package controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import entity.HealthInfo;
import entity.Question;
import entity.User;
import service.QuestionListDetailLogic;

/**
 * Servlet implementation class QuestionDetailReturn
 */
@WebServlet("/QuestionDetailReturn")
public class QuestionDetailReturn extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public QuestionDetailReturn() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		//クリックされた質問の質問IDを取得する。
		int questionId = Integer.parseInt(request.getParameter("questionId"));
		
		//ユーザーIDを取得する
		int id = Integer.parseInt(request.getParameter("id"));
		
		//サービスのインスタンス化
		QuestionListDetailLogic questionListDetailLogic = new QuestionListDetailLogic();

		//DBから取得した質問詳細を格納する
		Question questionDetail = null;
		try {
			questionDetail = questionListDetailLogic.execute(questionId);
		} catch (SQLException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}
		
		//DBから取得したユーザーを格納する
		User user = questionListDetailLogic.getById(id);
		
		//DBから取得した健康情報を格納する
		HealthInfo healthInfo = null;
		try {
			healthInfo = questionListDetailLogic.getHealthInfo(id);
		} catch (SQLException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}
		
		//リクエストスコープに保存する
		request.setAttribute("questionDetail", questionDetail);
		request.setAttribute("user", user);
		request.setAttribute("healthInfo", healthInfo);
		
		//質問詳細画面に遷移する
		RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/jsp/questionListDetail.jsp");
		rd.forward(request, response);		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
