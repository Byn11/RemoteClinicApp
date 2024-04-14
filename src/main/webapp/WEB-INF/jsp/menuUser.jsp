<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>HealthCareApp</title>
<link rel = "stylesheet" href="./css/menuUser.css">
</head>

<body>
  <script type="text/javascript" src="./javascript/menuUser.js"></script>
  <header>
		<h1>HealthCareApp</h1>
 	  	<!-- プロフィールのコンテンツ -->	
  </header>
  
  <main>
	  <h2>HealthCareAppへようこそ!</h2>
	  <h3>このアプリでは、医師に自分の症状を質問し、回答を得る事ができます</h3>
	  <div class="button-container">
		  
	      <form action="QuestionConfirm" method = "get">
		  <input type = "submit" value = "質問する" class = "button" onmouseover="showText1()" onmouseout="hideText1()">
		  <p id="output1" class = "output"></p>
		  </form>
	
		  <form action="QuestionHistory" method = "get">
		  <input type = "submit" value = "質問履歴" class = "button" onmouseover="showText2()" onmouseout="hideText2()">
		  <p id="output2" class = "output"></p>
		  </form>
	
		  <form action="DoctorList" method = "get" >
		  <input type = "submit" value = "医者一覧" class = "button" onmouseover="showText3()" onmouseout="hideText3()">
		  <p id="output3" class = "output"></p>
		  </form>
		  
		  <form action="ProfileConfirm" method = "get" >
		  <input type = "submit" value = "プロフィール" class = "button" onmouseover="showText4()" onmouseout="hideText4()">
		  <p id = "output4" class = "output"></p>
		  
		</form>
	  </div>
  </main>
  <footer>
    <p>© HealthCareApp</p>
  </footer>

</body>
</html>