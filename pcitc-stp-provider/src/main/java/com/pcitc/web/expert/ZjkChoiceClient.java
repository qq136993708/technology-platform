package com.pcitc.web.expert;

import com.pcitc.base.common.LayuiTableData;
import com.pcitc.base.common.LayuiTableParam;
import com.pcitc.base.common.enums.DataOperationStatusEnum;
import com.pcitc.base.expert.ZjkChoice;
import com.pcitc.base.expert.ZjkChoiceExample;
import com.pcitc.service.expert.ZjkChoiceService;
import com.alibaba.fastjson.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * <p>服务接口</p>
 * <p>Table: zjk_choice - 专家-人员选择</p>
 *
 * @since 2018-12-08 04:10:47
 */
@Api(value = "ZjkChoiceClient-API", description = "专家-人员选择服务接口")
@RestController
public class ZjkChoiceClient {
    private final static Logger logger = LoggerFactory.getLogger(ZjkChoiceClient.class);

    @Autowired
    ZjkChoiceService zjkChoiceService;

    //参数查询
    @ApiOperation(value = "带参专家-人员选择查询列表", notes = "根据ID查询查询专家-人员选择信息,返回一个专家-人员选择的JSONObject对象")
    @RequestMapping(value = "/zjkchoice-provider/zjkchoice/zjkchoice_list_param", method = RequestMethod.POST)
    public JSONObject selectZjkChoiceListParam(@RequestParam(value = "id", required = false) String id) {
        JSONObject retJson = new JSONObject();
        try {
            ZjkChoice zjkChoice = new ZjkChoice();
            zjkChoice.setId(id);
            List<ZjkChoice> list = zjkChoiceService.findZjkChoiceList(zjkChoice);
            retJson.put("list", list);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return retJson;
    }

    //对象查询,js需要JSON.stringify({id:"1"},转换之后,才能自动赋值
    @ApiOperation(value = "专家-人员选择查询列表", notes = "自定义对象(条件)查询专家-人员选择信息,返回存储在JSONObject对象中的专家-人员选择列表")
    @RequestMapping(value = "/zjkchoice-provider/zjkchoice/zjkchoice_list", method = RequestMethod.POST)
    public JSONObject selectZjkChoiceList(@RequestBody ZjkChoice zjkChoice) {
        JSONObject retJson = new JSONObject();
        try {
            List<ZjkChoice> list = zjkChoiceService.findZjkChoiceList(zjkChoice);
            retJson.put("list", JSONObject.toJSON(list).toString());
            if (list != null && list.size() > 0) {
                retJson.put("baseList", JSONObject.toJSON(zjkChoiceService.findZjkBaseInofList(list.stream().map(ZjkChoice::getZjId).collect(Collectors.toList()))).toString());
            } else {
                retJson.put("baseList", new ArrayList<>());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return retJson;
    }

    @ApiOperation(value = "查询专家-人员选择树形详情信息", notes = "按ID查询专家-人员选择详情信息(带父ID),操作成功返回SysFileKind对象")
    @RequestMapping(value = "/zjkchoice-provider/zjkchoice/get-zjkchoice/{id}", method = RequestMethod.POST)
    public ZjkChoice getZjkChoiceInfo(@PathVariable(value = "id", required = true) String id) {
        try {
            return zjkChoiceService.getZjkChoiceInfo(id);
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
    @ApiOperation(value = "查询(树)专家-人员选择信息", notes = "查询(树)专家-人员选择信息,操作成功返回List<TreeNode>对象")
    @RequestMapping(value = "/zjkchoice-provider/zjkchoice/tree-data")
    @ResponseBody
    public List selectObjectByTree() throws Exception {
        return zjkChoiceService.selectObjectByTree();
    }

    /**
     * 删除专家-人员选择-false
     *
     * @param zjkChoicecId
     * @return
     */
    @ApiOperation(value = "伪删除专家-人员选择信息", notes = "按ID伪删除专家-人员选择信息,操作成功返回201")
    @RequestMapping(value = "/zjkchoice-provider/zjkchoice/del-zjkchoice/{zjkChoiceId}")
    public Object deleteZjkChoice(@PathVariable("zjkChoiceId") String zjkChoicecId) {
        return zjkChoiceService.deleteZjkChoice(zjkChoicecId);
    }

    /**
     * 删除专家-人员选择-true
     *
     * @param zjkChoicecId
     * @return
     */
    @ApiOperation(value = "删除专家-人员选择信息", notes = "按ID删除专家-人员选择信息,操作成功返回201")
    @RequestMapping(value = "/zjkchoice-provider/zjkchoice/del-zjkchoice-real/{zjkChoiceId}", method = RequestMethod.POST)
    public Object deleteZjkChoiceReal(@PathVariable("zjkChoiceId") String zjkChoicecId) {
        return zjkChoiceService.deleteZjkChoiceReal(zjkChoicecId);
    }

    /**
     * 分页查询
     *
     * @param param
     * @return
     */
    @ApiOperation(value = "查询专家-人员选择信息-分页查询", notes = "查询专家-人员选择信息-分页查询,Object")
    @RequestMapping(value = "/zjkchoice-provider/zjkchoice/zjkchoice-page")
    public Object selectZjkChoiceByPage(@RequestBody LayuiTableParam param) {
        return zjkChoiceService.findZjkChoiceByPage(param);
    }

    /**
     * 分页查询
     *
     * @param param
     * @return
     */
    @ApiOperation(value = "查询专家-人员选择信息-分页查询", notes = "查询专家-人员选择信息-分页查询,Object")
    @RequestMapping(value = "/zjkchoice-provider/zjkchoice/getListChoice")
    public LayuiTableData getListChoice(@RequestBody LayuiTableParam param) throws Exception {
        return zjkChoiceService.getListChoice(param);
    }

    @ApiOperation(value = "查询专家-人员选择信息-分页查询", notes = "查询专家-人员选择信息-分页查询,Object")
    @RequestMapping(value = "/zjkchoice-provider/zjkchoice/zjkchoice-page-choice")
    public Object selectZjkChoiceByPageChoice(@RequestBody LayuiTableParam param) {
        return zjkChoiceService.findZjkChoiceByPageChoice(param);
    }

    /**
     * 保存
     *
     * @param zjkChoice
     * @return
     */
    @ApiOperation(value = "新增专家-人员选择信息", notes = "新增专家-人员选择信息,操作成功返回500")
    @RequestMapping(value = "/zjkchoice-provider/zjkchoice/save_zjkchoice", method = RequestMethod.POST)
    public int updateOrInsertZjkChoice(@RequestBody ZjkChoice zjkChoice) {
        try {
            return zjkChoiceService.updateOrInsertZjkChoice(zjkChoice);
        } catch (Exception e) {
            logger.error("[保存信息失败：]", e);
        }
        return 500;
    }

    /**
     * 保存
     *
     * @param zjkChoice
     * @return
     */
    @ApiOperation(value = "新增专家-人员选择信息", notes = "新增专家-人员选择信息,操作成功返回500")
    @RequestMapping(value = "/zjkchoice-provider/zjkchoice/save_zjkchoice_update", method = RequestMethod.POST)
    public int updateOrInsertZjkChoiceUpdate(@RequestBody ZjkChoice zjkChoice) {
        try {
            return zjkChoiceService.updateOrInsertZjkChoiceUpdate(zjkChoice);
        } catch (Exception e) {
            logger.error("[保存信息失败：]", e);
        }
        return 500;
    }

    @ApiOperation(value = "新增专家-人员选择信息", notes = "新增专家-人员选择信息,操作成功返回500")
    @RequestMapping(value = "/zjkchoice-provider/zjkchoice/save_zjkchoice_bat", method = RequestMethod.POST)
    public int updateOrInsertZjkChoiceUpdateBat(@RequestBody JSONObject jsonObject) {
        try {
            return zjkChoiceService.updateOrInsertZjkChoiceUpdateBat(jsonObject);
        } catch (Exception e) {
            logger.error("[保存信息失败：]", e);
        }
        return 500;
    }

    @ApiOperation(value = "删除专家-人员选择信息", notes = "按专家ID删除专家-人员选择信息,操作成功返回201")
    @RequestMapping(value = "/zjkchoice-provider/zjkchoice/del-zjkchoice-zjid", method = RequestMethod.POST)
    public Object deleteZjkChoiceRealByZjId(@RequestBody JSONObject jsonObject) {
        Object o = null;
        try {
            ZjkChoiceExample ex = new ZjkChoiceExample();
            ex.createCriteria().andZjIdEqualTo(jsonObject.get("expertId").toString());
            ex.createCriteria().andAddUserIdEqualTo(jsonObject.get("addUserId").toString());
            o = zjkChoiceService.deleteByExample(ex);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            return o;
        }
    }

    /**
     * 专家选择
     *
     * @param param
     * @return
     */
    @ApiOperation(value = "查询专家-人员选择信息", notes = "查询专家-人员选择专家信息")
    @RequestMapping(value = "/zjkchoice-provider/zjkchoice/select_expert")
    public LayuiTableData getUserChoiceTableData(@RequestBody LayuiTableParam param) {
        return zjkChoiceService.getUserChoiceTableData(param);
    }


    @RequestMapping(value = "/zjkchoice-provider/zjkchoice/selectByExample", method = RequestMethod.POST)
    public JSONObject selectByExample(@RequestBody JSONObject jsonObject) {
        JSONObject object = new JSONObject();
        List<String> ids = (List<String>) jsonObject.get("list");
        if(ids==null||ids.size()==0){
            ids.add("");
        }
        ZjkChoiceExample zjkChoiceExample = new ZjkChoiceExample();
        zjkChoiceExample.createCriteria().andXmIdIn(ids);
        List<ZjkChoice> zjkChoices = zjkChoiceService.selectByExample(zjkChoiceExample);
        object.put("list", zjkChoices == null || zjkChoices.size() == 0 ? new ArrayList<>() : zjkChoices);
        return object;
    }
}
