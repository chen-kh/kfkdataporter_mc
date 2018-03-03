package act.nsfc.kfkDataPorterMC.test;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeoutException;

import act.nsfc.kfkDataPorterMC.bean.DataInfo;
import act.nsfc.kfkDataPorterMC.config.CommonConfig;
import act.nsfc.kfkDataPorterMC.memcache.MCHelper;
import net.rubyeye.xmemcached.MemcachedClient;
import net.rubyeye.xmemcached.MemcachedClientBuilder;
import net.rubyeye.xmemcached.XMemcachedClientBuilder;
import net.rubyeye.xmemcached.exception.MemcachedException;
import net.rubyeye.xmemcached.utils.AddrUtil;

public class MonitorMC {
	private MemcachedClientBuilder mcbuilder;
	private MemcachedClient mc1;
	private MemcachedClient mc2;
	private long interval = 1000 * 5;
	public static String AppID = CommonConfig.KfkGroupId_mc;

	public MonitorMC() {
		List<InetSocketAddress> addressList = AddrUtil.getAddresses(CommonConfig.MC1Add);
		mcbuilder = new XMemcachedClientBuilder(addressList);
		try {
			mc1 = mcbuilder.build();
		} catch (IOException e) {
			e.printStackTrace();
		}
		mcbuilder = new XMemcachedClientBuilder(AddrUtil.getAddresses(CommonConfig.MC2Add));
		try {
			mc2 = mcbuilder.build();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private String getValueByKeyFromMc1(String key) {
		String result = null;
		try {
			result = mc1.get(key);
		} catch (TimeoutException | InterruptedException | MemcachedException e) {
			e.printStackTrace();
		}
		return result;
	}

	private String getValueByKeyFromMc2(String key) {
		String result = null;
		try {
			result = mc2.get(key);
		} catch (TimeoutException | InterruptedException | MemcachedException e) {
			e.printStackTrace();
		}
		return result;
	}

	public void monitorTotal() {
		MonitorMC mc = new MonitorMC();

		while (true) {
			try {
				Thread.sleep(interval);
				DataInfo.GPSCOUNT = Long.parseLong(MCHelper.instance.getCountByKey(CommonConfig.KfkGroupId_mc + "_gps"));
				System.err.println("get from dataInfo count : " + DataInfo.GPSCOUNT);
				System.out.println("MC1_obd count : " + mc.getValueByKeyFromMc1(AppID + "_obd") + " for time now "
						+ (new Date()).getTime() / 1000L);
				System.out.println("MC1_gps count : " + mc.getValueByKeyFromMc1(AppID + "_gps") + " for time now "
						+ (new Date()).getTime() / 1000L);
				System.out.println("MC1_gps count : " + mc.getValueByKeyFromMc1(AppID + "_event") + " for time now "
						+ (new Date()).getTime() / 1000L);
				System.out.println("MC2_obd count : " + mc.getValueByKeyFromMc2(AppID + "_obd") + " for time now "
						+ (new Date()).getTime() / 1000L);
				System.out.println("MC2_gps count : " + mc.getValueByKeyFromMc2(AppID + "_gps") + " for time now "
						+ (new Date()).getTime() / 1000L);
				System.out.println("MC2_gps count : " + mc.getValueByKeyFromMc2(AppID + "_event") + " for time now "
						+ (new Date()).getTime() / 1000L);
				System.out.println("daily_stat_car_appear : " + mc.getValueByKeyFromMc2("daily_stat_car_appear")
						+ " for time now" + (new Date()).getTime() / 1000L);
				System.out.println("daily_stat_car_appear : " + mc.getValueByKeyFromMc1("daily_stat_car_appear")
						+ " for time now" + (new Date()).getTime() / 1000L);
				System.out.println("daily_stat_mileage : " + mc.getValueByKeyFromMc2("daily_stat_mileage")
						+ " for time now " + (new Date()).getTime() / 1000L);
				int l1 = 0;
				int l2 = 0;
				for (int i = 0; i < CommonConfig.MCThreadNum4Each; i++) {
					l1 += DataInfo.queuelength[2 * i];
					l2 += DataInfo.queuelength[2 * i + 1];
				}
				System.out.println("MC1_queue length : " + mc.getValueByKeyFromMc1(AppID + "_queuelength1" + "test")
						+ " for time now " + (new Date()).getTime() / 1000L);
				System.out.println("MC2_queue length : " + mc.getValueByKeyFromMc2(AppID + "_queuelength2" + "test")
						+ " for time now " + (new Date()).getTime() / 1000L);
				System.out.println(
						"------------------------------------- for one time --------------------------------------");

			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

	public void monitorGpsData(String devicesn) {
		MonitorMC monitorMC = new MonitorMC();
		while (true) {
			try {
				Thread.sleep(interval);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println("MC1_gps info = " + monitorMC.getValueByKeyFromMc1(devicesn + "gps")
					+ " where devicesn = " + devicesn);
			System.out.println("MC2_gps info = " + monitorMC.getValueByKeyFromMc2(devicesn + "gps")
					+ " where devicesn = " + devicesn);
		}
	}

	public void monitorObdData(String devicesn) {
		MonitorMC monitorMC = new MonitorMC();
		while (true) {
			try {
				Thread.sleep(interval);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println("MC1_obd info = " + monitorMC.getValueByKeyFromMc1(devicesn + "obd")
					+ " where devicesn = " + devicesn);
			System.out.println("MC2_obd info = " + monitorMC.getValueByKeyFromMc2(devicesn + "obd")
					+ " where devicesn = " + devicesn);
		}
	}

	public void monitorEventData(String devicesn) {
		MonitorMC monitorMC = new MonitorMC();
		while (true) {
			try {
				Thread.sleep(interval);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println("MC1_event info = " + monitorMC.getValueByKeyFromMc1(devicesn + "event")
					+ " where devicesn = " + devicesn);
			System.out.println("MC2_event info = " + monitorMC.getValueByKeyFromMc2(devicesn + "event")
					+ " where devicesn = " + devicesn);
		}
	}

	public static void main(String[] args) {
		MonitorMC mc = new MonitorMC();
		mc.monitorTotal();
	}
}
