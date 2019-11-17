package com.pcitc.web.controller.researchplatform;

import com.github.pagehelper.PageInfo;
import com.pcitc.base.common.Page;
import com.pcitc.base.researchPlatform.PlatformInfoModel;
import com.pcitc.base.util.HttpConnectionUtils;
import com.pcitc.web.common.ApiResponseBody;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.commons.lang3.StringUtils;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

/**
 * <p>服务接口</p>
 * <p>Table: zjk_achievement - 科研平台-基本信息</p>
 * @author ty
 */
@Api(value = "researchPlatform-api", description = "国家科研平台接口")
@RestController
@RequestMapping("/platform-api")
public class PlatformApiController extends ApiResponseBody {
    /**
     * 根据ID获取对象信息
     */
    private static final String load = "http://kjpt-zuul/stp-proxy/researchPlatform-api/load/";
    /**
     * 查询平台列表
     */
   // private static final String query = "http://kjpt-zuul/stp-proxy/expert/page";
    private static final String query = "http://kjpt-zuul/stp-proxy/researchPlatform-api/query";
   // private static final String query = "http://localhost:8765/researchPlatform-api/query";


    @ApiOperation(value="读取一个平台信息")
    @RequestMapping(value = "/load/{id}", method = RequestMethod.GET)
    @ResponseBody
    public Object loadOne(@PathVariable String id) {
        return HttpConnectionUtils.get(load+id,PlatformInfoModel.class);
    }


    @ApiOperation(value = "查询科研平台列表", notes = "查询科研平台列表")
    @RequestMapping(value = "/query", method = RequestMethod.GET)
    @ResponseBody
    public PageInfo getList(
                          @RequestParam(required = false,value = "页码") Integer pageNum,
                          @RequestParam(required = false) Integer pageSize,
                          @RequestParam(required = false) String platformName,
                          @RequestParam(required = false) String supportingInstitutions,
                          @RequestParam(required = false) String personLiable,
                          @RequestParam(required = false) String researchField,
                          @RequestParam(required = false) String platformScorinHigh,
                          @RequestParam(required = false) String platformScorinLow

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
        return (PageInfo)HttpConnectionUtils.post(condition,query, MediaType.APPLICATION_JSON, PageInfo.class);

    }

}
