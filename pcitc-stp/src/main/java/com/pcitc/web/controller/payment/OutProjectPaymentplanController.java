package com.pcitc.web.controller.payment;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.StringUtils;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.pcitc.base.stp.out.OutProjectInfo;
import com.pcitc.base.stp.out.OutProjectPaymentplan;
import com.pcitc.base.system.SysDictionary;
import com.pcitc.base.util.CommonUtil;
import com.pcitc.base.util.DateUtil;
import com.pcitc.base.util.DateUtils;
import com.pcitc.base.util.IdUtil;
import com.pcitc.web.common.BaseController;
import com.pcitc.web.utils.EquipmentUtils;

@Controller
public class OutProjectPaymentplanController extends BaseController 
{
	private static final String PROJECT_INFO_LIST_BYCONDITION = "http://pcitc-zuul/system-proxy/out-provider/project-info-list-bycondition";
	private static final String PROJECT_PAYMENTPLANT_BATCHS = "http://pcitc-zuul/system-proxy/out-provider/out/project-paymentplan-batchs/";
	private static final String PROJECT_PAYMENTNOTICE_BATCHS = "http://pcitc-zuul/system-proxy/out-provider/out/project-paymentnotice-batchs/";
	private static final String PROJECT_PAYMENTPLANT_BYINFOID = "http://pcitc-zuul/system-proxy/out-provider/out/project-paymentplan-byinfoid/";
	private static final String PROJECT_PAYMENTPLANT_SAVE = "http://pcitc-zuul/system-proxy/out-provider/out/project-paymentplan-save";
	private static final String PROJECT_PAYMENTNOTICE_SAVE = "http://pcitc-zuul/system-proxy/out-provider/out/project-paymentnotice-save";
	
	
	@RequestMapping(method = RequestMethod.GET, value = "/payment/project_paymentplan_main")
	public Object toPaymentPlanProjectMain(HttpServletRequest request) throws Exception 
	{
		Map<String,String> dis = new HashMap<String,String>();
		dis.put("fylbList", "ROOT_FZJCZX_FYLX");//费用类别
		dis.put("ktlxList", "ROOT_FZJCZX_KTLX");//课题类型
		dis.put("jsflList", "ROOT_FZJCZX_JSFL");//技术分类
		dis.put("jflyList", "ROOT_FZJCZX_GSLXCW");//三级级联：经费来源(公司类型财务)->单位类别->研究院
		dis.put("zycList", "ROOT_ZGSHJT_ZBJG_KJB");//科技部二级级联： 专业处->专业类别
		dis.put("fzdwList", "ROOT_FZJCZX_FZDW");//负责单位
		dis.put("fzlxList", "ROOT_FZJCZX_FZLX");//分组类型
		dis.put("gsbmbmList", "ROOT_ZGSHJT_ZBJG");//部门
		
		Map<String,List<SysDictionary>> map = CommonUtil.getDictionaryByParentCodes(new ArrayList<String>(dis.values()), restTemplate, httpHeaders);
		for(java.util.Iterator<String> iter = dis.keySet().iterator();iter.hasNext();) 
		{
			String key = iter.next();
			request.setAttribute(key, map.get(dis.get(key)));
		}

		// 倒推部门-各个处室(汉字)->倒推部门
		String gsbmbmFlag = CommonUtil.getParameter(request, "gsbmbmFlag", "");// 部门
		String zycbmFlag = CommonUtil.getParameter(request, "zycbmFlag", "");// 处室
		String zylbbmFlag = CommonUtil.getParameter(request, "zylbbmFlag", "");// 专业类别
		

		request.setAttribute("zycbmFlag", zycbmFlag);
		request.setAttribute("gsbmbmFlag", gsbmbmFlag);
		request.setAttribute("zylbbmFlag", zylbbmFlag);
		request.setAttribute("ysnd", DateUtils.dateToStr(new Date(),DateUtils.FMT_YY));
		// (汉字反查CODE),用于级联: 费用来源define11-单位类别define12-研究院define2
		
		return "stp/payment/project_paymentplan_main";
	}
	@RequestMapping(method = RequestMethod.GET, value = "/payment/project_paymentplan_edit")
	public Object toPaymentPlanProjectEdit(HttpServletRequest request) throws Exception 
	{
		
		String nd = request.getParameter("nd");
		if(nd == null) {
			nd = DateUtil.format(new Date(), DateUtil.FMT_YYYY);
		}
		request.setAttribute("nd", nd);
		request.setAttribute("projectId", request.getParameter("dataId"));
		request.setAttribute("dataId", IdUtil.createIdByTime());
		return "stp/payment/project_paymentplan_edit";
	}
	@RequestMapping(method = RequestMethod.GET, value = "/payment/project_paymentnotice_main")
	public Object toPaymentNoticeProjectMain(HttpServletRequest request) throws Exception 
	{
		Map<String,String> dis = new HashMap<String,String>();
		dis.put("fylbList", "ROOT_FZJCZX_FYLX");//费用类别
		dis.put("ktlxList", "ROOT_FZJCZX_KTLX");//课题类型
		dis.put("jsflList", "ROOT_FZJCZX_JSFL");//技术分类
		dis.put("jflyList", "ROOT_FZJCZX_GSLXCW");//三级级联：经费来源(公司类型财务)->单位类别->研究院
		dis.put("zycList", "ROOT_ZGSHJT_ZBJG_KJB");//科技部二级级联： 专业处->专业类别
		dis.put("fzdwList", "ROOT_FZJCZX_FZDW");//负责单位
		dis.put("fzlxList", "ROOT_FZJCZX_FZLX");//分组类型
		dis.put("gsbmbmList", "ROOT_ZGSHJT_ZBJG");//部门
		
		Map<String,List<SysDictionary>> map = CommonUtil.getDictionaryByParentCodes(new ArrayList<String>(dis.values()), restTemplate, httpHeaders);
		for(java.util.Iterator<String> iter = dis.keySet().iterator();iter.hasNext();) 
		{
			String key = iter.next();
			request.setAttribute(key, map.get(dis.get(key)));
		}

		// 倒推部门-各个处室(汉字)->倒推部门
		String gsbmbmFlag = CommonUtil.getParameter(request, "gsbmbmFlag", "");// 部门
		String zycbmFlag = CommonUtil.getParameter(request, "zycbmFlag", "");// 处室
		String zylbbmFlag = CommonUtil.getParameter(request, "zylbbmFlag", "");// 专业类别
		

		request.setAttribute("zycbmFlag", zycbmFlag);
		request.setAttribute("gsbmbmFlag", gsbmbmFlag);
		request.setAttribute("zylbbmFlag", zylbbmFlag);
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
	@RequestMapping(value = "/payment/project-info-list-bycondition", method = RequestMethod.POST)
	@ResponseBody
	public Object toBudgetMainTotal(@ModelAttribute("out")OutProjectInfo out,HttpServletRequest request) throws IOException 
	{
		//out.setDefine11("C资产公司");
		if (!StringUtils.isBlank(out.getGsbmbm())) {
			SysDictionary sysDictionary = EquipmentUtils.getDictionaryByCode(out.getGsbmbm(), restTemplate, httpHeaders);
			if (sysDictionary != null) {
				out.setGsbmbm(sysDictionary.getNumValue());
			}
		}
		if (!StringUtils.isBlank(out.getZycbm())) {
			SysDictionary sysDictionary = EquipmentUtils.getDictionaryByCode(out.getZycbm(), restTemplate, httpHeaders);
			if (sysDictionary != null) {
				out.setZycbm(sysDictionary.getNumValue());
			}
		}
		if (!StringUtils.isBlank(out.getZylbbm())) {
			SysDictionary sysDictionary = EquipmentUtils.getDictionaryByCode(out.getZylbbm(), restTemplate, httpHeaders);
			if (sysDictionary != null) {
				out.setZylbbm(sysDictionary.getNumValue());
			}
		}
		System.out.println(JSON.toJSONString(out));
		ResponseEntity<?> responseEntity = this.restTemplate.exchange(PROJECT_INFO_LIST_BYCONDITION, HttpMethod.POST, new HttpEntity<OutProjectInfo>(out, this.httpHeaders), List.class);
		JSONArray array = JSONArray.parseArray(JSON.toJSONString(responseEntity.getBody()));
		for(int i = 0;i<array.size();i++) 
		{
			JSONObject obj = (JSONObject)array.get(i);
			if(obj.getString("define17") == null) 
			{
				obj.put("paymentPlanStatus", "未拨付");
			}else {
				obj.put("paymentPlanStatus", "已拨付");
			}
			if(obj.getString("define18") == null) 
			{
				obj.put("paymentNoticeStatus", "未报销");
			}else {
				obj.put("paymentNoticeStatus", "已报销");
			}
		}
		//System.out.println(array.toJSONString());
		return JSON.toJSONString(array);
	}
	
	@RequestMapping(value = "/payment/project-paymentplan-batchs", method = RequestMethod.POST)
	@ResponseBody
	public Object getprojectPaymentplanList(@ModelAttribute("out")OutProjectInfo out,HttpServletRequest request) throws IOException 
	{
		if(StringUtils.isBlank(out.getYsnd())) {
			out.setYsnd(DateUtils.dateToStr(new Date(),DateUtils.FMT_YY));
		}
		ResponseEntity<?> responseEntity = this.restTemplate.exchange(PROJECT_PAYMENTPLANT_BATCHS+out.getYsnd(), HttpMethod.POST, new HttpEntity<Object>(this.httpHeaders), List.class);
		
		return JSON.toJSONString(responseEntity.getBody());
	}
	@RequestMapping(value = "/payment/project-paymentnotice-batchs", method = RequestMethod.POST)
	@ResponseBody
	public Object getprojectPaymentnoticeList(@ModelAttribute("out")OutProjectInfo out,HttpServletRequest request) throws IOException 
	{
		if(StringUtils.isBlank(out.getYsnd())) {
			out.setYsnd(DateUtils.dateToStr(new Date(),DateUtils.FMT_YY));
		}
		ResponseEntity<?> responseEntity = this.restTemplate.exchange(PROJECT_PAYMENTNOTICE_BATCHS+out.getYsnd(), HttpMethod.POST, new HttpEntity<Object>(this.httpHeaders), List.class);
		
		return JSON.toJSONString(responseEntity.getBody());
	}
	
	@RequestMapping(value = "/payment/project-paymentplan-byinfoid", method = RequestMethod.POST)
	@ResponseBody
	public Object getprojectPaymentplanByInfoId(@ModelAttribute("payment")OutProjectPaymentplan payment,HttpServletRequest request) throws IOException 
	{
		System.out.println("project --- "+payment.getProjectId());
		ResponseEntity<?> responseEntity = this.restTemplate.exchange(PROJECT_PAYMENTPLANT_BYINFOID+payment.getProjectId(), HttpMethod.POST, new HttpEntity<Object>(this.httpHeaders), OutProjectPaymentplan.class);
		System.out.println("project:"+JSON.toJSONString(responseEntity.getBody()));
		return JSON.toJSONString(responseEntity.getBody());
	}
	
	@RequestMapping(value = "/payment/project-paymentplan-save", method = RequestMethod.POST)
	@ResponseBody
	public Object saveProjectPaymentplan(@ModelAttribute("payment")OutProjectPaymentplan payment,HttpServletRequest request) throws IOException 
	{
		
		ResponseEntity<?> responseEntity = this.restTemplate.exchange(PROJECT_PAYMENTPLANT_SAVE, HttpMethod.POST, new HttpEntity<OutProjectPaymentplan>(payment,this.httpHeaders), Object.class);
		System.out.println(JSON.toJSONString(responseEntity.getBody()));
		return JSON.toJSONString(responseEntity.getBody());
	}
	@RequestMapping(value = "/payment/project-paymentnotice-save", method = RequestMethod.POST)
	@ResponseBody
	public Object saveProjectPaymentnotice(@ModelAttribute("payment")OutProjectPaymentplan payment,HttpServletRequest request) throws IOException 
	{
		
		ResponseEntity<?> responseEntity = this.restTemplate.exchange(PROJECT_PAYMENTNOTICE_SAVE, HttpMethod.POST, new HttpEntity<OutProjectPaymentplan>(payment,this.httpHeaders), Object.class);
		System.out.println(JSON.toJSONString(responseEntity.getBody()));
		return JSON.toJSONString(responseEntity.getBody());
	}
}
