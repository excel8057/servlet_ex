package com.jdbc;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

import com.member.MemberDAO;
import com.member.MemberDTO;

@WebServlet("/login")
public class MemberLogInServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	// 로그인 처리
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = response.getWriter();
		
		String memberId = request.getParameter("memberId");
		String memberPasswd = request.getParameter("memberPasswd");

		HttpSession session = request.getSession(); // 세션 객체 생성
		
		MemberDTO dto = new MemberDTO();
		dto.setMemberId(memberId);
		dto.setMemberPasswd(memberPasswd);
		
		MemberDAO dao = new MemberDAO();
		MemberDTO memberDTO = dao.login(dto); 
		// 로그인 처리를 위한 메서드 호출. 아이디와 비밀번호 일치 시 MemberDTO의 인스턴스 값 반환. 일치하지 않을 시 null 반환.
		
		StringBuffer message = new StringBuffer();
		
		if(memberDTO != null){ // 로그인 성공 시 
			/* 로그인 정보를 개별적으로 설정 
			session.setAttribute("memberId", memberDTO.getMemberId());
			session.setAttribute("memberName", memberDTO.getMemberName()); */
			// 세션 객체 속성 설정. MemberDTO 자체를 속성으로 저장. 추후 필요한 필드값만 접근(반환)
			session.setAttribute("login", memberDTO); 
			// context path를 확인. /loginInfo 매핑으로 서블릿 생성.
			message.append("<div><a href='/servletExample/loginInfo'>로그인 정보 확인하기</a></div>");
  		} else{ // 로그인 실패 시
  			message.append("<div>아이디 또는 비밀번호가 일치하지 않습니다.</div>");
			message.append("<div><a href='#' onclick='history.back()'>이전 화면으로</a></div>");
  		}
		
		out.println("<!DOCTYPE html><html>");
		out.println("<head><meta charset='UTF-8' />");
		out.println("<title>로그인 예제</title>");
		out.println("<link rel='icon' href='data:,'>");
		out.println("</head><body>");
		// 정상적으로 로그인 되었을 때. 세션 객체의 속성으로 접근
		/*if(session.getAttribute("login") != null) { 
			out.print(((MemberDTO)session.getAttribute("login")).getMemberName()+"님 반갑습니다.");
		}*/
		
		// 정상적으로 로그인 되었을 때. 위와 같은 표현
		MemberDTO mDTO = (MemberDTO)session.getAttribute("login"); // 메서드의 반환형이 Object이기에 형변환이 필요.
		if(mDTO != null) {
			out.print(mDTO.getMemberName() + "님 반갑습니다.");
		}

		out.print(message.toString());
		out.println("</body></html>");
		out.close();
	}
}