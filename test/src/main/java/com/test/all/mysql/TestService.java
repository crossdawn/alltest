package com.test.all.mysql;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.support.TransactionSynchronizationAdapter;
import org.springframework.transaction.support.TransactionSynchronizationManager;

import java.util.*;

@Component
public class TestService {
    @Autowired
    private TestDAO testDAO;

    @HystrixCommand(commandProperties = {
            @HystrixProperty(name = "circuitBreaker.requestVolumeThreshold", value = "2"),
            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "3")
    }, fallbackMethod = "hiError")
    @Transactional
    public String trxWithLimit(int flag) {
        testDAO.insertBatch(genData(1, "trxWithLimit"));
        TransactionSynchronizationManager.registerSynchronization(new TransactionSynchronizationAdapter() {
            @Override
            public void afterCommit() {
                System.err.println("事务提交后发消息");
            }
        });
        int i = 1 / flag;
        return "hello";
    }

    public String hiError(int flag) {
        return "降级";
    }


    @Transactional
    public String trx(int flag) {
        testDAO.insertBatch(genData(1, "trx"));
        TransactionSynchronizationManager.registerSynchronization(new TransactionSynchronizationAdapter() {
            @Override
            public void afterCommit() {
                System.err.println("事务提交后发消息");
            }
        });
        int i = 1 / flag;
        return "hello";
    }

    public List<Tb1> genData(int num, String prefix) {
        List<Tb1> records = new ArrayList<>();
        Date date = new Date();
        for (int i = 0; i < num; i++) {
            Tb1 tb = new Tb1();
            tb.setF1Byte((byte) 1);
            tb.setF2Int(1000000 + new Random().nextInt(1000000));
            tb.setF3Varchar(prefix + UUID.randomUUID().toString());
            tb.setF4Datetime(date);
            tb.setCreateTime(date);
            tb.setUpdateTime(date);
            records.add(tb);
        }
        return records;
    }

}
