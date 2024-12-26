package com.jdbc;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.member.MemberDTO;

@WebServlet("/loginInfo")
public class MemberLoginInfoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html; charset=UTF-8");
		RequestDispatcher dispatcher = request.getRequestDispatcher("jdbc/loginInfo.jsp");
		dispatcher.forward(request, response);
	}
	// 로그인 후 정보 보여주기
	/*
	 * public void doGet(HttpServletRequest request, HttpServletResponse response)
	 * throws ServletException, IOException {
	 * response.setContentType("text/html; charset=UTF-8"); PrintWriter out =
	 * response.getWriter();
	 * 
	 * HttpSession session = request.getSession(false); MemberDTO dto =
	 * (MemberDTO)session.getAttribute("login");
	 * 
	 * out.println("<!DOCTYPE html><html>");
	 * out.println("<head><meta charset='UTF-8' />");
	 * out.println("<title>로그인 예제</title>");
	 * out.println("<link rel='icon' href='data:,'>"); out.println("</head><body>");
	 * 
	 * if(dto != null) { out.println("<div><table border='1'>");
	 * out.println("<tr><th colspan='2'>세션에 저장된 정보 얻기</th></tr>");
	 * out.println("<tr>"); out.println("<td>아이디</td>"); out.println("<td>" +
	 * dto.getMemberId() + "</td>"); out.println("</tr>"); out.println("<tr>");
	 * out.println("<td>이름</td>"); out.println("<td>" + dto.getMemberName() +
	 * "</td>"); out.println("</tr>"); out.println("<tr>");
	 * out.println("<td>이메일</td>"); out.println("<td>" + dto.getMemberEmail() +
	 * "</td>"); out.println("</tr>"); out.println("</table");
	 * out.println("</div>");
	 * 
	 * out.println("<div>");
	 * out.println("<a href='/servletExample/logout'>로그아웃</a>");
	 * out.println("</div>");
	 * 
	 * } else { out.print("<div>로그인 상태가 아닙니다.<br /> 로그인부터 다시 진행해 주세요.</div>"); out.
	 * print("<div><a href='/servletExample/jdbc/login.jsp'>로그인 화면으로 이동하기</a></div>"
	 * ); }
	 * 
	 * out.println("</body></html>"); out.close(); }
	 */
}