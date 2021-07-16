package com.test.all.controller;


import com.test.all.mysql.TestService;
import com.test.all.redis.RedissonTestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.lang.management.ClassLoadingMXBean;
import java.lang.management.ManagementFactory;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

@RequestMapping("/monitor")
@RestController

public class TestController {
    @Autowired
    private TestService testService;
    @Autowired
    private RedissonTestService redissonTestService;

    static Map<String,String> cache = new HashMap<>();
    static {
        cache.put("123","123");
    }

    private  int b;

    public void getA() {
        b=100;
    }

    @GetMapping(value = "/trx")
    @Deprecated
    public String trx(String flag) {
        return testService.trx();
    }

    @GetMapping(value = "/dead2")
    @Deprecated
    public Integer dead2(String flag) {
        if(Objects.equals(1+"",flag)){
            getA();
        }
        new Thread(()->{
            if(b!=100){
                System.err.println("dsfdsfds");
            }
        }).start();
        return b;
    }
    @GetMapping("/test")
    public String monitorHttp() {
        return "OK";
    }

    @GetMapping("/db")
    public String db() {
//        return testService.trx();
        System.err.println("从混存获取数据");
        return cache.get("123");
    }

    @GetMapping("/db2")
    public String db2() {
//        return testService.trx();
        cache =null;
//        cache.put("123","23423");
        return cache.get("123");
    }
    static class Num{
        int n =0;

        public Num(int a) {
            this.n = a;
        }
    }
    static final Num a = new Num(1);

    @GetMapping("/a")
    public String a(@RequestParam Integer b, HttpServletResponse response) {
        final int c;

        if(Objects.equals(1,b)){
            a.n =1000;
        }
        if(Objects.equals(2,b)){
           while (true){
               System.err.println("死循环");
           }
        }
        return ""+a.n;
    }

    @GetMapping("/redis")
    public String redis() {
//        redissonTestService.lock();
        redissonTestService.lock2();
//        redissonTestService.lock3();
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
