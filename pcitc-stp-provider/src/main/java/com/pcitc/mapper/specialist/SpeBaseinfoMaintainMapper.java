package com.pcitc.mapper.specialist;

import com.pcitc.base.stp.specialist.SpeBaseinfoMaintain;
import com.pcitc.base.stp.specialist.SpeBaseinfoMaintainExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SpeBaseinfoMaintainMapper {
	int countByExample(SpeBaseinfoMaintainExample example);

    int deleteByExample(SpeBaseinfoMaintainExample example);

    int deleteByPrimaryKey(String baseId);

    int insert(SpeBaseinfoMaintain record);

    int insertSelective(SpeBaseinfoMaintain record);

    List<SpeBaseinfoMaintain> selectByExample(SpeBaseinfoMaintainExample example);

    SpeBaseinfoMaintain selectByPrimaryKey(String baseId);

    int updateByExampleSelective(@Param("record") SpeBaseinfoMaintain record, @Param("example") SpeBaseinfoMaintainExample example);

    int updateByExample(@Param("record") SpeBaseinfoMaintain record, @Param("example") SpeBaseinfoMaintainExample example);

    int updateByPrimaryKeySelective(SpeBaseinfoMaintain record);

    int updateByPrimaryKey(SpeBaseinfoMaintain record);
    
	List<SpeBaseinfoMaintain> queryBaseinfoMaintainListByPage(SpeBaseinfoMaintain tableInfo);
	
	long countByBaseinfoMaintain(SpeBaseinfoMaintain tableInfo);
}