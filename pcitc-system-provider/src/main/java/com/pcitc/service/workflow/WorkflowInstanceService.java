package com.pcitc.service.workflow;

import com.alibaba.fastjson.JSONObject;
import com.pcitc.base.workflow.SysFunctionProdef;
import com.pcitc.base.workflow.WorkflowVo;

public interface WorkflowInstanceService {

    /**
     * 获取菜单的已经配置的工作流定义、项目、部门等信息
     * @param functionId
     * @return
     */
    public JSONObject selectFunctionProcessDefineList(String jsonStr);
    
    /**
     * 保存菜单配置的项目、部门
     * @param prodef
     * @return
     */
    public Integer insertFunctionProdef(SysFunctionProdef prodef);
    
    
    /**
     * @param prodef
     * @return
     * 查询已有的工作流定义，通过functionid、projectId、orgId
     */
    public SysFunctionProdef queryFunctionProdef(WorkflowVo workflowVo);
    
    /**
     * 删除菜单的工作流配置
     * @param prodef
     * @return
     */
    public Integer deleteFunctionProdef(String functionProdefId);
	
}
