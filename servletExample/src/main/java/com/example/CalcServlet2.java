package com.example;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/* [요구사항]
 * +, -, *, / 연산의 결과를 반환하는 클래스(Calc) 생성. 
 * result 필드 생성하여. 생성자 통해서 결과 얻고, getResult()로 결과 반환. 
 * */
@WebServlet("/calcServlet2")
public class CalcServlet2 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 변수선언
		int  num1,num2;
		int result;
		String op;
			
		response.setContentType("text/plain; charset=UTF-8");
		PrintWriter out = response.getWriter();

		num1 = Integer.parseInt(request.getParameter("num1"));
		num2 = Integer.parseInt(request.getParameter("num2"));
		op = request.getParameter("operator");
			
		Calc calc = new Calc(num1, num2, op);
		result = calc.getResult();

		out.print(result);
		out.close();
	}
}