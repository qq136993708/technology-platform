package com.pcitc.web.controller.budget;

import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URL;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
import com.pcitc.base.common.LayuiTableParam;
import com.pcitc.base.common.Result;
import com.pcitc.base.stp.budget.BudgetGroupTotal;
import com.pcitc.base.stp.budget.BudgetInfo;
import com.pcitc.base.util.DateUtil;
import com.pcitc.base.util.IdUtil;
import com.pcitc.web.common.BaseController;
/**
 * 集团预算总表
 * @author fb
 *
 */
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
	private static final String BUDGET_GROUPTOTAL_HISTORY_ITEMS = "http://pcitc-zuul/stp-proxy/stp-provider/budget/search-grouptotal-history-items";
	
	
	private static final String BUDGET_INFO_UPDATE = "http://pcitc-zuul/stp-proxy/stp-provider/budget/budget-info-update";
	
	
	
	@RequestMapping(method = RequestMethod.GET, value = "/budget/budget_group_page")
	public Object toBudgetGroupPage(HttpServletRequest request) throws IOException 
	{
		return "stp/budget/budget_main_grouptotal";
	}
	@RequestMapping(method = RequestMethod.GET, value = "/budget/budget_edit_grouptotal")
	public Object toBudgetGroupEditPage(HttpServletRequest request) throws IOException 
	{
		String dataId = request.getParameter("dataId");
		request.setAttribute("dataId", dataId==null?IdUtil.createIdByTime():dataId);
		request.setAttribute("budgetInfoId", request.getParameter("budgetInfoId"));
		return "stp/budget/budget_edit_grouptotal";
	}
	@RequestMapping(method = RequestMethod.GET, value = "/budget/budget_create_grouptotal")
	public Object toBudgetGroupAddPage(HttpServletRequest request) throws IOException 
	{
		return "stp/budget/budget_create_grouptotal";
	}
	@RequestMapping(method = RequestMethod.GET, value = "/budget/budget_history_compare_grouptotal")
	public Object toBudgetGroupTotalHistoryPage(HttpServletRequest request) throws IOException 
	{
		request.setAttribute("dataId", request.getParameter("dataId"));
		request.setAttribute("budgetInfoId", request.getParameter("budgetInfoId"));
		return "stp/budget/budget_history_compare_grouptotal";
	}
	
	@RequestMapping(value = "/budget/budget_group_info_list", method = RequestMethod.POST)
	@ResponseBody
	public Object getBudgetGroupList(@ModelAttribute("info") BudgetInfo info,HttpServletRequest request) throws IOException 
	{
		ResponseEntity<Object> responseEntity = this.restTemplate.exchange(BUDGET_GROUPTOTAL_LIST, HttpMethod.POST, new HttpEntity<BudgetInfo>(info, this.httpHeaders), Object.class);
		System.out.println(JSON.toJSON(responseEntity.getBody()).toString());
		return JSON.toJSON(responseEntity.getBody()).toString();
	}
	@RequestMapping(value = "/budget/budget_group_info_table", method = RequestMethod.POST)
	@ResponseBody
	public Object getBudgetGroupTable(@ModelAttribute("param") LayuiTableParam param,HttpServletRequest request) throws IOException 
	{
		ResponseEntity<Object> responseEntity = this.restTemplate.exchange(BUDGET_GROUPTOTAL_TABLE, HttpMethod.POST, new HttpEntity<LayuiTableParam>(param, this.httpHeaders), Object.class);
		System.out.println(JSON.toJSON(responseEntity.getBody()).toString());
		return JSON.toJSON(responseEntity.getBody()).toString();
	}
	@RequestMapping(value = "/budget/budget-grouptotal-items", method = RequestMethod.POST)
	@ResponseBody
	public Object getBudgetGroupItems(@ModelAttribute("param") LayuiTableParam param,HttpServletRequest request) throws IOException 
	{
		ResponseEntity<Object> responseEntity = this.restTemplate.exchange(BUDGET_GROUPTOTAL_ITEMS, HttpMethod.POST, new HttpEntity<LayuiTableParam>(param, this.httpHeaders), Object.class);
		System.out.println(JSON.toJSON(responseEntity.getBody()).toString());
		return JSON.toJSON(responseEntity.getBody()).toString();
	}
	@RequestMapping(value = "/budget/budget-grouptotal-create", method = RequestMethod.POST)
	@ResponseBody
	public Object createBudgetGroupInfo(@ModelAttribute("info") BudgetInfo info,HttpServletRequest request) throws IOException 
	{
		ResponseEntity<Object> responseEntity = this.restTemplate.exchange(BUDGET_GROUPTOTAL_CREATE, HttpMethod.POST, new HttpEntity<BudgetInfo>(info, this.httpHeaders), Object.class);
		System.out.println(JSON.toJSON(responseEntity.getBody()).toString());
		return JSON.toJSON(responseEntity.getBody()).toString();
	}
	
	@RequestMapping(value = "/budget/budget-grouptotal-create-bytemplate", method = RequestMethod.POST)
	@ResponseBody
	public Object createBudgetGroupInfoByTemplate(@ModelAttribute("info") BudgetInfo info,HttpServletRequest request) throws IOException 
	{
		ResponseEntity<Object> responseEntity = this.restTemplate.exchange(BUDGET_GROUPTOTAL_CREATE_BYTEMPLATE, HttpMethod.POST, new HttpEntity<BudgetInfo>(info, this.httpHeaders), Object.class);
		System.out.println(JSON.toJSON(responseEntity.getBody()).toString());
		return JSON.toJSON(responseEntity.getBody()).toString();
	}
	
	@RequestMapping(value = "/budget/budget-grouptotal-del", method = RequestMethod.POST)
	@ResponseBody
	public Object deleteBudgetGroupInfo(@ModelAttribute("info") BudgetInfo info,HttpServletRequest request) throws IOException 
	{
		ResponseEntity<Object> responseEntity = this.restTemplate.exchange(BUDGET_GROUPTOTAL_DELETE, HttpMethod.POST, new HttpEntity<BudgetInfo>(info, this.httpHeaders), Object.class);
		System.out.println(JSON.toJSON(responseEntity.getBody()).toString());
		return JSON.toJSON(responseEntity.getBody()).toString();
	}
	@RequestMapping(value = "/budget/get-grouptotal-item/{dataId}", method = RequestMethod.POST)
	@ResponseBody
	public Object selectBudgetGroupTotalItem(@PathVariable("dataId") String dataId,HttpServletRequest request) throws IOException 
	{
		ResponseEntity<Object> responseEntity = this.restTemplate.exchange(BUDGET_GROUPTOTAL_GET_ITEM+dataId, HttpMethod.POST, new HttpEntity<Object>(dataId, this.httpHeaders), Object.class);
		System.out.println("+++++++++++++++++++item+++++++++++++++++++++");
		System.out.println(JSON.toJSON(responseEntity.getBody()).toString());
		return JSON.toJSON(responseEntity.getBody()).toString();
	}
	@RequestMapping(value = "/budget/save-grouptotal-item", method = RequestMethod.POST)
	@ResponseBody
	public Object saveBudgetGroupTotalItem(@ModelAttribute("item") BudgetGroupTotal item,HttpServletRequest request) throws IOException 
	{
		ResponseEntity<Integer> responseEntity = this.restTemplate.exchange(BUDGET_GROUPTOTAL_SAVE_ITEM, HttpMethod.POST, new HttpEntity<BudgetGroupTotal>(item, this.httpHeaders), Integer.class);
		if (responseEntity.getBody() == 0) {
			return new Result(false);
		} else {
			return new Result(true);
		}
	}
	@RequestMapping(value = "/budget/save-grouptotal-items", method = RequestMethod.POST)
	@ResponseBody
	public Object saveBudgetGroupTotalItems(
			@ModelAttribute("items") String items,
			@ModelAttribute("info") String info,HttpServletRequest request) throws IOException 
	{
		List<BudgetGroupTotal> grouplist = JSON.parseArray(items, BudgetGroupTotal.class);
		BudgetInfo budget = JSON.toJavaObject(JSON.parseObject(info), BudgetInfo.class);
		ResponseEntity<Integer> infors = this.restTemplate.exchange(BUDGET_INFO_UPDATE, HttpMethod.POST, new HttpEntity<Object>(budget, this.httpHeaders), Integer.class);
		ResponseEntity<Integer> grouprs = this.restTemplate.exchange(BUDGET_GROUPTOTAL_SAVE_ITEMS, HttpMethod.POST, new HttpEntity<Object>(grouplist, this.httpHeaders), Integer.class);
		if (infors.getBody() >= 0 && grouprs.getBody() >= 0) 
		{
			return new Result(true);
		} else {
			return new Result(false);
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
			return new Result(false);
		} else {
			return new Result(true);
		}
	}
	
	@RequestMapping(value = "/budget/search-group-company-items", method = RequestMethod.POST)
	@ResponseBody
	public Object searchBudgetGroupCompany(HttpServletRequest request) throws IOException 
	{
		ResponseEntity<?> responseEntity = this.restTemplate.exchange(BUDGET_GROUPTOTAL_COMPANY_ITEMS, HttpMethod.POST, new HttpEntity<Object>(this.httpHeaders), List.class);
		return responseEntity.getBody();
	}
	@RequestMapping(value = "/budget/del-group-item/{dataId}", method = RequestMethod.POST)
	@ResponseBody
	public Object deleteBudgetGroupItem(@PathVariable("dataId") String dataId,HttpServletRequest request) throws IOException 
	{
		ResponseEntity<Integer> responseEntity = this.restTemplate.exchange(BUDGET_GROUPTOTAL_DEL_ITEMS+dataId, HttpMethod.POST, new HttpEntity<Object>(this.httpHeaders), Integer.class);
		if (responseEntity.getBody() == 0) {
			return new Result(false);
		} else {
			return new Result(true);
		}
	}
	@RequestMapping(value = "/budget/submit-grouptotal", method = RequestMethod.POST)
	@ResponseBody
	public Object submitBudgetGroupTotal(@ModelAttribute("info") BudgetInfo info,HttpServletRequest request) throws IOException 
	{
		System.out.println(JSON.toJSONString(info));
		info.setUpdateTime(DateUtil.format(new Date(), DateUtil.FMT_SS));
		info.setAuditStatus(1);//审批状态
		ResponseEntity<Integer> infors = this.restTemplate.exchange(BUDGET_INFO_UPDATE, HttpMethod.POST, new HttpEntity<Object>(info, this.httpHeaders), Integer.class);
		
		if (infors.getBody() >= 0) {
			return new Result(true);
		} else {
			return new Result(false);
		}
	}
	@RequestMapping(value = "/budget/search-grouptotal-history-items", method = RequestMethod.POST)
	@ResponseBody
	public Object searchBudgetGroupTotalHistoryItems(@ModelAttribute("info") BudgetGroupTotal info,HttpServletRequest request) throws IOException 
	{
		System.out.println("++++++++++++++++");
		System.out.println(JSON.toJSONString(info));
		ResponseEntity<?> infors = this.restTemplate.exchange(BUDGET_GROUPTOTAL_HISTORY_ITEMS, HttpMethod.POST, new HttpEntity<Object>(info, this.httpHeaders), List.class);
		return infors.getBody();
	}
	
	@RequestMapping("/budget/budget_download/grouptotal/{dataId}")
	public void downBudgetGroupTotal(@PathVariable("dataId") String dataId,HttpServletResponse res) throws IOException {
		
		Map<String, Object> beanMap = new HashMap<String,Object>();//MyBeanUtils.transBean2Map(oldApply);
		
		
		URL path = this.getClass().getResource("/");
		File f = new File(path.getPath() + "static/budget/budget_grouptotal_template.xlsx");

		
		//写入新文件
		String newFilePath = path.getPath() + "static/budget/budget_grouptotal_"+System.currentTimeMillis()+".xlsx";
		File outFile = new File(newFilePath);
		   
		processDataAndDownload(f,beanMap,outFile);
	    //下载文件
		this.fileDownload(new File(newFilePath), res);
	}
	
	private XSSFWorkbook workbook;
	private void processDataAndDownload(File template,Map<String,Object> beanMap,File outFile) 
	{
		try {
			InputStream is = new FileInputStream(template);
			workbook = new XSSFWorkbook(is);
			/*List<IBodyElement> bodyElements = docx.getBodyElements();// 所有对象（段落+表格）
			for (IBodyElement body : bodyElements) {
				if (BodyElementType.TABLE.equals(body.getElementType())) {
					List<XWPFTable> tables = body.getBody().getTables();
					for (XWPFTable table : tables) {
						for (XWPFTableRow row : table.getRows()) {
							for (XWPFTableCell cell : row.getTableCells()) {
								replaseText(beanMap,cell);
							}
						}
					}
				}
			}*/
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
        res.setHeader("content-type", "application/octet-stream");
        res.setContentType("application/octet-stream");
        res.setHeader("Content-Disposition", "attachment;filename=" + file.getName());
     
        OutputStream out = null;
        InputStream in = null;
        try 
        {
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
}
