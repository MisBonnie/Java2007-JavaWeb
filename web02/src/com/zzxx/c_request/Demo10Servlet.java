package com.zzxx.c_request;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Arrays;
import java.util.Enumeration;
import java.util.Map;

@WebServlet("/Demo10Servlet")
public class Demo10Servlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");

        // 1.获得的参数 一个name对应一个value
        String username = request.getParameter("username");
        System.out.println(username);
        // 2.一个name对应多个value checkbox
        String[] hobby = request.getParameterValues("hobby");
        System.out.println(Arrays.toString(hobby));
        // 3.value是日期  yyyy-MM-dd
        String birthday = request.getParameter("birthday");
        System.out.println(birthday);

        // 4.获得所有的参数,并且封装为map ParameterMap
        Map<String, String[]> map = request.getParameterMap();
        map.entrySet().stream().forEach((entry)->{
            System.out.println(entry.getKey() + ":" + entry.getValue());
        });

        // 5.获得所有参数的name -- 了解
        Enumeration<String> names = request.getParameterNames();


    }
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
