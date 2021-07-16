package com.test.all.netty.test;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.*;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.handler.codec.json.JsonObjectDecoder;
import io.netty.handler.codec.string.StringEncoder;
import io.netty.handler.logging.LogLevel;
import io.netty.handler.logging.LoggingHandler;

public class MyServer {

    private Channel channel;

    public  void start(){
        ServerBootstrap bootstrap = new ServerBootstrap();

        EventLoopGroup bossGroup = new NioEventLoopGroup(2);
        EventLoopGroup workerGroup = new NioEventLoopGroup(2);

        bootstrap.group(bossGroup,workerGroup);
        bootstrap.option(ChannelOption.SO_BACKLOG, 1024);
        bootstrap.channel(NioServerSocketChannel.class);
        bootstrap.handler(new ChannelInitializer<NioServerSocketChannel>() {
            @Override
            protected void initChannel(NioServerSocketChannel ch) {
                ch.pipeline().addLast(
                        new LoggingHandler(LogLevel.DEBUG),
                        new StringEncoder(),
                        new JsonObjectDecoder());
            }
        });
        bootstrap.childHandler(new MyServerHandler());


        ChannelFuture channelFuture = bootstrap.bind(9527);
        channelFuture.syncUninterruptibly();
        channel = channelFuture.channel();
        System.err.println("服务端启动了");
    }

    public static void main(String[] args) {
        MyServer myServer = new MyServer();
        myServer.start();
    }
}
