package com.pcitc.web.researchplatform;

import com.github.pagehelper.PageInfo;
import com.pcitc.base.common.LayuiTableParam;
import com.pcitc.base.researchPlatform.PlatformInfoModel;
import com.pcitc.service.researchplatform.PlatformService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

/**
 * <p>服务接口</p>
 * <p>科研平台-基本信息</p>
 * @author ty
 */

@Api(value = "researchPlatform-api", description = "国家科研平台接口")
@RestController
@RequestMapping(value = "/researchPlatform-api")
public class PlatformClient {

    @Autowired
    private PlatformService ps;

    @ApiOperation(value = "根据主键获取一个平台的信息", notes = "根据主键获取一个平台的信息")
    @RequestMapping(value = "/load/{id}", method = RequestMethod.GET)
    public PlatformInfoModel load(@PathVariable String id){
        return ps.load(id);
    }

    @ApiOperation(value = "科研平台信息保存", notes = "科研平台信息保存")
    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public PlatformInfoModel save(@RequestBody PlatformInfoModel platformInfoModel){

        return ps.save(platformInfoModel);
    }

    /*@ApiOperation(value = "初始化一个科研平台对象", notes = "初始化一个科研平台对象")
    @RequestMapping(value = "/new", method = RequestMethod.POST)
    public PlatformInfoModel New(){

        return  null;
    }*/

    @ApiOperation(value = "查询科研平台列表", notes = "查询科研平台列表")
    @RequestMapping(value = "/query", method = RequestMethod.POST)
    public PageInfo query(@RequestBody(required = false) Map param){
        return ps.query(param);
    }


    @ApiOperation(value = "科研平台删除", notes = "科研平台删除")
    @RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE)
    public Integer delete(@PathVariable String id){
        return ps.delete(id);
    }
}
