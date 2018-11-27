package com.pcitc.web.controller.plan;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.pcitc.base.common.LayuiTableData;
import com.pcitc.base.common.LayuiTableParam;
import com.pcitc.base.plan.PlanBase;
import com.pcitc.base.plan.PlanBaseDetail;
import com.pcitc.base.util.CodeUtil;
import com.pcitc.base.util.CommonUtil;
import com.pcitc.base.util.DataTableInfoVo;
import com.pcitc.base.util.DateUtil;
import com.pcitc.web.common.BaseController;
import com.pcitc.web.utils.PageCommon;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.*;

@Controller
@RequestMapping("/plan")
public class PlanController extends BaseController {

    private String basePath;
    private static final String BOT_WORK_ORDER_LIST = "http://pcitc-zuul/system-proxy/PlanClient-provider/botWorkOrder_list";
    // 保存新增
    private static final String SAVE_BOT_WORK_ORDER = "http://pcitc-zuul/system-proxy/PlanClient-provider/saveBotWorkOrder";
    // 删除
    private static final String DELETE_BOT_WORK_ORDER = "http://pcitc-zuul/system-proxy/PlanClient-provider/deleteBotWorkOrder/";
    // 修改
    private static final String EDIT_BOT_WORK_ORDER = "http://pcitc-zuul/system-proxy/PlanClient-provider/editBotWorkOrder";
    // 查询
    private static final String VIEW_BOT_WORK_ORDER = "http://pcitc-zuul/system-proxy/PlanClient-provider/viewBotWorkOrder/";
    // 提交
    private static final String AFFIRM_BOT_WORK_ORDER = "http://pcitc-zuul/system-proxy/PlanClient-provider/affirmBotWorkOrder/";
    // 提交
    private static final String SUBMIT_BOT_WORK_ORDER = "http://pcitc-zuul/system-proxy/PlanClient-provider/submitBotWorkOrder/";
    // 批量保存工单事项
    private static final String SAVE_BOT_WORK_ORDER_MATTER_BATCH = "http://pcitc-zuul/system-proxy/PlanClient-provider/saveBotWorkOrderMatterBatch";

    //批量保存任务
    private static final String SAVE_PLAN_BASE_BATCH = "http://pcitc-zuul/system-proxy/PlanClient-provider/savePlanBaseBatch";
    //转发修改子节点
    private static final String SAVE_PLAN_BASE_BATCHZF = "http://pcitc-zuul/system-proxy/PlanClient-provider/savePlanBaseBatchZf";
    // 查看工单事项集合
    private static final String VIEW_BOT_WORK_ORDER_MATTER_LIST = "http://pcitc-zuul/system-proxy/PlanClient-provider/queryBotWorkOrderMatterList";

    //我的工单
    private static final String MY_BOT_WORK_ORDER_LIST = "http://pcitc-zuul/system-proxy/PlanClient-provider/my/botWorkOrder_list";
    // 查看我的工单事项反馈集合
    private static final String VIEW_MY_BOT_WORK_ORDER_MATTER_LIST = "http://pcitc-zuul/system-proxy/PlanClient-provider/queryMyBotWorkOrderMatterList";
    // 批量保存工单事项
    private static final String SAVE_MY_BOT_WORK_ORDER_MATTER_BATCH = "http://pcitc-zuul/system-proxy/PlanClient-provider/saveMyBotWorkOrderMatterBatch";
    // 提交
    private static final String SUBMIT_MY_BOT_WORK_ORDER = "http://pcitc-zuul/system-proxy/PlanClient-provider/submitMyBotWorkOrder/";

    //查询用户信息
    private static final String USER_LIST_PAGE_URL = "http://pcitc-zuul/system-proxy/user-provider/user/user-list";
    // 组织机构查询（回写）
    private static final String UNIT_LIST = "http://pcitc-zuul/system-proxy/unit-provider/unit-list";
    // 岗位信息查询（回写）
    private static final String GET_POST_LIST = "http://pcitc-zuul/system-proxy/post-provider/post/list-data";

    /**
     * 用户选择:页面跳转
     * @param request
     * @return
     */
    @RequestMapping(method = RequestMethod.GET, value = "/pageSelectUser")
    private String pageSelectUser(HttpServletRequest request) {
        return "stp/plan/pageSelectUser";
    }

    /**
     * 用户信息弹出选择
     * @param param
     * @param request
     * @return
     * @throws IOException
     */
    @RequestMapping(value = "/user/user-list")
    @ResponseBody
    public Object getUserList(@ModelAttribute("param") LayuiTableParam param, HttpServletRequest request) throws IOException {
        // System.out.print("userId:"+this.sysUser.getUserId());
        HttpEntity<LayuiTableParam> entity = new HttpEntity<LayuiTableParam>(param, this.httpHeaders);
        ResponseEntity<LayuiTableData> responseEntity = this.restTemplate.exchange(USER_LIST_PAGE_URL, HttpMethod.POST, entity, LayuiTableData.class);
        LayuiTableData data = responseEntity.getBody();
        // 用户类型回写
        String parentCode = "ROOT_XTGL_YHLX"; // 字典编码
        String writebackField = "userKind"; // 回写字段
        JSONObject dataObject = (JSONObject) JSON.toJSON(data);
        PageCommon pageCommon = new PageCommon();
        pageCommon.getDictionaryWriteback(this.restTemplate, this.httpHeaders, dataObject, parentCode, writebackField);

        // 域用户回写
        parentCode = "ROOT_XTGL_YYH"; // 字典编码
        writebackField = "isDomain"; // 回写字段
        pageCommon.getDictionaryWriteback(this.restTemplate, this.httpHeaders, dataObject, parentCode, writebackField);

        // 机构
        writebackField = "userUnit"; // 回写字段
        DataTableInfoVo tableInfo = new DataTableInfoVo();
        tableInfo.setiDisplayLength(1000);
        String resultUnit = this.restTemplate.exchange(UNIT_LIST, HttpMethod.POST, new HttpEntity<DataTableInfoVo>(tableInfo, this.httpHeaders), String.class).getBody();
        JSONObject retUnitJson = (JSONObject) JSON.parse(resultUnit);
        com.alibaba.fastjson.JSONArray retUnitArray = retUnitJson.getJSONArray("list");
        com.alibaba.fastjson.JSONArray dataArray = dataObject.getJSONArray("data");
        for (int i = 0; i < dataArray.size(); i++) {
            JSONObject jsonObject = dataArray.getJSONObject(i);
            String wirtebackId = jsonObject.getString(writebackField);
            String[] wirtebackIds = wirtebackId.split(",");
            String wirtebackValue = "";
            for (int j = 0; j < wirtebackIds.length; j++) {
                String id = wirtebackIds[j];
                for (int k = 0; k < retUnitArray.size(); k++) {
                    JSONObject unitObject = retUnitArray.getJSONObject(k);
                    String unitId = unitObject.getString("unitId"); // 单位ID
                    if (id.equals(unitId)) {
                        String unitName = unitObject.getString("unitName"); // 单位名称
                        wirtebackValue += unitName + ",";
                        break;
                    }
                }
            }
            if (wirtebackValue.length() > 0) {
                wirtebackValue = wirtebackValue.substring(0, wirtebackValue.length() - 1);
            }
            jsonObject.put(writebackField + "Disp", wirtebackValue);
        }
        // 岗位
        List<?> rs = this.restTemplate.exchange(GET_POST_LIST, HttpMethod.POST, new HttpEntity<String>(this.httpHeaders), List.class).getBody();
        com.alibaba.fastjson.JSONArray retPostArray = (com.alibaba.fastjson.JSONArray) JSON.parse(JSONObject.toJSON(rs).toString());
        writebackField = "userPost"; // 回写字段
        for (int i = 0; i < dataArray.size(); i++) {
            JSONObject jsonObject = dataArray.getJSONObject(i);
            String wirtebackId = jsonObject.getString(writebackField);
            String[] wirtebackIds = wirtebackId.split(",");
            String wirtebackValue = "";
            for (int j = 0; j < wirtebackIds.length; j++) {
                String id = wirtebackIds[j];
                for (int k = 0; k < retPostArray.size(); k++) {
                    JSONObject postObject = retPostArray.getJSONObject(k);
                    String postId = postObject.getString("postId"); // 岗位ID
                    if (id.equals(postId)) {
                        String postName = postObject.getString("postName"); // 岗位名称
                        wirtebackValue += postName + ",";
                        break;
                    }
                }
            }
            if (wirtebackValue.length() > 0) {
                wirtebackValue = wirtebackValue.substring(0, wirtebackValue.length() - 1);
            }
            jsonObject.put(writebackField + "Disp", wirtebackValue);
        }
        return dataObject.toString();
    }
    /**
     * 跳转至列表页
     */
    @RequestMapping(method = RequestMethod.GET, value = "/pagePlanList")
    private String pagePlanList(HttpServletRequest request) {
        basePath = request.getContextPath();
        request.setAttribute("basePath", basePath);
        return "stp/plan/listPlanPage";
    }

    /**
     * 列表异步加载数据
     */
    @RequestMapping(value = "/getTableData", method = RequestMethod.POST)
    @ResponseBody
    public Object getTableData(@ModelAttribute("param") LayuiTableParam param, HttpServletRequest request) throws IOException {
        // Map<String, Object> map = param.getParam();
        param.getParam().put("createUser", sysUserInfo.getUserId());
//        param.getParam().put("workOrderAllotUserName",sysUserInfo.getUserId());
//        param.getParam().put("delFlag","");
        HttpEntity<LayuiTableParam> entity = new HttpEntity<LayuiTableParam>(param, this.httpHeaders);
        ResponseEntity<LayuiTableData> responseEntity = this.restTemplate.exchange(BOT_WORK_ORDER_LIST, HttpMethod.POST, entity, LayuiTableData.class);
        LayuiTableData result = responseEntity.getBody();
        CommonUtil.addAttachmentField(result, restTemplate, httpHeaders);
        JSONObject retJson = (JSONObject) JSON.toJSON(result);
        return retJson;
    }

    /**
     * 新建工单管理
     */
    @RequestMapping(value = "/addPlanPage")
    public String pageAddPlan(HttpServletRequest request) {
        Object dataId = request.getParameter("dataId");
        String flag = "edit";
        if (dataId == null || "".equals(dataId)) {
            dataId = UUID.randomUUID().toString().replace("-", "");
            flag = "add";
        }
        request.setAttribute("flag", flag);
        request.setAttribute("dataId", dataId);
        request.setAttribute("userName", sysUserInfo.getUserDisp());
        request.setAttribute("unitName", sysUserInfo.getUnitName());
        request.setAttribute("bak6", sysUserInfo.getUserId());
        request.setAttribute("bak4", sysUserInfo.getUserDisp());
        return "stp/plan/addPlanPage";
    }

    @RequestMapping(value = "/editPlanPage")
    public String editPlanPage(HttpServletRequest request) {
        Object dataId = request.getParameter("dataId");
        String flag = "edit";
        if (dataId == null || "".equals(dataId)) {
            dataId = UUID.randomUUID().toString().replace("-", "");
            flag = "add";
        }
        request.setAttribute("flag", flag);
        request.setAttribute("dataId", dataId);
        request.setAttribute("userName", sysUserInfo.getUserDisp());
        request.setAttribute("unitName", sysUserInfo.getUnitName());
        return "stp/plan/editPlanPage";
    }
    /**
     * 新建工单管理
     */
    @RequestMapping(value = "/PageEditPlanBase")
    public String goEditPlanBasePage(HttpServletRequest request) {
        Object dataId = request.getParameter("dataId");
        String flag = "edit";
        if (dataId == null || "".equals(dataId)) {
            dataId = UUID.randomUUID().toString().replace("-", "");
            flag = "add";
        }
        request.setAttribute("flag", flag);
        request.setAttribute("dataId", dataId);
        request.setAttribute("userName", sysUserInfo.getUserDisp());
        request.setAttribute("unitName", sysUserInfo.getUnitName());
        return "stp/plan/pageEditPlanBase";
    }

    @RequestMapping(value = "/goTablePlanDetailList")
    public String goTablePlanDetailList(HttpServletRequest request) {
        Object dataId = request.getParameter("dataId");
        request.setAttribute("dataId", dataId);
        return "stp/plan/my/table_plan_detail_list";
    }

    @RequestMapping(value = "/goAddBotWorkOrderZp")
    public String goAddBotWorkOrderZp(HttpServletRequest request) {
        Object dataId = request.getParameter("dataId");
        String flag = "edit";
        if (dataId == null || "".equals(dataId)) {
            dataId = UUID.randomUUID().toString().replace("-", "");
            flag = "add";
        }
        request.setAttribute("flag", flag);
        request.setAttribute("dataId", dataId);
        request.setAttribute("userName", sysUserInfo.getUserDisp());
        request.setAttribute("unitName", sysUserInfo.getUnitName());
        return "stp/plan/botWorkOrderAddZp";
    }

    @RequestMapping(value = "/toPageZfPlan")
    public String goAddBotWorkOrderZf(HttpServletRequest request) {
        Object dataId = request.getParameter("dataId");
        String flag = "edit";
        if (dataId == null || "".equals(dataId)) {
            dataId = UUID.randomUUID().toString().replace("-", "");
            flag = "add";
        }
        request.setAttribute("flag", flag);
        request.setAttribute("dataId", dataId);
        request.setAttribute("userName", sysUserInfo.getUserDisp());
        request.setAttribute("unitName", sysUserInfo.getUnitName());
        return "stp/plan/zf_plan_edit_page";
    }

    /**
     * 保存工单管理
     *
     * @param request
     * @return
     */
    @RequestMapping(value = "/saveBotWorkOrder")
    @ResponseBody
    public int saveBotWorkOrder(HttpServletRequest request) {
        String code = CodeUtil.getCode("XTBM_0048", restTemplate, httpHeaders);
        String param = request.getParameter("param");
        String strCreateUser = sysUserInfo.getUserId();
        JSONObject jsStr = (JSONObject) JSON.parseObject(param);
        jsStr.put("dataCode", code);
        jsStr.put("auditSts", "0");
        jsStr.put("createDate", DateUtil.dateToStr(new Date(), DateUtil.FMT_SS));
        jsStr.put("createUser", sysUserInfo.getUserId());
        jsStr.put("createUserName", sysUserInfo.getUserDisp());
        jsStr.put("dataOrder", new Date().getTime() + "");
//        jsStr.put("updateDate", DateUtil.dateToStr(new Date(), DateUtil.FMT_SS));
//        jsStr.put("updateUser", sysUserInfo.getUserId());
//        jsStr.put("updateUserName", sysUserInfo.getUserDisp());
        jsStr.put("workOrderStatus", "0");
        jsStr.put("status", "0");
        jsStr.put("workOrderCode", code);
        jsStr.put("unitName", sysUserInfo.getUnitName());
        PlanBase bsv = JSONObject.toJavaObject(jsStr, PlanBase.class);
        
        bsv.setDelFlag("0");
        List<PlanBaseDetail> matterList = new ArrayList<PlanBaseDetail>();
        List<PlanBase> baseList = new ArrayList<PlanBase>();
        if (jsStr.containsKey("matterList")) {
            JSONArray array = jsStr.getJSONArray("matterList");
            for (int i = 0; i < array.size(); i++) {
                //取值赋给PlanBase
                JSONObject detail = array.getJSONObject(i);
                PlanBase planBase = new PlanBase();
                planBase.setWorkOrderName(detail.get("workOrderName").toString());
                planBase.setWorkOrderAllotUserId(detail.get("workOrderAllotUserId").toString());//当前节点处理人
                planBase.setParentId(bsv.getDataId());
                planBase.setDelFlag("0");
                planBase.setBl("");
                System.out.println("dataId = " + "".equals(detail.get("dataId")));
                planBase.setDataId("".equals(detail.get("dataId")) ? UUID.randomUUID().toString().replace("-", "") : detail.get("dataId").toString());
//                planBase.setDataId(UUID.randomUUID().toString().replace("-", ""));
                planBase.setWorkOrderAllotUserName(detail.get("workOrderAllotUserName").toString());//当前节点处理人
                planBase.setWorkOrderStatus("0");
                planBase.setRedactUnitName(bsv.getRedactUnitName());
                planBase.setWorkOrderType(bsv.getWorkOrderType());
//                planBase.setCreateUser(sysUserInfo.getUserId());
//                planBase.setCreateUserName(sysUserInfo.getUserName());
                planBase.setCreateDate(DateUtil.dateToStr(new Date(), DateUtil.FMT_SS));
                //                Object objJsrId = detail.get("jsId");
//                if (objJsrId != null && !"".equals(objJsrId)) {//
//                    planBase.setJsId(objJsrId.toString());//指派给他人
//                    //指派给他人,新增一条数据
//                    PlanBase planBaseZp = new PlanBase();
//                    planBaseZp.setBl("");
//                    planBaseZp.setWorkOrderName(planBase.getRemarks());
//                    planBaseZp.setParentId(planBase.getDataId());
//                    planBaseZp.setDelFlag("0");
//                    planBaseZp.setDataId("".equals(detail.get("dataId")) ? UUID.randomUUID().toString().replace("-", "") : detail.get("dataId").toString());
//                    planBaseZp.setWorkOrderAllotUserName(objJsrId.toString());//当前节点处理人
//                    planBaseZp.setWorkOrderStatus("0");
//                    baseList.add(planBaseZp);
//                }
                baseList.add(planBase);
            }
        }
        HttpEntity<PlanBase> entity = new HttpEntity<PlanBase>(bsv, this.httpHeaders);
        ResponseEntity<Integer> responseEntity = this.restTemplate.exchange(SAVE_BOT_WORK_ORDER, HttpMethod.POST, entity, Integer.class);
        int result = responseEntity.getBody();

        HttpEntity<List<PlanBase>> entityList = new HttpEntity<List<PlanBase>>(baseList, this.httpHeaders);
        ResponseEntity<Integer> responseEntityList = this.restTemplate.exchange(SAVE_PLAN_BASE_BATCH, HttpMethod.POST, entityList, Integer.class);
        try {
            CommonUtil.updateFileFlag(restTemplate, httpHeaders, bsv.getDataId());
        } catch (Exception e) {
            e.printStackTrace();
            result = 500;
        }
        return result;
    }

    /**
     * 下发工单管理
     *
     * @param request
     * @return
     */
    @RequestMapping(value = "/submitBotWorkOrder")
    @ResponseBody
    public int submitBotWorkOrder(HttpServletRequest request) {
        int result;
        String workOrderStatus = request.getParameter("workOrderStatus");
        if ("0".equals(workOrderStatus)) {
            result = saveBotWorkOrder(request);
        } else {
            result = editBotWorkOrder(request);
        }
        String param = request.getParameter("param");
        JSONObject jsStr = (JSONObject) JSON.parseObject(param);
        String dataId = jsStr.getString("dataId");
        if (result == 200) {
            ResponseEntity<Integer> responseEntity = this.restTemplate.exchange(SUBMIT_BOT_WORK_ORDER + dataId, HttpMethod.POST, new HttpEntity<String>(this.httpHeaders), Integer.class);
            result = responseEntity.getBody();
        }
        return result;
    }

    /**
     * 删除工单管理
     *
     * @param request
     * @return
     */
    @RequestMapping(value = "/deletePlan")
    @ResponseBody
    public int deletePlan(HttpServletRequest request) {
        String id = request.getParameter("ids");
        ResponseEntity<Integer> responseEntity = this.restTemplate.exchange(DELETE_BOT_WORK_ORDER + id, HttpMethod.POST, new HttpEntity<String>(this.httpHeaders), Integer.class);
        int result = responseEntity.getBody();
        return result;
    }

    /**
     * 跳转至修改工单管理页面
     */
    @RequestMapping(value = "/pagePlanDo")
    public String goEditBotWorkOrder(HttpServletRequest request) {
        request.setAttribute("userName", sysUserInfo.getUserDisp());
        request.setAttribute("unitName", sysUserInfo.getUnitName());
        request.setAttribute("dataId", request.getParameter("dataId"));
        return "stp/plan/do_plan_edit_page";
    }

    /**
     * 跳转至查看工单管理页面
     */
    @RequestMapping(value = "/viewPlanPage")
    public String viewPlanPage(HttpServletRequest request) {
        request.setAttribute("dataId", request.getParameter("dataId"));
        return "stp/plan/viewPlanPage";
    }

    /**
     * 获取工单管理信息
     */
    @RequestMapping(value = "/viewBotWorkOrder")
    @ResponseBody
    public Object viewBotWorkOrder(HttpServletRequest request) {
        String dataId = request.getParameter("dataId");
        ResponseEntity<PlanBase> responseEntity = this.restTemplate.exchange(VIEW_BOT_WORK_ORDER + dataId, HttpMethod.POST, new HttpEntity<String>(this.httpHeaders), PlanBase.class);
        PlanBase result = responseEntity.getBody();
        return result;
    }

    /**
     * 修改保存
     *
     * @param request
     * @return
     */
    @RequestMapping(value = "/editBotWorkOrder")
    @ResponseBody
    public int editBotWorkOrder(HttpServletRequest request) {
        String param = request.getParameter("param");
        JSONObject jsStr = (JSONObject) JSON.parseObject(param);
        jsStr.put("visaApplyCode", null);
        String dataId = jsStr.getString("dataId");
        ResponseEntity<PlanBase> resultEntity = this.restTemplate.exchange(VIEW_BOT_WORK_ORDER + dataId, HttpMethod.POST, new HttpEntity<String>(this.httpHeaders), PlanBase.class);
        PlanBase wjbvo = resultEntity.getBody();
        wjbvo = (PlanBase) JSONObject.toJavaObject(jsStr, PlanBase.class);
        wjbvo.setUpdateDate(DateUtil.dateToStr(new Date(), DateUtil.FMT_SS));
        wjbvo.setUpdateUser(sysUserInfo.getUserId());
        wjbvo.setUpdateUserName(sysUserInfo.getUserDisp());
        wjbvo.setDelFlag("0");
        HttpEntity<PlanBase> entity = new HttpEntity<PlanBase>(wjbvo, this.httpHeaders);
        ResponseEntity<Integer> responseEntity = this.restTemplate.exchange(EDIT_BOT_WORK_ORDER, HttpMethod.POST, entity, Integer.class);
        int result = responseEntity.getBody();


        List<PlanBase> baseList = new ArrayList<PlanBase>();
        if (jsStr.containsKey("matterList")) {
            JSONArray array = jsStr.getJSONArray("matterList");
            for (int i = 0; i < array.size(); i++) {
                //取值赋给PlanBase
                JSONObject detail = array.getJSONObject(i);
                PlanBase planBase = JSONObject.toJavaObject((JSON) JSON.toJSON(detail), PlanBase.class);
                planBase.setParentId(wjbvo.getDataId());
                System.out.println("dataId = " + "".equals(detail.get("dataId")));
                planBase.setDataId("".equals(detail.get("dataId")) ? UUID.randomUUID().toString().replace("-", "") : detail.get("dataId").toString());
                planBase.setWorkOrderStatus("1");
                planBase.setDelFlag("0");
                planBase.setBl("");
                planBase.setWorkOrderType(wjbvo.getWorkOrderType());
                planBase.setRedactUnitName(wjbvo.getRedactUnitName());
                planBase.setCreateDate(DateUtil.dateToStr(new Date(),DateUtil.FMT_SS));
//                Object objJsrId = detail.get("jsId");
//                if (objJsrId != null && !"".equals(objJsrId)) {//
//                    planBase.setJsId(objJsrId.toString());//指派给他人
//                    //指派给他人,新增一条数据
//                    PlanBase planBaseZp = new PlanBase();
//                    planBaseZp.setWorkOrderName(planBase.getRemarks());
//                    planBaseZp.setParentId(planBase.getDataId());
//                    planBaseZp.setBl("");
//                    planBaseZp.setDataId(UUID.randomUUID().toString().replace("-", ""));
//                    planBaseZp.setWorkOrderAllotUserName(objJsrId.toString());//当前节点处理人
//                    planBaseZp.setWorkOrderStatus("0");
//                    planBaseZp.setDelFlag("0");
//                    baseList.add(planBaseZp);
//                }
                baseList.add(planBase);
            }
        }

        HttpEntity<List<PlanBase>> entityList = new HttpEntity<List<PlanBase>>(baseList, this.httpHeaders);
        ResponseEntity<Integer> responseEntityList = this.restTemplate.exchange(SAVE_PLAN_BASE_BATCH, HttpMethod.POST, entityList, Integer.class);

        try {
            CommonUtil.updateFileFlag(restTemplate, httpHeaders, wjbvo.getDataId());
        } catch (Exception e) {
            e.printStackTrace();
            result = 500;
        }
        return result;
    }

    /**
     * 任务转发保存
     *
     * @param request
     * @return
     */
    @RequestMapping(value = "/editBotWorkOrderZf")
    @ResponseBody
    public int editBotWorkOrderZf(HttpServletRequest request) {
        //修改原数据

        //新增此数据

        //更新子数据

        //页面判断不能重复转发,只能转发一次

        String param = request.getParameter("param");
        JSONObject jsStr = (JSONObject) JSON.parseObject(param);
        jsStr.put("visaApplyCode", null);
        String dataId = jsStr.getString("dataId");
        String newDataId = UUID.randomUUID().toString().replace("-", "");
        ResponseEntity<PlanBase> resultEntity = this.restTemplate.exchange(VIEW_BOT_WORK_ORDER + dataId, HttpMethod.POST, new HttpEntity<String>(this.httpHeaders), PlanBase.class);
        PlanBase wjbvoOld = resultEntity.getBody();
        PlanBase wjbvo = resultEntity.getBody();
        String workOrderName = wjbvo.getWorkOrderName();
        wjbvo = (PlanBase) JSONObject.toJavaObject(jsStr, PlanBase.class);
        wjbvo.setUpdateDate(DateUtil.dateToStr(new Date(), DateUtil.FMT_SS));
        wjbvo.setUpdateUser(sysUserInfo.getUserId());
        wjbvo.setUpdateUserName(sysUserInfo.getUserDisp());
        wjbvo.setDelFlag("0");
        wjbvo.setWorkOrderName("(已转发)"+workOrderName);
        wjbvo.setBak5("0");//0:转发
        wjbvo.setZpName(newDataId);
        wjbvo.setWorkOrderStatus("2");//转发状态设为2,完成
        HttpEntity<PlanBase> entity = new HttpEntity<PlanBase>(wjbvo, this.httpHeaders);
        ResponseEntity<Integer> responseEntity = this.restTemplate.exchange(EDIT_BOT_WORK_ORDER, HttpMethod.POST, entity, Integer.class);
        int result = responseEntity.getBody();


        //新增此数据
        wjbvoOld.setWorkOrderName(workOrderName);
        wjbvoOld.setWorkOrderAllotUserId(wjbvo.getBak2());
        wjbvoOld.setWorkOrderAllotUserName(wjbvo.getBak3());
        wjbvoOld.setBak2("");
        wjbvoOld.setBak3("");

        wjbvoOld.setBl(wjbvo.getBl());
        wjbvoOld.setWorkOrderType(wjbvo.getWorkOrderType());
        wjbvoOld.setDataId(newDataId);
        wjbvoOld.setJsId(wjbvo.getDataId());
//        wjbvoOld.setCreateUser(sysUserInfo.getUserId());
//        wjbvoOld.setCreateUserName(sysUserInfo.getUserName());
        wjbvoOld.setCreateDate(DateUtil.dateToStr(new Date(), DateUtil.FMT_SS));
        HttpEntity<PlanBase> entityNew = new HttpEntity<PlanBase>(wjbvoOld, this.httpHeaders);
        ResponseEntity<Integer> responseEntityNew = this.restTemplate.exchange(SAVE_BOT_WORK_ORDER, HttpMethod.POST, entityNew, Integer.class);


        List<PlanBase> baseList = new ArrayList<PlanBase>();
        if (jsStr.containsKey("matterList")) {
            JSONArray array = jsStr.getJSONArray("matterList");
            for (int i = 0; i < array.size(); i++) {
                //转发
                //子项:改为修改
                //取值赋给PlanBase
                JSONObject detail = array.getJSONObject(i);
                PlanBase planBase = JSONObject.toJavaObject((JSON) JSON.toJSON(detail), PlanBase.class);
                planBase.setParentId(newDataId);
                planBase.setDataId("".equals(detail.get("dataId")) ? UUID.randomUUID().toString().replace("-", "") : detail.get("dataId").toString());
                planBase.setWorkOrderStatus("1");
                planBase.setDelFlag("0");
                planBase.setBl("");
                planBase.setWorkOrderType(wjbvo.getWorkOrderType());
                planBase.setRedactUnitName(wjbvo.getRedactUnitName());
                planBase.setCreateDate(DateUtil.dateToStr(new Date(), DateUtil.FMT_SS));
                baseList.add(planBase);
            }
        }
        HttpEntity<List<PlanBase>> entityList = new HttpEntity<List<PlanBase>>(baseList, this.httpHeaders);
        ResponseEntity<Integer> responseEntityList = this.restTemplate.exchange(SAVE_PLAN_BASE_BATCHZF, HttpMethod.POST, entityList, Integer.class);

        try {
            CommonUtil.updateFileFlag(restTemplate, httpHeaders, wjbvo.getDataId());
        } catch (Exception e) {
            e.printStackTrace();
            result = 500;
        }
        return result;
    }

    /**
     * 批量提交工单管理
     *
     * @param request
     * @return
     */
    @RequestMapping(value = "/affirmBotOccupyRoad")
    @ResponseBody
    public int affirmBotOccupyRoad(HttpServletRequest request) {
        String ids = request.getParameter("ids");
        ResponseEntity<Integer> responseEntity = this.restTemplate.exchange(AFFIRM_BOT_WORK_ORDER + ids, HttpMethod.POST, new HttpEntity<String>(this.httpHeaders), Integer.class);
        int result = responseEntity.getBody();
        return result;
    }

    /**
     * 获取我的工单管理信息
     */
    @RequestMapping(value = "/queryBotWorkOrderMatterList")
    @ResponseBody
    public Object queryBotWorkOrderMatterList(@ModelAttribute("param") LayuiTableParam param, HttpServletRequest request) {
        HttpEntity<LayuiTableParam> entity = new HttpEntity<LayuiTableParam>(param, this.httpHeaders);
        ResponseEntity<LayuiTableData> responseEntity = this.restTemplate.exchange(VIEW_BOT_WORK_ORDER_MATTER_LIST, HttpMethod.POST, entity, LayuiTableData.class);
        LayuiTableData result = responseEntity.getBody();
        return JSON.toJSONString(result);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/my/goBotWorkOrderListPage")
    private String goMyBotWorkOrderListPage(HttpServletRequest request) {
        basePath = request.getContextPath();
        request.setAttribute("basePath", basePath);
        return "stp/plan/my/listMyPlan";
    }

    /**
     * 我的列表异步加载数据
     */
    @RequestMapping(value = "/my/getTableData", method = RequestMethod.POST)
    @ResponseBody
    public Object getMyTableData(@ModelAttribute("param") LayuiTableParam param, HttpServletRequest request) throws IOException {
        Map<String, Object> map = param.getParam();
        map.put("workOrderAllotUserId", sysUserInfo.getUserId());
        if(param.getParam().get("workOrderStatus")==null||"".equals(param.getParam().get("workOrderStatus"))){
            map.put("workOrderStatus", "1,2");
        }
        param.setParam(map);
        HttpEntity<LayuiTableParam> entity = new HttpEntity<LayuiTableParam>(param, this.httpHeaders);
        ResponseEntity<LayuiTableData> responseEntity = this.restTemplate.exchange(MY_BOT_WORK_ORDER_LIST, HttpMethod.POST, entity, LayuiTableData.class);
        LayuiTableData result = responseEntity.getBody();
        CommonUtil.addAttachmentField(result, restTemplate, httpHeaders);
        JSONObject retJson = (JSONObject) JSON.toJSON(result);
        return retJson;
    }

    /**
     * 跳转至完成我的工单管理页面
     */
    @RequestMapping(value = "/my/goEditPlanDetail")
    public String goMyEditBotWorkOrder(HttpServletRequest request) {
        request.setAttribute("dataId", request.getParameter("dataId"));
        return "stp/plan/my/do_plan_edit_page";
    }

    /**
     * 跳转至查看我的工单管理页面
     */
    @RequestMapping(value = "/my/viewPlanDetail")
    public String goMyViewBotWorkOrder(HttpServletRequest request) {
        request.setAttribute("dataId", request.getParameter("dataId"));
        return "stp/plan/my/viewPlanDetail";
    }

    /**
     * 获取我的工单事项反馈管理信息
     */
    @RequestMapping(value = "/queryMyBotWorkOrderMatterList")
    @ResponseBody
    public Object queryMyBotWorkOrderMatterList(@ModelAttribute("param") LayuiTableParam param, HttpServletRequest request) {
        HttpEntity<LayuiTableParam> entity = new HttpEntity<LayuiTableParam>(param, this.httpHeaders);
        ResponseEntity<LayuiTableData> responseEntity = this.restTemplate.exchange(VIEW_MY_BOT_WORK_ORDER_MATTER_LIST, HttpMethod.POST, entity, LayuiTableData.class);
        LayuiTableData result = responseEntity.getBody();
        return JSON.toJSONString(result);
    }

    /**
     * 保存我的工单事项反馈
     *
     * @param request
     * @return
     */
    @RequestMapping(value = "/saveMyBotWorkOrderMatterFeedBack")
    @ResponseBody
    public int saveMyBotWorkOrderMatterFeedBack(HttpServletRequest request) {
        String param = request.getParameter("param");
        JSONObject jsStr = (JSONObject) JSON.parseObject(param);
        //jsStr.put("dataCode", code);
        jsStr.put("auditSts", "0");
        jsStr.put("createDate", DateUtil.dateToStr(new Date(), DateUtil.FMT_SS));
//        jsStr.put("createUser", sysUserInfo.getUserId());
//        jsStr.put("createUserName", sysUserInfo.getUserDisp());
        jsStr.put("dataOrder", new Date().getTime() + "");
        jsStr.put("updateDate", DateUtil.dateToStr(new Date(), DateUtil.FMT_SS));
        jsStr.put("updateUser", sysUserInfo.getUserId());
        jsStr.put("updateUserName", sysUserInfo.getUserDisp());
//        jsStr.put("workOrderStatus", "0");
        jsStr.put("status", "0");
        //jsStr.put("workOrderCode", code);
        jsStr.put("unitName", sysUserInfo.getUnitName());

        PlanBase bsv = JSONObject.toJavaObject(jsStr, PlanBase.class);


        List<PlanBaseDetail> matterList = new ArrayList<PlanBaseDetail>();
        if (jsStr.containsKey("matterList")) {
            JSONArray array = jsStr.getJSONArray("matterList");
            for (int i = 0; i < array.size(); i++) {
                PlanBaseDetail matterVo = JSONObject.toJavaObject(array.getJSONObject(i), PlanBaseDetail.class);
                matterVo.setWorkOrderId(jsStr.getString("dataId"));
                matterVo.setDataOrder(i + "");
//                matterVo.setWorkOrderName(jsStr.getString("workOrderName"));
//                matterVo.setRemarks(array.getJSONObject(i).getString("matter"));
                matterVo.setMatterType("1");
                matterVo.setStatus("0");
                matterVo.setDataId(UUID.randomUUID().toString().replace("-", ""));
//                matterVo.setWorkOrderEndDatatime(array.getJSONObject(i).getString("workOrderEndDatatime"));

                matterVo.setCreateUser(sysUserInfo.getUserId());
                matterVo.setCreateUserName(sysUserInfo.getUserName());
                matterVo.setCreateDate(DateUtil.dateToStr(new Date(), DateUtil.FMT_SS));

                matterList.add(matterVo);
            }
        }
        //保存主表信息
        String dataId = jsStr.getString("dataId");
        ResponseEntity<PlanBase> resultEntity = this.restTemplate.exchange(VIEW_BOT_WORK_ORDER + dataId, HttpMethod.POST, new HttpEntity<String>(this.httpHeaders), PlanBase.class);
        PlanBase wjbvo = resultEntity.getBody();
        wjbvo = (PlanBase) JSONObject.toJavaObject(jsStr, PlanBase.class);
        wjbvo.setUpdateDate(DateUtil.dateToStr(new Date(), DateUtil.FMT_SS));
        wjbvo.setUpdateUser(sysUserInfo.getUserId());
        wjbvo.setUpdateUserName(sysUserInfo.getUserDisp());
        wjbvo.setDelFlag("0");
        HttpEntity<PlanBase> entity = new HttpEntity<PlanBase>(wjbvo, this.httpHeaders);
        ResponseEntity<Integer> responseEntity = this.restTemplate.exchange(EDIT_BOT_WORK_ORDER, HttpMethod.POST, entity, Integer.class);

        //保存从表新
        HttpEntity<List<PlanBaseDetail>> entityList = new HttpEntity<List<PlanBaseDetail>>(matterList, this.httpHeaders);
        ResponseEntity<Integer> responseEntityList = this.restTemplate.exchange(SAVE_MY_BOT_WORK_ORDER_MATTER_BATCH, HttpMethod.POST, entityList, Integer.class);
        int result = responseEntityList.getBody();
        try {
            CommonUtil.updateFileFlag(restTemplate, httpHeaders, jsStr.getString("dataId"));
        } catch (Exception e) {
            e.printStackTrace();
            result = 500;
        }
        return result;
    }

    /**
     * 下发工单管理
     *
     * @param request
     * @return
     */
    @RequestMapping(value = "/submitMyBotWorkOrder")
    @ResponseBody
    public int submitMyBotWorkOrder(HttpServletRequest request) {
        int result;
        result = saveMyBotWorkOrderMatterFeedBack(request);
        String param = request.getParameter("param");
        JSONObject jsStr = (JSONObject) JSON.parseObject(param);
        String dataId = jsStr.getString("dataId");
//        if (result == 200) {
            ResponseEntity<Integer> responseEntity = this.restTemplate.exchange(SUBMIT_MY_BOT_WORK_ORDER + dataId, HttpMethod.POST, new HttpEntity<String>(this.httpHeaders), Integer.class);
            result = responseEntity.getBody();
//        }
        return result;
    }

    public String getBasePath() {
        return basePath;
    }

    public void setBasePath(String basePath) {
        this.basePath = basePath;
    }
}
