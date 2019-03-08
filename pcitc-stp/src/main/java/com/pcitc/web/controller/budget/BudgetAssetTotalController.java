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
import com.pcitc.base.stp.budget.BudgetAssetTotal;
import com.pcitc.base.stp.budget.BudgetInfo;
import com.pcitc.base.util.DateUtil;
import com.pcitc.base.util.IdUtil;
import com.pcitc.base.util.MyBeanUtils;
import com.pcitc.base.workflow.WorkflowVo;
import com.pcitc.web.common.BaseController;
/**
 * 资产预算总表
 * @author fb
 *
 */
@Controller
public class BudgetAssetTotalController extends BaseController {

	private static final String BUDGET_ASSETTOTAL_TABLE = "http://pcitc-zuul/stp-proxy/stp-provider/budget/budget-assettotal-info-table";
	private static final String BUDGET_ASSETTOTAL_LIST = "http://pcitc-zuul/stp-proxy/stp-provider/budget/budget-assettotal-info-list";	
	private static final String BUDGET_ASSETTOTAL_INFO = "http://pcitc-zuul/stp-proxy/stp-provider/budget/budget-assettotal-info";	
	private static final String BUDGET_ASSETTOTAL_ITEMS = "http://pcitc-zuul/stp-proxy/stp-provider/budget/budget-assettotal-items";
	private static final String BUDGET_ASSETTOTAL_CREATE = "http://pcitc-zuul/stp-proxy/stp-provider/budget/budget-create-blank-assettotal";
	private static final String BUDGET_ASSETTOTAL_CREATE_BYTEMPLATE = "http://pcitc-zuul/stp-proxy/stp-provider/budget/budget-create-template-assettotal";
	private static final String BUDGET_ASSETTOTAL_DELETE = "http://pcitc-zuul/stp-proxy/stp-provider/budget/budget-assettotal-del";
	private static final String BUDGET_ASSETTOTAL_GET_ITEM = "http://pcitc-zuul/stp-proxy/stp-provider/budget/get-assettotal-item/";
	private static final String BUDGET_ASSETTOTAL_DEL_ITEMS = "http://pcitc-zuul/stp-proxy/stp-provider/budget/del-assettotal-item/";
	private static final String BUDGET_ASSETTOTAL_SAVE_ITEM = "http://pcitc-zuul/stp-proxy/stp-provider/budget/save-assettotal-item";
	private static final String BUDGET_ASSETTOTAL_SAVE_ITEMS = "http://pcitc-zuul/stp-proxy/stp-provider/budget/save-assettotal-items";
	private static final String BUDGET_ASSETTOTAL_SAVE_CHILDITEMS = "http://pcitc-zuul/stp-proxy/stp-provider/budget/save-assettotal-childitems";
	private static final String BUDGET_ASSETTOTAL_COMPANY_ITEMS = "http://pcitc-zuul/stp-proxy/stp-provider/budget/search-asset-company-items";
	private static final String BUDGET_ASSETTOTAL_COMPANY_TREE = "http://pcitc-zuul/stp-proxy/stp-provider/budget/search-asset-company-tree";
	private static final String BUDGET_ASSETTOTAL_HISTORY_ITEMS = "http://pcitc-zuul/stp-proxy/stp-provider/budget/search-assettotal-history-items";
	private static final String BUDGET_ASSETTOTAL_FINAL_HISTORY_LIST = "http://pcitc-zuul/stp-proxy/stp-provider/budget/search-assettotal-final-history-list";
	private static final String BUDGET_ASSETTOTAL_COMPARE_PLAN = "http://pcitc-zuul/stp-proxy/stp-provider/budget/select-assettotal-compare-plan";
	private static final String BUDGET_ASSETTOTAL_COMPARE_PROJECT = "http://pcitc-zuul/stp-proxy/stp-provider/budget/select-assettotal-compare-project";
	
	private static final String BUDGET_INFO_UPDATE = "http://pcitc-zuul/stp-proxy/stp-provider/budget/budget-info-update";
	private static final String BUDGET_INFO_GET = "http://pcitc-zuul/stp-proxy/stp-provider/budget/budget-info-get/";
	private static final String PROJECT_NOTICE_WORKFLOW_URL = "http://pcitc-zuul/stp-proxy/stp-provider/budget/start-budget-assettotal-activity/";
	
	
	@RequestMapping(method = RequestMethod.GET, value = "/budget/budget_main_assettotal")
	public Object toBudgetAssetPage(HttpServletRequest request) throws IOException 
	{
		request.setAttribute("nd", DateUtil.format(new Date(), DateUtil.FMT_YYYY));
		return "stp/budget/budget_main_assettotal";
	}
	@RequestMapping(method = RequestMethod.GET, value = "/budget/budget_edit_assettotal")
	public Object toBudgetAssetEditPage(HttpServletRequest request) throws IOException 
	{
		String dataId = request.getParameter("dataId");
		String nd = request.getParameter("nd");
		request.setAttribute("dataId", dataId==null?IdUtil.createIdByTime():dataId);
		request.setAttribute("budgetInfoId", request.getParameter("budgetInfoId"));
		request.setAttribute("nd", nd ==null?DateUtil.format(new Date(), DateUtil.FMT_YYYY):nd);
		return "stp/budget/budget_edit_assettotal";
	}
	@RequestMapping(method = RequestMethod.GET, value = "/budget/budget_create_assettotal")
	public Object toBudgetAssetAddPage(HttpServletRequest request) throws IOException 
	{
		request.setAttribute("nd", DateUtil.format(new Date(), DateUtil.FMT_YYYY));
		return "stp/budget/budget_create_assettotal";
	}
	@RequestMapping(method = RequestMethod.GET, value = "/budget/budget_history_compare_assettotal")
	public Object toBudgetAssetTotalHistoryPage(HttpServletRequest request) throws IOException 
	{
		
		request.setAttribute("dataId", request.getParameter("dataId"));
		request.setAttribute("budgetInfoId", request.getParameter("budgetInfoId"));
		request.setAttribute("nd", DateUtil.format(new Date(), DateUtil.FMT_YYYY));
		return "stp/budget/budget_history_compare_assettotal";
	}
	@RequestMapping(method = RequestMethod.GET, value = "/budget/budget_history_view_assettotal")
	public Object toBudgetAssetTotalHistoryViews(HttpServletRequest request) throws IOException 
	{
		//检索数据
		ResponseEntity<?> infors = this.restTemplate.exchange(BUDGET_ASSETTOTAL_FINAL_HISTORY_LIST, HttpMethod.POST, new HttpEntity<Object>(this.httpHeaders), List.class);
		String budgetInfoId = request.getParameter("budgetInfoId");
		request.setAttribute("budgetInfoId", budgetInfoId);
		request.setAttribute("tb_datas", infors.getBody());
		request.setAttribute("nd", DateUtil.format(new Date(), DateUtil.FMT_YYYY));
		return "stp/budget/budget_history_view_assettotal";
	}
	
	@RequestMapping(value = "/budget/budget_asset_info_list", method = RequestMethod.POST)
	@ResponseBody
	public Object getBudgetAssetList(@ModelAttribute("info") BudgetInfo info,HttpServletRequest request) throws IOException 
	{
		ResponseEntity<Object> responseEntity = this.restTemplate.exchange(BUDGET_ASSETTOTAL_LIST, HttpMethod.POST, new HttpEntity<BudgetInfo>(info, this.httpHeaders), Object.class);
		//System.out.println(JSON.toJSON(responseEntity.getBody()).toString());
		return JSON.toJSON(responseEntity.getBody()).toString();
	}
	@RequestMapping(value = "/budget/budget_asset_info_table", method = RequestMethod.POST)
	@ResponseBody
	public Object getBudgetAssetTable(@ModelAttribute("param") LayuiTableParam param,HttpServletRequest request) throws IOException 
	{
		ResponseEntity<Object> responseEntity = this.restTemplate.exchange(BUDGET_ASSETTOTAL_TABLE, HttpMethod.POST, new HttpEntity<LayuiTableParam>(param, this.httpHeaders), Object.class);
		//System.out.println(JSON.toJSON(responseEntity.getBody()).toString());
		return JSON.toJSON(responseEntity.getBody()).toString();
	}
	@RequestMapping(value = "/budget/budget-assettotal-items", method = RequestMethod.POST)
	@ResponseBody
	public Object getBudgetAssetItems(@ModelAttribute("param") LayuiTableParam param,HttpServletRequest request) throws IOException 
	{
		ResponseEntity<Object> responseEntity = this.restTemplate.exchange(BUDGET_ASSETTOTAL_ITEMS, HttpMethod.POST, new HttpEntity<LayuiTableParam>(param, this.httpHeaders), Object.class);
		System.out.println(JSON.toJSON(responseEntity.getBody()));
		return JSON.toJSON(responseEntity.getBody()).toString();
	}
	@RequestMapping(value = "/budget/budget-assettotal-create", method = RequestMethod.POST)
	@ResponseBody
	public Object createBudgetAssetInfo(@ModelAttribute("info") BudgetInfo info,HttpServletRequest request) throws IOException 
	{
		
		info.setCreaterId(this.getUserProfile().getUserId());
		info.setCreaterName(this.getUserProfile().getUserDisp());
		ResponseEntity<Object> responseEntity = this.restTemplate.exchange(BUDGET_ASSETTOTAL_CREATE, HttpMethod.POST, new HttpEntity<BudgetInfo>(info, this.httpHeaders), Object.class);
		//System.out.println(JSON.toJSON(responseEntity.getBody()).toString());
		return JSON.toJSON(responseEntity.getBody()).toString();
	}
	
	@RequestMapping(value = "/budget/budget-assettotal-create-bytemplate", method = RequestMethod.POST)
	@ResponseBody
	public Object createBudgetAssetInfoByTemplate(@ModelAttribute("info") BudgetInfo info,HttpServletRequest request) throws IOException 
	{
		info.setCreaterId(this.getUserProfile().getUserId());
		info.setCreaterName(this.getUserProfile().getUserDisp());
		ResponseEntity<Object> responseEntity = this.restTemplate.exchange(BUDGET_ASSETTOTAL_CREATE_BYTEMPLATE, HttpMethod.POST, new HttpEntity<BudgetInfo>(info, this.httpHeaders), Object.class);
		//System.out.println(JSON.toJSON(responseEntity.getBody()).toString());
		return JSON.toJSON(responseEntity.getBody()).toString();
	}
	
	@RequestMapping(value = "/budget/budget-assettotal-del", method = RequestMethod.POST)
	@ResponseBody
	public Object deleteBudgetAssetInfo(@ModelAttribute("info") BudgetInfo info,HttpServletRequest request) throws IOException 
	{
		ResponseEntity<Object> responseEntity = this.restTemplate.exchange(BUDGET_ASSETTOTAL_DELETE, HttpMethod.POST, new HttpEntity<BudgetInfo>(info, this.httpHeaders), Object.class);
		//System.out.println(JSON.toJSON(responseEntity.getBody()).toString());
		return JSON.toJSON(responseEntity.getBody()).toString();
	}
	@RequestMapping(value = "/budget/get-assettotal-item/{dataId}", method = RequestMethod.POST)
	@ResponseBody
	public Object selectBudgetAssetTotalItem(@PathVariable("dataId") String dataId,HttpServletRequest request) throws IOException 
	{
		ResponseEntity<Object> responseEntity = this.restTemplate.exchange(BUDGET_ASSETTOTAL_GET_ITEM+dataId, HttpMethod.POST, new HttpEntity<Object>(dataId, this.httpHeaders), Object.class);
		//System.out.println(JSON.toJSON(responseEntity.getBody()).toString());
		return JSON.toJSON(responseEntity.getBody()).toString();
	}
	@RequestMapping(value = "/budget/save-assettotal-item", method = RequestMethod.POST)
	@ResponseBody
	public Object saveBudgetAssetTotalItem(@ModelAttribute("item") BudgetAssetTotal item,HttpServletRequest request) throws IOException 
	{
		System.out.println(JSON.toJSONString(item));
		ResponseEntity<BudgetAssetTotal> rs = this.restTemplate.exchange(BUDGET_ASSETTOTAL_SAVE_ITEM, HttpMethod.POST, new HttpEntity<BudgetAssetTotal>(item, this.httpHeaders), BudgetAssetTotal.class);
		if (rs.getBody() != null) {
			return new Result(true,rs.getBody());
		} else {
			return new Result(false);
		}
	}
	@RequestMapping(value = "/budget/save-assettotal-items", method = RequestMethod.POST)
	@ResponseBody
	public Object saveBudgetAssetTotalItems(
			@ModelAttribute("items") String items,
			@ModelAttribute("info") String info,HttpServletRequest request) throws IOException 
	{
		List<BudgetAssetTotal> grouplist = JSON.parseArray(items, BudgetAssetTotal.class);
		BudgetInfo budget = JSON.toJavaObject(JSON.parseObject(info), BudgetInfo.class);
		ResponseEntity<Integer> infors = this.restTemplate.exchange(BUDGET_INFO_UPDATE, HttpMethod.POST, new HttpEntity<Object>(budget, this.httpHeaders), Integer.class);
		ResponseEntity<Integer> grouprs = this.restTemplate.exchange(BUDGET_ASSETTOTAL_SAVE_ITEMS, HttpMethod.POST, new HttpEntity<Object>(grouplist, this.httpHeaders), Integer.class);
		if (infors.getBody() >= 0 && grouprs.getBody() >= 0) 
		{
			return new Result(true);
		} else {
			return new Result(false);
		}
	}
	@RequestMapping(value = "/budget/save-assettotal-childitems", method = RequestMethod.POST)
	@ResponseBody
	public Object saveBudgetChildAssetTotalItems(@RequestParam("items")String items,@RequestParam("item")String item,HttpServletRequest request) throws IOException 
	{
		Map<String,Object> mapParam = new HashMap<String,Object>();
		mapParam.put("items", JSON.parseArray(items).toString());
		mapParam.put("item", JSON.parse(item).toString());
		ResponseEntity<Integer> responseEntity = this.restTemplate.exchange(BUDGET_ASSETTOTAL_SAVE_CHILDITEMS, HttpMethod.POST, new HttpEntity<Object>(mapParam, this.httpHeaders), Integer.class);
		if (responseEntity.getBody() == 0) {
			return new Result(false);
		} else {
			return new Result(true);
		}
	}
	
	@RequestMapping(value = "/budget/search-asset-company-items", method = RequestMethod.POST)
	@ResponseBody
	public Object searchBudgetAssetCompanyItems(HttpServletRequest request) throws IOException 
	{
		//获取所有的集团公司
		ResponseEntity<?> responseEntity = this.restTemplate.exchange(BUDGET_ASSETTOTAL_COMPANY_ITEMS, HttpMethod.POST, new HttpEntity<Object>(this.httpHeaders), List.class);
		return responseEntity.getBody();
	}
	@RequestMapping(value = "/budget/search-asset-company-tree", method = RequestMethod.POST)
	@ResponseBody
	public Object searchBudgetAssetCompanyTree(HttpServletRequest request) throws IOException 
	{
		//获取所有的集团公司
		ResponseEntity<?> responseEntity = this.restTemplate.exchange(BUDGET_ASSETTOTAL_COMPANY_TREE, HttpMethod.POST, new HttpEntity<Object>(this.httpHeaders), List.class);
		return responseEntity.getBody();
	}
	@RequestMapping(value = "/budget/del-asset-item/{dataId}", method = RequestMethod.POST)
	@ResponseBody
	public Object deleteBudgetAssetItem(@PathVariable("dataId") String dataId,HttpServletRequest request) throws IOException 
	{
		ResponseEntity<Integer> responseEntity = this.restTemplate.exchange(BUDGET_ASSETTOTAL_DEL_ITEMS+dataId, HttpMethod.POST, new HttpEntity<Object>(this.httpHeaders), Integer.class);
		if (responseEntity.getBody() == 0) {
			return new Result(false);
		} else {
			return new Result(true);
		}
	}
	@RequestMapping(value = "/budget/start-budget-assettotal-activity", method = RequestMethod.POST)
	@ResponseBody
	public Object submitBudgetAssetTotal(@RequestParam(value = "budgetInfoId", required = true) String budgetInfoId,
			@RequestParam(value = "functionId", required = true) String functionId,HttpServletRequest request) throws IOException 
	{
		System.out.println("start-budget-assettotal-activity-----------------");
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
	@RequestMapping(value = "/budget/search-assettotal-history-items", method = RequestMethod.POST)
	@ResponseBody
	public Object searchBudgetAssetTotalHistoryItems(@ModelAttribute("info") BudgetAssetTotal info,HttpServletRequest request) throws IOException 
	{
		//System.out.println(JSON.toJSONString(info));
		ResponseEntity<?> infors = this.restTemplate.exchange(BUDGET_ASSETTOTAL_HISTORY_ITEMS, HttpMethod.POST, new HttpEntity<Object>(info, this.httpHeaders), List.class);
		return infors.getBody();
	}
	@RequestMapping(value = "/budget/search-assettotal-final-history-list", method = RequestMethod.POST)
	@ResponseBody
	public Object searchBudgetAssetTotalFinalHistoryList(HttpServletRequest request) throws IOException 
	{
		//System.out.println(JSON.toJSONString(info));
		ResponseEntity<?> infors = this.restTemplate.exchange(BUDGET_ASSETTOTAL_FINAL_HISTORY_LIST, HttpMethod.POST, new HttpEntity<Object>(this.httpHeaders), List.class);
		return infors.getBody();
	}
	
	
	@RequestMapping(value = "/budget/select-assettotal-compare-plan", method = RequestMethod.POST)
	@ResponseBody
	public Object selectBudgetAssetTotalComparePlan(@RequestParam(value="nd",required = false)String nd,@RequestParam(value="code",required = false)String code,HttpServletRequest request) throws IOException 
	{
		System.out.println("plan............"+nd+"------"+code);
		if(nd == null || code == null) {
			return new ArrayList<Object>();
		}
		Map<String,Object> param = new HashMap<String,Object>();
		param.put("nd", nd);
		param.put("code", code);
		//System.out.println(JSON.toJSONString(info));
		ResponseEntity<?> infors = this.restTemplate.exchange(BUDGET_ASSETTOTAL_COMPARE_PLAN, HttpMethod.POST, new HttpEntity<Object>(param,this.httpHeaders), List.class);
		//System.out.println(JSON.toJSONString(infors.getBody()));
		return infors.getBody();
	}
	
	@RequestMapping(value = "/budget/select-assettotal-compare-project", method = RequestMethod.POST)
	@ResponseBody
	public Object selectBudgetAssetTotalCompareProject(@RequestParam(value="nd",required = false)String nd,@RequestParam(value="code",required = false)String code,HttpServletRequest request) throws IOException 
	{
		System.out.println("plan............"+nd+"------"+code);
		if(nd == null || code == null) {
			return new ArrayList<Object>();
		}
		Map<String,Object> param = new HashMap<String,Object>();
		param.put("nd", nd);
		param.put("code", code);
		//System.out.println(JSON.toJSONString(info));
		ResponseEntity<?> infors = this.restTemplate.exchange(BUDGET_ASSETTOTAL_COMPARE_PROJECT, HttpMethod.POST, new HttpEntity<Object>(param,this.httpHeaders), List.class);
		//System.out.println(JSON.toJSONString(infors.getBody()));
		return infors.getBody();
	}
	/*@RequestMapping(value = "/budget/start-budget-grouptotal-activity")
	public Object startBudgetGrouptotatlWorkflow(@RequestParam(value = "budget", required = true) String noticeId,
			@RequestParam(value = "functionId", required = true) String functionId,
			HttpServletRequest request, HttpServletResponse response) throws Exception 
	{
		WorkflowVo vo = new WorkflowVo();
		vo.setAuditUserIds(this.getUserProfile().getUserId());
		vo.setFunctionId(functionId);
		vo.setAuthenticatedUserId(this.getUserProfile().getUserId());
		HttpEntity<WorkflowVo> entity = new HttpEntity<WorkflowVo>(vo, this.httpHeaders);
		Result rs = this.restTemplate.exchange(PROJECT_NOTICE_WORKFLOW_URL + noticeId, HttpMethod.POST, entity, Result.class).getBody();
		return rs;
	}*/
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	@RequestMapping("/budget/budget_download/assettotal/{dataId}")
	public void downBudgetAssetTotal(@PathVariable("dataId") String dataId,HttpServletResponse res) throws IOException 
	{
		LayuiTableParam param = new LayuiTableParam();
		param.getParam().put("budget_info_id", dataId);
		param.setLimit(100);
		param.setPage(1);
		ResponseEntity<LayuiTableData> responseEntity = this.restTemplate.exchange(BUDGET_ASSETTOTAL_ITEMS, HttpMethod.POST, new HttpEntity<LayuiTableParam>(param, this.httpHeaders), LayuiTableData.class);
		LayuiTableData tabldata = responseEntity.getBody();
		//System.out.println(JSON.toJSONString(tabldata));
		
		ResponseEntity<BudgetInfo> rs = this.restTemplate.exchange(BUDGET_ASSETTOTAL_INFO, HttpMethod.POST, new HttpEntity<String>(dataId, this.httpHeaders), BudgetInfo.class);
		BudgetInfo info = rs.getBody();
		
		Map<String,String> parammap = new HashMap<String,String>();
		parammap.put("nd", info.getNd());
		
		
		URL path = this.getClass().getResource("/");
		File f = new File(path.getPath() + "static/budget/budget_assettotal_template.xlsx");
		//System.out.println(f.getAbsolutePath());
		//写入新文件2019年集团公司总部科技经费预算
		String newFilePath = path.getPath() + "static/budget/"+info.getNd()+"年资产公司总部科技项目经费预算（建议稿）_"+DateUtil.dateToStr(new Date(), "yyyyMMddHHmmss")+".xlsx";
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
