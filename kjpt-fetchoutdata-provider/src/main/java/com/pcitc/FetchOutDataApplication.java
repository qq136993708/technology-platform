package com.pcitc;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.context.annotation.PropertySource;

import com.alibaba.druid.spring.boot.autoconfigure.DruidDataSourceAutoConfigure;

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
@EnableCaching
@MapperScan(basePackages = { "com.pcitc.mapper" })
@EnableFeignClients
@SpringBootApplication
@PropertySource(name="EncryptedProperties", value = "classpath:application-${spring.profiles.active}.properties")
public class FetchOutDataApplication 
{
    public static void main(String[] args) 
    {
        SpringApplication.run(FetchOutDataApplication.class, args);
    }
}
