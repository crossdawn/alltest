//package com.test.all.grpc;
//import io.grpc.Metadata;
//import io.grpc.MethodDescriptor;
//import io.grpc.Server;
//import io.grpc.ServerCall;
//import io.grpc.ServerCall.Listener;
//import io.grpc.ServerCallHandler;
//import io.grpc.ServerInterceptor;
//import io.grpc.ServerInterceptors;
//import io.grpc.examples.demo.DemoProto.LoginRequest;
//import io.grpc.examples.demo.DemoProto.LoginResponse;
//import io.grpc.examples.demo.DemoServiceGrpc;
//import io.grpc.netty.GrpcSslContexts;
//import io.grpc.netty.NettyServerBuilder;
//import io.grpc.netty.ProtocolNegotiators;
//import io.grpc.stub.StreamObserver;
//import io.grpc.testing.TestUtils;
//import io.netty.handler.ssl.SslContext;
//import io.netty.handler.ssl.SslContextBuilder;
//import io.netty.handler.ssl.SslProvider;
//
//import java.io.IOException;
//
//public class GrpcService {
//    private int port=8888;
//    private Server server;
//
//    private void start() throws IOException {
//
//        /**
//         * 创建和启动一个服
//         */
//        server = NettyServerBuilder.forPort(port).addService(ServerInterceptors.intercept(DemoServiceGrpc.bindService(new Serviceimpl()),echoRequestHeadersInterceptor()))
//                .build().start();
//        //protocolNegotiator  和  sslContext  useTransportSecurity是等效的
//        /**
//         * 事件钩子  关闭的时候调用stop
//         */
//        Runtime.getRuntime().addShutdownHook(new Thread(){
//            @Override
//            public void run() {
//                System.err.println("*** shutting down gRPC server since JVM is shutting down");
//                GrpcService.this.stop();
//                System.err.println("*** server shut down");
//            }
//        });
//
//    }
//
//    private void stop(){
//        if(server!=null){
//            server.shutdown();
//        }
//    }
//
//    private void blockUntilShutdown() throws InterruptedException{
//        if (server != null) {
//            server.awaitTermination();
//        }
//    }
//
//    public static void main(String[] args) throws IOException, InterruptedException {
//        final GrpcService grpcService = new GrpcService();
//        grpcService.start();
//        grpcService.blockUntilShutdown();
//    }
//
//    public static ServerInterceptor echoRequestHeadersInterceptor() {
//        return new ServerInterceptor() {
//            public <ReqT, RespT> Listener<ReqT> interceptCall(MethodDescriptor<ReqT, RespT> method,
//                                                              ServerCall<RespT> call, Metadata headers, ServerCallHandler<ReqT, RespT> next) {
//                System.out.println("服务器过滤器method"+method.toString()+"sss"+System.currentTimeMillis());
//                System.out.println("服务器过滤器headers"+headers.toString());
//                return next.startCall(method, call, headers);
//            }
//
//        };
//    }
//    /**
//     * 实现DemoService服务
//     * @author yeyc
//     *
//     */
//    class  Serviceimpl implements   DemoServiceGrpc.DemoService{
//
//        public void login(LoginRequest request, StreamObserver<LoginResponse> responseObserver) {
//            // TODO Auto-generated method stub
//
//            System.out.println(request.getUserName()+"来登录");
//            LoginResponse loginResponse = LoginResponse.newBuilder().setMsg(request.getUserName()+"授权登录成功").build();
//            responseObserver.onNext(loginResponse);
//            responseObserver.onCompleted();
//        }
//
//}
