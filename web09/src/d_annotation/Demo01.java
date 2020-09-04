package d_annotation;

@Deprecated
@SuppressWarnings({"all"})
// 使用注解, 并且给属性赋值
// score属性值只有一个的时候, 可以直接赋值
//@MyAnnotation(age = 13, score = 1)
// score属性值有多个的时候, 必须使用{}表示数组
//@MyAnnotation(age = 13, score = {1, 2, 3})
// 如果注解的属性有且仅有一个value, 那么value可以省略
//@MyAnnotation(2)
@MyAnnotation(value = 2, age = 13)
public class Demo01 {
    @Deprecated
    @SuppressWarnings("all")
    private int age;

    @Deprecated
    @SuppressWarnings("all")
    public Demo01(@Deprecated @SuppressWarnings("all") String str) {
        @Deprecated
        int a;
    }

    public static void main(String[] args) {

    }

    @SuppressWarnings("all")
    @Deprecated
    public void test01() {

    }

    @Override
    public String toString() {
        return null;
    }
}
