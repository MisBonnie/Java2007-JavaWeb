package com.zzxx.user.manager.web;

import com.zzxx.user.manager.service.UserService;
import com.zzxx.user.manager.service.impl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/DeleteUserServlet")
public class DeleteUserServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 1.接收请求, 获得请求参数
        String _id = request.getParameter("id");
        int id = Integer.valueOf(_id);
        // 2.封装对象 -- 省略

        // 3.调用service层获得结果
        UserService us = new UserServiceImpl();
        us.deleteUserById(id);
        // 4.指派jsp进行显示 -- 全部列表
        response.sendRedirect(request.getContextPath()+"/FindByPageServlet");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
