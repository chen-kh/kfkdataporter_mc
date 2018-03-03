package act.nsfc.kfkDataPorterMC.dataHandler;

import java.util.Hashtable;

public class DataFilter {
	public static DataFilter instance = new DataFilter();
	private Hashtable<String, Long> gps_times = new Hashtable<String, Long>();
	private Hashtable<String, Long> obd_times = new Hashtable<String, Long>();
	private Hashtable<String, Long> event_times = new Hashtable<String, Long>();
	
	private DataFilter() {
	}

	/**
	 * filt data,return true when the data needs to be discarded.
	 * 
	 * @param o
	 * @return
	 */

	public boolean GPS_isOldTime(String devicesn,long gpstime){
		if(!gps_times.containsKey(devicesn)){
			gps_times.put(devicesn, gpstime);
			return false;
		}
		long oldtime = gps_times.get(devicesn);
		if(oldtime < gpstime){
			gps_times.put(devicesn, gpstime);
			return false;
		}else{
			return true;
		}
	}
	
	public boolean EVENT_isOldTime(String devicesn,long gpstime){
		if(!event_times.containsKey(devicesn)){
			event_times.put(devicesn, gpstime);
			return false;
		}
		long oldtime = event_times.get(devicesn);
		if(oldtime < gpstime){
			event_times.put(devicesn, gpstime);
			return false;
		}else{
			return true;
		}
	}
	
	
	public boolean OBD_isOldTime(String devicesn,long gpstime){
		if(!obd_times.containsKey(devicesn)){
			obd_times.put(devicesn, gpstime);
			return false;
		}
		long oldtime = obd_times.get(devicesn);
		if(oldtime < gpstime){
			obd_times.put(devicesn, gpstime);
			return false;
		}else{
			return true;
		}
	}
	
}
