package com.pcitc.web.doc;


import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

import java.io.Serializable;
import java.util.HashMap;
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
import com.pcitc.base.common.LayuiTableData;
import com.pcitc.base.common.LayuiTableParam;
import com.pcitc.base.common.TreeNode;
import com.pcitc.base.common.enums.DataOperationStatusEnum;
import com.pcitc.base.doc.SysFileKind;
import com.pcitc.base.doc.SysFileKindAuth;
import com.pcitc.base.system.SysUnit;
import com.pcitc.service.doc.SysFileKindService;


/**
 * <p>服务接口</p>
 * <p>Table: sys_file_kind - </p>
 *
 * @since 2018-06-19 09:24:12
 */
@Api(value = "SysFileKindClient-API", description = "文件种类服务接口")
@RestController
public class SysFileKindClient {
    private final static Logger logger = LoggerFactory.getLogger(SysFileKindClient.class);

    @Autowired
    SysFileKindService sysFileKindService;


    @ApiOperation(value = "带参文件种类查询列表", notes = "根据文件ID查询查询文件种类信息,返回一个文件种类的JSONObject对象")
    @RequestMapping(value = "/sysfilekind-provider/sysfilekind/sysfilekind_list_param", method = RequestMethod.POST)
    public JSONObject selectSysFileKindListParam(@RequestParam(value = "id", required = false) String id) {
        JSONObject retJson = new JSONObject();
        try {
            SysFileKind sysFileKind = new SysFileKind();
            sysFileKind.setId(id);
            List<SysFileKind> list = sysFileKindService.findSysFileKindList(sysFileKind);
            retJson.put("list", list);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return retJson;
    }

    //对象查询,js需要JSON.stringify({id:"1"},转换之后,才能自动赋值
    @ApiOperation(value = "文件种类查询列表", notes = "自定义对象(条件)查询文件种类信息,返回存储在JSONObject对象中的文件种类列表")
    @RequestMapping(value = "/sysfilekind-provider/sysfilekind/sysfilekind_list", method = RequestMethod.POST)
    public JSONObject selectSysFileKindList(@RequestBody SysFileKind sysFileKind) {
        JSONObject retJson = new JSONObject();
        try {
            List<SysFileKind> list = sysFileKindService.findSysFileKindList(sysFileKind);
            retJson.put("list", list);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return retJson;
    }

    @ApiOperation(value = "新增文件种类信息", notes = "新增文件种类信息,操作成功返回SysFileCollect类型对象")
    @RequestMapping(value = "/sysfilekind-provider/sysfilekind/save_sysfilekind", method = RequestMethod.POST)
    public int updateOrInsertSysFileKind(@RequestBody SysFileKind sysFileKind) {
        try {
            return sysFileKindService.updateOrInsertSysFileKind(sysFileKind);
        } catch (Exception e) {
            logger.error("[保存信息失败：]", e);
        }
        return 500;
    }
    @ApiOperation(value = "删除文件种类信息", notes = "根据ID删除文件种类信息,操作成功返回202状态")
    @RequestMapping(value = "/sysfilekind-provider/sysfilekind/delete_sysfilekind/{id}", method = RequestMethod.POST)
    public int deleteSysFileKindById(@PathVariable(value = "id", required = true) String id) {
        try {
            return sysFileKindService.deleteSysFileKindById(id);
        } catch (Exception e) {
            logger.error("[删除信息失败：]", e);
        }
        return 500;
    }
    @ApiOperation(value = "查询文件种类树形详情信息", notes = "按ID查询文件种类详情信息(带父ID),操作成功返回SysFileCollect对象")
    @RequestMapping(value = "/sysfilekind-provider/sysfilekind/get-sysfilekind/{id}", method = RequestMethod.POST)
    public SysFileKind getSysFileKindInfo(@PathVariable(value = "id", required = true) String id) {
        try {
            SysFileKind sysFileKind = sysFileKindService.getSysFileKindInfo(id);
            if(sysFileKind==null||"0".equals(sysFileKind.getStatus())){
                sysFileKind=null;
            }
            return sysFileKind;
        } catch (Exception e) {
            logger.error("[初始化信息失败：]", e);
        }
        return null;
    }


    /**
     * 获取菜单---节点树形展示
     *
     * @return
     * @throws Exception
     */
    @ApiOperation(value = "查询(树)文件种类信息", notes = "查询(树)文件种类信息,操作成功返回List<TreeNode>对象")
    @RequestMapping(value = "/sysfilekind-provider/sysfilekind/tree-data")
    public List<TreeNode> selectObjectByTree(@RequestBody SysFileKind sysFileKind) throws Exception {
    	// 只查询公共的文档分类
    	HashMap<String, Object> map = new HashMap<String, Object>();
    	map.put("other", sysFileKind.getOther());
    	map.put("createPersonId", sysFileKind.getCreatePersonId());
    	map.put("kindLevel", sysFileKind.getKindLevel());
    	map.put("parentId", sysFileKind.getParentId());
    	
    	List<TreeNode> list = sysFileKindService.selectTrees(map);
    	for (int i = 0; i < list.size(); i++) {
			TreeNode tree = list.get(i);
			// 判断节点是否有孩子（异步加载用）
			if (tree.getIsLeaf() == 1) {
				tree.setIsParent(true);
			} else {
				tree.setIsParent(false);
			}
		}
        return list;
    }

    /**
     * 删除菜单信息-false
     *
     * @param sysFileKindcId
     * @return
     */
    @ApiOperation(value = "伪删除文件种类信息", notes = "按ID伪删除文件种类信息,操作成功返回201")
    @RequestMapping(value = "/sysfilekind-provider/sysfilekind/del-sysfilekind/{sysFileKindId}")
    public Serializable deleteSysFileKind(@PathVariable("sysFileKindId") String sysFileKindcId) {
        DataOperationStatusEnum status = sysFileKindService.deleteSysFileKind(sysFileKindcId);
        return status;
    }
//
    /**
     * 删除菜单信息-true
     *
     * @param sysFileKindcId
     * @return
     */
    @ApiOperation(value = "删除文件种类信息", notes = "按ID删除文件种类信息,操作成功返回201")
    @RequestMapping(value = "/sysfilekind-provider/sysfilekind/del-sysfilekind-real/{sysFileKindId}", method = RequestMethod.POST)
    public Serializable deleteSysFileKindReal(@PathVariable("sysFileKindId") String sysFileKindcId) {
        sysFileKindService.deleteSysFileKindReal(sysFileKindcId);
        return DataOperationStatusEnum.DEL_OK;
    }
//
//    /**
//     * 增加菜单信息
//     *
//     * @param sysFileKind
//     * @return
//     */
//    @RequestMapping(value = "/sysfilekind-provider/sysfilekind/add-sysfilekind", method = RequestMethod.POST)
//    public SysFileKind insertSysFileKind(@RequestBody SysFileKind sysFileKind) {
//        sysFileKind.setStatus("");
//        return sysFileKindService.insertObject(sysFileKind);
//    }
//

    /**
     * 分页查询
     *
     * @param param
     * @return
     */
    @ApiOperation(value = "查询文件种类信息-分页查询", notes = "查询文件种类信息-分页查询,操作成功返回JSONObject对象")
    @RequestMapping(value = "/sysfilekind-provider/sysfilekind/sysfilekind-page", method = RequestMethod.POST)
    public Object selectSysFileKindByPage(@RequestBody LayuiTableParam param) {
        return sysFileKindService.findSysFileKindByPage(param);
    }

    @ApiOperation(value = "保存私有文件信息", notes = "保存私有文件信息,操作成功返回500状态位")
    @RequestMapping(value = "/sysfilekind-provider/sysfilekind/save_file", method = RequestMethod.POST)
    public int updateOrInsertSysFile(@RequestBody SysFileKind sysFileKind) {
        try {
            return sysFileKindService.updateOrInsertSysFile(sysFileKind);
        } catch (Exception e) {
            logger.error("[保存信息失败：]", e);
        }
        return 500;
    }
    
    /**
     * 文档分类进行权限分配的查询方法
     */
    @ApiOperation(value = "文档分类权限分配查询", notes = "按照人、组织机构、岗位进行区分")
    @RequestMapping(value = "/sysfilekind-provider/sysfilekind/auth/user-list", method = RequestMethod.POST)
    public LayuiTableData getSysFileKindUserListData(@RequestBody LayuiTableParam param) throws Exception {
    	LayuiTableData tem = sysFileKindService.getSysFileKindUserListData(param);
        return tem;
    }
    
    @ApiOperation(value = "保存文档分类的用户权限", notes = "建立用户和文档分类的关联")
    @RequestMapping(value = "/sysfilekind-provider/sysfilekind/auth/user/save", method = RequestMethod.POST)
    public int saveFileKindAuthUser(@RequestBody SysFileKindAuth sysFileKindAuth) {
        try {
            return sysFileKindService.saveFileKindAuthUser(sysFileKindAuth);
        } catch (Exception e) {
            logger.error("[保存信息失败：]", e);
        }
        return 500;
    }
    
    /**
	 * 查询某种条件下的组织机构节点，有组织机构和人员、岗位
	 * 已配置功能权限的默认勾选
	 */
	@ApiOperation(value="组织机构和人员、岗位",notes="文档分类已配置的默认勾选")
	@RequestMapping(value = "/sysfilekind-provider/sysfilekind/units-posts-users/tree", method = RequestMethod.POST)
	public List<TreeNode> selectTreeNodeWithUnitAndPostAndUser(@RequestBody SysUnit unit) {
		List<TreeNode> list = sysFileKindService.getUnitTreeAndPostAndUserCond(unit);
		
		for (int i = 0; i < list.size(); i++) {
			TreeNode tree = list.get(i);
			// 前几层默认打开
			if (tree.getLevelCode()<2) {
				tree.setOpen("true");
			} else {
				tree.setOpen("false");
			}
		}
		return list;
	}
}
