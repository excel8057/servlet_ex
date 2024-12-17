package com.example;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/todayMenu")
public class TodayMenu extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        // 요청 파라미터 인코딩 설정
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html; charset=UTF-8");
        PrintWriter out = response.getWriter();

        // 선택된 메뉴들을 받아오기
        String[] selectedMenus = request.getParameterValues("menu");

        // 출력
        out.println("<html><head><title>오늘의 점심 메뉴</title></head><body>");
        out.println("<h2>오늘의 점심 메뉴</h2>");

        if (selectedMenus != null) {
            out.println("오늘 점심 메뉴: ");
            for (String menu : selectedMenus) {
                out.println(menu + ", ");
            }
        } else {
            out.println("선택된 메뉴가 없습니다.");
        }

        out.println("</body></html>");
        out.close();
    }
}
