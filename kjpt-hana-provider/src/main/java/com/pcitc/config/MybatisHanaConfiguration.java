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
@MapperScan(basePackages = {"com.pcitc.mapper.*"}, sqlSessionFactoryRef = "hanaSqlSessionFactory")
public class MybatisHanaConfiguration {
	
	@Autowired
	private Environment env;
	
	@Autowired
    @Qualifier("hanaDS")
    private DataSource hanaDS;
	
	@Bean
    public SqlSessionFactory hanaSqlSessionFactory() throws Exception {
        SqlSessionFactoryBean factoryBean = new SqlSessionFactoryBean();
        System.out.println("1=================="+hanaDS);
        System.out.println("2=================="+hanaDS.getConnection().toString());
        factoryBean.setDataSource(hanaDS);
        
        factoryBean.setTypeAliasesPackage(env.getProperty("mybatis.typeAliasesPackage"));// 指定基包
        factoryBean.setMapperLocations(new PathMatchingResourcePatternResolver().getResources(env.getProperty("mybatis.mapperLocations")));//
        System.out.println("3=================="+env.getProperty("mybatis.typeAliasesPackage"));

        return factoryBean.getObject();

    }

    @Bean
    public SqlSessionTemplate hanaSqlSessionTemplate() throws Exception {
        SqlSessionTemplate template = new SqlSessionTemplate(hanaSqlSessionFactory()); // 使用上面配置的Factory
        return template;
    }
	
}
