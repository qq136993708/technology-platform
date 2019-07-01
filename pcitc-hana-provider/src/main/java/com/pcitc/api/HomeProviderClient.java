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
import com.pcitc.base.common.LayuiTableData;
import com.pcitc.base.common.LayuiTableParam;
import com.pcitc.base.hana.report.H1AMKYSY100101;
import com.pcitc.base.hana.report.H1AMKYSY100104;
import com.pcitc.base.hana.report.H1AMKYSY100109;
import com.pcitc.base.hana.report.H1AMKYSY100117;
import com.pcitc.service.ICommonService;
import com.pcitc.service.IHomeService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;



//共用接口
@Api(value = "Common-API",description = "首页接口")
@RestController
@RequestMapping("/hana/home")  
public class HomeProviderClient {

	@Autowired
	private ICommonService commonService;
	
	@Autowired
	private IHomeService homeService;
	
	
	
	
	
	@ApiOperation(value = "人工成本支出详细", notes = "人工成本支出详细")
	@RequestMapping(value = "/actualPay_detail_data", method = RequestMethod.POST)
	public LayuiTableData actualPay_detail_data(@RequestBody LayuiTableParam param)throws Exception
	{
		return homeService.actualPayDetailData(param);
	}
	
	
	
    
    @ApiOperation(value = "首页--科研项目 ", notes = "首页--科研项目 ")
	@RequestMapping(value = "/H1AMKYSY100101", method = RequestMethod.POST)
	public JSONArray getH1AMKYSY100101Count(@ApiParam(value="月份:month如201812,公司代码:companyCode",required=true)@RequestBody String paramsJson) throws Exception {
		
		System.out.println(" paramsJson=" + paramsJson);
		JSONObject jo = JSONObject.parseObject(paramsJson);
		String month = jo.getString("month");
		String companyCode = jo.getString("companyCode");
		Map map = new HashMap();
		map.put("month", month);
		map.put("companyCode", companyCode);
		List<H1AMKYSY100101> list = homeService.getH1AMKYSY100101Count(map);
		JSONArray json = JSONArray.parseArray(JSON.toJSONString(list));
		return json;
	}
    
    
    @ApiOperation(value = "首页--科研装备 ", notes = "首页--科研装备")
   	@RequestMapping(value = "/H1AMKYSY100104", method = RequestMethod.POST)
   	public JSONArray getH1AMKYSY100104Count(@ApiParam(value="月份:month如201812,公司代码:companyCode",required=true)@RequestBody String paramsJson) throws Exception {
   		
   		System.out.println(" paramsJson=" + paramsJson);
   		JSONObject jo = JSONObject.parseObject(paramsJson);
   		String month = jo.getString("month");
   		String companyCode = jo.getString("companyCode");
   		Map map = new HashMap();
   		map.put("month", month);
   		map.put("companyCode", companyCode);
   		List<H1AMKYSY100104> list = homeService.getH1AMKYSY100104Count(map);
   		JSONArray json = JSONArray.parseArray(JSON.toJSONString(list));
   		return json;
   	}
    
    
    
    @ApiOperation(value = "首页--年度预算、经费支出 ", notes = "首页--年度预算、经费支出 ")
   	@RequestMapping(value = "/getndys_xfzc", method = RequestMethod.POST)
   	public JSONArray getndys_xfzc(@ApiParam(value="月份:month如201812,公司代码:companyCode",required=true)@RequestBody String paramsJson) throws Exception {
   		
   		System.out.println(" paramsJson=" + paramsJson);
   		JSONObject jo = JSONObject.parseObject(paramsJson);
   		String month = jo.getString("month");
   		String companyCode = jo.getString("companyCode");
   		Map map = new HashMap();
   		map.put("month", month);
   		map.put("companyCode", companyCode);
   		List<H1AMKYSY100104> list = homeService.getndys_xfzc(map);
   		JSONArray json = JSONArray.parseArray(JSON.toJSONString(list));
   		return json;
   	}
    
       

    //图形
    @ApiOperation(value = "首页--年度科研项目总览", notes = "首页--年度科研项目总览")
   	@RequestMapping(value = "/H1AMKYSY100109", method = RequestMethod.POST)
   	public JSONArray getH1AMKYSY100109Report(@ApiParam(value="月份:month如201812,公司代码:companyCode",required=true)@RequestBody String paramsJson) throws Exception {
   		
   		System.out.println(" paramsJson=" + paramsJson);
   		JSONObject jo = JSONObject.parseObject(paramsJson);
   		String month = jo.getString("month");
   		String companyCode = jo.getString("companyCode");
   		Map map = new HashMap();
   		map.put("month", month);
   		map.put("companyCode", companyCode);
   		List<H1AMKYSY100109> list = homeService.getH1AMKYSY100109Report(map);
   		JSONArray json = JSONArray.parseArray(JSON.toJSONString(list));
   		return json;
   	}
    

    @ApiOperation(value = "首页--新开项目占比情况、 新开国家项目比上年增长、新开重大专项比上年增长、新开“十条龙”项目比上年增长、新开前瞻性研究项目(院控)比上年增长、上年项目结题", notes = "首页--新开项目占比情况、 新开国家项目比上年增长、新开重大专项比上年增长、新开“十条龙”项目比上年增长、新开前瞻性研究项目(院控)比上年增长、上年项目结题")
   	@RequestMapping(value = "/H1AMKYSY100109COUNT", method = RequestMethod.POST)
   	public JSONArray getH1AMKYSY100109Count(@ApiParam(value="月份:month如201812,公司代码:companyCode",required=true)@RequestBody String paramsJson) throws Exception {
   		
   		System.out.println(" paramsJson=" + paramsJson);
   		JSONObject jo = JSONObject.parseObject(paramsJson);
   		String month = jo.getString("month");
   		String companyCode = jo.getString("companyCode");
   		Map map = new HashMap();
   		map.put("month", month);
   		map.put("companyCode", companyCode);
   		List<H1AMKYSY100109> list = homeService.getH1AMKYSY100109Count(map);
   		JSONArray json = JSONArray.parseArray(JSON.toJSONString(list));
   		return json;
   	}
    

    @ApiOperation(value = "首页--新开项目占比情况、 新开国家项目比上年增长、新开重大专项比上年增长、新开“十条龙”项目比上年增长、新开前瞻性研究项目(院控)比上年增长、上年项目结题", notes = "首页--新开项目占比情况、 新开国家项目比上年增长、新开重大专项比上年增长、新开“十条龙”项目比上年增长、新开前瞻性研究项目(院控)比上年增长、上年项目结题")
   	@RequestMapping(value = "/H1AMKYSY100109COUNT2", method = RequestMethod.POST)
   	public JSONArray H1AMKYSY100109COUNT2(@ApiParam(value="月份:month如201812,公司代码:companyCode",required=true)@RequestBody String paramsJson) throws Exception {
   		
   		System.out.println(" paramsJson=" + paramsJson);
   		JSONObject jo = JSONObject.parseObject(paramsJson);
   		String month = jo.getString("month");
   		String companyCode = jo.getString("companyCode");
   		Map map = new HashMap();
   		map.put("month", month);
   		map.put("companyCode", companyCode);
   		List<H1AMKYSY100109> list = homeService.getH1AMKYSY100109Count02(map);
   		JSONArray json = JSONArray.parseArray(JSON.toJSONString(list));
   		return json;
   	}
    
    
    @ApiOperation(value = "大型分析仪器、中型实验装置、专业软件（外购）、勘探前沿装备", notes = "大型分析仪器、中型实验装置、专业软件（外购）、勘探前沿装备")
   	@RequestMapping(value = "/getDzzk", method = RequestMethod.POST)
   	public JSONArray getDzzk(@ApiParam(value="月份:month如201812,公司代码:companyCode",required=true)@RequestBody String paramsJson) throws Exception 
    {
   		
   		System.out.println(" paramsJson=" + paramsJson);
   		JSONObject jo = JSONObject.parseObject(paramsJson);
   		String month = jo.getString("month");
   		String companyCode = jo.getString("companyCode");
   		Map map = new HashMap();
   		map.put("month", month);
   		map.put("companyCode", companyCode);
   		List<H1AMKYSY100117> list = homeService.getDzzk(map);
   		
   		System.out.println(">>>>>>>>>>>>>>>>>getDzzk " + list.size());
   		JSONArray json = JSON.parseArray(JSON.toJSONString(list));
   		
   		System.out.println(">>>>>>>>>>>>>>>>>getDzzk str " +JSON.toJSONString(list));
   		System.out.println(">>>>>>>>>>>>>>>>>getDzzk " + json.toString());
   		return json;
   	}
    
    
    
    
    @ApiOperation(value = "大型分析仪器、中型实验装置、专业软件（外购）、勘探前沿装备", notes = "大型分析仪器、中型实验装置、专业软件（外购）、勘探前沿装备")
   	@RequestMapping(value = "/getDzzk_bar", method = RequestMethod.POST)
   	public JSONArray getDzzk_bar(@ApiParam(value="月份:month如201812,公司代码:companyCode",required=true)@RequestBody String paramsJson) throws Exception 
    {
   		
   		System.out.println(" paramsJson=" + paramsJson);
   		JSONObject jo = JSONObject.parseObject(paramsJson);
   		String month = jo.getString("month");
   		String companyCode = jo.getString("companyCode");
   		Map map = new HashMap();
   		map.put("month", month);
   		map.put("companyCode", companyCode);
   		List<H1AMKYSY100117> list = homeService.getDzzk_bar(map);
   		
   		JSONArray json = JSON.parseArray(JSON.toJSONString(list));
   		System.out.println(">>>>>>>>>>>>>>>>>getDzzk_bar " + json.toString());
   		return json;
   	}
    
    
    
    @ApiOperation(value = "大型分析仪器、中型实验装置、专业软件（外购）、勘探前沿装备", notes = "大型分析仪器、中型实验装置、专业软件（外购）、勘探前沿装备")
   	@RequestMapping(value = "/get_direct_KYZB", method = RequestMethod.POST)
   	public JSONArray get_direct_KYZB(@ApiParam(value="月份:month如201812,公司代码:companyCode",required=true)@RequestBody String paramsJson) throws Exception 
    {
   		
   		System.out.println(" paramsJson=" + paramsJson);
   		JSONObject jo = JSONObject.parseObject(paramsJson);
   		String month = jo.getString("month");
   		String companyCode = jo.getString("companyCode");
   		Map map = new HashMap();
   		map.put("month", month);
   		map.put("companyCode", companyCode);
   		List<H1AMKYSY100117> list = homeService.get_direct_KYZB(map);
   		
   		JSONArray json = JSON.parseArray(JSON.toJSONString(list));
   		System.out.println(">>>>>>>>>>>>>>>>>get_direct_KYZB " + json.toString());
   		return json;
   	}
    
    
    
    
    @ApiOperation(value = "大型分析仪器、中型实验装置、专业软件（外购）、勘探前沿装备", notes = "大型分析仪器、中型实验装置、专业软件（外购）、勘探前沿装备")
   	@RequestMapping(value = "/get_direct_KYZB_02", method = RequestMethod.POST)
   	public JSONArray get_direct_KYZB_02(@ApiParam(value="月份:month如201812,公司代码:companyCode",required=true)@RequestBody String paramsJson) throws Exception 
    {
   		
   		System.out.println(" paramsJson=" + paramsJson);
   		JSONObject jo = JSONObject.parseObject(paramsJson);
   		String month = jo.getString("month");
   		String companyCode = jo.getString("companyCode");
   		Map map = new HashMap();
   		map.put("month", month);
   		map.put("companyCode", companyCode);
   		List<H1AMKYSY100117> list = homeService.get_direct_KYZB_02(map);
   		
   		JSONArray json = JSON.parseArray(JSON.toJSONString(list));
   		System.out.println(">>>>>>>>>>>>>>>>>get_direct_KYZB_02 " + json.toString());
   		return json;
   	}
    
    
    @ApiOperation(value = "大型分析仪器、中型实验装置、专业软件（外购）、勘探前沿装备", notes = "大型分析仪器、中型实验装置、专业软件（外购）、勘探前沿装备")
   	@RequestMapping(value = "/get_home_KYZB", method = RequestMethod.POST)
    public JSONArray get_home_KYZB(@ApiParam(value="月份:month如201812,公司代码:companyCode",required=true)@RequestBody String paramsJson) throws Exception 
    {
   		
   		System.out.println(" paramsJson=" + paramsJson);
   		JSONObject jo = JSONObject.parseObject(paramsJson);
   		String month = jo.getString("month");
   		String companyCode = jo.getString("companyCode");
   		Map map = new HashMap();
   		map.put("month", month);
   		map.put("companyCode", companyCode);
   		List<H1AMKYSY100117> list = homeService.get_home_KYZB(map);
   		
   		JSONArray json = JSON.parseArray(JSON.toJSONString(list));
   		
   		return json;
   	}
    
    @ApiOperation(value = "大型分析仪器、中型实验装置、专业软件（外购）、勘探前沿装备--统计", notes = "大型分析仪器、中型实验装置、专业软件（外购）、勘探前沿装备--统计")
   	@RequestMapping(value = "/get_home_KYZB_DETAIL_ALL_COUNT", method = RequestMethod.POST)
    public JSONObject get_home_KYZB_DETAIL_ALL_COUNT(@ApiParam(value="月份:month如201812,公司代码:companyCode",required=true)@RequestBody String paramsJson) throws Exception 
    {
   		System.out.println(" get_home_KYZB_DETAIL_ALL_COUNT paramsJson=" + paramsJson);
   		JSONObject jo = JSONObject.parseObject(paramsJson);
   		String month = jo.getString("month");
   		String type = jo.getString("type");
   		String companyCode = jo.getString("companyCode");
   		Map map = new HashMap();
   		map.put("type", type);
   		map.put("month", month);
   		map.put("companyCode", companyCode);
   		H1AMKYSY100117 list = homeService.get_home_KYZB_DETAIL_ALL_COUNT(map);
   		JSONObject jsonObj = (JSONObject) JSON.toJSON(list);  
   		System.out.println(">>>>>>>>>>>>>>>>>get_home_KYZB_DETAIL_ALL_COUNT " + jsonObj.toString());
   		return jsonObj;
   	}
    
    
    
    @ApiOperation(value = "大型分析仪器、中型实验装置、专业软件（外购）、勘探前沿装备", notes = "大型分析仪器、中型实验装置、专业软件（外购）、勘探前沿装备")
   	@RequestMapping(value = "/get_home_KYZB_02", method = RequestMethod.POST)
    public JSONArray get_home_KYZB_02(@ApiParam(value="月份:month如201812,公司代码:companyCode",required=true)@RequestBody String paramsJson) throws Exception 
    {
   		
   		System.out.println(" paramsJson=" + paramsJson);
   		JSONObject jo = JSONObject.parseObject(paramsJson);
   		String month = jo.getString("month");
   		String companyCode = jo.getString("companyCode");
   		Map map = new HashMap();
   		map.put("month", month);
   		map.put("companyCode", companyCode);
   		List<H1AMKYSY100117> list = homeService.get_home_KYZB_02(map);
   		
   		JSONArray json = JSON.parseArray(JSON.toJSONString(list));
   		//System.out.println(">>>>>>>>>>>>>>>>>get_home_KYZB_02 " + json.toString());
   		return json;
   	}
    
    
    
   /* @ApiOperation(value = "大型分析仪器、中型实验装置、专业软件（外购）、勘探前沿装备--详情页", notes = "大型分析仪器、中型实验装置、专业软件（外购）、勘探前沿装备--详情页")
   	@RequestMapping(value = "/get_home_KYZB_detail", method = RequestMethod.POST)
    public JSONArray get_home_KYZB_detail(@ApiParam(value="月份:month如201812,公司代码:companyCode",required=true)@RequestBody String paramsJson) throws Exception 
    {
   		
   		System.out.println(" paramsJson=" + paramsJson);
   		JSONObject jo = JSONObject.parseObject(paramsJson);
   		String month = jo.getString("month");
   		String companyCode = jo.getString("companyCode");
   		String type = jo.getString("type");
   		Map map = new HashMap();
   		map.put("month", month);
   		map.put("type", type);
   		map.put("companyCode", companyCode);
   		List<H1AMKYSY100117> list = homeService.get_home_KYZB_02(map);
   		
   		JSONArray json = JSON.parseArray(JSON.toJSONString(list));
   		System.out.println(">>>>>>>>>>>>>>>>>get_home_KYZB_detail " + json.toString());
   		return json;
   	}*/
    
    @ApiOperation(value = "大型分析仪器、中型实验装置、专业软件（外购）、勘探前沿装备--详情页", notes = "大型分析仪器、中型实验装置、专业软件（外购）、勘探前沿装备--详情页")
   	@RequestMapping(value = "/get_home_KYZB_detail", method = RequestMethod.POST)
   	public LayuiTableData get_home_KYZB_detail(@RequestBody LayuiTableParam param)throws Exception
   	{
    	System.out.println("get_home_KYZB_detail param=" + param);
   		return homeService.get_home_KYZB_detail(param);
   	}
    
    

    
    @ApiOperation(value = "下钻页-年度科研项目总览", notes = "下钻页-年度科研项目总览")
   	@RequestMapping(value = "/getNdkyxmzl", method = RequestMethod.POST)
   	public JSONArray getNdkyxmzl(@ApiParam(value="月份:month如201812,公司代码:companyCode",required=true)@RequestBody String paramsJson) throws Exception 
    {
   		
   		System.out.println(" paramsJson=" + paramsJson);
   		JSONObject jo = JSONObject.parseObject(paramsJson);
   		String month = jo.getString("month");
   		String companyCode = jo.getString("companyCode");
   		Map map = new HashMap();
   		map.put("month", month);
   		map.put("companyCode", companyCode);
   		List<H1AMKYSY100109> list = homeService.getNdkyxmzl(map);
   		
   		JSONArray json = JSON.parseArray(JSON.toJSONString(list));
   		System.out.println(">>>>>>>>>>>>>>>>>getNdkyxmzl " + json.toString());
   		return json;
   	}
    @ApiOperation(value = "年度科研项目总览", notes = "年度科研项目总览")
	@RequestMapping(value = "/getNdkyxmzlTble", method = RequestMethod.POST)
	public LayuiTableData getNdkyxmzlTble(@RequestBody LayuiTableParam param)throws Exception
	{
		return homeService.getNdkyxmzlTble(param) ;
	}
    

    @ApiOperation(value = "下钻页-年度科研项目总览", notes = "下钻页-年度科研项目总览")
   	@RequestMapping(value = "/getNdkyxmzl02", method = RequestMethod.POST)
   	public JSONArray getNdkyxmzl02(@ApiParam(value="月份:month如201812,公司代码:companyCode",required=true)@RequestBody String paramsJson) throws Exception 
    {
   		
   		System.out.println(" paramsJson=" + paramsJson);
   		JSONObject jo = JSONObject.parseObject(paramsJson);
   		String month = jo.getString("month");
   		String companyCode = jo.getString("companyCode");
   		Map map = new HashMap();
   		map.put("month", month);
   		map.put("companyCode", companyCode);
   		List<H1AMKYSY100109> list = homeService.getNdkyxmzl02(map);
   		
   		JSONArray json = JSON.parseArray(JSON.toJSONString(list));
   		System.out.println(">>>>>>>>>>>>>>>>>getNdkyxmzl02 " + json.toString());
   		return json;
   	}
    @ApiOperation(value = "下钻页-年度科研项目总览", notes = "下钻页-年度科研项目总览")
   	@RequestMapping(value = "/getNdkyxmzBar", method = RequestMethod.POST)
   	public JSONArray getNdkyxmzBar(@ApiParam(value="月份:month如201812,公司代码:companyCode",required=true)@RequestBody String paramsJson) throws Exception 
    {
   		
   		System.out.println(" paramsJson=" + paramsJson);
   		JSONObject jo = JSONObject.parseObject(paramsJson);
   		String month = jo.getString("month");
   		String companyCode = jo.getString("companyCode");
   		Map map = new HashMap();
   		map.put("month", month);
   		map.put("companyCode", companyCode);
   		List<H1AMKYSY100109> list = homeService.getNdkyxmzBar(map);
   		
   		JSONArray json = JSON.parseArray(JSON.toJSONString(list));
   		System.out.println(">>>>>>>>>>>>>>>>>getNdkyxmzBar " + json.toString());
   		return json;
   	}
    @ApiOperation(value = "下钻页-年度科研项目总览", notes = "下钻页-年度科研项目总览")
   	@RequestMapping(value = "/getNdkyxmzCircle", method = RequestMethod.POST)
   	public JSONArray getNdkyxmzCircle(@ApiParam(value="月份:month如201812,公司代码:companyCode",required=true)@RequestBody String paramsJson) throws Exception 
    {
   		
   		System.out.println(" paramsJson=" + paramsJson);
   		JSONObject jo = JSONObject.parseObject(paramsJson);
   		String month = jo.getString("month");
   		String companyCode = jo.getString("companyCode");
   		Map map = new HashMap();
   		map.put("month", month);
   		map.put("companyCode", companyCode);
   		List<H1AMKYSY100109> list = homeService.getNdkyxmzCircle(map);
   		
   		
   		JSONArray json = JSON.parseArray(JSON.toJSONString(list));
   		System.out.println(">>>>>>>>>>>>>>>>>getNdkyxmzCircle " + json.toString());
   		return json;
   	}
    
    
    
    
    
    @ApiOperation(value = "年度科研项目总览", notes = "年度科研项目总览")
   	@RequestMapping(value = "/getListLevel2", method = RequestMethod.POST)
   	public LayuiTableData getListLevel2(@RequestBody LayuiTableParam param)throws Exception
   	{
    	System.out.println(" param=" + param);
   		return homeService.getListLevel2(param);
   	}
    
    
    
    
    
    
    /**==========================================科研装备======================================*/

    //科研装备二级页面
    
    @ApiOperation(value = "下钻页-科研装备二级页面", notes = "下钻页-科研装备二级页面")
   	@RequestMapping(value = "/getLevel2KYZB01", method = RequestMethod.POST)
   	public JSONArray getLevel2KYZB01(@ApiParam(value="月份:month如201812,公司代码:companyCode",required=true)@RequestBody String paramsJson) throws Exception 
    {
   		
   		System.out.println(" paramsJson=" + paramsJson);
   		JSONObject jo = JSONObject.parseObject(paramsJson);
   		String month = jo.getString("month");
   		String companyCode = jo.getString("companyCode");
   		Map map = new HashMap();
   		map.put("month", month);
   		map.put("companyCode", companyCode);
   		List<H1AMKYSY100109> list = homeService.getLevel2KYZB01(map);
   		JSONArray json = JSON.parseArray(JSON.toJSONString(list));
   		System.out.println(">>>>>>>>>>>>>>>>>getLevel2KYZB01 " + json.toString());
   		return json;
   	}
    
    
    @ApiOperation(value = "下钻页-科研装备二级页面", notes = "下钻页-科研装备二级页面")
   	@RequestMapping(value = "/getLevel2KYZB02Bar", method = RequestMethod.POST)
   	public JSONArray getLevel2KYZB02Bar(@ApiParam(value="月份:month如201812,公司代码:companyCode",required=true)@RequestBody String paramsJson) throws Exception 
    {
   		
   		System.out.println(" paramsJson=" + paramsJson);
   		JSONObject jo = JSONObject.parseObject(paramsJson);
   		String month = jo.getString("month");
   		String companyCode = jo.getString("companyCode");
   		Map map = new HashMap();
   		map.put("month", month);
   		map.put("companyCode", companyCode);
   		List<H1AMKYSY100109> list = homeService.getLevel2KYZB02Bar(map);
   		JSONArray json = JSON.parseArray(JSON.toJSONString(list));
   		System.out.println(">>>>>>>>>>>>>>>>>getLevel2KYZB02Bar " + json.toString());
   		return json;
   	}
    
    
    @ApiOperation(value = "下钻页-科研装备二级页面", notes = "下钻页-科研装备二级页面")
   	@RequestMapping(value = "/getLevel2KYZB03Circle", method = RequestMethod.POST)
   	public JSONArray getLevel2KYZB03Circle(@ApiParam(value="月份:month如201812,公司代码:companyCode",required=true)@RequestBody String paramsJson) throws Exception 
    {
   		
   		System.out.println(" paramsJson=" + paramsJson);
   		JSONObject jo = JSONObject.parseObject(paramsJson);
   		String month = jo.getString("month");
   		String companyCode = jo.getString("companyCode");
   		Map map = new HashMap();
   		map.put("month", month);
   		map.put("companyCode", companyCode);
   		List<H1AMKYSY100109> list = homeService.getLevel2KYZB03Circle(map);
   		JSONArray json = JSON.parseArray(JSON.toJSONString(list));
   		System.out.println(">>>>>>>>>>>>>>>>>getLevel2KYZB03Circle " + json.toString());
   		return json;
   	}
    
    

    @ApiOperation(value = "下钻页-科研装备二级页面", notes = "下钻页-科研装备二级页面")
   	@RequestMapping(value = "/getKYZBTble", method = RequestMethod.POST)
   	public LayuiTableData getKYZBTble(@RequestBody LayuiTableParam param)throws Exception
   	{
    	System.out.println(" param=" + param);
   		return homeService.getKYZBTble(param);
   	}
    
    
    @ApiOperation(value = "下钻页-科研装备三级页面", notes = "下钻页-科研装备三级页面")
   	@RequestMapping(value = "/get_kyzb_table_data", method = RequestMethod.POST)
   	public LayuiTableData get_kyzb_table_data(@RequestBody LayuiTableParam param)throws Exception
   	{
    	System.out.println(" param=" + param);
   		return homeService.get_kyzb_table_data(param);
   	}
    
    
    
    /**==========================================科研装备 end======================================*/

    
    
    

    @ApiOperation(value = "下钻页-大型分析仪器", notes = "下钻页-大型分析仪器")
   	@RequestMapping(value = "/getZhuanziTableList", method = RequestMethod.POST)
   	public LayuiTableData getZhuanziTableList(@RequestBody LayuiTableParam param)throws Exception
   	{
    	System.out.println(" param=" + param);
   		return homeService.getZhuanziTableList(param);
   	}
    
    
    
    

    
    /**=========================================经费支出 二级页面======================================*/

    
    @ApiOperation(value = "下钻页-经费支出二级页面", notes = "下钻页-经费支出二级页面")
   	@RequestMapping(value = "/getJFZCLevel2", method = RequestMethod.POST)
   	public JSONArray getJFZCLevel2(@ApiParam(value="月份:month如201812,公司代码:companyCode",required=true)@RequestBody String paramsJson) throws Exception 
    {
   		
   		System.out.println(" paramsJson=" + paramsJson);
   		JSONObject jo = JSONObject.parseObject(paramsJson);
   		String month = jo.getString("month");
   		String companyCode = jo.getString("companyCode");
   		Map map = new HashMap();
   		map.put("month", month);
   		map.put("companyCode", companyCode);
   		List<H1AMKYSY100104> list = homeService.getJFZCLevel2(map);
   		JSONArray json = JSON.parseArray(JSON.toJSONString(list));
   		System.out.println(">>>>>>>>>>>>>>>>>getLevel2KYZB01 " + json.toString());
   		return json;
   	}
    
    
    @ApiOperation(value = "下钻页-经费支出二级页面", notes = "下钻页-经费支出二级页面")
   	@RequestMapping(value = "/getJFZCLevel2Bar", method = RequestMethod.POST)
   	public JSONArray getJFZCLevel2Bar(@ApiParam(value="月份:month如201812,公司代码:companyCode",required=true)@RequestBody String paramsJson) throws Exception 
    {
   		
   		System.out.println(" paramsJson=" + paramsJson);
   		JSONObject jo = JSONObject.parseObject(paramsJson);
   		String month = jo.getString("month");
   		String companyCode = jo.getString("companyCode");
   		String g0XMDL = jo.getString("g0XMDL");
   		Map map = new HashMap();
   		map.put("month", month);
   		map.put("g0XMDL", g0XMDL);
   		map.put("companyCode", companyCode);
   		List<H1AMKYSY100104> list = homeService.getJFZCLevel2Bar(map);
   		JSONArray json = JSON.parseArray(JSON.toJSONString(list));
   		System.out.println(">>>>>>>>>>>>>>>>>getJFZCLevel2Pie " + json.toString());
   		return json;
   	}
    
    @ApiOperation(value = "下钻页-经费下达二级页面", notes = "下钻页-经费下达二级页面")
   	@RequestMapping(value = "/getJFXDPie", method = RequestMethod.POST)
   	public JSONArray getJFXDPie(@ApiParam(value="月份:month如201812,公司代码:companyCode",required=true)@RequestBody String paramsJson) throws Exception 
    {
   		
   		System.out.println(" paramsJson=" + paramsJson);
   		JSONObject jo = JSONObject.parseObject(paramsJson);
   		String month = jo.getString("month");
   		String companyCode = jo.getString("companyCode");
   		String g0XMDL = jo.getString("g0XMDL");
   		Map map = new HashMap();
   		map.put("month", month);
   		map.put("g0XMDL", g0XMDL);
   		map.put("companyCode", companyCode);
   		List<H1AMKYSY100104> list = homeService.getJFXDPie(map);
   		JSONArray json = JSON.parseArray(JSON.toJSONString(list));
   		System.out.println(">>>>>>>>>>>>>>>>>getJFZCLevel2Pie " + json.toString());
   		return json;
   	}
    
    
    
    
    @ApiOperation(value = "下钻页-经费支出二级页面", notes = "下钻页-经费支出二级页面")
   	@RequestMapping(value = "/getJFZCLevel2Circle", method = RequestMethod.POST)
   	public JSONArray getJFZCLevel2Circle(@ApiParam(value="月份:month如201812,公司代码:companyCode",required=true)@RequestBody String paramsJson) throws Exception 
    {
   		
   		System.out.println(" paramsJson=" + paramsJson);
   		JSONObject jo = JSONObject.parseObject(paramsJson);
   		String month = jo.getString("month");
   		String companyCode = jo.getString("companyCode");
   		Map map = new HashMap();
   		map.put("month", month);
   		map.put("companyCode", companyCode);
   		List<H1AMKYSY100104> list = homeService.getJFZCLevel2Circle(map);
   		JSONArray json = JSON.parseArray(JSON.toJSONString(list));
   		System.out.println(">>>>>>>>>>>>>>>>>getJFZCLevel2Circle " + json.toString());
   		return json;
   	}
    
    

    @ApiOperation(value = "下钻页-经费支出二级页面", notes = "下钻页-经费支出二级页面")
   	@RequestMapping(value = "/getJFZCLevel2TAble", method = RequestMethod.POST)
   	public LayuiTableData getJFZCLevel2TAble(@RequestBody LayuiTableParam param)throws Exception
   	{
    	System.out.println(" param=" + param);
   		return homeService.getJFZCLevel2TAble(param);
   	}
    
    
    @ApiOperation(value = "下钻页-经费支出三级页面", notes = "下钻页-经费支出三级页面")
   	@RequestMapping(value = "/getJFZCLevel3TAble", method = RequestMethod.POST)
   	public LayuiTableData getJFZCLevel3TAble(@RequestBody LayuiTableParam param)throws Exception
   	{
    	System.out.println(" param=" + param);
   		return homeService.getJFZCLevel3TAble(param);
   	}
    
    
    
    /**==========================================经费支出 end======================================*/

    
    
    /**==========================================科研项目======================================*/

    
    @ApiOperation(value = "下钻页-二级页面科研项目-按项目数量", notes = "下钻页-二级页面科研项目-按项目数量")
   	@RequestMapping(value = "/getProjectByCountBar", method = RequestMethod.POST)
   	public JSONArray getProjectByCountBar(@ApiParam(value="月份:month如201812,公司代码:companyCode",required=true)@RequestBody String paramsJson) throws Exception 
    {
   		
   		System.out.println(" paramsJson=" + paramsJson);
   		JSONObject jo = JSONObject.parseObject(paramsJson);
   		String month = jo.getString("month");
   		String companyCode = jo.getString("companyCode");
   		Map map = new HashMap();
   		map.put("month", month);
   		map.put("companyCode", companyCode);
   		List<H1AMKYSY100109> list = homeService.getProjectByCountBar(map);
   		JSONArray json = JSON.parseArray(JSON.toJSONString(list));
   		System.out.println(">>>>>>>>>>>>>>>>>getProjectByCountBar " + json.toString());
   		return json;
   	}
    @ApiOperation(value = "下钻页-二级页面科研项目-按项目数量", notes = "下钻页-二级页面科研项目-按项目数量")
   	@RequestMapping(value = "/getProjectByCountPie", method = RequestMethod.POST)
   	public JSONArray getProjectByCountPie(@ApiParam(value="月份:month如201812,公司代码:companyCode",required=true)@RequestBody String paramsJson) throws Exception 
    {
   		
   		System.out.println(" paramsJson=" + paramsJson);
   		JSONObject jo = JSONObject.parseObject(paramsJson);
   		String month = jo.getString("month");
   		String companyCode = jo.getString("companyCode");
   		Map map = new HashMap();
   		map.put("month", month);
   		map.put("companyCode", companyCode);
   		List<H1AMKYSY100109> list = homeService.getProjectByCountPie(map);
   		JSONArray json = JSON.parseArray(JSON.toJSONString(list));
   		System.out.println(">>>>>>>>>>>>>>>>>getProjectByCountPie " + json.toString());
   		return json;
   	}
    
    @ApiOperation(value = "下钻页-二级页面科研项目-按项目数量", notes = "下钻页-二级页面科研项目-按项目数量")
   	@RequestMapping(value = "/getProjectByCountCricle", method = RequestMethod.POST)
   	public JSONArray getProjectByCountCricle(@ApiParam(value="月份:month如201812,公司代码:companyCode",required=true)@RequestBody String paramsJson) throws Exception 
    {
   		
   		System.out.println(" paramsJson=" + paramsJson);
   		JSONObject jo = JSONObject.parseObject(paramsJson);
   		String month = jo.getString("month");
   		String companyCode = jo.getString("companyCode");
   		Map map = new HashMap();
   		map.put("month", month);
   		map.put("companyCode", companyCode);
   		List<H1AMKYSY100109> list = homeService.getProjectByCountCricle(map);
   		JSONArray json = JSON.parseArray(JSON.toJSONString(list));
   		System.out.println(">>>>>>>>>>>>>>>>>getProjectByCountCricle " + json.toString());
   		return json;
   	}
    
    
    @ApiOperation(value = "下钻页-二级页面科研项目-按单位", notes = "下钻页-二级页面科研项目-按单位")
   	@RequestMapping(value = "/getProjectByUnitBar", method = RequestMethod.POST)
   	public JSONArray getProjectByUnitBar(@ApiParam(value="月份:month如201812,公司代码:companyCode",required=true)@RequestBody String paramsJson) throws Exception 
    {
   		
   		System.out.println(" paramsJson=" + paramsJson);
   		JSONObject jo = JSONObject.parseObject(paramsJson);
   		String month = jo.getString("month");
   		String companyCode = jo.getString("companyCode");
   		Map map = new HashMap();
   		map.put("month", month);
   		map.put("companyCode", companyCode);
   		List<H1AMKYSY100109> list = homeService.getProjectByUnitBar(map);
   		JSONArray json = JSON.parseArray(JSON.toJSONString(list));
   		System.out.println(">>>>>>>>>>>>>>>>>getProjectByUnitBar " + json.toString());
   		return json;
   	}
    
    
    
    @ApiOperation(value = "下钻页-二级页面科研项目-按单位", notes = "下钻页-二级页面科研项目-按单位")
   	@RequestMapping(value = "/getProjectByUnitPie", method = RequestMethod.POST)
   	public JSONArray getProjectByUnitPie(@ApiParam(value="月份:month如201812,公司代码:companyCode",required=true)@RequestBody String paramsJson) throws Exception 
    {
   		
   		System.out.println(" paramsJson=" + paramsJson);
   		JSONObject jo = JSONObject.parseObject(paramsJson);
   		String month = jo.getString("month");
   		String companyCode = jo.getString("companyCode");
   		Map map = new HashMap();
   		map.put("month", month);
   		map.put("companyCode", companyCode);
   		List<H1AMKYSY100109> list = homeService.getProjectByUnitPie(map);
   		JSONArray json = JSON.parseArray(JSON.toJSONString(list));
   		System.out.println(">>>>>>>>>>>>>>>>>getProjectByUnitPie " + json.toString());
   		return json;
   	}
    
    
    @ApiOperation(value = "下钻页-二级页面科研项目-按单位", notes = "下钻页-二级页面科研项目-按单位")
   	@RequestMapping(value = "/getProjectByUnitCricle", method = RequestMethod.POST)
   	public JSONArray getProjectByUnitCricle(@ApiParam(value="月份:month如201812,公司代码:companyCode",required=true)@RequestBody String paramsJson) throws Exception 
    {
   		
   		System.out.println(" paramsJson=" + paramsJson);
   		JSONObject jo = JSONObject.parseObject(paramsJson);
   		String month = jo.getString("month");
   		String companyCode = jo.getString("companyCode");
   		Map map = new HashMap();
   		map.put("month", month);
   		map.put("companyCode", companyCode);
   		List<H1AMKYSY100109> list = homeService.getProjectByUnitCricle(map);
   		JSONArray json = JSON.parseArray(JSON.toJSONString(list));
   		System.out.println(">>>>>>>>>>>>>>>>>getProjectByUnitCricle " + json.toString());
   		return json;
   	}
    
    
    @ApiOperation(value = "下钻页-二级页面科研项目-按分布", notes = "下钻页-二级页面科研项目-按分布")
   	@RequestMapping(value = "/getProjectByDistributeBar", method = RequestMethod.POST)
   	public JSONArray getProjectByDistributeBar(@ApiParam(value="月份:month如201812,公司代码:companyCode",required=true)@RequestBody String paramsJson) throws Exception 
    {
   		
   		System.out.println(" paramsJson=" + paramsJson);
   		JSONObject jo = JSONObject.parseObject(paramsJson);
   		String month = jo.getString("month");
   		String companyCode = jo.getString("companyCode");
   		Map map = new HashMap();
   		map.put("month", month);
   		map.put("companyCode", companyCode);
   		List<H1AMKYSY100109> list = homeService.getProjectByDistributeBar(map);
   		JSONArray json = JSON.parseArray(JSON.toJSONString(list));
   		System.out.println(">>>>>>>>>>>>>>>>>getProjectByDistributeBar " + json.toString());
   		return json;
   	}
    
    @ApiOperation(value = "下钻页-科研项目三级页面", notes = "下钻页-科研项目三级页面")
   	@RequestMapping(value = "/getProjectTable", method = RequestMethod.POST)
   	public LayuiTableData getProjectTable(@RequestBody LayuiTableParam param)throws Exception
   	{
    	System.out.println(" param=" + param);
   		return homeService.getProjectTable(param);
   	}
    
    
    /**==========================================科研项目 end======================================*/
    
    
    
    
    
    
    
    
    
    

    
    /**==========================================科研装备======================================*/

    
    @ApiOperation(value = "下钻页-二级页面科研装备-按项目数量", notes = "下钻页-二级页面科研装备-按项目数量")
   	@RequestMapping(value = "/getDeviceByCountBar", method = RequestMethod.POST)
   	public JSONArray getDeviceByCountBar(@ApiParam(value="月份:month如201812,公司代码:companyCode",required=true)@RequestBody String paramsJson) throws Exception 
    {
   		
   		System.out.println(" paramsJson=" + paramsJson);
   		JSONObject jo = JSONObject.parseObject(paramsJson);
   		String month = jo.getString("month");
   		String companyCode = jo.getString("companyCode");
   		Map map = new HashMap();
   		map.put("month", month);
   		map.put("companyCode", companyCode);
   		List<H1AMKYSY100109> list = homeService.getDeviceByCountBar(map);
   		JSONArray json = JSON.parseArray(JSON.toJSONString(list));
   		System.out.println(">>>>>>>>>>>>>>>>>getDeviceByCountBar " + json.toString());
   		return json;
   	}
    @ApiOperation(value = "下钻页-二级页面科研装备-按项目数量", notes = "下钻页-二级页面科研装备-按项目数量")
   	@RequestMapping(value = "/getDeviceByCountPie", method = RequestMethod.POST)
   	public JSONArray getDeviceByCountPie(@ApiParam(value="月份:month如201812,公司代码:companyCode",required=true)@RequestBody String paramsJson) throws Exception 
    {
   		
   		System.out.println(" paramsJson=" + paramsJson);
   		JSONObject jo = JSONObject.parseObject(paramsJson);
   		String month = jo.getString("month");
   		String companyCode = jo.getString("companyCode");
   		Map map = new HashMap();
   		map.put("month", month);
   		map.put("companyCode", companyCode);
   		List<H1AMKYSY100109> list = homeService.getDeviceByCountPie(map);
   		JSONArray json = JSON.parseArray(JSON.toJSONString(list));
   		System.out.println(">>>>>>>>>>>>>>>>>getDeviceByCountPie " + json.toString());
   		return json;
   	}
    
    @ApiOperation(value = "下钻页-二级页面科研装备-按项目数量", notes = "下钻页-二级页面科研装备-按项目数量")
   	@RequestMapping(value = "/getDeviceByCountCricle", method = RequestMethod.POST)
   	public JSONArray getDeviceByCountCricle(@ApiParam(value="月份:month如201812,公司代码:companyCode",required=true)@RequestBody String paramsJson) throws Exception 
    {
   		
   		System.out.println(" paramsJson=" + paramsJson);
   		JSONObject jo = JSONObject.parseObject(paramsJson);
   		String month = jo.getString("month");
   		String companyCode = jo.getString("companyCode");
   		Map map = new HashMap();
   		map.put("month", month);
   		map.put("companyCode", companyCode);
   		List<H1AMKYSY100109> list = homeService.getDeviceByCountCricle(map);
   		JSONArray json = JSON.parseArray(JSON.toJSONString(list));
   		System.out.println(">>>>>>>>>>>>>>>>>getDeviceByCountCricle " + json.toString());
   		return json;
   	}
    
    
    @ApiOperation(value = "下钻页-二级页面科研装备-按单位", notes = "下钻页-二级页面科研装备-按单位")
   	@RequestMapping(value = "/getDeviceByUnitBar", method = RequestMethod.POST)
   	public JSONArray getDeviceByUnitBar(@ApiParam(value="月份:month如201812,公司代码:companyCode",required=true)@RequestBody String paramsJson) throws Exception 
    {
   		
   		System.out.println(" paramsJson=" + paramsJson);
   		JSONObject jo = JSONObject.parseObject(paramsJson);
   		String month = jo.getString("month");
   		String companyCode = jo.getString("companyCode");
   		Map map = new HashMap();
   		map.put("month", month);
   		map.put("companyCode", companyCode);
   		List<H1AMKYSY100109> list = homeService.getDeviceByUnitBar(map);
   		JSONArray json = JSON.parseArray(JSON.toJSONString(list));
   		System.out.println(">>>>>>>>>>>>>>>>>getDeviceByUnitBar " + json.toString());
   		return json;
   	}
    
    
    
    @ApiOperation(value = "下钻页-二级页面科研装备-按单位", notes = "下钻页-二级页面科研装备-按单位")
   	@RequestMapping(value = "/getDeviceByUnitPie", method = RequestMethod.POST)
   	public JSONArray getDeviceByUnitPie(@ApiParam(value="月份:month如201812,公司代码:companyCode",required=true)@RequestBody String paramsJson) throws Exception 
    {
   		
   		System.out.println(" paramsJson=" + paramsJson);
   		JSONObject jo = JSONObject.parseObject(paramsJson);
   		String month = jo.getString("month");
   		String companyCode = jo.getString("companyCode");
   		Map map = new HashMap();
   		map.put("month", month);
   		map.put("companyCode", companyCode);
   		List<H1AMKYSY100109> list = homeService.getDeviceByUnitPie(map);
   		JSONArray json = JSON.parseArray(JSON.toJSONString(list));
   		System.out.println(">>>>>>>>>>>>>>>>>getDeviceByUnitPie " + json.toString());
   		return json;
   	}
    
    
    @ApiOperation(value = "下钻页-二级页面科研装备-按单位", notes = "下钻页-二级页面科研装备-按单位")
   	@RequestMapping(value = "/getDeviceByUnitCricle", method = RequestMethod.POST)
   	public JSONArray getDeviceByUnitCricle(@ApiParam(value="月份:month如201812,公司代码:companyCode",required=true)@RequestBody String paramsJson) throws Exception 
    {
   		
   		System.out.println(" paramsJson=" + paramsJson);
   		JSONObject jo = JSONObject.parseObject(paramsJson);
   		String month = jo.getString("month");
   		String companyCode = jo.getString("companyCode");
   		Map map = new HashMap();
   		map.put("month", month);
   		map.put("companyCode", companyCode);
   		List<H1AMKYSY100109> list = homeService.getDeviceByUnitCricle(map);
   		JSONArray json = JSON.parseArray(JSON.toJSONString(list));
   		System.out.println(">>>>>>>>>>>>>>>>>getDeviceByUnitCricle " + json.toString());
   		return json;
   	}
    
    
    @ApiOperation(value = "下钻页-二级页面科研装备-按分布", notes = "下钻页-二级页面科研装备-按分布")
   	@RequestMapping(value = "/getDeviceByDistributeBar", method = RequestMethod.POST)
   	public JSONArray getDeviceByDistributeBar(@ApiParam(value="月份:month如201812,公司代码:companyCode",required=true)@RequestBody String paramsJson) throws Exception 
    {
   		
   		System.out.println(" paramsJson=" + paramsJson);
   		JSONObject jo = JSONObject.parseObject(paramsJson);
   		String month = jo.getString("month");
   		String companyCode = jo.getString("companyCode");
   		Map map = new HashMap();
   		map.put("month", month);
   		map.put("companyCode", companyCode);
   		List<H1AMKYSY100109> list = homeService.getDeviceByDistributeBar(map);
   		JSONArray json = JSON.parseArray(JSON.toJSONString(list));
   		System.out.println(">>>>>>>>>>>>>>>>>getDeviceByDistributeBar " + json.toString());
   		return json;
   	}
    
    
    @ApiOperation(value = "下钻页-科研装备三级页面", notes = "下钻页-科研装备三级页面")
   	@RequestMapping(value = "/getDeviceTable", method = RequestMethod.POST)
   	public LayuiTableData getDeviceTable(@RequestBody LayuiTableParam param)throws Exception
   	{
    	System.out.println(" param=" + param);
   		return homeService.getDeviceTable(param);
   	}
    
    /**==========================================科研装备 end======================================*/
    
    
    
    
    
    
    
    
    

    /**==========================================预算======================================*/

    
    @ApiOperation(value = "下钻页-二级页面科研预算-按项目数量", notes = "下钻页-二级页面科研预算-按项目数量")
   	@RequestMapping(value = "/getBudgetByCountBar", method = RequestMethod.POST)
   	public JSONArray getBudgetByCountBar(@ApiParam(value="月份:month如201812,公司代码:companyCode",required=true)@RequestBody String paramsJson) throws Exception 
    {
   		
   		System.out.println(" paramsJson=" + paramsJson);
   		JSONObject jo = JSONObject.parseObject(paramsJson);
   		String month = jo.getString("month");
   		String companyCode = jo.getString("companyCode");
   		Map map = new HashMap();
   		map.put("month", month);
   		map.put("companyCode", companyCode);
   		List<H1AMKYSY100109> list = homeService.getBudgetByCountBar(map);
   		JSONArray json = JSON.parseArray(JSON.toJSONString(list));
   		System.out.println(">>>>>>>>>>>>>>>>>getBudgetByCountBar " + json.toString());
   		return json;
   	}
    @ApiOperation(value = "下钻页-二级页面科研预算-按项目数量", notes = "下钻页-二级页面科研预算-按项目数量")
   	@RequestMapping(value = "/getBudgetByCountPie", method = RequestMethod.POST)
   	public JSONArray getBudgetByCountPie(@ApiParam(value="月份:month如201812,公司代码:companyCode",required=true)@RequestBody String paramsJson) throws Exception 
    {
   		
   		System.out.println(" paramsJson=" + paramsJson);
   		JSONObject jo = JSONObject.parseObject(paramsJson);
   		String month = jo.getString("month");
   		String companyCode = jo.getString("companyCode");
   		Map map = new HashMap();
   		map.put("month", month);
   		map.put("companyCode", companyCode);
   		List<H1AMKYSY100109> list = homeService.getBudgetByCountPie(map);
   		JSONArray json = JSON.parseArray(JSON.toJSONString(list));
   		System.out.println(">>>>>>>>>>>>>>>>>getBudgetByCountPie " + json.toString());
   		return json;
   	}
    
    @ApiOperation(value = "下钻页-二级页面科研预算-按项目数量", notes = "下钻页-二级页面科研预算-按项目数量")
   	@RequestMapping(value = "/getBudgetByCountCricle", method = RequestMethod.POST)
   	public JSONArray getBudgetByCountCricle(@ApiParam(value="月份:month如201812,公司代码:companyCode",required=true)@RequestBody String paramsJson) throws Exception 
    {
   		
   		System.out.println(" paramsJson=" + paramsJson);
   		JSONObject jo = JSONObject.parseObject(paramsJson);
   		String month = jo.getString("month");
   		String companyCode = jo.getString("companyCode");
   		Map map = new HashMap();
   		map.put("month", month);
   		map.put("companyCode", companyCode);
   		List<H1AMKYSY100109> list = homeService.getBudgetByCountCricle(map);
   		JSONArray json = JSON.parseArray(JSON.toJSONString(list));
   		System.out.println(">>>>>>>>>>>>>>>>>getBudgetByCountCricle " + json.toString());
   		return json;
   	}
    
    
    @ApiOperation(value = "下钻页-二级页面科研预算-按单位", notes = "下钻页-二级页面科研预算-按单位")
   	@RequestMapping(value = "/getBudgetByUnitBar", method = RequestMethod.POST)
   	public JSONArray getBudgetByUnitBar(@ApiParam(value="月份:month如201812,公司代码:companyCode",required=true)@RequestBody String paramsJson) throws Exception 
    {
   		
   		System.out.println(" paramsJson=" + paramsJson);
   		JSONObject jo = JSONObject.parseObject(paramsJson);
   		String month = jo.getString("month");
   		String companyCode = jo.getString("companyCode");
   		Map map = new HashMap();
   		map.put("month", month);
   		map.put("companyCode", companyCode);
   		List<H1AMKYSY100109> list = homeService.getBudgetByUnitBar(map);
   		JSONArray json = JSON.parseArray(JSON.toJSONString(list));
   		System.out.println(">>>>>>>>>>>>>>>>>getBudgetByUnitBar " + json.toString());
   		return json;
   	}
    
    
    
    @ApiOperation(value = "下钻页-二级页面科研预算-按单位", notes = "下钻页-二级页面科研预算-按单位")
   	@RequestMapping(value = "/getBudgetByUnitPie", method = RequestMethod.POST)
   	public JSONArray getBudgetByUnitPie(@ApiParam(value="月份:month如201812,公司代码:companyCode",required=true)@RequestBody String paramsJson) throws Exception 
    {
   		
   		System.out.println(" paramsJson=" + paramsJson);
   		JSONObject jo = JSONObject.parseObject(paramsJson);
   		String month = jo.getString("month");
   		String companyCode = jo.getString("companyCode");
   		Map map = new HashMap();
   		map.put("month", month);
   		map.put("companyCode", companyCode);
   		List<H1AMKYSY100109> list = homeService.getBudgetByUnitPie(map);
   		JSONArray json = JSON.parseArray(JSON.toJSONString(list));
   		System.out.println(">>>>>>>>>>>>>>>>>getBudgetByUnitPie " + json.toString());
   		return json;
   	}
    
    
    @ApiOperation(value = "下钻页-二级页面科研预算-按单位", notes = "下钻页-二级页面科研预算-按单位")
   	@RequestMapping(value = "/getBudgetByUnitCricle", method = RequestMethod.POST)
   	public JSONArray getBudgetByUnitCricle(@ApiParam(value="月份:month如201812,公司代码:companyCode",required=true)@RequestBody String paramsJson) throws Exception 
    {
   		
   		System.out.println(" paramsJson=" + paramsJson);
   		JSONObject jo = JSONObject.parseObject(paramsJson);
   		String month = jo.getString("month");
   		String companyCode = jo.getString("companyCode");
   		Map map = new HashMap();
   		map.put("month", month);
   		map.put("companyCode", companyCode);
   		List<H1AMKYSY100109> list = homeService.getBudgetByUnitCricle(map);
   		JSONArray json = JSON.parseArray(JSON.toJSONString(list));
   		System.out.println(">>>>>>>>>>>>>>>>>getBudgetByUnitCricle " + json.toString());
   		return json;
   	}
    
    
    @ApiOperation(value = "下钻页-二级页面科研预算-按分布", notes = "下钻页-二级页面科研预算-按分布")
   	@RequestMapping(value = "/getBudgetByDistributeBar", method = RequestMethod.POST)
   	public JSONArray getBudgetByDistributeBar(@ApiParam(value="月份:month如201812,公司代码:companyCode",required=true)@RequestBody String paramsJson) throws Exception 
    {
   		
   		System.out.println(" paramsJson=" + paramsJson);
   		JSONObject jo = JSONObject.parseObject(paramsJson);
   		String month = jo.getString("month");
   		String companyCode = jo.getString("companyCode");
   		Map map = new HashMap();
   		map.put("month", month);
   		map.put("companyCode", companyCode);
   		List<H1AMKYSY100109> list = homeService.getBudgetByDistributeBar(map);
   		JSONArray json = JSON.parseArray(JSON.toJSONString(list));
   		System.out.println(">>>>>>>>>>>>>>>>>getBudgetByDistributeBar " + json.toString());
   		return json;
   	}
    
    
    
    @ApiOperation(value = "下钻页-科研预算三级页面", notes = "下钻页-科研预算三级页面")
   	@RequestMapping(value = "/getBudgetTable", method = RequestMethod.POST)
   	public LayuiTableData getBudgetTable(@RequestBody LayuiTableParam param)throws Exception
   	{
    	System.out.println(" param=" + param);
   		return homeService.getBudgetTable(param);
   	}
    
    /**==========================================预算 end======================================*/
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    

    
    /**==========================================科研支出======================================*/

    
    @ApiOperation(value = "下钻页-二级页面科研支出-按项目数量", notes = "下钻页-二级页面科研支出-按项目数量")
   	@RequestMapping(value = "/getPayByCountBar", method = RequestMethod.POST)
   	public JSONArray getPayByCountBar(@ApiParam(value="月份:month如201812,公司代码:companyCode",required=true)@RequestBody String paramsJson) throws Exception 
    {
   		
   		System.out.println(" paramsJson=" + paramsJson);
   		JSONObject jo = JSONObject.parseObject(paramsJson);
   		String month = jo.getString("month");
   		String companyCode = jo.getString("companyCode");
   		Map map = new HashMap();
   		map.put("month", month);
   		map.put("companyCode", companyCode);
   		List<H1AMKYSY100109> list = homeService.getPayByCountBar(map);
   		JSONArray json = JSON.parseArray(JSON.toJSONString(list));
   		System.out.println(">>>>>>>>>>>>>>>>>getPayByCountBar " + json.toString());
   		return json;
   	}
    @ApiOperation(value = "下钻页-二级页面科研支出-按项目数量", notes = "下钻页-二级页面科研支出-按项目数量")
   	@RequestMapping(value = "/getPayByCountPie", method = RequestMethod.POST)
   	public JSONArray getPayByCountPie(@ApiParam(value="月份:month如201812,公司代码:companyCode",required=true)@RequestBody String paramsJson) throws Exception 
    {
   		
   		System.out.println(" paramsJson=" + paramsJson);
   		JSONObject jo = JSONObject.parseObject(paramsJson);
   		String month = jo.getString("month");
   		String companyCode = jo.getString("companyCode");
   		Map map = new HashMap();
   		map.put("month", month);
   		map.put("companyCode", companyCode);
   		List<H1AMKYSY100109> list = homeService.getPayByCountPie(map);
   		JSONArray json = JSON.parseArray(JSON.toJSONString(list));
   		System.out.println(">>>>>>>>>>>>>>>>>getPayByCountPie " + json.toString());
   		return json;
   	}
    
    @ApiOperation(value = "下钻页-二级页面科研支出-按项目数量", notes = "下钻页-二级页面科研支出-按项目数量")
   	@RequestMapping(value = "/getPayByCountCricle", method = RequestMethod.POST)
   	public JSONArray getPayByCountCricle(@ApiParam(value="月份:month如201812,公司代码:companyCode",required=true)@RequestBody String paramsJson) throws Exception 
    {
   		
   		System.out.println(" paramsJson=" + paramsJson);
   		JSONObject jo = JSONObject.parseObject(paramsJson);
   		String month = jo.getString("month");
   		String companyCode = jo.getString("companyCode");
   		Map map = new HashMap();
   		map.put("month", month);
   		map.put("companyCode", companyCode);
   		List<H1AMKYSY100109> list = homeService.getPayByCountCricle(map);
   		JSONArray json = JSON.parseArray(JSON.toJSONString(list));
   		System.out.println(">>>>>>>>>>>>>>>>>getPayByCountCricle " + json.toString());
   		return json;
   	}
    
    
    @ApiOperation(value = "下钻页-二级页面科研支出-按单位", notes = "下钻页-二级页面科研支出-按单位")
   	@RequestMapping(value = "/getPayByUnitBar", method = RequestMethod.POST)
   	public JSONArray getPayByUnitBar(@ApiParam(value="月份:month如201812,公司代码:companyCode",required=true)@RequestBody String paramsJson) throws Exception 
    {
   		
   		System.out.println(" paramsJson=" + paramsJson);
   		JSONObject jo = JSONObject.parseObject(paramsJson);
   		String month = jo.getString("month");
   		String companyCode = jo.getString("companyCode");
   		Map map = new HashMap();
   		map.put("month", month);
   		map.put("companyCode", companyCode);
   		List<H1AMKYSY100109> list = homeService.getPayByUnitBar(map);
   		JSONArray json = JSON.parseArray(JSON.toJSONString(list));
   		System.out.println(">>>>>>>>>>>>>>>>>getPayByUnitBar " + json.toString());
   		return json;
   	}
    
    
    
    @ApiOperation(value = "下钻页-二级页面科研支出-按单位", notes = "下钻页-二级页面科研支出-按单位")
   	@RequestMapping(value = "/getPayByUnitPie", method = RequestMethod.POST)
   	public JSONArray getPayByUnitPie(@ApiParam(value="月份:month如201812,公司代码:companyCode",required=true)@RequestBody String paramsJson) throws Exception 
    {
   		
   		System.out.println(" paramsJson=" + paramsJson);
   		JSONObject jo = JSONObject.parseObject(paramsJson);
   		String month = jo.getString("month");
   		String companyCode = jo.getString("companyCode");
   		Map map = new HashMap();
   		map.put("month", month);
   		map.put("companyCode", companyCode);
   		List<H1AMKYSY100109> list = homeService.getPayByUnitPie(map);
   		JSONArray json = JSON.parseArray(JSON.toJSONString(list));
   		System.out.println(">>>>>>>>>>>>>>>>>getPayByUnitPie " + json.toString());
   		return json;
   	}
    
    
    @ApiOperation(value = "下钻页-二级页面科研支出-按单位", notes = "下钻页-二级页面科研支出-按单位")
   	@RequestMapping(value = "/getPayByUnitCricle", method = RequestMethod.POST)
   	public JSONArray getPayByUnitCricle(@ApiParam(value="月份:month如201812,公司代码:companyCode",required=true)@RequestBody String paramsJson) throws Exception 
    {
   		
   		System.out.println(" paramsJson=" + paramsJson);
   		JSONObject jo = JSONObject.parseObject(paramsJson);
   		String month = jo.getString("month");
   		String companyCode = jo.getString("companyCode");
   		Map map = new HashMap();
   		map.put("month", month);
   		map.put("companyCode", companyCode);
   		List<H1AMKYSY100109> list = homeService.getPayByUnitCricle(map);
   		JSONArray json = JSON.parseArray(JSON.toJSONString(list));
   		System.out.println(">>>>>>>>>>>>>>>>>getPayByUnitCricle " + json.toString());
   		return json;
   	}
    
    
    @ApiOperation(value = "下钻页-二级页面科研支出-按分布", notes = "下钻页-二级页面科研支出-按分布")
   	@RequestMapping(value = "/getPayByDistributeBar", method = RequestMethod.POST)
   	public JSONArray getPayByDistributeBar(@ApiParam(value="月份:month如201812,公司代码:companyCode",required=true)@RequestBody String paramsJson) throws Exception 
    {
   		
   		System.out.println(" paramsJson=" + paramsJson);
   		JSONObject jo = JSONObject.parseObject(paramsJson);
   		String month = jo.getString("month");
   		String companyCode = jo.getString("companyCode");
   		Map map = new HashMap();
   		map.put("month", month);
   		map.put("companyCode", companyCode);
   		List<H1AMKYSY100109> list = homeService.getPayByDistributeBar(map);
   		JSONArray json = JSON.parseArray(JSON.toJSONString(list));
   		System.out.println(">>>>>>>>>>>>>>>>>getPayByDistributeBar " + json.toString());
   		return json;
   	}
    
    
    @ApiOperation(value = "下钻页-二级页面科研支出-按分布", notes = "下钻页-二级页面科研支出-按分布")
   	@RequestMapping(value = "/pay_01", method = RequestMethod.POST)
   	public JSONArray pay_01(@ApiParam(value="月份:month如201812,公司代码:companyCode",required=true)@RequestBody String paramsJson) throws Exception 
    {
   		
   		System.out.println(" paramsJson=" + paramsJson);
   		JSONObject jo = JSONObject.parseObject(paramsJson);
   		String month = jo.getString("month");
   		String companyCode = jo.getString("companyCode");
   		Map map = new HashMap();
   		map.put("month", month);
   		map.put("companyCode", companyCode);
   		List<H1AMKYSY100109> list = homeService.pay_01(map);
   		JSONArray json = JSON.parseArray(JSON.toJSONString(list));
   		System.out.println(">>>>>>>>>>>>>>>>>pay_01 " + json.toString());
   		return json;
   	}
    @ApiOperation(value = "下钻页-二级页面科研支出-按分布", notes = "下钻页-二级页面科研支出-按分布")
   	@RequestMapping(value = "/pay_02", method = RequestMethod.POST)
   	public JSONArray pay_02(@ApiParam(value="月份:month如201812,公司代码:companyCode",required=true)@RequestBody String paramsJson) throws Exception 
    {
   		
   		System.out.println(" paramsJson=" + paramsJson);
   		JSONObject jo = JSONObject.parseObject(paramsJson);
   		String month = jo.getString("month");
   		String companyCode = jo.getString("companyCode");
   		Map map = new HashMap();
   		map.put("month", month);
   		map.put("companyCode", companyCode);
   		List<H1AMKYSY100109> list = homeService.pay_02(map);
   		JSONArray json = JSON.parseArray(JSON.toJSONString(list));
   		System.out.println(">>>>>>>>>>>>>>>>>pay_02 " + json.toString());
   		return json;
   	}
    
    
    @ApiOperation(value = "下钻页-二级页面科研支出-按分布", notes = "下钻页-二级页面科研支出-按分布")
   	@RequestMapping(value = "/pay_03", method = RequestMethod.POST)
   	public JSONArray pay_03(@ApiParam(value="月份:month如201812,公司代码:companyCode",required=true)@RequestBody String paramsJson) throws Exception 
    {
   		
   		System.out.println(" paramsJson=" + paramsJson);
   		JSONObject jo = JSONObject.parseObject(paramsJson);
   		String month = jo.getString("month");
   		String companyCode = jo.getString("companyCode");
   		Map map = new HashMap();
   		map.put("month", month);
   		map.put("companyCode", companyCode);
   		List<H1AMKYSY100109> list = homeService.pay_03(map);
   		JSONArray json = JSON.parseArray(JSON.toJSONString(list));
   		System.out.println(">>>>>>>>>>>>>>>>>pay_03 " + json.toString());
   		return json;
   	}
    
    
    @ApiOperation(value = "下钻页-科研支出三级页面", notes = "下钻页-科研支出三级页面")
   	@RequestMapping(value = "/getPayTable", method = RequestMethod.POST)
   	public LayuiTableData getPayTable(@RequestBody LayuiTableParam param)throws Exception
   	{
    	System.out.println(" param=" + param);
   		return homeService.getPayTable(param);
   	}
    
    
    /**==========================================科研支出 end======================================*/
    
    
    
    
    
    
    
    
    
    
}
	
	
	
	
	
	
	
	
