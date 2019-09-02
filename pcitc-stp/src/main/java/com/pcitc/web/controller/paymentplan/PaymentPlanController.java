package com.pcitc.web.controller.paymentplan;

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
import com.pcitc.base.stp.out.OutProjectInfo;
import com.pcitc.base.stp.out.OutProjectInfoPaymentplan;
import com.pcitc.base.system.SysDictionary;
import com.pcitc.base.util.CommonUtil;
import com.pcitc.base.util.DateUtils;
import com.pcitc.web.common.BaseController;

@Controller
public class PaymentPlanController extends BaseController 
{
	private static final String PROJECT_INFO_LIST_BYCONDITION = "http://pcitc-zuul/system-proxy/out-provider/project-info-list-bycondition";
	private static final String PROJECT_PAYMENTPLANT_LIST = "http://pcitc-zuul/system-proxy/out-provider/out/project-paymentplan-list";

	
	
	@RequestMapping(method = RequestMethod.GET, value = "/paymentplan/project_main")
	public Object toPaymentPlanProjectMain(HttpServletRequest request) throws Exception 
	{
		
		String ysnd = DateUtils.dateToStr(new Date(),DateUtils.FMT_YY);
		OutProjectInfoPaymentplan plan = new OutProjectInfoPaymentplan();
		plan.setNd(ysnd);
		ResponseEntity<?> responseEntity = this.restTemplate.exchange(PROJECT_PAYMENTPLANT_LIST, HttpMethod.POST, new HttpEntity<OutProjectInfoPaymentplan>(plan,this.httpHeaders), List.class);
		request.setAttribute("paymentplans", responseEntity.getBody());
		
		
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
		/*if (gsbmbmFlag.equals("") && !zycbmFlag.equals("")) {
			gsbmbmFlag = getGsbmbmFlagByzycbmFlag(gsbmbmFlag, zycbmFlag);
		}*/

		request.setAttribute("zycbmFlag", zycbmFlag);
		request.setAttribute("gsbmbmFlag", gsbmbmFlag);
		request.setAttribute("zylbbmFlag", zylbbmFlag);
		request.setAttribute("ysnd", ysnd);
		// (汉字反查CODE),用于级联: 费用来源define11-单位类别define12-研究院define2
		
		return "stp/paymentplan/project_main";
	}
	
	@RequestMapping(value = "/paymentplan/project-info-list-bycondition", method = RequestMethod.POST)
	@ResponseBody
	public Object toBudgetMainTotal(@ModelAttribute("out")OutProjectInfo out,HttpServletRequest request) throws IOException 
	{
		
		/*out.setNd("2018");
		out.setYsnd("2019");*/
		out.setDefine11("C资产公司");
		System.out.println(JSON.toJSONString(out));
		ResponseEntity<?> responseEntity = this.restTemplate.exchange(PROJECT_INFO_LIST_BYCONDITION, HttpMethod.POST, new HttpEntity<OutProjectInfo>(out, this.httpHeaders), List.class);
		System.out.println(JSON.toJSONString(responseEntity.getBody()));
		return JSON.toJSONString(responseEntity.getBody());
	}
	
	@RequestMapping(value = "/paymentplan/project-paymentplan-list", method = RequestMethod.POST)
	@ResponseBody
	public Object getprojectPaymentplanList(@ModelAttribute("out")OutProjectInfo out,HttpServletRequest request) throws IOException 
	{
		OutProjectInfoPaymentplan plan = new OutProjectInfoPaymentplan();
		if(StringUtils.isBlank(out.getYsnd())) {
			plan.setNd(DateUtils.dateToStr(new Date(),DateUtils.FMT_YY));
		}else {
			plan.setNd(out.getYsnd());
		}
		ResponseEntity<?> responseEntity = this.restTemplate.exchange(PROJECT_PAYMENTPLANT_LIST, HttpMethod.POST, new HttpEntity<OutProjectInfoPaymentplan>(plan,this.httpHeaders), List.class);
		
		return JSON.toJSONString(responseEntity.getBody());
	}
}
