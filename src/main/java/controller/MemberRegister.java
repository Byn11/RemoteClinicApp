package controller;

import java.io.IOException;
import java.nio.file.Paths;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

import entity.Clinic;
import service.GetClinicListLogic;
import util.HashAlgorithm_SHA2;

/**
 * Servlet implementation class MemberRegister
 */
@WebServlet("/MemberRegisterConfirm")
@MultipartConfig
public class MemberRegister extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MemberRegister() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("UTF-8");
		
		//一般ユーザーの会員登録
		if(request.getParameter("type").equals("user")) {
			
			//リクエストパラメータから取得
			String name = request.getParameter("name");
			String password = request.getParameter("password");
			String gender = request.getParameter("gender");
			String StringBirthday = request.getParameter("birthday");
			String telephone = request.getParameter("telphone");
			String emailAddress = request.getParameter("emailAddress");
			String address = request.getParameter("address");
			password=HashAlgorithm_SHA2.getHashSha2(password);
			//男性と女性を0と1のint型に
			int intGender=0;
			if(gender.equals("男性")) {
				intGender = 0;
			}else if(gender.equals("女性")) {
				intGender=1;
			}
			
			//String型で受け取ったリクエストパラメータをDate型に変更
			DateFormat dateformat = new SimpleDateFormat("yyyy-MM-dd");
			
			Date birthday = null;
			try {
				birthday = dateformat.parse(StringBirthday);
			} catch (ParseException e) {
				
				e.printStackTrace();
			}
			//セッションを定義
			HttpSession session = request.getSession();
			
			//セッションに格納
			session.setAttribute("name", name);
			session.setAttribute("password", password);
			session.setAttribute("intGender", intGender);
			session.setAttribute("birthday", birthday);
			session.setAttribute("telephone", telephone);
			session.setAttribute("emailAddress",emailAddress);
			session.setAttribute("address", address);
			

			
		RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/jsp/memberRegisterConfirmUser.jsp");
		
		dispatcher.forward(request, response);
		//医者の会員登録
		}else if(request.getParameter("type").equals("doctor")){
			//リクエストパラメータから取得
			String name = request.getParameter("name");
			String password = request.getParameter("password");
			password=HashAlgorithm_SHA2.getHashSha2(password);
			String gender = request.getParameter("gender");
			String StringBirthday = request.getParameter("birthday");
			String telephone = request.getParameter("telphone");
			String emailAddress = request.getParameter("emailAddress");
			String address = request.getParameter("address");
			String[] StringClinicalDepartment = request.getParameterValues("clinicalDepartment");

			List<Clinic> clinicRegister = new ArrayList<>();
			GetClinicListLogic getClinicListLogic = new GetClinicListLogic();
			for(String s:StringClinicalDepartment) {
				String n=getClinicListLogic.selectNameById(Integer.parseInt(s));
				clinicRegister.add(new Clinic(Integer.parseInt(s),n));	
			}
			//Sring[]配列型からlist<Clinic>型に変換
			//GetClinicListLogic getClinicListLogic = new GetClinicListLogic();
			
//			List<Clinic> clinicList = getClinicListLogic.execute_sub();
//			List<Clinic> clinicRegister = new ArrayList<>();
//			for(String department: StringClinicalDepartment) {
//				for(Clinic cli : clinicList) {
//					if(department.equals(cli.getClinicDepartmentName())) {
//						clinicRegister.add(cli);
//						continue;
//					}
//				}
//			}
			
			
			//name属性がurlPhotoForAuthenticationのファイルをpartオブジェクトとして取得
			Part part = request.getPart("urlPhotoForAuthentication");
			//ファイル名を取得
			String filename = Paths.get(part.getSubmittedFileName()).getFileName().toString();
			//アップロードするフォルダ
			String path=getServletContext().getRealPath("image/");
			//実際にファイルが保存されるパス確認
			System.out.println(path);
			//この記述で引数で与えた場所にファイルを保存する。
			part.write(path+filename);
			
			//男性と女性を0と1のint型に
			int intGender=0;
			if(gender.equals("男性")) {
				intGender = 0;
			}else if(gender.equals("女性")) {
				intGender=1;
			}
			
			//String型で受け取ったリクエストパラメータをDate型に変更
			DateFormat dateformat = new SimpleDateFormat("yyyy-MM-dd");
			
			Date birthday = null;
			try {
				birthday = dateformat.parse(StringBirthday);
			} catch (ParseException e) {
				
				e.printStackTrace();
			}
			
			//セッションを定義
			HttpSession session = request.getSession();
			
			//セッションに格納
			session.setAttribute("name", name);
			session.setAttribute("password", password);
			session.setAttribute("intGender", intGender);
			session.setAttribute("birthday", birthday);
			session.setAttribute("telephone", telephone);
			session.setAttribute("emailAddress",emailAddress);
			session.setAttribute("address", address);
			session.setAttribute("clinicalDepartment", clinicRegister);
			session.setAttribute("filename", filename);
			
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/jsp/memberRegisterConfirmDoctor.jsp");
		
		dispatcher.forward(request, response);
		
		}
		else if (request.getParameter("type").equals("doctor_prepare")) {
			System.out.println("prepare");
			GetClinicListLogic getClinicListLogic = new GetClinicListLogic();
			List<Clinic> clinic_list =getClinicListLogic.execute_sub();
			request.setAttribute("clinic_list", clinic_list);
			RequestDispatcher dispatcher = request.getRequestDispatcher("memberRegisterDoctor.jsp");
			
			dispatcher.forward(request, response);
		}
	}


	}
