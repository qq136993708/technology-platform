package com.pcitc.web.feign;

import com.alibaba.fastjson.JSONArray;
import com.pcitc.base.common.LayuiTableData;
import com.pcitc.base.common.LayuiTableParam;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @author:Administrator
 * @date:2019/1/16
 */
@FeignClient(value = "pcitc-hana-provider")
public interface HomeProviderClient {

    @ApiOperation(value = "大型分析仪器、中型实验装置、专业软件（外购）、勘探前沿装备", notes = "大型分析仪器、中型实验装置、专业软件（外购）、勘探前沿装备")
    @RequestMapping(value = "/hana/home/get_home_KYZB_02", method = RequestMethod.POST)
    public JSONArray get_home_KYZB_02(@ApiParam(value="月份:month如201812,公司代码:companyCode",required=true)@RequestBody String paramsJson) throws Exception;
}
