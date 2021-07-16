//package com.test.all.grpc;
//
//import io.grpc.ManagedChannel;
//
//import javax.net.ssl.SSLException;
//
//import com.google.common.util.concurrent.ListenableFuture;
//
//import io.grpc.CallOptions;
//import io.grpc.Channel;
//import io.grpc.ClientCall;
//import io.grpc.ClientInterceptor;
//import io.grpc.LoadBalancer;
//import io.grpc.ManagedChannel;
//import io.grpc.MethodDescriptor;
//import io.grpc.SimpleLoadBalancerFactory;
//import io.grpc.TransportManager;
//import io.grpc.examples.demo.DemoProto.LoginRequest;
//import io.grpc.examples.demo.DemoProto.LoginResponse;
//import io.grpc.examples.demo.DemoServiceGrpc;
//import io.grpc.internal.GrpcUtil;
//import io.grpc.netty.GrpcSslContexts;
//import io.grpc.netty.NettyChannelBuilder;
//import io.grpc.testing.TestUtils;
//import io.netty.handler.ssl.SslContext;
//
//public class GrpcClient {
//    private ManagedChannel channel;
//    /**
//     * 同步阻塞
//     */
//    private DemoServiceGrpc.DemoServiceBlockingStub blockingStub;
//    /**
//     * 异步非阻塞
//     */
//    private DemoServiceGrpc.DemoServiceFutureStub futureStub;
//
//    /**
//     * 创建channel  创建各种桩
//     * @param host
//     * @param port
//     * @throws IOException
//     * @throws SSLException
//     */
//    void init(String host, int port) throws SSLException, IOException{
//
//        SslContext sslContext = GrpcSslContexts.forClient().trustManager(TestUtils.loadCert("ca.pem")).build();
//		/*String  tagert = GrpcUtil.authorityFromHostAndPort(host, port);
//		System.out.println("tagert:"+tagert);*/
//        channel =  NettyChannelBuilder.forAddress(host, port).usePlaintext(true).build();
//        //.negotiationType(NegotiationType.PLAINTEXT)  和这个是等效  usePlaintext(true)
//
//
//        blockingStub = DemoServiceGrpc.newBlockingStub(channel);
//        futureStub = DemoServiceGrpc.newFutureStub(channel);
//    }
//
//
//
//    public void shutdowm() throws InterruptedException{
//        if(channel!=null){
//            channel.shutdown().awaitTermination(5, TimeUnit.SECONDS);
//        }
//    }
//
//
//
//    public static void main(String[] args) throws InterruptedException, ExecutionException, SSLException, IOException {
//        GrpcClient grpcClient = new GrpcClient();
//        grpcClient.init("192.168.100.110", 8888);
//        //构建请求参数
//        LoginRequest request = LoginRequest.newBuilder().setUserName("yyc").build();
//        //同步阻塞调用
//        LoginResponse loginResponse = grpcClient.blockingStub.login(request);
//        System.out.println("同步调用后返回"+loginResponse.getMsg());
//        //异步非阻塞调用
//        ListenableFuture<LoginResponse>  loginResponse2 = grpcClient.futureStub.login(request);
//        LoginResponse loginResponseFuture =  loginResponse2.get();
//        System.out.println("异步调用后返回"+loginResponseFuture.getMsg());
//        grpcClient.shutdowm();
//    }
//
//}
