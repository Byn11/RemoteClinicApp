<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>HealthCareApp</title>
<link rel = "stylesheet" href="./css/menuDoctor.css">
</head>

<body>
  <script type="text/javascript" src="./javascript/menuDoctor.js"></script>
  <header>
		<h1>HealthCareApp</h1>
 	  	<!-- プロフィールのコンテンツ -->	
  </header>
  
  <main>
	  <h2>HealthCareAppへようこそ!</h2>
	  <h3>このアプリでは、質問者が抱える症状についてオンラインで回答ができます</h3>
	  <div class="button-container">
		  
	      <form action="Profile" method = "get">
		  <input type = "submit" value = "プロフィール" class = "button" onmouseover="showText1()" onmouseout="hideText1()">
		  <p id="output1" class = "output"></p>
		  </form>
	
		  <form action="QuestionAnswerList" method = "get">
		  <input type = "submit" value = "回答履歴" class = "button" onmouseover="showText2()" onmouseout="hideText2()">
		  <p id="output2" class = "output"></p>
		  </form>
	
		  <form action="QuestionList" method = "get">
		  <input type = "submit" value = "質問一覧" class = "button" onmouseover="showText3()" onmouseout="hideText3()">
		  <p id="output3" class = "output"></p>
		  </form>
	  </div>
  </main>
  <footer>
    <p>© HealthCareApp</p>
  </footer>

</body>
</html>