package com.pcitc.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.alibaba.fastjson.JSONObject;
import com.pcitc.base.common.LayuiTableData;
import com.pcitc.base.common.LayuiTableParam;
import com.pcitc.base.common.Page;
import com.pcitc.base.hana.report.H1AMKYSY100101;
import com.pcitc.base.hana.report.H1AMKYSY100104;
import com.pcitc.base.hana.report.H1AMKYSY100109;
import com.pcitc.base.hana.report.H1AMKYSY100117;
import com.pcitc.mapper.common.CommonMapper;
import com.pcitc.mapper.other.DecisionMapper;
import com.pcitc.mapper.other.HomeBudgetMapper;
import com.pcitc.mapper.other.HomeDeviceMapper;
import com.pcitc.mapper.other.HomeLevel2Mapper;
import com.pcitc.mapper.other.HomePageMapper;
import com.pcitc.mapper.other.HomePayMapper;
import com.pcitc.mapper.other.HomeProjectMapper;
import com.pcitc.service.IHomeService;
@Service("homeService")
@Transactional(propagation = Propagation.REQUIRED, readOnly = false, rollbackFor = Exception.class)
public class HomeServiceImpl implements IHomeService{
	
    @Autowired
    private DecisionMapper decisionMapper;
    
    @Autowired
    private HomePageMapper homePageMapper;
    
    
    @Autowired
    private HomeLevel2Mapper homeLevel2Mapper;

    @Autowired
    private CommonMapper commonMapper;
    
    
    @Autowired
    private HomeProjectMapper homeProjectMapper;
    
    
    @Autowired
    private HomeDeviceMapper homeDeviceMapper;
    
    
    
    @Autowired
    private HomeBudgetMapper homeBudgetMapper;
    

    @Autowired
    private HomePayMapper homePayMapper;
    
    
    
    
    
    private final static Logger logger = LoggerFactory.getLogger(DecisionFinancialServiceImpl.class);
    
    
    public List<H1AMKYSY100101> getH1AMKYSY100101Count(Map map)throws Exception
    {
    	List<H1AMKYSY100101> list = homePageMapper.getKyxm(map);
    	return list;
    }
    
    public List<H1AMKYSY100104> getH1AMKYSY100104Count(Map map)throws Exception
    {
    	List<H1AMKYSY100104> list = homePageMapper.getkyzb(map);
    	return list;
    }
    
    public List<H1AMKYSY100104> getndys_xfzc(Map map)throws Exception
    {
    	List<H1AMKYSY100104> list = homePageMapper.getndys_xfzc(map);
    	return list;
    }
    
    public List<H1AMKYSY100117>  getDzzk(Map map)throws Exception
    {
    	List<H1AMKYSY100117> one = homePageMapper.getDzzk(map);
    	return one;
    }
    
    
    public List<H1AMKYSY100117>  getDzzk_bar(Map map)throws Exception
    {
    	List<H1AMKYSY100117> one = homePageMapper.getDzzk_bar(map);
    	return one;
    }
    
    
    
    
    
    
    public List<H1AMKYSY100109> getH1AMKYSY100109Report(Map map)throws Exception
    {
    	List<H1AMKYSY100109> list = homePageMapper.getH1AMKYSY100109Report(map);
    	return list;
    }
    
    public List<H1AMKYSY100109> getH1AMKYSY100109Count(Map map)throws Exception
    {
    	List<H1AMKYSY100109> list = homePageMapper.getH1AMKYSY100109Count(map);
    	return list;
    }
    public List<H1AMKYSY100109> getH1AMKYSY100109Count02(Map map)throws Exception
    {
    	List<H1AMKYSY100109> list = homePageMapper.getH1AMKYSY100109Count02(map);
    	return list;
    }
    
    public LayuiTableData getNdkyxmzlTble(LayuiTableParam param)throws Exception
    {
  	        //每页显示条数
	  		int pageSize = param.getLimit();
	  		int pageNum = param.getPage();
	  		Page p=new Page(pageNum,pageSize);
			int start=(pageNum-1)*p.getPageSize();
	  		String month=(String)param.getParam().get("month");
	  		String companyCode=(String)param.getParam().get("companyCode");
	  		logger.info("======年度科研项目总览表格 param: "+JSONObject.toJSONString(param));
	  		Map map=new HashMap();
	  		map.put("start", start);
	  		map.put("pageSize", pageSize);
	  		map.put("month", month);
	  		map.put("companyCode", companyCode);
	  		List<H1AMKYSY100109> list = homePageMapper.getlist(map);
	  		Integer totalRecords = homePageMapper.getCount(map);
	  		System.out.println(">>>>>>>>年度科研项目总览表格："+totalRecords);
	  		LayuiTableData data = new LayuiTableData();
	  		data.setData(list);
	  		data.setCount(totalRecords);
	  	    return data;
    }
    
    
    
    
    
    public LayuiTableData getZhuanziTableList(LayuiTableParam param)throws Exception
    {
	  		int pageSize = param.getLimit();
	  		int pageNum = param.getPage();
	  		Page p=new Page(pageNum,pageSize);
			int start=(pageNum-1)*p.getPageSize();
	  		String month=(String)param.getParam().get("month");
	  		String companyCode=(String)param.getParam().get("companyCode");
	  		String g0SBFL=(String)param.getParam().get("g0SBFL");
	  		String g0TXT50=(String)param.getParam().get("g0TXT50");
	  		
	  		
	  		
	  		logger.info("======大型分析仪器 param: "+JSONObject.toJSONString(param));
	  		Map map=new HashMap();
	  		map.put("start", start);
	  		map.put("pageSize", pageSize);
	  		map.put("month", month);
	  		map.put("companyCode", companyCode);
	  		map.put("g0SBFL", g0SBFL);
	  		map.put("g0TXT50", g0TXT50);
	  		
	  		
	  		List<H1AMKYSY100117> list = homePageMapper.getZhuanziTableList(map);
	  		Integer totalRecords = homePageMapper.getZhuanziTableCount(map);
	  		System.out.println(">>>>>>>>大型分析仪器表格："+totalRecords);
	  		LayuiTableData data = new LayuiTableData();
	  		data.setData(list);
	  		data.setCount(totalRecords);
	  	    return data;
    }
    
    
    
	   
	   
    
    
    public LayuiTableData getListLevel2(LayuiTableParam param)throws Exception
    {
  	        //每页显示条数
	  		int pageSize = param.getLimit();
	  		int pageNum = param.getPage();
	  		Page p=new Page(pageNum,pageSize);
			int start=(pageNum-1)*p.getPageSize();
	  		String month=(String)param.getParam().get("month");
	  		String companyCode=(String)param.getParam().get("companyCode");
	  		
	  		String g0XMGLLX=(String)param.getParam().get("g0XMGLLX");
	  		String g0XMGLLY=(String)param.getParam().get("g0XMGLLY");
	  		String g0XMGLJB=(String)param.getParam().get("g0XMGLJB");
	  		String g0XMLXMS=(String)param.getParam().get("g0XMLXMS");
	  		String g0XMZTMS=(String)param.getParam().get("g0XMZTMS");
	  		String g0PROJTXT=(String)param.getParam().get("g0PROJTXT");
	  		
	  		logger.info("======年度科研项目总览表--格 param: "+JSONObject.toJSONString(param));
	  		Map map=new HashMap();
	  		map.put("start", start);
	  		map.put("pageSize", pageSize);
	  		map.put("month", month);
	  		map.put("companyCode", companyCode);
	  		map.put("g0PROJTXT", g0PROJTXT);
	  		map.put("g0XMGLLX", g0XMGLLX);
	  		map.put("g0XMGLLY", g0XMGLLY);
	  		map.put("g0XMGLJB", g0XMGLJB);
	  		map.put("g0XMLXMS", g0XMLXMS);
	  		map.put("g0XMZTMS", g0XMZTMS);
	  		
	  		
	  		
	  		
	  		
	  		List<H1AMKYSY100109> list = homePageMapper.getListLevel2(map);
	  		Integer totalRecords = homePageMapper.getCountLevel2(map);
	  		System.out.println(">>>>>>>>年度科研项目总览---表格："+totalRecords);
	  		LayuiTableData data = new LayuiTableData();
	  		data.setData(list);
	  		data.setCount(totalRecords);
	  	    return data;
    }
    
    
    
    //二级页面
    public List<H1AMKYSY100109> getNdkyxmzl(Map map)throws Exception
    {
    	List<H1AMKYSY100109> list = homePageMapper.getNdkyxmzl(map);
    	return list;
    }
    public List<H1AMKYSY100109> getNdkyxmzl02(Map map)throws Exception
    {
    	List<H1AMKYSY100109> list = homePageMapper.getNdkyxmzl02(map);
    	return list;
    }
    
    public List<H1AMKYSY100109> getNdkyxmzBar(Map map)throws Exception
    {
    	List<H1AMKYSY100109> list = homePageMapper.getNdkyxmzBar(map);
    	return list;
    }
    public List<H1AMKYSY100109> getNdkyxmzCircle(Map map)throws Exception
    {
    	List<H1AMKYSY100109> list = homePageMapper.getNdkyxmzCircle(map);
    	return list;
    }
    
    
    
    
    /**=======================================================科研装备=========================*/
    
    
    
     //科研装备二级页面
  	 public List<H1AMKYSY100109>  getLevel2KYZB01(Map map)throws Exception
  	 {
  		List<H1AMKYSY100109> list = homePageMapper.getLevel2KYZB01(map);
    	return list;
  	 }
  	 public List<H1AMKYSY100109>  getLevel2KYZB02Bar(Map map)throws Exception
  	 {
  		List<H1AMKYSY100109> list = homePageMapper.getLevel2KYZB02Bar(map);
    	return list;
  	 }
  	 public List<H1AMKYSY100109>  getLevel2KYZB03Circle(Map map)throws Exception
  	 {
  		List<H1AMKYSY100109> list = homePageMapper.getLevel2KYZB03Circle(map);
    	return list;
  	 }
  	 
  	  public LayuiTableData getKYZBTble(LayuiTableParam param)throws Exception
      {
  	  		int pageSize = param.getLimit();
  	  		int pageNum = param.getPage();
  	  		Page p=new Page(pageNum,pageSize);
  			int start=(pageNum-1)*p.getPageSize();
  	  		String month=(String)param.getParam().get("month");
  	  		String companyCode=(String)param.getParam().get("companyCode");
  	  		logger.info("======科研装备二级页面表格 param: "+JSONObject.toJSONString(param));
  	  		Map map=new HashMap();
  	  		map.put("start", start);
  	  		map.put("pageSize", pageSize);
  	  		map.put("month", month);
  	  		map.put("companyCode", companyCode);
  	  		List<H1AMKYSY100109> list = homePageMapper.getLevel2KYZB04List(map);
  	  		Integer totalRecords = homePageMapper.getLevel2KYZB04Count(map);
  	  		System.out.println(">>>>>>>>科研装备二级页面表格："+totalRecords);
  	  		LayuiTableData data = new LayuiTableData();
  	  		data.setData(list);
  	  		data.setCount(totalRecords);
  	  	    return data;
      }
  	  
  	public LayuiTableData get_kyzb_table_data(LayuiTableParam param)throws Exception
    {
  	        //每页显示条数
	  		int pageSize = param.getLimit();
	  		int pageNum = param.getPage();
	  		Page p=new Page(pageNum,pageSize);
			int start=(pageNum-1)*p.getPageSize();
	  		String month=(String)param.getParam().get("month");
	  		String companyCode=(String)param.getParam().get("companyCode");
	  		
	  		String g0XMGLLX=(String)param.getParam().get("g0XMGLLX");
	  		String g0XMGLLY=(String)param.getParam().get("g0XMGLLY");
	  		String g0XMGLJB=(String)param.getParam().get("g0XMGLJB");
	  		String g0XMLXMS=(String)param.getParam().get("g0XMLXMS");
	  		String g0XMZTMS=(String)param.getParam().get("g0XMZTMS");
	  		String g0PROJTXT=(String)param.getParam().get("g0PROJTXT");
	  		
	  		logger.info("======科研装备三级页面表格 param: "+JSONObject.toJSONString(param));
	  		Map map=new HashMap();
	  		map.put("start", start);
	  		map.put("pageSize", pageSize);
	  		map.put("month", month);
	  		map.put("companyCode", companyCode);
	  		map.put("g0PROJTXT", g0PROJTXT);
	  		map.put("g0XMGLLX", g0XMGLLX);
	  		map.put("g0XMGLLY", g0XMGLLY);
	  		map.put("g0XMGLJB", g0XMGLJB);
	  		map.put("g0XMLXMS", g0XMLXMS);
	  		map.put("g0XMZTMS", g0XMZTMS);
	  		
	  		
	  		
	  		
	  		
	  		List<H1AMKYSY100104> list = homePageMapper.get_KYZB_table_list(map);
	  		Integer totalRecords = homePageMapper.get_KYZB_table_count(map);
	  		System.out.println(">>>>>>>>科研装备三级页面表格："+totalRecords);
	  		LayuiTableData data = new LayuiTableData();
	  		data.setData(list);
	  		data.setCount(totalRecords);
	  	    return data;
    }
    
  	 /**=======================================================科研装备 end=========================*/
    
  	
  	
  	
  	
  	
  	
  	

    
    
    /**=======================================================经费支出 二级页面=========================*/
    
    
    
  	 public List<H1AMKYSY100104>  getJFZCLevel2(Map map)throws Exception
  	 {
  		List<H1AMKYSY100104> list = homeLevel2Mapper.getJFZCLevel2(map);
    	return list;
  	 }
  	 public List<H1AMKYSY100104>  getJFZCLevel2Bar(Map map)throws Exception
  	 {
  		List<H1AMKYSY100104> list = homeLevel2Mapper.getJFZCLevel2Pie(map);
    	return list;
  	 }
  	 
  	public List<H1AMKYSY100104>  getJFXDPie(Map map)throws Exception
 	 {
 		List<H1AMKYSY100104> list = homeLevel2Mapper.getJFXDPie(map);
      	return list;
 	 }
  	 
  	 
  	 public List<H1AMKYSY100104>  getJFZCLevel2Circle(Map map)throws Exception
  	 {
  		List<H1AMKYSY100104> list = homeLevel2Mapper.getJFZCLevel2Circle(map);
    	return list;
  	 }
  	 
  	  public LayuiTableData getJFZCLevel2TAble(LayuiTableParam param)throws Exception
      {
  	  		int pageSize = param.getLimit();
  	  		int pageNum = param.getPage();
  	  		Page p=new Page(pageNum,pageSize);
  			int start=(pageNum-1)*p.getPageSize();
  	  		String month=(String)param.getParam().get("month");
  	  		String companyCode=(String)param.getParam().get("companyCode");
  	  		logger.info("=====经费支出二级页面表格 param: "+JSONObject.toJSONString(param));
  	  		Map map=new HashMap();
  	  		map.put("start", start);
  	  		map.put("pageSize", pageSize);
  	  		map.put("month", month);
  	  		map.put("companyCode", companyCode);
  	  		List<H1AMKYSY100104> list = homeLevel2Mapper.getJFZCLevel2TableList(map);
  	  		Integer totalRecords = homeLevel2Mapper.getJFZCLevel2TableCount(map);
  	  		System.out.println(">>>>>>>>经费支出二级页面表格："+totalRecords);
  	  		LayuiTableData data = new LayuiTableData();
  	  		data.setData(list);
  	  		data.setCount(totalRecords);
  	  	    return data;
      }
  	  
  	public LayuiTableData getJFZCLevel3TAble(LayuiTableParam param)throws Exception
    {
  	        //每页显示条数
	  		int pageSize = param.getLimit();
	  		int pageNum = param.getPage();
	  		Page p=new Page(pageNum,pageSize);
			int start=(pageNum-1)*p.getPageSize();
	  		String month=(String)param.getParam().get("month");
	  		String companyCode=(String)param.getParam().get("companyCode");
	  		
	  		String g0XMGLLX=(String)param.getParam().get("g0XMGLLX");
	  		String g0XMGLLY=(String)param.getParam().get("g0XMGLLY");
	  		String g0XMGLJB=(String)param.getParam().get("g0XMGLJB");
	  		String g0XMLXMS=(String)param.getParam().get("g0XMLXMS");
	  		String g0XMZTMS=(String)param.getParam().get("g0XMZTMS");
	  		String g0PROJTXT=(String)param.getParam().get("g0PROJTXT");
	  		
	  		logger.info("======经费支出三级页面表格 param: "+JSONObject.toJSONString(param));
	  		Map map=new HashMap();
	  		map.put("start", start);
	  		map.put("pageSize", pageSize);
	  		map.put("month", month);
	  		map.put("companyCode", companyCode);
	  		map.put("g0PROJTXT", g0PROJTXT);
	  		map.put("g0XMGLLX", g0XMGLLX);
	  		map.put("g0XMGLLY", g0XMGLLY);
	  		map.put("g0XMGLJB", g0XMGLJB);
	  		map.put("g0XMLXMS", g0XMLXMS);
	  		map.put("g0XMZTMS", g0XMZTMS);
	  		
	  		
	  		
	  		
	  		
	  		List<H1AMKYSY100104> list = homeLevel2Mapper.getJFZCLevel_03_table_list(map);
	  		Integer totalRecords = homeLevel2Mapper.getJFZCLevel_03_Table_count(map);
	  		System.out.println(">>>>>>>经费支出三级页面表格："+totalRecords);
	  		LayuiTableData data = new LayuiTableData();
	  		data.setData(list);
	  		data.setCount(totalRecords);
	  	    return data;
    }
    
  	 /**=======================================================经费支出 end=========================*/
  	
  	
  	
  	/**======================================================科研项目二级========================*/
  	
  	//二级-科研项目
    public List<H1AMKYSY100109> getProjectByCountBar (Map map)throws Exception
    {
    	List<H1AMKYSY100109> list = homeProjectMapper.getProjectByCountBar(map);
    	return list;
    }
    
    public List<H1AMKYSY100109> getProjectByCountPie(Map map)throws Exception
    {
    	List<H1AMKYSY100109> list = homeProjectMapper.getProjectByCountPie(map);
    	return list;
    }
    public List<H1AMKYSY100109> getProjectByCountCricle(Map map)throws Exception
    {
    	List<H1AMKYSY100109> list = homeProjectMapper.getProjectByCountCricle(map);
    	return list;
    }
    public List<H1AMKYSY100109> getProjectByUnitBar(Map map)throws Exception
    {
    	List<H1AMKYSY100109> list = homeProjectMapper.getProjectByUnitBar(map);
    	return list;
    }
    public List<H1AMKYSY100109> getProjectByUnitPie(Map map)throws Exception
    {
    	List<H1AMKYSY100109> list = homeProjectMapper.getProjectByUnitPie(map);
    	return list;
    }
    public List<H1AMKYSY100109> getProjectByUnitCricle(Map map)throws Exception
    {
    	List<H1AMKYSY100109> list = homeProjectMapper.getProjectByUnitCricle(map);
    	return list;
    }
    public List<H1AMKYSY100109> getProjectByDistributeBar(Map map)throws Exception
    {
    	List<H1AMKYSY100109> list = homeProjectMapper.getProjectByDistributeBar(map);
    	return list;
    }
    
    public LayuiTableData getProjectTable(LayuiTableParam param)throws Exception
    {
  	        //每页显示条数
	  		int pageSize = param.getLimit();
	  		int pageNum = param.getPage();
	  		Page p=new Page(pageNum,pageSize);
			int start=(pageNum-1)*p.getPageSize();
	  		String month=(String)param.getParam().get("month");
	  		String companyCode=(String)param.getParam().get("companyCode");
	  		
	  		String g0XMGLLX=(String)param.getParam().get("g0XMGLLX");
	  		String g0XMGLLY=(String)param.getParam().get("g0XMGLLY");
	  		String g0XMGLJB=(String)param.getParam().get("g0XMGLJB");
	  		String g0XMLXMS=(String)param.getParam().get("g0XMLXMS");
	  		String g0XMZTMS=(String)param.getParam().get("g0XMZTMS");
	  		String g0PROJTXT=(String)param.getParam().get("g0PROJTXT");
	  		
	  		logger.info("======经费支出三级页面表格 param: "+JSONObject.toJSONString(param));
	  		Map map=new HashMap();
	  		map.put("start", start);
	  		map.put("pageSize", pageSize);
	  		map.put("month", month);
	  		map.put("companyCode", companyCode);
	  		map.put("g0PROJTXT", g0PROJTXT);
	  		map.put("g0XMGLLX", g0XMGLLX);
	  		map.put("g0XMGLLY", g0XMGLLY);
	  		map.put("g0XMGLJB", g0XMGLJB);
	  		map.put("g0XMLXMS", g0XMLXMS);
	  		map.put("g0XMZTMS", g0XMZTMS);
	  		
	  		
	  		
	  		List<H1AMKYSY100109> list = homeProjectMapper.getTableList(map);
	  		Integer totalRecords = homeProjectMapper.getTableCount(map);
	  		System.out.println(">>>>>>>经费支出三级页面表格："+totalRecords);
	  		LayuiTableData data = new LayuiTableData();
	  		data.setData(list);
	  		data.setCount(totalRecords);
	  	    return data;
    }
    
    /**=======================================================科研项目二级 end=========================*/
  	
    
    
    
    
    
    

  	
  	/**=====================================================科研装备二级========================*/
  	
    public List<H1AMKYSY100109> getDeviceByCountBar (Map map)throws Exception
    {
    	List<H1AMKYSY100109> list = homeDeviceMapper.getDeviceByCountBar(map);
    	return list;
    }
    
    public List<H1AMKYSY100109> getDeviceByCountPie(Map map)throws Exception
    {
    	List<H1AMKYSY100109> list = homeDeviceMapper.getDeviceByCountPie(map);
    	return list;
    }
    public List<H1AMKYSY100109> getDeviceByCountCricle(Map map)throws Exception
    {
    	List<H1AMKYSY100109> list = homeDeviceMapper.getDeviceByCountCricle(map);
    	return list;
    }
    public List<H1AMKYSY100109> getDeviceByUnitBar(Map map)throws Exception
    {
    	List<H1AMKYSY100109> list = homeDeviceMapper.getDeviceByUnitBar(map);
    	return list;
    }
    public List<H1AMKYSY100109> getDeviceByUnitPie(Map map)throws Exception
    {
    	List<H1AMKYSY100109> list = homeDeviceMapper.getDeviceByUnitPie(map);
    	return list;
    }
    public List<H1AMKYSY100109> getDeviceByUnitCricle(Map map)throws Exception
    {
    	List<H1AMKYSY100109> list = homeDeviceMapper.getDeviceByUnitCricle(map);
    	return list;
    }
    public List<H1AMKYSY100109> getDeviceByDistributeBar(Map map)throws Exception
    {
    	List<H1AMKYSY100109> list = homeDeviceMapper.getDeviceByDistributeBar(map);
    	return list;
    }
    public LayuiTableData getDeviceTable(LayuiTableParam param)throws Exception
    {
  	        //每页显示条数
	  		int pageSize = param.getLimit();
	  		int pageNum = param.getPage();
	  		Page p=new Page(pageNum,pageSize);
			int start=(pageNum-1)*p.getPageSize();
	  		String month=(String)param.getParam().get("month");
	  		String companyCode=(String)param.getParam().get("companyCode");
	  		
	  		String g0XMGLLX=(String)param.getParam().get("g0XMGLLX");
	  		String g0XMGLLY=(String)param.getParam().get("g0XMGLLY");
	  		String g0XMGLJB=(String)param.getParam().get("g0XMGLJB");
	  		String g0XMLXMS=(String)param.getParam().get("g0XMLXMS");
	  		String g0XMZTMS=(String)param.getParam().get("g0XMZTMS");
	  		String g0PROJTXT=(String)param.getParam().get("g0PROJTXT");
	  		
	  		logger.info("=====科研装备三级页面表格 param: "+JSONObject.toJSONString(param));
	  		Map map=new HashMap();
	  		map.put("start", start);
	  		map.put("pageSize", pageSize);
	  		map.put("month", month);
	  		map.put("companyCode", companyCode);
	  		map.put("g0PROJTXT", g0PROJTXT);
	  		map.put("g0XMGLLX", g0XMGLLX);
	  		map.put("g0XMGLLY", g0XMGLLY);
	  		map.put("g0XMGLJB", g0XMGLJB);
	  		map.put("g0XMLXMS", g0XMLXMS);
	  		map.put("g0XMZTMS", g0XMZTMS);
	  		
	  		
	  		
	  		List<H1AMKYSY100109> list = homeDeviceMapper.getTableList(map);
	  		Integer totalRecords = homeDeviceMapper.getTableCount(map);
	  		System.out.println(">>>>>>>科研装备三级页面表格："+totalRecords);
	  		LayuiTableData data = new LayuiTableData();
	  		data.setData(list);
	  		data.setCount(totalRecords);
	  	    return data;
    }
    /**=======================================================科研装备二级 end=========================*/
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    

  	/**======================================================预算二级========================*/
  	
    public List<H1AMKYSY100109> getBudgetByCountBar (Map map)throws Exception
    {
    	List<H1AMKYSY100109> list = homeBudgetMapper.getBudgetByCountBar(map);
    	return list;
    }
    
    public List<H1AMKYSY100109> getBudgetByCountPie(Map map)throws Exception
    {
    	List<H1AMKYSY100109> list = homeBudgetMapper.getBudgetByCountPie(map);
    	return list;
    }
    public List<H1AMKYSY100109> getBudgetByCountCricle(Map map)throws Exception
    {
    	List<H1AMKYSY100109> list = homeBudgetMapper.getBudgetByCountCricle(map);
    	return list;
    }
    public List<H1AMKYSY100109> getBudgetByUnitBar(Map map)throws Exception
    {
    	List<H1AMKYSY100109> list = homeBudgetMapper.getBudgetByUnitBar(map);
    	return list;
    }
    public List<H1AMKYSY100109> getBudgetByUnitPie(Map map)throws Exception
    {
    	List<H1AMKYSY100109> list = homeBudgetMapper.getBudgetByUnitPie(map);
    	return list;
    }
    public List<H1AMKYSY100109> getBudgetByUnitCricle(Map map)throws Exception
    {
    	List<H1AMKYSY100109> list = homeBudgetMapper.getBudgetByUnitCricle(map);
    	return list;
    }
    public List<H1AMKYSY100109> getBudgetByDistributeBar(Map map)throws Exception
    {
    	List<H1AMKYSY100109> list = homeBudgetMapper.getBudgetByDistributeBar(map);
    	return list;
    }
    public LayuiTableData getBudgetTable(LayuiTableParam param)throws Exception
    {
  	        //每页显示条数
	  		int pageSize = param.getLimit();
	  		int pageNum = param.getPage();
	  		Page p=new Page(pageNum,pageSize);
			int start=(pageNum-1)*p.getPageSize();
	  		String month=(String)param.getParam().get("month");
	  		String companyCode=(String)param.getParam().get("companyCode");
	  		
	  		String g0XMGLLX=(String)param.getParam().get("g0XMGLLX");
	  		String g0XMGLLY=(String)param.getParam().get("g0XMGLLY");
	  		String g0XMGLJB=(String)param.getParam().get("g0XMGLJB");
	  		String g0XMLXMS=(String)param.getParam().get("g0XMLXMS");
	  		String g0XMZTMS=(String)param.getParam().get("g0XMZTMS");
	  		String g0PROJTXT=(String)param.getParam().get("g0PROJTXT");
	  		
	  		logger.info("======经费支出三级页面表格 param: "+JSONObject.toJSONString(param));
	  		Map map=new HashMap();
	  		map.put("start", start);
	  		map.put("pageSize", pageSize);
	  		map.put("month", month);
	  		map.put("companyCode", companyCode);
	  		map.put("g0PROJTXT", g0PROJTXT);
	  		map.put("g0XMGLLX", g0XMGLLX);
	  		map.put("g0XMGLLY", g0XMGLLY);
	  		map.put("g0XMGLJB", g0XMGLJB);
	  		map.put("g0XMLXMS", g0XMLXMS);
	  		map.put("g0XMZTMS", g0XMZTMS);
	  		
	  		
	  		
	  		List<H1AMKYSY100109> list = homeBudgetMapper.getTableList(map);
	  		Integer totalRecords = homeBudgetMapper.getTableCount(map);
	  		System.out.println(">>>>>>>预算支出三级页面表格："+totalRecords);
	  		LayuiTableData data = new LayuiTableData();
	  		data.setData(list);
	  		data.setCount(totalRecords);
	  	    return data;
    }
    
    /**=======================================================预算二级 end=========================*/
  	
    
    
    
    
    
    
    

  	/**======================================================支出二级========================*/
  	
    public List<H1AMKYSY100109> getPayByCountBar (Map map)throws Exception
    {
    	List<H1AMKYSY100109> list = homePayMapper.getPayByCountBar(map);
    	return list;
    }
    
    public List<H1AMKYSY100109> getPayByCountPie(Map map)throws Exception
    {
    	List<H1AMKYSY100109> list = homePayMapper.getPayByCountPie(map);
    	return list;
    }
    public List<H1AMKYSY100109> getPayByCountCricle(Map map)throws Exception
    {
    	List<H1AMKYSY100109> list = homePayMapper.getPayByCountCricle(map);
    	return list;
    }
    public List<H1AMKYSY100109> getPayByUnitBar(Map map)throws Exception
    {
    	List<H1AMKYSY100109> list = homePayMapper.getPayByUnitBar(map);
    	return list;
    }
    public List<H1AMKYSY100109> getPayByUnitPie(Map map)throws Exception
    {
    	List<H1AMKYSY100109> list = homePayMapper.getPayByUnitPie(map);
    	return list;
    }
    public List<H1AMKYSY100109> getPayByUnitCricle(Map map)throws Exception
    {
    	List<H1AMKYSY100109> list = homePayMapper.getPayByUnitCricle(map);
    	return list;
    }
    public List<H1AMKYSY100109> getPayByDistributeBar(Map map)throws Exception
    {
    	List<H1AMKYSY100109> list = homePayMapper.getPayByDistributeBar(map);
    	return list;
    }
    
    
    public LayuiTableData getPayTable(LayuiTableParam param)throws Exception
    {
  	        //每页显示条数
	  		int pageSize = param.getLimit();
	  		int pageNum = param.getPage();
	  		Page p=new Page(pageNum,pageSize);
			int start=(pageNum-1)*p.getPageSize();
	  		String month=(String)param.getParam().get("month");
	  		String companyCode=(String)param.getParam().get("companyCode");
	  		
	  		String g0XMGLLX=(String)param.getParam().get("g0XMGLLX");
	  		String g0XMGLLY=(String)param.getParam().get("g0XMGLLY");
	  		String g0XMGLJB=(String)param.getParam().get("g0XMGLJB");
	  		String g0XMLXMS=(String)param.getParam().get("g0XMLXMS");
	  		String g0XMZTMS=(String)param.getParam().get("g0XMZTMS");
	  		String g0PROJTXT=(String)param.getParam().get("g0PROJTXT");
	  		
	  		logger.info("======经费支出三级页面表格 param: "+JSONObject.toJSONString(param));
	  		Map map=new HashMap();
	  		map.put("start", start);
	  		map.put("pageSize", pageSize);
	  		map.put("month", month);
	  		map.put("companyCode", companyCode);
	  		map.put("g0PROJTXT", g0PROJTXT);
	  		map.put("g0XMGLLX", g0XMGLLX);
	  		map.put("g0XMGLLY", g0XMGLLY);
	  		map.put("g0XMGLJB", g0XMGLJB);
	  		map.put("g0XMLXMS", g0XMLXMS);
	  		map.put("g0XMZTMS", g0XMZTMS);
	  		
	  		
	  		
	  		List<H1AMKYSY100109> list = homePayMapper.getTableList(map);
	  		Integer totalRecords = homePayMapper.getTableCount(map);
	  		System.out.println(">>>>>>>经费支出三级页面表格："+totalRecords);
	  		LayuiTableData data = new LayuiTableData();
	  		data.setData(list);
	  		data.setCount(totalRecords);
	  	    return data;
    }
    
    /**=======================================================支出二级 end=========================*/
  	
    
    
    
    
    
    
    
    
  	
}
