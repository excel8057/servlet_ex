package com.context;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/getContext")
public class GetServletContext extends HttpServlet{
	private static final long serialVersionUID = 1L;

	@SuppressWarnings("unchecked")
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws  ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		
		ServletContext context = getServletContext();				 
		List<String> member = (List<String>) context.getAttribute("member");
      
		out.println("<!DOCTYPE html><html>");
		out.println("<head><meta charset='UTF-8' />");
		out.println("<title>ServletContext 예제</title>");
		out.println("<link rel='icon' href='data:,'>");
		out.println("<style>");
		out.println("table{border-collapse: collapse; width:200px}");
		out.println("caption{font-size:14px;}");
		out.println("td{border:1px solid #000; text-align:center; }");
		out.println("</style></head>");
		out.println("<body>");
		
		out.print("<table><caption>[정보 출력]</caption>");
		for(String name : member) {
			out.print("<tr><td>"+name+"</td></tr>");
		}
		out.print("</table>");
		
		out.print("</body></html>");
		out.close();
   } 
} 