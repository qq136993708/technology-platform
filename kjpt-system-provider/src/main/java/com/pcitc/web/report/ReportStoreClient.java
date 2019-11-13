package com.pcitc.web.report;


import com.alibaba.fastjson.JSONObject;
import com.pcitc.base.common.LayuiTableParam;
import com.pcitc.base.system.ReportStore;
import com.pcitc.service.report.ReportStoreService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


/**
 * <p>服务接口</p>
 * <p>Table: report_store - 报表收藏</p>
 *
 * @since 2018-09-27 11:15:36
 */
@Api(value = "ReportStoreClient-API", description = "报表收藏服务接口")
@RestController
public class ReportStoreClient {
    private final static Logger logger = LoggerFactory.getLogger(ReportStoreClient.class);

    @Autowired
    ReportStoreService reportStoreService;

    //参数查询
    @ApiOperation(value = "带参报表收藏查询列表", notes = "根据ID查询查询报表收藏信息,返回一个报表收藏的JSONObject对象")
    @RequestMapping(value = "/reportstore-provider/reportstore/reportstore_list_param_uid_stp", method = RequestMethod.POST)
    public JSONObject selectReportStoreListParamByUserIdStp(@RequestBody JSONObject jsonObject) {
        JSONObject retJson = new JSONObject();
        try {
            System.out.println("jsonObject = " + jsonObject);
            ReportStore reportStore = new ReportStore();
            Object id = jsonObject.get("id");
            String userId = jsonObject.get("userId").toString();
            Object configId = jsonObject.get("configId");
            if (id!=null&&!"".equals(id)){
                reportStore.setId(id.toString());
            }
            if (configId!=null&&!"".equals(configId)){
                reportStore.setModelConfigId(configId.toString());
            }
            if (userId!=null&&!"".equals(userId)){
                reportStore.setUserId(userId);
            }
            List<ReportStore> list = reportStoreService.findReportStoreList(reportStore);
            retJson.put("list", list);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return retJson;
    }

    //参数查询
    @ApiOperation(value = "带参报表收藏查询列表", notes = "根据ID查询查询报表收藏信息,返回一个报表收藏的JSONObject对象")
    @RequestMapping(value = "/reportstore-provider/reportstore/reportstore_list_param_uid", method = RequestMethod.POST)
    public JSONObject selectReportStoreListParamByUserId(@RequestParam(value = "id", required = false) String id,@RequestParam(value = "userId", required = false) String userId) {
        JSONObject retJson = new JSONObject();
        try {
            ReportStore reportStore = new ReportStore();
            if (id!=null&&!"".equals(id)){
                reportStore.setModelConfigId(id);
            }
            if (userId!=null&&!"".equals(userId)){
                reportStore.setUserId(userId);
            }
            List<ReportStore> list = reportStoreService.findReportStoreList(reportStore);
            retJson.put("list", list);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return retJson;
    }

    //参数查询
    @ApiOperation(value = "带参报表收藏查询列表", notes = "根据ID查询查询报表收藏信息,返回一个报表收藏的JSONObject对象")
    @RequestMapping(value = "/reportstore-provider/reportstore/reportstore_list_param", method = RequestMethod.POST)
    public JSONObject selectReportStoreListParam(@RequestParam(value = "id", required = false) String id) {
        JSONObject retJson = new JSONObject();
        try {
            ReportStore reportStore = new ReportStore();
            reportStore.setId(id);
            List<ReportStore> list = reportStoreService.findReportStoreList(reportStore);
            retJson.put("list", list);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return retJson;
    }

    //对象查询,js需要JSON.stringify({id:"1"},转换之后,才能自动赋值
    @ApiOperation(value = "报表收藏查询列表", notes = "自定义对象(条件)查询报表收藏信息,返回存储在JSONObject对象中的报表收藏列表")
    @RequestMapping(value = "/reportstore-provider/reportstore/reportstore_list", method = RequestMethod.POST)
    public JSONObject selectReportStoreList(@RequestBody ReportStore reportStore) {
        JSONObject retJson = new JSONObject();
        try {
            List<ReportStore> list = reportStoreService.findReportStoreList(reportStore);
            retJson.put("list", list);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return retJson;
    }


    @ApiOperation(value = "查询报表收藏树形详情信息", notes = "按ID查询报表收藏详情信息(带父ID),操作成功返回SysFileKind对象")
    @RequestMapping(value = "/reportstore-provider/reportstore/get-reportstore/{id}", method = RequestMethod.POST)
    public ReportStore getReportStoreInfo(@PathVariable(value = "id", required = true) String id) {
        try {
            return reportStoreService.getReportStoreInfo(id);
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
    @ApiOperation(value = "查询(树)报表收藏信息", notes = "查询(树)报表收藏信息,操作成功返回List<TreeNode>对象")
    @RequestMapping(value = "/reportstore-provider/reportstore/tree-data")
    @ResponseBody
    public List selectObjectByTree() throws Exception {
        return reportStoreService.selectObjectByTree();
    }


    /**
     * 删除报表收藏-false
     *
     * @param reportStorecId
     * @return
     */
    @ApiOperation(value = "伪删除报表收藏信息", notes = "按ID伪删除报表收藏信息,操作成功返回201")
    @RequestMapping(value = "/reportstore-provider/reportstore/del-reportstore/{reportStoreId}")
    public Object deleteReportStore(@PathVariable("reportStoreId") String reportStorecId) {
        return reportStoreService.deleteReportStore(reportStorecId);
    }

    /**
     * 删除报表收藏-true
     *
     * @param reportStorecId
     * @return
     */
    @ApiOperation(value = "删除报表收藏信息", notes = "按ID删除报表收藏信息,操作成功返回201")
    @RequestMapping(value = "/reportstore-provider/reportstore/del-reportstore-real/{reportStoreId}", method = RequestMethod.POST)
    public Object deleteReportStoreReal(@PathVariable("reportStoreId") String reportStorecId) {
        return reportStoreService.deleteReportStoreReal(reportStorecId);
    }


    /**
     * 分页查询
     *
     * @param param
     * @return
     */
    @ApiOperation(value = "查询报表收藏信息-分页查询", notes = "查询报表收藏信息-分页查询,Object")
    @RequestMapping(value = "/reportstore-provider/reportstore/reportstore-page")
    public Object selectReportStoreByPage(@RequestBody LayuiTableParam param) {
        return reportStoreService.findReportStoreByPage(param);
    }

    /**
     * 保存
     *
     * @param reportStore
     * @return
     */
    @ApiOperation(value = "新增报表收藏信息", notes = "新增报表收藏信息,操作成功返回500")
    @RequestMapping(value = "/reportstore-provider/reportstore/save_reportstore", method = RequestMethod.POST)
    public int updateOrInsertReportStore(@RequestBody ReportStore reportStore) {
        try {
            return reportStoreService.updateOrInsertReportStore(reportStore);
        } catch (Exception e) {
            logger.error("[保存信息失败：]", e);
        }
        return 500;
    }
}
