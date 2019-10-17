package com.pcitc.web.system;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.pcitc.base.common.LayuiTableData;
import com.pcitc.base.common.LayuiTableParam;
import com.pcitc.base.common.Result;
import com.pcitc.base.system.SysCurrencyLog;
import com.pcitc.base.util.DateUtil;
import com.pcitc.base.util.IdUtil;
import com.pcitc.base.util.MyBeanUtils;
import com.pcitc.service.system.SysCurrencyLogService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Api(value="日志-通用操作日志",tags= {"系统-通用业务日志管理"})
@RestController
public class SysCurrencyLogProviderClient 
{

	@Autowired
	private SysCurrencyLogService sysCurrencyLogService;
	
	
	
	@ApiOperation(value="日志-预算项列表",notes="获取业务日志列表。")
	@RequestMapping(value = "/sys-provider/currencylog/process-logs-list", method = RequestMethod.POST)
	public Object selectSysCurrencyLogList(@RequestBody SysCurrencyLog bean) 
	{
		List<Map<String,Object>> rsdata = new ArrayList<Map<String,Object>>();
		try
		{
			List<SysCurrencyLog> datalist = sysCurrencyLogService.selectListSysCurrencyLogByBean(bean);
			for(SysCurrencyLog dt:datalist) {
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
	@ApiOperation(value="日志-预算项列表",notes="获取业务日志列表（带分页）。")
	@RequestMapping(value = "/sys-provider/currencylog/process-logs-table", method = RequestMethod.POST)
	public Object selectSysCurrencyLogTable(@RequestBody LayuiTableParam param) 
	{
		LayuiTableData data = null;
		try
		{
			data = sysCurrencyLogService.selectTableSysCurrencyLog(param);
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		return data;
	}
	@ApiOperation(value="日志-保存",notes="保存业务日志。")
	@RequestMapping(value = "/sys-provider/currencylog/process-logs-save", method = RequestMethod.POST)
	public Result saveSysCurrencyLog(@RequestBody SysCurrencyLog bean) 
	{
		Result rs = new Result(false);
		try
		{
			if(StringUtils.isBlank(bean.getDataId())) {
				bean.setDataId(IdUtil.createIdByTime());
				bean.setLogTime(DateUtil.dateToStr(new Date(),DateUtil.FMT_SS));
			}
			rs = sysCurrencyLogService.saveSysCurrencyLog(bean);
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		return rs;
	}
	
}
