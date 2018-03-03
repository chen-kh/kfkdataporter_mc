package act.nsfc.kfkDataPorterMC.dataHandler;

import org.apache.logging.log4j.Logger;
import org.apache.thrift.TDeserializer;
import org.apache.thrift.TException;
import org.apache.thrift.protocol.TCompactProtocol;

import act.nsfc.kfkDataPorterMC.bean.DataInfo;
import act.nsfc.kfkDataPorterMC.bean.LoggerRepository;
import act.nsfc.kfkDataPorterMC.bean.MCObject;
import act.nsfc.kfkDataPorterMC.bean.WarnEvent;
import act.nsfc.kfkDataPorterMC.config.CommonConfig;
import act.nsfc.kfkDataPorterMC.memcache.MCHelper;
import act.nsfc.kfkDataPorterMC.thrift.ThriftObdError;
import act.nsfc.kfkDataPorterMC.thrift.ThriftObdEvent;

public class EVENTHandler {
	private Logger logger = LoggerRepository.instance.getMcLogger();
	private TDeserializer tDeserializer = new TDeserializer(new TCompactProtocol.Factory());
	private ThriftObdError thriftObdError = new ThriftObdError();
	private ThriftObdEvent thriftObdEvent = new ThriftObdEvent();
	private WarnEvent even = new WarnEvent();

	public void handle(String topic, byte[] bs) {
		String devicesn;
		long gpstime;

		if (topic.equals(CommonConfig.KfkErrorCodeEventTopic)) {
			try {
				tDeserializer.deserialize(thriftObdError, bs);
			} catch (Exception e) {
				logger.error(e);
			}
			even.setDevicesn(thriftObdError.getSn());
			even.setGpstime(thriftObdError.getGpstime());
			even.setErrorcode(thriftObdError.getFaultCode());
			even.setType(1);

			devicesn = even.getDevicesn();
			gpstime = even.getGpstime();
			if (gpstime > CommonConfig.tooLargeTime) {
				return;
			}
			if (DataFilter.instance.EVENT_isOldTime(devicesn, gpstime)) {
				return;
			}
			MCHelper.instance.addMCObject(new MCObject(devicesn + "event", even.toJSONString()));
			eventCountUpdate();
		} else {
			try {
				tDeserializer.deserialize(thriftObdEvent, bs);
			} catch (TException e) {
				logger.error(e);
			}
			even.setDevicesn(thriftObdEvent.getSn());
			even.setGpstime(thriftObdEvent.getGpstime());
			even.setType(thriftObdEvent.getType());
			even.setLatitude(thriftObdEvent.getLat());
			even.setLongitude(thriftObdEvent.getLon());
			even.setDetail(thriftObdEvent.getOldVin() + "," + thriftObdEvent.getNewVin());
			even.setEventtime(thriftObdEvent.getEventtime());

			devicesn = even.getDevicesn();
			gpstime = even.getGpstime();
			if (gpstime > CommonConfig.tooLargeTime) {
				return;
			}
			if (DataFilter.instance.EVENT_isOldTime(devicesn, gpstime)) {
				return;
			}
			MCHelper.instance.addMCObject(new MCObject(devicesn + "event", even.toJSONString()));
			eventCountUpdate();
		}
	}

	private static synchronized void eventCountUpdate() {
		DataInfo.EVENTCOUNT++;
	}
}
