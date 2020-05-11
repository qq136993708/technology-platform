package com.pcitc.service;

import com.alibaba.fastjson.JSONArray;
import com.pcitc.base.common.LayuiTableData;
import com.pcitc.base.common.LayuiTableParam;

import java.lang.reflect.InvocationTargetException;
import java.util.List;
import java.util.Map;

public interface ReportService {
    /**
     * 报表
     *
     * @param map
     * @return
     * @throws Exception
     */
    public List getReportList(Map<String, Object> map);

    /**
     * 报表树查询
     *
     * @param json
     * @return
     * @throws Exception
     */
    public JSONArray getReportTree(String json) throws InvocationTargetException, IllegalAccessException;


    public List getReportListNew(Map<String, Object> map);

    public JSONArray getReportTreeNew(String json) throws InvocationTargetException, IllegalAccessException;

    /**
     * 模型字段查询
     *
     * @param map
     * @return
     */
    public List selectHanaModelColumn(Map<String, Object> map);

    /**
     * 查询
     *
     * @param map
     * @return
     */
    public List selectCatalog(Map<String, Object> map);

    /**
     * 模型查询
     *
     * @param map
     * @return
     */
    public List selectCubeName(Map<String, Object> map);

    /**
     * 查询-求和
     *
     * @param map
     * @return
     */
    public Long selectCatalogCount(Map<String, Object> map);

    /**
     * 模型查询-求和
     *
     * @param map
     * @return
     */
    public Long selectCubeNameCount(Map<String, Object> map);

    /**
     * Stp报表查询
     *
     * @param map
     * @return
     */
    public List getReportListStp(Map<String, Object> map);
    /**
     * Stp报表查询-总数
     *
     * @param map
     * @return
     */
    public List getReportListStpCount(Map<String, Object> map);

    /**
     * Stp报表查询-分页
     *
     * @param param
     * @return
     */
    public LayuiTableData getReportListStp(LayuiTableParam param);

    /**
     * Stp报表查询-汇总
     *
     * @param param
     * @return
     */
    public List getReportListStpSum(Map<String, Object> param);

    /**
     * Stp-mysql
     * @param map
     * @return
     */
//    List getReportListStpDb(Map<String, Object> map);
//    public List getSql(Map<String, Object> map);

}
