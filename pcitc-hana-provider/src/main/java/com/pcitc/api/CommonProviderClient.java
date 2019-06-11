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
import com.pcitc.base.hana.report.CompanyCode;
import com.pcitc.base.hana.report.DicAssetType;
import com.pcitc.base.hana.report.DicSupplyer;
import com.pcitc.base.hana.report.H1AMKYZH100006;
import com.pcitc.base.hana.report.ProjectCode;
import com.pcitc.base.stp.equipment.SreSupplier;
import com.pcitc.service.ICommonService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

//共用接口
@Api(value = "Common-API",description = "共用接口")
@RestController
@RequestMapping("/hana/common")  
public class CommonProviderClient {


	@Autowired
	private ICommonService commonService;
	
	
	/**
	 * 报表名称:项目主数据-科研公司代码   报表编码: H1AM_KY_ZH_1000_01
	 *
	 * @throws Exception
	 */
	@ApiOperation(value = "获取科研公司代码", notes = "报表名称:项目主数据-科研公司代码 ")
	@RequestMapping(value = "/dic/company-code", method = RequestMethod.GET)
	public JSONArray getCompanyCode() throws Exception {
		List<CompanyCode> list = commonService.getCompanyCode();
		
		JSONArray json = JSONArray.parseArray(JSON.toJSONString(list));
		return json;
	}


	/**
	 * 报表名称:项目主数据-项目代码   报表编码: H1AM_KY_ZH_1000_02
	 *
	 * @throws Exception
	 */
	@ApiOperation(value = "获取项目代码", notes = "报表名称:项目主数据-项目代码 ")
	@RequestMapping(value = "/dic/porject-code", method = RequestMethod.GET)
	public JSONArray getPorjectCode() throws Exception {
		List<ProjectCode> list = commonService.getPorjectCode();
		JSONArray json = JSONArray.parseArray(JSON.toJSONString(list));
		return json;
	}
	
	
	/**
	   项目类型
	 */
	@ApiOperation(value = "获取项目类型", notes = "报表名称:项目主数据-项目类型 ")
	@RequestMapping(value = "/dic/porject-lx", method = RequestMethod.GET)
	public JSONArray getDicG0XMGLLXList() throws Exception {
		List<ProjectCode> list = commonService.getDicG0XMGLLXList();
		JSONArray json = JSONArray.parseArray(JSON.toJSONString(list));
		return json;
	}
	
	
	/**
	   项目来源
	 */
	@ApiOperation(value = "获取项目来源", notes = "报表名称:项目主数据-项目来源 ")
	@RequestMapping(value = "/dic/porject-ly", method = RequestMethod.GET)
	public JSONArray getDicG0XMGLLYList() throws Exception {
		List<ProjectCode> list = commonService.getDicG0XMGLLYList();
		JSONArray json = JSONArray.parseArray(JSON.toJSONString(list));
		return json;
	}
	
	
	
	/**
	   项目级别
	 */
	@ApiOperation(value = "获取项目级别", notes = "报表名称:项目主数据-项目级别 ")
	@RequestMapping(value = "/dic/porject-jb", method = RequestMethod.GET)
	public JSONArray getDicG0XMGLJB_List() throws Exception {
		List<ProjectCode> list = commonService.getDicG0XMGLJB_List();
		JSONArray json = JSONArray.parseArray(JSON.toJSONString(list));
		return json;
	}
	
	
	
	
   
   
   
   
	
	
	
	/**
	 *  资产类别: H1AM_KY_ZH_1000_04
	 */
	@ApiOperation(value = "获取资产类别", notes = "报表名称:项目主数据-资产类别 ")
	@RequestMapping(value = "/dic/asset_type", method = RequestMethod.GET)
	public JSONArray getDicAssetTypeList() throws Exception 
	{
		List<DicAssetType> list = commonService.getDicAssetTypeList();
		JSONArray json = JSONArray.parseArray(JSON.toJSONString(list));
		return json;
	}
	
	
	
	/**
	 *  供应商: H1AM_KY_ZH_1000_05
	 */
	@ApiOperation(value = "获取供应商", notes = "报表名称:项目主数据-供应商 ")
	@RequestMapping(value = "/dic/supplyer", method = RequestMethod.POST)
	public JSONArray getDicSupplyerList(@RequestBody DicSupplyer dicSupplyer) throws Exception 
	{
		List<DicSupplyer> list = commonService.getDicSupplyerList(dicSupplyer);
		JSONArray json = JSONArray.parseArray(JSON.toJSONString(list));
		return json;
	}
	
	
	
	
	@ApiOperation(value = "获取供应商", notes = "报表名称:项目主数据-供应商 ")
	@RequestMapping(value = "/dic/supplyer_table", method = RequestMethod.POST)
   	public LayuiTableData getDicSupplyerList_table(@RequestBody LayuiTableParam param)throws Exception
   	{
		
		System.out.println("supplyer_table param=   " + JSONObject.toJSONString(param));
   		return commonService.getDicSupplyerList_table(param);
   	}
	
	
	
	@ApiOperation(value = "获取ERP号", notes = "获取ERP号")
	@RequestMapping(value = "/dic/getErpInfoList", method = RequestMethod.POST)
   	public LayuiTableData getErpInfoList(@RequestBody LayuiTableParam param)throws Exception
   	{
		System.out.println("getErpInfoList param=   " + JSONObject.toJSONString(param));
   		return commonService.getErpInfoList(param);
   	}
	
	
	/**
	 * 批量获取
	 * @param id
	 * @return
	 * @throws Exception
	 */
	@ApiOperation(value = "批量获取供应商", notes = "根据IDS批量获取供应商，返回json格式")
	@RequestMapping(value = "/dic/get_supplier_hana_by_ids", method = RequestMethod.POST)
	public JSONArray get_supplier_hana_by_ids(@RequestBody  String paramsJson)throws Exception
	{
		
		JSONObject jo = JSONObject.parseObject(paramsJson);
		String supplierIds = jo.getString("supplierIds");
   		String companyCode = jo.getString("companyCode");
   		Map map = new HashMap();
   		map.put("companyCode", companyCode);
   		
	    StringBuffer sb=new StringBuffer();
	    if(supplierIds!=null && !supplierIds.equals(""))
	    {
		   String arr[]=supplierIds.split(",");
		   sb.append(" AND G0LIFNR in  (");
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
		List<SreSupplier> listSreEquipment= commonService.getSupplierListByIds(map);
		JSONArray json = JSONArray.parseArray(JSON.toJSONString(listSreEquipment));
		return json;
	}
	
	
	
	
	
	/**
	 * 报表名称:项目主数据-科研公司代码   报表编码: H1AM_KY_ZH_1000_06
	 *
	 * @throws Exception
	 */
	@ApiOperation(value = "获取项目级别、项目类型等", notes = "获取项目级别、项目类型等 ")
	@RequestMapping(value = "/dic/BASE_DIC_LIST", method = RequestMethod.POST)
	public JSONArray getCodeH1AM_KY_ZH_1000_06(@ApiParam(value="月份:month如201812,类型:type",required=true)@RequestBody String paramsJson) throws Exception {
		
		System.out.println(" paramsJson=" + paramsJson);
   		JSONObject jo = JSONObject.parseObject(paramsJson);
   		String month = jo.getString("month");
   		String type = jo.getString("type");
   		Map map = new HashMap();
   		map.put("month", month);
   		map.put("type", type);
		List<ProjectCode> list = commonService.getCodeH1AM_KY_ZH_1000_06(map);
		JSONArray json = JSONArray.parseArray(JSON.toJSONString(list));
		return json;
	}
	
	
	
	
	@ApiOperation(value = "获取基础数据", notes = "获取基础数据 ")
	@RequestMapping(value = "/dic/getBaseCodeDic", method = RequestMethod.POST)
	public JSONArray getBaseCodeDic(@ApiParam(value="月份:month如201812",required=true)@RequestBody String paramsJson) throws Exception {
		
		System.out.println(" paramsJson=" + paramsJson);
   		JSONObject jo = JSONObject.parseObject(paramsJson);
   		String month = jo.getString("month");
   		Map map = new HashMap();
   		map.put("month", month);
		List<H1AMKYZH100006> list = commonService.getBaseCodeDic(map);
		JSONArray json = JSONArray.parseArray(JSON.toJSONString(list));
		return json;
	}
	
	

}
	
	
	
	
	
	
	
	
