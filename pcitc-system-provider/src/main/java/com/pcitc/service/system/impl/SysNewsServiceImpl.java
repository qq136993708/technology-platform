package com.pcitc.service.system.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.pcitc.base.common.LayuiTableData;
import com.pcitc.base.common.LayuiTableParam;
import com.pcitc.base.system.SysNews;
import com.pcitc.mapper.system.SysNewsMapper;
import com.pcitc.service.system.SysNewsService;

@Service
public class SysNewsServiceImpl implements SysNewsService{
	
	@Autowired
	private SysNewsMapper sysNewsDao;

	@Override
	public LayuiTableData selectNews(LayuiTableParam param) throws Exception {
		//每页显示条数
		int pageSize = param.getLimit();
		//从第多少条开始
		int pageStart = (param.getPage()-1)*pageSize;
		//当前是第几页
		int pageNum = pageStart/pageSize + 1;
		// 1、设置分页信息，包括当前页数和每页显示的总计数
		PageHelper.startPage(pageNum, pageSize);
		
		SysNews news = new SysNews();
/*		news.setiSortCol(tableInfo.getiSortCol());
		news.setsSortDir_0(tableInfo.getsSortDir_0());*/
		news.setTitle((String) param.getParam().get("title"));
		
		List<SysNews> list = sysNewsDao.selectNews(news);
		
		// 3、获取分页查询后的数据
		PageInfo<SysNews> pageInfo= new PageInfo<SysNews>(list);
		LayuiTableData data = new LayuiTableData();
		data.setData(pageInfo.getList());
		Long total = pageInfo.getTotal();
		data.setCount(total.intValue());
		return data;
	}

	@Override
	public int updateOrInsertNews(SysNews news) throws Exception {
		int result = 500;
		if(news.getId() !=null && news.getId() != null){
			news.setUpdatetime(new Date());
			sysNewsDao.updateByPrimaryKeySelective(news);
		}else{
			news.setCreatetime(new Date());
			news.setUpdatetime(new Date());
			sysNewsDao.insertSelective(news);
		}
		result = 200;
		return result;
	}

	@Override
	public int deleteNews(Integer id) throws Exception {
		int result = 500;
		if(id != null){
			sysNewsDao.deleteByPrimaryKey(id);
		}
		result = 200;
		return result;
	}

	@Override
	public SysNews getNewsInfo(Integer id) throws Exception {
		
		return sysNewsDao.selectByPrimaryKey(id);
	}

	@Override
	public List<SysNews> selectNewsMain(SysNews news) throws Exception {
		List<SysNews> sysNewsList = sysNewsDao.selectNewsMain(news);
//		for (int i = 0,j=sysNewsList.size(); i < j; i++) {
//			if (sysNewsList.get(i).getTitle().length()>20){
//				sysNewsList.get(i).setTitle(sysNewsList.get(i).getTitle().substring(0,20)+"...");
//			}
//		}
		return sysNewsList;
	}
}
