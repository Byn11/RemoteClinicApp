package entity;
import java.sql.Date;

public class Human {
	
	private int id;
	private String password;
	private String name;
	private int gender;
	private String emailAddress;
	private Date birthday;
	private String address;
	private String telephone;
	
	
	/**
	 * 
	 */
	public Human() {
		super();
	}


	public Human(int id, String password) {
		this.id = id;
		this.password = password; 
	}
	
	
	/**
	 * @param id
	 * @param name
	 * @param emailAddress
	 * @param birthday
	 * @param address
	 * @param telephone
	 */
	public Human(int id, String name, String emailAddress, Date birthday, String address, String telephone) {
		super();
		this.id = id;
		this.name = name;
		this.emailAddress = emailAddress;
		this.birthday = birthday;
		this.address = address;
		this.telephone = telephone;
	}


	public Human(int id, String password, String name, int gender, String emailAddress, Date birthday, String address,String telephone) {
		super();
		this.id = id;
		this.password = password;
		this.name = name;
		this.gender=gender;
		this.emailAddress = emailAddress;
		this.birthday = birthday;
		this.address = address;
		this.telephone = telephone;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	public String getPassword() {
		return password;
	}
	
	public void setPassword (String password){
		this.password = password;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmailAddress() {
		return emailAddress;
	}

	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}

	public Date getBirthday() {
		return birthday;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}
	
	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	public int getGender() {
		return gender;
	}

	public void setGender(int gender) {
		this.gender = gender;
	}

}
