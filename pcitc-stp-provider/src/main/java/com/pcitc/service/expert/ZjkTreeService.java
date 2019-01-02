package com.pcitc.service.expert;

import com.alibaba.fastjson.JSONObject;
import com.pcitc.base.common.LayuiTableData;
import com.pcitc.base.common.LayuiTableParam;
import com.pcitc.base.common.TreeNode;
import com.pcitc.base.expert.ZjkTree;
import com.pcitc.base.expert.ZjkTreeExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * <p>接口类</p>
 * <p>Table: zjk_tree - 专家库-树</p>
 *
 * @since 2019-01-02 09:53:32
 */
public interface ZjkTreeService {

    /**
     * 判空-信息
     *
     * @param record
     * @return
     * @throws Exception
     */
    List<ZjkTree> findZjkTreeList(ZjkTree record) throws Exception;

    /**
     * 删除
     *
     * @param record
     * @return
     * @throws Exception
     */
    int updateOrInsertZjkTree(ZjkTree record) throws Exception;

    /**
     * 根据id删除
     *
     * @param id
     * @return
     * @throws Exception
     */
    int deleteZjkTreeById(String id) throws Exception;

    /**
     * 根据id查询对象
     *
     * @param id
     * @return
     * @throws Exception
     */
    ZjkTree getZjkTreeInfo(String id) throws Exception;

    /**
     * 查询总条数
     *
     * @param example
     * @return
     */
    long countByExample(ZjkTreeExample example);

    /**
     * 根据example条件删除
     *
     * @param example
     * @return
     */
    int deleteByExample(ZjkTreeExample example);

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
    int insert(ZjkTree record);

    /**
     * 插入信息,返回对象
     *
     * @param record
     * @return
     */
    ZjkTree insertObject(ZjkTree record);

    /**
     * 判空-插入信息
     *
     * @param record
     * @return
     */
    int insertSelective(ZjkTree record);

    /**
     * 根据example条件查询
     *
     * @param example
     * @return
     */
    List<ZjkTree> selectByExample(ZjkTreeExample example);

    /**
     * 根据主键查询
     *
     * @param id
     * @return
     */
    ZjkTree selectByPrimaryKey(String id);

    /**
     * 根据example条件-判空更新
     *
     * @param record
     * @param example
     * @return
     */
    int updateByExampleSelective(@Param("record") ZjkTree record, @Param("example") ZjkTreeExample example);

    /**
     * 根据example条件,更新所有
     *
     * @param record
     * @param example
     * @return
     */
    int updateByExample(@Param("record") ZjkTree record, @Param("example") ZjkTreeExample example);

    /**
     * 根据主键判空-更新
     *
     * @param record
     * @return
     */
    int updateByPrimaryKeySelective(ZjkTree record);

    /**
     * 根据主键更新所有
     *
     * @param record
     * @return
     */
    int updateByPrimaryKey(ZjkTree record);

    /**
     * 删除菜单
     *
     * @param id
     * @return
     */
    Integer deleteZjkTree(java.io.Serializable id);

    /**
     * @param param 分页查询
     * @return
     */
    LayuiTableData findZjkTreeByPage(LayuiTableParam param);

    /**
     * 真删除
     *
     * @param id
     * @return
     */
    Integer deleteZjkTreeReal(String id);

    /**
     * 查询树
     *
     * @return
     */
    List<TreeNode> selectObjectByTree();

    JSONObject selectTree(JSONObject jsonObject);
}