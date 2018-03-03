package act.nsfc.kfkDataPorterMC.bean;

import act.nsfc.kfkDataPorterMC.config.CommonConfig;

public class DataInfo {
	public static long GPSCOUNT = 0;
	public static long OBDCOUNT = 0;
	public static long EVENTCOUNT = 0;
	public static int[] queuelength = new int[2 * CommonConfig.MCThreadNum4Each];
	
}
