package com.pcitc.web.achieve;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.pcitc.base.achieve.AchieveMaintainBI;
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
}
