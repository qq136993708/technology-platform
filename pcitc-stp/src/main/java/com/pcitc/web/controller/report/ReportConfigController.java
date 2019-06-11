package com.pcitc.web.controller.report;

import com.alibaba.druid.support.json.JSONUtils;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.pcitc.base.common.LayuiTableData;
import com.pcitc.base.common.LayuiTableParam;
import com.pcitc.base.common.Result;
import com.pcitc.base.common.TreeNode;
import com.pcitc.base.report.ReportColumn;
import com.pcitc.base.report.ReportConfig;
import com.pcitc.base.util.DateUtil;
import com.pcitc.web.common.BaseController;
import com.pcitc.web.common.OperationFilter;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.List;

/**
 * <p>控制类</p>
 * <p>Table: report_config - 报表配置</p>
 *
 * @since 2018-08-02 02:27:15
 */

@Controller
@RequestMapping("reportConfig")
public class ReportConfigController extends BaseController {
    /**
     * 根据ID获取对象信息
     */
    private static final String GET_INFO = "http://pcitc-zuul/system-proxy/reportconfig-provider/reportconfig/get-reportconfig/";
    /**
     * 树形
     */
    private static final String TREE_DATA = "http://pcitc-zuul/system-proxy/reportconfig-provider/reportconfig/tree-data";
    /**
     * 逻辑删除
     */
    private static final String DEL = "http://pcitc-zuul/system-proxy/reportconfig-provider/reportconfig/del-reportconfig/";
    /**
     * 物理删除
     */
    private static final String DEL_REAL = "http://pcitc-zuul/system-proxy/reportconfig-provider/reportconfig/del-reportconfig-real/";

    /**
     * 查询列表
     */
    private static final String LIST = "http://pcitc-zuul/system-proxy/reportconfig-provider/reportconfig/reportconfig_list";
    /**
     * 参数查询
     */
    private static final String LISTPARAM = "http://pcitc-zuul/system-proxy/reportconfig-provider/reportconfig/reportconfig_list_param";
    /**
     * 分页查询
     */
    private static final String LISTPAGE = "http://pcitc-zuul/system-proxy/reportconfig-provider/reportconfig/reportconfig-page";
    /**
     * 保存
     */
    private static final String SAVE = "http://pcitc-zuul/system-proxy/reportconfig-provider/reportconfig/save_reportconfig";
    /**
     * 获取模型字段
     */
    private static final String GET_LIST_MODEL_COLUMN = "http://pcitc-zuul/hana-proxy/hana/report/selectHanaModelColumn";

    private static final String GET_LIST_MODEL_COLUMN_RequestBody = "http://pcitc-zuul/hana-proxy/hana/report/selectHanaModelColumnRequestBody";
    /**
     * 保存模型字段
     */
    private static final String INSERT_MODEL_COLUMN = "http://pcitc-zuul/system-proxy/reportcolumn-provider/reportcolumn/save_reportcolumn_list";

    private static final String BATCH_DEL_COLUMN = "http://pcitc-zuul/system-proxy/reportcolumn-provider/reportcolumn/del-reportcolumn-real-batch/";

    /**
     * 报表配置-查询列表
     *
     * @param reportConfig
     * @return
     */
    @RequestMapping(value = "/list", method = RequestMethod.POST)
    @ResponseBody
    @OperationFilter(modelName = "报表配置", actionName = "查询列表getList")
    public Object getList(@RequestBody ReportConfig reportConfig) {
        httpHeaders.setContentType(MediaType.APPLICATION_JSON);
        ResponseEntity<JSONObject> responseEntity = this.restTemplate.exchange(LIST, HttpMethod.POST, new HttpEntity<ReportConfig>(reportConfig, this.httpHeaders), JSONObject.class);
        JSONObject retJson = responseEntity.getBody();
        List<ReportConfig> list = (List<ReportConfig>) retJson.get("list");
        return list;
    }

    @RequestMapping(value = "/listParam", method = RequestMethod.POST)
    @ResponseBody
    @OperationFilter(modelName = "报表配置", actionName = "查询列表getListParam")
    public Object getListParam(@RequestParam String id) {
        httpHeaders.setContentType(MediaType.APPLICATION_FORM_URLENCODED);
        MultiValueMap<String, String> requestBody = new LinkedMultiValueMap<String, String>();
        requestBody.add("id", request.getParameter("id") + "");
        HttpEntity<MultiValueMap<String, String>> entity = new HttpEntity<MultiValueMap<String, String>>(requestBody, this.httpHeaders);
        ResponseEntity<JSONObject> responseEntity = this.restTemplate.exchange(LISTPARAM, HttpMethod.POST, entity, JSONObject.class);
        JSONObject retJson = responseEntity.getBody();
        List<ReportConfig> list = (List<ReportConfig>) retJson.get("list");
        return list;
    }

    /**
     * 报表配置-分页查询
     *
     * @param param
     * @return
     */
    @RequestMapping(value = "/getTableData", method = RequestMethod.POST)
    @ResponseBody
    @OperationFilter(modelName = "报表配置", actionName = "分页查询getTableData")
    public Object getTableData(@ModelAttribute("param") LayuiTableParam param) {
        HttpEntity<LayuiTableParam> entity = new HttpEntity<LayuiTableParam>(param, this.httpHeaders);
        ResponseEntity<LayuiTableData> responseEntity = this.restTemplate.exchange(LISTPAGE, HttpMethod.POST, entity, LayuiTableData.class);
        LayuiTableData data = responseEntity.getBody();
        System.out.println("data = " + data);
        return JSON.toJSON(data).toString();
    }

    /**
     * 保存-报表配置
     *
     * @param record
     * @return
     */
    @RequestMapping(value = "/saveReportConfig")
    @ResponseBody
    @OperationFilter(modelName = "报表配置", actionName = "保存saveRecord")
    public int saveRecord(ReportConfig record) {
        httpHeaders.setContentType(MediaType.APPLICATION_JSON);
        if (record.getId() == null || "".equals(record.getId())) {
            record.setCreateDate(DateUtil.format(new Date(), DateUtil.FMT_SS));
            record.setCreateUserId(sysUserInfo.getUserId());
            record.setCreateUser(sysUserInfo.getUserName());
            record.setStatus("0");
        } else {
            record.setUpdateDate(DateUtil.format(new Date(), DateUtil.FMT_SS));
            record.setUpdateUser(sysUserInfo.getUserId());
//            if (!"2".equals(record.getStatus())) {
//                record.setStatus("0");
//            }
        }

        //保存报表配置
        ResponseEntity<Integer> responseEntity = this.restTemplate.exchange(SAVE, HttpMethod.POST, new HttpEntity<ReportConfig>(record, this.httpHeaders), Integer.class);
        Integer result = responseEntity.getBody();
        return result;
    }

    /**
     * 根据生成配置字段
     *
     * @param request
     * @return
     */
    @RequestMapping(value = "/getReportConfigInfoDo")
    @OperationFilter(modelName = "生成报表配置字段", actionName = "生成报表配置字段getReportConfigInfoDo")
    @ResponseBody
    public Object getReportConfigInfoDo(HttpServletRequest request) {
        //查询对象信息
        ReportConfig record = new ReportConfig();
        try {
            String id = request.getParameter("id");
            ResponseEntity<ReportConfig> responseEntity = this.restTemplate.exchange(GET_INFO + id, HttpMethod.POST, new HttpEntity<String>(this.httpHeaders), ReportConfig.class);
            record = (ReportConfig)responseEntity.getBody();
            //获取字段信息
            httpHeaders.setContentType(MediaType.APPLICATION_JSON);
            HttpEntity<ReportConfig> entity = new HttpEntity<ReportConfig>(record, this.httpHeaders);
            ResponseEntity<List> responseModelList = restTemplate.postForEntity(GET_LIST_MODEL_COLUMN_RequestBody,entity,List.class);
//            ResponseEntity<List> responseModelList = restTemplate.exchange(GET_LIST_MODEL_COLUMN_RequestBody, HttpMethod.POST, entity, List.class);
            //插入模型字段配置
            MultiValueMap<String, String> requestBodyColumn = new LinkedMultiValueMap<String, String>();
            String strColumn = JSON.toJSONString(responseModelList.getBody());
//            System.out.println("strColumn = " + strColumn);
            requestBodyColumn.add("paramsJson", strColumn);
            requestBodyColumn.add("paramscolumnconfig", JSON.toJSONString(record));
            httpHeaders.setContentType(MediaType.APPLICATION_FORM_URLENCODED);
            HttpEntity<MultiValueMap<String, String>> entityColumn = new HttpEntity<MultiValueMap<String, String>>(requestBodyColumn, this.httpHeaders);
            ResponseEntity<JSONObject> responseModelInsertColumn = restTemplate.exchange(INSERT_MODEL_COLUMN, HttpMethod.POST, entityColumn, JSONObject.class);
            record.setStatus("2");//是否生成
            this.saveRecord(record);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return record;
    }

    /**
     * 根据生成配置字段
     *
     * @param request
     * @return
     */
    @RequestMapping(value = "/getReportConfigInfoDoRepeat")
    @OperationFilter(modelName = "重新生成报表配置字段", actionName = "getReportConfigInfoDoRepeat")
    @ResponseBody
    public Object getReportConfigInfoDoRepeat(HttpServletRequest request) {
        int result = 0;
        try {
            String id = request.getParameter("id");
            ResponseEntity<Object> responseEntity = this.restTemplate.exchange(BATCH_DEL_COLUMN, HttpMethod.POST, new HttpEntity<String>(id, this.httpHeaders), Object.class);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    /**
     * 调整编辑页面-报表配置
     *
     * @param id
     * @param model
     * @return
     */
    @RequestMapping(method = RequestMethod.GET, value = "/edit")
    @OperationFilter(modelName = "报表配置", actionName = "跳转编辑页面pageEdit")
    public String pageEdit(String id, Model model, String opt) {
        model.addAttribute("id", id);
        model.addAttribute("opt", opt);
        return "pplus/report/reportConfig_edit";
    }

    /**
     * 跳转至报表配置列表页面
     *
     * @return
     */
    @RequestMapping(value = "/toListPage", method = {RequestMethod.GET})
    @OperationFilter(modelName = "报表配置", actionName = "跳转列表页toListPage")
    public String toListPage() {
        return "pplus/report/reportConfig_list";
    }

    /**
     * 根据ID查询对象信息
     *
     * @param request
     * @return
     */
    @RequestMapping(value = "/getReportConfigInfo")
    @OperationFilter(modelName = "报表配置", actionName = "根据ID查询对象信息getreportConfigInfo")
    @ResponseBody
    public Object getreportConfigInfo(HttpServletRequest request) {
        String id = request.getParameter("id");
        ResponseEntity<ReportConfig> responseEntity = this.restTemplate.exchange(GET_INFO + id, HttpMethod.POST, new HttpEntity<String>(this.httpHeaders), ReportConfig.class);
        ReportConfig news = responseEntity.getBody();
        return news;
    }

    @RequestMapping(value = "/tree-data")
    @OperationFilter(modelName = "报表配置", actionName = "树形查询getReportConfigTreeData()")
    public Object getReportConfigTreeData() throws Exception {
        TreeNode node = this.restTemplate.exchange(TREE_DATA, HttpMethod.POST, new HttpEntity<Object>(this.httpHeaders), TreeNode.class).getBody();
        return node;
    }

    @RequestMapping(value = "/tree-datas")
    @OperationFilter(modelName = "报表配置", actionName = "树形查询getReportConfigTreeData()")
    @ResponseBody
    public String getReportConfigTreeDatas(HttpServletRequest request) throws Exception {
        this.httpHeaders.setContentType(MediaType.APPLICATION_JSON);
        List list = this.restTemplate.exchange(TREE_DATA, HttpMethod.POST, new HttpEntity<Object>(this.httpHeaders), List.class).getBody();
        return JSONUtils.toJSONString(list);
    }

    @OperationFilter(modelName = "删除报表配置", actionName = "根据ID删除报表配置")
    @RequestMapping(value = "/del", method = RequestMethod.POST)
    @ResponseBody
    public Object delReportConfig() throws Exception {
        Integer rs = this.restTemplate.exchange(DEL + request.getParameter("id"), HttpMethod.POST, new HttpEntity<Object>(this.httpHeaders), Integer.class).getBody();
        if (rs > 0) {
            return new Result(true, "操作成功！");
        } else {
            return new Result(false, "保存失败请重试！");
        }
    }

    @OperationFilter(modelName = "物理删除报表配置", actionName = "根据ID物理删除报表配置")
    @RequestMapping(value = "/del-real", method = RequestMethod.POST)
    @ResponseBody
    public Object delReportConfigReal() throws Exception {
        Integer rs = this.restTemplate.exchange(DEL_REAL + request.getParameter("id"), HttpMethod.POST, new HttpEntity<Object>(this.httpHeaders), Integer.class).getBody();
        if (rs == 201) {
            return new Result(true, "操作成功！");
        } else {
            return new Result(false, "保存失败请重试！");
        }
    }
}