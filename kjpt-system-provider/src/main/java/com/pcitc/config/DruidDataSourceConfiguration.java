package com.pcitc.config;

import java.util.Properties;

import javax.sql.DataSource;

import org.apache.ibatis.mapping.DatabaseIdProvider;
import org.apache.ibatis.mapping.VendorDatabaseIdProvider;
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
	
	 /**
     * 自动识别使用的数据库类型
     * 在mapper.xml中databaseId的值就是跟这里对应，
     * 如果没有databaseId选择则说明该sql适用所有数据库
     * */
    @Bean
    public DatabaseIdProvider getDatabaseIdProvider(){
        DatabaseIdProvider databaseIdProvider = new VendorDatabaseIdProvider();
        Properties properties = new Properties();
        properties.setProperty("Oracle","oracle");
        properties.setProperty("MySQL","mysql");
        properties.setProperty("DB2","db2");
        properties.setProperty("Derby","derby");
        properties.setProperty("H2","h2");
        properties.setProperty("HSQL","hsql");
        properties.setProperty("Informix","informix");
        properties.setProperty("MS-SQL","ms-sql");
        properties.setProperty("PostgreSQL","postgresql");
        properties.setProperty("Sybase","sybase");
        properties.setProperty("Hana","hana");
        databaseIdProvider.setProperties(properties);
        return databaseIdProvider;
    }
}
