package com.pcitc.mapper.outApi;

import java.util.List;
import org.apache.ibatis.annotations.Param;

import com.pcitc.base.stp.out.OutProjectInvoices;
import com.pcitc.base.stp.out.OutProjectInvoicesExample;

public interface OutProjectInvoicesMapper {
    long countByExample(OutProjectInvoicesExample example);

    int deleteByExample(OutProjectInvoicesExample example);

    int deleteByPrimaryKey(String dataId);

    int insert(OutProjectInvoices record);

    int insertSelective(OutProjectInvoices record);

    List<OutProjectInvoices> selectByExample(OutProjectInvoicesExample example);

    OutProjectInvoices selectByPrimaryKey(String dataId);

    int updateByExampleSelective(@Param("record") OutProjectInvoices record, @Param("example") OutProjectInvoicesExample example);

    int updateByExample(@Param("record") OutProjectInvoices record, @Param("example") OutProjectInvoicesExample example);

    int updateByPrimaryKeySelective(OutProjectInvoices record);

    int updateByPrimaryKey(OutProjectInvoices record);
}