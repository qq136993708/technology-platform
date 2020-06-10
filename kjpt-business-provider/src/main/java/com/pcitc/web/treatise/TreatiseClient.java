package com.pcitc.web.treatise;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.github.pagehelper.PageInfo;
import com.pcitc.base.common.Result;
import com.pcitc.base.treatiseinfo.TreatiseInfo;
import com.pcitc.service.treatise.TreatiseService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;


/**
 * <p>论文</p>
 * @author ty
 */

@Api(value = "achieveMaintain-api", description = "论文")
@RestController
@RequestMapping(value = "/treatise-api")
public class TreatiseClient {

    @Autowired
    private TreatiseService ts;


    @ApiOperation(value = "load论文", notes = "load论文")
    @RequestMapping(value = "/load/{id}", method = RequestMethod.GET)
    public TreatiseInfo load(@PathVariable String id){
        return ts.load(id);
    }

    @ApiOperation(value = "保存", notes = "保存")
    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public void save(@RequestBody TreatiseInfo ti){
        ts.save(ti);
    }


    @ApiOperation(value = "查询列表分页", notes = "查询列表分页")
    @RequestMapping(value = "/query", method = RequestMethod.POST)
    public PageInfo query(@RequestBody(required = false) Map param){
        return ts.query(param);
    }



    @ApiOperation(value = "成果维护删除", notes = "成果维护删除")
    @RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE)
    public Integer delete(@PathVariable String id){
        return ts.delete(id);
    }


    @ApiOperation(value = "查询列表", notes = "查询列表")
    @RequestMapping(value = "/queryNoPage", method = RequestMethod.POST)
    public JSONArray queryNoPage(@RequestBody(required = false) Map param){
        List list=ts.queryNoPage(param);
        JSONArray json = JSONArray.parseArray(JSON.toJSONString(list));
        return json;
    }

    @ApiOperation(value = "导入论文信息", notes = "导入论文信息")
    @RequestMapping(value = "/excel_input", method = RequestMethod.POST)
    public Result excel_input(@RequestBody List<TreatiseInfo> list) throws Exception
    {
        Result result=new Result();
        try {
            ts.insertBatch(list);
            result.setSuccess(true);
        } catch (Exception e) {
            result.setSuccess(false);
            result.setMessage("导入科技规划失败");

        }
        return result;
    }


}
