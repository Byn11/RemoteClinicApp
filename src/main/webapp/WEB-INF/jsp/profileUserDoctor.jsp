<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	Doctor doctor = (Doctor)request.getAttribute("user");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>HealtCareApp</title>
</head>
<body>
<!-- 医者用プロフィール画面 -->
<h2>基本情報</h2>
<!-- 写真のgetterが不明 -->
<p>
写真
<%= doctor.get() %>
</p>
<p>
名前
<%= doctor.getName() %>
</p>
<p>
生年月日
<%= doctor.getBirthday() %>
</p>
<p>
メールアドレス
<%= doctor.getMailAddress() %>
</p>
<p>
住所
<%= doctor.getAddress() %>
</p>
<p>
診療料 <!-- ↓getter名称が分からない -->
<%= doctor.get() %>
</p>
<form action = "profileEditDoctor" method="post">
<input type="submit" value="基本情報修正">
</form>
<h2>口座情報</h2>
<p>
口座
<%= doctor.getAccount() %>
</p>
<form action = "AccountRegister" method="post">
<input type="submit" value="口座登録">
</body>
</html>