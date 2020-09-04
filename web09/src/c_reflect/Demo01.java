package c_reflect;

import java.lang1.String;

public class Demo01 {
    public static void main(String[] args) {
        // 1.手动类加载
        Class cls = null;
        try {
            cls = Class.forName("java.lang1.String");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        // 2.获得类的字节码类型
        Class cls2 = int.class;
        // 3.通过对象的getClass方法
        Class cls3 = "".getClass();

        // 类, 接口, 注解, 枚举
        // 每一个类的字节码对象只有一个
        System.out.println(cls == cls3); // true
    }
}
