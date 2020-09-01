package com.zzxx.user.manager.web;

import com.zzxx.user.manager.entity.User;
import com.zzxx.user.manager.service.UserService;
import com.zzxx.user.manager.service.impl.UserServiceImpl;
import com.zzxx.user.manager.utils.PageBean;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;

@WebServlet("/FindByPageServlet")
public class FindByPageServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 获得查询的条件参数
        Map<String, String[]> condition = request.getParameterMap();

        // 1.获得pageSize currentPage
        String pageSize = request.getParameter("pageSize");
        String currentPage = request.getParameter("currentPage");

        // 判断两个参数是不是为空, 是空, 赋默认值
        if (pageSize == null || "".equals(pageSize)) {
            pageSize = "4";
        }
        if (currentPage == null || "".equals(currentPage)) {
            currentPage = "1";
        }
        // 2.调用service层获得结果
        UserService us = new UserServiceImpl();
        PageBean<User> pb = us.findUserByPage(currentPage, pageSize, condition);
        // 3.转发到list.jsp
        request.setAttribute("pageBean", pb);
        request.setAttribute("condition", condition);
        request.getRequestDispatcher("/list.jsp").forward(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
