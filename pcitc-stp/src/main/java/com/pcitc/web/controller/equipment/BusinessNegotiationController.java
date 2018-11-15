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
import com.pcitc.base.stp.equipment.SreBusinessTalk;
import com.pcitc.base.util.CommonUtil;
import com.pcitc.web.common.BaseController;

@Controller
@RequestMapping(value = "/sre-negotiation")
public class BusinessNegotiationController extends BaseController {

	private static final String PAGE_URL = "http://pcitc-zuul/stp-proxy/sre-provider/business-talk/page";
	private static final String ADD_URL = "http://pcitc-zuul/stp-proxy/sre-provider/business-talk/add";
	private static final String UPDATE_URL = "http://pcitc-zuul/stp-proxy/sre-provider/business-talk/update";
	private static final String DEL_URL = "http://pcitc-zuul/stp-proxy/sre-provider/business-talk/delete/";
	private static final String GET_URL = "http://pcitc-zuul/stp-proxy/sre-provider/business-talk/get/";
	private static final String BATCH_DEL_URL = "http://pcitc-zuul/stp-proxy/sre-provider/business-talk/batch-delete/";

	@RequestMapping(value = "/to-list")
	public String softwarelist(HttpServletRequest request, HttpServletResponse response) {
		return "/stp/equipment/businessNegotiation/negotiation-list";
	}

	@RequestMapping(value = "/list")
	@ResponseBody
	public String list(@ModelAttribute("param") LayuiTableParam param, HttpServletRequest request, HttpServletResponse response) {
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
	public String addSreBusinessTalk(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String backurl = CommonUtil.getParameter(request, "backurl", "");
		request.setAttribute("backurl", backurl);

		String iframeId = CommonUtil.getParameter(request, "iframeId", "");
		request.setAttribute("iframeId", iframeId);

		String equipmentId = CommonUtil.getParameter(request, "equipmentId", "");
		request.setAttribute("equipmentId", equipmentId);

		return "/stp/equipment/businessNegotiation/negotiation-add";
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
	public String saveOrUpdateSreBusinessTalk(HttpServletRequest request, HttpServletResponse response) throws Exception {

		Result resultsDate = new Result();
		String equipmentId = CommonUtil.getParameter(request, "equipmentId", "");
		String purchaseId = CommonUtil.getParameter(request, "purchaseId", "");
		Long supplyQuote = CommonUtil.getParameterLong(request, "supplyQuote", 0l);
		Long supplyId = CommonUtil.getParameterLong(request, "supplyId", 0l);
		Long supplyPrice = CommonUtil.getParameterLong(request, "supplyPrice", 0l);

		// 业务ID
		String talkId = CommonUtil.getParameter(request, "talkId", "");
		// 流程状态-是保存还是提交
		SreBusinessTalk negotiation = null;
		// 判断是新增还是修改
		if (talkId.equals("")) {
			negotiation = new SreBusinessTalk();
			negotiation.setCreateDate(new Date());
			negotiation.setCreateUserId(sysUserInfo.getUserId());
			String code = CommonUtil.getTableCode("XTBM_0019", restTemplate, httpHeaders);
			negotiation.setTalkCode(code);
			String id = UUID.randomUUID().toString().replaceAll("-", "");
			negotiation.setTalkId(id);

		} else {
			ResponseEntity<SreBusinessTalk> se = this.restTemplate.exchange(GET_URL + talkId, HttpMethod.GET, new HttpEntity<Object>(this.httpHeaders), SreBusinessTalk.class);
			negotiation = se.getBody();
		}
		negotiation.setSupplyPrice(new BigDecimal(supplyPrice));
		negotiation.setSupplyId(Long.valueOf(supplyId));
		negotiation.setSupplyQuote(new BigDecimal(supplyQuote));
		negotiation.setPurchasePlanId(purchaseId);
		// 判断是新增还是修改
		if (talkId.equals("")) {
			ResponseEntity<String> responseEntity = this.restTemplate.exchange(ADD_URL, HttpMethod.POST, new HttpEntity<SreBusinessTalk>(negotiation, this.httpHeaders), String.class);
			int statusCode = responseEntity.getStatusCodeValue();
			String meetingId = responseEntity.getBody();
			// 返回结果代码
			if (statusCode == 200) {
				resultsDate = new Result(true, RequestProcessStatusEnum.OK.getStatusDesc());
			} else {
				resultsDate = new Result(false, RequestProcessStatusEnum.SERVER_BUSY.getStatusDesc());
			}

		} else {
			ResponseEntity<Integer> responseEntity = this.restTemplate.exchange(UPDATE_URL, HttpMethod.POST, new HttpEntity<SreBusinessTalk>(negotiation, this.httpHeaders), Integer.class);
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
	public String updateSreBusinessTalk(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String talkId = CommonUtil.getParameter(request, "talkId", "");
		request.setAttribute("talkId", talkId);
		ResponseEntity<SreBusinessTalk> responseEntity = this.restTemplate.exchange(GET_URL + talkId, HttpMethod.GET, new HttpEntity<Object>(this.httpHeaders), SreBusinessTalk.class);
		int statusCode = responseEntity.getStatusCodeValue();
		logger.info("============远程返回  statusCode " + statusCode);
		SreBusinessTalk SreBusinessTalk = responseEntity.getBody();
		request.setAttribute("sreBusinessTalk", SreBusinessTalk);
		String iframeId = CommonUtil.getParameter(request, "iframeId", "");
		request.setAttribute("iframeId", iframeId);
		String backurl = CommonUtil.getParameter(request, "backurl", "");
		request.setAttribute("backurl", backurl);
		System.out.println(">>>>>>>>>>>>>>>>>>>talkId  " + talkId);
		return "/stp/equipment/businessNegotiation/negotiation-add";
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
	public String deleteSreBusinessTalk(@PathVariable("id") String id, HttpServletRequest request, HttpServletResponse response) throws Exception {
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
	public String getSreBusinessTalk(@PathVariable("id") String id, HttpServletRequest request, HttpServletResponse response) throws Exception {
		ResponseEntity<SreBusinessTalk> responseEntity = this.restTemplate.exchange(GET_URL + id, HttpMethod.GET, new HttpEntity<Object>(this.httpHeaders), SreBusinessTalk.class);
		int statusCode = responseEntity.getStatusCodeValue();
		logger.info("============远程返回  statusCode " + statusCode);
		SreBusinessTalk plan = responseEntity.getBody();
		request.setAttribute("sreBusinessTalk", plan);
		return "/stp/equipment/businessNegotiation/negotiation-view";
	}

}
