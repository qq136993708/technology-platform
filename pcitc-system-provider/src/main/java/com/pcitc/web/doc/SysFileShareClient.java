package com.pcitc.web.doc;


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
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSONObject;
import com.pcitc.base.common.LayuiTableParam;
import com.pcitc.base.doc.SysFileShare;
import com.pcitc.service.doc.SysFileShareService;
import com.pcitc.service.system.SysFileService;


/**
 * <p>服务接口</p>
 * <p>Table: sys_file_share - 文件分享信息</p>
 *
 * @since 2018-06-19 03:58:11
 */
@Api(value = "SysFileShareClient-API", description = "文件分享服务接口")
@RestController
public class SysFileShareClient {
    private final static Logger logger = LoggerFactory.getLogger(SysFileShareClient.class);

    @Autowired
    SysFileShareService sysFileShareService;
    
    @Autowired
    SysFileService sysFileService;


    //参数查询
    @ApiOperation(value = "带参文件分享查询列表", notes = "根据文件ID查询查询文件分享信息,返回一个文件分享的JSONObject对象")
    @RequestMapping(value = "/sysfileshare-provider/sysfileshare/sysfileshare_list_param", method = RequestMethod.POST)
    public JSONObject selectSysFileShareListParam(@RequestParam(value = "id", required = false) String id) {
        JSONObject retJson = new JSONObject();
        try {
            SysFileShare sysFileShare = new SysFileShare();
            sysFileShare.setId(id);
            List<SysFileShare> list = sysFileShareService.findSysFileShareList(sysFileShare);
            retJson.put("list", list);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return retJson;
    }

    //对象查询,js需要JSON.stringify({id:"1"},转换之后,才能自动赋值
    @ApiOperation(value = "文件分享查询列表", notes = "自定义对象(条件)查询文件分享信息,返回存储在JSONObject对象中的文件分享列表")
    @RequestMapping(value = "/sysfileshare-provider/sysfileshare/sysfileshare_list", method = RequestMethod.POST)
    public JSONObject selectSysFileShareList(@RequestBody SysFileShare sysFileShare) {
        JSONObject retJson = new JSONObject();
        try {
            List<SysFileShare> list = sysFileShareService.findSysFileShareList(sysFileShare);
            retJson.put("list", list);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return retJson;
    }

    @ApiOperation(value = "更新文件收藏", notes = "更新文件收藏,操作成功返回500")
    @RequestMapping(value = "/sysfileshare-provider/sysfileshare/save_sysfileshare", method = RequestMethod.POST)
    public int updateOrInsertSysFileShare(@RequestBody SysFileShare sysFileShare) {
        try {
            return sysFileShareService.updateOrInsertSysFileShare(sysFileShare);
        } catch (Exception e) {
            logger.error("[保存信息失败：]", e);
        }
        return 500;
    }

    @ApiOperation(value = "新增文件分享信息", notes = "新增文件分享信息,操作成功返回SysFileCollect类型对象")
    @RequestMapping(value = "/sysfileshare-provider/sysfileshare/save_sysfileshare_file", method = RequestMethod.POST)
    public int saveSysFileShare(@RequestBody SysFileShare sysFileShare) {
        try {
            sysFileShareService.saveSysFileShare(sysFileShare);
        } catch (Exception e) {
            logger.error("[保存信息失败：]", e);
        }
        return 500;
    }
    @ApiOperation(value = "删除文件分享信息", notes = "根据ID删除文件分享信息,操作成功返回202状态")
    @RequestMapping(value = "/sysfileshare-provider/sysfileshare/delete_sysfileshare/{id}", method = RequestMethod.POST)
    public int deleteSysFileShareById(@PathVariable(value = "id", required = true) String id) {
        try {
            return sysFileShareService.deleteSysFileShareById(id);
        } catch (Exception e) {
            logger.error("[删除信息失败：]", e);
        }
        return 500;
    }

    @ApiOperation(value = "查询文件分享树形详情信息", notes = "按ID查询文件分享详情信息(带父ID),操作成功返回SysFileCollect对象")
    @RequestMapping(value = "/sysfileshare-provider/sysfileshare/get-sysfileshare/{id}", method = RequestMethod.POST)
    public SysFileShare getSysFileShareInfo(@PathVariable(value = "id", required = true) String id) {
        try {
            return sysFileShareService.getSysFileShareInfo(id);
        } catch (Exception e) {
            logger.error("[初始化信息失败：]", e);
        }
        return null;
    }
    
    /**
	 * 获取文件历史版本
	 * 
	 * @author zhf
	 * @date 2019年3月3日 下午2:09:43
	 */
	@ApiOperation(value = "获取文件历史版本信息", notes = "查询sys_file_version表，无主键")
	@RequestMapping(value = "/sysfileshare-provider/sysfileshare/file/history/list", method = RequestMethod.POST)
	public Object selectFileHistoryList(@RequestBody LayuiTableParam param) {
		// System.out.println("1selectDelegateByPage==============查询的是某个人的委托单，不是所有人的委托单");
		Object tem = sysFileService.selectFileHistoryList(param);
		return tem;
	}

//
//    /**
//     * 获取菜单---节点树形展示
//     *
//     * @return
//     * @throws Exception
//     */
//    @RequestMapping(value = "/sysfileshare-provider/sysfileshare/tree-data")
//    @ResponseBody
//    public List selectObjectByTree() throws Exception {
//        return sysFileShareService.selectObjectByTree();
//    }
//
//    /**
//     * 查询菜单相信信息-展示
//     *
//     * @param sysFileShareId
//     * @return
//     * @throws Exception
//     */
//    @RequestMapping(value = "/sysfileshare-provider/sysfileshare/get_sysfileshare/{sysFileShareId}")
//    public SysFileShare selectSysFileShareByMenuId(@PathVariable(value = "sysFileShareId", required = true) String sysFileShareId) throws Exception {
//        SysFileShare sysFileShare = sysFileShareService.selectByPrimaryKey(sysFileShareId);
//        if ("".equals(sysFileShare.getParentId().trim())) {
//            sysFileShare.setParentName("");
//        } else {
//        }
//        SysFileShareExample sysFileShareExample = new SysFileShareExample();
//        String strParentId = sysFileShareService.selectByExample(sysFileShareExample).get(0).getId();
//        sysFileShare.setRootId(strParentId);
//        return sysFileShare;
//    }
//
//    /**
//     * 更新菜单信息
//     *
//     * @param sysFileShare
//     * @return
//     */
//    @RequestMapping(value = "/sysfileshare-provider/sysfileshare/update-sysfileshare")
//    public Serializable updateSysFileShare(@RequestBody SysFileShare sysFileShare) {
//        sysFileShareService.updateByPrimaryKey(sysFileShare);
//        DataOperationStatusEnum status = DataOperationStatusEnum.UPD_OK;
//        return status;
//    }
//
//    /**
//     * 删除菜单信息-false
//     *
//     * @param sysFileSharecId
//     * @return
//     */
//    @RequestMapping(value = "/sysfileshare-provider/sysfileshare/del-sysfileshare/{sysFileShareId}")
//    public Serializable deleteSysFileShare(@PathVariable("sysFileShareId") String sysFileSharecId) {
//        DataOperationStatusEnum status = sysFileShareService.deleteSysFileShare(sysFileSharecId);
//        return status;
//    }
//
//    /**
//     * 删除菜单信息-true
//     *
//     * @param sysFileSharecId
//     * @return
//     */
//    @RequestMapping(value = "/sysfileshare-provider/sysfileshare/del-sysfileshare-real/{sysFileShareId}", method = RequestMethod.POST)
//    public Serializable deleteSysFileShareReal(@PathVariable("sysFileShareId") String sysFileSharecId) {
//        sysFileShareService.deleteSysFileShareReal(sysFileSharecId);
//        return DataOperationStatusEnum.DEL_OK;
//    }
//
//    /**
//     * 增加菜单信息
//     *
//     * @param sysFileShare
//     * @return
//     */
//    @RequestMapping(value = "/sysfileshare-provider/sysfileshare/add-sysfileshare", method = RequestMethod.POST)
//    public SysFileShare insertSysFileShare(@RequestBody SysFileShare sysFileShare) {
//        sysFileShare.setStatus("");
//        return sysFileShareService.insertObject(sysFileShare);
//    }
//
//    /**
//     * 分页查询
//     *
//     * @param jsonStr
//     * @return
//     */
//    @RequestMapping(value = "/sysfileshare-provider/sysfileshare/sysfileshare-page")
//    public JSONObject selectSysFileShareByPage(@RequestParam(value = "jsonStr", required = false) String jsonStr) {
//        PageInfo<SysFileShare> pageInfo = null;
//        try {
//            pageInfo = sysFileShareService.findSysFileShareByPage(jsonStr);
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        JSONObject retJson = new JSONObject();
//        retJson.put("totalCount", pageInfo.getTotal());
//        retJson.put("list", pageInfo.getList());
//        return retJson;
//    }
}
