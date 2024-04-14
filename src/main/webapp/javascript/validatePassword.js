function validatePassword() {
	  const password = document.getElementById('password').value;
	  const confirmPassword = document.getElementById('repassword').value;
	  const passwordMessage = document.getElementById('passwordMessage');

	  if (password !== confirmPassword) {
	    passwordMessage.textContent = 'パスワードが一致していません';
	    return false;
	  }

	  passwordMessage.textContent = ''; 
	  return true;
	}

