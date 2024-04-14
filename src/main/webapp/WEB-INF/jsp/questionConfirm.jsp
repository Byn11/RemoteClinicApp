<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<% 
//質問画面で入力された値がセッションに保存済みなので、もってくる。
String clinicDepartmentName = (String)session.getAttribute("clinicDepartmentName");
String text = (String)session.getAttribute("text");
String title=(String)session.getAttribute("title");
String heaelthInformationAble = (String)session.getAttribute("heaelthInformationAble");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>HealthCareApp</title>
<link rel = "stylesheet" href="./css/questionConfirm.css">
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
		
	  <div class = "main_container">
			<h2>質問内容の確認</h2>
			<div class = "container">
			  <div class = "clinic sub_container">	
				<p>診療科：<%=clinicDepartmentName%></p>
			  </div>
			  <div>
				<p>タイトル：<%= title %></p>
			  </div>
			  <div class = "question sub_container">
				<p>質問内容：</p>
				  <div class = "text-content">
					<div class = "text">
					<%= text %>
					</div>
				  </div>
			  </div>
			  <div class = "radio sub_container">
				<p>健康情報の提供可否：
					<% if(heaelthInformationAble.equals("OK")){ %>可
					<% }else { %>否
				    <% } %>
				</p>
			 </div>
			</div>
		  <div class = "submit_button">
			  <form action=""  method = "get">
			  <input type = "submit" formaction = "QuestionReturn" value = "戻る" class = "button">
			  <input type = "submit" formaction="QuestionComplete" value = "送信する" class = "button">
			  </form>
		  </div>
	  </div>
	</main>

	<footer>
		<p>© HealthCareApp</p>
	</footer>

</body>
</html>