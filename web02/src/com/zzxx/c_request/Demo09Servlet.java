package com.zzxx.c_request;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/Demo09Servlet")
public class Demo09Servlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 请求体内容
        String line = request.getReader().readLine();
        System.out.println(line);
        // username=%E5%BC%A0%E4%B8%89&password=123

//        request.getInputStream();
    }
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String queryString = request.getQueryString();
        System.out.println(queryString);
    }
}
