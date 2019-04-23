package com.pcitc.web.controller.equipment;


import java.io.*;
import java.math.BigDecimal;
import java.util.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.pcitc.base.common.Constant;
import com.pcitc.base.common.Result;
import com.pcitc.base.common.enums.RequestProcessStatusEnum;
import com.pcitc.base.stp.equipment.*;
import com.pcitc.base.system.SysDictionary;
import com.pcitc.base.util.DateUtil;
import com.pcitc.base.util.ResultsDate;
import com.pcitc.web.utils.WordUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import com.alibaba.fastjson.JSONObject;
import com.pcitc.base.common.LayuiTableData;
import com.pcitc.base.common.LayuiTableParam;
import com.pcitc.base.system.SysUnit;
import com.pcitc.base.util.CommonUtil;
import com.pcitc.base.util.IdUtil;
import com.pcitc.web.common.BaseController;
import com.pcitc.web.utils.EquipmentUtils;

/*/
 * Created by WSL in 2019/3/26
 */

@Controller
public class PurchaseController extends BaseController{


	private static final String PAGE_URL = "http://pcitc-zuul/stp-proxy/sre-provider/purchase/page";
	private static final String GET_URL = "http://pcitc-zuul/stp-proxy/sre-provider/purchase/get/";
    private static final String PAGE_URL_CHOOSE_PROJECT = "http://pcitc-zuul/stp-proxy/sre-provider/project_basic/page";
    private static final String GET_BY_PROJECT_ID = "http://pcitc-zuul/stp-proxy/sre-provider/purchase/getSreProject/";
    private static final String GET_PROJECT_URL = "http://pcitc-zuul/stp-proxy/sre-provider/project_basic/get/";


    private static final String ADD_URL = "http://pcitc-zuul/stp-proxy/sre-provider/purchase/add";
    private static final String UPDATE_URL = "http://pcitc-zuul/stp-proxy/sre-provider/purchase/update";
    private static final String DEL_URL = "http://pcitc-zuul/stp-proxy/sre-provider/purchase/delete/";
    //临时导出文件目录
    private static final String TEMP_FILE_PATH = "src/main/resources/tem/";

    // 流程操作--同意
    //private static final String AUDIT_AGREE_URL = "http://pcitc-zuul/stp-proxy/sre-provider/purchase/task/agree/";
    // 流程操作--拒绝
    //private static final String AUDIT_REJECT_URL = "http://pcitc-zuul/stp-proxy/sre-provider/purchase/task/reject/";

    //跳转到采购申请页面
	@RequestMapping(value = "/sre_purchase/to-list")
	public String list(HttpServletRequest request, HttpServletResponse response) {

        String departCode=sysUserInfo.getUnitCode();
        request.setAttribute("departCode", departCode);
		String	parentUnitPathIds="";
		String unitPathIds =   sysUserInfo.getUnitPath();
		if(!unitPathIds.equals(""))
		{
			if(unitPathIds.length()>4)
			{
				parentUnitPathIds=unitPathIds.substring(0, unitPathIds.length()-4);

			}
		}
		request.setAttribute("parentUnitPathIds", parentUnitPathIds);

		return "/stp/equipment/purchase/purchase-list";
	}
    //跳转到到货签收页面
    @RequestMapping(value = "/sre-purchase/to-arrive-goods-list")
    public String arriveGoodsList(HttpServletRequest request, HttpServletResponse response) {

        String departCode=sysUserInfo.getUnitCode();
        request.setAttribute("departCode", departCode);
        String	parentUnitPathIds="";
        String unitPathIds =   sysUserInfo.getUnitPath();
        if(!unitPathIds.equals(""))
        {
            if(unitPathIds.length()>4)
            {
                parentUnitPathIds=unitPathIds.substring(0, unitPathIds.length()-4);

            }
        }
        request.setAttribute("parentUnitPathIds", parentUnitPathIds);

        return "/stp/equipment/purchase/arrive-goods-list";
    }
    @RequestMapping(value = "/sre-purchase/apply_list")
    public String apply_list(HttpServletRequest request, HttpServletResponse response)throws Exception {

        String departCode=sysUserInfo.getUnitCode();
        request.setAttribute("departCode", departCode);
        String	parentUnitPathIds="";
        String unitPathIds =   sysUserInfo.getUnitPath();
        if(!unitPathIds.equals(""))
        {
            if(unitPathIds.length()>4)
            {
                parentUnitPathIds=unitPathIds.substring(0, unitPathIds.length()-4);

            }
        }
        request.setAttribute("parentUnitPathIds", parentUnitPathIds);

        return "/stp/equipment/purchase/apply-list";
    }
    //跳转到安装调试页面123
    @RequestMapping(value = "/sre-purchase/to-installation-list")
    public String installationList(HttpServletRequest request, HttpServletResponse response) {

        String departCode=sysUserInfo.getUnitCode();
        request.setAttribute("departCode", departCode);
        String	parentUnitPathIds="";
        String unitPathIds =   sysUserInfo.getUnitPath();
        if(!unitPathIds.equals(""))
        {
            if(unitPathIds.length()>4)
            {
                parentUnitPathIds=unitPathIds.substring(0, unitPathIds.length()-4);

            }
        }
        request.setAttribute("parentUnitPathIds", parentUnitPathIds);

        return "/stp/equipment/purchase/installation-list";
    }

	/**
	 * 查询列表
	 * @param param
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value = "/sre_purchase/list")
	@ResponseBody
	public String ajaxlist(@ModelAttribute("param") LayuiTableParam param, HttpServletRequest request, HttpServletResponse response) {

		LayuiTableData layuiTableData = new LayuiTableData();
		HttpEntity<LayuiTableParam> entity = new HttpEntity<LayuiTableParam>(param, httpHeaders);
		ResponseEntity<LayuiTableData> responseEntity = restTemplate.exchange(PAGE_URL, HttpMethod.POST, entity, LayuiTableData.class);
		int statusCode = responseEntity.getStatusCodeValue();
		if (statusCode == 200) {
			layuiTableData = responseEntity.getBody();
		}
		JSONObject result = JSONObject.parseObject(JSONObject.toJSONString(layuiTableData));
		logger.info("============result" + result);



		return result.toString();
	}
	/**
	 * 增加
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/sre-purchase/add")
	public String add(HttpServletRequest request, HttpServletResponse response) throws Exception
	{


		String parentUnitPathName = "";
        String parentUnitPathId   = "";
        String purchaseName = "";
        String projectId    = "";
        String name         = "";
        String equipmentId  = "";
        String sreProjectEquipmentIds = "";
                String unitPathIds =   sysUserInfo.getUnitPath();
		if(!unitPathIds.equals(""))
		{


			if(unitPathIds.length()>4)
			{
				String	parentUnitPathIds=unitPathIds.substring(0, unitPathIds.length()-4);
				SysUnit sysUnit=EquipmentUtils.getUnitByUnitPath(parentUnitPathIds, restTemplate, httpHeaders);
				if(sysUnit!=null)
				{
                    parentUnitPathName = sysUnit.getUnitName();
                    parentUnitPathId =sysUnit.getUnitCode();
				}
			}
		}
        String departName = sysUserInfo.getUnitName();
        String departCode = sysUserInfo.getUnitCode();
		String createUserName=sysUserInfo.getUserDisp();
		String createUserId=sysUserInfo.getUserName();
		String id = CommonUtil.getParameter(request, "id", "");
		request.setAttribute("id", id);
		if(!id.equals(""))
		{
            ResponseEntity<SrePurchase> srePurchaseResponseEntity= this.restTemplate.exchange(GET_URL + id, HttpMethod.GET, new HttpEntity<Object>(this.httpHeaders), SrePurchase.class);
            int statusCode = srePurchaseResponseEntity.getStatusCodeValue();
            SrePurchase srePurchase = srePurchaseResponseEntity.getBody();
            projectId = srePurchase.getProjectId();
            purchaseName = srePurchase.getPurchaseName();
            equipmentId = srePurchase.getEquipmentId();

            ResponseEntity<SreProject> SreProjectResponseEntity = this.restTemplate.exchange(GET_BY_PROJECT_ID + projectId, HttpMethod.GET, new HttpEntity<Object>(this.httpHeaders), SreProject.class);
            SreProject sreProject = SreProjectResponseEntity.getBody();
            name = sreProject.getName();
            sreProjectEquipmentIds = sreProject.getEquipmentIds();

        }

		request.setAttribute("parentUnitPathName", parentUnitPathName);
		request.setAttribute("parentUnitPathId", parentUnitPathId);
        request.setAttribute("departName", departName);
        request.setAttribute("departCode", departCode);
        request.setAttribute("createUserName",createUserName);
		request.setAttribute("createUserId", createUserId);
        request.setAttribute("purchaseName", purchaseName);
        request.setAttribute("topicId", projectId);
        request.setAttribute("name", name);
        request.setAttribute("equipmentIds",equipmentId);
        request.setAttribute("sreProjectEquipmentIds",sreProjectEquipmentIds);



		List<UnitField>  unitFieldList= CommonUtil.getUnitNameList(restTemplate, httpHeaders);
		request.setAttribute("unitFieldList", unitFieldList);


		return "/stp/equipment/purchase/purchase-add";
	}

    @RequestMapping(method = RequestMethod.GET, value = "/sre-purchase/chooseProject")
    private String chooseProject(HttpServletRequest request)
    {
        String taskWriteUsersIds=sysUserInfo.getUserId();
        request.setAttribute("taskWriteUsersIds",taskWriteUsersIds);
        String topicId = request.getParameter("topicId");
        request.setAttribute("topicId",topicId);
        return "/stp/equipment/purchase/chooseProject";
    }
    @RequestMapping(value = "/sre-purchase/chooseProject_data")
    @ResponseBody
    public String chooseProject_data(@ModelAttribute("param") LayuiTableParam param, HttpServletRequest request, HttpServletResponse response) {


        LayuiTableData layuiTableData = new LayuiTableData();
        HttpEntity<LayuiTableParam> entity = new HttpEntity<LayuiTableParam>(param, httpHeaders);
        ResponseEntity<LayuiTableData> responseEntity = restTemplate.exchange(PAGE_URL_CHOOSE_PROJECT, HttpMethod.POST, entity, LayuiTableData.class);
        int statusCode = responseEntity.getStatusCodeValue();
        if (statusCode == 200) {
            layuiTableData = responseEntity.getBody();
        }
        JSONObject result = JSONObject.parseObject(JSONObject.toJSONString(layuiTableData));
        logger.info("============查询结果：" + result);
        return result.toString();
    }

    /**
     * 保存-更新操作
     *
     * @param request
     * @param response
     * @return
     * @throws Exception
     */
    @RequestMapping(method = RequestMethod.POST, value = "/sre-purchase/save")
    @ResponseBody
    public String saveOrUpdate(HttpServletRequest request, HttpServletResponse response) throws Exception {

        Result resultsDate = dealSaveUpdate(request);
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        JSONObject ob = JSONObject.parseObject(JSONObject.toJSONString(resultsDate));
        out.println(ob.toString());
        out.flush();
        out.close();
        return null;
    }

    private Result dealSaveUpdate(HttpServletRequest request)throws Exception {
        Result resultsDate = new Result();
        String name = CommonUtil.getParameter(request, "name", "");
        // 业务ID
        String id = CommonUtil.getParameter(request, "id", "");
        // 流程状态-是保存还是提交
        String status = CommonUtil.getParameter(request, "status", Constant.PURCHASE_STATUS_DRAFT);
        String stage = CommonUtil.getParameter(request, "stage", Constant.PURCHASE_REQUEST);
        String topicId = CommonUtil.getParameter(request, "topicId", "");
        String taskWriteUsersIds = CommonUtil.getParameter(request, "taskWriteUsersIds", "");
        String purchaseName = CommonUtil.getParameter(request, "purchaseName", "");
        String equipmentIds = CommonUtil.getParameter(request, "equipmentIds", "");
        String parentUnitPathName = CommonUtil.getParameter(request, "parentUnitPathName", "");
        String parentUnitPathId = CommonUtil.getParameter(request, "parentUnitPathId", "");
        String departName = CommonUtil.getParameter(request, "departName", "");
        String departCode = CommonUtil.getParameter(request, "departCode", "");
        String createUserName = CommonUtil.getParameter(request, "createUserName", "");
        String createUserId = CommonUtil.getParameter(request, "createUserId", "");

        String unitPathIds =   CommonUtil.getParameter(request, "unitPathIds",sysUserInfo.getUnitPath());

        String parentUnitPathIds ="";
        String parentUnitPathNames =  "";
            if(unitPathIds!=null && !unitPathIds.equals(""))
        {
            if(unitPathIds.length()>4)
            {
                parentUnitPathIds=unitPathIds.substring(0, unitPathIds.length()-4);
                SysUnit sysUnit=EquipmentUtils.getUnitByUnitPath(parentUnitPathIds, restTemplate, httpHeaders);
                if(sysUnit!=null)
                {
                    parentUnitPathNames = sysUnit.getUnitName();
                }
            }
        }
        SrePurchase srePurchase = null;
        ResponseEntity<String> responseEntity = null;
        // 判断是新增还是修改
            if (id.equals(""))
        {
            srePurchase = new SrePurchase();
            srePurchase.setCreateDate(new Date());

            String idv = UUID.randomUUID().toString().replaceAll("-", "");
            srePurchase.setId(idv);
            srePurchase.setState(status);
            srePurchase.setStage(stage);
        } else
        {
            ResponseEntity<SrePurchase> se = this.restTemplate.exchange(GET_URL + id, HttpMethod.GET, new HttpEntity<Object>(this.httpHeaders), SrePurchase.class);
            srePurchase = se.getBody();
        }
        // 流程状态
            srePurchase.setState(status);
            srePurchase.setPurchaseName(purchaseName);//采购名称
            srePurchase.setParentUnitPathNames(parentUnitPathName);//单位名称
            srePurchase.setParentUnitPathId(parentUnitPathId);//单位ID
            srePurchase.setDepartName(departName);//部门名称
            srePurchase.setDepartCode(departCode);//部门Code
            srePurchase.setProposerName(createUserName);//采购员姓名
            srePurchase.setProposerId(createUserId);//采购员ID

            srePurchase.setEquipmentId(equipmentIds);//装备ID
            srePurchase.setProjectId(topicId);//课题ID


        // 判断是新增还是修改
            if (id.equals(""))
        {
            responseEntity = this.restTemplate.exchange(ADD_URL, HttpMethod.POST, new HttpEntity<SrePurchase>(srePurchase, this.httpHeaders), String.class);

        }
        else {
            responseEntity = this.restTemplate.exchange(UPDATE_URL, HttpMethod.POST, new HttpEntity<SrePurchase>(srePurchase, this.httpHeaders), String.class);
        }
        // 返回结果代码
        int statusCode = responseEntity.getStatusCodeValue();
        if (statusCode == 200) {
            resultsDate = new Result(true, RequestProcessStatusEnum.OK.getStatusDesc());
        } else
            {
            resultsDate = new Result(false, RequestProcessStatusEnum.SERVER_BUSY.getStatusDesc());
        }

        return resultsDate;
    }


    /**
     * 删除
     *
     * @param request
     * @param response
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "/sre-purchase/delete/{id}")
    public String delete(@PathVariable("id") String id, HttpServletRequest request, HttpServletResponse response) throws Exception {
        Result resultsDate = new Result();
        ResponseEntity<Integer> responseEntity = this.restTemplate.exchange(DEL_URL + id, HttpMethod.GET, new HttpEntity<Object>(this.httpHeaders), Integer.class);
        int statusCode = responseEntity.getStatusCodeValue();
        int status = responseEntity.getBody();
        logger.info("============远程返回  statusCode " + statusCode + "  status=" + status);
        if (responseEntity.getBody() > 0) {
            resultsDate = new Result(true);
        } else {
            resultsDate = new Result(false, "删除失败，请联系系统管理员！");
        }
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        JSONObject ob = JSONObject.parseObject(JSONObject.toJSONString(resultsDate));
        out.println(ob.toString());
        out.flush();
        out.close();
        return null;
    }
    /**
     * 详情
     *
     * @param request
     * @param response
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "/sre-purchase/getParticulars/{id}", method = RequestMethod.GET)
    public String getParticulars(@PathVariable("id") String id, HttpServletRequest request, HttpServletResponse response) throws Exception
    {
        ResponseEntity<SrePurchase> responseEntity = this.restTemplate.exchange(GET_URL + id, HttpMethod.GET, new HttpEntity<Object>(this.httpHeaders), SrePurchase.class);
        int statusCode = responseEntity.getStatusCodeValue();
        logger.info("============远程返回  statusCode " + statusCode);
        SrePurchase srePurchase = responseEntity.getBody();
        request.setAttribute("srePurchase",srePurchase);
        String projectId = srePurchase.getProjectId();


        ResponseEntity<SreProject> responseEntity1 = this.restTemplate.exchange(GET_PROJECT_URL + projectId, HttpMethod.GET, new HttpEntity<Object>(this.httpHeaders), SreProject.class);
        int statusCode1 = responseEntity.getStatusCodeValue();
        logger.info("============远程返回  statusCode " + statusCode);
        SreProject sreProjectBasic = responseEntity1.getBody();
        request.setAttribute("sreProjectBasic", sreProjectBasic);
        String name = sreProjectBasic.getName();
        System.out.println(name+"=================================");

        String proposerName = srePurchase.getProposerName();
        String departCode = srePurchase.getDepartCode();
        String departName = srePurchase.getDepartName();
        String parentUnitPathNames = srePurchase.getParentUnitPathNames();


        request.setAttribute("proposerName", proposerName);
        request.setAttribute("departCode", departCode);
        request.setAttribute("departName", departName);
        request.setAttribute("parentUnitPathNames", parentUnitPathNames);
        List<UnitField>  unitFieldList= CommonUtil.getUnitNameList(restTemplate, httpHeaders);
        request.setAttribute("unitFieldList", unitFieldList);

        List<SysDictionary>  dicList= CommonUtil.getDictionaryByParentCode("ROOT_UNIVERSAL_LCZT", restTemplate, httpHeaders);
        request.setAttribute("dicList", dicList);


        return "/stp/equipment/purchase/purchase-view";
    }

    /**
     * 上传附件
     * @param request
     * @param response
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "/sre-purchase/upFileDoc")
    public String upFileDoc(HttpServletRequest request, HttpServletResponse response) throws Exception {



        String id = CommonUtil.getParameter(request, "id", "");
        request.setAttribute("id", id);

        if(!id.equals(""))
        {
            ResponseEntity<SrePurchase> responseEntity = this.restTemplate.exchange(GET_URL + id, HttpMethod.GET, new HttpEntity<Object>(this.httpHeaders), SrePurchase.class);
            SrePurchase srePurchase = responseEntity.getBody();
            request.setAttribute("srePurchase", srePurchase);
            String documentDoc = srePurchase.getDocumentDoc();
            String docArriveGoods = srePurchase.getDocumentDocArriveGoods();
            String documentDocInstallDebug = srePurchase.getDocumentDocInstallDebug();
            String stage = srePurchase.getStage();
            if(stage.equals(Constant.PURCHASE_CONTRACT_DOCKING)){
                if(documentDoc==null || documentDoc.equals(""))
                {
                    documentDoc= IdUtil.createFileIdByTime();
                }
                request.setAttribute("documentDoc", documentDoc);
            }else if(stage.equals(Constant.PURCHASE_ARRIVE_GOODS)){
                if(docArriveGoods==null || docArriveGoods.equals(""))
                {
                    docArriveGoods= IdUtil.createFileIdByTime();
                }
                request.setAttribute("docArriveGoods", docArriveGoods);
            }else if(stage.equals(Constant.PURCHASE_INSTALL_DEBUG)){
                if(documentDocInstallDebug==null || documentDocInstallDebug.equals(""))
                {
                    documentDocInstallDebug= IdUtil.createFileIdByTime();
                }
                request.setAttribute("documentDocInstallDebug", documentDocInstallDebug);
            }
            request.setAttribute("stage", stage);

        }

        return "/stp/equipment/purchase/upFileDoc";
    }
    @RequestMapping(value = "/sre-purchase/updateFileDoc")
    public String updateFileDoc(HttpServletRequest request, HttpServletResponse response) throws Exception {

        Result resultsDate = new Result();
        String id = CommonUtil.getParameter(request, "id", "");
        String stage = CommonUtil.getParameter(request, "stage", "");
        String documentDoc = CommonUtil.getParameter(request, "documentDoc", "");
        String docArriveGoods = CommonUtil.getParameter(request, "docArriveGoods", "");
        String documentDocInstallDebug = CommonUtil.getParameter(request, "documentDocInstallDebug", "");
        String resutl="";

        int statusCodeValue = 0;
        if(!id.equals(""))
        {
            if(stage.equals(Constant.PURCHASE_CONTRACT_DOCKING)){
                ResponseEntity<SrePurchase> responseEntity = this.restTemplate.exchange(GET_URL + id, HttpMethod.GET, new HttpEntity<Object>(this.httpHeaders), SrePurchase.class);
                SrePurchase srePurchase = responseEntity.getBody();
                srePurchase.setDocumentDoc(documentDoc);
                ResponseEntity<String>  exchange = this.restTemplate.exchange(UPDATE_URL, HttpMethod.POST, new HttpEntity<SrePurchase>(srePurchase, this.httpHeaders), String.class);
                statusCodeValue = responseEntity.getStatusCodeValue();
            }else if (stage.equals(Constant.PURCHASE_ARRIVE_GOODS)){
                ResponseEntity<SrePurchase> responseEntity = this.restTemplate.exchange(GET_URL + id, HttpMethod.GET, new HttpEntity<Object>(this.httpHeaders), SrePurchase.class);
                SrePurchase srePurchase = responseEntity.getBody();
                srePurchase.setDocumentDocArriveGoods(docArriveGoods);
                ResponseEntity<String>  exchange = this.restTemplate.exchange(UPDATE_URL, HttpMethod.POST, new HttpEntity<SrePurchase>(srePurchase, this.httpHeaders), String.class);
                statusCodeValue = responseEntity.getStatusCodeValue();
            }else if (stage.equals(Constant.PURCHASE_INSTALL_DEBUG)){
                ResponseEntity<SrePurchase> responseEntity = this.restTemplate.exchange(GET_URL + id, HttpMethod.GET, new HttpEntity<Object>(this.httpHeaders), SrePurchase.class);
                SrePurchase srePurchase = responseEntity.getBody();
                srePurchase.setDocumentDocInstallDebug(documentDocInstallDebug);
                ResponseEntity<String>  exchange = this.restTemplate.exchange(UPDATE_URL, HttpMethod.POST, new HttpEntity<SrePurchase>(srePurchase, this.httpHeaders), String.class);
                statusCodeValue = responseEntity.getStatusCodeValue();
            }
        }
        if (statusCodeValue==200)
        {
            resultsDate.setSuccess(true);
        } else
        {
            resultsDate = new Result(false, RequestProcessStatusEnum.SERVER_BUSY.getStatusDesc());
        }

        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        JSONObject ob = JSONObject.parseObject(JSONObject.toJSONString(resultsDate));
        out.println(ob.toString());
        out.flush();
        out.close();
        return null;
    }
    //采购申请单审批通过
    @RequestMapping(value = "/sre-purchase/updateState/{id}")
    @ResponseBody
    public Result updateState(@PathVariable("id") String id, HttpServletRequest request, HttpServletResponse response) throws Exception {
        Result resultsDate = new Result();

        ResponseEntity<SrePurchase> exchange = this.restTemplate.exchange(GET_URL + id, HttpMethod.GET, new HttpEntity<Object>(this.httpHeaders), SrePurchase.class);
        SrePurchase srePurchase = exchange.getBody();
        String equipmentIds = srePurchase.getEquipmentId();

        String[] arr = equipmentIds.split(",");
        for (int i = 0; i < arr.length; i++) {
            System.err.println(arr[i]);
            SreEquipment sreEquipment = EquipmentUtils.getSreEquipment(arr[i], restTemplate, httpHeaders);
            sreEquipment.setPurchaseStatus(Constant.EQUIPMENT_PURCHASE_PASS);
            EquipmentUtils.updateSreEquipment(sreEquipment, restTemplate, httpHeaders);
        }

        srePurchase.setState(Constant.PURCHASE_STATUS_PASS);
        srePurchase.setStage(Constant.PURCHASE_CONTRACT_DOCKING);
        ResponseEntity<String> exchange1 = this.restTemplate.exchange(UPDATE_URL, HttpMethod.POST, new HttpEntity<SrePurchase>(srePurchase, this.httpHeaders), String.class);
        int statusCodeValue = exchange1.getStatusCodeValue();
        if (statusCodeValue == 200) {
            resultsDate = new Result(true, RequestProcessStatusEnum.OK.getStatusDesc());
        } else
        {
            resultsDate = new Result(false, RequestProcessStatusEnum.SERVER_BUSY.getStatusDesc());
        }
        return resultsDate;
    }
    //合同系统对接上报
    @RequestMapping(value = "/sre-purchase/contractSubmission/{id}")
    @ResponseBody
    public Result contractSubmission(@PathVariable("id") String id, HttpServletRequest request, HttpServletResponse response) throws Exception {
        Result resultsDate = new Result();

        ResponseEntity<SrePurchase> exchange = this.restTemplate.exchange(GET_URL + id, HttpMethod.GET, new HttpEntity<Object>(this.httpHeaders), SrePurchase.class);
        SrePurchase srePurchase = exchange.getBody();
        srePurchase.setState(Constant.PURCHASE_STATUS_COMPACT);
        srePurchase.setStage(Constant.PURCHASE_ARRIVE_GOODS);
        ResponseEntity<String> exchange1 = this.restTemplate.exchange(UPDATE_URL, HttpMethod.POST, new HttpEntity<SrePurchase>(srePurchase, this.httpHeaders), String.class);
        int statusCodeValue = exchange1.getStatusCodeValue();
        if (statusCodeValue == 200) {
            resultsDate = new Result(true, RequestProcessStatusEnum.OK.getStatusDesc());
        } else
        {
            resultsDate = new Result(false, RequestProcessStatusEnum.SERVER_BUSY.getStatusDesc());
        }
        return resultsDate;
    }//
    //到货验收上报
    @RequestMapping(value = "/sre-purchase/arriveGoodsSubmission/{id}")
    @ResponseBody
    public Result arriveGoodsSubmission(@PathVariable("id") String id, HttpServletRequest request, HttpServletResponse response) throws Exception {
        Result resultsDate = new Result();

        ResponseEntity<SrePurchase> exchange = this.restTemplate.exchange(GET_URL + id, HttpMethod.GET, new HttpEntity<Object>(this.httpHeaders), SrePurchase.class);
        SrePurchase srePurchase = exchange.getBody();
        String equipmentIds = srePurchase.getEquipmentId();
        String[] arr = equipmentIds.split(",");
        for (int i = 0; i < arr.length; i++) {
            System.err.println(arr[i]);
            SreEquipment sreEquipment = EquipmentUtils.getSreEquipment(arr[i], restTemplate, httpHeaders);
            sreEquipment.setPurchaseStatus(Constant.EQUIPMENT_PURCHASE_ARRIVE_GOODS);
            EquipmentUtils.updateSreEquipment(sreEquipment, restTemplate, httpHeaders);
        }
        srePurchase.setState(Constant.PURCHASE_STATUS_ARRIVE_GOODS);
        srePurchase.setStage(Constant.PURCHASE_INSTALL_DEBUG);

        ResponseEntity<String> exchange1 = this.restTemplate.exchange(UPDATE_URL, HttpMethod.POST, new HttpEntity<SrePurchase>(srePurchase, this.httpHeaders), String.class);
        int statusCodeValue = exchange1.getStatusCodeValue();
        if (statusCodeValue == 200) {
            resultsDate = new Result(true, RequestProcessStatusEnum.OK.getStatusDesc());
        } else
        {
            resultsDate = new Result(false, RequestProcessStatusEnum.SERVER_BUSY.getStatusDesc());
        }
        return resultsDate;
    }



    /* =================================生成word文档  START================================*/
    //生成采购单模板
    @RequestMapping(value = "/sre-purchase/createWord/{id}", method = RequestMethod.GET)
    @ResponseBody
    public String createWord(@PathVariable("id") String id, HttpServletRequest request, HttpServletResponse response) throws Exception
    {
        Result resultsDate = new Result();
        String fileName=createPurchaseWord( id,"purchase.ftl",  response);
        if (!fileName.equals(""))
        {
            resultsDate = new Result(true);
            download(TEMP_FILE_PATH+fileName, response);
            deleteFile(TEMP_FILE_PATH+fileName);
        } else {
            resultsDate = new Result(false, "生成文件失败！");
        }
        return null;
    }
    //生成word文档--任务书签字盖章页
    private String  createPurchaseWord(String id,String ftlName, HttpServletResponse response)
    {

        String  resutl="";
        // 文件路径
        String filePath = TEMP_FILE_PATH;
        // 文件名称
        String fileName =DateUtil.dateToStr(new Date(), DateUtil.FMT_SSS_02)+".doc";
        try {
            List<Map<String, Object>> purchaseEquipmentList = new ArrayList<Map<String, Object>>();
            Map<String, Object> dataMap = new HashMap<String, Object>();
            SrePurchase srePurchase = this.restTemplate.exchange(GET_URL + id, HttpMethod.GET, new HttpEntity<Object>(this.httpHeaders), SrePurchase.class).getBody();
            String purchaseName = srePurchase.getPurchaseName();
            String equipmentIds = srePurchase.getEquipmentId();
            SreEquipment sreEquipment = new SreEquipment();
            String[] arr = equipmentIds.split(",");

            for (int i = 0; i < arr.length; i++) {
                sreEquipment = EquipmentUtils.getSreEquipment(arr[i], restTemplate, httpHeaders);
                String name = sreEquipment.getName();
                String specification = sreEquipment.getSpecification();
                Integer applyAcount = sreEquipment.getApplyAcount();
                BigDecimal unitPrice = sreEquipment.getUnitPrice();
                String unitPathNames = sreEquipment.getUnitPathNames();

                Map<String, Object> map = new HashMap<String, Object>();
                map.put("name",name);
                map.put("specification",specification);
                map.put("applyAcount",applyAcount);
                map.put("unitPrice",unitPrice);
                map.put("unitPathNames",unitPathNames);
                purchaseEquipmentList.add(map);
            }
            dataMap.put("purchaseEquipmentList",purchaseEquipmentList);
            dataMap.put("purchaseName",purchaseName);
            
            /** 生成word */
            boolean flage= WordUtil.createWord(dataMap, ftlName, filePath, fileName);
            if(flage==true)
            {
                resutl=fileName;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return resutl;
    }







    public HttpServletResponse download(String path, HttpServletResponse response)
    {
        try {
            // path是指欲下载的文件的路径。
            File file = new File(path);
            // 取得文件名。
            String filename = file.getName();
            // 取得文件的后缀名。
            String ext = filename.substring(filename.lastIndexOf(".") + 1).toUpperCase();

            // 以流的形式下载文件。
            InputStream fis = new BufferedInputStream(new FileInputStream(path));
            byte[] buffer = new byte[fis.available()];
            fis.read(buffer);
            fis.close();
            // 清空response
            response.reset();
            // 设置response的Header
            response.setCharacterEncoding("UTF-8");
            response.addHeader("Content-Disposition", "attachment;filename=" + new String(filename.getBytes()));
            response.addHeader("Content-Length", "" + file.length());
            OutputStream toClient = new BufferedOutputStream(response.getOutputStream());
            response.setContentType("application/octet-stream");
            toClient.write(buffer);
            toClient.flush();
            toClient.close();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        return response;
    }




    public  boolean deleteFile(String fileName)
    {
        File file = new File(fileName);
        // 如果文件路径所对应的文件存在，并且是一个文件，则直接删除
        if (file.exists() && file.isFile())
        {
            if (file.delete())
            {
                System.out.println("删除单个文件" + fileName + "成功！");
                return true;
            } else
            {
                System.out.println("删除单个文件" + fileName + "失败！");
                return false;
            }
        } else
        {
            System.out.println("删除单个文件失败：" + fileName + "不存在！");
            return false;
        }
    }
    /* =================================生成word文档  END================================*/
}
