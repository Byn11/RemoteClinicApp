package service;

import dao.DoctorDao;
import dao.UserDao;
import entity.Doctor;
import entity.User;

public class MemberRegisterLogic {
	
	//UserDAOに投げる
	public int execute(User user) {
		UserDao userDao = new UserDao();
		return userDao.createUser(user);
		 
	}
	//DoctorDAOに投げる
	public int execute(Doctor doctor) {
		DoctorDao doctorDao = new DoctorDao();
		return doctorDao.createDoctor(doctor);
	}
}

