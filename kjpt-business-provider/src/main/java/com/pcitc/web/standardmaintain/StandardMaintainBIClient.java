package com.pcitc.web.standardmaintain;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.pcitc.service.standardmaintain.StandardMaintainBIService;
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
 * @Description 质量标准-领导驾驶舱
 * @Date 2020/6/8 17:45
 * @param
 * @return
 **/

@Api(value = "standardMaintainBI-api", description = "质量标准-领导驾驶舱")
@RestController
@RequestMapping(value = "/standardMaintainBI-api")
public class StandardMaintainBIClient {

    @Autowired
    private StandardMaintainBIService service;

    @ApiOperation(value = "国内标准在研数", notes = "国内标准在研数")
    @RequestMapping(value = "/getInternalResearchList", method = RequestMethod.POST)
    public JSONArray getInternalResearchList(@RequestBody(required = false) Map param){
        List list=service.getInternalResearchList(param);
        JSONArray json = JSONArray.parseArray(JSON.toJSONString(list));
        return json;
    }


    @ApiOperation(value = "国内累计发布数", notes = "国内累计发布数")
    @RequestMapping(value = "/getInternalPublishList", method = RequestMethod.POST)
    public JSONArray getInternalPublishList(@RequestBody(required = false) Map param){
        List list=service.getInternalPublishList(param);
        JSONArray json = JSONArray.parseArray(JSON.toJSONString(list));
        return json;
    }


    @ApiOperation(value = "国际标准在研、累计发布数", notes = "国际标准在研、累计发布数")
    @RequestMapping(value = "/getInternationalAllList", method = RequestMethod.POST)
    public JSONArray getInternationalAllList(@RequestBody(required = false) Map param){
        List list=service.getInternationalAllList(param);
        JSONArray json = JSONArray.parseArray(JSON.toJSONString(list));
        return json;
    }

}
