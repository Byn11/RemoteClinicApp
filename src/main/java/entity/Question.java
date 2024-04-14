package entity;

public class Question {
	
	//フィールド
	private int questionId;
	private int id;
	private String title;
	public Question(int questionId, int id, String title, String questionMessage, Clinic clinic, Answer answer,
			boolean isAnswered, boolean isAcessiable) {
		super();
		this.questionId = questionId;
		this.id = id;
		this.title = title;
		this.questionMessage = questionMessage;
		this.clinic = clinic;
		this.answer = answer;
		this.isAnswered = isAnswered;
		this.isAcessiable = isAcessiable;
	}


	private String questionMessage;
//	private int clinicDepartmentId;//新たに追加した（馬）
	private Clinic clinic;
//	private List<Answer> answerList;  //質問に対する複数の回答をまとめたリスト
	private Answer answer;
	private boolean isAnswered;
	private boolean isAcessiable;
	//引数なしコンストラクタ
	public Question() {
	}
	
	
	/**
 * @param id
 * @param questionMessage
 * @param clinicDepartmentName
 */
public Question(int id, String title, String questionMessage, Clinic clinic, boolean isAcessiable) {
	super();
	this.id = id;
	this.title=title;
	this.questionMessage = questionMessage;
	this.clinic = clinic;
	this.isAcessiable = isAcessiable;
}


	public Question(int id, String title ,String questionMessage, Clinic clinic, boolean isAnswered, boolean isAcessiable) {
		super();
		this.id = id;
		this.title=title;
		this.questionMessage = questionMessage;
		this.clinic = clinic;
		this.isAnswered = isAnswered;
		this.isAcessiable = isAcessiable;
	}


	public Question(int questionId,int id,String title ,String questionMessage,Clinic clinic, boolean isAnswered, boolean isAcessiable ) {
		this.questionId = questionId;
		this.id = id;
		this.title=title;
		this.questionMessage = questionMessage;
		this.clinic = clinic;
		this.isAcessiable = isAcessiable;
		
	}
	
	
	//getter,setter
	public int getQuestionId() {
		return questionId;
	}
	public void setQuestionId(int questinId) {
		this.questionId = questinId;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getQuestionMessage() {
		return questionMessage;
	}
	public void setQuestionMessage(String questionMessage) {
		this.questionMessage = questionMessage;
	}


	public boolean isAnswered() {
		return isAnswered;
	}


	public void setAnswered(boolean isAnswered) {
		this.isAnswered = isAnswered;
	}


	public boolean isAcessiable() {
		return isAcessiable;
	}


	public void setAcessiable(boolean isAcessiable) {
		this.isAcessiable = isAcessiable;
	}




	public String getTitle() {
		return title;
	}


	public void setTitle(String title) {
		this.title = title;
	}


	public Clinic getClinic() {
		return clinic;
	}


	public void setClinic(Clinic clinic) {
		this.clinic = clinic;
	}


	public Answer getAnswer() {
		return answer;
	}


	public void setAnswer(Answer answer) {
		this.answer = answer;
	}


		
	
}
