package com.pcitc.web.controller.system;

import com.alibaba.druid.support.json.JSONUtils;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.pcitc.base.common.Result;
import com.pcitc.base.system.EmailTemplate;
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
 * <p>Table: email_template - 邮件模板</p>
 *
 * @since 2019-06-05 03:42:06
 */

@Controller
public class EmailTemplateController extends BaseController {
    /**
     * 根据ID获取对象信息
     */
    private static final String GET_INFO = "http://pcitc-zuul/stp-proxy/emailtemplate-provider/emailtemplate/get-emailtemplate/";
    /**
     * 树形
     */
    private static final String TREE_DATA = "http://pcitc-zuul/stp-proxy/emailtemplate-provider/emailtemplate/tree-data";
    /**
     * 逻辑删除
     */
    private static final String DEL = "http://pcitc-zuul/stp-proxy/emailtemplate-provider/emailtemplate/del-emailtemplate/";
    /**
     * 物理删除
     */
    private static final String DEL_REAL = "http://pcitc-zuul/stp-proxy/emailtemplate-provider/emailtemplate/del-emailtemplate-real/";

    /**
     * 查询列表
     */
    private static final String LIST = "http://pcitc-zuul/stp-proxy/emailtemplate-provider/emailtemplate/emailtemplate_list";
    /**
     * 参数查询
     */
    private static final String LISTPARAM = "http://pcitc-zuul/stp-proxy/emailtemplate-provider/emailtemplate/emailtemplate_list_param";
    /**
     * 分页查询
     */
    private static final String LISTPAGE = "http://pcitc-zuul/stp-proxy/emailtemplate-provider/emailtemplate/emailtemplate-page";
    /**
     * 保存
     */
    private static final String SAVE = "http://pcitc-zuul/stp-proxy/emailtemplate-provider/emailtemplate/save_emailtemplate";

    /**
     * 邮件模板-查询列表
     *
     * @param emailTemplate
     * @return
     */
    @RequestMapping(value = "/emailTemplate/list", method = RequestMethod.POST)
    @ResponseBody
    public Object getList(@RequestBody EmailTemplate emailTemplate) {
        httpHeaders.setContentType(MediaType.APPLICATION_JSON);
        ResponseEntity<JSONObject> responseEntity = this.restTemplate.exchange(LIST, HttpMethod.POST, new HttpEntity<EmailTemplate>(emailTemplate, this.httpHeaders), JSONObject.class);
        JSONObject retJson = responseEntity.getBody();
        List<EmailTemplate> list = (List<EmailTemplate>) retJson.get("list");
        return list;
    }

    @RequestMapping(value = "/emailTemplate/listParam", method = RequestMethod.POST)
    @ResponseBody
    public Object getListParam(@RequestParam String id) {
        httpHeaders.setContentType(MediaType.APPLICATION_FORM_URLENCODED);
        MultiValueMap<String, String> requestBody = new LinkedMultiValueMap<String, String>();
        requestBody.add("id", request.getParameter("id") + "");
        HttpEntity<MultiValueMap<String, String>> entity = new HttpEntity<MultiValueMap<String, String>>(requestBody, this.httpHeaders);
        ResponseEntity<JSONObject> responseEntity = this.restTemplate.exchange(LISTPARAM, HttpMethod.POST, entity, JSONObject.class);
        JSONObject retJson = responseEntity.getBody();
        List<EmailTemplate> list = (List<EmailTemplate>) retJson.get("list");
        return list;
    }

    /**
     * 邮件模板-分页查询
     *
     * @param param
     * @return
     */
    @RequestMapping(value = "/emailTemplate/getTableData", method = RequestMethod.POST)
    @ResponseBody
    public Object getTableData(@ModelAttribute("param") LayuiTableParam param) {
        HttpEntity<LayuiTableParam> entity = new HttpEntity<LayuiTableParam>(param, this.httpHeaders);
        ResponseEntity<LayuiTableData> responseEntity = this.restTemplate.exchange(LISTPAGE, HttpMethod.POST, entity, LayuiTableData.class);
        LayuiTableData data = responseEntity.getBody();
        return JSON.toJSON(data).toString();
    }

    /**
     * 保存-邮件模板
     *
     * @param record
     * @return
     */
    @RequestMapping(value = "/emailTemplate/saveEmailTemplate")
    @ResponseBody
    @OperationFilter(modelName = "邮件模板", actionName = "保存saveRecord")
    public int saveRecord(EmailTemplate record) {
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
        ResponseEntity<Integer> responseEntity = this.restTemplate.exchange(SAVE, HttpMethod.POST, new HttpEntity<EmailTemplate>(record, this.httpHeaders), Integer.class);
        Integer result = responseEntity.getBody();
        return result;
    }

    /**
     * 编辑页面-邮件模板
     *
     * @param id
     * @param model
     * @return
     */
    @RequestMapping(method = RequestMethod.GET, value = "/emailTemplate/edit")
    @OperationFilter(modelName = "邮件模板", actionName = "跳转编辑页面pageEdit")
    public String pageEdit(String id, Model model, String opt) {
        model.addAttribute("id", id);
        model.addAttribute("opt", opt);
        return "stp/system/emailTemplate_edit";
    }

    /**
     * 详情页面-邮件模板
     *
     * @param model
     * @return
     */
    @RequestMapping(method = RequestMethod.GET, value = "/emailTemplate/view/{dataId}")
    @OperationFilter(modelName = "邮件模板", actionName = "跳转详情页面pageView")
    public String pageView(@PathVariable("dataId") String dataId, Model model) {
        model.addAttribute("id", dataId);
        model.addAttribute("opt", "");
        model.addAttribute("dataId", (dataId == null || "".equals(dataId)) ? UUID.randomUUID().toString().replace("-", "") : dataId);
        return "stp/system/emailTemplate_view";
    }

    /**
     * 跳转至邮件模板列表页面
     *
     * @return
     */
    @RequestMapping(value = "/emailTemplate/toListPage", method = {RequestMethod.GET})
    @OperationFilter(modelName = "邮件模板", actionName = "跳转列表页toListPage")
    public String toListPage() {
        return "stp/system/emailTemplate_list";
    }

    /**
     * 根据ID查询对象信息
     *
     * @param request
     * @return
     */
    @RequestMapping(value = "/emailTemplate/getEmailTemplateInfo")
    @OperationFilter(modelName = "邮件模板", actionName = "根据ID查询对象信息getemailTemplateInfo")
    @ResponseBody
    public Object getemailTemplateInfo(HttpServletRequest request) {
        String id = request.getParameter("id");
        ResponseEntity<EmailTemplate> responseEntity = this.restTemplate.exchange(GET_INFO + id, HttpMethod.POST, new HttpEntity<String>(this.httpHeaders), EmailTemplate.class);
        EmailTemplate news = responseEntity.getBody();
        return news;
    }

    @RequestMapping(value = "/emailTemplate/tree-data")
    @ResponseBody
    @OperationFilter(modelName = "邮件模板", actionName = "树形查询getEmailTemplateTreeData()")
    public Object getEmailTemplateTreeData() throws Exception {
        TreeNode node = this.restTemplate.exchange(TREE_DATA, HttpMethod.POST, new HttpEntity<Object>(this.httpHeaders), TreeNode.class).getBody();
        return node;
    }

    @RequestMapping(value = "/emailTemplate/tree-datas")
    @OperationFilter(modelName = "邮件模板", actionName = "树形查询getEmailTemplateTreeData()")
    @ResponseBody
    public String getEmailTemplateTreeDatas(HttpServletRequest request) throws Exception {
        this.httpHeaders.setContentType(MediaType.APPLICATION_JSON);
        List list = this.restTemplate.exchange(TREE_DATA, HttpMethod.POST, new HttpEntity<Object>(this.httpHeaders), List.class).getBody();
        return JSONUtils.toJSONString(list);
    }

    @OperationFilter(modelName = "删除邮件模板", actionName = "根据ID删除邮件模板")
    @RequestMapping(value = "/emailTemplate/del", method = RequestMethod.POST)
    @ResponseBody
    public Object delEmailTemplate() throws Exception {
        Integer rs = this.restTemplate.exchange(DEL + request.getParameter("id"), HttpMethod.POST, new HttpEntity<Object>(this.httpHeaders), Integer.class).getBody();
        if (rs > 0) {
            return new Result(true, "操作成功！");
        } else {
            return new Result(false, "保存失败请重试！");
        }
    }

    @OperationFilter(modelName = "物理删除邮件模板", actionName = "根据ID物理删除邮件模板")
    @RequestMapping(value = "/emailTemplate/del-real", method = RequestMethod.POST)
    @ResponseBody
    public Object delEmailTemplateReal() throws Exception {
        Integer rs = this.restTemplate.exchange(DEL_REAL + request.getParameter("id"), HttpMethod.POST, new HttpEntity<Object>(this.httpHeaders), Integer.class).getBody();
        if (rs > 0) {
            return new Result(true, "操作成功！");
        } else {
            return new Result(false, "保存失败请重试！");
        }
    }

}