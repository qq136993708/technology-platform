package com.pcitc.web.interceptor;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.mvc.condition.PatternsRequestCondition;
import org.springframework.web.servlet.mvc.condition.RequestMethodsRequestCondition;
import org.springframework.web.servlet.mvc.method.RequestMappingInfo;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerMapping;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

public class UrlAnnotation {
	@Autowired
	private WebApplicationContext applicationContext;
	public List getAllUrl() {
	    RequestMappingHandlerMapping mapping = applicationContext.getBean(RequestMappingHandlerMapping.class);
	    // 获取url与类和方法的对应信息
	    Map<RequestMappingInfo, HandlerMethod> map = mapping.getHandlerMethods();

	    List<Map<String, String>> list = new ArrayList<Map<String, String>>();
	    for (Map.Entry<RequestMappingInfo, HandlerMethod> m : map.entrySet()) {
	        Map<String, String> map1 = new HashMap<String, String>();
	        RequestMappingInfo info = m.getKey();
	        HandlerMethod method = m.getValue();
	        //获取当前方法所在类名
	        Class<?> bean = method.getBeanType();
	        //使用反射获取当前类注解内容
	        Api api = bean.getAnnotation(Api.class);
	        RequestMapping requestMapping = bean.getAnnotation(RequestMapping.class);
			String[] value = requestMapping.value();
			map1.put("parent",value[0]);
	        //获取方法上注解以及注解值
	        ApiOperation methodAnnotation = method.getMethodAnnotation(ApiOperation.class);
	        String privilegeName = methodAnnotation.notes();
	        PatternsRequestCondition p = info.getPatternsCondition();
	        for (String url : p.getPatterns()) 
	        {
	            map1.put("url", url);
	        }
	        map1.put("className", method.getMethod().getDeclaringClass().getName()); // 类名
	        map1.put("method", method.getMethod().getName()); // 方法名
	        RequestMethodsRequestCondition methodsCondition = info.getMethodsCondition();
	        for (RequestMethod requestMethod : methodsCondition.getMethods()) {
	            map1.put("type", requestMethod.toString());
	        }
	        
	        list.add(map1);
	    }
		return list;
	}
}
