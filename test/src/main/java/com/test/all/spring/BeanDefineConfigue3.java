package com.test.all.spring;

import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextClosedEvent;
import org.springframework.stereotype.Component;

@Component
public class BeanDefineConfigue3 implements ApplicationListener<ContextClosedEvent> {
    @Override
    public void onApplicationEvent(ContextClosedEvent event) {

            System.out.println("springContextClosedEvent初始化完毕================================================888");


    }
}
