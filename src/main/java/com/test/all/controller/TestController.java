package com.test.all.controller;

import com.test.all.mysql.TestService;
import com.test.all.redis.RedissonTestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.lang.management.ClassLoadingMXBean;
import java.lang.management.ManagementFactory;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.Callable;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;

@RequestMapping("/monitor")
@RestController

public class TestController {
    @Autowired
    private TestService testService;
    @Autowired
    private RedissonTestService redissonTestService;

    @GetMapping("/test")
    public String monitorHttp() {
        return "OK";
    }

    @GetMapping("/db")
    public String db() {
        testService.trx();
        return "1";
    }
    static class Num{
        int n =0;

        public Num(int a) {
            this.n = a;
        }
    }
    static final Num a = new Num(1);
    @GetMapping("/a")
    public String a(String b) {
        final int c;

        if("1".equals(b)){
            a.n =1000;
        }
        return ""+a.n;
    }

    @GetMapping("/redis")
    public String redis() {
        redissonTestService.lock();
        redissonTestService.lock2();
        redissonTestService.lock3();
//        ThreadPoolExecutor threadPoolExecutor = null;
//        threadPoolExecutor.submit(new Callable<Object>() {
//        }).cancel();
//        ArrayBlockingQueue;
//        LinkedBlockingQueue;
//        ThreadPoolExecutor.DiscardOldestPolicy
        return "1";
    }

    @GetMapping("/class")
    public String classT() {
        try {
            ClassLoadingMXBean classLoadingMXBean = ManagementFactory.getClassLoadingMXBean();
            classLoadingMXBean.getLoadedClassCount();
            classLoadingMXBean.getTotalLoadedClassCount();
            classLoadingMXBean.getUnloadedClassCount();

        }finally {

        }
        return "1";
    }


}
