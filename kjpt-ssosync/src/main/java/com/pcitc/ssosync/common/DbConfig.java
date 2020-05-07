package com.pcitc.ssosync.common;


import com.alibaba.druid.filter.config.ConfigTools;
import com.alibaba.druid.pool.DruidDataSource;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import javax.sql.DataSource;
import java.security.PublicKey;
import java.util.Base64;


/**
 * @author admin
 */
@Configuration
@Component
public class DbConfig {
    private static final String MAPPER_LOCATION = "classpath*:mapper/*.xml";

    @Value("${spring.datasource.druid.url}")
    private String dbUrl;

    @Value("${spring.datasource.druid.username}")
    private String username;

    @Value("${spring.datasource.druid.password}")
    private String password;

    @Value("${spring.datasource.druid.driverClassName}")
    private String driverClassName;

    @Value("${spring.datasource.type}")
    private String dbType;

    @Value("${spring.datasource.druid.initial-size}")
    private int initialSize;

    @Value("${spring.datasource.druid.min-idle}")
    private int minIdle;

    @Value("${spring.datasource.druid.max-active}")
    private int maxActive;

    @Value("${spring.datasource.druid.max-wait}")
    private int maxWait;

    @Value("${spring.datasource.druid.time-between-eviction-runs-millis}")
    private int timeBetweenEvictionRunsMillis;

    @Value("${spring.datasource.druid.min-evictable-idle-time-millis}")
    private int minEvictableIdleTimeMillis;


    @Value("${spring.datasource.druid.validation-query}")
    private String validationQuery;


    @Value("${publickey:}")
    private String publicKey;

    @Value("${publickeyfile:}")
    private String publicKeyFile;

    @Bean(name = "dataSource")
    @Primary
    public DataSource dataSource() throws Exception {
        DruidDataSource datasource = new DruidDataSource();
        datasource.setUrl(dbUrl);
        datasource.setUsername(username);

        String pwd = password;
        if(!StringUtils.isEmpty(publicKeyFile)) {
            PublicKey pk = ConfigTools.getPublicKeyByPublicKeyFile(publicKeyFile);
            byte[] b = pk.getEncoded();
            System.out.println("key=" + Base64.getEncoder().encodeToString(b));
            pwd = ConfigTools.decrypt(pk, password);
        } else if (!StringUtils.isEmpty(publicKey)){
            pwd = ConfigTools.decrypt(publicKey, password);
        }
        datasource.setPassword(pwd);
        datasource.setDriverClassName(driverClassName);
        datasource.setInitialSize(initialSize);
        datasource.setMinIdle(minIdle);
        datasource.setMaxActive(maxActive);
        datasource.setMaxWait(maxWait);
        datasource.setTimeBetweenEvictionRunsMillis(timeBetweenEvictionRunsMillis);
        datasource.setMinEvictableIdleTimeMillis(minEvictableIdleTimeMillis);
        datasource.setValidationQuery(validationQuery);
        //datasource.setDbType(dbType);
        return datasource;
    }

    @Bean(name = "transactionManager")
    @Primary
    public DataSourceTransactionManager transactionManager() throws Exception {
        return new DataSourceTransactionManager(dataSource());
    }

    @Bean(name = "sqlSessionFactory")
    @Primary
    public SqlSessionFactory sqlSessionFactory(@Qualifier("dataSource") DataSource dataSource)
            throws Exception {
        final SqlSessionFactoryBean sessionFactory = new SqlSessionFactoryBean();
        sessionFactory.setDataSource(dataSource);
        sessionFactory.setMapperLocations(new PathMatchingResourcePatternResolver()
                .getResources(DbConfig.MAPPER_LOCATION));
        sessionFactory.getObject().getConfiguration().setMapUnderscoreToCamelCase(true);
        return sessionFactory.getObject();
    }
}