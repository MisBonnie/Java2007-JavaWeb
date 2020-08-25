package com.zzxx.e_register;

import org.apache.commons.beanutils.BeanUtils;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.Map;

@WebServlet("/RegistServlet")
public class RegistServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 1.接收请求参数
        /*String username = request.getParameter("username");
        String password = request.getParameter("password");
        String email = request.getParameter("email");
        String realname = request.getParameter("realname");
        String birthday = request.getParameter("birthday");
        String gender = request.getParameter("gender");*/
        // 封装对象
        Map<String, String[]> map = request.getParameterMap();
        User user = new User();
        try {
            // 将map中的键值对, 自动注入到user对象中
            // map中的key, 对应user对象中的属性名
            BeanUtils.populate(user, map);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        /*user.setUsername(username);
        user.setPassword(password);
        user.setEmail(email);
        user.setBirthday(birthday);
        user.setGender(gender);
        user.setRealname(realname);*/
        // 2.调用UserDao中保存用户的方法
        UserDao ud = new UserDao();
        ud.insertUser(user);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
