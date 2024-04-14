package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import entity.Question;
import service.GetQuestionListLogic;

/**
 * Servlet implementation class QuestionDetails
 */
@WebServlet("/QuestionDetails")
public class QuestionDetails extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public QuestionDetails() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		//クリックされた質問の質問IDを取得する。
		int questionId = Integer.parseInt(request.getParameter("id"));
		System.out.println(questionId);
		//質問IDが一致する質問をDBから取得する。
		GetQuestionListLogic getQuestionListLogic = new GetQuestionListLogic();  
		Question question = getQuestionListLogic.findQuestionById(questionId);  //questionListにデータベースの全情報を格納
		request.setAttribute("question", question);  //questionをリクエストスコープに保存		
		
		//質問詳細画面に遷移する。
		RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/jsp/questionDetails.jsp");
		rd.forward(request, response);
	}

}
