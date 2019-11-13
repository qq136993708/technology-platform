package com.pcitc.service.report;

import com.pcitc.base.common.LayuiTableData;
import com.pcitc.base.common.LayuiTableParam;
import com.pcitc.base.common.TreeNode;
import com.pcitc.base.system.ReportStore;
import com.pcitc.base.system.ReportStoreExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * <p>接口类</p>
 * <p>Table: report_store - 报表收藏</p>
 *
 * @since 2018-09-27 11:15:36
 */
public interface ReportStoreService {

    /**
     * 判空-信息
     *
     * @param record
     * @return
     * @throws Exception
     */
    List<ReportStore> findReportStoreList(ReportStore record) throws Exception;

    /**
     * 删除
     *
     * @param record
     * @return
     * @throws Exception
     */
    int updateOrInsertReportStore(ReportStore record) throws Exception;

    /**
     * 根据id删除
     *
     * @param id
     * @return
     * @throws Exception
     */
    int deleteReportStoreById(String id) throws Exception;

    /**
     * 根据id查询对象
     *
     * @param id
     * @return
     * @throws Exception
     */
    ReportStore getReportStoreInfo(String id) throws Exception;

    /**
     * 查询总条数
     *
     * @param example
     * @return
     */
    long countByExample(ReportStoreExample example);

    /**
     * 根据example条件删除
     *
     * @param example
     * @return
     */
    int deleteByExample(ReportStoreExample example);

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
    int insert(ReportStore record);

    /**
     * 插入信息,返回对象
     *
     * @param record
     * @return
     */
    ReportStore insertObject(ReportStore record);

    /**
     * 判空-插入信息
     *
     * @param record
     * @return
     */
    int insertSelective(ReportStore record);

    /**
     * 根据example条件查询
     *
     * @param example
     * @return
     */
    List<ReportStore> selectByExample(ReportStoreExample example);

    /**
     * 根据主键查询
     *
     * @param id
     * @return
     */
    ReportStore selectByPrimaryKey(String id);

    /**
     * 根据example条件-判空更新
     *
     * @param record
     * @param example
     * @return
     */
    int updateByExampleSelective(@Param("record") ReportStore record, @Param("example") ReportStoreExample example);

    /**
     * 根据example条件,更新所有
     *
     * @param record
     * @param example
     * @return
     */
    int updateByExample(@Param("record") ReportStore record, @Param("example") ReportStoreExample example);

    /**
     * 根据主键判空-更新
     *
     * @param record
     * @return
     */
    int updateByPrimaryKeySelective(ReportStore record);

    /**
     * 根据主键更新所有
     *
     * @param record
     * @return
     */
    int updateByPrimaryKey(ReportStore record);

    /**
     * 删除菜单
     *
     * @param id
     * @return
     */
    Integer deleteReportStore(java.io.Serializable id);

    /**
     * @param param 分页查询
     * @return
     */
    LayuiTableData findReportStoreByPage(LayuiTableParam param);

    /**
     * 真删除
     *
     * @param id
     * @return
     */
    Integer deleteReportStoreReal(String id);

    /**
     * 查询树
     *
     * @return
     */
    List<TreeNode> selectObjectByTree();
}