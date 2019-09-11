package com.pcitc.web.out;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.pcitc.base.common.LayuiTableData;
import com.pcitc.base.common.LayuiTableParam;
import com.pcitc.base.common.Result;
import com.pcitc.base.stp.out.OutProjectInfoPaymentplan;
import com.pcitc.base.system.SysDictionary;
import com.pcitc.base.util.MyBeanUtils;
import com.pcitc.service.out.OutProjectInfoPaymentplanService;
import com.pcitc.service.system.SysDictionaryService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Api(value="报销计划-报销计划项管理",tags= {"报销计划-报销计划项管理"})
@RestController
public class OutProjectInfoPaymentplanProviderClient 
{

	@Autowired
	private OutProjectInfoPaymentplanService outProjectInfoPaymentplanService;
	
	@Autowired
	private SysDictionaryService dictionaryService;
	
	@ApiOperation(value="报销计划项管理-检索报销计划项",notes="根据报销计划项ID检索报销计划项!")
	@RequestMapping(value = "/out-provider/out/project-paymentplan-get/{dataId}", method = RequestMethod.POST)
	public Object selectOutProjectInfoPaymentplanById(@PathVariable("dataId") String dataId) 
	{
		OutProjectInfoPaymentplan organ = null;
		try 
		{
			organ = outProjectInfoPaymentplanService.selectOutProjectInfoPaymentplan(dataId);
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
		}
		return organ;
	}
	@ApiOperation(value="报销计划项管理-检索报销计划项",notes="根据项目ID检索报销计划项!")
	@RequestMapping(value = "/out-provider/out/project-paymentplan-byinfoid/{dataId}", method = RequestMethod.POST)
	public Object selectOutProjectInfoPaymentplanByInfoId(@PathVariable("dataId") String dataId) 
	{
		OutProjectInfoPaymentplan organ = null;
		try 
		{
			organ = outProjectInfoPaymentplanService.selectOutProjectInfoPaymentplanByInfoId(dataId);
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
		}
		return organ;
	}
	
	@ApiOperation(value="报销批次-拨付计划批次",notes="按年度获取拨付批次号列表")
	@RequestMapping(value = "/out-provider/out/project-paymentplan-batchs/{nd}", method = RequestMethod.POST)
	public Object selectOutProjectInfoPaymentplanBatchs(@PathVariable("nd") String nd) 
	{
		List<Map<String,Object>> rsdata = new ArrayList<Map<String,Object>>();
		try
		{
			List<SysDictionary> dictionarys = dictionaryService.getDictionaryListByParentCode("ROOT_YSGL_JFBFPCZD");
			for(SysDictionary dic:dictionarys) {
				Map<String,Object> map = MyBeanUtils.transBean2Map(dic);
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
	@ApiOperation(value="报销计划项管理-报销计划项列表",notes="获取报销计划项列表。")
	@RequestMapping(value = "/out-provider/out/project-paymentplan-list", method = RequestMethod.POST)
	public Object selectOutProjectInfoPaymentplanList(@RequestBody OutProjectInfoPaymentplan bean) 
	{
		List<Map<String,Object>> rsdata = new ArrayList<Map<String,Object>>();
		try
		{
			List<OutProjectInfoPaymentplan> datalist = outProjectInfoPaymentplanService.selectListOutProjectInfoPaymentplanByBean(bean);
			for(OutProjectInfoPaymentplan dt:datalist) {
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
	@ApiOperation(value="报销计划项管理-报销计划分页列表",notes="获取报销计划项列表（带分页）。")
	@RequestMapping(value = "/out-provider/out/project-paymentplan-table", method = RequestMethod.POST)
	public Object selectOutProjectInfoPaymentplanTable(@RequestBody LayuiTableParam param) 
	{
		LayuiTableData data = null;
		try
		{
			data = outProjectInfoPaymentplanService.selectTableOutProjectInfoPaymentplan(param);
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		return data;
	}
	@ApiOperation(value="报销计划项管理-报销计划项保存",notes="保存报销计划项")
	@RequestMapping(value = "/out-provider/out/project-paymentplan-save", method = RequestMethod.POST)
	public Object saveOutProjectInfoPaymentplan(@RequestBody OutProjectInfoPaymentplan bean) 
	{
		Result rs = new Result(false);
		try
		{
			rs = outProjectInfoPaymentplanService.saveOutProjectInfoPaymentplan(bean);
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		return rs;
	}
	@ApiOperation(value="报销计划项管理-报销计划项更新",notes="更新报销计划项")
	@RequestMapping(value = "/out-provider/out/project-paymentplan-upd", method = RequestMethod.POST)
	public Object updOutProjectInfoPaymentplan(@RequestBody OutProjectInfoPaymentplan bean) 
	{
		Result rs = new Result(false);
		try
		{
			rs = outProjectInfoPaymentplanService.updateOutProjectInfoPaymentplan(bean);
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		return rs;
	}

	@ApiOperation(value="报销计划项管理-报销计划项保存或更新",notes="报销计划项保存或更新")
	@RequestMapping(value = "/out-provider/out/project-paymentplan-saveorupd", method = RequestMethod.POST)
	public Object saveOrUpdOutProjectInfoPaymentplan(@RequestBody OutProjectInfoPaymentplan bean) 
	{
		Result rs = new Result(false);
		try
		{
			rs = outProjectInfoPaymentplanService.saveOrUpdOutProjectInfoPaymentplan(bean);
			
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		return rs;
	}
	
	@ApiOperation(value="报销计划项管理-报销计划项删除",notes="报销计划项删除")
	@RequestMapping(value = "/out-provider/out/project-paymentplan-del/{dataId}", method = RequestMethod.POST)
	public Object delOutProjectInfoPaymentplan(@PathVariable("dataId") String dataId) 
	{
		Result rs = new Result(false);
		try
		{
			rs = outProjectInfoPaymentplanService.deleteOutProjectInfoPaymentplan(dataId);
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		return rs;
	}
	
}
