package com.pcitc.service.expert;

import com.pcitc.base.common.LayuiTableData;
import com.pcitc.base.common.LayuiTableParam;
import com.pcitc.base.common.TreeNode;
import com.pcitc.base.expert.ZjkPatent;
import com.pcitc.base.expert.ZjkPatentExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * <p>接口类</p>
 * <p>Table: zjk_patent - 专家-专利信息</p>
 *
 * @since 2019-06-21 09:32:24
 */
public interface ZjkPatentService {

    /**
     *判空-信息
     * @param record
     * @return
     * @throws Exception
     */
        List<ZjkPatent> findZjkPatentList(ZjkPatent record) throws Exception;
    /**
     * 删除
     * @param record
     * @return
     * @throws Exception
     */
        int updateOrInsertZjkPatent(ZjkPatent record) throws Exception;
    /**
     * 根据id删除
     * @param id
     * @return
     * @throws Exception
     */
        int deleteZjkPatentById(String id) throws Exception;
    /**
     * 根据id查询对象
     * @param id
     * @return
     * @throws Exception
     */
        ZjkPatent getZjkPatentInfo(String id) throws Exception;
   /**
     * 查询总条数
     * @param example
     * @return
     */
        long countByExample(ZjkPatentExample example);
    /**
     * 根据example条件删除
     * @param example
     * @return
     */
        int deleteByExample(ZjkPatentExample example);
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
        int insert(ZjkPatent record);
    /**
     * 插入信息,返回对象
     * @param record
     * @return
     */
        ZjkPatent insertObject(ZjkPatent record);
   /**
     * 判空-插入信息
     * @param record
     * @return
     */
        int insertSelective(ZjkPatent record);
    /**
     * 根据example条件查询
     * @param example
     * @return
     */
        List<ZjkPatent> selectByExample(ZjkPatentExample example);
    /**
     * 根据主键查询
     * @param id
     * @return
     */
        ZjkPatent selectByPrimaryKey(String id);
    /**
     * 根据example条件-判空更新
     * @param record
     * @param example
     * @return
     */
        int updateByExampleSelective(@Param("record") ZjkPatent record, @Param("example") ZjkPatentExample example);
    /**
     * 根据example条件,更新所有
     * @param record
     * @param example
     * @return
     */
        int updateByExample(@Param("record") ZjkPatent record, @Param("example") ZjkPatentExample example);
  /**
     * 根据主键判空-更新
     * @param record
     * @return
     */
        int updateByPrimaryKeySelective(ZjkPatent record);
    /**
     * 根据主键更新所有
     * @param record
     * @return
     */
        int updateByPrimaryKey(ZjkPatent record);

        /**
        * 删除菜单
        * @param id
        * @return
        */
        Integer deleteZjkPatent(java.io.Serializable id);
        /**
        *
        * @param param 分页查询
        * @return
        */
        LayuiTableData findZjkPatentByPage(LayuiTableParam param);
    /**
     * 真删除
     * @param id
     * @return
     */
        Integer deleteZjkPatentReal(String id);
    /**
     * 查询树
     *
     * @return
     */
        List<TreeNode> selectObjectByTree();
}