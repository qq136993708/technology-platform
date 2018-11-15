package com.pcitc.service.system.impl;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.pcitc.base.common.LayuiTableData;
import com.pcitc.base.common.LayuiTableParam;
import com.pcitc.base.common.TreeNode;
import com.pcitc.base.system.SysDictionary;
import com.pcitc.base.util.HanyuPinyinHelper;
import com.pcitc.base.util.StrUtil;
import com.pcitc.mapper.system.SysDictionaryMapper;
import com.pcitc.service.system.SysDictionaryService;

@Service
public class SysDictionaryServiceImpl implements SysDictionaryService{
	
	@Autowired
	private SysDictionaryMapper dictionaryDao;
	
	
	@Override
	public List<TreeNode> selectTreeNodeOneLevel() throws Exception {
		
		return dictionaryDao.selectTreeNodeOneLevel();
	}
	
	@Override
	public List<TreeNode> selectChildNodeByParentId(String parentId) throws Exception {
		
		return dictionaryDao.selectChildNodeByParentId(parentId);
	}

	@Transactional
	@Override
	public int updateOrInsertDictionary(SysDictionary dictionary) throws Exception {
		int result = 500;
		int sameCount =0;
		if(dictionary.getId()!=null && dictionary.getId()!=""){
			//若同一级有相同字典返回201；
			sameCount = dictionaryDao.selectSameName(dictionary.getParentId(),dictionary.getName(),dictionary.getId());
			if(sameCount > 0){
				return 201;//(有相同名字菜单)
			}
			dictionary.setUpdateTime(new Date());
			dictionaryDao.updateByPrimaryKeySelective(dictionary);
		}else{
			String id = UUID.randomUUID().toString().replace("-", "");
			dictionary.setId(id);
			dictionary.setCreateTime(new Date());
			dictionary.setLevelCode(Integer.valueOf(dictionary.getLevelCode())+1);
			
			//若同一级有相同字典返回201；
			sameCount = dictionaryDao.selectSameName(dictionary.getParentId(),dictionary.getName(),null);
			if(sameCount > 0){
				return 201;//(有相同名字菜单)
			}
			//生成code;
			if(StrUtil.isBlank(dictionary.getCode())){
			    SysDictionary parent = dictionaryDao.getDictionaryById(dictionary.getParentId());
			    if(parent!=null){
			    	String code = HanyuPinyinHelper.toPinyin(dictionary.getParentCode())+"_"+HanyuPinyinHelper.toPinyin(dictionary.getName());
			    	dictionary.setCode(code);
			    }
			}
			
			dictionaryDao.insertSelective(dictionary);
			dictionaryDao.updateNodeIsParent(dictionary.getParentId());
		}
		result = 200;
		return result;
	}

	
	@Override
	public int deleteDictionary(String id) throws Exception {
		int result = 500;
		int count = dictionaryDao.getCountByParentId(id);
		if(id!=null && id!=""){
			if(count >0 ){
				return 101;
			}
			dictionaryDao.deleteByPrimaryKey(id);
		}
		result = 200;
		return result;
	}

	@Override
	public List<TreeNode> selectTreeNodeByLevel(SysDictionary dictionary) throws Exception {
		
		return dictionaryDao.selectTreeNodeByLevel(dictionary);
	}

	@Override
	public LayuiTableData selectDictionaryList(LayuiTableParam param) throws Exception {
		List<SysDictionary> list = null;
		
		//每页显示条数
		int pageSize = param.getLimit();
		//从第多少条开始
		int pageStart = (param.getPage()-1)*pageSize;
		//当前是第几页
		int pageNum = pageStart/pageSize + 1;
		// 1、设置分页信息，包括当前页数和每页显示的总计数
		PageHelper.startPage(pageNum, pageSize);

		// 2、执行查询
	    SysDictionary record = new SysDictionary();
	    
/*	    record.setiSortCol(info.getiSortCol());
	    record.setsSortDir_0(info.getsSortDir_0());*/
	  //选中的树节点（叶子节点）
  		String parentId = (String) param.getParam().get("parentId");
  		String parentCode = (String) param.getParam().get("parentCode");
  		record.setParentCode(parentCode);
  		record.setParentId(parentId);
	    //模糊查询条件
	    record.setName((String) param.getParam().get("name"));
	    if(StrUtil.isNotBlank(parentId)){
	    	record.setParentId(parentId);
	    	list = dictionaryDao.selectDictionaryList(record);
	    }else if(StrUtil.isNotBlank(parentCode)){
	    	record.setParentCode(parentCode);
	    	list = dictionaryDao.selectDictionaryListByParentCode(record);
	    }
		
		// 3、获取分页查询后的数据
		PageInfo<SysDictionary> pageInfo= new PageInfo<SysDictionary>(list);
		LayuiTableData data = new LayuiTableData();
		data.setData(pageInfo.getList());
		Long total = pageInfo.getTotal();
		data.setCount(total.intValue());
		return data;
	}

	@Override
	public SysDictionary getDictionaryById(String id) throws Exception {
		
		return dictionaryDao.getDictionaryById(id);
	}

	@Override
	public List<SysDictionary> getDictionaryListByParentCode(String parentCode) 
	{
		SysDictionary parent = new SysDictionary();
		parent.setParentCode(parentCode);
		return dictionaryDao.selectDictionaryListByParentCode(parent);
	}

	@Override
	public String createCode(SysDictionary dictionary) throws Exception {
		String code = HanyuPinyinHelper.toPinyin(dictionary.getParentCode())+"_"+HanyuPinyinHelper.toPinyin(dictionary.getName());
		return code;
	}

	@Override
	public Map<String, List<SysDictionary>> getMapDictionaryList(List<String> parentCodes) 
	{
		Map<String,List<SysDictionary>> map = new HashMap<String,List<SysDictionary>>();
		for(String parentCode:parentCodes) 
		{
			List<SysDictionary> dis = getDictionaryListByParentCode(parentCode);
			map.put(parentCode, dis);
		}
		return map;
	}

	@Override
	public SysDictionary getDictionaryByCode(String code) throws Exception 
	{
		return dictionaryDao.getDictionaryByCode(code);
	}

	

	
	

}
