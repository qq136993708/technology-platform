package com.pcitc.web.utils;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.jdom.*;
import org.jdom.input.SAXBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class ImportExcelUtil {

	private final static String excel2003L =".xls";    //2003- 版本的excel
	private final static String excel2007U =".xlsx";   //2007+ 版本的excel

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
			for (int j = sheet.getFirstRowNum(); j <=sheet.getLastRowNum(); j++) {
				Row row = sheet.getRow(j);
				if(row==null||row.getFirstCellNum()==j){continue;}
				//遍历所有的列
				List<Object> li = new ArrayList<Object>();
				for (int y = row.getFirstCellNum(); y < row.getLastCellNum(); y++) {
					Cell cell = row.getCell(y);
					li.add(this.getCellValue(cell));
					int beg = row.getFirstCellNum();
					int num = row.getLastCellNum();
//					if(y==num-1){
//						li.add("0")	;
//						li.add("1");
//					}
				}
				list.add(li);
			}
		}
		return list;
	}

	public  List<List<Object>> getListByExcel(InputStream in,String fileName) throws Exception{
		List<List<Object>> list = null;
		//创建Excel工作薄
		Workbook work = this.getWorkbook(in,fileName);
		if(null == work){
			throw new Exception("创建Excel工作薄为空！");
		}
		list = new ArrayList<List<Object>>();
		//遍历Excel中所有的sheet
			Sheet sheet = work.getSheetAt(0);
			if(sheet==null){return null;}
			//遍历当前sheet中的所有行
			for (int j = sheet.getFirstRowNum()+4; j <=sheet.getLastRowNum(); j++) {
				Row row = sheet.getRow(j);
				if(row==null||row.getFirstCellNum()==j){continue;}
				//遍历所有的列
				List<Object> li = new ArrayList<Object>();
				for (int y = row.getFirstCellNum(); y < row.getLastCellNum(); y++) {
					Cell cell = row.getCell(y);
					li.add(this.getCellValue(cell));
					int beg = row.getFirstCellNum();
					int num = row.getLastCellNum();
//					if(y==num-1){
//						li.add("0")	;
//						li.add("1");
//					}
				}
				list.add(li);
			}
		return list;
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

	//使用递归方式解析并显示所有的XML文档内容
	private Map<String,String> readAndPrint(String key, Map<String,String> hashMap, List<Content> list) {
		for (Content temp:list){
			//如果获取的内容是注释
			if (temp instanceof Comment){
				Comment com = (Comment)temp;
				System.out.println("<--"+com.getText()+"-->");
				// 如果获取的内容是处理指令
			}else if (temp instanceof ProcessingInstruction){
				ProcessingInstruction pi = (ProcessingInstruction)temp;
				System.out.println("<?"+pi.getTarget()+""+pi.getData()+"?>");
				//如果获取的内容是元素
			}else if (temp instanceof Element){
				Element elt = (Element)temp;
				List<Attribute> attrs = elt.getAttributes();
				System.out.print("<"+elt.getName()+"");
				for (Attribute t:attrs){
					System.out.println(t.getName()+"=\""+t.getValue()+"\"");
				}
				System.out.println(">");
				key = elt.getName();
				readAndPrint(key,hashMap,elt.getContent());
				System.out.println("</"+elt.getName()+">");
				//如果获取的内容是CDATA
			}else if (temp instanceof CDATA){
				CDATA cdata = (CDATA)temp;
				System.out.println("<![CDATA["+cdata.getText()+"]]>");
				//如果获取的内容是文本
			}else if (temp instanceof Text){
				Text text = (Text)temp;
				if (!text.getText().trim().equals("")){
					hashMap.put(key,text.getText());
					System.out.println(text.getText());
				}
			}
		}
		return hashMap;
	}

	public List generateData(InputStream in) throws Exception{
		SAXBuilder sb = new SAXBuilder();
		Document document = sb.build(in);
		//readAndPrint(document.getContent());
		Element root = document.getRootElement();
		//获取根元素下面的所有子元素(mess)
		List<Element> messList = root.getChildren("Patent");
		//子根元素(mess)
		Element childrenRoot = null;
		List arrList = new ArrayList();
		//遍历根元素的子元素集合(即遍历mess元素)
		for(int i = 0; i < messList.size(); i++){
			//将根元素prop下的mess子元素作为一个新的子根元素
			childrenRoot = messList.get(i);
			List list = childrenRoot.getContent();
			String key = "";
			Map<String,String> hashMap = new HashMap<String,String>();
			Map<String,String> hoshMap = readAndPrint(key,hashMap,list);
			ArrayList<Object> arrayList = new ArrayList<>();
			arrayList = setValue(arrayList,hoshMap);
			arrList.add(arrayList);
		}
		return arrList;
	}

	private ArrayList setValue(ArrayList arrayList,Map<String,String> hoshMap){
		arrayList.add(hoshMap.get("patentname"));
		arrayList.add(hoshMap.get("patentno"));
		arrayList.add(hoshMap.get("applicant"));
		arrayList.add(hoshMap.get("originator"));
		arrayList.add(hoshMap.get("applytype"));
		arrayList.add(hoshMap.get("patenttype"));
		arrayList.add(hoshMap.get("statename"));
		arrayList.add(hoshMap.get("applydate"));
		arrayList.add(hoshMap.get("accreditdate"));
		arrayList.add(hoshMap.get("enddate"));

		arrayList.add(hoshMap.get("lawstatus"));
		arrayList.add(hoshMap.get("changedate"));
		arrayList.add(hoshMap.get("science"));
		arrayList.add(hoshMap.get("background"));
		arrayList.add(hoshMap.get("backgrounddepartment"));
		arrayList.add(hoshMap.get("backgroundnumber"));
		arrayList.add(hoshMap.get("backgroundname"));
		arrayList.add(hoshMap.get("product"));
		arrayList.add(hoshMap.get("model"));
		arrayList.add(hoshMap.get("subsystem"));

		arrayList.add(hoshMap.get("material"));
		arrayList.add(hoshMap.get("mainclassifycode"));
		arrayList.add(hoshMap.get("childclassifycode"));
		arrayList.add(hoshMap.get("coapplicant"));
		arrayList.add(hoshMap.get("priority"));
		arrayList.add(hoshMap.get("agency"));
		arrayList.add(hoshMap.get("publicdata"));
		arrayList.add(hoshMap.get("caption"));
		arrayList.add(hoshMap.get("level"));
		arrayList.add(hoshMap.get("legalcode"));
		arrayList.add("0");
		arrayList.add("1");
		return arrayList;
	}
}