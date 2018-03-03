package act.nsfc.kfkDataPorterMC.dataHandler;

import org.apache.logging.log4j.Logger;
import org.apache.thrift.TDeserializer;
import org.apache.thrift.TException;
import org.apache.thrift.protocol.TCompactProtocol;

import act.nsfc.kfkDataPorterMC.bean.DataInfo;
import act.nsfc.kfkDataPorterMC.bean.LoggerRepository;
import act.nsfc.kfkDataPorterMC.bean.MCObject;
import act.nsfc.kfkDataPorterMC.config.CommonConfig;
import act.nsfc.kfkDataPorterMC.memcache.MCHelper;
import act.nsfc.kfkDataPorterMC.thrift.ThriftObdDs;
import net.sf.json.JSONObject;

public class OBDHandler {
	private TDeserializer tDeserializer = new TDeserializer(new TCompactProtocol.Factory());
	private ThriftObdDs thriftObd = new ThriftObdDs();
	private JSONObject res = null;
	private Logger logger = LoggerRepository.instance.getMcLogger();

	public void handle(byte[] bs) {
		try {
			tDeserializer.deserialize(thriftObd, bs);
			res = JSONObject.fromObject(thriftObd.getRes());
			if (res == null || !res.containsKey("devicesn")) {
				return;
			}
			String devicesn = thriftObd.getSn();
			long gpstime = thriftObd.getGpstime();
			if (gpstime > CommonConfig.tooLargeTime) {
				return;
			}
			if (DataFilter.instance.OBD_isOldTime(devicesn, gpstime)) {
				return;
			}
			MCHelper.instance.addMCObject(new MCObject(devicesn + "obd", res.toString()));
			DataInfo.OBDCOUNT++;
		} catch (TException e) {
			logger.error(Thread.currentThread().getName() + ":" + e);
		}
	}

}
