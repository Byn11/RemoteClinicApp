package entity;

public class Clinic {
	
	//フィールド
	private int clinicDepartmentId;  //診療科ID
	private String clinicDepartmentName;  //診療科名
	
	//引数なしコンストラクタ
	public Clinic () {
	}
	
	public Clinic(int clinicDepartmentId,String clinicDepartmentName) {
		this.clinicDepartmentId  = clinicDepartmentId;
		this.clinicDepartmentName = clinicDepartmentName;
	}
	
	public Clinic(int clinicDepartmentId) {
		super();
		this.clinicDepartmentId = clinicDepartmentId;
	}

	//getter,setter
	public int getClinicDepartmentId() {
		return clinicDepartmentId;
	}

	public void setClinicDepartmentId(int clinicDepartmentId) {
		this.clinicDepartmentId = clinicDepartmentId;
	}

	public String getClinicDepartmentName() {
		return clinicDepartmentName;
	}

	public void setClinicDepartmentName(String clinicDepartmentName) {
		this.clinicDepartmentName = clinicDepartmentName;
	}

	@Override
	public String toString() {
		return clinicDepartmentName;
	}
	



	}
	
	

