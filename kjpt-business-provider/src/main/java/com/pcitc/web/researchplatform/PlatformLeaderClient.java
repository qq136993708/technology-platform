package com.pcitc.web.researchplatform;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.github.pagehelper.PageInfo;
import com.pcitc.base.researchplatform.PlatformLeaderModel;
import com.pcitc.base.researchplatform.PlatformMemberModel;
import com.pcitc.service.researchplatform.PlatformLeaderService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

/**
 * <p>领军人物</p>
 * <p>科研平台-领军人物</p>
 * @author ty
 */

@Api(value = "researchPlatformLeader-api", description = "国家科研平台领军人物")
@RestController
@RequestMapping(value = "/researchPlatformLeader-api")
public class PlatformLeaderClient {
    @Autowired
    private PlatformLeaderService pls;

    @ApiOperation(value = "根据主键获取一个平台领军人物的信息", notes = "根据主键获取一个平台领军人物的信息")
    @RequestMapping(value = "/load/{id}", method = RequestMethod.GET)
    public PlatformLeaderModel load(@PathVariable String id){
        return pls.load(id);
    }

    @ApiOperation(value = "科研平台领军人物保存", notes = "科研平台领军人物保存")
    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public void save(@RequestBody PlatformLeaderModel platformLeaderModel){
         pls.save(platformLeaderModel);
    }

    @ApiOperation(value = "平台领军人物批量保存", notes = "平台领军人物批量保存")
    @RequestMapping(value = "/batchSave", method = RequestMethod.POST)
    public Integer batchSave(@RequestBody List<PlatformLeaderModel> list){
        return pls.batchSave(list);
    }

    @ApiOperation(value = "查询科研平台领军人物列表分页", notes = "查询科研平台领军人物列表分页")
    @RequestMapping(value = "/query", method = RequestMethod.POST)
    public PageInfo query(@RequestBody(required = false) Map param){
        return pls.query(param);
    }

    @ApiOperation(value = "查询科研平台领军人物列表", notes = "查询科研平台领军人物列表")
    @RequestMapping(value = "/queryNoPage", method = RequestMethod.POST)
    public JSONArray queryNoPage(@RequestBody(required = false) Map param){
        List list=pls.queryNoPage(param);
        JSONArray json = JSONArray.parseArray(JSON.toJSONString(list));
        return json;
    }

    @ApiOperation(value = "科研平台领军人物删除", notes = "科研平台领军人物删除")
    @RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE)
    public Integer delete(@PathVariable String id){
        return pls.delete(id);
    }


}
