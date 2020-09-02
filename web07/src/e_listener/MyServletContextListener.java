package e_listener;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

@WebListener
public class MyServletContextListener implements ServletContextListener {
    // 在ServletContext对象创建时调用
    @Override
    public void contextInitialized(ServletContextEvent sce) {
        System.out.println("application 创建了");
    }
    // 检测到ServletContext对象的销毁,并且调用该方法
    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        System.out.println("application 销毁了");
    }
}
