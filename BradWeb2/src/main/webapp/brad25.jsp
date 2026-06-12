<%@page import="java.io.BufferedReader"%>
<%@page import="org.json.*"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	BufferedReader reader = request.getReader();
	String line; StringBuffer sb = new StringBuffer();
	while ( (line = reader.readLine()) != null){
		sb.append(line);
	}
	String json = sb.toString();
	System.out.println(json);
	//----------------
	JSONObject root = new JSONObject(json);
	String op = root.getString("op");
	JSONObject params = root.getJSONObject("params");
	String x = params.getString("x");
	String y = params.getString("y");
	
	System.out.println(op + ":" + x + ":" + y);
	
	
%>