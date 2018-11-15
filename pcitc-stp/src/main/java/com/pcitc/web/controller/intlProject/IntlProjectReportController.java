package com.pcitc.web.controller.intlProject;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;
import com.pcitc.base.common.Chart3dData;
import com.pcitc.base.common.Chart3dResultData;
import com.pcitc.base.common.LayuiTableData;
import com.pcitc.base.common.LayuiTableParam;
import com.pcitc.web.common.BaseController;

@Controller
public class IntlProjectReportController extends BaseController {

	
	@RequestMapping(value = "/project/report/total_byunit", method = RequestMethod.POST)
	@ResponseBody
	public Object totalReportProjectInfo(@ModelAttribute("param") LayuiTableParam param) throws IOException 
	{
		LayuiTableData data = new LayuiTableData();
		System.out.println(JSON.toJSON(data).toString());
		data.setCode(0);
		data.setCount(10);
		
		String [] unitNames = new String[]{"勘探院","物探院","工程院","石科院","大连院","北化院","上海院","安工院"};
		List<Map<String,Object>> list = new ArrayList<Map<String,Object>>();
		for(String unitName:unitNames) 
		{
			Map<String,Object> map = new HashMap<String,Object>();
			Random r = new Random();
			map.put("unitName", unitName);
			map.put("projectNum", r.nextInt(10)+2);
			map.put("money", r.nextInt(10)*5+110);
			map.put("realMoney",r.nextInt(10)*5+120);
			
			list.add(map);
		}
		data.setData(list);
		return JSON.toJSON(data).toString();
	}
	
	@RequestMapping(value = "/intl_project/report/report_intl_project_main", method = RequestMethod.GET)
	public Object toTotalReportPage(HttpServletRequest request) throws IOException {
		
		return "stp/intlproject/report_intl_project_main";
	}

	@RequestMapping(value = "/project/report-3d", method = RequestMethod.POST)
	@ResponseBody
	public Object getAcceptTableData(HttpServletRequest request) throws IOException {
		String [] x = new String [] {"2012年","2013年","2014年","2015年","2016年","2017年","2018年"};
		String [] y = new String[] {"项目类别001","项目类别002","项目类别003","项目类别004","项目类别005","项目类别006","项目类别007","项目类别008","项目类别009","项目类别010"};

		List<String> lsx = new ArrayList<String>();
		for(String s:x) {lsx.add(s);}
		List<String> lsy = new ArrayList<String>();
		for(String s:y) {lsy.add(s);}
		List<Chart3dData> data = new ArrayList<Chart3dData>();
		for(String sx:lsx)
		{
			for(String sy:lsy) 
			{
				data.add(new Chart3dData(sx,sy,new Random().nextInt(100)));
			}
		}
		Chart3dResultData chardata = new Chart3dResultData(lsx,lsy,data);
		System.out.println(JSON.toJSONString(chardata));
		return chardata;
	}
	
	@RequestMapping(value = "/intl_project/report/report_apply_report_year", method = RequestMethod.GET)
	public Object toReportApplyReportYearPage(HttpServletRequest request) throws IOException {
		
		return "stp/intlproject/report_apply_report_year";
	}
	@RequestMapping(value = "/intl_project/report/report_plant_report_year", method = RequestMethod.GET)
	public Object toReportPlantReportYearPage(HttpServletRequest request) throws IOException {
		
		return "stp/intlproject/report_plant_report_year";
	}
	@RequestMapping(value = "/intl_project/report/report_contract_report_year", method = RequestMethod.GET)
	public Object toReportContractReportYearPage(HttpServletRequest request) throws IOException {
		
		return "stp/intlproject/report_contract_report_year";
	}

	@RequestMapping(value = "/intl_project/report/report_accept_report_year", method = RequestMethod.GET)
	public Object toReportAcceptReportYearPage(HttpServletRequest request) throws IOException {
		
		return "stp/intlproject/report_accept_report_year";
	}

}
