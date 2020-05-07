package com.pcitc.ssosync;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import koal.urm.client.action.ResServiceServlet;
/**
 * @author admin
 */
@EnableCaching
@Configuration
@MapperScan("com.pcitc.ssosync.mapper")
@SpringBootApplication
public class SsoSyncApplication {
    public static void main(String[] args) {
        SpringApplication.run(SsoSyncApplication.class, args);
    }



    @Bean
    public ServletRegistrationBean getServletRegistrationBean() {  //一定要返回ServletRegistrationBean
        ServletRegistrationBean bean = new ServletRegistrationBean(new ResServiceServlet());
        bean.addInitParameter("resDaoClass", "com.pcitc.ssosync.rpcdao.ResRecvDaoImp");
        bean.addInitParameter("daoType", "2");

        //放入自己的Servlet对象实例
        bean.addUrlMappings("/resReg");  //访问路径值
        return bean;
    }
}

