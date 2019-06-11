package com.pcitc.web.controller.out;

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
import com.pcitc.base.common.LayuiTableData;
import com.pcitc.base.common.LayuiTableParam;
import com.pcitc.base.stp.out.OutReward;
import com.pcitc.web.common.BaseController;

@Controller
public class OutRewardController extends BaseController {
	
	private static final String REWARD_LIST_PAGE = "http://pcitc-zuul/system-proxy/out-provider/reward-list";
	private static final String GET_OUT_REWARD = "http://pcitc-zuul/system-proxy/out-provider/get-reward-list/";

	@RequestMapping(value = "/out/ini-reward-list")
	public String iniOutAppraisalList(HttpServletRequest request, HttpServletResponse response) throws Exception {

		return "/stp/out/out-reward-list";
	}
	
	@RequestMapping(value = "/out/reward-list", method = RequestMethod.POST)
	@ResponseBody
	public Object outRewardlList(@ModelAttribute("param") LayuiTableParam param) {

		System.out.println("====/out/reward-list");
		HttpEntity<LayuiTableParam> entity = new HttpEntity<LayuiTableParam>(param, this.httpHeaders);
		ResponseEntity<LayuiTableData> responseEntity = this.restTemplate.exchange(REWARD_LIST_PAGE, HttpMethod.POST, entity, LayuiTableData.class);
		LayuiTableData retJson = responseEntity.getBody();

		return JSON.toJSON(retJson).toString();
	}

	@RequestMapping(value = "/out/reward-detail/{dataId}", method = RequestMethod.GET)
	public String iniOutRewardShow(@PathVariable("dataId") String dataId, HttpServletRequest request) {
		return "/stp/out/out-reward-show";
	 }
	
	/**
	 * @author Nishikino 根据id获取數據
	 */
	@RequestMapping(value = "/out/getOutRewardShow/{dataId}", method = RequestMethod.POST)
	@ResponseBody
	public Object getOutRewardShow(@PathVariable("dataId") String dataId, HttpServletRequest request) {
		System.out.println("-------------------------getOutRewardShow--------------------------------");
		ResponseEntity<OutReward> responseEntity = this.restTemplate.exchange(GET_OUT_REWARD + dataId, HttpMethod.POST, new HttpEntity<String>(this.httpHeaders), OutReward.class);
		OutReward outReward = responseEntity.getBody();
		return outReward;
	}
}
