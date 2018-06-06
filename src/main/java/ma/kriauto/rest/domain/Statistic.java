package ma.kriauto.rest.domain;

public class Statistic {
	
	private double course;
	private double speed;
	private double consumption;
	
	public Statistic() {
		super();
	}

	public Statistic(double course, double speed, double consumption) {
		super();
		this.course = course;
		this.speed = speed;
		this.consumption = consumption;
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

	@Override
	public String toString() {
		return "Statistic [course=" + course + ", speed=" + speed
				+ ", consumption=" + consumption + "]";
	}
}
