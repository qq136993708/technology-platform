package com.pcitc.web.controller.equipment;

import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSONObject;
import com.pcitc.base.common.LayuiTableData;
import com.pcitc.base.common.LayuiTableParam;
import com.pcitc.base.common.Result;
import com.pcitc.base.stp.equipment.SreDetail;
import com.pcitc.base.stp.equipment.SreEquipment;
import com.pcitc.base.stp.equipment.SreForApplication;
import com.pcitc.base.stp.equipment.SrePlanImplement;
import com.pcitc.base.system.SysDictionary;
import com.pcitc.base.util.CommonUtil;
import com.pcitc.base.util.IdUtil;
import com.pcitc.web.common.BaseController;
import com.pcitc.web.utils.EquipmentUtils;

@Controller
public class PlanImplementController extends BaseController {
	
	private static final String PAGE_URL = "http://pcitc-zuul/stp-proxy/sre-provider/planImplement/page";
	private static final String ADD_URL = "http://pcitc-zuul/stp-proxy/sre-provider/planImplement/add";
	private static final String GET_URL = "http://pcitc-zuul/stp-proxy/sre-provider/planImplement/get/";
	private static final String DEL_URL = "http://pcitc-zuul/stp-proxy/sre-provider/planImplement/delete/";
	private static final String UPDATE_URL = "http://pcitc-zuul/stp-proxy/sre-provider/planImplement/updata";
	
	
	/**
	 * 规划发布数据获取
	 * 
	 * @param requestPAGE_URL
	 * @param response
	 * @return
	 */
	@RequestMapping(value = "/sre-planImplement/list")
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
	 * 规划发布页列表
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/sre-planImplement/to-list")
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
	    List<SysDictionary>  dictonary= CommonUtil.getDictionaryByParentCode("ROOT_FZJCZX_YS", restTemplate, httpHeaders);
		request.setAttribute("unitPathIds", unitPathIds);//父id
		request.setAttribute("parentUnitPathIds", parentUnitPathIds);//子id
		request.setAttribute("parentUnitPathNames", parentUnitPathNames);//研究院
		request.setAttribute("applyDepartName", applyDepartName);//当前部门
		String str  ="0";
	    if(isKJBPerson == true) {
	    	//获取研究院
	    }else {
	    	str="1";
	    }
	    request.setAttribute("str",str);
	    String unitCodes =EquipmentUtils.getChildscUnitBycodes(sysUserInfo.getUnitCode(), restTemplate, httpHeaders);
	    request.setAttribute("unitCodes", unitCodes);
		return "/stp/equipment/planImplement/planImplement-list";
	}
	
	/**
	 *  规划新增页
	 */
	@RequestMapping(method = RequestMethod.GET, value = "/sre-planImplement/add")
	public String add(HttpServletRequest request, HttpServletResponse response) throws Exception {
		Map<String, String> map = EquipmentUtils.getDepartInfoBySysUser(sysUserInfo, restTemplate, httpHeaders);
		String parentUnitPathNames = map.get("unitName");// 申报单位
		String parentUnitPathIds = map.get("unitCode");// 申报单位
		String applyDepartName = map.get("applyDepartName");// 申报部门
		String applyDepartCode = map.get("applyDepartCode");// 申报部门
		String unitPathIds= map.get("applyDepartCode");
		String unitPathNames= map.get("applyDepartName");
		String unitPathId = sysUserInfo.getUnitPath();
		String UserDisp = sysUserInfo.getUserDisp();//申请人
		boolean isKJBPerson = EquipmentUtils.isKJBPerson(unitPathId);
	    request.setAttribute("isKJBPerson", isKJBPerson);
		request.setAttribute("unitPathIds", unitPathIds);//父id
		request.setAttribute("parentUnitPathIds", parentUnitPathIds);//子id
		request.setAttribute("parentUnitPathNames", parentUnitPathNames);//研究院
		request.setAttribute("applyDepartName", applyDepartName);//当前部门
		request.setAttribute("UserDisp", UserDisp);//申请人
		return "/stp/equipment/planImplement/planImplement-add";
	}
	
	/**
	 * 保存————新增
	 * @param applicationId
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	@ResponseBody
	@RequestMapping(method = RequestMethod.POST, value = "/sre-planImplement/save")
	public String upforapplication(String publicationTitle,String content,String publicationType,
					String publicDate,String publicationState,String publisher,String unitPathIds,
					String parentUnitPathIds,String parentUnitPathNames,String applyDepartName,
			HttpServletRequest request, HttpServletResponse response) throws Exception {
		String resultsDate = "";
		ResponseEntity<String> respo = null;
		SrePlanImplement mplement = new SrePlanImplement();
		String id = UUID.randomUUID().toString().replaceAll("-", "");
		mplement.setId(id);//表ID
		mplement.setResearchinstitute(parentUnitPathNames);//研究院
		mplement.setPublicationTitle(publicationTitle);//规划标题
		mplement.setPublicationType(publicationType);//发布类型
		mplement.setPublisher(publisher);//发布人
		mplement.setPublicationText(content);//发布内容
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		//publicDate = publicDate +" 00:00:00";
		mplement.setPublicationMonth(publicDate);//发布时间
		mplement.setPublicationState(publicationState);//发布状态
		mplement.setSonId(unitPathIds);//子ID
		mplement.setLevelId(parentUnitPathIds);//父ID
		mplement.setCreationTime(new Date());//创建时间
		mplement.setLevelName(applyDepartName);//部门名称
		respo = this.restTemplate.exchange(ADD_URL, HttpMethod.POST, new HttpEntity<SrePlanImplement>(mplement, this.httpHeaders), String.class);
		int statusCode = respo.getStatusCodeValue();
		String status = respo.getBody();
		logger.info("============远程返回  statusCode " + statusCode + "  status=" + status);
		if (Integer.valueOf(status) > 0) {
			resultsDate = "1";
		} else {
			resultsDate = "新增失败，请联系系统管理员！";
		}
		JSONObject jObject=new JSONObject();
		jObject.put("resultsDate", resultsDate);
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		out.println(jObject.toString());
		out.flush();
		out.close();
		return null;
	}
	
	/**
	 *  规划编辑页
	 * 
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/sre-planImplement/get/{id}", method = RequestMethod.GET)
	public String getPlanImplement(@PathVariable("id") String id, HttpServletRequest request, HttpServletResponse response) throws Exception {
		ResponseEntity<SrePlanImplement> responseEntity = this.restTemplate.exchange(GET_URL + id, HttpMethod.GET, new HttpEntity<Object>(this.httpHeaders), SrePlanImplement.class);
		int statusCode = responseEntity.getStatusCodeValue();
		Map<String, String> map = EquipmentUtils.getDepartInfoBySysUser(sysUserInfo, restTemplate, httpHeaders);
		String parentUnitPathNames = map.get("unitName");// 申报单位
		logger.info("============远程返回  statusCode " + statusCode);
		SrePlanImplement srePlanImplement =  responseEntity.getBody();
		request.setAttribute("srePlanImplement", srePlanImplement);
		//String dateStr = new SimpleDateFormat("yyyy-MM-dd").format(srePlanImplement.getPublicationMonth());
		request.setAttribute("dateStr", srePlanImplement.getPublicationMonth());
		request.setAttribute("researchInstitute", srePlanImplement.getResearchinstitute());
		return "/stp/equipment/planImplement/planImplement-edit";
	}
	
	/**
	 * 保存————修改
	 * 
	 * 
	 * @throws Exception
	 */
	@ResponseBody
	@RequestMapping(method = RequestMethod.POST, value = "/sre-planImplement/update")
	public String updateSrePlanImplement(String id,String publicationTitle,String content,String publicationType,
					String publicDate,String publicationState,String publisher,String unitPathIds,
					String parentUnitPathIds,String parentUnitPathNames,String applyDepartName,
			HttpServletRequest request, HttpServletResponse response) throws Exception {
		String resultsDate = "";
		ResponseEntity<SrePlanImplement> se = this.restTemplate.exchange(GET_URL + id, HttpMethod.GET, new HttpEntity<Object>(this.httpHeaders), SrePlanImplement.class);
		SrePlanImplement mplement = se.getBody();
		ResponseEntity<String> respo = null;
		mplement.setResearchinstitute(parentUnitPathNames);//研究院
		mplement.setPublicationTitle(publicationTitle);//规划标题
		mplement.setPublicationType(publicationType);//发布类型
		mplement.setPublisher(publisher);//发布人
		mplement.setPublicationText(content);//发布内容
		//SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
		mplement.setPublicationMonth(publicDate);//发布时间
		mplement.setPublicationState(publicationState);//发布状态
		mplement.setSonId(unitPathIds);//子ID
		mplement.setLevelId(parentUnitPathIds);//父ID
		mplement.setCreationTime(new Date());//创建时间
		mplement.setLevelName(applyDepartName);//部门名称
		respo = this.restTemplate.exchange(UPDATE_URL, HttpMethod.POST, new HttpEntity<SrePlanImplement>(mplement, this.httpHeaders), String.class);
		int statusCode = respo.getStatusCodeValue();
		String status = respo.getBody();
		logger.info("============远程返回  statusCode " + statusCode + "  status=" + status);
		if (Integer.valueOf(status) > 0) {
			resultsDate = "1";
		} else {
			resultsDate = "修改失败，请联系系统管理员！";
		}
		JSONObject jObject=new JSONObject();
		jObject.put("resultsDate", resultsDate);
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		out.println(jObject.toString());
		out.flush();
		out.close();
		return null;
	}
	
	/**
	 * 删除
	 * 
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/sre-planImplement/delete/{id}")
	public String delete(@PathVariable("id") String id, HttpServletRequest request, HttpServletResponse response) throws Exception {
		Result resultsDate = new Result();
		ResponseEntity<Integer> responseEntity = this.restTemplate.exchange(DEL_URL + id, HttpMethod.POST, new HttpEntity<Object>(this.httpHeaders), Integer.class);
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
	 *  规划详情页
	 * 
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/sre-planImplement/view/{id}", method = RequestMethod.GET)
	public String viewPlanImplement(@PathVariable("id") String id, HttpServletRequest request, HttpServletResponse response) throws Exception {
		ResponseEntity<SrePlanImplement> responseEntity = this.restTemplate.exchange(GET_URL + id, HttpMethod.GET, new HttpEntity<Object>(this.httpHeaders), SrePlanImplement.class);
		int statusCode = responseEntity.getStatusCodeValue();
		String strtype = "";
		String strState = "";
		Map<String, String> map = EquipmentUtils.getDepartInfoBySysUser(sysUserInfo, restTemplate, httpHeaders);
		String parentUnitPathNames = map.get("unitName");// 申报单位
		logger.info("============远程返回  statusCode " + statusCode);
		SrePlanImplement srePlanImplement =  responseEntity.getBody();
		request.setAttribute("srePlanImplement", srePlanImplement);
		//String dateStr = new SimpleDateFormat("yyyy-MM-dd").format(srePlanImplement.getPublicationMonth());
		request.setAttribute("dateStr", srePlanImplement.getPublicationMonth());
		request.setAttribute("researchInstitute", srePlanImplement.getResearchinstitute());
		if(srePlanImplement.getPublicationType().equals("1")){
			strtype="研究院中长期规划";
		}else if(srePlanImplement.getPublicationType().equals("2")) {
			strtype="研究室中长期规划";
		}else if(srePlanImplement.getPublicationType().equals("3")) {
			strtype="课题中长期规划";
		}else if(srePlanImplement.getPublicationType().equals("4")) {
			strtype="研究院滚动计划";
		}else if(srePlanImplement.getPublicationType().equals("5")) {
			strtype="研究室滚动计划";
		}else if(srePlanImplement.getPublicationType().equals("6")) {
			strtype="课题滚动计划";
		}
		request.setAttribute("strtype", strtype);
		if(srePlanImplement.getPublicationState().equals("1")){
			strState="是";
		}else {
			strState="否";
		}
		request.setAttribute("strState", strState);
		return "/stp/equipment/planImplement/planImplement-view";
	}
	
	
	/**
	 *  规划查看信息页
	 * 
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/sre-planImplement/planImplementView/{id}", method = RequestMethod.GET)
	public String getPlanImplementView(@PathVariable("id") String id, HttpServletRequest request, HttpServletResponse response) throws Exception {
		ResponseEntity<SrePlanImplement> responseEntity = this.restTemplate.exchange(GET_URL + id, HttpMethod.GET, new HttpEntity<Object>(this.httpHeaders), SrePlanImplement.class);
		int statusCode = responseEntity.getStatusCodeValue();
		Map<String, String> map = EquipmentUtils.getDepartInfoBySysUser(sysUserInfo, restTemplate, httpHeaders);
		String parentUnitPathNames = map.get("unitName");// 申报单位
		logger.info("============远程返回  statusCode " + statusCode);
		SrePlanImplement srePlanImplement =  responseEntity.getBody();
		request.setAttribute("srePlanImplement", srePlanImplement);
		request.setAttribute("dateStr", srePlanImplement.getPublicationMonth());
		request.setAttribute("researchInstitute", srePlanImplement.getResearchinstitute());
		return "/stp/equipment/planImplement/planImplement-planImplementView";
	}
	
	
	/**
	 * 研究院规划查询
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/sre-planImplement/InstitutePlanning")
	public String planImplementlist(HttpServletRequest request, HttpServletResponse response) throws Exception {
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
	    List<SysDictionary>  dictonary= CommonUtil.getDictionaryByParentCode("ROOT_FZJCZX_YS", restTemplate, httpHeaders);
		request.setAttribute("unitPathIds", unitPathIds);//父id
		request.setAttribute("parentUnitPathIds", parentUnitPathIds);//子id
		request.setAttribute("parentUnitPathNames", parentUnitPathNames);//研究院
		request.setAttribute("applyDepartName", applyDepartName);//当前部门
	    request.setAttribute("isKJBPerson", isKJBPerson);
	    List<SysDictionary> dicList = CommonUtil.getDictionaryByParentCode("ROOT_UNIVERSAL_BDYJY", restTemplate,
				httpHeaders);
	    String str ="1";
	    if(isKJBPerson == true) {
	    	//获取研究院
			request.setAttribute("dictonary", dicList);
			request.setAttribute("str", "1");
	    }else {
	    	request.setAttribute("dictonary", dicList);
	    	request.setAttribute("str", "0");
	    }
		return "/stp/equipment/planImplement/InstitutePlanning";
	}
}		
