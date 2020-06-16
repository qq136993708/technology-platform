package com.pcitc.web.controller.standardmaintain;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.pcitc.base.standardmaintain.StandardMaintainBI;
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
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/***
 * @Author xiaoh
 * @Description 质量标准-领导驾驶舱
 * @Date 2020/6/8 17:50
 * @param
 * @return
 **/
@Api(value = "standardMaintainBI-api", description = "质量标准领导驾驶舱接口")
@RestController
public class StandardMaintainBIController extends RestBaseController {

    /**
     * 国内标准在研数
     */
    private static final String getInternalResearchList = "http://kjpt-zuul/stp-proxy/standardMaintainBI-api/getInternalResearchList";
    /**
     * 国内累计发布数
     */
    private static final String getInternalPublishList = "http://kjpt-zuul/stp-proxy/standardMaintainBI-api/getInternalPublishList";

    /**
     * 国际标准在研、累计发布数
     */
    private static final String getInternationalAllList = "http://kjpt-zuul/stp-proxy/standardMaintainBI-api/getInternationalAllList";

    @ApiOperation(value="国内标准在研数")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "year", value = "年份", dataType = "String", paramType = "query")
    })
    @RequestMapping(value = "/standardMaintainBI-api/getInternalResearchList", method = RequestMethod.GET)
    public List<StandardMaintainBI> getAwardSumByQuery(
            @RequestParam(required = false,value = "year") String year
    ) {
        Map<String, Object> condition = new HashMap<>(2);
        if (!StringUtils.isEmpty(year)) {
            this.setParam(condition, "year", year);
        }
        this.setBaseParam(condition);
        this.httpHeaders.setContentType(MediaType.APPLICATION_JSON);
        ResponseEntity<JSONArray> responseEntity = this.restTemplate.exchange(getInternalResearchList, HttpMethod.POST, new HttpEntity<Map>(condition, this.httpHeaders), JSONArray.class);
        List list = JSONObject.parseArray(responseEntity.getBody().toJSONString(), StandardMaintainBI.class);
        return list;
    }


    @ApiOperation(value="国内累计发布数")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "year", value = "年份", dataType = "String", paramType = "query")
    })
    @RequestMapping(value = "/standardMaintainBI-api/getInternalPublishList", method = RequestMethod.GET)
    public List<StandardMaintainBI> getAwardSumByTypePie(
            @RequestParam(required = false,value = "year") String year
    ) {
        Map<String, Object> condition = new HashMap<>(2);
        if (!StringUtils.isEmpty(year)) {
            this.setParam(condition, "year", year);
        }
        this.setBaseParam(condition);
        this.httpHeaders.setContentType(MediaType.APPLICATION_JSON);
        ResponseEntity<JSONArray> responseEntity = this.restTemplate.exchange(getInternalPublishList, HttpMethod.POST, new HttpEntity<Map>(condition, this.httpHeaders), JSONArray.class);
        List list = JSONObject.parseArray(responseEntity.getBody().toJSONString(), StandardMaintainBI.class);
        return list;
    }


    @ApiOperation(value = " 国际标准在研、累计发布数", notes = " 国际标准在研、累计发布数")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "year", value = "年份", dataType = "String", paramType = "query")
    })
    @RequestMapping(value = "/standardMaintainBI-api/getInternationalAllList", method = RequestMethod.GET)
    @ResponseBody
    public List<StandardMaintainBI>  getDetailList(
            @RequestParam(required = false,value = "year") String year
    ){

        Map<String, Object> condition = new HashMap<>(6);
        if (!StringUtils.isEmpty(year)) {
            this.setParam(condition, "year", year);
        }
        this.setBaseParam(condition);
        this.httpHeaders.setContentType(MediaType.APPLICATION_JSON);
        //控制数据范围
        /*String childUnitIds= EquipmentUtils.getAllChildsByIUnitPath(sysUserInfo.getDataScopeUnitPath(), restTemplate, httpHeaders);
        this.setParam(condition,"childUnitIds",childUnitIds);*/
        ResponseEntity<JSONArray> responseEntity = this.restTemplate.exchange(getInternationalAllList, HttpMethod.POST, new HttpEntity<Map>(condition, this.httpHeaders), JSONArray.class);
        List list = JSONObject.parseArray(responseEntity.getBody().toJSONString(), StandardMaintainBI.class);
        return list;
    }



}
