package com.pcitc.service.expert;

import com.pcitc.base.common.LayuiTableData;
import com.github.pagehelper.PageInfo;
import com.pcitc.base.common.enums.DataOperationStatusEnum;
import com.pcitc.base.common.LayuiTableParam;
import com.pcitc.base.common.TreeNode;
import com.pcitc.base.expert.ZjkExtractConfig;
import com.pcitc.base.expert.ZjkExtractConfigExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * <p>接口类</p>
 * <p>Table: zjk_extract_config - 专家抽取逻辑配置</p>
 *
 * @since 2019-01-29 04:04:35
 */
public interface ZjkExtractConfigService {

    /**
     * 判空-信息
     *
     * @param record
     * @return
     * @throws Exception
     */
    List<ZjkExtractConfig> findZjkExtractConfigList(ZjkExtractConfig record) throws Exception;

    /**
     * 删除
     *
     * @param record
     * @return
     * @throws Exception
     */
    int updateOrInsertZjkExtractConfig(ZjkExtractConfig record) throws Exception;

    /**
     * 根据id删除
     *
     * @param id
     * @return
     * @throws Exception
     */
    int deleteZjkExtractConfigById(String id) throws Exception;

    /**
     * 根据id查询对象
     *
     * @param id
     * @return
     * @throws Exception
     */
    ZjkExtractConfig getZjkExtractConfigInfo(String id) throws Exception;

    /**
     * 查询总条数
     *
     * @param example
     * @return
     */
    long countByExample(ZjkExtractConfigExample example);

    /**
     * 根据example条件删除
     *
     * @param example
     * @return
     */
    int deleteByExample(ZjkExtractConfigExample example);

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
    int insert(ZjkExtractConfig record);

    /**
     * 插入信息,返回对象
     *
     * @param record
     * @return
     */
    ZjkExtractConfig insertObject(ZjkExtractConfig record);

    /**
     * 判空-插入信息
     *
     * @param record
     * @return
     */
    int insertSelective(ZjkExtractConfig record);

    /**
     * 根据example条件查询
     *
     * @param example
     * @return
     */
    List<ZjkExtractConfig> selectByExample(ZjkExtractConfigExample example);

    /**
     * 根据主键查询
     *
     * @param id
     * @return
     */
    ZjkExtractConfig selectByPrimaryKey(String id);

    /**
     * 根据example条件-判空更新
     *
     * @param record
     * @param example
     * @return
     */
    int updateByExampleSelective(@Param("record") ZjkExtractConfig record, @Param("example") ZjkExtractConfigExample example);

    /**
     * 根据example条件,更新所有
     *
     * @param record
     * @param example
     * @return
     */
    int updateByExample(@Param("record") ZjkExtractConfig record, @Param("example") ZjkExtractConfigExample example);

    /**
     * 根据主键判空-更新
     *
     * @param record
     * @return
     */
    int updateByPrimaryKeySelective(ZjkExtractConfig record);

    /**
     * 根据主键更新所有
     *
     * @param record
     * @return
     */
    int updateByPrimaryKey(ZjkExtractConfig record);

    /**
     * 删除菜单
     *
     * @param id
     * @return
     */
    Integer deleteZjkExtractConfig(java.io.Serializable id);

    /**
     * @param param 分页查询
     * @return
     */
    LayuiTableData findZjkExtractConfigByPage(LayuiTableParam param);

    /**
     * 真删除
     *
     * @param id
     * @return
     */
    Integer deleteZjkExtractConfigReal(String id);

    /**
     * 查询树
     *
     * @return
     */
    List<TreeNode> selectObjectByTree();
}