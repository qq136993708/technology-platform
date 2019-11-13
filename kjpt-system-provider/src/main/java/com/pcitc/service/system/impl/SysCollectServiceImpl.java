package com.pcitc.service.system.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.pcitc.base.system.SysCollect;
import com.pcitc.base.system.SysCollectExample;
import com.pcitc.base.system.SysCollectExample.Criteria;
import com.pcitc.mapper.system.SysCollectMapper;
import com.pcitc.service.system.SysCollectService;

/**
 * @author zhf
 * 2018-10-11
 * 菜单收藏
 */
@Service("sysCollect")
@Transactional(propagation = Propagation.REQUIRED, readOnly = false, rollbackFor = Exception.class)
public class SysCollectServiceImpl implements SysCollectService {

	@Autowired
	private SysCollectMapper sysCollectMapper;
	
	/**
	 * @param sysCollect
	 * @return
	 * 插入收藏，判断是否已经插入，已存在更新日期
	 */
	public int insertSysCollect(SysCollect sysCollect) {
		return sysCollectMapper.insert(sysCollect);
	}
	
	public List<SysCollect> getSysCollectByCond(String functionId, String userId) {
		SysCollectExample sysCollectExample = new SysCollectExample();
		Criteria cri = sysCollectExample.createCriteria();
		cri.andFunctionIdEqualTo(functionId);
		cri.andUserIdEqualTo(userId);
		cri.andStatusEqualTo("1");
		return sysCollectMapper.selectByExample(sysCollectExample);
	}
	
	public int updateSysCollect(SysCollect sysCollect) {
		return sysCollectMapper.updateByPrimaryKey(sysCollect);
	}
	
	public List<SysCollect> getSysCollectByUser(String userId) {
		SysCollectExample sysCollectExample = new SysCollectExample();
		Criteria cri = sysCollectExample.createCriteria();
		cri.andUserIdEqualTo(userId);
		return sysCollectMapper.selectByExample(sysCollectExample);
	}
}