package com.test.all;

//import org.apache.catalina.core.ApplicationContext;
//import org.mybatis.spring.annotation.MapperScan;
//import org.springframework.boot.ExitCodeGenerator;
//import org.springframework.boot.SpringApplication;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;
import org.springframework.context.ConfigurableApplicationContext;
//import org.springframework.context.annotation.AnnotationConfigApplicationContext;
//import org.springframework.context.annotation.Bean;
//import org.springframework.transaction.annotation.EnableTransactionManagement;
//import sun.net.dns.ResolverConfigurationImpl;

@SpringBootApplication
//@EnableTransactionManagement
//@MapperScan(basePackages = "main.com.test.all.mysql")
@EnableHystrix
@EnableHystrixDashboard
public class TestApplication {


    public static void main(String[] args) {
//        SpringApplication.run(TestApplication.class, args);
        ConfigurableApplicationContext applicationContext=new SpringApplicationBuilder()
                .sources(TestApplication.class).web(WebApplicationType.SERVLET).run(args);
        applicationContext.registerShutdownHook();
//        applicationContext.close();

    }
}
