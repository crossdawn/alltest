package com.test.all.zk;

import org.apache.curator.RetryPolicy;
import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.framework.CuratorFrameworkFactory;
import org.apache.curator.framework.recipes.cache.NodeCache;
import org.apache.curator.framework.recipes.cache.NodeCacheListener;
import org.apache.curator.framework.recipes.locks.InterProcessMutex;
import org.apache.curator.retry.ExponentialBackoffRetry;
import org.apache.zookeeper.CreateMode;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;

public class Curator implements InitializingBean, DisposableBean {

    private static CuratorFramework client;

    //ZooKeeper服务地址
    private static final String CONNECT_ADDR = "127.0.0.1:2181,127.0.0.1:2182,127.0.0.1:2183";

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
        client.create().withMode(CreateMode.PERSISTENT_SEQUENTIAL).forPath("/");
//       client.create().forPath("/locker/order/123");
//        client.create().forPath("/data/test");
//        client.create().forPath("/data/test/1");
//        client.create().forPath("/data/test/777/888","serwre".getBytes());
        client.create().creatingParentContainersIfNeeded().withMode(CreateMode.PERSISTENT_SEQUENTIAL);
        client.create().creatingParentContainersIfNeeded().withMode(CreateMode.EPHEMERAL).forPath("/data/lock/002","hello".getBytes());
//        client.create().withMode(CreateMode.EPHEMERAL_SEQUENTIAL).forPath("/locker/order/123");
//        client.create().withMode(CreateMode.EPHEMERAL_SEQUENTIAL).forPath("/locker/order/123");
        client.sync().wait();
//        NodeCache nodeCache = null;
//        nodeCache.start(true);
        // 如果为true则首次不会缓存节点内容到cache中，默认为false,设置为true首次不会触发监听事件


//        nodeCache.getListenable().addListener(new NodeCacheListener(){
//
//            @Override
//            public void nodeChanged() throws Exception {
//                // 节点发生变化，回调方法
//                byte[] ret = nodeCache.getCurrentData().getData();
//                // getData()方法实现返回byte[]
//                System.out.println("数据发生变化: " + new String(ret));
//            }
//
//        });
        InterProcessMutex lock = new InterProcessMutex(client, "/locker/order/555");
        for (int i =0;i<5;i++){
            lock.acquire();
        }
        System.err.println(new String(client.getData().forPath("/locker/order/555")));
        new Thread(()->{
            try {
                lock.acquire();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }).start();
        String path= lock.getParticipantNodes().iterator().next();
        lock.getParticipantNodes().forEach(x-> System.err.println(x));
//        lock.release();
        System.err.println(new String(client.getData().forPath(path)));

        client.create().withMode(CreateMode.EPHEMERAL).forPath("/data/lock/001");
        client.create().withMode(CreateMode.EPHEMERAL).forPath("/data/lock/001");

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

    public void lock()throws Exception{
        InterProcessMutex lock = new InterProcessMutex(client, "/locker/order/123");
        lock.acquire();
        lock2();
        lock.release();
    }
    public void lock2()throws Exception{
        InterProcessMutex lock = new InterProcessMutex(client, "/locker/order/123");
        lock.acquire();
        lock.release();
    }

}
