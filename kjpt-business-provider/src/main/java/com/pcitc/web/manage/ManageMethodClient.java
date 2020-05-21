package com.pcitc.web.manage;

import com.github.pagehelper.PageInfo;
import com.pcitc.base.achieve.AchieveBase;
import com.pcitc.base.common.Constant;
import com.pcitc.base.common.Result;
import com.pcitc.base.manage.ManageMethod;
import com.pcitc.base.workflow.Constants;
import com.pcitc.service.achieve.AchieveBaseService;
import com.pcitc.service.manage.ManageMethodService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

/**
 * <p>管理办法</p>
 * @author ty
 */

@Api(value = "achieve-api", description = "管理办法接口")
@RestController
@RequestMapping(value = "/manageMethod-api")
public class ManageMethodClient {
    @Autowired
    private ManageMethodService mms;
    @ApiOperation(value = "load管理办法", notes = "load管理办法")
    @RequestMapping(value = "/load/{id}", method = RequestMethod.GET)
    public ManageMethod load(@PathVariable String id){
        return mms.load(id);
    }

    @ApiOperation(value = "管理办法保存", notes = "管理办法保存")
    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public void save(@RequestBody ManageMethod manageMethod){
		mms.save(manageMethod);
    }


    @ApiOperation(value = "查询管理办法列表分页", notes = "查询管理办法列表分页")
    @RequestMapping(value = "/query", method = RequestMethod.POST)
    public PageInfo query(@RequestBody(required = false) Map param){
        return mms.query(param);
    }



    @ApiOperation(value = "管理办法删除", notes = "管理办法删除")
    @RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE)
    public Integer delete(@PathVariable String id){
         return mms.delete(id);
    }

}
