package com.pcitc.web.controller.payment;

import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URL;
import java.net.URLEncoder;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
import com.pcitc.base.common.LayuiTableData;
import com.pcitc.base.common.LayuiTableParam;
import com.pcitc.base.common.Result;
import com.pcitc.base.util.DateUtil;
import com.pcitc.base.util.DateUtils;
import com.pcitc.base.util.IdUtil;
import com.pcitc.web.common.BaseController;

@Controller
public class OutProjectPaymentNoticeController extends BaseController 
{
	
	//private static final String PROJECT_PAYMENTNOTICE_BATCHS = "http://pcitc-zuul/system-proxy/out-provider/out/project-paymentnotice-batchs/";
	//private static final String PROJECT_PAYMENTNOTICE_SAVE = "http://pcitc-zuul/system-proxy/out-provider/out/project-paymentnotice-save";
	private static final String PROJECT_PAYMENTNOTICE_COMPANYLIST = "http://pcitc-zuul/system-proxy/out-provider/out/company-list";
	

	@RequestMapping(method = RequestMethod.GET, value = "/payment/project_paymentnotice_main")
	public Object toPaymentNoticeProjectMain(HttpServletRequest request) throws Exception 
	{
		request.setAttribute("ysnd", DateUtils.dateToStr(new Date(),DateUtils.FMT_YY));
		// (汉字反查CODE),用于级联: 费用来源define11-单位类别define12-研究院define2
		
		return "stp/payment/project_paymentnotice_main";
	}
	@RequestMapping(method = RequestMethod.GET, value = "/payment/project_paymentnotice_edit")
	public Object toPaymentNoticeProjectEdit(HttpServletRequest request) throws Exception 
	{
		
		String nd = request.getParameter("nd");
		if(nd == null) {
			nd = DateUtil.format(new Date(), DateUtil.FMT_YYYY);
		}
		request.setAttribute("nd", nd);
		request.setAttribute("projectId", request.getParameter("dataId"));
		request.setAttribute("dataId", IdUtil.createIdByTime());
		return "stp/payment/project_paymentnotice_edit";
	}
	@RequestMapping(value = "/payment/company-list", method = RequestMethod.POST)
	@ResponseBody
	public Object getCompanyList(@ModelAttribute("param") LayuiTableParam param, HttpServletRequest request) throws IOException {
		System.out.println(JSON.toJSONString(param));
		ResponseEntity<LayuiTableData> responseEntity = this.restTemplate.exchange(PROJECT_PAYMENTNOTICE_COMPANYLIST, HttpMethod.POST, new HttpEntity<LayuiTableParam>(param, this.httpHeaders), LayuiTableData.class);
		LayuiTableData data = responseEntity.getBody();
		System.out.println(JSON.toJSON(data).toString());
		return JSON.toJSON(data).toString();
	}

	@RequestMapping(value = "/payment/project-paymentnotice-create")
	@ResponseBody
	public Object projectPaymentnoticeCreate(@ModelAttribute("items") String items, HttpServletRequest request,HttpServletResponse res) throws IOException {
		System.out.println(items);
		
		//URL path = this.getClass().getResource("/");
		//String modlePath = path.getPath() + "static/payment/payment_notice_template.docx";
		//File file = new File(modlePath);
		
		/*InputStream is = new FileInputStream(modlePath);
		XWPFDocument doc = new XWPFDocument(is);
		// 替换段落里面的变量
		WordReadUtil.replaceInPara(doc, params);
		// 替换表格里面的变量
		WordReadUtil.replaceInTable(doc, params);
		OutputStream os = new FileOutputStream(outPath);
		doc.write(os);
		WordReadUtil.close(os);
		WordReadUtil.close(is);*/
		Result rs = new Result();
		rs.setData(IdUtil.createIdByTime());
		
		return rs;
	}
	@RequestMapping(value = "/payment/project-paymentnotice-download/{dataId}")
	public void donwloadPaymentnoticeCreate(@PathVariable("dataId") String dataId, HttpServletRequest request,HttpServletResponse res) throws IOException {
		System.out.println(dataId);
		
		URL path = this.getClass().getResource("/");
		String modlePath = path.getPath() + "static/payment/payment_notice_template.docx";
		File file = new File(modlePath);
		
		this.fileDownload(file, res);
	}
	
	
	@RequestMapping(value = "/payment/project-paymentnotice-sent", method = RequestMethod.POST)
	@ResponseBody
	public Object projectPaymentnoticeSent(@ModelAttribute("param") LayuiTableParam param, HttpServletRequest request) throws IOException {
		System.out.println(JSON.toJSONString(param));
		ResponseEntity<LayuiTableData> responseEntity = this.restTemplate.exchange(PROJECT_PAYMENTNOTICE_COMPANYLIST, HttpMethod.POST, new HttpEntity<LayuiTableParam>(param, this.httpHeaders), LayuiTableData.class);
		LayuiTableData data = responseEntity.getBody();
		System.out.println(JSON.toJSON(data).toString());
		return JSON.toJSON(data).toString();
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
}
