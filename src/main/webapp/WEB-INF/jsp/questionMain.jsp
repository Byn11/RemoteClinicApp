<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="entity.Clinic, service.GetClinicListLogic, java.util.List" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>HealthCareApp</title>
<link rel = "stylesheet" href="./css/questionMain.css">
</head>
<body>
	<header>
		<h1>HealthCareApp</h1>
 	  	<!-- プロフィールのコンテンツ -->
 	  	<div class = "header-contents"> 
 	  	   <form action="ReturnMenu" method = "get">
			<input type = "submit" value = "TOPに戻る" class = "top">
 	  	   </form>  
 	  	</div> 	
  </header>
	<main>
	<h2>質問フォーム</h2>
	<form action="QuestionMain" method = "post">
		  <%--データベースから診療科リストを持ってくるプログラム --%>
		  <%
		  GetClinicListLogic getClinicList = new GetClinicListLogic();
		  List<Clinic> clinicList = getClinicList.execute_sub();
		  %>
		  <div class = "clinic_ist">	
			<p>・診療科</p>
			<p>
			<select name = "userSelectClinicDepartmentId">
			<% for (Clinic clinic: clinicList) { %>
			<option value = "<%= clinic.getClinicDepartmentId()%>"><%= clinic.getClinicDepartmentName() %></option>
			<% } %>
			</select>
			</p>
		  </div>
		  <div>
			<p>・タイトル</p>  
			<p>
			  <input type="text" name="title"><br>
			</p>
		  </div>
		  <div class = "question">
			<p>・質問内容</p>
			<textarea name="userText" rows="10"></textarea><br>
		  </div>
		  
			<p>・健康情報の提供可否</p>
			<div class = "radio_type">
			<input type="radio" name="healthInformationAble" value="OK">可
			<input type="radio" name="healthInformationAble" value="NG">否<br>
		  </div>
		  <div class = "submit_button">
			<input type = "submit" formaction="QuestionClear" value = "クリア" class = "button">
			<input type = "submit" formaction="QuestionMain" value = "確認する" class = "button">
		  </div>
	</form>
	</main>
	
	<footer>
		<p>© HealthCareApp</p>
	</footer>
</body>
</html>