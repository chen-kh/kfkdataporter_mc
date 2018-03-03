package act.nsfc.kfkDataPorterMC.kfkporter;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;

import org.apache.logging.log4j.Logger;

import act.nsfc.kfkDataPorterMC.bean.DataInfo;
import act.nsfc.kfkDataPorterMC.bean.LoggerRepository;
import act.nsfc.kfkDataPorterMC.config.CommonConfig;
import act.nsfc.kfkDataPorterMC.dataHandler.GPSHandler;
import act.nsfc.kfkDataPorterMC.memcache.MCHelper;
import kafka.consumer.Consumer;

import kafka.consumer.ConsumerConfig;
import kafka.consumer.ConsumerIterator;
import kafka.consumer.KafkaStream;
import kafka.javaapi.consumer.ConsumerConnector;
import kafka.message.MessageAndMetadata;

public class KFKGPSConsumer implements Runnable {
	public GPSHandler gpsHandler = new GPSHandler();
	private Logger logger = LoggerRepository.instance.getMcLogger();
	public KFKGPSConsumer() {
	}

	private static ConsumerConfig createConsumerConfig() {
		Properties props = new Properties();
		props.put("zookeeper.connect", CommonConfig.ZKAdd);
		props.put("group.id", CommonConfig.KfkGroupId_mc);
		props.put("zookeeper.session.timeout.ms", "10000");
		props.put("auto.commit.enable", "true");
		props.put("auto.offset.reset", "largest");
		props.put("auto.commit.interval.ms", "60000");
		return new ConsumerConfig(props);
	}

	@Override
	public void run() {
		ConsumerConnector consumer = Consumer.createJavaConsumerConnector(createConsumerConfig());
		Map<String, Integer> topicMap = new HashMap<String, Integer>();
		topicMap.put(CommonConfig.KfkGpsTopic, new Integer(1));
		Map<String, List<KafkaStream<byte[], byte[]>>> streamMap = consumer.createMessageStreams(topicMap);
		KafkaStream<byte[], byte[]> stream = streamMap.get(CommonConfig.KfkGpsTopic).get(0);
		ConsumerIterator<byte[], byte[]> it = stream.iterator();
		byte[] bs;
		updateDataCount();
		logger.info("gps consumer start");
		try {
			while (true) {
				while (needRest()) {
					Thread.sleep(CommonConfig.sleepIntervalMsIfDataIsTooBig);
				}
				try {
					if (it.hasNext()) {
						MessageAndMetadata<byte[], byte[]> item = it.next();
						bs = item.message();
						gpsHandler.handle(bs);

					}
				} catch (Exception ee) {
					logger.error(ee);
					Thread.sleep(10);
				}
			}
		} catch (Exception e) {
			stream.clear();
			streamMap.clear();
			logger.error(e);
			consumer.shutdown();
		}
	}

	private void updateDataCount() {
		try {
			DataInfo.GPSCOUNT = Long.parseLong(MCHelper.instance.getCountByKey(CommonConfig.KfkGroupId_mc + "_gps"));
			logger.info("gps count: " + DataInfo.GPSCOUNT);
		} catch (Exception e) {
			logger.error("error while get gps_count from Memcached");
			logger.error(e);
		}
	}

	private boolean needRest() {
		int l1 = 0;
		int l2 = 0;
		for (int i = 0; i < CommonConfig.MCThreadNum4Each; i++) {
			l1 += DataInfo.queuelength[2 * i];
			l2 += DataInfo.queuelength[2 * i + 1];
		}
		if (l1 < CommonConfig.maxQueueLength && l2 < CommonConfig.maxQueueLength) {
			return false;
		} else {
			return true;
		}
	}

}
