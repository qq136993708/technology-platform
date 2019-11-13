package com.pcitc.mapper.system;

import com.pcitc.base.system.EmailTemplate;
import com.pcitc.base.system.EmailTemplateExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface EmailTemplateMapper {
    long countByExample(EmailTemplateExample example);

    int deleteByExample(EmailTemplateExample example);

    int deleteByPrimaryKey(String menuId);

    int insert(EmailTemplate record);

    int insertSelective(EmailTemplate record);

    List<EmailTemplate> selectByExample(EmailTemplateExample example);

    EmailTemplate selectByPrimaryKey(String menuId);

    int updateByExampleSelective(@Param("record") EmailTemplate record, @Param("example") EmailTemplateExample example);

    int updateByExample(@Param("record") EmailTemplate record, @Param("example") EmailTemplateExample example);

    int updateByPrimaryKeySelective(EmailTemplate record);

    int updateByPrimaryKey(EmailTemplate record);

    int updateByPrimaryKeyWithBLOBs(EmailTemplate record);

    List<EmailTemplate> findEmailTemplateByPage(Map<String, Object> map);

    List<EmailTemplate> findEmailTemplateList(EmailTemplate record);

}