function validatePasswords(event) {
	event.preventDefault(); // フォームのデフォルトの送信を防止

	var password = document.getElementById('password').value;
	var repassword = document.getElementById('repassword').value;
	var errorSpan = document.getElementById('password-error');

	if (password !== repassword) {
		errorSpan.textContent = "パスワードが一致しません";
		errorSpan.style.display = "block";
	} else {
		document.getElementById('register-form').submit();
	}
}