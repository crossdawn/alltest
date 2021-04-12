package com.test.all.controller;

import com.test.all.mysql.TestService;
import com.test.all.redis.RedissonTestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.lang.management.ClassLoadingMXBean;
import java.lang.management.ManagementFactory;

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
