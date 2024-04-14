package service;

import java.sql.SQLException;

import dao.AnswerDAO;
import dao.QuestionDAO;
import entity.Answer;
import entity.Question;

public class AnswerMainLogic {

	public Question execute(int questionId) throws SQLException {
		
		QuestionDAO questionDAO = new QuestionDAO();
		
		return questionDAO.select(questionId);
	}
	public int insert(Answer answer) {
		AnswerDAO answerDAO=new AnswerDAO();
		try {
			answerDAO.insert(answer);
		} catch (SQLException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}

		return 0;
		
	}
}
