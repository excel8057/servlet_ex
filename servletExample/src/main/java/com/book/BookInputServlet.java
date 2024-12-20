package com.book;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/bookInput")
public class BookInputServlet extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    request.setCharacterEncoding("UTF-8"); // 요청 데이터의 문자 인코딩 설정
	    response.setContentType("text/html;charset=UTF-8"); // 응답 데이터의 문자 인코딩 설정

	    String title = request.getParameter("title");
	    String author = request.getParameter("author");
	    String publisher = request.getParameter("publisher");

	    request.setAttribute("title", title);
	    request.setAttribute("author", author);
	    request.setAttribute("publisher", publisher);

	    RequestDispatcher dispatcher = request.getRequestDispatcher("/bookOutput");
	    dispatcher.forward(request, response);
	}
}