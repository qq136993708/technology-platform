package com.pcitc.mapper.financial;

import java.util.List;
import java.util.Map;

import com.pcitc.base.hana.report.ScientificInvestment;

public interface ScientificInvestmentMapper {
     public List<ScientificInvestment> getList(Map map);
	 public Integer getCount(Map map);
}
