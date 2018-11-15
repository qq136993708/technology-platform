package com.pcitc.web.report;


import com.alibaba.fastjson.JSONObject;
import com.pcitc.base.common.LayuiTableParam;
import com.pcitc.base.report.ReportConfig;
import com.pcitc.service.report.ReportConfigService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


/**
 * <p>服务接口</p>
 * <p>Table: report_config - 报表配置</p>
 *
 * @since 2018-08-02 02:27:15
 */
@Api(value = "ReportConfigClient-API", description = "报表配置服务接口")
@RestController
public class ReportConfigClient {
    private final static Logger logger = LoggerFactory.getLogger(ReportConfigClient.class);

    @Autowired
    ReportConfigService reportConfigService;


    //参数查询
    @ApiOperation(value = "带参报表配置查询列表", notes = "根据文件ID查询查询报表配置信息,返回一个报表配置的JSONObject对象")
    @RequestMapping(value = "/reportconfig-provider/reportconfig/reportconfig_list_param", method = RequestMethod.POST)
    public JSONObject selectReportConfigListParam(@RequestParam(value = "id", required = false) String id) {
        JSONObject retJson = new JSONObject();
        try {
            ReportConfig reportConfig = new ReportConfig();
            reportConfig.setId(id);
            List<ReportConfig> list = reportConfigService.findReportConfigList(reportConfig);
            retJson.put("list", list);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return retJson;
    }

    //对象查询,js需要JSON.stringify({id:"1"},转换之后,才能自动赋值
    @ApiOperation(value = "报表配置查询列表", notes = "自定义对象(条件)查询报表配置信息,返回存储在JSONObject对象中的报表配置列表")
    @RequestMapping(value = "/reportconfig-provider/reportconfig/reportconfig_list", method = RequestMethod.POST)
    public JSONObject selectReportConfigList(@RequestBody ReportConfig reportConfig) {
        JSONObject retJson = new JSONObject();
        try {
            List<ReportConfig> list = reportConfigService.findReportConfigList(reportConfig);
            retJson.put("list", list);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return retJson;
    }


    @ApiOperation(value = "查询报表配置树形详情信息", notes = "按ID查询报表配置详情信息(带父ID),操作成功返回SysFileKind对象")
    @RequestMapping(value = "/reportconfig-provider/reportconfig/get-reportconfig/{id}", method = RequestMethod.POST)
    public ReportConfig getReportConfigInfo(@PathVariable(value = "id", required = true) String id) {
        try {
            return reportConfigService.getReportConfigInfo(id);
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
    @ApiOperation(value = "查询(树)报表配置信息", notes = "查询(树)报表配置信息,操作成功返回List<TreeNode>对象")
    @RequestMapping(value = "/reportconfig-provider/reportconfig/tree-data")
    @ResponseBody
    public List selectObjectByTree() throws Exception {
        return reportConfigService.selectObjectByTree();
    }


    /**
     * 删除报表配置-false
     *
     * @param reportConfigcId
     * @return
     */
    @ApiOperation(value = "伪删除报表配置信息", notes = "按ID伪删除报表配置信息,操作成功返回201")
    @RequestMapping(value = "/reportconfig-provider/reportconfig/del-reportconfig/{reportConfigId}")
    public Object deleteReportConfig(@PathVariable("reportConfigId") String reportConfigcId) {
        return reportConfigService.deleteReportConfig(reportConfigcId);
    }

    /**
     * 删除报表配置-true
     *
     * @param reportConfigcId
     * @return
     */
    @ApiOperation(value = "删除报表配置信息", notes = "按ID删除报表配置信息,操作成功返回201")
    @RequestMapping(value = "/reportconfig-provider/reportconfig/del-reportconfig-real/{reportConfigId}", method = RequestMethod.POST)
    public Object deleteReportConfigReal(@PathVariable("reportConfigId") String reportConfigcId) {
        return reportConfigService.deleteReportConfigReal(reportConfigcId);
    }


    /**
     * 分页查询
     *
     * @param param
     * @return
     */
    @ApiOperation(value = "查询报表配置信息-分页查询", notes = "查询报表配置信息-分页查询,Object")
    @RequestMapping(value = "/reportconfig-provider/reportconfig/reportconfig-page")
    public Object selectReportConfigByPage(@RequestBody LayuiTableParam param) {
        return reportConfigService.findReportConfigByPage(param);
    }

    /**
     * 保存
     *
     * @param reportConfig
     * @return
     */
    @ApiOperation(value = "新增报表配置信息", notes = "新增报表配置信息,操作成功返回500")
    @RequestMapping(value = "/reportconfig-provider/reportconfig/save_reportconfig", method = RequestMethod.POST)
    public int updateOrInsertReportConfig(@RequestBody ReportConfig reportConfig) {
        try {
            return reportConfigService.updateOrInsertReportConfig(reportConfig);
        } catch (Exception e) {
            logger.error("[保存信息失败：]", e);
        }
        return 500;
    }
}
