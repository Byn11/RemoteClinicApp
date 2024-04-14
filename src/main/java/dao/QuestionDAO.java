package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import entity.Answer;
import entity.Clinic;
import entity.Question;
import util.JDBCUtil;


public class QuestionDAO {
	
	public List<Question> list() {
		Connection connection = JDBCUtil.getConnection();
		//String sql = "SELECT QID,ID,TITLE,CONTENT,CLID,PROVIDE_IFO FROM QUESTION WHERE ID="+id;
		String sql="SELECT QUESTION.QID,QUESTION.ID,QUESTION.TITLE,QUESTION.CONTENT,QUESTION.CLID,QUESTION.PROVIDE_IFO ,CLINIC_IOF.NAME FROM QUESTION JOIN  CLINIC_IOF ON QUESTION.CLID=CLINIC_IOF.ID";
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		List<Question> questionlist = new ArrayList<>();
		try {
			statement = connection.prepareStatement(sql);
			resultSet = statement.executeQuery();
			while (resultSet.next()) {
				int QId=resultSet.getInt(1);
				int get_id = resultSet.getInt(2);
				String title = resultSet.getString(3);
				String questionMessage = resultSet.getString(4);
				int  clinicDepartmentId= resultSet.getInt(5);
				Boolean isAcessiable=resultSet.getBoolean(6);
				String clinicDepartmentName=resultSet.getString(7);
				questionlist.add(new Question(QId,get_id, title,questionMessage,new Clinic(clinicDepartmentId, clinicDepartmentName),false,isAcessiable));
			}

		} catch (SQLException throwables) {
			throwables.printStackTrace();
		} finally {
			JDBCUtil.release(connection, statement, resultSet);
		}
		return questionlist;

	}
	//未回答な質問を抽出するメソッド
	public List<Question> unansweredlist() {
		Connection connection = JDBCUtil.getConnection();
		//String sql = "SELECT QID,ID,TITLE,CONTENT,CLID,PROVIDE_IFO FROM QUESTION WHERE ID="+id;
		String sql="SELECT Q.QID, Q.ID, Q.TITLE, Q.CONTENT, C.ID AS CLINIC_ID, C.NAME AS CLINIC_NAME, Q.PROVIDE_IFO FROM QUESTION Q LEFT JOIN ANSWER A ON Q.QID = A.QID LEFT JOIN CLINIC_IOF C ON Q.CLID = C.ID WHERE A.QID IS NULL";
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		List<Question> questionlist = new ArrayList<>();
		try {
			statement = connection.prepareStatement(sql);
			resultSet = statement.executeQuery();
			while (resultSet.next()) {
				int QId=resultSet.getInt(1);
				int get_id = resultSet.getInt(2);
				String title = resultSet.getString(3);
				String questionMessage = resultSet.getString(4);
				int  clinicDepartmentId= resultSet.getInt(5);
				String clinicDepartmentName=resultSet.getString(6);
				String isAcessiableString = resultSet.getString(7);
				boolean isAcessiable = Boolean.parseBoolean(isAcessiableString);
				questionlist.add(new Question(QId,get_id, title,questionMessage,new Clinic(clinicDepartmentId, clinicDepartmentName),true,isAcessiable));
			}

		} catch (SQLException throwables) {
			throwables.printStackTrace();
		} finally {
			JDBCUtil.release(connection, statement, resultSet);
		}
		return questionlist;

	}
	
	
	
	public List<Question> listById(int id) {
		Connection connection = JDBCUtil.getConnection();
		//String sql = "SELECT QID,ID,TITLE,CONTENT,CLID,PROVIDE_IFO FROM QUESTION WHERE ID="+id;
		String sql="SELECT Q.QID, Q.ID, Q.TITLE, Q.CONTENT, Q.CLID, Q.PROVIDE_IFO, C.NAME AS CLINIC_NAME, A.DID, A.CONTENT AS ANSWER_CONTENT FROM QUESTION Q JOIN CLINIC_IOF C ON Q.CLID = C.ID LEFT JOIN ANSWER A ON Q.QID = A.QID WHERE Q.ID ="+id;
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		List<Question> questionlist = new ArrayList<>();
		try {
			statement = connection.prepareStatement(sql);
			resultSet = statement.executeQuery();
			while (resultSet.next()) {
				int QId=resultSet.getInt(1);
				int get_id = resultSet.getInt(2);
				String title = resultSet.getString(3);
				String questionMessage = resultSet.getString(4);
				int  clinicDepartmentId= resultSet.getInt(5);
				Boolean isAcessiable=resultSet.getBoolean(6);
				String clinicDepartmentName=resultSet.getString(7);
				int doctor_id=resultSet.getInt(8);
				String answer_content=resultSet.getString(9);
				questionlist.add(new Question(QId,id, title,questionMessage,new Clinic(clinicDepartmentId, clinicDepartmentName),new Answer(doctor_id,QId,answer_content),false,isAcessiable));
			}

		} catch (SQLException throwables) {
			throwables.printStackTrace();
		} finally {
			JDBCUtil.release(connection, statement, resultSet);
		}
		return questionlist;

	}
	
	//select information by questionId
	public Question select(int questionId)throws SQLException {
		DBUtil db = new DBUtil();
		Connection con = null;
		try {
			con = db.getConnection();
			
			//String sql = "SELECT * FROM QUESTION WHERE QUESTION_ID = ?";
			String sql="SELECT Q.QID, Q.ID, Q.TITLE, Q.CONTENT, Q.CLID, Q.PROVIDE_IFO, C.NAME AS CLINIC_NAME, A.DID, A.CONTENT AS ANSWER_CONTENT FROM QUESTION Q JOIN CLINIC_IOF C ON Q.CLID = C.ID LEFT JOIN ANSWER A ON Q.QID = A.QID WHERE Q.QID="+questionId;
			PreparedStatement pstmt = con.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();		
			Question question = null;
			if(rs.next()) {
				int QId=rs.getInt(1);
				int get_id = rs.getInt(2);
				String title = rs.getString(3);
				String questionMessage = rs.getString(4);
				int  clinicDepartmentId= rs.getInt(5);
				Boolean isAcessiable=rs.getBoolean(6);
				String clinicDepartmentName=rs.getString(7);
				int doctor_id=rs.getInt(8);
				String answer_content=rs.getString(9);
				question=new Question(QId,get_id, title,questionMessage,new Clinic(clinicDepartmentId, clinicDepartmentName),new Answer(doctor_id,QId,answer_content),false,isAcessiable);
			}
			pstmt.close();
			return question;
		}finally {
			db.closeConnection(con);
		}
	}
	
	//add information to DB
	public int insert(Question question) throws SQLException{
		DBUtil db = new DBUtil();//loading db driver 
		Connection con = null;
		try {
			con = db.getConnection();
//			String sql = "INSERT INTO QUESTION(QUESTION_ID, ID, QUESTION_MESSAGE) "
//					+ "VALUES(?, ?, ?)";
			
			//auto-incrementを利用してquestion_idを省する
			String sql = "INSERT INTO `QUESTION` (ID, CLID,TITLE,CONTENT, PROVIDE_IFO)"
					+ "VALUES(?, ?, ?, ?,?)";
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setInt(1,question.getId());
			pstmt.setInt(2, question.getClinic().getClinicDepartmentId());
			pstmt.setString(3, question.getTitle());
			pstmt.setString(4, question.getQuestionMessage());
			pstmt.setBoolean(5, question.isAcessiable());
			
			int r = pstmt.executeUpdate();
			pstmt.close();
			return r;
			
		}finally {
			db.closeConnection(con);
		}
	}
	
	//update question information
	public int update(Question question)throws SQLException{
		DBUtil db = new DBUtil();
		Connection con = null;
		try {
			con = db.getConnection();
			String sql = "UPDATE QUESTION SET ID=?, QUESTION_MESSAGE=?, IS_ANSWERED=?, IS_ACESSIABLE=?"
					+ "WHERE QUESTION_ID=? ";
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, question.getId());
			pstmt.setString(2, question.getQuestionMessage());
			pstmt.setBoolean(3, question.isAnswered());
			pstmt.setBoolean(4, question.isAcessiable());
			pstmt.setInt(5, question.getQuestionId());
			
			int r = pstmt.executeUpdate();
			pstmt.close();
			return r;
			
		}finally {
			db.closeConnection(con);
		}
		
	}
	
	
	
	
}
