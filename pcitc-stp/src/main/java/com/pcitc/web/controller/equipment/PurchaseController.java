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
import com.pcitc.base.stp.equipment.SrePurchase;
import com.pcitc.base.util.DateUtil;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

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

    private static final String ADD_URL = "http://pcitc-zuul/stp-proxy/sre-provider/purchase/add";
    private static final String UPDATE_URL = "http://pcitc-zuul/stp-proxy/sre-provider/project_basic/update";
    private static final String DEL_URL = "http://pcitc-zuul/stp-proxy/sre-provider/purchase/delete/";


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
        String topicId = CommonUtil.getParameter(request, "topicId", "");
        String taskWriteUsersIds = CommonUtil.getParameter(request, "taskWriteUsersIds", "");
        String equipmentIds = CommonUtil.getParameter(request, "equipmentIds", "");
        String leadUnitCode = CommonUtil.getParameter(request, "leadUnitCode", "");
        String createUserName = CommonUtil.getParameter(request, "createUserName", "");
        String createUserId = CommonUtil.getParameter(request, "createUserId", "");
        /*CommonUtil.getParameter(request,"name","");*/
        String leadUnitName = CommonUtil.getParameter(request, "leadUnitName", "");
        String purchaseName = CommonUtil.getParameter(request, "purchaseName", "");
        //状态  String auditStatus = CommonUtil.getParameter(request, "auditStatus", Constant.AUDIT_STATUS_DRAFT);
        String unitPathIds =   CommonUtil.getParameter(request, "unitPathIds",sysUserInfo.getUnitPath());
        String unitPathNames = CommonUtil.getParameter(request, "unitPathNames", sysUserInfo.getUnitName());



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
            srePurchase.setDepartCode(sysUserInfo.getUserId());//部门code
            srePurchase.setDepartName(sysUserInfo.getUserDisp());//部门名称

            String idv = UUID.randomUUID().toString().replaceAll("-", "");
            srePurchase.setId(idv);
            //状态 srePurchase.setAuditStatus(auditStatus);
        } else
        {
            ResponseEntity<SrePurchase> se = this.restTemplate.exchange(GET_URL + id, HttpMethod.GET, new HttpEntity<Object>(this.httpHeaders), SrePurchase.class);
            srePurchase = se.getBody();
        }
        // 流程状态
            //srePurchase.setState(auditStatus); ;

         /*purchase_name  采购名称
        proposer_id     采购员ID
        proposer_name   申请人姓名
        parent_unit_path_names 单位名称
        depart_name     部门名称
        depart_code     部门Code
        stage           阶段
        state           状态
        create_date     创建时间
        equipment_id    装备ID
        ischeck         采购合同是否验收
        project_id      计划课题表ID*/

       /* topicId				课题ID
        taskWriteUsersIds		用户ID
        id						ID
        equipmentIds			装备ID
        leadUnitCode			用户code
        createUserName			用户名
        createUserId			登录名
        name					课题名称
        leadUnitName			所属单位
        purchaseName			采购名称*/

            srePurchase.setPurchaseName(purchaseName);//采购名称
            srePurchase.setProposerId(leadUnitCode);//采购员ID
            srePurchase.setProposerName(createUserName);//采购员姓名
            srePurchase.setParentUnitPathNames(leadUnitName);//单位名称
            srePurchase.setEquipmentId(equipmentIds);//装备ID

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
            if (statusCode == 200)
        {
           /* //如果是提交
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
            }*/

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
}
