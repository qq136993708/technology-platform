package com.pcitc.web.config;

import com.google.common.base.Predicate;
import com.google.common.base.Predicates;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import springfox.documentation.RequestHandler;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * @author zhf
 * 2017-07-16 
 * swagger配置
 *
 */
@EnableSwagger2
@Configuration
public class SwaggerConfig {

    @Bean
    public Docket createRestApi() {

        Predicate<RequestHandler> restfulApi = Predicates.or(
                RequestHandlerSelectors.withClassAnnotation(RestController.class),
                RequestHandlerSelectors.withClassAnnotation(Controller.class)
        );

        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .select()
                .apis(restfulApi)//扫描RestController的api文档
                .paths(PathSelectors.any())//路径判断
                .build();
    }

    private ApiInfo apiInfo() {
      return new ApiInfoBuilder()
                .title("Swagger 开发规范")//标题
                .description("Saggger 开发规范详文档细地址--->>>>>>>：http://www.google.com.hk")//描述
                .termsOfServiceUrl("http://www.google.com.hk")//（不可见）条款地址
                .version("6.6.6")//版本号
                .build();
    }

}