package com.pcitc.web.expert;

import com.alibaba.fastjson.JSONObject;
import com.pcitc.base.common.LayuiTableParam;
import com.pcitc.base.expert.ZjkAchievement;
import com.pcitc.service.expert.ZjkAchievementService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * <p>服务接口</p>
 * <p>Table: zjk_achievement - 专家-成果信息</p>
 *
 * @since 2019-06-21 09:57:54
 */
@Api(value = "ZjkAchievementClient-API", description = "专家-成果信息服务接口")
@RestController
public class ZjkAchievementClient {
    private final static Logger logger = LoggerFactory.getLogger(ZjkAchievementClient.class);

    @Autowired
    ZjkAchievementService zjkAchievementService;

    //参数查询
    @ApiOperation(value = "带参专家-成果信息查询列表", notes = "根据ID查询查询专家-成果信息信息,返回一个专家-成果信息的JSONObject对象")
    @RequestMapping(value = "/zjkachievement-provider/zjkachievement/zjkachievement_list_param", method = RequestMethod.POST)
    public JSONObject selectZjkAchievementListParam(@RequestParam(value = "id", required = false) String id) {
        JSONObject retJson = new JSONObject();
        try {
            ZjkAchievement zjkAchievement = new ZjkAchievement();
            zjkAchievement.setId(id);
            List<ZjkAchievement> list = zjkAchievementService.findZjkAchievementList(zjkAchievement);
            retJson.put("list", list);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return retJson;
    }

    //对象查询,js需要JSON.stringify({id:"1"},转换之后,才能自动赋值
    @ApiOperation(value = "专家-成果信息查询列表", notes = "自定义对象(条件)查询专家-成果信息信息,返回存储在JSONObject对象中的专家-成果信息列表")
    @RequestMapping(value = "/zjkachievement-provider/zjkachievement/zjkachievement_list", method = RequestMethod.POST)
    public JSONObject selectZjkAchievementList(@RequestBody ZjkAchievement zjkAchievement) {
        JSONObject retJson = new JSONObject();
        try {
            List<ZjkAchievement> list = zjkAchievementService.findZjkAchievementList(zjkAchievement);
            retJson.put("list", list);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return retJson;
    }

    @ApiOperation(value = "查询专家-成果信息树形详情信息", notes = "按ID查询专家-成果信息详情信息(带父ID),操作成功返回SysFileKind对象")
    @RequestMapping(value = "/zjkachievement-provider/zjkachievement/get-zjkachievement/{id}", method = RequestMethod.POST)
    public ZjkAchievement getZjkAchievementInfo(@PathVariable(value = "id", required = true) String id) {
        try {
            return zjkAchievementService.getZjkAchievementInfo(id);
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
    @RequestMapping(value = "/zjkachievement-provider/zjkachievement/tree-data")
    @ResponseBody
    public List selectObjectByTree() throws Exception {
        return zjkAchievementService.selectObjectByTree();
    }

    /**
     * 删除专家-成果信息-false
     *
     * @param zjkAchievementcId
     * @return
     */
    @ApiOperation(value = "伪删除专家-成果信息信息", notes = "按ID伪删除专家-成果信息信息,操作成功返回201")
    @RequestMapping(value = "/zjkachievement-provider/zjkachievement/del-zjkachievement/{zjkAchievementId}")
    public Object deleteZjkAchievement(@PathVariable("zjkAchievementId") String zjkAchievementcId) {
        return zjkAchievementService.deleteZjkAchievement(zjkAchievementcId);
    }

    /**
     * 删除专家-成果信息-true
     *
     * @param zjkAchievementcId
     * @return
     */
    @ApiOperation(value = "删除专家-成果信息信息", notes = "按ID删除专家-成果信息信息,操作成功返回201")
    @RequestMapping(value = "/zjkachievement-provider/zjkachievement/del-zjkachievement-real/{zjkAchievementId}", method = RequestMethod.POST)
    public Object deleteZjkAchievementReal(@PathVariable("zjkAchievementId") String zjkAchievementcId) {
        return zjkAchievementService.deleteZjkAchievementReal(zjkAchievementcId);
    }

    /**
     * 分页查询
     *
     * @param param
     * @return
     */
    @ApiOperation(value = "查询专家-成果信息信息-分页查询", notes = "查询专家-成果信息信息-分页查询,Object")
    @RequestMapping(value = "/zjkachievement-provider/zjkachievement/zjkachievement-page")
    public Object selectZjkAchievementByPage(@RequestBody LayuiTableParam param) {
        return zjkAchievementService.findZjkAchievementByPage(param);
    }

    /**
     * 保存
     *
     * @param zjkAchievement
     * @return
     */
    @ApiOperation(value = "新增专家-成果信息信息", notes = "新增专家-成果信息信息,操作成功返回500")
    @RequestMapping(value = "/zjkachievement-provider/zjkachievement/save_zjkachievement", method = RequestMethod.POST)
    public int updateOrInsertZjkAchievement(@RequestBody ZjkAchievement zjkAchievement) {
        try {
            return zjkAchievementService.updateOrInsertZjkAchievement(zjkAchievement);
        } catch (Exception e) {
            logger.error("[保存信息失败：]", e);
        }
        return 500;
    }
}
