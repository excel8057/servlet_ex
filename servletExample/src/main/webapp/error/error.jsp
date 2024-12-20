<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<meta name="viewport" content="width=device-width, initial-scale=1.0">	
		<title>subject 테이블 예제 : error.jsp</title>
		
		<link href="/servletExample/image/icon.png" rel="icon" type="image/x-icon" />
		<style type="text/css">
			a{text-decoration: none;}
		</style>
	</head>
	<body>
		<div>
			<%= (String)request.getAttribute("message") %>
		</div>
		<div>
			<a href="/servletExample/list">리스트로 이동</a>
		</div>
		
	</body>
</html>