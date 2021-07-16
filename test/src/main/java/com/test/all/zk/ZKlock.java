package com.test.all.zk;

import org.apache.zookeeper.WatchedEvent;

public class ZKlock {
    /**
     * 前一个节点被删除的信号
     */
    static Integer mutex = Integer.valueOf(-1);

    /**
     * 监控的节点被删除
     */
    protected void processNodeDeleted(WatchedEvent event) {
        synchronized (mutex) {
            // 节点被删除，通知退出线程
            mutex.notify();
        }
    }
}

//    /** 是否加锁成功 */
//    protected boolean isLockSuccess() {
//        boolean lockSuccess;
//        while (true) {
//            String prevElementName = getPrevElementName();
//            if (prevElementName == null) {
//                lockSuccess = true;
//                break;
//            } else {
//                // 有更小的节点，说明当前节点没抢到锁，注册前一个节点的监听
//                getZooKeeper().exists(this.guidNodeName + "/" + prevElementName, true);
//                synchronized (mutex) {
//                    mutex.wait();
//                    log.info("{} 被删除，看看是不是轮到自己了", prevElementName);
//                }
//            }
//        }
//        return lockSuccess;
//
//}
