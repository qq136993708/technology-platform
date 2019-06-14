package com.pcitc;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;

/**
 * @author
 * 2017-11-15 
 * 系统基础服务的服务启动类
 * 
 * EnableDiscoveryClient：服务注册
 * EnableCaching:开启缓存功能
 * MapperScan：mybatis的接口扫描
 */
@EnableDiscoveryClient
@SpringBootApplication
@EnableCaching
@MapperScan(basePackages = { "com.pcitc.mapper" })
@EnableFeignClients
@ServletComponentScan(basePackages={"com.pcitc.monitor"})
public class StpProviderApplication 
{
    public static void main(String[] args) 
    {
        SpringApplication.run(StpProviderApplication.class, args);
    }
}
