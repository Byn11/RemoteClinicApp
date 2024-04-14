package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import entity.Clinic;
import service.GetClinicListLogic;

/**
 * Servlet implementation class QuestionConfirm
 */
@WebServlet("/QuestionConfirm")
public class QuestionConfirm extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public QuestionConfirm() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//診療科のリストを取得する(質問画面で診療科を選択したいため)
		GetClinicListLogic getClinicListLogic = new GetClinicListLogic();
		List<Clinic> clinicList = getClinicListLogic.execute_sub();
		request.setAttribute("clinicList", clinicList);
		
		//質問画面にフォワード
		RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/jsp/questionMain.jsp");
		rd.forward(request, response);
	}
	
}
