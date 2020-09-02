package b_login;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        // 模拟登录
        if (username.equals("lucy") && password.equals("1234")) {
           if ("autoLogin".equals(request.getParameter("autoLogin"))) {
               // 将账号密码保存在cookie中
               Cookie nameCookie = new Cookie("username", username);
               Cookie pwdCookie = new Cookie("password", password);
               nameCookie.setMaxAge(Integer.MAX_VALUE);
               pwdCookie.setMaxAge(Integer.MAX_VALUE);
               nameCookie.setPath(request.getContextPath());
               pwdCookie.setPath(request.getContextPath());

               response.addCookie(nameCookie);
               response.addCookie(pwdCookie);
           }
            request.getSession().setAttribute("user", "lucy");
            response.sendRedirect(request.getContextPath());
        } else {
            request.getRequestDispatcher("/login.jsp").forward(request, response);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
