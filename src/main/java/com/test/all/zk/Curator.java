package com.test.all.zk;

import org.apache.curator.RetryPolicy;
import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.framework.CuratorFrameworkFactory;
import org.apache.curator.framework.api.ExistsBuilder;
import org.apache.curator.framework.recipes.locks.InterProcessLock;
import org.apache.curator.framework.recipes.locks.InterProcessMutex;
import org.apache.curator.retry.ExponentialBackoffRetry;
import org.apache.zookeeper.CreateMode;
import org.apache.zookeeper.data.Stat;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;

public class Curator implements InitializingBean, DisposableBean {

    private static CuratorFramework client;

    //ZooKeeper服务地址
    private static final String CONNECT_ADDR = "127.0.0.1:2181";

    static {
        //1 重试策略：初试时间为1s 重试10次
        RetryPolicy retryPolicy = new ExponentialBackoffRetry(10000, 10);
        //2 通过工厂创建连接
        client = CuratorFrameworkFactory.builder()
                .connectString(CONNECT_ADDR).connectionTimeoutMs(30000)
                .sessionTimeoutMs(30000)
                .retryPolicy(retryPolicy)
                //命名空间           .namespace("super")
                .build();
        //3 开启连接
        client.start();
    }

    public static void main(String[] args) throws Exception {
//       client.create().forPath("/locker/order/123");
//        client.create().forPath("/data/test");
//        client.create().forPath("/data/test/1");
//        client.create().forPath("/data/test/777/888","serwre".getBytes());
        client.create().withMode(CreateMode.EPHEMERAL).forPath("/data/lock/002","hello".getBytes());
//        client.create().withMode(CreateMode.EPHEMERAL_SEQUENTIAL).forPath("/locker/order/123");
//        client.create().withMode(CreateMode.EPHEMERAL_SEQUENTIAL).forPath("/locker/order/123");

        InterProcessMutex lock = new InterProcessMutex(client, "/locker/order/123");
        lock.acquire();
        lock.release();

//        client.create().withMode(CreateMode.EPHEMERAL).forPath("/data/lock/001");

//        System.err.println(      new String(client.getData().forPath("/data/test/777")) );
//        System.err.println(client.getChildren().forPath("/data/test/777"));
//        System.err.println(      new String(client.getData().forPath("/data/test/777")) );
//        Stat existsBuilder = client.checkExists().forPath("/data/test/temp5");
//        System.err.println(existsBuilder.toString());
//        client.create().creatingParentsIfNeeded();
//        client.create().creatingParentContainersIfNeeded();
//        client.create().withMode(CreateMode.EPHEMERAL).forPath("/data/test/temp5");
//        Stat stat = client.checkExists().forPath("/data/test/temp3");
//        System.err.println(stat.getEphemeralOwner());
//        final InterProcessLock lock = new InterProcessSemaphoreMutex(client, lockPath);

    }

    @Override
    public void destroy() throws Exception {

    }

    @Override
    public void afterPropertiesSet() throws Exception {

    }
}
