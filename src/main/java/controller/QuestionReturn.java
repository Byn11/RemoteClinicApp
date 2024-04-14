package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class QuestionReturn
 */
@WebServlet("/QuestionReturn")
public class QuestionReturn extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public QuestionReturn() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//質問内容のセッションを削除
		HttpSession session = request.getSession();
		session.removeAttribute("clinicDepartmentname");
		session.removeAttribute("text");
		session.removeAttribute("heaelthInformationAble");
		
		//質問画面にフォワード
		RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/jsp/questionMain.jsp");
		rd.forward(request, response);
	}

	

}
