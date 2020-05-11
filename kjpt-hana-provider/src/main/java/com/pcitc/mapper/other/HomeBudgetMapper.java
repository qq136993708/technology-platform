package com.pcitc.mapper.other;

import java.util.List;
import java.util.Map;

import com.pcitc.base.hana.report.H1AMKYSY100109;

public interface HomeBudgetMapper {
	
    public List<H1AMKYSY100109> getBudgetByCountBar (Map map);
    public List<H1AMKYSY100109> getBudgetByCountPie(Map map);
    public List<H1AMKYSY100109> getBudgetByCountCricle(Map map);
    public List<H1AMKYSY100109> getBudgetByUnitBar(Map map);
    public List<H1AMKYSY100109> getBudgetByUnitPie(Map map);
    public List<H1AMKYSY100109> getBudgetByUnitCricle(Map map);
    public List<H1AMKYSY100109> getBudgetByDistributeBar(Map map);
    

    public List<H1AMKYSY100109> getTableList(Map map);
	 
	 public Integer getTableCount(Map map);
    

}
