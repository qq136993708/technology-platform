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
import com.pcitc.base.stp.equipment.SreContract;
import com.pcitc.base.util.CommonUtil;
import com.pcitc.base.util.DateUtil;
import com.pcitc.web.common.BaseController;

@Controller
@RequestMapping(value = "/sre-contract")
public class ContractController extends BaseController {

	private static final String PAGE_URL = "http://pcitc-zuul/stp-proxy/sre-provider/contract/page";
	private static final String ADD_URL = "http://pcitc-zuul/stp-proxy/sre-provider/contract";
	private static final String UPDATE_URL = "http://pcitc-zuul/stp-proxy/sre-provider/contract/update";
	private static final String DEL_URL = "http://pcitc-zuul/stp-proxy/sre-provider/contract/";
	private static final String GET_URL = "http://pcitc-zuul/stp-proxy/sre-provider/contract/";
	private static final String BATCH_DEL_URL = "http://pcitc-zuul/stp-proxy/sre-provider/contract/batch-delete/";

	@RequestMapping(value = "/to-list")
	public String list(HttpServletRequest request, HttpServletResponse response) {
		return "/stp/equipment/contract/contract-list";
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
	public String addSreContract(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String backurl = CommonUtil.getParameter(request, "backurl", "");
		request.setAttribute("backurl", backurl);

		String iframeId = CommonUtil.getParameter(request, "iframeId", "");
		request.setAttribute("iframeId", iframeId);

		String equipmentId = CommonUtil.getParameter(request, "equipmentId", "");
		request.setAttribute("equipmentId", equipmentId);

		return "/stp/equipment/contract/contract-add";
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
	public String saveOrUpdateSreContract(HttpServletRequest request, HttpServletResponse response) throws Exception {

		Result resultsDate = new Result();
		String equipmentId = CommonUtil.getParameter(request, "equipmentId", "");
		String deliveryTime = CommonUtil.getParameter(request, "deliveryTime", "");
		Long contracMoney = CommonUtil.getParameterLong(request, "contracMoney", 0l);
		String contractType = CommonUtil.getParameter(request, "contractType", "");

		String contractStartTime = CommonUtil.getParameter(request, "contractStartTime", "");
		String contractEndTime = CommonUtil.getParameter(request, "contractEndTime", "");
		String acceptTime = CommonUtil.getParameter(request, "acceptTime", "");

		// 业务ID
		String contractId = CommonUtil.getParameter(request, "contractId", "");
		// 流程状态-是保存还是提交
		SreContract contract = null;
		// 判断是新增还是修改
		if (contractId.equals("")) {
			contract = new SreContract();
			contract.setCreateDate(new Date());
			contract.setCreateUserId(sysUserInfo.getUserId());
			String code = CommonUtil.getTableCode("XTBM_0034", restTemplate, httpHeaders);
			contract.setContractCode(code);
			String id = UUID.randomUUID().toString().replaceAll("-", "");
			System.out.println("---------------UUID-id:" + id);
			contract.setContractId(id);

		} else {
			ResponseEntity<SreContract> se = this.restTemplate.exchange(GET_URL + contractId, HttpMethod.GET, new HttpEntity<Object>(this.httpHeaders), SreContract.class);
			contract = se.getBody();
		}
		contract.setAcceptTime(DateUtil.strToDate(acceptTime, DateUtil.FMT_SS));
		contract.setContracMoney(new BigDecimal(contracMoney));
		contract.setContractEndTime(DateUtil.strToDate(contractEndTime, DateUtil.FMT_SS));
		contract.setContractType(contractType);
		contract.setContractStartTime(DateUtil.strToDate(contractStartTime, DateUtil.FMT_SS));
		contract.setDeliveryTime(DateUtil.strToDate(deliveryTime, DateUtil.FMT_SS));

		// 判断是新增还是修改
		if (contractId.equals("")) {
			ResponseEntity<String> responseEntity = this.restTemplate.exchange(ADD_URL, HttpMethod.POST, new HttpEntity<SreContract>(contract, this.httpHeaders), String.class);
			int statusCode = responseEntity.getStatusCodeValue();
			String meetingId = responseEntity.getBody();
			// 返回结果代码
			if (statusCode == 200) {
				resultsDate = new Result(true, RequestProcessStatusEnum.OK.getStatusDesc());
			} else {
				resultsDate = new Result(false, RequestProcessStatusEnum.SERVER_BUSY.getStatusDesc());
			}

		} else {
			ResponseEntity<Integer> responseEntity = this.restTemplate.exchange(UPDATE_URL, HttpMethod.PUT, new HttpEntity<SreContract>(contract, this.httpHeaders), Integer.class);
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
	public String updateSreContract(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String contractId = CommonUtil.getParameter(request, "contractId", "");
		request.setAttribute("contractId", contractId);
		ResponseEntity<SreContract> responseEntity = this.restTemplate.exchange(GET_URL + contractId, HttpMethod.GET, new HttpEntity<Object>(this.httpHeaders), SreContract.class);
		int statusCode = responseEntity.getStatusCodeValue();
		logger.info("============远程返回  statusCode " + statusCode);
		SreContract SreContract = responseEntity.getBody();
		request.setAttribute("sreContract", SreContract);
		String iframeId = CommonUtil.getParameter(request, "iframeId", "");
		request.setAttribute("iframeId", iframeId);
		String backurl = CommonUtil.getParameter(request, "backurl", "");
		request.setAttribute("backurl", backurl);
		System.out.println(">>>>>>>>>>>>>>>>>>>contractId  " + contractId);
		return "/stp/equipment/contract/contract-add";
	}

	/**
	 * 删除
	 * 
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/delete/{contractId}")
	public String deleteSreContract(@PathVariable("contractId") String contractId, HttpServletRequest request, HttpServletResponse response) throws Exception {
		Result resultsDate = new Result();
		ResponseEntity<Integer> responseEntity = this.restTemplate.exchange(DEL_URL + contractId, HttpMethod.DELETE, new HttpEntity<Object>(this.httpHeaders), Integer.class);
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
	public String getSreContract(@PathVariable("id") String id, HttpServletRequest request, HttpServletResponse response) throws Exception {
		ResponseEntity<SreContract> responseEntity = this.restTemplate.exchange(GET_URL + id, HttpMethod.GET, new HttpEntity<Object>(this.httpHeaders), SreContract.class);
		int statusCode = responseEntity.getStatusCodeValue();
		logger.info("============远程返回  statusCode " + statusCode);
		SreContract plan = responseEntity.getBody();
		request.setAttribute("sreContract", plan);
		return "/stp/equipment/contract/contract-view";
	}
	
	
	
	
	
	
    //合同安排 合同填写  合同上报  合同审批  合同对接
		@RequestMapping(value = "/arrange", method = RequestMethod.GET)
		public String arrange( HttpServletRequest request, HttpServletResponse response) throws Exception {

			return "/stp/equipment/contract/arrange";
		}
		
		@RequestMapping(value = "/contract_add", method = RequestMethod.GET)
		public String contract_add( HttpServletRequest request, HttpServletResponse response) throws Exception {

			return "/stp/equipment/contract/contract_add";
		}
		
		
		@RequestMapping(value = "/contract_up", method = RequestMethod.GET)
		public String contract_up( HttpServletRequest request, HttpServletResponse response) throws Exception {

			return "/stp/equipment/contract/contract_up";
		}
			
		@RequestMapping(value = "/contract_audit", method = RequestMethod.GET)
		public String contract_audit( HttpServletRequest request, HttpServletResponse response) throws Exception {

			return "/stp/equipment/contract/contract_audit";
		}
				
		@RequestMapping(value = "/contract_deal", method = RequestMethod.GET)
		public String contract_deal( HttpServletRequest request, HttpServletResponse response) throws Exception {

			return "/stp/equipment/contract/contract_deal";
		}
		

}
