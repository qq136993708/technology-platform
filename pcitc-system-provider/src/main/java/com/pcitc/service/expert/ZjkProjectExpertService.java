package com.pcitc.service.expert;

import com.pcitc.base.common.LayuiTableData;
import com.github.pagehelper.PageInfo;
import com.pcitc.base.common.enums.DataOperationStatusEnum;
import com.pcitc.base.common.LayuiTableParam;
import com.pcitc.base.common.TreeNode;
import com.pcitc.base.expert.ZjkProjectExpert;
import com.pcitc.base.expert.ZjkProjectExpertExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * <p>接口类</p>
 * <p>Table: zjk_project_expert - </p>
 *
 * @since 2019-02-21 03:28:04
 */
public interface ZjkProjectExpertService {

    /**
     *判空-信息
     * @param record
     * @return
     * @throws Exception
     */
        List<ZjkProjectExpert> findZjkProjectExpertList(ZjkProjectExpert record) throws Exception;
    /**
     * 删除
     * @param record
     * @return
     * @throws Exception
     */
        int updateOrInsertZjkProjectExpert(ZjkProjectExpert record) throws Exception;
    /**
     * 根据id删除
     * @param id
     * @return
     * @throws Exception
     */
        int deleteZjkProjectExpertById(String id) throws Exception;
    /**
     * 根据id查询对象
     * @param id
     * @return
     * @throws Exception
     */
        ZjkProjectExpert getZjkProjectExpertInfo(String id) throws Exception;
   /**
     * 查询总条数
     * @param example
     * @return
     */
        long countByExample(ZjkProjectExpertExample example);
    /**
     * 根据example条件删除
     * @param example
     * @return
     */
        int deleteByExample(ZjkProjectExpertExample example);
    /**
     * 根据主键删除
     * @param id
     * @return
     */
        int deleteByPrimaryKey(String id);
    /**
     * 插入信息
     * @param record
     * @return
     */
        int insert(ZjkProjectExpert record);
    /**
     * 插入信息,返回对象
     * @param record
     * @return
     */
        ZjkProjectExpert insertObject(ZjkProjectExpert record);
   /**
     * 判空-插入信息
     * @param record
     * @return
     */
        int insertSelective(ZjkProjectExpert record);
    /**
     * 根据example条件查询
     * @param example
     * @return
     */
        List<ZjkProjectExpert> selectByExample(ZjkProjectExpertExample example);
    /**
     * 根据主键查询
     * @param id
     * @return
     */
        ZjkProjectExpert selectByPrimaryKey(String id);
    /**
     * 根据example条件-判空更新
     * @param record
     * @param example
     * @return
     */
        int updateByExampleSelective(@Param("record") ZjkProjectExpert record, @Param("example") ZjkProjectExpertExample example);
    /**
     * 根据example条件,更新所有
     * @param record
     * @param example
     * @return
     */
        int updateByExample(@Param("record") ZjkProjectExpert record, @Param("example") ZjkProjectExpertExample example);
  /**
     * 根据主键判空-更新
     * @param record
     * @return
     */
        int updateByPrimaryKeySelective(ZjkProjectExpert record);
    /**
     * 根据主键更新所有
     * @param record
     * @return
     */
        int updateByPrimaryKey(ZjkProjectExpert record);

        /**
        * 删除菜单
        * @param id
        * @return
        */
        Integer deleteZjkProjectExpert(java.io.Serializable id);
        /**
        *
        * @param param 分页查询
        * @return
        */
        LayuiTableData findZjkProjectExpertByPage(LayuiTableParam param);
    /**
     * 真删除
     * @param id
     * @return
     */
        Integer deleteZjkProjectExpertReal(String id);
    /**
     * 查询树
     *
     * @return
     */
        List<TreeNode> selectObjectByTree();
}