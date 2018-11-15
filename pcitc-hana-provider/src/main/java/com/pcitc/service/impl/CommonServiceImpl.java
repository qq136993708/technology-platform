package com.pcitc.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.pcitc.base.common.LayuiTableParam;
import com.pcitc.base.hana.report.CompanyCode;
import com.pcitc.base.hana.report.H1AMKYZH100006;
import com.pcitc.base.hana.report.ProjectCode;
import com.pcitc.mapper.common.CommonMapper;
import com.pcitc.service.ICommonService;

@Service("commonService")
@Transactional(propagation = Propagation.REQUIRED, readOnly = false, rollbackFor = Exception.class)
public class CommonServiceImpl implements ICommonService {


    @Autowired
    private CommonMapper commonMapper;

    /**
       * 报表名称:项目主数据-科研公司代码   报表编码: H1AM_KY_ZH_1000
     */
    public List<CompanyCode> getCompanyCode() throws Exception
    {
    	List<CompanyCode> list = commonMapper.getCompanyCode();
    	return list;
    }

    /**
         * 报表名称:项目主数据-科研公司代码   报表编码: H1AM_KY_ZH_1000_02
    */

	public List<ProjectCode> getPorjectCode() throws Exception
	{
    	List<ProjectCode> list = commonMapper.getPorjectCode();
    	return list;
    }
	

   // 项目类型
   public<ProjectCode> List getDicG0XMGLLXList()throws Exception
   {
	   List<ProjectCode> list = commonMapper.getDicG0XMGLLXList();
   	   return list;
   }
   
   // 项目项目来源
   public<ProjectCode> List getDicG0XMGLLYList()throws Exception
   {
	   List<ProjectCode> list = commonMapper.getDicG0XMGLLYList();
   	   return list;
   }
   
   
   // 项目级别
   public<ProjectCode> List getDicG0XMGLJB_List()throws Exception
   {
	   List<ProjectCode> list = commonMapper.getDicG0XMGLJB_List();
   	   return list;
   }
   



	 // 资产类别
   public<DicAssetType> List  getDicAssetTypeList()throws Exception
   {
	   List<DicAssetType> list = commonMapper.getDicAssetTypeList();
       return list;
   }
   
   
   // 供应商
   public<DicSupplyer> List  getDicSupplyerList(DicSupplyer dicSupplyer)throws Exception
   {
	   List<DicSupplyer> list = commonMapper.getDicSupplyerList(dicSupplyer);
       return list;
   }
   
   // 项目类型--项目项目来源--项目级别
   public List<ProjectCode>  getCodeH1AM_KY_ZH_1000_06(Map map)throws Exception
   {
	   List<ProjectCode> list = commonMapper.getCodeH1AM_KY_ZH_1000_06(map);
       return list;
   }
   
   
   
   // 项目类型--项目项目来源--项目级别
   public List<H1AMKYZH100006>  getBaseCodeDic(Map map)throws Exception
   {
	   List<H1AMKYZH100006> list = commonMapper.getCodeDicBase();
       return list;
   }
   

	// erp中的课题，分页查询
	public List selectErpProjectListByPage(LayuiTableParam param) {
		Map<String,Object> paraMap = param.getParam();
		System.out.println("==============="+(param.getPage()-1)*param.getLimit());
		paraMap.put("page", (param.getPage()-1)*param.getLimit()+1);
		paraMap.put("limit", param.getLimit());
		paraMap.put("G0CON", "true");
		return commonMapper.selectErpProjectListByPage(paraMap);
	}

	public int selectErpProjectListCount(LayuiTableParam param) {
		Map<String,Object> paraMap = param.getParam();
		paraMap.put("G0CON", "true");
		return commonMapper.selectErpProjectListCount(paraMap);
	}
   

}
