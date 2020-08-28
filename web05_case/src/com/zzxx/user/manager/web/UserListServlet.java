package com.zzxx.user.manager.web;

import com.zzxx.user.manager.entity.User;
import com.zzxx.user.manager.service.UserService;
import com.zzxx.user.manager.service.impl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/UserListServlet")
public class UserListServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 1.调用service获得用户列表
        UserService us = new UserServiceImpl();
        List<User> list = us.findAll();
        // 2.转发到list.jsp显示结果
        request.setAttribute("list", list);
        request.getRequestDispatcher("list.jsp").forward(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
