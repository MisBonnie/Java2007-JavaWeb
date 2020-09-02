package b_login;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

@WebFilter("/*")
public class AutoLoginFilter implements Filter {
    public void destroy() {

    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        HttpServletRequest request = (HttpServletRequest) req;
        // 自动登录
        // 1.获得cookie中保存的账号和密码
        Cookie[] cookies = request.getCookies();
        String username = null;
        String password = null;
        if (cookies != null) {
            for(Cookie c : cookies) {
                if(c.getName().equals("username")){
                    username = c.getValue();
                }
                if(c.getName().equals("password")){
                    password = c.getValue();
                }
            }
        }
        if (username != null && password != null ) {
            // 2.调用登录业务操作
            if (username.equals("lucy") && password.equals("1234")) {
                // 3.将登录后的用户存储在session中
                request.getSession().setAttribute("user", "lucy");
            }
        }

        chain.doFilter(req, resp);
    }

    public void init(FilterConfig config) throws ServletException {

    }

}
