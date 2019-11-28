package com.pcitc.web.researchplatform;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.github.pagehelper.PageInfo;
import com.pcitc.base.researchplatform.PlatformAchievementModel;
import com.pcitc.base.researchplatform.PlatformProjectModel;
import com.pcitc.service.researchplatform.PlatformAchievementService;
import com.pcitc.service.researchplatform.PlatformProjectService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

/**
 * <p>服务接口</p>
 * <p>科研平台-成果信息</p>
 * @author ty
 */

@Api(value = "researchPlatformAchievement-api", description = "国家科研平台成果接口")
@RestController
@RequestMapping(value = "/researchPlatformAchievement-api")
public class PlatformAchievementClient {

    @Autowired
    private PlatformAchievementService pas;

    @ApiOperation(value = "根据主键获取一个平台成果的信息", notes = "根据主键获取一个平台成果的信息")
    @RequestMapping(value = "/load/{id}", method = RequestMethod.GET)
    public PlatformAchievementModel load(@PathVariable String id){
        return pas.load(id);
    }

    @ApiOperation(value = "科研平台项目保存", notes = "科研平台项目保存")
    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public PlatformAchievementModel save(@RequestBody PlatformAchievementModel platformAchievementModel){
        return pas.save(platformAchievementModel);
    }

    @ApiOperation(value = "平台项目批量保存", notes = "平台项目批量保存")
    @RequestMapping(value = "/batchSave", method = RequestMethod.POST)
    public Integer batchSave(@RequestBody List<PlatformAchievementModel> list){
        return pas.batchSave(list);
    }

    @ApiOperation(value = "查询科研平台项目列表分页", notes = "查询科研平台项目列表分页")
    @RequestMapping(value = "/query", method = RequestMethod.POST)
    public PageInfo query(@RequestBody(required = false) Map param){
        return pas.query(param);
    }

    @ApiOperation(value = "查询科研平台项目列表", notes = "查询科研平台列表")
    @RequestMapping(value = "/queryNoPage", method = RequestMethod.POST)
    public JSONArray queryNoPage(@RequestBody(required = false) Map param){
        List list=pas.queryNoPage(param);
        JSONArray json = JSONArray.parseArray(JSON.toJSONString(list));
        return json;
    }


    @ApiOperation(value = "科研平台项目删除", notes = "科研平台项目删除")
    @RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE)
    public Integer delete(@PathVariable String id){
        return pas.delete(id);
    }

}
