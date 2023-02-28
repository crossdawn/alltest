package com.test.all.controller;


import com.test.all.mysql.Tb1;
import com.test.all.mysql.TestDAO;
import com.test.all.mysql.TestService;
import org.redisson.api.RedissonClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.lang.management.ClassLoadingMXBean;
import java.lang.management.ManagementFactory;
import java.util.*;

@RequestMapping("/redis")
@RestController

public class RedisController {

    @Autowired
    private RedissonClient redissonClient;

    @GetMapping(value = "/config")
    @Deprecated
    public String get() throws Exception{
        return redissonClient.getConfig().toJSON();
    }

    @GetMapping(value = "/map")
    @Deprecated
    public String map() throws Exception{
        return redissonClient.getMap("mymap").toString();
    }

}
