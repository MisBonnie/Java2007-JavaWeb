package a_filter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(value = "/Demo01Servlet",
     initParams =
        @WebInitParam(name="location", value="db.properties"))
public class Demo01Servlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String location = getServletConfig().getInitParameter("location");
        System.out.println(location);
        System.out.println("Demo01Servlet进来了");
        response.setContentType("text/html;charset=utf-8");
        response.getWriter().write("<h1>哈哈,响应回来了</h1>");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
