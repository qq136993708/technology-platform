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
import org.apache.poi.ss.usermodel.FillPatternType;
import org.apache.poi.ss.usermodel.HorizontalAlignment;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.VerticalAlignment;
import org.apache.poi.ss.util.CellRangeAddress;
import org.apache.poi.xssf.usermodel.XSSFCellStyle;
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
import com.alibaba.fastjson.JSONArray;
import com.pcitc.base.stp.budget.BudgetAssetTotal;
import com.pcitc.base.stp.budget.BudgetGroupTotal;
import com.pcitc.base.stp.budget.BudgetInfo;
import com.pcitc.base.stp.budget.BudgetStockTotal;
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
		request.setAttribute("nd", DateUtil.format(new Date(), DateUtil.FMT_YYYY));
		return "stp/budget/budget_main_totalsplit";
	}
	
	@RequestMapping(value = "/budget/budget-group-split-final", method = RequestMethod.POST)
	@ResponseBody
	public Object getFinalBudgetGroupAssetStockList(@ModelAttribute("info") BudgetInfo info,HttpServletRequest request) throws IOException 
	{
		ResponseEntity<Object> responseEntity = this.restTemplate.exchange(PROJECT_TOTAL_FINAL_GROUP, HttpMethod.POST, new HttpEntity<String>(info.getNd(), this.httpHeaders), Object.class);
		return JSON.toJSON(responseEntity.getBody()).toString();
	}
	
	@RequestMapping(value = "/budget/budget-asset-split-final", method = RequestMethod.POST)
	@ResponseBody
	public Object getFinalBudgetAssetAssetStockList(@ModelAttribute("info") BudgetInfo info,HttpServletRequest request) throws IOException 
	{
		ResponseEntity<Object> responseEntity = this.restTemplate.exchange(PROJECT_TOTAL_FINAL_ASSET, HttpMethod.POST, new HttpEntity<String>(info.getNd(), this.httpHeaders), Object.class);
		return JSON.toJSON(responseEntity.getBody()).toString();
	}
	
	@RequestMapping(value = "/budget/budget-stock-split-final", method = RequestMethod.POST)
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
		
		
		ResponseEntity<Map> responseEntity = this.restTemplate.exchange(PROJECT_TOTAL_FINAL_STOCK, HttpMethod.POST, new HttpEntity<String>(nd, this.httpHeaders), Map.class);
		Map stockMap = responseEntity.getBody();
		Object json = JSON.toJSON(stockMap.get("items"));
		JSONArray array = JSON.parseArray(json.toString());
		for(java.util.Iterator<Object> iter = array.iterator();iter.hasNext();) {
			BudgetStockTotal total = JSON.toJavaObject(JSON.parseObject(iter.next().toString()), BudgetStockTotal.class);
			Map<String,Object> map = new HashMap<String,Object>();
			map.put("total", total.getXmjfTotal());
			map.put("zbx", total.getXmjfZbx());
			map.put("fyx", total.getXmjfFyx());
			map.put("no", total.getNo());
			map.put("displayName", total.getDisplayName());
			map.put("level", total.getLevel());
			
			data.add(map);
		}
		
		
		responseEntity = this.restTemplate.exchange(PROJECT_TOTAL_FINAL_GROUP, HttpMethod.POST, new HttpEntity<String>(nd, this.httpHeaders), Map.class);
		Map groupMap = responseEntity.getBody();
		json = JSON.toJSON(groupMap.get("items"));
		array = JSON.parseArray(json.toString());
		Double fyx=0d;
		for(java.util.Iterator<Object> iter = array.iterator();iter.hasNext();) {
			BudgetGroupTotal group = JSON.toJavaObject(JSON.parseObject(iter.next().toString()), BudgetGroupTotal.class);
			fyx += group.getXmjf()+group.getZxjf();
		}
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("total", fyx);
		map.put("zbx", 0d);
		map.put("fyx", fyx);
		map.put("no", 0);
		map.put("displayName", "二、集团公司合计");
		map.put("level", -1);
		
		data.add(map);
		
		
		responseEntity = this.restTemplate.exchange(PROJECT_TOTAL_FINAL_ASSET, HttpMethod.POST, new HttpEntity<String>(nd, this.httpHeaders), Map.class);
		Map assetMap = responseEntity.getBody();
		json = JSON.toJSON(assetMap.get("items"));
		array = JSON.parseArray(json.toString());
		fyx=0d;
		for(java.util.Iterator<Object> iter = array.iterator();iter.hasNext();) {
			BudgetAssetTotal asset = JSON.toJavaObject(JSON.parseObject(iter.next().toString()), BudgetAssetTotal.class);
			fyx += asset.getXmjf();
		}
		map = new HashMap<String,Object>();
		map.put("total", fyx);
		map.put("zbx", 0d);
		map.put("fyx", fyx);
		map.put("no", 0);
		map.put("displayName", "三、股份公司合计");
		map.put("level", -1);
		
		data.add(map);
		
		URL path = this.getClass().getResource("/");
		File f = new File(path.getPath() + "static/budget/budget_total_template.xlsx");
		//System.out.println(f.getAbsolutePath());
		//写入新文件2019年集团公司总部科技经费预算
		String newFilePath = path.getPath() + "static/budget/"+nd+"年总部科技经费预算（建议稿）_"+DateUtil.dateToStr(new Date(), "yyyyMMddHHmmss")+".xlsx";
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
			String itemTitleJfys = readCell(sheet.getRow(2).getCell(2));
			
			sheet.getRow(0).getCell(0).setCellValue(title.replace("${nd}", ndStr));
			sheet.getRow(2).getCell(2).setCellValue(itemTitleJfys.replace("${nd}",ndStr));
			
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
			
			
			
			Double stock_total = 0d;
			Double stock_zbx = 0d;
			Double stock_fyx = 0d;
			for(int i = 0;i<list.size();i++) {
				
				Integer no = (Integer)list.get(i).get("no");
				String displayName = list.get(i).get("displayName").toString();
				Integer level = (Integer)list.get(i).get("level");
				Double total = (Double)list.get(i).get("total");
				Double zbx = (Double)list.get(i).get("zbx");
				Double fyx = (Double)list.get(i).get("fyx");
			
				if(level==0) {//只求集团总数
					stock_total += total;
					stock_zbx += zbx;
					stock_fyx += fyx;
				}
				
				
				Row crow = sheet.getRow(i+5);
				if(level == 0) {
					crow.createCell(0).setCellValue(no);
				}else {
					crow.createCell(0).setCellValue("");
				}
				crow.createCell(1).setCellValue(displayName);
				crow.createCell(2).setCellValue(total);
				crow.createCell(3).setCellValue(zbx);
				crow.createCell(4).setCellValue(fyx);
				
				
				
				crow.getCell(0).setCellStyle(centerStyle);
				if(level == 0) {
					crow.getCell(1).setCellStyle(leftCenterStyle);
				}else {
					crow.getCell(1).setCellStyle(rightCenterStyle);
				}
				crow.getCell(2).setCellStyle(rightCenterStyle);
				crow.getCell(3).setCellStyle(rightCenterStyle);
				crow.getCell(4).setCellStyle(rightCenterStyle);
				
			}
			totalRow.getCell(0).setCellValue("一、股份公司合计");
			totalRow.getCell(1).setCellValue("");
			totalRow.getCell(2).setCellValue(stock_fyx+stock_zbx);
			totalRow.getCell(3).setCellValue(stock_zbx);
			totalRow.getCell(4).setCellValue(stock_fyx);
			
			
			
			sheet.getRow(list.size()+3).getCell(0).setCellValue("二、集团公司合计");
			sheet.getRow(list.size()+4).getCell(0).setCellValue("三、资产公司合计");
			//合计单元格合并
			sheet.addMergedRegion(new CellRangeAddress(4,4,0,1));
			sheet.addMergedRegion(new CellRangeAddress(list.size()+3,list.size()+3,0,1));
			sheet.addMergedRegion(new CellRangeAddress(list.size()+4,list.size()+4,0,1));
			//设置背景色
			//cs.setFillPattern(XSSFCellStyle.FINE_DOTS );
			//cs.setFillBackgroundXSSFColor(IndexedColors.RED.getIndex());
			Integer [] color_rows = new Integer[]{4,list.size()+3,list.size()+4};
			
			XSSFCellStyle yellCellCenter = workbook.createCellStyle();
			yellCellCenter.cloneStyleFrom(centerStyle);
			yellCellCenter.setFillForegroundColor(IndexedColors.YELLOW.getIndex());
			yellCellCenter.setFillPattern(FillPatternType.SOLID_FOREGROUND);
			
			XSSFCellStyle yellCellRight = workbook.createCellStyle();
			yellCellRight.cloneStyleFrom(rightCenterStyle);
			yellCellRight.setFillForegroundColor(IndexedColors.YELLOW.getIndex());
			yellCellRight.setFillPattern(FillPatternType.SOLID_FOREGROUND);
			
			
			
			for(Integer row:color_rows) {
				sheet.getRow(row).getCell(0).setCellStyle(yellCellCenter);
				sheet.getRow(row).getCell(1).setCellStyle(yellCellCenter);
				sheet.getRow(row).getCell(2).setCellStyle(yellCellRight);
				sheet.getRow(row).getCell(3).setCellStyle(yellCellRight);
				sheet.getRow(row).getCell(4).setCellStyle(yellCellRight);
			}
			
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
