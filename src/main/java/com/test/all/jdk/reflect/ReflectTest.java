package com.test.all.jdk.reflect;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class ReflectTest {
    public static void main(String[] args) {
        System.err.println( System.getProperty("java.classpath"));
        System.getProperties().put("sun.misc.ProxyGenerator.saveGeneratedFiles", "true");
        TestService service1 = (TestService) Proxy.newProxyInstance(Thread.currentThread().getContextClassLoader(),new Class[]{TestService.class},new ProxyT(new TestServiceImpl2()));
//        TestService service2 = (TestService) Proxy.newProxyInstance(Thread.currentThread().getContextClassLoader(),new Class[]{TestService.class},new ProxyT(service1));
//        service2.sayHello();
        TestService service3 = (TestService) Proxy.newProxyInstance(Thread.currentThread().getContextClassLoader(),new Class[]{TestService.class},new ProxyT2(service1));
        service3.sayHello();
        TestApi api = (TestApi) Proxy.newProxyInstance(Thread.currentThread().getContextClassLoader(),new Class[]{TestApi.class},new ProxyT2(new TestApiImpl()));
        api.say();
        api.sing();

//        TestApi api2 = (TestApi) Proxy.newProxyInstance(Thread.currentThread().getContextClassLoader(),new Class[]{TestApi.class,TestService.class},new ProxyT2(new TestServiceImpl3()));
//        api2.say();
//        TestService service22 = (TestService) Proxy.newProxyInstance(Thread.currentThread().getContextClassLoader(),new Class[]{TestService.class},new ProxyT2(new TestServiceImpl22()));
//        service22.sayHello();

    }

    static class TestServiceImpl2 implements TestService{
        @Override
        public void sayHello() {
            System.err.println("你好");
        }
    }
    static class TestServiceImpl22 implements TestService{
        @Override
        public void sayHello() {
            System.err.println("你好2");
        }
    }
    static class TestServiceImpl implements TestService{
        @Override
        public void sayHello() {
            System.err.println("Hello");
        }
    }
    static class TestServiceImpl3 implements TestService,TestApi{
        @Override
        public void sayHello() {
            System.err.println("hello");
        }

        @Override
        public void say() {
            System.err.println("say");
        }

        @Override
        public void sing() {
            System.err.println("singTestServiceImpl3");
        }
    }

    interface TestService{
        void sayHello();
    }

    interface TestApi{
        void say();
        void sing();

    }
    static class TestApiImpl implements TestApi{
        @Override
        public void say() {
            System.err.println("aaaaa");
        }

        @Override
        public void sing() {
            System.err.println("sing");

        }
    }
   static class ProxyT implements InvocationHandler{
       Object testService;

       public ProxyT(TestService testService) {
           this.testService = testService;
       }

       @Override
       public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
//           System.err.println(proxy);
           System.err.println("proxyyyy");
           return method.invoke(testService,args);
       }
   }

    static class ProxyT2 implements InvocationHandler{
        Object target;

        public ProxyT2(Object target) {
            this.target = target;
        }

        @Override
        public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
//           System.err.println(proxy);
            System.err.println("proxyyyy2222");
            return method.invoke(target,args);
        }
    }

}
