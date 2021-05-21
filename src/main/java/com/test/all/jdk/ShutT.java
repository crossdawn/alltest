package com.test.all.jdk;

public class ShutT {
    public static void main(String[] args) {
        // 添加hook thread，重写其run方法
        Runtime.getRuntime().addShutdownHook(new Thread(){
            @Override
            public void run() {
                System.out.println("this is hook demo...");
                // TODO
            }
        });

        int i = 0;
        // 这里会报错，我们验证写是否会执行hook thread
        int j = 10/i;
        System.out.println("j" + j);
    }


}
