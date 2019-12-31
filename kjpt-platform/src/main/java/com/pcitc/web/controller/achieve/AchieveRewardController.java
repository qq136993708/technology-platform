package com.pcitc.web.controller.achieve;


import com.github.pagehelper.PageInfo;
import com.pcitc.base.achieve.AchieveReward;
import com.pcitc.base.system.SysUser;
import com.pcitc.web.common.RestBaseController;
import com.pcitc.web.utils.EquipmentUtils;
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

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

/**
 * <p>成果转换激励</p>
 * <p>Table:  achieve_record 成果转换激励</p>
 * @author
 */
@Api(value = "achieveReward-api", description = "成果转换激励")
@RestController
public class AchieveRewardController extends RestBaseController {

    /**
     * 根据ID获取对象信息
     */
    private static final String load = "http://kjpt-zuul/stp-proxy/achieveReward-api/load/";
    /**
     * 查询列表
     */
    private static final String query = "http://kjpt-zuul/stp-proxy/achieveReward-api/query";
    /**
     * 保存
     */
    private static final String save = "http://kjpt-zuul/stp-proxy/achieveReward-api/save";
    /**
     * 删除
     */
    private static final String delete = "http://kjpt-zuul/stp-proxy/achieveReward-api/delete/";


    @ApiOperation(value="读取")
    @RequestMapping(value = "/achieveReward-api/load/{id}", method = RequestMethod.GET)
    @ResponseBody
    public AchieveReward load(@PathVariable String id) {
        ResponseEntity<AchieveReward> responseEntity = this.restTemplate.exchange(load+id, HttpMethod.GET, new HttpEntity(this.httpHeaders), AchieveReward.class);
        return responseEntity.getBody();
    }




    @ApiOperation(value = "查询列表", notes = "查询列表")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "pageNum", value = "页码", dataType = "Integer", paramType = "query"),
            @ApiImplicitParam(name = "pageSize", value = "每页显示条数", dataType = "Integer", paramType = "query"),
            @ApiImplicitParam(name = "achieveName", value = "成果名称", dataType = "string", paramType = "query"),
            @ApiImplicitParam(name = "finishUnitName", value = "完成单位", dataType = "string", paramType = "query"),
            @ApiImplicitParam(name = "auditStatus", value = "审核状态", dataType = "string", paramType = "query")
    })
    @RequestMapping(value = "/achieveReward-api/query", method = RequestMethod.GET)
    @ResponseBody
    public PageInfo query(
            @RequestParam(required = false,value = "pageNum") Integer pageNum,
            @RequestParam(required = false,value = "pageSize") Integer pageSize,
            @RequestParam(required = false,value = "achieveName") String achieveName,
            @RequestParam(required = false,value = "finishUnitName") String finishUnitName,
            @RequestParam(required = false,value = "auditStatus") String auditStatus

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
        if (!StringUtils.isEmpty(achieveName)) {
            this.setParam(condition, "achieveName", achieveName);
        }
        if (!StringUtils.isEmpty(finishUnitName)) {
            this.setParam(condition, "finishUnitName", finishUnitName);
        }
        if (!StringUtils.isEmpty(auditStatus)) {
            this.setParam(condition, "auditStatus", auditStatus);
        }

        //默认查询当前人所在机构下所有的成果激励
        //String childUnitIds= EquipmentUtils.getAllChildsByIUnitPath(sysUserInfo.getUnitPath(), restTemplate, httpHeaders);
        //this.setParam(condition,"childUnitIds",childUnitIds);

        this.httpHeaders.setContentType(MediaType.APPLICATION_JSON);
        ResponseEntity<PageInfo> responseEntity = this.restTemplate.exchange(query, HttpMethod.POST, new HttpEntity<Map>(condition, this.httpHeaders), PageInfo.class);
        return responseEntity.getBody();
    }

    @ApiOperation(value="保存")
    @RequestMapping(value = "/achieveReward-api/save", method = RequestMethod.POST)
    @ResponseBody
    public AchieveReward save(@RequestBody AchieveReward ar){
        this.setBaseData(ar);
        this.httpHeaders.setContentType(MediaType.APPLICATION_JSON);
        ResponseEntity<AchieveReward> responseEntity = this.restTemplate.exchange(save, HttpMethod.POST, new HttpEntity<AchieveReward>(ar, this.httpHeaders), AchieveReward.class);
        return responseEntity.getBody();
    }

    @ApiOperation(value="删除")
    @RequestMapping(value = "/achieveReward-api/delete/{id}", method = RequestMethod.DELETE)
    @ResponseBody
    public Integer delete(@PathVariable String id) {
        ResponseEntity<Integer> responseEntity = this.restTemplate.exchange(delete+id, HttpMethod.DELETE, new HttpEntity(this.httpHeaders), Integer.class);
        return responseEntity.getBody();
    }


    @ApiOperation(value="初始化")
    @RequestMapping(value = "/achieveReward-api/newInit", method = RequestMethod.GET)
    @ResponseBody
    public AchieveReward newInit() {
        AchieveReward a = new AchieveReward();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy");
        Date date = new Date();
        a.setId(UUID.randomUUID().toString().replace("-",""));
        a.setAssignPlanDoc(UUID.randomUUID().toString().replace("-",""));
        a.setIncomeReportDoc(UUID.randomUUID().toString().replace("-",""));
        a.setRewardAccountingDoc(UUID.randomUUID().toString().replace("-",""));
        a.setRewardYear(sdf.format(date));
        return a;
    }
}
