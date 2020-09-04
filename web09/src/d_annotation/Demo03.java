package d_annotation;

import java.lang.annotation.Annotation;

// 解析Demo02上的MyAnnotation2注解
public class Demo03 {
    public static void main(String[] args) {
        // 1.获得Demo02对应的字节码对象
        Class cls = Demo02.class;

        // 2.获得Demo02类上的MyAnnotation2注解
        MyAnnotation2 annotation = (MyAnnotation2) cls.getAnnotation(MyAnnotation2.class);
        // 3.获得注解中的属性值
        int age = annotation.age();
        System.out.println(age);
    }
}
