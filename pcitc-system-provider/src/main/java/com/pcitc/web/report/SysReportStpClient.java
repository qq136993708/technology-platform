package com.pcitc.web.report;

import com.pcitc.base.common.LayuiTableParam;
import com.pcitc.base.common.enums.DataOperationStatusEnum;
import com.pcitc.base.report.SysReportStp;
import com.pcitc.base.report.SysReportStpExample;
import com.pcitc.service.report.SysReportStpService;
import com.alibaba.fastjson.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

import java.io.Serializable;
import java.util.List;

/**
 * <p>服务接口</p>
 * <p>Table: sys_report_stp - </p>
 *
 * @since 2019-01-11 10:46:19
 */
@Api(value = "SysReportStpClient-API", description = "服务接口")
@RestController
public class SysReportStpClient {
    private final static Logger logger = LoggerFactory.getLogger(SysReportStpClient.class);

    @Autowired
    SysReportStpService sysReportStpService;

    //参数查询
    @ApiOperation(value = "带参查询列表", notes = "根据ID查询查询信息,返回一个的JSONObject对象")
    @RequestMapping(value = "/sysreportstp-provider/sysreportstp/sysreportstp_list_param", method = RequestMethod.POST)
    public JSONObject selectSysReportStpListParam(@RequestParam(value = "id", required = false) String id) {
        JSONObject retJson = new JSONObject();
        try {
            SysReportStp sysReportStp = new SysReportStp();
            sysReportStp.setId(id);
            List<SysReportStp> list = sysReportStpService.findSysReportStpList(sysReportStp);
            retJson.put("list", list);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return retJson;
    }

    //对象查询,js需要JSON.stringify({id:"1"},转换之后,才能自动赋值
    @ApiOperation(value = "查询列表", notes = "自定义对象(条件)查询信息,返回存储在JSONObject对象中的列表")
    @RequestMapping(value = "/sysreportstp-provider/sysreportstp/sysreportstp_list", method = RequestMethod.POST)
    public JSONObject selectSysReportStpList(@RequestBody SysReportStp sysReportStp) {
        JSONObject retJson = new JSONObject();
        try {
            List<SysReportStp> list = sysReportStpService.findSysReportStpList(sysReportStp);
            retJson.put("list", list);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return retJson;
    }

    @ApiOperation(value = "查询树形详情信息", notes = "按ID查询详情信息(带父ID),操作成功返回SysFileKind对象")
    @RequestMapping(value = "/sysreportstp-provider/sysreportstp/get-sysreportstp/{id}", method = RequestMethod.POST)
    public SysReportStp getSysReportStpInfo(@PathVariable(value = "id", required = true) String id) {
        try {
            return sysReportStpService.getSysReportStpInfo(id);
        } catch (Exception e) {
            logger.error("[初始化信息失败：]", e);
        }
        return null;
    }

    /**
     * 树形展示
     *
     * @return
     * @throws Exception
     */
    @ApiOperation(value = "查询(树)信息", notes = "查询(树)信息,操作成功返回List<TreeNode>对象")
    @RequestMapping(value = "/sysreportstp-provider/sysreportstp/tree-data")
    @ResponseBody
    public List selectObjectByTree() throws Exception {
        return sysReportStpService.selectObjectByTree();
    }

    /**
     * 删除-false
     *
     * @param sysReportStpcId
     * @return
     */
    @ApiOperation(value = "伪删除信息", notes = "按ID伪删除信息,操作成功返回201")
    @RequestMapping(value = "/sysreportstp-provider/sysreportstp/del-sysreportstp/{sysReportStpId}")
    public Object deleteSysReportStp(@PathVariable("sysReportStpId") String sysReportStpcId) {
        return sysReportStpService.deleteSysReportStp(sysReportStpcId);
    }

    /**
     * 删除-true
     *
     * @param sysReportStpcId
     * @return
     */
    @ApiOperation(value = "删除信息", notes = "按ID删除信息,操作成功返回201")
    @RequestMapping(value = "/sysreportstp-provider/sysreportstp/del-sysreportstp-real/{sysReportStpId}", method = RequestMethod.POST)
    public Object deleteSysReportStpReal(@PathVariable("sysReportStpId") String sysReportStpcId) {
        return sysReportStpService.deleteSysReportStpReal(sysReportStpcId);
    }

    /**
     * 分页查询
     *
     * @param param
     * @return
     */
    @ApiOperation(value = "查询信息-分页查询", notes = "查询信息-分页查询,Object")
    @RequestMapping(value = "/sysreportstp-provider/sysreportstp/sysreportstp-page")
    public Object selectSysReportStpByPage(@RequestBody LayuiTableParam param) {
        return sysReportStpService.findSysReportStpByPage(param);
    }

    /**
     * 保存
     *
     * @param sysReportStp
     * @return
     */
    @ApiOperation(value = "新增信息", notes = "新增信息,操作成功返回500")
    @RequestMapping(value = "/sysreportstp-provider/sysreportstp/save_sysreportstp", method = RequestMethod.POST)
    public int updateOrInsertSysReportStp(@RequestBody SysReportStp sysReportStp) {
        try {
            return sysReportStpService.updateOrInsertSysReportStp(sysReportStp);
        } catch (Exception e) {
            logger.error("[保存信息失败：]", e);
        }
        return 500;
    }
}
