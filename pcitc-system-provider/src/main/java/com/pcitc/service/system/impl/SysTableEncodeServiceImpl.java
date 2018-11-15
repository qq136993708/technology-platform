package com.pcitc.service.system.impl;

import java.util.Date;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.pcitc.base.common.LayuiTableData;
import com.pcitc.base.common.LayuiTableParam;
import com.pcitc.base.system.SysTableEncode;
import com.pcitc.base.util.DateUtil;
import com.pcitc.mapper.system.SysTableEncodeMapper;
import com.pcitc.service.system.SysTableEncodeService;

@Service
public class SysTableEncodeServiceImpl implements SysTableEncodeService{
	
	
	@Autowired
	private SysTableEncodeMapper sysTableEncodeMapper;

	
	@Override
	public int saveTableEncode(SysTableEncode sysTableEncode) {
		int result = 500;
		try {
			String dataId = UUID.randomUUID().toString().replace("-", "");
			sysTableEncode.setDataId(dataId);
			sysTableEncode.setStatus("0");
			sysTableEncode.setCreateDate(DateUtil.dateToStr(new Date(), DateUtil.FMT_SS));
			sysTableEncode.setDataCode(sysTableEncode.getTableEncodeAnnotation());
			sysTableEncode.setSysFlag("SYSTEM");
			sysTableEncodeMapper.insert(sysTableEncode);
			result = 200;
		} catch (Exception e) {
			result = 500;
		}
		return result;
	}


	@Override
	public SysTableEncode findSysTableEncodeById(String id) {
		return sysTableEncodeMapper.selectByPrimaryKey(id);
	}


	@Override
	public void updateSysTableEncode(SysTableEncode steVO) {
		sysTableEncodeMapper.updateByPrimaryKey(steVO);
	}


	@Override
	public int deleteTableEncode(String id) {
		int result = 500;
		try {
			SysTableEncode ste = sysTableEncodeMapper.selectByPrimaryKey(id);
			ste.setStatus("1");
			ste.setUpdateDate(DateUtil.dateToStr(new Date(), DateUtil.FMT_SS));
			sysTableEncodeMapper.updateByPrimaryKeySelective(ste);
			result = 200;
		} catch (Exception e) {
			result = 500;
		}
		return result;
	}


	@Override
	public int modifyTableEncode(String id) {
		int result = 500;
		try {
			SysTableEncode ste = sysTableEncodeMapper.selectByPrimaryKey(id);
			if("0".equals(ste.getTableEncodeValid())){
				ste.setTableEncodeValid("1");
			}else{
				ste.setTableEncodeValid("0");
			}
			sysTableEncodeMapper.updateByPrimaryKey(ste);
			result = 200;
		} catch (Exception e) {
			result = 500;
		}
		return result;
	}


	@Override
	public LayuiTableData querySysTableEncodeListByPage(LayuiTableParam param) {
		//每页显示条数
		int pageSize = param.getLimit();
		//从第多少条开始
		int pageStart = (param.getPage()-1)*pageSize;
		//当前是第几页
		int pageNum = pageStart/pageSize + 1;
		// 1、设置分页信息，包括当前页数和每页显示的总计数
		PageHelper.startPage(pageNum, pageSize);
		//设置查询条件
		SysTableEncode vo = new SysTableEncode();
		String functionId = (String) param.getParam().get("functionId");
		if(functionId != null && !"".equals(functionId)) {
			vo.setTableEncodeProjectId(functionId);
		}
		// 2、执行查询
		List<SysTableEncode> list = sysTableEncodeMapper.querySysTableEncodeListByPage(vo);
		int total = sysTableEncodeMapper.countBySysTableEncode(vo).intValue();
		PageInfo<SysTableEncode> pageInfo= new PageInfo<SysTableEncode>(list);
		LayuiTableData data = new LayuiTableData();
		data.setData(pageInfo.getList());
		data.setCount(total);
		return data;
	}


	@Override
	public List<SysTableEncode> findTableEncodeList(String str) {
		SysTableEncode vo = new SysTableEncode();
		vo.setTableEncodeAnnotation(str);
		List<SysTableEncode> list = sysTableEncodeMapper.querySysTableEncodeListByPage(vo);
		return list;
	}

}
