package entity;
import java.util.Date;

public class HealthInfo implements Comparable<HealthInfo> {
	private int id;//user id
	private Date updateData;
	private double height;
	private double weight;
	private double bloodPressure;
	private double sleepTime;
	
	public HealthInfo() {
		super();
	}

	/**
	 * @param id
	 * @param updateData
	 * @param height
	 * @param weight
	 * @param bloodPressure
	 * @param sleepTime
	 */
	public HealthInfo(int id, Date updateData, double height, double weight, double bloodPressure, double sleepTime) {
		super();
		this.id = id;
		this.updateData = updateData;
		this.height = height;
		this.weight = weight;
		this.bloodPressure = bloodPressure;
		this.sleepTime = sleepTime;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Date getUpdateData() {
		return updateData;
	}

	public void setUpdateData(Date updateData) {
		this.updateData = updateData;
	}

	public double getHeight() {
		return height;
	}

	public void setHeight(double height) {
		this.height = height;
	}

	public double getWeight() {
		return weight;
	}

	public void setWeight(double weight) {
		this.weight = weight;
	}

	public double getBloodPressure() {
		return bloodPressure;
	}

	public void setBloodPressure(double bloodPressure) {
		this.bloodPressure = bloodPressure;
	}

	public double getSleepTime() {
		return sleepTime;
	}

	public void setSleepTime(double sleepTime) {
		this.sleepTime = sleepTime;
	}
	public int compareTo(HealthInfo info) {
		return info.updateData.compareTo(this.updateData);
	}
	
	
	


}
