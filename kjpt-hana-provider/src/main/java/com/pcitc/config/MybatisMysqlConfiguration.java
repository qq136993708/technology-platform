package com.pcitc.config;

import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;

/**
 * @author zhf
 * 2018-09-20 mysql配置
 */
@Configuration
@MapperScan(basePackages = {"com.pcitc.mysqlMapper.*"}, sqlSessionFactoryRef = "mysqlSqlSessionFactory")
public class MybatisMysqlConfiguration {
	
	@Autowired
	private Environment env;
	
	@Autowired
    @Qualifier("mysqlDS")
    private DataSource mysqlDS;
	
	@Bean
    public SqlSessionFactory mysqlSqlSessionFactory() throws Exception {
        SqlSessionFactoryBean factoryBean = new SqlSessionFactoryBean();
        factoryBean.setDataSource(mysqlDS); 
        
        System.out.println("1=================="+mysqlDS);
        System.out.println("2=================="+mysqlDS.getConnection().toString());
        
        factoryBean.setTypeAliasesPackage(env.getProperty("mybatis.typeAliasesPackage"));// 指定基包
        factoryBean.setMapperLocations(new PathMatchingResourcePatternResolver().getResources(env.getProperty("mybatis.mapperLocations")));//
        System.out.println("3=================="+env.getProperty("mybatis.typeAliasesPackage"));

        return factoryBean.getObject();

    }

    @Bean
    public SqlSessionTemplate mysqlSqlSessionTemplate() throws Exception {
        SqlSessionTemplate template = new SqlSessionTemplate(mysqlSqlSessionFactory());
        return template;
    }
	
}
