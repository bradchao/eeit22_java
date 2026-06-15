<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="jakarta.tags.core" prefix="c" %>  
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Insert title here</title>
	</head>
	<body>
		<c:set var="x" value="10"></c:set>
		x = ${x }<br />
		<c:set var="x" value="100" scope="request"></c:set>
		request x = ${requestScope.x }<br />
		<c:set var="y">3</c:set>
		y = ${y }<hr />
		<c:out value="Hello, World"></c:out><br />
		param.x = ${param.x }<br />
		param.x = <c:out value="${param.x }" default="0"></c:out>
		
	</body>
</html>