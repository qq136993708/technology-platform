package com.pcitc.web.groupinformation;


import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.github.pagehelper.PageInfo;
import com.pcitc.base.common.Result;
import com.pcitc.base.groupinformation.BlocScientificPlan;
import com.pcitc.base.scientificplan.SciencePlan;
import com.pcitc.service.groupinformation.BlocScientificPlanService;
import com.pcitc.web.scientificplan.SciencePlanClient;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;


@Api(value = "blocScientificPlan-api", description = "集团信息发布—科技规划接口")
@RestController
@RequestMapping(value = "/blocScientificPlan-api")
public class BlocScientificPlanClient {

    private final static Logger logger = LoggerFactory.getLogger(BlocScientificPlanClient.class);

    @Autowired
    private BlocScientificPlanService blocScientificPlanService;


    @ApiOperation(value = "根据主键获取一个平台的信息", notes = "根据主键获取一个平台的信息")
    @RequestMapping(value = "/load/{id}", method = RequestMethod.GET)
    public BlocScientificPlan load(@PathVariable String id) {
        return blocScientificPlanService.load(id);
    }


    @ApiOperation(value = "集团信息发布—科技规划信息保存", notes = "集团信息发布—科技规划信息保存")
    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public BlocScientificPlan save(@RequestBody BlocScientificPlan blocScientificPlan) {
        return blocScientificPlanService.save(blocScientificPlan);
    }

    @ApiOperation(value = "集团信息发布—科技规划信息查询", notes = "集团信息发布—科技规划信息查询")
    @RequestMapping(value = "/query", method = RequestMethod.POST)
    public PageInfo query(@RequestBody(required = false) Map param) {
        return blocScientificPlanService.query(param);
    }

    @ApiOperation(value = "集团信息发布—科技规划信息删除", notes = "集团信息发布—科技规划信息删除")
    @RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE)
    public Integer delete(@PathVariable String id) {
        return blocScientificPlanService.delete(id);

    }

    @ApiOperation(value = "无分页集团信息发布—科技规划信息查询", notes = "无分页集团信息发布—科技规划信息查询")
    @RequestMapping(value = "/queryNoPage", method = RequestMethod.POST)
    public JSONArray queryNoPage(@RequestBody(required = false) Map param) {
        List list = blocScientificPlanService.queryNoPage(param);
        JSONArray json = JSONArray.parseArray(JSON.toJSONString(list));
        return json;
    }

    @ApiOperation(value = "导入集团发布信息", notes = "导入集团发布信息")
    @RequestMapping(value = "/excel_input", method = RequestMethod.POST)
    public Result excel_input(@RequestBody List<BlocScientificPlan> list) throws Exception
    {
        Result result=new Result();
        try {
            int count = blocScientificPlanService.insertBatch(list);
            result.setSuccess(true);
        } catch (Exception e) {
            result.setSuccess(false);
            result.setMessage("导入科技规划失败");
            logger.error("导入专家信息失败", e);
        }
        return result;
    }


}
