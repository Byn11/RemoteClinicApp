package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import entity.Clinic;
import util.JDBCUtil;

public class Clinic_IFODao {
	
	public List<Clinic> selectAll()throws SQLException{
		DBUtil db = new DBUtil();
		Connection con = null;
		try {
			con = db.getConnection();
			
			String sql = "SELECT * FROM CLINIC_IOF";
			PreparedStatement pstmt = con.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();
			List<Clinic> clinicList = new ArrayList<>();
			while(rs.next()) {
				Clinic clinic = new Clinic();
				clinic.setClinicDepartmentId(rs.getInt("ID"));
				clinic.setClinicDepartmentName(rs.getString("NAME"));
				clinicList.add(clinic);
			}
			pstmt.close();
			return clinicList;
		}finally {
			db.closeConnection(con);
		}
	}
	public String selectNameById(int id) {
		Connection connection = JDBCUtil.getConnection();
		String sql = "select NAME from CLINIC_IOF  where ID = '" + id + "'";
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		try {
			statement = connection.prepareStatement(sql);
			resultSet = statement.executeQuery();
			if (resultSet.next()) {
				String name = resultSet.getString(1);
				return name;
			}
		} catch (SQLException throwables) {
			throwables.printStackTrace();
		} finally {
			JDBCUtil.release(connection, statement, resultSet);
		}
		
		return null;
		
		
	}
}
