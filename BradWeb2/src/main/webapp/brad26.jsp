<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String mesg = "";
	String errType = request.getParameter("errType");
	if(errType != null){
		if (errType.equals("1")){
			mesg = "Register Failure";
		}
	}
%>    
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Insert title here</title>
	</head>
	<body>
		<h1>Register Page</h1>
		<hr />
		<div><%= mesg %></div>
		<form action="Register" method="post">
			Account: <input name="account" /><br />
			Password: <input type="password" name="passwd" /><br />
			<input type="submit" value="Register" />
		</form>
	</body>
</html>