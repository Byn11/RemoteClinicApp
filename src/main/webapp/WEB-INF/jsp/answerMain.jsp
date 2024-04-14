<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="entity.Question,entity.Answer" %>
<%
	//リクエストスコープに保存された質問リストを取得
	Question question = (Question)request.getAttribute("question");
	Answer answer = (Answer)session.getAttribute("answer");
	
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>HealthCareApp</title>
<link rel = "stylesheet" href="./css/answerMain.css">
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
	 	<h1>回答確認画面</h1>
		<form action="AnswerComplete" method="post">
			<p>・質問内容</p>
					<div class = "text-content">
						<div class = "text">
						<%= question.getQuestionMessage() %>
						</div>
					 </div>
			<p>・回答内容</p>
					<div class = "text-content">
						<div class = "text">
						<%= answer.getContent() %>
						</div>
					 </div>
		 <div class = "submit-button">	
			<input type="submit" value="次へ" class = "button">
		 </div>
		</form>
		<form action="QuestionDetailReturn" method="get">
		<div class = "submit-button">
			<input type="submit" value="戻る" class = "button">
		</div>
		</form>
	</main>
	<footer>
		<p>© HealthCareApp</p>
	</footer>
</body>
</html>