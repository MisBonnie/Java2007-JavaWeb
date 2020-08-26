package e_cookie;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/Demo08Servlet")
public class Demo08Servlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 1.接收到请求
        System.out.println("接收到请求");

        // 2.通过请求对象获得cookie
        // 将客户端携带过来的cookie全部获得
        Cookie[] cookies = request.getCookies();
        if (cookies != null) {
            String name = cookies[0].getName();
            String value = cookies[0].getValue();

            response.getWriter().write("success: " + name + "," + value);
        } else {
            response.getWriter().write("cookie is null");
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
