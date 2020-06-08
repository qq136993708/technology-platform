package com.pcitc.web.achieve;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.pcitc.base.achieve.AchieveMaintainBI;
import com.pcitc.base.achieve.AchieveRecordBI;
import com.pcitc.service.achieve.AchieveMaintainBIService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

/***
 * @Author xiaoh
 * @Description  成果管理领导驾驶舱
 * @Date 2020/6/4 15:23
 * @param
 * @return
 **/

@Api(value = "achieveMaintainBI-api", description = "成果管理领导驾驶舱接口")
@RestController
@RequestMapping(value = "/achieveMaintainBI-api")
public class AchieveMaintainBIClient {

    @Autowired
    private AchieveMaintainBIService ams;

    @ApiOperation(value = "获奖按年份统计", notes = "获奖按年份统计")
    @RequestMapping(value = "/getAwardSumByQuery", method = RequestMethod.POST)
    public JSONArray getAwardSumByQuery(@RequestBody(required = false) Map param){
        List<AchieveMaintainBI> biList= ams.getAwardSumByQuery(param);
        JSONArray json = JSONArray.parseArray(JSON.toJSONString(biList));
        return json;
    }


    @ApiOperation(value = "获奖按年份、奖励分类统计 - 饼图", notes = "获奖按年份、奖励分类统计 - 饼图")
    @RequestMapping(value = "/getAwardSumByTypePie", method = RequestMethod.POST)
    public JSONArray getAwardSumByTypePie(@RequestBody(required = false) Map param){
        List<AchieveMaintainBI> biList= ams.getAwardSumByTypePie(param);
        JSONArray json = JSONArray.parseArray(JSON.toJSONString(biList));
        return json;
    }


    @ApiOperation(value = "获奖明细", notes = "获奖明细")
    @RequestMapping(value = "/getDetailList", method = RequestMethod.POST)
    public JSONArray getDetailList(@RequestBody(required = false) Map param){
        List<AchieveMaintainBI> biList= ams.getAwardDetailByQuery(param);
        JSONArray json = JSONArray.parseArray(JSON.toJSONString(biList));
        return json;
    }

    @ApiOperation(value = "历年成果转化完成情况", notes = "历年成果转化完成情况")
    @RequestMapping(value = "/getAchieveTransferByYear", method = RequestMethod.POST)
    public JSONArray getAchieveTransferByYear(@RequestBody(required = false) Map param){
        List<AchieveRecordBI> biList= ams.getAchieveTransferByYear(param);
        JSONArray json = JSONArray.parseArray(JSON.toJSONString(biList));
        return json;
    }

    @ApiOperation(value = "成果转化方式", notes = "成果转化方式")
    @RequestMapping(value = "/getAchieveTransferByType", method = RequestMethod.POST)
    public JSONArray getAchieveTransferByType(@RequestBody(required = false) Map param){
        List<AchieveRecordBI> biList= ams.getAchieveTransferByType(param);
        JSONArray json = JSONArray.parseArray(JSON.toJSONString(biList));
        return json;
    }

    @ApiOperation(value = "二级单位成果转化情况", notes = "二级单位成果转化情况")
    @RequestMapping(value = "/getAchieveTransferByOffice", method = RequestMethod.POST)
    public JSONArray getAchieveTransferByOffice(@RequestBody(required = false) Map param){
        List<AchieveRecordBI> biList= ams.getAchieveTransferByOffice(param);
        JSONArray json = JSONArray.parseArray(JSON.toJSONString(biList));
        return json;
    }

}
