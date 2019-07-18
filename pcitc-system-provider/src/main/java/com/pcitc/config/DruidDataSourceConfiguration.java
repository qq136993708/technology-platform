package com.pcitc.config;

import javax.sql.DataSource;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.alibaba.druid.pool.DruidDataSource;
import com.ulisesbocchio.jasyptspringboot.annotation.EnableEncryptableProperties;
import com.ulisesbocchio.jasyptspringboot.annotation.EncryptablePropertySource;
import com.ulisesbocchio.jasyptspringboot.annotation.EncryptablePropertySources;

/**
 * @author zhf 2017-11-16 初始配置时加载进druid
 */
@Configuration
@EnableEncryptableProperties
@EncryptablePropertySources({ @EncryptablePropertySource(value = "classpath:application.properties", ignoreResourceNotFound = true), @EncryptablePropertySource(value = "classpath:application-${spring.profiles.active}.properties", ignoreResourceNotFound = true) })
public class DruidDataSourceConfiguration {
	
	@Bean
	@ConfigurationProperties(prefix = "spring.datasource")
	public DataSource druidDataSource() {
		System.out.println("start up druid config !!!");
		DataSource druidDataSource = new DruidDataSource();
		return druidDataSource;
	}
}
