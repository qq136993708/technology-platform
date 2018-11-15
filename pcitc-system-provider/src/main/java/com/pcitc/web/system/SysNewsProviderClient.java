package com.pcitc.web.system;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.pcitc.base.common.LayuiTableData;
import com.pcitc.base.common.LayuiTableParam;
import com.pcitc.base.system.SysNews;
import com.pcitc.service.system.SysNewsService;

@RestController
public class SysNewsProviderClient {
	
	@Autowired
	private SysNewsService sysNewsService;
	
	private final static Logger logger = LoggerFactory.getLogger(SysNewsProviderClient.class);
	
	
	@RequestMapping(value = "/news-provider/news_list",method = RequestMethod.POST)
	public LayuiTableData selectNewsList(@RequestBody LayuiTableParam param) {
		LayuiTableData news = null;
		try {
			news = sysNewsService.selectNews(param);
		} catch (Exception e) {
			logger.error("[新闻管理-查询新闻列表失败：]", e);
		}
		return news;
	}
	
	@RequestMapping(value = "/news-provider/save_news",method = RequestMethod.POST)
	public int updateOrInsertNews(@RequestBody SysNews news){
		try {
			return sysNewsService.updateOrInsertNews(news);
		} catch (Exception e) {
			logger.error("[新闻管理-保存新闻信息失败：]", e);
		}
		return 500;
	}
	
	@RequestMapping(value = "/news-provider/delete_news/{id}",method = RequestMethod.POST)
	public int deleteNews(@PathVariable(value = "id", required = true) String id){
		try {
			return sysNewsService.deleteNews(Integer.valueOf(id));
		} catch (Exception e) {
			logger.error("[新闻管理-删除新闻信息失败：]", e);
		}
		return 500;
	}
	
	@RequestMapping(value = "/news-provider/get_news/{id}",method = RequestMethod.POST)
	public SysNews getNewsInfo(@PathVariable(value = "id", required = true) String id){
		try {
			return sysNewsService.getNewsInfo(Integer.valueOf(id));
		} catch (Exception e) {
			logger.error("[新闻管理-初始化新闻信息失败：]", e);
		}
		return null;
	}

	/**
	 * 查询已发布的新闻信息
	 * @param news
	 * @return
	 */
	@RequestMapping(value = "/news-provider/select_news_main",method = RequestMethod.POST)
	public List<SysNews> selectNewsMain(@RequestBody SysNews news){
		try {
			return sysNewsService.selectNewsMain(news);
		} catch (Exception e) {
			logger.error("[新闻管理-首页查询新闻信息失败：]", e);
		}
		return null;
	}

}
