package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import entity.Doctor;
import service.GetDoctorListLogic;

/**
 * Servlet implementation class DoctorList
 */
@WebServlet("/DoctorList")
public class DoctorList extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DoctorList() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//医者一覧を取得する
		GetDoctorListLogic getDoctorListLogic = new GetDoctorListLogic();  
		List<Doctor> doctorList = getDoctorListLogic.execute();  //mutterListにデータベースの全情報を格納
		request.setAttribute("doctorList", doctorList);  //mutterListをリクエストスコープに保存
//		for(Doctor doctor:doctorList) {
//			System.out.println(doctor.getName());
//			for(Clinic clinic :doctor.getClinicalDepartment()) {
//				System.out.println(clinic.getClinicDepartmentName());
//			}
//				
//		}
		//医者一覧画面へ遷移するためのプログラム
		RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/jsp/doctorList.jsp");
		rd.forward(request, response);
		
	}

}
