package com.pcitc.service.feign.hana;

import java.util.HashMap;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.alibaba.fastjson.JSONArray;

/**
 * @author zhf 
 * 2017-11-15 
 * 1、FeignClient接口中，如果使用到@PathVariable ，必须指定其value
 * 2、FeignClient接口，不能使用@GettingMapping 之类的组合注解 
 * 3、Feign如果想要使用HystrixStream，需要做一些额外操作 
 * 4、如果需要自定义单个Feign配置，Feign的@Configuration注解的类不能与@ComponentScan 的包重叠
 * 默认支持注解：@RequestMapping、@RequestParam、@RequestHeader、@PathVariable
 */
@FeignClient(value = "pcitc-hana-provider", fallback = OutProjectHystric.class)
public interface OutProjectRemoteClient {

	

	
	@RequestMapping(value = "/hana/country-project/list")
	public JSONArray getLastCountryProject(@RequestBody HashMap<String, String> map);
	

}
