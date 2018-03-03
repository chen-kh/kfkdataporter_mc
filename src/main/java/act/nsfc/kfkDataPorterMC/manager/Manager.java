package act.nsfc.kfkDataPorterMC.manager;

import act.nsfc.kfkDataPorterMC.config.CommonConfig;
import act.nsfc.kfkDataPorterMC.kfkporter.KFKEVENTConsumer;
import act.nsfc.kfkDataPorterMC.kfkporter.KFKGPSConsumer;
import act.nsfc.kfkDataPorterMC.kfkporter.KFKOBDConsumer;

public class Manager {
	public static void main(String[] args) {
		// 分别消费OBD\GPS\EVENT_ERROR\EVENT

		int obd_consu_num = 4;
		for (int i = 0; i < obd_consu_num; i++) {
			new Thread(new KFKOBDConsumer()).start();
		}//对多线程可以考虑更高级的api，使用进程池
		new Thread(new KFKGPSConsumer()).start();
		new Thread(new KFKEVENTConsumer(true)).start();// 故障码事件
		new Thread(new KFKEVENTConsumer(false)).start();
		Daemon deamon = new Daemon();
		deamon.AppID = CommonConfig.KfkGroupId_mc;
		new Thread(deamon).start();
	}
}
