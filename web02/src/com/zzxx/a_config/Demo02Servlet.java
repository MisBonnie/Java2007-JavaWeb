package com.zzxx.a_config;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Date;

/*
    name: 等同于 <servlet-name>
    urlPatterns/value: 等同于<url-pattern>
 */
//@WebServlet(name="/Demo02Servlet", urlPatterns = {"/demo02","/demo022"})
// <url-pattern>/demo02<url-pattern>
// @WebServlet(value = "/demo02")
//@WebServlet("/demo02")
@WebServlet({"/demo02", "/demo022"})
public class Demo02Servlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.getWriter().write("Demo02: " + new Date().toString());
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
