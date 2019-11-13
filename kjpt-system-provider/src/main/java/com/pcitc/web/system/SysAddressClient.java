package com.pcitc.web.system;

import com.pcitc.base.common.LayuiTableData;
import com.pcitc.base.common.LayuiTableParam;
import com.pcitc.base.common.enums.DataOperationStatusEnum;
import com.pcitc.base.system.SysAddress;
import com.pcitc.base.system.SysAddressExample;
import com.pcitc.service.system.SysAddressService;
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
 * <p>Table: sys_address - 省市县地址表</p>
 *
 * @since 2019-02-14 11:01:09
 */
@Api(value = "SysAddressClient-API", description = "省市县地址表服务接口")
@RestController
public class SysAddressClient {
    private final static Logger logger = LoggerFactory.getLogger(SysAddressClient.class);

    @Autowired
    SysAddressService sysAddressService;

    //参数查询
    @ApiOperation(value = "带参省市县地址表查询列表", notes = "根据ID查询查询省市县地址表信息,返回一个省市县地址表的JSONObject对象")
    @RequestMapping(value = "/sysaddress-provider/sysaddress/sysaddress_list_param", method = RequestMethod.POST)
    public JSONObject selectSysAddressListParam(@RequestParam(value = "id", required = false) String id) {
        JSONObject retJson = new JSONObject();
        try {
            SysAddress sysAddress = new SysAddress();
            sysAddress.setId(id);
            List<SysAddress> list = sysAddressService.findSysAddressList(sysAddress);
            retJson.put("list", list);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return retJson;
    }

    //对象查询,js需要JSON.stringify({id:"1"},转换之后,才能自动赋值
    @ApiOperation(value = "省市县地址表查询列表", notes = "自定义对象(条件)查询省市县地址表信息,返回存储在JSONObject对象中的省市县地址表列表")
    @RequestMapping(value = "/sysaddress-provider/sysaddress/sysaddress_list", method = RequestMethod.POST)
    public JSONObject selectSysAddressList(@RequestBody SysAddress sysAddress) {
        JSONObject retJson = new JSONObject();
        try {
            List<SysAddress> list = sysAddressService.findSysAddressList(sysAddress);
            retJson.put("list", list);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return retJson;
    }

    @ApiOperation(value = "查询省市县地址表树形详情信息", notes = "按ID查询省市县地址表详情信息(带父ID),操作成功返回SysFileKind对象")
    @RequestMapping(value = "/sysaddress-provider/sysaddress/get-sysaddress/{id}", method = RequestMethod.POST)
    public SysAddress getSysAddressInfo(@PathVariable(value = "id", required = true) String id) {
        try {
            return sysAddressService.getSysAddressInfo(id);
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
    @ApiOperation(value = "查询(树)省市县地址表信息", notes = "查询(树)省市县地址表信息,操作成功返回List<TreeNode>对象")
    @RequestMapping(value = "/sysaddress-provider/sysaddress/tree-data")
    @ResponseBody
    public List selectObjectByTree() throws Exception {
        return sysAddressService.selectObjectByTree();
    }

    /**
     * 删除省市县地址表-false
     *
     * @param sysAddresscId
     * @return
     */
    @ApiOperation(value = "伪删除省市县地址表信息", notes = "按ID伪删除省市县地址表信息,操作成功返回201")
    @RequestMapping(value = "/sysaddress-provider/sysaddress/del-sysaddress/{sysAddressId}")
    public Object deleteSysAddress(@PathVariable("sysAddressId") String sysAddresscId) {
        return sysAddressService.deleteSysAddress(sysAddresscId);
    }

    /**
     * 删除省市县地址表-true
     *
     * @param sysAddresscId
     * @return
     */
    @ApiOperation(value = "删除省市县地址表信息", notes = "按ID删除省市县地址表信息,操作成功返回201")
    @RequestMapping(value = "/sysaddress-provider/sysaddress/del-sysaddress-real/{sysAddressId}", method = RequestMethod.POST)
    public Object deleteSysAddressReal(@PathVariable("sysAddressId") String sysAddresscId) {
        return sysAddressService.deleteSysAddressReal(sysAddresscId);
    }

    /**
     * 分页查询
     *
     * @param param
     * @return
     */
    @ApiOperation(value = "查询省市县地址表信息-分页查询", notes = "查询省市县地址表信息-分页查询,Object")
    @RequestMapping(value = "/sysaddress-provider/sysaddress/sysaddress-page")
    public Object selectSysAddressByPage(@RequestBody LayuiTableParam param) {
        return sysAddressService.findSysAddressByPage(param);
    }

    /**
     * 保存
     *
     * @param sysAddress
     * @return
     */
    @ApiOperation(value = "新增省市县地址表信息", notes = "新增省市县地址表信息,操作成功返回500")
    @RequestMapping(value = "/sysaddress-provider/sysaddress/save_sysaddress", method = RequestMethod.POST)
    public int updateOrInsertSysAddress(@RequestBody SysAddress sysAddress) {
        try {
            return sysAddressService.updateOrInsertSysAddress(sysAddress);
        } catch (Exception e) {
            logger.error("[保存信息失败：]", e);
        }
        return 500;
    }
}
