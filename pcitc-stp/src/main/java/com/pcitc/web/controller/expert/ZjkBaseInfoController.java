package com.pcitc.web.controller.expert;

import com.alibaba.druid.support.json.JSONUtils;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.pcitc.base.common.Result;
import com.pcitc.base.expert.ZjkExpert;
import com.pcitc.base.common.LayuiTableData;
import com.pcitc.base.common.LayuiTableParam;
import com.pcitc.base.workflow.WorkflowVo;
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

import java.util.*;

/**
 * <p>控制类</p>
 * <p>Table: zjk_base_info - 专家-基本信息</p>
 *
 * @since 2018-12-08 04:10:36
 */


@Controller
@RequestMapping("zjkBaseInfo")
public class ZjkBaseInfoController extends BaseController {
    /**
     * 根据ID获取对象信息
     */
    private static final String GET_INFO = "http://pcitc-zuul/stp-proxy/zjkbaseinfo-provider/zjkbaseinfo/get-zjkbaseinfo/";
    /**
     * 树形
     */
    private static final String TREE_DATA = "http://pcitc-zuul/stp-proxy/zjkbaseinfo-provider/zjkbaseinfo/tree-data";
    /**
     * 逻辑删除
     */
    private static final String DEL = "http://pcitc-zuul/stp-proxy/zjkbaseinfo-provider/zjkbaseinfo/del-zjkbaseinfo/";

    private static final String updateAuditStatus = "http://pcitc-zuul/stp-proxy/zjkbaseinfo-provider/zjkbaseinfo/updateAuditStatus/";
    /**
     * 物理删除
     */
    private static final String DEL_REAL = "http://pcitc-zuul/stp-proxy/zjkbaseinfo-provider/zjkbaseinfo/del-zjkbaseinfo-real/";

    /**
     * 查询列表
     */
    private static final String LIST = "http://pcitc-zuul/stp-proxy/zjkbaseinfo-provider/zjkbaseinfo/zjkbaseinfo_list";
    /**
     * 参数查询
     */
    private static final String LISTPARAM = "http://pcitc-zuul/stp-proxy/zjkbaseinfo-provider/zjkbaseinfo/zjkbaseinfo_list_param";
    /**
     * 分页查询
     */
    private static final String LISTPAGE = "http://pcitc-zuul/stp-proxy/zjkbaseinfo-provider/zjkbaseinfo/zjkbaseinfo-page";
    /**
     * 保存
     */
    private static final String SAVE = "http://pcitc-zuul/stp-proxy/zjkbaseinfo-provider/zjkbaseinfo/save_zjkbaseinfo";


    /**
     * 专家-基本信息-查询列表
     *
     * @param zjkBaseInfo
     * @return
     */
    @RequestMapping(value = "/list", method = RequestMethod.POST)
    @ResponseBody
    @OperationFilter(modelName = "专家-基本信息", actionName = "查询列表getList")
    public Object getList(@RequestBody ZjkExpert zjkBaseInfo) {
        httpHeaders.setContentType(MediaType.APPLICATION_JSON);
        ResponseEntity<JSONObject> responseEntity = this.restTemplate.exchange(LIST, HttpMethod.POST, new HttpEntity<ZjkExpert>(zjkBaseInfo, this.httpHeaders), JSONObject.class);
        JSONObject retJson = responseEntity.getBody();
        List<ZjkExpert> list = (List<ZjkExpert>) retJson.get("list");
        return list;
    }


    @RequestMapping(value = "/listParam", method = RequestMethod.POST)
    @ResponseBody
    @OperationFilter(modelName = "专家-基本信息", actionName = "查询列表getListParam")
    public Object getListParam(@RequestParam String id) {
        httpHeaders.setContentType(MediaType.APPLICATION_FORM_URLENCODED);
        MultiValueMap<String, String> requestBody = new LinkedMultiValueMap<String, String>();
        requestBody.add("id", request.getParameter("id") + "");
        HttpEntity<MultiValueMap<String, String>> entity = new HttpEntity<MultiValueMap<String, String>>(requestBody, this.httpHeaders);
        ResponseEntity<JSONObject> responseEntity = this.restTemplate.exchange(LISTPARAM, HttpMethod.POST, entity, JSONObject.class);
        JSONObject retJson = responseEntity.getBody();
        List<ZjkExpert> list = (List<ZjkExpert>) retJson.get("list");
        return list;
    }

    /**
     * 专家-基本信息-分页查询
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
        System.out.println(JSON.toJSON(data).toString());
        return JSON.toJSON(data).toString();
    }

    /**
     * 保存-专家-基本信息
     *
     * @param record
     * @return
     */
    @RequestMapping(value = "/saveZjkBaseInfo")
    @ResponseBody
    @OperationFilter(modelName = "专家-基本信息", actionName = "保存saveRecord")
    public int saveRecord(ZjkExpert record) {
        httpHeaders.setContentType(MediaType.APPLICATION_JSON);
        if (record.getId() == null || "".equals(record.getId())) {
            record.setCreateDate(DateUtil.format(new Date(), DateUtil.FMT_SS));
            record.setCreateUser(sysUserInfo.getUserId());
            record.setCreateUserDisp(sysUserInfo.getUserName());
        } else {
            record.setUpdateDate(DateUtil.format(new Date(), DateUtil.FMT_SS));
            record.setUpdatePersonName(sysUserInfo.getUserId());
        }
        record.setStatus("0");
        ResponseEntity<Integer> responseEntity = this.restTemplate.exchange(SAVE, HttpMethod.POST, new HttpEntity<ZjkExpert>(record, this.httpHeaders), Integer.class);
        Integer result = responseEntity.getBody();
        return result;
    }

    // 流程启动接口,多步审批
    @RequestMapping(value = "/workflow/start-flow2", method = RequestMethod.POST)
    @ResponseBody
    @OperationFilter(modelName = "系统管理", actionName = "启动工作流程（测试）")
    public Result startFlow2(@RequestBody String param, HttpServletRequest request) {
        System.out.println("=====/workflow/start-flow2");
        JSONObject json = JSONObject.parseObject(param);
        String businessId = json.getString("dataId");
        WorkflowVo workflowVo = new WorkflowVo();
        workflowVo.setBusinessId(businessId);
        workflowVo.setProcessInstanceName("专家库注册");
        workflowVo.setAuthenticatedUserId(sysUserInfo.getUserId());

        // 不清楚此功能菜单要走的审批流程。可以通过菜单id（functionId），部门/组织ID（orgId），项目id（projectId）。其中菜单id必填（和ProcessDefineId两选一）
        workflowVo.setFunctionId(json.getString("functionId"));
        // workflowVo.setUnitId("");
        // workflowVo.setProjectId("");

        Map<String, Object> variables = new HashMap<String, Object>();

        // 发起人之后的审批环节，如果是需要选择审批人的话，此处获取选择的userIds赋值给auditor变量
        if (json.getString("userIds") != null && !json.getString("userIds").equals("")) {
            String[] userIds = json.getString("userIds").split(",");
            variables.put("auditor", Arrays.asList(userIds));
        }

        // 必须设置，统一流程待办任务中需要的业务详情
        variables.put("auditDetailsPath", "/zjkBaseInfo/view/" + businessId);

        // 流程完全审批通过时，调用的方法
        variables.put("auditAgreeMethod", "http://pcitc-zuul/stp-proxy/zjkbaseinfo-provider/zjkbaseinfo/updateAuditStatus?dataId="+"agree_"+businessId );

        // 流程驳回时，调用的方法（可能驳回到第一步，也可能驳回到第1+n步
        variables.put("auditRejectMethod", "http://pcitc-zuul/stp-proxy/zjkbaseinfo-provider/zjkbaseinfo/updateAuditStatus?dataId="+"reject_"+businessId );

        // 对流程中出现的多个判断条件，比如money>100等，需要把事先把money条件输入
//        variables.put("money", 50); // 环节1需要用到
//        variables.put("departmentCode", "1005"); // 环节2需要用到
//        variables.put("companyCode", "2006"); // 环节n需要用到

        workflowVo.setVariables(variables);
        ResponseEntity<String> status = this.restTemplate.exchange(START_WORKFLOW_URL, HttpMethod.POST, new HttpEntity<WorkflowVo>(workflowVo, this.httpHeaders), String.class);
        if (status.getBody() != null && status.getBody().equals("true")) {
            System.out.println("=================启动成功");
            return new Result(true, "启动成功");
        } else {
            System.out.println("=================启动失败");
            return new Result(false, "启动失败");
        }

    }

    /**
     * 专家详情
     *
     * @param dataId
     * @param model
     * @return
     */
    @RequestMapping(method = RequestMethod.GET, value = "/view/{dataId}")
    @OperationFilter(modelName = "专家-基本信息", actionName = "跳转编辑页面pageEdit")
    public String pageView(@PathVariable("dataId") String dataId,Model model) {
        model.addAttribute("id", dataId);
        model.addAttribute("opt", "");
        model.addAttribute("dataId", (dataId==null||"".equals(dataId))?UUID.randomUUID().toString().replace("-",""):dataId);
        return "stp/expert/zjkExpert_view";
    }

    private static final String START_WORKFLOW_URL = "http://pcitc-zuul/system-proxy/workflow-provider/workflow/start";


    /**
     * 调整编辑页面-专家-基本信息
     *
     * @param id
     * @param model
     * @return
     */
    @RequestMapping(method = RequestMethod.GET, value = "/edit")
    @OperationFilter(modelName = "专家-基本信息", actionName = "跳转编辑页面pageEdit")
    public String pageEdit(String id, Model model, String opt) {
        model.addAttribute("id", id);
        model.addAttribute("opt", opt);
//        return "stp/expert/zjkBaseInfo_edit";
        model.addAttribute("dataId", (id==null||"".equals(id))?UUID.randomUUID().toString().replace("-",""):id);
        return "stp/expert/zjkExpert_edit";
    }




    /**
     * 跳转至专家-基本信息列表页面
     *
     * @return
     */
    @RequestMapping(value = "/toListPage", method = {RequestMethod.GET})
    @OperationFilter(modelName = "专家-基本信息", actionName = "跳转列表页toListPage")
    public String toListPage() {
        return "stp/expert/zjkBaseInfo_list";
    }

    /**
     * 根据ID查询对象信息
     *
     * @param request
     * @return
     */
    @RequestMapping(value = "/getZjkBaseInfoInfo")
    @OperationFilter(modelName = "专家-基本信息", actionName = "根据ID查询对象信息getzjkBaseInfoInfo")
    @ResponseBody
    public Object getzjkBaseInfoInfo(HttpServletRequest request) {
        String id = request.getParameter("id");
        ResponseEntity<ZjkExpert> responseEntity = this.restTemplate.exchange(GET_INFO + id, HttpMethod.POST, new HttpEntity<String>(this.httpHeaders), ZjkExpert.class);
        ZjkExpert news = responseEntity.getBody();
        return news;
    }


    @RequestMapping(value = "/tree-data")
    @ResponseBody
    @OperationFilter(modelName = "专家-基本信息", actionName = "树形查询getZjkBaseInfoTreeData()")
    public Object getZjkBaseInfoTreeData() throws Exception {
        TreeNode node = this.restTemplate.exchange(TREE_DATA, HttpMethod.POST, new HttpEntity<Object>(this.httpHeaders), TreeNode.class).getBody();
        return node;
    }

    @RequestMapping(value = "/tree-datas")
    @OperationFilter(modelName = "专家-基本信息", actionName = "树形查询getZjkBaseInfoTreeData()")
    @ResponseBody
    public String getZjkBaseInfoTreeDatas(HttpServletRequest request) throws Exception {
        this.httpHeaders.setContentType(MediaType.APPLICATION_JSON);
        List list = this.restTemplate.exchange(TREE_DATA, HttpMethod.POST, new HttpEntity<Object>(this.httpHeaders), List.class).getBody();
        return JSONUtils.toJSONString(list);
    }


    @OperationFilter(modelName = "删除专家-基本信息", actionName = "根据ID删除专家-基本信息")
    @RequestMapping(value = "/del", method = RequestMethod.POST)
    @ResponseBody
    public Object delZjkBaseInfo() throws Exception {
        Integer rs = this.restTemplate.exchange(DEL + request.getParameter("id"), HttpMethod.POST, new HttpEntity<Object>(this.httpHeaders), Integer.class).getBody();
        if (rs > 0) {
            return new Result(true, "操作成功！");
        } else {
            return new Result(false, "保存失败请重试！");
        }
    }

    @OperationFilter(modelName = "专家审批-基本信息", actionName = "根据ID更新专家审批状态-基本信息")
    @RequestMapping(value = "/updateAuditStatus/{dataId}", method = RequestMethod.GET)
    @ResponseBody
    public Object updateAuditStatus(@PathVariable("dataId") String dataId) throws Exception {
        System.out.println("dataId = " + dataId);
        Integer rs = this.restTemplate.exchange(updateAuditStatus + dataId, HttpMethod.POST, new HttpEntity<Object>(this.httpHeaders), Integer.class).getBody();
        if (rs > 0) {
            return new Result(true, "操作成功！");
        } else {
            return new Result(false, "保存失败请重试！");
        }
    }

    @OperationFilter(modelName = "物理删除专家-基本信息", actionName = "根据ID物理删除专家-基本信息")
    @RequestMapping(value = "/del-real", method = RequestMethod.POST)
    @ResponseBody
    public Object delZjkBaseInfoReal() throws Exception {
        Integer rs = this.restTemplate.exchange(DEL_REAL + request.getParameter("id"), HttpMethod.POST, new HttpEntity<Object>(this.httpHeaders), Integer.class).getBody();
        if (rs > 0) {
            return new Result(true, "操作成功！");
        } else {
            return new Result(false, "保存失败请重试！");
        }
    }

}