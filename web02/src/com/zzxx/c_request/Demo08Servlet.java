package com.zzxx.c_request;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Enumeration;

@WebServlet("/Demo08Servlet")
public class Demo08Servlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 默认字符集: ISO8859-1
        request.setCharacterEncoding("UTF-8");
        // 请求对象request
        // 获得请求参数  Get-参数在URI/Post-参数在请求体中
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        System.out.println("post username: " + username);
        System.out.println("post password: " + password);
    }
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 默认字符集和tomcat字符集一致: ISO8859-1  UTF-8
        String username = request.getParameter("username");
        // 解决username的乱码
//        username = new String(username.getBytes("ISO8859-1"), "UTF-8");

        String password = request.getParameter("password");

        System.out.println("get username: " + username);
        System.out.println("get password: " + password);
    }
}
