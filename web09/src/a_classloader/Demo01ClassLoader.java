package a_classloader;

import java.lang1.String;

public class Demo01ClassLoader {
    public static void main(String[] args) {
        // 应用类加载器, 只有一个
        ClassLoader loader = Demo01ClassLoader.class.getClassLoader();
        ClassLoader loader2 = User.class.getClassLoader();
        // 引导类加载器, 和 扩展类加载器 代码获取不到
        ClassLoader loader1 = String.class.getClassLoader();

        System.out.println(loader1);
        System.out.println(loader == loader2);
    }
}
