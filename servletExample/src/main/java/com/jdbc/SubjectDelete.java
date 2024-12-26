package com.jdbc;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.subject.SubjectDAO;
import com.subject.SubjectVO;


/**
 * Servlet implementation class SubjectDelete
 */
@WebServlet("/delete")
public class SubjectDelete extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
		SubjectVO vo = new SubjectVO();
		//vo.setNo(Integer.parseInt(request.getParameter("no")));
		vo.setSubjectNumber(request.getParameter("subjectNumber"));
		
		SubjectDAO dao = new SubjectDAO();
		boolean result = dao.subjectDelete(vo);
		
		if(result) {
			response.sendRedirect("/servletExample/list");
		} else {
			request.setAttribute("message", "학과 삭제 실패!");
			RequestDispatcher dispatcher = request.getRequestDispatcher("error/error.jsp");
			dispatcher.forward(request, response);
		}	
	}
}