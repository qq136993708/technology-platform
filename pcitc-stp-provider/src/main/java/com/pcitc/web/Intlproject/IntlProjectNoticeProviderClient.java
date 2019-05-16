package com.pcitc.web.Intlproject;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.pcitc.base.common.LayuiTableParam;
import com.pcitc.base.common.Result;
import com.pcitc.base.common.enums.DelFlagEnum;
import com.pcitc.base.stp.IntlProject.IntlProjectNotice;
import com.pcitc.base.system.SysUser;
import com.pcitc.base.util.DateUtil;
import com.pcitc.base.util.IdUtil;
import com.pcitc.base.util.MyBeanUtils;
import com.pcitc.base.workflow.WorkflowVo;
import com.pcitc.common.MailBean;
import com.pcitc.common.WorkFlowStatusEnum;
import com.pcitc.service.feign.SystemRemoteClient;
import com.pcitc.service.feign.WorkflowRemoteClient;
import com.pcitc.service.intlproject.IntlProjectNoticeService;
import com.pcitc.service.msg.MailSentService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Api(value="通知管理接口",tags= {"国际合作-项目通知管理服务接口"})
@RestController
public class IntlProjectNoticeProviderClient 
{
	@Autowired
	IntlProjectNoticeService intlProjectService;
	
	@Autowired
	private WorkflowRemoteClient workflowRemoteClient;
	
	@Autowired
	private MailSentService mailSentService;
	
	@Autowired
	private SystemRemoteClient systemRemoteClient;
	
	@ApiOperation(value="通知审批流程",notes="发起通知内容审批")
	@RequestMapping(value = "/stp-provider/project/start-notice-activity/{noticeId}", method = RequestMethod.POST)
	public Result startNoticeWorkFlow(@PathVariable("noticeId") String noticeId,@RequestBody WorkflowVo workflowVo) 
	{
		IntlProjectNotice notice = intlProjectService.findById(noticeId);
		//如果审批已发起则不能再次发起
		if(!WorkFlowStatusEnum.STATUS_WAITING.getCode().equals(notice.getFlowStatus())) 
		{
			return new Result(false,"已发起审批不可重复发起！");
		}
		boolean status = intlProjectService.startWorkFlow(workflowVo.getBusinessId(), workflowVo.getFunctionId(), workflowVo.getProcessDefinitionName(), workflowVo.getAuthenticatedUserId(), workflowVo.getAuthenticatedUserName());
		if(status) 
		{
			return new Result(true,"操作成功!");
		}else {
			return new Result(false,"操作失败!");
		}
	
		/*//workflowVo.setAuthenticatedUserId("111");
		workflowVo.setProcessDefineId(WORKFLOW_DEFINE_ID); 
		workflowVo.setBusinessId(noticeId);
		workflowVo.setProcessInstanceName("通知审批："+notice.getNoticeTitle());
		Map<String, Object> variables = new HashMap<String, Object>();  
		//starter为必填项。流程图的第一个节点待办人变量必须为starter
        variables.put("starter", workflowVo.getAuthenticatedUserId());
        
        //必须设置。流程中，需要的第二个节点的指派人；除starter外，所有待办人变量都指定为auditor(处长审批)
        //处长审批 ZSH_JTZSZYC_GJHZC_CZ
        List<SysUser> users = systemRemoteClient.selectUsersByPostCode("ZSH_JTZSZYC_GJHZC_CZ");
        System.out.println("start userIds ... "+JSON.toJSONString(users));
        variables.put("auditor", workflowVo.getAuthenticatedUserId());
        if(users != null && users.size()>0) {
        	variables.put("auditor", users.get(0).getUserId());
        }
        
        //必须设置，统一流程待办任务中需要的业务详情
        variables.put("auditDetailsPath", "/intl_project/notice_view?noticeId="+noticeId);
       
        //流程完全审批通过时，调用的方法
        variables.put("auditAgreeMethod", "http://pcitc-zuul/stp-proxy/stp-provider/project/callback-workflow-notice?noticeId="+noticeId+"&workflow_status="+WorkFlowStatusEnum.STATUS_PASS.getCode());
        
        //流程驳回时，调用的方法（可能驳回到第一步，也可能驳回到第1+n步
        variables.put("auditRejectMethod", "http://pcitc-zuul/stp-proxy/stp-provider/project/callback-workflow-notice?noticeId="+noticeId+"&workflow_status="+WorkFlowStatusEnum.STATUS_RETURN.getCode());
        
        workflowVo.setVariables(variables);
		String rs = systemRemoteClient.startWorkflowByProcessDefinitionId(workflowVo);
		System.out.println("startwork  apply  rs...."+rs);*/
		
	}
	@ApiOperation(value="审批流程回调通知",notes="审批结果回调通知")
	@RequestMapping(value = "/stp-provider/project/callback-workflow-notice")
	public Object callBackProjectNoticeWorkflow(@RequestParam(value = "noticeId", required = true) String noticeId,
			@RequestParam(value = "workflow_status", required = true) Integer workflow_status) throws Exception 
	{
		if(noticeId != null) {
			IntlProjectNotice notice = intlProjectService.findById(noticeId);
			if(notice != null) {
				notice.setFlowStatus(workflow_status);
				intlProjectService.updProjectNotice(notice);
			}
		}
		return null;
	}
	@ApiOperation(value="分页检索通知",notes="检索通知列表数据，返回数据列表。")
	@RequestMapping(value = "/stp-provider/project/notice-list")
	public Object getProjectNoticeList(@RequestBody LayuiTableParam param) throws Exception 
	{
		return intlProjectService.selectProjectNoticeList(param);
	}
	
	@ApiOperation(value="检索通知",notes="检索立项项目数据，返回数据详情。")
	@RequestMapping(value = "/stp-provider/project/get-notice/{noticeId}", method = RequestMethod.POST)
	public IntlProjectNotice getProjectNoticeInfo(@PathVariable("noticeId") String noticeId) 
	{
		return intlProjectService.findById(noticeId);
	}
	@ApiOperation(value="保存更新通知",notes="保存或者更新通知数据")
	@RequestMapping(value = "/stp-provider/project/addorupd-notice", method = RequestMethod.POST)
	public Result saveOrUpdProjectNotice(@RequestBody IntlProjectNotice notice) 
	{
		IntlProjectNotice oldNotice = intlProjectService.findById(notice.getNoticeId());
		Integer rs = 0;
		if(oldNotice != null) {
			//如果审批已发起则不能编辑
			if(WorkFlowStatusEnum.STATUS_RUNNING.getCode().equals(oldNotice.getFlowStatus())||WorkFlowStatusEnum.STATUS_PASS.getCode().equals(oldNotice.getFlowStatus())) 
			{
				return new Result(false,"已发起审批不可编辑！");
			}
			MyBeanUtils.copyPropertiesIgnoreNull(notice, oldNotice);
			oldNotice.setUpdateTime(DateUtil.format(new Date(), DateUtil.FMT_SS));
			oldNotice.setFlowStatus(WorkFlowStatusEnum.STATUS_WAITING.getCode());
			rs = this.intlProjectService.updProjectNotice(oldNotice);
		}else {
			
			notice.setNoticeId(IdUtil.createIdByTime());
			notice.setCreateTime(DateUtil.format(new Date(), DateUtil.FMT_SS));
			notice.setFlowStatus(WorkFlowStatusEnum.STATUS_WAITING.getCode());
			rs = this.intlProjectService.saveProjectNotice(notice);
		}
		if(rs > 0) 
		{
			return new Result(true,"操作成功！");
		}else {
			return new Result(false,"操作出现异常，请重试！");
		}
	}
	@ApiOperation(value="项目申报通知关闭",notes="关闭通知信息（逻辑删除）。")
	@RequestMapping(value = "/stp-provider/project/close-notice/{noticeId}", method = RequestMethod.POST)
	public Integer delPlantClose(@PathVariable("noticeId") String noticeId) 
	{
		IntlProjectNotice oldNotice = intlProjectService.findById(noticeId);
		if(oldNotice != null) 
		{
			oldNotice.setDelFlag(DelFlagEnum.STATUS_DEL.getCode());
			return this.intlProjectService.updProjectNotice(oldNotice);
		}
		return 0;
	}
	@ApiOperation(value="项目申报通知删除",notes="删除通知信息（物理删除）。")
	@RequestMapping(value = "/stp-provider/project/del-notice/{noticeId}", method = RequestMethod.POST)
	public Integer delPlantReal(@PathVariable("noticeId") String noticeId) 
	{
		return intlProjectService.delProjectNotice(noticeId);
	}
	
	@ApiOperation(value="项目申报邮件通知",notes="检索项目申报列表数据，邮件通知相关方。")
	@RequestMapping(value = "/stp-provider/project/sent-notice/{noticeId}", method = RequestMethod.POST)
	public Object sendApplyInfoToMail(@PathVariable("noticeId") String noticeId) 
	{
		IntlProjectNotice notice = intlProjectService.findById(noticeId);
		if(!WorkFlowStatusEnum.STATUS_PASS.getCode().equals(notice.getFlowStatus())) 
		{
			return new Result(false,"审批未通过，不能发送");
		}else {
			//获取指定岗位负责人邮箱
			String [] postCodes =new String [] {
					"ZSH_ZSYJY_KTY_KTYGJHZGW",
					"ZSH_ZSYJY_WTY_WKYGJHZGW",
					"ZSH_ZSYJY_GCY_GCYGJHZGW",
					"ZSH_ZSYJY_SKY_SKYGJHZGW",
					"ZSH_ZSYJY_DLY_DLYGJHZGW",
					"ZSH_ZSYJY_BHY_BHYGJHZGW",
					"ZSH_ZSYJY_SHY_SHYGJHZGW",
					"ZSH_ZSYJY_AGY_AGYGJHZGW"};
			Integer rs = 0;
			for(String postCode:postCodes) {
				List<SysUser> users = systemRemoteClient.selectUsersByPostCode(postCode);
				for(SysUser user:users) {
					rs += this.mailSentService.sentMail(new MailBean(user.getUserMail(),"国际合作项目申报通知",notice.getNoticeContent()));
				}
			}
			//另外再发一封测试邮件
			//rs = mailSentService.sentMail(new MailBean("376221835@qq.com","测试邮件通知",notice.getNoticeContent()));
			
			notice.setNoticeStatus("1");
			notice.setNoticeSentTime(DateUtil.format(new Date(), DateUtil.FMT_SS));
			intlProjectService.updProjectNotice(notice);
			return new Result(true,"通知已下发!");
		}
	}
}
