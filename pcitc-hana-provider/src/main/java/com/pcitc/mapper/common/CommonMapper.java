package com.pcitc.mapper.common;

import java.util.List;
import java.util.Map;

import com.pcitc.base.hana.report.H1AMKYZH100006;

public interface CommonMapper {

    
    // 报表名称:项目主数据-科研公司代码   报表编码: H1AM_KY_ZH_1000
    public List getCompanyCode();
    
    // 项目代码
    public<ProjectCode> List getPorjectCode();
    
    // 项目类型
    public<ProjectCode> List getDicG0XMGLLXList();
    
    // 项目项目来源
    public<ProjectCode> List getDicG0XMGLLYList();
    
    
    // 项目级别
    public<ProjectCode> List getDicG0XMGLJB_List();
    
    
    
    
    
    
    // 资产类别
    public<DicAssetType> List  getDicAssetTypeList();
    
    
    
    // 供应商
    public<DicSupplyer> List  getDicSupplyerList(DicSupplyer dicSupplyer);
    
    
    // 供应商
    public<SreSupplier> List  getDicSupplyListByIds(Map map);
    
    
    
    
    public<DicSupplyer> List  getDicSupplyerList_table(Map map);
    int  getDicSupplyCount(Map map);
    
    
    
    // 项目类型--项目项目来源--项目级别
    public<DicSupplyer> List  getCodeH1AM_KY_ZH_1000_06(Map map);
    
    
    
    public List<H1AMKYZH100006>  getCodeDicBase();
    
    
    
    
    
    
    
    // erp课题
	public List selectErpProjectListByPage(Map param);

	public int selectErpProjectListCount(Map param);
    
    

}