package ma.kriauto.rest.domain;


public class Notification {
	private String phone;
	private String simnumber;
	private String immatriculation;
	private String mark;
	private String model;
	private String color;
	private String texte;
	private Integer status;
	private Integer deviceid;
	private Double  latitude1;
	private Double  longitude1;
	private Double  latitude2;
	private Double  longitude2;
	private Double  latitude3;
	private Double  longitude3;
	private Double  latitude4;
	private Double  longitude4;
	private Double  latitude5;
	private Double  longitude5;
	private Double  latitude6;
	private Double  longitude6;
	private boolean isgeofence;
	private boolean isnotifgeofence;
	private boolean isnotifdefaultgeofence;
	private String creationdate;
	
	public Notification() {
		super();
	}

	public Notification(String phone, String simnumber, String immatriculation,
			String mark, String model, String color, String texte,
			Integer status, Integer deviceid, Double latitude1,
			Double longitude1, Double latitude2, Double longitude2,
			Double latitude3, Double longitude3, Double latitude4,
			Double longitude4, Double latitude5, Double longitude5,
			Double latitude6, Double longitude6, boolean isgeofence,
			boolean isnotifgeofence, boolean isnotifdefaultgeofence,
			String creationdate) {
		super();
		this.phone = phone;
		this.simnumber = simnumber;
		this.immatriculation = immatriculation;
		this.mark = mark;
		this.model = model;
		this.color = color;
		this.texte = texte;
		this.status = status;
		this.deviceid = deviceid;
		this.latitude1 = latitude1;
		this.longitude1 = longitude1;
		this.latitude2 = latitude2;
		this.longitude2 = longitude2;
		this.latitude3 = latitude3;
		this.longitude3 = longitude3;
		this.latitude4 = latitude4;
		this.longitude4 = longitude4;
		this.latitude5 = latitude5;
		this.longitude5 = longitude5;
		this.latitude6 = latitude6;
		this.longitude6 = longitude6;
		this.isgeofence = isgeofence;
		this.isnotifgeofence = isnotifgeofence;
		this.isnotifdefaultgeofence = isnotifdefaultgeofence;
		this.creationdate = creationdate;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getSimnumber() {
		return simnumber;
	}

	public void setSimnumber(String simnumber) {
		this.simnumber = simnumber;
	}

	public String getImmatriculation() {
		return immatriculation;
	}

	public void setImmatriculation(String immatriculation) {
		this.immatriculation = immatriculation;
	}

	public String getMark() {
		return mark;
	}

	public void setMark(String mark) {
		this.mark = mark;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}
	
	public String getTexte() {
		return texte;
	}

	public void setTexte(String texte) {
		this.texte = texte;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public Integer getDeviceid() {
		return deviceid;
	}

	public void setDeviceid(Integer deviceid) {
		this.deviceid = deviceid;
	}

	public Double getLatitude1() {
		return latitude1;
	}

	public void setLatitude1(Double latitude1) {
		this.latitude1 = latitude1;
	}

	public Double getLongitude1() {
		return longitude1;
	}

	public void setLongitude1(Double longitude1) {
		this.longitude1 = longitude1;
	}

	public Double getLatitude2() {
		return latitude2;
	}

	public void setLatitude2(Double latitude2) {
		this.latitude2 = latitude2;
	}

	public Double getLongitude2() {
		return longitude2;
	}

	public void setLongitude2(Double longitude2) {
		this.longitude2 = longitude2;
	}

	public Double getLatitude3() {
		return latitude3;
	}

	public void setLatitude3(Double latitude3) {
		this.latitude3 = latitude3;
	}

	public Double getLongitude3() {
		return longitude3;
	}

	public void setLongitude3(Double longitude3) {
		this.longitude3 = longitude3;
	}

	public Double getLatitude4() {
		return latitude4;
	}

	public void setLatitude4(Double latitude4) {
		this.latitude4 = latitude4;
	}

	public Double getLongitude4() {
		return longitude4;
	}

	public void setLongitude4(Double longitude4) {
		this.longitude4 = longitude4;
	}

	public Double getLatitude5() {
		return latitude5;
	}

	public void setLatitude5(Double latitude5) {
		this.latitude5 = latitude5;
	}

	public Double getLongitude5() {
		return longitude5;
	}

	public void setLongitude5(Double longitude5) {
		this.longitude5 = longitude5;
	}

	public Double getLatitude6() {
		return latitude6;
	}

	public void setLatitude6(Double latitude6) {
		this.latitude6 = latitude6;
	}

	public Double getLongitude6() {
		return longitude6;
	}

	public void setLongitude6(Double longitude6) {
		this.longitude6 = longitude6;
	}

	public boolean isIsgeofence() {
		return isgeofence;
	}

	public void setIsgeofence(boolean isgeofence) {
		this.isgeofence = isgeofence;
	}

	public boolean isIsnotifgeofence() {
		return isnotifgeofence;
	}

	public void setIsnotifgeofence(boolean isnotifgeofence) {
		this.isnotifgeofence = isnotifgeofence;
	}

	public boolean isIsnotifdefaultgeofence() {
		return isnotifdefaultgeofence;
	}

	public void setIsnotifdefaultgeofence(boolean isnotifdefaultgeofence) {
		this.isnotifdefaultgeofence = isnotifdefaultgeofence;
	}

	public String getCreationdate() {
		return creationdate;
	}

	public void setCreationdate(String creationdate) {
		this.creationdate = creationdate;
	}

	@Override
	public String toString() {
		return "Notification [phone=" + phone + ", simnumber=" + simnumber
				+ ", immatriculation=" + immatriculation + ", mark=" + mark
				+ ", model=" + model + ", color=" + color + ", texte=" + texte
				+ ", status=" + status + ", deviceid=" + deviceid
				+ ", latitude1=" + latitude1 + ", longitude1=" + longitude1
				+ ", latitude2=" + latitude2 + ", longitude2=" + longitude2
				+ ", latitude3=" + latitude3 + ", longitude3=" + longitude3
				+ ", latitude4=" + latitude4 + ", longitude4=" + longitude4
				+ ", latitude5=" + latitude5 + ", longitude5=" + longitude5
				+ ", latitude6=" + latitude6 + ", longitude6=" + longitude6
				+ ", isgeofence=" + isgeofence + ", isnotifgeofence="
				+ isnotifgeofence + ", isnotifdefaultgeofence="
				+ isnotifdefaultgeofence + ", creationdate=" + creationdate
				+ "]";
	}

}
