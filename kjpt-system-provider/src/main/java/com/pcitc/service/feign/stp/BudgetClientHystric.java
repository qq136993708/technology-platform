package com.pcitc.service.feign.stp;

import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestBody;

import com.pcitc.base.stp.budget.vo.BudgetItemSearchVo;

/**
 * @author zhf 2019-02-11 断路器设置，当访问pplus-stp-provider时，进行断路处理
 */
@Component
public class BudgetClientHystric implements BudgetClient {

	@Override
	public BudgetItemSearchVo selectBudgetInfoList(@RequestBody BudgetItemSearchVo vo) {
		System.out.println("=====feign远程访问预算=====");
		BudgetItemSearchVo temVo = new BudgetItemSearchVo();
		return temVo;
	}
	 

}