package com.test.all.jdk.concurrent;

import java.lang.ref.PhantomReference;
import java.lang.ref.ReferenceQueue;
import java.lang.ref.WeakReference;
import java.util.concurrent.ThreadPoolExecutor;

public class MyDiscardOldestPolicy extends ThreadPoolExecutor.DiscardOldestPolicy {

    @Override
    public void rejectedExecution(Runnable r, ThreadPoolExecutor e) {
        Runnable a = e.getQueue().poll();
        System.err.println("丢弃了A"+a.toString());
        e.execute(new MyTask("DDD"));
        System.err.println(e.getTaskCount());
        System.err.println("重试");
        e.execute(r);
        Object o = new Object();
        PhantomReference<Object>  reference = new PhantomReference(o,new ReferenceQueue());
        reference.get();
//        if (!e.isShutdown()) {
//            e.getQueue().poll();
//            e.execute(r);
//        }
    }

}
