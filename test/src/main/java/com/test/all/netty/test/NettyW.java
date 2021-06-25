package com.test.all.netty.test;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.epoll.EpollEventLoopGroup;

public class NettyW {
    public static void main(String[] args) {
        ServerBootstrap server = new ServerBootstrap();
        EventLoopGroup bossGroup = new EpollEventLoopGroup(2);

    }
}
