package com.pcitc.service.techFamily.impl;

import java.util.HashMap;
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
import com.pcitc.base.common.TreeNode;
import com.pcitc.base.stp.techFamily.TechFamily;
import com.pcitc.base.stp.techFamily.TechFamilyExample;
import com.pcitc.base.stp.techFamily.TechFamilyExample.Criteria;
import com.pcitc.mapper.techFamily.TechFamilyMapper;
import com.pcitc.service.techFamily.TechFamilyService;
@Service("techFamilyService")
@Transactional(propagation = Propagation.REQUIRED, readOnly = false, rollbackFor = Exception.class)
public class TechFamilyServiceImpl implements TechFamilyService {

	@Autowired
	private TechFamilyMapper techFamilyMapper;
	
	
	/**
	 * @param techType
	 * @return
	 * @throws Exception
	 */
	public List<TechFamily> selectTechFamilyTypeList(TechFamily techType) {
		
		TechFamilyExample techFamilyExample = new TechFamilyExample();
		Criteria cri = techFamilyExample.createCriteria();
		if (techType.getTfmTypeId() != null) {
			cri.andTfmTypeIdEqualTo(techType.getTfmTypeId());
		}
		if (techType.getParentId() != null) {
			cri.andParentIdEqualTo(techType.getParentId());
		}
		if (techType.getStatus() != null) {
			cri.andStatusEqualTo(techType.getStatus());
		}
		List<TechFamily> list = techFamilyMapper.selectByExample(techFamilyExample);
		
		return list;
	}

	/**
	 * 根据层级显示树
	 * @param dictionary
	 * @return
	 * @throws Exception
	 */
	public List<TreeNode> selectTreeNodeByLevel(TechFamily techType) {
		return techFamilyMapper.selectTreeNodeByLevel(techType);
	}
	
	/**
	 * 根据层级显示树
	 * @param dictionary
	 * @return
	 * @throws Exception
	 */
	public List<TreeNode> selectTreeNodeByLevelCond(TechFamily techType) {
		return techFamilyMapper.selectTreeNodeByLevelCond(techType);
	}
	
	/**
	 * 查询技术族分类列表
	 * @param param
	 * @return
	 * @throws Exception
	 */
	public LayuiTableData getTechTypeList(LayuiTableParam param) {
		Map<String,Object> paraMap = param.getParam();
		
		TechFamilyExample techFamilyExample = new TechFamilyExample();
		Criteria cri = techFamilyExample.createCriteria();
		if (paraMap.get("status") != null && !paraMap.get("status").equals("")) {
			cri.andStatusEqualTo(paraMap.get("status").toString());
		}
		System.out.println("1========================"+paraMap.get("typeCode"));
		System.out.println("2========================"+paraMap.get("typeName"));
		if (paraMap.get("typeCode") != null && !paraMap.get("typeCode").equals("")) {
			cri.andTypeIndexLike("%@"+paraMap.get("typeCode").toString()+"@%");
			cri.andTypeCodeNotEqualTo(paraMap.get("typeCode").toString());
		}
		if (paraMap.get("typeName") != null && !paraMap.get("typeName").equals("")) {
			cri.andTypeNameLike("%"+paraMap.get("typeName").toString()+"%");
		}
		techFamilyExample.setOrderByClause(" type_code asc ");
		
		return this.findByExample(param, techFamilyExample);
	}
	
	/**
	 *  根据条件分页搜索
	 * @param param
	 * @param example
	 * @return
	 */
	private LayuiTableData findByExample(LayuiTableParam param, TechFamilyExample example) {
		//每页显示条数
		int pageSize = param.getLimit();
		//从第多少条开始
		int pageStart = (param.getPage()-1)*pageSize;
		//当前是第几页
		int pageNum = pageStart/pageSize + 1;
		// 1、设置分页信息，包括当前页数和每页显示的总计数
		PageHelper.startPage(pageNum, pageSize);
		
		List<TechFamily> list = techFamilyMapper.selectByExample(example);
		// 3、获取分页查询后的数据
		PageInfo<TechFamily> pageInfo = new PageInfo<TechFamily>(list);
		LayuiTableData data = new LayuiTableData();
		data.setData(pageInfo.getList());
		Long total = pageInfo.getTotal();
		data.setCount(total.intValue());
		return data;
	}
	
	
	public int saveTechFamilyType(TechFamily techType) {
		return techFamilyMapper.insert(techType);
	}
	
	public int updateTechFamilyType(TechFamily techType) {
		return techFamilyMapper.updateByPrimaryKey(techType);
	}
	
	/**
	 * 暂时逻辑删除
	 * @param techType
	 * @return
	 */
	public int deleteTechFamilyType(TechFamily techType) {
		return techFamilyMapper.updateTechTypeCondition(techType);
	}
	
	/**
	 * 查询最大的分类编码
	 * @param map
	 * @return
	 */
	public String getMaxTechTypeCode(HashMap<String, String> map) {
		return techFamilyMapper.getMaxTechTypeCode(map);
	}
}
