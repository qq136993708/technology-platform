package com.pcitc.service.workflow.impl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.UUID;

import org.activiti.engine.task.IdentityLink;
import org.activiti.engine.task.IdentityLinkType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.alibaba.fastjson.JSONObject;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.pcitc.base.common.LayuiTableData;
import com.pcitc.base.common.LayuiTableParam;
import com.pcitc.base.util.DateUtil;
import com.pcitc.base.util.MyBeanUtils;
import com.pcitc.base.util.StrUtil;
import com.pcitc.base.workflow.SysDelegate;
import com.pcitc.base.workflow.SysDelegateExample;
import com.pcitc.base.workflow.SysDelegateExample.Criteria;
import com.pcitc.base.workflow.SysFunctionProdef;
import com.pcitc.base.workflow.SysFunctionProdefExample;
import com.pcitc.base.workflow.SysTaskDelegate;
import com.pcitc.base.workflow.SysTaskDelegateExample;
import com.pcitc.mapper.system.SysDelegateMapper;
import com.pcitc.mapper.system.SysFunctionProdefMapper;
import com.pcitc.mapper.system.SysTaskDelegateMapper;
import com.pcitc.mapper.system.SysUserMapper;
import com.pcitc.service.feign.system.WorkflowRemoteClient;
import com.pcitc.service.workflow.TaskInstanceService;

@Service("taskInstanceService")
@CacheConfig(cacheNames = "taskCache")
@Transactional(propagation = Propagation.REQUIRED, readOnly = false, rollbackFor = Exception.class)
public class TaskInstanceServiceImpl implements TaskInstanceService {

	@Autowired
	private SysDelegateMapper sysDelegateMapper;
	
	@Autowired
	private SysTaskDelegateMapper sysTaskDelegateMapper;
	
	@Autowired
	private SysUserMapper sysUserMapper;
	
	@Autowired
	private SysFunctionProdefMapper sysFunctionProdefMapper;
	
	@Autowired
	private WorkflowRemoteClient workflowRemoteClient;
	
	//@Autowired
    //private HseRemoteClient hseRemoteClient;
	
	/**
     * 获取流程定义信息
     */
    public List<SysFunctionProdef> getProcessDefineInfo(HashMap<String, String> hashmap) {
		SysFunctionProdefExample example = new SysFunctionProdefExample();
		com.pcitc.base.workflow.SysFunctionProdefExample.Criteria cri = example.createCriteria();
		cri.andStatusEqualTo("1");
		if (hashmap.get("functionId") != null && !hashmap.get("functionId").equals("")) {
			cri.andFunctionIdEqualTo(hashmap.get("functionId").toString());
			System.out.println("========"+hashmap.get("functionId").toString());
		}
		List<SysFunctionProdef> list = sysFunctionProdefMapper.selectByExample(example);
		
		return list;
    }
    
	/** 
    * @author zhf
    * @date 2018年5月13日 下午5:50:31 
    * 获取某个委托单委托后，所产生的所有的任务（可能有些任务已经处理了）
    */
    public List<SysTaskDelegate> getDelegateHistoryTask(String delegateId) {
    	SysTaskDelegateExample example = new SysTaskDelegateExample();
    	example.createCriteria().andDelegateIdEqualTo(delegateId).andStatusEqualTo("1");
    	List<SysTaskDelegate> list = sysTaskDelegateMapper.selectByExample(example);
    	return list;
    }
	
	/** 
    * @author zhf
    * @date 2018年5月13日 下午5:40:54 
    * 所有委托的task做一个记录
    */
    public Integer insertTaskDelegate(SysTaskDelegate record) {
    	int returnInt = sysTaskDelegateMapper.insert(record);
    	return returnInt;
    }
	
	@Override
	public LayuiTableData selectDelegateByPage(LayuiTableParam param) {
		Map<String,Object> paraMap = param.getParam();
		
		SysDelegateExample SysDelegateExample = new SysDelegateExample();
		Criteria cri = SysDelegateExample.createCriteria();
		if (paraMap.get("status") != null && !paraMap.get("status").equals("")) {
			cri.andStatusEqualTo(paraMap.get("status").toString());
		}
		if (paraMap.get("attorneyName") != null && !paraMap.get("attorneyName").equals("")) {
			cri.andAttorneyNameLike("%" + paraMap.get("attorneyName").toString()  + "%");
		}
		if (paraMap.get("create_user_id") != null && !paraMap.get("create_user_id").equals("")) {
			cri.andCreateUserIdEqualTo(paraMap.get("create_user_id").toString());
		}
		if (paraMap.get("assigneeCode") != null && !paraMap.get("assigneeCode").equals("")) {
			cri.andAssigneeCodeEqualTo(paraMap.get("assigneeCode").toString());
		}
		SysDelegateExample.setOrderByClause(" create_date desc ");
		
		return this.findByExample(param, SysDelegateExample);
	}
	
	
	/**
	 *  根据条件分页搜索
	 * @param param
	 * @param example
	 * @return
	 */
	private LayuiTableData findByExample(LayuiTableParam param, SysDelegateExample example) {
		//每页显示条数
		int pageSize = param.getLimit();
		//从第多少条开始
		int pageStart = (param.getPage()-1)*pageSize;
		//当前是第几页
		int pageNum = pageStart/pageSize + 1;
		// 1、设置分页信息，包括当前页数和每页显示的总计数
		PageHelper.startPage(pageNum, pageSize);
		
		List<SysDelegate> list = sysDelegateMapper.selectByExample(example);
		// 3、获取分页查询后的数据
		PageInfo<SysDelegate> pageInfo = new PageInfo<SysDelegate>(list);
		LayuiTableData data = new LayuiTableData();
		data.setData(pageInfo.getList());
		Long total = pageInfo.getTotal();
		data.setCount(total.intValue());
		return data;
	}
	
	
	public Integer deleteDelegate(SysDelegate delegate) {
		SysDelegate oldDelegate = sysDelegateMapper.selectByPrimaryKey(delegate.getDelegateId());
		if(delegate != null) {
			MyBeanUtils.copyPropertiesIgnoreNull(delegate, oldDelegate);
		}
		int rInt = sysDelegateMapper.updateByPrimaryKey(oldDelegate);
		return rInt;
	}
	
	/** 
	* @author zhf
	* @date 2018年5月13日 下午7:19:39 
	* 修改曾经委托的任务
	*/
	public Integer deleteTaskDelegate(SysTaskDelegate record) {
		int rInt = sysTaskDelegateMapper.updateByPrimaryKey(record);
		return rInt;
	}
	
	
	/** 
    * @author zhf
    * @date 2018年5月7日 下午2:48:43 
    * 获取当前审批节点的候选用户
    */
    public List<String> getCandidateUserForTask(List<IdentityLink> identityLinks) {
        //使用Set过滤掉重复候选组的重复用户
        Set<String> userIds = new HashSet<String>();
        for (IdentityLink identityLink : identityLinks) {
            if (identityLink.getType().equals(IdentityLinkType.CANDIDATE)) {
            	if (!StrUtil.isEmpty(identityLink.getUserId())) {
            		System.out.println("1getCandidateUserForTask====="+identityLink.getUserId());
            		if (identityLink.getUserId().startsWith("post")) {
            			String[] posts = identityLink.getUserId().split("--")[1].split("-");
            			userIds.addAll(sysUserMapper.findUserByGroupIdFromACT(Arrays.asList(posts)));
            		} else if (identityLink.getUserId().startsWith("role")) {
            			String[] roles = identityLink.getUserId().split("--")[1].split("-");
            			userIds.addAll(sysUserMapper.findUserByGroupIdFromACT(Arrays.asList(roles)));
            		} else if (identityLink.getUserId().startsWith("unit")) {
            			String[] units = identityLink.getUserId().split("--")[1].split("-");
            			userIds.addAll(sysUserMapper.findUserByGroupIdFromACT(Arrays.asList(units)));
            		} else {
            			String[] users = identityLink.getUserId().split(",");
            			userIds.addAll(Arrays.asList(users));
            		}
                } else if (!StrUtil.isEmpty(identityLink.getGroupId())) {
                    // 分配的是组，获取，从act视图表act_id_membership中的获取用户
                	System.out.println("2getCandidateUserForTask====="+identityLink.getGroupId());
                	if (identityLink.getGroupId().startsWith("post")) {
            			String[] posts = identityLink.getGroupId().split("--")[1].split("-");
            			userIds.addAll(sysUserMapper.findUserByGroupIdFromACT(Arrays.asList(posts)));
            		} else if (identityLink.getGroupId().startsWith("role")) {
            			String[] roles = identityLink.getGroupId().split("--")[1].split("-");
            			userIds.addAll(sysUserMapper.findUserByGroupIdFromACT(Arrays.asList(roles)));
            		} else if (identityLink.getGroupId().startsWith("unit")) {
            			String[] units = identityLink.getGroupId().split("--")[1].split("-");
            			userIds.addAll(sysUserMapper.findUserByGroupIdFromACT(Arrays.asList(units)));
            		} else {
            			String[] units = identityLink.getGroupId().split("-");
            			userIds.addAll(sysUserMapper.findUserByGroupIdFromACT(Arrays.asList(units)));
            		}
                }
            }
        }
        List<String> userList = new ArrayList<>(userIds);
        return userList;
    }
	
    /** 
     * 根据模块编码，获取被委托人（审批配置）
     * @author zhf
     * @date 2018年5月7日 下午5:35:35 
     */
    public List<SysDelegate> getAttorneyByAssignee(String assignee, String moduleCode) {
    	SysDelegateExample sysDelegateExample = new SysDelegateExample();
    	Criteria criteria = sysDelegateExample.createCriteria();
    	criteria.andAssigneeCodeEqualTo(assignee);
    	//criteria.andModuleCodeEqualTo(moduleCode);
    	criteria.andStatusEqualTo("1");
    	criteria.andStartDateLessThanOrEqualTo(DateUtil.format(new Date(), DateUtil.FMT_DD));
    	criteria.andEndDateGreaterThanOrEqualTo(DateUtil.format(new Date(), DateUtil.FMT_DD));
    	
    	List<SysDelegate> list = sysDelegateMapper.selectByExample(sysDelegateExample);
    	return list;
    }
    
    /**
     * 查询委托单
     * @param delegate
     * @return
     */
    public List<SysDelegate> getSysDelegate(SysDelegate sysDelegate) {
    	SysDelegateExample sysDelegateExample = new SysDelegateExample();
    	Criteria criteria1 = sysDelegateExample.createCriteria();
    	criteria1.andAssigneeCodeEqualTo(sysDelegate.getAssigneeCode());
    	criteria1.andStatusEqualTo("1");
    	criteria1.andStartDateLessThanOrEqualTo(sysDelegate.getStartDate());
    	criteria1.andEndDateGreaterThanOrEqualTo(sysDelegate.getStartDate());
    	
    	Criteria criteria2 = sysDelegateExample.createCriteria();
    	criteria2.andAssigneeCodeEqualTo(sysDelegate.getAssigneeCode());
    	criteria2.andStatusEqualTo("1");
    	criteria2.andStartDateLessThanOrEqualTo(sysDelegate.getEndDate());
    	criteria2.andEndDateGreaterThanOrEqualTo(sysDelegate.getStartDate());
    	
    	sysDelegateExample.or(criteria2);
    	
    	List<SysDelegate> list = sysDelegateMapper.selectByExample(sysDelegateExample);
    	return list;
    }
    
    
    /** 
     * @author zhf
     * @date 2018年5月8日 下午7:27:57 
     * 新增委托单
     */
    @Transactional
    //@TxTransaction(isStart=true)
	@Override
    public Integer insertDelegate(SysDelegate delegate) {
    	String uuid = UUID.randomUUID().toString().replaceAll("-", "");
		delegate.setDelegateId(uuid);
    	
    	//新增委托单的时候，需要处理目前的已有待办任务
    	int returnInt = sysDelegateMapper.insert(delegate);
    	
    	// 调用审批流程，此处调用同时实现事务
    	JSONObject flowJson = new JSONObject();
    	// 业务主键id
    	flowJson.put("businessId", uuid);
    	flowJson.put("processInstanceName", "业务任务名称：" + uuid.substring(0, 10));
    	
    	// 发起者信息
    	flowJson.put("authenticatedUserId", delegate.getCreateUserId());
    	flowJson.put("authenticatedUserName", delegate.getCreateUser());

		// 菜单id（functionId），部门/组织ID（orgId），项目id（projectId）。其中菜单id必填（和ProcessDefineId两选一）
    	flowJson.put("functionId", "59d9113d-745d-4c46-bc84-c18f132ac2c1");
    	
    	// 待办业务详情、最终审批同意、最终审批不同意路径
    	flowJson.put("auditDetailsPath", "/task/test/details/" + uuid);
    	flowJson.put("auditAgreeMethod", "http://pcitc-zuul/system-proxy/workflow-provider/task/agree/" + uuid);
    	flowJson.put("auditRejectMethod", "http://pcitc-zuul/system-proxy/workflow-provider/task/reject/" + uuid);

    	// 非必填选项， 菜单功能需要根据不同单位、不同项目选择不同流程图的时候使用。（也可以在单个流程图中，用判断来做）
    	// flowJson.put("flowProjectId", "");
    	// flowJson.put("flowUnitId", "");
    	
    	// 非必填选项，当下一步审批者需要本次任务执行人（启动者）手动选择的时候，需要auditUserIds属性
    	String auditor = "16622d9cfc5_94712f71,16622e3f0df_1370e873";
    	String[] userIds = auditor.split(",");
    	flowJson.put("auditor", Arrays.asList(userIds));
    	
    	// 特殊审批环节。当任务节点存在某个不确定的审批人，在流程图任务节点id设置为specialAuditor，同时提交时specialAuditor写入unit/role/post
    	// flowJson.put("specialAuditor", "ZSH_YFGCS_CJCXY");
    	flowJson.put("specialAuditor1", "ZBGL_KTY_QYKYZG");
		flowJson.put("specialAuditor2", "ZBGL_KTY_FZDWKJCZ");
    	flowJson.put("specialAuditor3", "ZBGL_KTY_FZDWZGLD");
    	
		// 非必填选项, 对流程中出现的多个判断条件，比如money>100等，需要把事先把money条件输入
		// flowJson.put("involoFlag", 1); // 环节1需要用到
		// flowJson.put("departmentCode", "1005"); // 环节2需要用到
		// flowJson.put("companyCode", "2006"); // 环节n需要用到
		
		
    	// 非必填选项, 会签时需要的属性，会签里所有的人，同意率（double类型）
    	flowJson.put("signAuditRate", 1d); 
    	
    	// 远程调用
    	System.out.println("=====远程调用开始");
    	workflowRemoteClient.startCommonWorkflow(flowJson.toJSONString());
    	System.out.println("=====远程调用结束");
    	
    	return returnInt;
    }
    
    /**
     * 查询委托单
     * @param delegate
     * @return
     */
    public List<SysDelegate> getSysDelegateInfo(HashMap<String, String> hashmap) {
    	SysDelegateExample sysDelegateExample = new SysDelegateExample();
    	Criteria criteria = sysDelegateExample.createCriteria();
    	if (hashmap.get("delegateId") != null) {
    		criteria.andDelegateIdEqualTo(hashmap.get("delegateId"));
    	}
    	criteria.andStatusEqualTo("1");
    	
    	List<SysDelegate> list = sysDelegateMapper.selectByExample(sysDelegateExample);
    	return list;
    }
    
}
