package com.pcitc.web.controller.intlProject;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.pcitc.base.util.IdUtil;
import com.pcitc.web.common.BaseController;
/**
 * 科技平台 国际合作项目管理 
* @author fb  
* @version 1.0
* File: IntlProjectController.java  
* Description:  
* Copyright: Copyright (c) 2018  
* Company: pcitc.com
 */
@Controller
public class IntlProjectController extends BaseController 
{
	@RequestMapping(method = RequestMethod.GET, value = "/intl_project/notice_list")
	private String toProjectNoticeListPage(HttpServletRequest request) 
	{
		return "stp/intlproject/notice_list";
    }
	@RequestMapping(method = RequestMethod.GET, value = "/intl_project/notice_edit")
	private String toProjectNoticeEditPage(HttpServletRequest request) 
	{
		if(request.getParameter("noticeId")==null) 
		{
			request.setAttribute("appendFiles", IdUtil.createFileIdByTime());
		}
		request.setAttribute("noticeId", request.getParameter("noticeId"));
		return "stp/intlproject/notice_edit";
    }
	@RequestMapping(method = RequestMethod.GET, value = "/intl_project/notice_view")
	private String toProjectNoticeViewPage(HttpServletRequest request) 
	{
		if(request.getParameter("noticeId")==null) 
		{
			request.setAttribute("appendFiles", IdUtil.createFileIdByTime());
		}
		request.setAttribute("noticeId", request.getParameter("noticeId"));
		return "stp/intlproject/notice_view";
    }
	@RequestMapping(method = RequestMethod.GET, value = "/intl_project/plant_list")
	private String toProjectPlantListPage(HttpServletRequest request) 
	{
		return "stp/intlproject/plant_list";
    }
	@RequestMapping(method = RequestMethod.GET, value = "/intl_project/plant_edit")
	private String toProjectPlantEditPage(HttpServletRequest request) 
	{
		if(request.getParameter("plantId")==null) 
		{
			request.setAttribute("appendFiles", IdUtil.createFileIdByTime());
			request.setAttribute("plantId", IdUtil.createFileIdByTime());
			request.setAttribute("edit", 0);
		}else {
			request.setAttribute("edit", 1);
			request.setAttribute("plantId", request.getParameter("plantId"));
		}
		return "stp/intlproject/plant_edit";
    }
	@RequestMapping(method = RequestMethod.GET, value = "/intl_project/plant_view")
	private String toProjectPlantViewPage(HttpServletRequest request) 
	{
		if(request.getParameter("plantId")==null) 
		{
			request.setAttribute("appendFiles", IdUtil.createFileIdByTime());
		}
		request.setAttribute("plantId", request.getParameter("plantId"));
		return "stp/intlproject/plant_view";
    }
	
	@RequestMapping(method = RequestMethod.GET, value = "/intl_project/plant_edit_selectapply")
	private String toProjectPlantEditSelectApplyPage(HttpServletRequest request) 
	{
		String plantId = request.getParameter("plantId");
		request.setAttribute("plantId", plantId==null?IdUtil.createIdByTime():plantId);
		return "stp/intlproject/plant_edit_selectapply";
    }

	@RequestMapping(method = RequestMethod.GET, value = "/intl_project/apply_list")
	private String toProjectApplyListPage(HttpServletRequest request) 
	{
		return "stp/intlproject/apply_list";
    }
	@RequestMapping(method = RequestMethod.GET, value = "/intl_project/apply_edit")
	private String toProjectApplyEditPage(HttpServletRequest request) 
	{
		if(request.getParameter("applyId")==null) 
		{
			request.setAttribute("appendFiles", IdUtil.createFileIdByTime());
		}
		request.setAttribute("applyId", request.getParameter("applyId"));
		return "stp/intlproject/apply_edit";
    }
	@RequestMapping(method = RequestMethod.GET, value = "/intl_project/apply_view")
	private String toProjectApplyContentPage(HttpServletRequest request,String applyId) 
	{
		if(request.getParameter("applyId")==null) 
		{
			request.setAttribute("appendFiles", IdUtil.createFileIdByTime());
		}
		request.setAttribute("applyId", request.getParameter("applyId"));

		return "stp/intlproject/apply_view";
    }
	
	@RequestMapping(method = RequestMethod.GET, value = "/intl_project/review_list")
	private String toProjectReviewListPage(HttpServletRequest request) 
	{
		return "intl_project/review_list";
    }
	@RequestMapping(method = RequestMethod.GET, value = "/intl_project/review_edit")
	private String toProjectReviewEditPage(HttpServletRequest request) 
	{
		request.setAttribute("reviewId", request.getParameter("reviewId"));
		return "intl_project/review_edit";
    }
	
	@RequestMapping(method = RequestMethod.GET, value = "/intl_project/info_list")
	private String toProjectInfoListPage(HttpServletRequest request) 
	{
		return "stp/intlproject/info_list";
    }
	@RequestMapping(method = RequestMethod.GET, value = "/intl_project/info_edit")
	private String toProjectInfoEditPage(HttpServletRequest request) 
	{
		String projectId = request.getParameter("projectId");
		if(projectId == null) 
		{
			request.setAttribute("appendFiles", IdUtil.createFileIdByTime());
		}
		request.setAttribute("projectId", projectId);
		return "stp/intlproject/info_edit";
    }
	@RequestMapping(method = RequestMethod.GET, value = "/intl_project/info_view")
	private String toProjectInfoViewPage(HttpServletRequest request) 
	{
		String projectId = request.getParameter("projectId");
		if(projectId == null) 
		{
			request.setAttribute("appendFiles", IdUtil.createFileIdByTime());
		}
		request.setAttribute("projectId", projectId);
		return "stp/intlproject/info_view";
    }
	
	@RequestMapping(method = RequestMethod.GET, value = "/intl_project/contract_list")
	private String toProjectContractListPage(HttpServletRequest request) 
	{
		return "stp/intlproject/contract_list";
    }
	
	@RequestMapping(method = RequestMethod.GET, value = "/intl_project/contract_renew_list")
	private String toProjectEndContractListPage(HttpServletRequest request) 
	{
		return "stp/intlproject/contract_renew_list";
    }
	
	@RequestMapping(method = RequestMethod.GET, value = "/intl_project/contract_edit")
	private String toProjectContractEditPage(HttpServletRequest request) 
	{
		String contractId = request.getParameter("contractId");
		if(contractId == null) 
		{
			request.setAttribute("appendFiles", IdUtil.createFileIdByTime());
		}
		request.setAttribute("contractId", contractId);
		return "stp/intlproject/contract_edit";
    }
	
	@RequestMapping(method = RequestMethod.GET, value = "/intl_project/contract_renew_edit")
	private String toProjectContractRenewEditPage(HttpServletRequest request) 
	{
		String contractId = request.getParameter("contractId");
		if(contractId == null) 
		{
			request.setAttribute("appendFiles", IdUtil.createFileIdByTime());
		}
		request.setAttribute("contractId", contractId);
		return "stp/intlproject/contract_renew_edit";
    }
	
	@RequestMapping(method = RequestMethod.GET, value = "/intl_project/contract_view")
	private String toProjectContractViewPage(HttpServletRequest request) 
	{
		String contractId = request.getParameter("contractId");
		if(contractId == null) 
		{
			request.setAttribute("appendFiles", IdUtil.createFileIdByTime());
		}
		request.setAttribute("contractId", contractId);
		return "stp/intlproject/contract_view";
    }
	@RequestMapping(method = RequestMethod.GET, value = "/intl_project/contract_renew_view")
	private String toProjectContractRenewViewPage(HttpServletRequest request) 
	{
		String contractId = request.getParameter("contractId");
		if(contractId == null) 
		{
			request.setAttribute("appendFiles", IdUtil.createFileIdByTime());
		}
		request.setAttribute("contractId", contractId);
		return "stp/intlproject/contract_renew_view";
    }
	
	
	@RequestMapping(method = RequestMethod.GET, value = "/intl_project/result_list")
	private String toProjectResultListPage(HttpServletRequest request) 
	{
		return "stp/intlproject/result_list";
    }
	@RequestMapping(method = RequestMethod.GET, value = "/intl_project/result_edit")
	private String toProjectResultEditPage(HttpServletRequest request) 
	{
		String resultId = request.getParameter("resultId");
		if(resultId == null) 
		{
			request.setAttribute("appendFiles", IdUtil.createFileIdByTime());
		}
		request.setAttribute("resultId", resultId);
		return "stp/intlproject/result_edit";
    }
	@RequestMapping(method = RequestMethod.GET, value = "/intl_project/result_view")
	private String toProjectResultViewPage(HttpServletRequest request) 
	{
		String resultId = request.getParameter("resultId");
		if(resultId == null) 
		{
			request.setAttribute("appendFiles", IdUtil.createFileIdByTime());
		}
		request.setAttribute("resultId", resultId);
		return "stp/intlproject/result_view";
    }
	@RequestMapping(method = RequestMethod.GET, value = "/intl_project/remark_list")
	private String toProjectRemarkListPage(HttpServletRequest request) 
	{
		return "stp/intlproject/remark_list";
    }
	@RequestMapping(method = RequestMethod.GET, value = "/intl_project/remark_edit")
	private String toProjectRemarkEditPage(HttpServletRequest request) 
	{
		String remarkId = request.getParameter("remarkId");
		if(remarkId == null) 
		{
			request.setAttribute("appendFiles", IdUtil.createFileIdByTime());
		}
		request.setAttribute("remarkId",remarkId);
		return "stp/intlproject/remark_edit";
    }
	@RequestMapping(method = RequestMethod.GET, value = "/intl_project/remark_view")
	private String toProjectRemarkViewPage(HttpServletRequest request) 
	{
		String remarkId = request.getParameter("remarkId");
		if(remarkId == null) 
		{
			request.setAttribute("appendFiles", IdUtil.createFileIdByTime());
		}
		request.setAttribute("remarkId",remarkId);
		return "stp/intlproject/remark_view";
    }
	@RequestMapping(method = RequestMethod.GET, value = "/intl_project/accept_list")
	private String toProjectAcceptListPage(HttpServletRequest request) 
	{
		String status = request.getParameter("status");
		request.setAttribute("status", status==null?IdUtil.createIdByTime():status);
		return "stp/intlproject/accept_list";
    }
	@RequestMapping(method = RequestMethod.GET, value = "/intl_project/accept_pass_list")
	private String toProjectAcceptPASSListPage(HttpServletRequest request) 
	{
		String status = request.getParameter("status");
		request.setAttribute("status", status==null?IdUtil.createIdByTime():status);
		return "stp/intlproject/accept_pass_list";
    }
	@RequestMapping(method = RequestMethod.GET, value = "/intl_project/accept_refuse_list")
	private String toProjectAcceptRefuseListPage(HttpServletRequest request) 
	{
		String status = request.getParameter("status");
		request.setAttribute("status", status==null?IdUtil.createIdByTime():status);
		return "stp/intlproject/accept_refuse_list";
    }
	@RequestMapping(method = RequestMethod.GET, value = "/intl_project/accept_process")
	private String toProjectAcceptProcessPage(HttpServletRequest request) 
	{
		request.setAttribute("projectId", request.getParameter("projectId"));
		request.setAttribute("appendFiles", IdUtil.createFileIdByTime());
		return "stp/intlproject/accept_process";
    }
	
	@RequestMapping(method = RequestMethod.GET, value = "/intl_project/project_report")
	private String toProjectReportPage(HttpServletRequest request) 
	{
		return "stp/intlproject/project_report";
    }
	@RequestMapping(method = RequestMethod.GET, value = "/project/info_list_manager")
	public String toManagerPage(HttpServletRequest request) throws IOException 
	{
		return "stp/intlproject/info_list_manager";
	}
}
