package com.jdbc;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.subject.SubjectDAO;
import com.subject.SubjectVO;

@WebServlet("/listView")
public class SubjectServlet2 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		
		SubjectDAO dao = new SubjectDAO();
		ArrayList<SubjectVO> list = dao.getSubjectTotal();
		int counter = list.size();
		
		out.println("<!DOCTYPE html><html>");
		out.println("<head><meta charset='UTF-8' />");
		out.println("<title>학과 리스트 예제</title>");
		out.println("<link rel='stylesheet' href='https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/css/bootstrap.min.css' />");
		out.println("<link rel='icon' href='data:,'>");
		out.println("</head>");
		out.println("<body>");
		out.println("<div class='container'>");
		out.println("<h3 class='text-center'>학과 리스트</h3>");
		out.println("<table class='table'>");
		out.println("<thead class='text-center'>");
		out.println("<tr>");
		out.println("<th>일련번호</th>");
		out.println("<th>학과번호</th>");
		out.println("<th>학과명</th>");
		out.println("</tr>");
		out.println("</thead>");
		out.println("<tbody class='text-center'>");
		if (counter > 0) { 
			for( SubjectVO svo : list ) {
				out.print("<tr>");
				out.print("<td>"+ svo.getNo()+"</td>");
				out.print("<td>"+ svo.getSubjectNumber()+"</td>");
				out.print("<td>"+ svo.getSubjectName()+"</td>");
				out.print("</tr>"); 
			}
		} 
		out.println("</tbody></table>");
		out.println("</body></html>");
		out.close();
	}

}