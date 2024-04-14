package entity;

public class Answer {
	
	private int doctorId;
	private int question_id;
	private String content;

	public Answer(int doctorId, int question_id, String content) {
		super();
		this.doctorId = doctorId;
		this.question_id = question_id;
		this.content = content;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public int getDoctorId() {
		return doctorId;
	}
	public void setDoctorId(int doctorId) {
		this.doctorId = doctorId;
	}
	public int getQuestion_id() {
		return question_id;
	}
	public void setQuestion_id(int question_id) {
		this.question_id = question_id;
	}
	


}
