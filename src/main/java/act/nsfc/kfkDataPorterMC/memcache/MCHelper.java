package act.nsfc.kfkDataPorterMC.memcache;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.logging.log4j.Logger;

import net.rubyeye.xmemcached.MemcachedClient;
import net.rubyeye.xmemcached.MemcachedClientBuilder;
import net.rubyeye.xmemcached.XMemcachedClientBuilder;
import net.rubyeye.xmemcached.command.BinaryCommandFactory;
import net.rubyeye.xmemcached.impl.KetamaMemcachedSessionLocator;
import net.rubyeye.xmemcached.utils.AddrUtil;
import net.sf.json.JSONObject;
import act.nsfc.kfkDataPorterMC.bean.LoggerRepository;
import act.nsfc.kfkDataPorterMC.bean.MCObject;
import act.nsfc.kfkDataPorterMC.config.CommonConfig;

public class MCHelper {
	private Logger logger = LoggerRepository.instance.getMcLogger();
	public static MCHelper instance = new MCHelper();
	private List<MCPlanter> planterList1 = new ArrayList<MCPlanter>();
	private List<MCPlanter> planterList2 = new ArrayList<MCPlanter>();
	private MemcachedClientBuilder mcbuilder;

	private MemcachedClient mc1;
	private MemcachedClient mc2;

	short index = 0;

	public int MCThreadCount = CommonConfig.MCThreadNum4Each;
	public int MCPoolSize = 1;
	public boolean MCFailureMode = true;

	private MCHelper() {
		try {
			mcbuilder = new XMemcachedClientBuilder(AddrUtil.getAddresses(CommonConfig.MC1Add));
			mcbuilder.setSessionLocator(new KetamaMemcachedSessionLocator());
			mcbuilder.setCommandFactory(new BinaryCommandFactory());
			mcbuilder.setConnectionPoolSize(MCPoolSize);
			mcbuilder.setFailureMode(MCFailureMode);
			mc1 = mcbuilder.build();
			mc1.setOpTimeout(8000L);
			logger.info("mc1 connected!");

			mcbuilder = new XMemcachedClientBuilder(AddrUtil.getAddresses(CommonConfig.MC2Add));
			mcbuilder.setSessionLocator(new KetamaMemcachedSessionLocator());
			mcbuilder.setCommandFactory(new BinaryCommandFactory());
			mcbuilder.setConnectionPoolSize(MCPoolSize);
			mcbuilder.setFailureMode(MCFailureMode);
			mc2 = mcbuilder.build();
			mc2.setOpTimeout(8000L);
			logger.info("mc2 connected!");

			for (int i = 0; i < CommonConfig.MCThreadNum4Each; i++) {
				MCPlanter mcplanter1 = new MCPlanter(2 * i);
				mcplanter1.setMcClient(getMemcachedClientFromMC1());
				mcplanter1.start();
				planterList1.add(mcplanter1);

				MCPlanter mcplanter2 = new MCPlanter(2 * i + 1);
				mcplanter2.setMcClient(getMemcachedClientFromMC2());
				mcplanter2.start();
				planterList2.add(mcplanter2);
			}
		} catch (Exception e) {
			logger.error(e);
		}
	}

	public void setDataCount(String key, String value) {
		JSONObject obj = new JSONObject();
		obj.accumulate("type", key);
		obj.accumulate("data", value);
		obj.accumulate("time", (new Date()).getTime() / 1000L);
		try {
			mc1.set(key, 0, obj.toString());
		} catch (Exception e) {
			logger.error(e);
		}
		try {
			mc2.set(key, 0, obj.toString());
		} catch (Exception e) {
			logger.error(e);
		}
	}

	private String getValueByKeyFromMC1(String key) {
		try {
			return mc1.get(key);
		} catch (Throwable e) {
			e.printStackTrace();
			return null;
		}
	}

	private String getValueByKeyFromMC2(String key) {
		try {
			return mc2.get(key);
		} catch (Throwable e) {
			return null;
		}
	}

	public String getCountByKey(String key) {
		String res_a = getValueByKeyFromMC1(key);
		String res_b = getValueByKeyFromMC2(key);
		JSONObject obj_a = JSONObject.fromObject(res_a);
		JSONObject obj_b = JSONObject.fromObject(res_b);
		long time_b = obj_b.getLong("time");
		long time_a = obj_a.getLong("time");

		if (time_a > time_b) {
			return obj_b.getString("data");
		} else {
			return obj_a.getString("data");
		}
	}

	public void addMCObject(MCObject data) {
		index++;
		if (index > 32760) {
			index = 0;
		}
		((MCPlanter) planterList1.get(index % MCThreadCount)).tryAddData(data);
		((MCPlanter) planterList2.get(index % MCThreadCount)).tryAddData(data);
	}

	private MemcachedClient getMemcachedClientFromMC1() throws IOException {
		MemcachedClient mc1;
		mcbuilder = new XMemcachedClientBuilder(AddrUtil.getAddresses(CommonConfig.MC1Add));
		mcbuilder.setSessionLocator(new KetamaMemcachedSessionLocator());
		mcbuilder.setCommandFactory(new BinaryCommandFactory());
		mcbuilder.setConnectionPoolSize(MCPoolSize);
		mcbuilder.setFailureMode(MCFailureMode);
		mc1 = mcbuilder.build();
		mc1.setOpTimeout(8000L);
		logger.info("mc1 connected!");
		return mc1;
	}
	private MemcachedClient getMemcachedClientFromMC2() throws IOException {
		MemcachedClient mc2;
		mcbuilder = new XMemcachedClientBuilder(AddrUtil.getAddresses(CommonConfig.MC2Add));
		mcbuilder.setSessionLocator(new KetamaMemcachedSessionLocator());
		mcbuilder.setCommandFactory(new BinaryCommandFactory());
		mcbuilder.setConnectionPoolSize(MCPoolSize);
		mcbuilder.setFailureMode(MCFailureMode);
		mc2 = mcbuilder.build();
		mc2.setOpTimeout(8000L);
		logger.info("mc2 connected!");
		return mc2;
	}
}
