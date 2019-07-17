package com.pcitc.web.feign;

import com.pcitc.base.common.LayuiTableData;
import com.pcitc.base.common.LayuiTableParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @author:Administrator
 * @date:2019/1/16
 */
@FeignClient(value = "pcitc-stp-provider")
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
}

