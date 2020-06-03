package com.pcitc.web.manage;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.github.pagehelper.PageInfo;
import com.pcitc.base.achieve.AchieveBase;
import com.pcitc.base.common.Constant;
import com.pcitc.base.common.Result;
import com.pcitc.base.groupinformation.BlocScientificPlan;
import com.pcitc.base.manage.ManageMethod;
import com.pcitc.base.workflow.Constants;
import com.pcitc.service.achieve.AchieveBaseService;
import com.pcitc.service.manage.ManageMethodService;
import com.pcitc.web.groupinformation.BlocScientificPlanClient;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

/**
 * <p>管理办法</p>
 * @author ty
 */

@Api(value = "achieve-api", description = "管理办法接口")
@RestController
@RequestMapping(value = "/manageMethod-api")
public class ManageMethodClient {

    private final static Logger logger = LoggerFactory.getLogger(ManageMethodClient.class);
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

    @ApiOperation(value = "查询管理办法列表", notes = "查询管理办法列表")
    @RequestMapping(value = "/queryNoPage", method = RequestMethod.POST)
    public JSONArray queryNoPage(@RequestBody(required = false) Map param) {
        List list = mms.queryNoPage(param);
        JSONArray json = JSONArray.parseArray(JSON.toJSONString(list));
        return json;
    }


    @ApiOperation(value = "导入集团发布信息_管理办法", notes = "导入集团发布信息_管理办法")
    @RequestMapping(value = "/excel_input", method = RequestMethod.POST)
    public Result excel_input(@RequestBody List<ManageMethod> list) throws Exception
    {
        Result result=new Result();
        try {
            mms.insertBatch(list);
            result.setSuccess(true);
        } catch (Exception e) {
            result.setSuccess(false);
            result.setMessage("导入科技规划失败");
            logger.error("导入专家信息失败", e);
        }
        return result;
    }


}
