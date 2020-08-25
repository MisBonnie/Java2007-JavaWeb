package com.zzxx.c_request;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/Demo06Servlet")
public class Demo06Servlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 请求对象request
        // 获得请求行信息
        // 1.获得请求方式
        String method = request.getMethod();
        System.out.println(method);
        // 2.获得请求的URI
        String uri = request.getRequestURI();
        String url = request.getRequestURL().toString();
        System.out.println("uri:  " + uri);
        System.out.println("url:  " + url);
        // 3.获得Get请求方式的参数
        String queryString = request.getQueryString();
        System.out.println(queryString);
        // 4.获得协议版本 HTTP/1.1
        String address = request.getProtocol();
        System.out.println(address);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
