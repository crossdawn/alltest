package com.test.all.jdk.lang;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.locks.ReentrantLock;

public class VolitaleTest {
    private volatile int a;
    private Object object;

    public static void main(String[] args) {
//        Map<String,Integer> map = new ConcurrentHashMap<>();
//        map.computeIfAbsent("AaAa", key -> {
//            return map.computeIfAbsent("BBBB", key2 -> 42);
//        });
        HashMap<String,Integer> hashMap = new HashMap();
        hashMap.put("AaAa",1);
//        new Thread(()->{hashMap.put("BBBB",1);}).start();

//        new Thread(()->{hashMap.put("AaAa",1);}).start();
        hashMap.put("BBBB",1);
        System.err.println("12");
//        CopyOnWriteArrayList c;
//        LinkedList linkedList = ;
//        linkedList.remove(2);
//        ReentrantLock

    }
    public static synchronized void m1() {

    }

    public synchronized void m2() {

    }

    public void m3() {
        synchronized (object) {

        }
    }
}
