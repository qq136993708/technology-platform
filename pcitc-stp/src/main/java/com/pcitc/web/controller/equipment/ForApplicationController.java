package com.pcitc.web.controller.equipment;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.pcitc.base.common.Constant;
import com.pcitc.base.common.LayuiTableData;
import com.pcitc.base.common.LayuiTableParam;
import com.pcitc.base.common.Result;
import com.pcitc.base.common.enums.RequestProcessStatusEnum;
import com.pcitc.base.stp.equipment.SreDetail;
import com.pcitc.base.stp.equipment.SreEquipment;
import com.pcitc.base.stp.equipment.SreForApplication;
import com.pcitc.base.stp.equipment.SreProjectTask;
import com.pcitc.base.stp.equipment.SrePurchase;
import com.pcitc.base.stp.equipment.UnitField;
import com.pcitc.base.system.SysDictionary;
import com.pcitc.base.system.SysUnit;
import com.pcitc.base.util.CommonUtil;
import com.pcitc.base.util.DateUtil;
import com.pcitc.base.util.IdUtil;
import com.pcitc.web.common.BaseController;
import com.pcitc.web.config.SpringContextUtil;
import com.pcitc.web.utils.EquipmentUtils;
import com.pcitc.web.utils.WordUtil;

@Controller
public class ForApplicationController extends BaseController {
	
	private static final String PAGE_URL = "http://pcitc-zuul/stp-proxy/sre-provider/forapplication/page";
	private static final String DEL_URL = "http://pcitc-zuul/stp-proxy/sre-provider/forapplication/delete/";
	private static final String ADD_URL = "http://pcitc-zuul/stp-proxy/sre-provider/forapplication/add";
	private static final String LIST_BY_IDS_URL = "http://pcitc-zuul/stp-proxy/sre-provider/equipment/list-by-ids/";
	private static final String GET_URL = "http://pcitc-zuul/stp-proxy/sre-provider/forapplication/get/";
	private static final String VIEW_URL = "http://pcitc-zuul/stp-proxy/sre-provider/forapplication/pageview";
	private static final String EQU_URL = "http://pcitc-zuul/stp-proxy/sre-provider/forapplicationequipment/page";
	private static final String DETAIL_URL = "http://pcitc-zuul/stp-proxy/sre-provider/Detail/add";
	private static final String UPFOR_URL = "http://pcitc-zuul/stp-proxy/sre-provider/forapplication/upfor/";
	private static final String UPDATE_URL = "http://pcitc-zuul/stp-proxy/sre-provider/forapplication/update";
	private static final String PURCHASE_INNER_WORKFLOW_URL = "http://pcitc-zuul/stp-proxy/stp-provider/forapplication/forapplication_activity/";
	//临时导出文件目录
	private static final String TEMP_FILE_PATH = "src/main/resources/tem/";
	/**
	 * 列表
	 * 
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value = "/sre-forapplication/list")
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

	@RequestMapping(value = "/sre-forapplication/to-list")
	public String list(HttpServletRequest request, HttpServletResponse response) throws Exception {
		Map<String, String> map = EquipmentUtils.getDepartInfoBySysUser(sysUserInfo, restTemplate, httpHeaders);
		String parentUnitPathNames = map.get("unitName");// 申报单位
		String parentUnitPathIds = map.get("unitCode");// 申报单位
		String applyDepartName = map.get("applyDepartName");// 申报部门
		String applyDepartCode = map.get("applyDepartCode");// 申报部门
		String unitPathIds= map.get("applyDepartCode");
		String unitPathNames= map.get("applyDepartName");
		String unitPathId = sysUserInfo.getUnitPath();
		boolean isKJBPerson = EquipmentUtils.isKJBPerson(unitPathId);
	    request.setAttribute("isKJBPerson", isKJBPerson);
	    List<SysDictionary> dicList = CommonUtil.getDictionaryByParentCode("ROOT_UNIVERSAL_BDYJY", restTemplate,
				httpHeaders);
	    if(isKJBPerson == true) {
	    	//获取研究院
			request.setAttribute("dictonary", dicList);
			request.setAttribute("str","0");
	    }else {
	    	request.setAttribute("str","1");
	    }
	    String unitCodes =EquipmentUtils.getChildscUnitBycodes(sysUserInfo.getUnitCode(), restTemplate, httpHeaders);
		request.setAttribute("parentUnitPathIds", parentUnitPathIds);
		request.setAttribute("applyDepartCode", applyDepartCode);
		request.setAttribute("unitCodes", unitCodes);
 		return "/stp/equipment/forapplication/application-list";
	}
	
	
	/**
	 * 删除
	 * 
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/sre-forapplication/delete/{applicationId}")
	public String delete(@PathVariable("applicationId") String applicationId, HttpServletRequest request, HttpServletResponse response) throws Exception {
		Result resultsDate = new Result();
		ResponseEntity<Integer> responseEntity = this.restTemplate.exchange(DEL_URL + applicationId, HttpMethod.POST, new HttpEntity<Object>(this.httpHeaders), Integer.class);
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
	 * 列表
	 * 
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value = "/sre-forapplication/listfor")
	@ResponseBody
	public String list(@ModelAttribute("param") LayuiTableParam param, HttpServletRequest request, HttpServletResponse response) {
		
		LayuiTableData layuiTableData = new LayuiTableData();
		HttpEntity<LayuiTableParam> entity = new HttpEntity<LayuiTableParam>(param, httpHeaders);
		ResponseEntity<LayuiTableData> responseEntity = restTemplate.exchange(EQU_URL, HttpMethod.POST, entity, LayuiTableData.class);
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
	 * 
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(method = RequestMethod.GET, value = "/sre-forapplication/add")
	public String add(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		Map<String, String> map = EquipmentUtils.getDepartInfoBySysUser(sysUserInfo, restTemplate, httpHeaders);
		String parentUnitPathNames = map.get("unitName");// 申报单位
		String parentUnitPathIds = map.get("unitCode");// 申报单位
		String applyDepartName = map.get("applyDepartName");// 申报部门
		String applyDepartCode = map.get("applyDepartCode");// 申报部门
		String unitPathIds= map.get("applyDepartCode");
		String unitPathNames= map.get("applyDepartName");

		String firstApplyUser=sysUserInfo.getUserDisp();
		String attachmentDoc= IdUtil.createFileIdByTime();
		String equipmentId = CommonUtil.getParameter(request, "equipmentId", "");
		request.setAttribute("equipmentId", equipmentId);
		if(!equipmentId.equals(""))
		{
			ResponseEntity<SreEquipment> responseEntity = this.restTemplate.exchange(ADD_URL + equipmentId, HttpMethod.GET, new HttpEntity<Object>(this.httpHeaders), SreEquipment.class);
			int statusCode = responseEntity.getStatusCodeValue();
			logger.info("============远程返回  statusCode " + statusCode);
			SreEquipment sreEquipment = responseEntity.getBody();
			request.setAttribute("sreEquipment", sreEquipment);
			
			applyDepartName = sreEquipment.getApplyDepartName();
			applyDepartCode = sreEquipment.getApplyDepartCode();
			firstApplyUser=sreEquipment.getFirstApplyUser();
			attachmentDoc=sreEquipment.getAttachmentDoc();
		}
		String leadUnitName =  "";
		String leadUnitCode =  "";
		request.setAttribute("parentUnitPathIds", parentUnitPathIds);
		request.setAttribute("leadUnitName", leadUnitName);
		request.setAttribute("leadUnitCode", leadUnitCode);
		request.setAttribute("attachmentDoc", attachmentDoc);
		request.setAttribute("applyDepartName", applyDepartName);
		request.setAttribute("applyDepartCode", applyDepartCode);
		request.setAttribute("firstApplyUser", firstApplyUser);
	    String unitCodes =EquipmentUtils.getChildscUnitBycodes(sysUserInfo.getUnitCode(), restTemplate, httpHeaders);
		request.setAttribute("unitCodes", unitCodes);
		//List<SrePurchase>  purchaseList= CommonUtil.getPurchaseNameIDList(restTemplate, httpHeaders);
		//request.setAttribute("purchaseList", purchaseList);
//		List<>  unitFieldList= CommonUtil.getUnitNameList(restTemplate, httpHeaders);
//		request.setAttribute("unitFieldList", unitFieldList);
		return "/stp/equipment/forapplication/application-add";
	}
	
	
	@RequestMapping(value = "/sre-forapplicatio/purchaseNameIds")
	@ResponseBody
	public String chooseEquipmentByIds(HttpServletRequest request, HttpServletResponse response) {
		LayuiTableData layuiTableData = new LayuiTableData();
		ResponseEntity<List> responseEntity = null;
		List returnlist = new ArrayList();
		String ids = CommonUtil.getParameter(request, "purchaseNameIds", "");
		if (!ids.equals("")) 
		{
			String chkbox[] = ids.split(",");
			if (chkbox != null && chkbox.length > 0)
			{
				List<String> list = Arrays.asList(chkbox);
				JSONArray jsonObject = JSONArray.parseArray(JSON.toJSONString(list));
				HttpEntity<String> entity = new HttpEntity<String>(jsonObject.toString(), httpHeaders);
				responseEntity = restTemplate.exchange(LIST_BY_IDS_URL, HttpMethod.POST, entity, List.class);
				int statusCode = responseEntity.getStatusCodeValue();
				if (statusCode == 200) 
				{
					returnlist = responseEntity.getBody();
				}
			}
		}
			
		layuiTableData.setData(returnlist);
		layuiTableData.setCode(0);
		layuiTableData.setCount(returnlist.size());
		JSONObject result = JSONObject.parseObject(JSONObject.toJSONString(layuiTableData));
		//logger.info("============result" + result);
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
	@ResponseBody
	@RequestMapping(method = RequestMethod.POST, value = "/sre-forapplicatio/save")
	public String savePrivilege(String[] arr,String equipmentIds,String froname,String companyCode,HttpServletResponse response) throws Exception{ 
		List<String> sList = new ArrayList<String>();
		List<String> list = new ArrayList<String>();
		Collections.addAll(sList, arr);
		for(String tr : sList) {
			if(!tr.equals("")) {
				list.add(tr);
			}
		}
		String[] strArray = list.toArray(new String[list.size()]); 
		String result = "";
		SreForApplication pplication = new SreForApplication();
		ResponseEntity<String> responseEntity = null;
		ResponseEntity<String> respo = null;
		Map<String, String> map = EquipmentUtils.getDepartInfoBySysUser(sysUserInfo, restTemplate, httpHeaders);
		String parentUnitPathNames = map.get("unitName");// 申报单位
		String parentUnitPathIds = map.get("unitCode");// 申报单位
		String applyDepartName = map.get("applyDepartName");// 申报部门
		String applyDepartCode = map.get("applyDepartCode");// 申报部门
		String unitPathIds= map.get("applyDepartCode");
		String unitPathNames= map.get("applyDepartName");

		String UserDisp = sysUserInfo.getUserDisp();
		String firstApplyUser=sysUserInfo.getUnitPath();
		String attachmentDoc= IdUtil.createFileIdByTime();

		String id = UUID.randomUUID().toString().replaceAll("-", "");
		pplication.setApplicationId(id);
		pplication.setApplyDepartName(applyDepartName);
		pplication.setApplyDepartCode(applyDepartCode);
		pplication.setFirstApplyUser(parentUnitPathIds);
		pplication.setApplicationName(froname);//转资名称
		pplication.setApplicationTime(new Date());//申请时间
		pplication.setApplicationUserName(UserDisp);//当前操作人
		pplication.setApplicationPurchaseid(equipmentIds);//装备ID
		pplication.setCompanyCode(companyCode);//公司代码
		pplication.setApplicationState(Constant.OK_ZERO);//申请状态
		responseEntity = this.restTemplate.exchange(ADD_URL, HttpMethod.POST, new HttpEntity<SreForApplication>(pplication, this.httpHeaders), String.class);
		int statusCode = responseEntity.getStatusCodeValue();
		if(statusCode == 200) {
		String[] equipment = equipmentIds.split(",");
		for(int i = 0; i < equipment.length; i++) {
			SreDetail sreDeta = new SreDetail();
			String equipequipId = equipment[i];
			SreEquipment squipment=EquipmentUtils.getSreEquipment(equipequipId, restTemplate, httpHeaders);
			String sreDetaid = UUID.randomUUID().toString().replaceAll("-", "");
			sreDeta.setId(sreDetaid);//ID
			sreDeta.setEquipmentId(equipequipId);//装备ID
			sreDeta.setEquipmentName(squipment.getName());//装备名称
			sreDeta.setEquipmentType(squipment.getType());//装备分类
			sreDeta.setNationality(Constant.OK_ZERO);//转资状态
			sreDeta.setEquipmentPrice(squipment.getUnitPrice().toString());//装备单价
			sreDeta.setEquipmenNumber(String.valueOf(squipment.getApplyAcount()));//申请数量
			sreDeta.setDeclareUnit(squipment.getParentUnitPathNames());//申报单位
			sreDeta.setDeclareDepartment(squipment.getApplyDepartName());//申报部门
			sreDeta.setDeclareTime(new Date());//转资时间
			sreDeta.setDeclarePeople(squipment.getFirstApplyUser());//第一申报人
			sreDeta.setDeclareTime(squipment.getCreateDate());//申报时间
			sreDeta.setUnitPathIds(parentUnitPathIds);//子ID
			sreDeta.setParentUnitPathIds(applyDepartCode);//父ID
			sreDeta.setSupplier(companyCode);
			sreDeta.setConfigure(id);//转资申请ID
			sreDeta.setIsscrap(Constant.EQUME_ZERO);
			if(arr!=null) {
			for(int j=0;j<strArray.length;j++){
				if(i == j) {
					sreDeta.setAssetNumber(strArray[j]);//资产编号
				}
	         }
			}
				respo = this.restTemplate.exchange(DETAIL_URL, HttpMethod.POST, new HttpEntity<SreDetail>(sreDeta, this.httpHeaders), String.class);
				statusCode = respo.getStatusCodeValue();
				if(statusCode == 200) {
					 result = "1";
				}else {
					 result = "2";
				}
		 	}
		
		  }else {
			  result = "2";
		  }
		JSONObject jObject=new JSONObject();
		jObject.put("result", result);
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		out.println(jObject.toString());
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
	@RequestMapping(value = "/sre-forapplication/get/{applicationId}", method = RequestMethod.GET)
	public String get(@PathVariable("applicationId") String applicationId, HttpServletRequest request, HttpServletResponse response) throws Exception {
		ResponseEntity<SreForApplication> responseEntity = this.restTemplate.exchange(GET_URL + applicationId, HttpMethod.GET, new HttpEntity<Object>(this.httpHeaders), SreForApplication.class);
		int statusCode = responseEntity.getStatusCodeValue();
		logger.info("============远程返回  statusCode " + statusCode);
		SreForApplication pplication =  responseEntity.getBody();
		request.setAttribute("pplication", pplication);
		return "/stp/equipment/forapplication/application-view";
	}
	
	/**
	 * 详情列表
	 * 
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value = "/sre-forapplication/listView")
	@ResponseBody
	public String listView(@ModelAttribute("param") LayuiTableParam param, HttpServletRequest request, HttpServletResponse response) {
		
		LayuiTableData layuiTableData = new LayuiTableData();
		HttpEntity<LayuiTableParam> entity = new HttpEntity<LayuiTableParam>(param, httpHeaders);
		ResponseEntity<LayuiTableData> responseEntity = restTemplate.exchange(VIEW_URL, HttpMethod.POST, entity, LayuiTableData.class);
		int statusCode = responseEntity.getStatusCodeValue();
		if (statusCode == 200) {
			layuiTableData = responseEntity.getBody();
		}
		JSONObject result = JSONObject.parseObject(JSONObject.toJSONString(layuiTableData));
		logger.info("============result" + result);
		return result.toString();
	}
	
	/**
	 * 上报
	 * 
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/sre-forapplication/upforapplication/{applicationId}")
	public String upforapplication(@PathVariable("applicationId") String applicationId, HttpServletRequest request, HttpServletResponse response) throws Exception {
		Result resultsDate = new Result();
		ResponseEntity<Integer> responseEntity = this.restTemplate.exchange(UPFOR_URL + applicationId, HttpMethod.POST, new HttpEntity<Object>(this.httpHeaders), Integer.class);
		int statusCode = responseEntity.getStatusCodeValue();
		int status = responseEntity.getBody();
		logger.info("============远程返回  statusCode " + statusCode + "  status=" + status);
		if (responseEntity.getBody() > 0) {
			resultsDate = new Result(true);
		} else {
			resultsDate = new Result(false, "上报失败失败，请联系系统管理员！");
		}
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		JSONObject ob = JSONObject.parseObject(JSONObject.toJSONString(resultsDate));
		out.println(ob.toString());
		out.flush();
		out.close();
		return null;
	}
	
	//转资申请审批工作流
    @RequestMapping(value = "/sre-forapplication/forapplication_workflow")
    @ResponseBody
    public Object forapplicationWorkflow(HttpServletRequest request, HttpServletResponse response) throws Exception
    {
    	
    	
        this.httpHeaders.setContentType(MediaType.APPLICATION_JSON_UTF8);//设置参数类型和编码
        String id = CommonUtil.getParameter(request, "id", "");
        String functionId = CommonUtil.getParameter(request, "functionId", "");
        String userIds = CommonUtil.getParameter(request, "userIds", "");
        System.out.println("============start_purchase_workflow userIds="+userIds+" functionId="+functionId+" id="+id);

        SreForApplication pplication = this.restTemplate.exchange(GET_URL + id, HttpMethod.GET, new HttpEntity<Object>(this.httpHeaders), SreForApplication.class).getBody();

        Map<String ,Object> paramMap = new HashMap<String ,Object>();
        paramMap.put("id", id);
        paramMap.put("functionId", functionId);
        paramMap.put("processInstanceName", "转资申请确认->"+pplication.getApplicationName());
        paramMap.put("authenticatedUserId", sysUserInfo.getUserId());
        paramMap.put("authenticatedUserName", sysUserInfo.getUserDisp());
        paramMap.put("auditor", userIds);
        //申请者机构信息
        paramMap.put("applyUnitCode", sysUserInfo.getUnitCode());
        String parentApplyUnitCode=EquipmentUtils.getUnitParentCodesByUnitCodes(sysUserInfo.getUnitCode(), restTemplate, httpHeaders);
        paramMap.put("parentApplyUnitCode", parentApplyUnitCode);


     HttpEntity<Map<String, Object>> httpEntity = new HttpEntity<Map<String, Object>>(paramMap,this.httpHeaders);
        //return null;
        Result rs = this.restTemplate.exchange(PURCHASE_INNER_WORKFLOW_URL + id, HttpMethod.POST, httpEntity, Result.class).getBody();
        return rs;
    }
    
    /* =================================生成word文档  START================================*/
    //生成采购单word模板
    @RequestMapping(value = "/sre-forApplication/createWord/{id}", method = RequestMethod.GET)
    @ResponseBody
    public String createWord(@PathVariable("id") String id, HttpServletRequest request, HttpServletResponse response) throws Exception
    {
        Result resultsDate = new Result();
        String fileName=createPurchaseWord( id,"forApplication.ftl",  response);
        if (!fileName.equals(""))
        {
            resultsDate = new Result(true);
            //download(TEMP_FILE_PATH+fileName, response);
            //deleteFile(TEMP_FILE_PATH+fileName);
			WordUtil.download_new(fileName, response);
			WordUtil.deleteFile_new(fileName);
		} else {
            resultsDate = new Result(false, "生成文件失败！");
        }
        return null;
    }
    //生成采购单word数据
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
            SreForApplication sreForApplication = this.restTemplate.exchange(GET_URL + id, HttpMethod.GET, new HttpEntity<Object>(this.httpHeaders), SreForApplication.class).getBody();
           if(sreForApplication!=null) {
        	   String applicationpurchaseid[] = sreForApplication.getApplicationPurchaseid().split(",");

            for (int i = 0; i < applicationpurchaseid.length; i++) {
            	SreDetail sreDetail = EquipmentUtils.getSreDetail(applicationpurchaseid[i], restTemplate, httpHeaders);
                if(sreDetail!=null){
                	SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                    String dateString = formatter.format(sreForApplication.getApplicationTime());
                    Map<String, Object> map = new HashMap<String, Object>();
                    map.put("applicationName",sreForApplication.getApplicationName());
                    map.put("applicationTime",dateString);
                    map.put("applicationUserName",sreForApplication.getApplicationUserName());
                    map.put("companyCode",sreForApplication.getCompanyCode());
                    map.put("name",sreDetail.getEquipmentName());
                    map.put("equipmentPrice",sreDetail.getEquipmentPrice());
                    map.put("equipmenNumber",sreDetail.getEquipmenNumber());
                    map.put("declareUnit",sreDetail.getDeclareUnit());
                    map.put("assetNumber",sreDetail.getAssetNumber());
                    purchaseEquipmentList.add(map);
                }
            }

            }
            dataMap.put("purchaseEquipmentList",purchaseEquipmentList);
            dataMap.put("applicationName",sreForApplication.getApplicationName());
            
            /** 生成word */
            //boolean flage= WordUtil.createWord(dataMap, ftlName, filePath, fileName);
			boolean flage = WordUtil.createWord_new( request,dataMap, ftlName, fileName);
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
    
    /**
     * 上传附件
     * @param request
     * @param response
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "/sre-forapplication/upFileDoc")
    public String upFileDoc(HttpServletRequest request, HttpServletResponse response) throws Exception {
        String id = CommonUtil.getParameter(request, "id", "");
        request.setAttribute("id", id);
        if(!id.equals(""))
        {
        	ResponseEntity<SreForApplication> responseEntity = this.restTemplate.exchange(GET_URL + id, HttpMethod.GET, new HttpEntity<Object>(this.httpHeaders), SreForApplication.class);
            SreForApplication sreForApplication = responseEntity.getBody();
            request.setAttribute("sreForApplication", sreForApplication);
            String applicationUpload = sreForApplication.getApplicationUpload();
                if(applicationUpload==null || applicationUpload.equals(""))
                {
                	applicationUpload= IdUtil.createFileIdByTime();
                }
                request.setAttribute("applicationUpload", applicationUpload);
        }
        return "/stp/equipment/forapplication/upFileDoc";
    }
    @RequestMapping(value = "/sre-forapplication/updateFileDoc")
    public String updateFileDoc(HttpServletRequest request, HttpServletResponse response) throws Exception {

        Result resultsDate = new Result();
        String id = CommonUtil.getParameter(request, "id", "");
        String applicationUpload = CommonUtil.getParameter(request, "applicationUpload", "");
        String resutl="";

        int statusCodeValue = 0;
        if(!id.equals(""))
        {
                ResponseEntity<SreForApplication> responseEntity = this.restTemplate.exchange(GET_URL + id, HttpMethod.GET, new HttpEntity<Object>(this.httpHeaders), SreForApplication.class);
                SreForApplication sreForApplication = responseEntity.getBody();
                sreForApplication.setApplicationUpload(applicationUpload);
                ResponseEntity<String>  exchange = this.restTemplate.exchange(UPDATE_URL, HttpMethod.POST, new HttpEntity<SreForApplication>(sreForApplication, this.httpHeaders), String.class);
                statusCodeValue = responseEntity.getStatusCodeValue();
        }
        if (statusCodeValue==200)
        {
        	ResponseEntity<Integer> responseEntity = this.restTemplate.exchange(UPFOR_URL + id, HttpMethod.POST, new HttpEntity<Object>(this.httpHeaders), Integer.class);
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
}