package a_filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;

// url-pattern代表要过滤的请求资源路径
//@WebFilter(value = "/Demo01Servlet", filterName = "MyFilterD")
public class MyFilterD implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        System.out.println("MyFilterD before");
        // 放行
        chain.doFilter(request, response);
        System.out.println("MyFilterD after");
//        response.setContentType("text/html;charset=utf-8");
//        response.getWriter().write("<h1>直接从Filter回来了, 没有进入到Servlet</h1>");
    }

    @Override
    public void destroy() {

    }
}
