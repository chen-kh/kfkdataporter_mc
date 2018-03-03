package act.nsfc.kfkDataPorterMC.bean;

public class GPS {
	public GPS(String devicesn, long time, double longitude, double latitude,
			double speed, int direction) {
		this.devicesn = devicesn;
		this.gpstime = time;
		this.latitude = latitude;
		this.longitude = longitude;
		this.speed = speed;
		this.direction = direction;

	}

	public GPS() {
	}

	public String devicesn = "";

	public long gpstime;

	public double longitude = -1;

	public double latitude = -1;

	public double speed = -1;

	public int direction = -1;
}
