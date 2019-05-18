package com.pcitc.service.feign;

import java.util.List;

import javax.servlet.http.HttpServletResponse;

import com.pcitc.base.common.LayuiTableData;
import com.pcitc.base.common.LayuiTableParam;
import com.pcitc.base.expert.ZjkExtractConfig;
import com.pcitc.base.stp.out.OutUnit;
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

	@Override
	public List<OutUnit> selectProjectUnits(String define2)
	{
		System.out.println("执行断路器。。。。。。。。");
		return null;
	}

    @Override
    public ZjkExtractConfig getZjkExtractConfigInfo(String id) {
        return null;
    }

	@Override
	public LayuiTableData selectProjectPlanByCond(LayuiTableParam param) {
		return null;
	}

	@Override
	public LayuiTableData selectCommonProjectByCond(LayuiTableParam param) {
		return null;
	}

}
