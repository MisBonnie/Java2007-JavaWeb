package com.zzxx.b_application;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/Demo04Servlet")
public class Demo04Servlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 获得ServletContext对象
        ServletContext application = this.getServletContext();
        // 作用一: 获得虚拟目录   /web02_war_exploded
        String path = application.getContextPath();
        System.out.println(path);
        // 作用二: 获得应用的全局参数
        String driver = application.getInitParameter("driver");
        System.out.println(driver);
        // 作用三: 获得应用中, 文件的绝对路径
        // src/a.txt
        String aPath = application.getRealPath("/WEB-INF/classes/a.txt");
        // web/b.txt
        String bPath = application.getRealPath("/b.txt");
        // web/WEB-INF/c.txt
        String cPath = application.getRealPath("/WEB-INF/c.txt");
        // web02(module)/d.txt -- 应用中不存在
        System.out.println(aPath);
        System.out.println(bPath);
        System.out.println(cPath);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
