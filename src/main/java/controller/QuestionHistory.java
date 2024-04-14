package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import entity.Question;
import entity.User;
import service.GetQuestionListLogic;

/**
 * Servlet implementation class QuestionHistory
 */
@WebServlet("/QuestionHistory")
public class QuestionHistory extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public QuestionHistory() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//データベースから自分の質問全てを取得する。
		//それぞれの質問IDを取得する。
		//リクエストスコープに質問IDを格納する。
		//ユーザが質問した履歴の一覧を取得する
		HttpSession session = request.getSession();
		User user=(User) session.getAttribute("loginUser"); 
		
		GetQuestionListLogic getQuestionListLogic = new GetQuestionListLogic();  
		List<Question> questionList = getQuestionListLogic.executeList(user.getId());  //questionListにデータベースの全情報を格納
		request.setAttribute("questionList", questionList);  //questionListをリクエストスコープに保存		
		//質問履歴画面に遷移する。
		RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/jsp/questionHistory.jsp");
		rd.forward(request, response);
	}

}
