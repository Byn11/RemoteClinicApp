package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import entity.HealthInfo;

public class HealthInfoDAO {
	
	//database内の健康情報を全て取り出す
	public List<HealthInfo> sellectAll() throws SQLException{
			DBUtil db = new DBUtil();
			Connection con = null;
			try {
				con = db.getConnection();
				
				String sql = "SELECT * FROM HEALTHIFO";
				PreparedStatement pstmt = con.prepareStatement(sql);
				ResultSet rs = pstmt.executeQuery();
				List<HealthInfo> healthInfoList = new ArrayList<>();
				while(rs.next()) {
					HealthInfo healthInfo = new HealthInfo();
					healthInfo.setId(rs.getInt("ID"));
					healthInfo.setUpdateData(rs.getDate("UPDATE_TIME"));
					healthInfo.setHeight(rs.getDouble("HEIGHT"));
					healthInfo.setWeight(rs.getDouble("WEIGHT"));
					healthInfo.setBloodPressure(rs.getDouble("BLOOD_PRESSURE"));
					healthInfo.setSleepTime(rs.getDouble("SLEEP_TIME"));
					healthInfoList.add(healthInfo);
				}
				pstmt.close();
				return healthInfoList;
			}finally {
				db.closeConnection(con);
			}
	}
	
	//idを指定して、他の情報を取得する
	public HealthInfo select(int id) throws SQLException  {
		DBUtil db = new DBUtil();
		Connection con = null;
		try {
			con = db.getConnection();
			
			String sql = "SELECT * FROM HEALTHIFO WHERE ID = ? ";
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setInt(1,id);
			ResultSet rs = pstmt.executeQuery();		
			HealthInfo healthInfo = new HealthInfo();
			if(rs.next()) {
				healthInfo.setUpdateData(rs.getDate("UPDATE_TIME"));
				healthInfo.setHeight(rs.getDouble("HEIGHT"));
				healthInfo.setWeight(rs.getDouble("WEIGHT"));
				healthInfo.setBloodPressure(rs.getDouble("BLOOD_PRESSURE"));
				healthInfo.setSleepTime(rs.getDouble("SLEEP_TIME"));

			}
			pstmt.close();
			return healthInfo;

		}finally {
			db.closeConnection(con);
		}
		
	}
	public List<HealthInfo> selectById(int id){
		DBUtil db = new DBUtil();
		Connection con = null;
		try {
			con = db.getConnection();
			String sql = "SELECT * FROM HEALTHIFO WHERE ID =?";
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, id);
			ResultSet rs = pstmt.executeQuery();
			List<HealthInfo> infoList = new ArrayList<>();
			
			while(rs.next()) {
				HealthInfo healthInfo = new HealthInfo();
				healthInfo.setUpdateData(rs.getDate("UPDATE_TIME"));
				healthInfo.setHeight(rs.getDouble("HEIGHT"));
				healthInfo.setWeight(rs.getDouble("WEIGHT"));
				healthInfo.setBloodPressure(rs.getDouble("BLOOD_PRESSURE"));
				healthInfo.setSleepTime(rs.getDouble("SLEEP_TIME"));
				infoList.add(healthInfo);
			}
			pstmt.close();
			return infoList;
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			db.closeConnection(con);
		}
		return null;
	}
	
		//DBにデータを追加する
	public int insert(HealthInfo healthInfo)throws SQLException {
		DBUtil db = new DBUtil();
		Connection con = null;
		try {
			con = db.getConnection();
			String sql = "INSERT INTO HEALTHIFO(ID, UPDATE_TIME, HEIGHT,  WEIGHT, BLOOD_PRESSURE, SLEEP_TIME) "
					+ "VALUES(?,?,?,?,?,?)";
			PreparedStatement pstmt = con.prepareStatement(sql);
			
			pstmt.setInt(1,healthInfo.getId());
			pstmt.setDate(2,new java.sql.Date(healthInfo.getUpdateData().getTime()));
			pstmt.setDouble(3,healthInfo.getHeight());
			pstmt.setDouble(4, healthInfo.getWeight());
			pstmt.setDouble(5, healthInfo.getBloodPressure());
			pstmt.setDouble(6, healthInfo.getSleepTime());
			
			
			int r = pstmt.executeUpdate();
			pstmt.close();
			return r;

		}finally {
			db.closeConnection(con);
		}
	}
	
	//情報を更新する
	public int update(HealthInfo healthInfo)throws SQLException {
		DBUtil db = new DBUtil();
		Connection con = null;
		try {
			con = db.getConnection();
			
			String sql = "UPDATE HEALTHIFO SET UPDATE_TIME=? ,HEIGHT=?  ,WEIGHT=?, BLOOD_PRESSURE=?, SLEEP_TIME=?"
					+ "WHERE ID = ?";
					
			PreparedStatement pstmt = con.prepareStatement(sql);				
			pstmt.setDate(1,new java.sql.Date(healthInfo.getUpdateData().getTime()));
			pstmt.setDouble(2,healthInfo.getHeight());
			pstmt.setDouble(3, healthInfo.getWeight());
			pstmt.setDouble(4, healthInfo.getBloodPressure());
			pstmt.setDouble(5, healthInfo.getSleepTime());
			pstmt.setInt(6,healthInfo.getId());	
			
			int r = pstmt.executeUpdate();
			pstmt.close();
			return r;

		}finally {
			db.closeConnection(con);
		}
	}

}
