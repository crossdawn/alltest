//package com.test.all.redis;
//
//import org.redisson.api.RLock;
//import org.redisson.api.RPriorityBlockingDeque;
//import org.redisson.api.RedissonClient;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.data.redis.connection.RedisConnectionFactory;
//import org.springframework.data.redis.core.RedisTemplate;
//import org.springframework.data.redis.core.StringRedisTemplate;
//import org.springframework.stereotype.Component;
//
//import java.io.*;
//import java.util.PriorityQueue;
//import java.util.concurrent.SynchronousQueue;
//import java.util.concurrent.TimeUnit;
//
////@Component
//public class RedissonTestService {
//    @Autowired
//    private RedisConnectionFactory redisConnectionFactory;
//    @Autowired
//    private StringRedisTemplate stringRedisTemplate;
//    @Autowired
//    private RedisTemplate redisTemplate;
//    @Autowired
//    private RedissonClient redissonClient;
//
//    public  void lock() throws FileNotFoundException {
////        redisConnectionFactory.getConnection();
//        RLock rLock = redissonClient.getLock("123123");
//
//    }
//
//    public  void lock2() {
////        redisConnectionFactory.getConnection();
//        new Thread(() -> {
//            RLock rLock = redissonClient.getLock("123");
//            rLock.lock();
//            try {
//                Thread.sleep(10_000);
//
//            }catch (Exception e){}
//        }).start();
//        try {
//            Thread.sleep(10_000);
//
//        }catch (Exception e){}
//        RLock rLock = redissonClient.getLock("123");
//        rLock.lock();
//        rLock.unlock();
//
//    }
//    public synchronized void lock3() {
//        SynchronousQueue q = new SynchronousQueue();
//
////        redisConnectionFactory.getConnection();
//        new Thread(() -> {
//            RLock rLock = redissonClient.getLock("123123");
//            rLock.lock(3, TimeUnit.SECONDS);
//        });
//    }
//}
