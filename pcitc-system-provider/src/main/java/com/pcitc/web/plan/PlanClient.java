package com.pcitc.web.plan;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

import java.util.List;
import java.util.UUID;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSONObject;
import com.pcitc.base.common.LayuiTableData;
import com.pcitc.base.common.LayuiTableParam;
import com.pcitc.base.plan.PlanBase;
import com.pcitc.base.plan.PlanBaseDetail;
import com.pcitc.base.plan.PlanBaseDetailExample;
import com.pcitc.base.plan.PlanBaseDetailExample.Criteria;
import com.pcitc.service.plan.PlanBaseDetailService;
import com.pcitc.service.plan.PlanBaseService;
import com.pcitc.service.plan.PlanService;

@Api(value = "PlanClient-API", description = "计划任务相关的接口")
@RestController
public class PlanClient {

	@Autowired
	private PlanService planBaseService;
	
	@Autowired
	private PlanBaseDetailService planBaseDetailService;
	
	private final static Logger logger = LoggerFactory.getLogger(PlanClient.class);

	/**
	 * 查看计划任务列表
	 *
	 * @param param
	 * @return
	 */
	@ApiOperation(value = "查看计划任务列表")
	@RequestMapping(value = "/planClient-provider/botWorkOrder_list", method = RequestMethod.POST)
	public LayuiTableData queryBotWorkOrderListByPage(@RequestBody LayuiTableParam param) {
		LayuiTableData data = null;
		try {
			data = planBaseService.queryMyBotWorkOrderListByPage(param);
			// data = planBaseService.queryBotWorkOrderListByPage(param);
		} catch (Exception e) {
			logger.error("[任务管理-查询计划任务列表失败：]", e);
		}
		return data;
	}

	/**
	 * 根据ID查看计划任务
	 *
	 * @param dataId
	 * @return
	 */
	@ApiOperation(value = "查看计划任务信息-key", notes = "根据ID查询计划任务详情")
	@RequestMapping(value = "/planClient-provider/viewBotWorkOrder/{dataId}", method = RequestMethod.POST)
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
	 *
	 * @param vo
	 * @return
	 */
	@ApiOperation(value = "新增计划任务保存", notes = "新增计划任务保存")
	@RequestMapping(value = "/planClient-provider/saveBotWorkOrder", method = RequestMethod.POST)
	public int saveBotWorkOrder(@RequestBody PlanBase vo) {
		int result = 500;
		try {
			result = planBaseService.saveBotWorkOrder(vo);
		} catch (Exception e) {
			logger.error("[任务管理-保存计划任务失败]", e);
		}
		return result;
	}
	
	/**
	 * 转发任务时，保存新任务信息，同时复制原任务对应的反馈、附件信息
	 *
	 * @param vo
	 * @return
	 */
	@ApiOperation(value = "新增计划任务保存", notes = "新增计划任务保存")
	@RequestMapping(value = "/planClient-provider/zf/saveBotWorkOrder", method = RequestMethod.POST)
	public int saveBotWorkOrderForZF(@RequestBody PlanBase vo) {
		int result = 500;
		try {
			result = planBaseService.saveBotWorkOrder(vo);
			PlanBaseDetailExample example = new PlanBaseDetailExample();
			Criteria cri = example.createCriteria();
			cri.andWorkOrderIdEqualTo(vo.getJsId());
			List<PlanBaseDetail> list = planBaseDetailService.selectByExample(example);
			for (int i = 0; i < list.size(); i++) {
				PlanBaseDetail pbd = list.get(i);
				pbd.setDataId(UUID.randomUUID().toString().replaceAll("-", ""));
				pbd.setWorkOrderId(vo.getDataId());
				planBaseDetailService.insert(pbd);
			}
		} catch (Exception e) {
			logger.error("[任务管理-保存计划任务失败]", e);
		}
		return result;
	}

	/**
	 * 删除计划任务
	 *
	 * @param id
	 * @return
	 */
	@ApiOperation(value = "删除计划任务-key", notes = "根据ID删除计划任务信息")
	@RequestMapping(value = "/planClient-provider/deleteBotWorkOrder/{id}", method = RequestMethod.POST)
	public int deleteBotWorkOrder(@PathVariable(value = "id", required = true) String id) {
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
	 *
	 * @param vo
	 * @return
	 */
	@ApiOperation(value = "修改计划任务-key", notes = "根据ID修改计划任务信息")
	@RequestMapping(value = "/planClient-provider/editBotWorkOrder", method = RequestMethod.POST)
	public int editBotWorkOrder(@RequestBody PlanBase vo) {
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
	 *
	 * @param id
	 * @return
	 */
	@ApiOperation(value = "提交计划任务-key", notes = "根据ID提交计划任务信息")
	@RequestMapping(value = "/planClient-provider/affirmBotWorkOrder/{id}", method = RequestMethod.POST)
	public int affirmBotWorkOrder(@PathVariable(value = "id", required = true) String id) {
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
	 *
	 * @param id
	 * @return
	 */
	@ApiOperation(value = "提交计划任务-key", notes = "根据ID提交计划任务信息")
	@RequestMapping(value = "/planClient-provider/submitBotWorkOrder/{id}", method = RequestMethod.POST)
	public int submitBotWorkOrder(@PathVariable(value = "id", required = true) String id) {
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
	 *
	 * @param list
	 * @return
	 */
	@ApiOperation(value = "新增工单事项保存", notes = "新增工单事项保存")
	@RequestMapping(value = "/planClient-provider/saveBotWorkOrderMatterBatch", method = RequestMethod.POST)
	public int saveBotWorkOrderMatterBatch(@RequestBody List<PlanBaseDetail> list) {
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
	 *
	 * @param list
	 * @return
	 */
	@ApiOperation(value = "新增子任务保存", notes = "新增子任务保存")
	@RequestMapping(value = "/planClient-provider/savePlanBaseBatch", method = RequestMethod.POST)
	public int savePlanBaseBatch(@RequestBody List<PlanBase> list) {
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
	 *
	 * @param list
	 * @return
	 */
	@ApiOperation(value = "转发子任务修改", notes = "转发子任务修改")
	@RequestMapping(value = "/planClient-provider/savePlanBaseBatchZf", method = RequestMethod.POST)
	public int savePlanBaseBatchZf(@RequestBody List<PlanBase> list) {
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
	 *
	 * @param param
	 * @return
	 */
	@ApiOperation(value = "查看计划任务列表")
	@RequestMapping(value = "/planClient-provider/queryBotWorkOrderMatterList", method = RequestMethod.POST)
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
	 *
	 * @param param
	 * @return
	 */
	@ApiOperation(value = "查看我的计划任务列表")
	@RequestMapping(value = "/planClient-provider/my/botWorkOrder_list", method = RequestMethod.POST)
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
	 *
	 * @param param
	 * @return
	 */
	@ApiOperation(value = "查看计划任务列表")
	@RequestMapping(value = "/planClient-provider/queryMyBotWorkOrderMatterList", method = RequestMethod.POST)
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
	 *
	 * @param list
	 * @return
	 */
	@ApiOperation(value = "新增工单事项保存", notes = "新增工单事项保存")
	@RequestMapping(value = "/planClient-provider/saveMyBotWorkOrderMatterBatch", method = RequestMethod.POST)
	public int saveMyBotWorkOrderMatterBatch(@RequestBody List<PlanBaseDetail> list) {
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
	 *
	 * @param id
	 * @return
	 */
	@ApiOperation(value = "提交计划任务-key", notes = "根据ID提交计划任务信息")
	@RequestMapping(value = "/planClient-provider/submitMyBotWorkOrder/{id}", method = RequestMethod.POST)
	public int submitMyBotWorkOrder(@PathVariable(value = "id", required = true) String id) {
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
	@RequestMapping(value = "/planClient-provider/selectSonPlanBasesByCreateUserId", method = RequestMethod.POST)
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

	/**
	 * 文件导入标准
	 *
	 * @param jsonObject
	 * @return
	 */
	@ApiOperation(value = "文件导入标准", notes = "文件导入标准")
	@RequestMapping(value = "/planClient-provider/importFileStandard", method = RequestMethod.POST)
	public JSONObject importFileStandard(@RequestBody JSONObject jsonObject) {
		JSONObject retJson = new JSONObject();
		try {
			baseService.importFileStandard(jsonObject);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			return retJson;
		}
	}

	/**
	 * 文件导入技术族
	 *
	 * @param jsonObject
	 * @return
	 */
	@ApiOperation(value = "文件导入技术族", notes = "文件导入技术族")
	@RequestMapping(value = "/planClient-provider/importFileTfc", method = RequestMethod.POST)
	public JSONObject importFileTfc(@RequestBody JSONObject jsonObject) {
		JSONObject retJson = new JSONObject();
		try {
			retJson = baseService.importFileTfc(jsonObject);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			return retJson;
		}
	}
}
