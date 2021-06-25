package com.test.all.mysql;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.support.TransactionSynchronizationAdapter;
import org.springframework.transaction.support.TransactionSynchronizationManager;

@Component
public class TestService  {
//    @Autowired
//    private TestDAO testDAO;

    @HystrixCommand(commandProperties = {
            @HystrixProperty(name = "circuitBreaker.requestVolumeThreshold", value = "2"),
            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "3")
    },fallbackMethod = "hiError")
    @Transactional
    public String trx(){
//        testDAO.insert();
////        int i=1/0;
//        testDAO.insert();
//insert文章
        TransactionSynchronizationManager.registerSynchronization(new TransactionSynchronizationAdapter() {
            @Override
            public void afterCommit() {
                System.err.println("发送消息了拉利");
            }
        });
                int i=1/0;
                return "hello";
    }

    public String hiError() {
        return "Hystrix fallback";
    }
}
