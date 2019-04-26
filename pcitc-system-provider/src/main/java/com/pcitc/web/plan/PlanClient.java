package com.pcitc.web.plan;

import com.alibaba.fastjson.JSONObject;
import com.pcitc.base.common.LayuiTableData;
import com.pcitc.base.common.LayuiTableParam;
import com.pcitc.base.plan.PlanBase;
import com.pcitc.base.plan.PlanBaseDetail;
import com.pcitc.service.plan.PlanBaseService;
import com.pcitc.service.plan.PlanService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Api(value = "PlanClient-API",description = "计划任务相关的接口")
@RestController
@RequestMapping("/PlanClient-provider")
public class PlanClient {
	
	@Autowired
	private PlanService planBaseService;
	private final static Logger logger = LoggerFactory.getLogger(PlanClient.class);
	
	/**
	 * 查看计划任务列表
	 * @param param
	 * @return
	 */
	@ApiOperation(value = "查看计划任务列表")
	@RequestMapping(value = "/botWorkOrder_list",method = RequestMethod.POST)
	public LayuiTableData queryBotWorkOrderListByPage(@RequestBody LayuiTableParam param) {
		LayuiTableData data = null;
		try {
			data = planBaseService.queryMyBotWorkOrderListByPage(param);
//			data = planBaseService.queryBotWorkOrderListByPage(param);
		} catch (Exception e) {
			logger.error("[任务管理-查询计划任务列表失败：]", e);
		}
		return data;
	}
	/**
	 * 根据ID查看计划任务
	 * @param dataId
	 * @return
	 */
	@ApiOperation(value = "查看计划任务信息-key", notes = "根据ID查询计划任务详情")
	@RequestMapping(value = "/viewBotWorkOrder/{dataId}",method = RequestMethod.POST)
	public PlanBase viewBotWorkOrder(@PathVariable(value = "dataId", required = true) String dataId) {
		PlanBase vo = null;
		try {
			vo = planBaseService.findBotWorkOrderById(dataId);
		} catch (Exception e) {
			logger.error("[任务管理-查询计划任务失败]", e);
		}
		return vo;
	}
	/**
	 * 新增计划任务
	 * @param vo
	 * @return
	 */
	@ApiOperation(value = "新增计划任务保存", notes = "新增计划任务保存")
	@RequestMapping(value = "/saveBotWorkOrder", method = RequestMethod.POST)
	public int saveBotWorkOrder(@RequestBody PlanBase vo){
		int result = 500;
		try {
			result = planBaseService.saveBotWorkOrder(vo);
		} catch (Exception e) {
			logger.error("[任务管理-保存计划任务失败]", e);
		}
		return result;
	}
	
	/**
	 * 删除计划任务
	 * @param id
	 * @return
	 */
	@ApiOperation(value = "删除计划任务-key", notes = "根据ID删除计划任务信息")
	@RequestMapping(value = "/deleteBotWorkOrder/{id}", method = RequestMethod.POST)
	public int deleteBotWorkOrder(@PathVariable(value = "id", required = true) String id){
		int result = 500;
		try {
			result = planBaseService.deleteBotWorkOrder(id);
		} catch (Exception e) {
			logger.error("[任务管理-删除计划任务失败]", e);
		}
		return result;
	}
	/**
	 * 修改计划任务
	 * @param vo
	 * @return
	 */
	@ApiOperation(value = "修改计划任务-key", notes = "根据ID修改计划任务信息")
	@RequestMapping(value = "/editBotWorkOrder", method = RequestMethod.POST)
	public int editBotWorkOrder(@RequestBody PlanBase vo){
		int result = 500;
		try {
			result = planBaseService.editBotWorkOrder(vo);
		} catch (Exception e) {
			logger.error("[任务管理-修改计划任务失败]", e);
		}
		return result;
	}
	/**
	 * 批量提交计划任务
	 * @param id
	 * @return
	 */
	@ApiOperation(value = "提交计划任务-key", notes = "根据ID提交计划任务信息")
	@RequestMapping(value = "/affirmBotWorkOrder/{id}", method = RequestMethod.POST)
	public int affirmBotWorkOrder(@PathVariable(value = "id", required = true) String id){
		int result = 500;
		try {
			result = planBaseService.affirmBotWorkOrder(id);
		} catch (Exception e) {
			logger.error("[任务管理-提交计划任务失败]", e);
		}
		return result;
	}
	/**
	 * 提交计划任务
	 * @param id
	 * @return
	 */
	@ApiOperation(value = "提交计划任务-key", notes = "根据ID提交计划任务信息")
	@RequestMapping(value = "/submitBotWorkOrder/{id}", method = RequestMethod.POST)
	public int submitBotWorkOrder(@PathVariable(value = "id", required = true) String id){
		int result = 500;
		try {
			result = planBaseService.submitBotWorkOrder(id);
		} catch (Exception e) {
			logger.error("[任务管理-提交计划任务失败]", e);
		}
		return result;
	}
	
	/**
	 * 新增工单事项
	 * @param list
	 * @return
	 */
	@ApiOperation(value = "新增工单事项保存", notes = "新增工单事项保存")
	@RequestMapping(value = "/saveBotWorkOrderMatterBatch", method = RequestMethod.POST)
	public int saveBotWorkOrderMatterBatch(@RequestBody List<PlanBaseDetail> list){
		int result = 500;
		try {
			result = planBaseService.saveBotWorkOrderMatterBatch(list);
		} catch (Exception e) {
			logger.error("[任务管理-保存工单事项失败]", e);
		}
		return result;
	}

	/**
	 * 新增PlanBase主任务
	 * @param list
	 * @return
	 */
	@ApiOperation(value = "新增子任务保存", notes = "新增子任务保存")
	@RequestMapping(value = "/savePlanBaseBatch", method = RequestMethod.POST)
	public int savePlanBaseBatch(@RequestBody List<PlanBase> list){
		int result = 500;
		try {
			result = planBaseService.savePlanBaseBatch(list);
		} catch (Exception e) {
			logger.error("[任务管理-保存工单事项失败]", e);
		}
		return result;
	}

	/**
	 * 转发PlanBase主任务
	 * @param list
	 * @return
	 */
	@ApiOperation(value = "转发子任务修改", notes = "转发子任务修改")
	@RequestMapping(value = "/savePlanBaseBatchZf", method = RequestMethod.POST)
	public int savePlanBaseBatchZf(@RequestBody List<PlanBase> list){
		int result = 500;
		try {
			result = planBaseService.savePlanBaseBatchZf(list);
		} catch (Exception e) {
			logger.error("[任务管理-保存工单事项失败]", e);
		}
		return result;
	}

	/**
	 * 查看工单事项列表
	 * @param param
	 * @return
	 */
	@ApiOperation(value = "查看计划任务列表")
	@RequestMapping(value = "/queryBotWorkOrderMatterList",method = RequestMethod.POST)
	public LayuiTableData queryBotWorkOrderMatterList(@RequestBody LayuiTableParam param) {
		LayuiTableData data = null;
		try {
			data = planBaseService.queryBotWorkOrderMatterList(param);
		} catch (Exception e) {
			logger.error("[任务管理-查询计划任务列表失败：]", e);
		}
		return data;
	}
	
	/**
	 * 查看我的计划任务列表
	 * @param param
	 * @return
	 */
	@ApiOperation(value = "查看我的计划任务列表")
	@RequestMapping(value = "/my/botWorkOrder_list",method = RequestMethod.POST)
	public LayuiTableData queryMyBotWorkOrderListByPage(@RequestBody LayuiTableParam param) {
		LayuiTableData data = null;
		try {
			data = planBaseService.queryMyBotWorkOrderListByPage(param);
		} catch (Exception e) {
			logger.error("[任务管理-查询我的计划任务列表失败：]", e);
		}
		return data;
	}
	
	/**
	 * 查看工单事项列表
	 * @param param
	 * @return
	 */
	@ApiOperation(value = "查看计划任务列表")
	@RequestMapping(value = "/queryMyBotWorkOrderMatterList",method = RequestMethod.POST)
	public LayuiTableData queryMyBotWorkOrderMatterList(@RequestBody LayuiTableParam param) {
		LayuiTableData data = null;
		try {
			data = planBaseService.queryMyBotWorkOrderMatterList(param);
		} catch (Exception e) {
			logger.error("[任务管理-查询计划任务列表失败：]", e);
		}
		return data;
	}
	/**
	 * 新增工单事项
	 * @param list
	 * @return
	 */
	@ApiOperation(value = "新增工单事项保存", notes = "新增工单事项保存")
	@RequestMapping(value = "/saveMyBotWorkOrderMatterBatch", method = RequestMethod.POST)
	public int saveMyBotWorkOrderMatterBatch(@RequestBody List<PlanBaseDetail> list){
		int result = 500;
		try {
			result = planBaseService.saveMyBotWorkOrderMatterBatch(list);
		} catch (Exception e) {
			logger.error("[任务管理-保存工单事项失败]", e);
		}
		return result;
	}
	/**
	 * 提交我的计划任务事项反馈
	 * @param id
	 * @return
	 */
	@ApiOperation(value = "提交计划任务-key", notes = "根据ID提交计划任务信息")
	@RequestMapping(value = "/submitMyBotWorkOrder/{id}", method = RequestMethod.POST)
	public int submitMyBotWorkOrder(@PathVariable(value = "id", required = true) String id){
		int result = 500;
		try {
			result = planBaseService.submitMyBotWorkOrder(id);
		} catch (Exception e) {
			logger.error("[任务管理-提交计划任务失败]", e);
		}
		return result;
	}

    @Autowired
    private PlanBaseService baseService;

    @ApiOperation(value = "查询当前用户分配给其他人的任务", notes = "查询当前用户分配给其他人的任务")
    @RequestMapping(value = "/selectSonPlanBasesByCreateUserId", method = RequestMethod.POST)
    public JSONObject selectSonPlanBasesByCreateUserId(@RequestBody JSONObject jsonObject) {
        JSONObject retJson = new JSONObject();
        try {
            List<PlanBase> list = baseService.selectSonPlanBasesByCreateUserId(jsonObject);
            retJson.put("list", list);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return retJson;
    }
}
