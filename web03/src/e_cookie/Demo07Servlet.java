package e_cookie;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/cookie/Demo07Servlet")
public class Demo07Servlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 1.接收到请求
        System.out.println("接收到请求");
        // 2.一系列的数据处理
        System.out.println("数据处理了一堆");

        // 3.将数据存储在cookie中, 通过response对象
        // a.创建cookie对象 String-String类型的键值对
        Cookie cookie = new Cookie("name", "zhangsan");
        // 设置cookie的持久化时间
        cookie.setMaxAge(60*5);
        // 设置cookie的携带路径,
        // 设置cookie在访问Demo08Servlet的时候才会携带到服务器
//        cookie.setPath("/web03/Demo08Servlet");
        // 设置cookie在访问/web03应用中所有的资源都会携带到服务器
//        cookie.setPath("/web03/");
        // 设置cookie在访问这个服务器中所有的资源时,都会携带到服务器
//        cookie.setPath("/");
        // b.通过response将cookie传递给客户端
        // 本质是通过响应头set-cookie,把数据传递给客户端的
        response.addCookie(cookie);

        response.getWriter().write("success");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
