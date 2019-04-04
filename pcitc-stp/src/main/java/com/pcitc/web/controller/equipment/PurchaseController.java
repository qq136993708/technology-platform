package com.pcitc.web.controller.equipment;


import java.io.PrintWriter;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.pcitc.base.common.Constant;
import com.pcitc.base.common.Result;
import com.pcitc.base.common.enums.RequestProcessStatusEnum;
import com.pcitc.base.stp.equipment.SreEquipment;
import com.pcitc.base.util.DateUtil;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSONObject;
import com.pcitc.base.common.LayuiTableData;
import com.pcitc.base.common.LayuiTableParam;
import com.pcitc.base.stp.equipment.SreProject;
import com.pcitc.base.stp.equipment.UnitField;
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

    private static final String ADD_URL = "http://pcitc-zuul/stp-proxy/sre-provider/project_basic/add";
    private static final String UPDATE_URL = "http://pcitc-zuul/stp-proxy/sre-provider/project_basic/update";


    //跳转到采购申请页面
	@RequestMapping(value = "/sre_purchase/to-list")
	public String list(HttpServletRequest request, HttpServletResponse response) {

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


		String leadUnitName =  "";
		String leadUnitCode =  "";
		String unitPathIds =   sysUserInfo.getUnitPath();
		if(!unitPathIds.equals(""))
		{
			if(unitPathIds.length()>4)
			{
				String	parentUnitPathIds=unitPathIds.substring(0, unitPathIds.length()-4);
				SysUnit sysUnit=EquipmentUtils.getUnitByUnitPath(parentUnitPathIds, restTemplate, httpHeaders);
				if(sysUnit!=null)
				{
					leadUnitName = sysUnit.getUnitName();
					leadUnitCode =sysUnit.getUnitCode();
				}
			}
		}
		String createUserName=sysUserInfo.getUserDisp();
		String createUserId=sysUserInfo.getUserName();
		String documentDoc= IdUtil.createFileIdByTime();
		String beginYear=EquipmentUtils.getCurrrentYear();
		String endYear=String.valueOf(Integer.valueOf(beginYear).intValue()+1);
		String id = CommonUtil.getParameter(request, "id", "");
		request.setAttribute("id", id);
		if(!id.equals(""))
		{
			ResponseEntity<SreProject> responseEntity = this.restTemplate.exchange(GET_URL + id, HttpMethod.GET, new HttpEntity<Object>(this.httpHeaders), SreProject.class);
			int statusCode = responseEntity.getStatusCodeValue();

			SreProject sreEquipment = responseEntity.getBody();
			request.setAttribute("sreProjectBasic", sreEquipment);

			leadUnitName = sreEquipment.getLeadUnitName();
			leadUnitCode = sreEquipment.getLeadUnitCode();
			createUserId= sreEquipment.getCreateUserId();
			documentDoc=sreEquipment.getDocumentDoc();
			beginYear		= sreEquipment.getBeginYear();
			endYear		= sreEquipment.getEndYear();
		}
		request.setAttribute("createUserName",createUserName);
		request.setAttribute("documentDoc", documentDoc);
		request.setAttribute("leadUnitName", leadUnitName);
		request.setAttribute("leadUnitCode", leadUnitCode);
		request.setAttribute("createUserId", createUserId);
		request.setAttribute("endYear", endYear);
		request.setAttribute("beginYear", beginYear);
		logger.info("============远程返回  beginYear " + beginYear);
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
        String auditStatus = CommonUtil.getParameter(request, "auditStatus", Constant.AUDIT_STATUS_DRAFT);
        String userIds = CommonUtil.getParameter(request, "userIds", "");
        String equipmentIds = CommonUtil.getParameter(request, "equipmentIds", "");
        String remarks = CommonUtil.getParameter(request, "remarks", "");
        String beginYear = CommonUtil.getParameter(request, "beginYear", "");
        String endYear = CommonUtil.getParameter(request, "endYear", "");
        String projectType = CommonUtil.getParameter(request, "projectType", "");
        String keyWord = CommonUtil.getParameter(request, "keyWord", "");
        String projectLeader = CommonUtil.getParameter(request, "projectLeader", "");
        String erpNum = CommonUtil.getParameter(request, "erpNum", "");
        String documentDoc = CommonUtil.getParameter(request, "documentDoc", "");
        String joinUnitName = CommonUtil.getParameter(request, "joinUnitName", "");
        String joinUnitCode = CommonUtil.getParameter(request, "joinUnitCode", "");
        String leadLinkmansName = CommonUtil.getParameter(request, "leadLinkmansName", "");
        String leadLinkmansCode = CommonUtil.getParameter(request, "leadLinkmansCode", "");
        String leadUnitType = CommonUtil.getParameter(request, "leadUnitType", "");
        String professional = CommonUtil.getParameter(request, "professional", "");
        String projectChargesName = CommonUtil.getParameter(request, "projectChargesName", "");
        String projectChargesCode = CommonUtil.getParameter(request, "projectChargesCode", "");
        String contractNum = CommonUtil.getParameter(request, "contractNum", "");
        String setupYear = CommonUtil.getParameter(request, "setupYear", "");
        String leadUnitName = CommonUtil.getParameter(request, "leadUnitName", "");
        String leadUnitCode = CommonUtil.getParameter(request, "leadUnitCode", "");
        String entrustUnitCode = CommonUtil.getParameter(request, "entrustUnitCode", "");
        String entrustUnitName = CommonUtil.getParameter(request, "entrustUnitName", "");
        String isWorkFlow = CommonUtil.getParameter(request, "isWorkFlow", "0");
        String functionId = CommonUtil.getParameter(request, "functionId", "");
        String yearFeeStr = CommonUtil.getParameter(request, "yearFeeStr", "");

        String belongDepartmentName = CommonUtil.getParameter(request, "belongDepartmentName", "");
        String belongDepartmentCode = CommonUtil.getParameter(request, "belongDepartmentCode", "");
        String professionalDepartName = CommonUtil.getParameter(request, "professionalDepartName", "");
        String professionalDepartCode = CommonUtil.getParameter(request, "professionalDepartCode", "");
        String taskWriteUserNames = CommonUtil.getParameter(request, "taskWriteUserNames", "");
        String taskWriteUsersIds = CommonUtil.getParameter(request, "taskWriteUsersIds", "");
        String professionalFieldName = CommonUtil.getParameter(request, "professionalFieldName", "");
        String professionalFieldCode = CommonUtil.getParameter(request, "professionalFieldCode", "");
        String unitPathIds =   CommonUtil.getParameter(request, "unitPathIds",sysUserInfo.getUnitPath());
        String unitPathNames = CommonUtil.getParameter(request, "unitPathNames", sysUserInfo.getUnitName());
        String yearFeeStrJoinUnit = CommonUtil.getParameter(request, "yearFeeStrJoinUnit", "");

        String projectMoney = CommonUtil.getParameter(request, "projectMoney", "");



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

        SreProject sreProjectBasic = null;
        ResponseEntity<String> responseEntity = null;
        // 判断是新增还是修改
            if (id.equals(""))
        {
            sreProjectBasic = new SreProject();
            sreProjectBasic.setCreateDate(new Date());
            sreProjectBasic.setCreateUserId(sysUserInfo.getUserId());
            sreProjectBasic.setCreateUserName(sysUserInfo.getUserDisp());

            String idv = UUID.randomUUID().toString().replaceAll("-", "");
            sreProjectBasic.setId(idv);
            sreProjectBasic.setAuditStatus(auditStatus);
        } else
        {
            ResponseEntity<SreProject> se = this.restTemplate.exchange(GET_URL + id, HttpMethod.GET, new HttpEntity<Object>(this.httpHeaders), SreProject.class);
            sreProjectBasic = se.getBody();
        }
        // 流程状态
            sreProjectBasic.setAuditStatus(auditStatus);


            sreProjectBasic.setProjectMoney(new BigDecimal(projectMoney));
            sreProjectBasic.setUnitPathIds(unitPathIds);
            sreProjectBasic.setUnitPathNames(unitPathNames);
            sreProjectBasic.setParentUnitPathIds(parentUnitPathIds);
            sreProjectBasic.setParentUnitPathNames(parentUnitPathNames);
            sreProjectBasic.setProfessionalFieldCode(professionalFieldCode);
            sreProjectBasic.setProfessionalFieldName(professionalFieldName);
            sreProjectBasic.setYearFeeStr(yearFeeStr);
            sreProjectBasic.setDocumentDoc(documentDoc);
            sreProjectBasic.setName(name);
            sreProjectBasic.setEquipmentIds(equipmentIds);
            sreProjectBasic.setSetupYear(DateUtil.dateToStr(new Date(), DateUtil.FMT_YYYY));
            sreProjectBasic.setRemarks(remarks);
            sreProjectBasic.setBeginYear(beginYear);
            sreProjectBasic.setEndYear(endYear);
            sreProjectBasic.setKeyWord(keyWord);
            sreProjectBasic.setProjectType(projectType);
            sreProjectBasic.setProjectLeader(projectLeader);
            sreProjectBasic.setJoinUnitName(joinUnitName);
            sreProjectBasic.setJoinUnitCode(joinUnitCode);
            sreProjectBasic.setLeadLinkmansName(leadLinkmansName);
            sreProjectBasic.setLeadLinkmansCode(leadLinkmansCode);
            sreProjectBasic.setLeadUnitType(leadUnitType);
            sreProjectBasic.setErpNum(erpNum);
            sreProjectBasic.setProfessional(professional);
            sreProjectBasic.setBelongDepartmentName(belongDepartmentName);
            sreProjectBasic.setBelongDepartmentCode(belongDepartmentCode);
            sreProjectBasic.setProfessionalDepartName(professionalDepartName);
            sreProjectBasic.setProfessionalDepartCode(professionalDepartCode);
            sreProjectBasic.setProjectChargesName(projectChargesName);
            sreProjectBasic.setProjectChargesCode(projectChargesCode);
            sreProjectBasic.setIsContract("0");
            sreProjectBasic.setContractNum(contractNum);
            sreProjectBasic.setSetupYear(setupYear);
            sreProjectBasic.setLeadUnitName(leadUnitName);
            sreProjectBasic.setLeadUnitCode(leadUnitCode);
            sreProjectBasic.setEntrustUnitCode(entrustUnitCode);
            sreProjectBasic.setEntrustUnitName(entrustUnitName);
            sreProjectBasic.setApplyUnitCode(sysUserInfo.getUnitCode());
            sreProjectBasic.setApplyUnitName(sysUserInfo.getUnitName());
            sreProjectBasic.setTaskWriteUserNames(taskWriteUserNames);
            sreProjectBasic.setTaskWriteUsersIds(taskWriteUsersIds);
            sreProjectBasic.setSetupYear(DateUtil.dateToStr(new Date(), DateUtil.FMT_YYYY));
            sreProjectBasic.setYearFeeStrJoinUnit(yearFeeStrJoinUnit);
        // 判断是新增还是修改
            if (id.equals(""))
        {
            responseEntity = this.restTemplate.exchange(ADD_URL, HttpMethod.POST, new HttpEntity<SreProject>(sreProjectBasic, this.httpHeaders), String.class);

        } else {
            responseEntity = this.restTemplate.exchange(UPDATE_URL, HttpMethod.POST, new HttpEntity<SreProject>(sreProjectBasic, this.httpHeaders), String.class);
        }
        // 返回结果代码
        int statusCode = responseEntity.getStatusCodeValue();
            if (statusCode == 200)
        {
            //如果是提交
            if(isWorkFlow.equals("1"))
            {
                String dataId = sreProjectBasic.getId();
                resultsDate.setData(dataId);
                resultsDate.setSuccess(true);
            }
            String arr[]=equipmentIds.split(",");
            if(arr!=null && arr.length>0)
            {
                for(int i=0;i<arr.length;i++)
                {
                    String tempid=arr[i];
                    if(tempid!=null && !tempid.equals(""))
                    {
                        SreEquipment sreEquipment=EquipmentUtils.getSreEquipment(tempid, restTemplate, httpHeaders);
                        sreEquipment.setIsLinkedProject("1");
                        EquipmentUtils.updateSreEquipment(sreEquipment, restTemplate, httpHeaders);
                    }
                }
            }

        } else
        {
            resultsDate = new Result(false, RequestProcessStatusEnum.SERVER_BUSY.getStatusDesc());
        }
            return resultsDate;
    }
}
