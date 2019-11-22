package com.pcitc.web.researchplatform;

import com.github.pagehelper.PageInfo;
import com.pcitc.base.researchPlatform.PlatformInfoModel;
import com.pcitc.base.researchPlatform.PlatformProjectModel;
import com.pcitc.service.researchplatform.PlatformProjectService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

/**
 * <p>服务接口</p>
 * <p>科研平台-项目信息</p>
 * @author ty
 */

@Api(value = "researchPlatformPorject-api", description = "国家科研平台项目接口")
@RestController
@RequestMapping(value = "/researchPlatformPorject-api")
public class PlatformProjectClient {

    @Autowired
    private PlatformProjectService pps;

    @ApiOperation(value = "根据主键获取一个平台项目的信息", notes = "根据主键获取一个平台项目的信息")
    @RequestMapping(value = "/load/{id}", method = RequestMethod.GET)
    public PlatformProjectModel load(@PathVariable String id){
        return pps.load(id);
    }

    @ApiOperation(value = "科研平台项目保存", notes = "科研平台项目保存")
    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public PlatformProjectModel save(@RequestBody PlatformProjectModel platformProjectModel){

        return pps.save(platformProjectModel);
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
