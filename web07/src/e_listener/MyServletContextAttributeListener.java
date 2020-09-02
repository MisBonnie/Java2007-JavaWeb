package e_listener;

import javax.servlet.ServletContextAttributeEvent;
import javax.servlet.ServletContextAttributeListener;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

@WebListener
public class MyServletContextAttributeListener implements ServletContextAttributeListener {
    // getAttribute() -- 没有改变属性内容

    // 首次 setAttribute("name", 123)
    @Override
    public void attributeAdded(ServletContextAttributeEvent scae) {
        System.out.println("add 新的内容");
    }
    // removeAttribute()
    @Override
    public void attributeRemoved(ServletContextAttributeEvent scae) {
        System.out.println("remove 一个属性");
    }
    // 再次setAttribute("name", 345)
    @Override
    public void attributeReplaced(ServletContextAttributeEvent scae) {
        System.out.println("replace 一个属性");
    }
}
