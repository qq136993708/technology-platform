package com.pcitc.service.out.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.pcitc.base.common.LayuiTableData;
import com.pcitc.base.common.LayuiTableParam;
import com.pcitc.base.stp.out.OutReward;
import com.pcitc.base.stp.out.OutRewardExample;
import com.pcitc.mapper.out.OutRewardMapper;
import com.pcitc.service.out.OutRewardService;

@Service("outRewardService")
@Transactional(propagation = Propagation.REQUIRED, readOnly = false, rollbackFor = Exception.class)
public class OutRewardServiceImpl implements OutRewardService {

	@Autowired
	private OutRewardMapper		outRewardMapper;

	private final static Logger	logger	= LoggerFactory.getLogger(OutRewardServiceImpl.class);

	public LayuiTableData getOutRewardPage(LayuiTableParam param) {
		Map<String, Object> paraMap = param.getParam();

		// 1、设置分页信息，包括当前页数和每页显示的总计数
		PageHelper.startPage(param.getPage(), param.getLimit());

		OutRewardExample example = new OutRewardExample();
		OutRewardExample.Criteria criteria = example.createCriteria();
		example.setOrderByClause(" create_date desc ");

		List<OutReward> list = outRewardMapper.selectByExample(example);
		PageInfo<OutReward> pageInfo = new PageInfo<OutReward>(list);
		System.out.println(">>>>>>>>>查询分页结果"+pageInfo.getList().size());

		LayuiTableData data = new LayuiTableData();
		data.setData(pageInfo.getList());
		Long total = pageInfo.getTotal();
		data.setCount(total.intValue());
		return data;
	}

	public LayuiTableData getOutRewardListPage(LayuiTableParam param) {
		Map<String, Object> paraMap = param.getParam();

		// 1、设置分页信息，包括当前页数和每页显示的总计数
		PageHelper.startPage(param.getPage(), param.getLimit());

		OutRewardExample example = new OutRewardExample();
		OutRewardExample.Criteria criteria = example.createCriteria();

		if (paraMap.get("xmbh")!=null&&!paraMap.get("xmbh").toString().equals("")) {
			criteria.andXmbhLike("%"+paraMap.get("xmbh").toString()+"%");
		}
		if (paraMap.get("nd")!=null&&!paraMap.get("nd").toString().equals("")) {
			criteria.andNdEqualTo(paraMap.get("nd").toString());
		}
		if (paraMap.get("xmmc")!=null&&!paraMap.get("xmmc").toString().equals("")) {
            criteria.andXmmcLike("%"+paraMap.get("xmmc").toString()+"%");
        }

        //添加name值查询 start
        if (paraMap.get("name")!=null&&!paraMap.get("name").toString().equals("")) {
            criteria.andXmmcLike("%"+paraMap.get("name").toString()+"%");
        }
        //添加name值查询 end

        example.setOrderByClause(" sbjz,sbdj asc ");

		List<OutReward> list = outRewardMapper.selectByExample(example);
		PageInfo<OutReward> pageInfo = new PageInfo<OutReward>(list);
		System.out.println(">>>>>>>>>查询分页结果"+pageInfo.getList().size());

		LayuiTableData data = new LayuiTableData();
		data.setData(pageInfo.getList());
		Long total = pageInfo.getTotal();
		data.setCount(total.intValue());
		return data;
	}

	@Override
	public OutReward getOutRewardShowById(String dataId) {
		return outRewardMapper.selectByPrimaryKey(dataId);
	}

	public int insertRewardData(List<OutReward> list) {
		outRewardMapper.insertOutRewardBatch(list);
		return 1;
	}

	@Override
	public List<String> selectOutRewardYearList() {
		return outRewardMapper.selectOutRewardYearList();
	}

	/**
	 * 辅助决策中心，科技奖励年度趋势分析, 近5年各类奖励类型的数量情况
	 */
	public List getRewardBySbjzWithFiveYear(HashMap<String, String> map) {
		return outRewardMapper.getRewardBySbjzWithFiveYear(map);
	}
	
	/**
	 * 辅助决策中心，科技奖励年度趋势分析, 各个研究院的奖励情况
	 */
	public List getRewardInfoByYjy(HashMap<String, String> map) {
		return outRewardMapper.getRewardInfoByYjy(map);
	}
}
