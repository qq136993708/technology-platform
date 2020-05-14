package com.pcitc;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.PropertySource;
import org.springframework.http.client.SimpleClientHttpRequestFactory;
import org.springframework.web.client.RestTemplate;

import com.pcitc.utils.SpringUtil;

import koal.urm.client.action.ResServiceServlet;

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
@EnableFeignClients
@EnableHystrix      //方便turbine进行监控
@PropertySource(name="EncryptedProperties", value = "classpath:application-${spring.profiles.active}.properties")
public class SystemProviderApplication  {

    public static void main(String[] args) {
        SpringApplication.run(SystemProviderApplication.class, args);
    	
    	//SpringApplication application = new SpringApplication(SystemProviderApplication.class);
        //application.addListeners(new ApplicationPidFileWriter());
        //application.run(args);
        //System.out.println( "启动成功" );
	
    }
    
    
    
    
    
    @Bean
    public SpringUtil getSpringUtil() {
        return new SpringUtil();
    }
    
    
    
    @Bean
	@LoadBalanced
	protected RestTemplate restTemplate() {
		SimpleClientHttpRequestFactory requestFactory = new SimpleClientHttpRequestFactory();
		//设置超时时间
		requestFactory.setConnectTimeout(40000);
		requestFactory.setReadTimeout(40000);
		return new RestTemplate(requestFactory);
	}
    
    
    @Bean
    public ServletRegistrationBean getServletRegistrationBean() {  //一定要返回ServletRegistrationBean
        ServletRegistrationBean bean = new ServletRegistrationBean(new ResServiceServlet());
        bean.addInitParameter("resDaoClass", "com.pcitc.service.ssosync.impl.ResRecvServiceImpl");
       
        bean.addInitParameter("daoType", "2");
        //放入自己的Servlet对象实例
        bean.addUrlMappings("/resReg");  //访问路径值
        return bean;
    }
    

}
