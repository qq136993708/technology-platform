package com.pcitc.web.expert;


import com.alibaba.fastjson.JSONObject;
import com.pcitc.base.common.LayuiTableParam;
import com.pcitc.base.common.ResultSKM;
import com.pcitc.base.expert.ZjkExpert;
import com.pcitc.base.expert.ZjkExpertExample;
import com.pcitc.service.expert.ZjkBaseInfoService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;


@Api(value = "dataSKMClient-API", description = "第三方信息服务接口")
@RestController
public class DataSKMClient {
    private final static Logger logger = LoggerFactory.getLogger(DataSKMClient.class);

    @Autowired
    ZjkBaseInfoService zjkBaseInfoService;

    @ApiOperation(value = "SKM-专家接口", notes = "SKM专家接口,返回Result")
    @RequestMapping(value = "/dataSKM-provider/dataSKM/saveExpert", method = RequestMethod.POST)
    public JSONObject saveExpert(@RequestBody JSONObject jsonObject) {
        JSONObject retJson = new JSONObject();
        try {
            retJson = zjkBaseInfoService.SaveSKMExpert(jsonObject);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return retJson;
    }

    @ApiOperation(value = "SKM-知识分类", notes = "SKM知识分类,返回Result")
    @RequestMapping(value = "/dataSKM-provider/dataSKM/saveType", method = RequestMethod.POST)
    public JSONObject saveSKMType(@RequestBody JSONObject jsonObject) {
        JSONObject retJson = new JSONObject();
        try {
            retJson = zjkBaseInfoService.SaveSKMType(jsonObject);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return retJson;
    }

    @ApiOperation(value = "SKM-专利保存", notes = "SKM专利保存,返回Result")
    @RequestMapping(value = "/dataSKM-provider/dataSKM/savePatent", method = RequestMethod.POST)
    public JSONObject saveSKMPatent(@RequestBody JSONObject jsonObject) {
        JSONObject retJson = new JSONObject();
        try {
            retJson = zjkBaseInfoService.savePatent(jsonObject);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return retJson;
    }

    @ApiOperation(value = "SKM-成果保存", notes = "SKM成果保存,返回Result")
    @RequestMapping(value = "/dataSKM-provider/dataSKM/saveAchievement", method = RequestMethod.POST)
    public JSONObject saveSKMAchievement(@RequestBody JSONObject jsonObject) {
        JSONObject retJson = new JSONObject();
        try {
            retJson = zjkBaseInfoService.saveSKMAchievement(jsonObject);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return retJson;
    }


}


