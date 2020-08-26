package a_request;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Base64;

@WebServlet("/Demo01Servlet")
public class Demo01Servlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 1.request获得应用的虚拟目录
        String path = request.getContextPath();
        request.getServletContext().getContextPath();
        System.out.println(path);

        // 2.request 也可以作为域对象使用
        request.setAttribute("name", "zhangsan");
        // 因为转发后不是同一个request对象, 所以只能在servlet1中获得请求参数
        String age = request.getParameter("age");
        System.out.println("Servlet01: " + request);
        System.out.println("接下来要转发到Demo02Servlet中");

        // 1.获得请求的转发器
        /*RequestDispatcher dispatcher = request.getRequestDispatcher("/Demo02Servlet");
        // 2.请求的转发
        dispatcher.forward(request, response);*/
        request.getRequestDispatcher("/Demo02Servlet").forward(request, response);
        // 转发后的代码, 就不会执行了
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
