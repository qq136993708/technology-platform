package com.pcitc.service.out.impl;

import java.util.*;
import java.util.stream.Collectors;

import com.alibaba.fastjson.JSONObject;
import com.pcitc.base.expert.ZjkChoice;
import com.pcitc.base.expert.ZjkChoiceExample;
import com.pcitc.base.util.MyBeanUtils;
import com.pcitc.base.util.StrUtil;
import com.pcitc.web.feign.ZjkBaseInfoServiceClient;
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
import com.pcitc.base.system.SysUser;
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
		criteria.andSbztEqualTo("已上报");
		
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
            criteria.andDefine3Like("%"+paraMap.get("name").toString()+"%");
        }

        criteria.andSbztEqualTo("已上报");

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
		// 删除原有的2018年及以后年份的数据(新数据)
		OutRewardExample example = new OutRewardExample();
		OutRewardExample.Criteria criteria = example.createCriteria();
		criteria.andStatusEqualTo("newData");
		outRewardMapper.deleteByExample(example);
		
		outRewardMapper.insertOutRewardBatch(list);
		outRewardMapper.updateOutReward();
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

    @Override
    public LayuiTableData getOutRewardListPageExpert(LayuiTableParam param) {

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
            criteria.andDefine3Like("%"+paraMap.get("name").toString()+"%");
        }

        Object dataId = param.getParam().get("dataId");
        if (dataId != null&&!"".equals(dataId)) {
            criteria.andDataIdIn(Arrays.asList(dataId.toString().split(",")));
        }

        criteria.andSbztEqualTo("已上报");

        example.setOrderByClause(" sbjz,sbdj asc ");

        List<OutReward> list = outRewardMapper.selectByExample(example);
        PageInfo<OutReward> pageInfo = new PageInfo<OutReward>(list);
        System.out.println(">>>>>>>>>查询分页结果"+pageInfo.getList().size());

        //专家评审字段标红
        Object zjps = param.getParam().get("zjps");
        if (zjps != null&&!"".equals(zjps)) {
            int j = pageInfo.getList().size();

            List<String> ids = new ArrayList<>();
            for (int i = 0; i < j; i++) {
                ids.add(pageInfo.getList().get(i).getDataId());
            }
            if(ids==null||ids.size()==0){
                ids.add("");
            }
            ZjkChoiceExample zjkChoiceExample = new ZjkChoiceExample();
            zjkChoiceExample.createCriteria().andXmIdIn(ids);
            JSONObject jsonObject = new JSONObject();
            jsonObject.put("list",ids);
            List<Map<String,Object>> objectMap = (List<Map<String, Object>>) zjkBaseInfoServiceClient.selectByExample(jsonObject).get("list");
            List<ZjkChoice> zjkChoices = new ArrayList<>();
            for (int i = 0; i < objectMap.size(); i++) {
                ZjkChoice choice = new ZjkChoice();
                MyBeanUtils.transMap2Bean((Map<String, Object>) objectMap.get(i),choice);
                zjkChoices.add(choice);
            }
            Map<String,Object> map = zjkChoices.stream().collect(Collectors.toMap(ZjkChoice::getXmId,ZjkChoice::getZjId,(entity1, entity2) -> entity1));
            for (int i = 0; i < j; i++) {
                if (!StrUtil.isNullEmpty(map.get(pageInfo.getList().get(i).getDataId()))){
                    pageInfo.getList().get(i).setDefine4("1");
                }
            }
        }

        LayuiTableData data = new LayuiTableData();
        data.setData(pageInfo.getList());
        Long total = pageInfo.getTotal();
        data.setCount(total.intValue());
        return data;
    }

    @Autowired
    ZjkBaseInfoServiceClient zjkBaseInfoServiceClient;

	@Override
	public Integer addReward(OutReward outReward) {
		OutReward newoOutReward = (OutReward) MyBeanUtils.createBean(OutReward.class);
		MyBeanUtils.copyPropertiesIgnoreNull(outReward, newoOutReward);
		return outRewardMapper.insert(newoOutReward);
	}

	@Override
	public Integer updateReward(OutReward outReward) {
		OutReward newoOutReward = (OutReward) MyBeanUtils.createBean(OutReward.class);
		MyBeanUtils.copyPropertiesIgnoreNull(outReward, newoOutReward);
		return outRewardMapper.updateByPrimaryKey(newoOutReward);
	}

	@Override
	public Integer delOutRewardById(String dataId) {
		return outRewardMapper.deleteByPrimaryKey(dataId);
	}
}
