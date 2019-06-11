package com.pcitc.web.controller.budget;

import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URL;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.HorizontalAlignment;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.VerticalAlignment;
import org.apache.poi.ss.util.CellRangeAddress;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;
import com.pcitc.base.common.LayuiTableData;
import com.pcitc.base.common.LayuiTableParam;
import com.pcitc.base.common.Result;
import com.pcitc.base.common.enums.BudgetAuditStatusEnum;
import com.pcitc.base.common.enums.BudgetExceptionResultEnum;
import com.pcitc.base.common.enums.BudgetInfoEnum;
import com.pcitc.base.stp.budget.BudgetB2cSplit;
import com.pcitc.base.stp.budget.BudgetInfo;
import com.pcitc.base.util.DateUtil;
import com.pcitc.base.util.DateUtils;
import com.pcitc.base.util.IdUtil;
import com.pcitc.base.workflow.WorkflowVo;
import com.pcitc.web.common.BaseController;
/**
 * 事业部预算（炼油事业部，化工事业部）
 * @author fb
 *
 */
@Controller
public class BudgetB2cSplitController extends BaseController {

	private static final String BUDGET_b2csplit_TABLE = "http://pcitc-zuul/stp-proxy/stp-provider/budget/budget-b2csplit-info-table";
	private static final String BUDGET_b2csplit_LIST = "http://pcitc-zuul/stp-proxy/stp-provider/budget/budget-b2csplit-info-list";	
	private static final String BUDGET_b2csplit_INFO = "http://pcitc-zuul/stp-proxy/stp-provider/budget/budget-b2csplit-info";	
	private static final String BUDGET_b2csplit_ITEMS = "http://pcitc-zuul/stp-proxy/stp-provider/budget/budget-b2csplit-items";
	private static final String BUDGET_b2csplit_CREATE = "http://pcitc-zuul/stp-proxy/stp-provider/budget/budget-create-blank-b2csplit";
	private static final String BUDGET_b2csplit_CREATE_BYTEMPLATE = "http://pcitc-zuul/stp-proxy/stp-provider/budget/budget-create-template-b2csplit";
	private static final String BUDGET_b2csplit_DELETE = "http://pcitc-zuul/stp-proxy/stp-provider/budget/budget-b2csplit-del";
	private static final String BUDGET_b2csplit_GET_ITEM = "http://pcitc-zuul/stp-proxy/stp-provider/budget/get-b2csplit-item/";
	private static final String BUDGET_b2csplit_GET_ITEM_COMPANY = "http://pcitc-zuul/stp-proxy/stp-provider/budget/get-b2csplit-item-company/";
	private static final String BUDGET_b2csplit_DEL_ITEMS = "http://pcitc-zuul/stp-proxy/stp-provider/budget/del-b2csplit-item/";
	private static final String BUDGET_b2csplit_SAVE_ITEM = "http://pcitc-zuul/stp-proxy/stp-provider/budget/save-b2csplit-item";
	private static final String BUDGET_b2csplit_SAVE_ITEMS = "http://pcitc-zuul/stp-proxy/stp-provider/budget/save-b2csplit-items";
	private static final String BUDGET_b2csplit_SAVE_CHILDITEMS = "http://pcitc-zuul/stp-proxy/stp-provider/budget/save-b2csplit-childitems";
	private static final String BUDGET_b2csplit_COMPANY_ITEMS = "http://pcitc-zuul/stp-proxy/stp-provider/budget/search-b2c-company-items";
	private static final String BUDGET_b2csplit_COMPANY_TREE = "http://pcitc-zuul/stp-proxy/stp-provider/budget/search-b2c-company-tree";
	private static final String BUDGET_b2csplit_HISTORY_ITEMS = "http://pcitc-zuul/stp-proxy/stp-provider/budget/search-b2csplit-history-items";
	private static final String BUDGET_b2csplit_FINAL_HISTORY_LIST = "http://pcitc-zuul/stp-proxy/stp-provider/budget/search-b2csplit-final-history-list";
	private static final String BUDGET_b2csplit_COMPARE_PLAN = "http://pcitc-zuul/stp-proxy/stp-provider/budget/select-b2csplit-compare-plan";
	private static final String BUDGET_b2csplit_COMPARE_PROJECT = "http://pcitc-zuul/stp-proxy/stp-provider/budget/select-b2csplit-compare-project";
	
	private static final String BUDGET_INFO_UPDATE = "http://pcitc-zuul/stp-proxy/stp-provider/budget/budget-info-update";
	private static final String BUDGET_WORKFLOW_URL = "http://pcitc-zuul/stp-proxy/stp-provider/budget/start-budgetinfo-activity/";
	//private static final String BUDGET_INFO_GET = "http://pcitc-zuul/stp-proxy/stp-provider/budget/budget-info-get/";
	//private static final String PROJECT_NOTICE_WORKFLOW_URL = "http://pcitc-zuul/stp-proxy/stp-provider/budget/start-budget-b2csplit-activity/";
	private static final String BUDGET_b2csplit_ITEM_TREE = "http://pcitc-zuul/stp-proxy/stp-provider/budget/search-b2citem-tree";
	private static final String BUDGET_INFO_EDIT_CHECK = "http://pcitc-zuul/stp-proxy/stp-provider/budget/check-budgetinfo-edit/";
	private static final String BUDGET_FINAL_INFO = "http://pcitc-zuul/stp-proxy/stp-provider/budget/get-final-budget";
	
	
	@RequestMapping(method = RequestMethod.GET, value = "/budget/budget_main_b2csplit")
	public Object toBudgetB2cPage(HttpServletRequest request) throws IOException 
	{
		request.setAttribute("nd", DateUtil.format(DateUtil.getNextYearDay(new Date()), DateUtil.FMT_YYYY));
		return "stp/budget/budget_main_b2csplit";
	}
	@RequestMapping(method = RequestMethod.GET, value = "/budget/budget_edit_b2csplit")
	public Object toBudgetB2cEditPage(HttpServletRequest request) throws IOException 
	{
		String dataId = request.getParameter("dataId");
		String nd = request.getParameter("nd");
		request.setAttribute("dataId", dataId==null?IdUtil.createIdByTime():dataId);
		request.setAttribute("budgetInfoId", request.getParameter("budgetInfoId"));
		request.setAttribute("nd", nd ==null?DateUtil.format(new Date(), DateUtil.FMT_YYYY):nd);
		return "stp/budget/budget_edit_b2csplit";
	}
	@RequestMapping(method = RequestMethod.GET, value = "/budget/budget_create_b2csplit")
	public Object toBudgetB2cAddPage(HttpServletRequest request) throws IOException 
	{
		//request.setAttribute("nd", DateUtil.format(new Date(), DateUtil.FMT_YYYY));
		request.setAttribute("nd", request.getParameter("nd"));
		return "stp/budget/budget_create_b2csplit";
	}
	@RequestMapping(method = RequestMethod.GET, value = "/budget/budget_history_compare_b2csplit")
	public Object toBudgetB2cSplitHistoryPage(HttpServletRequest request) throws IOException 
	{
		
		request.setAttribute("dataId", request.getParameter("dataId"));
		request.setAttribute("budgetInfoId", request.getParameter("budgetInfoId"));
		request.setAttribute("nd", DateUtil.format(new Date(), DateUtil.FMT_YYYY));
		return "stp/budget/budget_history_compare_b2csplit";
	}
	@RequestMapping(method = RequestMethod.GET, value = "/budget/budget_history_view_b2csplit")
	public Object toBudgetB2cSplitHistoryViews(HttpServletRequest request) throws IOException 
	{
		//检索数据
		ResponseEntity<?> infors = this.restTemplate.exchange(BUDGET_b2csplit_FINAL_HISTORY_LIST, HttpMethod.POST, new HttpEntity<Object>(this.httpHeaders), List.class);
		String budgetInfoId = request.getParameter("budgetInfoId");
		request.setAttribute("budgetInfoId", budgetInfoId);
		request.setAttribute("tb_datas", infors.getBody());
		//request.setAttribute("nd", DateUtil.format(new Date(), DateUtil.FMT_YYYY));
		return "stp/budget/budget_history_view_b2csplit";
	}
	@RequestMapping(method = RequestMethod.GET, value = "/budget/budget_detail_b2csplit")
	public Object toBudgetGroupDetail(HttpServletRequest request) throws IOException 
	{
		request.setAttribute("dataId", request.getParameter("dataId"));
		return "stp/budget/budget_detail_b2csplit";
	}
	@RequestMapping(method = RequestMethod.GET, value = "/budget/budget_detail_b2csplit_nd")
	public Object toBudgetGroupDetailByNd(HttpServletRequest request) throws IOException 
	{
		String nd = request.getParameter("nd");
		if(nd == null) {
			nd = DateUtils.dateToStr(new Date(),"yyyy");
		}
		//找到最新
		BudgetInfo param = new BudgetInfo();
		param.setNd(nd);
		param.setBudgetType(BudgetInfoEnum.B2C_SPLIT.getCode());
		BudgetInfo rs = this.restTemplate.exchange(BUDGET_FINAL_INFO, HttpMethod.POST, new HttpEntity<Object>(param,this.httpHeaders), BudgetInfo.class).getBody();
		
		request.setAttribute("nd", nd);
		request.setAttribute("dataId", rs == null?"0":rs.getDataId());
		return "stp/budget/budget_detail_b2csplit";
	}
	
	@RequestMapping(value = "/budget/budget-b2c-info-list", method = RequestMethod.POST)
	@ResponseBody
	public Object getBudgetB2cList(@ModelAttribute("info") BudgetInfo info,HttpServletRequest request) throws IOException 
	{
		ResponseEntity<Object> responseEntity = this.restTemplate.exchange(BUDGET_b2csplit_LIST, HttpMethod.POST, new HttpEntity<BudgetInfo>(info, this.httpHeaders), Object.class);
		//System.out.println(JSON.toJSON(responseEntity.getBody()).toString());
		return JSON.toJSON(responseEntity.getBody()).toString();
	}
	@RequestMapping(value = "/budget/budget-b2c-info-table", method = RequestMethod.POST)
	@ResponseBody
	public Object getBudgetB2cTable(@ModelAttribute("param") LayuiTableParam param,HttpServletRequest request) throws IOException 
	{
		ResponseEntity<Object> responseEntity = this.restTemplate.exchange(BUDGET_b2csplit_TABLE, HttpMethod.POST, new HttpEntity<LayuiTableParam>(param, this.httpHeaders), Object.class);
		//System.out.println(JSON.toJSON(responseEntity.getBody()).toString());
		return JSON.toJSON(responseEntity.getBody()).toString();
	}
	@RequestMapping(value = "/budget/budget-b2csplit-items", method = RequestMethod.POST)
	@ResponseBody
	public Object getBudgetB2cItems(@ModelAttribute("param") LayuiTableParam param,HttpServletRequest request) throws IOException 
	{
		ResponseEntity<Object> responseEntity = this.restTemplate.exchange(BUDGET_b2csplit_ITEMS, HttpMethod.POST, new HttpEntity<LayuiTableParam>(param, this.httpHeaders), Object.class);
		System.out.println(JSON.toJSON(responseEntity.getBody()));
		return JSON.toJSON(responseEntity.getBody()).toString();
	}
	@RequestMapping(value = "/budget/budget-b2csplit-create", method = RequestMethod.POST)
	@ResponseBody
	public Object createBudgetB2cInfo(@ModelAttribute("info") BudgetInfo info,HttpServletRequest request) throws IOException 
	{
		
		info.setCreaterId(this.getUserProfile().getUserId());
		info.setCreaterName(this.getUserProfile().getUserDisp());
		ResponseEntity<Object> responseEntity = this.restTemplate.exchange(BUDGET_b2csplit_CREATE, HttpMethod.POST, new HttpEntity<BudgetInfo>(info, this.httpHeaders), Object.class);
		//System.out.println(JSON.toJSON(responseEntity.getBody()).toString());
		return JSON.toJSON(responseEntity.getBody()).toString();
	}
	
	@RequestMapping(value = "/budget/budget-b2csplit-create-bytemplate", method = RequestMethod.POST)
	@ResponseBody
	public Object createBudgetB2cInfoByTemplate(@ModelAttribute("info") BudgetInfo info,HttpServletRequest request) throws IOException 
	{
		info.setCreaterId(this.getUserProfile().getUserId());
		info.setCreaterName(this.getUserProfile().getUserDisp());
		ResponseEntity<Object> responseEntity = this.restTemplate.exchange(BUDGET_b2csplit_CREATE_BYTEMPLATE, HttpMethod.POST, new HttpEntity<BudgetInfo>(info, this.httpHeaders), Object.class);
		//System.out.println(JSON.toJSON(responseEntity.getBody()).toString());
		return JSON.toJSON(responseEntity.getBody()).toString();
	}
	
	@RequestMapping(value = "/budget/budget-b2csplit-del", method = RequestMethod.POST)
	@ResponseBody
	public Object deleteBudgetB2cInfo(@ModelAttribute("info") BudgetInfo info,HttpServletRequest request) throws IOException 
	{
		ResponseEntity<Object> responseEntity = this.restTemplate.exchange(BUDGET_b2csplit_DELETE, HttpMethod.POST, new HttpEntity<BudgetInfo>(info, this.httpHeaders), Object.class);
		//System.out.println(JSON.toJSON(responseEntity.getBody()).toString());
		return JSON.toJSON(responseEntity.getBody()).toString();
	}
	@RequestMapping(value = "/budget/get-b2csplit-item/{dataId}", method = RequestMethod.POST)
	@ResponseBody
	public Object selectBudgetB2cSplitItem(@PathVariable("dataId") String dataId,HttpServletRequest request) throws IOException 
	{
		ResponseEntity<Object> responseEntity = this.restTemplate.exchange(BUDGET_b2csplit_GET_ITEM+dataId, HttpMethod.POST, new HttpEntity<Object>(dataId, this.httpHeaders), Object.class);
		//System.out.println(JSON.toJSON(responseEntity.getBody()).toString());
		return JSON.toJSON(responseEntity.getBody()).toString();
	}
	@RequestMapping(value = "/budget/get-b2csplit-item-company/{dataId}", method = RequestMethod.POST)
	@ResponseBody
	public Object selectBudgetB2cSplitItemCompany(@PathVariable("dataId") String dataId,HttpServletRequest request) throws IOException 
	{
		ResponseEntity<Object> responseEntity = this.restTemplate.exchange(BUDGET_b2csplit_GET_ITEM_COMPANY+dataId, HttpMethod.POST, new HttpEntity<Object>(dataId, this.httpHeaders), Object.class);
		//System.out.println(JSON.toJSON(responseEntity.getBody()).toString());
		return JSON.toJSON(responseEntity.getBody()).toString();
	}
	@RequestMapping(value = "/budget/save-b2csplit-item", method = RequestMethod.POST)
	@ResponseBody
	public Object saveBudgetB2cSplitItem(@ModelAttribute("item") BudgetB2cSplit item,HttpServletRequest request) throws IOException 
	{
		Result result = this.restTemplate.exchange(BUDGET_INFO_EDIT_CHECK+item.getBudgetInfoId(), HttpMethod.POST, new HttpEntity<Object>(this.httpHeaders), Result.class).getBody();
		if(!result.isSuccess()) {
			return result;
		}
		ResponseEntity<BudgetB2cSplit> rs = this.restTemplate.exchange(BUDGET_b2csplit_SAVE_ITEM, HttpMethod.POST, new HttpEntity<BudgetB2cSplit>(item, this.httpHeaders), BudgetB2cSplit.class);
		if (rs.getBody() != null) {
			return new Result(true,rs.getBody());
		} else {
			return BudgetExceptionResultEnum.ERROR;
		}
	}
	@RequestMapping(value = "/budget/save-b2csplit-items", method = RequestMethod.POST)
	@ResponseBody
	public Object saveBudgetB2cSplitItems(
			@ModelAttribute("items") String items,
			@ModelAttribute("info") String info,HttpServletRequest request) throws IOException 
	{
		
		BudgetInfo budget = JSON.toJavaObject(JSON.parseObject(info), BudgetInfo.class);
		//检查是否可编辑
		Result result = this.restTemplate.exchange(BUDGET_INFO_EDIT_CHECK+budget.getDataId(), HttpMethod.POST, new HttpEntity<Object>(this.httpHeaders), Result.class).getBody();
		if(!result.isSuccess()) {
			return result;
		}
		
		List<BudgetB2cSplit> stocklist = JSON.parseArray(items, BudgetB2cSplit.class);
		ResponseEntity<Integer> infors = this.restTemplate.exchange(BUDGET_INFO_UPDATE, HttpMethod.POST, new HttpEntity<Object>(budget, this.httpHeaders), Integer.class);
		ResponseEntity<Integer> stockrs = this.restTemplate.exchange(BUDGET_b2csplit_SAVE_ITEMS, HttpMethod.POST, new HttpEntity<Object>(stocklist, this.httpHeaders), Integer.class);
		if (infors.getBody() >= 0 && stockrs.getBody() >= 0) 
		{
			return new Result(true);
		} else {
			return BudgetExceptionResultEnum.ERROR;
		}
	}
	@RequestMapping(value = "/budget/save-b2csplit-childitems", method = RequestMethod.POST)
	@ResponseBody
	public Object saveBudgetChildb2csplitItems(@RequestParam("items")String items,@RequestParam("item")String item,HttpServletRequest request) throws IOException 
	{
		//检查是否可编辑
		Result result = this.restTemplate.exchange(BUDGET_INFO_EDIT_CHECK+JSON.parseObject(item).get("budgetInfoId"), HttpMethod.POST, new HttpEntity<Object>(this.httpHeaders), Result.class).getBody();
		if(!result.isSuccess()) {
			return result;
		}
		
		Map<String,Object> mapParam = new HashMap<String,Object>();
		mapParam.put("items", JSON.parseArray(items).toString());
		mapParam.put("item", JSON.parse(item).toString());
		ResponseEntity<Integer> responseEntity = this.restTemplate.exchange(BUDGET_b2csplit_SAVE_CHILDITEMS, HttpMethod.POST, new HttpEntity<Object>(mapParam, this.httpHeaders), Integer.class);
		if (responseEntity.getBody() == 0) {
			return new Result(false);
		} else {
			return BudgetExceptionResultEnum.ERROR;
		}
	}
	
	@RequestMapping(value = "/budget/search-b2c-company-items", method = RequestMethod.POST)
	@ResponseBody
	public Object searchBudgetB2cCompanyItems(HttpServletRequest request) throws IOException 
	{
		//获取所有的集团公司
		ResponseEntity<?> responseEntity = this.restTemplate.exchange(BUDGET_b2csplit_COMPANY_ITEMS, HttpMethod.POST, new HttpEntity<Object>(this.httpHeaders), List.class);
		return responseEntity.getBody();
	}
	@RequestMapping(value = "/budget/search-b2c-company-tree", method = RequestMethod.POST)
	@ResponseBody
	public Object searchBudgetB2cCompanyTree(HttpServletRequest request) throws IOException 
	{
		//获取所有的集团公司
		ResponseEntity<?> responseEntity = this.restTemplate.exchange(BUDGET_b2csplit_COMPANY_TREE, HttpMethod.POST, new HttpEntity<Object>(this.httpHeaders), List.class);
		return responseEntity.getBody();
	}
	@RequestMapping(value = "/budget/del-b2c-item/{dataId}", method = RequestMethod.POST)
	@ResponseBody
	public Object deleteBudgetB2cItem(@PathVariable("dataId") String dataId,HttpServletRequest request) throws IOException 
	{
		//检查是否可删除
		Map<?,?> rsmap = this.restTemplate.exchange(BUDGET_b2csplit_GET_ITEM+dataId, HttpMethod.POST, new HttpEntity<Object>(dataId, this.httpHeaders), Map.class).getBody();
		Result result = this.restTemplate.exchange(BUDGET_INFO_EDIT_CHECK+rsmap.get("budgetInfoId"), HttpMethod.POST, new HttpEntity<Object>(this.httpHeaders), Result.class).getBody();
		if(!result.isSuccess()) {
			return result;
		}
		
		ResponseEntity<Integer> responseEntity = this.restTemplate.exchange(BUDGET_b2csplit_DEL_ITEMS+dataId, HttpMethod.POST, new HttpEntity<Object>(this.httpHeaders), Integer.class);
		if (responseEntity.getBody() == 0) {
			return new Result(false);
		} else {
			return BudgetExceptionResultEnum.ERROR;
		}
	}
	@RequestMapping(value = "/budget/start-budget-b2csplit-activity", method = RequestMethod.POST)
	@ResponseBody
	public Object submitBudgetB2cSplit(@RequestParam(value = "budgetInfoId", required = true) String budgetInfoId,
			@RequestParam(value = "functionId", required = true) String functionId,HttpServletRequest request) throws IOException 
	{
		System.out.println("start-budget-b2csplit-activity-----------------");
		WorkflowVo vo = new WorkflowVo();
		vo.setAuditUserIds(this.getUserProfile().getUserId());
		vo.setFunctionId(functionId);
		vo.setAuthenticatedUserId(this.getUserProfile().getUserId());
		vo.setBusinessId(budgetInfoId);
		vo.setProcessInstanceName("事业部预算审批");
		vo.setAuthenticatedUserName(this.getUserProfile().getUserDisp());
		vo.setMessageUserIds(this.getUserProfile().getUserId());
		
		// 待办业务详情、最终审批同意、最终审批不同意路径
		vo.setAuditDetailsPath("/budget/budget_detail_b2csplit?dataId="+budgetInfoId);
		vo.setAuditAgreeMethod("http://pcitc-zuul/stp-proxy/stp-provider/budget/callback-workflow-notice-budgetinfo?budgetId="+budgetInfoId+"&workflow_status="+BudgetAuditStatusEnum.AUDIT_STATUS_PASS.getCode());
		vo.setAuditRejectMethod("http://pcitc-zuul/stp-proxy/stp-provider/budget/callback-workflow-notice-budgetinfo?budgetId="+budgetInfoId+"&workflow_status="+BudgetAuditStatusEnum.AUDIT_STATUS_REFUSE.getCode());
		
		HttpEntity<WorkflowVo> entity = new HttpEntity<WorkflowVo>(vo, this.httpHeaders);
		Result startRs = this.restTemplate.exchange(BUDGET_WORKFLOW_URL + budgetInfoId, HttpMethod.POST, entity, Result.class).getBody();
		return startRs;
		
	}
	@RequestMapping(value = "/budget/search-b2csplit-history-items", method = RequestMethod.POST)
	@ResponseBody
	public Object searchBudgetB2cSplitHistoryItems(@ModelAttribute("info") BudgetB2cSplit info,HttpServletRequest request) throws IOException 
	{
		//System.out.println(JSON.toJSONString(info));
		ResponseEntity<?> infors = this.restTemplate.exchange(BUDGET_b2csplit_HISTORY_ITEMS, HttpMethod.POST, new HttpEntity<Object>(info, this.httpHeaders), List.class);
		return infors.getBody();
	}
	@RequestMapping(value = "/budget/search-b2csplit-final-history-list", method = RequestMethod.POST)
	@ResponseBody
	public Object searchBudgetB2cSplitFinalHistoryList(HttpServletRequest request) throws IOException 
	{
		//System.out.println(JSON.toJSONString(info));
		ResponseEntity<?> infors = this.restTemplate.exchange(BUDGET_b2csplit_FINAL_HISTORY_LIST, HttpMethod.POST, new HttpEntity<Object>(this.httpHeaders), List.class);
		return infors.getBody();
	}
	
	
	@RequestMapping(value = "/budget/select-b2csplit-compare-plan", method = RequestMethod.POST)
	@ResponseBody
	public Object selectBudgetB2cSplitComparePlan(@RequestParam(value="nd",required = false)String nd,@RequestParam(value="code",required = false)String code,HttpServletRequest request) throws IOException 
	{
		System.out.println("plan............"+nd+"------"+code);
		if(nd == null || code == null) {
			return new ArrayList<Object>();
		}
		Map<String,Object> param = new HashMap<String,Object>();
		param.put("nd", nd);
		param.put("code", code);
		//System.out.println(JSON.toJSONString(info));
		ResponseEntity<?> infors = this.restTemplate.exchange(BUDGET_b2csplit_COMPARE_PLAN, HttpMethod.POST, new HttpEntity<Object>(param,this.httpHeaders), List.class);
		//System.out.println(JSON.toJSONString(infors.getBody()));
		return infors.getBody();
	}
	
	@RequestMapping(value = "/budget/select-b2csplit-compare-project", method = RequestMethod.POST)
	@ResponseBody
	public Object selectBudgetB2cSplitCompareProject(@RequestParam(value="nd",required = false)String nd,@RequestParam(value="code",required = false)String code,HttpServletRequest request) throws IOException 
	{
		System.out.println("plan............"+nd+"------"+code);
		if(nd == null || code == null) {
			return new ArrayList<Object>();
		}
		Map<String,Object> param = new HashMap<String,Object>();
		param.put("nd", nd);
		param.put("code", code);
		//System.out.println(JSON.toJSONString(info));
		ResponseEntity<?> infors = this.restTemplate.exchange(BUDGET_b2csplit_COMPARE_PROJECT, HttpMethod.POST, new HttpEntity<Object>(param,this.httpHeaders), List.class);
		//System.out.println(JSON.toJSONString(infors.getBody()));
		return infors.getBody();
	}
	@RequestMapping(value = "/budget/search-b2citem-tree", method = RequestMethod.POST)
	@ResponseBody
	public Object searchB2citemTree(@RequestParam(value="dataId",required = false)String dataId,HttpServletRequest request, HttpServletResponse response) throws Exception 
	{
		ResponseEntity<?> infors = this.restTemplate.exchange(BUDGET_b2csplit_ITEM_TREE, HttpMethod.POST, new HttpEntity<Object>(dataId,this.httpHeaders), Object.class);
		//System.out.println(JSON.toJSONString(infors.getBody()));
		return infors.getBody();
	}
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	@RequestMapping("/budget/budget_download/b2csplit/{dataId}")
	public void downBudgetB2cSplit(@PathVariable("dataId") String dataId,HttpServletResponse res) throws IOException 
	{
		LayuiTableParam param = new LayuiTableParam();
		param.getParam().put("budget_info_id", dataId);
		param.setLimit(100);
		param.setPage(1);
		ResponseEntity<LayuiTableData> responseEntity = this.restTemplate.exchange(BUDGET_b2csplit_ITEMS, HttpMethod.POST, new HttpEntity<LayuiTableParam>(param, this.httpHeaders), LayuiTableData.class);
		LayuiTableData tabldata = responseEntity.getBody();
		//System.out.println(JSON.toJSONString(tabldata));
		
		ResponseEntity<BudgetInfo> rs = this.restTemplate.exchange(BUDGET_b2csplit_INFO, HttpMethod.POST, new HttpEntity<String>(dataId, this.httpHeaders), BudgetInfo.class);
		BudgetInfo info = rs.getBody();
		
		Map<String,String> parammap = new HashMap<String,String>();
		parammap.put("nd", info.getNd());
		
		
		URL path = this.getClass().getResource("/");
		File f = new File(path.getPath() + "static/budget/budget_b2csplit_template.xlsx");
		//System.out.println(f.getAbsolutePath());
		//写入新文件2019年集团公司总部科技经费预算
		String newFilePath = path.getPath() + "static/budget/"+info.getNd()+"股份炼油事业部、化工事业部B2、C类科技经费预算表（建议稿）_"+DateUtil.dateToStr(new Date(), "yyyyMMddHHmmss")+".xlsx";
		File outFile = new File(newFilePath);
		
		processDataAndDownload(f,new ArrayList(tabldata.getData()),parammap,outFile);
	    //下载文件
		this.fileDownload(new File(newFilePath), res);
	}
	
	
	
	private XSSFWorkbook workbook;
	private XSSFSheet sheet;
	private void processDataAndDownload(File template,List<Map<String,Object>> list,Map<String,String> param,File outFile) 
	{
		try {
			InputStream is = new FileInputStream(template);
			workbook = new XSSFWorkbook(is);
			sheet = workbook.getSheetAt(0);
			
			Integer nd = Integer.parseInt(param.get("nd"));
			//处理标题 年度
			String title = readCell(sheet.getRow(0).getCell(0));
			sheet.getRow(0).getCell(0).setCellValue(title.replace("${nd}", nd.toString()));
			//从第四行开始，第五行是汇总数据
			Row templateRow = sheet.getRow(4);
			
			//水平，垂直居中
			CellStyle centerStyle =workbook.createCellStyle();
			centerStyle.cloneStyleFrom(templateRow.getCell(0).getCellStyle());
			centerStyle.setAlignment(HorizontalAlignment.CENTER);
			centerStyle.setVerticalAlignment(VerticalAlignment.CENTER);
			//水平居左，垂直居中
			CellStyle leftCenterStyle =workbook.createCellStyle();
			leftCenterStyle.cloneStyleFrom(templateRow.getCell(1).getCellStyle());
			leftCenterStyle.setAlignment(HorizontalAlignment.LEFT);
			leftCenterStyle.setVerticalAlignment(VerticalAlignment.CENTER);
			//水平居右，垂直居中
			CellStyle rightCenterStyle =workbook.createCellStyle();
			rightCenterStyle.cloneStyleFrom(templateRow.getCell(3).getCellStyle());
			rightCenterStyle.setAlignment(HorizontalAlignment.RIGHT);
			rightCenterStyle.setVerticalAlignment(VerticalAlignment.CENTER);
			
			
			
			Double allLyTotal = 0d;
			Double allLyJz = 0d;
			Double allLyXq= 0d;
			Double allHgTotal = 0d;
			Double allHgJz = 0d;
			Double allHgXq = 0d;
			for(int i = 0;i<list.size();i++) {
				
				Integer no = (Integer)list.get(i).get("no");
				String displayName = list.get(i).get("displayName").toString();
				Integer level = (Integer)list.get(i).get("level");
				
				Double lyTotal = (Double)list.get(i).get("lyTotal");
				Double lyJz = (Double)list.get(i).get("lyJz");
				Double lyXq = (Double)list.get(i).get("lyXq");
				Double hgTotal = (Double)list.get(i).get("hgTotal");
				Double hgJz = (Double)list.get(i).get("hgJz");
				Double hgXq = (Double)list.get(i).get("hgXq");
				allLyTotal += lyTotal;
				allLyJz += lyJz;
				allLyXq += lyXq;
				allHgTotal += hgTotal;
				allHgJz += hgJz;
				allHgXq += hgXq;
				
				Row crow = sheet.getRow(i+4);
				if(level == 0) {
					crow.createCell(0).setCellValue(no);
				}else {
					crow.createCell(0).setCellValue("");
				}
				crow.createCell(1).setCellValue(displayName);
				crow.createCell(2).setCellValue(lyTotal);
				crow.createCell(3).setCellValue(lyJz);
				crow.createCell(4).setCellValue(lyXq);
				crow.createCell(5).setCellValue(hgTotal);
				crow.createCell(6).setCellValue(hgJz);
				crow.createCell(7).setCellValue(hgXq);
				
				crow.getCell(0).setCellStyle(centerStyle);
				if(level == 0) {
					crow.getCell(1).setCellStyle(leftCenterStyle);
				}else {
					crow.getCell(1).setCellStyle(rightCenterStyle);
				}
				crow.getCell(2).setCellStyle(rightCenterStyle);
				crow.getCell(3).setCellStyle(rightCenterStyle);
				crow.getCell(4).setCellStyle(rightCenterStyle);
				crow.getCell(5).setCellStyle(rightCenterStyle);
				crow.getCell(6).setCellStyle(rightCenterStyle);
				crow.getCell(7).setCellStyle(rightCenterStyle);
			}

			Row totalRow = sheet.getRow(list.size()+4);
			totalRow.createCell(0).setCellValue("合计");
			totalRow.createCell(1).setCellValue("");
			totalRow.createCell(2).setCellValue(allLyTotal);
			totalRow.createCell(3).setCellValue(allLyJz);
			totalRow.createCell(4).setCellValue(allLyXq);
			totalRow.createCell(5).setCellValue(allHgTotal);
			totalRow.createCell(6).setCellValue(allHgJz);
			totalRow.createCell(7).setCellValue(allHgXq);
			
			totalRow.getCell(0).setCellStyle(centerStyle);
			totalRow.getCell(1).setCellStyle(centerStyle);
			totalRow.getCell(2).setCellStyle(rightCenterStyle);
			totalRow.getCell(3).setCellStyle(rightCenterStyle);
			totalRow.getCell(4).setCellStyle(rightCenterStyle);
			totalRow.getCell(5).setCellStyle(rightCenterStyle);
			totalRow.getCell(6).setCellStyle(rightCenterStyle);
			totalRow.getCell(7).setCellStyle(rightCenterStyle);
			
			//合计单元格合并
			sheet.addMergedRegion(new CellRangeAddress(list.size()+4,list.size()+4,0,1));
			//写入新文件
			FileOutputStream fos  = new FileOutputStream(outFile);
			workbook.write(fos);
		    //关闭流
		    closeIO(fos);
		    closeIO(is);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	private void fileDownload(File file,HttpServletResponse res) 
	{
        OutputStream out = null;
        InputStream in = null;
        try 
        {
        	
          res.setHeader("content-type", "application/octet-stream");
          res.setContentType("application/octet-stream");
          res.setHeader("Content-Disposition", "attachment;filename=" + URLEncoder.encode(file.getName(), "UTF-8"));
        	
          out = res.getOutputStream();
          in = new FileInputStream(file);
          
          byte[] b = new byte[1000];
          int len;
          while ((len = in.read(b)) > 0)
          {
			out.write(b, 0, len);
          }
          closeIO(in);
     	  closeIO(out);
        } catch (IOException e) {
          e.printStackTrace();
        }
	}
	private void closeIO(Closeable io) 
	{
		if(io != null) 
		{
			try 
			{
				io.close();
			}
			catch(Exception e) 
			{
				e.printStackTrace();
			}
		}
	}
	private String readCell(Cell cell) 
	{
		String  cellVal = null;
		switch (cell.getCellTypeEnum()) 
		{
	        case NUMERIC:
	        	cellVal = cell.getNumericCellValue()+"";
	            break;
	        case STRING:
	        	cellVal = cell.getStringCellValue();
	            break;
	        case FORMULA:
	        	cellVal = cell.getRichStringCellValue().getString();
	            break;
	        case BLANK:
	            break;
	        case BOOLEAN:
	            break;
	        case ERROR:
	            break;
	        default:
	            break;
        }
		return cellVal;
	}
}
