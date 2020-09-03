package a_listener;

import javax.servlet.http.HttpSessionActivationListener;
import javax.servlet.http.HttpSessionBindingEvent;
import javax.servlet.http.HttpSessionBindingListener;
import javax.servlet.http.HttpSessionEvent;
import java.io.Serializable;

public class User implements HttpSessionBindingListener,
        HttpSessionActivationListener, Serializable {
    private String name;
    private int age;

    public User() {
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public User(String name, int age) {
        this.name = name;
        this.age = age;
    }
    // 绑定 -> 加到session中
    @Override
    public void valueBound(HttpSessionBindingEvent event) {
        System.out.println(this.name + " user 被绑定");
    }
    // 解绑 -> 从session中移除
    @Override
    public void valueUnbound(HttpSessionBindingEvent event) {
        System.out.println(this.name + " user 被解绑");
    }

    @Override
    public void sessionWillPassivate(HttpSessionEvent se) {
        System.out.println("user对象钝化");
    }

    @Override
    public void sessionDidActivate(HttpSessionEvent se) {
        System.out.println("user对象活化");
    }
}
