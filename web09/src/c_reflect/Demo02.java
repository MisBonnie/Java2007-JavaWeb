package c_reflect;

import java.lang.String;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;

public class Demo02 {
    public static void main(String[] args) {
        Class cls = String.class;
        System.out.println(cls);

        // 1.获得所有的父接口
        Class[] interfaces = cls.getInterfaces();
        System.out.println(Arrays.toString(interfaces));

        // 2.获得类的构造方法
        try {
            // 获得一个参数是String类型的构造器 new String("str");
            Constructor constructor = cls.getConstructor(String.class);
            // "hello" 就是调用这个构造方法传递的实际参数
            String ob = (String) constructor.newInstance("hello");
            System.out.println(ob);
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
    }
}
