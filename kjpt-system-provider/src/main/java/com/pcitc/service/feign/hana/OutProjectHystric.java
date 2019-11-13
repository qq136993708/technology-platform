package com.pcitc.service.feign.hana;

import java.util.HashMap;

import org.springframework.stereotype.Component;

import com.alibaba.fastjson.JSONArray;

/**
 * @author zhf 2017-11-28 断路器设置，当访问pplus-hse-provider时，进行断路处理
 */
@Component
public class OutProjectHystric implements OutProjectRemoteClient {

	@Override
	public JSONArray getLastCountryProject(HashMap<String, String> map) {
		System.out.println("=====读取国家项目数据异常，查看hana微服务日志");
		return null;
	}
	 
	@Override
	public JSONArray getExpensesPayInfo(HashMap<String, String> map) {
		System.out.println("=====获取hana中报销费用挂账清账信息");
		return null;
	}

}