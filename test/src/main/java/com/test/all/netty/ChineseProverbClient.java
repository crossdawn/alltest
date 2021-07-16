package com.test.all.netty;

import io.netty.bootstrap.Bootstrap;
import io.netty.buffer.Unpooled;
import io.netty.channel.Channel;
import io.netty.channel.ChannelOption;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.DatagramPacket;
import io.netty.channel.socket.nio.NioDatagramChannel;
import io.netty.util.CharsetUtil;

import java.net.InetSocketAddress;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.CyclicBarrier;

public class ChineseProverbClient {
    public void run(int port)throws Exception{
        EventLoopGroup group=new NioEventLoopGroup();
        try
        {
            Bootstrap b = new Bootstrap();
            b.group(group)
                    .channel(NioDatagramChannel.class)
                    .option(ChannelOption.SO_BROADCAST, true)
                    .handler(new ChineseProverbClientHandler());
            Channel ch=b.bind(0).sync().channel();
            //向网段内的所有机器广播
            ch.writeAndFlush(new DatagramPacket(Unpooled.copiedBuffer(
                    "谚语字典查询?", CharsetUtil.UTF_8), new InetSocketAddress(
                    "255.255.255.255",port))).sync();
            //客户端等待15s用于接收服务端的应答消息，然后退出并释放资源
            if(!ch.closeFuture().await(15000)){
                System.out.println("查询超时！");
            }
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }finally{
            group.shutdownGracefully();
        }
    }
    public int fib(int n) {
        if (n < 2) {
            return n;
        }
        int p = 0, q = 0, r = 1;
        for (int i = 2; i <= n; ++i) {
            p = q;
            q = r;
            r = p + q;
        }
        return r;
    }



    public static void main(String[] args)throws Exception {
        int port=9999;

        CyclicBarrier cyclicBarrier = new CyclicBarrier(5);
            for(int i =0;i<5;i++){
                new Thread(()->{
                    try{
                        ChineseProverbClient client =new ChineseProverbClient();
                        cyclicBarrier.await();
                        client.run(port);
                        System.err.println("发送");
                    }catch (Exception e){

                    }

                }).start();
        }
    }

}
