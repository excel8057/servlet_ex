<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.ArrayList, com.subject.SubjectVO" %>
<%	
	@SuppressWarnings("unchecked")
	ArrayList<SubjectVO> list = (ArrayList<SubjectVO>)request.getAttribute("list");
	int counter = list.size();
	
	String word = request.getParameter("subjectName");
	if( word == null) word = "";
%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8" />
		<meta name="viewport" content="width=device-width, initial-scale=1.0">
		<title>subject 테이블 예제 : subjectList.jsp</title>		
		<link href="/servletExample/image/icon.png" rel="icon" type="image/x-icon" />
		
		<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/css/bootstrap.min.css" >
		
		<script src="/servletExample/js/jquery-3.7.1.min.js"></script>
		<%-- request.getContextPath() 현재 프로젝트의 Context명을 반환. 즉 /servletExample 
		<script>
			$(function(){
				// 학과 정보 등록 버튼 제어 
				$("#subjectInsert").on("click", ()=>{
					location.href="<%=request.getContextPath()%>/subject/subjectForm.jsp";
				});
			});
		</script> --%>
	</head>
	<body>

		<div class="container">
			<h3> 테이블 subject 학과 정보 조회 </h3>
			<hr />
				<form id="search" >
					<div class="input-group">
						<input type="text" class="form-control" name="subjectName" id="name" placeholder="학과명 검색" aria-label="학과명 검색" maxlength="20" />
						<button class="btn btn-outline-secondary" type="button" id="searchBtn" >학과명 검색</button>
						<button class="btn btn-outline-secondary" type="button" id="searchAllBtn" >전체 검색</button>
					</div>
				</form>
			<div id="subjectList">
				<!-- <div class="text-end">
					<button type="button" id="subjectInsert" class="btn btn-success">학과정보등록</button>
				</div>  -->

				<table class="table table-striped">
					<thead>
						<tr class="text-center">
					        <th>번호</th>
							<th>학과번호</th>
							<th>학과명</th>
							<th>수정</th>
							<th>삭제</th> 
					    </tr>
					</thead>
					<tbody>	
					<% if (counter > 0) { 
						for( SubjectVO sub : list ) {
					%>
						    <tr class="text-center" data-no="<%= sub.getNo() %>">
						    	<td><%= sub.getNo()%></td>
						        <td><%= sub.getSubjectNumber()%></td>
		       					<td><%= sub.getSubjectName() %></td>
		       					<td><button type="button" class="updateBtn btn btn-outline-success btn-sm">수정</button></td>
		       					<td><button type="button" class="deleteBtn btn btn-outline-success btn-sm">삭제</button></td>
		       					
						    </tr>
					<%
						}
					   } else{
					%>
							<tr>
								<td colspan="5" class="text-center">
									조회된 학과 정보가 존재하지 않습니다.
								</td>
							</tr>
					<% } %>
					</tbody>
				</table>
				<div class="text-end">
					조회된 학과 수는 <span id="counter"><%=counter%></span>입니다.
				</div>
			</div>

			<div id="subjectForm">
				<jsp:include page="subjectForm.jsp" />
			</div>
		</div>
	
		<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/js/bootstrap.bundle.min.js"></script>
		<script src="/servletExample/js/jquery-3.7.1.min.js"></script>
		<script src="/servletExample/js/common.js"></script>	
		<script src="/servletExample/js/subjectList.js"></script>
		<script>
			let keyword = "<%=word%>"
		</script>
	

	</body>
</html>