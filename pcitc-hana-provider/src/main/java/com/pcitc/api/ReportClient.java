package com.pcitc.api;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.pcitc.base.common.LayuiTableData;
import com.pcitc.base.common.LayuiTableParam;
import com.pcitc.base.report.ReportConfig;
import com.pcitc.base.util.MyBeanUtils;
import com.pcitc.service.IDecisionService;
import com.pcitc.service.ReportService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

import static com.alibaba.fastjson.serializer.SerializerFeature.WriteNullStringAsEmpty;

@Api(value = "Report-API", description = "灵活分析报表服务")
@RestController
public class ReportClient {

    @Autowired
    private ReportService reportService;

    /**
     * 报表查询
     *
     * @param paramsJson
     * @return
     * @throws Exception
     */
    @ApiOperation(value = "查询模型列表", notes = "查询R2AS_MP_SB_0002_02模型列表信息,返回JSONArray对象")
    @RequestMapping(value = "/hana/report/getReport")
    public JSONArray getReport(@RequestParam(value = "paramsJson", required = false) String paramsJson) throws Exception {
        //System.out.println(" getList paramsJson=" + paramsJson);
        JSONArray json = JSONArray.parseArray(JSON.toJSONString(reportService.getReportList(JSONObject.parseObject(paramsJson)), WriteNullStringAsEmpty));
        return json;
    }

    /**
     * 报表树查询
     *
     * @param paramsJson
     * @return
     * @throws Exception
     */
    @ApiOperation(value = "查询树形模型列表", notes = "查询R2AS_MP_SB_0002_02模型树形列表信息,返回JSONArray对象")
    @RequestMapping(value = "/hana/report/getReportTree")//, method = RequestMethod.GET
    public JSONArray getReportTree(@RequestParam(value = "paramsJson", required = false) String paramsJson) throws Exception {
        return reportService.getReportTree(paramsJson);
    }


    /**
     * 报表树查询
     *
     * @param paramsJson
     * @return
     * @throws Exception
     */
    @ApiOperation(value = "查询树形模型列表", notes = "查询R2AS_MP_SB_0002_02模型树形列表信息,返回JSONArray对象")
    @RequestMapping(value = "/hana/report/getReportTreeNew")//, method = RequestMethod.GET
    public JSONArray getReportTreeNew(@RequestParam(value = "paramsJson", required = false) String paramsJson) throws Exception {
        return reportService.getReportTreeNew(paramsJson);
    }

    /**
     * 报表查询
     *
     * @param paramsJson
     * @return
     * @throws Exception
     */
    @ApiOperation(value = "查询模型列表", notes = "查询R2AS_MP_SB_0002_02模型列表信息,返回JSONArray对象")
    @RequestMapping(value = "/hana/report/getReportNew")
    public JSONArray getReportNew(@RequestParam(value = "paramsJson", required = false) String paramsJson) throws Exception {
        //System.out.println(" getList paramsJson=" + paramsJson);
        JSONArray json = JSONArray.parseArray(JSON.toJSONString(reportService.getReportListNew(JSONObject.parseObject(paramsJson)), WriteNullStringAsEmpty));
        return json;
    }

    /**
     * 模型字段查询
     *
     * @param paramsJson
     * @return
     * @throws Exception
     */
    @ApiOperation(value = "查询模型字段列表", notes = "查询模型字段列表,返回LIST")
    @RequestMapping(value = "/hana/report/selectHanaModelColumn")
    public List selectHanaModelColumn(@RequestParam(value = "paramsJson", required = false) String paramsJson) throws Exception {
        return reportService.selectHanaModelColumn(JSONObject.parseObject(paramsJson));
    }

    /**
     * 模型字段查询
     *
     * @param paramsJson
     * @return
     * @throws Exception
     */
    @ApiOperation(value = "模糊查询模型Catalog列表", notes = "模糊查询模型Catalog列表,返回LIST")
    @RequestMapping(value = "/hana/report/selectCatalog")
    public List selectCatalog(@RequestParam(value = "paramsJson", required = false) String paramsJson) throws Exception {
        JSONObject jsonObject =JSONObject.parseObject(paramsJson);
        Long aCount = reportService.selectCatalogCount(jsonObject);
        List list = reportService.selectCatalog(jsonObject);
        for (int i = 0; i < list.size(); i++) {
            ((Map<String,Object>)list.get(i)).put("acount",aCount+"");
        }
        return list;
    }

    /**
     * 模型字段查询
     *
     * @param paramsJson
     * @return
     * @throws Exception
     */
    @ApiOperation(value = "根据模型名称模糊查询模型列表", notes = "根据模型名称模糊查询模型列表,返回LIST")
    @RequestMapping(value = "/hana/report/selectCubeName")
    public List selectCubeName(@RequestParam(value = "paramsJson", required = false) String paramsJson) throws Exception {
        JSONObject jsonObject =JSONObject.parseObject(paramsJson);
        Long aCount = reportService.selectCubeNameCount(jsonObject);
        List list = reportService.selectCubeName(jsonObject);
        for (int i = 0; i < list.size(); i++) {
            ((Map<String,Object>)list.get(i)).put("acount",aCount+"");
        }
        return list;
    }

    /**
     * 模型字段查询
     *
     * @param obj
     * @return
     * @throws Exception
     */
    @ApiOperation(value = "查询模型字段列表", notes = "查询模型字段列表,返回LIST")
    @RequestMapping(value = "/hana/report/selectHanaModelColumnRequestBody")
    public List selectHanaModelColumnRequestBody(@RequestBody  ReportConfig obj) throws Exception {
        return reportService.selectHanaModelColumn(MyBeanUtils.transBean2Map(obj));
    }

    /**
     * 查询STP报表信息
     *
     * @param param
     * @return
     * @throws Exception
     */
    @ApiOperation(value = "查询STP报表信息", notes = "查询STP报表信息,返回JSONArray对象")
    @RequestMapping(value = "/hana/report/getReportListStp")
    public LayuiTableData getReportListStp(@RequestBody LayuiTableParam param) throws Exception {
        return reportService.getReportListStp(param);
    }
//    public JSONArray getReportListStp(@RequestParam(value = "paramsJson", required = false) String paramsJson) throws Exception {
//        return reportService.getReportListStp(paramsJson);
//    }
}
