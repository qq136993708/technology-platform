package com.pcitc.web.feign;

import java.util.List;

import org.springframework.stereotype.Component;

import com.pcitc.base.system.SysPost;
import com.pcitc.base.system.SysUser;
import com.pcitc.base.workflow.WorkflowVo;

@Component
public class SystemHystric implements SystemRemoteClient {

	@Override
	public String startWorkflowByProcessDefinitionId(WorkflowVo workflowVo) {
		System.out.println("执行断路器。。。。。。。。");
		return null;
	}

	@Override
	public List<SysUser> selectUsersByPostCode(String postCode) {
		System.out.println("执行断路器。。。。。。。。");
		return null;
	}

	@Override
	public SysPost getSysPostByCode(String postCode) {
		System.out.println("执行断路器。。。。。。。。");
		return null;
	}

}
