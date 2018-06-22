package ma.kriauto.rest.domain;

public class Statistic {
	
	private double course;
	private double speed;
	private double consumption;
	private Boolean enable;
	private StatisticValues maximalspeed ;
	private StatisticValues maximalcourse ;
	private StatisticValues fuelconsommation ;
	private StatisticValues fuellevel ;
	private StatisticValues enginetemperature ;
	private StatisticValues fridgetemperature ;
	
	public Statistic() {
		super();
	}

	public Statistic(double course, double speed, double consumption) {
		super();
		this.course = course;
		this.speed = speed;
		this.consumption = consumption;
	}
	
	public Statistic(double course, double speed, double consumption,
			Boolean enable, StatisticValues maximalspeed,
			StatisticValues maximalcourse, StatisticValues fuelconsommation,
			StatisticValues fuellevel, StatisticValues enginetemperature,
			StatisticValues fridgetemperature) {
		super();
		this.course = course;
		this.speed = speed;
		this.consumption = consumption;
		this.enable = enable;
		this.maximalspeed = maximalspeed;
		this.maximalcourse = maximalcourse;
		this.fuelconsommation = fuelconsommation;
		this.fuellevel = fuellevel;
		this.enginetemperature = enginetemperature;
		this.fridgetemperature = fridgetemperature;
	}

	public double getCourse() {
		return course;
	}

	public void setCourse(double course) {
		this.course = course;
	}

	public double getSpeed() {
		return speed;
	}

	public void setSpeed(double speed) {
		this.speed = speed;
	}

	public double getConsumption() {
		return consumption;
	}

	public void setConsumption(double consumption) {
		this.consumption = consumption;
	}

	public Boolean getEnable() {
		return enable;
	}

	public void setEnable(Boolean enable) {
		this.enable = enable;
	}

	public StatisticValues getMaximalspeed() {
		return maximalspeed;
	}

	public void setMaximalspeed(StatisticValues maximalspeed) {
		this.maximalspeed = maximalspeed;
	}

	public StatisticValues getMaximalcourse() {
		return maximalcourse;
	}

	public void setMaximalcourse(StatisticValues maximalcourse) {
		this.maximalcourse = maximalcourse;
	}

	public StatisticValues getFuelconsommation() {
		return fuelconsommation;
	}

	public void setFuelconsommation(StatisticValues fuelconsommation) {
		this.fuelconsommation = fuelconsommation;
	}

	public StatisticValues getFuellevel() {
		return fuellevel;
	}

	public void setFuellevel(StatisticValues fuellevel) {
		this.fuellevel = fuellevel;
	}

	public StatisticValues getEnginetemperature() {
		return enginetemperature;
	}

	public void setEnginetemperature(StatisticValues enginetemperature) {
		this.enginetemperature = enginetemperature;
	}

	public StatisticValues getFridgetemperature() {
		return fridgetemperature;
	}

	public void setFridgetemperature(StatisticValues fridgetemperature) {
		this.fridgetemperature = fridgetemperature;
	}

	@Override
	public String toString() {
		return "Statistic [course=" + course + ", speed=" + speed
				+ ", consumption=" + consumption + ", enable=" + enable
				+ ", maximalspeed=" + maximalspeed + ", maximalcourse="
				+ maximalcourse + ", fuelconsommation=" + fuelconsommation
				+ ", fuellevel=" + fuellevel + ", enginetemperature="
				+ enginetemperature + ", fridgetemperature="
				+ fridgetemperature + "]";
	}
}
