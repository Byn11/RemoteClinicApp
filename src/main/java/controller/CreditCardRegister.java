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

import entity.CreditCard;
import service.CreditCardRegisterLogic;
//クレジットカードのモデルインポートする
@WebServlet("/CreditCardRegister")
public class CreditCardRegister extends HttpServlet{
	private static final long serialVersionUID = 1L;
	
	protected void doPost(HttpServletRequest request,HttpServletResponse response)
					throws ServletException, IOException{
		request.setCharacterEncoding("UTF-8");
		String firstName = request.getParameter("firstName");
		String lastName = request.getParameter("lastName");
		String name = firstName + lastName;
		//card番号をintに変更する
		int creditCardNumber = Integer.parseInt(request.getParameter("creditCardNumber"));
		
		//cardの有効期限をＤａｔｅ型に変更する
		String expirationYear = request.getParameter("year");
		String expirationMonth = request.getParameter("month");
		String expiration = expirationYear + "-"+ expirationMonth;
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM");
		Date expirationDate = null;
		try {
			expirationDate = dateFormat.parse(expiration);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//securityCode
		int securityCode = Integer.parseInt(request.getParameter("securityCode"));
		
		//sessionからuserIdを取り出す
		HttpSession session = request.getSession();
		entity.User user = (entity.User)session.getAttribute("user");//User情報をsessionに保存されている
		int userId = user.getId();
		
		//CreditCard　instacneを生成する
		CreditCard creditCard = new CreditCard(userId,name,creditCardNumber,expirationDate,securityCode);
		
		//クレジットカードをdatabaseに登録する
		CreditCardRegisterLogic creditCardRegisterLogic = new CreditCardRegisterLogic();
		creditCardRegisterLogic.execute(creditCard);
		
		//forward
		RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/jsp/creditCardRegisterResult.jsp");
		dispatcher.forward(request,response);
	}
}
