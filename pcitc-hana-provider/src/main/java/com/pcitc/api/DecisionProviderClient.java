package com.pcitc.api;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.pcitc.base.hana.report.CompanyCode;
import com.pcitc.base.hana.report.FundsComprehensiveAnalysis01;
import com.pcitc.base.hana.report.FundsComprehensiveAnalysis02;
import com.pcitc.base.hana.report.FundsComprehensiveAnalysis03;
import com.pcitc.base.hana.report.ProjectCode;
import com.pcitc.base.hana.report.ScientificCashFlow01;
import com.pcitc.base.hana.report.ScientificCashFlow02;
import com.pcitc.base.hana.report.ScientificCashFlow03;
import com.pcitc.service.ICommonService;
import com.pcitc.service.IDecisionService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

//决策中心服务接口
@Api(value = "Decision-API",description = "决策中心相关的接口")
@RestController
@RequestMapping("/hana/decision")  
public class DecisionProviderClient {

	@Autowired
	private IDecisionService decisionService;

	@Autowired
	private ICommonService commonService;

	
	

	/**
	 * 报表名称: 科技资金现金流分析
	 * 报表编码: H1AM_KY_ZH_1003_01
	 */
	@ApiOperation(value = "科研资金净现金余额", notes = "报表名称: 科技资金现金流分析--科研资金净现金余额 ")
	@RequestMapping(value = "/funds/cash-flow/01", method = RequestMethod.POST)
	public JSONArray getCashFlow01Report(@ApiParam(value="月份:month如201812,公司代码:companyCode",required=true)@RequestBody String paramsJson) throws Exception {
		
		System.out.println(" paramsJson=" + paramsJson);
		JSONObject jo = JSONObject.parseObject(paramsJson);
		String month = jo.getString("month");
		String companyCode = jo.getString("companyCode");

		Map map = new HashMap();
		map.put("month", month);
		map.put("companyCode", companyCode);
		List<ScientificCashFlow01> list = decisionService.getScientificCashFlow01Report(map);
		JSONArray json = JSONArray.parseArray(JSON.toJSONString(list));
		return json;
	}


	/**
	 * 报表名称: 科技资金现金流分析
	 * 报表编码: H1AM_KY_ZH_1003_02
	 */
	@ApiOperation(value = "项目分析", notes = "报表名称: 科技资金现金流分析--项目分析 ")
	@RequestMapping(value = "/funds/cash-flow/02", method = RequestMethod.POST)
	public List getcashflow02Report(@ApiParam(value="月份:month如201812,公司代码:companyCode",required=true)@RequestBody String paramsJson) throws Exception {
		System.out.println(" paramsJson=" + paramsJson);
		JSONObject jo = JSONObject.parseObject(paramsJson);
		String month = jo.getString("month");
		String companyCode = jo.getString("companyCode");

		Map map = new HashMap();
		map.put("month", month);
		map.put("companyCode", companyCode);
		List<ScientificCashFlow02> list = decisionService.getScientificCashFlow02Report(map);
		for(int i=0;i<list.size();i++)
		{
			ScientificCashFlow02 ss=(ScientificCashFlow02)list.get(0);
			ss.setLay_icon_open("/layuiadmin/layui/images/treegrid1_open.png");
			ss.setLay_icon("/layuiadmin/layui/images/treegrid2.png");
			String levle=ss.getG0XMCJBM1();
			if(!levle.equals("1"))
			{
				ss.setLay_is_open(false);
			}else
			{
				ss.setLay_is_open(false);
			}
		}

		return list;
	}

	/**
	 * 报表名称: 科技资金现金流分析
	 * 报表编码: H1AM_KY_ZH_1003_03
	 */
	@ApiOperation(value = "科研资金净现金余额", notes = "报表名称: 科技资金现金流分析--科研资金净现金余额   type 13投资活动现金流量净额占比分析,27:投资活动现金流量净额占比分析,46:期末现金流量占比分析 ")
	@RequestMapping(value = "/funds/cash-flow/03", method = RequestMethod.POST)
	public JSONArray getcashflow03Report(@ApiParam(value="月份:month 如201812,公司代码:companyCode,type:13 经营活动现金流量净额占比分析,27 投资活动现金流量净额占比分析,46 期末现金流量占比分析",required=true)@RequestBody String paramsJson) throws Exception {
		System.out.println(" paramsJson=" + paramsJson);
		JSONObject jo = JSONObject.parseObject(paramsJson);
		String month = jo.getString("month");
		String type = jo.getString("type");
		String companyCode = jo.getString("companyCode");
		Map map = new HashMap();
		map.put("month", month);
		map.put("type", type);
		map.put("companyCode", companyCode);
		System.out.println(">>>>>>>>>>>>>month " + month);
		StringBuffer sb=new StringBuffer();
		if(companyCode!=null && !companyCode.equals(""))
		{
			   String arr[]=companyCode.split(",");
			   sb.append(" AND G0GSDM in  (");
			   for(int i=0;i<arr.length;i++)
			   {
				  String str=arr[i];
				  if(str!=null && !str.equals(""))
				  {
					  if(i>0)
					  {
						  sb.append(",");
					  }
					  sb.append("'"+str+"'");
				  }
			   }
			   sb.append(" )");
		}
		map.put("sqlStr", sb.toString());
		List<ScientificCashFlow03> list = decisionService.getScientificCashFlow03Report(map);
		JSONArray json = JSONArray.parseArray(JSON.toJSONString(list));
		return json;
	}
	
	
	
	
	
	
	
	
	

	/**
	 * 报表名称:科研经费综合分析    报表编码: H1AM_KY_ZH_1001_01
	 */
	@ApiOperation(value = "科研经费预算投入年度趋势分析", notes = "科研经费综合分析-科研经费预算投入年度趋势分析")
	@RequestMapping(value = "/funds/all-analysis/01", method = RequestMethod.POST)
	public JSONArray getFundsComprehensiveAnalysis01Report(@ApiParam(value="月份:month如201812,公司代码:companyCode",required=true)@RequestBody String paramsJson) throws Exception {
		System.out.println(" paramsJson=" + paramsJson);
		JSONObject jo = JSONObject.parseObject(paramsJson);
		String month = jo.getString("month");
		String companyCode = jo.getString("companyCode");
		Map map = new HashMap();
		map.put("month", month);
		map.put("companyCode", companyCode);
		List<FundsComprehensiveAnalysis01> list = decisionService.getFundsComprehensiveAnalysis01Report(map);
		JSONArray json = JSONArray.parseArray(JSON.toJSONString(list));
		return json;
		
	}
	
	/**
	 * 报表名称:科研经费综合分析    报表编码: H1AM_KY_ZH_1001_02
	 */
	@ApiOperation(value = "预算经费、实际经费分析", notes = "科研经费综合分析-预算经费、实际经费分析")
	@RequestMapping(value = "/funds/all-analysis/02", method = RequestMethod.POST)
	public JSONArray getFundsComprehensiveAnalysis02Report(@ApiParam(value="月份:month如201812,公司代码:companyCode,类型:type:项目类型经费project、资金来源source、管理级别manage",required=true)@RequestBody String paramsJson) throws Exception {
		System.out.println(" paramsJson=" + paramsJson);
		JSONObject jo = JSONObject.parseObject(paramsJson);
		String month = jo.getString("month");
		String companyCode = jo.getString("companyCode");
		String type = jo.getString("type");
		Map map = new HashMap();
		map.put("month", month);
		map.put("companyCode", companyCode);
		map.put("type", type);
		List<FundsComprehensiveAnalysis02> list = decisionService.getFundsComprehensiveAnalysis02Report(map);
		JSONArray json = JSONArray.parseArray(JSON.toJSONString(list));
		return json;
		
	}
	
	/**
	 * 报表名称:科研经费综合分析    报表编码: H1AM_KY_ZH_1001_03
	 */
	@ApiOperation(value = "研究院科研经费资金使用率分析", notes = "科研经费综合分析-研究院科研经费资金使用率分析")
	@RequestMapping(value = "/funds/all-analysis/03", method = RequestMethod.POST)
	public List getFundsComprehensiveAnalysis03Report(@ApiParam(value="月份:month如201812,公司代码:companyCode",required=true)@RequestBody String paramsJson) throws Exception {
		System.out.println(" paramsJson=" + paramsJson);
		JSONObject jo = JSONObject.parseObject(paramsJson);
		String month = jo.getString("month");
		String companyCode = jo.getString("companyCode");
		Map map = new HashMap();
		map.put("month", month);
		map.put("companyCode", companyCode);
		
		List<FundsComprehensiveAnalysis03> list = decisionService.getFundsComprehensiveAnalysis03Report(map);
		return list;
	}
	
	
	
	

}
	
	
	
	
	
	
	
	
