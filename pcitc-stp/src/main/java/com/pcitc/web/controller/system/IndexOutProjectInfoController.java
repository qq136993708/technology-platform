package com.pcitc.web.controller.system;

import com.alibaba.druid.support.json.JSONUtils;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.pcitc.base.common.Result;
import com.pcitc.base.system.IndexOutProjectInfo;
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
 * <p>Table: index_out_project_info - 首页-科研项目</p>
 *
 * @since 2019-05-23 10:43:50
 */

@Controller
public class IndexOutProjectInfoController extends BaseController {
    /**
     * 根据ID获取对象信息
     */
    private static final String GET_INFO = "http://pcitc-zuul/system-proxy/indexoutprojectinfo-provider/indexoutprojectinfo/get-indexoutprojectinfo/";
    /**
     * 树形
     */
    private static final String TREE_DATA = "http://pcitc-zuul/system-proxy/indexoutprojectinfo-provider/indexoutprojectinfo/tree-data";
    /**
     * 逻辑删除
     */
    private static final String DEL = "http://pcitc-zuul/system-proxy/indexoutprojectinfo-provider/indexoutprojectinfo/del-indexoutprojectinfo/";
    /**
     * 物理删除
     */
    private static final String DEL_REAL = "http://pcitc-zuul/system-proxy/indexoutprojectinfo-provider/indexoutprojectinfo/del-indexoutprojectinfo-real/";

    /**
     * 查询列表
     */
    private static final String LIST = "http://pcitc-zuul/system-proxy/indexoutprojectinfo-provider/indexoutprojectinfo/indexoutprojectinfo_list";
    /**
     * 参数查询
     */
    private static final String LISTPARAM = "http://pcitc-zuul/system-proxy/indexoutprojectinfo-provider/indexoutprojectinfo/indexoutprojectinfo_list_param";

    private static final String LISTTypeIndexCode = "http://pcitc-zuul/system-proxy/indexoutprojectinfo-provider/indexoutprojectinfo/selectByExampleByTypeIndexCode";
    /**
     * 分页查询
     */
    private static final String LISTPAGE = "http://pcitc-zuul/system-proxy/indexoutprojectinfo-provider/indexoutprojectinfo/indexoutprojectinfo-page";
    private static final String LISTPAGETree = "http://pcitc-zuul/system-proxy/indexoutprojectinfo-provider/indexoutprojectinfo/indexoutprojectinfo-page-tree";
    /**
     * 保存
     */
    private static final String SAVE = "http://pcitc-zuul/system-proxy/indexoutprojectinfo-provider/indexoutprojectinfo/save_indexoutprojectinfo";



//    selectByExampleByTypeIndexCode
    @RequestMapping(value = "/indexOutProjectInfo/selectByExampleByTypeIndexCode", method = RequestMethod.POST)
    @ResponseBody
    public Object selectByExampleByTypeIndexCode() {

        JSONObject object = new JSONObject();
        object.put("typeIndex",request.getParameter("typeIndex").toString());
        ResponseEntity<JSONObject> responseEntity = this.restTemplate.exchange(LISTTypeIndexCode, HttpMethod.POST, new HttpEntity<JSONObject>(object), JSONObject.class);
        JSONObject retJson = responseEntity.getBody();
        return JSON.toJSON(retJson).toString();
    }

    /**
     * 首页-科研项目-查询列表
     *
     * @param indexOutProjectInfo
     * @return
     */
    @RequestMapping(value = "/indexOutProjectInfo/list", method = RequestMethod.POST)
    @ResponseBody
    public Object getList(@RequestBody IndexOutProjectInfo indexOutProjectInfo) {
        httpHeaders.setContentType(MediaType.APPLICATION_JSON);
        ResponseEntity<JSONObject> responseEntity = this.restTemplate.exchange(LIST, HttpMethod.POST, new HttpEntity<IndexOutProjectInfo>(indexOutProjectInfo, this.httpHeaders), JSONObject.class);
        JSONObject retJson = responseEntity.getBody();
        List<IndexOutProjectInfo> list = (List<IndexOutProjectInfo>) retJson.get("list");
        return list;
    }

    @RequestMapping(value = "/indexOutProjectInfo/listParam", method = RequestMethod.POST)
    @ResponseBody
    public Object getListParam(@RequestParam String id) {
        httpHeaders.setContentType(MediaType.APPLICATION_FORM_URLENCODED);
        MultiValueMap<String, String> requestBody = new LinkedMultiValueMap<String, String>();
        requestBody.add("id", request.getParameter("id") + "");
        HttpEntity<MultiValueMap<String, String>> entity = new HttpEntity<MultiValueMap<String, String>>(requestBody, this.httpHeaders);
        ResponseEntity<JSONObject> responseEntity = this.restTemplate.exchange(LISTPARAM, HttpMethod.POST, entity, JSONObject.class);
        JSONObject retJson = responseEntity.getBody();
        List<IndexOutProjectInfo> list = (List<IndexOutProjectInfo>) retJson.get("list");
        return list;
    }

    /**
     * 首页-科研项目-分页查询
     *
     * @param param
     * @return
     */
    @RequestMapping(value = "/indexOutProjectInfo/getTableData", method = RequestMethod.POST)
    @ResponseBody
    public Object getTableData(@ModelAttribute("param") LayuiTableParam param) {
        HttpEntity<LayuiTableParam> entity = new HttpEntity<LayuiTableParam>(param, this.httpHeaders);
        ResponseEntity<LayuiTableData> responseEntity = this.restTemplate.exchange(LISTPAGE, HttpMethod.POST, entity, LayuiTableData.class);
        LayuiTableData data = responseEntity.getBody();
        return JSON.toJSON(data).toString();
    }

    @RequestMapping(value = "/indexOutProjectInfo/getTableDataTree", method = RequestMethod.POST)
    @ResponseBody
    public Object getTableDataTree(@ModelAttribute("param") LayuiTableParam param) {
        HttpEntity<LayuiTableParam> entity = new HttpEntity<LayuiTableParam>(param, this.httpHeaders);
        ResponseEntity<LayuiTableData> responseEntity = this.restTemplate.exchange(LISTPAGETree, HttpMethod.POST, entity, LayuiTableData.class);
        LayuiTableData data = responseEntity.getBody();
        return JSON.toJSON(data).toString();
    }

    /**
     * 保存-首页-科研项目
     *
     * @param record
     * @return
     */
    @RequestMapping(value = "/saveIndexOutProjectInfo")
    @ResponseBody
    @OperationFilter(modelName = "首页-科研项目", actionName = "保存saveRecord")
    public int saveRecord(IndexOutProjectInfo record) {
        httpHeaders.setContentType(MediaType.APPLICATION_JSON);
        if (record.getDataId() == null || "".equals(record.getDataId())) {
            record.setCreateDate(DateUtil.format(new Date(), DateUtil.FMT_SS));
//            record.setCreateUser(sysUserInfo.getUserId());
//            record.setCreateUserDisp(sysUserInfo.getUserName());
        } else {
            record.setUpdateDate(DateUtil.format(new Date(), DateUtil.FMT_SS));
            record.setUpdatePersonId(sysUserInfo.getUserId());
            record.setUpdatePersonName(sysUserInfo.getUserName());
        }
        record.setStatus("0");
        ResponseEntity<Integer> responseEntity = this.restTemplate.exchange(SAVE, HttpMethod.POST, new HttpEntity<IndexOutProjectInfo>(record, this.httpHeaders), Integer.class);
        Integer result = responseEntity.getBody();
        return result;
    }

    /**
     * 编辑页面-首页-科研项目
     *
     * @param id
     * @param model
     * @return
     */
    @RequestMapping(method = RequestMethod.GET, value = "/indexOutProjectInfo/edit")
    @OperationFilter(modelName = "首页-科研项目", actionName = "跳转编辑页面pageEdit")
    public String pageEdit(String id, Model model, String opt) {
        model.addAttribute("id", id);
        model.addAttribute("opt", opt);
        return "stp/system/indexOutProjectInfo_edit";
    }

    /**
     * 详情页面-首页-科研项目
     *
     * @param model
     * @return
     */
    @RequestMapping(method = RequestMethod.GET, value = "/indexOutProjectInfo/view/{dataId}")
    @OperationFilter(modelName = "首页-科研项目", actionName = "跳转详情页面pageView")
    public String pageView(@PathVariable("dataId") String dataId, Model model) {
        model.addAttribute("id", dataId);
        model.addAttribute("opt", "");
        model.addAttribute("dataId", (dataId == null || "".equals(dataId)) ? UUID.randomUUID().toString().replace("-", "") : dataId);
        return "stp/system/indexOutProjectInfo_view";
    }

    /**
     * 跳转至首页-科研项目列表页面
     *
     * @return
     */
    @RequestMapping(value = "/indexOutProjectInfo/toListPage", method = {RequestMethod.GET})
    @OperationFilter(modelName = "首页-科研项目", actionName = "跳转列表页toListPage")
    public String toListPage() {
        return "stp/system/indexOutProjectInfo_list";
    }

    /**
     * 根据ID查询对象信息
     *
     * @param request
     * @return
     */
    @RequestMapping(value = "/indexOutProjectInfo/getIndexOutProjectInfoInfo")
    @OperationFilter(modelName = "首页-科研项目", actionName = "根据ID查询对象信息getindexOutProjectInfoInfo")
    @ResponseBody
    public Object getindexOutProjectInfoInfo(HttpServletRequest request) {
        String id = request.getParameter("id");
        ResponseEntity<IndexOutProjectInfo> responseEntity = this.restTemplate.exchange(GET_INFO + id, HttpMethod.POST, new HttpEntity<String>(this.httpHeaders), IndexOutProjectInfo.class);
        IndexOutProjectInfo news = responseEntity.getBody();
        return news;
    }

    @RequestMapping(value = "/indexOutProjectInfo/tree-data")
    @ResponseBody
    @OperationFilter(modelName = "首页-科研项目", actionName = "树形查询getIndexOutProjectInfoTreeData()")
    public Object getIndexOutProjectInfoTreeData() throws Exception {
        TreeNode node = this.restTemplate.exchange(TREE_DATA, HttpMethod.POST, new HttpEntity<Object>(this.httpHeaders), TreeNode.class).getBody();
        return node;
    }

    @RequestMapping(value = "/indexOutProjectInfo/tree-datas")
    @OperationFilter(modelName = "首页-科研项目", actionName = "树形查询getIndexOutProjectInfoTreeData()")
    @ResponseBody
    public String getIndexOutProjectInfoTreeDatas(HttpServletRequest request) throws Exception {
        this.httpHeaders.setContentType(MediaType.APPLICATION_JSON);
        List list = this.restTemplate.exchange(TREE_DATA, HttpMethod.POST, new HttpEntity<Object>(this.httpHeaders), List.class).getBody();
        return JSONUtils.toJSONString(list);
    }

    @OperationFilter(modelName = "删除首页-科研项目", actionName = "根据ID删除首页-科研项目")
    @RequestMapping(value = "/indexOutProjectInfo/del", method = RequestMethod.POST)
    @ResponseBody
    public Object delIndexOutProjectInfo() throws Exception {
        Integer rs = this.restTemplate.exchange(DEL + request.getParameter("id"), HttpMethod.POST, new HttpEntity<Object>(this.httpHeaders), Integer.class).getBody();
        if (rs > 0) {
            return new Result(true, "操作成功！");
        } else {
            return new Result(false, "保存失败请重试！");
        }
    }

    @OperationFilter(modelName = "物理删除首页-科研项目", actionName = "根据ID物理删除首页-科研项目")
    @RequestMapping(value = "/indexOutProjectInfo/del-real", method = RequestMethod.POST)
    @ResponseBody
    public Object delIndexOutProjectInfoReal() throws Exception {
        Integer rs = this.restTemplate.exchange(DEL_REAL + request.getParameter("id"), HttpMethod.POST, new HttpEntity<Object>(this.httpHeaders), Integer.class).getBody();
        if (rs > 0) {
            return new Result(true, "操作成功！");
        } else {
            return new Result(false, "保存失败请重试！");
        }
    }

}