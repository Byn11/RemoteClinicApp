<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ page import = "entity.Doctor, entity.Clinic , java.util.List" %>
    
<%  
    //リクエストスコープに保存されたつぶやきリストを取得
	List<Doctor> doctorList = (List<Doctor>)request.getAttribute("doctorList");

%>


<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel = "stylesheet" href="./css/doctorList.css">
</head>
<body>
	<header>
		<h1>HealthCareApp</h1>
 	  	<!-- プロフィールのコンテンツ -->
 	  	<div class = "header-contents"> 
 	  	   <form action="ReturnMenu" method = "get">
			<input type = "submit" value = "TOPに戻る" class = "top">
 	  	   </form>  
 	  	</div> 	
  </header>
	<main>
		<div class="container">
	  		<% for (Doctor doctor : doctorList) { %>
	    	<div class="doctor-card">
	    		<img src="image/<%= doctor.geturlPhotoForAuthentication() %>" alt="Doctor Photo">
	    		<div class="info">
	    			<h2><%= doctor.getName() %></h2>
	    			<% for (Clinic clinic : doctor.getClinicalDepartment()) { %>
      					<p><%= clinic.getClinicDepartmentName() %></p>
    				<% } %>
	    		</div>
	    	</div>
	  		<% } %>
  		
	  		<div class="submit-button">
		  		<form action="ReturnMenu" method="get">
		    	   <input type="submit" value="戻る" class = "button">
		  		</form>
	  		</div>
		</div>
	</main>
	<footer>
		<p>© HealthCareApp</p>
	</footer>
</body>
</html>