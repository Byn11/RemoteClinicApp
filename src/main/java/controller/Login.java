package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import entity.Doctor;
import entity.User;
import service.LoginLogic;
import util.HashAlgorithm_SHA2;
/**
 * Servlet implementation class Login
 */
@WebServlet("/Login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Login() {
        super();
        // TODO Auto-generated constructor stub
    }


	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		
		request.setCharacterEncoding("UTF-8");
		int id = Integer.parseInt(request.getParameter("id"));  //IDをリクエストスコープから取得し、int型に変換
		String password = request.getParameter("pswd");  //パスワードをリクエストスコープから取得
		password=HashAlgorithm_SHA2.getHashSha2(password);
		//パスワードがUから始まればUser、Dから始まればDoctor、Aから始まればAdminとする。
		//String initialPass = password.substring(0,1);
		String type = request.getParameter("type");
		User retUser;
		if(type.equals("User")) {
			 User user = new User(id,password);
			 //ログイン処理
			 LoginLogic loginLogic = new LoginLogic();
			 retUser = loginLogic.userlogin(id,password);
			 
			//ログイン済みの場合
			if (retUser!=null) {
				request.setAttribute("msg", "ログイン成功");
				HttpSession session = request.getSession();  //セッションスコープの準備
				session.setAttribute("loginUser", user);   //パスワードと名前を持っているインスタンスをセッションとして保存しておく
			}else {
				request.setAttribute("msg", "ログイン失敗");
				RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
			    rd.forward(request, response);
			}
			
		}
		Doctor retDoctor;
		if(type.equals("Doctor")) { 			 
			Doctor doctor = new Doctor(id,password);
		//ログイン処理
			 LoginLogic loginLogic = new LoginLogic();
			 retDoctor = loginLogic.doctorlogin(id,password);
			 
			//ログイン済みの場合
			if (retDoctor!=null) {
				HttpSession session = request.getSession();  //セッションスコープの準備
				session.setAttribute("loginDoctor", doctor);   //パスワードと名前を持っているインスタンスをセッションとして保存しておく
			}else {
				request.setAttribute("msg", "ログイン失敗");
				RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
			    rd.forward(request, response);
			}
			 
		 }
//		if(type.equals("Admin")) {
//			Admin admin=new Admin(id,password);
//			//ログイン処理
//			 LoginLogic loginLogic = new LoginLogic();
//			 isLogin = loginLogic.execute();
//			 
//			//ログイン済みの場合
//			if (isLogin) {
//				HttpSession session = request.getSession();  //セッションスコープの準備
//				session.setAttribute("loginAdmin", admin);   //パスワードと名前を持っているインスタンスをセッションとして保存しておく
//			}
//		}
		
		
		
		
		
		
		
//		boolean isLogin;
//		
//		 if (initialPass.equals("U")) {
//			 User user = new User(id,password);
//			 //ログイン処理
//			 LoginLogic loginLogic = new LoginLogic();
//			 isLogin = loginLogic.execute();
//			 
//			//ログイン済みの場合
//			if (isLogin) {
//				HttpSession session = request.getSession();  //セッションスコープの準備
//				session.setAttribute("loginUser", user);   //パスワードと名前を持っているインスタンスをセッションとして保存しておく
//			}
//			
//		 }
//		 else if(initialPass.equals("D")) {
//			 Doctor doctor = new Doctor(id,password);
//			 //ログイン処理
//			 LoginLogic loginLogic = new LoginLogic();
//			 isLogin = loginLogic.execute();
//			 
//			//ログイン済みの場合
//			if (isLogin) {
//				HttpSession session = request.getSession();  //セッションスコープの準備
//				session.setAttribute("loginDoctor", doctor);   //パスワードと名前を持っているインスタンスをセッションとして保存しておく
//			}
//			 
//		 }
//		 else if(initialPass.equals("A")) {
//			 Admin admin = new Admin(id,password);
//			 //ログイン処理
//			 LoginLogic loginLogic = new LoginLogic();
//			 isLogin = loginLogic.execute();
//			 
//			//ログイン済みの場合
//			if (isLogin) {
//				HttpSession session = request.getSession();  //セッションスコープの準備
//				session.setAttribute("loginAdmin", admin);   //パスワードと名前を持っているインスタンスをセッションとして保存しておく
//			}
//			 
//		 }
//		
		
		//ログイン完了画面にフォワード
		String urlString="WEB-INF/jsp/menu"+type+".jsp";
		System.out.println(urlString);
		RequestDispatcher rd = request.getRequestDispatcher(urlString);
	    rd.forward(request, response);
		
	    
	    
	    
	}

}
