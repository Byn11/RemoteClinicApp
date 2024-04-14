<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>HaelthCareApp</title>
<link rel = "stylesheet" href="./css/questionComplete.css">
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
	<div class="container">
	  <h2>質問の送信が完了しました！</h2>
	  <form action="ReturnMenu" method = "get">
		<div class = "submit_button">
		  <input type = "submit"  value = "トップ画面に戻る" class = "button">
		</div>
	  </form>
	</div>
	<footer>
		<p>© HealthCareApp</p>
	</footer>
</body>
</html>