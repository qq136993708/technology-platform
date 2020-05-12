package com.pcitc.web;

import javax.servlet.MultipartConfigElement;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.context.embedded.ConfigurableEmbeddedServletContainer;
import org.springframework.boot.context.embedded.EmbeddedServletContainerCustomizer;
import org.springframework.boot.context.embedded.tomcat.TomcatEmbeddedServletContainerFactory;
import org.springframework.boot.web.servlet.MultipartConfigFactory;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.client.RestTemplate;



/**
 * @author zhf
 * @EnableFeignClients考虑zuul进行集群
 * @EnableEurekaClient考虑controller调用时方便（微服务间的调用）
 */
@EnableFeignClients
@EnableEurekaClient
@ServletComponentScan
@EnableAutoConfiguration(exclude = DataSourceAutoConfiguration.class)
@ComponentScan({"com.pcitc.web.feign", "com.pcitc.web.controller", "com.pcitc.web.common", "com.pcitc.web.config", "com.pcitc.web.activiti", "com.pcitc.web.socket","com.pcitc.web.interceptor","com.pcitc.web.utils"})
@SpringBootApplication
public class PplusApplication extends SpringBootServletInitializer {

	@Bean
	@LoadBalanced
	protected RestTemplate restTemplate() {
		return new RestTemplate();
	}

	public static void main(String[] args) {
		System.out.println("springboot方式---------------启动");
		SpringApplication.run(PplusApplication.class, args);
	}

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		System.out.println("tomcat外置方式---------------启动");
		return application.sources(PplusApplication.class);
	}

	/**
	 * 解决ie数据保存出现下载对话框的问题
	 * @return
	 */
	/*@Bean
	public HttpMessageConverters fastJsonHttpMessageConverters(){
		//1.需要定义一个convert转换消息的对象;
		FastJsonHttpMessageConverter fastJsonHttpMessageConverter = new FastJsonHttpMessageConverter();
		//2处理ie浏览器保存数据时出现下载json数据问题
		List<MediaType> fastMediaTypes = new ArrayList<>();
		//fastMediaTypes.add(MediaType.TEXT_PLAIN);
		fastMediaTypes.add(new MediaType("text", "plain", Charset.forName("UTF-8")));
		//3.在convert中添加配置信息.
		fastJsonHttpMessageConverter.setSupportedMediaTypes(fastMediaTypes);
		HttpMessageConverter<?> converter = fastJsonHttpMessageConverter;
		return new HttpMessageConverters(converter);
	}*/


	@Bean
	EmbeddedServletContainerCustomizer containerCustomizer() throws Exception {
		return (ConfigurableEmbeddedServletContainer container) -> {
			if (container instanceof TomcatEmbeddedServletContainerFactory) {
				TomcatEmbeddedServletContainerFactory tomcat = (TomcatEmbeddedServletContainerFactory) container;
				/*tomcat.addConnectorCustomizers((connector) -> {
					connector.setMaxPostSize(100000000); // 100 MB
				});*/
			}
		};
	}
	
	
	
	/**
	 * 文件上传配置
	 * 
	 * @return
	 */
	@Bean
	public MultipartConfigElement multipartConfigElement() {
		MultipartConfigFactory factory = new MultipartConfigFactory();
		// 单个文件最大
		factory.setMaxFileSize("2048MB"); // KB,MB
		// / 设置总上传数据总大小
		factory.setMaxRequestSize("2048MB");
		return factory.createMultipartConfig();
	}
	
	
	    
	
	
	
}
