package com.pcitc.web.controller.report;

import com.alibaba.druid.support.json.JSONUtils;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.pcitc.base.common.LayuiTableData;
import com.pcitc.base.common.LayuiTableParam;
import com.pcitc.base.common.Result;
import com.pcitc.base.report.ReportColumn;
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
 * <p>Table: report_column - 报表字段配置信息</p>
 *
 * @since 2018-08-03 10:29:19
 */

@Controller
@RequestMapping("reportColumn")
public class ReportColumnController extends BaseController {
    /**
     * 根据ID获取对象信息
     */
    private static final String GET_INFO = "http://pcitc-zuul/system-proxy/reportcolumn-provider/reportcolumn/get-reportcolumn/";
    /**
     * 树形
     */
    private static final String TREE_DATA = "http://pcitc-zuul/system-proxy/reportcolumn-provider/reportcolumn/tree-data";
    /**
     * 逻辑删除
     */
    private static final String DEL = "http://pcitc-zuul/system-proxy/reportcolumn-provider/reportcolumn/del-reportcolumn/";
    /**
     * 物理删除
     */
    private static final String DEL_REAL = "http://pcitc-zuul/system-proxy/reportcolumn-provider/reportcolumn/del-reportcolumn-real/";

    /**
     * 查询列表
     */
    private static final String LIST = "http://pcitc-zuul/system-proxy/reportcolumn-provider/reportcolumn/reportcolumn_list";
    /**
     * 参数查询
     */
    private static final String LISTPARAM = "http://pcitc-zuul/system-proxy/reportcolumn-provider/reportcolumn/reportcolumn_list_param";
    /**
     * 分页查询
     */
    private static final String LISTPAGE = "http://pcitc-zuul/system-proxy/reportcolumn-provider/reportcolumn/reportcolumn-page";
    /**
     * 保存
     */
    private static final String SAVE = "http://pcitc-zuul/system-proxy/reportcolumn-provider/reportcolumn/save_reportcolumn";

    /**
     * 报表字段配置信息-查询列表
     *
     * @param reportColumn
     * @return
     */
    @RequestMapping(value = "/list", method = RequestMethod.POST)
    @ResponseBody
    @OperationFilter(modelName = "报表字段配置信息", actionName = "查询列表getList")
    public Object getList(@RequestBody ReportColumn reportColumn) {
        httpHeaders.setContentType(MediaType.APPLICATION_JSON);
        ResponseEntity<JSONObject> responseEntity = this.restTemplate.exchange(LIST, HttpMethod.POST, new HttpEntity<ReportColumn>(reportColumn, this.httpHeaders), JSONObject.class);
        JSONObject retJson = responseEntity.getBody();
        List<ReportColumn> list = (List<ReportColumn>) retJson.get("list");
        return list;
    }

    @RequestMapping(value = "/listParam", method = RequestMethod.POST)
    @ResponseBody
    @OperationFilter(modelName = "报表字段配置信息", actionName = "查询列表getListParam")
    public Object getListParam(@RequestParam String id) {
        httpHeaders.setContentType(MediaType.APPLICATION_FORM_URLENCODED);
        MultiValueMap<String, String> requestBody = new LinkedMultiValueMap<String, String>();
        requestBody.add("id", request.getParameter("id") + "");
        HttpEntity<MultiValueMap<String, String>> entity = new HttpEntity<MultiValueMap<String, String>>(requestBody, this.httpHeaders);
        ResponseEntity<JSONObject> responseEntity = this.restTemplate.exchange(LISTPARAM, HttpMethod.POST, entity, JSONObject.class);
        JSONObject retJson = responseEntity.getBody();
        List<ReportColumn> list = (List<ReportColumn>) retJson.get("list");
        return list;
    }

    /**
     * 报表字段配置信息-分页查询
     *
     * @param param
     * @return
     */
    @RequestMapping(value = "/getTableData", method = RequestMethod.POST)
    @ResponseBody
    @OperationFilter(modelName = "报表字段配置信息", actionName = "分页查询getTableData")
    public Object getTableData(@ModelAttribute("param") LayuiTableParam param) {
        HttpEntity<LayuiTableParam> entity = new HttpEntity<LayuiTableParam>(param, this.httpHeaders);
        ResponseEntity<LayuiTableData> responseEntity = this.restTemplate.exchange(LISTPAGE, HttpMethod.POST, entity, LayuiTableData.class);
        LayuiTableData data = responseEntity.getBody();
        return JSON.toJSON(data).toString();
    }

    /**
     * 保存-报表字段配置信息
     *
     * @param record
     * @return
     */
    @RequestMapping(value = "/saveReportColumn")
    @ResponseBody
    @OperationFilter(modelName = "报表字段配置信息", actionName = "保存saveRecord")
    public int saveRecord(ReportColumn record) {

        //查询数量
        LayuiTableParam param = new LayuiTableParam();
        param.setPage(1);
        param.setLimit(1000);

        HttpEntity<LayuiTableParam> entity = new HttpEntity<LayuiTableParam>(param, this.httpHeaders);
        ResponseEntity<LayuiTableData> responseCount = this.restTemplate.exchange(LISTPAGE, HttpMethod.POST, entity, LayuiTableData.class);
        httpHeaders.setContentType(MediaType.APPLICATION_JSON);
        if (record.getId() == null || "".equals(record.getId())) {
            record.setCreateDate(DateUtil.format(new Date(), DateUtil.FMT_SS));
            record.setCreateUserId(sysUserInfo.getUserId());
            record.setCreateUser(sysUserInfo.getUserName());
            record.setSsort((responseCount.getBody().getCount()+1)+"");
            record.setSfDel("0");
        } else {
            record.setUpdateDate(DateUtil.format(new Date(), DateUtil.FMT_SS));
            record.setUpdateUser(sysUserInfo.getUserId());
        }
        record.setStatus("0");
        ResponseEntity<Integer> responseEntity = this.restTemplate.exchange(SAVE, HttpMethod.POST, new HttpEntity<ReportColumn>(record, this.httpHeaders), Integer.class);
        Integer result = responseEntity.getBody();
        return result;
    }

    /**
     * 调整编辑页面-报表字段配置信息
     *
     * @param id
     * @param model
     * @return
     */
    @RequestMapping(method = RequestMethod.GET, value = "/edit")
    @OperationFilter(modelName = "报表字段配置信息", actionName = "跳转编辑页面pageEdit")
    public String pageEdit(String id, Model model, String reportConfigId) {
        model.addAttribute("id", id);
        model.addAttribute("reportConfigId", reportConfigId);
        return "pplus/report/reportColumn_edit";
    }

    /**
     * 跳转至报表字段配置信息列表页面
     *
     * @return
     */
    @RequestMapping(value = "/toListPage", method = {RequestMethod.GET})
    @OperationFilter(modelName = "报表字段配置信息", actionName = "跳转列表页toListPage")
    public String toListPage() {
        return "pplus/report/reportColumn_list";
    }

    /**
     * 根据ID查询对象信息
     *
     * @param request
     * @return
     */
    @RequestMapping(value = "/getReportColumnInfo")
    @OperationFilter(modelName = "报表字段配置信息", actionName = "根据ID查询对象信息getreportColumnInfo")
    @ResponseBody
    public Object getreportColumnInfo(HttpServletRequest request) {
        String id = request.getParameter("id");
        ResponseEntity<ReportColumn> responseEntity = this.restTemplate.exchange(GET_INFO + id, HttpMethod.POST, new HttpEntity<String>(this.httpHeaders), ReportColumn.class);
        ReportColumn news = responseEntity.getBody();
        return news;
    }

    @RequestMapping(value = "/tree-data")
    @ResponseBody
    @OperationFilter(modelName = "报表字段配置信息", actionName = "树形查询getReportColumnTreeData()")
    public String getReportColumnTreeData() throws Exception {
        httpHeaders.setContentType(MediaType.APPLICATION_JSON);
        ReportColumn reportColumn = new ReportColumn();
        ResponseEntity<List> responseEntity = this.restTemplate.exchange(TREE_DATA, HttpMethod.POST, new HttpEntity<ReportColumn>(reportColumn, this.httpHeaders), List.class);
        List treeNodes = responseEntity.getBody();
        System.out.println("treeNodes = " + treeNodes);
        return JSONUtils.toJSONString(treeNodes);
    }

    @RequestMapping(value = "/tree-datas")
    @OperationFilter(modelName = "报表字段配置信息", actionName = "树形查询getReportColumnTreeData()")
    @ResponseBody
    public String getReportColumnTreeDatas(HttpServletRequest request) throws Exception {
        this.httpHeaders.setContentType(MediaType.APPLICATION_JSON);
        List list = this.restTemplate.exchange(TREE_DATA, HttpMethod.POST, new HttpEntity<Object>(this.httpHeaders), List.class).getBody();
        return JSONUtils.toJSONString(list);
    }

    @OperationFilter(modelName = "删除报表字段配置信息", actionName = "根据ID删除报表字段配置信息")
    @RequestMapping(value = "/del", method = RequestMethod.POST)
    @ResponseBody
    public Object delReportColumn() throws Exception {
        Integer rs = this.restTemplate.exchange(DEL + request.getParameter("id"), HttpMethod.POST, new HttpEntity<Object>(this.httpHeaders), Integer.class).getBody();
        if (rs > 0) {
            return new Result(true, "操作成功！");
        } else {
            return new Result(false, "保存失败请重试！");
        }
    }

    @OperationFilter(modelName = "物理删除报表字段配置信息", actionName = "根据ID物理删除报表字段配置信息")
    @RequestMapping(value = "/del-real", method = RequestMethod.POST)
    @ResponseBody
    public Object delReportColumnReal() throws Exception {
        Integer rs = this.restTemplate.exchange(DEL_REAL + request.getParameter("id"), HttpMethod.POST, new HttpEntity<Object>(this.httpHeaders), Integer.class).getBody();
        if (rs > 0) {
            return new Result(true, "操作成功！");
        } else {
            return new Result(false, "保存失败请重试！");
        }
    }

}