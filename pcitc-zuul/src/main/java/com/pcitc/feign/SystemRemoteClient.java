package com.pcitc.feign;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.alibaba.fastjson.JSONObject;
import com.pcitc.base.system.SysUser;

/**
 * @author zhf 
 * 2017-11-15 
 * 1、FeignClient接口中，如果使用到@PathVariable ，必须指定其value
 * 2、FeignClient接口，不能使用@GettingMapping 之类的组合注解 
 * 3、Feign如果想要使用HystrixStream，需要做一些额外操作 
 * 4、如果需要自定义单个Feign配置，Feign的@Configuration注解的类不能与@ComponentScan 的包重叠
 * 默认支持注解：@RequestMapping、@RequestParam、@RequestHeader、@PathVariable
 */
@FeignClient(value = "pcitc-system-provider", fallback = SystemHystric.class)
public interface SystemRemoteClient {

	/**
	 * 查询用户信息
	 * @author zhf
	 * @date 2017年11月29日 下午1:45:24 FeignClient接口中，不能使用@GettingMapping 之类的组合注解
	 */
	@RequestMapping(value = "/user-provider/user/get-user/{userId}", method = RequestMethod.GET)
	public SysUser selectUserByUserId(@PathVariable(name = "userId") String userId);
	/**
	 * 查询用户信息
	 * @author zhf
	 * @date 2017年11月29日 下午1:45:24 FeignClient接口中，不能使用@GettingMapping 之类的组合注解
	 */
	@RequestMapping(value = "/user-provider/user/get-user-byname/{username}", method = RequestMethod.GET)
	public SysUser selectUserByUserName(@PathVariable(name = "username") String username);
	
	/** 
	* @author zhf
	* @date 2018年5月17日 下午1:51:15 
	* 包含user基本信息、菜单信息
	*/
	@RequestMapping(value = "/user-provider/user/user-details/{userId}", method = RequestMethod.GET)
	public SysUser selectUserDetailsByUserId(@PathVariable(value = "userId", required = true) String userId);
	
	/** 
	* @author zhf
	* @date 2018年8月24日 下午1:51:15 
	* 包含user详细信息
	*/
	@RequestMapping(value = "/user-provider/user/details", method = RequestMethod.POST)
	public JSONObject selectUserDetail(@RequestParam(value="jsonStr", required=false) String jsonStr);
	
}
