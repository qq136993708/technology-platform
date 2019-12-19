package com.pcitc.web.controller.trademark;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.github.pagehelper.PageInfo;
import com.pcitc.base.patent.PatentInfo;
import com.pcitc.base.system.SysUser;
import com.pcitc.base.trademarkinfo.TrademarkInfo;
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
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@Api(value = "trademark-api", description = "商标接口")
@RestController
@RequestMapping("/trademarkController")
public class TrademarkController extends RestBaseController {

    private static final String SAVE = "http://kjpt-zuul/stp-proxy/trademark-provider/trademarkInfo/trademarkInfo_save";

    private static final String QUERY = "http://kjpt-zuul/stp-proxy/trademark-provider/trademarkInfo/trademarkInfo_query";

    private static final String LOAD = "http://kjpt-zuul/stp-proxy/trademark-provider/trademarkInfo/trademarkInfo_load/";

    private static final String DELETE = "http://kjpt-zuul/stp-proxy/trademark-provider/trademarkInfo/trademarkInfo_delete/";

    private static final String queryNoPage = "http://kjpt-zuul/stp-proxy/trademark-provider/trademarkInfo/queryNoPage";

    /**
     * 保存-商标信息
     *
     * @param trademarkInfo
     * @return TrademarkInfo
     */
    @ApiOperation(value="保存商标信息")
    @RequestMapping(value = "/save",method=RequestMethod.POST)
    @ResponseBody
    public TrademarkInfo save(@RequestBody TrademarkInfo trademarkInfo) {
        this.setBaseData(trademarkInfo);
        httpHeaders.setContentType(MediaType.APPLICATION_JSON);
        ResponseEntity<TrademarkInfo> responseEntity = this.restTemplate.exchange(SAVE, HttpMethod.POST, new HttpEntity<TrademarkInfo>(trademarkInfo, this.httpHeaders), TrademarkInfo.class);
        return responseEntity.getBody();
    }

    /**
     * 商标列表-分页查询
     *
     * @return PageInfo
     */
    @ApiOperation(value = "查询商标列表", notes = "查询商标列表")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "pageNum", value = "页码", dataType = "Integer", paramType = "query"),
            @ApiImplicitParam(name = "pageSize", value = "每页显示条数", dataType = "Integer", paramType = "query"),
            @ApiImplicitParam(name = "unitName", value = "单位名称", dataType = "String", paramType = "query"),
            @ApiImplicitParam(name = "registerDateStart", value = "注册日期开始", dataType = "Date", paramType = "query"),
            @ApiImplicitParam(name = "registerDateEnd", value = "注册日期结束", dataType = "Date", paramType = "query"),
            @ApiImplicitParam(name = "trademarkName", value = "注册商标名称", dataType = "String", paramType = "query"),
            @ApiImplicitParam(name = "lawStatus", value = "法律状态", dataType = "String", paramType = "query"),
            @ApiImplicitParam(name = "applicant", value = "申请人", dataType = "String", paramType = "query"),
            @ApiImplicitParam(name = "secretLevel", value = "秘级", dataType = "string", paramType = "query")
    })

    @RequestMapping(value = "/query",  method = RequestMethod.GET)
    @ResponseBody
    public PageInfo query(@RequestParam(required = false) Integer pageNum,
                        @RequestParam(required = false) Integer pageSize,
                        @RequestParam(required = false) String unitName,
                        @RequestParam(required = false) @DateTimeFormat(pattern="yyyy-MM-dd") Date registerDateStart,
                        @RequestParam(required = false) @DateTimeFormat(pattern="yyyy-MM-dd") Date registerDateEnd,
                        @RequestParam(required = false) String trademarkName,
                        @RequestParam(required = false) String lawStatus,
                        @RequestParam(required = false) String applicant,
                          @RequestParam(required = false,value = "secretLevel") String secretLevel
    ){
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
            if (!StringUtils.isEmpty(unitName)) {
            this.setParam(condition, "unitName", unitName);
        }
        if (!StringUtils.isEmpty(DateUtil.format(registerDateStart,DateUtil.FMT_SS))) {
            this.setParam(condition, "registerDateStart", DateUtil.format(registerDateStart,DateUtil.FMT_SS));
        }
        if (!StringUtils.isEmpty(DateUtil.format(registerDateEnd,DateUtil.FMT_SS))) {
            this.setParam(condition, "registerDateEnd", DateUtil.format(registerDateEnd,DateUtil.FMT_SS));
        }
        if (!StringUtils.isEmpty(trademarkName)) {
        this.setParam(condition, "trademarkName", trademarkName);
        }
        if (!StringUtils.isEmpty(lawStatus)) {
        this.setParam(condition, "lawStatus", lawStatus);
        }
        if (!StringUtils.isEmpty(applicant)) {
        this.setParam(condition, "applicant", applicant);
        }

        if(secretLevel != null){
            this.setParam(condition,"secretLevel",secretLevel);
        }
        SysUser sysUserInfo = this.getUserProfile();
        this.setParam(condition,"userSecretLevel",sysUserInfo.getSecretLevel());

        //默认查询当前人所在机构及子机构的所有专家
        String childUnitIds= EquipmentUtils.getAllChildsByIUnitPath(sysUserInfo.getUnitPath(), restTemplate, httpHeaders);
        this.setParam(condition, "childUnitIds", childUnitIds);
        this.httpHeaders.setContentType(MediaType.APPLICATION_JSON);
        ResponseEntity<PageInfo> responseEntity = this.restTemplate.exchange(QUERY, HttpMethod.POST, new HttpEntity<Map>(condition, this.httpHeaders), PageInfo.class);
        return responseEntity.getBody();
    }
    /**
     * 导出
     *
     * @return PageInfo
     */
    @ApiOperation(value = "导出", notes = "导出")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "unitName", value = "单位名称", dataType = "String", paramType = "query"),
            @ApiImplicitParam(name = "trademarkName", value = "注册商标名称", dataType = "String", paramType = "query")
    })

    @RequestMapping(value = "/export",  method = RequestMethod.GET)
    @ResponseBody
    public void query(
                        @RequestParam(required = false) String unitName,
                        @RequestParam(required = false) String trademarkName,
                          @RequestParam(required = false,value = "secretLevel") String secretLevel
    ) throws Exception {
        Map<String, Object> condition = new HashMap<>(6);
            if (!StringUtils.isEmpty(unitName)) {
            this.setParam(condition, "unitName", unitName);
        }
        if (!StringUtils.isEmpty(trademarkName)) {
        this.setParam(condition, "trademarkName", trademarkName);
        }

        if(secretLevel != null){
            this.setParam(condition,"secretLevel",secretLevel);
        }
        SysUser sysUserInfo = this.getUserProfile();
        this.setParam(condition,"userSecretLevel",sysUserInfo.getSecretLevel());

        //默认查询当前人所在机构及子机构的所有专家
        String childUnitIds= EquipmentUtils.getAllChildsByIUnitPath(sysUserInfo.getUnitPath(), restTemplate, httpHeaders);
        this.setParam(condition, "childUnitIds", childUnitIds);
        this.httpHeaders.setContentType(MediaType.APPLICATION_JSON);
        String[] headers = { "单位名称",  "注册商标名称",    "商标申请号"  , "注册日期","注册公告日","核定使用商品大类","申请人/注册人","有效日期","法律状态","密级"};
        String[] cols =    {"unitNameText","trademarkName","applicationNumber","registerDate","registerNoticeDate","commodityCategory","applicant","effectiveDate","legalStatusText","secretLevelText"};
        ResponseEntity<JSONArray> responseEntity = this.restTemplate.exchange(queryNoPage, HttpMethod.POST, new HttpEntity<Map>(condition, this.httpHeaders), JSONArray.class);
        List list = JSONObject.parseArray(responseEntity.getBody().toJSONString(), TrademarkInfo.class);
        String fileName = "商标明细表_"+ DateFormatUtils.format(new Date(), "ddhhmmss");
        this.exportExcel(headers,cols,fileName,list);
    }


    /**
     * 根据ID查询商标信息
     *
     * @return TrademarkInfo
     */
    @ApiOperation(value="根据ID查询商标信息")
    @RequestMapping(value = "/load/{id}",method = RequestMethod.GET)
    @ResponseBody
    public TrademarkInfo load(@PathVariable String id) {
        ResponseEntity<TrademarkInfo> responseEntity = this.restTemplate.exchange(LOAD+id, HttpMethod.GET, new HttpEntity(this.httpHeaders), TrademarkInfo.class);
        return responseEntity.getBody();
    }

    /**
     * 删除方法
     *
     * @return Integer
     */
    @ApiOperation(value="删除商标信息")
    @RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE)
    @ResponseBody
    public Integer delete(@PathVariable String id) {
        ResponseEntity<Integer> responseEntity = this.restTemplate.exchange(DELETE+id, HttpMethod.DELETE, new HttpEntity(this.httpHeaders), Integer.class);
        return responseEntity.getBody();
    }

    /**
     * 初始化方法
     *
     * @return TrademarkInfo
     */
    @ApiOperation(value="初始化商标信息")
    @RequestMapping(value = "/newInit", method = RequestMethod.GET)
    @ResponseBody
    public TrademarkInfo newInit() {
        TrademarkInfo trademarkInfo = new TrademarkInfo();
        trademarkInfo.setId(UUID.randomUUID().toString().replace("-",""));
        trademarkInfo.setDeleted("0");
        return trademarkInfo;
    }
}
