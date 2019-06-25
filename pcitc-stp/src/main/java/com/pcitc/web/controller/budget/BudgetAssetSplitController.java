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
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.pcitc.base.common.LayuiTableData;
import com.pcitc.base.common.LayuiTableParam;
import com.pcitc.base.common.Result;
import com.pcitc.base.common.enums.BudgetAuditStatusEnum;
import com.pcitc.base.common.enums.BudgetInfoEnum;
import com.pcitc.base.stp.budget.BudgetInfo;
import com.pcitc.base.stp.budget.vo.BudgetSplitBaseDataVo;
import com.pcitc.base.util.DateUtil;
import com.pcitc.base.util.DateUtils;
import com.pcitc.base.workflow.WorkflowVo;
import com.pcitc.web.common.BaseController;
import com.pcitc.web.utils.InputCheckUtil;
/**
 * 资产预算分解表
 * @author fb
 *
 */
@Controller
public class BudgetAssetSplitController extends BaseController {

	private static final String BUDGET_ASSETSPLIT_TABLE = "http://pcitc-zuul/stp-proxy/stp-provider/budget/budget-assetsplit-info-table";
	private static final String BUDGET_ASSETSPLIT_LIST = "http://pcitc-zuul/stp-proxy/stp-provider/budget/budget-assetsplit-info-list";	
	private static final String BUDGET_ASSETSPLIT_INFO = "http://pcitc-zuul/stp-proxy/stp-provider/budget/budget-assetsplit-info";	
	private static final String BUDGET_ASSETSPLIT_ITEMS = "http://pcitc-zuul/stp-proxy/stp-provider/budget/budget-assetsplit-items";
	
	private static final String BUDGET_ASSETSPLIT_TITLES = "http://pcitc-zuul/stp-proxy/stp-provider/budget/budget-assetsplit-titles";
	private static final String BUDGET_ASSETSPLIT_HISTORY_TITLES = "http://pcitc-zuul/stp-proxy/stp-provider/budget/budget-assetsplit-history-titles";
	private static final String BUDGET_ASSETSPLIT_DELETE = "http://pcitc-zuul/stp-proxy/stp-provider/budget/budget-assetsplit-del";
	private static final String BUDGET_ASSETSPLIT_GET_ITEM = "http://pcitc-zuul/stp-proxy/stp-provider/budget/get-assetsplit-item";
	private static final String BUDGET_ASSETSPLIT_SAVE_ITEMS = "http://pcitc-zuul/stp-proxy/stp-provider/budget/save-assetsplit-items";
	private static final String BUDGET_ASSETSPLIT_SAVE_ITEM = "http://pcitc-zuul/stp-proxy/stp-provider/budget/save-assetsplit-item";
	private static final String BUDGET_ASSETSPLIT_HISTORY_ITEMS = "http://pcitc-zuul/stp-proxy/stp-provider/budget/get-assetsplit-history-items";
	
	private static final String BUDGET_ASSETSPLIT_CREATE = "http://pcitc-zuul/stp-proxy/stp-provider/budget/budget-create-blank-assetsplit";
	private static final String BUDGET_ASSETSPLIT_FINAL_HISTORY_LIST = "http://pcitc-zuul/stp-proxy/stp-provider/budget/search-assetsplit-final-history-list";
	private static final String BUDGET_ASSETSPLIT_COMPARE_PLAN = "http://pcitc-zuul/stp-proxy/stp-provider/budget/select-assetsplit-compare-plan";
	private static final String BUDGET_ASSETSPLIT_COMPARE_PROJECT = "http://pcitc-zuul/stp-proxy/stp-provider/budget/select-assetsplit-compare-project";
	
	private static final String BUDGET_INFO_UPDATE = "http://pcitc-zuul/stp-proxy/stp-provider/budget/budget-info-update";
	private static final String BUDGET_WORKFLOW_URL = "http://pcitc-zuul/stp-proxy/stp-provider/budget/start-budgetinfo-activity/";
	private static final String BUDGET_INFO_GET = "http://pcitc-zuul/stp-proxy/stp-provider/budget/budget-info-get/";
	//private static final String PROJECT_NOTICE_WORKFLOW_URL = "http://pcitc-zuul/stp-proxy/stp-provider/budget/start-budget-assetsplit-activity/";
	private static final String BUDGET_INFO_EDIT_CHECK = "http://pcitc-zuul/stp-proxy/stp-provider/budget/check-budgetinfo-edit/";
	private static final String BUDGET_FINAL_INFO = "http://pcitc-zuul/stp-proxy/stp-provider/budget/get-final-budget";
	
	@RequestMapping(method = RequestMethod.GET, value = "/budget/budget_main_assetsplit")
	public Object toBudgetGroupPage(HttpServletRequest request) throws IOException 
	{
		
		String nd = request.getParameter("nd");
		if(nd == null) {
			nd = DateUtil.format(DateUtil.getNextYearDay(new Date()), DateUtil.FMT_YYYY);
		}
		//输入验证
		if(!InputCheckUtil.check(InputCheckUtil.pub_nd, nd)) {
			return "error";
		}
		request.setAttribute("nd", nd);
		request.setAttribute("budgetType", BudgetInfoEnum.ASSET_SPLIT.getCode());
		ResponseEntity<?> infors = this.restTemplate.exchange(BUDGET_ASSETSPLIT_TITLES, HttpMethod.POST, new HttpEntity<Object>(nd,this.httpHeaders), List.class);
		request.setAttribute("items", infors.getBody());
		return "stp/budget/budget_main_assetsplit";
	}
	
	@RequestMapping(method = RequestMethod.GET, value = "/budget/budget_create_assetsplit")
	public Object toBudgetGroupAddPage(HttpServletRequest request) throws IOException 
	{
		//request.setAttribute("nd", DateUtil.format(new Date(), DateUtil.FMT_YYYY));
		request.setAttribute("nd", request.getParameter("nd"));
		return "stp/budget/budget_create_assetsplit";
	}
	
	@RequestMapping(method = RequestMethod.GET, value = "/budget/budget_history_compare_assetsplit")
	public Object toBudgetGroupSplitHistoryPage(HttpServletRequest request) throws IOException 
	{
		String nd = request.getParameter("nd");
		request.setAttribute("organCode", request.getParameter("organCode"));
		request.setAttribute("budgetInfoId", request.getParameter("budgetInfoId"));
		request.setAttribute("nd", nd);
		ResponseEntity<?> infors = this.restTemplate.exchange(BUDGET_ASSETSPLIT_TITLES, HttpMethod.POST, new HttpEntity<Object>(nd,this.httpHeaders), List.class);
		request.setAttribute("items", infors.getBody());
		
		infors = this.restTemplate.exchange(BUDGET_ASSETSPLIT_HISTORY_TITLES, HttpMethod.POST, new HttpEntity<Object>(nd,this.httpHeaders), Object.class);
		request.setAttribute("history_items", infors.getBody());
		return "stp/budget/budget_history_compare_assetsplit";
	}
	
	@RequestMapping(method = RequestMethod.GET, value = "/budget/budget_history_view_assetsplit")
	public Object toBudgetGroupSplitHistoryViews(HttpServletRequest request) throws IOException 
	{
		//检索数据
		String nd = request.getParameter("nd");
		request.setAttribute("budgetInfoId", request.getParameter("budgetInfoId"));
		request.setAttribute("nd", nd);
		
		ResponseEntity<?> infors = this.restTemplate.exchange(BUDGET_ASSETSPLIT_HISTORY_TITLES, HttpMethod.POST, new HttpEntity<Object>(nd,this.httpHeaders), Object.class);
		request.setAttribute("history_items", infors.getBody());
		return "stp/budget/budget_history_view_assetsplit";
	}
	@RequestMapping(method = RequestMethod.GET, value = "/budget/budget_detail_assetsplit")
	public Object toBudgetGroupDetail(HttpServletRequest request) throws IOException 
	{
		
		String dataId = request.getParameter("dataId");
		BudgetInfo info = this.restTemplate.exchange(BUDGET_INFO_GET+dataId, HttpMethod.POST, new HttpEntity<Object>(this.httpHeaders), BudgetInfo.class).getBody();
		
		
		ResponseEntity<?> infors = this.restTemplate.exchange(BUDGET_ASSETSPLIT_TITLES, HttpMethod.POST, new HttpEntity<Object>(info.getNd(),this.httpHeaders), List.class);
		request.setAttribute("items", infors.getBody());
		
		request.setAttribute("dataId", request.getParameter("dataId"));
		return "stp/budget/budget_detail_assetsplit";
	}
	@RequestMapping(method = RequestMethod.GET, value = "/budget/budget_detail_assetsplit_nd")
	public Object toBudgetGroupDetailByNd(HttpServletRequest request) throws IOException 
	{
		String nd = request.getParameter("nd");
		if(nd == null) {
			nd = DateUtils.dateToStr(new Date(),"yyyy");
		}
		//找到最新
		BudgetInfo param = new BudgetInfo();
		param.setNd(nd);
		param.setBudgetType(BudgetInfoEnum.ASSET_SPLIT.getCode());
		BudgetInfo rs = this.restTemplate.exchange(BUDGET_FINAL_INFO, HttpMethod.POST, new HttpEntity<Object>(param,this.httpHeaders), BudgetInfo.class).getBody();
		
		ResponseEntity<?> infors = this.restTemplate.exchange(BUDGET_ASSETSPLIT_TITLES, HttpMethod.POST, new HttpEntity<Object>(nd,this.httpHeaders), List.class);
		request.setAttribute("items", infors.getBody());
		
		request.setAttribute("nd", nd);
		request.setAttribute("dataId", rs == null?"0":rs.getDataId());
		return "stp/budget/budget_detail_assetsplit";
	}
	
	@RequestMapping(value = "/budget/budget-assetsplit-info-list", method = RequestMethod.POST)
	@ResponseBody
	public Object getBudgetGroupSplitList(@ModelAttribute("info") BudgetInfo info,HttpServletRequest request) throws IOException 
	{
		ResponseEntity<Object> responseEntity = this.restTemplate.exchange(BUDGET_ASSETSPLIT_LIST, HttpMethod.POST, new HttpEntity<BudgetInfo>(info, this.httpHeaders), Object.class);
		//System.out.println(JSON.toJSON(responseEntity.getBody()).toString());
		return JSON.toJSON(responseEntity.getBody()).toString();
	}
	@RequestMapping(value = "/budget/budget-assetsplit-info-table", method = RequestMethod.POST)
	@ResponseBody
	public Object getBudgetGroupTable(@ModelAttribute("param") LayuiTableParam param,HttpServletRequest request) throws IOException 
	{
		ResponseEntity<Object> responseEntity = this.restTemplate.exchange(BUDGET_ASSETSPLIT_TABLE, HttpMethod.POST, new HttpEntity<LayuiTableParam>(param, this.httpHeaders), Object.class);
		//System.out.println(JSON.toJSON(responseEntity.getBody()).toString());
		return JSON.toJSON(responseEntity.getBody()).toString();
	}
	@RequestMapping(value = "/budget/budget-assetsplit-items", method = RequestMethod.POST)
	@ResponseBody
	public Object getBudgetGroupItems(@ModelAttribute("param") LayuiTableParam param,HttpServletRequest request) throws IOException 
	{
		ResponseEntity<Object> responseEntity = this.restTemplate.exchange(BUDGET_ASSETSPLIT_ITEMS, HttpMethod.POST, new HttpEntity<LayuiTableParam>(param, this.httpHeaders), Object.class);
		System.out.println(JSON.toJSON(responseEntity.getBody()).toString());
		return JSON.toJSON(responseEntity.getBody()).toString();
	}
	@RequestMapping(value = "/budget/budget-assetsplit-create", method = RequestMethod.POST)
	@ResponseBody
	public Object createBudgetGroupInfo(@ModelAttribute("info") BudgetInfo info,HttpServletRequest request) throws IOException 
	{
		info.setCreaterId(this.getUserProfile().getUserId());
		info.setCreaterName(this.getUserProfile().getUserDisp());
		ResponseEntity<Object> responseEntity = this.restTemplate.exchange(BUDGET_ASSETSPLIT_CREATE, HttpMethod.POST, new HttpEntity<BudgetInfo>(info, this.httpHeaders), Object.class);
		//System.out.println(JSON.toJSON(responseEntity.getBody()).toString());
		return JSON.toJSON(responseEntity.getBody()).toString();
	}
	
	@RequestMapping(value = "/budget/budget-assetsplit-del", method = RequestMethod.POST)
	@ResponseBody
	public Object deleteBudgetGroupInfo(@ModelAttribute("info") BudgetInfo info,HttpServletRequest request) throws IOException 
	{
		ResponseEntity<Object> responseEntity = this.restTemplate.exchange(BUDGET_ASSETSPLIT_DELETE, HttpMethod.POST, new HttpEntity<BudgetInfo>(info, this.httpHeaders), Object.class);
		//System.out.println(JSON.toJSON(responseEntity.getBody()).toString());
		return JSON.toJSON(responseEntity.getBody()).toString();
	}
	
	@RequestMapping(value = "/budget/get-assetsplit-item", method = RequestMethod.POST)
	@ResponseBody
	public Object selectBudgetGroupSplitItem(@ModelAttribute("vo") BudgetSplitBaseDataVo vo,HttpServletRequest request) throws IOException 
	{
		ResponseEntity<Object> responseEntity = this.restTemplate.exchange(BUDGET_ASSETSPLIT_GET_ITEM, HttpMethod.POST, new HttpEntity<Object>(vo, this.httpHeaders), Object.class);
		System.out.println(JSON.toJSON(responseEntity.getBody()).toString());
		return JSON.toJSON(responseEntity.getBody()).toString();
	}
	
	@RequestMapping(value = "/budget/get-assetsplit-history-items", method = RequestMethod.POST)
	@ResponseBody
	public Object selectBudgetGroupSplitHistoryItems(@ModelAttribute("vo") BudgetSplitBaseDataVo vo,HttpServletRequest request) throws IOException 
	{
		ResponseEntity<Object> responseEntity = this.restTemplate.exchange(BUDGET_ASSETSPLIT_HISTORY_ITEMS, HttpMethod.POST, new HttpEntity<Object>(vo, this.httpHeaders), Object.class);
		System.out.println(JSON.toJSON(responseEntity.getBody()).toString());
		return JSON.toJSON(responseEntity.getBody()).toString();
	}
	
	
	@RequestMapping(value = "/budget/save-assetsplit-item", method = RequestMethod.POST)
	@ResponseBody
	public Object saveBudgetGroupSplitItem(
			@ModelAttribute("item") String item,
			@ModelAttribute("info") String info,HttpServletRequest request) throws IOException 
	{
		BudgetInfo budget = JSON.toJavaObject(JSON.parseObject(info), BudgetInfo.class);
		Result result = this.restTemplate.exchange(BUDGET_INFO_EDIT_CHECK+budget.getDataId(), HttpMethod.POST, new HttpEntity<Object>(this.httpHeaders), Result.class).getBody();
		if(!result.isSuccess()) {
			return result;
		}
		
		ResponseEntity<Integer> infors = this.restTemplate.exchange(BUDGET_INFO_UPDATE, HttpMethod.POST, new HttpEntity<Object>(budget, this.httpHeaders), Integer.class);
		ResponseEntity<Integer> grouprs = this.restTemplate.exchange(BUDGET_ASSETSPLIT_SAVE_ITEM, HttpMethod.POST, new HttpEntity<Object>(item, this.httpHeaders), Integer.class);
		if (infors.getBody() >= 0 && grouprs.getBody() >= 0) 
		{
			return new Result(true);
		} else {
			return new Result(false);
		}
	}
	@RequestMapping(value = "/budget/save-assetsplit-items", method = RequestMethod.POST)
	@ResponseBody
	public Object saveBudgetGroupSplitItems(
			@ModelAttribute("items") String items,
			@ModelAttribute("info") String info,HttpServletRequest request) throws IOException 
	{
		BudgetInfo budget = JSON.toJavaObject(JSON.parseObject(info), BudgetInfo.class);
		Result result = this.restTemplate.exchange(BUDGET_INFO_EDIT_CHECK+budget.getDataId(), HttpMethod.POST, new HttpEntity<Object>(this.httpHeaders), Result.class).getBody();
		if(!result.isSuccess()) {
			return result;
		}
		
		ResponseEntity<Integer> infors = this.restTemplate.exchange(BUDGET_INFO_UPDATE, HttpMethod.POST, new HttpEntity<Object>(budget, this.httpHeaders), Integer.class);
		ResponseEntity<Integer> grouprs = this.restTemplate.exchange(BUDGET_ASSETSPLIT_SAVE_ITEMS, HttpMethod.POST, new HttpEntity<Object>(items, this.httpHeaders), Integer.class);
		if (infors.getBody() >= 0 && grouprs.getBody() >= 0) 
		{
			return new Result(true);
		} else {
			return new Result(false);
		}
	}
	
	
	@RequestMapping(value = "/budget/start-budget-assetsplit-activity", method = RequestMethod.POST)
	@ResponseBody
	public Object submitBudgetGroupSplit(@RequestParam(value = "budgetInfoId", required = true) String budgetInfoId,
			@RequestParam(value = "functionId", required = true) String functionId,HttpServletRequest request) throws IOException 
	{
		WorkflowVo vo = new WorkflowVo();
		vo.setAuditUserIds(this.getUserProfile().getUserId());
		vo.setFunctionId(functionId);
		vo.setAuthenticatedUserId(this.getUserProfile().getUserId());
		vo.setBusinessId(budgetInfoId);
		vo.setProcessInstanceName("资产预算分解表审批");
		vo.setAuthenticatedUserName(this.getUserProfile().getUserDisp());
		vo.setMessageUserIds(this.getUserProfile().getUserId());
		
		// 待办业务详情、最终审批同意、最终审批不同意路径
		vo.setAuditDetailsPath("/budget/budget_detail_assetsplit?dataId="+budgetInfoId);
		vo.setAuditAgreeMethod("http://pcitc-zuul/stp-proxy/stp-provider/budget/callback-workflow-notice-budgetinfo?budgetId="+budgetInfoId+"&workflow_status="+BudgetAuditStatusEnum.AUDIT_STATUS_PASS.getCode());
		vo.setAuditRejectMethod("http://pcitc-zuul/stp-proxy/stp-provider/budget/callback-workflow-notice-budgetinfo?budgetId="+budgetInfoId+"&workflow_status="+BudgetAuditStatusEnum.AUDIT_STATUS_REFUSE.getCode());
		
		HttpEntity<WorkflowVo> entity = new HttpEntity<WorkflowVo>(vo, this.httpHeaders);
		Result startRs = this.restTemplate.exchange(BUDGET_WORKFLOW_URL + budgetInfoId, HttpMethod.POST, entity, Result.class).getBody();
		return startRs;
	}
	
	@RequestMapping(value = "/budget/search-assetsplit-final-history-list", method = RequestMethod.POST)
	@ResponseBody
	public Object searchBudgetGroupSplitFinalHistoryList(HttpServletRequest request) throws IOException 
	{
		//System.out.println(JSON.toJSONString(info));
		ResponseEntity<?> infors = this.restTemplate.exchange(BUDGET_ASSETSPLIT_FINAL_HISTORY_LIST, HttpMethod.POST, new HttpEntity<Object>(this.httpHeaders), List.class);
		return infors.getBody();
	}
	
	
	@RequestMapping(value = "/budget/select-assetsplit-compare-plan", method = RequestMethod.POST)
	@ResponseBody
	public Object selectBudgetGroupSplitComparePlan(@RequestParam(value="nd",required = false)String nd,@RequestParam(value="code",required = false)String code,HttpServletRequest request) throws IOException 
	{
		System.out.println("plan............"+nd+"------"+code);
		if(nd == null || code == null) {
			return new ArrayList<Object>();
		}
		Map<String,Object> param = new HashMap<String,Object>();
		param.put("nd", nd);
		param.put("code", code);
		//System.out.println(JSON.toJSONString(info));
		ResponseEntity<?> infors = this.restTemplate.exchange(BUDGET_ASSETSPLIT_COMPARE_PLAN, HttpMethod.POST, new HttpEntity<Object>(param,this.httpHeaders), List.class);
		//System.out.println(JSON.toJSONString(infors.getBody()));
		return infors.getBody();
	}
	
	@RequestMapping(value = "/budget/select-assetsplit-compare-project", method = RequestMethod.POST)
	@ResponseBody
	public Object selectBudgetGroupSplitCompareProject(@RequestParam(value="nd",required = false)String nd,@RequestParam(value="code",required = false)String code,HttpServletRequest request) throws IOException 
	{
		System.out.println("plan............"+nd+"------"+code);
		if(nd == null || code == null) {
			return new ArrayList<Object>();
		}
		Map<String,Object> param = new HashMap<String,Object>();
		param.put("nd", nd);
		param.put("code", code);
		//System.out.println(JSON.toJSONString(info));
		ResponseEntity<?> infors = this.restTemplate.exchange(BUDGET_ASSETSPLIT_COMPARE_PROJECT, HttpMethod.POST, new HttpEntity<Object>(param,this.httpHeaders), List.class);
		//System.out.println(JSON.toJSONString(infors.getBody()));
		return infors.getBody();
	}
	
	
	@RequestMapping("/budget/budget_download/assetsplit/{dataId}")
	public void downBudgetGroupSplit(@PathVariable("dataId") String dataId,HttpServletResponse res) throws IOException 
	{
		LayuiTableParam param = new LayuiTableParam();
		param.getParam().put("budget_info_id", dataId);
		param.setLimit(100);
		param.setPage(1);
		System.out.println(JSON.toJSONString(param));
		ResponseEntity<LayuiTableData> responseEntity = this.restTemplate.exchange(BUDGET_ASSETSPLIT_ITEMS, HttpMethod.POST, new HttpEntity<LayuiTableParam>(param, this.httpHeaders), LayuiTableData.class);
		LayuiTableData tabldata = responseEntity.getBody();
		//System.out.println(JSON.toJSONString(tabldata));
		
		ResponseEntity<BudgetInfo> rs = this.restTemplate.exchange(BUDGET_ASSETSPLIT_INFO, HttpMethod.POST, new HttpEntity<String>(dataId, this.httpHeaders), BudgetInfo.class);
		BudgetInfo info = rs.getBody();
		
		Map<String,String> parammap = new HashMap<String,String>();
		parammap.put("nd", info.getNd());
		
		
		URL path = this.getClass().getResource("/");
		File f = new File(path.getPath() + "static/budget/budget_assetsplit_template.xlsx");
		//System.out.println(f.getAbsolutePath());
		//写入新文件2019年集团公司总部科技经费预算
		String newFilePath = path.getPath() + "static/budget/"+info.getNd()+"年资产经费预算明细表（建议稿）_"+DateUtil.dateToStr(new Date(), "yyyyMMddHHmmss")+".xlsx";
		File outFile = new File(newFilePath);
		
		processDataAndDownload(f,tabldata,parammap,outFile);
	    //下载文件
		this.fileDownload(new File(newFilePath), res);
	}
	
	
	
	private XSSFWorkbook workbook;
	private XSSFSheet sheet;
	private void processDataAndDownload(File template,LayuiTableData tableData,Map<String,String> param,File outFile) 
	{
		try {
			InputStream is = new FileInputStream(template);
			workbook = new XSSFWorkbook(is);
			sheet = workbook.getSheetAt(0);
			
			//处理标题 年度
			String title = readCell(sheet.getRow(0).getCell(0));
			sheet.getRow(0).getCell(0).setCellValue(title.replace("${nd}", param.get("nd")));
			//获得标题
			ResponseEntity<?> rs = this.restTemplate.exchange(BUDGET_ASSETSPLIT_TITLES, HttpMethod.POST, new HttpEntity<Object>(param.get("nd"),this.httpHeaders), List.class);
			JSONArray titles = JSON.parseArray(JSON.toJSONString(rs.getBody()));
			
			
			
			this.processExcelTitle(sheet, param, titles);
			//从第六行开始数据
			int c_index = 4;
			for(java.util.Iterator<?> iter = tableData.getData().iterator();iter.hasNext();) 
			{
				//{"budgetType":203,"plan_xq":0.0,"no":1,"ROOT_JFYS_JTDWFL2019_QT_total":0.0,"ROOT_JFYS_JTDWFL2019_JX_xq":5000.0,"total_xq":5000.0,"dataVersion":"vs-2019-203-001","ROOT_JFYS_JTDWFL2019_QT_jz":0.0,"plan_jz":0.0,"ROOT_JFYS_JTDWFL2019_YF_xq":0.0,"ROOT_JFYS_JTDWFL2019_QT_xq":0.0,"organName":"油田处","total":10000.0,"ROOT_JFYS_JTDWFL2019_JX_jz":5000.0,"nd":"2019","organCode":"YTC","ROOT_JFYS_JTDWFL2019_YF_jz":0.0,"budgetInfoId":"169e13840cc_22676aa3","organId":1,"total_jz":5000.0,"ROOT_JFYS_JTDWFL2019_JX_total":10000.0,"plan_total":0.0,"ROOT_JFYS_JTDWFL2019_YF_total":0.0,"budgetTypeName":"预算分解表（集团预算分解）"}
				JSONObject json = JSON.parseObject(JSON.toJSONString(iter.next()));
				//序号，专业处，预算合计，【合计，油服，机械，其他，计划 | 合计，油服，机械，其他，计划】
				Integer no = json.getIntValue("no");
			
				//Integer plan_total = json.getInteger("plan_total");
				Integer total_jz = json.getInteger("total_jz");
				Integer total_xq = json.getInteger("total_xq");
				Integer total = json.getInteger("total");
				String organName = json.getString("organName");
				
				Row row = sheet.getRow(c_index++);
				if(row == null) {row = sheet.createRow(c_index);}
				row.createCell(0).setCellValue(no);
				row.createCell(1).setCellValue(organName);
				row.createCell(2).setCellValue(total);
				row.createCell(3).setCellValue(total_jz);
				row.createCell(4+titles.size()).setCellValue(total_xq);
				for(int i=0;i<titles.size();i++) 
				{
					JSONObject t = JSON.parseObject(titles.getString(i));
					String key = t.keySet().iterator().next();
					row.createCell(i+4).setCellValue(json.getInteger(key+"_jz"));
					row.createCell(titles.size()+5+i).setCellValue(json.getInteger(key+"_xq"));
				}
			}
			
			//指定第三行，第一列单元格为模板
			Row templateRow = sheet.getRow(2);
			CellStyle tCenterStyle =workbook.createCellStyle();
			tCenterStyle.cloneStyleFrom(templateRow.getCell(0).getCellStyle());
			tCenterStyle.setAlignment(HorizontalAlignment.CENTER);
			tCenterStyle.setVerticalAlignment(VerticalAlignment.CENTER);
			
			CellStyle tRightStyle =workbook.createCellStyle();
			tRightStyle.cloneStyleFrom(tCenterStyle);
			tRightStyle.setAlignment(HorizontalAlignment.RIGHT);
			
			CellStyle tLeftStyle =workbook.createCellStyle();
			tLeftStyle.cloneStyleFrom(tCenterStyle);
			tLeftStyle.setAlignment(HorizontalAlignment.LEFT);
			//汇总数据
			for(java.util.Iterator<Row> iter = sheet.iterator();iter.hasNext();) {
				for(java.util.Iterator<Cell> citer = iter.next().iterator();citer.hasNext();) {
					Cell cell = citer.next();
					if(cell.getRowIndex()>=4 && cell.getRowIndex()<21 && cell.getColumnIndex()>=2) {
						Double val = cell.getNumericCellValue();
						//第23行为汇总行
						Double total = sheet.getRow(21).getCell(cell.getColumnIndex()).getNumericCellValue();
						sheet.getRow(21).getCell(cell.getColumnIndex()).setCellValue(total+val);
					}
				}
			}
			//设置格式（默认水平垂直居中）
			for(java.util.Iterator<Row> iter = sheet.iterator();iter.hasNext();) {
				for(java.util.Iterator<Cell> citer = iter.next().iterator();citer.hasNext();) {
					citer.next().setCellStyle(tCenterStyle);
				}
			}
			//单位栏水平居右
			sheet.getRow(1).getCell(0).setCellStyle(tRightStyle);
			//处部门居左,数值居右
			for(java.util.Iterator<Row> iter = sheet.iterator();iter.hasNext();) {
				for(java.util.Iterator<Cell> citer = iter.next().iterator();citer.hasNext();) {
					Cell cell = citer.next();
					if(cell.getRowIndex()>=4 && cell.getColumnIndex()==1) {
						cell.setCellStyle(tLeftStyle);
					}
					if(cell.getRowIndex()>=4 && cell.getColumnIndex()>1) {
						cell.setCellStyle(tRightStyle);
					}
				}
			}
			//合计单元格合并
			sheet.addMergedRegion(new CellRangeAddress(tableData.getData().size()+4,tableData.getData().size()+4,0,1));
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
	
	//处理标题
	private void processExcelTitle(XSSFSheet sheet,Map<String,String> param,JSONArray dis){
		int countcol = 5+dis.size()*2;//序号，处部门，总计，两合计
		for(int i = 0;i<22;i++) {
			for(int j=0;j<countcol;j++) {
				Cell cell = sheet.getRow(i).getCell(j);
				if(cell == null) {
					sheet.getRow(i).createCell(j);
				}
			}
		}
		//第三行第四列和八[5+dis.size]列写入（2018年结转项目经费,2018年新开项目经费)
		Row row2 = sheet.getRow(2);
		row2.createCell(3).setCellValue(param.get("nd")+"年结转项目经费");
		row2.createCell(4+dis.size()).setCellValue(param.get("nd")+"年新开项目经费");
		//第四行
		Row row3 = sheet.getRow(3);
		row3.createCell(3).setCellValue("合计");
		row3.createCell(4+dis.size()).setCellValue("合计");
		for(int i = 0;i<dis.size();i++) {
			JSONObject json = JSON.parseObject(dis.getString(i));
			String key = json.keySet().iterator().next();
			row3.createCell(4+i).setCellValue(json.getString(key));
			row3.createCell(5+dis.size()+i).setCellValue(json.getString(key));
		}
		/**开始合并**/
		//标题行
		sheet.addMergedRegion(new CellRangeAddress(0,0,0,dis.size()*2+4));
		//单位行
		sheet.addMergedRegion(new CellRangeAddress(1,1,0,dis.size()*2+4));
		//序号
		sheet.addMergedRegion(new CellRangeAddress(2,3,0,0));
		//处部门
		sheet.addMergedRegion(new CellRangeAddress(2,3,1,1));
		//预算合计
		sheet.addMergedRegion(new CellRangeAddress(2,3,2,2));
		//第三行合并
		sheet.addMergedRegion(new CellRangeAddress(2,2,3,dis.size()+3));
		sheet.addMergedRegion(new CellRangeAddress(2,2,dis.size()+4,dis.size()*2+4));
	
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
