package entity;

public class Admin {
	
	private int id;
	private String password;
	
	public Admin() {
	}
	
	public Admin(int id,String password) {
		this.id = id;
		this.password = password;
	}
	
	public int getId() {
		return id;
	}
	
	public String getPassword() {
		return password;
	}
	
}

