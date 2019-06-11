package com.pcitc.web.expert;


import com.pcitc.base.common.LayuiTableData;
import com.pcitc.base.common.LayuiTableParam;
import com.pcitc.base.common.enums.DataOperationStatusEnum;
import com.pcitc.base.expert.ZjkAchievement;
import com.pcitc.service.expert.ZjkChengguoService;
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
 * <p>Table: zjk_chengguo - 专家-成果信息</p>
 *
 * @since 2018-12-08 04:10:42
 */
@Api(value = "ZjkChengguoClient-API", description = "专家-成果信息服务接口")
@RestController
public class ZjkChengguoClient {
    private final static Logger logger = LoggerFactory.getLogger(ZjkChengguoClient.class);

    @Autowired
    ZjkChengguoService zjkChengguoService;


    //参数查询
    @ApiOperation(value = "带参专家-成果信息查询列表", notes = "根据ID查询查询专家-成果信息信息,返回一个专家-成果信息的JSONObject对象")
    @RequestMapping(value = "/zjkchengguo-provider/zjkchengguo/zjkchengguo_list_param", method = RequestMethod.POST)
    public JSONObject selectZjkChengguoListParam(@RequestParam(value = "id", required = false) String id) {
        JSONObject retJson = new JSONObject();
        try {
            ZjkAchievement zjkChengguo = new ZjkAchievement();
            zjkChengguo.setId(id);
            List<ZjkAchievement> list = zjkChengguoService.findZjkChengguoList(zjkChengguo);
            retJson.put("list", list);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return retJson;
    }

    //对象查询,js需要JSON.stringify({id:"1"},转换之后,才能自动赋值
    @ApiOperation(value = "专家-成果信息查询列表", notes = "自定义对象(条件)查询专家-成果信息信息,返回存储在JSONObject对象中的专家-成果信息列表")
    @RequestMapping(value = "/zjkchengguo-provider/zjkchengguo/zjkchengguo_list", method = RequestMethod.POST)
    public JSONObject selectZjkChengguoList(@RequestBody ZjkAchievement zjkChengguo) {
        JSONObject retJson = new JSONObject();
        try {
            List<ZjkAchievement> list = zjkChengguoService.findZjkChengguoList(zjkChengguo);
            retJson.put("list", list);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return retJson;
    }


    @ApiOperation(value = "查询专家-成果信息树形详情信息", notes = "按ID查询专家-成果信息详情信息(带父ID),操作成功返回SysFileKind对象")
    @RequestMapping(value = "/zjkchengguo-provider/zjkchengguo/get-zjkchengguo/{id}", method = RequestMethod.POST)
    public ZjkAchievement getZjkChengguoInfo(@PathVariable(value = "id", required = true) String id) {
        try {
            return zjkChengguoService.getZjkChengguoInfo(id);
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
    @ApiOperation(value = "查询(树)专家-成果信息信息", notes = "查询(树)专家-成果信息信息,操作成功返回List<TreeNode>对象")
    @RequestMapping(value = "/zjkchengguo-provider/zjkchengguo/tree-data")
    @ResponseBody
    public List selectObjectByTree() throws Exception {
        return zjkChengguoService.selectObjectByTree();
    }


    /**
     * 删除专家-成果信息-false
     *
     * @param zjkChengguocId
     * @return
     */
    @ApiOperation(value = "伪删除专家-成果信息信息", notes = "按ID伪删除专家-成果信息信息,操作成功返回201")
    @RequestMapping(value = "/zjkchengguo-provider/zjkchengguo/del-zjkchengguo/{zjkChengguoId}")
    public Object deleteZjkChengguo(@PathVariable("zjkChengguoId") String zjkChengguocId) {
        return zjkChengguoService.deleteZjkChengguo(zjkChengguocId);
    }

    /**
     * 删除专家-成果信息-true
     *
     * @param zjkChengguocId
     * @return
     */
    @ApiOperation(value = "删除专家-成果信息信息", notes = "按ID删除专家-成果信息信息,操作成功返回201")
    @RequestMapping(value = "/zjkchengguo-provider/zjkchengguo/del-zjkchengguo-real/{zjkChengguoId}", method = RequestMethod.POST)
    public Object deleteZjkChengguoReal(@PathVariable("zjkChengguoId") String zjkChengguocId) {
        return zjkChengguoService.deleteZjkChengguoReal(zjkChengguocId);
    }


    /**
     * 分页查询
     *
     * @param param
     * @return
     */
    @ApiOperation(value = "查询专家-成果信息信息-分页查询", notes = "查询专家-成果信息信息-分页查询,Object")
    @RequestMapping(value = "/zjkchengguo-provider/zjkchengguo/zjkchengguo-page")
    public Object selectZjkChengguoByPage(@RequestBody LayuiTableParam param) {
        return zjkChengguoService.findZjkChengguoByPage(param);
    }

    /**
     * 保存
     *
     * @param zjkChengguo
     * @return
     */
    @ApiOperation(value = "新增专家-成果信息信息", notes = "新增专家-成果信息信息,操作成功返回500")
    @RequestMapping(value = "/zjkchengguo-provider/zjkchengguo/save_zjkchengguo", method = RequestMethod.POST)
    public int updateOrInsertZjkChengguo(@RequestBody ZjkAchievement zjkChengguo) {
        try {
            return zjkChengguoService.updateOrInsertZjkChengguo(zjkChengguo);
        } catch (Exception e) {
            logger.error("[保存信息失败：]", e);
        }
        return 500;
    }
}
