package com.zzxx.c_request;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Enumeration;

@WebServlet("/Demo07Servlet")
public class Demo07Servlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 请求对象request
        // 获得请求头信息 Map
        // user-agent 客户端信息
        String userAgent = request.getHeader("User-Agent");
        System.out.println(userAgent);

        // referer -> 链接来源 防盗链

//        request.getDateHeader()
//        request.getIntHeader()
        // 获得所有请求头的name
        Enumeration<String> headerNames = request.getHeaderNames();

        request.getLocalAddr();// 获得本地地址
        request.getRemoteAddr();// 获得远程地址
    }


    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
