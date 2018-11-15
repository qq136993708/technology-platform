package com.pcitc.feign;

import org.springframework.stereotype.Component;

import com.alibaba.fastjson.JSONObject;
import com.pcitc.base.system.SysUser;

/**
 * @author zhf 2017-11-28 断路器设置，当访问pcitc-system-provider时，进行断路处理
 */
@Component
public class SystemHystric implements SystemRemoteClient {

	@Override
	public SysUser selectUserByUserId(String id) {
		System.out.println("sorry，访问selectUserByUserId错误，请调整。返回null");
		return null;
	}
	
	@Override
	public SysUser selectUserDetailsByUserId(String id) {
		System.out.println("sorry，访问selectUserDetailsByUserId错误，请调整。返回null");
		return null;
	}

	@Override
	public SysUser selectUserByUserName(String username) {
		System.out.println("sorry，访问selectUserByUserId错误，请调整。返回null");
		return null;
	}
	
	@Override
	public JSONObject selectUserDetail(String jsonStr) {
		System.out.println("sorry，访问selectUserDetail错误，请调整。返回null");
		return null;
	}

}
