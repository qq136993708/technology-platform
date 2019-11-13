package com.pcitc.web.system;

import com.alibaba.fastjson.JSONObject;
import com.pcitc.base.system.SysLog;
import com.pcitc.service.system.SysLogService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


/**
 * @author Administrator
 * <p>
 * 日志接口，插入日志、查询日志、导出日志
 */
@Api(value = "SysLog-API",description = "日志管理相关的接口")
@RestController
public class SysLogClient {

    private final static Logger logger = LoggerFactory.getLogger(SysLogClient.class);

    @Autowired
    SysLogService sysLogService;

    /**
     * 新增系统日志
     *
     * @param log
     * @return
     */
    @ApiOperation(value = "新增系统日志", notes = "传入json格式的日志实体属性")
    @RequestMapping(value = "/log-provider/log/add", method = RequestMethod.POST)
    public Integer insertLog(@RequestBody SysLog log) {
        try {
            return sysLogService.insertLog(log);
        } catch (Exception e) {
            logger.error("[系统管理-日志管理-新增系统日志失败：]", e);
        }
        return 0;
    }

    /**
     * 查询系统日志列表
     *
     * @param obj
     * @return
     */
    @ApiOperation(value = "查询系统日志列表", notes = "传入json格式的日志实体属性")
    @RequestMapping(value = "/sysLog-provider/sysLog_list", method = RequestMethod.POST)
    public String selectSysLogByPage(@RequestBody SysLog obj) {
        JSONObject tem = null;
        try {
            tem = sysLogService.selectSysLogList(obj);
        } catch (Exception e) {
            logger.error("[系统管理-日志管理-查询系统日志列表失败：]", e);
            e.printStackTrace();
        }
        return tem.toString();
    }

    /**
     * 删除系统日志
     *
     * @param id
     * @return
     */
    @ApiOperation(value = "删除系统日志", notes = "传入日志实体id属性")
    @RequestMapping(value = "/sysLog-provider/deleteSysLog/{id}", method = RequestMethod.POST)
    public int deleteDictionary(@PathVariable(value = "id", required = true) String id) {
        int result = 500;
        try {
            result = sysLogService.deleteSysLog(id);
        } catch (Exception e) {
            logger.error("[系统管理-日志管理-删除系统日志失败：]", e);
        }
        return result;
    }

    /**
     * 批量导入日志
     *
     * @param list
     * @return
     */
    @ApiOperation(value = "批量导入日志", notes = "传入json格式的日志实体属性")
    @RequestMapping(value = "/sysLog-provider/importSysLog", method = RequestMethod.POST)
    public int exportSysLog(@RequestBody List<SysLog> list) {
        int result = 500;
        try {
            result = sysLogService.insertBatch(list);
        } catch (Exception e) {
            logger.error("[系统管理-日志管理-导入日志失败：]", e);
        }
        return result;
    }
}
