package com.pcitc.web.researchplatform;

import com.github.pagehelper.PageInfo;
import com.pcitc.base.researchplatform.PlatformPatentModel;
import com.pcitc.service.researchplatform.PlatformPatentService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

/**
 * <p>服务接口</p>
 * <p>科研平台-专利</p>
 * @author ty
 */

@Api(value = "researchPlatformPatent-api", description = "国家科研平台专利接口")
@RestController
@RequestMapping(value = "/researchPlatformPatent-api")
public class PlatformPatentClient {

    @Autowired
    private PlatformPatentService pps;

    @ApiOperation(value = "根据主键获取一个平台专利的信息", notes = "根据主键获取一个平台专利的信息")
    @RequestMapping(value = "/load/{id}", method = RequestMethod.GET)
    public PlatformPatentModel load(@PathVariable String id){
        return pps.load(id);
    }

    @ApiOperation(value = "科研平台项目保存", notes = "科研平台项目保存")
    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public PlatformPatentModel save(@RequestBody PlatformPatentModel platformPatentModel){

        return pps.save(platformPatentModel);
    }

    @ApiOperation(value = "平台项目批量保存", notes = "平台项目批量保存")
    @RequestMapping(value = "/batchSave", method = RequestMethod.POST)
    public Integer batchSave(@RequestBody List<PlatformPatentModel> list){
        return pps.batchSave(list);
    }

    @ApiOperation(value = "查询科研平台项目列表", notes = "查询科研平台项目列表")
    @RequestMapping(value = "/query", method = RequestMethod.POST)
    public PageInfo query(@RequestBody(required = false) Map param){
        return pps.query(param);
    }


    @ApiOperation(value = "科研平台项目删除", notes = "科研平台项目删除")
    @RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE)
    public Integer delete(@PathVariable String id){
        return pps.delete(id);
    }
}
