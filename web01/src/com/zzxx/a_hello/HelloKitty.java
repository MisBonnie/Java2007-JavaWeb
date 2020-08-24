package com.zzxx.a_hello;

import javax.servlet.*;
import java.io.IOException;
import java.util.Date;

public class HelloKitty implements Servlet {
    @Override
    public void init(ServletConfig servletConfig) throws ServletException {
        System.out.println("Hello Kitty init");
    }
    @Override
    // 服务方法, 每次接收到请求都会执行的
    public void service(ServletRequest servletRequest, ServletResponse response) throws ServletException, IOException {
        System.out.println("Hello Kitty service");
        response.getWriter().println(new Date());
    }
    @Override
    public void destroy() {
        System.out.println("Hello Kitty destroy");
    }
    @Override
    public String getServletInfo() {
        return null;
    }

    @Override
    public ServletConfig getServletConfig() {
        return null;
    }

}
