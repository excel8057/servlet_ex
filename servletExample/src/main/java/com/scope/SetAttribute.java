package com.scope;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/setAttribute")
public class SetAttribute extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html; charset=utf-8");
		PrintWriter out = response.getWriter();
		
		String ctxMsg = "context에 바인딩됩니다.";
		String sesMsg = "session에 바인딩됩니다.";
		String reqMsg = "request에 바인딩됩니다.";

		ServletContext application = getServletContext();
		application.setAttribute("context", ctxMsg);
		
		HttpSession session = request.getSession();
		session.setAttribute("session", sesMsg);
		
		request.setAttribute("request", reqMsg);
		
		// 바인딩이란 웹 프로그램 실행 시 자원(데이터)를 서블릿 관련 객체에 저장하는 방법.
		// 목적은 서블릿에서 다른 서블릿(JSP)로 데이터를 공유하거나 전달하고자 할 때.
		

		RequestDispatcher dispatch = request.getRequestDispatcher("getAttribute");  
        // 위 코드 확인 후 주석처리. 그리고 아래 코드 작성
        //RequestDispatcher dispatch = request.getRequestDispatcher("binding/scope.jsp");
	    dispatch.forward(request, response);
	    
	    out.close();
	}

}