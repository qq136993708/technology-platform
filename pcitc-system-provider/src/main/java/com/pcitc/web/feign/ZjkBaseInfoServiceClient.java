package com.pcitc.web.feign;

import com.pcitc.base.common.LayuiTableParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author:Administrator
 * @date:2019/1/16
 */
@FeignClient(value = "pcitc-stp-provider")
public interface ZjkBaseInfoServiceClient {

    @ApiOperation(value = "查询专家-基本信息信息-分页查询", notes = "查询专家-基本信息信息-分页查询,Object")
    @RequestMapping(value = "/zjkbaseinfo-provider/zjkbaseinfo/zjkbaseinfo-page")
    public Object selectZjkBaseInfoByPage(@RequestBody LayuiTableParam param);
}
