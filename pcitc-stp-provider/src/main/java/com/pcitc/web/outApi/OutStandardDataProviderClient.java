package com.pcitc.web.outApi;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSON;
import com.pcitc.base.common.LayuiTableData;
import com.pcitc.base.common.LayuiTableParam;
import com.pcitc.base.common.Result;
import com.pcitc.base.stp.out.OutStandardData;
import com.pcitc.base.util.MyBeanUtils;
import com.pcitc.service.outApi.OutStandardDataService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Api(value="标准化-标准化数据",tags= {"标准化-标准化数据管理"})
@RestController
public class OutStandardDataProviderClient 
{

	@Autowired
	private OutStandardDataService outStandardDataService;
	
	
	
	
	@ApiOperation(value="标准化管理-检索标准化",notes="根据标准化ID检索标准化!")
	@RequestMapping(value = "/stp-provider/out/out-standarddata-get/{dataId}", method = RequestMethod.POST)
	public Object selectOutStandardDataByDataId(@PathVariable("dataId") String dataId) 
	{
		OutStandardData organ = null;
		try 
		{
			organ = outStandardDataService.selectOutStandardData(dataId);
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
		}
		return organ;
	}
	@ApiOperation(value="标准化管理-检索标准化",notes="根据标准化ID检索标准化!")
	@RequestMapping(value = "/stp-provider/out/out-standarddata-getbyId/{id}", method = RequestMethod.POST)
	public Object selectOutStandardDataById(@PathVariable("id") String id) 
	{
		OutStandardData organ = null;
		try 
		{
			organ = outStandardDataService.selectOutStandardDataById(id);
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
		}
		return organ;
	}
	
	
	@ApiOperation(value="标准化管理-标准化列表",notes="获取标准化列表。")
	@RequestMapping(value = "/stp-provider/out/out-standarddata-list", method = RequestMethod.POST)
	public Object selectOutStandardDataList(@RequestBody OutStandardData bean) 
	{
		List<Map<String,Object>> rsdata = new ArrayList<Map<String,Object>>();
		try
		{
			List<OutStandardData> datalist = outStandardDataService.selectListOutStandardDataByBean(bean);
			for(OutStandardData dt:datalist) {
				Map<String,Object> map = MyBeanUtils.transBean2Map(dt);
				//map.put("auditStatusDesc", BudgetAuditStatusEnum.getStatusByCode(dt.getAuditStatus()).getDesc());
				rsdata.add(map);
			}
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		return rsdata;
	}
	@ApiOperation(value="标准化管理-预算分页列表",notes="获取标准化列表（带分页）。")
	@RequestMapping(value = "/stp-provider/out/out-standarddata-table", method = RequestMethod.POST)
	public Object selectOutStandardDataTable(@RequestBody LayuiTableParam param) 
	{
		LayuiTableData data = null;
		try
		{
			data = outStandardDataService.selectTableOutStandardData(param);
			System.out.println(JSON.toJSONString(data));
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		return data;
	}
	@ApiOperation(value="标准化管理-标准化保存",notes="保存标准化")
	@RequestMapping(value = "/stp-provider/out/out-standarddata-save", method = RequestMethod.POST)
	public Object saveOutStandardData(@RequestBody OutStandardData bean) 
	{
		Result rs = new Result(false);
		try
		{
			rs = outStandardDataService.saveOutStandardData(bean);
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		return rs;
	}
	@ApiOperation(value="标准化管理-标准化更新",notes="更新标准化")
	@RequestMapping(value = "/stp-provider/out/out-standarddata-upd", method = RequestMethod.POST)
	public Object updOutStandardData(@RequestBody OutStandardData bean) 
	{
		Result rs = new Result(false);
		try
		{
			rs = outStandardDataService.updateOutStandardData(bean);
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		return rs;
	}

	@ApiOperation(value="标准化管理-标准化保存或更新",notes="标准化保存或更新")
	@RequestMapping(value = "/stp-provider/out/out-standarddata-saveorupd", method = RequestMethod.POST)
	public Object saveOrUpdOutStandardData(@RequestBody OutStandardData bean) 
	{
		Result rs = new Result(false);
		try
		{
			rs = outStandardDataService.saveOrUpdOutStandardData(bean);
			
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		return rs;
	}
	
	@ApiOperation(value="标准化管理-标准化删除",notes="标准化删除")
	@RequestMapping(value = "/stp-provider/out/out-standarddata-del/{dataId}", method = RequestMethod.POST)
	public Object delOutStandardData(@PathVariable("dataId") String dataId) 
	{
		Result rs = new Result(false);
		try
		{
			rs = outStandardDataService.deleteOutStandardData(dataId);
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		return rs;
	}
	@ApiOperation(value="标准化管理-标准化删除",notes="标准化删除")
	@RequestMapping(value = "/stp-provider/out/out-standarddata-count", method = RequestMethod.POST)
	public Object selectOutStandardDataSize() 
	{
		Integer rs = 0;
		try
		{
			rs = outStandardDataService.selectOutStandardDataCount();
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		return rs;
	}
}
