package com.pcitc.web.controller.system;

import com.alibaba.druid.support.json.JSONUtils;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.pcitc.base.common.LayuiTableData;
import com.pcitc.base.common.LayuiTableParam;
import com.pcitc.base.common.Result;
import com.pcitc.base.common.TreeNode;
import com.pcitc.base.report.ReportConfig;
import com.pcitc.base.system.ReportStore;
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
 * <p>Table: report_store - 报表收藏</p>
 *
 * @since 2018-09-27 11:15:36
 */


@Controller
@RequestMapping("reportStore")
public class ReportStoreController extends BaseController {
    /**
     * 根据ID获取对象信息
     */
    private static final String GET_INFO = "http://pcitc-zuul/system-proxy/reportstore-provider/reportstore/get-reportstore/";
    /**
     * 树形
     */
    private static final String TREE_DATA = "http://pcitc-zuul/system-proxy/reportstore-provider/reportstore/tree-data";
    /**
     * 逻辑删除
     */
    private static final String DEL = "http://pcitc-zuul/system-proxy/reportstore-provider/reportstore/del-reportstore/";
    /**
     * 物理删除
     */
    private static final String DEL_REAL = "http://pcitc-zuul/system-proxy/reportstore-provider/reportstore/del-reportstore-real/";

    /**
     * 查询列表
     */
    private static final String LIST = "http://pcitc-zuul/system-proxy/reportstore-provider/reportstore/reportstore_list";
    /**
     * 参数查询
     */
    private static final String LISTPARAM = "http://pcitc-zuul/system-proxy/reportstore-provider/reportstore/reportstore_list_param";
    private static final String LISTPARAMBYID = "http://pcitc-zuul/system-proxy/reportstore-provider/reportstore/reportstore_list_param_uid";
    private static final String LISTPARAMBYID_STP = "http://pcitc-zuul/system-proxy/reportstore-provider/reportstore/reportstore_list_param_uid_stp";
    /**
     * 分页查询
     */
    private static final String LISTPAGE = "http://pcitc-zuul/system-proxy/reportstore-provider/reportstore/reportstore-page";
    /**
     * 保存
     */
    private static final String SAVE = "http://pcitc-zuul/system-proxy/reportstore-provider/reportstore/save_reportstore";
    private static final String GET_INFO_ReportConfig = "http://pcitc-zuul/system-proxy/reportconfig-provider/reportconfig/get-reportconfig/";



    @RequestMapping(value = "/listParamByUserId", method = RequestMethod.POST)
    @ResponseBody
    @OperationFilter(modelName = "报表收藏", actionName = "根据用户ID查询列表listParamByUserId")
    public Object getlistParamByUserId() {
        httpHeaders.setContentType(MediaType.APPLICATION_FORM_URLENCODED);
        MultiValueMap<String, String> requestBody = new LinkedMultiValueMap<String, String>();
        requestBody.add("id", request.getParameter("id"));
//        requestBody.add("userId", sysUserInfo.getUserId());
        HttpEntity<MultiValueMap<String, String>> entity = new HttpEntity<MultiValueMap<String, String>>(requestBody, this.httpHeaders);
        ResponseEntity<JSONObject> responseEntity = this.restTemplate.exchange(LISTPARAMBYID, HttpMethod.POST, entity, JSONObject.class);
        JSONObject retJson = responseEntity.getBody();
        List<ReportStore> list = (List<ReportStore>) retJson.get("list");
        System.out.println("getlistParamByUserId");
        System.out.println(list);
        return list;
    }

    @RequestMapping(value = "/listParamByUserIdStp", method = RequestMethod.POST)
    @ResponseBody
    @OperationFilter(modelName = "报表收藏", actionName = "根据用户ID查询列表listParamByUserIdStp")
    public Object getlistParamByUserIdStp() {
//        httpHeaders.setContentType(MediaType.APPLICATION_FORM_URLENCODED);
//        MultiValueMap<String, String> requestBody = new LinkedMultiValueMap<String, String>();
//        requestBody.add("id", request.getParameter("id"));
//        requestBody.add("configId", request.getParameter("configId"));
//        requestBody.add("userId", sysUserInfo.getUserId());

        JSONObject jsonObject = new JSONObject();
        jsonObject.put("id", request.getParameter("id"));
        jsonObject.put("configId", request.getParameter("configId"));
        jsonObject.put("userId", sysUserInfo.getUserId());

        ResponseEntity<JSONObject> responseEntity = this.restTemplate.exchange(LISTPARAMBYID_STP, HttpMethod.POST, new HttpEntity<JSONObject>(jsonObject, this.httpHeaders), JSONObject.class);

//        HttpEntity<MultiValueMap<String, String>> entity = new HttpEntity<MultiValueMap<String, String>>(requestBody, this.httpHeaders);
//        ResponseEntity<JSONObject> responseEntity = this.restTemplate.exchange(LISTPARAMBYID, HttpMethod.POST, entity, JSONObject.class);
        JSONObject retJson = responseEntity.getBody();
        List<ReportStore> list = (List<ReportStore>) retJson.get("list");
        System.out.println("getlistParamByUserId");
        System.out.println(list);
        return list;
    }

    @RequestMapping(value = "/saveReportStoreByUser")
    @ResponseBody
    @OperationFilter(modelName = "报表收藏", actionName = "收藏保存saveRecordByUser")
    public int saveRecordByUser(ReportStore record) {
        httpHeaders.setContentType(MediaType.APPLICATION_JSON);

        //删除当前模型ID
        if (record.getId() == null || "".equals(record.getId())) {
            ResponseEntity<ReportConfig> responseEntity = this.restTemplate.exchange(GET_INFO_ReportConfig + record.getModelConfigId(), HttpMethod.POST, new HttpEntity<String>(this.httpHeaders), ReportConfig.class);

            record.setBak1("/reportNew/reportPageIndex?name="+record.getModelConfigId());
            record.setBak2("/reportNew/reportPage?name="+record.getModelConfigId());
            record.setBak3(responseEntity.getBody().getName());
            record.setCreateDate(DateUtil.format(new Date(), DateUtil.FMT_SS));
            record.setCreateUserId(record.getUserId());
            record.setParentName("DEL");
//            record.setCreateUser(sysUserInfo.getUserName());
            if(sysUserInfo!=null){
                record.setUserId(sysUserInfo.getUserId());
            }
        } else {
            record.setUpdateDate(DateUtil.format(new Date(), DateUtil.FMT_SS));
//            record.setUpdateUser(sysUserInfo.getUserId());
        }
        record.setStatus("0");
        ResponseEntity<Integer> responseEntity = this.restTemplate.exchange(SAVE, HttpMethod.POST, new HttpEntity<ReportStore>(record, this.httpHeaders), Integer.class);
        Integer result = responseEntity.getBody();
        return result;
    }

    @RequestMapping(value = "/saveReportStoreByUserStp")
    @ResponseBody
    @OperationFilter(modelName = "报表收藏", actionName = "收藏保存saveRecordByUser")
    public int saveReportStoreByUserStp(ReportStore record) {
        httpHeaders.setContentType(MediaType.APPLICATION_JSON);
        //删除当前模型ID
        if (record.getId() == null || "".equals(record.getId())) {
            ResponseEntity<ReportConfig> responseEntity = this.restTemplate.exchange(GET_INFO_ReportConfig + record.getModelConfigId(), HttpMethod.POST, new HttpEntity<String>(this.httpHeaders), ReportConfig.class);

            record.setBak1("/reportNew/reportPageIndex?name="+record.getModelConfigId());
            record.setBak2("/reportNew/reportPageStp?name="+record.getModelConfigId());
            record.setBak3(responseEntity.getBody().getName());
            record.setCreateDate(DateUtil.format(new Date(), DateUtil.FMT_SS));
//            record.setParentName("DEL");
            if(sysUserInfo!=null){
                record.setUserId(sysUserInfo.getUserId());
                record.setCreateUserId(sysUserInfo.getUserId());
                record.setCreateUser(sysUserInfo.getUserName());
            }
        } else {
            record.setUpdateDate(DateUtil.format(new Date(), DateUtil.FMT_SS));
//            record.setUpdateUser(sysUserInfo.getUserId());
        }
        record.setStatus("0");
        ResponseEntity<Integer> responseEntity = this.restTemplate.exchange(SAVE, HttpMethod.POST, new HttpEntity<ReportStore>(record, this.httpHeaders), Integer.class);
        Integer result = responseEntity.getBody();
        return result;
    }

    /**
     * 报表收藏-查询列表
     *
     * @param reportStore
     * @return
     */
    @RequestMapping(value = "/list", method = RequestMethod.POST)
    @ResponseBody
    @OperationFilter(modelName = "报表收藏", actionName = "查询列表getList")
    public Object getList(@RequestBody ReportStore reportStore) {
        httpHeaders.setContentType(MediaType.APPLICATION_JSON);
        ResponseEntity<JSONObject> responseEntity = this.restTemplate.exchange(LIST, HttpMethod.POST, new HttpEntity<ReportStore>(reportStore, this.httpHeaders), JSONObject.class);
        JSONObject retJson = responseEntity.getBody();
        List<ReportStore> list = (List<ReportStore>) retJson.get("list");
        return list;
    }


    @RequestMapping(value = "/listParam", method = RequestMethod.POST)
    @ResponseBody
    @OperationFilter(modelName = "报表收藏", actionName = "查询列表getListParam")
    public Object getListParam(@RequestParam String id) {
        httpHeaders.setContentType(MediaType.APPLICATION_FORM_URLENCODED);
        MultiValueMap<String, String> requestBody = new LinkedMultiValueMap<String, String>();
        requestBody.add("id", request.getParameter("id") + "");
        HttpEntity<MultiValueMap<String, String>> entity = new HttpEntity<MultiValueMap<String, String>>(requestBody, this.httpHeaders);
        ResponseEntity<JSONObject> responseEntity = this.restTemplate.exchange(LISTPARAM, HttpMethod.POST, entity, JSONObject.class);
        JSONObject retJson = responseEntity.getBody();
        List<ReportStore> list = (List<ReportStore>) retJson.get("list");
        return list;
    }

    /**saveReportStoreByUser
     * 报表收藏-分页查询
     *
     * @param param
     * @return
     */
    @RequestMapping(value = "/getTableData", method = RequestMethod.POST)
    @ResponseBody
    @OperationFilter(modelName = "报表收藏", actionName = "分页查询getTableData")
    public Object getTableData(@ModelAttribute("param") LayuiTableParam param) {
        if(param.getParam().get("stp")!=null){
            param.getParam().put("userId",sysUserInfo.getUserId());
        }
        HttpEntity<LayuiTableParam> entity = new HttpEntity<LayuiTableParam>(param, this.httpHeaders);
        ResponseEntity<LayuiTableData> responseEntity = this.restTemplate.exchange(LISTPAGE, HttpMethod.POST, entity, LayuiTableData.class);
        LayuiTableData data = responseEntity.getBody();
        return JSON.toJSON(data).toString();
    }


    /**
     * 保存-报表收藏
     *
     * @param record
     * @return
     */
    @RequestMapping(value = "/saveReportStore")
    @ResponseBody
    @OperationFilter(modelName = "报表收藏", actionName = "保存saveRecord")
    public int saveRecord(ReportStore record) {
        httpHeaders.setContentType(MediaType.APPLICATION_JSON);
        if (record.getId() == null || "".equals(record.getId())) {
            record.setCreateDate(DateUtil.format(new Date(), DateUtil.FMT_SS));
            record.setCreateUserId(sysUserInfo.getUserId());
            record.setCreateUser(sysUserInfo.getUserName());
        } else {
            record.setUpdateDate(DateUtil.format(new Date(), DateUtil.FMT_SS));
            record.setUpdateUser(sysUserInfo.getUserId());
        }
        record.setStatus("0");
        ResponseEntity<Integer> responseEntity = this.restTemplate.exchange(SAVE, HttpMethod.POST, new HttpEntity<ReportStore>(record, this.httpHeaders), Integer.class);
        Integer result = responseEntity.getBody();
        return result;
    }


    /**
     * 调整编辑页面-报表收藏
     *
     * @param id
     * @param model
     * @return
     */
    @RequestMapping(method = RequestMethod.GET, value = "/edit")
    @OperationFilter(modelName = "报表收藏", actionName = "跳转编辑页面pageEdit")
    public String pageEdit(String id, Model model, String opt) {
        model.addAttribute("id", id);
        model.addAttribute("opt", opt);
        return "pplus/report/reportStore_edit";
    }


    /**
     * 跳转至报表收藏列表页面
     *
     * @return
     */
    @RequestMapping(value = "/toListPage", method = {RequestMethod.GET})
    @OperationFilter(modelName = "报表收藏", actionName = "跳转列表页toListPage")
    public String toListPage() {
        return "pplus/report/reportStore_list";
    }

    /**
     * 跳转至报表收藏列表页面
     *
     * @return
     */
    @RequestMapping(value = "/toListPageStp", method = {RequestMethod.GET})
    @OperationFilter(modelName = "报表收藏", actionName = "跳转列表页toListPage")
    public String toListPageStp() {
        return "pplus/report/reportStore_liststp";
    }

    /**
     * 根据ID查询对象信息
     *
     * @param request
     * @return
     */
    @RequestMapping(value = "/getReportStoreInfo")
    @OperationFilter(modelName = "报表收藏", actionName = "根据ID查询对象信息getreportStoreInfo")
    @ResponseBody
    public Object getreportStoreInfo(HttpServletRequest request) {
        String id = request.getParameter("id");
        ResponseEntity<ReportStore> responseEntity = this.restTemplate.exchange(GET_INFO + id, HttpMethod.POST, new HttpEntity<String>(this.httpHeaders), ReportStore.class);
        ReportStore news = responseEntity.getBody();
        return news;
    }


    @RequestMapping(value = "/tree-data")
    @ResponseBody
    @OperationFilter(modelName = "报表收藏", actionName = "树形查询getReportStoreTreeData()")
    public Object getReportStoreTreeData() throws Exception {
        TreeNode node = this.restTemplate.exchange(TREE_DATA, HttpMethod.POST, new HttpEntity<Object>(this.httpHeaders), TreeNode.class).getBody();
        return node;
    }

    @RequestMapping(value = "/tree-datas")
    @OperationFilter(modelName = "报表收藏", actionName = "树形查询getReportStoreTreeData()")
    @ResponseBody
    public String getReportStoreTreeDatas(HttpServletRequest request) throws Exception {
        this.httpHeaders.setContentType(MediaType.APPLICATION_JSON);
        List list = this.restTemplate.exchange(TREE_DATA, HttpMethod.POST, new HttpEntity<Object>(this.httpHeaders), List.class).getBody();
        return JSONUtils.toJSONString(list);
    }


    @OperationFilter(modelName = "删除报表收藏", actionName = "根据ID删除报表收藏")
    @RequestMapping(value = "/del", method = RequestMethod.POST)
    @ResponseBody
    public Object delReportStore() throws Exception {
        Integer rs = this.restTemplate.exchange(DEL + request.getParameter("id"), HttpMethod.POST, new HttpEntity<Object>(this.httpHeaders), Integer.class).getBody();
        if (rs > 0) {
            return new Result(true, "操作成功！");
        } else {
            return new Result(false, "保存失败请重试！");
        }
    }

    @OperationFilter(modelName = "物理删除报表收藏", actionName = "根据ID物理删除报表收藏")
    @RequestMapping(value = "/del-real", method = RequestMethod.POST)
    @ResponseBody
    public Object delReportStoreReal() throws Exception {
        Integer rs = this.restTemplate.exchange(DEL_REAL + request.getParameter("id"), HttpMethod.POST, new HttpEntity<Object>(this.httpHeaders), Integer.class).getBody();
        if (rs > 0) {
            return new Result(true, "操作成功！");
        } else {
            return new Result(false, "保存失败请重试！");
        }
    }

}