package com.pcitc.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import com.alibaba.druid.spring.boot.autoconfigure.DruidDataSourceBuilder;
import com.ulisesbocchio.jasyptspringboot.annotation.EnableEncryptableProperties;
import com.ulisesbocchio.jasyptspringboot.annotation.EncryptablePropertySource;
import com.ulisesbocchio.jasyptspringboot.annotation.EncryptablePropertySources;

/**
 * @author zhf
 * 2018-09-20 初始数据库配置，配置多个数据源
 */
@Configuration
@EnableEncryptableProperties
@EncryptablePropertySources({ @EncryptablePropertySource(value = "classpath:application.properties", ignoreResourceNotFound = true), @EncryptablePropertySource(value = "classpath:application-${spring.profiles.active}.properties", ignoreResourceNotFound = true) })
public class DataSourceConfiguration {
	
	@Bean(name = "mysqlDS")
	@Primary
	@ConfigurationProperties(prefix = "spring.datasource.mysql")
	public DataSource mysqlDataSource(){
		System.out.println("start up mysql data source config !!!");
		return DruidDataSourceBuilder.create().build();
	}
	
	@Bean(name = "hanaDS")
	@ConfigurationProperties(prefix = "spring.datasource.hana")
	public DataSource hanaDataSource(){
		System.out.println("start up hana data source config !!!");
		return DruidDataSourceBuilder.create().build();
	}
}
