package com.test.all.jdk;

import org.openjdk.jol.info.ClassLayout;

import java.lang.ref.WeakReference;

public class ObjectT {
    static Object yesLock;

    public static void main(String[] args) throws InterruptedException {
        Integer i = new Integer(100);
//        ThreadLocal<Integer> threadLocal = new ThreadLocal<>();
//        threadLocal.set(i);
        WeakReference<Object> weakReference = new WeakReference<Object>(i);
//        Integer b = i;
        i=null;
        System.gc();
        System.err.println(weakReference.get());
//        ByteOrder.LITTLE_ENDIAN
//        -XX:+PrintSafepointStatistics
//                -XX:PrintSafepointStatisticsCount=1
//        179d3b25
        yesLock = new Object();
//        yesLock=null;
//        System.err.println(weakReference);
//        System.gc();
//        yesLock.hashCode();
//        System.err.println(yesLock.hashCode());
//        System.gc();
//        System.out.println("无锁时对象布局：" + ClassLayout.parseInstance(yesLock).toPrintable());
//        IntStream.rangeClosed(1,4).forEach(i->{getYesLock(i);});
//        Thread.sleep(5000);
//        System.out.println("无竞争之后，此时的对象布局：" + ClassLayout.parseInstance(yesLock).toPrintable());
//        getYesLock(100);//此时再来一次加锁
//        IntStream.rangeClosed(10,12).forEach(i->{getYesLock(i);});
    }


    private static void getYesLock(int i) {
        new Thread(() -> {
            try {
                synchronized (yesLock) {
                    System.out.println("线程[" + i+"]" +
                            ":重量级锁状态对象布局:" + ClassLayout.parseInstance(yesLock).toPrintable());
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }).start();
    }

}
