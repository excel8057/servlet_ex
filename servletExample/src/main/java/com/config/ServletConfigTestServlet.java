package com.config;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class ServletConfigTestServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String charset = getInitParameter("charset"); 
		request.setCharacterEncoding(charset);
		
		response.setContentType("text/html; charset=UTF-8");
		
		PrintWriter out = response.getWriter();
		
		out.println("<!DOCTYPE html><html><head><meta charset='UTF-8' />");
		out.println("<title> 서블릿 초기값 설정으로 인코딩 설정 </title>");
		out.println("<link rel='icon' href='data:,'></head>");
		out.print("<body><h3>서블릿 초기값으로 인코딩 설정한 후 결과 출력</h3>");
		out.print("<h4> 이름 :"+request.getParameter("name")+"</h4>");
		out.println("</body></html>");
		
		out.close();
	}
}