package com.pcitc.mapper.expert;

import com.pcitc.base.expert.ZjkProjectExpert;
import com.pcitc.base.expert.ZjkProjectExpertExample;
import java.util.List;
import java.util.Map;
import org.apache.ibatis.annotations.Param;

public interface ZjkProjectExpertMapper {
long countByExample(ZjkProjectExpertExample example);

int deleteByExample(ZjkProjectExpertExample example);

int deleteByPrimaryKey(String menuId);

int insert(ZjkProjectExpert record);

int insertSelective(ZjkProjectExpert record);

List<ZjkProjectExpert> selectByExample(ZjkProjectExpertExample example);

    ZjkProjectExpert selectByPrimaryKey(String menuId);

    int updateByExampleSelective(@Param("record") ZjkProjectExpert record, @Param("example") ZjkProjectExpertExample example);

    int updateByExample(@Param("record") ZjkProjectExpert record, @Param("example") ZjkProjectExpertExample example);

    int updateByPrimaryKeySelective(ZjkProjectExpert record);

    int updateByPrimaryKey(ZjkProjectExpert record);

    int updateByPrimaryKeyWithBLOBs(ZjkProjectExpert record);

    List<ZjkProjectExpert> findZjkProjectExpertByPage(Map<String,Object> map);

    List<ZjkProjectExpert> findZjkProjectExpertList( ZjkProjectExpert record);

    }