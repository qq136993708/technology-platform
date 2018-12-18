package com.pcitc.service.system.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSONObject;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.pcitc.base.common.LayuiTableData;
import com.pcitc.base.common.LayuiTableParam;
import com.pcitc.base.system.SysNews;
import com.pcitc.base.system.ireport.SysUserInfo;
import com.pcitc.base.util.DateUtil;
import com.pcitc.base.util.StrUtil;
import com.pcitc.mapper.system.SysNewsMapper;
import com.pcitc.service.system.SysNewsService;

@Service
public class SysNewsServiceImpl implements SysNewsService {

	@Autowired
	private SysNewsMapper sysNewsDao;

	@Override
	public LayuiTableData selectNews(LayuiTableParam param) throws Exception {
		// 每页显示条数
		int pageSize = param.getLimit();
		// 从第多少条开始
		int pageStart = (param.getPage() - 1) * pageSize;
		// 当前是第几页
		int pageNum = pageStart / pageSize + 1;
		// 1、设置分页信息，包括当前页数和每页显示的总计数
		PageHelper.startPage(pageNum, pageSize);

		SysNews news = new SysNews();

		news.setTitle((String) param.getParam().get("title"));
		String status = (String) param.getParam().get("status");
		if (StrUtil.isNotBlank(status)) {
			news.setStatus(Byte.valueOf(status));
		}

		List<SysNews> list = sysNewsDao.selectNews(news);

		// 3、获取分页查询后的数据
		PageInfo<SysNews> pageInfo = new PageInfo<SysNews>(list);
		LayuiTableData data = new LayuiTableData();
		data.setData(pageInfo.getList());
		Long total = pageInfo.getTotal();
		data.setCount(total.intValue());
		return data;
	}

	@Override
	public int updateOrInsertNews(JSONObject newsInfo) throws Exception {
		int result = 500;
		SysNews news = JSONObject.parseObject(newsInfo.get("news").toString(), SysNews.class);
		SysUserInfo user = JSONObject.parseObject(newsInfo.getJSONObject("user").toString(), SysUserInfo.class);
		if (news.getId() != null && news.getId() != null) {
			news.setUpdatetime(DateUtil.format(new Date(), DateUtil.FMT_SS));
			news.setAuthor(user.getUserdisp());
			sysNewsDao.updateByPrimaryKeySelective(news);
		} else {
			// 创建时讲修改时间 也附上，作为发布时间用
			news.setCreatetime(DateUtil.format(new Date(), DateUtil.FMT_SS));
			news.setUpdatetime(DateUtil.format(new Date(), DateUtil.FMT_SS));
			news.setAuthor(user.getUserdisp());
			sysNewsDao.insertSelective(news);
		}
		result = 200;
		return result;
	}

	@Override
	public int deleteNews(Integer id) throws Exception {
		int result = 500;
		if (id != null) {
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
		// for (int i = 0,j=sysNewsList.size(); i < j; i++) {
		// if (sysNewsList.get(i).getTitle().length()>20){
		// sysNewsList.get(i).setTitle(sysNewsList.get(i).getTitle().substring(0,20)+"...");
		// }
		// }
		return sysNewsList;
	}
}
