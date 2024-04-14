package dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import entity.User;
import util.JDBCUtil;

public class UserDao {
	public User userFindById(Integer id) {
		Connection connection = JDBCUtil.getConnection();
		System.out.println(connection);
	    String sql="select * from `USER` where id = "+id;
	    PreparedStatement statement=null;
	    ResultSet resultSet=null;
	    try {
	    	statement=connection.prepareStatement(sql);
	    	resultSet=statement.executeQuery();
	    	if (resultSet.next()) {
	    		Integer get_id=resultSet.getInt(1);
	    		String uname=resultSet.getString(2);
		    	String pswd=resultSet.getString(3);
		    	Integer gender=resultSet.getInt(4);
		    	Date birthday=java.sql.Date.valueOf(resultSet.getString(5));
		    	String telephone=resultSet.getString(6);		    	
		    	String mailaddress=resultSet.getString(7);
		    	String address=resultSet.getString(8);
		    	User user =new User(get_id, pswd, uname, gender,mailaddress,birthday,address,telephone,null);
		    	//System.out.println("ok");
		    	return user;
	    	}
	    }catch(SQLException throwables) {
	            throwables.printStackTrace();
	        } finally {
	            JDBCUtil.release(connection, statement, resultSet);
	        }
	    //System.out.println("no");
	        return null;
		
		
		
	}
	public int createUser(User user) {
	    Connection connection = JDBCUtil.getConnection();
	    String sql="INSERT INTO `USER`(NAME,PSWD,GENDER,BIRTHDAY,TELEPHONE,MAILADDRESS,ADDRESS) VALUES(?,?,?,?,?,?,?)";
	    PreparedStatement statement=null;
	    try {
	    	statement=connection.prepareStatement(sql,new String[] {"ID"});
	    	statement.setString(1, user.getName());
	    	statement.setString(2, user.getPassword());
	    	statement.setInt(3, user.getGender());
	    	statement.setDate(4, user.getBirthday());
	    	statement.setString(5, user.getTelephone());
	    	statement.setString(6, user.getEmailAddress());
	    	statement.setString(7, user.getAddress());
	    	int result=statement.executeUpdate();
	    	if (result > 0) {
	    	    ResultSet generatedKeys = statement.getGeneratedKeys();
	    	    if (generatedKeys.next()) {
	    	        int insertedId = generatedKeys.getInt(1);
	    	        return insertedId;
	    	    }}
	    }catch (SQLException e) {
			e.printStackTrace();
			return -1;
		}
		return -1;  
	    
	
	}
	//基本情報を更新する
	public int update(User user) {
		DBUtil db = new DBUtil();
		Connection con = null;
		try {
			con = db.getConnection();
			
			String sql = "UPDATE `USER` SET NAME=?, BIRTHDAY=?, TELEPHONE=?, MAILADDRESS=?, ADDRESS=?"
					+ "WHERE ID=? ";
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setString(1, user.getName());
//			pstmt.setDate(2, new java.sql.Date(user.getBirthday().getTime()));
			pstmt.setDate(2, user.getBirthday());
			pstmt.setString(3, user.getTelephone());
			pstmt.setString(4, user.getEmailAddress());
			pstmt.setString(5, user.getAddress());
			pstmt.setInt(6, user.getId());//指定するUserのId
			int r = pstmt.executeUpdate();
			pstmt.close();
			return r;
		}catch(SQLException e){
			e.printStackTrace();
		}finally {
			db.closeConnection(con);
		}
		return 0;
		
	}
}
