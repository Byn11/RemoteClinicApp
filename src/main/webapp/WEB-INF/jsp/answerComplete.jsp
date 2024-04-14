<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>HealthCareApp</title>
<link rel = "stylesheet" href="./css/answerComplete.css">
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
		<h2>回答が完了しました！</h2>
			<form action="ReturnDoctorMenu" method="get">
			    <div class = "submit_button">
				  <input type="submit" value="トップへ" class = "button">
				</div>
			</form>
  </main>
  <footer>
		<p>© HealthCareApp</p>
	</footer>
</body>
</html>