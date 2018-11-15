package com.pcitc;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;

/**
 * @author zhf
 * 2017-11-15 
 * 系统基础服务的服务启动类
 * 
 * EnableDiscoveryClient：服务注册
 * EnableCaching:开启缓存功能
 * MapperScan：mybatis的接口扫描
 */

@EnableDiscoveryClient
@EnableCaching
@SpringBootApplication(exclude = {
        DataSourceAutoConfiguration.class
})
@ComponentScan
@EnableFeignClients
public class Application 
{
    public static void main(String[] args) 
    {
        SpringApplication.run(Application.class, args);
    }
}
