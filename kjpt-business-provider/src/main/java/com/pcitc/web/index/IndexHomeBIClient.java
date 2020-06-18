package com.pcitc.web.index;


import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.pcitc.base.indexHome.calResult;
import com.pcitc.service.index.IndexHomeBIService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@Api(value = "领导驾驶舱首页数据", description = "领导驾驶舱首页数据")
@RestController
@RequestMapping(value = "/indexHomeBI")
public class IndexHomeBIClient {

    @Autowired
    private IndexHomeBIService ihs;

    @ApiOperation(value = "科技专家", notes = "科技专家")
    @RequestMapping(value = "/getTechnologyExpert", method = RequestMethod.POST)
    public JSONArray getTechnologyExpert(@RequestBody(required = false) Map param){
        List<calResult> biList= ihs.getTechnologyExpert(param);
        JSONArray json = JSONArray.parseArray(JSON.toJSONString(biList));
        return json;
    }

    @ApiOperation(value = "科研平台", notes = "科研平台")
    @RequestMapping(value = "/getTechnologyPlatform", method = RequestMethod.POST)
    public JSONArray getTechnologyPlatform(@RequestBody(required = false) Map param){
        List<calResult> biList= ihs.getTechnologyPlatform(param);
        JSONArray json = JSONArray.parseArray(JSON.toJSONString(biList));
        return json;
    }

    @ApiOperation(value = "成果获奖（累计）", notes = "成果获奖（累计）")
    @RequestMapping(value = "/getAchieveAward", method = RequestMethod.POST)
    public JSONArray getAchieveAward(@RequestBody(required = false) Map param){
        List<calResult> biList= ihs.getAchieveAward(param);
        JSONArray json = JSONArray.parseArray(JSON.toJSONString(biList));
        return json;
    }

    @ApiOperation(value = "知识产权（累计）", notes = "成果获奖（累计）")
    @RequestMapping(value = "/getIntellectualProperty", method = RequestMethod.POST)
    public JSONArray getIntellectualProperty(@RequestBody(required = false) Map param){
        List<calResult> biList= ihs.getIntellectualProperty(param);
        JSONArray json = JSONArray.parseArray(JSON.toJSONString(biList));
        return json;
    }

    @ApiOperation(value = "专利数量（累计）", notes = "成果获奖（累计）")
    @RequestMapping(value = "/getPatent", method = RequestMethod.POST)
    public JSONArray getPatent(@RequestBody(required = false) Map param){
        List<calResult> biList= ihs.getPatent(param);
        JSONArray json = JSONArray.parseArray(JSON.toJSONString(biList));
        return json;
    }

    @ApiOperation(value = "成果转化（累计）", notes = "成果获奖（累计）")
    @RequestMapping(value = "/getAchieveTransfer", method = RequestMethod.POST)
    public JSONArray getAchieveTransfer(@RequestBody(required = false) Map param){
        List<calResult> biList= ihs.getAchieveTransfer(param);
        JSONArray json = JSONArray.parseArray(JSON.toJSONString(biList));
        return json;
    }

    @ApiOperation(value = "科研项目（累计）", notes = "成果获奖（累计）")
    @RequestMapping(value = "/getTechnologyProject", method = RequestMethod.POST)
    public JSONArray getTechnologyProject(@RequestBody(required = false) Map param){
        List<calResult> biList= ihs.getTechnologyProject(param);
        JSONArray json = JSONArray.parseArray(JSON.toJSONString(biList));
        return json;
    }


    @ApiOperation(value = "项目投资（累计）", notes = "成果获奖（累计）")
    @RequestMapping(value = "/getProjectInvest", method = RequestMethod.POST)
    public JSONArray getProjectInvest(@RequestBody(required = false) Map param){
        List<calResult> biList= ihs.getProjectInvest(param);
        JSONArray json = JSONArray.parseArray(JSON.toJSONString(biList));
        return json;
    }

    @ApiOperation(value = "质量信息（累计）", notes = "成果获奖（累计）")
    @RequestMapping(value = "/getQualityInfo", method = RequestMethod.POST)
    public JSONArray getQualityInfo(@RequestBody(required = false) Map param){
        List<calResult> biList= ihs.getQualityInfo(param);
        JSONArray json = JSONArray.parseArray(JSON.toJSONString(biList));
        return json;
    }
    @ApiOperation(value = "二级单位科研平台分布情况", notes = "二级单位科研平台分布情况")
    @RequestMapping(value = "/distribution", method = RequestMethod.POST)
    public JSONArray distribution(@RequestBody(required = false) Map param){
        List biList= ihs.distribution(param);
        JSONArray json = JSONArray.parseArray(JSON.toJSONString(biList));
        return json;
    }

}
