package com.pcitc.mapper.expert;

import com.pcitc.base.expert.ZjkAcademicianBase;
import com.pcitc.base.expert.ZjkBase;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public interface ZjkAcademicianBaseMapper {
	
	    int deleteByPrimaryKey(String id);

	    int insert(ZjkAcademicianBase record);

	    int insertSelective(ZjkAcademicianBase record);

	ZjkAcademicianBase selectByPrimaryKey(String id);

	    int updateByPrimaryKeySelective(ZjkAcademicianBase record);

	    int updateByPrimaryKey(ZjkAcademicianBase record);
	    
	    List getList(Map map);
	    
	    int getCount(Map map);


	ZjkAcademicianBase getZjkAcademicianBaseByNum(String num);
	    
	    List getZjkAcademicianTongjiList();
	    
	    
	    
	    
	    
}