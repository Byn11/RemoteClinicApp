<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>HealthCareApp</title>
</head>
<body>
<h1>口座登録</h1>
<form action="accountRegister" method="post">
<p>銀行名</p>
<select name="bankName">
<option value="bankYutyo">ゆうちょ銀行</option>
<option value="bankUfj">三菱UFJ銀行</option>
<option value="bankMizuho">みずほ銀行</option>
<option value="bankMitsui">三井住友銀行</option>
</select>
<p>支店番号</p><input id="branchNumber" type="text" name="branchNumber">
<p>預金種類</p>
<select name="accountType">
<option value="touza">当座</option>
<option value="hutsu">普通</option>
</select>
<p>口座番号</p><input id="accountNumber" type="text" name="accountNumber">
<p>口座名義</p><input id="accountName" type="text" name="accountName">
<input type="submit" value="登録">
</form>
<a href="profileDoctor.jsp" value="キャンセル"></a>
</body>
</html>