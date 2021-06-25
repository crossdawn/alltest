package com.test.all.jdk;

public class CalT {
    public static void main(String[] args) throws ClassNotFoundException, IllegalAccessException, InstantiationException, InterruptedException {
//        Class<TestClass> a = (Class<TestClass>) Class.forName("main.com.test.all.jdk.TestClass",false,CalT.class.getClassLoader());
//        Class<TestClass> b = (Class<TestClass>) Class.forName("main.com.test.all.jdk.TestClass");

        //        a.newInstance();
//        Thread.currentThread().join();
        for(;;){
         try{
             TestClass t = new TestClass();
         }   catch (Throwable e){

         }
        }
    }
}
