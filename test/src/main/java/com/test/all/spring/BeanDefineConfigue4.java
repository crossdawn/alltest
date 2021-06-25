package com.test.all.spring;

import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextStoppedEvent;
import org.springframework.stereotype.Component;

@Component
public class BeanDefineConfigue4 implements ApplicationListener<ContextStoppedEvent> {
    @Override
    public void onApplicationEvent(ContextStoppedEvent event) {

            System.out.println("springContextStoppedEvent初始化完毕================================================888");

    }
}
