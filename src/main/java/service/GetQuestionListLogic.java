package service;

import java.sql.SQLException;
import java.util.List;

import dao.QuestionDAO;
import entity.Question;


public class GetQuestionListLogic {
	
	//自分の過去の質問をリストとして格納するプログラム
	public List<Question> executeList(){
		QuestionDAO dao = new QuestionDAO();
//		//データベースの値を全て持ってきてquestionListに格納。
//		List<Question> questionList = new ArrayList<Question>();
//		//questionIdが1から最大値までの間、SELECTを実行して全部の質問を取得する。
//		for (int i= 1; i <= max_id; i ++) {
//			questionList.add(dao.select(i));
//		}
//
//		//ログインユーザーだけの質問を抽出する。
//		//ユーザーIDをセッションから取り出して、一致する質問だけのリストを新たに作る。
//		List<Question> userQuestionList = new ArrayList<Question>();
//		
//		for (int j= 1; j <= max_id; j ++) {
//			if (セッションのユーザIDとquestionListのユーザーIDが一致している場合) {
//				userQuestionList.add(questionList(j));
//			}	
//		}	
//		return userQuestionList;
		return dao.list();
	}
	public List<Question> executeList(int id){
		QuestionDAO dao = new QuestionDAO();
		return dao.listById(id);
	}
	
	public Question findQuestionById(int id) {
		QuestionDAO dao = new QuestionDAO();
		try {
			return dao.select(id);
		} catch (SQLException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}
		return null;
		
		
		
	}
	//1つの質問を質問IDから取得するプログラム
	public Question executeChoice(int questionId) throws SQLException{
		QuestionDAO dao = new QuestionDAO();
		Question question = dao.select(questionId);
		return question;
		
	}
	
}
