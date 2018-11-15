package com.pcitc.service;

import java.util.List;
import java.util.Map;

import com.pcitc.base.common.LayuiTableParam;
import com.pcitc.base.hana.report.H1AMKYZH100006;
import com.pcitc.base.hana.report.ProjectCode;

public interface ICommonService
{
	
	
	// H1AM_KY_ZH_1000_01
	public List getCompanyCode() throws Exception;
	

	// H1AM_KY_ZH_1000_02
	public List<ProjectCode> getPorjectCode() throws Exception;
	
	
	  public List<H1AMKYZH100006>  getBaseCodeDic(Map map)throws Exception;
	
	 // 项目类型
    public<ProjectCode> List getDicG0XMGLLXList()throws Exception;
    
    // 项目项目来源
    public<ProjectCode> List getDicG0XMGLLYList()throws Exception;
    
    
    // 项目级别
    public<ProjectCode> List getDicG0XMGLJB_List()throws Exception;
    
    
    
	
	
	 //  资产类别 H1AM_KY_ZH_1000_04
    public<DicAssetType> List  getDicAssetTypeList()throws Exception;
    
    
    // 供应商 H1AM_KY_ZH_1000_05
    public<DicSupplyer> List  getDicSupplyerList(DicSupplyer dicSupplyer)throws Exception;
    
	
    
    // 项目类型--项目项目来源--项目级别
    public<ProjectCode> List  getCodeH1AM_KY_ZH_1000_06(Map map)throws Exception;
	
	// erp课题
	public List selectErpProjectListByPage(LayuiTableParam param);

	public int selectErpProjectListCount(LayuiTableParam param);

}
