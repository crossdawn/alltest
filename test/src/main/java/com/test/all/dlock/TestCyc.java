package com.test.all.dlock;

import org.openjdk.jol.info.ClassLayout;

import java.io.IOException;
import java.util.concurrent.ConcurrentHashMap;

public class TestCyc {
    /**
     * 锁资源记录表
     */
    private static ConcurrentHashMap<String, Object> lockMap = new ConcurrentHashMap<>();
    static {
        lockMap.put("123",new Object());
        lockMap.put("345",new Object());

    }

    public static void main(String[] args) throws IOException {
        ClassLayout layout5 = ClassLayout.parseInstance(new Object());
        System.err.println(layout5.instanceSize());
        System.err.println(layout5.headerSize());
        System.err.println(layout5.toPrintable());

        new Thread(()->test("123")).start();
        new Thread(()->test("123")).start();
        System.in.read();
        }

    public static void test(String key) {
        if(lockMap.get(key)==null){
            lockMap.putIfAbsent(key,new Object());
        }
        synchronized (lockMap.get(key)){
            try{
                Thread.sleep(3_000);
                System.err.println("获取到锁"+System.currentTimeMillis());
            }catch (Exception e){}

        }
    }
}
