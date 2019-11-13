package com.pcitc.web.controller.system;

import java.util.Date;

import com.alibaba.druid.support.json.JSONUtils;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.pcitc.base.common.Result;
import com.pcitc.base.system.IndexOutAppraisal;
import com.pcitc.base.common.LayuiTableData;
import com.pcitc.base.common.LayuiTableParam;
import com.pcitc.web.utils.UserProfileAware;
import com.pcitc.base.common.TreeNode;
import com.pcitc.base.common.enums.DataOperationStatusEnum;
import com.pcitc.base.util.DateUtil;
import com.pcitc.web.common.JwtTokenUtil;
import com.pcitc.base.doc.SysFileKind;
import com.pcitc.web.common.OperationFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;
import com.pcitc.web.common.BaseController;
import com.pcitc.base.util.DataTableInfoVo;
import com.pcitc.base.util.DateTableUtil;
import com.pcitc.web.common.DataTableParameter;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;

import java.util.Date;
import java.util.List;
import java.util.UUID;

/**
 * <p>控制类</p>
 * <p>Table: index_out_appraisal - </p>
 *
 * @since 2019-05-23 07:13:47
 */

@Controller
public class IndexOutAppraisalController extends BaseController {
    /**
     * 根据ID获取对象信息
     */
    private static final String GET_INFO = "http://pcitc-zuul/system-proxy/indexoutappraisal-provider/indexoutappraisal/get-indexoutappraisal/";
    /**
     * 树形
     */
    private static final String TREE_DATA = "http://pcitc-zuul/system-proxy/indexoutappraisal-provider/indexoutappraisal/tree-data";
    /**
     * 逻辑删除
     */
    private static final String DEL = "http://pcitc-zuul/system-proxy/indexoutappraisal-provider/indexoutappraisal/del-indexoutappraisal/";
    /**
     * 物理删除
     */
    private static final String DEL_REAL = "http://pcitc-zuul/system-proxy/indexoutappraisal-provider/indexoutappraisal/del-indexoutappraisal-real/";

    /**
     * 查询列表
     */
    private static final String LIST = "http://pcitc-zuul/system-proxy/indexoutappraisal-provider/indexoutappraisal/indexoutappraisal_list";
    /**
     * 参数查询
     */
    private static final String LISTPARAM = "http://pcitc-zuul/system-proxy/indexoutappraisal-provider/indexoutappraisal/indexoutappraisal_list_param";
    /**
     * 分页查询
     */
    private static final String LISTPAGE = "http://pcitc-zuul/system-proxy/indexoutappraisal-provider/indexoutappraisal/indexoutappraisal-page";
    /**
     * 保存
     */
    private static final String SAVE = "http://pcitc-zuul/system-proxy/indexoutappraisal-provider/indexoutappraisal/save_indexoutappraisal";

    /**
     * -查询列表
     *
     * @param indexOutAppraisal
     * @return
     */
    @RequestMapping(value = "/indexOutAppraisal/list", method = RequestMethod.POST)
    @ResponseBody
    public Object getList(@RequestBody IndexOutAppraisal indexOutAppraisal) {
        httpHeaders.setContentType(MediaType.APPLICATION_JSON);
        ResponseEntity<JSONObject> responseEntity = this.restTemplate.exchange(LIST, HttpMethod.POST, new HttpEntity<IndexOutAppraisal>(indexOutAppraisal, this.httpHeaders), JSONObject.class);
        JSONObject retJson = responseEntity.getBody();
        List<IndexOutAppraisal> list = (List<IndexOutAppraisal>) retJson.get("list");
        return list;
    }

    @RequestMapping(value = "/indexOutAppraisal/listParam", method = RequestMethod.POST)
    @ResponseBody
    public Object getListParam(@RequestParam String id) {
        httpHeaders.setContentType(MediaType.APPLICATION_FORM_URLENCODED);
        MultiValueMap<String, String> requestBody = new LinkedMultiValueMap<String, String>();
        requestBody.add("id", request.getParameter("id") + "");
        HttpEntity<MultiValueMap<String, String>> entity = new HttpEntity<MultiValueMap<String, String>>(requestBody, this.httpHeaders);
        ResponseEntity<JSONObject> responseEntity = this.restTemplate.exchange(LISTPARAM, HttpMethod.POST, entity, JSONObject.class);
        JSONObject retJson = responseEntity.getBody();
        List<IndexOutAppraisal> list = (List<IndexOutAppraisal>) retJson.get("list");
        return list;
    }

    /**
     * -分页查询
     *
     * @param param
     * @return
     */
    @RequestMapping(value = "/indexOutAppraisal/getTableData", method = RequestMethod.POST)
    @ResponseBody
    public Object getTableData(@ModelAttribute("param") LayuiTableParam param) {
        HttpEntity<LayuiTableParam> entity = new HttpEntity<LayuiTableParam>(param, this.httpHeaders);
        ResponseEntity<LayuiTableData> responseEntity = this.restTemplate.exchange(LISTPAGE, HttpMethod.POST, entity, LayuiTableData.class);
        LayuiTableData data = responseEntity.getBody();
        return JSON.toJSON(data).toString();
    }

    /**
     * 保存-
     *
     * @param record
     * @return
     */
    @RequestMapping(value = "/saveIndexOutAppraisal")
    @ResponseBody
    @OperationFilter(modelName = "", actionName = "保存saveRecord")
    public int saveRecord(IndexOutAppraisal record) {
        httpHeaders.setContentType(MediaType.APPLICATION_JSON);
        if (record.getDataId() == null || "".equals(record.getDataId())) {
            record.setCreateDate(DateUtil.format(new Date(), DateUtil.FMT_SS));
//                record.setCreateUser(sysUserInfo.getUserId());
//                record.setCreateUserDisp(sysUserInfo.getUserName());
        } else {
            record.setUpdateDate(DateUtil.format(new Date(), DateUtil.FMT_SS));
            record.setUpdatePersonId(sysUserInfo.getUserId());
            record.setUpdatePersonName(sysUserInfo.getUserName());
        }
        record.setStatus("0");
        ResponseEntity<Integer> responseEntity = this.restTemplate.exchange(SAVE, HttpMethod.POST, new HttpEntity<IndexOutAppraisal>(record, this.httpHeaders), Integer.class);
        Integer result = responseEntity.getBody();
        return result;
    }

    /**
     * 编辑页面-
     *
     * @param id
     * @param model
     * @return
     */
    @RequestMapping(method = RequestMethod.GET, value = "/indexOutAppraisal/edit")
    @OperationFilter(modelName = "", actionName = "跳转编辑页面pageEdit")
    public String pageEdit(String id, Model model, String opt) {
        model.addAttribute("id", id);
        model.addAttribute("opt", opt);
        return "stp/system/indexOutAppraisal_edit";
    }

    /**
     * 详情页面-
     *
     * @param model
     * @return
     */
    @RequestMapping(method = RequestMethod.GET, value = "/indexOutAppraisal/view/{dataId}")
    @OperationFilter(modelName = "", actionName = "跳转详情页面pageView")
    public String pageView(@PathVariable("dataId") String dataId, Model model) {
        model.addAttribute("id", dataId);
        model.addAttribute("opt", "");
        model.addAttribute("dataId", (dataId == null || "".equals(dataId)) ? UUID.randomUUID().toString().replace("-", "") : dataId);
        return "stp/system/indexOutAppraisal_view";
    }

    /**
     * 跳转至列表页面
     *
     * @return
     */
    @RequestMapping(value = "/indexOutAppraisal/toListPage", method = {RequestMethod.GET})
    @OperationFilter(modelName = "", actionName = "跳转列表页toListPage")
    public String toListPage() {
        return "stp/system/indexOutAppraisal_list";
    }

    /**
     * 根据ID查询对象信息
     *
     * @param request
     * @return
     */
    @RequestMapping(value = "/indexOutAppraisal/getIndexOutAppraisalInfo")
    @OperationFilter(modelName = "", actionName = "根据ID查询对象信息getindexOutAppraisalInfo")
    @ResponseBody
    public Object getindexOutAppraisalInfo(HttpServletRequest request) {
        String id = request.getParameter("id");
        ResponseEntity<IndexOutAppraisal> responseEntity = this.restTemplate.exchange(GET_INFO + id, HttpMethod.POST, new HttpEntity<String>(this.httpHeaders), IndexOutAppraisal.class);
        IndexOutAppraisal news = responseEntity.getBody();
        return news;
    }

    @RequestMapping(value = "/indexOutAppraisal/tree-data")
    @ResponseBody
    @OperationFilter(modelName = "", actionName = "树形查询getIndexOutAppraisalTreeData()")
    public Object getIndexOutAppraisalTreeData() throws Exception {
        TreeNode node = this.restTemplate.exchange(TREE_DATA, HttpMethod.POST, new HttpEntity<Object>(this.httpHeaders), TreeNode.class).getBody();
        return node;
    }

    @RequestMapping(value = "/indexOutAppraisal/tree-datas")
    @OperationFilter(modelName = "", actionName = "树形查询getIndexOutAppraisalTreeData()")
    @ResponseBody
    public String getIndexOutAppraisalTreeDatas(HttpServletRequest request) throws Exception {
        this.httpHeaders.setContentType(MediaType.APPLICATION_JSON);
        List list = this.restTemplate.exchange(TREE_DATA, HttpMethod.POST, new HttpEntity<Object>(this.httpHeaders), List.class).getBody();
        return JSONUtils.toJSONString(list);
    }

    @OperationFilter(modelName = "删除", actionName = "根据ID删除")
    @RequestMapping(value = "/indexOutAppraisal/del", method = RequestMethod.POST)
    @ResponseBody
    public Object delIndexOutAppraisal() throws Exception {
        Integer rs = this.restTemplate.exchange(DEL + request.getParameter("id"), HttpMethod.POST, new HttpEntity<Object>(this.httpHeaders), Integer.class).getBody();
        if (rs > 0) {
            return new Result(true, "操作成功！");
        } else {
            return new Result(false, "保存失败请重试！");
        }
    }

    @OperationFilter(modelName = "物理删除", actionName = "根据ID物理删除")
    @RequestMapping(value = "/indexOutAppraisal/del-real", method = RequestMethod.POST)
    @ResponseBody
    public Object delIndexOutAppraisalReal() throws Exception {
        Integer rs = this.restTemplate.exchange(DEL_REAL + request.getParameter("id"), HttpMethod.POST, new HttpEntity<Object>(this.httpHeaders), Integer.class).getBody();
        if (rs > 0) {
            return new Result(true, "操作成功！");
        } else {
            return new Result(false, "保存失败请重试！");
        }
    }

}