package ${clientPackageName};

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
import com.pcitc.base.stp.budget.${beanName};
import com.pcitc.base.util.MyBeanUtils;
import ${svcPackageName}.${beanName}Service;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Api(value="预算-${clientApiDesc}管理",tags= {"预算-${clientApiDesc}管理"})
@RestController
public class ${beanName}ProviderClient 
{

	@Autowired
	private ${beanName}Service ${beanNamePropertis}Service;
	
	
	@ApiOperation(value="${clientApiDesc}管理-检索${clientApiDesc}",notes="根据${clientApiDesc}ID检索${clientApiDesc}!")
	@RequestMapping(value = "/stp-provider/budget/${clientSvcPath}-get/{dataId}", method = RequestMethod.POST)
	public Object select${beanName}ById(@PathVariable("dataId") String dataId) 
	{
		${beanName} organ = null;
		try 
		{
			organ = ${beanNamePropertis}Service.select${beanName}(dataId);
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
		}
		return organ;
	}
	
	@ApiOperation(value="${clientApiDesc}管理-${clientApiDesc}列表",notes="获取${clientApiDesc}列表。")
	@RequestMapping(value = "/stp-provider/budget/${clientSvcPath}-list", method = RequestMethod.POST)
	public Object select${beanName}List(@RequestBody ${beanName} bean) 
	{
		List<Map<String,Object>> rsdata = new ArrayList<Map<String,Object>>();
		try
		{
			List<${beanName}> datalist = ${beanNamePropertis}Service.selectList${beanName}ByBean(bean);
			for(${beanName} dt:datalist) {
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
	@ApiOperation(value="${clientApiDesc}管理-预算分页列表",notes="获取${clientApiDesc}列表（带分页）。")
	@RequestMapping(value = "/stp-provider/budget/${clientSvcPath}-table", method = RequestMethod.POST)
	public Object select${beanName}Table(@RequestBody LayuiTableParam param) 
	{
		LayuiTableData data = null;
		try
		{
			data = ${beanNamePropertis}Service.selectTable${beanName}(param);
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		return data;
	}
	@ApiOperation(value="${clientApiDesc}管理-${clientApiDesc}保存",notes="保存${clientApiDesc}")
	@RequestMapping(value = "/stp-provider/budget/${clientSvcPath}-save", method = RequestMethod.POST)
	public Object save${beanName}(@RequestBody ${beanName} bean) 
	{
		Result rs = new Result(false);
		try
		{
			rs = ${beanNamePropertis}Service.save${beanName}(bean);
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		return rs;
	}
	@ApiOperation(value="${clientApiDesc}管理-${clientApiDesc}更新",notes="更新${clientApiDesc}")
	@RequestMapping(value = "/stp-provider/budget/${clientSvcPath}-upd", method = RequestMethod.POST)
	public Object upd${beanName}(@RequestBody ${beanName} bean) 
	{
		Result rs = new Result(false);
		try
		{
			rs = ${beanNamePropertis}Service.update${beanName}(bean);
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		return rs;
	}

	@ApiOperation(value="${clientApiDesc}管理-${clientApiDesc}保存或更新",notes="${clientApiDesc}保存或更新")
	@RequestMapping(value = "/stp-provider/budget/${clientSvcPath}-saveorupd", method = RequestMethod.POST)
	public Object saveOrUpd${beanName}(@RequestBody ${beanName} bean) 
	{
		Result rs = new Result(false);
		try
		{
			rs = ${beanNamePropertis}Service.saveOrUpd${beanName}(bean);
			
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		return rs;
	}
	
	@ApiOperation(value="${clientApiDesc}管理-${clientApiDesc}删除",notes="${clientApiDesc}删除")
	@RequestMapping(value = "/stp-provider/budget/${clientSvcPath}-del/{dataId}", method = RequestMethod.POST)
	public Object del${beanName}(@PathVariable("dataId") String dataId) 
	{
		Result rs = new Result(false);
		try
		{
			rs = ${beanNamePropertis}Service.delete${beanName}(dataId);
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		return rs;
	}
	
}
