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
import com.pcitc.base.util.MyBeanUtils;
import com.pcitc.base.workflow.WorkflowVo;
import com.pcitc.web.common.BaseController;
/**
 *  股份预算分解表
 * @author fb
 *
 */
@Controller
public class BudgetStockSplitZgsController extends BaseController {

	private static final String BUDGET_STOCKSPLIT_TABLE = "http://pcitc-zuul/stp-proxy/stp-provider/budget/budget-stocksplit-zgs-info-table";
	private static final String BUDGET_STOCKSPLIT_LIST = "http://pcitc-zuul/stp-proxy/stp-provider/budget/budget-stocksplit-zgs-info-list";	
	private static final String BUDGET_STOCKSPLIT_INFO = "http://pcitc-zuul/stp-proxy/stp-provider/budget/budget-stocksplit-zgs-info";	
	private static final String BUDGET_STOCKSPLIT_ITEMS = "http://pcitc-zuul/stp-proxy/stp-provider/budget/budget-stocksplit-zgs-items";
	
	private static final String BUDGET_STOCKSPLIT_TITLES = "http://pcitc-zuul/stp-proxy/stp-provider/budget/budget-stocksplit-zgs-titles";
	private static final String BUDGET_STOCKSPLIT_HISTORY_TITLES = "http://pcitc-zuul/stp-proxy/stp-provider/budget/budget-stocksplit-zgs-history-titles";
	private static final String BUDGET_STOCKSPLIT_DELETE = "http://pcitc-zuul/stp-proxy/stp-provider/budget/budget-stocksplit-zgs-del";
	private static final String BUDGET_STOCKSPLIT_GET_ITEM = "http://pcitc-zuul/stp-proxy/stp-provider/budget/get-stocksplit-zgs-item";
	private static final String BUDGET_STOCKSPLIT_SAVE_ITEMS = "http://pcitc-zuul/stp-proxy/stp-provider/budget/save-stocksplit-zgs-items";
	private static final String BUDGET_STOCKSPLIT_SAVE_ITEM = "http://pcitc-zuul/stp-proxy/stp-provider/budget/save-stocksplit-zgs-item";
	private static final String BUDGET_STOCKSPLIT_HISTORY_ITEMS = "http://pcitc-zuul/stp-proxy/stp-provider/budget/get-stocksplit-zgs-history-items";
	
	private static final String BUDGET_STOCKSPLIT_CREATE = "http://pcitc-zuul/stp-proxy/stp-provider/budget/budget-create-blank-stocksplit-zgs";
	private static final String BUDGET_STOCKSPLIT_FINAL_HISTORY_LIST = "http://pcitc-zuul/stp-proxy/stp-provider/budget/search-stocksplit-zgs-final-history-list";
	private static final String BUDGET_STOCKSPLIT_COMPARE_PLAN = "http://pcitc-zuul/stp-proxy/stp-provider/budget/select-stocksplit-zgs-compare-plan";
	private static final String BUDGET_STOCKSPLIT_COMPARE_PROJECT = "http://pcitc-zuul/stp-proxy/stp-provider/budget/select-stocksplit-zgs-compare-project";
	
	private static final String BUDGET_INFO_UPDATE = "http://pcitc-zuul/stp-proxy/stp-provider/budget/budget-info-update";
	private static final String BUDGET_INFO_GET = "http://pcitc-zuul/stp-proxy/stp-provider/budget/budget-info-get/";
	private static final String PROJECT_NOTICE_WORKFLOW_URL = "http://pcitc-zuul/stp-proxy/stp-provider/budget/start-budget-stocksplit-zgs-activity/";
	private static final String BUDGET_FINAL_INFO = "http://pcitc-zuul/stp-proxy/stp-provider/budget/get-final-budget";
	
	
	@RequestMapping(method = RequestMethod.GET, value = "/budget/budget_main_stocksplit_zgs")
	public Object toBudgetStockPage(HttpServletRequest request) throws IOException 
	{
		String nd = request.getParameter("nd")==null?DateUtil.format(new Date(), DateUtil.FMT_YYYY):request.getParameter("nd");
		request.setAttribute("nd", nd);
		ResponseEntity<?> infors = this.restTemplate.exchange(BUDGET_STOCKSPLIT_TITLES, HttpMethod.POST, new HttpEntity<Object>(nd,this.httpHeaders), List.class);
		request.setAttribute("items", infors.getBody());
		return "stp/budget/budget_main_stocksplit_zgs";
	}
	
	@RequestMapping(method = RequestMethod.GET, value = "/budget/budget_create_stocksplit_zgs")
	public Object toBudgetStockAddPage(HttpServletRequest request) throws IOException 
	{
		//request.setAttribute("nd", DateUtil.format(new Date(), DateUtil.FMT_YYYY));
		request.setAttribute("nd", request.getParameter("nd"));
		return "stp/budget/budget_create_stocksplit_zgs";
	}
	
	@RequestMapping(method = RequestMethod.GET, value = "/budget/budget_history_compare_stocksplit_zgs")
	public Object toBudgetStockSplitHistoryPage(HttpServletRequest request) throws IOException 
	{
		String nd = request.getParameter("nd");
		request.setAttribute("organCode", request.getParameter("organCode"));
		request.setAttribute("budgetInfoId", request.getParameter("budgetInfoId"));
		request.setAttribute("nd", nd);
		ResponseEntity<?> infors = this.restTemplate.exchange(BUDGET_STOCKSPLIT_TITLES, HttpMethod.POST, new HttpEntity<Object>(nd,this.httpHeaders), List.class);
		request.setAttribute("items", infors.getBody());
		
		infors = this.restTemplate.exchange(BUDGET_STOCKSPLIT_HISTORY_TITLES, HttpMethod.POST, new HttpEntity<Object>(nd,this.httpHeaders), Object.class);
		request.setAttribute("history_items", infors.getBody());
		return "stp/budget/budget_history_compare_stocksplit_zgs";
	}
	
	@RequestMapping(method = RequestMethod.GET, value = "/budget/budget_history_view_stocksplit_zgs")
	public Object toBudgetStockSplitHistoryViews(HttpServletRequest request) throws IOException 
	{
		//检索数据
		String nd = request.getParameter("nd");
		request.setAttribute("budgetInfoId", request.getParameter("budgetInfoId"));
		request.setAttribute("nd", nd);
		
		ResponseEntity<?> infors = this.restTemplate.exchange(BUDGET_STOCKSPLIT_HISTORY_TITLES, HttpMethod.POST, new HttpEntity<Object>(nd,this.httpHeaders), Object.class);
		request.setAttribute("history_items", infors.getBody());
		return "stp/budget/budget_history_view_stocksplit_zgs";
	}
	@RequestMapping(method = RequestMethod.GET, value = "/budget/budget_detail_stocksplitzgs")
	public Object toBudgetStockDetail(HttpServletRequest request) throws IOException 
	{
		String nd = request.getParameter("nd")==null?DateUtil.format(new Date(), DateUtil.FMT_YYYY):request.getParameter("nd");
		request.setAttribute("nd", nd);
		ResponseEntity<?> infors = this.restTemplate.exchange(BUDGET_STOCKSPLIT_TITLES, HttpMethod.POST, new HttpEntity<Object>(nd,this.httpHeaders), List.class);
		request.setAttribute("items", infors.getBody());
		
		request.setAttribute("dataId", request.getParameter("dataId"));
		return "stp/budget/budget_detail_stocksplitzgs";
	}
	@RequestMapping(method = RequestMethod.GET, value = "/budget/budget_detail_stocksplitzgs_nd")
	public Object toBudgetStockDetailByNd(HttpServletRequest request) throws IOException 
	{
		String nd = request.getParameter("nd");
		if(nd == null) {
			nd = DateUtils.dateToStr(new Date(),"yyyy");
		}
		BudgetInfo param = new BudgetInfo();
		param.setNd(nd);
		param.setBudgetType(BudgetInfoEnum.STOCK_ZGS_SPLIT.getCode());
		BudgetInfo rs = this.restTemplate.exchange(BUDGET_FINAL_INFO, HttpMethod.POST, new HttpEntity<Object>(param,this.httpHeaders), BudgetInfo.class).getBody();
		
		ResponseEntity<?> infors = this.restTemplate.exchange(BUDGET_STOCKSPLIT_TITLES, HttpMethod.POST, new HttpEntity<Object>(nd,this.httpHeaders), List.class);
		request.setAttribute("items", infors.getBody());
		
		request.setAttribute("nd", nd);
		request.setAttribute("dataId", rs == null?"0":rs.getDataId());
		return "stp/budget/budget_detail_stocksplitzgs";
	}
	@RequestMapping(value = "/budget/budget-stocksplit-zgs-info-list", method = RequestMethod.POST)
	@ResponseBody
	public Object getBudgetStockSplitList(@ModelAttribute("info") BudgetInfo info,HttpServletRequest request) throws IOException 
	{
		ResponseEntity<Object> responseEntity = this.restTemplate.exchange(BUDGET_STOCKSPLIT_LIST, HttpMethod.POST, new HttpEntity<BudgetInfo>(info, this.httpHeaders), Object.class);
		//System.out.println(JSON.toJSON(responseEntity.getBody()).toString());
		return JSON.toJSON(responseEntity.getBody()).toString();
	}
	@RequestMapping(value = "/budget/budget-stocksplit-zgs-info-table", method = RequestMethod.POST)
	@ResponseBody
	public Object getBudgetStockTable(@ModelAttribute("param") LayuiTableParam param,HttpServletRequest request) throws IOException 
	{
		ResponseEntity<Object> responseEntity = this.restTemplate.exchange(BUDGET_STOCKSPLIT_TABLE, HttpMethod.POST, new HttpEntity<LayuiTableParam>(param, this.httpHeaders), Object.class);
		//System.out.println(JSON.toJSON(responseEntity.getBody()).toString());
		return JSON.toJSON(responseEntity.getBody()).toString();
	}
	@RequestMapping(value = "/budget/budget-stocksplit-zgs-items", method = RequestMethod.POST)
	@ResponseBody
	public Object getBudgetStockItems(@ModelAttribute("param") LayuiTableParam param,HttpServletRequest request) throws IOException 
	{
		ResponseEntity<Object> responseEntity = this.restTemplate.exchange(BUDGET_STOCKSPLIT_ITEMS, HttpMethod.POST, new HttpEntity<LayuiTableParam>(param, this.httpHeaders), Object.class);
		System.out.println(JSON.toJSON(responseEntity.getBody()).toString());
		return JSON.toJSON(responseEntity.getBody()).toString();
	}
	@RequestMapping(value = "/budget/budget-stocksplit-zgs-create", method = RequestMethod.POST)
	@ResponseBody
	public Object createBudgetStockInfo(@ModelAttribute("info") BudgetInfo info,HttpServletRequest request) throws IOException 
	{
		info.setCreaterId(this.getUserProfile().getUserId());
		info.setCreaterName(this.getUserProfile().getUserDisp());
		ResponseEntity<Object> responseEntity = this.restTemplate.exchange(BUDGET_STOCKSPLIT_CREATE, HttpMethod.POST, new HttpEntity<BudgetInfo>(info, this.httpHeaders), Object.class);
		//System.out.println(JSON.toJSON(responseEntity.getBody()).toString());
		return JSON.toJSON(responseEntity.getBody()).toString();
	}
	
	@RequestMapping(value = "/budget/budget-stocksplit-zgs-del", method = RequestMethod.POST)
	@ResponseBody
	public Object deleteBudgetStockInfo(@ModelAttribute("info") BudgetInfo info,HttpServletRequest request) throws IOException 
	{
		ResponseEntity<Object> responseEntity = this.restTemplate.exchange(BUDGET_STOCKSPLIT_DELETE, HttpMethod.POST, new HttpEntity<BudgetInfo>(info, this.httpHeaders), Object.class);
		//System.out.println(JSON.toJSON(responseEntity.getBody()).toString());
		return JSON.toJSON(responseEntity.getBody()).toString();
	}
	
	@RequestMapping(value = "/budget/get-stocksplit-zgs-item", method = RequestMethod.POST)
	@ResponseBody
	public Object selectBudgetStockSplitItem(@ModelAttribute("vo") BudgetSplitBaseDataVo vo,HttpServletRequest request) throws IOException 
	{
		ResponseEntity<Object> responseEntity = this.restTemplate.exchange(BUDGET_STOCKSPLIT_GET_ITEM, HttpMethod.POST, new HttpEntity<Object>(vo, this.httpHeaders), Object.class);
		System.out.println(JSON.toJSON(responseEntity.getBody()).toString());
		return JSON.toJSON(responseEntity.getBody()).toString();
	}
	
	@RequestMapping(value = "/budget/get-stocksplit-zgs-history-items", method = RequestMethod.POST)
	@ResponseBody
	public Object selectBudgetStockSplitHistoryItems(@ModelAttribute("vo") BudgetSplitBaseDataVo vo,HttpServletRequest request) throws IOException 
	{
		ResponseEntity<Object> responseEntity = this.restTemplate.exchange(BUDGET_STOCKSPLIT_HISTORY_ITEMS, HttpMethod.POST, new HttpEntity<Object>(vo, this.httpHeaders), Object.class);
		System.out.println(JSON.toJSON(responseEntity.getBody()).toString());
		return JSON.toJSON(responseEntity.getBody()).toString();
	}
	
	
	@RequestMapping(value = "/budget/save-stocksplit-zgs-item", method = RequestMethod.POST)
	@ResponseBody
	public Object saveBudgetStockSplitItem(@RequestParam("item") String item,HttpServletRequest request) throws IOException 
	{
		ResponseEntity<Integer> grouprs = this.restTemplate.exchange(BUDGET_STOCKSPLIT_SAVE_ITEM, HttpMethod.POST, new HttpEntity<Object>(item, this.httpHeaders), Integer.class);
		if (grouprs.getBody() >= 0) 
		{
			return new Result(true);
		} else {
			return new Result(false);
		}
	}
	@RequestMapping(value = "/budget/save-stocksplit-zgs-items", method = RequestMethod.POST)
	@ResponseBody
	public Object saveBudgetStockSplitItems(
			@ModelAttribute("items") String items,
			@ModelAttribute("info") String info,HttpServletRequest request) throws IOException 
	{
		BudgetInfo budget = JSON.toJavaObject(JSON.parseObject(info), BudgetInfo.class);
		ResponseEntity<Integer> infors = this.restTemplate.exchange(BUDGET_INFO_UPDATE, HttpMethod.POST, new HttpEntity<Object>(budget, this.httpHeaders), Integer.class);
		ResponseEntity<Integer> grouprs = this.restTemplate.exchange(BUDGET_STOCKSPLIT_SAVE_ITEMS, HttpMethod.POST, new HttpEntity<Object>(items, this.httpHeaders), Integer.class);
		if (infors.getBody() >= 0 && grouprs.getBody() >= 0) 
		{
			return new Result(true);
		} else {
			return new Result(false);
		}
	}
	
	
	@RequestMapping(value = "/budget/start-budget-stocksplit-zgs-activity", method = RequestMethod.POST)
	@ResponseBody
	public Object submitBudgetStockSplit(@RequestParam(value = "budgetInfoId", required = true) String budgetInfoId,
			@RequestParam(value = "functionId", required = true) String functionId,HttpServletRequest request) throws IOException 
	{
		System.out.println("start-budget-stocksplit-zgs-activity-----------------");
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
	
	@RequestMapping(value = "/budget/search-stocksplit-zgs-final-history-list", method = RequestMethod.POST)
	@ResponseBody
	public Object searchBudgetStockSplitFinalHistoryList(HttpServletRequest request) throws IOException 
	{
		//System.out.println(JSON.toJSONString(info));
		ResponseEntity<?> infors = this.restTemplate.exchange(BUDGET_STOCKSPLIT_FINAL_HISTORY_LIST, HttpMethod.POST, new HttpEntity<Object>(this.httpHeaders), List.class);
		return infors.getBody();
	}
	
	
	@RequestMapping(value = "/budget/select-stocksplit-zgs-compare-plan", method = RequestMethod.POST)
	@ResponseBody
	public Object selectBudgetStockSplitComparePlan(@RequestParam(value="nd",required = false)String nd,@RequestParam(value="code",required = false)String code,HttpServletRequest request) throws IOException 
	{
		System.out.println("plan............"+nd+"------"+code);
		if(nd == null || code == null) {
			return new ArrayList<Object>();
		}
		Map<String,Object> param = new HashMap<String,Object>();
		param.put("nd", nd);
		param.put("code", code);
		//System.out.println(JSON.toJSONString(info));
		ResponseEntity<?> infors = this.restTemplate.exchange(BUDGET_STOCKSPLIT_COMPARE_PLAN, HttpMethod.POST, new HttpEntity<Object>(param,this.httpHeaders), List.class);
		//System.out.println(JSON.toJSONString(infors.getBody()));
		return infors.getBody();
	}
	
	@RequestMapping(value = "/budget/select-stocksplit-zgs-compare-project", method = RequestMethod.POST)
	@ResponseBody
	public Object selectBudgetStockSplitCompareProject(@RequestParam(value="nd",required = false)String nd,@RequestParam(value="code",required = false)String code,HttpServletRequest request) throws IOException 
	{
		System.out.println("plan............"+nd+"------"+code);
		if(nd == null || code == null) {
			return new ArrayList<Object>();
		}
		Map<String,Object> param = new HashMap<String,Object>();
		param.put("nd", nd);
		param.put("code", code);
		//System.out.println(JSON.toJSONString(info));
		ResponseEntity<?> infors = this.restTemplate.exchange(BUDGET_STOCKSPLIT_COMPARE_PROJECT, HttpMethod.POST, new HttpEntity<Object>(param,this.httpHeaders), List.class);
		//System.out.println(JSON.toJSONString(infors.getBody()));
		return infors.getBody();
	}
	
	
	@RequestMapping("/budget/budget_download/stocksplit-zgs/{dataId}")
	public void downBudgetStockSplit(@PathVariable("dataId") String dataId,HttpServletResponse res) throws IOException 
	{
		LayuiTableParam param = new LayuiTableParam();
		param.getParam().put("budget_info_id", dataId);
		param.setLimit(100);
		param.setPage(1);
		
		ResponseEntity<LayuiTableData> responseEntity = this.restTemplate.exchange(BUDGET_STOCKSPLIT_ITEMS, HttpMethod.POST, new HttpEntity<LayuiTableParam>(param, this.httpHeaders), LayuiTableData.class);
		LayuiTableData tabldata = responseEntity.getBody();
		//System.out.println(JSON.toJSONString(tabldata));
		
		ResponseEntity<BudgetInfo> rs = this.restTemplate.exchange(BUDGET_STOCKSPLIT_INFO, HttpMethod.POST, new HttpEntity<String>(dataId, this.httpHeaders), BudgetInfo.class);
		BudgetInfo info = rs.getBody();
		
		Map<String,String> parammap = new HashMap<String,String>();
		parammap.put("nd", info.getNd());
		
		
		URL path = this.getClass().getResource("/");
		File f = new File(path.getPath() + "static/budget/budget_stocksplit_zgs_template.xlsx");
		//System.out.println(f.getAbsolutePath());
		//写入新文件2019年集团公司总部科技经费预算
		String newFilePath = path.getPath() + "static/budget/"+info.getNd()+"年股份付分子公司经费预算表（建议稿）_"+DateUtil.dateToStr(new Date(), "yyyyMMddHHmmss")+".xlsx";
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
			Cell c1 = sheet.getRow(0).getCell(0);
			c1.setCellValue(c1.getStringCellValue().replace("${nd}", param.get("nd")));
			
			//获得标题
			ResponseEntity<?> rs = this.restTemplate.exchange(BUDGET_STOCKSPLIT_TITLES, HttpMethod.POST, new HttpEntity<Object>(param.get("nd"),this.httpHeaders), List.class);
			JSONArray titles = JSON.parseArray(JSON.toJSONString(rs.getBody()));
			//生成模板
			this.processExcelTitle(sheet, param, titles);
			//从第四行开始数据
			int c_index = 4;
			for(java.util.Iterator<?> iter = tableData.getData().iterator();iter.hasNext();) 
			{
				JSONObject json = JSON.parseObject(JSON.toJSONString(iter.next()));
				//序号，专业处，预算合计，【勘探院，工程院，....】
				Integer no = json.getIntValue("no");
			
				//Integer total_xq = json.getInteger("total_xq");
				//Integer total_jz = json.getInteger("total_jz");
				//Integer total = json.getInteger("total");
				String organName = json.getString("organName");
				
				Row row = sheet.getRow(c_index++);
				if(row == null) {row = sheet.createRow(c_index);}
				row.createCell(0).setCellValue(no);
				row.createCell(1).setCellValue(organName);
				
				for(int i=0;i<titles.size();i++) 
				{
					JSONObject t = JSON.parseObject(titles.getString(i));
					String key = t.keySet().iterator().next();
					row.createCell(i*3+2).setCellValue(json.getInteger(key+"_total"));
					row.createCell(i*3+3).setCellValue(json.getInteger(key+"_jz"));
					row.createCell(i*3+4).setCellValue(json.getInteger(key+"_xq"));
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
			//汇总求和数据
			for(java.util.Iterator<Row> iter = sheet.iterator();iter.hasNext();) {
				for(java.util.Iterator<Cell> citer = iter.next().iterator();citer.hasNext();) {
					Cell cell = citer.next();
					if(cell.getRowIndex()>=5 && cell.getRowIndex()<21 && cell.getColumnIndex()>=2) {
						Double val = cell.getNumericCellValue();
						//列汇总，第23行为汇总行
						Double total = sheet.getRow(21).getCell(cell.getColumnIndex()).getNumericCellValue();
						sheet.getRow(21).getCell(cell.getColumnIndex()).setCellValue(total+val);
					}
				}
			}
			//设置格式
			for(java.util.Iterator<Row> iter = sheet.iterator();iter.hasNext();) {
				for(java.util.Iterator<Cell> citer = iter.next().iterator();citer.hasNext();) {
					Cell cell = citer.next();
					//设置格式（默认水平垂直居中）
					cell.setCellStyle(tCenterStyle);
					//处部门居左
					if(cell.getRowIndex()>=4 && cell.getColumnIndex()==1) {
						cell.setCellStyle(tLeftStyle);
					}
					//数值居右(合计除外)
					if(cell.getRowIndex()>=4 && cell.getColumnIndex()>=2) {
						cell.setCellStyle(tRightStyle);
					}
				}
			}
			//单位栏水平居右
			sheet.getRow(1).getCell(0).setCellStyle(tRightStyle);
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
	private void processExcelTitle(XSSFSheet sheet,Map<String,String> param,JSONArray titles){
		int countcol = 2+titles.size()*3;//序号，处部门，XXX
		for(int i = 0;i<22;i++) {
			for(int j=0;j<countcol;j++) {
				Cell cell = sheet.getRow(i).getCell(j);
				if(cell == null) {
					sheet.getRow(i).createCell(j);
				}
			}
		}
		//第三行标题
		//第四行（预算，结转，可新签）
		Row row2 = sheet.getRow(2);
		Row row3 = sheet.getRow(3);
		for(int i = 0;i<titles.size();i++) {
			JSONObject json = JSON.parseObject(titles.getString(i));
			String key = json.keySet().iterator().next();
			row2.createCell(2+i*3).setCellValue(json.getString(key));
			
			row3.createCell(2+i*3).setCellValue("预算");
			row3.createCell(3+i*3).setCellValue("老合同");
			row3.createCell(4+i*3).setCellValue("可新签");
		}
		/**开始合并**/
		//标题行
		sheet.addMergedRegion(new CellRangeAddress(0,0,0,titles.size()*3+1));
		//单位行
		sheet.addMergedRegion(new CellRangeAddress(1,1,0,titles.size()*3+1));
		//序号
		sheet.addMergedRegion(new CellRangeAddress(2,3,0,0));
		//专业处
		sheet.addMergedRegion(new CellRangeAddress(2,3,1,1));
		//标题行
		for(int i = 0;i<titles.size();i++) {
			sheet.addMergedRegion(new CellRangeAddress(2,2,i*3+2,i*3+4));
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
	public String readCell(Cell cell) 
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
