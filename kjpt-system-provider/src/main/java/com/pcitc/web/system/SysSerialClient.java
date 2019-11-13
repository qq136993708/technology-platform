package com.pcitc.web.system;


import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSONObject;
import com.pcitc.base.common.LayuiTableParam;
import com.pcitc.base.system.SysSerial;
import com.pcitc.service.system.SysSerialService;


/**
 * <p>服务接口</p>
 * <p>Table: sys_serial - 文件上传-取号</p>
 *
 * @since 2018-08-15 03:34:45
 */
@Api(value = "SysSerialClient-API", description = "文件上传-取号服务接口")
@RestController
public class SysSerialClient {
    private final static Logger logger = LoggerFactory.getLogger(SysSerialClient.class);

    @Autowired
    SysSerialService sysSerialService;


    //参数查询
    @ApiOperation(value = "带参文件上传-取号查询列表", notes = "根据ID查询查询文件上传-取号信息,返回一个文件上传-取号的JSONObject对象")
    @RequestMapping(value = "/sysserial-provider/sysserial/sysserial_list_param", method = RequestMethod.POST)
    public JSONObject selectSysSerialListParam(@RequestParam(value = "id", required = false) String id) {
        JSONObject retJson = new JSONObject();
        try {
            SysSerial sysSerial = new SysSerial();
            sysSerial.setId(id);
            List<SysSerial> list = sysSerialService.findSysSerialList(sysSerial);
            retJson.put("list", list);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return retJson;
    }

    //对象查询,js需要JSON.stringify({id:"1"},转换之后,才能自动赋值
    @ApiOperation(value = "文件上传-取号查询列表", notes = "自定义对象(条件)查询文件上传-取号信息,返回存储在JSONObject对象中的文件上传-取号列表")
    @RequestMapping(value = "/sysserial-provider/sysserial/sysserial_list", method = RequestMethod.POST)
    public JSONObject selectSysSerialList(@RequestBody SysSerial sysSerial) {
        JSONObject retJson = new JSONObject();
        try {
            List<SysSerial> list = sysSerialService.findSysSerialList(sysSerial);
            retJson.put("list", list);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return retJson;
    }


    @ApiOperation(value = "查询文件上传-取号树形详情信息", notes = "按ID查询文件上传-取号详情信息(带父ID),操作成功返回SysFileKind对象")
    @RequestMapping(value = "/sysserial-provider/sysserial/get-sysserial/{id}", method = RequestMethod.POST)
    public SysSerial getSysSerialInfo(@PathVariable(value = "id", required = true) String id) {
        try {
            return sysSerialService.getSysSerialInfo(id);
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
    @ApiOperation(value = "查询(树)文件上传-取号信息", notes = "查询(树)文件上传-取号信息,操作成功返回List<TreeNode>对象")
    @RequestMapping(value = "/sysserial-provider/sysserial/tree-data")
    @ResponseBody
    public List selectObjectByTree() throws Exception {
        return sysSerialService.selectObjectByTree();
    }


    /**
     * 删除文件上传-取号-false
     *
     * @param sysSerialcId
     * @return
     */
    @ApiOperation(value = "伪删除文件上传-取号信息", notes = "按ID伪删除文件上传-取号信息,操作成功返回201")
    @RequestMapping(value = "/sysserial-provider/sysserial/del-sysserial/{sysSerialId}")
    public Object deleteSysSerial(@PathVariable("sysSerialId") String sysSerialcId) {
        return sysSerialService.deleteSysSerial(sysSerialcId);
    }

    /**
     * 删除文件上传-取号-true
     *
     * @param sysSerialcId
     * @return
     */
    @ApiOperation(value = "删除文件上传-取号信息", notes = "按ID删除文件上传-取号信息,操作成功返回201")
    @RequestMapping(value = "/sysserial-provider/sysserial/del-sysserial-real/{sysSerialId}", method = RequestMethod.POST)
    public Object deleteSysSerialReal(@PathVariable("sysSerialId") String sysSerialcId) {
        return sysSerialService.deleteSysSerialReal(sysSerialcId);
    }


    /**
     * 分页查询
     *
     * @param param
     * @return
     */
    @ApiOperation(value = "查询文件上传-取号信息-分页查询", notes = "查询文件上传-取号信息-分页查询,Object")
    @RequestMapping(value = "/sysserial-provider/sysserial/sysserial-page")
    public Object selectSysSerialByPage(@RequestBody LayuiTableParam param) {
        return sysSerialService.findSysSerialByPage(param);
    }

    /**
     * 保存
     *
     * @param sysSerial
     * @return
     */
    @ApiOperation(value = "新增文件上传-取号信息", notes = "新增文件上传-取号信息,操作成功返回500")
    @RequestMapping(value = "/sysserial-provider/sysserial/save_sysserial", method = RequestMethod.POST)
    public int updateOrInsertSysSerial(@RequestBody SysSerial sysSerial) {
        try {
            return sysSerialService.updateOrInsertSysSerial(sysSerial);
        } catch (Exception e) {
            logger.error("[保存信息失败：]", e);
        }
        return 500;
    }
}
