package com.pcitc.mapper.out;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.pcitc.base.stp.out.OutUnit;
import com.pcitc.base.stp.out.OutUnitExample;

public interface OutUnitMapper {
    int countByExample(OutUnitExample example);

    int deleteByExample(OutUnitExample example);

    int deleteByPrimaryKey(String dataId);

    int insert(OutUnit record);

    int insertSelective(OutUnit record);

    List<OutUnit> selectByExample(OutUnitExample example);

    OutUnit selectByPrimaryKey(String dataId);

    int updateByExampleSelective(@Param("record") OutUnit record, @Param("example") OutUnitExample example);

    int updateByExample(@Param("record") OutUnit record, @Param("example") OutUnitExample example);

    int updateByPrimaryKeySelective(OutUnit record);

    int updateByPrimaryKey(OutUnit record);
    
    public void insertOutUnitBatch(List<OutUnit> list);
    
    /**
	 * @param list
	 * 批量修改数据
	 */
	public int updateUnitDataBatch(List<OutUnit> list);
}