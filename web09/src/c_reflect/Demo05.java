package c_reflect;

import a_classloader.User;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

// 通过反射调用成员变量
/*
    User user = new User("张三", 23);
    user.age
 */
public class Demo05 {
    public static void main(String[] args) throws Exception {
        User user = new User("张三");
        System.out.println(user);
        // 1.获得user的字节码对象
        Class cls = User.class;
        // 2.获得age属性
        Field age = cls.getDeclaredField("age");
        age.setAccessible(true);
        // 3.给user对象的age属性赋值
        age.set(user, 18);
        // 4.获得user对象的age属性
        age.get(user);
        System.out.println(user);
    }
}
