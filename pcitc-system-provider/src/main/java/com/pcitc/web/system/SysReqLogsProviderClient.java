package com.pcitc.web.system;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.pcitc.base.common.LayuiTableData;
import com.pcitc.base.common.LayuiTableParam;
import com.pcitc.base.common.Result;
import com.pcitc.base.system.SysReqLogs;
import com.pcitc.base.util.MyBeanUtils;
import com.pcitc.service.system.SysReqLogsService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Api(value="日志-业务操作日志",tags= {"系统-业务日志管理"})
@RestController
public class SysReqLogsProviderClient 
{

	@Autowired
	private SysReqLogsService sysReqLogsService;
	
	
	
	@ApiOperation(value="日志-预算项列表",notes="获取业务日志列表。")
	@RequestMapping(value = "/sys-provider/processlogs/process-logs-list", method = RequestMethod.POST)
	public Object selectSysReqLogsList(@RequestBody SysReqLogs bean) 
	{
		List<Map<String,Object>> rsdata = new ArrayList<Map<String,Object>>();
		try
		{
			List<SysReqLogs> datalist = sysReqLogsService.selectListSysReqLogsByBean(bean);
			for(SysReqLogs dt:datalist) {
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
	@RequestMapping(value = "/sys-provider/processlogs/process-logs-table", method = RequestMethod.POST)
	public Object selectSysReqLogsTable(@RequestBody LayuiTableParam param) 
	{
		LayuiTableData data = null;
		try
		{
			data = sysReqLogsService.selectTableSysReqLogs(param);
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		return data;
	}
	@ApiOperation(value="日志-保存",notes="保存业务日志。")
	@RequestMapping(value = "/sys-provider/processlogs/process-logs-save", method = RequestMethod.POST)
	public Result saveSysReqLogs(@RequestBody SysReqLogs bean) 
	{
		Result rs = new Result(false);
		try
		{
			rs = sysReqLogsService.saveSysReqLogs(bean);
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		return rs;
	}
	
}
