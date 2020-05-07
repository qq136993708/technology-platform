package com.pcitc.web.achieve;

import com.github.pagehelper.PageInfo;
import com.pcitc.base.achieve.AchieveBase;
import com.pcitc.base.achieve.AchieveIdentifyPlan;
import com.pcitc.base.common.Constant;
import com.pcitc.base.common.Result;
import com.pcitc.base.workflow.Constants;
import com.pcitc.service.achieve.AchieveBaseService;
import com.pcitc.service.achieve.AchieveIdentifyPlanService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

/**
 * <p>成果鉴定-计划<</p>
 * @author ty
 */

@Api(value = "achieveIdentifyPlan-api", description = "成果鉴定-计划<")
@RestController
@RequestMapping(value = "/achieveIdentifyPlan-api")
public class AchieveIdentifyPlanClient {

    @Autowired
    private AchieveIdentifyPlanService aps;
    @ApiOperation(value = "load成果鉴定计划", notes = "load成果鉴定计划")
    @RequestMapping(value = "/load/{id}", method = RequestMethod.GET)
    public AchieveIdentifyPlan load(@PathVariable String id){
        return aps.load(id);
    }

    @ApiOperation(value = "成果鉴定计划", notes = "成果鉴定计划")
    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public void save(@RequestBody AchieveIdentifyPlan achieveIdentifyPlan){
        aps.save(achieveIdentifyPlan);
    }


    @ApiOperation(value = "查询成果鉴定计划列表分页", notes = "查询成果鉴定计划列表分页")
    @RequestMapping(value = "/query", method = RequestMethod.POST)
    public PageInfo query(@RequestBody(required = false) Map param){
        return aps.query(param);
    }



    @ApiOperation(value = "成果鉴定计划删除", notes = "成果鉴定计划删除")
    @RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE)
    public Integer delete(@PathVariable String id){
         return aps.delete(id);
    }



}
