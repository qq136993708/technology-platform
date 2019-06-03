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
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.pcitc.base.stp.budget.BudgetInfo;
import com.pcitc.base.util.DateUtil;
import com.pcitc.web.common.BaseController;
/**
 * 预算总表
 * @author fb
 *
 */
@Controller
public class BudgetTotalSplitController extends BaseController {

	private static final String PROJECT_TOTAL_FINAL_GROUP = "http://pcitc-zuul/stp-proxy/stp-provider/budget/get-final-groupsplit";
	private static final String PROJECT_TOTAL_FINAL_ASSET = "http://pcitc-zuul/stp-proxy/stp-provider/budget/get-final-assetsplit";
	private static final String PROJECT_TOTAL_FINAL_STOCK = "http://pcitc-zuul/stp-proxy/stp-provider/budget/get-final-stocksplit";
	
	@RequestMapping(method = RequestMethod.GET, value = "/budget/budget_main_totalsplit")
	public Object toBudgetPage(HttpServletRequest request) throws IOException 
	{
		
		String nd = request.getParameter("nd");
		if(nd == null) {
			nd = DateUtil.format(DateUtil.getNextYearDay(new Date()), DateUtil.FMT_YYYY);
		}
		request.setAttribute("nd", nd);
		return "stp/budget/budget_main_totalsplit";
	}
	
	@RequestMapping(value = "/budget/get-final-groupsplit", method = RequestMethod.POST)
	@ResponseBody
	public Object getFinalBudgetGroupAssetStockList(@ModelAttribute("info") BudgetInfo info,HttpServletRequest request) throws IOException 
	{
		ResponseEntity<Object> responseEntity = this.restTemplate.exchange(PROJECT_TOTAL_FINAL_GROUP, HttpMethod.POST, new HttpEntity<String>(info.getNd(), this.httpHeaders), Object.class);
		return JSON.toJSON(responseEntity.getBody()).toString();
	}
	
	@RequestMapping(value = "/budget/get-final-assetsplit", method = RequestMethod.POST)
	@ResponseBody
	public Object getFinalBudgetAssetAssetStockList(@ModelAttribute("info") BudgetInfo info,HttpServletRequest request) throws IOException 
	{
		ResponseEntity<Object> responseEntity = this.restTemplate.exchange(PROJECT_TOTAL_FINAL_ASSET, HttpMethod.POST, new HttpEntity<String>(info.getNd(), this.httpHeaders), Object.class);
		return JSON.toJSON(responseEntity.getBody()).toString();
	}
	
	@RequestMapping(value = "/budget/get-final-stocksplit", method = RequestMethod.POST)
	@ResponseBody
	public Object getFinalBudgetStockAssetStockList(@ModelAttribute("info") BudgetInfo info,HttpServletRequest request) throws IOException 
	{
		ResponseEntity<Object> responseEntity = this.restTemplate.exchange(PROJECT_TOTAL_FINAL_STOCK, HttpMethod.POST, new HttpEntity<String>(info.getNd(), this.httpHeaders), Object.class);
		return JSON.toJSON(responseEntity.getBody()).toString();
	}
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	@RequestMapping("/budget/budget_download/totalsplit/{nd}")
	public void downBudgetTotal(@PathVariable("nd") String nd,HttpServletResponse res) throws IOException 
	{
		List<Map<String,Object>> data = new ArrayList<Map<String,Object>>();
		
		
		ResponseEntity<List> responseEntity = this.restTemplate.exchange(PROJECT_TOTAL_FINAL_STOCK, HttpMethod.POST, new HttpEntity<String>(nd, this.httpHeaders), List.class);
		List<Map<String,Object>> array = responseEntity.getBody();
		for(java.util.Iterator<?> iter = array.iterator();iter.hasNext();) {
			JSONObject json = JSON.parseObject(JSON.toJSONString(iter.next()));
			data.add(JSON.toJavaObject(json, Map.class));
		}
		responseEntity = this.restTemplate.exchange(PROJECT_TOTAL_FINAL_GROUP, HttpMethod.POST, new HttpEntity<String>(nd, this.httpHeaders), List.class);
		array = responseEntity.getBody();
		for(int i = 0;i<array.size();i++) {
			data.get(i).putAll(array.get(i));
		}
		
		responseEntity = this.restTemplate.exchange(PROJECT_TOTAL_FINAL_ASSET, HttpMethod.POST, new HttpEntity<String>(nd, this.httpHeaders), List.class);
		array = responseEntity.getBody();
		for(int i = 0;i<array.size();i++) {
			data.get(i).putAll(array.get(i));
		}
		
		URL path = this.getClass().getResource("/");
		File f = new File(path.getPath() + "static/budget/budget_totalsplit_template.xlsx");
		System.out.println(JSON.toJSONString(data));
		//写入新文件2019年集团公司总部科技经费预算
		String newFilePath = path.getPath() + "static/budget/"+nd+"年各处、部门科技经费预算总表（建议稿）_"+DateUtil.dateToStr(new Date(), "yyyyMMddHHmmss")+".xlsx";
		File outFile = new File(newFilePath);
		
		processDataAndDownload(f,new ArrayList(data),nd,outFile);
	    //下载文件
		this.fileDownload(new File(newFilePath), res);
	}
	
	
	
	private XSSFWorkbook workbook;
	private XSSFSheet sheet;
	private void processDataAndDownload(File template,List<Map<String,Object>> list,String ndStr,File outFile) 
	{
		try {
			InputStream is = new FileInputStream(template);
			workbook = new XSSFWorkbook(is);
			sheet = workbook.getSheetAt(0);
			
			//处理标题 年度
			String title = readCell(sheet.getRow(0).getCell(0));
			sheet.getRow(0).getCell(0).setCellValue(title.replace("${nd}", ndStr));
			
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
			
			
			for(int i = 0;i<list.size();i++) {
				
				System.out.println(JSON.toJSONString(list.get(i)));
				Integer no = (Integer)list.get(i).get("no");
				String displayName = list.get(i).get("organName").toString();
				
				Double group_jz = (Double)list.get(i).get("group_jz");
				Double group_xq = (Double)list.get(i).get("group_xq");
				Double group_total = (Double)list.get(i).get("group_total");
				
				Double asset_jz = (Double)list.get(i).get("asset_jz");
				Double asset_xq = (Double)list.get(i).get("asset_xq");
				Double asset_total = (Double)list.get(i).get("asset_total");
				
				
				Double stock_jz = Double.parseDouble(list.get(i).get("stock_jz").toString());
				Double stock_xq = Double.parseDouble(list.get(i).get("stock_xq").toString());
				Double stock_total = Double.parseDouble(list.get(i).get("stock_total").toString());
				
				Double jz = group_jz + asset_jz+ stock_jz;
				Double xq = group_xq + asset_xq+ stock_xq;
				Double total = group_total + asset_total+ stock_total;
			
				Row crow = sheet.getRow(i+4);
				
				crow.getCell(0).setCellValue(no);
				crow.getCell(1).setCellValue(displayName);
				crow.getCell(2).setCellValue(total);
				crow.getCell(3).setCellValue(jz);
				crow.getCell(4).setCellValue(xq);
				
				crow.getCell(5).setCellValue(group_total);
				crow.getCell(6).setCellValue(group_jz);
				crow.getCell(7).setCellValue(group_xq);
				
				crow.getCell(8).setCellValue(asset_total);
				crow.getCell(9).setCellValue(asset_jz);
				crow.getCell(10).setCellValue(asset_xq);
				
				crow.getCell(11).setCellValue(stock_total);
				crow.getCell(12).setCellValue(stock_jz);
				crow.getCell(13).setCellValue(stock_xq);
				
				
				//crow.getCell(0).setCellStyle(centerStyle);
				//crow.getCell(1).setCellStyle(leftCenterStyle);
				//crow.getCell(2).setCellStyle(rightCenterStyle);
				//crow.getCell(3).setCellStyle(rightCenterStyle);
				//crow.getCell(4).setCellStyle(rightCenterStyle);
				
			}
			//汇总求和数据
			for(java.util.Iterator<Row> iter = sheet.iterator();iter.hasNext();) {
				for(java.util.Iterator<Cell> citer = iter.next().iterator();citer.hasNext();) {
					Cell cell = citer.next();
					if(cell.getRowIndex()>=4 && cell.getRowIndex()<21 && cell.getColumnIndex()>=2) {
						cell.setCellStyle(rightCenterStyle);
						Double val = cell.getNumericCellValue();						
						//列汇总，第23行为汇总行
						Double total = sheet.getRow(21).getCell(cell.getColumnIndex()).getNumericCellValue();
						sheet.getRow(21).getCell(cell.getColumnIndex()).setCellValue(total+val);
					}
				}
			}
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
