package com.zzxx.user.manager.web;

import com.zzxx.user.manager.entity.User;
import com.zzxx.user.manager.service.UserService;
import com.zzxx.user.manager.service.impl.UserServiceImpl;
import org.apache.commons.beanutils.BeanUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;

@WebServlet("/AddUserServlet")
public class AddUserServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 0.解决乱码
        request.setCharacterEncoding("utf-8");
        // 1.接收请求, 获得请求参数
        // 2.封装对象
        User user = new User();
        try {
            BeanUtils.populate(user, request.getParameterMap());
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        // 3.调用Service层,获得结果
        UserService us = new UserServiceImpl();
        us.addUser(user);
        // 4.指派JSP显示
        response.sendRedirect(request.getContextPath()+"/FindByPageServlet");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
