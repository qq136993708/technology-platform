package com.pcitc.web.standardmaintain;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.github.pagehelper.PageInfo;
import com.pcitc.base.standardmaintain.StandardMaintain;
import com.pcitc.service.standardmaintain.StandardMaintainService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

/**
 * <p>标准维护</p>
 * @author ty
 */

@Api(value = "standardMaintain-api", description = "标准维护")
@RestController
@RequestMapping(value = "/standardMaintain-api")
public class StandardMaintainClient {
    @Autowired
    private StandardMaintainService service;
    @ApiOperation(value = "load", notes = "load")
    @RequestMapping(value = "/load/{id}", method = RequestMethod.GET)
    public StandardMaintain load(@PathVariable String id){
        return service.load(id);
    }

    @ApiOperation(value = "保存", notes = "保存")
    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public void save(@RequestBody StandardMaintain sm){
        service.save(sm);
    }


    @ApiOperation(value = "查询分页", notes = "查询分页")
    @RequestMapping(value = "/query", method = RequestMethod.POST)
    public PageInfo query(@RequestBody(required = false) Map param){
        return service.query(param);
    }



    @ApiOperation(value = "删除", notes = "删除")
    @RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE)
    public Integer delete(@PathVariable String id){
         return service.delete(id);
    }


    @ApiOperation(value = "查询列表", notes = "查询列表")
    @RequestMapping(value = "/queryNoPage", method = RequestMethod.POST)
    public JSONArray queryNoPage(@RequestBody(required = false) Map param){
        List list=service.queryNoPage(param);
        JSONArray json = JSONArray.parseArray(JSON.toJSONString(list));
        return json;
    }


}
