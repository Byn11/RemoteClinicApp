package service;

import java.util.List;

import dao.DoctorDao;
import entity.Doctor;

public class GetDoctorListLogic {
	public List<Doctor> execute(){
		DoctorDao dao = new DoctorDao();
		//データベースの値を全て持ってきてdoctorListに格納。
//		List<Doctor> doctorList = new ArrayList<Doctor>();
//		//doctorIdが1から最大値までの間、SELECTを実行して全部の質問を取得する。
//		for (int i= 1; i <= dao.doctor_getMaxId(); i ++) {
//			doctorList.add(dao.doctorFindById(i));
//		}
//		
//		
		return dao.list();
	}
}
