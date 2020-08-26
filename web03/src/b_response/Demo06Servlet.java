package b_response;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/Demo06Servlet")
public class Demo06Servlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 设置response缓冲区字符集
//        response.setCharacterEncoding("UTF-8");
        // 告诉客户端响应体类型, 解析方式
        response.setContentType("text/html;charset=utf-8");

        // 获得字符输出流 -> 输出内容, 页面内容
        PrintWriter writer = response.getWriter();

        writer.println("<h1>Demo06Servlet字符流的println方法</h1>");
        writer.write("<h1>Demo06Servlet字符流的write方法</h1>");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
