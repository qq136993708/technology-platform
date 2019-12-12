package com.pcitc.filepreview;

import com.google.common.base.Predicate;
import org.springframework.boot.autoconfigure.web.servlet.error.BasicErrorController;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import springfox.documentation.RequestHandler;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.ParameterBuilder;
import springfox.documentation.schema.ModelRef;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Parameter;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.ArrayList;
import java.util.List;

/**
 * @author ty
 * 访问链接：http://localhost:7901/swagger-ui.html
 */
@Configuration
//@ConditionalOnProperty(name = "swagger.enable", havingValue = "false")//如果关闭就把havingValue改为false
@EnableSwagger2
public class Swagger2 {


	@Bean
	public Docket createRestApi() {

		Predicate<RequestHandler> predicate = input -> {
			Class<?> declaringClass = input.declaringClass();
			if (declaringClass == BasicErrorController.class) {
				// 排除
				return false;
			}
			if (declaringClass.isAnnotationPresent(RestController.class)) {
				// 被注解的类
				return true;
			}
			if (input.isAnnotatedWith(ResponseBody.class)) {
				// 被注解的方法
				return true;
			}
			return false;
		};

		List<Parameter> pars = new ArrayList<>();

		ParameterBuilder sortFieldPar = new ParameterBuilder();
		sortFieldPar.name("sortField").description("排序字段").modelRef(new ModelRef("string")).parameterType("query")
				.required(false).build();
		pars.add(sortFieldPar.build());

		ParameterBuilder sortDirPar = new ParameterBuilder();
		sortDirPar.name("sortDir").description("排序方式").modelRef(new ModelRef("string")).parameterType("query")
				.required(false).build();
		pars.add(sortDirPar.build());



		ParameterBuilder pageNumPar = new ParameterBuilder();
		pageNumPar.name("pageNum").description("页码").modelRef(new ModelRef("string")).parameterType("query")
				.required(false).build();
		pars.add(pageNumPar.build());

		ParameterBuilder pageSizePar = new ParameterBuilder();
		pageSizePar.name("pageSize").description("页大小").modelRef(new ModelRef("string")).parameterType("query")
				.required(false).build();
		pars.add(pageSizePar.build());


		return new Docket(DocumentationType.SWAGGER_2).apiInfo(apiInfo()).useDefaultResponseMessages(false).select()
				.apis(predicate).build();
	}

	private ApiInfo apiInfo() {

		return new ApiInfoBuilder()
				.title("测试")
				.version("1.0")
				.build();

	}

}
