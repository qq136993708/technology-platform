package com.pcitc.mapper.financial;

import java.util.List;
import java.util.Map;

import com.pcitc.base.hana.report.TopicDevelop;

public interface TopicDevelopMapper {
	 public List<TopicDevelop> getTopicDevelopPotList(Map map);
	 public List<TopicDevelop> getlist(Map map);
	 public Integer getCount(Map map);
	 
	 
}
