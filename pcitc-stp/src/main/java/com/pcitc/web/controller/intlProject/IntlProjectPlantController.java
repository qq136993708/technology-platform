package com.pcitc.web.controller.intlProject;

import java.io.IOException;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSON;
import com.pcitc.base.common.LayuiTableData;
import com.pcitc.base.common.LayuiTableParam;
import com.pcitc.base.common.Result;
import com.pcitc.base.common.enums.FlowStatusEnum;
import com.pcitc.base.stp.IntlProject.IntlProjectApplyPlant;
import com.pcitc.base.stp.IntlProject.IntlProjectPlant;
import com.pcitc.base.util.DateUtil;
import com.pcitc.base.util.IdUtil;
import com.pcitc.base.util.MyBeanUtils;
import com.pcitc.web.common.BaseController;

@RestController
public class IntlProjectPlantController extends BaseController {

	private static final String PROJECT_PLANT_LIST_URL = "http://pcitc-zuul/stp-proxy/stp-provider/project/plant-list";
	private static final String PROJECT_PLANT_ADD_URL = "http://pcitc-zuul/stp-proxy/stp-provider/project/add-plant";
	private static final String PROJECT_PLANT_UPD_URL = "http://pcitc-zuul/stp-proxy/stp-provider/project/upd-plant";
	private static final String PROJECT_PLANT_GET_URL = "http://pcitc-zuul/stp-proxy/stp-provider/project/get-plant/";
	private static final String PROJECT_PLANT_CLOSE_URL = "http://pcitc-zuul/stp-proxy/stp-provider/project/close-plant/";
	private static final String PROJECT_PLANT_DEL_URL = "http://pcitc-zuul/stp-proxy/stp-provider/project/del-plant/";
	private static final String PROJECT_PLANT_WORKFLOW_URL = "http://pcitc-zuul/stp-proxy/stp-provider/project/start-plant-activity/";

	private static final String PROJECT_PLANT_REL_ADD_URL = "http://pcitc-zuul/stp-proxy/stp-provider/project/add-toplant";
	private static final String PROJECT_PLANT_REL_DEL_URL = "http://pcitc-zuul/stp-proxy/stp-provider/project/del-fromplant";

	@RequestMapping(value = "/project/plant-list", method = RequestMethod.POST)
	public Object getTableData(@ModelAttribute("param") LayuiTableParam param) throws IOException {
		HttpEntity<LayuiTableParam> entity = new HttpEntity<LayuiTableParam>(param, this.httpHeaders);
		ResponseEntity<LayuiTableData> responseEntity = this.restTemplate.exchange(PROJECT_PLANT_LIST_URL, HttpMethod.POST, entity, LayuiTableData.class);
		LayuiTableData data = responseEntity.getBody();
		return JSON.toJSON(data).toString();
	}

	@RequestMapping(value = "/project/plant-saveorupdate", method = RequestMethod.POST)
	public Object updProjectPlant(@ModelAttribute("plant") IntlProjectPlant plant, HttpServletRequest request, HttpServletResponse response) throws Exception {
		IntlProjectPlant oldplant = this.restTemplate.exchange(PROJECT_PLANT_GET_URL + plant.getPlantId(), HttpMethod.POST, new HttpEntity<Object>(this.httpHeaders), IntlProjectPlant.class).getBody();
		ResponseEntity<Integer> status = null;
		if (oldplant == null) {
			// 创建一个新的对象
			IntlProjectPlant newplant = (IntlProjectPlant) MyBeanUtils.createDefaultModel(IntlProjectPlant.class);
			newplant.setAppendFiles(IdUtil.createFileIdByTime());
			MyBeanUtils.copyPropertiesIgnoreNull(plant, newplant);
			System.out.println("save plant........" + JSON.toJSONString(newplant));
			status = this.restTemplate.exchange(PROJECT_PLANT_ADD_URL, HttpMethod.POST, new HttpEntity<IntlProjectPlant>(newplant, this.httpHeaders), Integer.class);
		} else {
			// 如果已提交则不可更新
			if (FlowStatusEnum.FLOW_START_STATUS_YES.getCode().equals(oldplant.getFlowStartStatus())) {
				return new Result(false, "申报已提交不可再编辑");
			}
			plant.setUpdateTime(DateUtil.format(new Date(), DateUtil.FMT_SS));
			if (plant.getAppendFiles() == null) {
				plant.setAppendFiles(IdUtil.createFileIdByTime());
			}
			MyBeanUtils.copyPropertiesIgnoreNull(plant, oldplant);
			System.out.println("update plant........" + JSON.toJSONString(oldplant));
			status = this.restTemplate.exchange(PROJECT_PLANT_UPD_URL, HttpMethod.POST, new HttpEntity<IntlProjectPlant>(oldplant, this.httpHeaders), Integer.class);
		}
		if (status.getBody() == 0) {
			return new Result(false);
		} else {
			return new Result(true);
		}
	}

	@RequestMapping(value = "/project/plant-close/{plantId}")
	public Object delPlant(@PathVariable("plantId") String plantId, HttpServletRequest request, HttpServletResponse response) throws Exception {
		// 关闭
		ResponseEntity<Integer> presult = this.restTemplate.exchange(PROJECT_PLANT_CLOSE_URL + plantId, HttpMethod.POST, new HttpEntity<Object>(this.httpHeaders), Integer.class);
		if (presult.getBody() > 0) {
			return new Result(true, "关闭成功！");
		} else {
			return new Result(false, "关闭失败，请联系系统管理员！");
		}
	}

	@RequestMapping(value = "/project/plant-delete/{plantId}")
	public Object delPlantRel(@PathVariable("plantId") String plantId, HttpServletRequest request, HttpServletResponse response) throws Exception {
		// 先查询再删除
		IntlProjectPlant oldplant = this.restTemplate.exchange(PROJECT_PLANT_GET_URL + plantId, HttpMethod.POST, new HttpEntity<Object>(this.httpHeaders), IntlProjectPlant.class).getBody();
		// 如果已提交则不可删除
		if (FlowStatusEnum.FLOW_START_STATUS_YES.getCode().equals(oldplant.getFlowStartStatus())) {
			return new Result(false, "已提交不可删除");
		}
		// 删除
		ResponseEntity<Integer> presult = this.restTemplate.exchange(PROJECT_PLANT_DEL_URL + plantId, HttpMethod.POST, new HttpEntity<Object>(this.httpHeaders), Integer.class);
		if (presult.getBody() > 0) {
			return new Result(true, "删除成功！");
		} else {
			return new Result(false, "删除失败，请联系系统管理员！");
		}
	}

	@RequestMapping(value = "/project/get-plant")
	public Object getProjectPlant(@RequestParam(value = "plantId", required = true) String plantId, HttpServletRequest request, HttpServletResponse response) throws Exception {
		System.out.println("start .... get plant .....");
		IntlProjectPlant plant = this.restTemplate.exchange(PROJECT_PLANT_GET_URL + plantId, HttpMethod.POST, new HttpEntity<Object>(this.httpHeaders), IntlProjectPlant.class).getBody();
		System.out.println(JSON.toJSON(plant));
		return plant;
	}

	@RequestMapping(value = "/project/plant-start-workflow")
	public Object startProjectPlantWorkflow(@RequestParam(value = "plantId", required = true) String plantId, HttpServletRequest request, HttpServletResponse response) throws Exception {
		System.out.println("开始审批！！！！");
		Integer plant = this.restTemplate.exchange(PROJECT_PLANT_WORKFLOW_URL + plantId, HttpMethod.POST, new HttpEntity<Object>(this.httpHeaders), Integer.class).getBody();
		if (plant == 0) {
			return new Result(false);
		} else {
			return new Result(true);
		}
	}

	@RequestMapping(value = "/project/add-toplant")
	public Object addToPlant(@RequestParam(value = "applyId", required = true) String applyId, @RequestParam(value = "plantId", required = true) String plantId, HttpServletRequest request, HttpServletResponse response) throws Exception {
		IntlProjectApplyPlant rel = new IntlProjectApplyPlant();
		rel.setApplyId(applyId);
		rel.setPlantId(plantId);
		ResponseEntity<Integer> presult = this.restTemplate.exchange(PROJECT_PLANT_REL_ADD_URL, HttpMethod.POST, new HttpEntity<IntlProjectApplyPlant>(rel, this.httpHeaders), Integer.class);
		if (presult.getBody() > 0) {
			return new Result(true, "添加成功！");
		} else {
			return new Result(false, "添加失败，请联系系统管理员！");
		}
	}

	@RequestMapping(value = "/project/del-fromplant")
	public Object delFromPlant(@RequestParam(value = "applyId", required = true) String applyId, @RequestParam(value = "plantId", required = true) String plantId, HttpServletRequest request, HttpServletResponse response) throws Exception {

		IntlProjectApplyPlant rel = new IntlProjectApplyPlant();
		rel.setApplyId(applyId);
		rel.setPlantId(plantId);
		ResponseEntity<Integer> presult = this.restTemplate.exchange(PROJECT_PLANT_REL_DEL_URL, HttpMethod.POST, new HttpEntity<IntlProjectApplyPlant>(rel, this.httpHeaders), Integer.class);
		if (presult.getBody() > 0) {
			return new Result(true, "移除成功！");
		} else {
			return new Result(false, "移除失败，请联系系统管理员！");
		}
	}
}
