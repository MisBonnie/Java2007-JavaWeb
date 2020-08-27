package a_session;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/Demo02Servlet")
public class Demo02Servlet extends javax.servlet.http.HttpServlet {
    protected void doPost(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        // 1.获取session对象
        HttpSession session = request.getSession();
        // 2.从session中取数据
        Object name = session.getAttribute("name");
        response.setContentType("text/html");
        response.getWriter().write("name: " + name + "<br/>");
        response.getWriter().write("JSESSIONID: " + session.getId());
    }

    protected void doGet(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        doPost(request, response);
    }
}
