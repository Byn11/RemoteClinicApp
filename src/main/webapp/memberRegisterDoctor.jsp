<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="entity.Clinic,java.util.List" %>
<%
List<Clinic> clinic_list = (List<Clinic>)request.getAttribute("clinic_list");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>HealthCareApp</title>
<link rel="stylesheet" href="./css/memberRegisterUser.css">
<script type="text/javascript" src="./javascript/memberRegisterUser.js"></script>
</head>
<body>
<header>
	<h1>HealthCareApp</h1>
	<!-- プロフィールのコンテンツ -->
</header>

<main>
	<h1>会員登録画面</h1>

	<form id="register-form" action="MemberRegisterConfirm?type=doctor" method="post" enctype="multipart/form-data">
		<div class="form-group">
			<label for="name">名前</label>
			<input type="text" id="name" name="name" required>
		</div>
		<div class="form-group">
			<label for="password">パスワード</label>
			<input type="password" id="password" name="password" required>
		</div>
		<div class="form-group">
			<label for="repassword">パスワード(確認)</label>
			<input type="password" id="repassword" name="rePassword" required>
		</div>
		<span id="password-error" class="error-message"></span>
		<div class="form-group">
			<label for="gender">性別</label>
			<select name="gender" name="gender" required>
				<option value="男性">男性</option>
				<option value="女性">女性</option>
			</select>
		</div>
		<div class="form-group">
			<label for="birthday">生年月日</label>
			<input type="date" id="birthday" min="1900-01-01" max="2023-01-01" name="birthday" required>
		</div>
		<div class="form-group">
			<label for="telphone">電話番号</label>
			<input type="text" id="telphone" name="telphone" placeholder="ハイフンなし" required>
		</div>
		<div class="form-group">
			<label for="emailAddress">メールアドレス</label>
			<input type="email" id="emailAddress" name="emailAddress" required>
		</div>
		<div class="form-group">
			<label for="address">住所</label>
			<input type="text" id="address" name="address" required>
		</div>
		<div class = "form-group">
			<p>診療科</p>
				<% for(Clinic clinic : clinic_list){%>
				<input type="checkbox" name="clinicalDepartment" value="<%= clinic.getClinicDepartmentId()%>"> <%=clinic.getClinicDepartmentName() %>
				<% } %>
			<p>身分証</p><input type="file" name="urlPhotoForAuthentication">
		</div>
		<div class="submit_button">
			<input type="submit" value="次へ" class="button submit" onclick="validatePasswords(event)">
		</div>
	</form>
	<a href="index.jsp" class="submit_button submit">戻る</a>
</main>

<footer>
	<p>© HealthCareApp</p>
</footer>

</body>
</html>