package com.book;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/bookOutput")
public class BookOutputServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        String title = (String) request.getAttribute("title");
        String author = (String) request.getAttribute("author");
        String publisher = (String) request.getAttribute("publisher");

        try (PrintWriter out = response.getWriter()) {
            out.println("<!DOCTYPE html>");
            out.println("<html lang='en'>");
            out.println("<head>");
            out.println("<meta charset='UTF-8'>");
            out.println("<title>Book Output</title>");
            out.println("<style>");
            out.println("body {");
            out.println("    font-family: 'Segoe UI', Tahoma, Geneva, Verdana, sans-serif;");
            out.println("    background-color: #f4f4f9;");
            out.println("    margin: 0;");
            out.println("    padding: 20px;");
            out.println("    color: #333;");
            out.println("}");
            out.println("h1 {");
            out.println("    color: #4a90e2;");
            out.println("    border-bottom: 2px solid #4a90e2;");
            out.println("    padding-bottom: 10px;");
            out.println("    margin-bottom: 20px;");
            out.println("}");
            out.println("p {");
            out.println("    font-size: 18px;");
            out.println("    margin: 10px 0;");
            out.println("    line-height: 1.8;");
            out.println("}");
            out.println("p strong {");
            out.println("    color: #4a90e2;");
            out.println("    font-weight: bold;");
            out.println("}");
            out.println(".container {");
            out.println("    max-width: 600px;");
            out.println("    background: #fff;");
            out.println("    padding: 20px;");
            out.println("    margin: 0 auto;");
            out.println("    box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1);");
            out.println("    border-radius: 8px;");
            out.println("}");
            out.println("</style>");
            out.println("</head>");
            out.println("<body>");
            out.println("<div class='container'>");
            out.println("<h1>책 정보</h1>");
            out.println("<p><strong>책 제목 :</strong> " + title + "</p>");
            out.println("<p><strong>책 저자 :</strong> " + author + "</p>");
            out.println("<p><strong>출판사  :</strong> " + publisher + "</p>");
            out.println("</div>");
            out.println("</body>");
            out.println("</html>");
        }
    }
}