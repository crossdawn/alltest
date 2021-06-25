package com.test.all.controller;

import com.netflix.hystrix.HystrixCommand;

public class CusHystrixCommand extends HystrixCommand {
    protected CusHystrixCommand(Setter setter) {
        super(setter);
    }

    @Override
    protected Object run() throws Exception {
        return null;
    }
}
