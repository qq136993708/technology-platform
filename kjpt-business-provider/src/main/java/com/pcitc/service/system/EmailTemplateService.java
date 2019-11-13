package com.pcitc.service.system;

import com.pcitc.base.common.LayuiTableData;
import com.pcitc.base.common.LayuiTableParam;
import com.pcitc.base.common.TreeNode;
import com.pcitc.base.system.EmailTemplate;
import com.pcitc.base.system.EmailTemplateExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * <p>接口类</p>
 * <p>Table: email_template - 邮件模板</p>
 *
 * @since 2019-06-05 03:42:05
 */
public interface EmailTemplateService {

    /**
     * 判空-信息
     *
     * @param record
     * @return
     * @throws Exception
     */
    List<EmailTemplate> findEmailTemplateList(EmailTemplate record) throws Exception;

    /**
     * 删除
     *
     * @param record
     * @return
     * @throws Exception
     */
    int updateOrInsertEmailTemplate(EmailTemplate record) throws Exception;

    /**
     * 根据id删除
     *
     * @param id
     * @return
     * @throws Exception
     */
    int deleteEmailTemplateById(String id) throws Exception;

    /**
     * 根据id查询对象
     *
     * @param id
     * @return
     * @throws Exception
     */
    EmailTemplate getEmailTemplateInfo(String id) throws Exception;

    /**
     * 查询总条数
     *
     * @param example
     * @return
     */
    long countByExample(EmailTemplateExample example);

    /**
     * 根据example条件删除
     *
     * @param example
     * @return
     */
    int deleteByExample(EmailTemplateExample example);

    /**
     * 根据主键删除
     *
     * @param id
     * @return
     */
    int deleteByPrimaryKey(String id);

    /**
     * 插入信息
     *
     * @param record
     * @return
     */
    int insert(EmailTemplate record);

    /**
     * 插入信息,返回对象
     *
     * @param record
     * @return
     */
    EmailTemplate insertObject(EmailTemplate record);

    /**
     * 判空-插入信息
     *
     * @param record
     * @return
     */
    int insertSelective(EmailTemplate record);

    /**
     * 根据example条件查询
     *
     * @param example
     * @return
     */
    List<EmailTemplate> selectByExample(EmailTemplateExample example);

    /**
     * 根据主键查询
     *
     * @param id
     * @return
     */
    EmailTemplate selectByPrimaryKey(String id);

    /**
     * 根据example条件-判空更新
     *
     * @param record
     * @param example
     * @return
     */
    int updateByExampleSelective(@Param("record") EmailTemplate record, @Param("example") EmailTemplateExample example);

    /**
     * 根据example条件,更新所有
     *
     * @param record
     * @param example
     * @return
     */
    int updateByExample(@Param("record") EmailTemplate record, @Param("example") EmailTemplateExample example);

    /**
     * 根据主键判空-更新
     *
     * @param record
     * @return
     */
    int updateByPrimaryKeySelective(EmailTemplate record);

    /**
     * 根据主键更新所有
     *
     * @param record
     * @return
     */
    int updateByPrimaryKey(EmailTemplate record);

    /**
     * 删除菜单
     *
     * @param id
     * @return
     */
    Integer deleteEmailTemplate(java.io.Serializable id);

    /**
     * @param param 分页查询
     * @return
     */
    LayuiTableData findEmailTemplateByPage(LayuiTableParam param);

    /**
     * 真删除
     *
     * @param id
     * @return
     */
    Integer deleteEmailTemplateReal(String id);

    /**
     * 查询树
     *
     * @return
     */
    List<TreeNode> selectObjectByTree();
}