package act.nsfc.kfkDataPorterMC.bean;

public class OBD {
	public OBD(String devicesn, long time, double t_mil, double t_fuel,
			double mil, double speed, double e_speed) {
		this.devicesn = devicesn;
		this.gpstime = time;
		this.total_fuel = t_fuel;
		this.total_mileage = t_mil;
		this.mileage = mil;
		this.speed = speed;
		this.engine_speed = e_speed;

	}

	public OBD() {
	}

	public String devicesn = "";

	public long gpstime;

	public double total_mileage = -1;

	public double total_fuel = -1;

	public double mileage = -1;

	public double speed = -1;

	public double engine_speed = -1;

	public long processtime = -1;

}