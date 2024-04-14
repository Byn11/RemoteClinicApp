<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>HealthCareApp</title>
    <link rel="stylesheet" href="./css/profileEditUser.css">
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
<h2>基本情報の修正</h2>
<form action="ProfileUserUpdate" method="post">
<p>名前 <input id="name" type="text" name="name" class = "text"></p>
<p>生年月日
<select name="year">
<%
	int N=1900;
	int[] num= new int[1000];
	for(int i=0;i+N<2023;i++){
		num[i]=i+N;
	
%>
	<option value="<%= num[i] %>"><%= num[i] %></option>
<%
	}
%>
</select>
年
<!-- 月 -->
<select name="month">
<%
	for(int i=1;i<13;i++){
		
%>
	<option value="<%= i %>"><%= i %></option>
<%
	}
%>
</select>
月
<!-- 日 -->
<select name="day">
<%
	for(int i=1;i<32;i++){
		
%>
	<option value="<%= i %>"><%= i %></option>
<%
	}
%>
</select>
日
</p>
<p>電話番号 <input id="telephone" type="text" name="telephone" class = "text"></p>
<p>メールアドレス <input id="mailAddress" type="text" name="mailAddress" class = "text"></p>
<p>住所 <input id="adress" type="text" name="address" class = "text"></p>

<div class = "submit-button">
  <div class = "submit-buttons">
	<input type="submit" value="登録する" class = "button">
  </div>	
</div>
</form>


<form action="ProfileConfirm" method="get">
	<div class = "submit-button">
	  <div class = "submit-buttons">
		<input type="submit" value="プロフィールに戻る" class = "button">
	  </div>
	</div>
</form>
</main>
<footer>
    <p>© HealthCareApp</p>
 </footer>
</body>
</html>