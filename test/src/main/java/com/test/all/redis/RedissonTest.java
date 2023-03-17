package com.test.all.redis;

import org.redisson.Redisson;
import org.redisson.api.RMap;
import org.redisson.api.RedissonClient;
import org.redisson.client.codec.LongCodec;
import org.redisson.config.Config;
import org.redisson.config.SingleServerConfig;
import org.redisson.config.TransportMode;

import java.util.Map;

public class RedissonTest {
    public static void main(String[] args) {
        Config config = new Config();
        config.setTransportMode(TransportMode.NIO);
        SingleServerConfig singleServerConfig = config.useSingleServer();
        //可以用"rediss://"来启用SSL连接
        singleServerConfig.setAddress("redis://101.43.139.201:6379");
        RedissonClient redisson = Redisson.create(config);
        redisson.getMap("");
        RMap<Long,Long> map = redisson.getMap("laohuapp:user:world:viewing", LongCodec.INSTANCE);
//        redisson.getMap()
        Long a1= map.get(1L);
        System.err.println(map.values());
        System.err.println(map.entrySet());

        Map<Long,Long> map1 = map.readAllMap();
        System.err.println(map1);
    }
}
