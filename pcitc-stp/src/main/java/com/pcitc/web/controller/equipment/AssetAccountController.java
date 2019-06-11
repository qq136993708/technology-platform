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
import com.pcitc.base.common.LayuiTableData;
import com.pcitc.base.common.LayuiTableParam;
import com.pcitc.base.common.Result;
import com.pcitc.base.common.enums.RequestProcessStatusEnum;
import com.pcitc.base.stp.equipment.SreAssetAccount;
import com.pcitc.base.util.CommonUtil;
import com.pcitc.web.common.BaseController;

@Controller
@RequestMapping(value = "/sre-account")
public class AssetAccountController extends BaseController {

	private static final String PAGE_URL = "http://pcitc-zuul/stp-proxy/sre-provider/asset-account/page";
	private static final String ADD_URL = "http://pcitc-zuul/stp-proxy/sre-provider/asset-account/add";
	private static final String UPDATE_URL = "http://pcitc-zuul/stp-proxy/sre-provider/asset-account/update";
	private static final String DEL_URL = "http://pcitc-zuul/stp-proxy/sre-provider/asset-account/delete/";
	private static final String GET_URL = "http://pcitc-zuul/stp-proxy/sre-provider/asset-account/get/";
	private static final String BATCH_DEL_URL = "http://pcitc-zuul/stp-proxy/sre-provider/asset-account/batch-delete/";

	@RequestMapping(value = "/to-list")
	public String list(HttpServletRequest request, HttpServletResponse response) {
		return "/stp/equipment/assetAccount/account-list";
	}

	@RequestMapping(value = "/list")
	@ResponseBody
	public String listSreHardwareAccept(@ModelAttribute("param") LayuiTableParam param, HttpServletRequest request, HttpServletResponse response) {
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
	 * 
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/add")
	public String addSreAssetAccount(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String backurl = CommonUtil.getParameter(request, "backurl", "");
		request.setAttribute("backurl", backurl);

		String iframeId = CommonUtil.getParameter(request, "iframeId", "");
		request.setAttribute("iframeId", iframeId);

		String equipmentId = CommonUtil.getParameter(request, "equipmentId", "");
		request.setAttribute("equipmentId", equipmentId);

		return "/stp/equipment/assetAccount/account-add";
	}

	/**
	 * 保存-更新操作
	 * 
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(method = RequestMethod.POST, value = "/save")
	public String saveOrUpdateSreAssetAccount(HttpServletRequest request, HttpServletResponse response) throws Exception {

		Result resultsDate = new Result();
		String equipmentId = CommonUtil.getParameter(request, "equipmentId", "");
		String assentManUser = CommonUtil.getParameter(request, "assentManUser", "");
		String assetType = CommonUtil.getParameter(request, "assetType", "");
		String eqCountry = CommonUtil.getParameter(request, "eqCountry", "");
		String eqConfig = CommonUtil.getParameter(request, "eqConfig", "");
		String equipmentYear = CommonUtil.getParameter(request, "equipmentYear", "");
		String eqCompanyName = CommonUtil.getParameter(request, "eqCompanyName", "");

		String eqModel = CommonUtil.getParameter(request, "eqModel", "");
		String eqModelPrice = CommonUtil.getParameter(request, "eqModelPrice", "");
		String eqNo = CommonUtil.getParameter(request, "eqNo", "");
		String eqNum = CommonUtil.getParameter(request, "eqNum", "");
		String eqSn = CommonUtil.getParameter(request, "eqSn", "");
		String eqWhere = CommonUtil.getParameter(request, "eqWhere", "");
		String accountId = CommonUtil.getParameter(request, "accountId", "");
		// 业务ID
		String producName = CommonUtil.getParameter(request, "producName", "");
		// 流程状态-是保存还是提交
		SreAssetAccount plan = null;
		// 判断是新增还是修改
		if (accountId.equals("")) {
			plan = new SreAssetAccount();
			plan.setCreateDate(new Date());
			plan.setCreateUserId(sysUserInfo.getUserId());
			String code = CommonUtil.getTableCode("XTBM_0018", restTemplate, httpHeaders);
			plan.setAccountCode(code);
			String id = UUID.randomUUID().toString().replaceAll("-", "");
			plan.setAccountId(id);

		} else {
			ResponseEntity<SreAssetAccount> se = this.restTemplate.exchange(GET_URL + accountId, HttpMethod.GET, new HttpEntity<Object>(this.httpHeaders), SreAssetAccount.class);
			plan = se.getBody();
		}
		plan.setAssentManUser(assentManUser);
		plan.setAssetType(assetType);
		plan.setEqBuyDate(new Date());
		plan.setEqCompanyName(eqCompanyName);
		plan.setEqConfig(eqConfig);
		plan.setEqCountry(eqCountry);
		plan.setEqModel(eqModel);
		plan.setEqNo(eqNo);
		// plan.setEqNum(eqNum);
		plan.setProducName(producName);
		plan.setEqSn(eqSn);
		plan.setEqWhere(eqWhere);
		plan.setAssetType(assetType);

		// 判断是新增还是修改
		if (accountId.equals("")) {
			ResponseEntity<String> responseEntity = this.restTemplate.exchange(ADD_URL, HttpMethod.POST, new HttpEntity<SreAssetAccount>(plan, this.httpHeaders), String.class);
			int statusCode = responseEntity.getStatusCodeValue();
			String meetingId = responseEntity.getBody();
			// 返回结果代码
			if (statusCode == 200) {
				resultsDate = new Result(true, RequestProcessStatusEnum.OK.getStatusDesc());
			} else {
				resultsDate = new Result(false, RequestProcessStatusEnum.SERVER_BUSY.getStatusDesc());
			}

		} else {
			ResponseEntity<Integer> responseEntity = this.restTemplate.exchange(UPDATE_URL, HttpMethod.POST, new HttpEntity<SreAssetAccount>(plan, this.httpHeaders), Integer.class);
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
	@RequestMapping(value = "/update")
	public String updateSreAssetAccount(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String accountId = CommonUtil.getParameter(request, "accountId", "");
		request.setAttribute("accountId", accountId);
		ResponseEntity<SreAssetAccount> responseEntity = this.restTemplate.exchange(GET_URL + accountId, HttpMethod.GET, new HttpEntity<Object>(this.httpHeaders), SreAssetAccount.class);
		int statusCode = responseEntity.getStatusCodeValue();
		logger.info("============远程返回  statusCode " + statusCode);
		SreAssetAccount sreAssetAccount = responseEntity.getBody();
		request.setAttribute("sreAssetAccount", sreAssetAccount);
		String iframeId = CommonUtil.getParameter(request, "iframeId", "");
		request.setAttribute("iframeId", iframeId);
		String backurl = CommonUtil.getParameter(request, "backurl", "");
		request.setAttribute("backurl", backurl);
		System.out.println(">>>>>>>>>>>>>>>>>>>accountId  " + accountId);
		return "/stp/equipment/assetAccount/account-add";
	}

	/**
	 * 删除
	 * 
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/delete/{id}")
	public String deleteSreAssetAccount(@PathVariable("id") String id, HttpServletRequest request, HttpServletResponse response) throws Exception {
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

	@RequestMapping(value = "/bacth-delete")
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
			responseEntity = restTemplate.exchange(BATCH_DEL_URL, HttpMethod.POST, entity, Integer.class);

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
	@RequestMapping(value = "/get/{id}", method = RequestMethod.GET)
	public String getSreAssetAccount(@PathVariable("id") String id, HttpServletRequest request, HttpServletResponse response) throws Exception {
		ResponseEntity<SreAssetAccount> responseEntity = this.restTemplate.exchange(GET_URL + id, HttpMethod.GET, new HttpEntity<Object>(this.httpHeaders), SreAssetAccount.class);
		int statusCode = responseEntity.getStatusCodeValue();
		logger.info("============远程返回  statusCode " + statusCode);
		SreAssetAccount plan = responseEntity.getBody();
		request.setAttribute("sreAssetAccount", plan);
		return "/stp/equipment/assetAccount/account-view";
	}

}
