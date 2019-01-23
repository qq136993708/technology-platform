package com.pcitc;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.scheduling.annotation.EnableAsync;

/**
 * @author zhf
 * 2017-11-15 
 * 系统基础服务的服务启动类
 * 
 * EnableDiscoveryClient：服务注册
 * EnableCaching:开启缓存功能
 * MapperScan：mybatis的接口扫描
 * ServletComponentScan: 监听器相关
 */
@EnableDiscoveryClient
@SpringBootApplication
@EnableCaching
@MapperScan(basePackages = { "com.pcitc.mapper.*" })
@ComponentScan
@EnableFeignClients
@EnableHystrix      //方便turbine进行监控
@EnableAsync
public class SystemProviderApplication {

    public static void main(String[] args) {
        SpringApplication.run(SystemProviderApplication.class, args);
    }

}
