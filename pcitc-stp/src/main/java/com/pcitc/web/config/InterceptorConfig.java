package com.pcitc.web.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import com.pcitc.web.interceptor.TokenInterceptor;

@Configuration
public class InterceptorConfig extends WebMvcConfigurerAdapter {

	@Autowired
	TokenInterceptor tokenInterceptor;

	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		// 添加拦截器
		registry.addInterceptor(tokenInterceptor).addPathPatterns("/**").excludePathPatterns("/mobile/**");
		System.out.println("拦截器---------------------------------"+registry);
		super.addInterceptors(registry);
	}

	@Bean
	public LocaleResolver localeResolver() {
		return new MyLocaleResolver();
	}

}
