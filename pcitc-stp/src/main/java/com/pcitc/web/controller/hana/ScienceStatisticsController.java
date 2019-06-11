package com.pcitc.web.controller.hana;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.client.RestTemplate;

import com.pcitc.base.hana.report.CompanyCode;
import com.pcitc.base.hana.report.ProjectCode;
import com.pcitc.web.common.BaseController;
import com.pcitc.web.utils.HanaUtil;

//科技统计
@Controller
public class ScienceStatisticsController extends BaseController {
	private static final String GET_LIST = "http://pcitc-zuul/hana-proxy/hana/decision/get";
	
	  //年度科技项目支出决算与投入预算征集表
	  @RequestMapping(method = RequestMethod.GET, value = "/ss/ndkjxmzcjsytryszjb")
	  public String ndkjxmzcjsytryszjb(HttpServletRequest request) throws Exception
	  {
		    
	        return "stp/hana/scienceStatistics/ndkjxmzcjsytryszjb";
	  }
	 
	    //年度科技项目支出决算分项表
		 @RequestMapping(method = RequestMethod.GET, value = "/ss/ndkjxmzcjsfxb")
		 public String NDKJXMZCJSFXB(HttpServletRequest request) throws Exception
		 {
			    
		        return "stp/hana/scienceStatistics/ndkjxmzcjsfxb";
		 }
		 //企业自立科技项目年度决算支出情况
		 @RequestMapping(method = RequestMethod.GET, value = "/ss/qyzlkjxmndjszcqk")
		 public String QYZLKJXMNDJSZCQK(HttpServletRequest request) throws Exception
		 {
			    
		        return "stp/hana/scienceStatistics/qyzlkjxmndjszcqk";
		 }
		 //企业科研机构调查表_汇总表
		 @RequestMapping(method = RequestMethod.GET, value = "/ss/qykyjgdcb_hzb")
		 public String QYKYJGDCB_HZB(HttpServletRequest request) throws Exception
		 {
			    
		        return "stp/hana/scienceStatistics/qykyjgdcb_hzb";
		 }
		 //企业科研机构调查表 _略表
		 @RequestMapping(method = RequestMethod.GET, value = "/ss/qykyjgdcb_lb")
		 public String QYKYJGDCB_LB(HttpServletRequest request) throws Exception
		 {
			    
		        return "stp/hana/scienceStatistics/qykyjgdcb_lb";
		 }
		 //企业科研机构调查表_详表
		 @RequestMapping(method = RequestMethod.GET, value = "/ss/qykyjgdcb_xb")
		 public String QYKYJGDCB_XB(HttpServletRequest request) throws Exception
		 {
			    
		        return "stp/hana/scienceStatistics/qykyjgdcb_xb";
		 }
		 //人事数据表 
		 @RequestMapping(method = RequestMethod.GET, value = "/ss/rssjb")
		 public String RSSJB(HttpServletRequest request) throws Exception
		 {
			    
		        return "stp/hana/scienceStatistics/rssjb";
		 }
		 //股份公司财务报表_财务数据统计
		 @RequestMapping(method = RequestMethod.GET, value = "/ss/gfgscwbb_cwsjtj")
		 public String GFGSCWBB_CWSJTJ(HttpServletRequest request) throws Exception
		 {
			    
		        return "stp/hana/scienceStatistics/gfgscwbb_cwsjtj";
		 }
		 
		 
		 
		//股份公司财务报表_科技活动经济支出
		 @RequestMapping(method = RequestMethod.GET, value = "/ss/gfgscwbb_kjhdjjzc")
		 public String GFGSCWBB_KJHDJJZC(HttpServletRequest request) throws Exception
		 {
			    
		        return "stp/hana/scienceStatistics/gfgscwbb_kjhdjjzc";
		 }
		//股份公司专家列表
		 @RequestMapping(method = RequestMethod.GET, value = "/ss/gfgszjlb")
		 public String gfgszjlb(HttpServletRequest request) throws Exception
		 {
			    
		        return "stp/hana/scienceStatistics/gfgszjlb";
		 }
		//集团公司财务报表_企业经营活动情况
		 @RequestMapping(method = RequestMethod.GET, value = "/ss/jtgscwbb_qyjyhdqk")
		 public String jtgscwbb_qyjyhdqk(HttpServletRequest request) throws Exception
		 {
			    
		        return "stp/hana/scienceStatistics/jtgscwbb_qyjyhdqk";
		 }
		//集团公司财务报表_企业创新活动
		 @RequestMapping(method = RequestMethod.GET, value = "/ss/jtgscwbb_qycxhd")
		 public String jtgscwbb_qycxhd(HttpServletRequest request) throws Exception
		 {
			    
		        return "stp/hana/scienceStatistics/jtgscwbb_qycxhd";
		 }
		//集团公司科技情况统计表_科技投入表（股份）
		 @RequestMapping(method = RequestMethod.GET, value = "/ss/jtgskjqktjb_kjtrbgf")
		 public String JTGSKJQKTJB_KJTRBGF(HttpServletRequest request) throws Exception
		 {
			    
		        return "stp/hana/scienceStatistics/jtgskjqktjb_kjtrbgf";
		 }
		//集团公司科技情况统计表_科研投入表（集团）
		 @RequestMapping(method = RequestMethod.GET, value = "/ss/jtgskjqktjb_kjtrbjt")
		 public String jtgskjqktjb_kjtrbjt(HttpServletRequest request) throws Exception
		 {
			    
		        return "stp/hana/scienceStatistics/jtgskjqktjb_kjtrbjt";
		 }
		//集团公司科技情况统计表_科研机构调查表（股份）
		 @RequestMapping(method = RequestMethod.GET, value = "/ss/jtgskjqktjb_kyjgdcbgf")
		 public String jtgskjqktjb_kyjgdcbgf(HttpServletRequest request) throws Exception
		 {
			    
		        return "stp/hana/scienceStatistics/jtgskjqktjb_kyjgdcbgf";
		 }
		//集团公司科技情况统计表_科研机构调查表（集团）
		 @RequestMapping(method = RequestMethod.GET, value = "/ss/jtgskjqktjb_kyjgdcbjt")
		 public String jtgskjqktjb_kyjgdcbjt(HttpServletRequest request) throws Exception
		 {
			    
		        return "stp/hana/scienceStatistics/jtgskjqktjb_kyjgdcbjt";
		 }
	
	
}
