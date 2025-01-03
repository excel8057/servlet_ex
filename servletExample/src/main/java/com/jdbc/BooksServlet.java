package com.jdbc;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.books.BooksDAO;
import com.books.BooksVO;

/**
 * Servlet implementation class BooksServlet
 */
@WebServlet("/booksList")
public class BooksServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BooksServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		BooksDAO dao = new BooksDAO();
		ArrayList<BooksVO> list = dao.getBooksTotal();
		
		request.setAttribute("list", list);
		RequestDispatcher dispatcher = request.getRequestDispatcher("books/BooksList.jsp");
		dispatcher.forward(request, response);
	}

}
