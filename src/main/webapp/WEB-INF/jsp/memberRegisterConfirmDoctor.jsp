<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="entity.Clinic,java.util.List" %>
<%
String filename = (String)session.getAttribute("filename");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>会員登録確認</title>
</head>
<body>
<h1>会員登録確認画面</h1>

<form action="MemberRegisterResult?type=resultD" method="post">
<p>名前<p><%= request.getParameter("name") %>
<p>パスワード</p><%= request.getParameter("password")  %>
<p>パスワード(確認)</p><%= request.getParameter("rePassword") %>
<p>生年月日</p><%= request.getParameter("birthday") %>
<p>電話番号</p><%= request.getParameter("telphone") %>
<p>メールアドレス</p><%= request.getParameter("emailAddress") %>
<p>住所</p><%= request.getParameter("address") %>
<p>診療科</p>
	<% 
		List<Clinic> clinicList = (List<Clinic>)session.getAttribute("clinicalDepartment");
	%>
<% for(Clinic clinic : clinicList){%>
<%= clinic.getClinicDepartmentName() %>
	<% } %>

	
<p>身分証</p>
<img src="image/<%=filename %>">

<input type="submit" value="次へ">
</form>
<a href="memberRegisterDoctor.jsp" value="戻る"></a>
</body>
</html>