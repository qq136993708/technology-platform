package com.pcitc.service.report;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.pcitc.base.common.LayuiTableData;
import com.pcitc.base.common.LayuiTableParam;
import com.pcitc.base.common.TreeNode;
import com.pcitc.base.report.ReportColumn;
import com.pcitc.base.report.ReportColumnExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * <p>接口类</p>
 * <p>Table: report_column - 报表字段配置信息</p>
 *
 * @since 2018-08-03 10:29:19
 */
public interface ReportColumnService {

    /**
     * 判空-信息
     *
     * @param record
     * @return
     * @throws Exception
     */
    List<ReportColumn> findReportColumnList(ReportColumn record) throws Exception;

    /**
     * 删除
     *
     * @param record
     * @return
     * @throws Exception
     */
    int updateOrInsertReportColumn(ReportColumn record) throws Exception;

    /**
     * 根据id删除
     *
     * @param id
     * @return
     * @throws Exception
     */
    int deleteReportColumnById(String id) throws Exception;

    /**
     * 根据id查询对象
     *
     * @param id
     * @return
     * @throws Exception
     */
    ReportColumn getReportColumnInfo(String id) throws Exception;

    /**
     * 查询总条数
     *
     * @param example
     * @return
     */
    long countByExample(ReportColumnExample example);

    /**
     * 根据example条件删除
     *
     * @param example
     * @return
     */
    int deleteByExample(ReportColumnExample example);

    int deleteReportColumnRealBatch(String reportColumncId);

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
    int insert(ReportColumn record);

    /**
     * 插入信息,返回对象
     *
     * @param record
     * @return
     */
    ReportColumn insertObject(ReportColumn record);

    /**
     * 判空-插入信息
     *
     * @param record
     * @return
     */
    int insertSelective(ReportColumn record);

    /**
     * 根据example条件查询
     *
     * @param example
     * @return
     */
    List<ReportColumn> selectByExample(ReportColumnExample example);

    /**
     * 根据主键查询
     *
     * @param id
     * @return
     */
    ReportColumn selectByPrimaryKey(String id);

    /**
     * 根据example条件-判空更新
     *
     * @param record
     * @param example
     * @return
     */
    int updateByExampleSelective(@Param("record") ReportColumn record, @Param("example") ReportColumnExample example);

    /**
     * 根据example条件,更新所有
     *
     * @param record
     * @param example
     * @return
     */
    int updateByExample(@Param("record") ReportColumn record, @Param("example") ReportColumnExample example);

    /**
     * 根据主键判空-更新
     *
     * @param record
     * @return
     */
    int updateByPrimaryKeySelective(ReportColumn record);

    /**
     * 根据主键更新所有
     *
     * @param record
     * @return
     */
    int updateByPrimaryKey(ReportColumn record);

    /**
     * 删除菜单
     *
     * @param id
     * @return
     */
    Integer deleteReportColumn(java.io.Serializable id);

    /**
     * @param param 分页查询
     * @return
     */
    LayuiTableData findReportColumnByPage(LayuiTableParam param);

    /**
     * 真删除
     *
     * @param id
     * @return
     */
    Integer deleteReportColumnReal(String id);

    /**
     * 查询树
     *
     * @return
     */
    List<TreeNode> selectObjectByTree();
    /**
     * JSONARRAY数组合并
     * @param mData
     * @param array
     * @return
     */
    JSONArray joinJSONArray(JSONArray mData, JSONArray array);

    /**
     * 获取报表配置信息
     * @param id
     * @return
     */
    JSONObject getReportPageConfig(String id);

    /**
     * 获取报表配置信息
     * @param paramsJson
     * @return
     */
    JSONObject saveReportColumnList(String paramsJson, String paramscolumnconfig);

}