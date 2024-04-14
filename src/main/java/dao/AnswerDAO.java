package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import entity.Answer;

public class AnswerDAO  {
//	public Answer select(int answerId)throws SQLException {
//		DBUtil db = new DBUtil();
//		Connection con = null;
//		try {
//			con = db.getConnection();
//			String sql = "SELECT * FROM ANSWER WHERE ANSWER_ID= ? ";
//			PreparedStatement pstmt = con.prepareStatement(sql);
//			pstmt.setInt(1, answerId);
//			ResultSet rs = pstmt.executeQuery();
//			Answer answer = new Answer();
//			if(rs.next()){
//				answer.setId(rs.getInt("ID"));
//				answer.setAnswerMessage(rs.getString("ANSWER_MESSAGE"));
//			}
//			pstmt.close();
//			return answer;
//		}finally {
//			db.closeConnection(con);
//		}
//	}
	
	public int insert(Answer answer)throws SQLException{
		DBUtil db = new DBUtil();
		Connection con = null;
		try {
			con = db.getConnection();
			String sql = "INSERT INTO ANSWER(QID, DID, CONTENT)"
					+ "VALUES(?, ?, ?)";
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, answer.getQuestion_id());
			pstmt.setInt(2, answer.getDoctorId());
			pstmt.setString(3, answer.getContent());
			
			int r = pstmt.executeUpdate();
			con.close();
			return r;
			
		}finally {
			db.closeConnection(con);
		}
	}
	
//	public int update(Answer answer)throws SQLException{
//		DBUtil db = new DBUtil();
//		Connection con = null;
//		try {
//			con = db.getConnection();
//			String sql = "UPDATE ANSWER SET ID=?, ANSWER_MESSAGE=?"
//					+ "WHERE ANSWER_ID=?";
//			PreparedStatement pstmt = con.prepareStatement(sql);
//			pstmt.setInt(1, answer.getId());
//			pstmt.setString(2, answer.getAnswerMessage());
//			pstmt.setInt(3, answer.getAnswerId());
//			int r = pstmt.executeUpdate();
//			pstmt.close();
//			return r;
//		}finally {
//			db.closeConnection(con);
//		}
//	}

}
