package controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.QuestionDAO;
import entity.Clinic;
import entity.Question;
import entity.User;

/**
 * Servlet implementation class QuestionComplete
 */
@WebServlet("/QuestionComplete")
public class QuestionComplete extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public QuestionComplete() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//セッション情報をデータベースに質問データを格納する。

		//sessionから格納したrequest情報を取り出す
		HttpSession session = request.getSession();
		String clinicDepartmentName = (String)session.getAttribute("clinicDepartmentName");
		int clinicDepartmentId= (Integer)session.getAttribute("clinicDepartmentId");
		String text = (String)session.getAttribute("text");
		String title= (String)session.getAttribute("title");
		
		//医者が健康情報にアクセス可能かどうか
		String heaelthInformationAble = (String)session.getAttribute("heaelthInformationAble");
		boolean isAcessiable;
		if(heaelthInformationAble.equals("OK")) {
			isAcessiable = true;
		}else {
			isAcessiable = false;
		}
		
		User user = (User)session.getAttribute("loginUser");
		int userId = user.getId();
		Question question = new Question(userId, title,text,new Clinic(clinicDepartmentId, clinicDepartmentName), isAcessiable );//質問データによるQuestionのinstanceを生成し、データベースに格納する
		try {
			QuestionDAO dao = new QuestionDAO();
			dao.insert(question);
		}catch(SQLException e) {
			e.printStackTrace();
		}
		
		

		
		//メイン画面にフォワード
		RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/jsp/questionComplete.jsp");
		rd.forward(request, response);
	}

}
