package com.pcitc.service.system.impl;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.pcitc.base.common.LayuiTableData;
import com.pcitc.base.common.LayuiTableParam;
import com.pcitc.base.common.TreeNode;
import com.pcitc.base.common.enums.DelFlagEnum;
import com.pcitc.base.system.SysUnit;
import com.pcitc.base.system.SysUnitExample;
import com.pcitc.base.system.SysUnitExample.Criteria;
import com.pcitc.base.system.SysUser;
import com.pcitc.base.system.SysUserUnit;
import com.pcitc.base.system.SysUserUnitExample;
import com.pcitc.base.util.DataTableInfo;
import com.pcitc.base.util.DataTableInfoVo;
import com.pcitc.base.util.HanyuPinyinHelper;
import com.pcitc.base.util.MyBeanUtils;
import com.pcitc.base.util.TreeNodeUtil;
import com.pcitc.mapper.system.SysUnitMapper;
import com.pcitc.mapper.system.SysUserUnitMapper;
import com.pcitc.service.system.UnitService;

@Service("unitService")
@Transactional(propagation = Propagation.REQUIRED, readOnly = false, rollbackFor = Exception.class)
public class UnitServiceImpl implements UnitService {

	@Autowired
	private SysUnitMapper unitMapper;

	@Autowired
	private SysUserUnitMapper userUnitMapper;

	/**
	 * 查询某种条件下的组织机构节点，只有组织机构，没有人员、没有岗位
	 * 
	 * @throws Exception
	 */
	public List<TreeNode> getUnitTreeCond(SysUnit temUnit) {
		SysUnitExample example = new SysUnitExample();
		Criteria cri = example.createCriteria();
		cri.andUnitDelflagEqualTo(DelFlagEnum.STATUS_NORMAL.getCode());
		cri.andUnitPathLike(temUnit.getUnitPath() + "%");
		List<SysUnit> units = unitMapper.selectByExample(example);

		List<TreeNode> nodes = new ArrayList<TreeNode>();
		for (SysUnit unit : units) {
			TreeNode node = new TreeNode();
			node.setId(unit.getUnitId());
			node.setpId(unit.getUnitRelation());
			node.setCode(unit.getUnitCode());
			node.setName(unit.getUnitName());
			nodes.add(node);
		}
		return nodes;
	}

	/**
	 * 查询某种条件下的组织机构节点，有组织机构和人员，没有岗位
	 * 
	 * @param unit
	 * @return
	 * @throws Exception
	 */
	public List<TreeNode> getUnitTreeAndUserCond(SysUnit unit) {
		return unitMapper.getUnitTreeAndUserCond(unit);
	}

	/**
	 * 组织机构树, 有组织机构和人员, 没有岗位-- 查询某些组织机构节点的组织机构树,只查询这些节点的所有子孙和直系父辈
	 * 
	 * @param unit
	 * @return
	 * @throws Exception
	 */
	public List<TreeNode> getUnitTreeAndUserByUnitCodes(Map<String, Object> paramMap) {
		return unitMapper.getUnitTreeAndUserByUnitCodes(paramMap);
	}

	/**
	 * 通过某几个岗位编码或者这几个岗位的全部其他信息
	 * 
	 * @param paramMap
	 * @return
	 */
	public List<TreeNode> getPostInfoByPostCodes(Map<String, Object> paramMap) {
		return unitMapper.getPostInfoByPostCodes(paramMap);
	}

	/**
	 * 通过某几个组织机构id获取这几个组织机构的全部其他信息
	 * 
	 * @param paramMap
	 * @return
	 */
	public List<TreeNode> getUnitInfoByUnitIds(Map<String, Object> paramMap) {
		return unitMapper.getUnitInfoByUnitIds(paramMap);
	}

	/**
	 * 查询某种条件下的组织机构节点，有组织机构和人员、岗位
	 * 
	 * @param unit
	 * @return
	 * @throws Exception
	 */
	public List<TreeNode> getUnitTreeAndPostAndUserCond(SysUnit unit) {
		return unitMapper.getUnitTreeAndPostAndUserCond(unit);
	}

	@Override
	public List<TreeNode> selectUnitsByTree() {
		List<TreeNode> nodes = new ArrayList<TreeNode>();
		SysUnitExample example = new SysUnitExample();
		example.getOredCriteria().add(example.createCriteria().andUnitDelflagEqualTo(DelFlagEnum.STATUS_NORMAL.getCode()));
		// example.setOrderByClause("unitLevel");
		List<SysUnit> units = unitMapper.selectByExample(example);
		for (SysUnit unit : units) {
			TreeNode node = new TreeNode();
			node.setId(unit.getUnitId());
			node.setParentId(unit.getUnitRelation());
			node.setText(unit.getUnitName());
			nodes.add(node);
		}
		// 构建树形结构(从根节点开始的树形结构)

		List<TreeNode> orderNodes = new ArrayList<TreeNode>();
		try {
			if (units.size() > 0) {
				orderNodes = TreeNodeUtil.getfatherNode(nodes, units.get(0).getUnitId());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return orderNodes;
	}

	@Override
	public SysUnit seletUnitById(Serializable id) {
		return unitMapper.selectByPrimaryKey(id.toString());
	}

	@Override
	public Integer saveUnit(SysUnit unit) {
		// 设置路径
		unit.setUnitPath(createUnitPath(unit));
		// 创建编码
		if (unit.getUnitCode() == null) {
			unit.setUnitCode(createCode(unit));
		}
		return unitMapper.insert(unit);
	}

	@Override
	public Integer updateUnit(SysUnit unit) {
		try {
			SysUnit oldUnit = unitMapper.selectByPrimaryKey(unit.getUnitId());
			if (oldUnit != null) {
				MyBeanUtils.copyPropertiesIgnoreNull(unit, oldUnit);
				// oldUnit.setUnitCode(createCode(oldUnit));
				return unitMapper.updateByPrimaryKey(oldUnit);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return 0;
	}

	@Override
	public Integer deleteUnit(Serializable id) {
		try {
			SysUnit unit = unitMapper.selectByPrimaryKey(id.toString());
			if (unit != null) {
				// 查询是否有下级机构(如果有下级机构，不允许删除)
				SysUnitExample example = new SysUnitExample();
				SysUnitExample.Criteria c = example.createCriteria();
				c.andUnitRelationEqualTo(unit.getUnitId());
				c.andUnitDelflagEqualTo(DelFlagEnum.STATUS_NORMAL.getCode());
				List<SysUnit> ls = unitMapper.selectByExample(example);
				if (ls.size() > 0) {
					return 0;
				}
				unit.setUnitDelflag(DelFlagEnum.STATUS_DEL.getCode());
				return unitMapper.updateByPrimaryKey(unit);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return 0;
	}

	@Override
	public Integer deleteUnitReal(Serializable id) {
		try {
			SysUnit unit = unitMapper.selectByPrimaryKey(id.toString());
			if (unit != null) {
				SysUserUnitExample example = new SysUserUnitExample();
				SysUserUnitExample.Criteria c = example.createCriteria();
				c.andUnitIdEqualTo(unit.getUnitId());

				List<SysUserUnit> userUnits = userUnitMapper.selectByExample(example);
				if (userUnits != null) {
					for (SysUserUnit userUnit : userUnits) {
						userUnitMapper.deleteByPrimaryKey(userUnit.getRelId());
					}
				}
				return unitMapper.deleteByPrimaryKey(unit.getUnitId());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return 0;
	}

	@Override
	public List<SysUnit> selectUnitByPath() {
		SysUnitExample example = new SysUnitExample();
		Criteria c = example.createCriteria();
		c.andUnitDelflagEqualTo(DelFlagEnum.STATUS_NORMAL.getCode());
		example.setOrderByClause("unit_path ASC");

		List<SysUnit> units = unitMapper.selectByExample(example);
		return units;
	}

	@Override
	public List<SysUser> selectUnitUsers(DataTableInfo searchConn) {

		// 1、设置分页信息，包括当前页数和每页显示的总计数
		PageHelper.startPage(searchConn.getiDisplayStart() / searchConn.getiDisplayLength() + 1, searchConn.getiDisplayLength());
		// 2、执行查询
		// List<SysUser> list = unitMapper.selectByExample(example);
		return null;
	}

	@Override
	public List<com.pcitc.base.common.TreeNode> getUnitTree() throws Exception {
		List<com.pcitc.base.common.TreeNode> list = unitMapper.getUnitTree();
		return com.pcitc.base.util.TreeNodeUtil.getfatherNode(list, "10001");
	}

	/**
	 * 创建编码
	 * 
	 * @param unit
	 * @return
	 */
	private String createCode(SysUnit unit) {
		// 计算父节点编码(没有父节点则设置父节点为0)
		String pUnitId = StringUtils.isBlank(unit.getUnitRelation()) ? "0" : unit.getUnitRelation();
		SysUnit parent = unitMapper.selectByPrimaryKey(pUnitId);
		if (parent == null) {
			return HanyuPinyinHelper.toPinyin(unit.getUnitName());
		}
		// 根据机构级别设置编码
		StringBuffer sb = new StringBuffer();
		String pathstr = parent.getUnitPath();
		for (int i = 4; i <= pathstr.length(); i += 4) {
			String relpath = pathstr.substring(0, i);
			SysUnitExample example = new SysUnitExample();
			SysUnitExample.Criteria c = example.createCriteria();

			c.andUnitPathEqualTo(relpath);
			List<SysUnit> units = unitMapper.selectByExample(example);
			if (units != null && units.size() == 1) {
				sb.append(HanyuPinyinHelper.toPinyin(units.get(0).getUnitName()) + "_");
			}
		}
		sb.append(HanyuPinyinHelper.toPinyin(unit.getUnitName()));
		return sb.toString();
	}

	/**
	 * 创建路径
	 * 
	 * @param unit
	 * @return
	 */
	private String createUnitPath(SysUnit unit) {
		SysUnitExample example = new SysUnitExample();
		SysUnitExample.Criteria c = example.createCriteria();
		c.andUnitRelationEqualTo(unit.getUnitRelation());
		example.setOrderByClause("unit_path desc");
		Integer number;
		// 设置路径查找同一个父机构下的同级机构
		List<SysUnit> units = unitMapper.selectByExample(example);
		if (units == null || units.size() == 0) {
			// 没有同级别则取父级别
			SysUnit parentUnit = unitMapper.selectByPrimaryKey(unit.getUnitRelation());
			return parentUnit.getUnitPath() + "0001";
		} else {
			// Integer path = new Integer(units.get(0).getUnitPath())+1;
			String path = units.get(0).getUnitPath();
			if (path.length() < 4) {
				number = new Integer("1" + path.substring(path.length() - 3)) + 1;
				return path.substring(0, path.length() - 3) + number.toString().substring(1);
			} else {
				number = new Integer("1" + path.substring(path.length() - 4)) + 1;
				return path.substring(0, path.length() - 4) + number.toString().substring(1);
			}
		}
	}

	@Override
	public JSONObject selectUnitList(DataTableInfoVo tableInfo) throws Exception {
		// 每页显示条数
		int pageSize = tableInfo.getiDisplayLength();
		// 从第多少条开始
		int pageStart = tableInfo.getiDisplayStart();
		// 当前是第几页
		int pageNum = pageStart / pageSize + 1;

		// 1、设置分页信息，包括当前页数和每页显示的总计数
		PageHelper.startPage(pageNum, pageSize);
		// 2、执行查询
		SysUnit unit = new SysUnit();
		unit.setiSortCol(tableInfo.getiSortCol());
		unit.setsSortDir_0(tableInfo.getsSortDir_0());

		List<SysUnit> list = unitMapper.selectUnitList(unit);
		// 3、获取分页查询后的数据
		PageInfo<SysUnit> pageInfo = new PageInfo<SysUnit>(list);
		// 4、封装需要返回的分页实体
		JSONObject result = new JSONObject();
		result.put("totalCount", pageInfo.getTotal());
		result.put("list", list);

		return result;
	}

	@Override
	public String getUnitCode(SysUnit unit) {
		return this.createCode(unit);
	}

	@Override
	public String getUnitZTreeList(String parentCode) {
		SysUnitExample example = new SysUnitExample();
		Criteria c = example.createCriteria();
		c.andUnitDelflagEqualTo(DelFlagEnum.STATUS_NORMAL.getCode());
		if (parentCode != null) {
			c.andUnitPathLike(parentCode + "%");
		}
		example.setOrderByClause("unit_order ASC");
		List<SysUnit> units = unitMapper.selectByExample(example);
		List<TreeNode> nodes = new ArrayList<TreeNode>();
		for (SysUnit unit : units) {
			TreeNode node = new TreeNode();
			node.setId(unit.getUnitId());
			node.setpId(unit.getUnitRelation());
			node.setName(unit.getUnitName());
			// 只打开一层
			if (unit.getUnitLevel() < 1) {
				node.setOpen("true");
			} else {
				node.setOpen("false");
			}
			nodes.add(node);

		}
		return JSONArray.toJSONString(nodes);
	}

	@Override
	public LayuiTableData selectControlUnit(LayuiTableParam param) throws Exception {
		if (param.getLimit() != null && param.getPage() != null) {
			// 每页显示条数
			int pageSize = param.getLimit();
			// 从第多少条开始
			int pageStart = (param.getPage() - 1) * pageSize;
			// 当前是第几页
			int pageNum = pageStart / pageSize + 1;
			// 1、设置分页信息，包括当前页数和每页显示的总计数
			PageHelper.startPage(pageNum, pageSize);
		}
		// 设置查询条件
		SysUnit unit = new SysUnit();
		String unitName = (String) param.getParam().get("unitName");
		String unitKind = (String) param.getParam().get("unitKind");
		unit.setUnitName(unitName);
		unit.setUnitKind(unitKind);

		// 2、执行查询
		List<SysUnit> list = unitMapper.selectControlUnit(unit);
		PageInfo<SysUnit> pageInfo = new PageInfo<SysUnit>(list);
		// 4、封装需要返回的分页实体
		LayuiTableData data = new LayuiTableData();
		data.setData(pageInfo.getList());
		Long total = pageInfo.getTotal();
		data.setCount(total.intValue());
		return data;
	}

	@Override
	public SysUnit seletUnitByCode(String code) {
		SysUnitExample example = new SysUnitExample();
		SysUnitExample.Criteria cr = example.createCriteria();
		cr.andUnitCodeEqualTo(code);
		List<SysUnit> units = unitMapper.selectByExample(example);
		if (units != null && units.size() > 0) {
			return units.get(0);
		}
		return null;
	}

	/**
	 * 查询某种条件下的组织机构节点，有组织机构和岗位, 没有人员
	 * 
	 * @param unit
	 * @return
	 * @throws Exception
	 */
	public List<TreeNode> getUnitPostTree(HashMap<String, Object> paramMap) {
		List<TreeNode> nodes = unitMapper.getUnitPostTree(paramMap);
		for (int i = 0; i < nodes.size(); i++) {
			TreeNode tree = nodes.get(i);
			if (tree.getLevelCode() < 3) {
				tree.setOpen("true");
			} else {
				tree.setOpen("false");
			}
		}
		return nodes;
	}

	// 根据UnitPath检索机构信息
	public SysUnit getUnitByUnitPath(String unitPath) {
		SysUnitExample example = new SysUnitExample();
		SysUnitExample.Criteria cr = example.createCriteria();
		cr.andUnitPathEqualTo(unitPath);
		List<SysUnit> units = unitMapper.selectByExample(example);
		if (units != null && units.size() > 0) {
			return units.get(0);
		}
		return null;
	}

	public String getUnitZTreeListByName(String name) {
		// 先检索出所有的数据
		SysUnitExample example = new SysUnitExample();
		Criteria c = example.createCriteria();
		c.andUnitDelflagEqualTo(DelFlagEnum.STATUS_NORMAL.getCode());
		example.setOrderByClause("unit_path ASC");
		List<SysUnit> units = unitMapper.selectByExample(example);

		// 根据名称模糊匹配组织机构（包含当前组织机构的所有父节点，不包含子节点），ztree
		if (name != null && !"".equals(name)) {
			Map<String, SysUnit> map = new HashMap<String, SysUnit>();
			for (SysUnit unit : units) {
				map.put(unit.getUnitPath(), unit);
			}
			// 如果是模糊匹配则需要先检索名称，再检索父子节点
			SysUnitExample ex = new SysUnitExample();
			Criteria exc = ex.createCriteria();
			exc.andUnitDelflagEqualTo(DelFlagEnum.STATUS_NORMAL.getCode());
			exc.andUnitNameLike("%" + name + "%");
			ex.setOrderByClause("unit_path ASC");
			List<SysUnit> searchunits = unitMapper.selectByExample(ex);

			Map<String, SysUnit> unitset = new HashMap<String, SysUnit>();
			for (SysUnit u : searchunits) {
				unitset.put(u.getUnitPath(), u);
				String pathurl = u.getUnitPath();
				if (pathurl == null) {
					continue;
				}
				for (int i = 0; i < pathurl.length(); i += 4) {
					String path = pathurl.substring(0, i + 4);
					unitset.put(path, map.get(path));
				}
			}
			units = new ArrayList<SysUnit>(unitset.values());
			java.util.Collections.sort(units, new Comparator<SysUnit>() {
				@Override
				public int compare(SysUnit u1, SysUnit u2) {
					return u1.getUnitLevel() - u2.getUnitLevel();
				}
			});
		}
		List<TreeNode> nodes = new ArrayList<TreeNode>();
		for (SysUnit unit : units) {
			TreeNode node = new TreeNode();
			node.setId(unit.getUnitId());
			node.setpId(unit.getUnitRelation());
			node.setName(unit.getUnitName());
			node.setText(unit.getUnitCode());
			nodes.add(node);
		}
		return JSONArray.toJSONString(nodes);
	}

}
