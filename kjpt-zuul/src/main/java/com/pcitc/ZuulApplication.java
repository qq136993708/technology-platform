package com.pcitc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.MultipartConfigFactory;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.context.annotation.Bean;

import javax.servlet.MultipartConfigElement;

/**
 * @author zhf
 * @date 2017年12月6日 下午3:59:16
 * @version V1.0
 * 服务网关,本质上和nginx功能一致
 */
@EnableZuulProxy
@EnableEurekaClient
@SpringBootApplication
@EnableFeignClients
public class ZuulApplication {

	public static void main(String[] args) {
		SpringApplication.run(ZuulApplication.class, args);
	}
    /**
     * 文件上传配置
     * @return
     */
//    @Bean
//    public MultipartConfigElement multipartConfigElement() {
//        MultipartConfigFactory factory = new MultipartConfigFactory();
//        //单个文件最大
//        factory.setMaxFileSize("10240MB"); //KB,MB
//        /// 设置总上传数据总大小
//        factory.setMaxRequestSize("10240MB");
//        return factory.createMultipartConfig();
//    }
}
