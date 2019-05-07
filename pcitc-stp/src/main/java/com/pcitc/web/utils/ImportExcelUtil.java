package com.pcitc.web.utils;
import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.web.multipart.MultipartFile;

import com.alibaba.fastjson.JSON;


public class ImportExcelUtil {
	
	private final static String excel2003L =".xls";    //2003- 版本的excel
	private final static String excel2007U =".xlsx";   //2007+ 版本的excel
	/**
	 * 
	 * @param file
	 * @return
	 * @throws Exception
	 */
	public List<Map<Point,Object>> readExcelAllCellVal(MultipartFile file) throws Exception
	{
		return readWorkBook(file.getInputStream(),file.getName());
	}
	/**
	 * 
	 * @param file
	 * @return
	 * @throws Exception
	 */
	public List<Map<Point,Object>> readExcelAllCellVal(File file) throws Exception
	{
		return readWorkBook(new FileInputStream(file),file.getName());
	}
	/**
	 * 描述：获取IO流中的数据，组装成List<List<Object>>对象
	 * @param in,fileName
	 * @return
	 * @throws IOException 
	 */
	public  List<List<Object>> getBankListByExcel(InputStream in,String fileName) throws Exception{
		List<List<Object>> list = null;
		//创建Excel工作薄
		Workbook work = this.getWorkbook(in,fileName);
		if(null == work){
			throw new Exception("创建Excel工作薄为空！");
		}
		list = new ArrayList<List<Object>>();
		//遍历Excel中所有的sheet
		for (int i = 0; i < work.getNumberOfSheets(); i++) {
			Sheet sheet = work.getSheetAt(i);
			if(sheet==null){continue;}
			//遍历当前sheet中的所有行
			for (int j = sheet.getFirstRowNum(); j < sheet.getLastRowNum(); j++) {
				Row row = sheet.getRow(j);
				if(row==null||row.getFirstCellNum()==j){continue;}
				//遍历所有的列
				List<Object> li = new ArrayList<Object>();
				for (int y = row.getFirstCellNum(); y < row.getLastCellNum(); y++) {
					Cell cell = row.getCell(y);
					li.add(this.getCellValue(cell));
				}
				list.add(li);
			}
		}
		return list;
	}
	/**
	 * 
	 * @param sheet
	 * @return
	 */
	public Map<Point,Object> readSheetVal(Sheet sheet)
	{
		Map<Point,Object> map = new HashMap<Point,Object>();
		for(int r = 0;r<sheet.getLastRowNum();r++) {
			for(int c = 0;c<sheet.getRow(r).getLastCellNum();c++) {
				map.put(new Point(r,c), getCellValue(sheet.getRow(r).getCell(c)));
			}
		}
		return map;
	}
	/**
	 * 
	 * @param is
	 * @param fileName
	 * @return
	 * @throws Exception
	 */
	public List<Map<Point,Object>> readWorkBook(InputStream is,String fileName) throws Exception
	{
		List<Map<Point,Object>> data = new ArrayList<Map<Point,Object>>();
		
		Workbook workbook = getWorkbook(is,fileName);
		
		List<Sheet> sheets = readWorkBook(workbook);
		for(int s = 0;s<sheets.size();s++) {
			data.add(readSheetVal(sheets.get(s)));;
		}
		this.closeIO(is);
		this.closeIO(workbook);
		
		return data;
	}
	
	/**
	 * 描述：根据文件后缀，自适应上传文件的版本 
	 * @param inStr,fileName
	 * @return
	 * @throws Exception
	 */
	public  Workbook getWorkbook(InputStream inStr,String fileName) throws Exception{
		Workbook wb = null;
		String fileType = fileName.substring(fileName.lastIndexOf("."));
		if(excel2003L.equals(fileType)){
			wb = new HSSFWorkbook(inStr);  //2003-
		}else if(excel2007U.equals(fileType)){
			wb = new XSSFWorkbook(inStr);  //2007+
		}else{
			throw new Exception("解析的文件格式有误！");
		}
		return wb;
	}
	/**
	 * 读取工作簿
	 * @param workbook
	 * @return
	 */
	public List<Sheet> readWorkBook(Workbook workbook)
	{
		List<Sheet> sheets = new ArrayList<Sheet>();
		for (int i = 0; i < workbook.getNumberOfSheets(); i++) 
		{
			sheets.add(workbook.getSheetAt(i));
		}
		return sheets;
	}
	/**
	 * 读取单元行
	 * @param sheet
	 * @return
	 */
	public List<Row> readSheet(Sheet sheet)
	{
		List<Row> rows = new ArrayList<Row>();
		for (int i = 0; i < sheet.getLastRowNum(); i++) 
		{
			rows.add(sheet.getRow(i));
		}
		return rows;
	}
	/**
	 * 描述：对表格中数值进行格式化
	 * @param cell
	 * @return
	 */
	public  Object getCellValue(Cell cell){
		Object value = null;
		DecimalFormat df = new DecimalFormat("0");  //格式化number String字符
		SimpleDateFormat sdf = new SimpleDateFormat("yyy-MM-dd");  //日期格式化
		DecimalFormat df2 = new DecimalFormat("0.00");  //格式化数字
		if(cell == null) {
			return null;
		}
		switch (cell.getCellTypeEnum()) {
		case STRING:
			value = cell.getRichStringCellValue().getString();
			break;
		case NUMERIC:
			if("General".equals(cell.getCellStyle().getDataFormatString())){
				value = df.format(cell.getNumericCellValue());
			}else if("m/d/yy".equals(cell.getCellStyle().getDataFormatString())){
				value = sdf.format(cell.getDateCellValue());
			}else{
				value = df2.format(cell.getNumericCellValue());
			}
			break;
		case BOOLEAN:
			value = cell.getBooleanCellValue();
			break;
		case BLANK:
			value = "";
			break;
		default:
			break;
		}
		return value;
	}
	/**
	 * 	读取单元格
	 * @param cell
	 * @return
	 */
	public String readCellStringVal(Cell cell) 
	{
		if(cell == null) {
			return null;
		}
		String  cellVal = null;
		switch (cell.getCellTypeEnum()) 
		{
	        case NUMERIC:
	        	cellVal = Double.toString(cell.getNumericCellValue());
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
	        	cellVal = Boolean.toString(cell.getBooleanCellValue());
	            break;
	        case ERROR:
	            break;
	        default:
	            break;
        }
		return cellVal;
	}
	/**
	 * 
	 * @param io
	 */
	public void closeIO(Closeable io) 
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
	public static void main(String [] args) 
	{
		File file = new File("D:\\data.xlsx");
		try {
			List<Map<Point,Object>> rss = new ImportExcelUtil().readExcelAllCellVal(file);
			for(java.util.Iterator<Map<Point,Object>> iter = rss.iterator();iter.hasNext();) {
				Map<Point,Object> map = iter.next();
				Map<String,Object> tomap = new HashMap<String,Object>();
				for(java.util.Iterator<Point> miter = map.keySet().iterator();miter.hasNext();) {
					Point p = miter.next();
					tomap.put(p.toString(), map.get(p));
				}
				System.out.println(JSON.toJSONString(tomap));
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}