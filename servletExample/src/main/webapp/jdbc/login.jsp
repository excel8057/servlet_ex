<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
	<head>
		<meta charset="UTF-8">
		<meta name="viewport" content="width=device-width, initial-scale=1.0">
		<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" />
		<title>Insert title here</title>
	</head>
	<body>
		<form id="login">
			<fieldset>
				<div>
					<label for="memberId">아이디</label>
					<input type="text" name="memberId" id="memberId" />
				</div>
				<div>
					<label for="memberPasswd">비밀번호</label>
					<input type="password" name="memberPasswd" id="memberPasswd" />
				</div>
				<div>
					<button type="button" id="loginBtn">로그인</button>
				</div>
			</fieldset>
		</form>
		
		<script src="/servletExample/js/jquery-3.7.1.min.js"></script>
		<script src="/servletExample/js/common.js"></script>
		<script src="/servletExample/js/login.js"></script>
	</body>
</html>