package com.pcitc.web.controller.researchplatform;

import com.github.pagehelper.PageInfo;
import com.pcitc.base.researchplatform.PlatformProjectModel;
import com.pcitc.web.common.RestBaseController;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;

/**
 * <p>服务接口</p>
 * <p>Table:  - 科研平台-项目信息</p>
 * @author ty
 */

@Api(value = "researchPlatformProject-api", description = "国家科研平台项目接口")
@RestController
public class PlatformProjectController extends RestBaseController {

    /**
     * 根据ID获取对象信息
     */
    private static final String load = "http://kjpt-zuul/stp-proxy/researchPlatformPorject-api/load/";
    /**
     * 查询平台项目列表
     */
    private static final String query = "http://kjpt-zuul/stp-proxy/researchPlatformPorject-api/query";
    /**
     * 保存平台项目
     */
    private static final String save = "http://kjpt-zuul/stp-proxy/researchPlatformPorject-api/save";
    /**
     * 平台项目批量保存
     */
    private static final String batchSave = "http://kjpt-zuul/stp-proxy/researchPlatformPorject-api/batchSave";
    /**
     * 删除项目
     */
    private static final String delete = "http://kjpt-zuul/stp-proxy/researchPlatformPorject-api/delete/";

    @ApiOperation(value="读取")
    @RequestMapping(value = "/platformProject-api/load/{id}", method = RequestMethod.GET)
    @ResponseBody
    public PlatformProjectModel load(@PathVariable String id) {
        ResponseEntity<PlatformProjectModel> responseEntity = this.restTemplate.exchange(load+id, HttpMethod.GET, new HttpEntity(this.httpHeaders), PlatformProjectModel.class);
        return responseEntity.getBody();
    }


    @ApiOperation(value = "查询科研平台项目列表", notes = "查询科研平台项目列表")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "pageNum", value = "页码", dataType = "Integer", paramType = "query"),
            @ApiImplicitParam(name = "pageSize", value = "每页显示条数", dataType = "Integer", paramType = "query"),
            @ApiImplicitParam(name = "platformId", value = "平台ID", dataType = "string", paramType = "query")
    })
    @RequestMapping(value = "/platformProject-api/query", method = RequestMethod.GET)
    @ResponseBody
    public PageInfo query(
            @RequestParam(required = false,value = "pageNum") Integer pageNum,
            @RequestParam(required = false,value = "pageSize") Integer pageSize,
            @RequestParam(value = "platformId") String platformId

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
        this.setParam(condition,"platformId",platformId);
        this.httpHeaders.setContentType(MediaType.APPLICATION_JSON);
        ResponseEntity<PageInfo> responseEntity = this.restTemplate.exchange(query, HttpMethod.POST, new HttpEntity<Map>(condition, this.httpHeaders), PageInfo.class);
        return responseEntity.getBody();
    }

    @ApiOperation(value="保存")
    @RequestMapping(value = "/platformProject-api/save", method = RequestMethod.POST)
    @ResponseBody
    public PlatformProjectModel save(@RequestBody PlatformProjectModel pm) {
        this.httpHeaders.setContentType(MediaType.APPLICATION_JSON);
        this.setBaseData(pm);
        ResponseEntity<PlatformProjectModel> responseEntity = this.restTemplate.exchange(save, HttpMethod.POST, new HttpEntity<PlatformProjectModel>(pm, this.httpHeaders), PlatformProjectModel.class);
        return responseEntity.getBody();
    }

    @ApiOperation(value="删除")
    @RequestMapping(value = "/platformProject-api/delete/{id}", method = RequestMethod.DELETE)
    @ResponseBody
    public Integer delete(@PathVariable String id) {
        ResponseEntity<Integer> responseEntity = this.restTemplate.exchange(delete+id, HttpMethod.DELETE, new HttpEntity(this.httpHeaders), Integer.class);
        return responseEntity.getBody();
    }

    @ApiOperation(value="初始化")
    @RequestMapping(value = "/platformProject-api/newInit/{platformId}", method = RequestMethod.GET)
    @ResponseBody
    public PlatformProjectModel newInit(@PathVariable String platformId) {
        PlatformProjectModel p = new PlatformProjectModel();
        p.setId(UUID.randomUUID().toString().replace("-",""));
        p.setPlatformId(platformId);
        p.setCreateDate(new Date());
        p.setCreator(this.getUserProfile().getUserName());
        p.setDeleted("0");
        return p;
    }

    @ApiOperation(value="批量添加")
    @RequestMapping(value = "/platformProject-api/batchSave", method = RequestMethod.POST)
    @ResponseBody
    public Integer batchSave(@RequestBody List<PlatformProjectModel> pmList) {
        this.httpHeaders.setContentType(MediaType.APPLICATION_JSON);
        ResponseEntity<Integer> responseEntity = this.restTemplate.exchange(batchSave, HttpMethod.POST, new HttpEntity<List>(pmList, this.httpHeaders), Integer.class);
        return responseEntity.getBody();
    }

}