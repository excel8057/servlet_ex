package com.example;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class HelloServlet
 */
//@WebServlet("/hello")
@WebServlet(name="helloServlet", value= {"/hello3", "/hello4"})
public class HelloServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	public HelloServlet() {
		System.out.println("===========> HelloServlet 객체 생성");
	}
 
	
	@Override
	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
		//super.init();
		System.out.println("============> init() 메서드 호출");
	}
 
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	//	response.getWriter().append("Served at: ").append(request.getContextPath());
		
		System.out.println("===========> doGet() 메서드 호출");
		
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = response.getWriter();
		out.println("<!DOCTYPE html><html>");
		out.println("<head><meta charset='UTF-8' />");
		out.println("<title>Servlet 예제</title>");
		out.println("<link rel='icon' href='data:,'></head>");
		out.println("<body><h1>Hello Servlet ~@</h1></body>");
		out.println("</html>");
		out.close();
	}

}