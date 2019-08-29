package com.pcitc.web.controller.paymentplan;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

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
import com.pcitc.base.system.SysDictionary;
import com.pcitc.base.util.CommonUtil;
import com.pcitc.web.common.BaseController;

@Controller
public class PaymentPlanController extends BaseController 
{
	private static final String PROJECT_INFO_LIST_BYCONDITION = "http://pcitc-zuul/system-proxy/out-provider/project-info-list-bycondition";

	@RequestMapping(method = RequestMethod.GET, value = "/paymentplan/project_main")
	public Object toPaymentPlanProjectMain(HttpServletRequest request) throws Exception 
	{
		// 费用类别
		List<SysDictionary> fylbList = CommonUtil.getDictionaryByParentCode("ROOT_FZJCZX_FYLX", restTemplate, httpHeaders);
		request.setAttribute("fylbList", fylbList);
		//System.out.println("fylbList::::"+JSON.toJSONString(fylbList));
		// 课题类型
		//List<SysDictionary> ktlxList = CommonUtil.getDictionaryByParentCode("ROOT_FZJCZX_KTLX", restTemplate, httpHeaders);
		//request.setAttribute("ktlxList", ktlxList);
		// 技术分类
		List<SysDictionary> jsflList = CommonUtil.getDictionaryByParentCode("ROOT_FZJCZX_JSFL", restTemplate, httpHeaders);
		request.setAttribute("jsflList", jsflList);
		
		// 三级级联：经费来源(公司类型财务)->单位类别->研究院
		List<SysDictionary> jflyList = CommonUtil.getDictionaryByParentCode("ROOT_FZJCZX_GSLXCW", restTemplate, httpHeaders);
		request.setAttribute("jflyList", jflyList);
		// 科技部二级级联： 专业处->专业类别
		List<SysDictionary> zycList = CommonUtil.getDictionaryByParentCode("ROOT_ZGSHJT_ZBJG_KJB", restTemplate, httpHeaders);
		request.setAttribute("zycList", zycList);
		
		// 负责单位
		List<SysDictionary> fzdwList = CommonUtil.getDictionaryByParentCode("ROOT_FZJCZX_FZDW", restTemplate, httpHeaders);
		request.setAttribute("fzdwList", fzdwList);
		// 分组类型
		//List<SysDictionary> fzlxList = CommonUtil.getDictionaryByParentCode("ROOT_FZJCZX_FZLX", restTemplate, httpHeaders);
		//request.setAttribute("fzlxList", fzlxList);
		// 部门
		List<SysDictionary> gsbmbmList = CommonUtil.getDictionaryByParentCode("ROOT_ZGSHJT_ZBJG", restTemplate, httpHeaders);
		request.setAttribute("gsbmbmList", gsbmbmList);

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
		// (汉字反查CODE),用于级联: 费用来源define11-单位类别define12-研究院define2
		
		return "stp/paymentplan/project_main";
	}
	
	@RequestMapping(value = "/paymentplan/project-info-list-bycondition", method = RequestMethod.POST)
	@ResponseBody
	public Object toBudgetMainTotal(@ModelAttribute("out")OutProjectInfo out,HttpServletRequest request) throws IOException 
	{
		//OutProjectInfo out = new OutProjectInfo();
		out.setNd("2018");
		out.setYsnd("2019");
		//out.setDefine11("C资产公司");
		ResponseEntity<List> responseEntity = this.restTemplate.exchange(PROJECT_INFO_LIST_BYCONDITION, HttpMethod.POST, new HttpEntity<OutProjectInfo>(out, this.httpHeaders), List.class);
		System.out.println("++++++++++++++++++++++++++++"+responseEntity.getBody().size());
		//System.out.println(JSON.toJSONString(responseEntity.getBody()));
		return JSON.toJSONString(responseEntity.getBody());
	}
}
