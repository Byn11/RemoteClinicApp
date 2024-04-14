package entity;
import java.sql.Date;
import java.util.List;

public class User extends Human{
	List<HealthInfo> healthInfo;

	public User(int id, String password) {
		super(id, password);
	}
	
	public User(int id, String password, String name, int gender, String emailAddress, Date birthday, String address,String telephone,  List<HealthInfo> healthInfo) {
		super(id, password, name, gender,emailAddress, birthday, address, telephone);
		this.healthInfo = healthInfo;
	}

	public User(String password, String name, int gender, String emailAddress, Date birthday, String address,String telephone) {
		super(gender, password, name, gender, emailAddress, birthday, address, telephone);
		
	}

	public List<HealthInfo> getHealthInfo() {
		return healthInfo;
	}

	public void setHealthInfo(List<HealthInfo> healthInfo) {
		this.healthInfo = healthInfo;
	}
	
	

}
