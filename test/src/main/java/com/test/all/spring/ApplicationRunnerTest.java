package com.test.all.spring;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;

//@Component
public class ApplicationRunnerTest implements ApplicationRunner, InitializingBean {
    @Override
    public void run(ApplicationArguments args) throws Exception {
        System.err.println("ApplicationRunner");
    }

    @Override
    public void afterPropertiesSet() throws Exception {

    }
}
