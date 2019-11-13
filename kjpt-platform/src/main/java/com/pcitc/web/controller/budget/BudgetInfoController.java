package com.pcitc.web.controller.budget;

import java.io.IOException;
import java.util.Date;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;
import com.pcitc.base.common.LayuiTableData;
import com.pcitc.base.common.LayuiTableParam;
import com.pcitc.base.common.Result;
import com.pcitc.base.common.enums.BudgetInfoEnum;
import com.pcitc.base.common.enums.BudgetReleaseEnum;
import com.pcitc.base.stp.budget.BudgetInfo;
import com.pcitc.base.util.DateUtil;
import com.pcitc.web.common.BaseController;
import com.pcitc.web.utils.InputCheckUtil;

@Controller
public class BudgetInfoController extends BaseController
{

	private static final String BUDGET_INFO_FINAL_LIST = "http://pcitc-zuul/stp-proxy/stp-provider/budget/budget-info-final-list";
	private static final String BUDGET_GET_INFO = "http://pcitc-zuul/stp-proxy/stp-provider/budget/budget-info-get/";
	private static final String BUDGET_INFO_LIST = "http://pcitc-zuul/stp-proxy/stp-provider/budget/budget-info-list";
	private static final String BUDGET_INFO_TABLE = "http://pcitc-zuul/stp-proxy/stp-provider/budget/budget-info-table";
	private static final String BUDGET_INFO_DEL = "http://pcitc-zuul/stp-proxy/stp-provider/budget/budget-info-del";
	private static final String BUDGET_INFO_CREATE = "http://pcitc-zuul/stp-proxy/stp-provider/budget/budget-info-create";
	private static final String BUDGET_INFO_CREATE_BYTEMPLATE = "http://pcitc-zuul/stp-proxy/stp-provider/budget/budget-info-create-bytemplate";
	private static final String BUDGET_RELEASE_LIST = "http://pcitc-zuul/stp-proxy/stp-provider/budget/budget-release-list";
	private static final String BUDGET_INFO_RELEASE = "http://pcitc-zuul/stp-proxy/stp-provider/budget/budget-info-release";
	private static final String BUDGET_MODIFY_LIST = "http://pcitc-zuul/stp-proxy/stp-provider/budget/budget-modify-list";
	private static final String BUDGET_STOCK_SPLIT_JZ = "http://pcitc-zuul/stp-proxy/stp-provider/budget/budget-stock-split-jz";
	private static final String BUDGET_STOCK_TOTAL_JZ = "http://pcitc-zuul/stp-proxy/stp-provider/budget/budget-stock-total-jz";
	
	
	
	@RequestMapping(method = RequestMethod.GET, value = "/budget/budget_create_total")
	public Object toBudgetInfoTotalAddPage(HttpServletRequest request) throws IOException 
	{
		
		String nd = request.getParameter("nd");
		String budgetType = request.getParameter("budgetType");
		//验证输入有效性年度 和 预算类型
		if(!InputCheckUtil.check(InputCheckUtil.pub_nd, nd) || !InputCheckUtil.check(InputCheckUtil.budget_budgettype, budgetType)) {
			return "error";
		}
		request.setAttribute("nd", nd);
		request.setAttribute("budgetType", budgetType);
		return "stp/budget/budget_create_all_total";
	}
	@RequestMapping(method = RequestMethod.GET, value = "/budget/budget_create_split")
	public Object toBudgetInfoSplitAddPage(HttpServletRequest request) throws IOException 
	{
		String nd = request.getParameter("nd");
		String budgetType = request.getParameter("budgetType");
		//验证输入有效性年度 和 预算类型
		if(!InputCheckUtil.check(InputCheckUtil.pub_nd, nd) || !InputCheckUtil.check(InputCheckUtil.budget_budgettype, budgetType)) {
			return "error";
		}
		request.setAttribute("nd", nd);
		request.setAttribute("budgetType", budgetType);
		return "stp/budget/budget_create_all_split";
	}
	
	@RequestMapping(method = RequestMethod.GET, value = "/budget/budget_release_main")
	public Object toBudgetReleaseMainPage(HttpServletRequest request) throws IOException 
	{
		String nd = request.getParameter("nd");
		if(nd == null) {
			nd = DateUtil.format(new Date(), DateUtil.FMT_YYYY);
		}
		request.setAttribute("nd", nd);
		return "stp/budget/budget_release_main";
	}
	@RequestMapping(method = RequestMethod.GET, value = "/budget/budget_detail_total_unit")
	public Object toBudgetDetailTotalUnit(HttpServletRequest request) throws IOException 
	{
		String nd = request.getParameter("nd");
		if(nd == null) {
			nd = DateUtil.format(new Date(), DateUtil.FMT_YYYY);
		}
		request.setAttribute("nd", nd);
		request.setAttribute("unitCodes", getUserProfile().getUnitCode());
		//request.setAttribute("unitCodes", "30130058,30130063,30130017");
		
		LayuiTableParam param = new LayuiTableParam();
		param.getParam().put("nd", nd);
		ResponseEntity<LayuiTableData> responseEntity = this.restTemplate.exchange(BUDGET_RELEASE_LIST, HttpMethod.POST, new HttpEntity<LayuiTableParam>(param, this.httpHeaders), LayuiTableData.class);
		LayuiTableData tableData = responseEntity.getBody();
		
		
		String groupDataId = "0";
		String assetDataId = "0";
		String stockZsyDataId = "0";
		String stockZgsDataId = "0";
		String stockXtwDataId = "0";
		for(java.util.Iterator<?> iter = tableData.getData().iterator();iter.hasNext();) {
			Map<?,?> map = (Map<?,?>)iter.next();
			if(!BudgetReleaseEnum.STATUS_RELEASE.getCode().equals(Integer.valueOf(map.get("releaseStatus").toString()))) 
			{
				continue;
			}
			if(BudgetInfoEnum.GROUP_SPLIT.getCode().equals(Integer.valueOf(map.get("budgetType").toString()))) 
			{
				groupDataId = map.get("dataId").toString();
			}else if(BudgetInfoEnum.ASSET_SPLIT.getCode().equals(Integer.valueOf(map.get("budgetType").toString()))) 
			{
				assetDataId = map.get("dataId").toString();
			}else if(BudgetInfoEnum.STOCK_ZSY_SPLIT.getCode().equals(Integer.valueOf(map.get("budgetType").toString()))) 
			{
				stockZsyDataId = map.get("dataId").toString();
			}else if(BudgetInfoEnum.STOCK_ZGS_SPLIT.getCode().equals(Integer.valueOf(map.get("budgetType").toString()))) 
			{
				stockZgsDataId = map.get("dataId").toString();
			}else if(BudgetInfoEnum.STOCK_XTY_SPLIT.getCode().equals(Integer.valueOf(map.get("budgetType").toString()))) 
			{
				stockXtwDataId = map.get("dataId").toString();
			}else {
				System.out.println("......");
			}
		}
		request.setAttribute("groupDataId", groupDataId);
		request.setAttribute("assetDataId", assetDataId);
		request.setAttribute("stockZsyDataId", stockZsyDataId);
		request.setAttribute("stockZgsDataId", stockZgsDataId);
		request.setAttribute("stockXtwDataId", stockXtwDataId);
		return "stp/budget/budget_detail_total_unit";
	}
	
	@RequestMapping(method = RequestMethod.GET, value = "/budget/budget_modify_main")
	public Object toBudgetModifyMainPage(HttpServletRequest request) throws IOException 
	{
		String nd = request.getParameter("nd");
		if(nd == null) {
			nd = DateUtil.format(new Date(), DateUtil.FMT_YYYY);
		}
		request.setAttribute("nd", nd);
		return "stp/budget/budget_modify_main";
	}
	
	@RequestMapping(value = "/budget/budget-info-get", method = RequestMethod.POST)
	@ResponseBody
	public Object getBudgetInfo(@RequestParam(value = "dataId", required = true) String dataId,HttpServletRequest request) throws IOException 
	{
		ResponseEntity<Object> responseEntity = this.restTemplate.exchange(BUDGET_GET_INFO+dataId, HttpMethod.POST, new HttpEntity<Object>(this.httpHeaders), Object.class);
		return JSON.toJSON(responseEntity.getBody());
	}
	@RequestMapping(value = "/budget/budget-info-table", method = RequestMethod.POST)
	@ResponseBody
	public Object getBudgetInfoTable(@ModelAttribute("param") LayuiTableParam param,HttpServletRequest request) throws IOException 
	{
		if(!InputCheckUtil.check(InputCheckUtil.pub_nd, param.getParam().get("nd")+"") || !InputCheckUtil.check(InputCheckUtil.budget_budgettype, param.getParam().get("budgetType")+"")) 
		{
			return JSON.toJSON(new Result(false));
		}
		ResponseEntity<Object> responseEntity = this.restTemplate.exchange(BUDGET_INFO_TABLE, HttpMethod.POST, new HttpEntity<LayuiTableParam>(param, this.httpHeaders), Object.class);
		return JSON.toJSON(responseEntity.getBody());
	}
	@RequestMapping(value = "/budget/budget-info-list", method = RequestMethod.POST)
	@ResponseBody
	public Object getBudgetInfoList(@ModelAttribute("info") BudgetInfo info,HttpServletRequest request) throws IOException 
	{
		//输入验证
		if(!InputCheckUtil.check(InputCheckUtil.pub_nd, info.getNd()) || !InputCheckUtil.check(InputCheckUtil.budget_budgettype, info.getBudgetType()+"")) 
		{
			return JSON.toJSON(new Result(false));
		}
		ResponseEntity<Object> responseEntity = this.restTemplate.exchange(BUDGET_INFO_LIST, HttpMethod.POST, new HttpEntity<BudgetInfo>(info, this.httpHeaders), Object.class);
		return JSON.toJSON(responseEntity.getBody());
	}
	@RequestMapping(value = "/budget/budget-info-del", method = RequestMethod.POST)
	@ResponseBody
	public Object deleteBudgetGroupInfo(@ModelAttribute("info") BudgetInfo info,HttpServletRequest request) throws IOException 
	{
		ResponseEntity<Object> responseEntity = this.restTemplate.exchange(BUDGET_INFO_DEL, HttpMethod.POST, new HttpEntity<BudgetInfo>(info, this.httpHeaders), Object.class);
		return JSON.toJSON(responseEntity.getBody());
	}
	@RequestMapping(value = "/budget/budget-info-create", method = RequestMethod.POST)
	@ResponseBody
	public Object createBudgetGroupInfo(@ModelAttribute("info") BudgetInfo info,HttpServletRequest request) throws IOException 
	{
		info.setCreaterId(this.getUserProfile().getUserId());
		info.setCreaterName(this.getUserProfile().getUserDisp());
		ResponseEntity<Object> responseEntity = this.restTemplate.exchange(BUDGET_INFO_CREATE, HttpMethod.POST, new HttpEntity<BudgetInfo>(info, this.httpHeaders), Object.class);
		return JSON.toJSON(responseEntity.getBody());
	}
	@RequestMapping(value = "/budget/budget-info-create-bytemplate", method = RequestMethod.POST)
	@ResponseBody
	public Object createBudgetGroupInfoByTemplate(@ModelAttribute("info") BudgetInfo info,HttpServletRequest request) throws IOException 
	{
		info.setCreaterId(this.getUserProfile().getUserId());
		info.setCreaterName(this.getUserProfile().getUserDisp());
		ResponseEntity<Object> responseEntity = this.restTemplate.exchange(BUDGET_INFO_CREATE_BYTEMPLATE, HttpMethod.POST, new HttpEntity<BudgetInfo>(info, this.httpHeaders), Object.class);
		return JSON.toJSON(responseEntity.getBody());
	}
	
	
	@RequestMapping(method = RequestMethod.GET, value = "/budget/unit_select_tree")
	public Object toBudgetAssetSelectUnit(HttpServletRequest request) throws IOException 
	{
		request.setAttribute("company", request.getParameter("company"));
		return "stp/budget/unit_select_tree";
	}
	@RequestMapping(value = "/budget/budget-info-final-list", method = RequestMethod.POST)
	@ResponseBody
	public Object getBudgetGroupList(@ModelAttribute("info") BudgetInfo info,HttpServletRequest request) throws IOException 
	{
		ResponseEntity<Object> responseEntity = this.restTemplate.exchange(BUDGET_INFO_FINAL_LIST, HttpMethod.POST, new HttpEntity<BudgetInfo>(info, this.httpHeaders), Object.class);
		return JSON.toJSON(responseEntity.getBody());
	}
	@RequestMapping(value = "/budget/budget-release-list", method = RequestMethod.POST)
	@ResponseBody
	public Object getBudgetRelaseList(@ModelAttribute("param") LayuiTableParam param,HttpServletRequest request) throws IOException 
	{
		ResponseEntity<Object> responseEntity = this.restTemplate.exchange(BUDGET_RELEASE_LIST, HttpMethod.POST, new HttpEntity<LayuiTableParam>(param, this.httpHeaders), Object.class);
		Object rs = JSON.toJSON(responseEntity.getBody());
		//System.out.println(JSON.toJSONString(responseEntity.getBody()));
		return rs;
		
	}
	@RequestMapping(value = "/budget/budget-info-release", method = RequestMethod.POST)
	@ResponseBody
	public Object budgetInfoRelase(@ModelAttribute("info") BudgetInfo info,HttpServletRequest request) throws IOException 
	{
		info.setReleaseStatus(BudgetReleaseEnum.STATUS_RELEASE.getCode());
		ResponseEntity<Object> responseEntity = this.restTemplate.exchange(BUDGET_INFO_RELEASE, HttpMethod.POST, new HttpEntity<BudgetInfo>(info, this.httpHeaders), Object.class);
		Object rs = JSON.toJSON(responseEntity.getBody());
		//System.out.println(JSON.toJSONString(responseEntity.getBody()));
		return rs;
		
	}
	@RequestMapping(value = "/budget/budget-info-norelease", method = RequestMethod.POST)
	@ResponseBody
	public Object budgetInfoNoRelase(@ModelAttribute("info") BudgetInfo info,HttpServletRequest request) throws IOException 
	{
		info.setReleaseStatus(BudgetReleaseEnum.STATUS_NORELEASE.getCode());
		ResponseEntity<Object> responseEntity = this.restTemplate.exchange(BUDGET_INFO_RELEASE, HttpMethod.POST, new HttpEntity<BudgetInfo>(info, this.httpHeaders), Object.class);
		Object rs = JSON.toJSON(responseEntity.getBody());
		//System.out.println(JSON.toJSONString(responseEntity.getBody()));
		return rs;
		
	}
	@RequestMapping(value = "/budget/budget-modify-list", method = RequestMethod.POST)
	@ResponseBody
	public Object getBudgetModifyList(@ModelAttribute("param") LayuiTableParam param,HttpServletRequest request) throws IOException 
	{
		ResponseEntity<Object> responseEntity = this.restTemplate.exchange(BUDGET_MODIFY_LIST, HttpMethod.POST, new HttpEntity<LayuiTableParam>(param, this.httpHeaders), Object.class);
		Object rs = JSON.toJSON(responseEntity.getBody());
		//System.out.println(JSON.toJSONString(responseEntity.getBody()));
		return rs;
		
	}
	@RequestMapping(value = "/budget/budget-stock-split-jz", method = RequestMethod.POST)
	@ResponseBody
	public Object getBudgetStockSplitJz(@ModelAttribute("param") LayuiTableParam param,HttpServletRequest request) throws IOException 
	{
		ResponseEntity<Object> responseEntity = this.restTemplate.exchange(BUDGET_STOCK_SPLIT_JZ, HttpMethod.POST, new HttpEntity<LayuiTableParam>(param, this.httpHeaders), Object.class);
		Object rs = JSON.toJSON(responseEntity.getBody());
		return rs;
	}
	@RequestMapping(value = "/budget/budget-stock-total-jz", method = RequestMethod.POST)
	@ResponseBody
	public Object getBudgetStockTotalJz(@ModelAttribute("param") LayuiTableParam param,HttpServletRequest request) throws IOException 
	{
		ResponseEntity<Object> responseEntity = this.restTemplate.exchange(BUDGET_STOCK_TOTAL_JZ, HttpMethod.POST, new HttpEntity<LayuiTableParam>(param, this.httpHeaders), Object.class);
		Object rs = JSON.toJSON(responseEntity.getBody());
		return rs;
	}
}
