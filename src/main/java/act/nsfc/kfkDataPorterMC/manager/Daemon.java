package act.nsfc.kfkDataPorterMC.manager;


import org.apache.logging.log4j.Logger;

import act.nsfc.kfkDataPorterMC.bean.DataInfo;
import act.nsfc.kfkDataPorterMC.bean.LoggerRepository;
import act.nsfc.kfkDataPorterMC.config.CommonConfig;
import act.nsfc.kfkDataPorterMC.memcache.MCHelper;

public class Daemon implements Runnable {
	private Logger logger = LoggerRepository.instance.getMcLogger();
	private long interval = 1000 * 5;

	public String AppID = "default";

	@Override
	public void run() {
		// TODO Auto-generated method stub
		while (true) {
			try {
				// CheckDataPorterA();
				Thread.sleep(interval);
				MCHelper.instance.setDataCount(this.AppID + "_obd", DataInfo.OBDCOUNT + "");
				MCHelper.instance.setDataCount(this.AppID + "_gps", DataInfo.GPSCOUNT + "");
				MCHelper.instance.setDataCount(this.AppID + "_event", DataInfo.EVENTCOUNT + "");
				int l1 = 0;
				int l2 = 0;
				for (int i = 0; i < CommonConfig.MCThreadNum4Each; i++) {
					l1 += DataInfo.queuelength[2 * i];
					l2 += DataInfo.queuelength[2 * i + 1];
				}
				MCHelper.instance.setDataCount(this.AppID + "_queuelength1" + "test", l1 + "");
				MCHelper.instance.setDataCount(this.AppID + "_queuelength2" + "test", l2 + "");
			} catch (InterruptedException e) {
				logger.error(e);
			}
		}
	}

}
