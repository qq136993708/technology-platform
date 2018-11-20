package com.pcitc.web.plan;


import com.alibaba.fastjson.JSONObject;
import com.pcitc.base.common.LayuiTableParam;
import com.pcitc.base.plan.PlanBaseDetail;
import com.pcitc.service.plan.PlanBaseDetailService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


/**
 * <p>服务接口</p>
 * <p>Table: plan_base_detail - 工程签证申请</p>
 *
 * @since 2018-11-12 10:15:00
 */
@Api(value = "PlanBaseDetailClient-API", description = "工程签证申请服务接口")
@RestController
public class PlanBaseDetailClient {
    private final static Logger logger = LoggerFactory.getLogger(PlanBaseDetailClient.class);

    @Autowired
    PlanBaseDetailService planBaseDetailService;


    //参数查询
    @ApiOperation(value = "带参工程签证申请查询列表", notes = "根据ID查询查询工程签证申请信息,返回一个工程签证申请的JSONObject对象")
    @RequestMapping(value = "/planbasedetail-provider/planbasedetail/planbasedetail_list_param", method = RequestMethod.POST)
    public JSONObject selectPlanBaseDetailListParam(@RequestParam(value = "id", required = false) String id) {
        JSONObject retJson = new JSONObject();
        try {
            PlanBaseDetail planBaseDetail = new PlanBaseDetail();
            planBaseDetail.setId(id);
            List<PlanBaseDetail> list = planBaseDetailService.findPlanBaseDetailList(planBaseDetail);
            retJson.put("list", list);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return retJson;
    }

    //对象查询,js需要JSON.stringify({id:"1"},转换之后,才能自动赋值
    @ApiOperation(value = "工程签证申请查询列表", notes = "自定义对象(条件)查询工程签证申请信息,返回存储在JSONObject对象中的工程签证申请列表")
    @RequestMapping(value = "/planbasedetail-provider/planbasedetail/planbasedetail_list", method = RequestMethod.POST)
    public JSONObject selectPlanBaseDetailList(@RequestBody PlanBaseDetail planBaseDetail) {
        JSONObject retJson = new JSONObject();
        try {
            List<PlanBaseDetail> list = planBaseDetailService.findPlanBaseDetailList(planBaseDetail);
            retJson.put("list", list);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return retJson;
    }


    @ApiOperation(value = "查询工程签证申请树形详情信息", notes = "按ID查询工程签证申请详情信息(带父ID),操作成功返回SysFileKind对象")
    @RequestMapping(value = "/planbasedetail-provider/planbasedetail/get-planbasedetail/{id}", method = RequestMethod.POST)
    public PlanBaseDetail getPlanBaseDetailInfo(@PathVariable(value = "id", required = true) String id) {
        try {
            return planBaseDetailService.getPlanBaseDetailInfo(id);
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
    @ApiOperation(value = "查询(树)工程签证申请信息", notes = "查询(树)工程签证申请信息,操作成功返回List<TreeNode>对象")
    @RequestMapping(value = "/planbasedetail-provider/planbasedetail/tree-data")
    @ResponseBody
    public List selectObjectByTree() throws Exception {
        return planBaseDetailService.selectObjectByTree();
    }


    /**
     * 删除工程签证申请-false
     *
     * @param planBaseDetailcId
     * @return
     */
    @ApiOperation(value = "伪删除工程签证申请信息", notes = "按ID伪删除工程签证申请信息,操作成功返回201")
    @RequestMapping(value = "/planbasedetail-provider/planbasedetail/del-planbasedetail/{planBaseDetailId}")
    public Object deletePlanBaseDetail(@PathVariable("planBaseDetailId") String planBaseDetailcId) {
        return planBaseDetailService.deletePlanBaseDetail(planBaseDetailcId);
    }

    /**
     * 删除工程签证申请-true
     *
     * @param planBaseDetailcId
     * @return
     */
    @ApiOperation(value = "删除工程签证申请信息", notes = "按ID删除工程签证申请信息,操作成功返回201")
    @RequestMapping(value = "/planbasedetail-provider/planbasedetail/del-planbasedetail-real/{planBaseDetailId}", method = RequestMethod.POST)
    public Object deletePlanBaseDetailReal(@PathVariable("planBaseDetailId") String planBaseDetailcId) {
        return planBaseDetailService.deletePlanBaseDetailReal(planBaseDetailcId);
    }


    /**
     * 分页查询
     *
     * @param param
     * @return
     */
    @ApiOperation(value = "查询工程签证申请信息-分页查询", notes = "查询工程签证申请信息-分页查询,Object")
    @RequestMapping(value = "/planbasedetail-provider/planbasedetail/planbasedetail-page")
    public Object selectPlanBaseDetailByPage(@RequestBody LayuiTableParam param) {
        return planBaseDetailService.findPlanBaseDetailByPage(param);
    }

    /**
     * 保存
     *
     * @param planBaseDetail
     * @return
     */
    @ApiOperation(value = "新增工程签证申请信息", notes = "新增工程签证申请信息,操作成功返回500")
    @RequestMapping(value = "/planbasedetail-provider/planbasedetail/save_planbasedetail", method = RequestMethod.POST)
    public int updateOrInsertPlanBaseDetail(@RequestBody PlanBaseDetail planBaseDetail) {
        try {
            return planBaseDetailService.updateOrInsertPlanBaseDetail(planBaseDetail);
        } catch (Exception e) {
            logger.error("[保存信息失败：]", e);
        }
        return 500;
    }
}
