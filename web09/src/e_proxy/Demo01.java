package e_proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * 生成代理对象
 * 1.准备一个接口
 * 2.准备接口的实现类
 */
public class Demo01 {
    UserService us ;
    public void main(String[] args) {

//        us.modify();
        /*
           1.ClassLoader loader
              被代理对象的类加载器
           2.Class<?>[] interfaces
              被代理对象的父接口
           3.InvocationHandler
              方法执行器
         */
        UserService proxyService = (UserService) Proxy.newProxyInstance(UserServiceImpl.class.getClassLoader(),
                UserServiceImpl.class.getInterfaces(),
                new InvocationHandler() {
                    /*  proxyService.modify();
                        proxyService.register("张三");
                        1. proxy: 代理对象  proxyService
                        2. method: 方法对象  modify register
                        3. args: 方法参数实际值列表 modify方法的参数 "张三"
                     */
                    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                        System.out.println("开启事务");
                        // 执行原来的方法
                        Object o = method.invoke(us, args);
                        System.out.println("关闭事务");
                        return o;
                    }
                });
        proxyService.modify(); // --> 实际去调用了invoke方法
        proxyService.login();
        proxyService.delete();
        int i = proxyService.register("张三");
        System.out.println(i);

        System.out.println(proxyService instanceof UserServiceImpl);
        System.out.println(proxyService instanceof UserService);
    }
}
