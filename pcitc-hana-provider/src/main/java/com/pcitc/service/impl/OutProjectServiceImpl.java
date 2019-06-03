package com.pcitc.service.impl;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.pcitc.mapper.out.OutProjectMapper;
import com.pcitc.service.IOutProjectService;
@Service("outProjectService")
@Transactional(propagation = Propagation.REQUIRED, readOnly = false, rollbackFor = Exception.class)
public class OutProjectServiceImpl implements IOutProjectService{
	
    @Autowired
    private OutProjectMapper outProjectMapper;
    
    /**
     * 获取国家项目的数据
     */
	public List getCountryProjectList(HashMap<String, String> map) {
		return outProjectMapper.getCountryProjectList(map);
	}
	
	/**
     * 获取hana中报销费用挂账清账信息
     */
	public List getExpensesPayInfo(HashMap<String, String> map) {
		return outProjectMapper.getExpensesPayInfo(map);
	}
    
    
  	
}
