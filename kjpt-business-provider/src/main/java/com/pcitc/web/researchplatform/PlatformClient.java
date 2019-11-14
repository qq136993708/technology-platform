package com.pcitc.web.researchplatform;

import com.pcitc.base.common.LayuiTableParam;
import com.pcitc.base.researchPlatform.PlatformInfoModel;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * <p>服务接口</p>
 * <p>Table: zjk_achievement - 科研平台-基本信息</p>
 * @author ty
 */

@Api(value = "researchPlatform-api", description = "国家科研平台接口")
@RestController
@RequestMapping("researchPlatform-api")
public class PlatformClient {

    @ApiOperation(value = "根据主键获取一个平台的信息", notes = "根据主键获取一个平台的信息")
    @RequestMapping(value = "/load/{id}", method = RequestMethod.GET)
    public PlatformInfoModel load(@PathVariable String id){
        return null;
    }

    @ApiOperation(value = "科研平台信息保存", notes = "科研平台信息保存")
    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public PlatformInfoModel save(@RequestBody PlatformInfoModel platformInfoModel){

        return null;
    }

    /*@ApiOperation(value = "初始化一个科研平台对象", notes = "初始化一个科研平台对象")
    @RequestMapping(value = "/new", method = RequestMethod.POST)
    public PlatformInfoModel New(){

        return  null;
    }*/

    @ApiOperation(value = "查询科研平台列表", notes = "查询科研平台列表")
    @RequestMapping(value = "/query", method = RequestMethod.GET)
    public List<PlatformInfoModel> query(LayuiTableParam param){
        return null;
    }

    public void delete(){
    }
}
