package com.pcitc.service;

import java.util.List;
import java.util.Map;

import com.pcitc.base.common.LayuiTableData;
import com.pcitc.base.common.LayuiTableParam;
import com.pcitc.base.hana.report.H1AMKYSY100101;
import com.pcitc.base.hana.report.H1AMKYSY100104;
import com.pcitc.base.hana.report.H1AMKYSY100109;
import com.pcitc.base.hana.report.H1AMKYSY100117;

public interface IHomeService {
	
	public List<H1AMKYSY100101> getH1AMKYSY100101Count (Map map)throws Exception;
	
    public List<H1AMKYSY100104> getH1AMKYSY100104Count (Map map)throws Exception;
    //年度预算 经费支出
    public List<H1AMKYSY100104> getndys_xfzc(Map map)throws Exception;
    
    public List<H1AMKYSY100109> getH1AMKYSY100109Report(Map map)throws Exception;
    
    public List<H1AMKYSY100109> getH1AMKYSY100109Count(Map map)throws Exception;
    
    public List<H1AMKYSY100109> getH1AMKYSY100109Count02(Map map)throws Exception;
    
    public List<H1AMKYSY100117>  getDzzk(Map map)throws Exception;
    
    public List<H1AMKYSY100117>  getDzzk_bar(Map map)throws Exception;
    
    public List<H1AMKYSY100117>  get_direct_KYZB(Map map)throws Exception;
    public List<H1AMKYSY100117>  get_direct_KYZB_02(Map map)throws Exception;
    
    public  List<H1AMKYSY100117> get_home_KYZB(Map map)throws Exception;
    public  List<H1AMKYSY100117> get_home_KYZB_02(Map map)throws Exception;
    
    
    public LayuiTableData getNdkyxmzlTble(LayuiTableParam param)throws Exception;
    
    
    //二级页面
    public List<H1AMKYSY100109> getNdkyxmzl(Map map)throws Exception;
    public List<H1AMKYSY100109> getNdkyxmzl02(Map map)throws Exception;
    
    public List<H1AMKYSY100109> getNdkyxmzBar(Map map)throws Exception;
    public List<H1AMKYSY100109> getNdkyxmzCircle(Map map)throws Exception;
    
    
    public LayuiTableData getListLevel2(LayuiTableParam param)throws Exception;
    
    
    
    
    
    //科研装备二级页面
    public List<H1AMKYSY100109>  getLevel2KYZB01(Map map)throws Exception;
 	public List<H1AMKYSY100109>  getLevel2KYZB02Bar(Map map)throws Exception;
 	public List<H1AMKYSY100109>  getLevel2KYZB03Circle(Map map)throws Exception;
 	public LayuiTableData getKYZBTble(LayuiTableParam param)throws Exception;
    
    //三级
    public LayuiTableData get_kyzb_table_data(LayuiTableParam param)throws Exception;
    public LayuiTableData getZhuanziTableList(LayuiTableParam param)throws Exception;
    
    

    
    //经费支出二级页面
    public List<H1AMKYSY100104>  getJFZCLevel2(Map map)throws Exception;
 	public List<H1AMKYSY100104>  getJFZCLevel2Bar(Map map)throws Exception;
 	public List<H1AMKYSY100104>  getJFZCLevel2Circle(Map map)throws Exception;
 	public LayuiTableData getJFZCLevel2TAble(LayuiTableParam param)throws Exception;
    //经费支出三级
    public LayuiTableData getJFZCLevel3TAble(LayuiTableParam param)throws Exception;
    public List<H1AMKYSY100104>  getJFXDPie(Map map)throws Exception;
    
    
    
    
    
    
    
    
    //二级-科研项目
    public List<H1AMKYSY100109> getProjectByCountBar (Map map)throws Exception;
    public List<H1AMKYSY100109> getProjectByCountPie(Map map)throws Exception;
    public List<H1AMKYSY100109> getProjectByCountCricle(Map map)throws Exception;
    public List<H1AMKYSY100109> getProjectByUnitBar(Map map)throws Exception;
    public List<H1AMKYSY100109> getProjectByUnitPie(Map map)throws Exception;
    public List<H1AMKYSY100109> getProjectByUnitCricle(Map map)throws Exception;
    public List<H1AMKYSY100109> getProjectByDistributeBar(Map map)throws Exception;
    public LayuiTableData getProjectTable(LayuiTableParam param)throws Exception;
    
    

    
    //二级-科研装备
    public List<H1AMKYSY100109> getDeviceByCountBar (Map map)throws Exception;
    public List<H1AMKYSY100109> getDeviceByCountPie(Map map)throws Exception;
    public List<H1AMKYSY100109> getDeviceByCountCricle(Map map)throws Exception;
    public List<H1AMKYSY100109> getDeviceByUnitBar(Map map)throws Exception;
    public List<H1AMKYSY100109> getDeviceByUnitPie(Map map)throws Exception;
    public List<H1AMKYSY100109> getDeviceByUnitCricle(Map map)throws Exception;
    public List<H1AMKYSY100109> getDeviceByDistributeBar(Map map)throws Exception;
    public LayuiTableData getDeviceTable(LayuiTableParam param)throws Exception;
    
    
    //二级-预算
    public List<H1AMKYSY100109> getBudgetByCountBar (Map map)throws Exception;
    public List<H1AMKYSY100109> getBudgetByCountPie(Map map)throws Exception;
    public List<H1AMKYSY100109> getBudgetByCountCricle(Map map)throws Exception;
    public List<H1AMKYSY100109> getBudgetByUnitBar(Map map)throws Exception;
    public List<H1AMKYSY100109> getBudgetByUnitPie(Map map)throws Exception;
    public List<H1AMKYSY100109> getBudgetByUnitCricle(Map map)throws Exception;
    public List<H1AMKYSY100109> getBudgetByDistributeBar(Map map)throws Exception;
    public LayuiTableData getBudgetTable(LayuiTableParam param)throws Exception;
    
    
    
    
    
    
    //二级-支出
    public List<H1AMKYSY100109> getPayByCountBar (Map map)throws Exception;
    public List<H1AMKYSY100109> getPayByCountPie(Map map)throws Exception;
    public List<H1AMKYSY100109> getPayByCountCricle(Map map)throws Exception;
    public List<H1AMKYSY100109> getPayByUnitBar(Map map)throws Exception;
    public List<H1AMKYSY100109> getPayByUnitPie(Map map)throws Exception;
    public List<H1AMKYSY100109> getPayByUnitCricle(Map map)throws Exception;
    public List<H1AMKYSY100109> getPayByDistributeBar(Map map)throws Exception;
    public LayuiTableData getPayTable(LayuiTableParam param)throws Exception;
    
    
    
    
    

}
