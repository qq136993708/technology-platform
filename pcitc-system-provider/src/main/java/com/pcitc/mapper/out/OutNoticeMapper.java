package com.pcitc.mapper.out;

import com.pcitc.base.stp.out.OutNotice;
import com.pcitc.base.stp.out.OutNoticeExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface OutNoticeMapper {
    long countByExample(OutNoticeExample example);

    int deleteByExample(OutNoticeExample example);

    int deleteByPrimaryKey(String dataId);

    int insert(OutNotice record);

    int insertSelective(OutNotice record);

    List<OutNotice> selectByExampleWithBLOBs(OutNoticeExample example);

    List<OutNotice> selectByExample(OutNoticeExample example);

    OutNotice selectByPrimaryKey(String dataId);

    int updateByExampleSelective(@Param("record") OutNotice record, @Param("example") OutNoticeExample example);

    int updateByExampleWithBLOBs(@Param("record") OutNotice record, @Param("example") OutNoticeExample example);

    int updateByExample(@Param("record") OutNotice record, @Param("example") OutNoticeExample example);

    int updateByPrimaryKeySelective(OutNotice record);

    int updateByPrimaryKeyWithBLOBs(OutNotice record);

    int updateByPrimaryKey(OutNotice record);
}