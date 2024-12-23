package com.scope;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/getAttribute")
public class GetAttribute extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html; charset=utf-8");
		PrintWriter out = response.getWriter();
		
		ServletContext application = getServletContext();
		String contextMsg = (String) application.getAttribute("context");

		HttpSession session = request.getSession();
		String sessionMsg = (String) session.getAttribute("session");
		
		String requestMsg = (String) request.getAttribute("request");

	    out.println("<!DOCTYPE html><html>");
	    out.println("<head><meta charset='UTF-8' />");
	    out.println("<title>ServletContext 예제</title>");
	    out.println("<link rel='icon' href='data:,'></head>");
	    out.println("<body>");
	    
		out.println("<div>context값 : " + contextMsg + "</div>");
		out.println("<div>session값 : " + sessionMsg + "</div>");
		out.println("<div>request값 : " + requestMsg + "</div>");
		out.println("</body></html>");
	}
}