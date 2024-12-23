<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="com.member.MemberDTO"%>    
<% 	
	MemberDTO dto = (MemberDTO)session.getAttribute("login");  
%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<meta name="viewport" content="width=device-width, initial-scale=1.0">		
		<title>로그인 정보 출력</title>

		<link href="/servletExample/image/icon.png" rel="icon" type="image/x-icon" />
	</head>
	<body>
		<div class="container">	
			<% if(dto != null) {  %>
			<div>
				<table>
					<tr>
						<th colspan="2">세션에 저장된 정보 얻기</th>
					</tr>
					<tr>
						<td>아이디</td>
						<td><%=dto.getMemberId()%></td>
					</tr>
					<tr>
						<td>이름</td>
						<td><%=dto.getMemberName()%></td>
					</tr>
					<tr>
						<td>이메일</td>
						<td><%=dto.getMemberEmail()%></td>
					</tr>
				</table>
			</div>
			<div>
				<a href='/servletExample/logout'>로그아웃</a>
			</div>
			<% } else { %>
				<div>
					로그인 상태가 아닙니다.<br /> 로그인부터 다시 진행해 주세요.
				</div>
				<div>
					<a href='/servletExample/jdbc/login.jsp'>로그인 화면으로 이동하기</a>
				</div>
			<% } %>
		</div>
	</body>
</html>