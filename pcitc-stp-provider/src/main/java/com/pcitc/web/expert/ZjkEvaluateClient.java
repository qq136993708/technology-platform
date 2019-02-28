package com.pcitc.web.expert;

import com.pcitc.base.common.LayuiTableData;
import com.pcitc.base.common.LayuiTableParam;
import com.pcitc.base.common.enums.DataOperationStatusEnum;
import com.pcitc.base.expert.ZjkEvaluate;
import com.pcitc.base.expert.ZjkEvaluateExample;
import com.pcitc.service.expert.ZjkEvaluateService;
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
 * <p>Table: zjk_evaluate - 专家库-专家评价</p>
 *
 * @since 2019-02-28 02:27:36
 */
@Api(value = "ZjkEvaluateClient-API", description = "专家库-专家评价服务接口")
@RestController
public class ZjkEvaluateClient {
    private final static Logger logger = LoggerFactory.getLogger(ZjkEvaluateClient.class);

    @Autowired
    ZjkEvaluateService zjkEvaluateService;

    //参数查询
    @ApiOperation(value = "带参专家库-专家评价查询列表", notes = "根据ID查询查询专家库-专家评价信息,返回一个专家库-专家评价的JSONObject对象")
    @RequestMapping(value = "/zjkevaluate-provider/zjkevaluate/zjkevaluate_list_param", method = RequestMethod.POST)
    public JSONObject selectZjkEvaluateListParam(@RequestParam(value = "id", required = false) String id) {
        JSONObject retJson = new JSONObject();
        try {
            ZjkEvaluate zjkEvaluate = new ZjkEvaluate();
            zjkEvaluate.setId(id);
            List<ZjkEvaluate> list = zjkEvaluateService.findZjkEvaluateList(zjkEvaluate);
            retJson.put("list", list);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return retJson;
    }

    //对象查询,js需要JSON.stringify({id:"1"},转换之后,才能自动赋值
    @ApiOperation(value = "专家库-专家评价查询列表", notes = "自定义对象(条件)查询专家库-专家评价信息,返回存储在JSONObject对象中的专家库-专家评价列表")
    @RequestMapping(value = "/zjkevaluate-provider/zjkevaluate/zjkevaluate_list", method = RequestMethod.POST)
    public JSONObject selectZjkEvaluateList(@RequestBody ZjkEvaluate zjkEvaluate) {
        JSONObject retJson = new JSONObject();
        try {
            List<ZjkEvaluate> list = zjkEvaluateService.findZjkEvaluateList(zjkEvaluate);
            retJson.put("list", list);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return retJson;
    }

    @ApiOperation(value = "查询专家库-专家评价树形详情信息", notes = "按ID查询专家库-专家评价详情信息(带父ID),操作成功返回SysFileKind对象")
    @RequestMapping(value = "/zjkevaluate-provider/zjkevaluate/get-zjkevaluate/{id}", method = RequestMethod.POST)
    public ZjkEvaluate getZjkEvaluateInfo(@PathVariable(value = "id", required = true) String id) {
        try {
            return zjkEvaluateService.getZjkEvaluateInfo(id);
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
    @ApiOperation(value = "查询(树)专家库-专家评价信息", notes = "查询(树)专家库-专家评价信息,操作成功返回List<TreeNode>对象")
    @RequestMapping(value = "/zjkevaluate-provider/zjkevaluate/tree-data")
    @ResponseBody
    public List selectObjectByTree() throws Exception {
        return zjkEvaluateService.selectObjectByTree();
    }

    /**
     * 删除专家库-专家评价-false
     *
     * @param zjkEvaluatecId
     * @return
     */
    @ApiOperation(value = "伪删除专家库-专家评价信息", notes = "按ID伪删除专家库-专家评价信息,操作成功返回201")
    @RequestMapping(value = "/zjkevaluate-provider/zjkevaluate/del-zjkevaluate/{zjkEvaluateId}")
    public Object deleteZjkEvaluate(@PathVariable("zjkEvaluateId") String zjkEvaluatecId) {
        return zjkEvaluateService.deleteZjkEvaluate(zjkEvaluatecId);
    }

    /**
     * 删除专家库-专家评价-true
     *
     * @param zjkEvaluatecId
     * @return
     */
    @ApiOperation(value = "删除专家库-专家评价信息", notes = "按ID删除专家库-专家评价信息,操作成功返回201")
    @RequestMapping(value = "/zjkevaluate-provider/zjkevaluate/del-zjkevaluate-real/{zjkEvaluateId}", method = RequestMethod.POST)
    public Object deleteZjkEvaluateReal(@PathVariable("zjkEvaluateId") String zjkEvaluatecId) {
        return zjkEvaluateService.deleteZjkEvaluateReal(zjkEvaluatecId);
    }

    /**
     * 分页查询
     *
     * @param param
     * @return
     */
    @ApiOperation(value = "查询专家库-专家评价信息-分页查询", notes = "查询专家库-专家评价信息-分页查询,Object")
    @RequestMapping(value = "/zjkevaluate-provider/zjkevaluate/zjkevaluate-page")
    public Object selectZjkEvaluateByPage(@RequestBody LayuiTableParam param) {
        return zjkEvaluateService.findZjkEvaluateByPage(param);
    }

    /**
     * 保存
     *
     * @param zjkEvaluate
     * @return
     */
    @ApiOperation(value = "新增专家库-专家评价信息", notes = "新增专家库-专家评价信息,操作成功返回500")
    @RequestMapping(value = "/zjkevaluate-provider/zjkevaluate/save_zjkevaluate", method = RequestMethod.POST)
    public int updateOrInsertZjkEvaluate(@RequestBody ZjkEvaluate zjkEvaluate) {
        try {
            return zjkEvaluateService.updateOrInsertZjkEvaluate(zjkEvaluate);
        } catch (Exception e) {
            logger.error("[保存信息失败：]", e);
        }
        return 500;
    }
}
