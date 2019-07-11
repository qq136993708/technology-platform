package ${svcPackageName};

import java.io.Serializable;
import java.util.List;

import com.pcitc.base.common.LayuiTableData;
import com.pcitc.base.common.LayuiTableParam;
import com.pcitc.base.common.Result;
import ${beanPackage}.${beanName};
import ${beanPackage}.${beanName}Example;

public interface ${beanName}Service extends BaseService<${beanName},Serializable,${beanName}Example>
{
	
	public ${beanName} select${beanName}(String dataId);
	
	public Result save${beanName}(${beanName} bean) throws Exception;

	public Result update${beanName}(${beanName} bean) throws Exception;
	
	public Result saveOrUpd${beanName}(${beanName} bean) throws Exception;
	
	public Result delete${beanName}(String dataId) throws Exception;
	
	public List<${beanName}> selectList${beanName}();
	
	public List<${beanName}> selectList${beanName}ByBean(${beanName} bean);
	
	public LayuiTableData selectTable${beanName}(LayuiTableParam param);
}
