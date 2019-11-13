package com.pcitc.service.out.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.pcitc.base.common.LayuiTableData;
import com.pcitc.base.common.LayuiTableParam;
import com.pcitc.base.stp.out.OutCompanyAreaInfo;
import com.pcitc.base.stp.out.OutCompanyAreaInfoExample;
import com.pcitc.mapper.out.OutCompanyAreaInfoMapper;
import com.pcitc.service.out.OutCompanyAreaService;

@Service("OutCompanyAreaService")
@Transactional(propagation = Propagation.REQUIRED, readOnly = false, rollbackFor = Exception.class)
public class OutCompanyAreaServiceImpl implements OutCompanyAreaService {

	@Autowired
	private OutCompanyAreaInfoMapper outCompanyAreaInfoMapper;

	@Override
	public LayuiTableData getCompanyListPage(LayuiTableParam param) {
		Map<String, Object> paraMap = param.getParam();

		// 1、设置分页信息，包括当前页数和每页显示的总计数
		PageHelper.startPage(param.getPage(), param.getLimit());

		OutCompanyAreaInfoExample example = new OutCompanyAreaInfoExample();
		OutCompanyAreaInfoExample.Criteria criteria = example.createCriteria();

		if (paraMap.get("unit_code") != null && !paraMap.get("unit_code").equals("")) {
			criteria.andUnitCodeLike("%" + paraMap.get("unit_code").toString() + "%");
		}
		if (paraMap.get("unit_name") != null && !paraMap.get("unit_name").equals("")) {
			criteria.andUnitNameLike("%" + paraMap.get("unit_name").toString() + "%");
		}
		example.setOrderByClause(" data_id asc ");
		List<OutCompanyAreaInfo> list = outCompanyAreaInfoMapper.selectByExample(example);
		PageInfo<OutCompanyAreaInfo> pageInfo = new PageInfo<OutCompanyAreaInfo>(list);

		LayuiTableData data = new LayuiTableData();
		data.setData(pageInfo.getList());
		Long total = pageInfo.getTotal();
		data.setCount(total.intValue());
		return data;
	}

}
