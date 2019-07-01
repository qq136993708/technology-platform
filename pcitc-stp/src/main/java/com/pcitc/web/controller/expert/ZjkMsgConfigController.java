package com.pcitc.web.controller.expert;

import com.alibaba.druid.support.json.JSONUtils;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.pcitc.base.common.Result;
import com.pcitc.base.expert.ZjkMsg;
import com.pcitc.base.expert.ZjkMsgConfig;
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
 * <p>Table: zjk_msg_config - 专家回复消息配置表</p>
 *
 * @since 2019-02-25 03:04:53
 */

@Controller
@RequestMapping("zjkMsgConfig")
public class ZjkMsgConfigController extends BaseController {
    /**
     * 根据ID获取对象信息
     */
    private static final String GET_INFO = "http://pcitc-zuul/stp-proxy/zjkmsgconfig-provider/zjkmsgconfig/get-zjkmsgconfig/";
    /**
     * 树形
     */
    private static final String TREE_DATA = "http://pcitc-zuul/stp-proxy/zjkmsgconfig-provider/zjkmsgconfig/tree-data";
    /**
     * 逻辑删除
     */
    private static final String DEL = "http://pcitc-zuul/stp-proxy/zjkmsgconfig-provider/zjkmsgconfig/del-zjkmsgconfig/";
    /**
     * 物理删除
     */
    private static final String DEL_REAL = "http://pcitc-zuul/stp-proxy/zjkmsgconfig-provider/zjkmsgconfig/del-zjkmsgconfig-real/";

    /**
     * 查询列表
     */
    private static final String LIST = "http://pcitc-zuul/stp-proxy/zjkmsgconfig-provider/zjkmsgconfig/zjkmsgconfig_list";
    /**
     * 参数查询
     */
    private static final String LISTPARAM = "http://pcitc-zuul/stp-proxy/zjkmsgconfig-provider/zjkmsgconfig/zjkmsgconfig_list_param";
    /**
     * 分页查询
     */
    private static final String LISTPAGE = "http://pcitc-zuul/stp-proxy/zjkmsgconfig-provider/zjkmsgconfig/zjkmsgconfig-page";
    /**
     * 保存
     */
    private static final String SAVE = "http://pcitc-zuul/stp-proxy/zjkmsgconfig-provider/zjkmsgconfig/save_zjkmsgconfig";

    /**
     * 专家回复消息配置表-查询列表
     *
     * @param zjkMsgConfig
     * @return
     */
    @RequestMapping(value = "/list", method = RequestMethod.POST)
    @ResponseBody
    public Object getList(@RequestBody ZjkMsgConfig zjkMsgConfig) {
        httpHeaders.setContentType(MediaType.APPLICATION_JSON);
        ResponseEntity<JSONObject> responseEntity = this.restTemplate.exchange(LIST, HttpMethod.POST, new HttpEntity<ZjkMsgConfig>(zjkMsgConfig, this.httpHeaders), JSONObject.class);
        JSONObject retJson = responseEntity.getBody();
        List<ZjkMsgConfig> list = (List<ZjkMsgConfig>) retJson.get("list");
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
        List<ZjkMsgConfig> list = (List<ZjkMsgConfig>) retJson.get("list");
        return list;
    }

    /**
     * 专家回复消息配置表-分页查询
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
     * 保存-专家回复消息配置表
     *
     * @param record
     * @return
     */
    @RequestMapping(value = "/saveZjkMsgConfig")
    @ResponseBody
    @OperationFilter(modelName = "专家回复消息配置表", actionName = "保存saveRecord")
    public int saveRecord(ZjkMsgConfig record) {
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
        ResponseEntity<Integer> responseEntity = this.restTemplate.exchange(SAVE, HttpMethod.POST, new HttpEntity<ZjkMsgConfig>(record, this.httpHeaders), Integer.class);
        Integer result = responseEntity.getBody();
        return result;
    }


    /**
     * 调整编辑页面-专家回复消息配置表
     *
     * @param id
     * @param model
     * @return
     */
    @RequestMapping(method = RequestMethod.GET, value = "/edit")
    @OperationFilter(modelName = "专家回复消息配置表", actionName = "跳转编辑页面pageEdit")
    public String pageEdit(String id, Model model, String opt) {
        model.addAttribute("id", id);
        model.addAttribute("opt", opt);
        return "stp/expert/zjkMsgConfig_edit";
    }

    @RequestMapping(method = RequestMethod.GET, value = "/zjkMsg_bat")
    @OperationFilter(modelName = "专家回复消息配置表", actionName = "跳转批量设置页面zjkMsg_bat")
    public String zjkMsg_bat(String ids, Model model, String opt) {
        model.addAttribute("ids", ids);
        return "stp/expert/zjkMsg_bat";
    }

    /**
     * 跳转至专家回复消息配置表列表页面
     *
     * @return
     */
    @RequestMapping(value = "/toListPage", method = {RequestMethod.GET})
    @OperationFilter(modelName = "专家回复消息配置表", actionName = "跳转列表页toListPage")
    public String toListPage() {
        return "stp/expert/zjkMsgConfig_list";
    }

    /**
     * 根据ID查询对象信息
     *
     * @param request
     * @return
     */
    @RequestMapping(value = "/getZjkMsgConfigInfo")
    @OperationFilter(modelName = "专家回复消息配置表", actionName = "根据ID查询对象信息getzjkMsgConfigInfo")
    @ResponseBody
    public Object getzjkMsgConfigInfo(HttpServletRequest request) {
        String id = request.getParameter("id");
        ResponseEntity<ZjkMsgConfig> responseEntity = this.restTemplate.exchange(GET_INFO + id, HttpMethod.POST, new HttpEntity<String>(this.httpHeaders), ZjkMsgConfig.class);
        ZjkMsgConfig news = responseEntity.getBody();
        return news;
    }

    @RequestMapping(value = "/tree-data")
    @ResponseBody
    @OperationFilter(modelName = "专家回复消息配置表", actionName = "树形查询getZjkMsgConfigTreeData()")
    public Object getZjkMsgConfigTreeData() throws Exception {
        TreeNode node = this.restTemplate.exchange(TREE_DATA, HttpMethod.POST, new HttpEntity<Object>(this.httpHeaders), TreeNode.class).getBody();
        return node;
    }

    @RequestMapping(value = "/tree-datas")
    @OperationFilter(modelName = "专家回复消息配置表", actionName = "树形查询getZjkMsgConfigTreeData()")
    @ResponseBody
    public String getZjkMsgConfigTreeDatas(HttpServletRequest request) throws Exception {
        this.httpHeaders.setContentType(MediaType.APPLICATION_JSON);
        List list = this.restTemplate.exchange(TREE_DATA, HttpMethod.POST, new HttpEntity<Object>(this.httpHeaders), List.class).getBody();
        return JSONUtils.toJSONString(list);
    }

    @OperationFilter(modelName = "删除专家回复消息配置表", actionName = "根据ID删除专家回复消息配置表")
    @RequestMapping(value = "/del", method = RequestMethod.POST)
    @ResponseBody
    public Object delZjkMsgConfig() throws Exception {
        Integer rs = this.restTemplate.exchange(DEL + request.getParameter("id"), HttpMethod.POST, new HttpEntity<Object>(this.httpHeaders), Integer.class).getBody();
        if (rs > 0) {
            return new Result(true, "操作成功！");
        } else {
            return new Result(false, "保存失败请重试！");
        }
    }

    @OperationFilter(modelName = "物理删除专家回复消息配置表", actionName = "根据ID物理删除专家回复消息配置表")
    @RequestMapping(value = "/del-real", method = RequestMethod.POST)
    @ResponseBody
    public Object delZjkMsgConfigReal() throws Exception {
        Integer rs = this.restTemplate.exchange(DEL_REAL + request.getParameter("id"), HttpMethod.POST, new HttpEntity<Object>(this.httpHeaders), Integer.class).getBody();
        if (rs > 0) {
            return new Result(true, "操作成功！");
        } else {
            return new Result(false, "保存失败请重试！");
        }
    }

}