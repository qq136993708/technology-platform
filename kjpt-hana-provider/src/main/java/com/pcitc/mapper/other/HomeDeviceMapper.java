package com.pcitc.mapper.other;

import java.util.List;
import java.util.Map;

import com.pcitc.base.hana.report.H1AMKYSY100109;

public interface HomeDeviceMapper {
	
    public List<H1AMKYSY100109> getDeviceByCountBar (Map map);
    public List<H1AMKYSY100109> getDeviceByCountPie(Map map);
    public List<H1AMKYSY100109> getDeviceByCountCricle(Map map);
    public List<H1AMKYSY100109> getDeviceByUnitBar(Map map);
    public List<H1AMKYSY100109> getDeviceByUnitPie(Map map);
    public List<H1AMKYSY100109> getDeviceByUnitCricle(Map map);
    public List<H1AMKYSY100109> getDeviceByDistributeBar(Map map);
    
    
    public List<H1AMKYSY100109> getTableList(Map map);
	 
	 public Integer getTableCount(Map map);
    
    
    

}
