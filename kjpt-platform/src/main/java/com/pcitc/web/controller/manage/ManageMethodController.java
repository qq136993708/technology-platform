package com.pcitc.web.controller.manage;

import com.github.pagehelper.PageInfo;
import com.pcitc.base.manage.ManageMethod;
import com.pcitc.base.system.SysUser;
import com.pcitc.base.util.DateUtil;
import com.pcitc.web.common.RestBaseController;
import com.pcitc.web.utils.EquipmentUtils;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.apache.commons.lang3.StringUtils;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

/**
 * <p>管理办法</p>
 * @author
 */
@Api(value = "manageMethod-api", description = "管理办法")
@RestController
public class ManageMethodController extends RestBaseController {


    /**
     * 根据ID获取对象信息
     */
    private static final String load = "http://kjpt-zuul/stp-proxy/manageMethod-api/load/";
    /**
     * 查询列表
     */
    private static final String query = "http://kjpt-zuul/stp-proxy/manageMethod-api/query";
    /**
     * 保存
     */
    private static final String save = "http://kjpt-zuul/stp-proxy/manageMethod-api/save";
    /**
     * 删除
     */
    private static final String delete = "http://kjpt-zuul/stp-proxy/manageMethod-api/delete/";




    @ApiOperation(value="读取")
    @RequestMapping(value = "/manageMethod-api/load/{id}", method = RequestMethod.GET)
    @ResponseBody
    public ManageMethod load(@PathVariable String id) {
        ResponseEntity<ManageMethod> responseEntity = this.restTemplate.exchange(load+id, HttpMethod.GET, new HttpEntity(this.httpHeaders), ManageMethod.class);
        return responseEntity.getBody();
    }




    @ApiOperation(value = "查询列表", notes = "查询列表")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "pageNum", value = "页码", dataType = "Integer", paramType = "query"),
            @ApiImplicitParam(name = "pageSize", value = "每页显示条数", dataType = "Integer", paramType = "query"),
            @ApiImplicitParam(name = "publishDate", value = "发布日期", dataType = "Date", paramType = "query"),
            @ApiImplicitParam(name = "methodName", value = "名称", dataType = "string", paramType = "query"),
            @ApiImplicitParam(name = "edition", value = "版次", dataType = "string", paramType = "query")
    })
    @RequestMapping(value = "/manageMethod-api/query", method = RequestMethod.GET)
    @ResponseBody
    public PageInfo query(
            @RequestParam(required = false,value = "pageNum") Integer pageNum,
            @RequestParam(required = false,value = "pageSize") Integer pageSize,
            @RequestParam(required = false,value = "methodName") String methodName,
            @RequestParam(required = false,value = "publishDate") @DateTimeFormat(pattern="yyyy-MM-dd") Date publishDate,
            @RequestParam(required = false,value = "edition") String edition
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
        if (!StringUtils.isEmpty(DateUtil.format(publishDate,DateUtil.FMT_SS))) {
            this.setParam(condition, "publishDate", DateUtil.format(publishDate,DateUtil.FMT_SS));
        }
        if (!StringUtils.isEmpty(methodName)) {
            this.setParam(condition, "methodName", methodName);
        }
        if (!StringUtils.isEmpty(edition)) {
            this.setParam(condition, "edition", edition);
        }

        String childUnitIds= EquipmentUtils.getAllChildsByIUnitPath(sysUserInfo.getUnitPath(), restTemplate, httpHeaders);
        this.setParam(condition,"childUnitIds",childUnitIds);
        this.setBaseParam(condition);

        this.httpHeaders.setContentType(MediaType.APPLICATION_JSON);
        ResponseEntity<PageInfo> responseEntity = this.restTemplate.exchange(query, HttpMethod.POST, new HttpEntity<Map>(condition, this.httpHeaders), PageInfo.class);
        return responseEntity.getBody();
    }

    @ApiOperation(value="保存")
    @RequestMapping(value = "/manageMethod-api/save", method = RequestMethod.POST)
    @ResponseBody
    public void save(@RequestBody ManageMethod am){
        this.setBaseData(am);
        this.httpHeaders.setContentType(MediaType.APPLICATION_JSON);
        this.restTemplate.exchange(save, HttpMethod.POST, new HttpEntity<ManageMethod>(am, this.httpHeaders), ManageMethod.class);
    }


    @ApiOperation(value="删除")
    @RequestMapping(value = "/manageMethod-api/delete/{id}", method = RequestMethod.DELETE)
    @ResponseBody
    public void delete(@PathVariable String id) {
        this.restTemplate.exchange(delete+id, HttpMethod.DELETE, new HttpEntity(this.httpHeaders), Integer.class);
    }


    @ApiOperation(value="初始化")
    @RequestMapping(value = "/manageMethod-api/newInit", method = RequestMethod.GET)
    @ResponseBody
    public ManageMethod newInit() {
        ManageMethod a = new ManageMethod();
        a.setId(UUID.randomUUID().toString().replace("-",""));
        return a;
    }



}
