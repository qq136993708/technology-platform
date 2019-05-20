package com.pcitc.web.controller.system;

import com.alibaba.druid.support.json.JSONUtils;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.google.gson.JsonObject;
import com.pcitc.base.common.LayuiTableData;
import com.pcitc.base.common.LayuiTableParam;
import com.pcitc.base.common.Result;
import com.pcitc.base.common.TreeNode;
import com.pcitc.base.stp.out.OutProjectInfo;
import com.pcitc.base.stp.techFamily.TechFamily;
import com.pcitc.base.system.StandardBase;
import com.pcitc.base.system.SysFile;
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
import java.util.UUID;

/**
 * <p>控制类</p>
 * <p>Table: standard_base - 标准化</p>
 *
 * @since 2019-05-07 10:08:25
 */

@Controller
@RequestMapping("standardBaseExpert")
public class StandardBaseExpertController extends BaseController {
    /**
     * 根据ID获取对象信息
     */
    private static final String GET_INFO = "http://pcitc-zuul/system-proxy/standardbase-provider/standardbase/get-standardbase/";
    /**
     * 树形
     */
    private static final String TREE_DATA = "http://pcitc-zuul/system-proxy/standardbase-provider/standardbase/tree-data";
    /**
     * 逻辑删除
     */
    private static final String DEL = "http://pcitc-zuul/system-proxy/standardbase-provider/standardbase/del-standardbase/";
    /**
     * 物理删除
     */
    private static final String DEL_REAL = "http://pcitc-zuul/system-proxy/standardbase-provider/standardbase/del-standardbase-real/";

    /**
     * 查询列表
     */
    private static final String LIST = "http://pcitc-zuul/system-proxy/standardbase-provider/standardbase/standardbase_list";
    /**
     * 参数查询
     */
    private static final String LISTPARAM = "http://pcitc-zuul/system-proxy/standardbase-provider/standardbase/standardbase_list_param";
    /**
     * 分页查询
     */
    private static final String LISTPAGE = "http://pcitc-zuul/system-proxy/standardbase-provider/standardbase/standardbase-page";
    /**
     * 保存
     */
    private static final String SAVE = "http://pcitc-zuul/system-proxy/standardbase-provider/standardbase/save_standardbase";

    private static final String importFileStandard = "http://pcitc-zuul/system-proxy/PlanClient-provider/importFileStandard";
    private static final String importFileTfc = "http://pcitc-zuul/system-proxy/PlanClient-provider/importFileTfc";
    private static final String TECH_TYPE_ADD_LIST = "http://pcitc-zuul/stp-proxy/tech-family-provider/type-insert-list";

    /**
     * 技术族导入
     *
     * @return
     */
    @RequestMapping(value = "/importFileTfc")
    @ResponseBody
    @OperationFilter(modelName = "技术族导入", actionName = "导入excel文件")
    public Result importFileTfc() {
        //获取excel内容
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("fileList", request.getParameter("param"));
        ResponseEntity<JSONObject> responseEntity = this.restTemplate.exchange(importFileTfc, HttpMethod.POST, new HttpEntity<JSONObject>(jsonObject, this.httpHeaders), JSONObject.class);
        JSONObject body = responseEntity.getBody();
        System.out.println(body.get("list"));
        //保存
        int retI = this.restTemplate.exchange(TECH_TYPE_ADD_LIST, HttpMethod.POST, new HttpEntity<JSONObject>(body, this.httpHeaders), Integer.class).getBody();
        if (retI >= 1) {
            return new Result(true, "操作成功");
        } else {
            return new Result(true, "操作失败");
        }
    }

    /**
     * 标准化导入
     *
     * @return
     */
    @RequestMapping(value = "/importFileStandard")
    @ResponseBody
    @OperationFilter(modelName = "标准管理", actionName = "导入excel文件")
    public String importFileStandard() {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("fileList", request.getParameter("param"));
        ResponseEntity<JSONObject> responseEntity = this.restTemplate.exchange(importFileStandard, HttpMethod.POST, new HttpEntity<JSONObject>(jsonObject, this.httpHeaders), JSONObject.class);
        return "ok";
    }

    @RequestMapping(method = RequestMethod.GET, value = "/pageSelectics")
    public String pageSelectics(String id, Model model, String opt) {
        return "stp/system/pageSelectics";
    }

    @RequestMapping(method = RequestMethod.GET, value = "/pageSelectType")
    public String pageSelectType(String id, Model model, String opt) {
        return "stp/system/pageSelectType";
    }

    @RequestMapping(method = RequestMethod.GET, value = "/pageSelectorgType")
    public String pageSelectorgType(String id, Model model, String opt) {
        return "stp/system/pageSelectorgType";
    }

    /**
     * 技术热点图
     *
     * @return
     */
    @RequestMapping(method = RequestMethod.GET, value = "/tfcHotPoint")
    public String tfcHotPoint() {
        String dataId = request.getParameter("dataId");
        if (dataId==null||"".equals(dataId))
        {
            dataId="no";
        }
        ResponseEntity<JSONObject> responseEntity = this.restTemplate.exchange(GET_OUT_PROJECT_COUNT+dataId, HttpMethod.POST, new HttpEntity<>(this.httpHeaders), JSONObject.class);
        JSONObject outProjectInfo = responseEntity.getBody();
        request.setAttribute("value",outProjectInfo.get("value"));
        request.setAttribute("name",outProjectInfo.get("name"));
        return "stp/techFamily/tfcHotPoint";
    }


    @RequestMapping(method = RequestMethod.GET, value = "/tfcAnalysis")
    public String tfcAnalysis() {
        String dataId = request.getParameter("dataId");
        if (dataId==null||"".equals(dataId))
        {
            dataId="no";
        }
        ResponseEntity<JSONObject> responseEntity = this.restTemplate.exchange(GET_OUT_PROJECT_COUNT+dataId, HttpMethod.POST, new HttpEntity<>(this.httpHeaders), JSONObject.class);
        JSONObject outProjectInfo = responseEntity.getBody();
        request.setAttribute("value",outProjectInfo.get("value"));
        request.setAttribute("name",outProjectInfo.get("name"));
        return "stp/techFamily/tfcAnalysis";
    }

    /**
     * 技术优选
     *
     * @return
     */
    @RequestMapping(method = RequestMethod.GET, value = "/tfcGood")
    public String tfcGood() {
        return "stp/techFamily/tfcGood";
    }

    /**
     * 技术族推荐
     *
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "/tfcTj")
    public String tfcTj() throws Exception {
        request.setAttribute("dataId", request.getParameter("dataId"));
        request.setAttribute("name", request.getParameter("name"));

        String dataId = request.getParameter("dataId");

        //获取项目信息
        ResponseEntity<OutProjectInfo> responseEntity = this.restTemplate.exchange(GET_OUT_PROJECT + dataId, HttpMethod.POST, new HttpEntity<String>(this.httpHeaders), OutProjectInfo.class);
        OutProjectInfo outProjectInfo = responseEntity.getBody();
        //获取分词

        //获取对应技术族信息
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("info", JSONObject.toJSONString(outProjectInfo));
        ResponseEntity<JSONObject> responseBody = this.restTemplate.exchange(GET_TFC_PROJECT, HttpMethod.POST, new HttpEntity<JSONObject>(jsonObject, this.httpHeaders), JSONObject.class);

        request.setAttribute("values", responseBody.getBody().get("info"));
        return "/stp/techFamily/tfcTj";
    }

    private static final String GET_OUT_PROJECT = "http://pcitc-zuul/system-proxy/out-provider/get-project-list-fc/";
    private static final String GET_OUT_PROJECT_COUNT = "http://pcitc-zuul/system-proxy/out-provider/get-project-list-count/";
    private static final String GET_TFC_PROJECT = "http://pcitc-zuul/stp-proxy/tech-family-provider/get-tfc-project";

    /**
     * 标准化-查询列表
     *
     * @param standardBase
     * @return
     */
    @RequestMapping(value = "/list", method = RequestMethod.POST)
    @ResponseBody
    public Object getList(@RequestBody StandardBase standardBase) {
        httpHeaders.setContentType(MediaType.APPLICATION_JSON);
        ResponseEntity<JSONObject> responseEntity = this.restTemplate.exchange(LIST, HttpMethod.POST, new HttpEntity<StandardBase>(standardBase, this.httpHeaders), JSONObject.class);
        JSONObject retJson = responseEntity.getBody();
        List<StandardBase> list = (List<StandardBase>) retJson.get("list");
        return list;
    }

    @RequestMapping(value = "/listParam", method = RequestMethod.POST)
    @ResponseBody
    public Object getListParam(@RequestParam String id) {
        httpHeaders.setContentType(MediaType.APPLICATION_FORM_URLENCODED);
        MultiValueMap<String, String> requestBody = new LinkedMultiValueMap<String, String>();
        requestBody.add("id", request.getParameter("id") + "");
        HttpEntity<MultiValueMap<String, String>> entity = new HttpEntity<MultiValueMap<String, String>>(requestBody, this.httpHeaders);
        ResponseEntity<JSONObject> responseEntity = this.restTemplate.exchange(LISTPARAM, HttpMethod.POST, entity, JSONObject.class);
        JSONObject retJson = responseEntity.getBody();
        List<StandardBase> list = (List<StandardBase>) retJson.get("list");
        return list;
    }

    /**
     * 标准化-分页查询
     *
     * @param param
     * @return
     */
    @RequestMapping(value = "/getTableData", method = RequestMethod.POST)
    @ResponseBody
    public Object getTableData(@ModelAttribute("param") LayuiTableParam param) {
        HttpEntity<LayuiTableParam> entity = new HttpEntity<LayuiTableParam>(param, this.httpHeaders);
        ResponseEntity<LayuiTableData> responseEntity = this.restTemplate.exchange(LISTPAGE, HttpMethod.POST, entity, LayuiTableData.class);
        LayuiTableData data = responseEntity.getBody();
        return JSON.toJSON(data).toString();
    }

    /**
     * 保存-标准化
     *
     * @param record
     * @return
     */
    @RequestMapping(value = "/saveStandardBase")
    @ResponseBody
    @OperationFilter(modelName = "标准化", actionName = "保存saveRecord")
    public String saveRecord(StandardBase record) {
        String msg = "";
        String success = "true";
        String strReturn = "";
        try {
            httpHeaders.setContentType(MediaType.APPLICATION_JSON);
            if (record.getDataId() == null || "".equals(record.getDataId())) {
                record.setCreateDate(DateUtil.format(new Date(), DateUtil.FMT_SS));
                record.setCreateUser(sysUserInfo.getUserId());
                record.setCreateUserDisp(sysUserInfo.getUserName());
            } else {
                record.setUpdateDate(DateUtil.format(new Date(), DateUtil.FMT_SS));
                record.setUpdatePersonId(sysUserInfo.getUserId());
                record.setUpdatePersonName(sysUserInfo.getUserName());
            }
            record.setStatus("0");
            ResponseEntity<Integer> responseEntity = this.restTemplate.exchange(SAVE, HttpMethod.POST, new HttpEntity<StandardBase>(record, this.httpHeaders), Integer.class);
        } catch (Exception e) {
            msg = "保存异常";
            success = "false";
            e.printStackTrace();
        } finally {
            return "{\"msg\":" + msg + ",\"success\":" + success + "}";
        }
    }

    /**
     * 编辑页面-标准化
     *
     * @param id
     * @param model
     * @return
     */
    @RequestMapping(method = RequestMethod.GET, value = "/edit")
    @OperationFilter(modelName = "标准化", actionName = "跳转编辑页面pageEdit")
    public String pageEdit(String id, Model model, String opt) {
        model.addAttribute("id", id);
        model.addAttribute("opt", opt);
        return "stp/system/standardBase_edit";
    }

    /**
     * 详情页面-标准化
     *
     * @param model
     * @return
     */
    @RequestMapping(method = RequestMethod.GET, value = "/view/{dataId}")
    @OperationFilter(modelName = "标准化", actionName = "跳转详情页面pageView")
    public String pageView(@PathVariable("dataId") String dataId, Model model) {
        model.addAttribute("id", dataId);
        model.addAttribute("opt", "");
        model.addAttribute("dataId", (dataId == null || "".equals(dataId)) ? UUID.randomUUID().toString().replace("-", "") : dataId);
        return "stp/system/standardBase_view";
    }

    /**
     * 跳转至标准化列表页面
     *
     * @return
     */
    @RequestMapping(value = "/toListPage", method = {RequestMethod.GET})
    @OperationFilter(modelName = "标准化", actionName = "跳转列表页toListPage")
    public String toListPage() {
        return "stp/system/standardBase_list";
    }

    /**
     * 根据ID查询对象信息
     *
     * @param request
     * @return
     */
    @RequestMapping(value = "/getStandardBaseInfo")
    @OperationFilter(modelName = "标准化", actionName = "根据ID查询对象信息getstandardBaseInfo")
    @ResponseBody
    public Object getstandardBaseInfo(HttpServletRequest request) {
        String id = request.getParameter("id");
        ResponseEntity<StandardBase> responseEntity = this.restTemplate.exchange(GET_INFO + id, HttpMethod.POST, new HttpEntity<String>(this.httpHeaders), StandardBase.class);
        StandardBase news = responseEntity.getBody();
        return news;
    }

    @RequestMapping(value = "/tree-data")
    @ResponseBody
    @OperationFilter(modelName = "标准化", actionName = "树形查询getStandardBaseTreeData()")
    public Object getStandardBaseTreeData() throws Exception {
        TreeNode node = this.restTemplate.exchange(TREE_DATA, HttpMethod.POST, new HttpEntity<Object>(this.httpHeaders), TreeNode.class).getBody();
        return node;
    }

    @RequestMapping(value = "/tree-datas")
    @OperationFilter(modelName = "标准化", actionName = "树形查询getStandardBaseTreeData()")
    @ResponseBody
    public String getStandardBaseTreeDatas(HttpServletRequest request) throws Exception {
        this.httpHeaders.setContentType(MediaType.APPLICATION_JSON);
        List list = this.restTemplate.exchange(TREE_DATA, HttpMethod.POST, new HttpEntity<Object>(this.httpHeaders), List.class).getBody();
        return JSONUtils.toJSONString(list);
    }

    @OperationFilter(modelName = "删除标准化", actionName = "根据ID删除标准化")
    @RequestMapping(value = "/del", method = RequestMethod.POST)
    @ResponseBody
    public Object delStandardBase() throws Exception {
        Integer rs = this.restTemplate.exchange(DEL + request.getParameter("id"), HttpMethod.POST, new HttpEntity<Object>(this.httpHeaders), Integer.class).getBody();
        if (rs > 0) {
            return new Result(true, "操作成功！");
        } else {
            return new Result(false, "保存失败请重试！");
        }
    }

    @OperationFilter(modelName = "物理删除标准化", actionName = "根据ID物理删除标准化")
    @RequestMapping(value = "/del-real", method = RequestMethod.POST)
    @ResponseBody
    public Object delStandardBaseReal() throws Exception {
        Integer rs = this.restTemplate.exchange(DEL_REAL + request.getParameter("id"), HttpMethod.POST, new HttpEntity<Object>(this.httpHeaders), Integer.class).getBody();
        if (rs > 0) {
            return new Result(true, "操作成功！");
        } else {
            return new Result(false, "保存失败请重试！");
        }
    }

}