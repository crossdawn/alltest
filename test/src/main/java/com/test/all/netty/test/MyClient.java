//package com.test.all.netty.test;
//
//import com.sun.corba.se.impl.orbutil.concurrent.ReentrantMutex;
//import com.test.all.jdk.T;
//import com.test.all.netty.ChineseProverbClientHandler;
//import com.test.all.netty.ListNode;
//import io.netty.bootstrap.Bootstrap;
//import io.netty.bootstrap.ServerBootstrap;
//import io.netty.channel.Channel;
//import io.netty.channel.ChannelInitializer;
//import io.netty.channel.ChannelOption;
//import io.netty.channel.EventLoopGroup;
//import io.netty.channel.epoll.EpollEventLoopGroup;
//import io.netty.channel.nio.NioEventLoopGroup;
//import io.netty.channel.socket.nio.NioDatagramChannel;
//import io.netty.channel.socket.nio.NioServerSocketChannel;
//import io.netty.channel.socket.nio.NioSocketChannel;
//import io.netty.handler.codec.json.JsonObjectDecoder;
//import io.netty.handler.codec.string.StringEncoder;
//import io.netty.handler.logging.LogLevel;
//import io.netty.handler.logging.LoggingHandler;
//
//import java.util.concurrent.locks.ReentrantReadWriteLock;
//import java.util.stream.IntStream;
//
//public class MyClient {
//
//    public void start(String message)  {
//        Bootstrap client = new Bootstrap();
//        EventLoopGroup group = new NioEventLoopGroup(2);
//        client.group(group)
//                .channel(NioSocketChannel.class);
//        client.handler(new ChannelInitializer<NioSocketChannel>() {
//            @Override
//            protected void initChannel(NioSocketChannel ch) {
//                ch.pipeline().addLast(
//                        new LoggingHandler(LogLevel.DEBUG),
//                        new StringEncoder(),
//                        new JsonObjectDecoder(),new MyClientHandler());
//            }
//        });
//        try {
//            Channel channel=client.connect("127.0.0.1",9527).sync().channel();
//
//            for(int i=0;i<10;i++){
//                channel.writeAndFlush(message);
//            }
//
//        }catch (Exception e){
//
//        }
//    }
//
//    public static void main(String[] args) throws InterruptedException {
//        int i =0;
//        while (i<1){
//            Thread t1 = new Thread(()->{
//                new MyClient().start("1231");
//            });
//            Thread t2 = new Thread(()->{
//                new MyClient().start("213123");
//            });
//            t1.start();
//            t1.join();
//            t2.start();
//            t2.join();
//            i++;
//        }
//
//    }
//
//    public ListNode deleteDuplicates(ListNode head) {
//        if(head == null||head.next ==null){
//            return head;
//        }
//        ListNode cur =head;
//        while (cur!=null){
//            ListNode next = cur.next;
//            while (cur==next){
//                next =next.next;
//            }
//            cur.next =next;
//            cur =next;
//        }
//        return head;
//    }
//    1 2 3 4 5
//    public boolean validateStackSequences(int[] pushed, int[] popped) {
//        Stack<Integer> stack = new Stack<>();
//        int i = 0;
//        for(int num : pushed) {
//            stack.push(num); // num 入栈
//            while(!stack.isEmpty() && stack.peek() == popped[i]) { // 循环判断与出栈
//                stack.pop();
//                i++;
//            }
//        }
//        return stack.isEmpty();
//    }
//    public int[] exchange(int[] nums) {
//        int i =0;
//        int j = nums.length-1;
//        while (i<=j&&i<nums.length-1&&j>0){
//            while (nums[i]%2==1&&i<j){
//              i++;
//            }
//            while(nums[j]%2==0&&i<j){
//                j--;
//            }
//            ReentrantReadWriteLock reentrantReadWriteLock;
//            ReentrantMutex
//            int temp =nums[i];
//            nums[i] = nums[j];
//            nums[j] = temp;
//        }
//        return nums;
//    }
//}
