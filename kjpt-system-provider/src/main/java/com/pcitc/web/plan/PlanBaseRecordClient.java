package com.pcitc.web.plan;


import com.alibaba.fastjson.JSONObject;
import com.pcitc.base.common.LayuiTableParam;
import com.pcitc.base.plan.PlanBaseRecord;
import com.pcitc.service.plan.PlanBaseRecordService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


/**
 * <p>服务接口</p>
 * <p>Table: plan_base_record - </p>
 *
 * @since 2018-11-12 10:15:05
 */
@Api(value = "PlanBaseRecordClient-API", description = "服务接口")
@RestController
public class PlanBaseRecordClient {
    private final static Logger logger = LoggerFactory.getLogger(PlanBaseRecordClient.class);

    @Autowired
    PlanBaseRecordService planBaseRecordService;


    //参数查询
    @ApiOperation(value = "带参查询列表", notes = "根据ID查询查询信息,返回一个的JSONObject对象")
    @RequestMapping(value = "/planbaserecord-provider/planbaserecord/planbaserecord_list_param", method = RequestMethod.POST)
    public JSONObject selectPlanBaseRecordListParam(@RequestParam(value = "id", required = false) String id) {
        JSONObject retJson = new JSONObject();
        try {
            PlanBaseRecord planBaseRecord = new PlanBaseRecord();
            planBaseRecord.setId(id);
            List<PlanBaseRecord> list = planBaseRecordService.findPlanBaseRecordList(planBaseRecord);
            retJson.put("list", list);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return retJson;
    }

    //对象查询,js需要JSON.stringify({id:"1"},转换之后,才能自动赋值
    @ApiOperation(value = "查询列表", notes = "自定义对象(条件)查询信息,返回存储在JSONObject对象中的列表")
    @RequestMapping(value = "/planbaserecord-provider/planbaserecord/planbaserecord_list", method = RequestMethod.POST)
    public JSONObject selectPlanBaseRecordList(@RequestBody PlanBaseRecord planBaseRecord) {
        JSONObject retJson = new JSONObject();
        try {
            List<PlanBaseRecord> list = planBaseRecordService.findPlanBaseRecordList(planBaseRecord);
            retJson.put("list", list);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return retJson;
    }


    @ApiOperation(value = "查询树形详情信息", notes = "按ID查询详情信息(带父ID),操作成功返回SysFileKind对象")
    @RequestMapping(value = "/planbaserecord-provider/planbaserecord/get-planbaserecord/{id}", method = RequestMethod.POST)
    public PlanBaseRecord getPlanBaseRecordInfo(@PathVariable(value = "id", required = true) String id) {
        try {
            return planBaseRecordService.getPlanBaseRecordInfo(id);
        } catch (Exception e) {
            logger.error("[初始化信息失败：]", e);
        }
        return null;
    }


    /**
     * 树形展示
     *
     * @return
     * @throws Exception
     */
    @ApiOperation(value = "查询(树)信息", notes = "查询(树)信息,操作成功返回List<TreeNode>对象")
    @RequestMapping(value = "/planbaserecord-provider/planbaserecord/tree-data")
    @ResponseBody
    public List selectObjectByTree() throws Exception {
        return planBaseRecordService.selectObjectByTree();
    }


    /**
     * 删除-false
     *
     * @param planBaseRecordcId
     * @return
     */
    @ApiOperation(value = "伪删除信息", notes = "按ID伪删除信息,操作成功返回201")
    @RequestMapping(value = "/planbaserecord-provider/planbaserecord/del-planbaserecord/{planBaseRecordId}")
    public Object deletePlanBaseRecord(@PathVariable("planBaseRecordId") String planBaseRecordcId) {
        return planBaseRecordService.deletePlanBaseRecord(planBaseRecordcId);
    }

    /**
     * 删除-true
     *
     * @param planBaseRecordcId
     * @return
     */
    @ApiOperation(value = "删除信息", notes = "按ID删除信息,操作成功返回201")
    @RequestMapping(value = "/planbaserecord-provider/planbaserecord/del-planbaserecord-real/{planBaseRecordId}", method = RequestMethod.POST)
    public Object deletePlanBaseRecordReal(@PathVariable("planBaseRecordId") String planBaseRecordcId) {
        return planBaseRecordService.deletePlanBaseRecordReal(planBaseRecordcId);
    }


    /**
     * 分页查询
     *
     * @param param
     * @return
     */
    @ApiOperation(value = "查询信息-分页查询", notes = "查询信息-分页查询,Object")
    @RequestMapping(value = "/planbaserecord-provider/planbaserecord/planbaserecord-page")
    public Object selectPlanBaseRecordByPage(@RequestBody LayuiTableParam param) {
        return planBaseRecordService.findPlanBaseRecordByPage(param);
    }

    /**
     * 保存
     *
     * @param planBaseRecord
     * @return
     */
    @ApiOperation(value = "新增信息", notes = "新增信息,操作成功返回500")
    @RequestMapping(value = "/planbaserecord-provider/planbaserecord/save_planbaserecord", method = RequestMethod.POST)
    public int updateOrInsertPlanBaseRecord(@RequestBody PlanBaseRecord planBaseRecord) {
        try {
            return planBaseRecordService.updateOrInsertPlanBaseRecord(planBaseRecord);
        } catch (Exception e) {
            logger.error("[保存信息失败：]", e);
        }
        return 500;
    }
}
