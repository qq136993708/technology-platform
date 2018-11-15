package com.pcitc.mapper.out;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.pcitc.base.stp.out.OutProjectErp;
import com.pcitc.base.stp.out.OutProjectErpExample;

public interface OutProjectErpMapper {
    int countByExample(OutProjectErpExample example);

    int deleteByExample(OutProjectErpExample example);

    int deleteByPrimaryKey(String dataId);

    int insert(OutProjectErp record);

    int insertSelective(OutProjectErp record);

    List<OutProjectErp> selectByExample(OutProjectErpExample example);

    OutProjectErp selectByPrimaryKey(String dataId);

    int updateByExampleSelective(@Param("record") OutProjectErp record, @Param("example") OutProjectErpExample example);

    int updateByExample(@Param("record") OutProjectErp record, @Param("example") OutProjectErpExample example);

    int updateByPrimaryKeySelective(OutProjectErp record);

    int updateByPrimaryKey(OutProjectErp record);
    
    public int deleteOutProjectErpBatch(Map map);
    
    public int insertOutProjectErpBatch(List<OutProjectErp> list);
}