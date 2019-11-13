package com.pcitc.service.system;

import java.util.List;

import com.alibaba.fastjson.JSONObject;
import com.pcitc.base.common.LayuiTableData;
import com.pcitc.base.common.LayuiTableParam;
import com.pcitc.base.system.SysNews;

public interface SysNewsService {

	LayuiTableData selectNews(LayuiTableParam tableInfo) throws Exception;
	
	int updateOrInsertNews(JSONObject news) throws Exception;
	
	int deleteNews(Integer id) throws Exception;
	
	
	SysNews getNewsInfo(Integer id) throws Exception;

	/**
	 * 首页:查询新闻信息
	 * @param news
	 * @return
	 */
	List<SysNews> selectNewsMain(SysNews news) throws Exception;

}
