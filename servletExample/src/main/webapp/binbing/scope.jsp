<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<meta name="viewport" content="width=device-width, initial-scale=1.0">		
		<title>scope - scope.jsp</title>
		
		<link href="/servletExample/image/icon.png" rel="icon" type="image/x-icon" />
	<body>
		<%
		String contextMsg = (String) application.getAttribute("context");
		String sessionMsg = (String) session.getAttribute("session");
		String requestMsg = (String) request.getAttribute("request");
		%>
		<div>context값 : <%= contextMsg %></div>
		<div>session값 : <%= sessionMsg %></div>
		<div>request값 : <%= requestMsg %></div>
	</body>
</html>