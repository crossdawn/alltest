package com.test.all.controller;

import com.test.all.mysql.TestDAO;
import com.test.all.mysql.TestService;
import com.test.all.redis.RedissonTestService;
import org.redisson.api.RedissonClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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

    @GetMapping("/redis")
    public String redis() {
        redissonTestService.redisTest();
        return "1";
    }


}
