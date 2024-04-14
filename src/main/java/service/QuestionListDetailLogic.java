package service;

import java.sql.SQLException;

import dao.HealthInfoDAO;
import dao.QuestionDAO;
import dao.UserDao;
import entity.HealthInfo;
import entity.Question;
import entity.User;

public class QuestionListDetailLogic {

	//DBから質問の詳細を取得する
	public Question execute(int questionId) throws SQLException {
		
		QuestionDAO questionDAO = new QuestionDAO();
		
		return questionDAO.select(questionId);
	}
	//DBから引数に紐づくユーザー情報を取得する
	public User getById(int id) {
		
		UserDao userDao = new UserDao();
		
		return userDao.userFindById(id);
	}
	//DBから引数に紐づく健康情報を取得する
	public HealthInfo getHealthInfo(int id) throws SQLException {
		
		HealthInfoDAO healthInfoDao = new HealthInfoDAO();
		
		return healthInfoDao.select(id);
	}
}
