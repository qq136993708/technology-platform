package com.pcitc.web.controller.intlProject;

import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.http.HttpServletResponse;

import org.apache.poi.xwpf.usermodel.BodyElementType;
import org.apache.poi.xwpf.usermodel.IBodyElement;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFTable;
import org.apache.poi.xwpf.usermodel.XWPFTableCell;
import org.apache.poi.xwpf.usermodel.XWPFTableRow;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.pcitc.base.common.LayuiTableData;
import com.pcitc.base.common.LayuiTableParam;
import com.pcitc.base.stp.IntlProject.IntlProjectApply;
import com.pcitc.base.stp.IntlProject.IntlProjectContract;
import com.pcitc.base.stp.IntlProject.IntlProjectInfo;
import com.pcitc.base.stp.IntlProject.IntlProjectPlant;
import com.pcitc.base.util.MyBeanUtils;
import com.pcitc.web.common.BaseController;

@Controller
public class IntlProjectReportDownloadController extends BaseController
{
	
	private static final String PROJECT_APPLY_GET_URL = "http://pcitc-zuul/stp-proxy/stp-provider/project/get-apply/";
	private static final String PROJECT_PLANT_GET_URL = "http://pcitc-zuul/stp-proxy/stp-provider/project/get-plant/";
	private static final String PROJECT_APPLY_JOIN_URL = "http://pcitc-zuul/stp-proxy/stp-provider/project/join-plant-apply-list";
	private static final String PROJECT_GET_INFO = "http://pcitc-zuul/stp-proxy/stp-provider/project/get-project/";
	private static final String PROJECT_GET_CONTRACT_URL = "http://pcitc-zuul/stp-proxy/stp-provider/project/get-contract/";
	
	private XWPFDocument docx;
	
	@RequestMapping("/intl_project/report_download/plant_running_list")
	public void downLoadPlantRunningListInfo(HttpServletResponse res) throws IOException {
		
		Map<String, Object> beanMap = new HashMap<String,Object>();//MyBeanUtils.transBean2Map(oldApply);
		
		
		URL path = this.getClass().getResource("/");
		File f = new File(path.getPath() + "static/report_template/intl_project_plant_runninglist_template.docx");

		
		//写入新文件
		String newFilePath = path.getPath() + "static/report_template/intl_project_plant_runninglist_"+System.currentTimeMillis()+".docx";
		File outFile = new File(newFilePath);
		   
		processDataAndDownload(f,beanMap,outFile);
	    //下载文件
		this.fileDownload(new File(newFilePath), res);
	}
	@RequestMapping("/intl_project/report_download/apply_list")
	public void downLoadApplyListInfo(HttpServletResponse res) throws IOException {
		
		Map<String, Object> beanMap = new HashMap<String,Object>();//MyBeanUtils.transBean2Map(oldApply);
		
		
		URL path = this.getClass().getResource("/");
		File f = new File(path.getPath() + "static/report_template/intl_project_plant_list_template.docx");

		
		//写入新文件
		String newFilePath = path.getPath() + "static/report_template/intl_project_plant_list_"+System.currentTimeMillis()+".docx";
		File outFile = new File(newFilePath);
		   
		processDataAndDownload(f,beanMap,outFile);
	    //下载文件
		this.fileDownload(new File(newFilePath), res);
	}
	
	@RequestMapping("/intl_project/report_download/apply/{applyId}")
	public void downLoadApplyInfo(@PathVariable("applyId") String applyId,HttpServletResponse res) throws IOException {
		
		IntlProjectApply oldApply = this.restTemplate.exchange(PROJECT_APPLY_GET_URL + applyId, HttpMethod.POST, new HttpEntity<Object>(this.httpHeaders), IntlProjectApply.class).getBody();
		Map<String, Object> beanMap = MyBeanUtils.transBean2Map(oldApply);
		
		
		URL path = this.getClass().getResource("/");
		File f = new File(path.getPath() + "static/report_template/intl_project_apply_template.docx");

		
		//写入新文件
		String newFilePath = path.getPath() + "static/report_template/intl_project_apply_"+System.currentTimeMillis()+".docx";
		File outFile = new File(newFilePath);
		   
		processDataAndDownload(f,beanMap,outFile);
	    //下载文件
		this.fileDownload(new File(newFilePath), res);
	}
	
	@RequestMapping("/intl_project/report_download/plant/{plantId}")
	public void downLoadPlantInfo(@PathVariable("plantId") String plantId,HttpServletResponse res) throws IOException {
		
		IntlProjectPlant oldplant = this.restTemplate.exchange(PROJECT_PLANT_GET_URL + plantId, HttpMethod.POST, new HttpEntity<Object>(this.httpHeaders), IntlProjectPlant.class).getBody();
		Map<String, Object> beanMap = MyBeanUtils.transBean2Map(oldplant);
		//获取计划申报列表
		LayuiTableParam param = new LayuiTableParam();
		param.setPage(1);
		param.setLimit(100);
		Map<String,Object> p = new HashMap<String,Object>();
		p.put("plantId", plantId);
		param.setParam(p);
		HttpEntity<LayuiTableParam> entity = new HttpEntity<LayuiTableParam>(param, this.httpHeaders);
		LayuiTableData data = this.restTemplate.exchange(PROJECT_APPLY_JOIN_URL, HttpMethod.POST, entity, LayuiTableData.class).getBody();
		List<Map<?,?>> plants = (List<Map<?,?>>)data.getData();
		StringBuffer sb = new StringBuffer();
		for(Map<?,?> apply:plants) 
		{
			sb.append(apply.get("applyName")+"\r\n");
		}
		beanMap.put("applyList", sb.toString());
		
		URL path = this.getClass().getResource("/");
		File f = new File(path.getPath() + "static/report_template/intl_project_plant_template.docx");
		
		//写入新文件
		String newFilePath = path.getPath() + "static/report_template/intl_project_plant_"+System.currentTimeMillis()+".docx";
		File outFile = new File(newFilePath);
		   
		processDataAndDownload(f,beanMap,outFile);
	    //下载文件
		this.fileDownload(new File(newFilePath), res);
	}
	@RequestMapping("/intl_project/report_download/info/{projectId}")
	public void downLoadProjectInfo(@PathVariable("projectId") String projectId,HttpServletResponse res) throws IOException {
		
		IntlProjectInfo prject = this.restTemplate.exchange(PROJECT_GET_INFO + projectId, HttpMethod.POST, new HttpEntity<Object>(this.httpHeaders), IntlProjectInfo.class).getBody();
		Map<String, Object> beanMap = MyBeanUtils.transBean2Map(prject);
		
		
		URL path = this.getClass().getResource("/");
		File f = new File(path.getPath() + "static/report_template/intl_project_info_template.docx");
		
		//写入新文件
		String newFilePath = path.getPath() + "static/report_template/intl_project_info_"+System.currentTimeMillis()+".docx";
	    File outFile = new File(newFilePath);
	   
	    processDataAndDownload(f,beanMap,outFile);
	    //下载文件
		this.fileDownload(new File(newFilePath), res);
	}
	@RequestMapping("/intl_project/report_download/contract/{contractId}")
	public void downLoadProjectContract(@PathVariable("contractId") String contractId,HttpServletResponse res) throws IOException {
		
		IntlProjectContract oldContract = this.restTemplate.exchange(PROJECT_GET_CONTRACT_URL + contractId, HttpMethod.POST, new HttpEntity<Object>(this.httpHeaders), IntlProjectContract.class).getBody();
		Map<String, Object> beanMap = MyBeanUtils.transBean2Map(oldContract);
		
		URL path = this.getClass().getResource("/");
		File f = new File(path.getPath() + "static/report_template/intl_project_contract_template.docx");
		
		//写入新文件
		String newFilePath = path.getPath() + "static/report_template/intl_project_contract_"+System.currentTimeMillis()+".docx";
		File outFile = new File(newFilePath);
	    
	    processDataAndDownload(f,beanMap,outFile);
	    //下载文件
		this.fileDownload(new File(newFilePath), res);
	}
	private void processDataAndDownload(File template,Map<String,Object> beanMap,File outFile) 
	{
		try {
			InputStream is = new FileInputStream(template);
			docx = new XWPFDocument(is);
			List<IBodyElement> bodyElements = docx.getBodyElements();// 所有对象（段落+表格）
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
			}
			//写入新文件
			FileOutputStream fos  = new FileOutputStream(outFile);
		    docx.write(fos);
		    //关闭流
		    closeIO(fos);
		    closeIO(is);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	private void replaseText(Map<String,Object> resMap,XWPFTableCell cell) 
	{
		List<String> vals = findByPattern(cell.getText(),"##\\{(.*?)\\}##");
		if(vals != null && vals.size() >0) 
		{
			for(String val:vals) {
				if(resMap.containsKey(val)) 
				{
					String vl =  resMap.get(val)==null?"": resMap.get(val).toString();
					String rs = this.replaseByPattern(cell.getText(), "##\\{"+val+"\\}##",vl);
					cell.removeParagraph(0);
					cell.setText(rs);
				}
			}
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
	private List<String> findByPattern(String sourceStr,String pattern)
	{
		List<String> rs = new ArrayList<String>();
		Pattern p = Pattern.compile(pattern);
		Matcher m = p.matcher(sourceStr);
		while (m.find()) {
			rs.add(m.group(1));
		}
		return rs;
	}
	private String replaseByPattern(String sourceStr,String pattern,String target)
	{
		try
		{
			return sourceStr.replaceAll(pattern, target);
			
		}catch(Exception e)
		{
			
		}
		return sourceStr;
	}
}
