package com.pcitc.service.expert;

import com.pcitc.base.common.LayuiTableData;
import com.github.pagehelper.PageInfo;
import com.pcitc.base.common.enums.DataOperationStatusEnum;
import com.pcitc.base.common.LayuiTableParam;
import com.pcitc.base.common.TreeNode;
import com.pcitc.base.expert.ZjkBaseInfo;
import com.pcitc.base.expert.ZjkBaseInfoExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * <p>接口类</p>
 * <p>Table: zjk_base_info - 专家-基本信息</p>
 *
 * @since 2018-12-08 04:10:36
 */
public interface ZjkBaseInfoService {

    /**
     * 判空-信息
     *
     * @param record
     * @return
     * @throws Exception
     */
    List<ZjkBaseInfo> findZjkBaseInfoList(ZjkBaseInfo record) throws Exception;

    /**
     * 删除
     *
     * @param record
     * @return
     * @throws Exception
     */
    int updateOrInsertZjkBaseInfo(ZjkBaseInfo record) throws Exception;

    /**
     * 根据id删除
     *
     * @param id
     * @return
     * @throws Exception
     */
    int deleteZjkBaseInfoById(String id) throws Exception;

    /**
     * 根据id查询对象
     *
     * @param id
     * @return
     * @throws Exception
     */
    ZjkBaseInfo getZjkBaseInfoInfo(String id) throws Exception;

    /**
     * 查询总条数
     *
     * @param example
     * @return
     */
    long countByExample(ZjkBaseInfoExample example);

    /**
     * 根据example条件删除
     *
     * @param example
     * @return
     */
    int deleteByExample(ZjkBaseInfoExample example);

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
    int insert(ZjkBaseInfo record);

    /**
     * 插入信息,返回对象
     *
     * @param record
     * @return
     */
    ZjkBaseInfo insertObject(ZjkBaseInfo record);

    /**
     * 判空-插入信息
     *
     * @param record
     * @return
     */
    int insertSelective(ZjkBaseInfo record);

    /**
     * 根据example条件查询
     *
     * @param example
     * @return
     */
    List<ZjkBaseInfo> selectByExample(ZjkBaseInfoExample example);

    /**
     * 根据主键查询
     *
     * @param id
     * @return
     */
    ZjkBaseInfo selectByPrimaryKey(String id);

    /**
     * 根据example条件-判空更新
     *
     * @param record
     * @param example
     * @return
     */
    int updateByExampleSelective(@Param("record") ZjkBaseInfo record, @Param("example") ZjkBaseInfoExample example);

    /**
     * 根据example条件,更新所有
     *
     * @param record
     * @param example
     * @return
     */
    int updateByExample(@Param("record") ZjkBaseInfo record, @Param("example") ZjkBaseInfoExample example);

    /**
     * 根据主键判空-更新
     *
     * @param record
     * @return
     */
    int updateByPrimaryKeySelective(ZjkBaseInfo record);

    /**
     * 根据主键更新所有
     *
     * @param record
     * @return
     */
    int updateByPrimaryKey(ZjkBaseInfo record);

    /**
     * 删除菜单
     *
     * @param id
     * @return
     */
    Integer deleteZjkBaseInfo(java.io.Serializable id);

    /**
     * @param param 分页查询
     * @return
     */
    LayuiTableData findZjkBaseInfoByPage(LayuiTableParam param);

    /**
     * 真删除
     *
     * @param id
     * @return
     */
    Integer deleteZjkBaseInfoReal(String id);

    /**
     * 查询树
     *
     * @return
     */
    List<TreeNode> selectObjectByTree();
}