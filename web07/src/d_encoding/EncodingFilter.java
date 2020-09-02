package d_encoding;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.security.Principal;
import java.util.Collection;
import java.util.Enumeration;
import java.util.Locale;
import java.util.Map;

@WebFilter({"/Demo02Servlet", "/Demo03Servlet"})
public class EncodingFilter implements Filter {
    public void destroy() {
    }
    public void init(FilterConfig config) throws ServletException {
    }
        public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        // 1.解决乱码
//        req.setCharacterEncoding("UTF-8");
        HttpServletRequest request = (HttpServletRequest) req;
        // 创建MyRequest类型
        MyRequest myRequest = new MyRequest(request);
        chain.doFilter(myRequest, resp);
    }
}
// 装饰者模式: 方法增强
/*
   1.装饰者和被装饰者拥有相同的父接口
   2.使用被装饰者 来 构建装饰者对象
   3.重写需要增强的方法, 方法内部会使用到被装饰者原来的方法
   4.将 被装饰者 包装成 装饰者对象 再去使用
 */
class MyRequest extends HttpServletRequestWrapper {
    private HttpServletRequest request;
    public MyRequest(HttpServletRequest request) {
        super(request);
        this.request = request;
    }
    @Override
    public String getParameter(String name) {
        // 1.获得原来是乱码的参数值
        String parameter = request.getParameter(name);
        // 2.解决乱码
        try {
            parameter = new String(parameter.getBytes("ISO8859-1"), "UTF-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        // 3.将最终解决好编码的正常中文返回
        return parameter;
    }

}
