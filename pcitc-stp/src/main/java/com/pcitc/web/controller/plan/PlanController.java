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
import com.pcitc.base.util.DateUtil;
import com.pcitc.web.common.BaseController;
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
    private static final String BOT_WORK_ORDER_LIST = "http://pcitc-zuul/pcitc-system-provider/PlanClient-provider/botWorkOrder_list";
    // 保存新增
    private static final String SAVE_BOT_WORK_ORDER = "http://pcitc-zuul/pcitc-system-provider/PlanClient-provider/saveBotWorkOrder";
    // 删除
    private static final String DELETE_BOT_WORK_ORDER = "http://pcitc-zuul/pcitc-system-provider/PlanClient-provider/deleteBotWorkOrder/";
    // 修改
    private static final String EDIT_BOT_WORK_ORDER = "http://pcitc-zuul/pcitc-system-provider/PlanClient-provider/editBotWorkOrder";
    // 查询
    private static final String VIEW_BOT_WORK_ORDER = "http://pcitc-zuul/pcitc-system-provider/PlanClient-provider/viewBotWorkOrder/";
    // 提交
    private static final String AFFIRM_BOT_WORK_ORDER = "http://pcitc-zuul/pcitc-system-provider/PlanClient-provider/affirmBotWorkOrder/";
    // 提交
    private static final String SUBMIT_BOT_WORK_ORDER = "http://pcitc-zuul/pcitc-system-provider/PlanClient-provider/submitBotWorkOrder/";
    // 批量保存工单事项
    private static final String SAVE_BOT_WORK_ORDER_MATTER_BATCH = "http://pcitc-zuul/pcitc-system-provider/PlanClient-provider/saveBotWorkOrderMatterBatch";

    //批量保存任务
    private static final String SAVE_PLAN_BASE_BATCH = "http://pcitc-zuul/pcitc-system-provider/PlanClient-provider/savePlanBaseBatch";
    // 查看工单事项集合
    private static final String VIEW_BOT_WORK_ORDER_MATTER_LIST = "http://pcitc-zuul/pcitc-system-provider/PlanClient-provider/queryBotWorkOrderMatterList";

    //我的工单
    private static final String MY_BOT_WORK_ORDER_LIST = "http://pcitc-zuul/pcitc-system-provider/PlanClient-provider/my/botWorkOrder_list";
    // 查看我的工单事项反馈集合
    private static final String VIEW_MY_BOT_WORK_ORDER_MATTER_LIST = "http://pcitc-zuul/pcitc-system-provider/PlanClient-provider/queryMyBotWorkOrderMatterList";
    // 批量保存工单事项
    private static final String SAVE_MY_BOT_WORK_ORDER_MATTER_BATCH = "http://pcitc-zuul/pcitc-system-provider/PlanClient-provider/saveMyBotWorkOrderMatterBatch";
    // 提交
    private static final String SUBMIT_MY_BOT_WORK_ORDER = "http://pcitc-zuul/pcitc-system-provider/PlanClient-provider/submitMyBotWorkOrder/";

    /**
     * 跳转至列表页
     */
    @RequestMapping(method = RequestMethod.GET, value = "/goBotWorkOrderListPage")
    private String goBotWorkOrderListPage(HttpServletRequest request) {
        basePath = request.getContextPath();
        request.setAttribute("basePath", basePath);
        return "stp/plan/botWorkOrderList";
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
    @RequestMapping(value = "/goAddBotWorkOrder")
    public String goAddBotWorkOrder(HttpServletRequest request) {
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
        return "stp/plan/botWorkOrderAdd";
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
        jsStr.put("updateDate", DateUtil.dateToStr(new Date(), DateUtil.FMT_SS));
        jsStr.put("updateUser", sysUserInfo.getUserId());
        jsStr.put("updateUserName", sysUserInfo.getUserDisp());
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
                planBase.setDataId(UUID.randomUUID().toString().replace("-", ""));
                planBase.setWorkOrderAllotUserName(detail.get("workOrderAllotUserName").toString());//当前节点处理人
                planBase.setWorkOrderStatus("0");
                Object objJsrId = detail.get("jsId");
                if (objJsrId != null && !"".equals(objJsrId)) {//
                    planBase.setJsId(objJsrId.toString());//指派给他人
                    //指派给他人,新增一条数据
                    PlanBase planBaseZp = new PlanBase();
                    planBaseZp.setBl("");
                    planBaseZp.setWorkOrderName(planBase.getRemarks());
                    planBaseZp.setParentId(planBase.getDataId());
                    planBaseZp.setDelFlag("0");
                    planBaseZp.setDataId("".equals(detail.get("dataId")) ? UUID.randomUUID().toString().replace("-", "") : detail.get("dataId").toString());
                    planBaseZp.setWorkOrderAllotUserName(objJsrId.toString());//当前节点处理人
                    planBaseZp.setWorkOrderStatus("0");
                    baseList.add(planBaseZp);
                }
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
    @RequestMapping(value = "/deleteBotWorkOrder")
    @ResponseBody
    public int deleteBotWorkOrder(HttpServletRequest request) {
        String id = request.getParameter("ids");
        ResponseEntity<Integer> responseEntity = this.restTemplate.exchange(DELETE_BOT_WORK_ORDER + id, HttpMethod.POST, new HttpEntity<String>(this.httpHeaders), Integer.class);
        int result = responseEntity.getBody();
        return result;
    }

    /**
     * 跳转至修改工单管理页面
     */
    @RequestMapping(value = "/goEditBotWorkOrder")
    public String goEditBotWorkOrder(HttpServletRequest request) {
        request.setAttribute("userName", sysUserInfo.getUserDisp());
        request.setAttribute("unitName", sysUserInfo.getUnitName());
        request.setAttribute("dataId", request.getParameter("dataId"));
        return "stp/plan/botWorkOrderEdit";
    }

    /**
     * 跳转至查看工单管理页面
     */
    @RequestMapping(value = "/goViewBotWorkOrder")
    public String goViewBotWorkOrder(HttpServletRequest request) {
        request.setAttribute("dataId", request.getParameter("dataId"));
        return "stp/plan/botWorkOrderView";
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
                System.out.println("planBase = " + planBase);
                planBase.setParentId(wjbvo.getDataId());
                planBase.setDataId("".equals(detail.get("dataId")) ? UUID.randomUUID().toString().replace("-", "") : detail.get("dataId").toString());
                planBase.setWorkOrderStatus("0");
                planBase.setDelFlag("0");
                planBase.setBl("");
                Object objJsrId = detail.get("jsId");
                if (objJsrId != null && !"".equals(objJsrId)) {//
                    planBase.setJsId(objJsrId.toString());//指派给他人
                    //指派给他人,新增一条数据
                    PlanBase planBaseZp = new PlanBase();
                    planBaseZp.setWorkOrderName(planBase.getRemarks());
                    planBaseZp.setParentId(planBase.getDataId());
                    planBaseZp.setBl("");
                    planBaseZp.setDataId(UUID.randomUUID().toString().replace("-", ""));
                    planBaseZp.setWorkOrderAllotUserName(objJsrId.toString());//当前节点处理人
                    planBaseZp.setWorkOrderStatus("0");
                    planBaseZp.setDelFlag("0");
                    baseList.add(planBaseZp);
                }
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
        return "stp/plan/my/botWorkOrderList";
    }

    /**
     * 我的列表异步加载数据
     */
    @RequestMapping(value = "/my/getTableData", method = RequestMethod.POST)
    @ResponseBody
    public Object getMyTableData(@ModelAttribute("param") LayuiTableParam param, HttpServletRequest request) throws IOException {
        Map<String, Object> map = param.getParam();
        map.put("workOrderAllotUserId", sysUserInfo.getUserId());
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
    @RequestMapping(value = "/my/goEditBotWorkOrder")
    public String goMyEditBotWorkOrder(HttpServletRequest request) {
        request.setAttribute("dataId", request.getParameter("dataId"));
        return "stp/plan/my/botWorkOrderEdit";
    }

    /**
     * 跳转至查看我的工单管理页面
     */
    @RequestMapping(value = "/my/goViewBotWorkOrder")
    public String goMyViewBotWorkOrder(HttpServletRequest request) {
        request.setAttribute("dataId", request.getParameter("dataId"));
        return "stp/plan/my/botWorkOrderView";
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
        //String code = CodeUtil.getCode("XTBM_0048", restTemplate, httpHeaders);
        String param = request.getParameter("param");
        JSONObject jsStr = (JSONObject) JSON.parseObject(param);
        //jsStr.put("dataCode", code);
        jsStr.put("auditSts", "0");
        jsStr.put("createDate", DateUtil.dateToStr(new Date(), DateUtil.FMT_SS));
        jsStr.put("createUser", sysUserInfo.getUserId());
        jsStr.put("createUserName", sysUserInfo.getUserDisp());
        jsStr.put("dataOrder", new Date().getTime() + "");
        jsStr.put("updateDate", DateUtil.dateToStr(new Date(), DateUtil.FMT_SS));
        jsStr.put("updateUser", sysUserInfo.getUserId());
        jsStr.put("updateUserName", sysUserInfo.getUserDisp());
        jsStr.put("workOrderStatus", "0");
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
                matterVo.setWorkOrderEndDatatime(array.getJSONObject(i).getString("workOrderEndDatatime"));
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
        if (result == 200) {
            ResponseEntity<Integer> responseEntity = this.restTemplate.exchange(SUBMIT_MY_BOT_WORK_ORDER + dataId, HttpMethod.POST, new HttpEntity<String>(this.httpHeaders), Integer.class);
            result = responseEntity.getBody();
        }
        return result;
    }

    public String getBasePath() {
        return basePath;
    }

    public void setBasePath(String basePath) {
        this.basePath = basePath;
    }
}
