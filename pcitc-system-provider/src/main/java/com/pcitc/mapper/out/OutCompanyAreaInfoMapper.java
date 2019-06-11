package com.pcitc.mapper.out;

import com.pcitc.base.stp.out.OutCompanyAreaInfo;
import com.pcitc.base.stp.out.OutCompanyAreaInfoExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface OutCompanyAreaInfoMapper {
    long countByExample(OutCompanyAreaInfoExample example);

    int deleteByExample(OutCompanyAreaInfoExample example);

    int deleteByPrimaryKey(String dataId);

    int insert(OutCompanyAreaInfo record);

    int insertSelective(OutCompanyAreaInfo record);

    List<OutCompanyAreaInfo> selectByExample(OutCompanyAreaInfoExample example);

    OutCompanyAreaInfo selectByPrimaryKey(String dataId);

    int updateByExampleSelective(@Param("record") OutCompanyAreaInfo record, @Param("example") OutCompanyAreaInfoExample example);

    int updateByExample(@Param("record") OutCompanyAreaInfo record, @Param("example") OutCompanyAreaInfoExample example);

    int updateByPrimaryKeySelective(OutCompanyAreaInfo record);

    int updateByPrimaryKey(OutCompanyAreaInfo record);
    
}