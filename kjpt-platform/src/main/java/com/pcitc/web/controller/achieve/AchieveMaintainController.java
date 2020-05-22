package com.pcitc.web.controller.achieve;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.github.pagehelper.PageInfo;
import com.pcitc.base.achieve.AchieveMaintain;
import com.pcitc.base.researchplatform.PlatformInfoModel;
import com.pcitc.base.system.SysUser;
import com.pcitc.base.util.DateUtil;
import com.pcitc.web.common.RestBaseController;
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
@Api(value = "achieveMaintain-api", description = "成果维护接口")
@RestController
public class AchieveMaintainController extends RestBaseController {


    /**
     * 根据ID获取对象信息
     */
    private static final String load = "http://kjpt-zuul/stp-proxy/achieveMaintain-api/load/";
    /**
     * 查询列表
     */
    private static final String query = "http://kjpt-zuul/stp-proxy/achieveMaintain-api/query";
    /**
     * 保存
     */
    private static final String save = "http://kjpt-zuul/stp-proxy/achieveMaintain-api/save";
    /**
     * 删除
     */
    private static final String delete = "http://kjpt-zuul/stp-proxy/achieveMaintain-api/delete/";

    /**
     * 查询平台列表不分页
     */
    private static final String queryNoPage = "http://kjpt-zuul/stp-proxy/achieveMaintain-api/queryNoPage";



    @ApiOperation(value="读取")
    @RequestMapping(value = "/achieveMaintain-api/load/{id}", method = RequestMethod.GET)
    @ResponseBody
    public AchieveMaintain load(@PathVariable String id) {
        ResponseEntity<AchieveMaintain> responseEntity = this.restTemplate.exchange(load+id, HttpMethod.GET, new HttpEntity(this.httpHeaders), AchieveMaintain.class);
        return responseEntity.getBody();
    }




    @ApiOperation(value = "查询列表", notes = "查询列表")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "pageNum", value = "页码", dataType = "Integer", paramType = "query"),
            @ApiImplicitParam(name = "pageSize", value = "每页显示条数", dataType = "Integer", paramType = "query"),
            @ApiImplicitParam(name = "startYear", value = "获奖年份开始", dataType = "String", paramType = "query"),
            @ApiImplicitParam(name = "endYear", value = "获奖年份结束", dataType = "String", paramType = "query"),
            @ApiImplicitParam(name = "type", value = "获奖类型", dataType = "string", paramType = "query"),
            @ApiImplicitParam(name = "awardsChildType", value = "奖项子名称", dataType = "string", paramType = "query"),
            @ApiImplicitParam(name = "awardsType", value = "成果奖项", dataType = "string", paramType = "query")
    })
    @RequestMapping(value = "/achieveMaintain-api/query", method = RequestMethod.GET)
    @ResponseBody
    public PageInfo query(
            @RequestParam(required = false,value = "pageNum") Integer pageNum,
            @RequestParam(required = false,value = "pageSize") Integer pageSize,
            @RequestParam(required = false,value = "type") String type,
            @RequestParam(required = false,value = "awardsChildType") String awardsChildType,
            @RequestParam(required = false,value = "startYear") String startYear,
            @RequestParam(required = false,value = "endYear")  String endYear,
            @RequestParam(required = false,value = "awardsType") String awardsType
    ){

        Map<String, Object> condition = new HashMap<>(6);
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
        if (!StringUtils.isEmpty(startYear)) {
            this.setParam(condition, "startYear", startYear);
        }
        if (!StringUtils.isEmpty(endYear)) {
            this.setParam(condition, "endYear", endYear);
        }
        if (!StringUtils.isEmpty(type)) {
            this.setParam(condition, "type", type);
        }
        if (!StringUtils.isEmpty(awardsChildType)) {
            this.setParam(condition, "awardsChildType", awardsChildType);
        }
        if (!StringUtils.isEmpty(awardsType)) {
            this.setParam(condition, "awardsType", awardsType);
        }

        this.setBaseParam(condition);
        this.httpHeaders.setContentType(MediaType.APPLICATION_JSON);
        ResponseEntity<PageInfo> responseEntity = this.restTemplate.exchange(query, HttpMethod.POST, new HttpEntity<Map>(condition, this.httpHeaders), PageInfo.class);
        return responseEntity.getBody();
    }

    @ApiOperation(value="保存")
    @RequestMapping(value = "/achieveMaintain-api/save", method = RequestMethod.POST)
    @ResponseBody
    public void save(@RequestBody AchieveMaintain am){
        this.setBaseData(am);
        this.httpHeaders.setContentType(MediaType.APPLICATION_JSON);
        this.restTemplate.exchange(save, HttpMethod.POST, new HttpEntity<AchieveMaintain>(am, this.httpHeaders), AchieveMaintain.class);
    }


    @ApiOperation(value="删除")
    @RequestMapping(value = "/achieveMaintain-api/delete/{id}", method = RequestMethod.DELETE)
    @ResponseBody
    public void delete(@PathVariable String id) {
       this.restTemplate.exchange(delete+id, HttpMethod.DELETE, new HttpEntity(this.httpHeaders), Integer.class);
    }


    @ApiOperation(value="初始化")
    @RequestMapping(value = "/achieveMaintain-api/newInit", method = RequestMethod.GET)
    @ResponseBody
    public AchieveMaintain newInit() {
        AchieveMaintain a = new AchieveMaintain();
        a.setId(UUID.randomUUID().toString().replace("-",""));
        return a;
    }


    @ApiOperation(value="导出excel")
    @RequestMapping(value = "/achieveMaintain-api/export", method = RequestMethod.GET)
    @ResponseBody
    public void export(
            @RequestParam(required = false,value = "type") String type,
            @RequestParam(required = false,value = "startYear") @DateTimeFormat(pattern="yyyy") Date startYear,
            @RequestParam(required = false,value = "endYear")  @DateTimeFormat(pattern="yyyy") Date endYear,
            @RequestParam(required = false,value = "awardsType") String awardsType
    ) throws Exception {
        Map<String, Object> condition = new HashMap<>(2);
        if (!StringUtils.isEmpty(DateUtil.format(startYear,DateUtil.FMT_YYYY))) {
            this.setParam(condition, "startYear", DateUtil.format(startYear,DateUtil.FMT_YYYY));
        }
        if (!StringUtils.isEmpty(DateUtil.format(endYear,DateUtil.FMT_YYYY))) {
            this.setParam(condition, "endYear", DateUtil.format(endYear,DateUtil.FMT_YYYY));
        }
        if (!StringUtils.isEmpty(type)) {
            this.setParam(condition, "type", type);
        }
        if (!StringUtils.isEmpty(awardsType)) {
            this.setParam(condition, "awardsType", awardsType);
        }
        String[] headers = { "获奖年份",  "奖项级别","奖项名称", "奖项子名称", "奖项数量"  };
        String[] cols =    {"year","typeText","awardsTypeText","awardsChildTypeText","awardsNumber"};
        export(headers,cols,"成果维护表_",condition);
    }


    private void export(String[] headers,String[] cols,String fileName,Map condition) throws Exception {
        this.setBaseParam(condition);
        this.httpHeaders.setContentType(MediaType.APPLICATION_JSON);
        ResponseEntity<JSONArray> responseEntity = this.restTemplate.exchange(queryNoPage, HttpMethod.POST, new HttpEntity<Map>(condition, this.httpHeaders), JSONArray.class);
        List list = JSONObject.parseArray(responseEntity.getBody().toJSONString(), AchieveMaintain.class);
        fileName = fileName+ DateFormatUtils.format(new Date(), "ddhhmmss");
        this.exportExcel(headers,cols,fileName,list);
    }



}
