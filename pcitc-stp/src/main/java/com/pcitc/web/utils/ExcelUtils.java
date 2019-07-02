package com.pcitc.web.utils;

import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.lang.reflect.Field;
import java.math.BigDecimal;
import java.net.URL;
import java.net.URLEncoder;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Objects;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.DataFormat;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.HorizontalAlignment;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.VerticalAlignment;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.alibaba.fastjson.JSON;
import com.pcitc.base.util.DateUtils;

public class ExcelUtils {

	private static final Log _log = LogFactory.getLog(ExcelUtils.class);

	private Workbook wb = null;

	private Sheet sheet = null;


	public Workbook getWb() {
		return wb;
	}

	public void setWb(Workbook wb) {
		this.wb = wb;
	}

	public Sheet getSheet() {
		return sheet;
	}

	public void setSheet(Sheet sheet) {
		this.sheet = sheet;
	}

	public ExcelUtils() {
	}

	public ExcelUtils(Workbook wb, Sheet sheet) {
		this.wb = wb;
		this.sheet = sheet;
	}

	public ExcelUtils(InputStream ips) {
		try {
			this.wb = WorkbookFactory.create(ips);
			// this.sheet = wb.getSheetAt(0);
			// this.sheet = wb.createSheet();
		} catch (EncryptedDocumentException e1) {
			e1.printStackTrace();
		} catch (InvalidFormatException e1) {
			e1.printStackTrace();
		} catch (IOException e1) {
			e1.printStackTrace();
		}

	}

	/**
	 * @描述 根据数据源格式写入数据到Excel表格中
	 * @作者 liuht
	 * @时间 2017年4月27日下午2:34:14
	 * @参数 @param row
	 * @参数 @param col
	 * @参数 @param style
	 * @参数 @param value
	 * @return void
	 */
	public void cteateCell(Row row, int col, CellStyle style, Object value) {
		Cell cell = row.createCell(col);
		cell.setCellStyle(style);

		if (value instanceof String) {
			cell.setCellValue(value.toString());
			cell.setCellType(Cell.CELL_TYPE_STRING);
		} else if (value instanceof Integer) {
			cell.setCellValue((Integer) value);
			cell.setCellType(Cell.CELL_TYPE_NUMERIC);
		} else if (value instanceof Double) {
			cell.setCellValue((Double) value);
			cell.setCellType(Cell.CELL_TYPE_NUMERIC);
		} else if (value instanceof Boolean) {
			cell.setCellValue((Boolean) value);
			cell.setCellType(Cell.CELL_TYPE_BOOLEAN);
		}
	}

	/**
	 * @描述 读取Excel表格内容并转化为String格式
	 * @作者 liuht
	 * @时间 2017年4月27日下午2:33:39
	 * @参数 @param cell
	 * @参数 @return
	 * @return String
	 */
	public String getCellContent(Cell cell) {
		String res = "";
		if (cell == null)
			return res;

		switch (cell.getCellType()) {
		case Cell.CELL_TYPE_STRING:
			res = cell.getRichStringCellValue().getString().trim();
			break;
		case Cell.CELL_TYPE_NUMERIC:
			if (DateUtil.isCellDateFormatted(cell)) {// 是日期类型
				Date celldate = cell.getDateCellValue();
				SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
				res = sdf.format(celldate);
			} else {
				res = String.valueOf(cell.getNumericCellValue());
			}
			break;
		default:
			res = "";
			break;
		}

		return res;
	}

	/**
	 * ie,chrome,firfox下处理文件名显示乱码
	 * 
	 * @param request
	 * @param fileName
	 * @return
	 */
	public static String processFileName(HttpServletRequest request, String fileName) {
		String codedfilename = null;
		try {
			String agent = request.getHeader("USER-AGENT");
			if (null != agent && -1 != agent.indexOf("MSIE") || null != agent && -1 != agent.indexOf("Trident")) {// ie
				codedfilename = java.net.URLEncoder.encode(fileName, "UTF8");
			} else if (null != agent && -1 != agent.indexOf("Mozilla")) {// 火狐,chrome等
				codedfilename = new String(fileName.getBytes("UTF-8"), "iso-8859-1");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return codedfilename;
	}

	/**
	 * @描述 设置单元格样式
	 * @作者 liuht
	 * @时间 2017-9-5 16:11
	 * @参数 [style, align, font]
	 * @return org.apache.poi.ss.usermodel.CellStyle
	 */
	public static CellStyle createCellStyle(CellStyle style, int align, Font font) {
		/*style.setBorderBottom((short) 1);
		style.setBorderLeft((short) 1);
		style.setBorderRight((short) 1);
		style.setBorderTop((short) 1);
		style.setAlignment(align);*/
		// style.setWrapText(true);自动换行
		if (font != null) {
			style.setFont(font);
		}
		return style;
	}

	/**
	 * @描述 根据类名反射获取对象
	 * @作者 liuht
	 * @时间 2017-9-5 11:48
	 * @参数 [className]
	 * @return java.lang.Object
	 */
	public static Object loadClassObject(String className) {
		Object o = null;
		try {
			Class clas = Class.forName(className);
			if (clas != null) {
				try {
					o = clas.newInstance();
				} catch (IllegalAccessException ex1) {
					ex1.printStackTrace();
				} catch (InstantiationException ex1) {
					ex1.printStackTrace();
				}
			} else
				o = null;
		} catch (ClassNotFoundException ex) {
			ex.printStackTrace();
		}
		return o;
	}

	/**
	 * @描述 通过实体反转将list数据插入Excel中
	 * @作者 liuht
	 * @时间 2017-9-5 15:01
	 * @参数 [beanName, listKey, listName, dataList]
	 * @return void
	 */
	@SuppressWarnings({ "rawtypes", "static-access" })
	public void insertExcelData(String beanName, List listKey, List listName, List dataList, int rowNum) {
		try {
			Object o = this.loadClassObject(beanName);
			if (wb == null || sheet == null || o == null) {
				return;
			}
			Row row = null;
			Cell cell = null;
			Object objType = null;
			Field field = null;
			// 创建表头
			Font font = wb.createFont();
			//font.setBoldweight(Font.BOLDWEIGHT_BOLD);
			CellStyle headStyle = this.createCellStyle(wb.createCellStyle(), 0, font);
			row = sheet.createRow(rowNum);
			int i = 0;
			for (Iterator it = listName.iterator(); it.hasNext();) {
				while (it.hasNext()) {
					String name = (String) it.next();
					cell = row.createCell((short) i++);
					cell.setCellStyle(headStyle);
					cell.setCellType(Cell.CELL_TYPE_STRING);
					cell.setCellValue(name);
				}
			}
			// 创建数据
			CellStyle styleContent = this.createCellStyle(wb.createCellStyle(), 0, null);
			CellStyle styleFomatDouble = this.createCellStyle(wb.createCellStyle(), 0, null);
			DataFormat format = wb.createDataFormat();
			for (Iterator it = dataList.iterator(); it.hasNext();) {
				while (it.hasNext()) {
					rowNum++;
					o = it.next();
					row = sheet.createRow(rowNum);
					for (int keyCount = 0; keyCount < listKey.size(); keyCount++) {
						// 如果对象为空，填充空数据
						if(Objects.isNull(o)){
							cell.setCellStyle(styleContent);
							cell.setCellValue(" ");
						}else{
							cell = row.createCell((short) keyCount);
							cell.setCellType(Cell.CELL_TYPE_STRING);
							try {
								try {
									field = o.getClass().getDeclaredField(listKey.get(keyCount).toString());
								} catch (NoSuchFieldException e) {
									// 读取父类的属性
									field = o.getClass().getSuperclass().getDeclaredField(listKey.get(keyCount).toString());
								}
								field.setAccessible(true);// 设置允许访问private属性
								objType = field.getType();
								Object tempObj = field.get(o);
								if (objType == Integer.class || objType.toString().equals("int")) {
									cell.setCellStyle(styleContent);
									cell.setCellValue((double) Integer.parseInt(tempObj == null ? "0" : tempObj.toString()));
								} else if (objType == Double.class || objType.toString().equals("double") || objType == BigDecimal.class) {
									styleFomatDouble.setDataFormat(format.getFormat("0.00"));
									cell.setCellStyle(styleFomatDouble);
									cell.setCellValue(Double.parseDouble(tempObj == null ? "0.00" : tempObj.toString()));
								} else if (objType == Date.class) {
									cell.setCellStyle(styleContent);
									cell.setCellValue(tempObj == null ? "" : DateUtils.dateToStr((Date) tempObj, DateUtils.FMT_SS));
								} else if (objType == Timestamp.class) {
									cell.setCellStyle(styleContent);
									cell.setCellValue(tempObj == null ? "" : DateUtils.dateToStr((Date) tempObj, DateUtils.FMT_SS));
								} else {
									cell.setCellStyle(styleContent);
									cell.setCellValue(tempObj == null ? "" : tempObj.toString());
								}
								tempObj = null;
							} catch (SecurityException e) {
								e.printStackTrace();
								_log.error(e.getMessage());
								_log.debug("报表读取类文件方法出错-插入信息失败-SecurityException");
							} catch (NoSuchFieldException e) {
								e.printStackTrace();
								_log.error(e.getMessage());
								_log.debug("报表读取对象属性方法出错-插入信息失败-NoSuchFieldException");
							} catch (NumberFormatException e) {
								e.printStackTrace();
								_log.error(e.getMessage());
								_log.debug("报表数字类型转换方法出错-插入信息失败-NumberFormatException");
							} catch (IllegalArgumentException e) {
								e.printStackTrace();
								_log.error(e.getMessage());
								_log.debug("报表方法中存在不合法变量-插入信息失败-IllegalArgumentException");
							} catch (IllegalAccessException e) {
								_log.error(e.getMessage());
								_log.debug("报表方法中存取对象不合法-插入信息失败-IllegalAccessException");
							}
						}
					}
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
			_log.error("通过实体反转将list数据插入Excel失败", e);
		}
	}
	
    /**
     * @描述 导出下载Excel
     * @作者 liuht
     * @时间 2017-10-23 14:18
     * @参数 [response, wb, fileName]
     * @return void
     */
	public static void responseDownload(HttpServletResponse response, Workbook wb, String fileName) throws IOException {
        //fileName = new String((fileName).getBytes("gb2312"), "ISO8859-1");

        response.setCharacterEncoding("UTF-8");
        response.setContentType("application/vnd.ms-excel");
        response.setHeader("Content-Disposition", "attachment;filename=\"" + URLEncoder.encode(fileName, "UTF-8") + ".xls\"");

        wb.write(response.getOutputStream());

        response.getOutputStream().flush();
        response.getOutputStream().close();

    }
	/**
	 * 读取Excel 
	 * @param filePath
	 * @return
	 * @throws Exception 
	 */
	public static Map<Map<Integer,Integer>,Cell> readExcel(XSSFWorkbook xssfWorkbook,Integer sheetIndex) throws Exception 
	{
		Map<Map<Integer,Integer>,Cell> data = new HashMap<Map<Integer,Integer>,Cell>();
		XSSFSheet sheet = xssfWorkbook.getSheetAt(sheetIndex);
		for(int i = sheet.getFirstRowNum();i<sheet.getLastRowNum();i++) {
			Row row = sheet.getRow(i);
			for(int j = row.getFirstCellNum();j<row.getLastCellNum();j++) {
				Cell cell = row.getCell(j);
				if(cell == null) {continue;}
				Map<Integer,Integer> key = new HashMap<Integer,Integer>();
				key.put(i, j);
				data.put(key, cell);
			}
		}
		return data;
	}
	/**
	 * 写入Excel文件
	 * @param xssfWorkbook
	 * @param sheetIndex
	 * @param rowStartIndex
	 * @param columnStartIndex
	 */
	public static void writeDataToExcel(XSSFWorkbook xssfWorkbook,Integer sheetIndex,Integer rowStartIndex,Integer columnStartIndex,List<List<String>> data) 
	{
		for(int row =0;row<data.size();row++) {
			Row crow = xssfWorkbook.getSheetAt(sheetIndex).getRow(rowStartIndex+row);
			for(int col=0;col<data.get(row).size();col++) {
				crow.createCell(columnStartIndex+col).setCellValue(data.get(row).get(col));
			}
		}
	}
	/**
	 * 写入对象到文件
	 * @param workbook
	 * @param outFile
	 */
	public static void writeWorkBookToFile(XSSFWorkbook workbook,File outFile) 
	{
		try {
			FileOutputStream fos = new FileOutputStream(outFile);
			workbook.write(fos);
			closeIO(fos);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	/**
	 * 读取模板到对象
	 * @param templateFile
	 * @return
	 */
	public static XSSFWorkbook readWorkBookFromFile(File templateFile) 
	{
		XSSFWorkbook workbook = null;
		try {
			InputStream is = new FileInputStream(templateFile);
			workbook = new XSSFWorkbook(is);
			closeIO(is);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return workbook;
	}
	
	/**
	 * 以行单元格为模板设置格式
	 * @param cell
	 */
	public static void setCellStyle(Row templateRow,Cell cell) 
	{
		CellStyle style = templateRow.getSheet().getWorkbook().createCellStyle();
		style.cloneStyleFrom(templateRow.getCell(cell.getColumnIndex()).getCellStyle());
		cell.setCellStyle(style);
	}
	public static void fileDownload(File file,HttpServletResponse res) 
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
	public static void closeIO(Closeable io) 
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
	public static String readCell(Cell cell) 
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
	public static void main(String [] args) throws Exception {
		URL path = ExcelUtils.class.getResource("/");
		File f = new File(path.getPath() + "static/budget/budget_total_template.xlsx");
		InputStream is = new FileInputStream(f);
		Map<Map<Integer,Integer>,Cell> data = ExcelUtils.readExcel(new XSSFWorkbook(is), 0);
		for(java.util.Iterator<?> iter=data.keySet().iterator();iter.hasNext();) 
		{
			Object key = iter.next();
			String cell = readCell(data.get(key));
			System.out.println(JSON.toJSONString(key) + cell);
		}
		closeIO(is);
	}
}
