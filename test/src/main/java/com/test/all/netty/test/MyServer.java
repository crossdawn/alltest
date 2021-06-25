package com.test.all.netty.test;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.*;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioServerSocketChannel;

public class MyServer {

    private Channel channel;

    public  void start(){
        ServerBootstrap bootstrap = new ServerBootstrap();

        EventLoopGroup bossGroup = new NioEventLoopGroup(2);
        EventLoopGroup workerGroup = new NioEventLoopGroup(2);

        bootstrap.group(bossGroup,workerGroup);
        bootstrap.option(ChannelOption.SO_BACKLOG, 1024);
        bootstrap.channel(NioServerSocketChannel.class);
        bootstrap.childHandler(new MyServerHandler());
        ChannelFuture channelFuture = bootstrap.bind(9527);
        channelFuture.syncUninterruptibly();
        channel = channelFuture.channel();
    }
}
