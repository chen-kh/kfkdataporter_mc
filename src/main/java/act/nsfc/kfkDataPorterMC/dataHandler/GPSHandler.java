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
import act.nsfc.kfkDataPorterMC.thrift.ThriftObdGps;
import net.sf.json.JSONObject;

public class GPSHandler {
	private Logger logger = LoggerRepository.instance.getMcLogger();
	private TDeserializer tDeserializer = new TDeserializer(new TCompactProtocol.Factory());
	private ThriftObdGps thriftObdGps = new ThriftObdGps();
	private JSONObject res = null;

	public void handle(byte[] bs) {
		// TODO 自动生成的方法存根
		String devicesn;
		long gpstime;
		try {
			
			tDeserializer.deserialize(thriftObdGps, bs);
			if (null == thriftObdGps.getSn() || "".equals(thriftObdGps.getSn())) {
				return;
			}
			res = new JSONObject();
			res.put("devicesn", thriftObdGps.getSn());
			res.put("gpstime", thriftObdGps.getGpstime());
			res.put("1", thriftObdGps.getPositionMode());
			res.put("2", thriftObdGps.getDirection());
			res.put("3", thriftObdGps.getSpeed());
			res.put("4", thriftObdGps.getHeight());
			res.put("5", thriftObdGps.getLon());
			res.put("6", thriftObdGps.getLat());
			res.put("7", thriftObdGps.getAccuracy());
			devicesn = res.getString("devicesn");
			gpstime = res.getLong("gpstime");
			if (gpstime > CommonConfig.tooLargeTime) {
				return;
			}
			if (DataFilter.instance.GPS_isOldTime(devicesn, gpstime)) {
				return;
			}
			MCHelper.instance.addMCObject(new MCObject(devicesn + "gps", res.toString()));
			DataInfo.GPSCOUNT++;
		} catch (TException e) {
			logger.error(e);
		}
	}
}
