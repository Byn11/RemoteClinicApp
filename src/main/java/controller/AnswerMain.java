package controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import entity.Answer;
import entity.Question;
import service.AnswerMainLogic;

/**
 * Servlet implementation class AnswerMain
 */
@WebServlet("/AnswerMain")
public class AnswerMain extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AnswerMain() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		//クリックされた質問の質問IDを取得する。
		int questionId = Integer.parseInt(request.getParameter("questionId"));
		int doctorId=Integer.parseInt(request.getParameter("doctorId"));
		String content=request.getParameter("answer");
		Answer answer=new Answer(doctorId, questionId, content);
		//System.out.println(answer.getContent()+""+answer.getDoctorId()+""+answer.getQuestion_id());
		//サービスインスタンス化
		AnswerMainLogic answerMainLogic = new AnswerMainLogic();
		//answerMainLogic.insert(answer);
		//DBから質問を取得して格納する
		Question question = null;
		try {
			 question = answerMainLogic.execute(questionId);
		} catch (SQLException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}
		//リクエストスコープに保存する
		HttpSession session=request.getSession();
		request.setAttribute("question", question);
		session.setAttribute("answer", answer);
		//回答画面遷移
		RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/jsp/answerMain.jsp");
		rd.forward(request, response);
	}

}
