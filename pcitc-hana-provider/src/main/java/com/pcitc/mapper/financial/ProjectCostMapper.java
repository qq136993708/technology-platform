package com.pcitc.mapper.financial;

import java.util.List;
import java.util.Map;

import com.pcitc.base.hana.report.ProjectCost;

public interface ProjectCostMapper {
	 public List<ProjectCost> getList(Map map);
	 public Integer getCount(Map map);
}
