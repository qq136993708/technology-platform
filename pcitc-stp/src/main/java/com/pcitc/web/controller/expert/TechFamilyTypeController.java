package com.pcitc.web.controller.expert;

import com.alibaba.druid.support.json.JSONUtils;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.pcitc.base.common.Result;
import com.pcitc.base.expert.TechFamilyType;
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

/**
 * <p>控制类</p>
 * <p>Table: tech_family_type - 技术族-分类</p>
 *
 * @since 2018-12-29 11:34:35
 */


@Controller
@RequestMapping("techFamilyType")
public class TechFamilyTypeController extends BaseController {
    /**
     * 根据ID获取对象信息
     */
    private static final String GET_INFO = "http://pcitc-zuul/stp-proxy/techfamilytype-provider/techfamilytype/get-techfamilytype/";
    /**
     * 树形
     */
    private static final String TREE_DATA = "http://pcitc-zuul/stp-proxy/techfamilytype-provider/techfamilytype/tree-data";
    /**
     * 逻辑删除
     */
    private static final String DEL = "http://pcitc-zuul/stp-proxy/techfamilytype-provider/techfamilytype/del-techfamilytype/";
    /**
     * 物理删除
     */
    private static final String DEL_REAL = "http://pcitc-zuul/stp-proxy/techfamilytype-provider/techfamilytype/del-techfamilytype-real/";

    /**
     * 查询列表
     */
    private static final String LIST = "http://pcitc-zuul/stp-proxy/techfamilytype-provider/techfamilytype/techfamilytype_list";
    /**
     * 参数查询
     */
    private static final String LISTPARAM = "http://pcitc-zuul/stp-proxy/techfamilytype-provider/techfamilytype/techfamilytype_list_param";
    /**
     * 分页查询
     */
    private static final String LISTPAGE = "http://pcitc-zuul/stp-proxy/techfamilytype-provider/techfamilytype/techfamilytype-page";
    /**
     * 保存
     */
    private static final String SAVE = "http://pcitc-zuul/stp-proxy/techfamilytype-provider/techfamilytype/save_techfamilytype";


    /**
     * 技术族-分类-查询列表
     *
     * @param techFamilyType
     * @return
     */
    @RequestMapping(value = "/list", method = RequestMethod.POST)
    @ResponseBody
    @OperationFilter(modelName = "技术族-分类", actionName = "查询列表getList")
    public Object getList(@RequestBody TechFamilyType techFamilyType) {
        httpHeaders.setContentType(MediaType.APPLICATION_JSON);
        ResponseEntity<JSONObject> responseEntity = this.restTemplate.exchange(LIST, HttpMethod.POST, new HttpEntity<TechFamilyType>(techFamilyType, this.httpHeaders), JSONObject.class);
        JSONObject retJson = responseEntity.getBody();
        List<TechFamilyType> list = (List<TechFamilyType>) retJson.get("list");
        return list;
    }


    @RequestMapping(value = "/listParam", method = RequestMethod.POST)
    @ResponseBody
    @OperationFilter(modelName = "技术族-分类", actionName = "查询列表getListParam")
    public Object getListParam(@RequestParam String id) {
        httpHeaders.setContentType(MediaType.APPLICATION_FORM_URLENCODED);
        MultiValueMap<String, String> requestBody = new LinkedMultiValueMap<String, String>();
        requestBody.add("id", request.getParameter("id") + "");
        HttpEntity<MultiValueMap<String, String>> entity = new HttpEntity<MultiValueMap<String, String>>(requestBody, this.httpHeaders);
        ResponseEntity<JSONObject> responseEntity = this.restTemplate.exchange(LISTPARAM, HttpMethod.POST, entity, JSONObject.class);
        JSONObject retJson = responseEntity.getBody();
        List<TechFamilyType> list = (List<TechFamilyType>) retJson.get("list");
        return list;
    }

    /**
     * 技术族-分类-分页查询
     *
     * @param param
     * @return
     */
    @RequestMapping(value = "/getTableData", method = RequestMethod.POST)
    @ResponseBody
    @OperationFilter(modelName = "技术族-分类", actionName = "分页查询getTableData")
    public Object getTableData(@ModelAttribute("param") LayuiTableParam param) {
        HttpEntity<LayuiTableParam> entity = new HttpEntity<LayuiTableParam>(param, this.httpHeaders);
        ResponseEntity<LayuiTableData> responseEntity = this.restTemplate.exchange(LISTPAGE, HttpMethod.POST, entity, LayuiTableData.class);
        LayuiTableData data = responseEntity.getBody();
        return JSON.toJSON(data).toString();
    }

    /**
     * 保存-技术族-分类
     *
     * @param record
     * @return
     */
    @RequestMapping(value = "/saveTechFamilyType")
    @ResponseBody
    @OperationFilter(modelName = "技术族-分类", actionName = "保存saveRecord")
    public int saveRecord(TechFamilyType record) {
        httpHeaders.setContentType(MediaType.APPLICATION_JSON);
        if (record.getDataId() == null || "".equals(record.getDataId())) {
            record.setCreateDate(DateUtil.format(new Date(), DateUtil.FMT_SS));
            record.setCreateUser(sysUserInfo.getUserId());
        } else {
            record.setUpdateDate(DateUtil.format(new Date(), DateUtil.FMT_SS));
            record.setUpdateUser(sysUserInfo.getUserId());
        }
        record.setStatus("0");
        ResponseEntity<Integer> responseEntity = this.restTemplate.exchange(SAVE, HttpMethod.POST, new HttpEntity<TechFamilyType>(record, this.httpHeaders), Integer.class);
        Integer result = responseEntity.getBody();
        return result;
    }


    /**
     * 调整编辑页面-技术族-分类
     *
     * @param id
     * @param model
     * @return
     */
    @RequestMapping(method = RequestMethod.GET, value = "/edit")
    @OperationFilter(modelName = "技术族-分类", actionName = "跳转编辑页面pageEdit")
    public String pageEdit(String id, Model model, String opt,String parentId) {
        model.addAttribute("id", id);
        model.addAttribute("opt", opt);
        model.addAttribute("parentId",(parentId==null||"".equals(parentId))?"":parentId);
        return "stp/expert/techFamilyType_edit";
    }


    /**
     * 跳转至技术族-分类列表页面
     *
     * @return
     */
    @RequestMapping(value = "/toListPage", method = {RequestMethod.GET})
    @OperationFilter(modelName = "技术族-分类", actionName = "跳转列表页toListPage")
    public String toListPage() {
        return "stp/expert/techFamilyType_list";
    }

    /**
     * 根据ID查询对象信息
     *
     * @param request
     * @return
     */
    @RequestMapping(value = "/getTechFamilyTypeInfo")
    @OperationFilter(modelName = "技术族-分类", actionName = "根据ID查询对象信息gettechFamilyTypeInfo")
    @ResponseBody
    public Object gettechFamilyTypeInfo(HttpServletRequest request) {
        String id = request.getParameter("id");
        ResponseEntity<TechFamilyType> responseEntity = this.restTemplate.exchange(GET_INFO + id, HttpMethod.POST, new HttpEntity<String>(this.httpHeaders), TechFamilyType.class);
        TechFamilyType news = responseEntity.getBody();
        return news;
    }


    @RequestMapping(value = "/tree-data")
    @ResponseBody
    @OperationFilter(modelName = "技术族-分类", actionName = "树形查询getTechFamilyTypeTreeData()")
    public Object getTechFamilyTypeTreeData() throws Exception {
        TreeNode node = this.restTemplate.exchange(TREE_DATA, HttpMethod.POST, new HttpEntity<Object>(this.httpHeaders), TreeNode.class).getBody();
        return node;
    }

    @RequestMapping(value = "/tree-datas")
    @OperationFilter(modelName = "技术族-分类", actionName = "树形查询getTechFamilyTypeTreeData()")
    @ResponseBody
    public String getTechFamilyTypeTreeDatas(HttpServletRequest request) throws Exception {
        this.httpHeaders.setContentType(MediaType.APPLICATION_JSON);
        List list = this.restTemplate.exchange(TREE_DATA, HttpMethod.POST, new HttpEntity<Object>(this.httpHeaders), List.class).getBody();
        return JSONUtils.toJSONString(list);
    }


    @OperationFilter(modelName = "删除技术族-分类", actionName = "根据ID删除技术族-分类")
    @RequestMapping(value = "/del", method = RequestMethod.POST)
    @ResponseBody
    public Object delTechFamilyType() throws Exception {
        Integer rs = this.restTemplate.exchange(DEL + request.getParameter("id"), HttpMethod.POST, new HttpEntity<Object>(this.httpHeaders), Integer.class).getBody();
        if (rs > 0) {
            return new Result(true, "操作成功！");
        } else {
            return new Result(false, "保存失败请重试！");
        }
    }

    @OperationFilter(modelName = "物理删除技术族-分类", actionName = "根据ID物理删除技术族-分类")
    @RequestMapping(value = "/del-real", method = RequestMethod.POST)
    @ResponseBody
    public Object delTechFamilyTypeReal() throws Exception {
        Integer rs = this.restTemplate.exchange(DEL_REAL + request.getParameter("id"), HttpMethod.POST, new HttpEntity<Object>(this.httpHeaders), Integer.class).getBody();
        if (rs > 0) {
            return new Result(true, "操作成功！");
        } else {
            return new Result(false, "保存失败请重试！");
        }
    }

}