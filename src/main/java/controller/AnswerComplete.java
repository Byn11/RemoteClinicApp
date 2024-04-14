package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import entity.Answer;
import service.AnswerMainLogic;

/**
 * Servlet implementation class AnswerComplete
 */
@WebServlet("/AnswerComplete")
public class AnswerComplete extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AnswerComplete() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//回答をDBに登録する
		//セッションを定義
		HttpSession session = request.getSession();
		
		Answer answer = (Answer) session.getAttribute("answer");
		AnswerMainLogic answerMainLogic = new AnswerMainLogic();
		answerMainLogic.insert(answer);
		RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/jsp/answerComplete.jsp");
		rd.forward(request, response);
	}

}
