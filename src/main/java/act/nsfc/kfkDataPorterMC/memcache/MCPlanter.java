package act.nsfc.kfkDataPorterMC.memcache;

/**
 * 
 * @author chenkh
 *
 */

import java.io.IOException;
import java.util.Date;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeoutException;

import org.apache.logging.log4j.Logger;

import net.rubyeye.xmemcached.MemcachedClient;
import net.rubyeye.xmemcached.exception.MemcachedException;
import act.nsfc.kfkDataPorterMC.bean.DataInfo;
import act.nsfc.kfkDataPorterMC.bean.LoggerRepository;
import act.nsfc.kfkDataPorterMC.bean.MCObject;
import act.nsfc.kfkDataPorterMC.config.CommonConfig;

class MCPlanter extends Thread {

	// private MemcachedClientBuilder mcbuilder;
	private MemcachedClient mc;
	private LinkedBlockingQueue<MCObject> dataQueue;
	private Logger logger = LoggerRepository.instance.getMcLogger();
	public int index;

	public MCPlanter(int index) {
		this.index = index;
		dataQueue = new LinkedBlockingQueue<MCObject>(CommonConfig.maxQueueLength / 2);
	}

	public void setMcClient(MemcachedClient mc) throws IOException {
		this.mc = mc;
	}

	public void tryAddData(MCObject obj) {
		try {
			dataQueue.put(obj);
		} catch (InterruptedException e) {
			logger.error(e);
		}
	}

	@Override
	public void run() {
		logger.info("mc planter " + Thread.currentThread().getName() + " created");
		MCObject obj;
		while (true) {
			int s = dataQueue.size();
			DataInfo.queuelength[index] = s;
			if (s == 0) {
				try {
					Thread.sleep(50);
				} catch (Exception e) {
					logger.error("Error at " + new Date());
					logger.error(e);
				}
				continue;
			}
			if (s > 0) {
				for (int i = 0; i < s; i++) {
					try {
						obj = dataQueue.take();
						if (obj != null) {
							mc.set(obj.key, 0, obj.value);
						}
					} catch (TimeoutException e) {
						logger.error(e);
					} catch (InterruptedException e) {
						logger.error(e);
					} catch (MemcachedException e) {
						logger.error(e);
					}
				}
			}
		}
	}
}
