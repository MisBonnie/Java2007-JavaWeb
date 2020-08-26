package b_response;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/Demo03Servlet")
public class Demo03Servlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 1.设置响应行信息 - 状态码 为重定向
        response.setStatus(302);

        // response.setHeader("name", "zhangsan");
        // 2.设置响应头内容 - 重定向地址
//        response.setHeader("location", "http://www.baidu.com");
        response.setHeader("location", "/web03_war_exploded/Demo01Servlet");
        // 重定向后, 代码也不会执行

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
