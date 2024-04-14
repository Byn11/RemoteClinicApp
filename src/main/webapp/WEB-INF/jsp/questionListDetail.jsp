<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="entity.Question,entity.User,java.util.List,entity.HealthInfo,entity.Clinic,entity.Doctor" %>
<%  
    //リクエストスコープに保存された質問リストを取得
	Question questionDetail = (Question)request.getAttribute("questionDetail");
	//リクエストスコープに保存されたユーザーを取得
	User user = (User)request.getAttribute("user");
	//リクエストスコープに保存された健康情報を取得
	HealthInfo healthInfo = (HealthInfo)request.getAttribute("healthInfo");


	Doctor doctor = (Doctor)session.getAttribute("loginDoctor");
%>


<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>HealthCareApp</title>
<link rel = "stylesheet" href="./css/questionListDetail.css">
</head>
<body>
<script type="text/javascript">
window.onload = function () {
if(<%= questionDetail.isAcessiable() %>==true){
	document.getElementById("height").innerHTML =  " 身長:"+<%= healthInfo.getHeight() %> ;
	document.getElementById("weight").innerHTML = "体重:"+<%= healthInfo.getWeight() %>;
	document.getElementById("bloodPressure").innerHTML = "血圧："+<%= healthInfo.getBloodPressure() %>;
	document.getElementById("sleepTime").innerHTML = "睡眠時間:"+<%= healthInfo.getSleepTime() %>;
}else if(<%= questionDetail.isAcessiable() %>==false){
	document.getElementById("height").innerHTML = "健康情報は非公開";
};
};
</script>

	<header>
		<h1>HealthCareApp</h1>
 	  	<!-- プロフィールのコンテンツ -->
 	  	<div class = "header-contents"> 
 	  	   <form action="ReturnMenu" method = "get">
			<input type = "submit" value = "TOPに戻る" class = "top-button">
 	  	   </form>  
 	  	</div> 	
  </header>
  <main>
		<h1>質問詳細画面</h1>
		<form action="AnswerMain?questionId=<%= questionDetail.getQuestionId() %>" method="post">
		
		<input type="hidden" name="id" value=<%= questionDetail.getId() %>>
		<input type="hidden" name="doctorId" value=<%=doctor.getId() %> >
		<div class = "font">
			<p>・診療科：<%= questionDetail.getClinic() %></p>
			<p>・名前：<%= user.getName() %></p>
			<p>・性別：<%= user.getGender() %></p>
			<p>・生年月日：<%= user.getBirthday() %></p>
			<p>・健康情報</p>
					  <p id="height"></p>
					  <p id="weight"></p>
					  <p id="bloodPressure"></p>
					  <p id="sleepTime"></p>
			<p>・質問内容</p>
				<div class = "text-content">
					<div class = "text">
					<%= questionDetail.getQuestionMessage() %>
					</div>
				 </div>
			
			<p>・質問に対する回答を入力してください</p>
			<p><textarea name="answer" rows="10"></textarea></p>	 
		</div>
		<div class = "submit-button">
			<input type="submit" value="回答確認" class = "button"><br>	
		</div>		  
		</form>
		<form action="QuestionListReturn" method="get">
		<div  class = "submit-button">
			<input type="submit" value="戻る" class = "button">
		</div>
		</form>
	</main>	
	<footer>
		<p>© HealthCareApp</p>
	</footer>

</body>
</html>