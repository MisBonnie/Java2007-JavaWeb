package c_reflect;

import a_classloader.User;

import java.lang.reflect.Method;

// 通过反射调用study方法
/*
    User user = new User("张三", 23);
    boolean b = user.study("Java"); // true
 */
public class Demo04 {
    public static void main(String[] args) throws Exception {
        User user = new User("张三");

        // 1.获得user的字节码对象
        Class cls = User.class;
        // 2.获得study这个方法对象
        Method method = cls.getDeclaredMethod("study", String.class);
        // 2.2设置方法可见
        method.setAccessible(true);
        // 3.调用方法
        boolean b = (Boolean) method.invoke(user, "Java");
        System.out.println(b);
    }
}
