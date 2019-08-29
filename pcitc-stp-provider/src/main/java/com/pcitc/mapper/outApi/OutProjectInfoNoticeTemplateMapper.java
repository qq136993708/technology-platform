package com.pcitc.mapper.outApi;

import com.pcitc.base.stp.out.OutProjectInfoNoticeTemplate;
import com.pcitc.base.stp.out.OutProjectInfoNoticeTemplateExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface OutProjectInfoNoticeTemplateMapper {
    long countByExample(OutProjectInfoNoticeTemplateExample example);

    int deleteByExample(OutProjectInfoNoticeTemplateExample example);

    int deleteByPrimaryKey(String dataId);

    int insert(OutProjectInfoNoticeTemplate record);

    int insertSelective(OutProjectInfoNoticeTemplate record);

    List<OutProjectInfoNoticeTemplate> selectByExample(OutProjectInfoNoticeTemplateExample example);

    OutProjectInfoNoticeTemplate selectByPrimaryKey(String dataId);

    int updateByExampleSelective(@Param("record") OutProjectInfoNoticeTemplate record, @Param("example") OutProjectInfoNoticeTemplateExample example);

    int updateByExample(@Param("record") OutProjectInfoNoticeTemplate record, @Param("example") OutProjectInfoNoticeTemplateExample example);

    int updateByPrimaryKeySelective(OutProjectInfoNoticeTemplate record);

    int updateByPrimaryKey(OutProjectInfoNoticeTemplate record);
}