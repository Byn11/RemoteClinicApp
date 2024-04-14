package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import service.GetClinicListLogic;

/**
 * Servlet implementation class QuestionMain
 */
@WebServlet("/QuestionMain")
public class QuestionMain extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public QuestionMain() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
		//質問画面で入力されたデータをリクエストスコープから抽出
		int clinicDepartmentId = Integer.parseInt(request.getParameter("userSelectClinicDepartmentId"));
		String text = request.getParameter("userText");
		String title=request.getParameter("title");
		String healthInformationAble = request.getParameter("healthInformationAble");
		
		//セッションスコープを定義
		HttpSession session = request.getSession();
		
		GetClinicListLogic getClinicListLogic=new GetClinicListLogic();
		
		//セッションスコープに入力されたデータを格納
		session.setAttribute("clinicDepartmentId",clinicDepartmentId);
		session.setAttribute("title", title);
		session.setAttribute("clinicDepartmentName", getClinicListLogic.selectNameById(clinicDepartmentId));
		session.setAttribute("text",text);
		session.setAttribute("heaelthInformationAble",healthInformationAble);
		//質問確認画面にフォワード
		RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/jsp/questionConfirm.jsp");
		   rd.forward(request, response);
			
		
		
	}

}
