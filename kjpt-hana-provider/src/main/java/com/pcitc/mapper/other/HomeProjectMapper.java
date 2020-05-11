package com.pcitc.mapper.other;

import java.util.List;
import java.util.Map;

import com.pcitc.base.hana.report.H1AMKYSY100109;

public interface HomeProjectMapper {
	
    public List<H1AMKYSY100109> getProjectByCountBar (Map map);
    public List<H1AMKYSY100109> getProjectByCountPie(Map map);
    public List<H1AMKYSY100109> getProjectByCountCricle(Map map);
    public List<H1AMKYSY100109> getProjectByUnitBar(Map map);
    public List<H1AMKYSY100109> getProjectByUnitPie(Map map);
    public List<H1AMKYSY100109> getProjectByUnitCricle(Map map);
    public List<H1AMKYSY100109> getProjectByDistributeBar(Map map);
    public List<H1AMKYSY100109> getTableList(Map map);
	 
	 public Integer getTableCount(Map map);
   
    
    

}
