package com.pcitc.web.feign;

import com.alibaba.fastjson.JSONObject;
import com.pcitc.base.common.LayuiTableData;
import com.pcitc.base.common.LayuiTableParam;
import com.pcitc.base.expert.ZjkChoiceExample;
import io.swagger.annotations.ApiOperation;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @author:Administrator
 * @date:2019/1/16
 */
@FeignClient(value = "kjpt-business-provider")
public interface ZjkBaseInfoServiceClient {

    @ApiOperation(value = "查询专家-基本信息信息-分页查询", notes = "查询专家-基本信息信息-分页查询,Object")
    @RequestMapping(value = "/zjkbaseinfo-provider/zjkbaseinfo/zjkbaseinfo-page")
    public LayuiTableData selectZjkBaseInfoByPage(@RequestBody LayuiTableParam param);

    @ApiOperation(value = "查询专家-专利信息信息-分页查询", notes = "查询专家-专利信息信息-分页查询,Object")
    @RequestMapping(value = "/zjkzhuanli-provider/zjkzhuanli/zjkzhuanli-page")
    public LayuiTableData selectZjkZhuanliByPage(@RequestBody LayuiTableParam param);

    /**
     * 课题列表
     * @param paramsJson
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "/sre-provider/project_basic/page_search", method = RequestMethod.POST)
    public LayuiTableData getSreProjectBasicListSearch(@RequestBody LayuiTableParam paramsJson)throws Exception;

    /**
     * 专家信息
     * @param param
     * @return
     */
    @RequestMapping(value = "/zjkbaseinfo-provider/zjkbaseinfo/zjkbaseinfo-page-count")
    public LayuiTableData selectZjkBaseInfoByPageCount(@RequestBody LayuiTableParam param);

    //专家信息统计
    @RequestMapping(value = "/zjkbaseinfo-provider/zjkbaseinfo/zjkbaseinfo-page-count-job")
    public LayuiTableData selectZjkBaseInfoByPageCountJob();

    //查询被选中专家数据
    @RequestMapping(value = "/zjkchoice-provider/zjkchoice/selectByExample", method = RequestMethod.POST)
    public JSONObject selectByExample(@RequestBody JSONObject jsonObject);

    //查询被选中项目列表
    @RequestMapping(value = "/zjkchoice-provider/zjkchoice/selectZjkChoiceByExampleByType", method = RequestMethod.POST)
    public JSONObject selectZjkChoiceByExampleByType(@RequestBody JSONObject jsonObject);


}
