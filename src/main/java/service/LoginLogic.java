package service;

import dao.DoctorDao;
import dao.UserDao;
import entity.Doctor;
import entity.User;

public class LoginLogic {
	public User userlogin(Integer id,String password){
		UserDao userDao=new UserDao();
		User user=userDao.userFindById(id);
		if(user!=null&&password.equals(user.getPassword()))
			return user;			
		else 
			return null;
		
	}
	
	public Doctor doctorlogin(Integer id,String password){
		DoctorDao doctorDao=new DoctorDao();
		Doctor doctor=doctorDao.doctorFindById(id);
		if(doctor!=null&&password.equals(doctor.getPassword())) {
			return doctor;
			
		}else {
			return null;
		}
		
	}
//	public User adminlogin(Integer id){
//		UserDao userDao=new UserDao();
//		User user=userDao.userFindById(id);
//		if(user!=null) {
//			return user;
//			
//		}else {
//			return null;
//		}
//		
//	}
}
