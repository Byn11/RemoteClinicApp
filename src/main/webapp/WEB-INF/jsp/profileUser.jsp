<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="entity.User, dao.HealthInfoDAO, entity.HealthInfo, 
	entity.CreditCard, dao.CreditCardDAO, java.util.List,
	java.text.SimpleDateFormat, java.util.Date " %>
<%
	//sessionに保存したHealthInfoとuserIdを取り出す
	HealthInfo healthInfo = (HealthInfo)session.getAttribute("healthInfo");
	
	User user = (User)session.getAttribute("user");//User情報をsessionに保存されている
	int userId = user.getId();
	List<HealthInfo> healthInfoList = (List<HealthInfo>)session.getAttribute("healthInfoList");
	SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		
	CreditCardDAO cardDao = new CreditCardDAO();
	CreditCard creditCard = cardDao.selectById(userId);
	
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>HealthCareApp</title>
<link rel="stylesheet" href="./css/profileUser.css">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.3/css/all.min.css">
<style>
    table {
        border-collapse: collapse; 
    }
    
    th, td {
        border: 1px solid black; 
        padding: 8px; 
    }
</style>
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
		<div class="main-container">
		    <div class = "info">	
				<h2>基本情報</h2>
				<p>
					名前：<%= user.getName() %>
				</p>
				<p>
					生年月日：<%= user.getBirthday() %>
				</p>
				<p>
					メールアドレス：<%= user.getEmailAddress() %>
				</p>
				<p>
					住所：<%= user.getAddress() %>
				</p>
				<form action="ProfileEditUser" method="get">
					<div class="submit-button">
						<input type="submit" value="基本情報修正" class="button">
					</div>
				</form>
		    </div>
		    <div class = "info">
				<h2>健康情報</h2>
				<%
				if (healthInfoList.size() == 0) {
				%>
				    <p>健康情報が登録されていません</p>
				<%
				} else {				
				%>
				<p>
					<table>
						<tr>
							<th>日付 </th>
							<th>身長(cm)) </th>
							<th>体重(kg)) </th>
							<th>血圧 (kPa)</th>
							<th>睡眠(hours)</th>
						</tr>
						<tr>
							<%for(HealthInfo info : healthInfoList){%>
								<tr>
									<td><%= dateFormat.format(info.getUpdateData()) %>  </td>
									<td><%= info.getHeight() %>  </td>
									<td><%= info.getWeight() %>  </td>
									<td><%= info.getBloodPressure() %>  </td>
									<td><%= info.getSleepTime() %>  </td>	
								</tr>			
							<% } %>
						</tr>
					</table>
					<%
					}
					%>
					<form action="ProfileEditUserHealth" method="get">
					<div class="submit-button">
						<input type="submit" value="健康情報登録" class="button">
					</div>
					</form>
			</div>	
			<div class = "info">
				<h2>支払い情報</h2>
				<%
				if(creditCard.getCreditCardNumber() == 0){
				%>
				<p>クレジットカードが登録されていません</p>
				<form action = "CreditCardForwardToEdit" method="post">
				<input type="submit" value="クレジットカード登録" class = "button">
				</form>
				<%
				}else{
				%>
				<p>
				クレジットカード番号：<%= creditCard.getCreditCardNumber() %>
				</p>
				<%
				}
				%>
				<form action="ReturnMenu" method="get">
				<div class="submit-button">
					<input type="submit" value="メニューに戻る" class="button">
				</div>
				</form>
			</div>	
		</div>
	</main>
	<footer>
			<p>© HealthCareApp</p>
	</footer>
</body>

</html>

