package com.test.all.dlock;

import com.github.benmanes.caffeine.cache.Cache;
import com.github.benmanes.caffeine.cache.Caffeine;

import java.util.concurrent.TimeUnit;

public class CacheTest {
    public static void main(String[] args) {
         Cache<String, Object> cache = Caffeine.newBuilder()
                .expireAfterWrite(1, TimeUnit.SECONDS)
                .expireAfterAccess(1, TimeUnit.SECONDS)
                .maximumSize(10)
                .build();
        cache.put("hello",new Object());
        System.err.println(cache.stats().hitRate());
        System.err.println(cache.getIfPresent("hello"));
    }
}
