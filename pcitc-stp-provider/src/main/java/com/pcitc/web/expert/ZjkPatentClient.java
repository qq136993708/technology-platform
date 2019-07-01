package com.pcitc.web.expert;

import com.alibaba.fastjson.JSONObject;
import com.pcitc.base.common.LayuiTableParam;
import com.pcitc.base.expert.ZjkPatent;
import com.pcitc.service.expert.ZjkPatentService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * <p>服务接口</p>
 * <p>Table: zjk_patent - 专家-专利信息</p>
 *
 * @since 2019-06-21 09:32:24
 */
@Api(value = "ZjkPatentClient-API", description = "专家-专利信息服务接口")
@RestController
public class ZjkPatentClient {
    private final static Logger logger = LoggerFactory.getLogger(ZjkPatentClient.class);

    @Autowired
    ZjkPatentService zjkPatentService;

    //参数查询
    @ApiOperation(value = "带参专家-专利信息查询列表", notes = "根据ID查询查询专家-专利信息信息,返回一个专家-专利信息的JSONObject对象")
    @RequestMapping(value = "/zjkpatent-provider/zjkpatent/zjkpatent_list_param", method = RequestMethod.POST)
    public JSONObject selectZjkPatentListParam(@RequestParam(value = "id", required = false) String id) {
        JSONObject retJson = new JSONObject();
        try {
            ZjkPatent zjkPatent = new ZjkPatent();
            zjkPatent.setId(id);
            List<ZjkPatent> list = zjkPatentService.findZjkPatentList(zjkPatent);
            retJson.put("list", list);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return retJson;
    }

    //对象查询,js需要JSON.stringify({id:"1"},转换之后,才能自动赋值
    @ApiOperation(value = "专家-专利信息查询列表", notes = "自定义对象(条件)查询专家-专利信息信息,返回存储在JSONObject对象中的专家-专利信息列表")
    @RequestMapping(value = "/zjkpatent-provider/zjkpatent/zjkpatent_list", method = RequestMethod.POST)
    public JSONObject selectZjkPatentList(@RequestBody ZjkPatent zjkPatent) {
        JSONObject retJson = new JSONObject();
        try {
            List<ZjkPatent> list = zjkPatentService.findZjkPatentList(zjkPatent);
            retJson.put("list", list);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return retJson;
    }

    @ApiOperation(value = "查询专家-专利信息树形详情信息", notes = "按ID查询专家-专利信息详情信息(带父ID),操作成功返回SysFileKind对象")
    @RequestMapping(value = "/zjkpatent-provider/zjkpatent/get-zjkpatent/{id}", method = RequestMethod.POST)
    public ZjkPatent getZjkPatentInfo(@PathVariable(value = "id", required = true) String id) {
        try {
            return zjkPatentService.getZjkPatentInfo(id);
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
    @RequestMapping(value = "/zjkpatent-provider/zjkpatent/tree-data")
    @ResponseBody
    public List selectObjectByTree() throws Exception {
        return zjkPatentService.selectObjectByTree();
    }

    /**
     * 删除专家-专利信息-false
     *
     * @param zjkPatentcId
     * @return
     */
    @ApiOperation(value = "伪删除专家-专利信息信息", notes = "按ID伪删除专家-专利信息信息,操作成功返回201")
    @RequestMapping(value = "/zjkpatent-provider/zjkpatent/del-zjkpatent/{zjkPatentId}")
    public Object deleteZjkPatent(@PathVariable("zjkPatentId") String zjkPatentcId) {
        return zjkPatentService.deleteZjkPatent(zjkPatentcId);
    }

    /**
     * 删除专家-专利信息-true
     *
     * @param zjkPatentcId
     * @return
     */
    @ApiOperation(value = "删除专家-专利信息信息", notes = "按ID删除专家-专利信息信息,操作成功返回201")
    @RequestMapping(value = "/zjkpatent-provider/zjkpatent/del-zjkpatent-real/{zjkPatentId}", method = RequestMethod.POST)
    public Object deleteZjkPatentReal(@PathVariable("zjkPatentId") String zjkPatentcId) {
        return zjkPatentService.deleteZjkPatentReal(zjkPatentcId);
    }

    /**
     * 分页查询
     *
     * @param param
     * @return
     */
    @ApiOperation(value = "查询专家-专利信息信息-分页查询", notes = "查询专家-专利信息信息-分页查询,Object")
    @RequestMapping(value = "/zjkpatent-provider/zjkpatent/zjkpatent-page")
    public Object selectZjkPatentByPage(@RequestBody LayuiTableParam param) {
        return zjkPatentService.findZjkPatentByPage(param);
    }

    /**
     * 保存
     *
     * @param zjkPatent
     * @return
     */
    @ApiOperation(value = "新增专家-专利信息信息", notes = "新增专家-专利信息信息,操作成功返回500")
    @RequestMapping(value = "/zjkpatent-provider/zjkpatent/save_zjkpatent", method = RequestMethod.POST)
    public int updateOrInsertZjkPatent(@RequestBody ZjkPatent zjkPatent) {
        try {
            return zjkPatentService.updateOrInsertZjkPatent(zjkPatent);
        } catch (Exception e) {
            logger.error("[保存信息失败：]", e);
        }
        return 500;
    }
}
