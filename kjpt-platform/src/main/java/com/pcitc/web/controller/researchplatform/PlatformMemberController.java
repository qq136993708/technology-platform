package com.pcitc.web.controller.researchplatform;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.github.pagehelper.PageInfo;
import com.pcitc.base.researchplatform.PlatformAchievementModel;
import com.pcitc.base.researchplatform.PlatformMemberModel;
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
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.*;

import java.util.*;

/**
 * <p>服务接口</p>
 * <p>Table:  - 科研平台-成果信息</p>
 * @author ty
 */

@Api(value = "researchPlatformMember-api", description = "国家科研平台成员接口")
@RestController
public class PlatformMemberController extends RestBaseController {

    /**
     * 根据ID获取对象信息
     */
    private static final String load = "http://kjpt-zuul/stp-proxy/researchPlatformMember-api/load/";
    /**
     * 查询平台项目列表
     */
    private static final String query = "http://kjpt-zuul/stp-proxy/researchPlatformMember-api/query";
    /**
     * 保存平台项目
     */
    private static final String save = "http://kjpt-zuul/stp-proxy/researchPlatformMember-api/save";
    /**
     * 平台项目批量保存
     */
    private static final String batchSave = "http://kjpt-zuul/stp-proxy/researchPlatformMember-api/batchSave";
    /**
     * 删除项目
     */
    private static final String delete = "http://kjpt-zuul/stp-proxy/researchPlatformMember-api/delete/";

    /**
     * 修改团队成员的角色
     */
    private static final String updateMemberRole = "http://kjpt-zuul/stp-proxy/researchPlatformMember-api/updateMemberRole";

    /**
     * 查询平台成员不分页
     */
    private static final String queryNopage = "http://kjpt-zuul/stp-proxy/researchPlatformMember-api/queryNoPage";

    private static final String importPath = "http://kjpt-zuul/stp-proxy/researchPlatformMember-api/excelImport/";

    @ApiOperation(value="读取")
    @RequestMapping(value = "/researchPlatformMember-api/load/{id}", method = RequestMethod.GET)
    @ResponseBody
    public PlatformMemberModel load(@PathVariable String id) {
        ResponseEntity<PlatformMemberModel> responseEntity = this.restTemplate.exchange(load+id, HttpMethod.GET, new HttpEntity(this.httpHeaders), PlatformMemberModel.class);
        return responseEntity.getBody();
    }

    @ApiOperation(value="导出excel")
    @RequestMapping(value = "/researchPlatformMember-api/export", method = RequestMethod.GET)
    @ResponseBody
    public void export(
            @RequestParam(value = "platformId") String platformId
    ) throws Exception {
        Map<String, Object> condition = new HashMap<>(2);
        if (!StringUtils.isEmpty(platformId)) {
            this.setParam(condition, "platformId", platformId);
        }
        String[] headers = { "名称",  "出生年月",    "学历"  , "技术职称", "毕业院校", "所学专业", "岗位名称", "担任职务","工作单位"};
        String[] cols =    {"name","birth","educationText","technicalTitle","graduateSchool","majorStudied","postName","assumeOffice","workUnitText"};
        this.httpHeaders.setContentType(MediaType.APPLICATION_JSON);
        ResponseEntity<JSONArray> responseEntity = this.restTemplate.exchange(queryNopage, HttpMethod.POST, new HttpEntity<Map>(condition, this.httpHeaders), JSONArray.class);
        List list = JSONObject.parseArray(responseEntity.getBody().toJSONString(), PlatformMemberModel.class);
        String fileName = "科研平台成员表_"+ DateFormatUtils.format(new Date(), "ddhhmmss");
        this.exportExcel(headers,cols,fileName,list);
    }


    @ApiOperation(value = "查询科研平台成员列表", notes = "查询科研平台成员列表")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "pageNum", value = "页码", dataType = "Integer", paramType = "query"),
            @ApiImplicitParam(name = "pageSize", value = "每页显示条数", dataType = "Integer", paramType = "query"),
            @ApiImplicitParam(name = "platformId", value = "平台ID", dataType = "string", paramType = "query"),
            @ApiImplicitParam(name = "baseIds", value = "人员ID数组", dataType = "string", paramType = "query"),
            @ApiImplicitParam(name = "secretLevel", value = "秘级", dataType = "string", paramType = "query")

    })
    @RequestMapping(value = "/researchPlatformMember-api/query", method = RequestMethod.GET)
    @ResponseBody
    public PageInfo query(
            @RequestParam(required = false,value = "pageNum") Integer pageNum,
            @RequestParam(required = false,value = "pageSize") Integer pageSize,
            @RequestParam(value = "platformId") String platformId,
            @RequestParam(required = false,value = "baseIds") String baseIds,
            @RequestParam(required = false,value = "secretLevel") String secretLevel

    ) throws Exception {
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

        if(secretLevel != null){
            this.setParam(condition,"secretLevel",secretLevel);
        }
        this.setParam(condition,"userSecretLevel",this.getUserProfile().getSecretLevel());


        //默认查询当前人所在机构下所有的科研平台成员
        String childUnitIds= EquipmentUtils.getAllChildsByIUnitPath(this.getUserProfile().getUnitPath(), restTemplate, httpHeaders);
        this.setParam(condition,"childUnitIds",childUnitIds);

        this.httpHeaders.setContentType(MediaType.APPLICATION_JSON);
        ResponseEntity<PageInfo> responseEntity = this.restTemplate.exchange(query, HttpMethod.POST, new HttpEntity<Map>(condition, this.httpHeaders), PageInfo.class);
        return responseEntity.getBody();
    }

    @ApiOperation(value="保存")
    @RequestMapping(value = "/researchPlatformMember-api/save", method = RequestMethod.POST)
    @ResponseBody
    public PlatformMemberModel save(@RequestBody PlatformMemberModel pam) {
        this.setBaseData(pam);
        this.httpHeaders.setContentType(MediaType.APPLICATION_JSON);
        ResponseEntity<PlatformMemberModel> responseEntity = this.restTemplate.exchange(save, HttpMethod.POST, new HttpEntity<PlatformMemberModel>(pam, this.httpHeaders), PlatformMemberModel.class);
        return responseEntity.getBody();
    }

    @ApiOperation(value="删除")
    @RequestMapping(value = "/researchPlatformMember-api/delete/{id}", method = RequestMethod.DELETE)
    @ResponseBody
    public Integer delete(@PathVariable String id) {
        ResponseEntity<Integer> responseEntity = this.restTemplate.exchange(delete+id, HttpMethod.DELETE, new HttpEntity(this.httpHeaders), Integer.class);
        return responseEntity.getBody();
    }

    @ApiOperation(value="修改团队成员角色")
    @RequestMapping(value = "/researchPlatformMember-api/updateMemberRole", method = RequestMethod.POST)
    @ResponseBody
    public Integer updateMemberRole(@RequestParam String ids,@RequestParam String role) {
        this.httpHeaders.setContentType(MediaType.APPLICATION_JSON);

        Map<String, Object> param = new HashMap<>(2);
        if (!StringUtils.isEmpty(role)) {
            this.setParam(param, "role", role);
        }
        if (!StringUtils.isEmpty(role)) {
            this.setParam(param, "ids", ids);
        }
        ResponseEntity<Integer> responseEntity = this.restTemplate.exchange(updateMemberRole, HttpMethod.POST, new HttpEntity<Map>(param,this.httpHeaders), Integer.class);
        return responseEntity.getBody();
    }

    @ApiOperation(value="初始化")
    @RequestMapping(value = "/researchPlatformMember-api/newInit/{platformId}", method = RequestMethod.GET)
    @ResponseBody
    public PlatformMemberModel newInit(@PathVariable String platformId) {
        PlatformMemberModel p = new PlatformMemberModel();
        p.setId(UUID.randomUUID().toString().replace("-",""));
        p.setPlatformId(platformId);
        p.setCreateDate(new Date());
        p.setCreator(this.getUserProfile().getUserName());
        p.setDeleted("0");
        return p;
    }

    @ApiOperation(value="批量添加")
    @RequestMapping(value = "/researchPlatformMember-api/batchSave", method = RequestMethod.POST)
    @ResponseBody
    public Integer batchSave(@RequestBody List<PlatformMemberModel> pmList) {
        this.httpHeaders.setContentType(MediaType.APPLICATION_JSON);
        pmList.forEach(p -> {
            this.setBaseData(p);
            p.setCreateDate(new Date());
            p.setCreator(this.getUserProfile().getUserName());
            p.setId(UUID.randomUUID().toString().replace("-",""));
            p.setDeleted("0");
            p.setCreateUnitId(this.getUserProfile().getUnitId());
            p.setCreateUnitName(this.getUserProfile().getUnitName());
        });
        ResponseEntity<Integer> responseEntity = this.restTemplate.exchange(batchSave, HttpMethod.POST, new HttpEntity<List>(pmList, this.httpHeaders), Integer.class);
        return responseEntity.getBody();
    }

}
