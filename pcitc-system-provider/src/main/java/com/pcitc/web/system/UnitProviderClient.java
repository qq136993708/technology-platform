package com.pcitc.web.system;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
import com.pcitc.base.system.SysUnit;
import com.pcitc.base.util.DataTableInfoVo;
import com.pcitc.base.util.MyBeanUtils;
import com.pcitc.service.system.UnitService;

@Api(value="机构接口",tags= {"机构相关操作服务接口"})
@RestController
public class UnitProviderClient 
{
	private final static Logger logger = LoggerFactory.getLogger(UnitProviderClient.class);
	
	@Autowired
	private UnitService unitService;
	
	/**
	 * 显示某个节点下的组织机构,只有组织机构，没有人员、没有岗位
	 */
	@ApiOperation(value="检索机构(树)没人员没岗位",notes="显示某个节点下的组织机构,只有组织机构，没有人员、没有岗位。")
	@RequestMapping(value = "/unit-provider/units/tree", method = RequestMethod.POST)
	public List<TreeNode> selectTreeNodeWithUnit(@RequestBody SysUnit unit) {
		String unitCode = unit.getUnitCode();
		if (unitCode == null) {
			// 动态设置根节点，之后从数据库中动态查询获得
			unit.setUnitPath("1001");
		}
		
		List<TreeNode> list = unitService.getUnitTreeCond(unit);
		return list;
	}
	
	/**
	 * 查询某种条件下的组织机构节点，有组织机构和人员，没有岗位
	 */
	@ApiOperation(value="检索机构(树)有人员没岗位",notes="查询某种条件下的组织机构节点，有组织机构和人员，没有岗位。")
	@RequestMapping(value = "/unit-provider/units-users/tree", method = RequestMethod.POST)
	public List<TreeNode> selectTreeNodeWithUnitAndUser(@RequestBody SysUnit unit) {
		String unitCode = unit.getUnitCode();
		if (unitCode == null) {
			// 动态设置根节点，之后从数据库中动态查询获得
			unit.setUnitPath("1001");
		}
		
		List<TreeNode> list = unitService.getUnitTreeAndUserCond(unit);
		return list;
	}
	
	/**
	 * 查询某种条件下的组织机构节点，有组织机构和人员、岗位
	 */
	@ApiOperation(value="检索机构(树)有人员有岗位",notes="查询某种条件下的组织机构节点，有组织机构和人员、岗位。")
	@RequestMapping(value = "/unit-provider/units-posts-users/tree", method = RequestMethod.POST)
	public List<TreeNode> selectTreeNodeWithUnitAndPostAndUser(@RequestBody SysUnit unit) {
		String unitCode = unit.getUnitCode();
		if (unitCode == null) {
			// 动态设置根节点，之后从数据库中动态查询获得
			unit.setUnitPath("1001");
		}
		
		List<TreeNode> list = unitService.getUnitTreeAndPostAndUserCond(unit);
		
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
	
	/**
	 * 组织机构树, 有组织机构和人员, 没有岗位-- 查询某些组织机构节点的组织机构树,只查询这些节点的所有子孙和直系父辈
	 */
	@ApiOperation(value="检索机构(树)子节点",notes="组织机构树, 有组织机构和人员, 没有岗位-- 查询某些组织机构节点的组织机构树,只查询这些节点的所有子孙和直系父辈。")
	@RequestMapping(value = "/unit-provider/units-users/part-tree", method = RequestMethod.POST)
	public List<TreeNode> getUnitTreeAndUserByUnitCodes(@RequestParam(value="jsonStr", required=false) String jsonStr) {
		// unitCode 包含多个组织机构节点编码
		String unitCodes = null;
		List<TreeNode> list = null;
		System.out.println("1后台getUnitTreeAndUserByUnitCodes==========="+jsonStr);
		JSONObject reJson = JSONObject.parseObject(jsonStr);
		
		if (reJson.get("unitCodes") != null && !reJson.get("unitCodes").equals("")) {
			unitCodes = reJson.get("unitCodes").toString();
			
			String[] codes = unitCodes.split("-");
			// 查询这些角色中的人员信息
			List<String> unitCodeList = new ArrayList<String>();
			List<String> unitParentCodeList = new ArrayList<String>();
			for (int i = 0; i < codes.length; i++) {
				unitCodeList.add(codes[i]);
				String[] pCodes = codes[i].split("_");
				String temParent="";
				for (int j = 0; j < pCodes.length; j++) {
					//暂时不考虑重复性
					//unitParentCodeList.add(pCodes[j]);
					if (j == 0) {
						temParent = pCodes[j];
					} else {
						temParent = temParent + "_" + pCodes[j];
					}
					
					unitParentCodeList.add(temParent);
				}
			}
			System.out.println("2后台==========="+unitCodeList);
			System.out.println("2后台==========="+unitParentCodeList);
			Map<String,Object> paramMap = new HashMap<String,Object>();
			paramMap.put("unitCodes", unitCodeList);
			paramMap.put("unitParentCodes", unitParentCodeList);
			
			list = unitService.getUnitTreeAndUserByUnitCodes(paramMap);
			
			for (int i = 0; i < list.size(); i++) {
				TreeNode tree = list.get(i);
				// 前几层默认打开
				if (tree.getLevelCode()<2) {
					tree.setOpen("true");
				} else {
					tree.setOpen("false");
				}
			}
		}
		
		return list;
	}
	
	/**
	 * 组织机构树, 有组织机构和人员, 没有岗位-- 查询某些组织机构节点的组织机构树,只查询这些节点的所有子孙和直系父辈
	 */
	@ApiOperation(value="检索机构(树)有人员没岗位",notes="组织机构树, 有组织机构和人员, 没有岗位-- 查询某些组织机构节点的组织机构树,只查询这些节点的所有子孙和直系父辈。")
	@RequestMapping(value = "/unit-provider/units-posts-users/part-tree", method = RequestMethod.POST)
	public List<TreeNode> getUnitTreeAndPostsAndUserByPostCodes(@RequestParam(value="jsonStr", required=false) String jsonStr) {
		// postCodes 包含多个岗位节点编码
		String postCodes = null;
		List<TreeNode> list = new ArrayList<TreeNode>();
		System.out.println("1后台getUnitTreeAndPostsAndUserByPostCodes==========="+jsonStr);
		JSONObject reJson = JSONObject.parseObject(jsonStr);
		
		if (reJson.get("postCodes") != null && !reJson.get("postCodes").equals("")) {
			postCodes = reJson.get("postCodes").toString();
			
			String[] codes = postCodes.split("-");
			// 查询这些岗位对应的组织机构
			List<String> postCodeList = new ArrayList<String>();
			List<String> postParentCodeList = new ArrayList<String>();
			for (int i = 0; i < codes.length; i++) {
				postCodeList.add(codes[i]);
			}
			System.out.println("2后台==========="+postCodeList);
			Map<String,Object> postMap = new HashMap<String,Object>();
			postMap.put("postCodes", postCodeList);
			
			List<TreeNode> postList = unitService.getPostInfoByPostCodes(postMap);
			System.out.println("2后台==========="+postList.size());
			
			for (int i = 0; i < postList.size(); i++) {
				TreeNode tree = postList.get(i);
				// 人员信息不考虑
				if (tree.getNodeType().equals("post")) {
					for (int j = 0; j < tree.getNodePath().length()/4; j++) {
						//暂时不考虑重复性
						postParentCodeList.add(tree.getNodePath().substring(0, (j+1)*4));
					}
				}
			}
			System.out.println("e后台==========="+postParentCodeList);
			Map<String,Object> unitMap = new HashMap<String,Object>();
			unitMap.put("unitIds", postParentCodeList);
			
			List<TreeNode> unitList = unitService.getUnitInfoByUnitIds(unitMap);
			
			System.out.println("e后台==========="+unitList.size());
			
			list.addAll(postList);
			list.addAll(unitList);
			System.out.println("e后台==========="+list.size());
		}
		
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
	
	@ApiOperation(value="检索机构",notes="根据机构ID检索机构信息。")
	@RequestMapping(value = "/unit-provider/unit/get-unit/{unitId}", method = RequestMethod.POST)
	public SysUnit getUnit(@PathVariable(value = "unitId", required = true) String unitId) 
	{
		return unitService.seletUnitById(unitId);
	}
	
	@ApiOperation(value="检索机构树",notes="检索完整的机构树，从根节点开始。")
	@RequestMapping(value = "/unit-provider/unit/tree-data", method = RequestMethod.POST)
	public List<TreeNode> getUnitListTree() 
	{
		return unitService.selectUnitsByTree();
	}
	
	@ApiOperation(value="添加机构",notes="保存数据到持久化结构中,操作返回持久化数据的数量，1为成功，0不成功。")
	@RequestMapping(value = "/unit-provider/unit/add-unit", method = RequestMethod.POST)
	public Integer saveUnit(@RequestBody SysUnit unit) 
	{
		logger.info("save unit start.....");
		Integer rs = unitService.saveUnit(unit);
		return rs;
	}
	@ApiOperation(value="更新机构",notes="持久化结构数据更新,操作返回持久化数据的数量，1为成功，0不成功。")
	@RequestMapping(value = "/unit-provider/unit/upd-unit", method = RequestMethod.POST)
	public Integer updateUnit(@RequestBody SysUnit unit) 
	{
		logger.info("update unit start.....");
		SysUnit oldUnit = unitService.seletUnitById(unit.getUnitId());
		if(oldUnit != null)
		{
			MyBeanUtils.copyPropertiesIgnoreNull(unit, oldUnit);
		}
		return unitService.updateUnit(oldUnit);
	}
	
	@ApiOperation(value="删除机构(逻辑删除)",notes="删除指定ID机构信息，逻辑删除，物理数据依然存在于持久化数据结构中。")
	@RequestMapping(value = "/unit-provider/unit/del-unit/{unitId}", method = RequestMethod.POST)
	public Integer deleteUnit(@PathVariable(value = "unitId", required = true) String unitId) 
	{
		return unitService.deleteUnit(unitId);
	}
	@ApiOperation(value="删除机构(物理删除)",notes="删除指定ID机构信息，物理删除，物理数据将从持久化数据结构中删除，同时删除用户机构关系数据！")
	@RequestMapping(value = "/unit-provider/unit/del-unit-real/{unitId}", method = RequestMethod.POST)
	public Integer deleteUnitRel(@PathVariable(value = "unitId", required = true) String unitId) 
	{
		return unitService.deleteUnitReal(unitId);
	}
	
	@ApiOperation(value="检索机构列表(不分页)",notes="检索机构列表，不分页。")
	@RequestMapping(value = "/unit-provider/unit/list-data", method = RequestMethod.POST)
	public List<SysUnit> getUnitList() 
	{
		return unitService.selectUnitByPath();
	}
	
	/**
	 * 获取组织机构树节点
	 * @return
	 */
	@ApiOperation(value="检索机构树(从根节点)",notes="检索机构树。")
	@RequestMapping(value = "/unit-provider/get-unit-tree", method = RequestMethod.POST)
	public List<TreeNode> getUnitTree() {
		List<TreeNode> list = null;
		try {
			list = unitService.getUnitTree();
		} catch (Exception e) {
			logger.error("[组织机构-获取组织机构树失败：]", e);
		}
		return list;
	}
	
	/**
	 * 查询组织机构列表
	 * @param tableInfo
	 * @return
	 */
	@ApiOperation(value="检索机构列表(分页)",notes="使用DataTableInfoVo分页对象。")
	@RequestMapping(value = "/unit-provider/unit-list",method = RequestMethod.POST)
	public String selectFunctionByPage(@RequestBody DataTableInfoVo tableInfo) {
		JSONObject tem = null;
		try {
			tem = unitService.selectUnitList(tableInfo);
		} catch (Exception e) {
			logger.error("[组织机构-获取组织机构列表失败：]", e);
		}
		return tem.toString();
	}
	/**
	 * 生成组织机构代码
	 * @param tableInfo
	 * @return
	 */
	@ApiOperation(value="获取机构编码",notes="根据机构信息，生成机构编码。")
	@RequestMapping(value = "/unit-provider/unit/unit-code",method = RequestMethod.POST)
	public String selectUnitCode(@RequestBody SysUnit unit) {
		
		return unitService.getUnitCode(unit);
	}
	/**
	 *  获得组织机构树
	 * @param tableInfo
	 * @return
	 */
	@ApiOperation(value="获取组织机构树(ztree)",notes="根据机构信息，生成ztree组织机构树。")
	@RequestMapping(value = "/unit-provider/unit/ztree-unit-list",method = RequestMethod.POST)
	public String selectUnitForZTree() 
	{
		return unitService.getUnitZTreeList(null);
	}
	
	@ApiOperation(value="获取监理单位列表",notes="获取监理单位列表")
	@RequestMapping(value = "/unit-provider/unit/control-unit-list")
	public LayuiTableData selectControlUnit(@RequestBody LayuiTableParam param){
		LayuiTableData units = null;
		try {
			units =  unitService.selectControlUnit(param);
		} catch (Exception e) {
			logger.error("[组织机构-获取监理单位列表失败：]", e);
		}
		return units;
	}
}
