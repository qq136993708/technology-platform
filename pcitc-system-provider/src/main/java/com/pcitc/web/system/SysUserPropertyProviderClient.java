package com.pcitc.web.system;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.pcitc.base.common.LayuiTableData;
import com.pcitc.base.common.LayuiTableParam;
import com.pcitc.base.common.TreeNode;
import com.pcitc.base.system.SysUserProperty;
import com.pcitc.base.system.vo.SysUserPropertyVo;
import com.pcitc.service.system.SysUserPropertyService;

@RestController
public class SysUserPropertyProviderClient {
	

	
	@Autowired
	private SysUserPropertyService userPropertyService;
	
	private final static Logger logger = LoggerFactory.getLogger(SysUserPropertyProviderClient.class);
	
	/**
	 * 第一层树
	 * @return
	 */
	@RequestMapping(value = "/userProperty-provider/first-level-tree", method = RequestMethod.POST)
	@ResponseBody
	public List selectUnitUserUnderOfRoot() {
		List<TreeNode> list = null;
		try {
			list = userPropertyService.selectUnitUserUnderOfRoot();
		} catch (Exception e) {
			logger.error("[人员配置-获取部门和人员树失败：]", e);
		}
		return list;
	}
	
	/**
	 * 异步加载树
	 * @param parentId
	 * @return
	 */
	@RequestMapping(value = "/userProperty-provider/selectUserUnderOfUnitTree/{parentId}", method = RequestMethod.POST)
	@ResponseBody
	public List selectUserUnderOfUnitTree(@PathVariable(value = "parentId", required = true) String parentId,HttpServletRequest request) {
		List<TreeNode> list = null;
		try {
			list = userPropertyService.selectUserUnderOfUnitTree(parentId,request);
			//list = TreeNodeUtil.getfatherNode(list, "10001");
		} catch (Exception e) {
			logger.error("[人员配置-获取部门和人员树失败：]", e);
		}
		return list;
	}
	
	
	
	
	@RequestMapping(value = "/userProperty-provider/saveUserPropertyList", method = RequestMethod.POST)
	public int saveUserPropertyList(@RequestBody SysUserPropertyVo property){
		int result = 500;
		try {
			result = userPropertyService.bantchInsertRelation(property.getProperties(),property.getDataType(),property.getUserIdList(),property.getCurrentPageDataIdList(),property.getDataId() );
		} catch (Exception e) {
			logger.error("[人员条件配置-保存人员条件关系失败：]", e);
		}
		return result;
	}
	
	

	@RequestMapping(value = "/userProperty-provider/propertyList",method = RequestMethod.POST)
	public LayuiTableData selectUserPropertyList(@RequestBody LayuiTableParam param) {
		LayuiTableData tem = null;
		try {
			tem = userPropertyService.selectUserPropertyList(param);
		} catch (Exception e) {
			logger.error("[人员条件配置-查询配置列表失败：]", e);
		}
		return tem;
	}
	
	/**
	 * @param jsonStr
	 * @return
	 * @throws Exception
	 * 查询某个人在某些数据控制属性上的具体控制数据内容
	 */
	@RequestMapping(value = "/userProperty-provider/data-filter/{userId}/{functionCode}", method = RequestMethod.POST)
	public JSONArray getUserDataByUserAndType(@PathVariable(value = "userId", required = true) String userId, @PathVariable(value = "functionCode", required = true) String functionCode) throws Exception {
		System.out.println("=getUserDataByUserAndType+++++++==="+userId+"========="+functionCode);
		
		List<SysUserProperty> retList = userPropertyService.selectUserPropertyByUserAndType(userId, functionCode);
		
		// 对创建人的控制，特殊处理。
		for (SysUserProperty sup : retList) {
			// 特殊处理一下dataId, 把第一个和最后一个“，”去掉，同时把“，，”替换成“，”
			if (sup.getDataId() != null && !sup.getDataId().equals("")) {
				sup.setDataId(sup.getDataId().replaceAll(",,", ","));
				sup.setDataId(sup.getDataId().replaceFirst("^,*", ""));
				sup.setDataId(sup.getDataId().substring(0, sup.getDataId().length()-1));
			}
			if (sup.getDataType() != null && sup.getDataType().equals("create_user_id")) {
				sup.setDataId(userId);
			}
			
		}
		JSONArray json = JSONArray.parseArray(JSON.toJSONString(retList));
		return json;
	}
	
	
	@RequestMapping(value = "/userProperty-provider/select-unit-tree/{userId}", method = RequestMethod.POST)
	@ResponseBody
	public List selectUnitTreeForProperty(@PathVariable(value = "userId", required = true) String userId) {
		List<TreeNode> list = null;
		try {
			list = userPropertyService.selectUnitTree(userId);
		} catch (Exception e) {
			logger.error("[人员配置-获取部门配置树失败：]", e);
		}
		return list;
	}
	
	/**
	 * 递归获取节点下的子节点用户
	 * @param parentId
	 * @return
	 */
	@RequestMapping(value = "/userProperty-provider/child-by-child/{parentCode}", method = RequestMethod.POST)
	@ResponseBody
	public List selectChildByChild(@PathVariable(value = "parentCode", required = true) String parentCode) {
		List<TreeNode> list = null;
		
		try {
			list = userPropertyService.selectChildByChild(parentCode);
		} catch (Exception e) {
			logger.error("[人员配置-通过节点id递归查询用户失败：]", e);
		}
		return list;
	}
	
	
	
	
	@RequestMapping(value = "/userProperty-provider/getSysUserProperty/{userId}/{dataType}", method = RequestMethod.GET)
	public SysUserProperty getSysUserProperty(@PathVariable(value = "userId", required = true) String userId, @PathVariable(value = "dataType", required = true) String dataType) throws Exception {
		System.out.println("=getSysUserProperty+++++++==="+userId+"========="+dataType);
		SysUserProperty sysUserProperty  = userPropertyService.getSysUserProperty(userId, dataType);
		return sysUserProperty;
	}
	
	

}
