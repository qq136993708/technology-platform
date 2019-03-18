package com.pcitc.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.pcitc.base.common.LayuiTableData;
import com.pcitc.base.common.LayuiTableParam;
import com.pcitc.base.common.Page;
import com.pcitc.base.hana.report.CompanyCode;
import com.pcitc.base.hana.report.DicSupplyer;
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
   
   public LayuiTableData getDicSupplyerList_table(LayuiTableParam param)throws Exception
   {
	    //每页显示条数
 		int pageSize = param.getLimit();
 		int pageNum = param.getPage();
 		Page p=new Page(pageNum,pageSize);
		int start=(pageNum-1)*p.getPageSize();
 		String g0NAME1=(String)param.getParam().get("g0NAME1");
 		String g0MCOD3=(String)param.getParam().get("g0MCOD3");
 		String g0GSDM=(String)param.getParam().get("g0GSDM");
 		/*List<String> list=null;
 		if(g0GSDM!=null)
 		{
 			String arr[]=g0GSDM.split(",");
 	 		if(arr!=null)
 	 		{
 	 			list=new ArrayList<String>();
 	 			for(int i=0;i<arr.length;i++)
 	 			{
 	 				String str=arr[i];
 	 				if(str!=null && !str.equals(""))
 	 				{
 	 					list.add(str);
 	 				}
 	 			}
 	 		}
 		}
 		StringBuffer stringBuffer=new StringBuffer();
 		if(list!=null && list.size()>0)
 		{
 			stringBuffer.append(" and G0GSDM in (");
 			for(int i=0;i<list.size();i++)
 			{
 				String str=list.get(i);
 				if(i>0)
 				{
 					stringBuffer.append(",");
 				}
 				stringBuffer.append("'").append(str).append("'");
 			}
 			stringBuffer.append(")");
 		}
 		*/
 		Map map=new HashMap();
 		map.put("start", start);
 		map.put("pageSize", pageSize);
 		map.put("g0NAME1", g0NAME1);
 		map.put("g0MCOD3", g0MCOD3);
 		map.put("companyCode", g0GSDM);
 		List<DicSupplyer> listDicSupplyer = commonMapper.getDicSupplyerList_table(map);
 		Integer totalRecords = commonMapper.getDicSupplyCount(map);
 		System.out.println(">>>>>>>表格："+totalRecords);
 		LayuiTableData data = new LayuiTableData();
 		data.setData(listDicSupplyer);
 		data.setCount(totalRecords);
 	    return data;
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
