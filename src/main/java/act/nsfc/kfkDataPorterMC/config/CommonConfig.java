package act.nsfc.kfkDataPorterMC.config;

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Properties;

import org.apache.logging.log4j.Logger;

import act.nsfc.kfkDataPorterMC.bean.LoggerRepository;

public class CommonConfig {
	private static Logger logger = LoggerRepository.instance.getMcLogger();
	// //buaa
	// public static String DB = "192.168.6.252";
	// public static String ZKAdd =
	// "192.168.6.100:2181,192.168.6.101:2181,192.168.6.102:2181";
	// public static final String MC1Add = "192.168.6.120:11211";
	// public static final String MC2Add = "192.168.6.115:11211";

	// azureold
	// public static String DB = "172.16.100.4";// trails server address
	// public static final String MC1Add = "172.16.100.9:11211";
	// public static final String MC2Add = "172.16.100.9:11211";
	// public static String ZKAdd =
	// "172.16.100.15:2181,172.16.100.16:2181,172.16.100.17:2181";

	// azurenew
	// public static String DB = "172.16.100.37";// trails server address
	// public static final String MC1Add = "172.16.100.23:11211";
	// public static final String MC2Add = "172.16.100.24:11211";
	// public static String ZKAdd =
	// "172.16.100.30:2181,172.16.100.31:2181,172.16.100.32:2181/kafka";

	public static String MC1Add;// = "192.168.6.120:11211";
	public static String MC2Add;// = "192.168.6.115:11211";
	public static String ZKAdd;// =
								// "192.168.6.128:2181,192.168.6.129:2181,192.168.6.130:2181";

	public static String KfkGroupId_pg;// = "dataporter_pg";
	public static String KfkGroupId_mc;// = "dataporter_mc";
	public static String KfkObdTopic;// ="ThriftObdDs";
	public static String KfkGpsTopic;// ="ThriftObdGps";
	public static String KfkObdEventTopic;// ="ThriftObdEvent";
	public static String KfkErrorCodeEventTopic;// ="ThriftObdError";
	public static int sleepIntervalMsIfDataIsTooBig = 50;
	public static String getRealPath() {
		String rootPath = CommonConfig.class.getProtectionDomain().getCodeSource().getLocation().getPath();
		rootPath = rootPath.substring(0, rootPath.lastIndexOf("/") + 1);
		logger.info(rootPath);
		return rootPath;
	}

	static {
		Properties props = new Properties();
		try {
			InputStream in = new FileInputStream(getRealPath() + "//conf.prop");
			props.load(in);

			CommonConfig.MC1Add = props.getProperty("MC1Add");
			CommonConfig.MC2Add = props.getProperty("MC2Add");
			CommonConfig.ZKAdd = props.getProperty("ZKAdd");

			CommonConfig.KfkGroupId_pg = props.getProperty("KfkGroupId_pg");
			CommonConfig.KfkGroupId_mc = props.getProperty("KfkGroupId_mc");

			CommonConfig.KfkObdTopic = props.getProperty("KfkObdTopic");
			CommonConfig.KfkGpsTopic = props.getProperty("KfkGpsTopic");
			CommonConfig.KfkObdEventTopic = props.getProperty("KfkObdEventTopic");
			CommonConfig.KfkErrorCodeEventTopic = props.getProperty("KfkErrorCodeEventTopic");

			in.close();
			logger.info("load config file:\n" + props.toString());
		} catch (Exception e) {
			logger.error(e);
		}
	}
	public static final long tooLargeTime = 2800000000l;
	public static int PGfhSleepInterval = 100;
	public static int MCThreadNum4Each = 4;
//	public static boolean PlanBWorking = false;
	public static final int maxQueueLength = 40000;
	
}