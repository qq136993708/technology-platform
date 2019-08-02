package com.pcitc.service.plan;

import java.util.List;
import java.util.Map;

import com.alibaba.fastjson.JSONObject;
import com.pcitc.base.common.LayuiTableData;
import com.pcitc.base.common.LayuiTableParam;
import com.pcitc.base.common.TreeNode;
import com.pcitc.base.plan.PlanBase;
import com.pcitc.base.plan.PlanBaseDetail;

public interface PlanService {

	PlanBase findBotWorkOrderById(String dataId);

	int saveBotWorkOrder(PlanBase vo);

	int deleteBotWorkOrder(String id);

	int editBotWorkOrder(PlanBase vo);

	LayuiTableData queryBotWorkOrderListByPage(LayuiTableParam param);

	int affirmBotWorkOrder(String id);

	int submitBotWorkOrder(String dataId);

	int updatePlanSonWorkOrderStatus(String dataId);

	PlanBaseDetail findBotWorkOrderMatterById(String dataId);

	int saveBotWorkOrderMatterBatch(List<PlanBaseDetail> list);

	int savePlanBaseBatch(List<PlanBase> list);

	int savePlanBaseBatchZf(List<PlanBase> list);

	int deleteBotWorkOrderMatter(String id);

	int editBotWorkOrderMatter(PlanBaseDetail vo);

	LayuiTableData queryBotWorkOrderMatterList(LayuiTableParam param);

	int affirmBotWorkOrderMatter(String id);

	int submitBotWorkOrderMatter(String dataId);

	LayuiTableData queryMyBotWorkOrderListByPage(LayuiTableParam param);

	LayuiTableData queryMyBotWorkOrderMatterList(LayuiTableParam param);

	int saveMyBotWorkOrderMatterBatch(PlanBase planBase);

	int submitMyBotWorkOrder(String id);

    public String selectTreeData(JSONObject jsonObject) throws Exception;

    public List selectTreeDataList(JSONObject jsonObject);
    /**
     * 领导页的任务督办
     */
    public LayuiTableData getWorkOrderForLeader(LayuiTableParam param);

    public String selectListPlan(JSONObject jsonObject);

    /**
     * 计算值
     * @param jsonObject
     */
    public void calPlanBl(JSONObject jsonObject);

}
