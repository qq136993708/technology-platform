package com.pcitc.service.search;

import com.pcitc.base.common.HotWord;
import com.pcitc.base.common.LayuiTableData;
import com.github.pagehelper.PageInfo;
import com.pcitc.base.common.enums.DataOperationStatusEnum;
import com.pcitc.base.common.LayuiTableParam;
import com.pcitc.base.common.TreeNode;
import com.pcitc.base.search.ZjkSearchLog;
import com.pcitc.base.search.ZjkSearchLogExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * <p>接口类</p>
 * <p>Table: zjk_search_log - 专家库-搜索关键字日志</p>
 *
 * @since 2019-07-20 10:11:09
 */
public interface ZjkSearchLogService {

    /**
     * 判空-信息
     *
     * @param record
     * @return
     * @throws Exception
     */
    List<ZjkSearchLog> findZjkSearchLogList(ZjkSearchLog record) throws Exception;

    /**
     * 删除
     *
     * @param record
     * @return
     * @throws Exception
     */
    int updateOrInsertZjkSearchLog(ZjkSearchLog record) throws Exception;

    /**
     * 根据id删除
     *
     * @param id
     * @return
     * @throws Exception
     */
    int deleteZjkSearchLogById(String id) throws Exception;

    /**
     * 根据id查询对象
     *
     * @param id
     * @return
     * @throws Exception
     */
    ZjkSearchLog getZjkSearchLogInfo(String id) throws Exception;

    /**
     * 查询总条数
     *
     * @param example
     * @return
     */
    long countByExample(ZjkSearchLogExample example);

    /**
     * 根据example条件删除
     *
     * @param example
     * @return
     */
    int deleteByExample(ZjkSearchLogExample example);

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
    int insert(ZjkSearchLog record);

    /**
     * 插入信息,返回对象
     *
     * @param record
     * @return
     */
    ZjkSearchLog insertObject(ZjkSearchLog record);

    /**
     * 判空-插入信息
     *
     * @param record
     * @return
     */
    int insertSelective(ZjkSearchLog record);

    /**
     * 根据example条件查询
     *
     * @param example
     * @return
     */
    List<ZjkSearchLog> selectByExample(ZjkSearchLogExample example);

    /**
     * 根据主键查询
     *
     * @param id
     * @return
     */
    ZjkSearchLog selectByPrimaryKey(String id);

    /**
     * 根据example条件-判空更新
     *
     * @param record
     * @param example
     * @return
     */
    int updateByExampleSelective(@Param("record") ZjkSearchLog record, @Param("example") ZjkSearchLogExample example);

    /**
     * 根据example条件,更新所有
     *
     * @param record
     * @param example
     * @return
     */
    int updateByExample(@Param("record") ZjkSearchLog record, @Param("example") ZjkSearchLogExample example);

    /**
     * 根据主键判空-更新
     *
     * @param record
     * @return
     */
    int updateByPrimaryKeySelective(ZjkSearchLog record);

    /**
     * 根据主键更新所有
     *
     * @param record
     * @return
     */
    int updateByPrimaryKey(ZjkSearchLog record);

    /**
     * 删除菜单
     *
     * @param id
     * @return
     */
    Integer deleteZjkSearchLog(java.io.Serializable id);

    /**
     * @param param 分页查询
     * @return
     */
    LayuiTableData findZjkSearchLogByPage(LayuiTableParam param);

    /**
     * 真删除
     *
     * @param id
     * @return
     */
    Integer deleteZjkSearchLogReal(String id);

    /**
     * 查询树
     *
     * @return
     */
    List<TreeNode> selectObjectByTree();

    /**
     * 查询热点
     * @param hotWord
     * @return
     */
    public List<String> getListEs(HotWord hotWord);
}