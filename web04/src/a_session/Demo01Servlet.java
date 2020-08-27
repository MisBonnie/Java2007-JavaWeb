package a_session;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/Demo01Servlet")
public class Demo01Servlet extends javax.servlet.http.HttpServlet {
    protected void doPost(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        // 1.获取session对象
        HttpSession session = request.getSession();
        // 2.获取session的id
        String jsessionid = session.getId();
        // 3.创建一个一模一样的cookie
        Cookie cookie = new Cookie("JSESSIONID", jsessionid);
        cookie.setPath(request.getContextPath());
        // 4.设置这个cookie持久化时间
        cookie.setMaxAge(Integer.MAX_VALUE);
        // 5.将原来的cookie覆盖
        response.addCookie(cookie);
        // 2.向session中存储数据
        session.setAttribute("name", "zhangsan");
    }

    protected void doGet(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        doPost(request, response);
    }
}
