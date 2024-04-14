function submitAction() {
	  event.preventDefault();

	  var form = document.createElement('form');
	  form.method = 'post';
	  form.action = 'MemberRegisterConfirm'; 

	  var input = document.createElement('input');
	  input.type = 'hidden';
	  input.name = 'type';
	  input.value = 'doctor_prepare';

	  form.appendChild(input);

	  document.body.appendChild(form);

	  form.submit();
	}