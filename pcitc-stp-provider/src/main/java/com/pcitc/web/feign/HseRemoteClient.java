/*package com.pcitc.web.feign;

import java.util.List;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.pcitc.base.hse.Hse;

import net.sf.json.JSONObject;

*//**
 * @author zhf 
 * 2017-11-15 
 * 1、FeignClient接口中，如果使用到@PathVariable ，必须指定其value
 * 2、FeignClient接口，不能使用@GettingMapping 之类的组合注解 
 * 3、Feign如果想要使用HystrixStream，需要做一些额外操作 
 * 4、如果需要自定义单个Feign配置，Feign的@Configuration注解的类不能与@ComponentScan 的包重叠
 * 默认支持注解：@RequestMapping、@RequestParam、@RequestHeader、@PathVariable
 *//*
@FeignClient(value = "pplus-hse-provider", fallback = HseHystric.class)
public interface HseRemoteClient {

	*//**
	 * @author zhf
	 * @date 2017年11月29日 下午1:45:24 FeignClient接口中，不能使用@GettingMapping 之类的组合注解
	 *//*
	@RequestMapping(value = "/hse-provider/hse/{hseId}", method = RequestMethod.GET)
	public Hse selectHseByHseId(@PathVariable(name = "hseId") Integer hseId);

	*//**
	 * 插入
	 * 
	 * @param hse
	 * @return
	 *//*
	@RequestMapping(value = "/hse-provider/add-hse", method = RequestMethod.POST)
	public Integer insertHse(@RequestBody Hse hse);

	*//**
	 * 修改
	 * 
	 * @param hse
	 * @return
	 *//*
	@RequestMapping(value = "/hse-provider/update-hse", method = RequestMethod.POST)
	public Integer updateHse(@RequestBody Hse hse);
	

	@RequestMapping(value = "/hse-provider/all-hses", method = RequestMethod.GET)
	public List<Hse> getAllHses();
	
	*//**
	 * 删除
	 * 
	 * @param hseId
	 * @return
	 *//*
	@RequestMapping(value = "/hse-provider/delete-hse/{hseId}", method = RequestMethod.POST)
	public int deleteHseByHseId(@PathVariable(name = "hseId") Integer hseId);

	*//**
	 * 条件查询列表
	 * 
	 * @param hseExample
	 * @return
	 *//*
	@RequestMapping(value = "/hse-provider/hses-page", method = RequestMethod.GET)
	public JSONObject selectHseByPage(@RequestParam("jsonStr") String jsonStr);


}
*/