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
import com.pcitc.base.common.enums.BudgetInfoEnum;
import com.pcitc.base.stp.budget.BudgetInfo;
import com.pcitc.base.stp.budget.BudgetStockTotal;
import com.pcitc.base.util.DateUtil;
import com.pcitc.base.util.DateUtils;
import com.pcitc.base.util.IdUtil;
import com.pcitc.base.util.MyBeanUtils;
import com.pcitc.base.workflow.WorkflowVo;
import com.pcitc.web.common.BaseController;
/**
 * 股份预算总表
 * @author fb
 *
 */
@Controller
public class BudgetStockTotalController extends BaseController {

	private static final String BUDGET_STOCKTOTAL_TABLE = "http://pcitc-zuul/stp-proxy/stp-provider/budget/budget-stocktotal-info-table";
	private static final String BUDGET_STOCKTOTAL_LIST = "http://pcitc-zuul/stp-proxy/stp-provider/budget/budget-stocktotal-info-list";	
	private static final String BUDGET_STOCKTOTAL_INFO = "http://pcitc-zuul/stp-proxy/stp-provider/budget/budget-stocktotal-info";	
	private static final String BUDGET_STOCKTOTAL_ITEMS = "http://pcitc-zuul/stp-proxy/stp-provider/budget/budget-stocktotal-items";
	private static final String BUDGET_STOCKTOTAL_CREATE = "http://pcitc-zuul/stp-proxy/stp-provider/budget/budget-create-blank-stocktotal";
	private static final String BUDGET_STOCKTOTAL_CREATE_BYTEMPLATE = "http://pcitc-zuul/stp-proxy/stp-provider/budget/budget-create-template-stocktotal";
	private static final String BUDGET_STOCKTOTAL_DELETE = "http://pcitc-zuul/stp-proxy/stp-provider/budget/budget-stocktotal-del";
	private static final String BUDGET_STOCKTOTAL_GET_ITEM = "http://pcitc-zuul/stp-proxy/stp-provider/budget/get-stocktotal-item/";
	private static final String BUDGET_STOCKTOTAL_GET_ITEM_COMPANY = "http://pcitc-zuul/stp-proxy/stp-provider/budget/get-stocktotal-item-company/";
	private static final String BUDGET_STOCKTOTAL_DEL_ITEMS = "http://pcitc-zuul/stp-proxy/stp-provider/budget/del-stocktotal-item/";
	private static final String BUDGET_STOCKTOTAL_SAVE_ITEM = "http://pcitc-zuul/stp-proxy/stp-provider/budget/save-stocktotal-item";
	private static final String BUDGET_STOCKTOTAL_SAVE_ITEMS = "http://pcitc-zuul/stp-proxy/stp-provider/budget/save-stocktotal-items";
	private static final String BUDGET_STOCKTOTAL_SAVE_CHILDITEMS = "http://pcitc-zuul/stp-proxy/stp-provider/budget/save-stocktotal-childitems";
	private static final String BUDGET_STOCKTOTAL_COMPANY_ITEMS = "http://pcitc-zuul/stp-proxy/stp-provider/budget/search-stock-company-items";
	private static final String BUDGET_STOCKTOTAL_COMPANY_TREE = "http://pcitc-zuul/stp-proxy/stp-provider/budget/search-stock-company-tree";
	private static final String BUDGET_STOCKTOTAL_HISTORY_ITEMS = "http://pcitc-zuul/stp-proxy/stp-provider/budget/search-stocktotal-history-items";
	private static final String BUDGET_STOCKTOTAL_FINAL_HISTORY_LIST = "http://pcitc-zuul/stp-proxy/stp-provider/budget/search-stocktotal-final-history-list";
	private static final String BUDGET_STOCKTOTAL_COMPARE_PLAN = "http://pcitc-zuul/stp-proxy/stp-provider/budget/select-stocktotal-compare-plan";
	private static final String BUDGET_STOCKTOTAL_COMPARE_PROJECT = "http://pcitc-zuul/stp-proxy/stp-provider/budget/select-stocktotal-compare-project";
	private static final String BUDGET_STOCKTOTAL_TYPE_DICTIONARY = "http://pcitc-zuul/stp-proxy/stp-provider/budget/get-stockitem-type-dictionary";
	
	
	
	private static final String BUDGET_INFO_UPDATE = "http://pcitc-zuul/stp-proxy/stp-provider/budget/budget-info-update";
	private static final String BUDGET_INFO_GET = "http://pcitc-zuul/stp-proxy/stp-provider/budget/budget-info-get/";
	private static final String PROJECT_NOTICE_WORKFLOW_URL = "http://pcitc-zuul/stp-proxy/stp-provider/budget/start-budget-stocktotal-activity/";
	private static final String BUDGET_STOCKTOTAL_ITEM_TREE = "http://pcitc-zuul/stp-proxy/stp-provider/budget/search-stockitem-tree";
	private static final String BUDGET_FINAL_INFO = "http://pcitc-zuul/stp-proxy/stp-provider/budget/get-final-budget";
	
	
	@RequestMapping(method = RequestMethod.GET, value = "/budget/budget_main_stocktotal")
	public Object toBudgetStockPage(HttpServletRequest request) throws IOException 
	{
		request.setAttribute("nd", DateUtil.format(DateUtil.getNextYearDay(new Date()), DateUtil.FMT_YYYY));
		return "stp/budget/budget_main_stocktotal";
	}
	@RequestMapping(method = RequestMethod.GET, value = "/budget/budget_edit_stocktotal")
	public Object toBudgetStockEditPage(HttpServletRequest request) throws IOException 
	{
		String dataId = request.getParameter("dataId");
		String nd = request.getParameter("nd");
		request.setAttribute("dataId", dataId==null?IdUtil.createIdByTime():dataId);
		request.setAttribute("budgetInfoId", request.getParameter("budgetInfoId"));
		request.setAttribute("nd", nd ==null?DateUtil.format(new Date(), DateUtil.FMT_YYYY):nd);
		return "stp/budget/budget_edit_stocktotal";
	}
	@RequestMapping(method = RequestMethod.GET, value = "/budget/budget_create_stocktotal")
	public Object toBudgetStockAddPage(HttpServletRequest request) throws IOException 
	{
		//request.setAttribute("nd", DateUtil.format(new Date(), DateUtil.FMT_YYYY));
		request.setAttribute("nd", request.getParameter("nd"));
		return "stp/budget/budget_create_stocktotal";
	}
	@RequestMapping(method = RequestMethod.GET, value = "/budget/budget_history_compare_stocktotal")
	public Object toBudgetStockTotalHistoryPage(HttpServletRequest request) throws IOException 
	{
		
		request.setAttribute("dataId", request.getParameter("dataId"));
		request.setAttribute("budgetInfoId", request.getParameter("budgetInfoId"));
		request.setAttribute("nd", DateUtil.format(new Date(), DateUtil.FMT_YYYY));
		return "stp/budget/budget_history_compare_stocktotal";
	}
	@RequestMapping(method = RequestMethod.GET, value = "/budget/budget_history_view_stocktotal")
	public Object toBudgetStockTotalHistoryViews(HttpServletRequest request) throws IOException 
	{
		//检索数据
		ResponseEntity<?> infors = this.restTemplate.exchange(BUDGET_STOCKTOTAL_FINAL_HISTORY_LIST, HttpMethod.POST, new HttpEntity<Object>(this.httpHeaders), List.class);
		String budgetInfoId = request.getParameter("budgetInfoId");
		request.setAttribute("budgetInfoId", budgetInfoId);
		request.setAttribute("tb_datas", infors.getBody());
		//request.setAttribute("nd", DateUtil.format(new Date(), DateUtil.FMT_YYYY));
		return "stp/budget/budget_history_view_stocktotal";
	}
	@RequestMapping(method = RequestMethod.GET, value = "/budget/budget_detail_stocktotal")
	public Object toBudgetGroupDetail(HttpServletRequest request) throws IOException 
	{
		request.setAttribute("dataId", request.getParameter("dataId"));
		return "stp/budget/budget_detail_stocktotal";
	}
	@RequestMapping(method = RequestMethod.GET, value = "/budget/budget_detail_stocktotal_nd")
	public Object toBudgetGroupDetailByNd(HttpServletRequest request) throws IOException 
	{
		String nd = request.getParameter("nd");
		if(nd == null) {
			nd = DateUtils.dateToStr(new Date(),"yyyy");
		}
		BudgetInfo param = new BudgetInfo();
		param.setNd(nd);
		param.setBudgetType(BudgetInfoEnum.STOCK_TOTAL.getCode());
		BudgetInfo rs = this.restTemplate.exchange(BUDGET_FINAL_INFO, HttpMethod.POST, new HttpEntity<Object>(param,this.httpHeaders), BudgetInfo.class).getBody();
		
		request.setAttribute("nd", nd);
		request.setAttribute("dataId", rs == null?"0":rs.getDataId());
		return "stp/budget/budget_detail_stocktotal";
	}
	@RequestMapping(value = "/budget/budget-stock-info-list", method = RequestMethod.POST)
	@ResponseBody
	public Object getBudgetStockList(@ModelAttribute("info") BudgetInfo info,HttpServletRequest request) throws IOException 
	{
		ResponseEntity<Object> responseEntity = this.restTemplate.exchange(BUDGET_STOCKTOTAL_LIST, HttpMethod.POST, new HttpEntity<BudgetInfo>(info, this.httpHeaders), Object.class);
		//System.out.println(JSON.toJSON(responseEntity.getBody()).toString());
		return JSON.toJSON(responseEntity.getBody()).toString();
	}
	@RequestMapping(value = "/budget/budget-stock-info-table", method = RequestMethod.POST)
	@ResponseBody
	public Object getBudgetStockTable(@ModelAttribute("param") LayuiTableParam param,HttpServletRequest request) throws IOException 
	{
		ResponseEntity<Object> responseEntity = this.restTemplate.exchange(BUDGET_STOCKTOTAL_TABLE, HttpMethod.POST, new HttpEntity<LayuiTableParam>(param, this.httpHeaders), Object.class);
		//System.out.println(JSON.toJSON(responseEntity.getBody()).toString());
		return JSON.toJSON(responseEntity.getBody()).toString();
	}
	@RequestMapping(value = "/budget/budget-stocktotal-items", method = RequestMethod.POST)
	@ResponseBody
	public Object getBudgetStockItems(@ModelAttribute("param") LayuiTableParam param,HttpServletRequest request) throws IOException 
	{
		ResponseEntity<Object> responseEntity = this.restTemplate.exchange(BUDGET_STOCKTOTAL_ITEMS, HttpMethod.POST, new HttpEntity<LayuiTableParam>(param, this.httpHeaders), Object.class);
		System.out.println(JSON.toJSON(responseEntity.getBody()));
		return JSON.toJSON(responseEntity.getBody()).toString();
	}
	@RequestMapping(value = "/budget/budget-stocktotal-create", method = RequestMethod.POST)
	@ResponseBody
	public Object createBudgetStockInfo(@ModelAttribute("info") BudgetInfo info,HttpServletRequest request) throws IOException 
	{
		
		info.setCreaterId(this.getUserProfile().getUserId());
		info.setCreaterName(this.getUserProfile().getUserDisp());
		ResponseEntity<Object> responseEntity = this.restTemplate.exchange(BUDGET_STOCKTOTAL_CREATE, HttpMethod.POST, new HttpEntity<BudgetInfo>(info, this.httpHeaders), Object.class);
		//System.out.println(JSON.toJSON(responseEntity.getBody()).toString());
		return JSON.toJSON(responseEntity.getBody()).toString();
	}
	
	@RequestMapping(value = "/budget/budget-stocktotal-create-bytemplate", method = RequestMethod.POST)
	@ResponseBody
	public Object createBudgetStockInfoByTemplate(@ModelAttribute("info") BudgetInfo info,HttpServletRequest request) throws IOException 
	{
		info.setCreaterId(this.getUserProfile().getUserId());
		info.setCreaterName(this.getUserProfile().getUserDisp());
		ResponseEntity<Object> responseEntity = this.restTemplate.exchange(BUDGET_STOCKTOTAL_CREATE_BYTEMPLATE, HttpMethod.POST, new HttpEntity<BudgetInfo>(info, this.httpHeaders), Object.class);
		//System.out.println(JSON.toJSON(responseEntity.getBody()).toString());
		return JSON.toJSON(responseEntity.getBody()).toString();
	}
	
	@RequestMapping(value = "/budget/budget-stocktotal-del", method = RequestMethod.POST)
	@ResponseBody
	public Object deleteBudgetStockInfo(@ModelAttribute("info") BudgetInfo info,HttpServletRequest request) throws IOException 
	{
		ResponseEntity<Object> responseEntity = this.restTemplate.exchange(BUDGET_STOCKTOTAL_DELETE, HttpMethod.POST, new HttpEntity<BudgetInfo>(info, this.httpHeaders), Object.class);
		//System.out.println(JSON.toJSON(responseEntity.getBody()).toString());
		return JSON.toJSON(responseEntity.getBody()).toString();
	}
	@RequestMapping(value = "/budget/get-stocktotal-item/{dataId}", method = RequestMethod.POST)
	@ResponseBody
	public Object selectBudgetStockTotalItem(@PathVariable("dataId") String dataId,HttpServletRequest request) throws IOException 
	{
		ResponseEntity<Object> responseEntity = this.restTemplate.exchange(BUDGET_STOCKTOTAL_GET_ITEM+dataId, HttpMethod.POST, new HttpEntity<Object>(dataId, this.httpHeaders), Object.class);
		//System.out.println(JSON.toJSON(responseEntity.getBody()).toString());
		return JSON.toJSON(responseEntity.getBody()).toString();
	}
	@RequestMapping(value = "/budget/get-stocktotal-item-company/{dataId}", method = RequestMethod.POST)
	@ResponseBody
	public Object selectBudgetStockTotalItemCompany(@PathVariable("dataId") String dataId,HttpServletRequest request) throws IOException 
	{
		ResponseEntity<Object> responseEntity = this.restTemplate.exchange(BUDGET_STOCKTOTAL_GET_ITEM_COMPANY+dataId, HttpMethod.POST, new HttpEntity<Object>(dataId, this.httpHeaders), Object.class);
		//System.out.println(JSON.toJSON(responseEntity.getBody()).toString());
		return JSON.toJSON(responseEntity.getBody()).toString();
	}
	@RequestMapping(value = "/budget/save-stocktotal-item", method = RequestMethod.POST)
	@ResponseBody
	public Object saveBudgetStockTotalItem(@ModelAttribute("item") BudgetStockTotal item,HttpServletRequest request) throws IOException 
	{
		ResponseEntity<BudgetStockTotal> rs = this.restTemplate.exchange(BUDGET_STOCKTOTAL_SAVE_ITEM, HttpMethod.POST, new HttpEntity<BudgetStockTotal>(item, this.httpHeaders), BudgetStockTotal.class);
		if (rs.getBody() != null) {
			return new Result(true,rs.getBody());
		} else {
			return new Result(false);
		}
	}
	@RequestMapping(value = "/budget/save-stocktotal-items", method = RequestMethod.POST)
	@ResponseBody
	public Object saveBudgetStockTotalItems(
			@ModelAttribute("items") String items,
			@ModelAttribute("info") String info,HttpServletRequest request) throws IOException 
	{
		List<BudgetStockTotal> stocklist = JSON.parseArray(items, BudgetStockTotal.class);
		BudgetInfo budget = JSON.toJavaObject(JSON.parseObject(info), BudgetInfo.class);
		ResponseEntity<Integer> infors = this.restTemplate.exchange(BUDGET_INFO_UPDATE, HttpMethod.POST, new HttpEntity<Object>(budget, this.httpHeaders), Integer.class);
		ResponseEntity<Integer> stockrs = this.restTemplate.exchange(BUDGET_STOCKTOTAL_SAVE_ITEMS, HttpMethod.POST, new HttpEntity<Object>(stocklist, this.httpHeaders), Integer.class);
		if (infors.getBody() >= 0 && stockrs.getBody() >= 0) 
		{
			return new Result(true);
		} else {
			return new Result(false);
		}
	}
	@RequestMapping(value = "/budget/save-stocktotal-childitems", method = RequestMethod.POST)
	@ResponseBody
	public Object saveBudgetChildStockTotalItems(@RequestParam("items")String items,@RequestParam("item")String item,HttpServletRequest request) throws IOException 
	{
		Map<String,Object> mapParam = new HashMap<String,Object>();
		mapParam.put("items", JSON.parseArray(items).toString());
		mapParam.put("item", JSON.parse(item).toString());
		ResponseEntity<Integer> responseEntity = this.restTemplate.exchange(BUDGET_STOCKTOTAL_SAVE_CHILDITEMS, HttpMethod.POST, new HttpEntity<Object>(mapParam, this.httpHeaders), Integer.class);
		if (responseEntity.getBody() == 0) {
			return new Result(false);
		} else {
			return new Result(true);
		}
	}
	
	@RequestMapping(value = "/budget/search-stock-company-items", method = RequestMethod.POST)
	@ResponseBody
	public Object searchBudgetStockCompanyItems(HttpServletRequest request) throws IOException 
	{
		//获取所有的集团公司
		ResponseEntity<?> responseEntity = this.restTemplate.exchange(BUDGET_STOCKTOTAL_COMPANY_ITEMS, HttpMethod.POST, new HttpEntity<Object>(this.httpHeaders), List.class);
		return responseEntity.getBody();
	}
	@RequestMapping(value = "/budget/search-stock-company-tree", method = RequestMethod.POST)
	@ResponseBody
	public Object searchBudgetStockCompanyTree(HttpServletRequest request) throws IOException 
	{
		//获取所有的集团公司
		ResponseEntity<?> responseEntity = this.restTemplate.exchange(BUDGET_STOCKTOTAL_COMPANY_TREE, HttpMethod.POST, new HttpEntity<Object>(this.httpHeaders), List.class);
		return responseEntity.getBody();
	}
	@RequestMapping(value = "/budget/del-stock-item/{dataId}", method = RequestMethod.POST)
	@ResponseBody
	public Object deleteBudgetStockItem(@PathVariable("dataId") String dataId,HttpServletRequest request) throws IOException 
	{
		ResponseEntity<Integer> responseEntity = this.restTemplate.exchange(BUDGET_STOCKTOTAL_DEL_ITEMS+dataId, HttpMethod.POST, new HttpEntity<Object>(this.httpHeaders), Integer.class);
		if (responseEntity.getBody() == 0) {
			return new Result(false);
		} else {
			return new Result(true);
		}
	}
	@RequestMapping(value = "/budget/start-budget-stocktotal-activity", method = RequestMethod.POST)
	@ResponseBody
	public Object submitBudgetStockTotal(@RequestParam(value = "budgetInfoId", required = true) String budgetInfoId,
			@RequestParam(value = "functionId", required = true) String functionId,HttpServletRequest request) throws IOException 
	{
		WorkflowVo vo = new WorkflowVo();
		vo.setAuditUserIds(this.getUserProfile().getUserId());
		vo.setFunctionId(functionId);
		vo.setAuthenticatedUserId(this.getUserProfile().getUserId());
		HttpEntity<WorkflowVo> entity = new HttpEntity<WorkflowVo>(vo, this.httpHeaders);
		Result startRs = this.restTemplate.exchange(PROJECT_NOTICE_WORKFLOW_URL + budgetInfoId, HttpMethod.POST, entity, Result.class).getBody();
		
		ResponseEntity<BudgetInfo> getRs = this.restTemplate.exchange(BUDGET_INFO_GET+budgetInfoId, HttpMethod.POST, new HttpEntity<Object>(this.httpHeaders), BudgetInfo.class);
		BudgetInfo info =getRs.getBody();// JSON.toJavaObject(JSON.parseObject(getRs.getBody().toString()), BudgetInfo.class);
		
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
	@RequestMapping(value = "/budget/search-stocktotal-history-items", method = RequestMethod.POST)
	@ResponseBody
	public Object searchBudgetStockTotalHistoryItems(@ModelAttribute("info") BudgetStockTotal info,HttpServletRequest request) throws IOException 
	{
		//System.out.println(JSON.toJSONString(info));
		ResponseEntity<?> infors = this.restTemplate.exchange(BUDGET_STOCKTOTAL_HISTORY_ITEMS, HttpMethod.POST, new HttpEntity<Object>(info, this.httpHeaders), List.class);
		return infors.getBody();
	}
	@RequestMapping(value = "/budget/search-stocktotal-final-history-list", method = RequestMethod.POST)
	@ResponseBody
	public Object searchBudgetStockTotalFinalHistoryList(HttpServletRequest request) throws IOException 
	{
		//System.out.println(JSON.toJSONString(info));
		ResponseEntity<?> infors = this.restTemplate.exchange(BUDGET_STOCKTOTAL_FINAL_HISTORY_LIST, HttpMethod.POST, new HttpEntity<Object>(this.httpHeaders), List.class);
		return infors.getBody();
	}
	
	
	@RequestMapping(value = "/budget/select-stocktotal-compare-plan", method = RequestMethod.POST)
	@ResponseBody
	public Object selectBudgetStockTotalComparePlan(@RequestParam(value="nd",required = false)String nd,@RequestParam(value="code",required = false)String code,HttpServletRequest request) throws IOException 
	{
		System.out.println("plan............"+nd+"------"+code);
		if(nd == null || code == null) {
			return new ArrayList<Object>();
		}
		Map<String,Object> param = new HashMap<String,Object>();
		param.put("nd", nd);
		param.put("code", code);
		//System.out.println(JSON.toJSONString(info));
		ResponseEntity<?> infors = this.restTemplate.exchange(BUDGET_STOCKTOTAL_COMPARE_PLAN, HttpMethod.POST, new HttpEntity<Object>(param,this.httpHeaders), List.class);
		//System.out.println(JSON.toJSONString(infors.getBody()));
		return infors.getBody();
	}
	
	@RequestMapping(value = "/budget/select-stocktotal-compare-project", method = RequestMethod.POST)
	@ResponseBody
	public Object selectBudgetStockTotalCompareProject(@RequestParam(value="nd",required = false)String nd,@RequestParam(value="code",required = false)String code,HttpServletRequest request) throws IOException 
	{
		System.out.println("plan............"+nd+"------"+code);
		if(nd == null || code == null) {
			return new ArrayList<Object>();
		}
		Map<String,Object> param = new HashMap<String,Object>();
		param.put("nd", nd);
		param.put("code", code);
		//System.out.println(JSON.toJSONString(info));
		ResponseEntity<?> infors = this.restTemplate.exchange(BUDGET_STOCKTOTAL_COMPARE_PROJECT, HttpMethod.POST, new HttpEntity<Object>(param,this.httpHeaders), List.class);
		//System.out.println(JSON.toJSONString(infors.getBody()));
		return infors.getBody();
	}
	@RequestMapping(value = "/budget/search-stockitem-tree", method = RequestMethod.POST)
	@ResponseBody
	public Object searchStockitemTree(@RequestParam(value="dataId",required = false)String dataId,HttpServletRequest request, HttpServletResponse response) throws Exception 
	{
		ResponseEntity<?> infors = this.restTemplate.exchange(BUDGET_STOCKTOTAL_ITEM_TREE, HttpMethod.POST, new HttpEntity<Object>(dataId,this.httpHeaders), Object.class);
		//System.out.println(JSON.toJSONString(infors.getBody()));
		return infors.getBody();
	}
	@RequestMapping(value = "/budget/get-stockitem-type-dictionary", method = RequestMethod.POST)
	@ResponseBody
	public Object getStockitemTypeDictionary(@RequestParam(value="nd",required = false)String nd,HttpServletRequest request, HttpServletResponse response) throws Exception 
	{
		ResponseEntity<?> infors = this.restTemplate.exchange(BUDGET_STOCKTOTAL_TYPE_DICTIONARY, HttpMethod.POST, new HttpEntity<Object>(nd,this.httpHeaders), Object.class);
		//System.out.println(JSON.toJSONString(infors.getBody()));
		return infors.getBody();
	}
	@SuppressWarnings({ "unchecked", "rawtypes" })
	@RequestMapping("/budget/budget_download/stocktotal/{dataId}")
	public void downBudgetStockTotal(@PathVariable("dataId") String dataId,HttpServletResponse res) throws IOException 
	{
		LayuiTableParam param = new LayuiTableParam();
		param.getParam().put("budget_info_id", dataId);
		param.setLimit(100);
		param.setPage(1);
		ResponseEntity<LayuiTableData> responseEntity = this.restTemplate.exchange(BUDGET_STOCKTOTAL_ITEMS, HttpMethod.POST, new HttpEntity<LayuiTableParam>(param, this.httpHeaders), LayuiTableData.class);
		LayuiTableData tabldata = responseEntity.getBody();
		//System.out.println(JSON.toJSONString(tabldata));
		
		ResponseEntity<BudgetInfo> rs = this.restTemplate.exchange(BUDGET_STOCKTOTAL_INFO, HttpMethod.POST, new HttpEntity<String>(dataId, this.httpHeaders), BudgetInfo.class);
		BudgetInfo info = rs.getBody();
		
		Map<String,String> parammap = new HashMap<String,String>();
		parammap.put("nd", info.getNd());
		
		
		URL path = this.getClass().getResource("/");
		File f = new File(path.getPath() + "static/budget/budget_stocktotal_template.xlsx");
		//System.out.println(f.getAbsolutePath());
		//写入新文件2019年集团公司总部科技经费预算
		String newFilePath = path.getPath() + "static/budget/"+info.getNd()+"年股份公司总部科技经费预算（建议稿）_"+DateUtil.dateToStr(new Date(), "yyyyMMddHHmmss")+".xlsx";
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
			String itemTitleJfys = readCell(sheet.getRow(2).getCell(2));
			String itemTitleYjwc = readCell(sheet.getRow(2).getCell(5));
			String itemTitleXmjf = readCell(sheet.getRow(2).getCell(8));
			
			sheet.getRow(0).getCell(0).setCellValue(title.replace("${nd}", nd.toString()));
			sheet.getRow(2).getCell(2).setCellValue(itemTitleJfys.replace("${yd}", new Integer(nd-1).toString()));
			sheet.getRow(2).getCell(5).setCellValue(itemTitleYjwc.replace("${yd}", new Integer(nd-1).toString()));
			sheet.getRow(2).getCell(8).setCellValue(itemTitleXmjf.replace("${nd}", nd.toString()));
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
			
			//合计
			Row totalRow = sheet.getRow(4);
			totalRow.createCell(0).setCellValue("");
			totalRow.createCell(1).setCellValue("");
			totalRow.createCell(2).setCellValue("");
			totalRow.createCell(3).setCellValue("");
			totalRow.createCell(4).setCellValue("");
			totalRow.createCell(5).setCellValue("");
			totalRow.createCell(6).setCellValue("");
			totalRow.createCell(7).setCellValue("");
			totalRow.createCell(8).setCellValue("");
			totalRow.createCell(9).setCellValue("");
			totalRow.createCell(10).setCellValue("");
			
			Double allYjwcTotal = 0d;
			Double allYjwcZbx = 0d;
			Double allYjwcFyx = 0d;
			Double allXmjfTotal = 0d;
			Double allXmjfZbx = 0d;
			Double allXmjfFyx = 0d;
			for(int i = 0;i<list.size();i++) {
				
				Integer no = (Integer)list.get(i).get("no");
				String displayName = list.get(i).get("displayName").toString();
				Integer level = (Integer)list.get(i).get("level");
				
				
				String l_hj = "无";
				String l_zbx = "无";
				String l_fyx = "无";
				Double yjwcTotal = (Double)list.get(i).get("yjwcTotal");
				Double yjwcZbx = (Double)list.get(i).get("yjwcZbx");
				Double yjwcFyx = (Double)list.get(i).get("yjwcFyx");
				Double xmjfTotal = (Double)list.get(i).get("xmjfTotal");
				Double xmjfZbx = (Double)list.get(i).get("xmjfZbx");
				Double xmjfFyx = (Double)list.get(i).get("xmjfFyx");
				allYjwcTotal += yjwcTotal;
				allYjwcZbx += yjwcZbx;
				allYjwcFyx += yjwcFyx;
				allXmjfTotal += xmjfTotal;
				allXmjfZbx += xmjfZbx;
				allXmjfFyx += xmjfFyx;
				
				Row crow = sheet.getRow(i+5);
				if(level == 0) {
					crow.createCell(0).setCellValue(no);
				}else {
					crow.createCell(0).setCellValue("");
				}
				crow.createCell(1).setCellValue(displayName);
				crow.createCell(2).setCellValue(l_hj);
				crow.createCell(3).setCellValue(l_zbx);
				crow.createCell(4).setCellValue(l_fyx);
				crow.createCell(5).setCellValue(yjwcTotal);
				crow.createCell(6).setCellValue(yjwcZbx);
				crow.createCell(7).setCellValue(yjwcFyx);
				crow.createCell(8).setCellValue(xmjfTotal);
				crow.createCell(9).setCellValue(xmjfZbx);
				crow.createCell(10).setCellValue(xmjfFyx);
				
				
				
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
				crow.getCell(8).setCellStyle(rightCenterStyle);
				crow.getCell(9).setCellStyle(rightCenterStyle);
				crow.getCell(10).setCellStyle(rightCenterStyle);
			}
			totalRow.getCell(0).setCellValue("合计");
			totalRow.getCell(1).setCellValue("");
			totalRow.getCell(2).setCellValue("无");
			totalRow.getCell(3).setCellValue("无");
			totalRow.getCell(4).setCellValue("无");
			totalRow.getCell(5).setCellValue(allYjwcTotal);
			totalRow.getCell(6).setCellValue(allYjwcZbx);
			totalRow.getCell(7).setCellValue(allYjwcFyx);
			totalRow.getCell(8).setCellValue(allXmjfTotal);
			totalRow.getCell(9).setCellValue(allXmjfZbx);
			totalRow.getCell(10).setCellValue(allXmjfFyx);
			
			totalRow.getCell(0).setCellStyle(centerStyle);
			totalRow.getCell(1).setCellStyle(centerStyle);
			totalRow.getCell(2).setCellStyle(rightCenterStyle);
			totalRow.getCell(3).setCellStyle(rightCenterStyle);
			totalRow.getCell(4).setCellStyle(rightCenterStyle);
			totalRow.getCell(5).setCellStyle(rightCenterStyle);
			totalRow.getCell(6).setCellStyle(rightCenterStyle);
			totalRow.getCell(7).setCellStyle(rightCenterStyle);
			totalRow.getCell(8).setCellStyle(rightCenterStyle);
			totalRow.getCell(9).setCellStyle(rightCenterStyle);
			totalRow.getCell(10).setCellStyle(rightCenterStyle);
			
			//合计单元格合并
			sheet.addMergedRegion(new CellRangeAddress(4,4,0,1));
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
