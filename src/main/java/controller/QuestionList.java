package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import entity.Question;
import service.QuestionListLogic;

/**
 * Servlet implementation class QuestionList
 */
@WebServlet("/QuestionList")
public class QuestionList extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public QuestionList() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//質問一覧を取得する
		QuestionListLogic questionListLogic = new QuestionListLogic();
		//DBにある質問を取得して格納
		List<Question> questionList = questionListLogic.execute();
		//リクエストスコープに保存
		request.setAttribute("questionList", questionList);
		//質問一覧画面遷移
		RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/jsp/questionList.jsp");
		rd.forward(request, response);
	}

}
