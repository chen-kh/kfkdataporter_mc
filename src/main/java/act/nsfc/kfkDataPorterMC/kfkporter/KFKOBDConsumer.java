package act.nsfc.kfkDataPorterMC.kfkporter;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import org.apache.logging.log4j.Logger;

import act.nsfc.kfkDataPorterMC.bean.DataInfo;
import act.nsfc.kfkDataPorterMC.bean.LoggerRepository;
import act.nsfc.kfkDataPorterMC.config.CommonConfig;
import act.nsfc.kfkDataPorterMC.dataHandler.OBDHandler;
import act.nsfc.kfkDataPorterMC.memcache.MCHelper;
import kafka.consumer.Consumer;
import kafka.consumer.ConsumerConfig;
import kafka.consumer.ConsumerIterator;
import kafka.consumer.KafkaStream;
import kafka.javaapi.consumer.ConsumerConnector;
import kafka.message.MessageAndMetadata;

public class KFKOBDConsumer implements Runnable {
	private Logger logger = LoggerRepository.instance.getMcLogger();
	private  OBDHandler obdHandler = new OBDHandler();
	// private static int numThreads = 4;
	// private static ExecutorService threadPool =
	// Executors.newFixedThreadPool(numThreads);

	// public KFKOBDConsumer(OBDHandler obdHandler) {
	// this.obdHandler = obdHandler;
	// }

	public KFKOBDConsumer() {

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
		topicMap.put(CommonConfig.KfkObdTopic, new Integer(1));
		Map<String, List<KafkaStream<byte[], byte[]>>> streamMap = consumer.createMessageStreams(topicMap);
		KafkaStream<byte[], byte[]> stream = streamMap.get(CommonConfig.KfkObdTopic).get(0);
		ConsumerIterator<byte[], byte[]> it = stream.iterator();
		byte[] bs = null;
		updateDataCount();
		logger.info("obd consumer start");
		try {
			while (true) {
				while (needRest()) {
					Thread.sleep(CommonConfig.sleepIntervalMsIfDataIsTooBig);
				}
				try {
					if (it.hasNext()) {
						MessageAndMetadata<byte[], byte[]> item = it.next();
						bs = item.message();
						obdHandler.handle(bs);
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
			DataInfo.OBDCOUNT = Long.parseLong(MCHelper.instance.getCountByKey(CommonConfig.KfkGroupId_mc + "_obd"));
			logger.info("obd count: " + DataInfo.OBDCOUNT);
		} catch (Exception e) {
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
//			logger.info("the blockingQueue size is too long");
//			logger.info("[memcached_1: " + CommonConfig.MC1Add + "]_queueSize = " + l1);
//			logger.info("[memcached_2: " + CommonConfig.MC2Add + "]_queueSize = " + l2);
			return true;
		}
	}
}
