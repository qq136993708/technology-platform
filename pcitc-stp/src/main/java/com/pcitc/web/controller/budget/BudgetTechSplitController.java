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
import com.pcitc.base.stp.budget.BudgetInfo;
import com.pcitc.base.stp.budget.BudgetTechSplit;
import com.pcitc.base.util.DateUtil;
import com.pcitc.base.util.IdUtil;
import com.pcitc.base.util.MyBeanUtils;
import com.pcitc.base.workflow.WorkflowVo;
import com.pcitc.web.common.BaseController;
/**
 * 事业部预算（炼油事业部，化工事业部）
 * @author fb
 *
 */
@Controller
public class BudgetTechSplitController extends BaseController {

	private static final String BUDGET_techsplit_TABLE = "http://pcitc-zuul/stp-proxy/stp-provider/budget/budget-techsplit-info-table";
	private static final String BUDGET_techsplit_LIST = "http://pcitc-zuul/stp-proxy/stp-provider/budget/budget-techsplit-info-list";	
	private static final String BUDGET_techsplit_INFO = "http://pcitc-zuul/stp-proxy/stp-provider/budget/budget-techsplit-info";	
	private static final String BUDGET_techsplit_ITEMS = "http://pcitc-zuul/stp-proxy/stp-provider/budget/budget-techsplit-items";
	private static final String BUDGET_techsplit_CREATE = "http://pcitc-zuul/stp-proxy/stp-provider/budget/budget-create-blank-techsplit";
	private static final String BUDGET_techsplit_CREATE_BYTEMPLATE = "http://pcitc-zuul/stp-proxy/stp-provider/budget/budget-create-template-techsplit";
	private static final String BUDGET_techsplit_DELETE = "http://pcitc-zuul/stp-proxy/stp-provider/budget/budget-techsplit-del";
	private static final String BUDGET_techsplit_GET_ITEM = "http://pcitc-zuul/stp-proxy/stp-provider/budget/get-techsplit-item/";
	private static final String BUDGET_techsplit_GET_ITEM_COMPANY = "http://pcitc-zuul/stp-proxy/stp-provider/budget/get-techsplit-item-company/";
	private static final String BUDGET_techsplit_DEL_ITEMS = "http://pcitc-zuul/stp-proxy/stp-provider/budget/del-techsplit-item/";
	private static final String BUDGET_techsplit_SAVE_ITEM = "http://pcitc-zuul/stp-proxy/stp-provider/budget/save-techsplit-item";
	private static final String BUDGET_techsplit_SAVE_ITEMS = "http://pcitc-zuul/stp-proxy/stp-provider/budget/save-techsplit-items";
	private static final String BUDGET_techsplit_SAVE_CHILDITEMS = "http://pcitc-zuul/stp-proxy/stp-provider/budget/save-techsplit-childitems";
	private static final String BUDGET_techsplit_COMPANY_ITEMS = "http://pcitc-zuul/stp-proxy/stp-provider/budget/search-tech-company-items";
	private static final String BUDGET_techsplit_COMPANY_TREE = "http://pcitc-zuul/stp-proxy/stp-provider/budget/search-tech-company-tree";
	private static final String BUDGET_techsplit_HISTORY_ITEMS = "http://pcitc-zuul/stp-proxy/stp-provider/budget/search-techsplit-history-items";
	private static final String BUDGET_techsplit_FINAL_HISTORY_LIST = "http://pcitc-zuul/stp-proxy/stp-provider/budget/search-techsplit-final-history-list";
	private static final String BUDGET_techsplit_COMPARE_PLAN = "http://pcitc-zuul/stp-proxy/stp-provider/budget/select-techsplit-compare-plan";
	private static final String BUDGET_techsplit_COMPARE_PROJECT = "http://pcitc-zuul/stp-proxy/stp-provider/budget/select-techsplit-compare-project";
	
	private static final String BUDGET_INFO_UPDATE = "http://pcitc-zuul/stp-proxy/stp-provider/budget/budget-info-update";
	private static final String BUDGET_INFO_GET = "http://pcitc-zuul/stp-proxy/stp-provider/budget/budget-info-get/";
	private static final String PROJECT_NOTICE_WORKFLOW_URL = "http://pcitc-zuul/stp-proxy/stp-provider/budget/start-budget-techsplit-activity/";
	private static final String BUDGET_techsplit_ITEM_TREE = "http://pcitc-zuul/stp-proxy/stp-provider/budget/search-techitem-tree";
	
	@RequestMapping(method = RequestMethod.GET, value = "/budget/budget_main_techsplit")
	public Object toBudgetTechPage(HttpServletRequest request) throws IOException 
	{
		request.setAttribute("nd", DateUtil.format(new Date(), DateUtil.FMT_YYYY));
		return "stp/budget/budget_main_techsplit";
	}
	@RequestMapping(method = RequestMethod.GET, value = "/budget/budget_edit_techsplit")
	public Object toBudgetTechEditPage(HttpServletRequest request) throws IOException 
	{
		String dataId = request.getParameter("dataId");
		String nd = request.getParameter("nd");
		request.setAttribute("dataId", dataId==null?IdUtil.createIdByTime():dataId);
		request.setAttribute("budgetInfoId", request.getParameter("budgetInfoId"));
		request.setAttribute("nd", nd ==null?DateUtil.format(new Date(), DateUtil.FMT_YYYY):nd);
		return "stp/budget/budget_edit_techsplit";
	}
	@RequestMapping(method = RequestMethod.GET, value = "/budget/budget_create_techsplit")
	public Object toBudgetTechAddPage(HttpServletRequest request) throws IOException 
	{
		//request.setAttribute("nd", DateUtil.format(new Date(), DateUtil.FMT_YYYY));
		request.setAttribute("nd", request.getParameter("nd"));
		return "stp/budget/budget_create_techsplit";
	}
	@RequestMapping(method = RequestMethod.GET, value = "/budget/budget_history_compare_techsplit")
	public Object toBudgetTechSplitHistoryPage(HttpServletRequest request) throws IOException 
	{
		
		request.setAttribute("dataId", request.getParameter("dataId"));
		request.setAttribute("budgetInfoId", request.getParameter("budgetInfoId"));
		request.setAttribute("nd", DateUtil.format(new Date(), DateUtil.FMT_YYYY));
		return "stp/budget/budget_history_compare_techsplit";
	}
	@RequestMapping(method = RequestMethod.GET, value = "/budget/budget_history_view_techsplit")
	public Object toBudgetTechSplitHistoryViews(HttpServletRequest request) throws IOException 
	{
		//检索数据
		ResponseEntity<?> infors = this.restTemplate.exchange(BUDGET_techsplit_FINAL_HISTORY_LIST, HttpMethod.POST, new HttpEntity<Object>(this.httpHeaders), List.class);
		String budgetInfoId = request.getParameter("budgetInfoId");
		request.setAttribute("budgetInfoId", budgetInfoId);
		request.setAttribute("tb_datas", infors.getBody());
		//request.setAttribute("nd", DateUtil.format(new Date(), DateUtil.FMT_YYYY));
		return "stp/budget/budget_history_view_techsplit";
	}
	
	@RequestMapping(value = "/budget/budget_tech_info_list", method = RequestMethod.POST)
	@ResponseBody
	public Object getBudgetTechList(@ModelAttribute("info") BudgetInfo info,HttpServletRequest request) throws IOException 
	{
		ResponseEntity<Object> responseEntity = this.restTemplate.exchange(BUDGET_techsplit_LIST, HttpMethod.POST, new HttpEntity<BudgetInfo>(info, this.httpHeaders), Object.class);
		//System.out.println(JSON.toJSON(responseEntity.getBody()).toString());
		return JSON.toJSON(responseEntity.getBody()).toString();
	}
	@RequestMapping(value = "/budget/budget_tech_info_table", method = RequestMethod.POST)
	@ResponseBody
	public Object getBudgetTechTable(@ModelAttribute("param") LayuiTableParam param,HttpServletRequest request) throws IOException 
	{
		ResponseEntity<Object> responseEntity = this.restTemplate.exchange(BUDGET_techsplit_TABLE, HttpMethod.POST, new HttpEntity<LayuiTableParam>(param, this.httpHeaders), Object.class);
		//System.out.println(JSON.toJSON(responseEntity.getBody()).toString());
		return JSON.toJSON(responseEntity.getBody()).toString();
	}
	@RequestMapping(value = "/budget/budget-techsplit-items", method = RequestMethod.POST)
	@ResponseBody
	public Object getBudgetTechItems(@ModelAttribute("param") LayuiTableParam param,HttpServletRequest request) throws IOException 
	{
		ResponseEntity<Object> responseEntity = this.restTemplate.exchange(BUDGET_techsplit_ITEMS, HttpMethod.POST, new HttpEntity<LayuiTableParam>(param, this.httpHeaders), Object.class);
		System.out.println(JSON.toJSON(responseEntity.getBody()));
		return JSON.toJSON(responseEntity.getBody()).toString();
	}
	@RequestMapping(value = "/budget/budget-techsplit-create", method = RequestMethod.POST)
	@ResponseBody
	public Object createBudgetTechInfo(@ModelAttribute("info") BudgetInfo info,HttpServletRequest request) throws IOException 
	{
		
		info.setCreaterId(this.getUserProfile().getUserId());
		info.setCreaterName(this.getUserProfile().getUserDisp());
		ResponseEntity<Object> responseEntity = this.restTemplate.exchange(BUDGET_techsplit_CREATE, HttpMethod.POST, new HttpEntity<BudgetInfo>(info, this.httpHeaders), Object.class);
		//System.out.println(JSON.toJSON(responseEntity.getBody()).toString());
		return JSON.toJSON(responseEntity.getBody()).toString();
	}
	
	@RequestMapping(value = "/budget/budget-techsplit-create-bytemplate", method = RequestMethod.POST)
	@ResponseBody
	public Object createBudgetTechInfoByTemplate(@ModelAttribute("info") BudgetInfo info,HttpServletRequest request) throws IOException 
	{
		info.setCreaterId(this.getUserProfile().getUserId());
		info.setCreaterName(this.getUserProfile().getUserDisp());
		ResponseEntity<Object> responseEntity = this.restTemplate.exchange(BUDGET_techsplit_CREATE_BYTEMPLATE, HttpMethod.POST, new HttpEntity<BudgetInfo>(info, this.httpHeaders), Object.class);
		//System.out.println(JSON.toJSON(responseEntity.getBody()).toString());
		return JSON.toJSON(responseEntity.getBody()).toString();
	}
	
	@RequestMapping(value = "/budget/budget-techsplit-del", method = RequestMethod.POST)
	@ResponseBody
	public Object deleteBudgetTechInfo(@ModelAttribute("info") BudgetInfo info,HttpServletRequest request) throws IOException 
	{
		ResponseEntity<Object> responseEntity = this.restTemplate.exchange(BUDGET_techsplit_DELETE, HttpMethod.POST, new HttpEntity<BudgetInfo>(info, this.httpHeaders), Object.class);
		//System.out.println(JSON.toJSON(responseEntity.getBody()).toString());
		return JSON.toJSON(responseEntity.getBody()).toString();
	}
	@RequestMapping(value = "/budget/get-techsplit-item/{dataId}", method = RequestMethod.POST)
	@ResponseBody
	public Object selectBudgetTechSplitItem(@PathVariable("dataId") String dataId,HttpServletRequest request) throws IOException 
	{
		ResponseEntity<Object> responseEntity = this.restTemplate.exchange(BUDGET_techsplit_GET_ITEM+dataId, HttpMethod.POST, new HttpEntity<Object>(dataId, this.httpHeaders), Object.class);
		//System.out.println(JSON.toJSON(responseEntity.getBody()).toString());
		return JSON.toJSON(responseEntity.getBody()).toString();
	}
	@RequestMapping(value = "/budget/get-techsplit-item-company/{dataId}", method = RequestMethod.POST)
	@ResponseBody
	public Object selectBudgetTechSplitItemCompany(@PathVariable("dataId") String dataId,HttpServletRequest request) throws IOException 
	{
		ResponseEntity<Object> responseEntity = this.restTemplate.exchange(BUDGET_techsplit_GET_ITEM_COMPANY+dataId, HttpMethod.POST, new HttpEntity<Object>(dataId, this.httpHeaders), Object.class);
		//System.out.println(JSON.toJSON(responseEntity.getBody()).toString());
		return JSON.toJSON(responseEntity.getBody()).toString();
	}
	@RequestMapping(value = "/budget/save-techsplit-item", method = RequestMethod.POST)
	@ResponseBody
	public Object saveBudgetTechSplitItem(@ModelAttribute("item") BudgetTechSplit item,HttpServletRequest request) throws IOException 
	{
		System.out.println(JSON.toJSONString(item));
		ResponseEntity<BudgetTechSplit> rs = this.restTemplate.exchange(BUDGET_techsplit_SAVE_ITEM, HttpMethod.POST, new HttpEntity<BudgetTechSplit>(item, this.httpHeaders), BudgetTechSplit.class);
		if (rs.getBody() != null) {
			return new Result(true,rs.getBody());
		} else {
			return new Result(false);
		}
	}
	@RequestMapping(value = "/budget/save-techsplit-items", method = RequestMethod.POST)
	@ResponseBody
	public Object saveBudgetTechSplitItems(
			@ModelAttribute("items") String items,
			@ModelAttribute("info") String info,HttpServletRequest request) throws IOException 
	{
		List<BudgetTechSplit> stocklist = JSON.parseArray(items, BudgetTechSplit.class);
		BudgetInfo budget = JSON.toJavaObject(JSON.parseObject(info), BudgetInfo.class);
		ResponseEntity<Integer> infors = this.restTemplate.exchange(BUDGET_INFO_UPDATE, HttpMethod.POST, new HttpEntity<Object>(budget, this.httpHeaders), Integer.class);
		ResponseEntity<Integer> stockrs = this.restTemplate.exchange(BUDGET_techsplit_SAVE_ITEMS, HttpMethod.POST, new HttpEntity<Object>(stocklist, this.httpHeaders), Integer.class);
		if (infors.getBody() >= 0 && stockrs.getBody() >= 0) 
		{
			return new Result(true);
		} else {
			return new Result(false);
		}
	}
	@RequestMapping(value = "/budget/save-techsplit-childitems", method = RequestMethod.POST)
	@ResponseBody
	public Object saveBudgetChildtechsplitItems(@RequestParam("items")String items,@RequestParam("item")String item,HttpServletRequest request) throws IOException 
	{
		Map<String,Object> mapParam = new HashMap<String,Object>();
		mapParam.put("items", JSON.parseArray(items).toString());
		mapParam.put("item", JSON.parse(item).toString());
		ResponseEntity<Integer> responseEntity = this.restTemplate.exchange(BUDGET_techsplit_SAVE_CHILDITEMS, HttpMethod.POST, new HttpEntity<Object>(mapParam, this.httpHeaders), Integer.class);
		if (responseEntity.getBody() == 0) {
			return new Result(false);
		} else {
			return new Result(true);
		}
	}
	
	@RequestMapping(value = "/budget/search-tech-company-items", method = RequestMethod.POST)
	@ResponseBody
	public Object searchBudgetTechCompanyItems(HttpServletRequest request) throws IOException 
	{
		//获取所有的集团公司
		ResponseEntity<?> responseEntity = this.restTemplate.exchange(BUDGET_techsplit_COMPANY_ITEMS, HttpMethod.POST, new HttpEntity<Object>(this.httpHeaders), List.class);
		return responseEntity.getBody();
	}
	@RequestMapping(value = "/budget/search-tech-company-tree", method = RequestMethod.POST)
	@ResponseBody
	public Object searchBudgetTechCompanyTree(HttpServletRequest request) throws IOException 
	{
		//获取所有的集团公司
		ResponseEntity<?> responseEntity = this.restTemplate.exchange(BUDGET_techsplit_COMPANY_TREE, HttpMethod.POST, new HttpEntity<Object>(this.httpHeaders), List.class);
		return responseEntity.getBody();
	}
	@RequestMapping(value = "/budget/del-tech-item/{dataId}", method = RequestMethod.POST)
	@ResponseBody
	public Object deleteBudgetTechItem(@PathVariable("dataId") String dataId,HttpServletRequest request) throws IOException 
	{
		ResponseEntity<Integer> responseEntity = this.restTemplate.exchange(BUDGET_techsplit_DEL_ITEMS+dataId, HttpMethod.POST, new HttpEntity<Object>(this.httpHeaders), Integer.class);
		if (responseEntity.getBody() == 0) {
			return new Result(false);
		} else {
			return new Result(true);
		}
	}
	@RequestMapping(value = "/budget/start-budget-techsplit-activity", method = RequestMethod.POST)
	@ResponseBody
	public Object submitBudgetTechSplit(@RequestParam(value = "budgetInfoId", required = true) String budgetInfoId,
			@RequestParam(value = "functionId", required = true) String functionId,HttpServletRequest request) throws IOException 
	{
		System.out.println("start-budget-techsplit-activity-----------------");
		WorkflowVo vo = new WorkflowVo();
		vo.setAuditUserIds(this.getUserProfile().getUserId());
		vo.setFunctionId(functionId);
		vo.setAuthenticatedUserId(this.getUserProfile().getUserId());
		HttpEntity<WorkflowVo> entity = new HttpEntity<WorkflowVo>(vo, this.httpHeaders);
		Result startRs = this.restTemplate.exchange(PROJECT_NOTICE_WORKFLOW_URL + budgetInfoId, HttpMethod.POST, entity, Result.class).getBody();
		
		ResponseEntity<BudgetInfo> getRs = this.restTemplate.exchange(BUDGET_INFO_GET+budgetInfoId, HttpMethod.POST, new HttpEntity<Object>(this.httpHeaders), BudgetInfo.class);
		BudgetInfo info =getRs.getBody();// JSON.toJavaObject(JSON.parseObject(getRs.getBody().toString()), BudgetInfo.class);
		
		System.out.println(JSON.toJSONString(info));
		info.setUpdateTime(DateUtil.format(new Date(), DateUtil.FMT_SS));
		info.setAuditStatus(BudgetAuditStatusEnum.AUDIT_STATUS_START.getCode());//审批状态开始
		ResponseEntity<Integer> upRs = this.restTemplate.exchange(BUDGET_INFO_UPDATE, HttpMethod.POST, new HttpEntity<Object>(info, this.httpHeaders), Integer.class);
		if (upRs.getBody() >= 0) {
			Map<String,Object> rsmap = MyBeanUtils.transBean2Map(info);
			rsmap.put("auditStatusDesc", BudgetAuditStatusEnum.getStatusByCode(info.getAuditStatus()).getDesc());
			startRs.setData(rsmap);
		} 
		
		return startRs;
	}
	@RequestMapping(value = "/budget/search-techsplit-history-items", method = RequestMethod.POST)
	@ResponseBody
	public Object searchBudgetTechSplitHistoryItems(@ModelAttribute("info") BudgetTechSplit info,HttpServletRequest request) throws IOException 
	{
		//System.out.println(JSON.toJSONString(info));
		ResponseEntity<?> infors = this.restTemplate.exchange(BUDGET_techsplit_HISTORY_ITEMS, HttpMethod.POST, new HttpEntity<Object>(info, this.httpHeaders), List.class);
		return infors.getBody();
	}
	@RequestMapping(value = "/budget/search-techsplit-final-history-list", method = RequestMethod.POST)
	@ResponseBody
	public Object searchBudgetTechSplitFinalHistoryList(HttpServletRequest request) throws IOException 
	{
		//System.out.println(JSON.toJSONString(info));
		ResponseEntity<?> infors = this.restTemplate.exchange(BUDGET_techsplit_FINAL_HISTORY_LIST, HttpMethod.POST, new HttpEntity<Object>(this.httpHeaders), List.class);
		return infors.getBody();
	}
	
	
	@RequestMapping(value = "/budget/select-techsplit-compare-plan", method = RequestMethod.POST)
	@ResponseBody
	public Object selectBudgetTechSplitComparePlan(@RequestParam(value="nd",required = false)String nd,@RequestParam(value="code",required = false)String code,HttpServletRequest request) throws IOException 
	{
		System.out.println("plan............"+nd+"------"+code);
		if(nd == null || code == null) {
			return new ArrayList<Object>();
		}
		Map<String,Object> param = new HashMap<String,Object>();
		param.put("nd", nd);
		param.put("code", code);
		//System.out.println(JSON.toJSONString(info));
		ResponseEntity<?> infors = this.restTemplate.exchange(BUDGET_techsplit_COMPARE_PLAN, HttpMethod.POST, new HttpEntity<Object>(param,this.httpHeaders), List.class);
		//System.out.println(JSON.toJSONString(infors.getBody()));
		return infors.getBody();
	}
	
	@RequestMapping(value = "/budget/select-techsplit-compare-project", method = RequestMethod.POST)
	@ResponseBody
	public Object selectBudgetTechSplitCompareProject(@RequestParam(value="nd",required = false)String nd,@RequestParam(value="code",required = false)String code,HttpServletRequest request) throws IOException 
	{
		System.out.println("plan............"+nd+"------"+code);
		if(nd == null || code == null) {
			return new ArrayList<Object>();
		}
		Map<String,Object> param = new HashMap<String,Object>();
		param.put("nd", nd);
		param.put("code", code);
		//System.out.println(JSON.toJSONString(info));
		ResponseEntity<?> infors = this.restTemplate.exchange(BUDGET_techsplit_COMPARE_PROJECT, HttpMethod.POST, new HttpEntity<Object>(param,this.httpHeaders), List.class);
		//System.out.println(JSON.toJSONString(infors.getBody()));
		return infors.getBody();
	}
	@RequestMapping(value = "/budget/search-techitem-tree", method = RequestMethod.POST)
	@ResponseBody
	public Object searchTechitemTree(@RequestParam(value="dataId",required = false)String dataId,HttpServletRequest request, HttpServletResponse response) throws Exception 
	{
		ResponseEntity<?> infors = this.restTemplate.exchange(BUDGET_techsplit_ITEM_TREE, HttpMethod.POST, new HttpEntity<Object>(dataId,this.httpHeaders), Object.class);
		//System.out.println(JSON.toJSONString(infors.getBody()));
		return infors.getBody();
	}
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	@RequestMapping("/budget/budget_download/techsplit/{dataId}")
	public void downBudgetTechSplit(@PathVariable("dataId") String dataId,HttpServletResponse res) throws IOException 
	{
		LayuiTableParam param = new LayuiTableParam();
		param.getParam().put("budget_info_id", dataId);
		param.setLimit(100);
		param.setPage(1);
		ResponseEntity<LayuiTableData> responseEntity = this.restTemplate.exchange(BUDGET_techsplit_ITEMS, HttpMethod.POST, new HttpEntity<LayuiTableParam>(param, this.httpHeaders), LayuiTableData.class);
		LayuiTableData tabldata = responseEntity.getBody();
		//System.out.println(JSON.toJSONString(tabldata));
		
		ResponseEntity<BudgetInfo> rs = this.restTemplate.exchange(BUDGET_techsplit_INFO, HttpMethod.POST, new HttpEntity<String>(dataId, this.httpHeaders), BudgetInfo.class);
		BudgetInfo info = rs.getBody();
		
		Map<String,String> parammap = new HashMap<String,String>();
		parammap.put("nd", info.getNd());
		
		
		URL path = this.getClass().getResource("/");
		File f = new File(path.getPath() + "static/budget/budget_techsplit_template.xlsx");
		//System.out.println(f.getAbsolutePath());
		//写入新文件2019年集团公司总部科技经费预算
		String newFilePath = path.getPath() + "static/budget/"+info.getNd()+"年股份公司科技专项经费预算表（建议稿）_"+DateUtil.dateToStr(new Date(), "yyyyMMddHHmmss")+".xlsx";
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
			
			//从第五行开始
			Row templateRow = sheet.getRow(5);
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
			
			Double alljtgs = 0d;
			Double allgfZsyKty = 0d;
			Double allgfZsyGcy = 0d;
			Double allgfZsyWty = 0d;
			Double allgfZsySky = 0d;
			Double allgfZsyBhy = 0d;			
			Double allgfZsyFyy = 0d;
			Double allgfZsyShy = 0d;
			Double allgfZsyQdy = 0d;
			Double allgfFzgs = 0d;
			Double allxtw = 0d;
			
			for(int i = 0;i<list.size();i++) {
				
				String displayName = list.get(i).get("displayName").toString();
				Double jtgs = (Double)list.get(i).get("jtgs");
				Double gfZsyKty = (Double)list.get(i).get("gfZsyKty");
				Double gfZsyGcy = (Double)list.get(i).get("gfZsyGcy");
				Double gfZsyWty = (Double)list.get(i).get("gfZsyWty");
				Double gfZsySky = (Double)list.get(i).get("gfZsySky");
				Double gfZsyBhy = (Double)list.get(i).get("gfZsyBhy");				
				Double gfZsyFyy = (Double)list.get(i).get("gfZsyFyy");
				Double gfZsyShy = (Double)list.get(i).get("gfZsyShy");
				Double gfZsyQdy = (Double)list.get(i).get("gfZsyQdy");
				Double gfFzgs = (Double)list.get(i).get("gfFzgs");
				Double xtw = (Double)list.get(i).get("xtw");
				
				alljtgs += jtgs;
				allgfZsyKty += gfZsyKty;
				allgfZsyGcy += gfZsyGcy;
				allgfZsyWty += gfZsyWty;
				allgfZsySky += gfZsySky;
				allgfZsyBhy += gfZsyBhy;				
				allgfZsyFyy += gfZsyFyy;
				allgfZsyShy += gfZsyShy;
				allgfZsyQdy += gfZsyQdy;
				allgfFzgs += gfFzgs;
				allxtw += xtw;
				
				Row crow = sheet.getRow(i+5);
				
				crow.createCell(0).setCellValue(displayName);
				crow.createCell(1).setCellValue(jtgs);
				crow.createCell(2).setCellValue(gfZsyKty);
				crow.createCell(3).setCellValue(gfZsyGcy);
				crow.createCell(4).setCellValue(gfZsyWty);
				crow.createCell(5).setCellValue(gfZsySky);
				crow.createCell(6).setCellValue(gfZsyBhy);
				crow.createCell(7).setCellValue(gfZsyFyy);
				crow.createCell(8).setCellValue(gfZsyShy);
				crow.createCell(9).setCellValue(gfZsyQdy);
				crow.createCell(10).setCellValue(gfFzgs);
				crow.createCell(11).setCellValue(xtw);
				
				
				
				crow.getCell(0).setCellStyle(leftCenterStyle);
				crow.getCell(1).setCellStyle(rightCenterStyle);
				crow.getCell(2).setCellStyle(rightCenterStyle);
				crow.getCell(3).setCellStyle(rightCenterStyle);
				crow.getCell(4).setCellStyle(rightCenterStyle);
				crow.getCell(5).setCellStyle(rightCenterStyle);
				crow.getCell(6).setCellStyle(rightCenterStyle);
				crow.getCell(7).setCellStyle(rightCenterStyle);
				crow.getCell(8).setCellStyle(rightCenterStyle);
				crow.getCell(9).setCellStyle(rightCenterStyle);
				crow.getCell(10).setCellStyle(rightCenterStyle);
				crow.getCell(11).setCellStyle(rightCenterStyle);
			}
			//Row totalRow = sheet.createRow(list.size()+5);
			Row totalRow =sheet.getRow(list.size()+5);
			totalRow.createCell(0).setCellValue("合计");
			totalRow.createCell(1).setCellValue(alljtgs);
			totalRow.createCell(2).setCellValue(allgfZsyKty);
			totalRow.createCell(3).setCellValue(allgfZsyGcy);
			totalRow.createCell(4).setCellValue(allgfZsyWty);
			totalRow.createCell(5).setCellValue(allgfZsySky);
			totalRow.createCell(6).setCellValue(allgfZsyBhy);
			totalRow.createCell(7).setCellValue(allgfZsyFyy);
			totalRow.createCell(8).setCellValue(allgfZsyShy);
			totalRow.createCell(9).setCellValue(allgfZsyQdy);
			totalRow.createCell(10).setCellValue(allgfFzgs);
			totalRow.createCell(11).setCellValue(allxtw);
			
			totalRow.getCell(0).setCellStyle(centerStyle);
			totalRow.getCell(1).setCellStyle(rightCenterStyle);
			totalRow.getCell(2).setCellStyle(rightCenterStyle);
			totalRow.getCell(3).setCellStyle(rightCenterStyle);
			totalRow.getCell(4).setCellStyle(rightCenterStyle);
			totalRow.getCell(5).setCellStyle(rightCenterStyle);
			totalRow.getCell(6).setCellStyle(rightCenterStyle);
			totalRow.getCell(7).setCellStyle(rightCenterStyle);
			totalRow.getCell(8).setCellStyle(rightCenterStyle);
			totalRow.getCell(9).setCellStyle(rightCenterStyle);
			totalRow.getCell(10).setCellStyle(rightCenterStyle);
			totalRow.getCell(11).setCellStyle(rightCenterStyle);
			
			//合计单元格合并
			//sheet.addMergedRegion(new CellRangeAddress(list.size()+5,list.size()+5,0,1));
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
