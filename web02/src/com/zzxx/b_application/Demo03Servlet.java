package com.zzxx.b_application;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/Demo03Servlet")
public class Demo03Servlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 获得ServletContext对象
        // 1.方式一: 通过Servlet获得
        ServletContext application = this.getServletContext();
        // 2.方式二: 通过request对象获得
        ServletContext app1 = request.getServletContext();
        // 3.方式三: 通过ServletConfig对象获得
        ServletContext app2 = this.getServletConfig().getServletContext();
        System.out.println(app1 == app2);
        System.out.println(app1 == application);

        // 从域中取数据
        String name = (String) application.getAttribute("name");
        response.getWriter().write("name: " + name);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
