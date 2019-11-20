package com.pcitc.web.controller.researchplatform;

import com.github.pagehelper.PageInfo;
import com.pcitc.base.common.Page;
import com.pcitc.base.expert.ZjkBase;
import com.pcitc.base.patent.PatentInfo;
import com.pcitc.base.researchPlatform.PlatformInfoModel;
import com.pcitc.base.util.HttpConnectionUtils;
import com.pcitc.web.common.ApiResponseBody;
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
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

/**
 * <p>服务接口</p>
 * <p>Table:  kypt-info 科研平台-基本信息</p>
 * @author ty
 */
@Api(value = "researchPlatform-api", description = "国家科研平台接口")
@Controller
public class PlatformApiController extends RestBaseController {
    /**
     * 根据ID获取对象信息
     */
    private static final String load = "http://kjpt-zuul/stp-proxy/researchPlatform-api/load/";
    /**
     * 查询平台列表
     */
    private static final String query = "http://kjpt-zuul/stp-proxy/researchPlatform-api/query";
    /**
     * 保存平台
     */
    private static final String save = "http://kjpt-zuul/stp-proxy/researchPlatform-api/save";
    /**
     * 删除
     */
    private static final String delete = "http://kjpt-zuul/stp-proxy/researchPlatform-api/delete/";

    @RequestMapping(value = "/platform-api/view")
    public String view() {
        return "/kjpt/researchplatform/researchplatform_view";
    }

    @RequestMapping(value = "/platform-api/add")
    public String add() {
        return "/kjpt/researchplatform/researchplatform_add";
    }



    @ApiOperation(value="读取")
    @RequestMapping(value = "/platform-api/load/{id}", method = RequestMethod.GET)
    @ResponseBody
    public PlatformInfoModel load(@PathVariable String id) {
        ResponseEntity<PlatformInfoModel> responseEntity = this.restTemplate.exchange(load+id, HttpMethod.GET, new HttpEntity(this.httpHeaders), PlatformInfoModel.class);
        return responseEntity.getBody();
    }


    @ApiOperation(value = "查询科研平台列表", notes = "查询科研平台列表")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "pageNum", value = "页码", dataType = "Integer", paramType = "query"),
            @ApiImplicitParam(name = "pageSize", value = "每页显示条数", dataType = "Integer", paramType = "query"),
            @ApiImplicitParam(name = "platformName", value = "平台名称", dataType = "string", paramType = "query"),
            @ApiImplicitParam(name = "supportingInstitutions", value = "依托单位", dataType = "string", paramType = "query"),
            @ApiImplicitParam(name = "personLiable", value = "主要负责人", dataType = "string", paramType = "query"),
            @ApiImplicitParam(name = "researchField", value = "科研经费", dataType = "string", paramType = "query"),
            @ApiImplicitParam(name = "platformScorinHigh", value = "平台评分区间高", dataType = "string", paramType = "query"),
            @ApiImplicitParam(name = "platformScorinLow", value = "平台评分区间低", dataType = "string", paramType = "query")
    })
    @RequestMapping(value = "/platform-api/query", method = RequestMethod.GET)
    @ResponseBody
    public PageInfo query(
            @RequestParam(required = false,value = "pageNum") Integer pageNum,
            @RequestParam(required = false,value = "pageSize") Integer pageSize,
            @RequestParam(required = false,value = "platformName") String platformName,
            @RequestParam(required = false,value = "supportingInstitutions") String supportingInstitutions,
            @RequestParam(required = false,value = "personLiable") String personLiable,
            @RequestParam(required = false,value = "researchField") String researchField,
            @RequestParam(required = false,value = "platformScorinHigh") String platformScorinHigh,
            @RequestParam(required = false,value = "platformScorinLow") String platformScorinLow

    ) {
        Map<String, Object> condition = new HashMap<>(6);
        if (pageNum == null) {
            this.setParam(condition, "pageNum", 1);
        }else {
            this.setParam(condition, "pageNum", pageNum);
        }
        if (pageSize == null) {
            this.setParam(condition, "pageSize", 10);
        }else {
            this.setParam(condition, "pageSize", pageSize);
        }
        if (!StringUtils.isEmpty(platformName)) {
            this.setParam(condition, "platformName", platformName);
        }
        if (!StringUtils.isEmpty(supportingInstitutions)) {
            this.setParam(condition, "supportingInstitutions", supportingInstitutions);
        }
        if (!StringUtils.isEmpty(personLiable)) {
            this.setParam(condition, "personLiable", personLiable);
        }
        if (!StringUtils.isEmpty(researchField)) {
            this.setParam(condition, "researchField", researchField);
        }
        if (!StringUtils.isEmpty(platformScorinHigh)) {
            this.setParam(condition, "platformScorinHigh", platformScorinHigh);
        }
        if (!StringUtils.isEmpty(platformScorinLow)) {
            this.setParam(condition, "platformScorinLow", platformScorinLow);
        }
        this.httpHeaders.setContentType(MediaType.APPLICATION_JSON);
        ResponseEntity<PageInfo> responseEntity = this.restTemplate.exchange(query, HttpMethod.POST, new HttpEntity<Map>(condition, this.httpHeaders), PageInfo.class);
        return responseEntity.getBody();
    }

    @ApiOperation(value="保存")
    @RequestMapping(value = "/platform-api/save", method = RequestMethod.POST)
    @ResponseBody
    public PlatformInfoModel save(@RequestBody PlatformInfoModel pm) {
        this.httpHeaders.setContentType(MediaType.APPLICATION_JSON);
        ResponseEntity<PlatformInfoModel> responseEntity = this.restTemplate.exchange(save, HttpMethod.POST, new HttpEntity<PlatformInfoModel>(pm, this.httpHeaders), PlatformInfoModel.class);
        return responseEntity.getBody();
    }

    @ApiOperation(value="删除")
    @RequestMapping(value = "/platform-api/delete/{id}", method = RequestMethod.DELETE)
    @ResponseBody
    public Integer delete(@PathVariable String id) {
        ResponseEntity<Integer> responseEntity = this.restTemplate.exchange(delete+id, HttpMethod.DELETE, new HttpEntity(this.httpHeaders), Integer.class);
        return responseEntity.getBody();
    }

    @ApiOperation(value="初始化")
    @RequestMapping(value = "/platform-api/newInit", method = RequestMethod.GET)
    @ResponseBody
    public PlatformInfoModel newInit() {
        PlatformInfoModel p = new PlatformInfoModel();
        p.setId(UUID.randomUUID().toString().replace("-",""));
        p.setCreateDate(new Date());
        p.setCreator(this.getUserProfile().getUserName());
        p.setPlatformScoring("0");
        p.setResearchFunds("0");
        p.setDeleted("0");
        return p;
    }

}
