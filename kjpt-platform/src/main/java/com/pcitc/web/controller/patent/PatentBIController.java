package com.pcitc.web.controller.patent;


import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.pcitc.base.indexHome.calResult;
import com.pcitc.web.common.RestBaseController;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.apache.commons.lang3.StringUtils;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Api(value = "知识产权领导驾驶舱接口", description = "知识产权领导驾驶舱接口")
@RestController
public class PatentBIController extends RestBaseController {

    private static final String getPatentCountByYear = "http://kjpt-zuul/stp-proxy/patentBI/getPatentCountByYear";

    private static final String getPatentCountByLegelStatus = "http://kjpt-zuul/stp-proxy/patentBI/getPatentCountByLegelStatus";

    private static final String getPatentCountByOffice = "http://kjpt-zuul/stp-proxy/patentBI/getPatentCountByOffice";

    @ApiOperation(value="历年申请/授权专利数量统计")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "year", value = "年份", dataType = "String", paramType = "query")
    })
    @RequestMapping(value = "/patentBI/getPatentCountByYear", method = RequestMethod.GET)
    public List<calResult> getPatentCountByYear(
            @RequestParam(required = false,value = "year") String year
    ) {
        return getCalResults(year, getPatentCountByYear);
    }

    @ApiOperation(value="法律状态")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "year", value = "年份", dataType = "String", paramType = "query")
    })
    @RequestMapping(value = "/patentBI/getPatentCountByLegelStatus", method = RequestMethod.GET)
    public List<calResult> getPatentCountByLegelStatus(
            @RequestParam(required = false,value = "year") String year
    ) {
        return getCalResults(year, getPatentCountByLegelStatus);
    }

    @ApiOperation(value="二级单位专利数量统计")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "year", value = "年份", dataType = "String", paramType = "query")
    })
    @RequestMapping(value = "/patentBI/getPatentCountByOffice", method = RequestMethod.GET)
    public List<calResult> getPatentCountByOffice(
            @RequestParam(required = false,value = "year") String year
    ) {
        return getCalResults(year, getPatentCountByOffice);
    }

    private List<calResult> getCalResults(@RequestParam(required = false, value = "year") String year, String remoteURL) {
        Map<String, Object> condition = new HashMap<>(2);
        if (!StringUtils.isEmpty(year)) {
            this.setParam(condition, "year", year);
        }
        this.setBaseParam(condition);
        this.httpHeaders.setContentType(MediaType.APPLICATION_JSON);
        ResponseEntity<JSONArray> responseEntity = this.restTemplate.exchange(remoteURL, HttpMethod.POST, new HttpEntity<Map>(condition, this.httpHeaders), JSONArray.class);
        List<calResult> list = JSONObject.parseArray(responseEntity.getBody().toJSONString(), calResult.class);
        return list;
    }

}
