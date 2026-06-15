<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="jakarta.tags.core" prefix="c" %>  
<%@ taglib uri="jakarta.tags.sql" prefix="sql" %>    
<c:catch var="err">
	<c:import url="https://data.moa.gov.tw/Service/OpenData/ODwsv/ODwsvAgriculturalProduce.aspx" var="data"></c:import>


	<sql:setDataSource
		driver="com.mysql.cj.jdbc.Driver"
		url="jdbc:mysql://localhost:3306/brad"
		user="root"
		password="root"
	/>
	<c:forEach items="" var="">
		<sql:update
			INSERT INTO gift
				(name,city,town,addr,tel,picurl)
			VALUES 
				(?,?,?,?,?,?)
		 />
	</c:forEach>
</c:catch>

