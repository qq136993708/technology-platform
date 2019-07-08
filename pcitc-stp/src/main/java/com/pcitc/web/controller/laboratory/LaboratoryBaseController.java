package com.pcitc.web.controller.laboratory;

import java.util.Date;
import java.util.List;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.druid.support.json.JSONUtils;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.pcitc.base.common.LayuiTableData;
import com.pcitc.base.common.LayuiTableParam;
import com.pcitc.base.common.Result;
import com.pcitc.base.common.TreeNode;
import com.pcitc.base.laboratory.LaboratoryBase;
import com.pcitc.base.util.DateUtil;
import com.pcitc.web.common.BaseController;
import com.pcitc.web.common.OperationFilter;

/**
 * <p>控制类</p>
 * <p>Table: laboratory_base - 实验室-基本情况</p>
 *
 * @since 2019-07-01 09:11:30
 */

@Controller
public class LaboratoryBaseController extends BaseController {
    /**
     * 根据ID获取对象信息
     */
    private static final String GET_INFO = "http://pcitc-zuul/stp-proxy/laboratorybase-provider/laboratorybase/get-laboratorybase/";
    /**
     * 树形
     */
    private static final String TREE_DATA = "http://pcitc-zuul/stp-proxy/laboratorybase-provider/laboratorybase/tree-data";
    /**
     * 逻辑删除
     */
    private static final String DEL = "http://pcitc-zuul/stp-proxy/laboratorybase-provider/laboratorybase/del-laboratorybase/";
    /**
     * 物理删除
     */
    private static final String DEL_REAL = "http://pcitc-zuul/stp-proxy/laboratorybase-provider/laboratorybase/del-laboratorybase-real/";

    /**
     * 查询列表
     */
    private static final String LIST = "http://pcitc-zuul/stp-proxy/laboratorybase-provider/laboratorybase/laboratorybase_list";
    /**
     * 参数查询
     */
    private static final String LISTPARAM = "http://pcitc-zuul/stp-proxy/laboratorybase-provider/laboratorybase/laboratorybase_list_param";
    /**
     * 分页查询
     */
    private static final String LISTPAGE = "http://pcitc-zuul/stp-proxy/laboratorybase-provider/laboratorybase/laboratorybase-page";
    /**
     * 保存
     */
    private static final String SAVE = "http://pcitc-zuul/stp-proxy/laboratorybase-provider/laboratorybase/save_laboratorybase";

    /**
    *
    * @param laboratoryBase
    * @return
    */
   @RequestMapping(method = RequestMethod.GET, value = "/laboratoryBase/laboratoryBaseDetails/{dataId}")
   public Object toLaboratoryBaseDetails(@PathVariable("dataId") String dataId) {
	   ResponseEntity<JSONObject> responseEntity = this.restTemplate.exchange(GET_INFO+dataId, HttpMethod.POST, new HttpEntity<Object>(this.httpHeaders), JSONObject.class);
       JSONObject retJson = responseEntity.getBody();
       request.setAttribute("laboratoryBase", retJson);
       return "/stp/laboratory/laboratoryBaseDetails";
   }
   @RequestMapping(method = RequestMethod.GET, value = "/laboratoryBase/laboratoryBaseMain")
   public Object toLaboratoryBaseMain() {
       return "/stp/laboratory/laboratoryBaseMain";
   }
    /**
     * 实验室-基本情况-查询列表
     *
     * @param laboratoryBase
     * @return
     */
    @RequestMapping(value = "/laboratoryBase/list", method = RequestMethod.POST)
    @ResponseBody
    public Object getList(@RequestBody LaboratoryBase laboratoryBase) {
        httpHeaders.setContentType(MediaType.APPLICATION_JSON);
        ResponseEntity<JSONObject> responseEntity = this.restTemplate.exchange(LIST, HttpMethod.POST, new HttpEntity<LaboratoryBase>(laboratoryBase, this.httpHeaders), JSONObject.class);
        JSONObject retJson = responseEntity.getBody();
        return retJson.get("list");
    }
    /**
     *
     * @param laboratoryBase
     * @return
     */
    @RequestMapping(value = "/laboratoryBase/listByBak1", method = RequestMethod.POST)
    @ResponseBody
    public Object getListByBak1(@ModelAttribute("laboratoryBase") LaboratoryBase laboratoryBase) {
        ResponseEntity<JSONObject> responseEntity = this.restTemplate.exchange(LIST, HttpMethod.POST, new HttpEntity<LaboratoryBase>(laboratoryBase, this.httpHeaders), JSONObject.class);
        JSONObject retJson = responseEntity.getBody();
        return retJson.get("list");
    }
    

    @RequestMapping(value = "/laboratoryBase/listParam", method = RequestMethod.POST)
    @ResponseBody
    public Object getListParam(@RequestParam String id) {
        httpHeaders.setContentType(MediaType.APPLICATION_FORM_URLENCODED);
        MultiValueMap<String, String> requestBody = new LinkedMultiValueMap<String, String>();
        requestBody.add("id", request.getParameter("id") + "");
        HttpEntity<MultiValueMap<String, String>> entity = new HttpEntity<MultiValueMap<String, String>>(requestBody, this.httpHeaders);
        ResponseEntity<JSONObject> responseEntity = this.restTemplate.exchange(LISTPARAM, HttpMethod.POST, entity, JSONObject.class);
        JSONObject retJson = responseEntity.getBody();
        return retJson.get("list");
    }

    /**
     * 实验室-基本情况-分页查询
     *
     * @param param
     * @return
     */
    @RequestMapping(value = "/laboratoryBase/getTableData", method = RequestMethod.POST)
    @ResponseBody
    public Object getTableData(@ModelAttribute("param") LayuiTableParam param) {
        HttpEntity<LayuiTableParam> entity = new HttpEntity<LayuiTableParam>(param, this.httpHeaders);
        ResponseEntity<LayuiTableData> responseEntity = this.restTemplate.exchange(LISTPAGE, HttpMethod.POST, entity, LayuiTableData.class);
        LayuiTableData data = responseEntity.getBody();
        return JSON.toJSON(data).toString();
    }

    /**
     * 保存-实验室-基本情况
     *
     * @param record
     * @return
     */
    @RequestMapping(value = "/laboratoryBase/saveLaboratoryBase")
    @ResponseBody
    @OperationFilter(modelName = "实验室-基本情况", actionName = "保存saveRecord")
    public int saveRecord(LaboratoryBase record) {
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
        ResponseEntity<Integer> responseEntity = this.restTemplate.exchange(SAVE, HttpMethod.POST, new HttpEntity<LaboratoryBase>(record, this.httpHeaders), Integer.class);
        Integer result = responseEntity.getBody();
        return result;
    }

    /**
     * 编辑页面-实验室-基本情况
     *
     * @param id
     * @param model
     * @return
     */
    @RequestMapping(method = RequestMethod.GET, value = "/laboratoryBase/edit")
    @OperationFilter(modelName = "实验室-基本情况", actionName = "跳转编辑页面pageEdit")
    public String pageEdit(String id, Model model, String opt) {
        model.addAttribute("id", id);
        model.addAttribute("opt", opt);
        return "stp/laboratory/laboratoryBase_edit";
    }

    /**
     * 详情页面-实验室-基本情况
     *
     * @param model
     * @return
     */
    @RequestMapping(method = RequestMethod.GET, value = "/laboratoryBase/view/{dataId}")
    @OperationFilter(modelName = "实验室-基本情况", actionName = "跳转详情页面pageView")
    public String pageView(@PathVariable("dataId") String dataId, Model model) {
        model.addAttribute("id", dataId);
        model.addAttribute("opt", "");
        model.addAttribute("dataId", (dataId == null || "".equals(dataId)) ? UUID.randomUUID().toString().replace("-", "") : dataId);
        return "stp/laboratory/laboratoryBase_view";
    }

    /**
     * 跳转至实验室-基本情况列表页面
     *
     * @return
     */
    @RequestMapping(value = "/laboratoryBase/toListPage", method = {RequestMethod.GET})
    @OperationFilter(modelName = "实验室-基本情况", actionName = "跳转列表页toListPage")
    public String toListPage() {
        return "stp/laboratory/laboratoryBase_list";
    }

    /**
     * 根据ID查询对象信息
     *
     * @param request
     * @return
     */
    @RequestMapping(value = "/laboratoryBase/getLaboratoryBaseInfo")
    @OperationFilter(modelName = "实验室-基本情况", actionName = "根据ID查询对象信息getlaboratoryBaseInfo")
    @ResponseBody
    public Object getlaboratoryBaseInfo(HttpServletRequest request) {
        String id = request.getParameter("id");
        ResponseEntity<LaboratoryBase> responseEntity = this.restTemplate.exchange(GET_INFO + id, HttpMethod.POST, new HttpEntity<String>(this.httpHeaders), LaboratoryBase.class);
        LaboratoryBase news = responseEntity.getBody();
        return news;
    }

    @RequestMapping(value = "/laboratoryBase/tree-data")
    @ResponseBody
    @OperationFilter(modelName = "实验室-基本情况", actionName = "树形查询getLaboratoryBaseTreeData()")
    public Object getLaboratoryBaseTreeData() throws Exception {
        TreeNode node = this.restTemplate.exchange(TREE_DATA, HttpMethod.POST, new HttpEntity<Object>(this.httpHeaders), TreeNode.class).getBody();
        return node;
    }

    @RequestMapping(value = "/laboratoryBase/tree-datas")
    @OperationFilter(modelName = "实验室-基本情况", actionName = "树形查询getLaboratoryBaseTreeData()")
    @ResponseBody
    public String getLaboratoryBaseTreeDatas(HttpServletRequest request) throws Exception {
        this.httpHeaders.setContentType(MediaType.APPLICATION_JSON);
        List<?> list = this.restTemplate.exchange(TREE_DATA, HttpMethod.POST, new HttpEntity<Object>(this.httpHeaders), List.class).getBody();
        return JSONUtils.toJSONString(list);
    }

    @OperationFilter(modelName = "删除实验室-基本情况", actionName = "根据ID删除实验室-基本情况")
    @RequestMapping(value = "/laboratoryBase/del", method = RequestMethod.POST)
    @ResponseBody
    public Object delLaboratoryBase() throws Exception {
        Integer rs = this.restTemplate.exchange(DEL + request.getParameter("id"), HttpMethod.POST, new HttpEntity<Object>(this.httpHeaders), Integer.class).getBody();
        if (rs > 0) {
            return new Result(true, "操作成功！");
        } else {
            return new Result(false, "保存失败请重试！");
        }
    }

    @OperationFilter(modelName = "物理删除实验室-基本情况", actionName = "根据ID物理删除实验室-基本情况")
    @RequestMapping(value = "/laboratoryBase/del-real", method = RequestMethod.POST)
    @ResponseBody
    public Object delLaboratoryBaseReal() throws Exception {
        Integer rs = this.restTemplate.exchange(DEL_REAL + request.getParameter("id"), HttpMethod.POST, new HttpEntity<Object>(this.httpHeaders), Integer.class).getBody();
        if (rs > 0) {
            return new Result(true, "操作成功！");
        } else {
            return new Result(false, "保存失败请重试！");
        }
    }

}