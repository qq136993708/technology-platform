package com.pcitc.service.achieve.impl;

import com.alibaba.fastjson.JSONObject;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.pcitc.base.achieve.AchieveBase;
import com.pcitc.base.common.Constant;
import com.pcitc.base.common.Result;
import com.pcitc.base.expert.ZjkBase;
import com.pcitc.base.util.IsEmptyUtil;
import com.pcitc.mapper.achieve.AchieveBaseMapper;
import com.pcitc.service.achieve.AchieveBaseService;
import com.pcitc.service.feign.WorkflowRemoteClient;

import com.pcitc.service.file.FileCommonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

/**
 * @author
 */
@Service
public class AchieveBaseServiceImpl implements AchieveBaseService {

    @Autowired
    private AchieveBaseMapper abm;

	@Autowired
	private FileCommonService fs;
    
    
    @Autowired
	private WorkflowRemoteClient workflowRemoteClient;
    
    

    @Override
    public AchieveBase load(String id) {
        return abm.load(id);
    }

    @Override
    public Integer save(AchieveBase ab) {

        IsEmptyUtil.isEmpty(ab.getId());
        if(load(ab.getId()) ==null){
            ab.setCreateDate(ab.getUpdateDate());
            ab.setCreator(ab.getUpdator());
			//fs.updateFileData(ab.getFileDoc(),ab.getId(),ab.getSecretLevel());
			handlerFile(ab.getFileDoc(),ab.getSecretLevel());
            return abm.add(ab);
        }
        else{
			//fs.updateFileData(ab.getFileDoc(),ab.getId(),ab.getSecretLevel());
			handlerFile(ab.getFileDoc(),ab.getSecretLevel());
            return abm.update(ab);
        }

    }


	private void handlerFile(String files,String secretLevel){
		if(files != null){
			JSONObject fileDoc =  JSONObject.parseObject(files);
			for(String key:fileDoc.keySet()){
				fs.updateFileData(fileDoc.get(key) == null?"":fileDoc.get(key).toString(),key,secretLevel);
			}
		}
	}

    @Override
    public Integer delete(String id) {
        return abm.delete(id);
    }

    @Override
    public PageInfo query(Map param) {
        int pageNum = (int)param.get("pageNum");
        int pageSize = (int)param.get("pageSize");
        PageHelper.startPage(pageNum, pageSize);
        List dataList = abm.query(param);
        PageInfo pageInfo = new PageInfo(dataList);
        return pageInfo;
    }
    
    
        //流程
  		public Result dealWorkFlow(String id, Map map) throws Exception
  		{
  			
  			
  			JSONObject parmamss = JSONObject.parseObject(JSONObject.toJSONString(map));
  			System.out.println(">>>>>>>>>>流程 dealWorkFlow 参数: "+parmamss.toJSONString());
  			
  			AchieveBase achieveBase= abm.load(id);
  			String processInstanceName=(String)map.get("processInstanceName");
  			String authenticatedUserId=(String)map.get("authenticatedUserId");
  			String authenticatedUserName=(String)map.get("authenticatedUserName");
  			String functionId=(String)map.get("functionId");
  			String auditor=(String)map.get("auditor");
  			
  			//指定岗位
  			String specialAuditor1=(String)map.get("specialAuditor1");
  			String branchFlag=(String)map.get("branchFlag");
  			
  			
  			
  			// 调用审批流程，此处调用同时实现事务
  	    	JSONObject flowJson = new JSONObject();
  	    	// 业务主键id
  	    	flowJson.put("businessId", id);
  	    	flowJson.put("processInstanceName", processInstanceName);
  	    	// 发起者信息
  	    	flowJson.put("authenticatedUserId", authenticatedUserId);
  	    	flowJson.put("authenticatedUserName", authenticatedUserName);
  			// 菜单id（functionId），部门/组织ID（orgId），项目id（projectId）。其中菜单id必填（和ProcessDefineId两选一）
  	    	flowJson.put("functionId", functionId);
  	    	// 待办业务详情、最终审批同意、最终审批不同意路径
  	    	flowJson.put("auditDetailsPath", "/kjpt/achieve/apply_view.html?type=view&flag=1&id=" + id);
  	    	flowJson.put("auditAgreeMethod", "http://kjpt-zuul/stp-proxy/achieve-api/task/agree/" + id);
  	    	flowJson.put("auditRejectMethod", "http://kjpt-zuul/stp-proxy/achieve-api/task/reject/" + id);

  	    	// 非必填选项， 菜单功能需要根据不同单位、不同项目选择不同流程图的时候使用。（也可以在单个流程图中，用判断来做）
  	    	// flowJson.put("flowProjectId", "");
  	    	// flowJson.put("flowUnitId", "");
  	    	flowJson.put("branchFlag", branchFlag);
  	    	// 非必填选项，当下一步审批者需要本次任务执行人（启动者）手动选择的时候，需要auditUserIds属性
  	    	
  	    	
  	    	if (auditor!=null && !auditor.equals("")) 
  			{
  				String[] userIds_arr = auditor.split(",");
  				flowJson.put("auditor", Arrays.asList(userIds_arr));
  			}
  	    	
  	    	
  	    	
  	    	// 非必填选项, 会签时需要的属性，会签里所有的人，同意率（double类型）
  	    	// flowJson.put("specialAuditor0", "ZBGL_KTY_CYDW");
  	    	flowJson.put("specialAuditor1", specialAuditor1);
  	    	flowJson.put("signAuditRate", 1d); 
  	    	
  	    	// 远程调用
  	    	System.out.println("=====远程调用开始");
  	    	String str=workflowRemoteClient.startCommonWorkflow(flowJson.toJSONString());
  	    	System.out.println("=====远程调用结束");
  			if("true".equals(str)) 
  			{
  				achieveBase.setAuditStatus(Constant.AUDIT_STATUS_SUBMIT);
  				abm.update(achieveBase);
  				return new Result(true,"操作成功!");
  			}else 
  			{
  				return new Result(false,"操作失败!");
  			}
  		}

	@Override
	public Integer updatePublicStatus(Map map) {
		return abm.updatePublicStatus(map);
	}


}
