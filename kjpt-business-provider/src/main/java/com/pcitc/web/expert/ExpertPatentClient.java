package com.pcitc.web.expert;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.github.pagehelper.PageInfo;
import com.pcitc.base.common.Result;
import com.pcitc.base.expert.ZjkPatent;
import com.pcitc.base.researchplatform.PlatformProjectModel;
import com.pcitc.service.expert.ExpertPatentService;
import com.pcitc.service.expert.ExpertProjectService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

/**
 * <p>服务接口</p>
 * <p>专家信息管理项目接口</p>
 * @author ty
 */

@Api(value = "expertPorject-api", description = "专家信息管理项目接口")
@RestController
@RequestMapping(value = "/expertPatent-api")
public class ExpertPatentClient {

    @Autowired
    private ExpertPatentService eps;

    @ApiOperation(value = "根据主键获取一个平台项目的信息", notes = "根据主键获取一个平台项目的信息")
    @RequestMapping(value = "/load/{id}", method = RequestMethod.GET)
    public PlatformProjectModel load(@PathVariable String id){
        //return pps.load(id);
        return null;
    }

    @ApiOperation(value = "科研平台项目保存", notes = "科研平台项目保存")
    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public PlatformProjectModel save(@RequestBody PlatformProjectModel platformProjectModel){
        //return pps.save(platformProjectModel);
        return null;
    }

    @ApiOperation(value = "平台项目批量保存", notes = "平台项目批量保存")
    @RequestMapping(value = "/batchSave", method = RequestMethod.POST)
    public Integer batchSave(@RequestBody List<PlatformProjectModel> list){
        //return pps.batchSave(list);
        return null;
    }

    @ApiOperation(value = "查询科研平台项目列表", notes = "查询科研平台项目列表")
    @RequestMapping(value = "/query", method = RequestMethod.POST)
    public PageInfo query(@RequestBody(required = false) Map param){
        //return pps.query(param);
        return null;
    }

    @ApiOperation(value = "查询专家信息管理项目列表", notes = "查询专家信息管理项目列表")
    @RequestMapping(value = "/queryNoPage", method = RequestMethod.POST)
    public JSONArray queryNoPage(@RequestBody(required = false) Map param){
        List list=eps.queryNoPage(param);
        JSONArray json = JSONArray.parseArray(JSON.toJSONString(list));
        return json;
    }


    @ApiOperation(value = "科研平台项目删除", notes = "科研平台项目删除")
    @RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE)
    public Integer delete(@PathVariable String id){
        //return pps.delete(id);
        return null;
    }

    @ApiOperation(value = "导入专家专利信息", notes = "导入专家专利信息")
    @RequestMapping(value = "/excel_input", method = RequestMethod.POST)
    public Result excel_input(@RequestBody List<ZjkPatent> list) throws Exception
    {
        Result result=new Result();
        try {
            eps.insertBatch(list);
            result.setSuccess(true);
        } catch (Exception e) {
            result.setSuccess(false);
            result.setMessage("导入专家专利失败!");

        }
        return result;
    }
}
