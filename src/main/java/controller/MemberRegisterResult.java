package controller;

import java.io.IOException;
import java.util.Date;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import entity.Clinic;
import entity.Doctor;
import entity.User;
import service.MemberRegisterLogic;

/**
 * Servlet implementation class MemberRegisterConfirm
 */
@WebServlet("/MemberRegisterResult")
public class MemberRegisterResult extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MemberRegisterResult() {
        super();
        // TODO Auto-generated constructor stub
    }

//	/**
//	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
//	 */
//	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		
//		
//	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");

		//一般ユーザーが会員登録確認した後の処理
		if(request.getParameter("type").equals("resultU")) {
			
			//セッションを定義
			HttpSession session = request.getSession();
			
			String name = (String) session.getAttribute("name");
			String password = (String) session.getAttribute("password");
			int intGender = (int) session.getAttribute("intGender");
			String emailAddress = (String) session.getAttribute("emailAddress");
			Date birthday = (Date) session.getAttribute("birthday");
			String address = (String) session.getAttribute("address");
			String telephone = (String) session.getAttribute("telephone");
			
			//java.util.Date型からjava.sql.Date型に変更
			long time = birthday.getTime();
			java.sql.Date sqlBirthday = new java.sql.Date(time);
			
			//ユーザーエンティティにセットする
			User user = new User(password,name,intGender,emailAddress, sqlBirthday,address,telephone);	
			
			//サービスクラスに投げる
			MemberRegisterLogic memberRegisterLogic = new MemberRegisterLogic();
			int insert_id=memberRegisterLogic.execute(user);
			request.setAttribute("insert_id", insert_id);
			RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/jsp/memberRegisterResultUser.jsp");
			
			dispatcher.forward(request, response);
			
		//医者が会員登録確認した後の処理
		}else if(request.getParameter("type").equals("resultD")) {
			
			//セッションを定義
			HttpSession session = request.getSession();
			
			String name = (String) session.getAttribute("name");
			String password = (String) session.getAttribute("password");
			int intGender = (int) session.getAttribute("intGender");
			String emailAddress = (String) session.getAttribute("emailAddress");
			Date birthday = (Date) session.getAttribute("birthday");
			String address = (String) session.getAttribute("address");
			String telephone = (String) session.getAttribute("telephone");
			List<Clinic> clinicalDepartment = (List<Clinic>) session.getAttribute("clinicalDepartment");
			String fileName = (String) session.getAttribute("filename");

			//java.util.Date型からjava.sql.Date型に変更
			long time = birthday.getTime();
			java.sql.Date sqlBirthday = new java.sql.Date(time);
			
			//ドクターエンティティにセットする
			Doctor doctor = new Doctor(password,name,intGender,emailAddress,sqlBirthday,address,telephone,fileName,clinicalDepartment);
			
			//サービスクラスに投げる
			MemberRegisterLogic memberRegisterLogic = new MemberRegisterLogic();
			int insert_id=memberRegisterLogic.execute(doctor);
			request.setAttribute("insert_id", insert_id);
			RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/jsp/memberRegisterResultDoctor.jsp");
			
			dispatcher.forward(request, response);
		}
	}

}