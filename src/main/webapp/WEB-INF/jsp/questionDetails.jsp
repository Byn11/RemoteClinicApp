<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% 
//データベースから一致する質問IDのレコード値を取得し、表示する。
%>
<%@ page import = "entity.Question,entity.Answer" %>
    
<%  
    //リクエストスコープに保存されたつぶやきリストを取得
	Question question = (Question)request.getAttribute("question");
%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>HealthCareApp</title>
<link rel = "stylesheet" href="./css/questionDetails.css">
</head>
<body>
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
		<h2>質問詳細</h2>
		<div class = "font">
			診療科：<%=question.getClinic().getClinicDepartmentName() %><br>
			質問内容：<%=question.getQuestionMessage() %><br>
			健康情報提供可否：<%=question.isAcessiable() %><br>
			
			
			<% Answer answer = question.getAnswer();
			  if (answer.getContent()!= null) {
	    	%>  
	    	  医者ID: <%= answer.getDoctorId()%><br>
	    	  回答内容: <%= answer.getContent()%>
	     	<% } %>
		
		</div>
		<form action="ReturnMenu" method = "get">
		   <div class = "submit-button">
		    <input type = "submit"  value = "戻る" class = "button">
		   </div>
	     </form>
	</main>
	<footer>
		<p>© HealthCareApp</p>
	</footer>
</body>
</html>