package controller;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import service.ProfileUserLogic;

/**
 * Servlet implementation class ProfileUserUpdate
 */
@WebServlet("/ProfileUserUpdate")
public class ProfileUserUpdate extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ProfileUserUpdate() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
		String name = request.getParameter("name");

		String birthday = request.getParameter("year")+"-"+request.getParameter("month")+"-"+request.getParameter("day");
		
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
		Date birthdayDate = null;
		try {
			birthdayDate = formatter.parse(birthday);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		String telephone = request.getParameter("telephone");
		String mailAddress = request.getParameter("mailAddress");
		String address = request.getParameter("address");
		
		
		//ユーザインスタンス生成はid,name,birthday,telephone,mailaddress,address
		//ユーザ新規登録ではなく更新のDAOが必要？
		HttpSession session = request.getSession();
		entity.User user = (entity.User)session.getAttribute("user");
//		int userId = user.getId();
		//Userの基本情報を新たに設定する
		user.setName(name);
		user.setBirthday(new java.sql.Date(birthdayDate.getTime()));
		user.setTelephone(telephone);
		user.setEmailAddress(mailAddress);
		user.setAddress(address);
		
		//基本情報と健康情報をぞれぞれ更新する
		ProfileUserLogic logic = new ProfileUserLogic();
		logic.updateProfileUser(user);

		//forward
		RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/jsp/profileChangedComplete.jsp");
		dispatcher.forward(request,response);
	}

}
