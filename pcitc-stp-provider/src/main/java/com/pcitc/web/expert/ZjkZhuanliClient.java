package com.pcitc.web.expert;


import com.pcitc.base.common.LayuiTableData;
import com.pcitc.base.common.LayuiTableParam;
import com.pcitc.base.common.enums.DataOperationStatusEnum;
import com.pcitc.base.expert.ZjkZhuanli;
import com.pcitc.base.expert.ZjkZhuanliExample;
import com.pcitc.service.expert.ZjkZhuanliService;
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
 * <p>Table: zjk_zhuanli - 专家-专利信息</p>
 *
 * @since 2018-12-08 04:10:52
 */
@Api(value = "ZjkZhuanliClient-API", description = "专家-专利信息服务接口")
@RestController
public class ZjkZhuanliClient {
    private final static Logger logger = LoggerFactory.getLogger(ZjkZhuanliClient.class);

    @Autowired
    ZjkZhuanliService zjkZhuanliService;


    //参数查询
    @ApiOperation(value = "带参专家-专利信息查询列表", notes = "根据ID查询查询专家-专利信息信息,返回一个专家-专利信息的JSONObject对象")
    @RequestMapping(value = "/zjkzhuanli-provider/zjkzhuanli/zjkzhuanli_list_param", method = RequestMethod.POST)
    public JSONObject selectZjkZhuanliListParam(@RequestParam(value = "id", required = false) String id) {
        JSONObject retJson = new JSONObject();
        try {
            ZjkZhuanli zjkZhuanli = new ZjkZhuanli();
            zjkZhuanli.setId(id);
            List<ZjkZhuanli> list = zjkZhuanliService.findZjkZhuanliList(zjkZhuanli);
            retJson.put("list", list);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return retJson;
    }

    //对象查询,js需要JSON.stringify({id:"1"},转换之后,才能自动赋值
    @ApiOperation(value = "专家-专利信息查询列表", notes = "自定义对象(条件)查询专家-专利信息信息,返回存储在JSONObject对象中的专家-专利信息列表")
    @RequestMapping(value = "/zjkzhuanli-provider/zjkzhuanli/zjkzhuanli_list", method = RequestMethod.POST)
    public JSONObject selectZjkZhuanliList(@RequestBody ZjkZhuanli zjkZhuanli) {
        JSONObject retJson = new JSONObject();
        try {
            List<ZjkZhuanli> list = zjkZhuanliService.findZjkZhuanliList(zjkZhuanli);
            retJson.put("list", list);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return retJson;
    }


    @ApiOperation(value = "查询专家-专利信息树形详情信息", notes = "按ID查询专家-专利信息详情信息(带父ID),操作成功返回SysFileKind对象")
    @RequestMapping(value = "/zjkzhuanli-provider/zjkzhuanli/get-zjkzhuanli/{id}", method = RequestMethod.POST)
    public ZjkZhuanli getZjkZhuanliInfo(@PathVariable(value = "id", required = true) String id) {
        try {
            return zjkZhuanliService.getZjkZhuanliInfo(id);
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
    @ApiOperation(value = "查询(树)专家-专利信息信息", notes = "查询(树)专家-专利信息信息,操作成功返回List<TreeNode>对象")
    @RequestMapping(value = "/zjkzhuanli-provider/zjkzhuanli/tree-data")
    @ResponseBody
    public List selectObjectByTree() throws Exception {
        return zjkZhuanliService.selectObjectByTree();
    }


    /**
     * 删除专家-专利信息-false
     *
     * @param zjkZhuanlicId
     * @return
     */
    @ApiOperation(value = "伪删除专家-专利信息信息", notes = "按ID伪删除专家-专利信息信息,操作成功返回201")
    @RequestMapping(value = "/zjkzhuanli-provider/zjkzhuanli/del-zjkzhuanli/{zjkZhuanliId}")
    public Object deleteZjkZhuanli(@PathVariable("zjkZhuanliId") String zjkZhuanlicId) {
        return zjkZhuanliService.deleteZjkZhuanli(zjkZhuanlicId);
    }

    /**
     * 删除专家-专利信息-true
     *
     * @param zjkZhuanlicId
     * @return
     */
    @ApiOperation(value = "删除专家-专利信息信息", notes = "按ID删除专家-专利信息信息,操作成功返回201")
    @RequestMapping(value = "/zjkzhuanli-provider/zjkzhuanli/del-zjkzhuanli-real/{zjkZhuanliId}", method = RequestMethod.POST)
    public Object deleteZjkZhuanliReal(@PathVariable("zjkZhuanliId") String zjkZhuanlicId) {
        return zjkZhuanliService.deleteZjkZhuanliReal(zjkZhuanlicId);
    }


    /**
     * 分页查询
     *
     * @param param
     * @return
     */
    @ApiOperation(value = "查询专家-专利信息信息-分页查询", notes = "查询专家-专利信息信息-分页查询,Object")
    @RequestMapping(value = "/zjkzhuanli-provider/zjkzhuanli/zjkzhuanli-page")
    public Object selectZjkZhuanliByPage(@RequestBody LayuiTableParam param) {
        return zjkZhuanliService.findZjkZhuanliByPage(param);
    }

    /**
     * 保存
     *
     * @param zjkZhuanli
     * @return
     */
    @ApiOperation(value = "新增专家-专利信息信息", notes = "新增专家-专利信息信息,操作成功返回500")
    @RequestMapping(value = "/zjkzhuanli-provider/zjkzhuanli/save_zjkzhuanli", method = RequestMethod.POST)
    public int updateOrInsertZjkZhuanli(@RequestBody ZjkZhuanli zjkZhuanli) {
        try {
            return zjkZhuanliService.updateOrInsertZjkZhuanli(zjkZhuanli);
        } catch (Exception e) {
            logger.error("[保存信息失败：]", e);
        }
        return 500;
    }
}
