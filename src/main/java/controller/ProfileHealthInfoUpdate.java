package controller;

import java.io.IOException;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import entity.HealthInfo;
import entity.User;
import service.ProfileUserLogic;

/**
 * Servlet implementation class ProfileHealthInfoUpdate
 */
@WebServlet("/ProfileHealthInfoUpdate")
public class ProfileHealthInfoUpdate extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ProfileHealthInfoUpdate() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");
		double height = Double.parseDouble(request.getParameter("height"));
		double weight = Double.parseDouble(request.getParameter("weight"));
		double bloodPressure = Double.parseDouble(request.getParameter("bloodPressure"));
		double sleepTime = Double.parseDouble(request.getParameter("sleepTime"));
		//ユーザ新規登録ではなく更新のDAOが必要？
		HttpSession session = request.getSession();
		User user = (User)session.getAttribute("user");
		int userId = user.getId();
		//Userの健康情報のinstanceを生成する
		HealthInfo healthInfo = new HealthInfo(userId, new Date(), height, weight, bloodPressure, sleepTime);
		//健康情報を追加する
		ProfileUserLogic logic = new ProfileUserLogic();
		logic.addProfileUserHealth(healthInfo);
		
		//forword
		RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/jsp/profileChangedComplete.jsp");
		rd.forward(request, response);
	}

}
