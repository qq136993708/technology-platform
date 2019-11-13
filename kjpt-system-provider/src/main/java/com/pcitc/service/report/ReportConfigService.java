package com.pcitc.service.report;

import com.pcitc.base.common.LayuiTableData;
import com.pcitc.base.common.LayuiTableParam;
import com.pcitc.base.common.TreeNode;
import com.pcitc.base.report.ReportConfig;
import com.pcitc.base.report.ReportConfigExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * <p>接口类</p>
 * <p>Table: report_config - 报表配置</p>
 *
 * @since 2018-08-02 02:27:15
 */
public interface ReportConfigService {

    /**
     * 判空-信息
     *
     * @param record
     * @return
     * @throws Exception
     */
    List<ReportConfig> findReportConfigList(ReportConfig record) throws Exception;

    /**
     * 删除
     *
     * @param record
     * @return
     * @throws Exception
     */
    int updateOrInsertReportConfig(ReportConfig record) throws Exception;

    /**
     * 根据id删除
     *
     * @param id
     * @return
     * @throws Exception
     */
    int deleteReportConfigById(String id) throws Exception;

    /**
     * 根据id查询对象
     *
     * @param id
     * @return
     * @throws Exception
     */
    ReportConfig getReportConfigInfo(String id) throws Exception;

    /**
     * 查询总条数
     *
     * @param example
     * @return
     */
    long countByExample(ReportConfigExample example);

    /**
     * 根据example条件删除
     *
     * @param example
     * @return
     */
    int deleteByExample(ReportConfigExample example);

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
    int insert(ReportConfig record);

    /**
     * 插入信息,返回对象
     *
     * @param record
     * @return
     */
    ReportConfig insertObject(ReportConfig record);

    /**
     * 判空-插入信息
     *
     * @param record
     * @return
     */
    int insertSelective(ReportConfig record);

    /**
     * 根据example条件查询
     *
     * @param example
     * @return
     */
    List<ReportConfig> selectByExample(ReportConfigExample example);

    /**
     * 根据主键查询
     *
     * @param id
     * @return
     */
    ReportConfig selectByPrimaryKey(String id);

    /**
     * 根据example条件-判空更新
     *
     * @param record
     * @param example
     * @return
     */
    int updateByExampleSelective(@Param("record") ReportConfig record, @Param("example") ReportConfigExample example);

    /**
     * 根据example条件,更新所有
     *
     * @param record
     * @param example
     * @return
     */
    int updateByExample(@Param("record") ReportConfig record, @Param("example") ReportConfigExample example);

    /**
     * 根据主键判空-更新
     *
     * @param record
     * @return
     */
    int updateByPrimaryKeySelective(ReportConfig record);

    /**
     * 根据主键更新所有
     *
     * @param record
     * @return
     */
    int updateByPrimaryKey(ReportConfig record);

    /**
     * 删除菜单
     *
     * @param id
     * @return
     */
    Integer deleteReportConfig(java.io.Serializable id);

    /**
     * @param param 分页查询
     * @return
     */
    LayuiTableData findReportConfigByPage(LayuiTableParam param);

    /**
     * 真删除
     *
     * @param id
     * @return
     */
    Integer deleteReportConfigReal(String id);

    /**
     * 查询树
     *
     * @return
     */
    List<TreeNode> selectObjectByTree();
}