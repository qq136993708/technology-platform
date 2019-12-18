package com.pcitc.web.controller.researchplatform;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.github.pagehelper.PageInfo;
import com.pcitc.base.researchplatform.PlatformLeaderModel;
import com.pcitc.base.researchplatform.PlatformMemberModel;
import com.pcitc.base.system.SysUser;
import com.pcitc.web.common.RestBaseController;
import com.pcitc.web.utils.EquipmentUtils;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.apache.commons.lang.time.DateFormatUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;

/**
 * <p>服务接口</p>
 * <p>Table:  - 科研平台-领军人物</p>
 * @author ty
 */

@Api(value = "researchPlatformLeader-api", description = "国家科研平台领军人物接口")
@RestController
public class PlatformLeaderController extends RestBaseController {

    /**
     * 根据ID获取对象信息
     */
    private static final String load = "http://kjpt-zuul/stp-proxy/researchPlatformLeader-api/load/";
    /**
     * 查询平台领军人物列表
     */
    private static final String query = "http://kjpt-zuul/stp-proxy/researchPlatformLeader-api/query";
    /**
     * 保存平台领军人员
     */
    private static final String save = "http://kjpt-zuul/stp-proxy/researchPlatformLeader-api/save";
    /**
     * 平台领军人员批量保存
     */
    private static final String batchSave = "http://kjpt-zuul/stp-proxy/researchPlatformLeader-api/batchSave";
    /**
     * 删除领军人员
     */
    private static final String delete = "http://kjpt-zuul/stp-proxy/researchPlatformLeader-api/delete/";

    /**
     * 查询平台领军人物不分页
     */
    private static final String queryNopage = "http://kjpt-zuul/stp-proxy/researchPlatformLeader-api/queryNoPage";

    @ApiOperation(value="读取")
    @RequestMapping(value = "/researchPlatformLeader-api/load/{id}", method = RequestMethod.GET)
    @ResponseBody
    public PlatformLeaderModel load(@PathVariable String id) {
        ResponseEntity<PlatformLeaderModel> responseEntity = this.restTemplate.exchange(load+id, HttpMethod.GET, new HttpEntity(this.httpHeaders), PlatformLeaderModel.class);
        return responseEntity.getBody();
    }

    @ApiOperation(value="导出excel")
    @RequestMapping(value = "/researchPlatformLeader-api/export", method = RequestMethod.GET)
    @ResponseBody
    public void export(
            @RequestParam(value = "platformId") String platformId
    ) throws Exception {
        Map<String, Object> condition = new HashMap<>(2);
        if (!StringUtils.isEmpty(platformId)) {
            this.setParam(condition, "platformId", platformId);
        }
        String[] headers = { "姓名",  "担任职务",    "工作单位"  , "专业"};
        String[] cols =    {"name","post","workUnit","major"};
        SysUser sysUserInfo = this.getUserProfile();
        this.setParam(condition,"userSecretLevel",sysUserInfo.getSecretLevel());
        //默认查询当前人所在机构下所有的科研平台
        String childUnitIds= EquipmentUtils.getAllChildsByIUnitPath(sysUserInfo.getUnitPath(), restTemplate, httpHeaders);
        this.setParam(condition,"childUnitIds",childUnitIds);
        this.httpHeaders.setContentType(MediaType.APPLICATION_JSON);
        ResponseEntity<JSONArray> responseEntity = this.restTemplate.exchange(queryNopage, HttpMethod.POST, new HttpEntity<Map>(condition, this.httpHeaders), JSONArray.class);
        List list = JSONObject.parseArray(responseEntity.getBody().toJSONString(), PlatformLeaderModel.class);
        String fileName = "科研平台领军人物表_"+ DateFormatUtils.format(new Date(), "ddhhmmss");
        this.exportExcel(headers,cols,fileName,list);
    }


    @ApiOperation(value = "查询科研平台成员列表", notes = "查询科研平台成员列表")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "pageNum", value = "页码", dataType = "Integer", paramType = "query"),
            @ApiImplicitParam(name = "pageSize", value = "每页显示条数", dataType = "Integer", paramType = "query"),
            @ApiImplicitParam(name = "platformId", value = "平台ID", dataType = "string", paramType = "query"),
            @ApiImplicitParam(name = "baseIds", value = "人员ID数组", dataType = "string", paramType = "query"),
            @ApiImplicitParam(name = "secretLevel", value = "密级", dataType = "string", paramType = "query")


    })
    @RequestMapping(value = "/researchPlatformLeader-api/query", method = RequestMethod.GET)
    @ResponseBody
    public PageInfo query(
            @RequestParam(required = false,value = "pageNum") Integer pageNum,
            @RequestParam(required = false,value = "pageSize") Integer pageSize,
            @RequestParam(value = "platformId") String platformId,
            @RequestParam(required = false,value = "baseIds") String baseIds,
            @RequestParam(required = false,value = "secretLevel") String secretLevel


    ) throws Exception {
        SysUser sysUserInfo = this.getUserProfile();
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
        if (!StringUtils.isEmpty(baseIds)) {
            this.setParam(condition, "baseIds", baseIds.split(","));
        }

        if (secretLevel != null) {
            this.setParam(condition, "secretLevel", secretLevel);
        }
        this.setParam(condition,"userSecretLevel",sysUserInfo.getSecretLevel());



        //默认查询当前人所在机构下所有的科研平台领军人物
        String childUnitIds= EquipmentUtils.getAllChildsByIUnitPath(sysUserInfo.getUnitPath(), restTemplate, httpHeaders);
        this.setParam(condition,"childUnitIds",childUnitIds);

        this.httpHeaders.setContentType(MediaType.APPLICATION_JSON);
        ResponseEntity<PageInfo> responseEntity = this.restTemplate.exchange(query, HttpMethod.POST, new HttpEntity<Map>(condition, this.httpHeaders), PageInfo.class);
        return responseEntity.getBody();
    }

    @ApiOperation(value="保存")
    @RequestMapping(value = "/researchPlatformLeader-api/save", method = RequestMethod.POST)
    @ResponseBody
    public PlatformLeaderModel save(@RequestBody PlatformLeaderModel pam) {
        this.setBaseData(pam);
        this.httpHeaders.setContentType(MediaType.APPLICATION_JSON);
        this.restTemplate.exchange(save, HttpMethod.POST, new HttpEntity<PlatformLeaderModel>(pam, this.httpHeaders), PlatformLeaderModel.class);
        return pam;
    }

    @ApiOperation(value="删除")
    @RequestMapping(value = "/researchPlatformLeader-api/delete/{id}", method = RequestMethod.DELETE)
    @ResponseBody
    public Integer delete(@PathVariable String id) {
        ResponseEntity<Integer> responseEntity = this.restTemplate.exchange(delete+id, HttpMethod.DELETE, new HttpEntity(this.httpHeaders), Integer.class);
        return responseEntity.getBody();
    }


    @ApiOperation(value="初始化")
    @RequestMapping(value = "/researchPlatformLeader-api/newInit/{platformId}", method = RequestMethod.GET)
    @ResponseBody
    public PlatformLeaderModel newInit(@PathVariable String platformId) {
        PlatformLeaderModel p = new PlatformLeaderModel();
        p.setId(UUID.randomUUID().toString().replace("-",""));
        p.setPlatformId(platformId);
        return p;
    }

    @ApiOperation(value="批量添加")
    @RequestMapping(value = "/researchPlatformLeader-api/batchSave", method = RequestMethod.POST)
    @ResponseBody
    public Integer batchSave(@RequestBody List<PlatformLeaderModel> pmList) {
        this.httpHeaders.setContentType(MediaType.APPLICATION_JSON);
        SysUser userInfo = this.getUserProfile();
        pmList.forEach(p -> {
            this.setBaseData(p);
            p.setCreateDate(new Date());
            p.setCreator(userInfo.getUserName());
            p.setId(UUID.randomUUID().toString().replace("-",""));
            p.setDeleted("0");
            p.setCreateUnitId(userInfo.getUnitId());
            p.setCreateUnitName(userInfo.getUnitName());
        });
        ResponseEntity<Integer> responseEntity = this.restTemplate.exchange(batchSave, HttpMethod.POST, new HttpEntity<List>(pmList, this.httpHeaders), Integer.class);
        return responseEntity.getBody();
    }

}
