package com.pcitc.service.out.impl;

import java.util.List;

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
import com.pcitc.base.stp.out.OutAppraisal;
import com.pcitc.base.stp.out.OutAppraisalExample;
import com.pcitc.base.stp.out.OutProjectInfo;
import com.pcitc.base.stp.out.OutProjectInfoExample;
import com.pcitc.base.stp.out.OutWaitWork;
import com.pcitc.base.stp.out.OutWaitWorkExample;
import com.pcitc.base.util.DateUtil;
import com.pcitc.mapper.out.OutAppraisalMapper;
import com.pcitc.mapper.out.OutProjectInfoMapper;
import com.pcitc.mapper.out.OutWaitWorkMapper;
import com.pcitc.service.out.OutWaitWorkService;
import com.pcitc.utils.StringUtils;

@Service("outWaitWorkService")
@Transactional(propagation = Propagation.REQUIRED, readOnly = false, rollbackFor = Exception.class)
public class OutWaitWorkServiceImpl implements OutWaitWorkService {

	@Autowired
	private OutWaitWorkMapper outWaitWorkMapper;

	@Autowired
	private OutProjectInfoMapper outProjectInfoMapper;

	@Autowired
	private OutAppraisalMapper outAppraisalMapper;

	private final static Logger logger = LoggerFactory.getLogger(OutWaitWorkServiceImpl.class);

	public LayuiTableData getOutWaitWorkPage(LayuiTableParam param) throws Exception {

		PageHelper.startPage(param.getPage(), param.getLimit());

		String title = (String) param.getParam().get("title");

		OutWaitWorkExample example = new OutWaitWorkExample();
		OutWaitWorkExample.Criteria criteria = example.createCriteria();

		if (param.getParam().get("userCode") != null && !StringUtils.isBlank(param.getParam().get("userCode") + "")) {
			criteria.andUserIdEqualTo(param.getParam().get("userCode").toString());
		}
		example.setOrderByClause(" wait_time desc ");

		List<OutWaitWork> list = outWaitWorkMapper.selectByExample(example);

		for (int i = 0; i < list.size(); i++) {
			OutWaitWork oww = list.get(i);
			if (oww.getWaitTime() != null)
				oww.setShowDate(DateUtil.dateToStr(oww.getWaitTime(), DateUtil.FMT_SS));
		}
		PageInfo<OutWaitWork> pageInfo = new PageInfo<OutWaitWork>(list);
		System.out.println(">>>>>>>>>查询分页结果" + pageInfo.getList().size());

		LayuiTableData data = new LayuiTableData();
		data.setData(pageInfo.getList());
		Long total = pageInfo.getTotal();
		data.setCount(total.intValue());
		return data;
	}

	public List getOutWaitWorkList(OutWaitWork outWaitWork) throws Exception {

		OutWaitWorkExample example = new OutWaitWorkExample();
		OutWaitWorkExample.Criteria criteria = example.createCriteria();
		example.setOrderByClause(" create_date desc ");
		List<OutWaitWork> list = outWaitWorkMapper.selectByExample(example);
		return list;
	}

	public OutWaitWork selectOutWaitWork(Long id) throws Exception {
		return outWaitWorkMapper.selectByPrimaryKey(id);
	}

	public Integer updateOutWaitWork(OutWaitWork record) throws Exception {
		return outWaitWorkMapper.updateByPrimaryKey(record);
	}

	public int deleteOutWaitWork(Long id) throws Exception {
		return outWaitWorkMapper.deleteByPrimaryKey(id);
	}

	public Integer insertOutWaitWork(OutWaitWork record) throws Exception {
		return outWaitWorkMapper.insert(record);
	}

	public Integer insertOutWaitWorkBatch(List<OutWaitWork> workList) {

		return outWaitWorkMapper.insertOutWaitWorkBatch(workList);
	}

	public int deleteOutWaitWorkByType(String type) throws Exception {
		OutWaitWorkExample example = new OutWaitWorkExample();
		example.createCriteria().andTypeEqualTo(type);
		return outWaitWorkMapper.deleteByExample(example);
	}

	public int insertProjectData(List<OutProjectInfo> list, String nd) {
		// 把年度数据复制到临时表中备份
		// outProjectInfoMapper.copyData(nd);

		// 删除年度数据
		OutProjectInfoExample example = new OutProjectInfoExample();
		example.createCriteria().andNdEqualTo(nd);
		outProjectInfoMapper.deleteByExample(example);

		// 批量插入数据
		outProjectInfoMapper.insertOutProjectBatch(list);
		return 1;
	}

	public int insertAppraisalData(List<OutAppraisal> list, String nd) {
		// 删除年度数据
		OutAppraisalExample example = new OutAppraisalExample();
		outAppraisalMapper.deleteByExample(example);

		// 批量插入数据
		outAppraisalMapper.insertOutAppraisalBatch(list);
		return 1;
	}

}
