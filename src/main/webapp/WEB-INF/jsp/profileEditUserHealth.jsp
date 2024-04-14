<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>HealthCareApp</title>
    <link rel="stylesheet" href="./css/profileEditUserHealth.css">
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
  	<!-- 健康情報の修正 -->
<h2>健康情報の修正</h2>
<form action="ProfileHealthInfoUpdate" method="post">
<p>身長 <input id="height" type="text" name="height" class = "text"> cm</p>
<p>体重 <input id="weight" type="text" name="weight" class = "text"> kg</p>
<p>血圧 <input id="bloodPressure" type="text" name="bloodPressure" class = "text"> kPa</p>
<p>睡眠 <input id="sleepTime" type="text" name="sleepTime" class = "text"> hours</p>

<div class = "submit-button">
	<input type="submit" value="登録" class = "button">
</div>
</form>
<!-- プロフィールに戻る -->

<form action="ProfileConfirm" method="get">
<div class = "submit-button">
  <input type="submit" value="プロフィールに戻る" class = "button">
</div>
</form>
  </main>
<footer>
		<p>© HealthCareApp</p>
</footer>

</body>
</html>