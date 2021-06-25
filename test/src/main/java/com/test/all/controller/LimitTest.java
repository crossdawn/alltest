package com.test.all.controller;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Random;

@RequestMapping("/limit")
@RestController
public class LimitTest {

    @HystrixCommand(commandProperties = {
            @HystrixProperty(name = "circuitBreaker.requestVolumeThreshold", value = "2")
//            ,
//            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "5000")
    },fallbackMethod = "hiError")
    @GetMapping("/test")
    public String monitorHttp() {
        int i = new Random().nextInt(5);
        System.err.println(i);
        if(i<2){
            try {
                Thread.sleep(5_000);
            }catch (Exception e){}
            System.err.println("超时后台继续执行");
        }
        if(i>3){
            int a=1/0;
        }
        return "OK"+i;
    }

    public String hiError() {
        return "Hystrix fallback";
    }

    public static void main(String[] args) {
        System.err.println(fastPow(2,3));
    }
    public static int fastPow(int n,int m){
        int res =1;
        int base =n;
        while (m!=0){
            if((m&1) == 1){
                res = res*base;
            }
            m=m>>1;
            base =base*base;
        }
        return res;
    }

}
