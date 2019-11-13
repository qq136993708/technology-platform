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
import com.pcitc.base.stp.equipment.SreInformationDelivery;
import com.pcitc.base.stp.equipment.SrePlanImplement;
import com.pcitc.base.system.SysDictionary;
import com.pcitc.base.util.CommonUtil;
import com.pcitc.base.util.IdUtil;
import com.pcitc.web.common.BaseController;
import com.pcitc.web.utils.EquipmentUtils;

@Controller
public class InformationDeliveryController extends BaseController {
	
	private static final String PAGE_URL = "http://pcitc-zuul/stp-proxy/sre-provider/informationDelivery/page";
	private static final String ADD_URL = "http://pcitc-zuul/stp-proxy/sre-provider/informationDelivery/add";
	private static final String GET_URL = "http://pcitc-zuul/stp-proxy/sre-provider/informationDelivery/get/";
	private static final String DEL_URL = "http://pcitc-zuul/stp-proxy/sre-provider/informationDelivery/delete/";
	private static final String UPDATE_URL = "http://pcitc-zuul/stp-proxy/sre-provider/informationDelivery/updata";
	
	
	/**
	 * 信息发布数据获取
	 * 
	 * @param requestPAGE_URL
	 * @param response
	 * @return
	 */
	@RequestMapping(value = "/sre-informationDelivery/list")
	@ResponseBody
	public String ajaxlist(@ModelAttribute("param") LayuiTableParam param, HttpServletRequest request, HttpServletResponse response) {
		
		LayuiTableData layuiTableData = new LayuiTableData();
		HttpEntity<LayuiTableParam> entity = new HttpEntity<LayuiTableParam>(param, httpHeaders);
		ResponseEntity<LayuiTableData> responseEntity = restTemplate.exchange(PAGE_URL, HttpMethod.POST, entity, LayuiTableData.class);
		int statusCode = responseEntity.getStatusCodeValue();
		if (statusCode == 200) {
			layuiTableData = responseEntity.getBody();
		}
//		JSONObject result = JSONObject.parseObject(JSONObject.toJSONString(layuiTableData));
//		logger.info("============result" + result);
//		return result.toString();
		return JSONObject.toJSONString(layuiTableData);
	}
	
	/**
	 * 规划发布页列表
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/sre-informationDelivery/to-list")
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
	    //List<SysDictionary>  dictonary= CommonUtil.getDictionaryByParentCode("ROOT_FZJCZX_YS", restTemplate, httpHeaders);
		request.setAttribute("unitPathIds", unitPathIds);//父id
		request.setAttribute("parentUnitPathIds", parentUnitPathIds);//子id
		request.setAttribute("parentUnitPathNames", parentUnitPathNames);//研究院
		request.setAttribute("applyDepartName", applyDepartName);//当前部门
	    request.setAttribute("isKJBPerson", isKJBPerson);
		return "/stp/equipment/informationDelivery/informationDelivery-list";
	}
	
	/**
	 *  信息发布新增页
	 */
	@RequestMapping(method = RequestMethod.GET, value = "/sre-informationDelivery/add")
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
		return "/stp/equipment/informationDelivery/informationDelivery-add";
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
	@RequestMapping(method = RequestMethod.POST, value = "/sre-informationDelivery/save")
	public String upforapplication(String publicationTitle,String content,String publicationType,
					String publicDate,String publicationState,String publisher,String unitPathIds,
					String parentUnitPathIds,String parentUnitPathNames,String applyDepartName,
			HttpServletRequest request, HttpServletResponse response) throws Exception {
		String resultsDate = "";
		ResponseEntity<String> respo = null;
		SreInformationDelivery informationDelivery = new SreInformationDelivery();
		String id = UUID.randomUUID().toString().replaceAll("-", "");
		informationDelivery.setId(id);//表ID
		informationDelivery.setResearchinstitute(parentUnitPathNames);//研究院
		informationDelivery.setInformationTitle(publicationTitle);//规划标题
		informationDelivery.setInformationType(publicationType);//发布类型
		informationDelivery.setInformationPublisher(publisher);//发布人
		informationDelivery.setInformationText(content);//发布内容
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		//publicDate = publicDate +" 00:00:00";
		informationDelivery.setInformationMonth(publicDate);//发布时间
		informationDelivery.setInformationState(publicationState);//发布状态
		informationDelivery.setSonId(unitPathIds);//子ID
		informationDelivery.setLevelId(parentUnitPathIds);//父ID
		informationDelivery.setCreationTime(new Date());//创建时间
		informationDelivery.setLevelName(applyDepartName);//部门名称
		informationDelivery.setNumberCompliments("0");//点赞数量
		respo = this.restTemplate.exchange(ADD_URL, HttpMethod.POST, new HttpEntity<SreInformationDelivery>(informationDelivery, this.httpHeaders), String.class);
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
	 * 删除
	 * 
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/sre-informationDelivery/delete/{id}")
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
	 * 信息查看页
	 * 
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/sre-informationDelivery/informationDelivery/{id}", method = RequestMethod.GET)
	public String getPlanImplementView(@PathVariable("id") String id, HttpServletRequest request, HttpServletResponse response) throws Exception {
		ResponseEntity<SreInformationDelivery> responseEntity = this.restTemplate.exchange(GET_URL + id, HttpMethod.GET, new HttpEntity<Object>(this.httpHeaders), SreInformationDelivery.class);
		int statusCode = responseEntity.getStatusCodeValue();
		Map<String, String> map = EquipmentUtils.getDepartInfoBySysUser(sysUserInfo, restTemplate, httpHeaders);
		String parentUnitPathNames = map.get("unitName");// 申报单位
		logger.info("============远程返回  statusCode " + statusCode);
		SreInformationDelivery informationDelivery = responseEntity.getBody();
		request.setAttribute("srePlanImplement", informationDelivery);
		//String dateStr = new SimpleDateFormat("yyyy-MM-dd").format(informationDelivery.getInformationMonth());
		request.setAttribute("dateStr", informationDelivery.getInformationMonth());
		request.setAttribute("researchInstitute", informationDelivery.getResearchinstitute());
		return "/stp/equipment/informationDelivery/informationDelivery-informationDeliveryView";
	}
	
	/**
	 *  信息查看页
	 * 
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/sre-informationDelivery/view/{id}", method = RequestMethod.GET)
	public String viewSreInformationDelivery(@PathVariable("id") String id, HttpServletRequest request, HttpServletResponse response) throws Exception {
		ResponseEntity<SreInformationDelivery> responseEntity = this.restTemplate.exchange(GET_URL + id, HttpMethod.GET, new HttpEntity<Object>(this.httpHeaders), SreInformationDelivery.class);
		int statusCode = responseEntity.getStatusCodeValue();
		String strtype = "";
		String strState = "";
		Map<String, String> map = EquipmentUtils.getDepartInfoBySysUser(sysUserInfo, restTemplate, httpHeaders);
		String parentUnitPathNames = map.get("unitName");// 申报单位
		logger.info("============远程返回  statusCode " + statusCode);
		SreInformationDelivery informationDelivery =  responseEntity.getBody();
		request.setAttribute("srePlanImplement", informationDelivery);
		//String dateStr = new SimpleDateFormat("yyyy-MM-dd").format(informationDelivery.getInformationMonth());
		request.setAttribute("dateStr", informationDelivery.getInformationMonth());
		request.setAttribute("researchInstitute", informationDelivery.getResearchinstitute());
		if(informationDelivery.getInformationType().equals("1")){
			strtype="科研装备能力";
		}else if(informationDelivery.getInformationType().equals("2")) {
			strtype="专有分析手段";
		}else if(informationDelivery.getInformationType().equals("3")) {
			strtype="分析方法";
		}else if(informationDelivery.getInformationType().equals("4")) {
			strtype="设备使用心得";
		}else if(informationDelivery.getInformationType().equals("5")) {
			strtype="维护保养经验";
		}else if(informationDelivery.getInformationType().equals("6")) {
			strtype="装备管理办法";
		}else if(informationDelivery.getInformationType().equals("7")) {
			strtype="故障诊断及排除";
		}
		request.setAttribute("strtype", strtype);
		if(informationDelivery.getInformationState().equals("1")){
			strState="是";
		}else {
			strState="否";
		}
		request.setAttribute("strState", strState);
		return "/stp/equipment/informationDelivery/informationDelivery-view";
	}
	
	/**
	 *  规划编辑页
	 * 
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/sre-informationDelivery/get/{id}", method = RequestMethod.GET)
	public String getSreInformationDelivery(@PathVariable("id") String id, HttpServletRequest request, HttpServletResponse response) throws Exception {
		ResponseEntity<SreInformationDelivery> responseEntity = this.restTemplate.exchange(GET_URL + id, HttpMethod.GET, new HttpEntity<Object>(this.httpHeaders), SreInformationDelivery.class);
		int statusCode = responseEntity.getStatusCodeValue();
		Map<String, String> map = EquipmentUtils.getDepartInfoBySysUser(sysUserInfo, restTemplate, httpHeaders);
		String parentUnitPathNames = map.get("unitName");// 申报单位
		logger.info("============远程返回  statusCode " + statusCode);
		SreInformationDelivery informationDelivery =  responseEntity.getBody();
		request.setAttribute("srePlanImplement", informationDelivery);
		//String dateStr = new SimpleDateFormat("yyyy-MM-dd").format(informationDelivery.getInformationMonth());
		request.setAttribute("dateStr", informationDelivery.getInformationMonth());
		request.setAttribute("researchInstitute", informationDelivery.getResearchinstitute());
		return "/stp/equipment/informationDelivery/informationDelivery-edit";
	}
	
	/**
	 * 保存————修改
	 * 
	 * 
	 * @throws Exception
	 */
	@ResponseBody
	@RequestMapping(method = RequestMethod.POST, value = "/sre-informationDelivery/update")
	public String updateSreInformationDelivery(String id,String publicationTitle,String content,String publicationType,
					String publicDate,String publicationState,String publisher,String unitPathIds,
					String parentUnitPathIds,String parentUnitPathNames,String applyDepartName,
			HttpServletRequest request, HttpServletResponse response) throws Exception {
		String resultsDate = "";
		ResponseEntity<SreInformationDelivery> se = this.restTemplate.exchange(GET_URL + id, HttpMethod.GET, new HttpEntity<Object>(this.httpHeaders), SreInformationDelivery.class);
		SreInformationDelivery informationDelivery = se.getBody();
		ResponseEntity<String> respo = null;
		informationDelivery.setResearchinstitute(parentUnitPathNames);//研究院
		informationDelivery.setInformationTitle(publicationTitle);//规划标题
		informationDelivery.setInformationType(publicationType);//发布类型
		informationDelivery.setInformationPublisher(publisher);//发布人
		informationDelivery.setInformationText(content);//发布内容
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		//publicDate = publicDate +" 00:00:00";
		informationDelivery.setInformationMonth(publicDate);//发布时间
		informationDelivery.setInformationState(publicationState);//发布状态
		informationDelivery.setSonId(unitPathIds);//子ID
		informationDelivery.setLevelId(parentUnitPathIds);//父ID
		informationDelivery.setCreationTime(new Date());//创建时间
		informationDelivery.setLevelName(applyDepartName);//部门名称
		informationDelivery.setNumberCompliments("0");//点赞数量
		respo = this.restTemplate.exchange(UPDATE_URL, HttpMethod.POST, new HttpEntity<SreInformationDelivery>(informationDelivery, this.httpHeaders), String.class);
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
	 * 	经验心得页列表
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/sre-informationDelivery/informationDelivery-tolist")
	public String tolist(HttpServletRequest request, HttpServletResponse response) throws Exception {
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
		request.setAttribute("unitPathIds", unitPathIds);//父id
		request.setAttribute("parentUnitPathIds", parentUnitPathIds);//子id
		request.setAttribute("parentUnitPathNames", parentUnitPathNames);//研究院
		request.setAttribute("applyDepartName", applyDepartName);//当前部门
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
		return "/stp/equipment/informationDelivery/informationDelivery-tolist";
	}
	
	
	/**
	 * 执行点赞数量修改
	 */
	@ResponseBody
	@RequestMapping(value ="/sre-informationDelivery/informationDeliveryUpforapplication", method = RequestMethod.POST)
	public String informationDeliveryUpforapplication(String informationid, HttpServletRequest request, HttpServletResponse response) throws Exception {
		String resultsDate = "";
		ResponseEntity<String> respo = null;
		int NumberCompliments =0;
		ResponseEntity<SreInformationDelivery> responseEntity = this.restTemplate.exchange(GET_URL + informationid, HttpMethod.GET, new HttpEntity<Object>(this.httpHeaders), SreInformationDelivery.class);
		SreInformationDelivery informationDelivery =  responseEntity.getBody();
		if(null==informationDelivery.getNumberCompliments()||informationDelivery.getNumberCompliments().equals("")) {
			NumberCompliments=1;
		}else {
			NumberCompliments = Integer.valueOf(informationDelivery.getNumberCompliments());
			NumberCompliments++;
		}
		informationDelivery.setNumberCompliments(String.valueOf((NumberCompliments)));
		respo = this.restTemplate.exchange(UPDATE_URL, HttpMethod.POST, new HttpEntity<SreInformationDelivery>(informationDelivery, this.httpHeaders), String.class);
		int statusCode = respo.getStatusCodeValue();
		String status = respo.getBody();
		responseEntity = this.restTemplate.exchange(GET_URL + informationid, HttpMethod.GET, new HttpEntity<Object>(this.httpHeaders), SreInformationDelivery.class);
		informationDelivery =  responseEntity.getBody();
		if (Integer.valueOf(status) > 0) {
			resultsDate = "1";
		} else {
			resultsDate = "新增失败，请联系系统管理员！";
		}
		JSONObject jObject=new JSONObject();
		jObject.put("resultsDate", resultsDate);
		jObject.put("result", informationDelivery.getNumberCompliments());
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		out.println(jObject.toString());
		out.flush();
		out.close();
		return null;
	}
}		
