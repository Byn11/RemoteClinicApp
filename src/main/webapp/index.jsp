<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>HealthCareApp</title>
<link rel = "stylesheet" href="./css/index.css">
</head>

<body>
	<script type="text/javascript" src="./javascript/index.js"></script>
<header>
	<img class = "application_icon" src="./img/application_icon.png" >
</header>
<main>
  <h2>HealthCareAppにログイン</h2>
  <div class="login-container">
  	<form action="Login" method="post">
	  <span class = "hidden-msg">${msg}</span><br>
        <div class = "text-type">
	       <input type="text" id="username" name="id" placeholder="ユーザIDの入力">
	       <input type="password" id="password" name="pswd" placeholder="パスワードの入力">
	    </div>
		<div class = "radio-type">
			<input type="radio" name="type" value="User"> 一般ユーザー
			<input type="radio" name="type" value="Doctor"> 医者
			<input type="radio" name="type" value="Admin"> 管理者<br>
		</div>
      <input type="submit" class="login-button" value = "ログイン"><br>
    </form>
      <div class = "message">
		  アカウントを持っていませんか？<br>
	  </div>
	  <div class = "account-create"> 
		  <a href="memberRegisterUser.jsp">一般用アカウントを作成</a>
	  	  <a href="MemberRegisterConfirm?type=doctor_prepare" onclick="submitAction()">医者用アカウントを作成</a>
	  </div>
	  
  </div>
</main>
</body>
</html>
