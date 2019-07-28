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
import com.pcitc.base.stp.budget.BudgetGroupTotal;
import com.pcitc.base.stp.budget.BudgetInfo;
import com.pcitc.base.util.DateUtil;
import com.pcitc.base.util.DateUtils;
import com.pcitc.base.util.IdUtil;
import com.pcitc.base.workflow.WorkflowVo;
import com.pcitc.web.common.BaseController;
import com.pcitc.web.common.OperationFilter;
@Controller
public class BudgetGroupTotalController extends BaseController {

	private static final String BUDGET_GROUPTOTAL_TABLE = "http://pcitc-zuul/stp-proxy/stp-provider/budget/budget-grouptotal-info-table";
	private static final String BUDGET_GROUPTOTAL_LIST = "http://pcitc-zuul/stp-proxy/stp-provider/budget/budget-grouptotal-info-list";	
	
	private static final String BUDGET_GROUPTOTAL_ITEMS = "http://pcitc-zuul/stp-proxy/stp-provider/budget/budget-grouptotal-items";
	private static final String BUDGET_GROUPTOTAL_CREATE = "http://pcitc-zuul/stp-proxy/stp-provider/budget/budget-create-blank-grouptotal";
	private static final String BUDGET_GROUPTOTAL_CREATE_BYTEMPLATE = "http://pcitc-zuul/stp-proxy/stp-provider/budget/budget-create-template-grouptotal";
	private static final String BUDGET_GROUPTOTAL_DELETE = "http://pcitc-zuul/stp-proxy/stp-provider/budget/budget-grouptotal-del";
	private static final String BUDGET_GROUPTOTAL_GET_ITEM = "http://pcitc-zuul/stp-proxy/stp-provider/budget/get-grouptotal-item/";
	private static final String BUDGET_GROUPTOTAL_DEL_ITEMS = "http://pcitc-zuul/stp-proxy/stp-provider/budget/del-grouptotal-item/";
	private static final String BUDGET_GROUPTOTAL_SAVE_ITEM = "http://pcitc-zuul/stp-proxy/stp-provider/budget/save-grouptotal-item";
	private static final String BUDGET_GROUPTOTAL_SAVE_ITEMS = "http://pcitc-zuul/stp-proxy/stp-provider/budget/save-grouptotal-items";
	private static final String BUDGET_GROUPTOTAL_SAVE_CHILDITEMS = "http://pcitc-zuul/stp-proxy/stp-provider/budget/save-grouptotal-childitems";
	private static final String BUDGET_GROUPTOTAL_COMPANY_ITEMS = "http://pcitc-zuul/stp-proxy/stp-provider/budget/search-group-company-items";
	private static final String BUDGET_GROUPTOTAL_COMPANY_TREE = "http://pcitc-zuul/stp-proxy/stp-provider/budget/search-group-company-tree";
	private static final String BUDGET_GROUPTOTAL_PLANDATA = "http://pcitc-zuul/stp-proxy/stp-provider/budget/select-grouptotal-plandata/";
	
	private static final String BUDGET_GROUPTOTAL_HISTORY_ITEMS = "http://pcitc-zuul/stp-proxy/stp-provider/budget/search-grouptotal-history-items";
	private static final String BUDGET_GROUPTOTAL_FINAL_HISTORY_LIST = "http://pcitc-zuul/stp-proxy/stp-provider/budget/search-grouptotal-final-history-list";
	private static final String BUDGET_GROUPTOTAL_COMPARE_PLAN = "http://pcitc-zuul/stp-proxy/stp-provider/budget/select-grouptotal-compare-plan";
	private static final String BUDGET_GROUPTOTAL_COMPARE_PROJECT = "http://pcitc-zuul/stp-proxy/stp-provider/budget/select-grouptotal-compare-project";
	
	private static final String BUDGET_INFO_UPDATE = "http://pcitc-zuul/stp-proxy/stp-provider/budget/budget-info-update";
	private static final String BUDGET_WORKFLOW_URL = "http://pcitc-zuul/stp-proxy/stp-provider/budget/start-budgetinfo-activity/";
	private static final String BUDGET_INFO_GET = "http://pcitc-zuul/stp-proxy/stp-provider/budget/budget-info-get/";
	private static final String BUDGET_INFO_EDIT_CHECK = "http://pcitc-zuul/stp-proxy/stp-provider/budget/check-budgetinfo-edit/";
	private static final String BUDGET_FINAL_INFO = "http://pcitc-zuul/stp-proxy/stp-provider/budget/get-final-budget";
	
	
	
	
	@RequestMapping(method = RequestMethod.GET, value = "/budget/budget_main_grouptotal")
	public Object toBudgetGroupPage(HttpServletRequest request) throws IOException 
	{
		String nd = request.getParameter("nd");
		if(nd == null) {
			nd = DateUtil.format(DateUtil.getNextYearDay(new Date()), DateUtil.FMT_YYYY);
		}
		request.setAttribute("dataId", request.getParameter("dataId"));
		request.setAttribute("nd", nd);
		request.setAttribute("cnd", DateUtil.dateToStr(new Date(), DateUtil.FMT_YYYY));
		request.setAttribute("budgetType", BudgetInfoEnum.GROUP_TOTAL.getCode());
		return "stp/budget/budget_main_grouptotal";
	}
	@RequestMapping(method = RequestMethod.GET, value = "/budget/budget_edit_grouptotal")
	public Object toBudgetGroupEditPage(HttpServletRequest request) throws IOException 
	{
		String dataId = request.getParameter("dataId");
		String nd = request.getParameter("nd");
		request.setAttribute("dataId", dataId==null?IdUtil.createIdByTime():dataId);
		request.setAttribute("budgetInfoId", request.getParameter("budgetInfoId"));
		request.setAttribute("nd", nd ==null?DateUtil.format(new Date(), DateUtil.FMT_YYYY):nd);
		return "stp/budget/budget_edit_grouptotal";
	}
	/*@RequestMapping(method = RequestMethod.GET, value = "/budget/budget_create_grouptotal")
	public Object toBudgetGroupAddPage(HttpServletRequest request) throws IOException 
	{
		request.setAttribute("nd", request.getParameter("nd"));
		request.setAttribute("budget_type", request.getParameter("budget_type"));
		return "stp/budget/budget_create_grouptotal";
	}*/
	@RequestMapping(method = RequestMethod.GET, value = "/budget/budget_history_compare_grouptotal")
	public Object toBudgetGroupTotalHistoryPage(HttpServletRequest request) throws IOException 
	{
		
		request.setAttribute("dataId", request.getParameter("dataId"));
		request.setAttribute("budgetInfoId", request.getParameter("budgetInfoId"));
		request.setAttribute("nd", DateUtil.format(new Date(), DateUtil.FMT_YYYY));
		return "stp/budget/budget_history_compare_grouptotal";
	}
	@RequestMapping(method = RequestMethod.GET, value = "/budget/budget_history_view_grouptotal")
	public Object toBudgetGroupTotalHistoryViews(HttpServletRequest request) throws IOException 
	{
		//检索数据
		ResponseEntity<?> infors = this.restTemplate.exchange(BUDGET_GROUPTOTAL_FINAL_HISTORY_LIST, HttpMethod.POST, new HttpEntity<Object>(this.httpHeaders), List.class);
		String budgetInfoId = request.getParameter("budgetInfoId");
		request.setAttribute("budgetInfoId", budgetInfoId);
		request.setAttribute("tb_datas", infors.getBody());
		request.setAttribute("nd", DateUtil.format(new Date(), DateUtil.FMT_YYYY));
		return "stp/budget/budget_history_view_grouptotal";
	}
	@RequestMapping(method = RequestMethod.GET, value = "/budget/budget_detail_grouptotal")
	public Object toBudgetGroupDetail(HttpServletRequest request) throws IOException 
	{
		request.setAttribute("dataId", request.getParameter("dataId"));
		return "stp/budget/budget_detail_grouptotal";
	}
	@RequestMapping(method = RequestMethod.GET, value = "/budget/budget_detail_grouptotal_nd")
	public Object toBudgetGroupDetailByNd(HttpServletRequest request) throws IOException 
	{
		String nd = request.getParameter("nd");
		if(nd == null) {
			nd = DateUtils.dateToStr(new Date(),"yyyy");
		}
		//找到最新
		BudgetInfo param = new BudgetInfo();
		param.setNd(nd);
		param.setBudgetType(BudgetInfoEnum.GROUP_TOTAL.getCode());
		BudgetInfo rs = this.restTemplate.exchange(BUDGET_FINAL_INFO, HttpMethod.POST, new HttpEntity<Object>(param,this.httpHeaders), BudgetInfo.class).getBody();
		
		request.setAttribute("nd", nd);
		request.setAttribute("dataId", rs == null?"0":rs.getDataId());
		return "stp/budget/budget_detail_grouptotal";
	}
	
	
	@RequestMapping(value = "/budget/budget-group-info-list", method = RequestMethod.POST)
	@ResponseBody
	public Object getBudgetGroupList(@ModelAttribute("info") BudgetInfo info,HttpServletRequest request) throws IOException 
	{
		ResponseEntity<Object> responseEntity = this.restTemplate.exchange(BUDGET_GROUPTOTAL_LIST, HttpMethod.POST, new HttpEntity<BudgetInfo>(info, this.httpHeaders), Object.class);
		//System.out.println(JSON.toJSON(responseEntity.getBody()).toString());
		return JSON.toJSON(responseEntity.getBody());
	}
	@RequestMapping(value = "/budget/budget-group-info-table", method = RequestMethod.POST)
	@ResponseBody
	public Object getBudgetGroupTable(@ModelAttribute("param") LayuiTableParam param,HttpServletRequest request) throws IOException 
	{
		ResponseEntity<Object> responseEntity = this.restTemplate.exchange(BUDGET_GROUPTOTAL_TABLE, HttpMethod.POST, new HttpEntity<LayuiTableParam>(param, this.httpHeaders), Object.class);
		//System.out.println(JSON.toJSON(responseEntity.getBody()).toString());
		return JSON.toJSON(responseEntity.getBody());
	}
	@RequestMapping(value = "/budget/budget-grouptotal-items", method = RequestMethod.POST)
	@ResponseBody
	public Object getBudgetGroupItems(@ModelAttribute("param") LayuiTableParam param,HttpServletRequest request) throws IOException 
	{
		ResponseEntity<Object> responseEntity = this.restTemplate.exchange(BUDGET_GROUPTOTAL_ITEMS, HttpMethod.POST, new HttpEntity<LayuiTableParam>(param, this.httpHeaders), Object.class);
		//System.out.println(JSON.toJSON(responseEntity.getBody()).toString());
		return JSON.toJSON(responseEntity.getBody());
	}
	@RequestMapping(value = "/budget/budget-grouptotal-create", method = RequestMethod.POST)
	@ResponseBody
	public Object createBudgetGroupInfo(@ModelAttribute("info") BudgetInfo info,HttpServletRequest request) throws IOException 
	{
		info.setCreaterId(this.getUserProfile().getUserId());
		info.setCreaterName(this.getUserProfile().getUserDisp());
		ResponseEntity<Object> responseEntity = this.restTemplate.exchange(BUDGET_GROUPTOTAL_CREATE, HttpMethod.POST, new HttpEntity<BudgetInfo>(info, this.httpHeaders), Object.class);
		//System.out.println(JSON.toJSON(responseEntity.getBody()).toString());
		return JSON.toJSON(responseEntity.getBody());
	}
	
	@RequestMapping(value = "/budget/budget-grouptotal-create-bytemplate", method = RequestMethod.POST)
	@ResponseBody
	public Object createBudgetGroupInfoByTemplate(@ModelAttribute("info") BudgetInfo info,HttpServletRequest request) throws IOException 
	{
		info.setCreaterId(this.getUserProfile().getUserId());
		info.setCreaterName(this.getUserProfile().getUserDisp());
		ResponseEntity<Object> responseEntity = this.restTemplate.exchange(BUDGET_GROUPTOTAL_CREATE_BYTEMPLATE, HttpMethod.POST, new HttpEntity<BudgetInfo>(info, this.httpHeaders), Object.class);
		//System.out.println(JSON.toJSON(responseEntity.getBody()).toString());
		return JSON.toJSON(responseEntity.getBody());
	}
	
	@RequestMapping(value = "/budget/budget-grouptotal-del", method = RequestMethod.POST)
	@ResponseBody
	public Object deleteBudgetGroupInfo(@ModelAttribute("info") BudgetInfo info,HttpServletRequest request) throws IOException 
	{
		ResponseEntity<Object> responseEntity = this.restTemplate.exchange(BUDGET_GROUPTOTAL_DELETE, HttpMethod.POST, new HttpEntity<BudgetInfo>(info, this.httpHeaders), Object.class);
		//System.out.println(JSON.toJSON(responseEntity.getBody()).toString());
		return JSON.toJSON(responseEntity.getBody());
	}
	@RequestMapping(value = "/budget/get-grouptotal-item/{dataId}", method = RequestMethod.POST)
	@ResponseBody
	public Object selectBudgetGroupTotalItem(@ModelAttribute("param")LayuiTableParam param,@PathVariable("dataId") String dataId,HttpServletRequest request) throws IOException 
	{
		param.getParam().put("leaderFlag", "2");
		ResponseEntity<Object> responseEntity = this.restTemplate.exchange(BUDGET_GROUPTOTAL_GET_ITEM+dataId, HttpMethod.POST, new HttpEntity<LayuiTableParam>(param, this.httpHeaders), Object.class);
		//System.out.println(JSON.toJSON(responseEntity.getBody()).toString());
		return JSON.toJSON(responseEntity.getBody()).toString();
	}
	@RequestMapping(value = "/budget/save-grouptotal-item", method = RequestMethod.POST)
	@ResponseBody
	public Object saveBudgetGroupTotalItem(@ModelAttribute("item") BudgetGroupTotal item,HttpServletRequest request) throws IOException 
	{
		
		//检查是否可编辑
		Result result = this.restTemplate.exchange(BUDGET_INFO_EDIT_CHECK+item.getBudgetInfoId(), HttpMethod.POST, new HttpEntity<Object>(this.httpHeaders), Result.class).getBody();
		if(!result.isSuccess()) {
			return JSON.toJSON(result);
		}
		
		ResponseEntity<BudgetGroupTotal> rs = this.restTemplate.exchange(BUDGET_GROUPTOTAL_SAVE_ITEM, HttpMethod.POST, new HttpEntity<BudgetGroupTotal>(item, this.httpHeaders), BudgetGroupTotal.class);
		if (rs.getBody() != null) {
			return JSON.toJSON(new Result(true,rs.getBody()));
		} else {
			return JSON.toJSON(BudgetExceptionResultEnum.ERROR.getResult());
		}
	}
	@RequestMapping(value = "/budget/save-grouptotal-items", method = RequestMethod.POST)
	@ResponseBody
	public Object saveBudgetGroupTotalItems(
			@ModelAttribute("items") String items,
			@ModelAttribute("info") String info,HttpServletRequest request) throws IOException 
	{
		BudgetInfo budget = JSON.toJavaObject(JSON.parseObject(info), BudgetInfo.class);
		//检查是否可编辑
		Result result = this.restTemplate.exchange(BUDGET_INFO_EDIT_CHECK+budget.getDataId(), HttpMethod.POST, new HttpEntity<Object>(this.httpHeaders), Result.class).getBody();
		if(!result.isSuccess()) {
			return JSON.toJSON(result);
		}
		
		List<BudgetGroupTotal> grouplist = JSON.parseArray(items, BudgetGroupTotal.class);
		ResponseEntity<Integer> infors = this.restTemplate.exchange(BUDGET_INFO_UPDATE, HttpMethod.POST, new HttpEntity<Object>(budget, this.httpHeaders), Integer.class);
		ResponseEntity<Integer> grouprs = this.restTemplate.exchange(BUDGET_GROUPTOTAL_SAVE_ITEMS, HttpMethod.POST, new HttpEntity<Object>(grouplist, this.httpHeaders), Integer.class);
		if (infors.getBody() >= 0 && grouprs.getBody() >= 0) 
		{
			return JSON.toJSON(new Result(true));
		} else {
			return JSON.toJSON(BudgetExceptionResultEnum.ERROR.getResult());
		}
	}
	@RequestMapping(value = "/budget/save-grouptotal-childitems", method = RequestMethod.POST)
	@ResponseBody
	public Object saveBudgetChildGroupTotalItems(@RequestParam("items")String items,@RequestParam("item")String item,HttpServletRequest request) throws IOException 
	{
		Map<String,Object> mapParam = new HashMap<String,Object>();
		mapParam.put("items", JSON.parseArray(items).toString());
		mapParam.put("item", JSON.parse(item).toString());
		ResponseEntity<Integer> responseEntity = this.restTemplate.exchange(BUDGET_GROUPTOTAL_SAVE_CHILDITEMS, HttpMethod.POST, new HttpEntity<Object>(mapParam, this.httpHeaders), Integer.class);
		if (responseEntity.getBody() == 0) {
			return JSON.toJSON(new Result(false));
		} else {
			return JSON.toJSON(new Result(true));
		}
	}
	
	@RequestMapping(value = "/budget/search-group-company-items", method = RequestMethod.POST)
	@ResponseBody
	public Object searchBudgetGroupCompanyItems(HttpServletRequest request) throws IOException 
	{
		//获取所有的集团公司
		ResponseEntity<?> responseEntity = this.restTemplate.exchange(BUDGET_GROUPTOTAL_COMPANY_ITEMS, HttpMethod.POST, new HttpEntity<Object>(this.httpHeaders), List.class);
		return JSON.toJSON(responseEntity.getBody());
	}
	@RequestMapping(value = "/budget/search-group-company-tree", method = RequestMethod.POST)
	@ResponseBody
	public Object searchBudgetGroupCompanyTree(HttpServletRequest request) throws IOException 
	{
		//获取所有的集团公司
		ResponseEntity<?> responseEntity = this.restTemplate.exchange(BUDGET_GROUPTOTAL_COMPANY_TREE, HttpMethod.POST, new HttpEntity<Object>(this.httpHeaders), List.class);
		//System.out.println(JSON.toJSONString(responseEntity.getBody()));
		return JSON.toJSON(responseEntity.getBody());
	}
	
	@RequestMapping(value = "/budget/del-group-item/{dataId}", method = RequestMethod.POST)
	@ResponseBody
	public Object deleteBudgetGroupItem(@PathVariable("dataId") String dataId,HttpServletRequest request) throws IOException 
	{
		//检查是否可删除
		Map<?,?> rsmap = this.restTemplate.exchange(BUDGET_GROUPTOTAL_GET_ITEM+dataId, HttpMethod.POST, new HttpEntity<Object>(dataId, this.httpHeaders), Map.class).getBody();
		Result result = this.restTemplate.exchange(BUDGET_INFO_EDIT_CHECK+rsmap.get("budgetInfoId"), HttpMethod.POST, new HttpEntity<Object>(this.httpHeaders), Result.class).getBody();
		if(!result.isSuccess()) {
			return JSON.toJSON(result);
		}
		ResponseEntity<Integer> responseEntity = this.restTemplate.exchange(BUDGET_GROUPTOTAL_DEL_ITEMS+dataId, HttpMethod.POST, new HttpEntity<Object>(this.httpHeaders), Integer.class);
		if (responseEntity.getBody() == 0) {
			return JSON.toJSON(new Result(false));
		} else {
			return JSON.toJSON(new Result(true));
		}
	}
	@RequestMapping(value = "/budget/start-budget-grouptotal-activity", method = RequestMethod.POST)
	@ResponseBody
	public Object submitBudgetGroupTotal(@RequestParam(value = "budgetInfoId", required = true) String budgetInfoId,
			@RequestParam(value = "functionId", required = true) String functionId,HttpServletRequest request) throws IOException 
	{
		WorkflowVo vo = new WorkflowVo();
		vo.setAuditUserIds(this.getUserProfile().getUserId());
		vo.setFunctionId(functionId);
		vo.setAuthenticatedUserId(this.getUserProfile().getUserId());
		vo.setBusinessId(budgetInfoId);
		vo.setProcessInstanceName("集团总表审批");
		vo.setAuthenticatedUserName(this.getUserProfile().getUserDisp());
		vo.setMessageUserIds(this.getUserProfile().getUserId());
		
		// 待办业务详情、最终审批同意、最终审批不同意路径
		vo.setAuditDetailsPath("/budget/budget_detail_grouptotal?dataId="+budgetInfoId);
		vo.setAuditAgreeMethod("http://pcitc-zuul/stp-proxy/stp-provider/budget/callback-workflow-notice-budgetinfo?budgetId="+budgetInfoId+"&workflow_status="+BudgetAuditStatusEnum.AUDIT_STATUS_PASS.getCode());
		vo.setAuditRejectMethod("http://pcitc-zuul/stp-proxy/stp-provider/budget/callback-workflow-notice-budgetinfo?budgetId="+budgetInfoId+"&workflow_status="+BudgetAuditStatusEnum.AUDIT_STATUS_REFUSE.getCode());
		
		HttpEntity<WorkflowVo> entity = new HttpEntity<WorkflowVo>(vo, this.httpHeaders);
		Result startRs = this.restTemplate.exchange(BUDGET_WORKFLOW_URL + budgetInfoId, HttpMethod.POST, entity, Result.class).getBody();
		return JSON.toJSON(startRs);
	}
	@RequestMapping(value = "/budget/search-grouptotal-history-items", method = RequestMethod.POST)
	@ResponseBody
	public Object searchBudgetGroupTotalHistoryItems(@ModelAttribute("info") BudgetGroupTotal info,HttpServletRequest request) throws IOException 
	{
		//System.out.println(JSON.toJSONString(info));
		ResponseEntity<?> infors = this.restTemplate.exchange(BUDGET_GROUPTOTAL_HISTORY_ITEMS, HttpMethod.POST, new HttpEntity<Object>(info, this.httpHeaders), List.class);
		return JSON.toJSON(infors.getBody());
	}
	@RequestMapping(value = "/budget/search-grouptotal-final-history-list", method = RequestMethod.POST)
	@ResponseBody
	public Object searchBudgetGroupTotalFinalHistoryList(HttpServletRequest request) throws IOException 
	{
		//System.out.println(JSON.toJSONString(info));
		ResponseEntity<?> infors = this.restTemplate.exchange(BUDGET_GROUPTOTAL_FINAL_HISTORY_LIST, HttpMethod.POST, new HttpEntity<Object>(this.httpHeaders), List.class);
		return JSON.toJSON(infors.getBody());
	}
	
	
	@RequestMapping(value = "/budget/select-grouptotal-compare-plan", method = RequestMethod.POST)
	@ResponseBody
	public Object selectBudgetGroupTotalComparePlan(@RequestParam(value="nd",required = false)String nd,@RequestParam(value="code",required = false)String code,HttpServletRequest request) throws IOException 
	{
		if(nd == null || code == null) {
			return JSON.toJSON(new ArrayList<Object>());
		}
		Map<String,Object> param = new HashMap<String,Object>();
		param.put("nd", nd);
		param.put("code", code);
		//System.out.println(JSON.toJSONString(info));
		ResponseEntity<?> infors = this.restTemplate.exchange(BUDGET_GROUPTOTAL_COMPARE_PLAN, HttpMethod.POST, new HttpEntity<Object>(param,this.httpHeaders), List.class);
		//System.out.println(JSON.toJSONString(infors.getBody()));
		return JSON.toJSON(infors.getBody());
	}
	
	@RequestMapping(value = "/budget/select-grouptotal-compare-project", method = RequestMethod.POST)
	@ResponseBody
	public Object selectBudgetGroupTotalCompareProject(@ModelAttribute("param")LayuiTableParam param,HttpServletRequest request) throws IOException 
	{
		if(param.getParam().get("nd") == null || param.getParam().get("code") == null) {
			return JSON.toJSON(new ArrayList<Object>());
		}
		param.getParam().put("leaderFlag", "2");
		//System.out.println(JSON.toJSONString(info));
		ResponseEntity<?> infors = this.restTemplate.exchange(BUDGET_GROUPTOTAL_COMPARE_PROJECT, HttpMethod.POST, new HttpEntity<Object>(param,this.httpHeaders), List.class);
		//System.out.println(JSON.toJSONString(infors.getBody()));
		return JSON.toJSON(infors.getBody());
	}
	@RequestMapping(value = "/budget/select-grouptotal-plandata", method = RequestMethod.POST)
	@ResponseBody
	@OperationFilter(dataFlag = "true")
	public Object selectGrouptotalPlandata(@ModelAttribute("param")LayuiTableParam param,
			HttpServletRequest request, HttpServletResponse response) throws Exception 
	{
		String budget_info_id = param.getParam().get("budget_info_id").toString();
		param.getParam().put("leaderFlag", "2");//
		ResponseEntity<?> rs = this.restTemplate.exchange(BUDGET_GROUPTOTAL_PLANDATA + budget_info_id, HttpMethod.POST,  new HttpEntity<LayuiTableParam>(param,this.httpHeaders), Object.class);
		return JSON.toJSON(rs.getBody());
	}
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	@RequestMapping("/budget/budget_download/grouptotal/{dataId}")
	public void downBudgetGroupTotal(@PathVariable("dataId") String dataId,HttpServletResponse res) throws IOException 
	{
		LayuiTableParam param = new LayuiTableParam();
		param.getParam().put("budget_info_id", dataId);
		param.setLimit(100);
		param.setPage(1);
		ResponseEntity<LayuiTableData> responseEntity = this.restTemplate.exchange(BUDGET_GROUPTOTAL_ITEMS, HttpMethod.POST, new HttpEntity<LayuiTableParam>(param, this.httpHeaders), LayuiTableData.class);
		LayuiTableData tabldata = responseEntity.getBody();
		//System.out.println(JSON.toJSONString(tabldata));
		
		ResponseEntity<BudgetInfo> rs = this.restTemplate.exchange(BUDGET_INFO_GET+dataId, HttpMethod.POST, new HttpEntity<Object>(this.httpHeaders), BudgetInfo.class);
		BudgetInfo info = rs.getBody();
		
		Map<String,String> parammap = new HashMap<String,String>();
		parammap.put("nd", info.getNd());
		
		
		URL path = this.getClass().getResource("/");
		File f = new File(path.getPath() + "static/budget/budget_grouptotal_template.xlsx");
		//System.out.println(f.getAbsolutePath());
		//写入新文件2019年集团公司总部科技经费预算
		String newFilePath = path.getPath() + "static/budget/"+info.getNd()+"年集团公司总部科技经费预算（建议稿）_"+DateUtil.dateToStr(new Date(), "yyyyMMddHHmmss")+".xlsx";
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
			if(workbook != null) {
				System.out.println("workbook != null .............");
			}else {
				System.out.println("workbook == null .............");
			}
			if(sheet != null) {
				System.out.println("sheet != null .............");
			}else {
				System.out.println("sheet == null .............");
			}
			
			InputStream is = new FileInputStream(template);
			workbook = new XSSFWorkbook(is);
			sheet = workbook.getSheetAt(0);
			//处理标题 年度
			String title = readCell(sheet.getRow(0).getCell(0));
			sheet.getRow(0).getCell(0).setCellValue(title.replace("${nd}", param.get("nd")));
			
			//从第五行开始，第五行是测试数据
			Row templateRow = sheet.getRow(4);
			Double total_xmjf = 0d;
			Double total_zxjf = 0d;
			
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
			
			for(int i = 0;i<list.size();i++) {
				
				Integer no = (Integer)list.get(i).get("no");
				String displayName = list.get(i).get("displayName").toString();
				//String remark = list.get(i).get("remark").toString();
				Double total = (Double)list.get(i).get("total");
				Double xmjf = (Double)list.get(i).get("xmjf");
				Double zxjf = (Double)list.get(i).get("zxjf");
				total_xmjf += xmjf;
				total_zxjf += zxjf;
				
				
				Row crow = sheet.getRow(i+4);
				crow.createCell(0).setCellValue(no);
				crow.createCell(1).setCellValue(displayName);
				//crow.createCell(2).setCellValue(remark);
				crow.createCell(2).setCellValue(total);
				crow.createCell(3).setCellValue(xmjf);
				crow.createCell(4).setCellValue(zxjf);
				
				crow.getCell(0).setCellStyle(centerStyle);
				crow.getCell(1).setCellStyle(leftCenterStyle);
				//crow.getCell(2).setCellStyle(leftCenterStyle);
				crow.getCell(2).setCellStyle(rightCenterStyle);
				crow.getCell(3).setCellStyle(rightCenterStyle);
				crow.getCell(4).setCellStyle(rightCenterStyle);
			}
			//汇总数据
			Row totalrow =sheet.getRow(list.size()+4);
			totalrow.createCell(0).setCellValue("合计");
			totalrow.createCell(1).setCellValue("");
			totalrow.createCell(2).setCellValue(total_xmjf+total_zxjf);
			totalrow.createCell(3).setCellValue(total_xmjf);
			totalrow.createCell(4).setCellValue(total_zxjf);
			//设置格式
			totalrow.getCell(0).setCellStyle(centerStyle);
			totalrow.getCell(1).setCellStyle(centerStyle);
			totalrow.getCell(2).setCellStyle(rightCenterStyle);
			totalrow.getCell(3).setCellStyle(rightCenterStyle);
			totalrow.getCell(4).setCellStyle(rightCenterStyle);
			
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
