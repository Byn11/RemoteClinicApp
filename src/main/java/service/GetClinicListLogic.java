package service;

import java.sql.SQLException;
import java.util.List;

import dao.Clinic_IFODao;
import entity.Clinic;

public class GetClinicListLogic {
	
	//データベースから診療科のリストを取得する
	public List<Clinic> execute_sub(){
		Clinic_IFODao clinic_IFODao = new Clinic_IFODao();
		List<Clinic> clinicList = null;
		try {
			clinicList = clinic_IFODao.selectAll();
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return clinicList;
	}
	
	//応急措置
	public  boolean execute() {
		return true;
	}
	public String selectNameById(int id) {
		return new Clinic_IFODao().selectNameById(id);
	}
//	//データベースから診療科のリストを取得する
//	public List<Clinic> execute_sub(){
//	ClinicDAO dao = new ClinicDAO();
//	
//	return clinicList;
	}



