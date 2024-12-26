<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.ArrayList, com.books.BooksVO" %>
<%	
	@SuppressWarnings("unchecked")
	ArrayList<BooksVO> list = (ArrayList<BooksVO>)request.getAttribute("list");
	int counter = (list != null) ? list.size() : 0;
%>
<!DOCTYPE html>
<html lang="ko">
<head>
	<meta charset="UTF-8" />
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>책 정보 리스트</title>

    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/css/bootstrap.min.css" >
    <script src="/servletExample/js/jquery-3.7.1.min.js"></script>
</head>
<body>
    <h1>책 정보 리스트</h1>
    <div>
	    <table class="table table-striped">
	        <thead>
	            <tr class="text-center">
	                <th>책 번호</th>
	                <th>책 제목</th>
	                <th>출판사</th>
	                <th>출간 연도</th>
	                <th>책 가격</th>
	            </tr>
	        </thead>
	        <tbody>
	            <%-- 서버에서 전달받은 책 데이터를 반복문으로 출력 --%>
				<% if (counter > 0) { 
					for( BooksVO book : list ) {
				%>
	            <tr class="text-center">
	                <td><%= book.getBook_id() %></td>
	                <td class="text-start"><%= book.getTitle() %></td>
	                <td><%= book.getPublisher() %></td>
	                <td><%= book.getYear() %></td>
	                <td><%= book.getPrice() %></td>
	            </tr>
	            <%
	                    }
	                } else {
	            %>
	            <tr>
	                <td colspan="5">조회된 책이 없습니다.</td>
	            </tr>
	            <%
	                }
	            %>
	        </tbody>
	    </table>
    </div>
    <p>조회된 책은 <%= counter %>권입니다.</p>
</body>
</html>
