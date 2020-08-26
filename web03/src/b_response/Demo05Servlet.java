package b_response;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/Demo05Servlet")
public class Demo05Servlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 获得字符输出流 -> 输出内容, 页面内容
        PrintWriter writer = response.getWriter();
        // 获得字节输出流 -> 复制文件, 文件下载
//        ServletOutputStream out = response.getOutputStream();

        // 两种输出流只能选择一种来使用, 不需要手动关闭流
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
