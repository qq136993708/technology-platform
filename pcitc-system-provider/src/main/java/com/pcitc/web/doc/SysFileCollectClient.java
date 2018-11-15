package com.pcitc.web.doc;


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
import com.pcitc.base.doc.SysFileCollect;
import com.pcitc.base.doc.SysFileCollectExample;
import com.pcitc.service.doc.SysFileCollectService;


/**
 * <p>服务接口</p>
 * <p>Table: sys_file_collect - 文件收藏</p>
 *
 * @since 2018-06-22 09:00:03
 */
@Api(value = "SysFileCollectClient-API", description = "文件收藏服务接口")
@RestController
public class SysFileCollectClient {
    private final static Logger logger = LoggerFactory.getLogger(SysFileCollectClient.class);

    @Autowired
    SysFileCollectService sysFileCollectService;


    @ApiOperation(value = "带参文件收藏查询列表", notes = "根据文件ID查询查询文件收藏信息,返回一个文件收藏的JSONObject对象")
    @RequestMapping(value = "/sysfilecollect-provider/sysfilecollect/sysfilecollect_list_param", method = RequestMethod.POST)
    public JSONObject selectSysFileCollectListParam(@RequestParam(value = "id", required = false) String id) {
        JSONObject retJson = new JSONObject();
        try {
            SysFileCollect sysFileCollect = new SysFileCollect();
            sysFileCollect.setId(id);
            List<SysFileCollect> list = sysFileCollectService.findSysFileCollectList(sysFileCollect);
            retJson.put("list", list);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return retJson;
    }

    @ApiOperation(value = "文件收藏查询列表", notes = "自定义对象(条件)查询文件收藏信息,返回存储在JSONObject对象中的文件收藏列表")
    @RequestMapping(value = "/sysfilecollect-provider/sysfilecollect/sysfilecollect_list", method = RequestMethod.POST)
    public JSONObject selectSysFileCollectList(@RequestBody SysFileCollect sysFileCollect) {
        JSONObject retJson = new JSONObject();
        try {
            List<SysFileCollect> list = sysFileCollectService.findSysFileCollectList(sysFileCollect);
            retJson.put("list", list);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return retJson;
    }

    @ApiOperation(value = "更新文件收藏", notes = "更新文件收藏,操作成功返回500")
    @RequestMapping(value = "/sysfilecollect-provider/sysfilecollect/save_sysfilecollect", method = RequestMethod.POST)
    public int updateOrInsertSysFileCollect(@RequestBody SysFileCollect sysFileCollect) {
        try {
            return sysFileCollectService.updateOrInsertSysFileCollect(sysFileCollect);
        } catch (Exception e) {
            logger.error("[保存信息失败：]", e);
        }
        return 500;
    }

    @ApiOperation(value = "删除文件收藏", notes = "根据ID删除文件收藏信息,操作成功返回500")
    @RequestMapping(value = "/sysfilecollect-provider/sysfilecollect/delete_sysfilecollect/{id}", method = RequestMethod.POST)
    public int deleteSysFileCollectById(@PathVariable(value = "id", required = true) String id) {
        try {
            return sysFileCollectService.deleteSysFileCollectById(id);
        } catch (Exception e) {
            logger.error("[删除信息失败：]", e);
        }
        return 500;
    }

    @ApiOperation(value = "查询文件收藏详情", notes = "根据ID查询文件收藏信息,操作成功返回SysFileCollect对象")
    @RequestMapping(value = "/sysfilecollect-provider/sysfilecollect/get-sysfilecollect/{id}", method = RequestMethod.POST)
    public SysFileCollect getSysFileCollectInfo(@PathVariable(value = "id", required = true) String id) {
        try {
            return sysFileCollectService.getSysFileCollectInfo(id);
        } catch (Exception e) {
            logger.error("[初始化信息失败：]", e);
        }
        return null;
    }


    @ApiOperation(value = "文件收藏树形展示", notes = "查询文件收藏树形列表,操作成功返回List<TreeNode>对象")
    @RequestMapping(value = "/sysfilecollect-provider/sysfilecollect/tree-data")
    @ResponseBody
    public List selectObjectByTree() throws Exception {
        return sysFileCollectService.selectObjectByTree();
    }

    /**
     * 查询菜单相信信息-展示
     *
     * @param sysFileCollectId
     * @return
     * @throws Exception
     */
    @ApiOperation(value = "查询文件收藏树形详情信息", notes = "按ID查询文件收藏详情信息(带父ID),操作成功返回SysFileCollect对象")
    @RequestMapping(value = "/sysfilecollect-provider/sysfilecollect/get_sysfilecollect/{sysFileCollectId}")
    public SysFileCollect selectSysFileCollectByMenuId(@PathVariable(value = "sysFileCollectId", required = true) String sysFileCollectId) throws Exception {
        SysFileCollect sysFileCollect = sysFileCollectService.selectByPrimaryKey(sysFileCollectId);
        if ("".equals(sysFileCollect.getParentId().trim())) {
            sysFileCollect.setParentName("");
        } else {
        }
        SysFileCollectExample sysFileCollectExample = new SysFileCollectExample();
        String strParentId = sysFileCollectService.selectByExample(sysFileCollectExample).get(0).getId();
        sysFileCollect.setRootId(strParentId);
        return sysFileCollect;
    }

    /**
     * 更新菜单信息
     *
     * @param sysFileCollect
     * @return
     */
    @ApiOperation(value = "更新文件收藏信息", notes = "更新文件收藏详情信息,操作成功返回202状态")
    @RequestMapping(value = "/sysfilecollect-provider/sysfilecollect/update-sysfilecollect")
    public Serializable updateSysFileCollect(@RequestBody SysFileCollect sysFileCollect) {
        sysFileCollectService.updateByPrimaryKey(sysFileCollect);
        DataOperationStatusEnum status = DataOperationStatusEnum.UPD_OK;
        return status;
    }

    /**
     * 删除菜单信息-false
     *
     * @param sysFileCollectcId
     * @return
     */
    @ApiOperation(value = "伪删除文件收藏信息", notes = "根据ID删除文件收藏信息,操作成功返回202状态")
    @RequestMapping(value = "/sysfilecollect-provider/sysfilecollect/del-sysfilecollect/{sysFileCollectId}")
    public Serializable deleteSysFileCollect(@PathVariable("sysFileCollectId") String sysFileCollectcId) {
        DataOperationStatusEnum status = sysFileCollectService.deleteSysFileCollect(sysFileCollectcId);
        return status;
    }

    /**
     * 删除菜单信息-true
     *
     * @param sysFileCollectcId
     * @return
     */
    @ApiOperation(value = "物理删除文件收藏信息", notes = "根据ID删除文件收藏信息,操作成功返回202状态")
    @RequestMapping(value = "/sysfilecollect-provider/sysfilecollect/del-sysfilecollect-real/{sysFileCollectId}", method = RequestMethod.POST)
    public Serializable deleteSysFileCollectReal(@PathVariable("sysFileCollectId") String sysFileCollectcId) {
        sysFileCollectService.deleteSysFileCollectReal(sysFileCollectcId);
        return DataOperationStatusEnum.DEL_OK;
    }

    /**
     * 增加菜单信息
     *
     * @param sysFileCollect
     * @return
     */
    @ApiOperation(value = "新增文件收藏信息", notes = "新增文件收藏信息,操作成功返回SysFileCollect类型对象")
    @RequestMapping(value = "/sysfilecollect-provider/sysfilecollect/add-sysfilecollect", method = RequestMethod.POST)
    public SysFileCollect insertSysFileCollect(@RequestBody SysFileCollect sysFileCollect) {
        sysFileCollect.setStatus("");
        return sysFileCollectService.insertObject(sysFileCollect);
    }

    /**
     * 分页查询
     *
     * @param jsonStr
     * @return
     */
    @ApiOperation(value = "查询文件收藏信息-分页", notes = "分页文件收藏信息,操作成功返回PageInfo<SysFileCollect>类型对象")
    @RequestMapping(value = "/sysfilecollect-provider/sysfilecollect/sysfilecollect-page")
    public JSONObject selectSysFileCollectByPage(@RequestParam(value = "jsonStr", required = false) String jsonStr) {
        PageInfo<SysFileCollect> pageInfo = null;
        try {
            pageInfo = sysFileCollectService.findSysFileCollectByPage(jsonStr);
        } catch (Exception e) {
            e.printStackTrace();
        }
        JSONObject retJson = new JSONObject();
        retJson.put("totalCount", pageInfo.getTotal());
        retJson.put("list", pageInfo.getList());
        return retJson;
    }
}
