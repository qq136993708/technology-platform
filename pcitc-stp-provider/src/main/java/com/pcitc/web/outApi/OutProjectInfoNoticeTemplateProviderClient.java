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
import com.pcitc.base.stp.out.OutProjectInfoNoticeTemplate;
import com.pcitc.base.util.MyBeanUtils;
import com.pcitc.service.outApi.OutProjectInfoNoticeTemplateService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Api(value="通知模板-付款通知模板",tags= {"通知模板-付款通知模板数据管理"})
@RestController
public class OutProjectInfoNoticeTemplateProviderClient 
{

	@Autowired
	private OutProjectInfoNoticeTemplateService outStandardDataService;
	
	
	
	
	@ApiOperation(value="通知模板-检索付款通知模板",notes="根据付款通知模板ID检索付款通知模板!")
	@RequestMapping(value = "/stp-provider/out/out-noticetemplate-get/{dataId}", method = RequestMethod.POST)
	public Object selectOutProjectInfoNoticeTemplateByDataId(@PathVariable("dataId") String dataId) 
	{
		OutProjectInfoNoticeTemplate organ = null;
		try 
		{
			organ = outStandardDataService.selectOutProjectInfoNoticeTemplate(dataId);
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
		}
		return organ;
	}
	@ApiOperation(value="通知模板-检索付款通知模板",notes="根据付款通知模板ID检索付款通知模板!")
	@RequestMapping(value = "/stp-provider/out/out-noticetemplate-getbyId/{id}", method = RequestMethod.POST)
	public Object selectOutProjectInfoNoticeTemplateById(@PathVariable("id") String id) 
	{
		OutProjectInfoNoticeTemplate organ = null;
		try 
		{
			organ = outStandardDataService.selectOutProjectInfoNoticeTemplate(id);
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
		}
		return organ;
	}
	
	
	@ApiOperation(value="通知模板-付款通知模板列表",notes="获取付款通知模板列表。")
	@RequestMapping(value = "/stp-provider/out/out-noticetemplate-list", method = RequestMethod.POST)
	public Object selectOutProjectInfoNoticeTemplateList(@RequestBody OutProjectInfoNoticeTemplate bean) 
	{
		List<Map<String,Object>> rsdata = new ArrayList<Map<String,Object>>();
		try
		{
			List<OutProjectInfoNoticeTemplate> datalist = outStandardDataService.selectListOutProjectInfoNoticeTemplateByBean(bean);
			for(OutProjectInfoNoticeTemplate dt:datalist) {
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
	@ApiOperation(value="通知模板-预算分页列表",notes="获取付款通知模板列表（带分页）。")
	@RequestMapping(value = "/stp-provider/out/out-noticetemplate-table", method = RequestMethod.POST)
	public Object selectOutProjectInfoNoticeTemplateTable(@RequestBody LayuiTableParam param) 
	{
		LayuiTableData data = null;
		try
		{
			data = outStandardDataService.selectTableOutProjectInfoNoticeTemplate(param);
			System.out.println(JSON.toJSONString(data));
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		return data;
	}
	@ApiOperation(value="通知模板-付款通知模板保存",notes="保存付款通知模板")
	@RequestMapping(value = "/stp-provider/out/out-noticetemplate-save", method = RequestMethod.POST)
	public Object saveOutProjectInfoNoticeTemplate(@RequestBody OutProjectInfoNoticeTemplate bean) 
	{
		Result rs = new Result(false);
		try
		{
			rs = outStandardDataService.saveOutProjectInfoNoticeTemplate(bean);
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		return rs;
	}
	@ApiOperation(value="通知模板-付款通知模板更新",notes="更新付款通知模板")
	@RequestMapping(value = "/stp-provider/out/out-noticetemplate-upd", method = RequestMethod.POST)
	public Object updOutProjectInfoNoticeTemplate(@RequestBody OutProjectInfoNoticeTemplate bean) 
	{
		Result rs = new Result(false);
		try
		{
			rs = outStandardDataService.updateOutProjectInfoNoticeTemplate(bean);
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		return rs;
	}

	@ApiOperation(value="通知模板-付款通知模板保存或更新",notes="付款通知模板保存或更新")
	@RequestMapping(value = "/stp-provider/out/out-noticetemplate-saveorupd", method = RequestMethod.POST)
	public Object saveOrUpdOutProjectInfoNoticeTemplate(@RequestBody OutProjectInfoNoticeTemplate bean) 
	{
		Result rs = new Result(false);
		try
		{
			rs = outStandardDataService.saveOrUpdOutProjectInfoNoticeTemplate(bean);
			
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		return rs;
	}
	
	@ApiOperation(value="通知模板-付款通知模板删除",notes="付款通知模板删除")
	@RequestMapping(value = "/stp-provider/out/out-noticetemplate-del/{dataId}", method = RequestMethod.POST)
	public Object delOutProjectInfoNoticeTemplate(@PathVariable("dataId") String dataId) 
	{
		Result rs = new Result(false);
		try
		{
			rs = outStandardDataService.deleteOutProjectInfoNoticeTemplate(dataId);
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		return rs;
	}
	
}
