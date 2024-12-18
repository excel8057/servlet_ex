package com.example;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/calcServlet")
public class CalcServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // 요청값 인코딩 설정
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html; charset=UTF-8");

        // 입력값 가져오기
        String num1Str = request.getParameter("num1");
        String operator = request.getParameter("operator");
        String num2Str = request.getParameter("num2");

        PrintWriter out = response.getWriter();

        try {
            int num1 = Integer.parseInt(num1Str);
            int num2 = Integer.parseInt(num2Str);
            int result = calc(num1, num2, operator);

            out.println("<html><body>");
            out.println("<h2>계산 결과</h2><hr>");
            out.println("<p>" + num1 + " " + operator + " " + num2 + " = " + result + "</p>");
            out.println("</body></html>");
        } catch (NumberFormatException e) {
            out.println("<html><body>");
            out.println("<h2>잘못된 입력</h2>");
            out.println("<p>숫자만 입력해주세요.</p>");
            out.println("</body></html>");
        } catch (ArithmeticException e) {
            out.println("<html><body>");
            out.println("<h2>오류</h2>");
            out.println("<p>0으로 나눌 수 없습니다.</p>");
            out.println("</body></html>");
        }
    }

    private int calc(int num1, int num2, String operator) {
        switch (operator) {
            case "+":
                return num1 + num2;
            case "-":
                return num1 - num2;
            case "*":
                return num1 * num2;
            case "/":
                if (num2 == 0) {
                    throw new ArithmeticException("Divide by zero");
                }
                return num1 / num2; // 정수 나눗셈
            default:
                throw new IllegalArgumentException("Invalid operator");
        }
    }
}
