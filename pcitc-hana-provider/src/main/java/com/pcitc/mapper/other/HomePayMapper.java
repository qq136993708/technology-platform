package com.pcitc.mapper.other;

import java.util.List;
import java.util.Map;

import com.pcitc.base.hana.report.H1AMKYSY100109;

public interface HomePayMapper {
	
    public List<H1AMKYSY100109> getPayByCountBar (Map map);
    public List<H1AMKYSY100109> getPayByCountPie(Map map);
    public List<H1AMKYSY100109> getPayByCountCricle(Map map);
    public List<H1AMKYSY100109> getPayByUnitBar(Map map);
    public List<H1AMKYSY100109> getPayByUnitPie(Map map);
    public List<H1AMKYSY100109> getPayByUnitCricle(Map map);
    public List<H1AMKYSY100109> getPayByDistributeBar(Map map);
    

    public List<H1AMKYSY100109> getTableList(Map map);
	 
	 public Integer getTableCount(Map map);
    

}
