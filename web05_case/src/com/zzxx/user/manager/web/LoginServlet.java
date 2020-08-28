package com.zzxx.user.manager.web;

import com.zzxx.user.manager.entity.User;
import com.zzxx.user.manager.service.UserService;
import com.zzxx.user.manager.service.impl.UserServiceImpl;
import com.zzxx.user.manager.utils.LoginException;
import org.apache.commons.beanutils.BeanUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;

@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        // 1.接收请求 接收请求参数
        User user = new User();
        try {
            BeanUtils.populate(user, request.getParameterMap());
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        // 2.登录业务 - UserService的login方法
        UserService us = new UserServiceImpl();
        try {
            // 3.对结果判断, 结果跳转
            User loginUser = us.login(user);
            // 4.登录成功后, 将用户信息保存在session中
            request.getSession().setAttribute("user", loginUser);
            // 跳转到首页 - 重定向
            response.sendRedirect(request.getContextPath() + "/index.html");
        } catch (LoginException e) {
            // 登录失败, 结果跳转 - 转发
            request.setAttribute("msg", e.getMessage());
            request.getRequestDispatcher("/login.jsp").forward(request, response);
        }

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
