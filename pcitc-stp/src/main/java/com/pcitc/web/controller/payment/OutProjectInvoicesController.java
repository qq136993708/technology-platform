package com.pcitc.web.controller.payment;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.pcitc.base.system.SysDictionary;
import com.pcitc.base.util.CommonUtil;
import com.pcitc.base.util.DateUtil;
import com.pcitc.base.util.DateUtils;
import com.pcitc.base.util.IdUtil;
import com.pcitc.web.common.BaseController;

@Controller
public class OutProjectInvoicesController extends BaseController 
{
/*	private static final String PROJECT_INFO_LIST_BYCONDITION = "http://pcitc-zuul/system-proxy/out-provider/project-info-list-bycondition";
	private static final String PROJECT_PAYMENTPLANT_BATCHS = "http://pcitc-zuul/system-proxy/out-provider/out/project-paymentplan-batchs/";
	private static final String PROJECT_PAYMENTNOTICE_BATCHS = "http://pcitc-zuul/system-proxy/out-provider/out/project-paymentnotice-batchs/";
	private static final String PROJECT_PAYMENTPLANT_BYINFOID = "http://pcitc-zuul/system-proxy/out-provider/out/project-paymentplan-byinfoid/";
	private static final String PROJECT_PAYMENTPLANT_SAVE = "http://pcitc-zuul/system-proxy/out-provider/out/project-paymentplan-save";
	private static final String PROJECT_PAYMENTNOTICE_SAVE = "http://pcitc-zuul/system-proxy/out-provider/out/project-paymentnotice-save";
*/	
	
	@RequestMapping(method = RequestMethod.GET, value = "/payment/project_invoices_main")
	public Object toPaymentProjectInvoicesMain(HttpServletRequest request) throws Exception 
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
		
		return "stp/payment/project_invoices_main";
	}
	@RequestMapping(method = RequestMethod.GET, value = "/payment/project_invoices_edit")
	public Object toPaymentProjectInvoicesEdit(HttpServletRequest request) throws Exception 
	{
		
		String nd = request.getParameter("nd");
		if(nd == null) {
			nd = DateUtil.format(new Date(), DateUtil.FMT_YYYY);
		}
		request.setAttribute("nd", nd);
		request.setAttribute("projectId", request.getParameter("dataId"));
		request.setAttribute("dataId", IdUtil.createIdByTime());
		return "stp/payment/project_invoices_edit";
	}
}
