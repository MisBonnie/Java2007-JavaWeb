package com.zzxx.web;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.zzxx.entity.ResponseInfo;
import com.zzxx.service.UserService;
import com.zzxx.service.impl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/CheckUserServlet")
public class CheckUserServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 1.接收请求参数 - 用户名
        String username = request.getParameter("username");

        // 2.调用service获得结果 - boolean
        UserService us = new UserServiceImpl();
        boolean isExists = us.checkUser(username);
        // 3.返回响应 - json
        // { "isExists" : true }
//        String json = "{ \"isExists\" : "+isExists+" }";
        ResponseInfo info = new ResponseInfo();
        info.setFlag(isExists);
        response.setContentType("application/json;charset=utf-8");
        // 将Java中的对象 -> 转换成json对象
        ObjectMapper mapper = new ObjectMapper();
        mapper.writeValue(response.getOutputStream(), info);
//        response.getWriter().write(json);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
