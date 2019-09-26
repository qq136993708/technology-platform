package com.pcitc.service.feign.stp;

import io.swagger.annotations.ApiOperation;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.pcitc.base.stp.budget.vo.BudgetItemSearchVo;

/**
 * @author zhf
 * 获取预算相关的信息
 * 2019-07-05
 * 1、FeignClient接口中，如果使用到@PathVariable ，必须指定其value
 * 2、FeignClient接口，不能使用@GettingMapping 之类的组合注解 
 * 3、Feign如果想要使用HystrixStream，需要做一些额外操作 
 * 4、如果需要自定义单个Feign配置，Feign的@Configuration注解的类不能与@ComponentScan 的包重叠
 * 默认支持注解：@RequestMapping、@RequestParam、@RequestHeader、@PathVariable
 */
@FeignClient(value = "pcitc-stp-provider")
public interface ExpenseJobClient {
	
	
	
	
	
	//private static final String	INSERT_EXPENSES		= "http://pcitc-zuul/stp-proxy/expenses/add";
	//private static final String	MAX_EXPENSES		= "http://pcitc-zuul/stp-proxy/expenses/max-date/update";
	
	
	@ApiOperation(value="查询最大的更新时间",notes="查询最大的更新时间")
	@RequestMapping(value = "/expenses/max-date/update", method = RequestMethod.POST)
	public String selectMaxUpdate();
	
	
	
	@ApiOperation(value = "批量保存费用报销数据", notes = "审批信息、费用信息等")
	@RequestMapping(value = "/expenses/add", method = RequestMethod.POST)
	public String saveExpenses(@RequestBody String jsonStr) throws Exception;
	
	
	
	
	

}
