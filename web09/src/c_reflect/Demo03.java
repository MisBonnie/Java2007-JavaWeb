package c_reflect;

import a_classloader.User;

import java.lang.reflect.Constructor;

public class Demo03 {
    public static void main(String[] args) throws Exception {
        // 通过反射创建user对象

        // 1.获得user的字节码对象
        Class cl = User.class;
        // 2.获得user的构造方法
        Constructor con1 = cl.getConstructor();
        // 3.创建对象
        User u1 = (User) con1.newInstance();
        System.out.println(u1);
//        new User("张三", 23);
        // 获得user的构造方法
//        Constructor con2 = cl.getConstructor(String.class, int.class);
        // 成员私有时, 获得方法需要使用 getDeclaredxx
        Constructor con2 = cl.getDeclaredConstructor(String.class, int.class);
        // 私有成员可以手动设置可见
        con2.setAccessible(true);
        // 创建对象
        User u2 = (User) con2.newInstance("lucy", 18);
        System.out.println(u2);

//        cl.newInstance(); // -- 直接通过无参构造器创建对象
    }
}
