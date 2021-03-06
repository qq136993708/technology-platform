package com.pcitc.web.system;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.pcitc.base.common.LayuiTableData;
import com.pcitc.base.common.LayuiTableParam;
import com.pcitc.base.common.Result;
import com.pcitc.base.common.TreeNode;
import com.pcitc.base.system.SysUnit;
import com.pcitc.base.util.DataTableInfoVo;
import com.pcitc.base.util.MyBeanUtils;
import com.pcitc.service.system.UnitService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

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
		List<TreeNode> list = unitService.getUnitTreeCond(unit);
		return list;
	}
	
	/**
	 * 查询某种条件下的组织机构节点，有组织机构和人员，没有岗位
	 */
	@ApiOperation(value="检索机构(树)有人员没岗位",notes="查询某种条件下的组织机构节点，有组织机构和人员，没有岗位。")
	@RequestMapping(value = "/unit-provider/units-users/tree", method = RequestMethod.POST)
	public List<TreeNode> selectTreeNodeWithUnitAndUser(@RequestBody SysUnit unit) {
		List<TreeNode> list = unitService.getUnitTreeAndUserCond(unit);
		return list;
	}
	
	/**
	 * 查询某种条件下的组织机构节点，有组织机构和人员、岗位
	 */
	@ApiOperation(value="检索机构(树)有人员有岗位",notes="查询某种条件下的组织机构节点，有组织机构和人员、岗位。")
	@RequestMapping(value = "/unit-provider/units-posts-users/tree", method = RequestMethod.POST)
	public List<TreeNode> selectTreeNodeWithUnitAndPostAndUser(@RequestBody SysUnit unit) {
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
			Map<String,Object> postMap = new HashMap<String,Object>();
			postMap.put("postCodes", postCodeList);
			
			List<TreeNode> postList = unitService.getPostInfoByPostCodes(postMap);
			
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
			Map<String,Object> unitMap = new HashMap<String,Object>();
			unitMap.put("unitIds", postParentCodeList);
			
			List<TreeNode> unitList = unitService.getUnitInfoByUnitIds(unitMap);
			
			list.addAll(postList);
			list.addAll(unitList);
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
	

	@ApiOperation(value="根据编码检索机构",notes="根据机构编码检索机构信息。")
	@RequestMapping(value = "/unit-provider/unit/get-unit-bycode/{unitCode}", method = RequestMethod.POST)
	public SysUnit getUnitByCode(@PathVariable(value = "unitCode", required = true) String unitCode) 
	{
		return unitService.seletUnitByCode(unitCode);
	}
	
	
	
	@ApiOperation(value="根据编码检索子机构",notes="根据机构编码检索子机构信息。")
	@RequestMapping(value = "/unit-provider/unit/gethildscUnitBycodes/{unitCodes}", method = RequestMethod.POST)
	public JSONArray getChildscUnitycode(@PathVariable(value = "unitCodes", required = true) String unitCodes) throws Exception
	{
		String []arr=unitCodes.split(",");
		List list = java.util.Arrays.asList(arr);
		List<SysUnit> result= unitService.getChildscUnitBycodes(list);
		JSONArray json = JSONArray.parseArray(JSON.toJSONString(result));
		return json;
	}
	
	
	
	
	@ApiOperation(value="根据unitPath编码检索机构",notes="根据机构unitPath编码检索机构信息。")
	@RequestMapping(value = "/unit-provider/unit/getUnitByUnitPath/{unitPath}", method = RequestMethod.POST)
	public SysUnit getUnitByUnitPath(@PathVariable(value = "unitPath", required = true) String unitPath) 
	{
		return unitService.getUnitByUnitPath(unitPath);
	}

	
	@ApiOperation(value="检索机构树",notes="检索完整的机构树，从根节点开始。")
	@RequestMapping(value = "/unit-provider/unit/tree-data", method = RequestMethod.POST)
	public List<TreeNode> getUnitListTree() 
	{
		return unitService.selectUnitsByTree();
	}
	
	@ApiOperation(value="添加机构",notes="保存数据到持久化结构中,操作返回持久化数据的数量，1为成功，0不成功。")
	@RequestMapping(value = "/unit-provider/unit/add-unit", method = RequestMethod.POST)
	public Object saveUnit(@RequestBody SysUnit unit) 
	{
		logger.info("save unit start.....");
		/*SysUnit dbunit = unitService.seletUnitByCode(unit.getUnitCode());
		if(dbunit != null) {
			return new Result(false, "编码重复!");
		}*/
		Integer rs = unitService.saveUnit(unit);
		if(rs > 0) {
			return new Result(true, "操作成功!");
		}else {
			return new Result(false, "操作异常，请联系管理员!");
		}
	}
	@ApiOperation(value="更新机构",notes="持久化结构数据更新,操作返回持久化数据的数量，1为成功，0不成功。")
	@RequestMapping(value = "/unit-provider/unit/upd-unit", method = RequestMethod.POST)
	public Object updateUnit(@RequestBody SysUnit unit) 
	{
		/*SysUnit dbunit = unitService.seletUnitByCode(unit.getUnitCode());
		if(dbunit!=null && !dbunit.getUnitId().equals(unit.getUnitId())) 
		{
			return new Result(false, "编码重复!");
		}*/
		logger.info("update unit start.....");
		SysUnit oldUnit = unitService.seletUnitById(unit.getUnitId());
		if(oldUnit != null)
		{
			MyBeanUtils.copyPropertiesIgnoreNull(unit, oldUnit);
		}
		Integer rs =  unitService.updateUnit(oldUnit);
		if(rs > 0) {
			return new Result(true, "操作成功!");
		}else {
			return new Result(false, "操作异常，请联系管理员!");
		}
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
	
	
	/**
	 *  获得组织机构树
	 * @param tableInfo
	 * @return
	 */
	@ApiOperation(value="获取组织机构树(ztree)",notes="根据机构信息，生成ztree组织机构树。")
	@RequestMapping(value = "/unit-provider/unit/ztree_unit_list_by_name",method = RequestMethod.POST)
	public String selectUnitForZTreename(@RequestBody(required=false) String name) 
	{
		System.out.println("name............"+name);
		//return unitService.getUnitZTreeList(null);
		return unitService.getUnitZTreeListByName(name);
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
	
	/**
	 * 查询某种条件下的组织机构节点，有组织机构和岗位，没有人员
	 */
	@ApiOperation(value="检索机构(树)有组织机构和岗位",notes="有组织机构和岗位")
	@RequestMapping(value = "/unit-provider/units-posts/tree", method = RequestMethod.POST)
	public List<TreeNode> getUnitPostTree(@RequestBody HashMap<String, Object> map) {
		
		List<TreeNode> list = unitService.getUnitPostTree(map);
		return list;
	}
	@ApiOperation(value="检索机构",notes="根据ID检索机构")
	@RequestMapping(value = "/unit-provider/units/get-units-byids", method = RequestMethod.POST)
	public Object selectSysUnitByIds(@RequestBody Set<String> unitIds) {
		List<SysUnit> list = unitService.selectUnitByIds(unitIds);
		return list;
	}
	
	
	
	@ApiOperation(value="查询未删除的机 构",notes="查询未删除的机 构")
	@RequestMapping(value = "/unit-provider/unit/getAllList", method = RequestMethod.POST)
	public JSONArray getAllList(@RequestBody Map map) throws Exception
	{
		List<SysUnit> result= unitService.getAllList();
		JSONArray json = JSONArray.parseArray(JSON.toJSONString(result));
		return json;
	}


	/**
	 *  获得组织机构树
	 * @param name
	 * @return
	 */
	@ApiOperation(value="获取单位ID",notes="根据机构信息，返回机构id")
	@RequestMapping(value = "/unit-provider/unit/getUnitId_by_name",method = RequestMethod.POST)
	public String getUnitIdByUnitName(@RequestBody(required=false) String name)
	{
		System.out.println("name............"+name);
		//return unitService.getUnitZTreeList(null);
		return unitService.getUnitIdByUnitName(name);
	}
	
	
	
	
	


    @ApiOperation(value="根据Path查询所有子机构",notes="根据Path查询所有子机构")
	@RequestMapping(value = "/unit-provider/unit/getAllChildsByIUnitPath/{unitPath}", method = RequestMethod.POST)
	public JSONArray getAllChildsByIUnitPath(@PathVariable(value = "unitPath", required = true) String unitPath) throws Exception
	{
		List<SysUnit> result= unitService.getAllChildsByIUnitPath(unitPath);
		JSONArray json = JSONArray.parseArray(JSON.toJSONString(result));
		return json;
	}

}
