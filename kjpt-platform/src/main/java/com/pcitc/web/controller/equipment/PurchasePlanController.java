package com.pcitc.web.controller.equipment;

import java.io.PrintWriter;
import java.math.BigDecimal;
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
import com.pcitc.base.stp.equipment.SrePurchasePlan;
import com.pcitc.base.util.CommonUtil;
import com.pcitc.web.common.BaseController;

@Controller
@RequestMapping(value = "/sre-plan")
public class PurchasePlanController extends BaseController {

	private static final String PAGE_URL = "http://pcitc-zuul/stp-proxy/sre-provider/purchase-plan/page";
	private static final String ADD_URL = "http://pcitc-zuul/stp-proxy/sre-provider/purchase-plan/add";
	private static final String UPDATE_URL = "http://pcitc-zuul/stp-proxy/sre-provider/purchase-plan/update";
	private static final String DEL_URL = "http://pcitc-zuul/stp-proxy/sre-provider/purchase-plan/delete/";
	private static final String GET_URL = "http://pcitc-zuul/stp-proxy/sre-provider/purchase-plan/get/";
	private static final String BATCH_DEL_URL = "http://pcitc-zuul/stp-proxy/sre-provider/purchase-plan/batch-delete/";

	@RequestMapping(value = "/to-list")
	public String list(HttpServletRequest request, HttpServletResponse response) {
		return "/stp/equipment/purchasePlan/plan-list";
	}

	@RequestMapping(value = "/list")
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
	 * 
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/add")
	public String addSrePurchasePlan(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String backurl = CommonUtil.getParameter(request, "backurl", "");
		request.setAttribute("backurl", backurl);

		String iframeId = CommonUtil.getParameter(request, "iframeId", "");
		request.setAttribute("iframeId", iframeId);

		String equipmentId = CommonUtil.getParameter(request, "equipmentId", "");
		request.setAttribute("equipmentId", equipmentId);

		return "/stp/equipment/purchasePlan/plan-add";
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
	public String saveOrUpdateSrePurchasePlan(HttpServletRequest request, HttpServletResponse response) throws Exception {

		Result resultsDate = new Result();
		String equipmentId = CommonUtil.getParameter(request, "equipmentId", "0");
		String price = CommonUtil.getParameter(request, "price", "");
		String purchaseName = CommonUtil.getParameter(request, "purchaseName", "");
		String status = CommonUtil.getParameter(request, "status", "");
		String isPass = CommonUtil.getParameter(request, "isPass", "");
		String equipmentYear = CommonUtil.getParameter(request, "equipmentYear", "");
		Integer amount = CommonUtil.getParameterInt(request, "amount", 0);
		// 业务ID
		String purchasePlanId = CommonUtil.getParameter(request, "purchasePlanId", "");
		// 流程状态-是保存还是提交
		SrePurchasePlan plan = null;
		// 判断是新增还是修改
		if (purchasePlanId.equals("")) {
			plan = new SrePurchasePlan();
			plan.setCreateDate(new Date());
			plan.setCreateUserId(sysUserInfo.getUserId());
			String code = CommonUtil.getTableCode("XTBM_0033", restTemplate, httpHeaders);
			plan.setPurchasePlanCode(code);
			String id = UUID.randomUUID().toString().replaceAll("-", "");
			plan.setPurchasePlanId(id);
		} else {
			ResponseEntity<SrePurchasePlan> se = this.restTemplate.exchange(GET_URL + purchasePlanId, HttpMethod.GET, new HttpEntity<Object>(this.httpHeaders), SrePurchasePlan.class);
			plan = se.getBody();
		}
		plan.setAmount(Integer.valueOf(amount));
		plan.setEquipmentId(Long.valueOf(equipmentId));
		plan.setEquipmentYear(equipmentYear);
		plan.setIsPass(isPass);
		plan.setPurchaseName(purchaseName);
		plan.setPrice(new BigDecimal(price));
		// 判断是新增还是修改
		if (purchasePlanId.equals("")) {
			ResponseEntity<String> responseEntity = this.restTemplate.exchange(ADD_URL, HttpMethod.POST, new HttpEntity<SrePurchasePlan>(plan, this.httpHeaders), String.class);
			int statusCode = responseEntity.getStatusCodeValue();
			String meetingId = responseEntity.getBody();
			// 返回结果代码
			if (statusCode == 200) {
				resultsDate = new Result(true, RequestProcessStatusEnum.OK.getStatusDesc());
			} else {
				resultsDate = new Result(false, RequestProcessStatusEnum.SERVER_BUSY.getStatusDesc());
			}

		} else {
			ResponseEntity<Integer> responseEntity = this.restTemplate.exchange(UPDATE_URL, HttpMethod.POST, new HttpEntity<SrePurchasePlan>(plan, this.httpHeaders), Integer.class);
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
	public String updateSrePurchasePlan(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String purchasePlanId = CommonUtil.getParameter(request, "purchasePlanId", "");
		request.setAttribute("purchasePlanId", purchasePlanId);
		ResponseEntity<SrePurchasePlan> responseEntity = this.restTemplate.exchange(GET_URL + purchasePlanId, HttpMethod.GET, new HttpEntity<Object>(this.httpHeaders), SrePurchasePlan.class);
		int statusCode = responseEntity.getStatusCodeValue();
		logger.info("============远程返回  statusCode " + statusCode);
		SrePurchasePlan plan = responseEntity.getBody();
		request.setAttribute("srePurchasePlan", plan);
		String iframeId = CommonUtil.getParameter(request, "iframeId", "");
		request.setAttribute("iframeId", iframeId);
		String backurl = CommonUtil.getParameter(request, "backurl", "");
		request.setAttribute("backurl", backurl);
		System.out.println(">>>>>>>>>>>>>>>>>>>purchasePlanId  " + purchasePlanId);
		return "/stp/equipment/purchasePlan/plan-add";
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
	public String deleteSrePurchasePlan(@PathVariable("id") String id, HttpServletRequest request, HttpServletResponse response) throws Exception {
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
	public String getSrePurchasePlan(@PathVariable("id") String id, HttpServletRequest request, HttpServletResponse response) throws Exception {
		ResponseEntity<SrePurchasePlan> responseEntity = this.restTemplate.exchange(GET_URL + id, HttpMethod.GET, new HttpEntity<Object>(this.httpHeaders), SrePurchasePlan.class);
		int statusCode = responseEntity.getStatusCodeValue();
		logger.info("============远程返回  statusCode " + statusCode);
		SrePurchasePlan plan = responseEntity.getBody();
		request.setAttribute("srePurchasePlan", plan);
		return "/stp/equipment/purchasePlan/plan-view";
	}
	
	
	
	
	

	//采购申请 合同系统对接 到货签收 合同验收 安装调试 合同关闭
	@RequestMapping(value = "/purchase_apply", method = RequestMethod.GET)
	public String purchase_apply( HttpServletRequest request, HttpServletResponse response) throws Exception {

		return "/stp/equipment/purchase/purchase_apply";
	}
	// 合同系统对接
	@RequestMapping(value = "/contract_duijie", method = RequestMethod.GET)
	public String contract_duijie( HttpServletRequest request, HttpServletResponse response) throws Exception {

		return "/stp/equipment/purchase/contract_duijie";
	}
	
	// 到货签收
	@RequestMapping(value = "/contract_receipt", method = RequestMethod.GET)
	public String contract_receipt( HttpServletRequest request, HttpServletResponse response) throws Exception {

		return "/stp/equipment/purchase/contract_receipt";
	}
		
	// 到货签收
		@RequestMapping(value = "/contract_ys", method = RequestMethod.GET)
		public String contract_ys( HttpServletRequest request, HttpServletResponse response) throws Exception {

			return "/stp/equipment/purchase/contract_ys";
		}
		
		@RequestMapping(value = "/contract_Installation", method = RequestMethod.GET)
		public String contract_Installation( HttpServletRequest request, HttpServletResponse response) throws Exception {

			return "/stp/equipment/purchase/contract_Installation";
		}
		
		//合同关闭
		@RequestMapping(value = "/contract_close", method = RequestMethod.GET)
	public String contract_close( HttpServletRequest request, HttpServletResponse response) throws Exception {

		return "/stp/equipment/purchase/contract_close";
	}
	
		

}
