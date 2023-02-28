package com.test.all.mysql;

import org.springframework.transaction.support.TransactionSynchronizationAdapter;
import org.springframework.transaction.support.TransactionSynchronizationManager;

/**
 * 事务工具类
 */
public class TransactionUtils {


    public static void executeSyncAfterCommit(Runnable runnable) {
        TransactionSynchronizationManager
                .registerSynchronization(new TransactionSynchronizationAdapter() {
                    @Override
                    public void afterCommit() {
                        runnable.run();
                    }
                });
    }
}
