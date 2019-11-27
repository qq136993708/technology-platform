package com.pcitc.web.researchplatform;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.github.pagehelper.PageInfo;
import com.pcitc.base.researchplatform.PlatformTreatiseModel;
import com.pcitc.service.researchplatform.PlatformTreatiseService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

/**
 * <p>服务接口</p>
 * <p>科研平台-论文</p>
 * @author ty
 */

@Api(value = "researchPlatformTreatise-api", description = "国家科研平台论文接口")
@RestController
@RequestMapping(value = "/researchPlatformTreatise-api")
public class PlatformTreatiseClient {

    @Autowired
    private PlatformTreatiseService pts;

    @ApiOperation(value = "根据主键获取一个平台论文的信息", notes = "根据主键获取一个平台论文的信息")
    @RequestMapping(value = "/load/{id}", method = RequestMethod.GET)
    public PlatformTreatiseModel load(@PathVariable String id){
        return pts.load(id);
    }

    @ApiOperation(value = "科研平台论文保存", notes = "科研平台论文保存")
    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public PlatformTreatiseModel save(@RequestBody PlatformTreatiseModel platformTreatiseModel){

        return pts.save(platformTreatiseModel);
    }

    @ApiOperation(value = "科研平台论文批量保存", notes = "科研平台论文批量保存")
    @RequestMapping(value = "/batchSave", method = RequestMethod.POST)
    public Integer batchSave(@RequestBody List<PlatformTreatiseModel> list){
        return pts.batchSave(list);
    }

    @ApiOperation(value = "查询科研平台论文列表分页", notes = "查询科研平台论文列表分页")
    @RequestMapping(value = "/query", method = RequestMethod.POST)
    public PageInfo query(@RequestBody(required = false) Map param){
        return pts.query(param);
    }

    @ApiOperation(value = "查询科研平台论文列表", notes = "查询科研平台论文列表")
    @RequestMapping(value = "/queryNoPage", method = RequestMethod.POST)
    public JSONArray queryNoPage(@RequestBody(required = false) Map param){
        List list=pts.queryNoPage(param);
        JSONArray json = JSONArray.parseArray(JSON.toJSONString(list));
        return json;
    }


    @ApiOperation(value = "科研平台项目删除", notes = "科研平台项目删除")
    @RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE)
    public Integer delete(@PathVariable String id){
        return pts.delete(id);
    }
}
