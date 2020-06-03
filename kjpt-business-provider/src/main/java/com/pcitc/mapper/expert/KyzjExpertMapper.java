package com.pcitc.mapper.expert;

import com.pcitc.base.expert.KyzjExpert;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public interface KyzjExpertMapper {
	
	    int deleteByPrimaryKey(String id);

	    int insert(KyzjExpert record);

	    int insertSelective(KyzjExpert record);

		KyzjExpert selectByPrimaryKey(String id);

	    int updateByPrimaryKeySelective(KyzjExpert record);

	    int updateByPrimaryKey(KyzjExpert record);
	    
	    List getList(Map map);
	    
	    int getCount(Map map);
}