package com.example;

import java.io.*;
import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

@WebServlet("/portalSite")
public class SendRedirectTestServlet extends HttpServlet {
 
	private static final long serialVersionUID = 1653501095386225075L;
	
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String param = request.getParameter("site");
		
		if (param.equals("naver")) {
			response.sendRedirect("https://www.naver.com/");
		} else if (param.equals("daum")) {
			response.sendRedirect("https://www.daum.net/");
		} else if (param.equals("w3schools")) {
			response.sendRedirect("https://www.w3schools.com/");
		} else if (param.equals("google")) {
			response.sendRedirect("https://www.google.com/");
		}
	}
	
}