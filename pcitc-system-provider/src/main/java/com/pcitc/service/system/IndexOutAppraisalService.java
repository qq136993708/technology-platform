package com.pcitc.service.system;

import java.util.Date;

import com.pcitc.base.common.LayuiTableData;
import com.github.pagehelper.PageInfo;
import com.pcitc.base.common.enums.DataOperationStatusEnum;
import com.pcitc.base.common.LayuiTableParam;
import com.pcitc.base.common.TreeNode;
import com.pcitc.base.system.IndexOutAppraisal;
import com.pcitc.base.system.IndexOutAppraisalExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * <p>接口类</p>
 * <p>Table: index_out_appraisal - </p>
 *
 * @since 2019-05-23 07:13:47
 */
public interface IndexOutAppraisalService {

    /**
     * 判空-信息
     *
     * @param record
     * @return
     * @throws Exception
     */
    List<IndexOutAppraisal> findIndexOutAppraisalList(IndexOutAppraisal record) throws Exception;

    /**
     * 删除
     *
     * @param record
     * @return
     * @throws Exception
     */
    int updateOrInsertIndexOutAppraisal(IndexOutAppraisal record) throws Exception;

    /**
     * 根据id删除
     *
     * @param id
     * @return
     * @throws Exception
     */
    int deleteIndexOutAppraisalById(String id) throws Exception;

    /**
     * 根据id查询对象
     *
     * @param id
     * @return
     * @throws Exception
     */
    IndexOutAppraisal getIndexOutAppraisalInfo(String id) throws Exception;

    /**
     * 查询总条数
     *
     * @param example
     * @return
     */
    long countByExample(IndexOutAppraisalExample example);

    /**
     * 根据example条件删除
     *
     * @param example
     * @return
     */
    int deleteByExample(IndexOutAppraisalExample example);

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
    int insert(IndexOutAppraisal record);

    /**
     * 插入信息,返回对象
     *
     * @param record
     * @return
     */
    IndexOutAppraisal insertObject(IndexOutAppraisal record);

    /**
     * 判空-插入信息
     *
     * @param record
     * @return
     */
    int insertSelective(IndexOutAppraisal record);

    /**
     * 根据example条件查询
     *
     * @param example
     * @return
     */
    List<IndexOutAppraisal> selectByExample(IndexOutAppraisalExample example);

    /**
     * 根据主键查询
     *
     * @param id
     * @return
     */
    IndexOutAppraisal selectByPrimaryKey(String id);

    /**
     * 根据example条件-判空更新
     *
     * @param record
     * @param example
     * @return
     */
    int updateByExampleSelective(@Param("record") IndexOutAppraisal record, @Param("example") IndexOutAppraisalExample example);

    /**
     * 根据example条件,更新所有
     *
     * @param record
     * @param example
     * @return
     */
    int updateByExample(@Param("record") IndexOutAppraisal record, @Param("example") IndexOutAppraisalExample example);

    /**
     * 根据主键判空-更新
     *
     * @param record
     * @return
     */
    int updateByPrimaryKeySelective(IndexOutAppraisal record);

    /**
     * 根据主键更新所有
     *
     * @param record
     * @return
     */
    int updateByPrimaryKey(IndexOutAppraisal record);

    /**
     * 删除菜单
     *
     * @param id
     * @return
     */
    Integer deleteIndexOutAppraisal(java.io.Serializable id);

    /**
     * @param param 分页查询
     * @return
     */
    LayuiTableData findIndexOutAppraisalByPage(LayuiTableParam param);

    /**
     * 真删除
     *
     * @param id
     * @return
     */
    Integer deleteIndexOutAppraisalReal(String id);

    /**
     * 查询树
     *
     * @return
     */
    List<TreeNode> selectObjectByTree();
}