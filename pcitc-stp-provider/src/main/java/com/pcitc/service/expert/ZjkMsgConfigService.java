package com.pcitc.service.expert;

import com.pcitc.base.common.LayuiTableData;
import com.github.pagehelper.PageInfo;
import com.pcitc.base.common.enums.DataOperationStatusEnum;
import com.pcitc.base.common.LayuiTableParam;
import com.pcitc.base.common.TreeNode;
import com.pcitc.base.expert.ZjkMsgConfig;
import com.pcitc.base.expert.ZjkMsgConfigExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * <p>接口类</p>
 * <p>Table: zjk_msg_config - 专家回复消息配置表</p>
 *
 * @since 2019-02-25 03:04:53
 */
public interface ZjkMsgConfigService {

    /**
     * 判空-信息
     *
     * @param record
     * @return
     * @throws Exception
     */
    List<ZjkMsgConfig> findZjkMsgConfigList(ZjkMsgConfig record) throws Exception;

    /**
     * 删除
     *
     * @param record
     * @return
     * @throws Exception
     */
    int updateOrInsertZjkMsgConfig(ZjkMsgConfig record) throws Exception;

    /**
     * 根据id删除
     *
     * @param id
     * @return
     * @throws Exception
     */
    int deleteZjkMsgConfigById(String id) throws Exception;

    /**
     * 根据id查询对象
     *
     * @param id
     * @return
     * @throws Exception
     */
    ZjkMsgConfig getZjkMsgConfigInfo(String id) throws Exception;

    /**
     * 查询总条数
     *
     * @param example
     * @return
     */
    long countByExample(ZjkMsgConfigExample example);

    /**
     * 根据example条件删除
     *
     * @param example
     * @return
     */
    int deleteByExample(ZjkMsgConfigExample example);

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
    int insert(ZjkMsgConfig record);

    /**
     * 插入信息,返回对象
     *
     * @param record
     * @return
     */
    ZjkMsgConfig insertObject(ZjkMsgConfig record);

    /**
     * 判空-插入信息
     *
     * @param record
     * @return
     */
    int insertSelective(ZjkMsgConfig record);

    /**
     * 根据example条件查询
     *
     * @param example
     * @return
     */
    List<ZjkMsgConfig> selectByExample(ZjkMsgConfigExample example);

    /**
     * 根据主键查询
     *
     * @param id
     * @return
     */
    ZjkMsgConfig selectByPrimaryKey(String id);

    /**
     * 根据example条件-判空更新
     *
     * @param record
     * @param example
     * @return
     */
    int updateByExampleSelective(@Param("record") ZjkMsgConfig record, @Param("example") ZjkMsgConfigExample example);

    /**
     * 根据example条件,更新所有
     *
     * @param record
     * @param example
     * @return
     */
    int updateByExample(@Param("record") ZjkMsgConfig record, @Param("example") ZjkMsgConfigExample example);

    /**
     * 根据主键判空-更新
     *
     * @param record
     * @return
     */
    int updateByPrimaryKeySelective(ZjkMsgConfig record);

    /**
     * 根据主键更新所有
     *
     * @param record
     * @return
     */
    int updateByPrimaryKey(ZjkMsgConfig record);

    /**
     * 删除菜单
     *
     * @param id
     * @return
     */
    Integer deleteZjkMsgConfig(java.io.Serializable id);

    /**
     * @param param 分页查询
     * @return
     */
    LayuiTableData findZjkMsgConfigByPage(LayuiTableParam param);

    /**
     * 真删除
     *
     * @param id
     * @return
     */
    Integer deleteZjkMsgConfigReal(String id);

    /**
     * 查询树
     *
     * @return
     */
    List<TreeNode> selectObjectByTree();
}