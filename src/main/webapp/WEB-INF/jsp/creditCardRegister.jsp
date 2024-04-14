<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="./css/creditCardRegister.css">
<title>HelthCareApp</title>
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
	<h1>クレジットカード登録</h1>
	<form action="CreditCardRegister" method="post"><br>
		<p>First Name<input id="firstName" type="text" name="firstName" class = "text"></p>
		<p>Last Name<input id="LastName" type="text" name="lastName" class = "text"></p>
		<p>カード番号 <input id="creditCardNumber" type="text" name="creditCardNumber" class = "text"></p>
		<p>カード有効期限
		<!-- 年 -->
		<select name="year">
		<%
			for(int i=2023;i<2033;i++){
				
		%>
			<option value="<%= i %>"><%= i %></option>
		<%
			}
		%>
		</select>
		<!-- 月 -->
		<select name="month">
		<%
			for(int i=1;i<13;i++){
				
		%>
			<option value="<%= i %>"><%= i %></option>
		<%
			}
		%>
		</select></p>
		<p>セキュリティコード<input id="securityCode" type="text" name="securityCode"></p>
		<div class = "submit-button">
		  <input type="submit" value="登録" class = "button">
		</div>
	</form>
	
	<!-- プロフィールに戻る -->
	<form action="ProfileConfirm" method="get">
	<div class = "submit-button">
	  <input type="submit" value="プロフィールに戻る" class = "button">
    </div>
   </main>
   	<footer>
    <p>© HealthCareApp</p>
 	</footer>
</body>
</html>