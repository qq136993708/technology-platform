package com.pcitc.web.controller.researchplatform;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.github.pagehelper.PageInfo;
import com.pcitc.base.researchplatform.PlatformAchievementModel;
import com.pcitc.base.researchplatform.PlatformPatentModel;
import com.pcitc.web.common.RestBaseController;
import com.pcitc.web.utils.EquipmentUtils;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.apache.commons.lang.time.DateFormatUtils;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;

/**
 * <p>服务接口</p>
 * <p>Table:  - 科研平台-专利信息</p>
 * @author ty
 */

@Api(value = "researchPlatformPatent-api", description = "国家科研平台专利接口")
@RestController
public class PlatformPatentController extends RestBaseController {

    /**
     * 根据ID获取对象信息
     */
    private static final String load = "http://kjpt-zuul/stp-proxy/researchPlatformPatent-api/load/";
    /**
     * 查询平台项目列表
     */
    private static final String query = "http://kjpt-zuul/stp-proxy/researchPlatformPatent-api/query";
    /**
     * 保存平台项目
     */
    private static final String save = "http://kjpt-zuul/stp-proxy/researchPlatformPatent-api/save";
    /**
     * 平台项目批量保存
     */
    private static final String batchSave = "http://kjpt-zuul/stp-proxy/researchPlatformPatent-api/batchSave";
    /**
     * 删除项目
     */
    private static final String delete = "http://kjpt-zuul/stp-proxy/researchPlatformPatent-api/delete/";

    /**
     * 查询平台专利列表不分页
     */
    private static final String queryNopage = "http://kjpt-zuul/stp-proxy/researchPlatformPatent-api/queryNoPage";

    private static final String importPath = "http://kjpt-zuul/stp-proxy/researchPlatformPatent-api/excelImport/";

    @ApiOperation(value="读取")
    @RequestMapping(value = "/researchPlatformPatent-api/load/{id}", method = RequestMethod.GET)
    @ResponseBody
    public PlatformPatentModel load(@PathVariable String id) {
        ResponseEntity<PlatformPatentModel> responseEntity = this.restTemplate.exchange(load+id, HttpMethod.GET, new HttpEntity(this.httpHeaders), PlatformPatentModel.class);
        return responseEntity.getBody();
    }



    @ApiOperation(value="导出excel")
    @RequestMapping(value = "/researchPlatformPatent-api/export", method = RequestMethod.GET)
    @ResponseBody
    public void export(@RequestParam String platformId) throws Exception {
        Map<String, Object> condition = new HashMap<>(2);
        this.setParam(condition, "platformId", platformId);
        String[] headers = { "专利名称",  "专利类型",    "申请日期"  , "描述"};
        String[] cols =    {"patentName","patentTypeText","applicationDate","remark"};
        this.httpHeaders.setContentType(MediaType.APPLICATION_JSON);
        ResponseEntity<JSONArray> responseEntity = this.restTemplate.exchange(queryNopage, HttpMethod.POST, new HttpEntity<Map>(condition, this.httpHeaders), JSONArray.class);
        List list = JSONObject.parseArray(responseEntity.getBody().toJSONString(), PlatformPatentModel.class);
        String fileName = "科研平台专利表_"+ DateFormatUtils.format(new Date(), "ddhhmmss");
        this.exportExcel(headers,cols,fileName,list);
    }

    @ApiOperation(value = "查询科研平台专利列表", notes = "查询科研平台专利列表")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "pageNum", value = "页码", dataType = "Integer", paramType = "query"),
            @ApiImplicitParam(name = "pageSize", value = "每页显示条数", dataType = "Integer", paramType = "query"),
            @ApiImplicitParam(name = "platformId", value = "平台ID", dataType = "string", paramType = "query"),
            @ApiImplicitParam(name = "secretLevel", value = "秘级", dataType = "string", paramType = "query")
    })
    @RequestMapping(value = "/researchPlatformPatent-api/query", method = RequestMethod.GET)
    @ResponseBody
    public PageInfo query(
            @RequestParam(required = false,value = "pageNum") Integer pageNum,
            @RequestParam(required = false,value = "pageSize") Integer pageSize,
            @RequestParam(value = "platformId") String platformId,
            @RequestParam(value = "secretLevel") String secretLevel

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

        if(secretLevel != null){
            this.setParam(condition,"secretLevel",secretLevel);
        }
        this.setParam(condition,"userSecretLevel",this.getUserProfile().getSecretLevel());


        //默认查询当前人所在机构下所有的科研平台专利
        String childUnitIds= EquipmentUtils.getAllChildsByIUnitPath(this.getUserProfile().getUnitPath(), restTemplate, httpHeaders);
        this.setParam(condition,"childUnitIds",childUnitIds);

        this.setParam(condition,"platformId",platformId);
        this.httpHeaders.setContentType(MediaType.APPLICATION_JSON);
        ResponseEntity<PageInfo> responseEntity = this.restTemplate.exchange(query, HttpMethod.POST, new HttpEntity<Map>(condition, this.httpHeaders), PageInfo.class);
        return responseEntity.getBody();
    }

    @ApiOperation(value="保存")
    @RequestMapping(value = "/researchPlatformPatent-api/save", method = RequestMethod.POST)
    @ResponseBody
    public PlatformPatentModel save(@RequestBody PlatformPatentModel pm) {
        this.httpHeaders.setContentType(MediaType.APPLICATION_JSON);
        this.setBaseData(pm);
        ResponseEntity<PlatformPatentModel> responseEntity = this.restTemplate.exchange(save, HttpMethod.POST, new HttpEntity<PlatformPatentModel>(pm, this.httpHeaders), PlatformPatentModel.class);
        return responseEntity.getBody();
    }

    @ApiOperation(value="删除")
    @RequestMapping(value = "/researchPlatformPatent-api/delete/{id}", method = RequestMethod.DELETE)
    @ResponseBody
    public Integer delete(@PathVariable String id) {
        ResponseEntity<Integer> responseEntity = this.restTemplate.exchange(delete+id, HttpMethod.DELETE, new HttpEntity(this.httpHeaders), Integer.class);
        return responseEntity.getBody();
    }

    @ApiOperation(value="初始化")
    @RequestMapping(value = "/researchPlatformPatent-api/newInit/{platformId}", method = RequestMethod.GET)
    @ResponseBody
    public PlatformPatentModel newInit(@PathVariable String platformId) {
        PlatformPatentModel p = new PlatformPatentModel();
        p.setId(UUID.randomUUID().toString().replace("-",""));
        p.setPlatformId(platformId);
        p.setCreateDate(new Date());
        p.setCreator(this.getUserProfile().getUserName());
        p.setDeleted("0");
        return p;
    }

    @ApiOperation(value="批量添加")
    @RequestMapping(value = "/researchPlatformPatent-api/batchSave", method = RequestMethod.POST)
    @ResponseBody
    public Integer batchSave(@RequestBody List<PlatformPatentModel> pmList) {
        pmList.forEach(p -> {
            this.setBaseData(p);
            p.setCreateDate(new Date());
            p.setCreator(this.getUserProfile().getUserName());
            p.setId(UUID.randomUUID().toString().replace("-",""));
            p.setDeleted("0");
            p.setCreateUnitId(this.getUserProfile().getUnitId());
            p.setCreateUnitName(this.getUserProfile().getUnitName());
        });
        this.httpHeaders.setContentType(MediaType.APPLICATION_JSON);
        ResponseEntity<Integer> responseEntity = this.restTemplate.exchange(batchSave, HttpMethod.POST, new HttpEntity<List>(pmList, this.httpHeaders), Integer.class);
        return responseEntity.getBody();
    }

}
