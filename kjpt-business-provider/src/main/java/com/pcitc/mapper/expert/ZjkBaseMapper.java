package com.pcitc.mapper.expert;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.pcitc.base.expert.ZjkBase;

@Repository
public interface ZjkBaseMapper  {
	
	 int deleteByPrimaryKey(String id);

	    int insert(ZjkBase record);

	    int insertSelective(ZjkBase record);

	    ZjkBase selectByPrimaryKey(String id);

	    int updateByPrimaryKeySelective(ZjkBase record);

	    int updateByPrimaryKey(ZjkBase record);
	    
	    List getList(Map map);
	    int getCount(Map map);
}