package com.pcitc.web.controller.treatise;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.github.pagehelper.PageInfo;
import com.pcitc.base.system.SysUser;
import com.pcitc.base.treatiseinfo.TreatiseInfo;
import com.pcitc.base.util.DateUtil;
import com.pcitc.web.common.RestBaseController;
import com.pcitc.web.utils.EquipmentUtils;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.apache.commons.lang.time.DateFormatUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;

/**
 * <p>成果维护</p>
 * @author
 */
@Api(value = "treatise-api", description = "论文")
@RestController
public class TreatiseController extends RestBaseController {


    /**
     * 根据ID获取对象信息
     */
    private static final String load = "http://kjpt-zuul/stp-proxy/treatise-api/load/";
    /**
     * 查询列表
     */
    private static final String query = "http://kjpt-zuul/stp-proxy/treatise-api/query";
    /**
     * 保存
     */
    private static final String save = "http://kjpt-zuul/stp-proxy/treatise-api/save";
    /**
     * 删除
     */
    private static final String delete = "http://kjpt-zuul/stp-proxy/treatise-api/delete/";

    /**
     * 查询平台列表不分页
     */
    private static final String queryNoPage = "http://kjpt-zuul/stp-proxy/treatise-api/queryNoPage";



    @ApiOperation(value="读取")
    @RequestMapping(value = "/treatise-api/load/{id}", method = RequestMethod.GET)
    @ResponseBody
    public TreatiseInfo load(@PathVariable String id) {
        ResponseEntity<TreatiseInfo> responseEntity = this.restTemplate.exchange(load+id, HttpMethod.GET, new HttpEntity(this.httpHeaders), TreatiseInfo.class);
        return responseEntity.getBody();
    }




    @ApiOperation(value = "查询列表", notes = "查询列表")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "pageNum", value = "页码", dataType = "Integer", paramType = "query"),
            @ApiImplicitParam(name = "pageSize", value = "每页显示条数", dataType = "Integer", paramType = "query"),
            @ApiImplicitParam(name = "theme", value = "论文主题", dataType = "String", paramType = "query"),
            @ApiImplicitParam(name = "title", value = "篇名", dataType = "String", paramType = "query"),
            @ApiImplicitParam(name = "journalName", value = "期刊名", dataType = "string", paramType = "query"),
            @ApiImplicitParam(name = "journalLevel", value = "期刊等级", dataType = "string", paramType = "query"),
            @ApiImplicitParam(name = "publishDate", value = "发表日期", dataType = "string", paramType = "query")
    })
    @RequestMapping(value = "/treatise-api/query", method = RequestMethod.GET)
    @ResponseBody
    public PageInfo query(
            @RequestParam(required = false,value = "pageNum") Integer pageNum,
            @RequestParam(required = false,value = "pageSize") Integer pageSize,
            @RequestParam(required = false,value = "theme") String theme,
            @RequestParam(required = false,value = "title") String title,
            @RequestParam(required = false,value = "journalName") String journalName,
            @RequestParam(required = false,value = "journalLevel")  String journalLevel,
            @RequestParam(required = false,value = "publishDate") @DateTimeFormat(pattern="yyyy-MM-dd") Date publishDate
    ){

        Map<String, Object> condition = new HashMap<>();
        SysUser sysUserInfo = this.getUserProfile();
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
        if (!StringUtils.isEmpty(theme)) {
            this.setParam(condition, "theme", theme);
        }
        if (!StringUtils.isEmpty(title)) {
            this.setParam(condition, "title", title);
        }
        if (!StringUtils.isEmpty(journalName)) {
            this.setParam(condition, "journalName", journalName);
        }
        if (!StringUtils.isEmpty(journalLevel)) {
            this.setParam(condition, "journalLevel", journalLevel);
        }
        if (!StringUtils.isEmpty(DateUtil.format(publishDate,DateUtil.FMT_SS))) {
            this.setParam(condition, "publishDate", DateUtil.format(publishDate,DateUtil.FMT_SS));
        }

        String childUnitIds= EquipmentUtils.getAllChildsByIUnitPath(sysUserInfo.getUnitPath(), restTemplate, httpHeaders);
        this.setParam(condition,"childUnitIds",childUnitIds);
        this.setBaseParam(condition);

        this.httpHeaders.setContentType(MediaType.APPLICATION_JSON);
        ResponseEntity<PageInfo> responseEntity = this.restTemplate.exchange(query, HttpMethod.POST, new HttpEntity<Map>(condition, this.httpHeaders), PageInfo.class);
        return responseEntity.getBody();
    }

    @ApiOperation(value="保存")
    @RequestMapping(value = "/treatise-api/save", method = RequestMethod.POST)
    @ResponseBody
    public void save(@RequestBody TreatiseInfo am){
        this.setBaseData(am);
        this.httpHeaders.setContentType(MediaType.APPLICATION_JSON);
        this.restTemplate.exchange(save, HttpMethod.POST, new HttpEntity<TreatiseInfo>(am, this.httpHeaders), TreatiseInfo.class);
    }


    @ApiOperation(value="删除")
    @RequestMapping(value = "/treatise-api/delete/{id}", method = RequestMethod.DELETE)
    @ResponseBody
    public void delete(@PathVariable String id) {
       this.restTemplate.exchange(delete+id, HttpMethod.DELETE, new HttpEntity(this.httpHeaders), Integer.class);
    }


    @ApiOperation(value="初始化")
    @RequestMapping(value = "/treatise-api/newInit", method = RequestMethod.GET)
    @ResponseBody
    public TreatiseInfo newInit() {
        TreatiseInfo a = new TreatiseInfo();
        a.setId(UUID.randomUUID().toString().replace("-",""));
        return a;
    }


    @ApiOperation(value="导出excel")
    @RequestMapping(value = "/treatise-api/export", method = RequestMethod.GET)
    @ResponseBody
    public void export(
            @RequestParam(required = false,value = "theme") String theme,
            @RequestParam(required = false,value = "title") String title,
            @RequestParam(required = false,value = "journalName") String journalName,
            @RequestParam(required = false,value = "journalLevel")  String journalLevel,
            @RequestParam(required = false,value = "publishDate") @DateTimeFormat(pattern="yyyy-MM-dd") Date publishDate
    ) throws Exception {
        Map<String, Object> condition = new HashMap<>(2);
        if (!StringUtils.isEmpty(theme)) {
            this.setParam(condition, "theme", theme);
        }
        if (!StringUtils.isEmpty(title)) {
            this.setParam(condition, "title", title);
        }

        if (!StringUtils.isEmpty(journalName)) {
            this.setParam(condition, "journalName", journalName);
        }
        if (!StringUtils.isEmpty(journalLevel)) {
            this.setParam(condition, "journalLevel", journalLevel);
        }
        if (!StringUtils.isEmpty(DateUtil.format(publishDate,DateUtil.FMT_SS))) {
            this.setParam(condition, "publishDate", DateUtil.format(publishDate,DateUtil.FMT_SS));
        }

        String[] headers = { "论文主题",  "关键字","篇名", "作者", "单位", "摘要", "期刊名", "期刊等级", "发表日期", "影响因子"  };
        String[] cols =    {"theme","keyWord","title","author","unitText","summary","journalName","journalLevelText","publishDate","influencingFactors"};
        export(headers,cols,"论文_",condition);
    }


    private void export(String[] headers,String[] cols,String fileName,Map condition) throws Exception {
        this.setBaseParam(condition);
        this.httpHeaders.setContentType(MediaType.APPLICATION_JSON);
        ResponseEntity<JSONArray> responseEntity = this.restTemplate.exchange(queryNoPage, HttpMethod.POST, new HttpEntity<Map>(condition, this.httpHeaders), JSONArray.class);
        List list = JSONObject.parseArray(responseEntity.getBody().toJSONString(), TreatiseInfo.class);
        fileName = fileName+ DateFormatUtils.format(new Date(), "ddhhmmss");
        this.exportExcel(headers,cols,fileName,list);
    }



}
