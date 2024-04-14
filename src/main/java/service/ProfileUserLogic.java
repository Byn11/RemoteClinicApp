package service;

import java.sql.SQLException;
import java.util.Collections;
import java.util.List;

import dao.HealthInfoDAO;
import dao.UserDao;
import entity.HealthInfo;
import entity.User;

public class ProfileUserLogic {
	//daoのinstanceを生成する 
	UserDao userDao = new UserDao();
	HealthInfoDAO healthInfoDAO = new HealthInfoDAO(); 
	
	//基本情報をget
	public User getUserInfo(int userId){
		User user =userDao.userFindById(userId);
		return user;
	}
	
	//基本情報をupdate
	public void updateProfileUser(User user) {
		userDao.update(user);
	}
	
	//user別の健康情報一覧をget
	public List<HealthInfo> getHealthInfo(int userId) {
		List<HealthInfo> infoList = null;
		infoList = healthInfoDAO.selectById(userId);
		if(infoList != null) {
			Collections.sort(infoList);
		}
		
		return infoList ;
		
	}
	
	//健康情報をupdate
	public void updateProfileUserHealth(HealthInfo healthInfo) {
		try {
			healthInfoDAO.update(healthInfo);
		}catch(SQLException e) {
			e.printStackTrace();
		}
		
	}
	//heath informationを追加する
	public void addProfileUserHealth(HealthInfo healthInfo) {
		try {
			healthInfoDAO.insert(healthInfo);
		}catch(SQLException e){
			e.printStackTrace();
		}
	}
	
}
