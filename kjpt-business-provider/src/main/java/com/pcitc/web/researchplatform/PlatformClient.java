package com.pcitc.web.researchplatform;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.github.pagehelper.PageInfo;
import com.pcitc.base.patent.KgjImportModel;
import com.pcitc.base.researchplatform.PlatformInfoModel;
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

    @ApiOperation(value = "查询科研平台列表分页", notes = "查询科研平台列表分页")
    @RequestMapping(value = "/query", method = RequestMethod.POST)
    public PageInfo query(@RequestBody(required = false) Map param){
        return ps.query(param);
    }

    @ApiOperation(value = "查询科研平台列表", notes = "查询科研平台列表")
    @RequestMapping(value = "/queryNoPage", method = RequestMethod.POST)
    public JSONArray queryNoPage(@RequestBody(required = false) Map param){
        List list=ps.queryNoPage(param);
        JSONArray json = JSONArray.parseArray(JSON.toJSONString(list));
        return json;
    }
    
    @ApiOperation(value = "查询科研平台列表", notes = "查询科研平台列表")
    @RequestMapping(value = "/queryPlatformListApi", method = RequestMethod.POST)
    public JSONArray queryPlatformListApi(@RequestBody(required = false) Map param){
        List list=ps.queryPlatformListApi(param);
        JSONArray json = JSONArray.parseArray(JSON.toJSONString(list));
        return json;
    }
    
    
    


    @ApiOperation(value = "科研平台删除", notes = "科研平台删除")
    @RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE)
    public Integer delete(@PathVariable String id){
        return ps.delete(id);
    }


    @ApiOperation(value = "科研平台项目条数", notes = "科研平台项目条数")
    @RequestMapping(value = "/selectPaltinfoCount", method = RequestMethod.POST)
    public List<Map> selectPaltinfoCount(@RequestBody Map param){
        return ps.selectPaltinfoCount(param);
    }


    @RequestMapping(value="/excelImport/{currrentUser}",method =RequestMethod.POST)
    public String excelImport(@PathVariable(value="currrentUser") String currrentUser, @RequestBody List<List<String>> dataList){
        //return ks.kgjImport(dataList,currrentUser);
        return null;
    }

    @ApiOperation(value = "科技材料统计表", notes = "科技材料统计表")
    @RequestMapping(value="/scienceStatistics",method =RequestMethod.POST)
    public PageInfo excelImport( @RequestBody Map param){
        return ps.scienceStatistics(param);
    }


    @ApiOperation(value = "科技材料统计表不分页", notes = "科技材料统计表不分页")
    @RequestMapping(value = "/scienceStatisticsNoPage", method = RequestMethod.POST)
    public JSONArray scienceStatisticsNoPage(@RequestBody(required = false) Map param){
        List list=ps.scienceStatisticsNoPage(param);
        JSONArray json = JSONArray.parseArray(JSON.toJSONString(list));
        return json;
    }

}
