<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ page import = "entity.Question, java.util.List" %>
    
<%  
    //リクエストスコープに保存されたつぶやきリストを取得
	List<Question> questionList = (List<Question>)request.getAttribute("questionList");
%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>HealthCareApp</title>
<link rel = "stylesheet" href="./css/questionHistory.css">
</head>
<body>
	<script type="text/javascript" src="./javascript/questionHistory.js"></script>
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
		<h1>質問履歴</h1>
		<p>過去に自分が質問した内容を確認する事ができます</p>
		
		<!-- 日付入力欄と抽出ボタン -->
		<div class = "date_sort">
			<div class = "calender">
				<input type="date" id="startDateInput">
				<input type="date" id="dateInput">
			</div>
			<div class = "calender_submit">
				<button onclick="extractRows()">日付で探す</button>
			</div>
		</div>
		<div class = "table">
			<table border="1" class = "table_layout">
			  <tr>
				<th class = "th0">日付</th>
			    <th class = "th1">診療科</th>
			    <th class = "th2">タイトル</th>
			    <th class = "th3">詳細</th>
			  </tr>
			  <% for(Question question : questionList) { %>
  			  <tr>
				<td class = "th0">2023-04-01</td>
    			<td class = "th1"><%= question.getClinic().getClinicDepartmentName()%></td>
    			<td class = "th2"><%= question.getTitle()%></td>
    			<td class = "th3"><a href="QuestionDetails?id=<%= question.getQuestionId() %>">詳細</a></td>
  			  </tr>
 			   <% } %>
			</table>
		</div>
		
		<div>
	     <form action="ReturnMenu" method = "get">
		   <div class = "submit-button">
		    <input type = "submit"  value = "戻る" class = "button">
		   </div>
	     </form>
		</div>
	</main>
	
	<footer>
		<p>© HealthCareApp</p>
	</footer>

</body>
</html>