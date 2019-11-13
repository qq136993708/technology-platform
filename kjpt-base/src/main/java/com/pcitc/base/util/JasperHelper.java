package com.pcitc.base.util;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.sql.Connection;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.log4j.Logger;
import org.springframework.http.HttpHeaders;
import org.springframework.web.client.RestTemplate;

import net.sf.jasperreports.engine.JRDataSource;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JRExporter;
import net.sf.jasperreports.engine.JRExporterParameter;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperPrintManager;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.base.JRBaseReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.engine.export.JRHtmlExporter;
import net.sf.jasperreports.engine.export.JRHtmlExporterParameter;
import net.sf.jasperreports.engine.export.JRRtfExporter;
import net.sf.jasperreports.engine.export.JRXlsExporter;
import net.sf.jasperreports.engine.export.JRXlsExporterParameter;
import net.sf.jasperreports.engine.util.JRLoader;
import net.sf.jasperreports.j2ee.servlets.ImageServlet;

/**
 * <p>Title: Ireport</p>
 * <p>Description: Ireport打印、导出（excel、pdf、word格式）</p>
 * <p>Copyright: Copyright (c) 2014</p>
 * <p>Company: 石化盈科</p>
 * <p>last modified: 2014-03-28 liubitao</p>
 * @author liubitao
 * @version 1.0
 */
 
public class JasperHelper {

	private static Logger logger = Logger.getLogger(JasperHelper.class);
	public static final String PRINT_TYPE = "print";
	public static final String PDF_TYPE = "pdf";
	public static final String PDFINLINE_TYPE = "pdfInline";
	public static final String EXCEL_TYPE = "excel";
	public static final String WORD_TYPE = "word";
	public static final String WORDINLINE_TYPE = "wordInline";
	public static final String HTML_TYPE = "html";

	public static void prepareReport(JasperReport jasperReport, String type) {
		logger.debug("The method======= prepareReport() start.......................");
		/*
		 * 如果导出的是excel，则需要去掉周围的margin
		 */
		if ("excel".equals(type)) {
			try {
				Field margin = JRBaseReport.class
						.getDeclaredField("leftMargin");
				margin.setAccessible(true);
				margin.setInt(jasperReport, 0);
				margin = JRBaseReport.class.getDeclaredField("topMargin");
				margin.setAccessible(true);
				margin.setInt(jasperReport, 0);
				margin = JRBaseReport.class.getDeclaredField("bottomMargin");
				margin.setAccessible(true);
				margin.setInt(jasperReport, 0);
				Field pageHeight = JRBaseReport.class
						.getDeclaredField("pageHeight");
				pageHeight.setAccessible(true);
				pageHeight.setInt(jasperReport, 2147483647);
			} catch (Exception exception) {
				
			}
		}
	}

	/*
	 * 单条数据导出pdf
	 * 
	 * 注意此处中文问题 这里应该详细说：主要在ireport里变下就行了。看图
	 * 
	 * 1）在ireport的classpath中加入iTextAsian.jar 2）在ireport画jrxml时，看ireport最左边有个属性栏。
	 * 
	 * 下边的设置就在点字段的属性后出现。 pdf font name ：STSong-Light ，pdf encoding ：UniGB-UCS2-H
	 */
	private static void exportPdf(JasperPrint jasperPrint,
			String defaultFilename, HttpServletRequest request,
			HttpServletResponse response) throws IOException, JRException {
		response.setContentType("application/pdf");
		response.setHeader("Content-Transfer-Encoding","binary");
		response.setHeader("Cache-Control", "must-revalidate, post-check=0, pre-check=0");
		response.setHeader("Pragma", "public");
		String defaultname = null;
		if (defaultFilename.trim() != null && defaultFilename != null) {
			defaultname = defaultFilename + ".pdf";
		} else {
			defaultname = "export.pdf";
		}
		String fileName = new String(defaultname.getBytes("GBK"), "ISO8859_1");
		response.setHeader("Content-disposition", "attachment; filename=" + fileName);
		ServletOutputStream ouputStream = response.getOutputStream();
		JasperExportManager.exportReportToPdfStream(jasperPrint, ouputStream);
		ouputStream.flush();
		ouputStream.close();
	}
	
	/*
	 * 单条数据导出pdf
	 * 
	 * 注意此处中文问题 这里应该详细说：主要在ireport里变下就行了。看图
	 * 
	 * 1）在ireport的classpath中加入iTextAsian.jar 2）在ireport画jrxml时，看ireport最左边有个属性栏。
	 * 
	 * 下边的设置就在点字段的属性后出现。 pdf font name ：STSong-Light ，pdf encoding ：UniGB-UCS2-H
	 */
	private static void exportPdfInline(JasperPrint jasperPrint,
			String defaultFilename, HttpServletRequest request,
			HttpServletResponse response) throws IOException, JRException {
		response.setContentType("application/pdf");
		response.setHeader("Content-Transfer-Encoding","binary");
		response.setHeader("Cache-Control", "must-revalidate, post-check=0, pre-check=0");
		response.setHeader("Pragma", "public");
		String defaultname = null;
		if (defaultFilename.trim() != null && defaultFilename != null) {
			defaultname = defaultFilename + ".pdf";
		} else {
			defaultname = "export.pdf";
		}
		String fileName = new String(defaultname.getBytes("GBK"), "ISO8859_1");
		response.setContentType("application/pdf");
		response.setHeader("Content-disposition", "inline; filename="+ fileName);
		ServletOutputStream ouputStream = response.getOutputStream();
		JasperExportManager.exportReportToPdfStream(jasperPrint, ouputStream);
		ouputStream.flush();
		ouputStream.close();
	}

	/*
	 * 单条数据导出pdf到文件夹
	 * 
	 * 注意此处中文问题 这里应该详细说：主要在ireport里变下就行了。看图
	 * 
	 * 1）在ireport的classpath中加入iTextAsian.jar 2）在ireport画jrxml时，看ireport最左边有个属性栏。
	 * 
	 * 下边的设置就在点字段的属性后出现。 pdf font name ：STSong-Light ，pdf encoding ：UniGB-UCS2-H
	 */
	private static void exportPdfToFile(JasperPrint jasperPrint,
			String foldername, String Filename, HttpServletRequest request,
			HttpServletResponse response) throws IOException, JRException {
		// 文件夹目标地址
		File file = new File(foldername);
		if (!file.exists()) {
			try {
				FileUtil.mkdir(foldername);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		response.setHeader("Content-Transfer-Encoding","binary");
		response.setHeader("Cache-Control", "must-revalidate, post-check=0, pre-check=0");
		response.setHeader("Pragma", "public");
		FileOutputStream fos = new FileOutputStream(foldername + "\\" + Filename + ".pdf");
		JasperExportManager.exportReportToPdfStream(jasperPrint, fos);
		fos.close();
	}

	/**
	 * 单条数据导出word
	 */
	private static void exportWord(JasperPrint jasperPrint,
			String defaultFilename, HttpServletRequest request,
			HttpServletResponse response) throws JRException, IOException {
		response.setContentType("application/msword;charset=utf-8");
		response.setHeader("Content-Transfer-Encoding","binary");
		response.setHeader("Cache-Control", "must-revalidate, post-check=0, pre-check=0");
		response.setHeader("Pragma", "public");
		String defaultname = null;
		if (defaultFilename.trim() != null && defaultFilename != null) {
			defaultname = defaultFilename + ".doc";
		} else {
			defaultname = "export.doc";
		}
		String fileName = new String(defaultname.getBytes("GBK"), "ISO8859_1");
		response.setHeader("Content-disposition", "attachment; filename=" + fileName);
		JRExporter exporter = new JRRtfExporter();
		exporter.setParameter(JRExporterParameter.JASPER_PRINT, jasperPrint);
		exporter.setParameter(JRExporterParameter.OUTPUT_STREAM, response.getOutputStream());
		exporter.exportReport();
	}
	
	/**
	 * 单条数据导出word
	 */
	private static void exportWordInline(JasperPrint jasperPrint,
			String defaultFilename, HttpServletRequest request,
			HttpServletResponse response) throws JRException, IOException {
		response.setContentType("application/msword;charset=utf-8");
		response.setHeader("Content-Transfer-Encoding","binary");
		response.setHeader("Cache-Control", "must-revalidate, post-check=0, pre-check=0");
		response.setHeader("Pragma", "public");
		String defaultname = null;
		if (defaultFilename.trim() != null && defaultFilename != null) {
			defaultname = defaultFilename + ".doc";
		} else {
			defaultname = "export.doc";
		}
		String fileName = new String(defaultname.getBytes("GBK"), "ISO8859_1");
		response.setContentType("application/word");
		response.setHeader("Content-disposition", "inline; filename="+ fileName);
		JRExporter exporter = new JRRtfExporter();
		exporter.setParameter(JRExporterParameter.JASPER_PRINT, jasperPrint);
		exporter.setParameter(JRExporterParameter.OUTPUT_STREAM, response.getOutputStream());
		exporter.exportReport();
	}

	/**
	 * 单条数据导出word
	 */
	private static void exportHtml(JasperPrint jasperPrint,
			String defaultFilename, File reportFile, HttpServletRequest request,
			HttpServletResponse response) throws JRException, IOException {
		response.setContentType("text/html;charset=UTF-8"); 
		PrintWriter out = response.getWriter(); 
		  
		JRHtmlExporter exporter = new JRHtmlExporter();  
		try { 
		    request.getSession().setAttribute(ImageServlet.DEFAULT_JASPER_PRINT_SESSION_ATTRIBUTE, jasperPrint); 
		    exporter.setParameter(JRExporterParameter.JASPER_PRINT, jasperPrint);   
		    exporter.setParameter(JRExporterParameter.OUTPUT_WRITER, out);   
		    exporter.setParameter(JRHtmlExporterParameter.IS_USING_IMAGES_TO_ALIGN, Boolean.FALSE); 
		    exporter.setParameter(JRExporterParameter.CHARACTER_ENCODING, "UTF-8");  
		    exporter.setParameter(JRHtmlExporterParameter.IS_REMOVE_EMPTY_SPACE_BETWEEN_ROWS,Boolean.FALSE); 
		    exporter.setParameter(JRHtmlExporterParameter.IMAGES_URI, "/JJPLUS/servlets/image?image="); 
		    //exporter.setParameter(JRExporterParameter.OUTPUT_STREAM, response.getOutputStream());
		    exporter.exportReport(); 
		} catch (JRException e) { 
		  logger.debug(" 生成html文件失败 .... ...."); 
		} 
	}
	
   /** 
   * Java文件操作 获取不带扩展名的文件名  
   */    
    public static String getFileNameNoEx(String filename) {     
       if ((filename != null) && (filename.length() > 0)) {     
            int dot = filename.lastIndexOf('.');     
            if ((dot >-1) && (dot < (filename.length()))) {     
            return filename.substring(0, dot);     
            }     
        }     
        return filename;     
    } 
	
	/**
	 * 单条数据导出word到文件夹
	 */
	private static void exportWordToFile(JasperPrint jasperPrint,
			String foldername, String Filename, HttpServletRequest request,
			HttpServletResponse response) throws IOException, JRException {
		// 文件夹目标地址
		File file = new File(foldername);
		if (!file.exists()) {
			try {
				FileUtil.mkdir(foldername);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		response.setHeader("Content-Transfer-Encoding","binary");
		response.setHeader("Cache-Control", "must-revalidate, post-check=0, pre-check=0");
		response.setHeader("Pragma", "public");
		JRExporter exporter = new JRRtfExporter();
		exporter.setParameter(JRExporterParameter.JASPER_PRINT, jasperPrint);
		FileOutputStream fos = new FileOutputStream(foldername + "\\" + Filename + ".doc");
		exporter.setParameter(JRExporterParameter.OUTPUT_STREAM, fos);
		exporter.exportReport();
		fos.close();
	}

	/**
	 * 单条数据导出excel
	 */
	public static void exportExcel(JasperPrint jasperPrint,
			String defaultFilename, HttpServletRequest request,
			HttpServletResponse response) throws IOException, JRException {
		logger.debug("执行导出excel   The method======= exportExcel() start.......................");
		/*
		 * 设置头信息
		 */
		response.setContentType("application/vnd.ms-excel");
		response.setHeader("Content-Transfer-Encoding","binary");
		response.setHeader("Cache-Control", "must-revalidate, post-check=0, pre-check=0");
		response.setHeader("Pragma", "public");
		String defaultname = null;
		if (defaultFilename.trim() != null && defaultFilename != null) {
			defaultname = defaultFilename + ".xls";
		} else {
			defaultname = "export.xls";
		}
		String fileName = new String(defaultname.getBytes("GBK"), "ISO8859_1");
		response.setHeader("Content-disposition", "attachment; filename="
				+ fileName);
		ServletOutputStream ouputStream = response.getOutputStream();
		JRXlsExporter exporter = new JRXlsExporter();
		exporter.setParameter(JRExporterParameter.JASPER_PRINT, jasperPrint);
		exporter.setParameter(JRExporterParameter.OUTPUT_STREAM, ouputStream);
		exporter.setParameter(JRXlsExporterParameter.IS_REMOVE_EMPTY_SPACE_BETWEEN_ROWS, Boolean.TRUE);
		exporter.setParameter(JRXlsExporterParameter.IS_ONE_PAGE_PER_SHEET, Boolean.FALSE);
		exporter.setParameter(JRXlsExporterParameter.IS_WHITE_PAGE_BACKGROUND, Boolean.FALSE);
		exporter.exportReport();
		ouputStream.flush();
		ouputStream.close();
	}

	/**
	 * 单条数据导出excel到文件夹
	 */
	public static void exportExcelToFile(JasperPrint jasperPrint,
			String foldername, String Filename, HttpServletRequest request,
			HttpServletResponse response) throws IOException, JRException {
		// logger.debug("执行导出excel   The method======= exportExcel() start.......................");
		// 文件夹目标地址
		File file = new File(foldername);
		if (!file.exists()) {
			try {
				FileUtil.mkdir(foldername);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		response.setHeader("Content-Transfer-Encoding","binary");
		response.setHeader("Cache-Control", "must-revalidate, post-check=0, pre-check=0");
		response.setHeader("Pragma", "public");
		JRXlsExporter exporter = new JRXlsExporter();
		exporter.setParameter(JRExporterParameter.JASPER_PRINT, jasperPrint);
		FileOutputStream fos = new FileOutputStream(foldername + "\\" + Filename + ".xls");
		exporter.setParameter(JRExporterParameter.OUTPUT_STREAM, fos);//
		exporter.setParameter(JRXlsExporterParameter.IS_REMOVE_EMPTY_SPACE_BETWEEN_ROWS, Boolean.TRUE);
		exporter.setParameter(JRXlsExporterParameter.IS_ONE_PAGE_PER_SHEET, Boolean.FALSE);
		exporter.setParameter(JRXlsExporterParameter.IS_WHITE_PAGE_BACKGROUND, Boolean.FALSE);
		exporter.exportReport();
		fos.close();
	}

	/**
	 * 打印
	 */
	public static void print(JasperPrint jasperPrint, String defaultFilename,
			HttpServletRequest request, HttpServletResponse response)
			throws IOException, JRException {
		JasperPrintManager.printReport(jasperPrint, false);
	}

	/**
	 * 按照类型导出不同格式文件
	 * 
	 * @param datas 数据
	 * @param type  文件类型
	 * @param is    jasper文件的来源
	 * @param request
	 * @param response
	 * @param defaultFilename默认的导出文件的名称
	 */    
	private static void export(Map map, String type, InputStream is, File file, String dataType,
			HttpServletRequest request, HttpServletResponse response,
			RestTemplate restTemplate, HttpHeaders httpHeaders) {
		// logger.debug("导出判断     The method======= export() start...");
		try {
			JasperReport jasperReport = (JasperReport) JRLoader.loadObject(is);
			prepareReport(jasperReport, type);
			JasperPrint jasperPrint = null;
			String irparams_name_beanparams = "";
			String irparam = "";
			String name_beanparams = "";
			String beanparam = "";
			String filename = "";
			
			List list = null;
			String classUrl = "";//"com.pcitc.web.report.SysUserInfo";
			if("javabean".equals(dataType)){
				irparams_name_beanparams = map.get("params").toString();
				irparam = irparams_name_beanparams.substring(0, irparams_name_beanparams.indexOf("@:@"));
				name_beanparams = irparams_name_beanparams.substring(irparams_name_beanparams.indexOf("@:@") + 3); 
				filename = name_beanparams.substring(0, name_beanparams.indexOf("@:@"));
				beanparam = name_beanparams.substring(name_beanparams.indexOf("@:@")+3);
				
				String beanparams[] = beanparam.split(";");
				String orgs[] = new String[beanparams.length-1];
				for(int i = 0; i < beanparams.length; i++){
					String paramKey = beanparams[i].substring(0,beanparams[i].indexOf(":"));
					String paramValue = beanparams[i].substring(beanparams[i].indexOf(":")+1);
					if("beanurl".equals(paramKey)){
						classUrl = paramValue;
						continue;
					}
					orgs[i] = paramValue ;//把前台参数，添加到javabean的getData方法（参数按顺序传递）
				}
			    Class clazz = Class.forName(classUrl);//包名.类名
			    Class[] cla = new Class[4];
			    cla[0] = String[].class;
			    cla[1] = HttpServletRequest.class;
			    cla[2] = RestTemplate.class;
			    cla[3] = HttpHeaders.class;
			    Method method = clazz.getMethod("getData", cla);//方法名，和参数的类对象
			    list = (List) method.invoke(clazz.newInstance(), (Object)orgs, request, restTemplate, httpHeaders);//类的实例，和参数
			    //ireport参数
			    Map parameters = new HashMap(); 
			    List listSource = new ArrayList();
			    //用户签章
			    if(list.size()>0){
			    	 //单条数据，取最后一项，其余项为图片
			    	 if(!"more".equals(list.get(list.size()-1))){
			    		 listSource.add(list.get(list.size()-1));//
			    	 }
			    	 boolean issetlist = false;//list赋值listSource，仅仅一次
				     for(int i =0; i<list.size(); i++){
				    	if(list.get(i) instanceof String){ 
					    	String imageUrl = (String)list.get(i);
					    	//★处理多条，不含图片
					    	if("more".equals(imageUrl) && !issetlist){
					    		listSource = new ArrayList();
					    		list.remove(0);//移除more项
					    		listSource = list;	
					    		//移除图片
					    		for(int icount=0; icount<listSource.size(); icount++){
					    			if(listSource.get(icount) instanceof String){
					    				//2015.04.15添加logo(领料单)
					    				imageUrl = (String) listSource.get(icount);
					    				listSource.remove(icount);
					    			}
					    		}
					    		issetlist = true;
					    		//break;
					    	}
					    	//单条数据，含图片
					    	if(imageUrl.contains("imagesurl")){
					    		String urlKey = imageUrl.substring(0,imageUrl.indexOf(":"));
					    		String urlVlue = imageUrl.substring(imageUrl.indexOf(":")+1);
					    		urlVlue = request.getRealPath(urlVlue);
					    		InputStream   imageIn   =   new   FileInputStream(urlVlue);//图片一个数据流 
					    		parameters.put(urlKey, imageIn);
					    	}
				    	}
					 } 
			    }
			    if(!"".equals(irparam.trim())){
			    	String irparams[] = irparam.split(";");
					for(int i = 0; i < irparams.length; i++){
						String paramKey = irparams[i].substring(0,irparams[i].indexOf(":"));
						String paramValue = irparams[i].substring(irparams[i].indexOf(":")+1);
						if("imagesurl".equals(paramKey)){
							String   imageRead   =   paramValue;//"d:\\1.jpg";
							//获得图片路径File   imageFile   =   new   File(imageRead); 
							InputStream   imageIn   =   new   FileInputStream(imageRead);//图片一个数据流 
							parameters.put("imagesurl", imageIn);
						}else{
							parameters.put(paramKey, paramValue);
						}
					}
			    }   
			    JRDataSource dataSource = new JRBeanCollectionDataSource(listSource);
			    jasperPrint = JasperFillManager.fillReport(
						jasperReport, parameters, dataSource);  
			}else{
				// 一个记录的id&name
				irparams_name_beanparams = map.get("params").toString();
				irparam = irparams_name_beanparams.substring(0, irparams_name_beanparams.indexOf("@:@"));
				filename = irparams_name_beanparams.substring(irparams_name_beanparams.indexOf("@:@") + 3);
				Map parameters = new HashMap(); 
				if(!"".equals(irparam.trim())){
					String params[] = irparam.split(";");
					for(int i = 0; i < params.length; i++){
						String paramKey = params[i].substring(0,params[i].indexOf(":"));
						String paramValue = params[i].substring(params[i].indexOf(":")+1);
						if("imagesurl".equals(paramKey)){
							String   imageRead   =   paramValue;//"d:\\1.jpg";
							//获得图片路径File   imageFile   =   new   File(imageRead); 
							InputStream   imageIn   =   new   FileInputStream(imageRead);//图片一个数据流 
							parameters.put("imagesurl", imageIn);
						}else{
							parameters.put(paramKey, paramValue);
						}
					}
				}
			}
			// 处理单条
			if (EXCEL_TYPE.equals(type)) {
				exportExcel(jasperPrint, filename, request, response);
			} else if (PDF_TYPE.equals(type)) {
				exportPdf(jasperPrint, filename, request, response);
			} else if (PDFINLINE_TYPE.equals(type)) {
				exportPdfInline(jasperPrint, filename, request, response);
			} else if (WORD_TYPE.equals(type)) {
				exportWord(jasperPrint, filename, request, response);
			}else if (WORDINLINE_TYPE.equals(type)) {
				exportWordInline(jasperPrint, filename, request, response);
			} else if (HTML_TYPE.equals(type)) {
				exportHtml(jasperPrint, filename, file, request, response);
			} else if (PRINT_TYPE.equals(type)) {
				print(jasperPrint, filename, request, response);
			}
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
		} 
		finally 
		{
			
		}
	}

	// 得到临时附件路径
	private static String getTemplatePath() {
		String templatePath = "";
		try {
			String classPath = java.net.URLDecoder.decode(JasperHelper.class.getResource("/").getPath(),"UTF-8");
			if(classPath.startsWith("/"))
			{
				classPath = classPath.substring(1,classPath.length());
			}
			classPath = changeSeparator(classPath);
			String basePath = classPath.substring(0,classPath.lastIndexOf(File.separator+"WEB-INF"+File.separator)+1);
			String tempPath = "\\template\\TemporaryFile\\";
			templatePath = changeSeparator(basePath + tempPath);
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		return templatePath;
	}

	/**
	 * 替换路径分隔符
	 * */
	private static String changeSeparator(String path)
	{
		if(path==null)return path;
		path = path.replace("/",File.separator);
		path = path.replace("\\",File.separator);
		return path;
	}
	
	/**
	 * 导出入口
	 * 
	 * @param exportType
	 *            导出文件的类型
	 * @param jaspername
	 *            jasper文件的名字 如： xx.jasper
	 * @param lists
	 *            导出的数据
	 * @param request
	 * @param response
	 * @param defaultFilename默认的导出文件的名称
	 */
	public static String exportmain(String exportType, String jaspername,
			Map map, String dataType, HttpServletRequest request, HttpServletResponse response,
			RestTemplate restTemplate, HttpHeaders httpHeaders) {
		logger.debug("进入导出 The method======= exportmain() start....");
		// 得到临时附件路径
		String srcTemplatePath = getTemplatePath() + UUID.randomUUID().toString()
				+ "\\";
		// jasper文件放在WebRoot/template/ireport/xx.jasper</span>
		String filenurl = request.getRealPath("/template/ireport/"+ jaspername);
		// 根据前台传进来的参数，判断是多条导出(打印)还是单条导出(打印)
		String pid = map.get("params").toString();
		String pids[] = pid.split(",,");

		if (pids.length == 1) {
			// 执行单条
			File file = new File(filenurl);
			InputStream is = null;
			try {
				is = new FileInputStream(file);
			} catch (Exception e) {
				logger.error("文件" + filenurl + "不存在。。。。。。。。。。");
			}
			export(map, exportType, is, file, dataType, request, response, restTemplate, httpHeaders);
			return "";
		} else {
			// 执行多条
			for (int i = 0; i < pids.length; i++) {
				Map params_namemap = new HashMap();
				params_namemap.put("params", pids[i]);
				InputStream istream = null;
				try {
					istream = new FileInputStream(new File(filenurl));
				} catch (Exception e) {
					logger.error("文件" + filenurl + "不存在。。。。。。。。。。");
				}
				moreexport(params_namemap, exportType, srcTemplatePath, istream, dataType, request, response, restTemplate, httpHeaders);
			}
			// 压缩文件夹zip
			String zipname = "";
			// 打印不压缩zip包
			if (!JasperHelper.PRINT_TYPE.equals(exportType)) {
				try {
					SimpleDateFormat sdf = new SimpleDateFormat(
							"yyyy年MM月dd日 HH时mm分ss秒 E ");
					String currtime = sdf.format(new Date());
					zipname = "工程项目管理(" + currtime + ").zip";
					/*ZipUtil.zip(srcTemplatePath, getTemplatePath(), zipname,
							"xmgl");*/
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
			return getTemplatePath() + zipname + "&@&" + srcTemplatePath;
		}
	}

	/**
	 * zip包下载到本地
	 * 
	 * @param response
	 *            HttpServletResponse
	 * @param filename
	 *            文件夹名称
	 * @param zipname
	 *            zip名称
	 */
	public static void export(HttpServletResponse response, String Foldername,
			String zipname) {
		// 压缩文件夹zip
		try {
			String filePath = zipname;
			File file = new File(filePath);
			// 处理文件名字符集
			String zipfile = zipname.substring(getTemplatePath().length());
			String sourceFileName = new String(zipfile.getBytes("GBK"), "ISO_8859_1");
			// 设置客户端打开类型
			response.setContentType("application/download");
			response.setContentLength((int) file.length());
			response.setHeader("Content-disposition", "attachment;filename=" + sourceFileName);
			// 读取文件流
			InputStream inputStream = new BufferedInputStream(new FileInputStream(filePath));
			OutputStream out = response.getOutputStream();
			try {
				int bytesRead = 0;
				byte[] buffer = new byte[8192];
				// 开始向客户端传输文件流
				while ((bytesRead = inputStream.read(buffer, 0, 8192)) != -1) {
					out.write(buffer, 0, bytesRead);
				}
			} catch (Exception e) {
				e.printStackTrace();
			}finally {
				inputStream.close();
				out.flush();
				out.close();
			}
			// 删除临时文件
			if (file.exists()) {
				// 删除文件
				File folderfile = null;
				try {
					folderfile = new File(zipname);
					FileUtil.delFile(file.getPath());
				} catch (Exception e) {
					e.printStackTrace();
				}
				// 删除目录
				try {
					FileUtil.delFolder(Foldername);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * 按照类型导出不同格式文件(多条)
	 * @param datas  数据
	 * @param type   文件类型
	 * @param is     jasper文件的来源
	 * @param request
	 * @param response
	 * @param defaultFilename默认的导出文件的名称
	 */
	private static void moreexport(
			Map map, String type, String foldername,InputStream is, String dataType,
			HttpServletRequest request, HttpServletResponse response,
			RestTemplate restTemplate, HttpHeaders httpHeaders) {
		// logger.debug("导出判断     The method======= export() start...");
		Connection con = null;
		try {		
			JasperReport jasperReport = (JasperReport) JRLoader.loadObject(is);
			prepareReport(jasperReport, type);
			JasperPrint jasperPrint = null;
			String irparams_name_beanparams = "";
			String irparam = "";
			String name_beanparams = "";
			String beanparam = "";
			String filename = "";
			List list = null;
			
			String classUrl = "";//"com.pcitc.server.ireport.bean.WeldExamine";
			if("javabean".equals(dataType)){
				irparams_name_beanparams = map.get("params").toString();
				irparam = irparams_name_beanparams.substring(0, irparams_name_beanparams.indexOf("@:@"));
				name_beanparams = irparams_name_beanparams.substring(irparams_name_beanparams.indexOf("@:@") + 3); 
				filename = name_beanparams.substring(0, name_beanparams.indexOf("@:@"));
				beanparam = name_beanparams.substring(name_beanparams.indexOf("@:@")+3);

				String beanparams[] = beanparam.split(";");
				String orgs[] = new String[beanparams.length-1];
				for(int i = 0; i < beanparams.length; i++){
					String paramKey = beanparams[i].substring(0,beanparams[i].indexOf(":"));
					String paramValue = beanparams[i].substring(beanparams[i].indexOf(":")+1);
					if("beanurl".equals(paramKey)){
						classUrl = paramValue;
						continue;
					}
					orgs[i] = paramValue ;//把前台参数，添加到javabean的getData方法（参数按顺序传递）
				}
			    Class clazz = Class.forName(classUrl);//包名.类名
			    Class[] cla = new Class[4];
			    cla[0] = String[].class;
			    cla[1] = HttpServletRequest.class;
			    cla[2] = RestTemplate.class;
			    cla[3] = HttpHeaders.class;
			    Method method = clazz.getMethod("getData", cla);//方法名，和参数的类对象
			    list = (List) method.invoke(clazz.newInstance(), (Object)orgs, request, restTemplate, httpHeaders);//类的实例，和参数
			    
			    //ireport参数
			    Map parameters = new HashMap(); 
			    List listSource = new ArrayList();
			    //用户签章
			    if(list.size()>0){
			    	 listSource.add(list.get(list.size()-1));//
				     for(int i =0; i<list.size(); i++){
					    if(i != list.size()-1 ){
					    	String imageUrl = (String)list.get(i);
					    	if(imageUrl.contains("imagesurl")){
					    		String urlKey = imageUrl.substring(0,imageUrl.indexOf(":"));
					    		String urlVlue = imageUrl.substring(imageUrl.indexOf(":")+1);
					    		urlVlue = request.getRealPath(urlVlue);
					    		InputStream   imageIn   =   new   FileInputStream(urlVlue);//图片一个数据流 
					    		parameters.put(urlKey, imageIn);
					    	}
				        }	
					 } 
			    }
			    if(!"".equals(irparam.trim())){
			    	String irparams[] = irparam.split(";");
					for(int i = 0; i < irparams.length; i++){
						String paramKey = irparams[i].substring(0,irparams[i].indexOf(":"));
						String paramValue = irparams[i].substring(irparams[i].indexOf(":")+1);
						if("imagesurl".equals(paramKey)){
							String   imageRead   =   paramValue;//"d:\\1.jpg";
							//获得图片路径File   imageFile   =   new   File(imageRead); 
							InputStream   imageIn   =   new   FileInputStream(imageRead);//图片一个数据流 
							parameters.put("imagesurl", imageIn);
						}else{
							parameters.put(paramKey, paramValue);
						}
					}
			    }   
			    JRDataSource dataSource = new JRBeanCollectionDataSource(listSource);
			    jasperPrint = JasperFillManager.fillReport(
						jasperReport, parameters, dataSource);  
			}else{
				// 一个记录的id&name
				irparams_name_beanparams = map.get("params").toString();
				irparam = irparams_name_beanparams.substring(0, irparams_name_beanparams.indexOf("@:@"));
				filename = irparams_name_beanparams.substring(irparams_name_beanparams.indexOf("@:@") + 3);
				Map parameters = new HashMap();
				if(!"".equals(irparam.trim())){
					String params[] = irparam.split(";");
					for(int i = 0; i < params.length; i++){
						String paramKey = params[i].substring(0,params[i].indexOf(":"));
						String paramValue = params[i].substring(params[i].indexOf(":")+1);
						if("imagesurl".equals(paramKey)){
							String   imageRead   =   paramValue;//"d:\\1.jpg";
							//获得图片路径File   imageFile   =   new   File(imageRead); 
							InputStream   imageIn   =   new   FileInputStream(imageRead);//图片一个数据流 
							parameters.put("imagesurl", imageIn);
						}else{
							parameters.put(paramKey, paramValue);
						}
					}
				}
			}
			//String pattern = "/";
			String[] strs = new String[]{"?",",","*","+","<",">","[","]",":","\\","/",";","=","|"} ;
			for(int i=0; i<strs.length; i++){
				//filename.
				if(filename.contains(strs[i])){
					filename = filename.replaceAll(strs[i], "");
				}
			}
			//filename = filename.replaceAll(pattern, "");
			// 处理单条
			if (EXCEL_TYPE.equals(type)) {
				exportExcelToFile(jasperPrint, foldername, filename, request,
						response);
			} else if (PDF_TYPE.equals(type)) {
				exportPdfToFile(jasperPrint, foldername, filename, request,
						response);
			} else if (WORD_TYPE.equals(type)) {
				exportWordToFile(jasperPrint, foldername, filename, request,
						response);
			} else if (PRINT_TYPE.equals(type)) {
				print(jasperPrint, filename, request, response);
			}
		} catch (JRException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {

		}
	}
}
