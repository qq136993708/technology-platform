package com.pcitc.web.system;

import com.pcitc.es.common.Constant;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

import java.io.Serializable;
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
import com.github.pagehelper.PageInfo;
import com.pcitc.base.common.enums.DataOperationStatusEnum;
import com.pcitc.base.system.SysFileConfig;
import com.pcitc.base.system.SysFileConfigExample;
import com.pcitc.service.system.SysFileConfigService;

/**
 * <p>服务接口</p>
 * <p>Table: sys_file_config - InnoDB free: 5120 kB</p>
 *
 * @since 2018-05-12 09:49:59
 */
@Api(value = "SysFileConfigClient-API", description = "文件配置服务接口")
@RestController
public class SysFileConfigClient {
    private final static Logger logger = LoggerFactory.getLogger(SysFileConfigClient.class);

    @Autowired
    SysFileConfigService sysFileConfigService;

    /**
     * 获取菜单---节点树形展示
     *
     * @return
     * @throws Exception
     */
    @ApiOperation(value = "文件配置树形展示", notes = "文件配置列表树形展示,返回List类型对象")
    @RequestMapping(value = "/sysfileconfig-provider/sysfileconfig/tree-data")
    @ResponseBody
    public List selectObjectByTree() throws Exception {
        return sysFileConfigService.selectObjectByTree();
    }

    @ApiOperation(value = "获取文件配置", notes = "根据ID获取文件配置,返回SysFileConfig类型对象")
    @RequestMapping(value = "/sysfileconfig-provider/sysfileconfig/getFileConfig/{filedflag}")
    public SysFileConfig selectSysFileConfigById(@PathVariable(value = "filedflag", required = true) String filedflag) throws Exception {
        SysFileConfig sysFileConfig = sysFileConfigService.selectByPrimaryKey(filedflag);
        return sysFileConfig;
    }

    /**
     * 查询菜单相信信息-展示
     *
     * @param sysFileConfigId
     * @return
     * @throws Exception
     */
    @ApiOperation(value = "获取文件配置信息(包括父节点)", notes = "根据ID获取文件配置信息(包括父节点),返回SysFileConfig类型对象")
    @RequestMapping(value = "/sysfileconfig-provider/sysfileconfig/get-sysfileconfig/{sysFileConfigId}")
    public SysFileConfig selectSysFileConfigByMenuId(@PathVariable(value = "sysFileConfigId", required = true) String sysFileConfigId) throws Exception {
        SysFileConfig sysFileConfig = new SysFileConfig();

        SysFileConfigExample sysFileConfigExample = new SysFileConfigExample();
        sysFileConfigExample.getOredCriteria().add(sysFileConfigExample.createCriteria().andMenuIdEqualTo(sysFileConfigId));

        List<SysFileConfig> sysFileConfigList = sysFileConfigService.selectByExample(sysFileConfigExample);
        if ((sysFileConfigList == null || sysFileConfigList.size() == 0)) {
            sysFileConfig.setId(sysFileConfigId);
            sysFileConfig.setMenuId(sysFileConfigId);
            sysFileConfig.setFileCount("1");
            sysFileConfig.setFileSize("102400");
            sysFileConfig.setPosition(sysFileConfigId);
            sysFileConfig.setFileType(com.pcitc.base.common.Constant.default_file_type);
            sysFileConfig.setFileTheme("1");
            sysFileConfig.setBz("0.5f");
            sysFileConfigService.insertObject(sysFileConfig);
        } else {
            sysFileConfig = sysFileConfigList.get(0);
        }
        return sysFileConfig;
    }

    /**
     * 更新文件配置
     *
     * @param sysFileConfig
     * @return
     */
    @ApiOperation(value = "更新文件配置信息", notes = "根据文件ID更新文件配置信息,返回200状态")
    @RequestMapping(value = "/sysfileconfig-provider/sysfileconfig/update-sysfileconfig")
    public Serializable updateSysFileConfig(@RequestBody SysFileConfig sysFileConfig) {
        sysFileConfigService.updateByPrimaryKey(sysFileConfig);
        DataOperationStatusEnum status = DataOperationStatusEnum.UPD_OK;
        return status;
    }

    /**
     * 删除文件配置-false
     *
     * @param sysFileConfigcId
     * @return
     */
    @ApiOperation(value = "伪删除文件配置信息", notes = "根据文件ID伪删除文件配置信息,返回200状态")
    @RequestMapping(value = "/sysfileconfig-provider/sysfileconfig/del-sysfileconfig/{sysFileConfigId}")
    public Serializable deleteSysFileConfig(@PathVariable("sysFileConfigId") String sysFileConfigcId) {
        DataOperationStatusEnum status = sysFileConfigService.deleteSysFileConfig(sysFileConfigcId);
        return status;
    }

    /**
     * 删除文件配置-true
     *
     * @param sysFileConfigcId
     * @return
     */
    @ApiOperation(value = "删除文件配置信息", notes = "根据文件ID删除文件配置信息,返回200状态")
    @RequestMapping(value = "/sysfileconfig-provider/sysfileconfig/del-sysfileconfig-real/{sysFileConfigId}", method = RequestMethod.POST)
    public Serializable deleteSysFileConfigReal(@PathVariable("sysFileConfigId") String sysFileConfigcId) {
        sysFileConfigService.deleteSysFileConfigReal(sysFileConfigcId);
        return DataOperationStatusEnum.DEL_OK;
    }

    /**
     * 增加文件配置
     *
     * @param sysFileConfig
     * @return
     */
    @ApiOperation(value = "新增文件配置信息", notes = "新增文件配置信息,返回SysFileConfig类型对象")
    @RequestMapping(value = "/sysfileconfig-provider/sysfileconfig/add-sysfileconfig", method = RequestMethod.POST)
    public SysFileConfig insertSysFileConfig(@RequestBody SysFileConfig sysFileConfig) {
        return sysFileConfigService.insertObject(sysFileConfig);
    }

    /**
     * 分页查询
     *
     * @param jsonStr
     * @return
     */
    @ApiOperation(value = "分页查询文件配置信息", notes = "分页查询文件配置信息,返回JSONObject类型对象")
    @RequestMapping(value = "/sysfileconfig-provider/sysfileconfig-page")
    public JSONObject selectSysFileConfigByPage(@RequestParam(value = "jsonStr", required = false) String jsonStr) {
        PageInfo<SysFileConfig> info = sysFileConfigService.findSysFileConfigByPage(jsonStr);
        return JSONObject.parseObject(JSONObject.toJSONString(info));
    }
}
