package com.pcitc.service.workflow;

import java.util.HashMap;
import java.util.List;
import java.util.Set;

import org.activiti.engine.task.IdentityLink;

import com.pcitc.base.common.LayuiTableData;
import com.pcitc.base.common.LayuiTableParam;
import com.pcitc.base.workflow.SysDelegate;
import com.pcitc.base.workflow.SysFunctionProdef;
import com.pcitc.base.workflow.SysTaskDelegate;

public interface TaskInstanceService {

	/** 
	* 查询委托列表
	* @author zhf
	* @date 2018年5月2日 下午5:06:25 
	*/
	public LayuiTableData selectDelegateByPage(LayuiTableParam param);
	
	/** 
	* 修改任务委托单，需要id值
	* @author zhf
	* @date 2018年5月3日 下午2:08:57 
	*/
	public Integer deleteDelegate(SysDelegate delegate);
	
	/** 
	* @author zhf
	* @date 2018年5月13日 下午7:19:39 
	* 修改曾经委托的任务
	*/
	public Integer deleteTaskDelegate(SysTaskDelegate record);
	
	
    /** 
    * @author zhf
    * @date 2018年5月7日 下午2:48:43 
    * 获取当前审批节点的候选用户
    */
    public List<String> getCandidateUserForTask(List<IdentityLink> identityLinks);
    
    /**
     * 查询委托单
     * @param delegate
     * @return
     */
    public List<SysDelegate> getSysDelegate(SysDelegate delegate);
    
    /** 
    * 根据模块编码，获取被委托人
    * @author zhf
    * @date 2018年5月7日 下午5:35:35 
    */
    public List<SysDelegate> getAttorneyByAssignee(String assignee, String moduleCode);
    
    /** 
    * @author zhf
    * @date 2018年5月8日 下午7:27:57 
    * 新增委托单
    */
    public Integer insertDelegate(SysDelegate delegate);
    
    /** 
    * @author zhf
    * @date 2018年5月13日 下午5:40:54 
    * 所有委托的task做一个记录
    */
    public Integer insertTaskDelegate(SysTaskDelegate record);
    
    /** 
    * @author zhf
    * @date 2018年5月13日 下午5:50:31 
    * 获取某个委托单委托后，所产生的所有的任务（可能有些任务已经处理了）
    */
    public List<SysTaskDelegate> getDelegateHistoryTask(String delegateId);
    
    /**
     * 获取流程定义信息
     */
    public List<SysFunctionProdef> getProcessDefineInfo(HashMap<String, String> hashmap);
    
    /**
     * 查询委托单
     * @param delegate
     * @return
     */
    public List<SysDelegate> getSysDelegateInfo(HashMap<String, String> hashmap);
    
    
	
}
