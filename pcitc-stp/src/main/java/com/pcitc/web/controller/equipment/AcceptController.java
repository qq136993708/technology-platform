package com.pcitc.web.controller.equipment;

import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
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

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.pcitc.base.common.Constant;
import com.pcitc.base.common.LayuiTableData;
import com.pcitc.base.common.LayuiTableParam;
import com.pcitc.base.common.Result;
import com.pcitc.base.common.enums.RequestProcessStatusEnum;
import com.pcitc.base.stp.equipment.SreEquipment;
import com.pcitc.base.stp.equipment.SreHardwareAccept;
import com.pcitc.base.stp.equipment.SreSoftwareAccept;
import com.pcitc.base.util.CommonUtil;
import com.pcitc.base.util.DateUtil;
import com.pcitc.web.common.BaseController;

@Controller
@RequestMapping(value = "/sre-accept")
public class AcceptController extends BaseController {

	private static final String SOFTWARE_PAGE_URL = "http://pcitc-zuul/stp-proxy/sre-provider/software-accept/page";
	private static final String SOFTWARE_ADD_URL = "http://pcitc-zuul/stp-proxy/sre-provider/software-accept/add";
	private static final String SOFTWARE_UPDATE_URL = "http://pcitc-zuul/stp-proxy/sre-provider/software-accept/update";
	private static final String SOFTWARE_DEL_URL = "http://pcitc-zuul/stp-proxy/sre-provider/software-accept/delete/";
	private static final String SOFTWARE_GET_URL = "http://pcitc-zuul/stp-proxy/sre-provider/software-accept/get/";
	private static final String SOFTWARE_BATCH_DEL_URL = "http://pcitc-zuul/stp-proxy/sre-provider/software-accept/batch-delete/";

	private static final String HARDWARE_PAGE_URL = "http://pcitc-zuul/stp-proxy/sre-provider/hardware-accept/page";
	private static final String HARDWARE_ADD_URL = "http://pcitc-zuul/stp-proxy/sre-provider/hardware-accept/add";
	private static final String HARDWARE_UPDATE_URL = "http://pcitc-zuul/stp-proxy/sre-provider/hardware-accept/update";
	private static final String HARDWARE_DEL_URL = "http://pcitc-zuul/stp-proxy/sre-provider/hardware-accept/delete/";
	private static final String HARDWARE_GET_URL = "http://pcitc-zuul/stp-proxy/sre-provider/hardware-accept/get/";
	private static final String HARDWARE_BATCH_DEL_URL = "http://pcitc-zuul/stp-proxy/sre-provider/hardware-accept/batch-delete/";

	public static final String EQUIPMENT_GET_URL = "http://pcitc-zuul/stp-proxy/sre-provider/equipment/get/";

	@RequestMapping(value = "/to-software-list")
	public String softwarelist(HttpServletRequest request, HttpServletResponse response) {
		return "/stp/equipment/accept/software-list";
	}

	/**
	 * 列表
	 * 
	 * @param request
	 * @param response
	 * @return
	 */

	@RequestMapping(value = "/software/list")
	@ResponseBody
	public String listSreSoftwareAccept(@ModelAttribute("param") LayuiTableParam param, HttpServletRequest request, HttpServletResponse response) {
		LayuiTableData layuiTableData = new LayuiTableData();
		HttpEntity<LayuiTableParam> entity = new HttpEntity<LayuiTableParam>(param, httpHeaders);
		ResponseEntity<LayuiTableData> responseEntity = restTemplate.exchange(SOFTWARE_PAGE_URL, HttpMethod.POST, entity, LayuiTableData.class);
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
	@RequestMapping(value = "/software/add")
	public String addSreSoftwareAccept(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String backurl = CommonUtil.getParameter(request, "backurl", "");
		request.setAttribute("backurl", backurl);

		String iframeId = CommonUtil.getParameter(request, "iframeId", "");
		request.setAttribute("iframeId", iframeId);

		String equipmentId = CommonUtil.getParameter(request, "equipmentId", "");
		request.setAttribute("equipmentId", equipmentId);
		if (!equipmentId.equals("")) {
			ResponseEntity<SreEquipment> responseEntity = this.restTemplate.exchange(EQUIPMENT_GET_URL + equipmentId, HttpMethod.GET, new HttpEntity<Object>(this.httpHeaders), SreEquipment.class);
			int statusCode = responseEntity.getStatusCodeValue();
			logger.info("============远程返回  statusCode " + statusCode);
			SreEquipment sreEquipment = responseEntity.getBody();
			request.setAttribute("sreEquipment", sreEquipment);
		}

		return "/stp/equipment/accept/software-add";
	}

	/**
	 * 保存-更新操作
	 * 
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(method = RequestMethod.POST, value = "/software/save")
	public String saveOrUpdateSreSoftwareAccept(HttpServletRequest request, HttpServletResponse response) throws Exception {

		Result resultsDate = new Result();
		String equipmentId = CommonUtil.getParameter(request, "equipmentId", "");
		String installPlace = CommonUtil.getParameter(request, "installPlace", "");
		String equipmentUse = CommonUtil.getParameter(request, "equipmentUse", "");
		String softSituation = CommonUtil.getParameter(request, "softSituation", "");
		String equipmentNo = CommonUtil.getParameter(request, "equipmentNo", "");
		String status = CommonUtil.getParameter(request, "status", Constant.AUDIT_STATUS_DRAFT);
		String softwareEnvironment = CommonUtil.getParameter(request, "softwareEnvironment", "");
		String softWareCount = CommonUtil.getParameter(request, "softWareCount", "");
		String softMediaCount = CommonUtil.getParameter(request, "softMediaCount", "");
		String softwareId = CommonUtil.getParameter(request, "softwareId", "");
		// 业务ID
		String remarks = CommonUtil.getParameter(request, "remarks", "");
		String acceptTime = CommonUtil.getParameter(request, "acceptTime", "");
		String installTime = CommonUtil.getParameter(request, "installTime", "");
		// 流程状态-是保存还是提交
		System.out.println(">>>>>>>>>>>>>>>>>>>equipmentId  " + equipmentId + "  softSituation=" + softSituation + " softwareId=" + softwareId + "getUserId=" + sysUserInfo.getUserId());
		SreSoftwareAccept softwareAccept = null;
		// 判断是新增还是修改
		if (softwareId.equals("")) {
			softwareAccept = new SreSoftwareAccept();
			softwareAccept.setCreateDate(new Date());
			softwareAccept.setCreateUserId(sysUserInfo.getUserId());
			softwareAccept.setStatus(status);
			String code = CommonUtil.getTableCode("XTBM_0021", restTemplate, httpHeaders);
			softwareAccept.setSoftwareCode(code);
			String id = UUID.randomUUID().toString().replaceAll("-", "");
			softwareAccept.setSoftwareId(id);

		} else {
			ResponseEntity<SreSoftwareAccept> se = this.restTemplate.exchange(SOFTWARE_GET_URL + softwareId, HttpMethod.GET, new HttpEntity<Object>(this.httpHeaders), SreSoftwareAccept.class);
			softwareAccept = se.getBody();
		}
		// 流程状态
		softwareAccept.setStatus(status);
		softwareAccept.setEquipmentNo(equipmentNo);
		softwareAccept.setEquipmentUse(equipmentUse);
		softwareAccept.setInstallPlace(installPlace);
		softwareAccept.setSoftSituation(softSituation);
		softwareAccept.setSoftwareEnvironment(softwareEnvironment);
		softwareAccept.setSoftWareCount(Integer.valueOf(softWareCount));
		softwareAccept.setSoftMediaCount(Integer.valueOf(softMediaCount));
		softwareAccept.setAcceptTime(DateUtil.strToDate(acceptTime, DateUtil.FMT_SS));
		softwareAccept.setInstallTime(DateUtil.strToDate(installTime, DateUtil.FMT_SS));
		softwareAccept.setRemarks(remarks);

		// 判断是新增还是修改
		if (softwareId.equals("")) {
			ResponseEntity<String> responseEntity = this.restTemplate.exchange(SOFTWARE_ADD_URL, HttpMethod.POST, new HttpEntity<SreSoftwareAccept>(softwareAccept, this.httpHeaders), String.class);
			int statusCode = responseEntity.getStatusCodeValue();
			String meetingId = responseEntity.getBody();
			// 返回结果代码
			if (statusCode == 200) {
				resultsDate = new Result(true, RequestProcessStatusEnum.OK.getStatusDesc());
			} else {
				resultsDate = new Result(false, RequestProcessStatusEnum.SERVER_BUSY.getStatusDesc());
			}

		} else {
			ResponseEntity<Integer> responseEntity = this.restTemplate.exchange(SOFTWARE_UPDATE_URL, HttpMethod.POST, new HttpEntity<SreSoftwareAccept>(softwareAccept, this.httpHeaders), Integer.class);
			int statusCode = responseEntity.getStatusCodeValue();
			Integer dataId = responseEntity.getBody();
			System.out.println(">>>>>>>>>>>>>>>>>>>返回  statusCode=" + statusCode + "  dataId=" + dataId);
			// 返回结果代码
			if (statusCode == 200) {
				resultsDate = new Result(true, RequestProcessStatusEnum.OK.getStatusDesc());
			} else {
				resultsDate = new Result(false, RequestProcessStatusEnum.SERVER_BUSY.getStatusDesc());
			}
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
	 * 修改
	 * 
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/software/update")
	public String updateSreSoftwareAccept(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String softwareId = CommonUtil.getParameter(request, "softwareId", "");
		request.setAttribute("softwareId", softwareId);
		ResponseEntity<SreSoftwareAccept> responseEntity = this.restTemplate.exchange(SOFTWARE_GET_URL + softwareId, HttpMethod.GET, new HttpEntity<Object>(this.httpHeaders), SreSoftwareAccept.class);
		int statusCode = responseEntity.getStatusCodeValue();
		logger.info("============远程返回  statusCode " + statusCode);
		SreSoftwareAccept SreSoftwareAccept = responseEntity.getBody();
		request.setAttribute("sreSoftwareAccept", SreSoftwareAccept);
		String iframeId = CommonUtil.getParameter(request, "iframeId", "");
		request.setAttribute("iframeId", iframeId);
		String backurl = CommonUtil.getParameter(request, "backurl", "");
		request.setAttribute("backurl", backurl);
		System.out.println(">>>>>>>>>>>>>>>>>>>id  " + softwareId);
		return "/stp/equipment/accept/software-add";
	}

	/**
	 * 删除
	 * 
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/software/delete/{softwareId}")
	public String deleteSreSoftwareAccept(@PathVariable("softwareId") String softwareId, HttpServletRequest request, HttpServletResponse response) throws Exception {
		Result resultsDate = new Result();
		ResponseEntity<Integer> responseEntity = this.restTemplate.exchange(SOFTWARE_DEL_URL + softwareId, HttpMethod.POST, new HttpEntity<Object>(this.httpHeaders), Integer.class);
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

	@RequestMapping(value = "/software/bacth-delete")
	public String deleteBatch(HttpServletRequest request, HttpServletResponse response) throws Exception {

		Result resultsDate = new Result();
		ResponseEntity<Integer> responseEntity = null;
		String chkboxstr = CommonUtil.getParameter(request, "ids", "");
		String chkbox[] = chkboxstr.split(",");
		System.out.println("--------chkboxstr=" + chkboxstr + " chkbox=" + chkbox.length);

		if (chkbox != null && chkbox.length > 0) {
			List<String> list = Arrays.asList(chkbox);
			List<Long> longList = new ArrayList();
			if (list != null) {
				for (int i = 0; i < list.size(); i++) {
					String str = list.get(i);
					longList.add(Long.valueOf(str));
				}
			}
			JSONArray jsonObject = JSONArray.parseArray(JSON.toJSONString(longList));

			HttpEntity<String> entity = new HttpEntity<String>(jsonObject.toString(), httpHeaders);
			responseEntity = restTemplate.exchange(SOFTWARE_BATCH_DEL_URL, HttpMethod.POST, entity, Integer.class);

		}
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
	@RequestMapping(value = "/software/get/{softwareId}", method = RequestMethod.GET)
	public String getSreSoftwareAccept(@PathVariable("softwareId") String softwareId, HttpServletRequest request, HttpServletResponse response) throws Exception {
		ResponseEntity<SreSoftwareAccept> responseEntity = this.restTemplate.exchange(SOFTWARE_GET_URL + softwareId, HttpMethod.GET, new HttpEntity<Object>(this.httpHeaders), SreSoftwareAccept.class);
		int statusCode = responseEntity.getStatusCodeValue();
		logger.info("============远程返回  statusCode " + statusCode);
		SreSoftwareAccept softwareAccept = responseEntity.getBody();
		request.setAttribute("sreSoftwareAccept", softwareAccept);
		return "/stp/equipment/accept/software-view";
	}

	/**
	 * ==================================================硬件====================
	 * ========================
	 */
	@RequestMapping(value = "/to-hardware-list")
	public String hardwarelist(HttpServletRequest request, HttpServletResponse response) {
		return "/stp/equipment/accept/hardware-list";
	}

	/**
	 * 列表
	 * 
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value = "/hardware/list")
	@ResponseBody
	public String listSreHardwareAccept(@ModelAttribute("param") LayuiTableParam param, HttpServletRequest request, HttpServletResponse response) {
		LayuiTableData layuiTableData = new LayuiTableData();
		HttpEntity<LayuiTableParam> entity = new HttpEntity<LayuiTableParam>(param, httpHeaders);
		ResponseEntity<LayuiTableData> responseEntity = restTemplate.exchange(HARDWARE_PAGE_URL, HttpMethod.POST, entity, LayuiTableData.class);
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
	@RequestMapping(value = "/hardware/add")
	public String addSreHardwareAccept(HttpServletRequest request, HttpServletResponse response) throws Exception {

		String equipmentId = CommonUtil.getParameter(request, "equipmentId", "");
		request.setAttribute("equipmentId", equipmentId);

		if (!equipmentId.equals("")) {
			ResponseEntity<SreEquipment> responseEntity = this.restTemplate.exchange(EQUIPMENT_GET_URL + equipmentId, HttpMethod.GET, new HttpEntity<Object>(this.httpHeaders), SreEquipment.class);
			int statusCode = responseEntity.getStatusCodeValue();
			logger.info("============远程返回  statusCode " + statusCode);
			SreEquipment sreEquipment = responseEntity.getBody();
			request.setAttribute("sreEquipment", sreEquipment);
		}

		return "/stp/equipment/accept/hardware-add";
	}

	/**
	 * 保存-更新操作
	 * 
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(method = RequestMethod.POST, value = "/hardware/save")
	public String saveOrUpdateSreHardwareAccept(HttpServletRequest request, HttpServletResponse response) throws Exception {

		Result resultsDate = new Result();
		String equipmentId = CommonUtil.getParameter(request, "equipmentId", "");
		String equipmentUse = CommonUtil.getParameter(request, "equipmentUse", "");
		String factAcceptNumber = CommonUtil.getParameter(request, "factAcceptNumber", "1");
		String acceptStatus = CommonUtil.getParameter(request, "acceptStatus", "");

		String installPlace = CommonUtil.getParameter(request, "installPlace", "");
		String originPlace = CommonUtil.getParameter(request, "originPlace", "");
		String outFactoryNo = CommonUtil.getParameter(request, "outFactoryNo", "");
		String packingDetails = CommonUtil.getParameter(request, "packingDetails", "");
		String acceptTime = CommonUtil.getParameter(request, "acceptTime", "");
		// 业务ID
		String hardwareId = CommonUtil.getParameter(request, "hardwareId", "");
		// 流程状态-是保存还是提交
		SreHardwareAccept softwareAccept = null;
		// 判断是新增还是修改
		if (hardwareId.equals("")) {
			softwareAccept = new SreHardwareAccept();
			softwareAccept.setCreateDate(new Date());
			softwareAccept.setCreateUserId(sysUserInfo.getUserId());
			String code = CommonUtil.getTableCode("XTBM_0022", restTemplate, httpHeaders);
			softwareAccept.setHardwareCode(code);
			String id = UUID.randomUUID().toString().replaceAll("-", "");
			softwareAccept.setHardwareId(id);
		} else {
			ResponseEntity<SreHardwareAccept> se = this.restTemplate.exchange(HARDWARE_GET_URL + hardwareId, HttpMethod.GET, new HttpEntity<Object>(this.httpHeaders), SreHardwareAccept.class);
			softwareAccept = se.getBody();
		}
		// 流程状态
		softwareAccept.setAcceptStatus(acceptStatus);
		softwareAccept.setEquipmentUse(equipmentUse);
		softwareAccept.setFactAcceptNumber(Integer.valueOf(factAcceptNumber));
		softwareAccept.setInstallPlace(installPlace);
		softwareAccept.setOriginPlace(originPlace);
		softwareAccept.setOutFactoryNo(outFactoryNo);
		softwareAccept.setPackingDetails(packingDetails);
		softwareAccept.setAcceptTime(DateUtil.strToDate(acceptTime, DateUtil.FMT_SS));
		// 判断是新增还是修改
		if (hardwareId.equals("")) {
			ResponseEntity<String> responseEntity = this.restTemplate.exchange(HARDWARE_ADD_URL, HttpMethod.POST, new HttpEntity<SreHardwareAccept>(softwareAccept, this.httpHeaders), String.class);
			int statusCode = responseEntity.getStatusCodeValue();
			String meetingId = responseEntity.getBody();
			// 返回结果代码
			if (statusCode == 200) {
				resultsDate = new Result(true, RequestProcessStatusEnum.OK.getStatusDesc());
			} else {
				resultsDate = new Result(false, RequestProcessStatusEnum.SERVER_BUSY.getStatusDesc());
			}

		} else {
			ResponseEntity<Integer> responseEntity = this.restTemplate.exchange(HARDWARE_UPDATE_URL, HttpMethod.POST, new HttpEntity<SreHardwareAccept>(softwareAccept, this.httpHeaders), Integer.class);
			int statusCode = responseEntity.getStatusCodeValue();
			Integer dataId = responseEntity.getBody();
			System.out.println(">>>>>>>>>>>>>>>>>>>返回  statusCode=" + statusCode + "  dataId=" + dataId);
			// 返回结果代码
			if (statusCode == 200) {
				resultsDate = new Result(true, RequestProcessStatusEnum.OK.getStatusDesc());
			} else {
				resultsDate = new Result(false, RequestProcessStatusEnum.SERVER_BUSY.getStatusDesc());
			}
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
	 * 修改
	 * 
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/hardware/update")
	public String updateSreHardwareAccept(HttpServletRequest request, HttpServletResponse response) throws Exception {

		String hardwareId = CommonUtil.getParameter(request, "hardwareId", "");
		request.setAttribute("hardwareId", hardwareId);
		ResponseEntity<SreHardwareAccept> responseEntity = this.restTemplate.exchange(HARDWARE_GET_URL + hardwareId, HttpMethod.GET, new HttpEntity<Object>(this.httpHeaders), SreHardwareAccept.class);
		int statusCode = responseEntity.getStatusCodeValue();
		logger.info("============远程返回  statusCode " + statusCode);
		SreHardwareAccept sreHardwareAccept = responseEntity.getBody();
		if (sreHardwareAccept != null) {
			String equipmentId = sreHardwareAccept.getEquipmentId();
			if (!equipmentId.equals("")) {
				ResponseEntity<SreEquipment> re = this.restTemplate.exchange(EQUIPMENT_GET_URL + equipmentId, HttpMethod.GET, new HttpEntity<Object>(this.httpHeaders), SreEquipment.class);
				int sc = re.getStatusCodeValue();
				logger.info("============远程返回  statusCode " + sc);
				SreEquipment sreEquipment = re.getBody();
				request.setAttribute("sreEquipment", sreEquipment);
			}
		}
		request.setAttribute("sreHardwareAccept", sreHardwareAccept);

		return "/stp/equipment/accept/hardware-add";
	}

	/**
	 * 删除
	 * 
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/hardware/delete/{hardwareId}")
	public String deleteSreHardwareAccept(@PathVariable("hardwareId") String hardwareId, HttpServletRequest request, HttpServletResponse response) throws Exception {
		Result resultsDate = new Result();
		ResponseEntity<Integer> responseEntity = this.restTemplate.exchange(HARDWARE_DEL_URL + hardwareId, HttpMethod.POST, new HttpEntity<Object>(this.httpHeaders), Integer.class);
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

	@RequestMapping(value = "/hardware/bacth-delete")
	public String deleteBatchHardware(HttpServletRequest request, HttpServletResponse response) throws Exception {

		Result resultsDate = new Result();
		ResponseEntity<Integer> responseEntity = null;
		String chkboxstr = CommonUtil.getParameter(request, "ids", "");
		String chkbox[] = chkboxstr.split(",");
		System.out.println("--------chkboxstr=" + chkboxstr + " chkbox=" + chkbox.length);

		if (chkbox != null && chkbox.length > 0) {
			List<String> list = Arrays.asList(chkbox);
			List<Long> longList = new ArrayList();
			if (list != null) {
				for (int i = 0; i < list.size(); i++) {
					String str = list.get(i);
					longList.add(Long.valueOf(str));
				}
			}
			JSONArray jsonObject = JSONArray.parseArray(JSON.toJSONString(longList));

			HttpEntity<String> entity = new HttpEntity<String>(jsonObject.toString(), httpHeaders);
			responseEntity = restTemplate.exchange(HARDWARE_BATCH_DEL_URL, HttpMethod.POST, entity, Integer.class);

		}
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
	@RequestMapping(value = "/hardware/get/{hardwareId}", method = RequestMethod.GET)
	public String getSreHardwareAccept(@PathVariable("hardwareId") String hardwareId, HttpServletRequest request, HttpServletResponse response) throws Exception {
		ResponseEntity<SreHardwareAccept> responseEntity = this.restTemplate.exchange(HARDWARE_GET_URL + hardwareId, HttpMethod.GET, new HttpEntity<Object>(this.httpHeaders), SreHardwareAccept.class);
		int statusCode = responseEntity.getStatusCodeValue();
		logger.info("============远程返回  statusCode " + statusCode);
		SreHardwareAccept sreHardwareAccept = responseEntity.getBody();
		request.setAttribute("sreHardwareAccept", sreHardwareAccept);
		return "/stp/equipment/accept/hardware-view";
	}

}
