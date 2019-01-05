package com.pcitc.mapper.financial;
import java.util.List;
import java.util.Map;
import com.pcitc.base.hana.report.ScientificFunds;

public interface ScientificFundsMapper {
	 public List<ScientificFunds> getList(Map map);
	 public Integer getCount(Map map);
}
