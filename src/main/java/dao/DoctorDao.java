package dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import entity.Clinic;
import entity.Doctor;
import util.JDBCUtil;

public class DoctorDao {
	public Doctor doctorFindById(Integer id) {
		Connection connection = JDBCUtil.getConnection();
		String sql = "select * from `DOCTOR` where id = '" + id + "'";
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		try {
			statement = connection.prepareStatement(sql);
			resultSet = statement.executeQuery();
			if (resultSet.next()) {
				Integer get_id = resultSet.getInt(1);
				String uname = resultSet.getString(2);
				String pswd = resultSet.getString(3);
				Integer gender = resultSet.getInt(4);
				Date birthday = resultSet.getDate(5);
				String telephone = resultSet.getString(6);
				String mailaddress = resultSet.getString(7);
				String address = resultSet.getString(8);
				Integer clinic_id = resultSet.getInt(9);
				String image = resultSet.getString(10);
				Doctor doctor = new Doctor(get_id, pswd, uname, gender, mailaddress, birthday, address, telephone,
						image, null);
				//System.out.println("ok");
				return doctor;
			}
		} catch (SQLException throwables) {
			throwables.printStackTrace();
		} finally {
			JDBCUtil.release(connection, statement, resultSet);
		}
		//System.out.println("no");
		return null;

	}

	public int createDoctor(Doctor doctor) {
		Connection connection = JDBCUtil.getConnection();
		String sql_doctor = "INSERT INTO `DOCTOR`(NAME,PSWD,GENDER,BIRTHDAY,TELEPHONE,MAILADDRESS,ADDRESS,IMAGE) VALUES(?,?,?,?,?,?,?,?)";
		String sql_clinic = "INSERT INTO CLINIC (ID,CIID) VALUES(?,?)";
		int insertedId=-1;
		PreparedStatement statement = null;
		try {
	    	statement=connection.prepareStatement(sql_doctor,new String[] {"ID"});
			statement.setString(1, doctor.getName());
			statement.setString(2, doctor.getPassword());
			statement.setInt(3, doctor.getGender());
			statement.setDate(4, doctor.getBirthday());
			statement.setString(5, doctor.getTelephone());
			statement.setString(6, doctor.getEmailAddress());
			statement.setString(7, doctor.getAddress());
			statement.setString(8, doctor.geturlPhotoForAuthentication());
			int result = statement.executeUpdate();
			if (result>0) {
				ResultSet generatedKeys = statement.getGeneratedKeys();
	    	    if (generatedKeys.next()) 
	    	        insertedId = generatedKeys.getInt(1);    
	    	    }
			else {
				return -1;
			}
			
			statement = connection.prepareStatement(sql_clinic);
			List<Clinic> clinicalDepartment = doctor.getClinicalDepartment();
			for (Clinic clinic : clinicalDepartment) {
				statement.setInt(1, doctor_getMaxId());
				statement.setInt(2, clinic.getClinicDepartmentId());
				result=statement.executeUpdate();
				if (result != 1)
					return -1;
			}
		} catch (SQLException e) {
			e.printStackTrace();
			return -1;
		}

		return insertedId;

	}

	public int doctor_getMaxId() {
		Connection connection = JDBCUtil.getConnection();
		String sql = "SELECT MAX(ID) FROM DOCTOR";
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		try {
			statement = connection.prepareStatement(sql);
			resultSet = statement.executeQuery();
			if (resultSet.next()) {
				Integer max_id = resultSet.getInt(1);
				return max_id;
			}
		} catch (SQLException throwables) {
			throwables.printStackTrace();
		} finally {
			JDBCUtil.release(connection, statement, resultSet);
		}
		return 0;
	}

	public List<Doctor> list() {
		Connection connection = JDBCUtil.getConnection();
		String sql = "SELECT ID,NAME,PSWD,GENDER,BIRTHDAY,TELEPHONE,MAILADDRESS,ADDRESS,IMAGE FROM DOCTOR";
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		List<Doctor> doctorlist = new ArrayList<>();
		try {
			statement = connection.prepareStatement(sql);
			resultSet = statement.executeQuery();
			while (resultSet.next()) {
				int id = resultSet.getInt(1);
				String name = resultSet.getString(2);
				String pswd = resultSet.getString(3);
				int gender = resultSet.getInt(4);
				Date birthday = java.sql.Date.valueOf(resultSet.getString(5));
				String telephone = resultSet.getString(6);
				String mailaddress = resultSet.getString(7);
				String address = resultSet.getString(8);
				String image = resultSet.getString(9);
				List<Clinic> cliniclist = getClinicByDoctorId(id);
				doctorlist.add(new Doctor(id, pswd, name, gender, mailaddress, birthday, address, telephone, image,
						cliniclist));
			}

		} catch (SQLException throwables) {
			throwables.printStackTrace();
		} finally {
			JDBCUtil.release(connection, statement, resultSet);
		}
		return doctorlist;

	}

	public List<Clinic> getClinicByDoctorId(int id) {
		Connection connection = JDBCUtil.getConnection();
		String sql = "SELECT CLINIC.CIID,CLINIC_IOF.NAME FROM CLINIC JOIN CLINIC_IOF ON CLINIC.CIID=CLINIC_IOF.ID WHERE CLINIC.ID='"
				+ id + "'";
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		List<Clinic> cliniclist = new ArrayList<>();
		try {
			statement = connection.prepareStatement(sql);
			resultSet = statement.executeQuery();
			while (resultSet.next()) {
				int clinicDepartmentId = resultSet.getInt(1);
				String clinicDepartmentName = resultSet.getString(2);
				cliniclist.add(new Clinic(clinicDepartmentId, clinicDepartmentName));
			}
		} catch (SQLException throwables) {
			throwables.printStackTrace();
		} finally {
			JDBCUtil.release(connection, statement, resultSet);
		}
		return cliniclist;

	}
}

//String sql1="SELECT * FROM CLINIC JOIN DOCTOR ON DOCTOR.ID = CLINIC.ID JOIN CLINIC_IOF ON CLINIC.CIID = CLINIC_IOF.ID";