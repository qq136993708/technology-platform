package ${svcImplPackageName};

import java.io.Serializable;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.pcitc.base.common.LayuiTableData;
import com.pcitc.base.common.LayuiTableParam;
import com.pcitc.base.common.Result;
import ${beanPackage}.${beanName};
import ${beanPackage}.${beanName}Example;
import ${svcPackageName}.${beanName}Service;
/**
 * 
 * @author fb
 *
 */
@Service("${beanNamePropertis}Service")
@Transactional(propagation = Propagation.REQUIRED, readOnly = false, rollbackFor = Exception.class)
public class ${beanName}ServiceImpl  extends BaseServiceImpl<${beanName},Serializable,${beanName}Example>  implements ${beanName}Service
{

	@Override
	public ${beanName} select${beanName}(String dataId) 
	{
		return this.selectByPrimaryKey(dataId);
	}
	@Override
	public Result save${beanName}(${beanName} bean) throws Exception 
	{
		Boolean status = this.saveBean(bean);
		
		return new Result(status);
	}
	@Override
	public Result update${beanName}(${beanName} ${beanNamePropertis}) throws Exception 
	{
		Boolean status =  this.updateBean(${beanNamePropertis});
		
		return new Result(status);
	}
	@Override
	public Result delete${beanName}(String id) throws Exception 
	{
		Boolean status =  this.deleteBean(id);
		
		return new Result(status);
	}
	@Override
	public Result saveOrUpd${beanName}(${beanName} bean) throws Exception 
	{
		Boolean status =  this.saveOrUpdBean(bean.getDataId(),bean);
		
		return new Result(status);
	}
	@Override
	public List<${beanName}> selectList${beanName}() 
	{
		${beanName}Example example = new ${beanName}Example();
		return this.selectListData(example);
	}
	@Override
	public LayuiTableData selectTable${beanName}(LayuiTableParam param) 
	{
		${beanName}Example example = new ${beanName}Example();
		return this.selectTableData(param, example);
	}
	@Override
	public List<${beanName}> selectList${beanName}ByBean(${beanName} bean) 
	{
		${beanName}Example example = new ${beanName}Example();
		return this.selectListData(example);
	}
	
	
}
