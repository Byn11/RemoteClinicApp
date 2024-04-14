package entity;

import java.sql.Date;
import java.util.List;

public class Doctor extends Human{
	
	private String urlPhotoForAuthentication;
	private List<Clinic> clinicalDepartment;
	
	public Doctor(int id, String password) {
		super(id, password);
	}
	
	public Doctor(int id, String password, String name, int gender, String emailAddress, Date birthday, String address,String telephone,String urlPhotoForAuthentication,List<Clinic> clinicalDepartment) {
		super(id, password, name, gender,emailAddress, birthday, address,telephone);
		this.urlPhotoForAuthentication=urlPhotoForAuthentication;
		this.clinicalDepartment=clinicalDepartment;
		
	}
	public Doctor(String password,String name,int gender,String emailAddress,Date birthday,String address,String telephone,String urlPhotoForAuthentication,List<Clinic> clinicalDepartment) {
		super(gender, password, name, gender, emailAddress, birthday, address, telephone);
		this.urlPhotoForAuthentication=urlPhotoForAuthentication;
		this.clinicalDepartment=clinicalDepartment;
	}
	
	public String geturlPhotoForAuthentication() {
		return urlPhotoForAuthentication;
	}
	
	public void setUrlPhotoForAuthentication(String urlPhotoForAuthentication) {
		this.urlPhotoForAuthentication=urlPhotoForAuthentication;
	}

	public List<Clinic> getClinicalDepartment() {
		return clinicalDepartment;
	}
	
	public void setClinicalDepartment(List<Clinic> clinicalDepartment) {
		this.clinicalDepartment=clinicalDepartment;
	}
}

