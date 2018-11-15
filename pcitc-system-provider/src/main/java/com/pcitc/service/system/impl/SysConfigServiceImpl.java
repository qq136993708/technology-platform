package com.pcitc.service.system.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.pcitc.base.common.LayuiTableData;
import com.pcitc.base.common.LayuiTableParam;
import com.pcitc.base.system.SysConfig;
import com.pcitc.base.system.SysConfigExample;
import com.pcitc.base.system.SysModule;
import com.pcitc.base.system.SysRestfulapi;
import com.pcitc.base.system.SysConfigExample.Criteria;
import com.pcitc.mapper.system.SysConfigMapper;
import com.pcitc.service.system.SysConfigService;

@Service("sysConfigService")
@CacheConfig(cacheNames = "sysConfigCache")
public class SysConfigServiceImpl implements SysConfigService {

	@Autowired
	private SysConfigMapper sysConfigMapper;
	
	public LayuiTableData selectConfigByPage(LayuiTableParam param) {
		Map<String,Object> paraMap = param.getParam();
		
		SysConfigExample SysConfigExample = new SysConfigExample();
		Criteria cri = SysConfigExample.createCriteria();
		if (paraMap.get("status") != null && !paraMap.get("status").equals("")) {
			cri.andStatusEqualTo(paraMap.get("status").toString());
		}
		if (paraMap.get("config_name") != null && !paraMap.get("config_name").equals("")) {
			cri.andConfigNameLike("%" + paraMap.get("config_name").toString()  + "%");
		}
		if (paraMap.get("create_user_id") != null && !paraMap.get("create_user_id").equals("")) {
			cri.andCreateUserIdEqualTo(paraMap.get("create_user_id").toString());
		}
		if (paraMap.get("config_code") != null && !paraMap.get("config_code").equals("")) {
			cri.andConfigValueEqualTo(paraMap.get("config_code").toString());
		}
		SysConfigExample.setOrderByClause(" create_date desc ");
		
		return this.findByExample(param, SysConfigExample);
	}
	
	/**
	 *  根据条件分页搜索
	 * @param param
	 * @param example
	 * @return
	 */
	private LayuiTableData findByExample(LayuiTableParam param, SysConfigExample example) {
		//每页显示条数
		int pageSize = param.getLimit();
		//从第多少条开始
		int pageStart = (param.getPage()-1)*pageSize;
		//当前是第几页
		int pageNum = pageStart/pageSize + 1;
		// 1、设置分页信息，包括当前页数和每页显示的总计数
		PageHelper.startPage(pageNum, pageSize);
		
		List<SysConfig> list = sysConfigMapper.selectByExample(example);
		// 3、获取分页查询后的数据
		PageInfo<SysConfig> pageInfo = new PageInfo<SysConfig>(list);
		LayuiTableData data = new LayuiTableData();
		data.setData(pageInfo.getList());
		Long total = pageInfo.getTotal();
		data.setCount(total.intValue());
		return data;
	}
	
	@Override
	public Integer insertSysConfig(SysConfig sysconfig) {
		return sysConfigMapper.insert(sysconfig);
	}
	
	@Override
	public SysConfig getSysConfigById(String configId) {
		return sysConfigMapper.selectByPrimaryKey(configId);
	}
	
	@Override
	public Integer updateSysConfig(SysConfig sysconfig) {
		return sysConfigMapper.updateByPrimaryKey(sysconfig);
	}
	
	//直接删除
	/*@Override
	public Integer deleteSysConfigById(String configId) {
		return sysConfigMapper.deleteByPrimaryKey(configId);
	}*/
	
	//改变状态
	@Override
	public Integer deleteSysConfig(SysConfig sysconfig){
		SysConfig oldSysConfig = sysConfigMapper.selectByPrimaryKey(sysconfig.getConfigId());
		oldSysConfig.setStatus("0");
		int rInt = sysConfigMapper.updateByPrimaryKey(oldSysConfig);
		System.out.println("--------------------------------状态 : " + oldSysConfig.getStatus());
		return rInt;
	}
}
