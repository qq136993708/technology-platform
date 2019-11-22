package com.pcitc.web.controller.computersoftware;


import com.github.pagehelper.PageInfo;
import com.pcitc.base.computersoftware.ComputerSoftware;
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
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;


@Api(value = "computerSoftware-api", description = "计算机软件接口")
@RestController
@RequestMapping(value = "/ComputerSoftware")
public class ComputerSoftwareController extends RestBaseController {

    /**
     * 根据ID获取对象信息
     */
    private static final String load = "http://kjpt-zuul/stp-proxy/computerSoftware-api/load/";
    /**
     * 查询平台列表
     */
    private static final String query = "http://kjpt-zuul/stp-proxy/computerSoftware-api/query";
    /**
     * 保存平台
     */
    private static final String save = "http://kjpt-zuul/stp-proxy/computerSoftware-api/save";
    /**
     * 删除
     */
    private static final String delete = "http://kjpt-zuul/stp-proxy/computerSoftware-api/delete/";


    @ApiOperation(value = "读取")
    @RequestMapping(value = "/load/{id}", method = RequestMethod.GET)
    @ResponseBody
    public ComputerSoftware load(@PathVariable String id) {
        ResponseEntity<ComputerSoftware> responseEntity = this.restTemplate.exchange(load + id, HttpMethod.GET, new HttpEntity(this.httpHeaders), ComputerSoftware.class);
        return responseEntity.getBody();
    }


    @ApiOperation(value = "查询计算机软件列表", notes = "查询计算机软件列表")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "pageNum", value = "页码", dataType = "Integer", paramType = "query"),
            @ApiImplicitParam(name = "pageSize", value = "每页显示条数", dataType = "Integer", paramType = "query"),
            @ApiImplicitParam(name = "unitName;", value = "单位名称", dataType = "string", paramType = "query"),
            @ApiImplicitParam(name = "registerNumber;", value = "登记号", dataType = "string", paramType = "query"),
            @ApiImplicitParam(name = "softwareName;", value = "软件名称", dataType = "string", paramType = "query"),
            @ApiImplicitParam(name = "copyrightOwner;", value = "著作权人", dataType = "string", paramType = "query"),
            @ApiImplicitParam(name = "versionNumber;", value = "版本号", dataType = "string", paramType = "query"),
            @ApiImplicitParam(name = "recordDate;", value = "登记日期", dataType = "string", paramType = "query"),
            @ApiImplicitParam(name = "developFinishDate;;", value = "开发完成日期", dataType = "string", paramType = "query"),
            @ApiImplicitParam(name = "softwareIntro;;", value = "软件简介", dataType = "string", paramType = "query"),
            @ApiImplicitParam(name = "entryPeople;;", value = "录入人", dataType = "string", paramType = "query"),
            @ApiImplicitParam(name = "entryTime;;", value = "录入时间", dataType = "string", paramType = "query"),
            @ApiImplicitParam(name = "notes;;", value = "备注", dataType = "string", paramType = "query"),
            @ApiImplicitParam(name = "accessoryUpload;;;", value = " 附件上传", dataType = "string", paramType = "query")
    })

    @RequestMapping(value = "/query", method = RequestMethod.GET)
    @ResponseBody
    public PageInfo query(
            @RequestParam(required = false, value = "pageNum") Integer pageNum,
            @RequestParam(required = false, value = "pageSize") Integer pageSize,
            @RequestParam(required = false, value = "unitName") String unitName,
            @RequestParam(required = false, value = "registerNumber") String registerNumber,
            @RequestParam(required = false, value = "softwareName") String softwareName,
            @RequestParam(required = false, value = "copyrightOwner") String copyrightOwner,
            @RequestParam(required = false, value = "versionNumber") String versionNumber,
            @RequestParam(required = false, value = "recordDate") String recordDate,
            @RequestParam(required = false, value = "developFinishDate") String developFinishDate,
            @RequestParam(required = false, value = "softwareIntro") String softwareIntro,
            @RequestParam(required = false, value = "entryPeople") String entryPeople,
            @RequestParam(required = false, value = "entryTime") String entryTime,
            @RequestParam(required = false, value = "notes") String notes,
            @RequestParam(required = false, value = "accessoryUpload") String accessoryUpload

    ) {
        Map<String, Object> condition = new HashMap<>(6);
        if (pageNum == null) {
            this.setParam(condition, "pageNum", 1);
        } else {
            this.setParam(condition, "pageNum", pageNum);
        }
        if (pageSize == null) {
            this.setParam(condition, "pageSize", 10);
        } else {
            this.setParam(condition, "pageSize", pageSize);
        }
        if (!StringUtils.isEmpty(unitName)) {
            this.setParam(condition, "unitName", unitName);
        }
        if (!StringUtils.isEmpty(registerNumber)) {
            this.setParam(condition, "registerNumber;", registerNumber);
        }
        if (!StringUtils.isEmpty(softwareName)) {
            this.setParam(condition, "softwareName", softwareName);
        }
        if (!StringUtils.isEmpty(copyrightOwner)) {
            this.setParam(condition, "copyrightOwner", copyrightOwner);
        }
        if (!StringUtils.isEmpty(versionNumber)) {
            this.setParam(condition, "versionNumber", versionNumber);
        }
        if (!StringUtils.isEmpty(recordDate)) {
            this.setParam(condition, "recordDate", recordDate);
        }
        if (!StringUtils.isEmpty(developFinishDate)) {
            this.setParam(condition, "developFinishDate", developFinishDate);
        }
        if (!StringUtils.isEmpty(softwareIntro)) {
            this.setParam(condition, "softwareIntro", softwareIntro);
        }
        if (!StringUtils.isEmpty(entryPeople)) {
            this.setParam(condition, "entryPeople", entryPeople);
        }
        if (!StringUtils.isEmpty(entryTime)) {
            this.setParam(condition, "entryTime", entryTime);
        }
        if (!StringUtils.isEmpty(notes)) {
            this.setParam(condition, "notes", notes);
        }
        if (!StringUtils.isEmpty(accessoryUpload)) {
            this.setParam(condition, "accessoryUpload", accessoryUpload);
        }

        this.httpHeaders.setContentType(MediaType.APPLICATION_JSON);
        ResponseEntity<PageInfo> responseEntity = this.restTemplate.exchange(query, HttpMethod.POST, new HttpEntity<Map>(condition, this.httpHeaders), PageInfo.class);
        return responseEntity.getBody();
    }


    @ApiOperation(value = "保存")
    @RequestMapping(value = "/save", method = RequestMethod.POST)
    @ResponseBody
    public ComputerSoftware save(@RequestBody ComputerSoftware cs) {
        this.httpHeaders.setContentType(MediaType.APPLICATION_JSON);
        ResponseEntity<ComputerSoftware> responseEntity = this.restTemplate.exchange(save, HttpMethod.POST, new HttpEntity<ComputerSoftware>(cs, this.httpHeaders), ComputerSoftware.class);
        return responseEntity.getBody();
    }

    @ApiOperation(value = "删除")
    @RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE)
    @ResponseBody
    public Integer delete(@PathVariable String id) {
        ResponseEntity<Integer> responseEntity = this.restTemplate.exchange(delete + id, HttpMethod.DELETE, new HttpEntity(this.httpHeaders), Integer.class);
        return responseEntity.getBody();
    }

    @ApiOperation(value = "初始化")
    @RequestMapping(value = "/newInit", method = RequestMethod.GET)
    @ResponseBody
    public ComputerSoftware newInit() {
        ComputerSoftware p = new ComputerSoftware();
        p.setId(UUID.randomUUID().toString().replace("_", ""));
        p.setDeleted("0");  //删除标识
        p.setCreateDate(new Date());  // 创建时间
        p.setCreator(this.getUserProfile().getUserName());
        return p;
    }

}
