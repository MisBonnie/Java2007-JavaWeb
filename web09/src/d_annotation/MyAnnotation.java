package d_annotation;

public @interface MyAnnotation {
    // 属性语法  类型 属性名()
    int age() default 0; // 使用注解时属性必须赋值
    String name() default ""; // 使用注解时可以不赋值, 就使用默认值
    int[] score() default {}; // 使用注解时必须赋值, 可以是多个
    int value();
}
