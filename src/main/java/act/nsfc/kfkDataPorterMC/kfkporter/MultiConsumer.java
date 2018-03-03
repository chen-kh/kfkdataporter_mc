package act.nsfc.kfkDataPorterMC.kfkporter;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import act.nsfc.kfkDataPorterMC.bean.OBD;
import act.nsfc.kfkDataPorterMC.config.CommonConfig;
import act.nsfc.kfkDataPorterMC.dataHandler.OBDHandler;
import kafka.consumer.Consumer;
import kafka.consumer.ConsumerConfig;
import kafka.consumer.ConsumerIterator;
import kafka.consumer.KafkaStream;
import kafka.javaapi.consumer.ConsumerConnector;
import kafka.message.MessageAndMetadata;

public class MultiConsumer {
	private ConsumerConfig config;
	private String topic;
	private int threadsNum;
	private MessageExecutor executor;
	private ConsumerConnector connector;
	private ExecutorService threadPool;
	private static OBDHandler obdHandler = new OBDHandler();
	private static Logger logger = LogManager.getLogger(MultiConsumer.class);
	Thread t1, t2;

	public MultiConsumer(String topic, int threadsNum, MessageExecutor executor) {
		this.config = createConsumerConfig();
		this.topic = topic;
		this.threadsNum = threadsNum;
		this.executor = executor;
	}

	private static ConsumerConfig createConsumerConfig() {
		Properties props = new Properties();
		props.put("zookeeper.connect", CommonConfig.ZKAdd);
		props.put("group.id", CommonConfig.KfkGroupId_mc);
		props.put("zookeeper.session.timeout.ms", "10000");
		props.put("auto.commit.enable", "true");
		props.put("auto.offset.reset", "largest");
		props.put("auto.commit.interval.ms", "60*1000");

		return new ConsumerConfig(props);
	}

	public void start() throws Exception {
		connector = Consumer.createJavaConsumerConnector(config);
		Map<String, Integer> topics = new HashMap<String, Integer>();
		topics.put(topic, threadsNum);
		Map<String, List<KafkaStream<byte[], byte[]>>> streams = connector.createMessageStreams(topics);
		List<KafkaStream<byte[], byte[]>> partitions = streams.get(topic);
		threadPool = Executors.newFixedThreadPool(threadsNum);
		for (KafkaStream<byte[], byte[]> partition : partitions) {
			threadPool.execute(new MessageRunner(partition));
		}
	}

	public void close() {
		try {
			threadPool.shutdownNow();
		} catch (Exception e) {
			//
		} finally {
			connector.shutdown();
		}

	}

	class MessageRunner implements Runnable {
		private KafkaStream<byte[], byte[]> partition;

		MessageRunner(KafkaStream<byte[], byte[]> partition) {
			this.partition = partition;
		}

		public void run() {
			ConsumerIterator<byte[], byte[]> it = partition.iterator();

			while (it.hasNext()) {
				// System.out.println("partition" + partition.clientId() + "
				// report");
				MessageAndMetadata<byte[], byte[]> item = it.next();
				// System.out.println("partiton:" + item.partition());
				// logger.info("offset:" + item.offset());
				// executor.execute(new String(item.message()));
				executor.execute(item.message());
				// try {
				// Thread.sleep(100);
				// } catch (InterruptedException e) {
				// // TODO 自动生成的 catch 块
				// e.printStackTrace();
				// }
			}
		}
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		MultiConsumer consumer = null;
		try {
			MessageExecutor executor = new MessageExecutor() {
				public void execute(String message) {
					System.out.println(message);
				}
				public void execute(byte[] bs) {
					obdHandler.handle(bs);
				}
			};
			consumer = new MultiConsumer("testGps1116", 4, executor);
			consumer.start();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {

		}

	}

	// private static void monitorNum(int sleepIntervalMs) {
	// while (true) {
	// try {
	// Thread.sleep(sleepIntervalMs);
	// } catch (InterruptedException e) {
	// e.printStackTrace();
	// }
	// }
	// }

	interface MessageExecutor {
		public void execute(String message);

		public void execute(byte[] bs);
	}

}
