package a_filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;

//@WebFilter(value = "/Demo01Servlet", filterName = "MyFilterA")
public class MyFilterA implements Filter {
    public void destroy() {
        System.out.println("FilterA destroy");
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        System.out.println("MyFilterA before");
        chain.doFilter(req, resp);
        System.out.println("MyFilterA after");
    }

    public void init(FilterConfig config) throws ServletException {
        System.out.println("FilterA init");
    }

}
