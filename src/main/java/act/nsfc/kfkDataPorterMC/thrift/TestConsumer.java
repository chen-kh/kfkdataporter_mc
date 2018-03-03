package act.nsfc.kfkDataPorterMC.thrift;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;

import org.apache.log4j.Logger;
import org.apache.thrift.TDeserializer;
import org.apache.thrift.protocol.TCompactProtocol;

import kafka.consumer.Consumer;
import kafka.consumer.ConsumerConfig;
import kafka.consumer.ConsumerIterator;
import kafka.consumer.KafkaStream;
import kafka.javaapi.consumer.ConsumerConnector;
import kafka.message.MessageAndMetadata;

public class TestConsumer {
	private static Logger log = Logger.getLogger(TestConsumer.class);

	public TestConsumer() {
	}

	private static ConsumerConfig createConsumerConfig() {
		Properties props = new Properties();
		props.put("zookeeper.connect", "192.168.6.131:2181,192.168.6.132:2181,192.168.6.133:2181");
		props.put("group.id", "zsm_test");
		props.put("zookeeper.session.timeout.ms", "10000");
		props.put("auto.commit.enable", "true");// 为true时客户端断开后重新消费时会从上次消费的地方继续下去；为false时则会从头开始消�?
		props.put("auto.offset.reset", "largest");
		props.put("auto.commit.interval.ms", "60000");
		return new ConsumerConfig(props);
	}

	public static void isGivenCar(ThriftObdDs ds) {
		String devsns[] = new String[] { "967790145172", "967790147267", "967790145253", "967790221104",
				"967790144421" };
		for (int i = 0; i < devsns.length; i++) {
			if (ds.getSn().equals(devsns[i])) {
				System.out.println(i);
			}
		}
	}

	public static void main(String[] args) {
		String topic = "ThriftObdDs";
		ConsumerConnector consumer = null;
		Map<String, Integer> topicMap = null;
		Map<String, List<KafkaStream<byte[], byte[]>>> streamMap = null;
		KafkaStream<byte[], byte[]> stream = null;
		ConsumerIterator<byte[], byte[]> it = null;
		while (true) {
			try {
				consumer = Consumer.createJavaConsumerConnector(createConsumerConfig());
				topicMap = new HashMap<String, Integer>();
				topicMap.put(topic, new Integer(1));
				streamMap = consumer.createMessageStreams(topicMap);
				stream = streamMap.get(topic).get(0);
				it = stream.iterator();
				byte[] bs = null;
				TDeserializer td = new TDeserializer(new TCompactProtocol.Factory());
				while (true) {
					if (it.hasNext()) {
						MessageAndMetadata<byte[], byte[]> item = it.next();
						try {
							bs = item.message();
							ThriftObdDs ds = new ThriftObdDs();
							td.deserialize(ds, bs);
							if (ds.getSn() == null) {
								System.out.println("obd sn null" + ds.getRes());
							}
							isGivenCar(ds);
							// System.out.println(ds.getRes());
						} catch (Exception e) {
							// Thread.sleep(10);
						}

					}
				}
			} catch (Exception e) {
				if (stream != null)
					stream.clear();
				if (streamMap != null)
					streamMap.clear();
				if (consumer != null)
					consumer.shutdown();
				log.error(e.toString());
				try {
					Thread.sleep(10000);
				} catch (InterruptedException e1) {
				}
			}
		}
	}

}
