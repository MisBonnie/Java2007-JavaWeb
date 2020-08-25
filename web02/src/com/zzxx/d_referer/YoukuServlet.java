package com.zzxx.d_referer;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/YoukuServlet")
public class YoukuServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 1.获得链接来源 http://localhost:8080/web02_war_exploded/a.html
        String referer = request.getHeader("referer");
        // http://www.youku.com

        if(referer.startsWith("http://www.youku.com")) {
            // 正常情况, 没有发生盗链现象
            response.getWriter().write("<h1>Hello, I see honghaixingdong le</h1>");
        } else {
            // 这就是盗链了
            response.getWriter().write("you are a thief, please go to <a href='http://www.youku.com'>youku</a>");
        }

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
