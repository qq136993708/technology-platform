package com.pcitc.service.feign;

import java.util.List;

import com.pcitc.base.system.SysDictionary;
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

	@Override
	public List<SysDictionary> getDictionaryListByParentCode(String parentCode) {
		getSysPostByCode("获取字典异常");
		return null;
	}

}
