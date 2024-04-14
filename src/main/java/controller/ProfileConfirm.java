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

import dao.UserDao;
import entity.HealthInfo;
import entity.User;
import service.ProfileUserLogic;

/**
 * Servlet implementation class ProfileConfirm
 */
@WebServlet("/ProfileConfirm")
public class ProfileConfirm extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ProfileConfirm() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//Userの健康情報をgetする
		HttpSession session = request.getSession();
		User user = (User)session.getAttribute("loginUser");//sessionに保存されたuser情報はidとパスワードしかない
		int userId = user.getId();
		UserDao userDao = new UserDao();
		user = userDao.userFindById(userId);//userの他の情報を持ってくる
//		ProfileUserLogic pul = new ProfileUserLogic();
		ProfileUserLogic logic = new ProfileUserLogic();
		List<HealthInfo> healthInfoList = logic.getHealthInfo(userId);

				
		//userIdとhealthInfoをsessionに格納する
		session.setAttribute("user", user);
		session.setAttribute("userId",userId);
		session.setAttribute("healthInfoList", healthInfoList);
		
		
		
		//プロフィール確認画面にforward
		RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/jsp/profileUser.jsp");
		rd.forward(request, response);
		
	}

	

}
