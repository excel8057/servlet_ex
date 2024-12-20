<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<% 
    String data = request.getParameter("score"); 
    int score = 0;
    String grade = "";

    if (data != null) {
        try {
            score = Integer.parseInt(data);
        } catch (NumberFormatException e) {
            score = -1; // 잘못된 점수 처리
        }

        // 학점 계산 로직
        if (score >= 90) {
            grade = "A";
        } else if (score >= 80) {
            grade = "B";
        } else if (score >= 70) {
            grade = "C";
        } else if (score >= 60) {
            grade = "D";
        } else if (score >= 0) {
            grade = "F";
        } else {
            grade = "잘못된 점수"; // 유효하지 않은 점수 입력 시
        }
    }
%>    

<!DOCTYPE html>
<html lang="ko">
	<head>
		<meta charset="UTF-8">
		<meta name="viewport" content="width=device-width, initial-scale=1.0">
		<title>학점 결과</title>
	</head>
	<body>
		<div>입력한 점수는 <%= score %>입니다.</div>
		<div>학점은 <%= grade %>입니다.</div>
	</body>
</html>
