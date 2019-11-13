package com.pcitc.web.report;


import com.alibaba.fastjson.JSONObject;
import com.pcitc.base.common.LayuiTableParam;
import com.pcitc.base.report.ReportColumn;
import com.pcitc.service.report.ReportColumnService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


/**
 * <p>服务接口</p>
 * <p>Table: report_column - 报表字段配置信息</p>
 *
 * @since 2018-08-03 10:29:19
 */
@Api(value = "ReportColumnClient-API", description = "报表字段配置信息服务接口")
@RestController
public class ReportColumnClient {
    private final static Logger logger = LoggerFactory.getLogger(ReportColumnClient.class);

    @Autowired
    ReportColumnService reportColumnService;


    //参数查询
    @ApiOperation(value = "带参报表字段配置信息查询列表", notes = "根据文件ID查询查询报表字段配置信息信息,返回一个报表字段配置信息的JSONObject对象")
    @RequestMapping(value = "/reportcolumn-provider/reportcolumn/reportcolumn_list_param", method = RequestMethod.POST)
    public JSONObject selectReportColumnListParam(@RequestParam(value = "id", required = false) String id) {
        JSONObject retJson = new JSONObject();
        try {
            ReportColumn reportColumn = new ReportColumn();
            reportColumn.setId(id);
            List<ReportColumn> list = reportColumnService.findReportColumnList(reportColumn);
            retJson.put("list", list);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return retJson;
    }

    //对象查询,js需要JSON.stringify({id:"1"},转换之后,才能自动赋值
    @ApiOperation(value = "报表字段配置信息查询列表", notes = "自定义对象(条件)查询报表字段配置信息信息,返回存储在JSONObject对象中的报表字段配置信息列表")
    @RequestMapping(value = "/reportcolumn-provider/reportcolumn/reportcolumn_list", method = RequestMethod.POST)
    public JSONObject selectReportColumnList(@RequestBody ReportColumn reportColumn) {
        JSONObject retJson = new JSONObject();
        try {
            List<ReportColumn> list = reportColumnService.findReportColumnList(reportColumn);
            retJson.put("list", list);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return retJson;
    }


    @ApiOperation(value = "查询报表字段配置信息树形详情信息", notes = "按ID查询报表字段配置信息详情信息(带父ID),操作成功返回SysFileKind对象")
    @RequestMapping(value = "/reportcolumn-provider/reportcolumn/get-reportcolumn/{id}", method = RequestMethod.POST)
    public ReportColumn getReportColumnInfo(@PathVariable(value = "id", required = true) String id) {
        try {
            return reportColumnService.getReportColumnInfo(id);
        } catch (Exception e) {
            logger.error("[初始化信息失败：]", e);
        }
        return null;
    }


    /**
     * 树形展示
     *
     * @return
     * @throws Exception
     */
    @ApiOperation(value = "查询(树)报表字段配置信息信息", notes = "查询(树)报表字段配置信息信息,操作成功返回List<TreeNode>对象")
    @RequestMapping(value = "/reportcolumn-provider/reportcolumn/tree-data")
    @ResponseBody
    public List selectObjectByTree() throws Exception {
        return reportColumnService.selectObjectByTree();
    }


    /**
     * 删除报表字段配置信息-false
     *
     * @param reportColumncId
     * @return
     */
    @ApiOperation(value = "伪删除报表字段配置信息信息", notes = "按ID伪删除报表字段配置信息信息,操作成功返回201")
    @RequestMapping(value = "/reportcolumn-provider/reportcolumn/del-reportcolumn/{reportColumnId}")
    public Object deleteReportColumn(@PathVariable("reportColumnId") String reportColumncId) {
        return reportColumnService.deleteReportColumn(reportColumncId);
    }

    /**
     * 删除报表字段配置信息-true
     *
     * @param reportColumncId
     * @return
     */
    @ApiOperation(value = "删除报表字段配置信息信息", notes = "按ID删除报表字段配置信息信息,操作成功返回201")
    @RequestMapping(value = "/reportcolumn-provider/reportcolumn/del-reportcolumn-real/{reportColumnId}", method = RequestMethod.POST)
    public Object deleteReportColumnReal(@PathVariable("reportColumnId") String reportColumncId) {
        return reportColumnService.deleteReportColumnReal(reportColumncId);
    }


    /**
     * 分页查询
     *
     * @param param
     * @return
     */
    @ApiOperation(value = "查询报表字段配置信息信息-分页查询", notes = "查询报表字段配置信息信息-分页查询,Object")
    @RequestMapping(value = "/reportcolumn-provider/reportcolumn/reportcolumn-page")
    public Object selectReportColumnByPage(@RequestBody LayuiTableParam param) {
        return reportColumnService.findReportColumnByPage(param);
    }

    /**
     * 保存
     *
     * @param reportColumn
     * @return
     */
    @ApiOperation(value = "新增报表字段配置信息信息", notes = "新增报表字段配置信息信息,操作成功返回500")
    @RequestMapping(value = "/reportcolumn-provider/reportcolumn/save_reportcolumn", method = RequestMethod.POST)
    public int updateOrInsertReportColumn(@RequestBody ReportColumn reportColumn) {
        try {
            return reportColumnService.updateOrInsertReportColumn(reportColumn);
        } catch (Exception e) {
            logger.error("[保存信息失败：]", e);
        }
        return 500;
    }

    @ApiOperation(value = "带参报表字段配置信息查询&数据拼装", notes = "根据ID带参报表字段配置信息查询&数据拼装,返回一个报表字段配置信息的JSONObject对象")
    @RequestMapping(value = "/reportcolumn-provider/reportcolumn/reportcolumn_list_config", method = RequestMethod.POST)
    public JSONObject selectReportColumnInfos(@RequestParam(value = "id", required = false) String id) {
        return reportColumnService.getReportPageConfig(id);
    }

    /**
     * 批量保存
     *
     * @param paramsJson
     * @return
     */
    @ApiOperation(value = "批量保存报表字段配置信息信息", notes = "批量保存报表字段配置信息信息,操作成功返回JSONObject对象")
    @RequestMapping(value = "/reportcolumn-provider/reportcolumn/save_reportcolumn_list", method = RequestMethod.POST)
    public JSONObject saveReportColumnList(@RequestParam(value = "paramsJson", required = false) String paramsJson,@RequestParam(value = "paramscolumnconfig", required = false) String paramscolumnconfig) {
            return reportColumnService.saveReportColumnList(paramsJson,paramscolumnconfig);
    }

    /**
     * 批量删除报表字段配置信息-true
     *
     * @param reportColumncId
     * @return
     */
    @ApiOperation(value = "批量删除报表字段配置信息信息", notes = "按ID批量删除报表字段配置信息信息,操作成功返回状态位")
    @RequestMapping(value = "/reportcolumn-provider/reportcolumn/del-reportcolumn-real-batch/{reportColumnId}", method = RequestMethod.POST)
    public Object deleteReportColumnRealBatch(@RequestBody String reportColumncId) {
//    public Object deleteReportColumnRealBatch(@PathVariable("reportColumnId") String reportColumncId) {
        return reportColumnService.deleteReportColumnRealBatch(reportColumncId);
    }
}
