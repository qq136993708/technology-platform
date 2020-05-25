package com.pcitc.service.achieve.impl;

import com.alibaba.fastjson.JSONObject;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.pcitc.base.achieve.AchieveRecord;
import com.pcitc.base.achieve.AchieveReward;
import com.pcitc.base.achieve.AchieveSubmit;
import com.pcitc.base.common.Constant;
import com.pcitc.base.common.Result;
import com.pcitc.base.util.IsEmptyUtil;
import com.pcitc.mapper.achieve.AchieveRecordMapper;
import com.pcitc.mapper.achieve.AchieveRewardMapper;
import com.pcitc.service.achieve.AchieveRecordService;
import com.pcitc.service.feign.WorkflowRemoteClient;
import com.pcitc.service.file.FileCommonService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

/**
 * @author
 */
@Service
public class AchieveRecordServiceImpl implements AchieveRecordService {

    @Autowired
    private AchieveRecordMapper arm;

    @Autowired
    private AchieveRewardMapper arw;

    @Autowired
    private FileCommonService fs;
    
    @Autowired
  	private WorkflowRemoteClient workflowRemoteClient;
    
    
    

    @Override
    public AchieveRecord load(String id) {
        AchieveRecord ar = arm.load(id);
        if(ar == null){
            return null;
        }
        ar.setAchieveRewards(arw.getByRecordId(id));
        return ar;
    }


    /**
     * 录入备案信息的保存
     * @param as
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public void save(AchieveSubmit as) {

        AchieveRecord aRecord = as.getAchieveRecord();
        AchieveReward aReward = as.getAchieveReward();
        IsEmptyUtil.isEmpty(aRecord);
        if(arm.load(aRecord.getId()) ==null){
            aRecord.setCreateDate(as.getUpdateDate());
            aRecord.setCreator(as.getUpdator());
            handlerFile(aRecord.getFiles(),aRecord.getSecretLevel());
            aRecord.setKnowledgePerson(as.getKnowledgePerson());
            aRecord.setKnowledgeScope(as.getKnowledgeScope());
            arm.add(aRecord);
        }
        else{
            handlerFile(aRecord.getFiles(),aRecord.getSecretLevel());
            arm.update(aRecord);
        }

        if(aReward != null){
            aReward.setCreateDate(as.getUpdateDate());
            aReward.setCreator(as.getUpdator());
            aRecord.setCreateUnitName(as.getCreateUnitName());
            aRecord.setCreateUnitId(as.getCreateUnitId());
            saveReward(aReward);
        }

    }

    private void saveReward(AchieveReward ab) {
        IsEmptyUtil.isEmpty(ab.getId());
        if(arw.load(ab.getId()) ==null){
            ab.setCreateDate(ab.getUpdateDate());
            ab.setCreator(ab.getUpdator());
            handlerFile(ab.getFiles(),ab.getSecretLevel());
            arw.add(ab);
        }
        else{
            handlerFile(ab.getFiles(),ab.getSecretLevel());
            arw.update(ab);

        }
        arw.updateRewardMoney(ab.getAchieveId());
    }

    /**
     * 备案的新增保存
     * @param as
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public void simpleSave(AchieveSubmit as) {
        AchieveRecord aRecord = as.getAchieveRecord();
        AchieveReward aReward = as.getAchieveReward();
        IsEmptyUtil.isEmpty(aRecord);
        if(arm.load(aRecord.getId()) ==null){
            aRecord.setCreateDate(as.getUpdateDate());
            aRecord.setCreator(as.getUpdator());
            aRecord.setCreateUnitName(as.getCreateUnitName());
            aRecord.setCreateUnitId(as.getCreateUnitId());
            aRecord.setKnowledgePerson(as.getKnowledgePerson());
            aRecord.setKnowledgeScope(as.getKnowledgeScope());
            arm.add(aRecord);
        }
        else{
            arm.update(aRecord);
        }
        if(aReward != null){
            aRecord.setCreateUnitName(as.getCreateUnitName());
            aRecord.setCreateUnitId(as.getCreateUnitId());
            simpleSaveReward(aReward);
        }
    }

    private void simpleSaveReward(AchieveReward ab) {
        IsEmptyUtil.isEmpty(ab.getId());
        if(load(ab.getId()) ==null){
            ab.setCreateDate(ab.getUpdateDate());
            ab.setCreator(ab.getUpdator());
            arw.add(ab);
        }
        else{
            arw.update(ab);

        }
        arw.updateRewardMoney(ab.getAchieveId());
    }

    private void handlerFile(String files,String secretLevel){
        if(StringUtils.isNotBlank(files)){
            JSONObject fileDoc =  JSONObject.parseObject(files);
            for(String key:fileDoc.keySet()){
                fs.updateFileData(fileDoc.get(key) == null?"":fileDoc.get(key).toString(),key,secretLevel);
            }
        }
    }

    @Override
    public Integer delete(String ids) {
        String[] idArr = ids.split(",");
        return arm.delete(idArr);
    }

    @Override
    public PageInfo query(Map param) {
        int pageNum = (int)param.get("pageNum");
        int pageSize = (int)param.get("pageSize");
        PageHelper.startPage(pageNum, pageSize);
        List dataList = arm.query(param);
        PageInfo pageInfo = new PageInfo(dataList);
        return pageInfo;
    }

    @Override
    public PageInfo queryAchieveSubsidiarity(Map param) {
        int pageNum = (int)param.get("pageNum");
        int pageSize = (int)param.get("pageSize");
        PageHelper.startPage(pageNum, pageSize);
        List dataList = arm.queryAchieveSubsidiarity(param);
        PageInfo pageInfo = new PageInfo(dataList);
        return pageInfo;
    }

    @Override
    public Integer saveAchieveRecord(AchieveRecord as)
    {
    	return arm.update(as);
    }

    @Override
    public List<AchieveRecord> queryNoPage(Map paramMap) {
        List dataList = arm.query(paramMap);
        return dataList;
    }
  
    
    
    //流程
        @Override
		public Result dealWorkFlow(String id, Map map) throws Exception
		{
			
			
			JSONObject parmamss = JSONObject.parseObject(JSONObject.toJSONString(map));
			System.out.println(">>>>>>>>>>流程 dealWorkFlow 参数: "+parmamss.toJSONString());
			
			AchieveRecord achieveBase= arm.load(id);
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
	    	flowJson.put("auditDetailsPath", "/kjpt/achieve/record_input.html?type=view&id=" + id);
	    	flowJson.put("auditAgreeMethod", "http://kjpt-zuul/stp-proxy/achieveRecord-api/task/agree/" + id);
	    	flowJson.put("auditRejectMethod", "http://kjpt-zuul/stp-proxy/achieveRecord-api/task/reject/" + id);

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
				arm.update(achieveBase);
				return new Result(true,"操作成功!");
			}else 
			{
				return new Result(false,"操作失败!");
			}
		}

    @Override
    public List<Map> queryAchieveSubsidiarityExport(Map param) {
        return arm.queryAchieveSubsidiarity(param);
    }


}
