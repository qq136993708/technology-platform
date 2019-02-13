package com.pcitc.service.feign.stp;

import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestBody;

import com.pcitc.base.stp.flow.FlowProjectInfo;

/**
 * @author zhf 2019-02-11 断路器设置，当访问pplus-stp-provider时，进行断路处理
 */
@Component
public class FlowProjectHystric implements FlowProjectRemoteClient {

	@Override
	public Integer insertFlowProjectInfo(@RequestBody FlowProjectInfo flowProjectInfo) {
		System.out.println("=====远程保存科研课题数据异常，查看微服务日志");
		return null;
	}
	 

}