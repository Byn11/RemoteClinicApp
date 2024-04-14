package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import entity.CreditCard;

public class CreditCardDAO {
	public CreditCard select(int creditCardNumber) throws SQLException{
		DBUtil db = new DBUtil();
		Connection con = null;
		try {
			con = db.getConnection();
			String sql = "SELECT * FROM CREDITCARD WHERE creditCard_Number = ? ";
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, creditCardNumber);
			ResultSet rs = pstmt.executeQuery();
			CreditCard card = new CreditCard();
			if(rs.next()) {
				card.setId(rs.getInt("ID"));
				card.setName(rs.getString("NAME"));
				card.setCreditCardNumber(rs.getInt("CREDITCARD_NUMBER"));
				card.setExpiration(rs.getDate("EXPIRATION"));
				card.setSecurityCode(rs.getInt("SECURITY_CODE"));
			}
			pstmt.close();
			return card ;
		}finally {
			db.closeConnection(con);
		}
	}
	
	public CreditCard selectById(int id)throws SQLException{
		DBUtil db = new DBUtil();
		Connection con = null;
		try {
			con = db.getConnection();
			String sql = "SELECT * FROM CREDITCARD WHERE ID = ? ";
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, id);
			ResultSet rs = pstmt.executeQuery();
			CreditCard card = new CreditCard();
			if(rs.next()) {
//				card.setId(rs.getInt("ID"));
				card.setName(rs.getString("NAME"));
				card.setCreditCardNumber(rs.getInt("CREDITCARD_NUMBER"));
				card.setExpiration(rs.getDate("EXPIRATION"));
				card.setSecurityCode(rs.getInt("SECURITY_CODE"));
				card.setSecurityCode(rs.getInt("SECURITY_CODE"));
			}
			pstmt.close();
			return card ;
		}finally {
			db.closeConnection(con);
		}
	}
	
	public int insert(CreditCard card)throws SQLException{
		DBUtil db = new DBUtil();//loading db driver 
		Connection con = null;
		try {
			con = db.getConnection();
			String sql = "INSERT INTO CREDITCARD(CREDITCARD_NUMBER, ID, NAME, EXPIRATION, SECURITY_CODE)"
					+ "VALUES(?,?,?,?,?)";
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, card.getCreditCardNumber());
			pstmt.setInt(2, card.getId());
			pstmt.setString(3, card.getName());
			pstmt.setDate(4, new java.sql.Date(card.getExpiration().getTime()));
			pstmt.setInt(5, card.getSecurityCode());
			
			int r = pstmt.executeUpdate();
			pstmt.close();
			return r;
		}finally {
			db.closeConnection(con);
		}
	}

}
