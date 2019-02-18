package com.pcitc.web.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import com.pcitc.web.interceptor.TokenInterceptor;

@Configuration
public class InterceptorConfig extends WebMvcConfigurerAdapter {

	@Autowired
	TokenInterceptor tokenInterceptor;
	
	// 文件上传路径
	@Value("${uploaderPathTemp}")
	private String uploaderPathTemp;

	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		// 添加拦截器
		registry.addInterceptor(tokenInterceptor).addPathPatterns("/**").excludePathPatterns("/mobile/**");
		System.out.println("拦截器---------------------------------"+registry);
		super.addInterceptors(registry);
	}
	
	/* (non-Javadoc)
	 * 添加到系统的静态路径中，方便在线编辑等操作使用
	 * @see org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter#addResourceHandlers(org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry)
	 */	
	@Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/**").addResourceLocations("file:"+uploaderPathTemp);
    }

	@Bean
	public LocaleResolver localeResolver() {
		return new MyLocaleResolver();
	}

}
