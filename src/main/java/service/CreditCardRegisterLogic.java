package service;

import java.sql.SQLException;

import dao.CreditCardDAO;
import entity.CreditCard;

public class CreditCardRegisterLogic {
	public void execute(CreditCard creditCard) {
			//データベースに登録する。
		CreditCardDAO dao = new CreditCardDAO();
		try {
			dao.insert(creditCard);
		}catch(SQLException e) {
			e.printStackTrace();
		}
	}

}
