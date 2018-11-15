package com.pcitc.mapper.equipment;

import com.pcitc.base.stp.equipment.SreSoftwareAccept;
import com.pcitc.base.stp.equipment.SreSoftwareAcceptExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SreSoftwareAcceptMapper {
    int countByExample(SreSoftwareAcceptExample example);

    int deleteByExample(SreSoftwareAcceptExample example);

    int deleteByPrimaryKey(String softwareId);

    int insert(SreSoftwareAccept record);

    int insertSelective(SreSoftwareAccept record);

    List<SreSoftwareAccept> selectByExample(SreSoftwareAcceptExample example);

    SreSoftwareAccept selectByPrimaryKey(String softwareId);

    int updateByExampleSelective(@Param("record") SreSoftwareAccept record, @Param("example") SreSoftwareAcceptExample example);

    int updateByExample(@Param("record") SreSoftwareAccept record, @Param("example") SreSoftwareAcceptExample example);

    int updateByPrimaryKeySelective(SreSoftwareAccept record);

    int updateByPrimaryKey(SreSoftwareAccept record);
}