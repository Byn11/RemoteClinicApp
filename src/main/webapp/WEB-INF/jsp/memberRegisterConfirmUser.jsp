<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>HealthCareApp</title>
<link rel = "stylesheet" href="./css/memberRegisterConfirmUser.css">
</head>
<body>
	<script type="text/javascript" src="./javascript/memberRegisterConfirmUser.js"></script>
	<header>
		<h1>HealthCareApp</h1>
 	  	<!-- プロフィールのコンテンツ -->	
  </header>
	
	<main>
	  <div class = "main-container">
		<h2>登録情報の確認</h2>
		<form action="MemberRegisterResult?type=resultU" method="post">
			<div class = "container">
			    <div class = "user-name">	
					<p>名前：<%= request.getParameter("name") %></p>
				</div>
				<div class = "user-password">
					<p>パスワード：<%= request.getParameter("password")%></p>
				</div>
			    <div class = "gender">
					<p>性別：<%= request.getParameter("gender") %></p>
			    </div>
			    <div class = "birthday">
					<p>生年月日：<%= request.getParameter("birthday") %></p>
			    </div>
			    <div class = "phone">
					<p>電話番号：<%= request.getParameter("telphone") %></p>
			    </div>
			    <div class = "mail">
					<p>メールアドレス：<%= request.getParameter("emailAddress") %></p>
			    </div>
			    <div class = "address">
					<p>住所：<%= request.getParameter("address") %></p>
			    </div>
			</div>
		
			<div class = "submit-button">
				<input type="submit" value="送信する" class = "button submit">
			</div>
		</form>
		<div class = "submit-button">
			<a href="memberRegisterUser.jsp" class = "submit_button submit">戻る</a>
		</div>
	  </div>
	</main>
	
	<footer>
		<p>© HealthCareApp</p>
	</footer>
</body>
</html>