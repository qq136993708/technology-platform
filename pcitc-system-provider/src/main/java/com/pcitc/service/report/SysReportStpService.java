package com.pcitc.service.report;

import com.pcitc.base.common.LayuiTableData;
import com.github.pagehelper.PageInfo;
import com.pcitc.base.common.enums.DataOperationStatusEnum;
import com.pcitc.base.common.LayuiTableParam;
import com.pcitc.base.common.TreeNode;
import com.pcitc.base.report.SysReportStp;
import com.pcitc.base.report.SysReportStpExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * <p>接口类</p>
 * <p>Table: sys_report_stp - </p>
 *
 * @since 2019-01-11 10:46:19
 */
public interface SysReportStpService {

    /**
     * 判空-信息
     *
     * @param record
     * @return
     * @throws Exception
     */
    List<SysReportStp> findSysReportStpList(SysReportStp record) throws Exception;

    /**
     * 删除
     *
     * @param record
     * @return
     * @throws Exception
     */
    int updateOrInsertSysReportStp(SysReportStp record) throws Exception;

    /**
     * 根据id删除
     *
     * @param id
     * @return
     * @throws Exception
     */
    int deleteSysReportStpById(String id) throws Exception;

    /**
     * 根据id查询对象
     *
     * @param id
     * @return
     * @throws Exception
     */
    SysReportStp getSysReportStpInfo(String id) throws Exception;

    /**
     * 查询总条数
     *
     * @param example
     * @return
     */
    long countByExample(SysReportStpExample example);

    /**
     * 根据example条件删除
     *
     * @param example
     * @return
     */
    int deleteByExample(SysReportStpExample example);

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
    int insert(SysReportStp record);

    /**
     * 插入信息,返回对象
     *
     * @param record
     * @return
     */
    SysReportStp insertObject(SysReportStp record);

    /**
     * 判空-插入信息
     *
     * @param record
     * @return
     */
    int insertSelective(SysReportStp record);

    /**
     * 根据example条件查询
     *
     * @param example
     * @return
     */
    List<SysReportStp> selectByExample(SysReportStpExample example);

    /**
     * 根据主键查询
     *
     * @param id
     * @return
     */
    SysReportStp selectByPrimaryKey(String id);

    /**
     * 根据example条件-判空更新
     *
     * @param record
     * @param example
     * @return
     */
    int updateByExampleSelective(@Param("record") SysReportStp record, @Param("example") SysReportStpExample example);

    /**
     * 根据example条件,更新所有
     *
     * @param record
     * @param example
     * @return
     */
    int updateByExample(@Param("record") SysReportStp record, @Param("example") SysReportStpExample example);

    /**
     * 根据主键判空-更新
     *
     * @param record
     * @return
     */
    int updateByPrimaryKeySelective(SysReportStp record);

    /**
     * 根据主键更新所有
     *
     * @param record
     * @return
     */
    int updateByPrimaryKey(SysReportStp record);

    /**
     * 删除菜单
     *
     * @param id
     * @return
     */
    Integer deleteSysReportStp(java.io.Serializable id);

    /**
     * @param param 分页查询
     * @return
     */
    LayuiTableData findSysReportStpByPage(LayuiTableParam param);

    /**
     * 真删除
     *
     * @param id
     * @return
     */
    Integer deleteSysReportStpReal(String id);

    /**
     * 查询树
     *
     * @return
     */
    List<TreeNode> selectObjectByTree();

    LayuiTableData findByExample(LayuiTableParam param_common, SysReportStpExample example);
}