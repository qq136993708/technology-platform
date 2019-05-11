package com.pcitc.web;

import javax.servlet.MultipartConfigElement;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.context.embedded.ConfigurableEmbeddedServletContainer;
import org.springframework.boot.context.embedded.EmbeddedServletContainerCustomizer;
import org.springframework.boot.context.embedded.tomcat.TomcatEmbeddedServletContainerFactory;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.MultipartConfigFactory;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.boot.web.servlet.ServletContextInitializer;
import org.springframework.boot.web.servlet.ServletListenerRegistrationBean;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.client.RestTemplate;

import com.pcitc.web.interceptor.InitFilter;
import com.sinopec.siam.agent.web.AccessEnforcer;
import com.sinopec.siam.agent.web.SAMLProfileFilter;
import com.sinopec.siam.provisioning.listener.ApplicationWatch;

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

	/*@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		System.out.println("tomcat外置方式---------------启动");
		return application.sources(PplusApplication.class);
	}

	@Bean
	EmbeddedServletContainerCustomizer containerCustomizer() throws Exception {
		return (ConfigurableEmbeddedServletContainer container) -> {
			if (container instanceof TomcatEmbeddedServletContainerFactory) {
				TomcatEmbeddedServletContainerFactory tomcat = (TomcatEmbeddedServletContainerFactory) container;
				tomcat.addConnectorCustomizers((connector) -> {
					connector.setMaxPostSize(100000000); // 100 MB
				});
			}
		};
	}
	
	@Bean
	public ServletContextInitializer contextInitializer() {
	    return new ServletContextInitializer() {

	        @Override
	        public void onStartup(ServletContext servletContext)
	                throws ServletException {
	                servletContext.setInitParameter("spSimpleConfigFile","classpath:/conf/sp-simple-config.properties");
	        }
	    };
	}
	
	@Bean
	public ServletListenerRegistrationBean<ApplicationWatch> serssionListenerBean(){
		ServletListenerRegistrationBean<ApplicationWatch> 
		sessionListener = new ServletListenerRegistrationBean<ApplicationWatch>(new ApplicationWatch());
		return sessionListener;
	}
	
	@Bean
	public FilterRegistrationBean MyFilterRegistration1() {
		FilterRegistrationBean registration = new FilterRegistrationBean();
		registration.setFilter(new SAMLProfileFilter());
		registration.addUrlPatterns("/SSO/*");
		registration.setName("SAMLProfileFilter");
		registration.setOrder(1);
		return registration;
	}
	
	@Bean
    public FilterRegistrationBean MyFilterRegistration() {
        FilterRegistrationBean registration = new FilterRegistrationBean();
        AccessEnforcer access = new AccessEnforcer();
        registration.setFilter(access);
        registration.addUrlPatterns("/*");
        //registration.addInitParameter("spSimpleConfigFile", "classpath:/conf/sp-simple-config.properties");
        registration.addInitParameter("noFilterURLs", "/;/login;/index;/index.html;/error;/mobile/*;/layuiadmin/*;/layuicommon/*;/plugins/*;/common/js/*;/styles/*;/init.jsp;/spversion.html");
        registration.setName("AccessEnforcer");
        registration.setOrder(1);
        return registration;
    }
	
	@Bean
	public FilterRegistrationBean MyFilterRegistration2() {
		FilterRegistrationBean registration = new FilterRegistrationBean();
		registration.setFilter(new InitFilter());
		registration.addUrlPatterns("/");
		registration.setName("InitFilter");
		registration.setOrder(1);
		return registration;
	}*/
	
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
