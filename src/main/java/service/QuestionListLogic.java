package service;

import java.util.List;

import dao.QuestionDAO;
import entity.Question;

public class QuestionListLogic {

	//DBから質問一覧を取得
	public List<Question> execute() {
		
		QuestionDAO questionDAO = new QuestionDAO();
		
		return questionDAO.unansweredlist();
	}
}
