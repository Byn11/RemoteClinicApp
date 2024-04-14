<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="entity.Question,java.util.List" %>
<%  
    //リクエストスコープに保存された質問リストを取得
	List<Question> questionList = (List<Question>)request.getAttribute("questionList");

%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>HealthCareApp</title>
<link rel = "stylesheet" href="./css/questionList.css">
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
		<h1>質問一覧画面</h1>
		<p>未回答のユーザーの質問に回答する事ができます</p>
		<div class = "table">	
			<table border="1" class = "table_layout">
				<tr>
					<th class = "th0">日付</th>
				    <th class = "th1">診療科</th>
				    <th class = "th2">タイトル</th>
				    <th class = "th3">質問詳細</th>
				</tr>
				
					<%for(Question question : questionList){%>
				<tr>
					<td class = "th0">2023-04-01</td>
					<td class = "th1"><%= question.getClinic() %></td>
					<td class = "th2"><%= question.getTitle() %></td>
					<td class = "th3"><a href="QuestionListDetail?questionId=<%= question.getQuestionId() %>&id=<%= question.getId() %>">詳細</a></td>
				</tr>
				<% } %>
			</table>
		</div>	
			
		<form action="ReturnDoctorMenu" method="get" >
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