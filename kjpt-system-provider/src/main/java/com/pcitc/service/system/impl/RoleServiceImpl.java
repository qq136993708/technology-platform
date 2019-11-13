package com.pcitc.service.system.impl;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.pcitc.base.common.LayuiTableData;
import com.pcitc.base.common.LayuiTableParam;
import com.pcitc.base.common.TreeNode;
import com.pcitc.base.common.enums.DelFlagEnum;
import com.pcitc.base.system.SysFunction;
import com.pcitc.base.system.SysFunctionExample;
import com.pcitc.base.system.SysRole;
import com.pcitc.base.system.SysRoleExample;
import com.pcitc.base.system.SysRoleFunction;
import com.pcitc.base.system.SysRoleFunctionExample;
import com.pcitc.base.system.SysUser;
import com.pcitc.base.system.SysUserExample;
import com.pcitc.base.system.SysUserRole;
import com.pcitc.base.system.SysUserRoleExample;
import com.pcitc.base.system.SysUserRoleExample.Criteria;
import com.pcitc.base.util.HanyuPinyinHelper;
import com.pcitc.base.util.IdUtil;
import com.pcitc.base.util.JsonUtil;
import com.pcitc.base.util.MyBeanUtils;
import com.pcitc.base.util.TreeNodeUtil;
import com.pcitc.mapper.system.SysFunctionMapper;
import com.pcitc.mapper.system.SysRoleFunctionMapper;
import com.pcitc.mapper.system.SysRoleMapper;
import com.pcitc.mapper.system.SysUserMapper;
import com.pcitc.mapper.system.SysUserRoleMapper;
import com.pcitc.service.system.RoleService;

@Service("roleService")
@Transactional(propagation = Propagation.REQUIRED, readOnly = false, rollbackFor = Exception.class)
public class RoleServiceImpl implements RoleService {

	@Autowired
	private SysRoleMapper roleMapper;
	
	@Autowired
	private SysUserMapper userMapper;
	
	@Autowired
	private SysFunctionMapper functionMapper;
	
	@Autowired
	private SysUserRoleMapper userRoleMapper;
	
	@Autowired
	private SysRoleFunctionMapper roleFunctionMapper;
	
	@Override
	public PageInfo<SysRole> findRoles(String searchStr) 
	{
		int pageLength = 10;
		int startPage = 0;
		Map<String,Object> paramMap = JsonUtil.parseJsonToMap(searchStr);
		if(paramMap.get("iDisplayLength") != null)
		{
			pageLength = Integer.parseInt(paramMap.get("iDisplayLength").toString());
		}
		if(paramMap.get("iDisplayStart") != null)
		{
			startPage = Integer.parseInt(paramMap.get("iDisplayStart").toString());
		}
		
		
		startPage = startPage/pageLength+1;
		// 1、设置分页信息，包括当前页数和每页显示的总计数
		PageHelper.startPage(startPage, pageLength);
		
		SysRoleExample example = new SysRoleExample();
		com.pcitc.base.system.SysRoleExample.Criteria c = example.createCriteria();
		c.andRoleDelflagEqualTo(DelFlagEnum.STATUS_NORMAL.getCode());
		if(!StringUtils.isBlank(paramMap.get("roleName")+"")){
			c.andRoleNameLike("%"+paramMap.get("roleName")+"%");
		}
		PageInfo<SysRole> pageInfo = new PageInfo<SysRole>(roleMapper.selectByExample(example));
		PageHelper.clearPage();
		return pageInfo;
	}

	@Override
	public SysRole findById(String roleId) 
	{
		return roleMapper.selectByPrimaryKey(roleId);
	}

	@Override
	public Serializable saveRole(SysRole role) 
	{
		//检查重名
		if(checkRoleDoubleName(role)) 
		{
			return 0;
		}
		role.setRoleCreateTime(new Date());
		role.setRoleId(IdUtil.createIdByTime());
		return roleMapper.insert(role);
	}

	@Override
	public Integer updateRole(SysRole role) 
	{
		try
		{
			SysRole oldRole = roleMapper.selectByPrimaryKey(role.getRoleId());
			if(oldRole != null)
			{
				MyBeanUtils.copyPropertiesIgnoreNull(role, oldRole);
			}
			//检查重名
			if(checkRoleDoubleName(role)) 
			{
				return 0;
			}
			return roleMapper.updateByPrimaryKey(oldRole);
		}catch(Exception e){
			return 0;
		}
		
	}

	@Override
	public Integer deleteRole(Serializable id) 
	{
			SysRole role = roleMapper.selectByPrimaryKey(id.toString());
			if(role != null){
				role.setRoleDelflag(DelFlagEnum.STATUS_DEL.getCode());
				return roleMapper.updateByPrimaryKey(role);
			}
		return 0;
	}

	@Override
	public Integer deleteRoleReal(Serializable id) 
	{
		Integer rs = 0;
		try
		{
			SysUserRoleExample example = new SysUserRoleExample();
			example.createCriteria().andRoleIdEqualTo(id.toString());
			
			rs += userRoleMapper.deleteByExample(example);
			rs += roleMapper.deleteByPrimaryKey(id.toString());
		}
		catch(Exception e)
		{
			return rs;
		}
		return rs;
	}

	@Override
	public List<SysRole> findRoleByUser(String userId) 
	{
		SysUserRoleExample example = new SysUserRoleExample();
		example.createCriteria().andUserIdEqualTo(userId);
		List<SysUserRole> userRoles = userRoleMapper.selectByExample(example);
		
		List<String> ids = new ArrayList<String>();
		for(SysUserRole role:userRoles){
			ids.add(role.getRoleId());
		}
		SysRoleExample rexample = new SysRoleExample();
		rexample.createCriteria().andRoleIdIn(ids);
		return roleMapper.selectByExample(rexample);
	}

	@Override
	public PageInfo<SysUser> findUsersPageByRole(String roleId, String userName, String pageParamJsonStr) 
	{
		// 1、执行查询
		SysUserRoleExample example = new SysUserRoleExample();
		SysUserRoleExample.Criteria surc = example.createCriteria();
		surc.andRoleIdEqualTo(roleId);
		List<SysUserRole> userRoles = userRoleMapper.selectByExample(example);
		List<String> uids = new ArrayList<String>();
		for(SysUserRole role:userRoles){
			uids.add(role.getUserId());
		}
		SysUserExample uexample = new SysUserExample();
		SysUserExample.Criteria suc = uexample.createCriteria();
		suc.andUserIdIn(uids);
		if(!StringUtils.isBlank(userName)){
			suc.andUserNameLike("%"+userName+"%");
		}
		
		int pageLength = 10;
		int startPage = 0;
		Map<String,Object> paramMap = JsonUtil.parseJsonToMap(pageParamJsonStr);
		if(paramMap.get("iDisplayLength") != null)
		{
			pageLength = Integer.parseInt(paramMap.get("iDisplayLength").toString());
		}
		if(paramMap.get("iDisplayStart") != null)
		{
			startPage = Integer.parseInt(paramMap.get("iDisplayStart").toString());
		}
		
		startPage = startPage/pageLength+1;
		// 1、设置分页信息，包括当前页数和每页显示的总计数
		PageHelper.startPage(startPage, pageLength);
		
		List<SysUser> list = userMapper.selectByExample(uexample);
		// 2、获取分页查询后的数据
		PageInfo<SysUser> pageInfo = new PageInfo<SysUser>(list);
		// 3、封装需要返回的分页实体
		System.out.println("总的用户数----" + pageInfo.getTotal());
		System.out.println("查询出当月的条数----" + list.size());
		PageHelper.clearPage();
		return pageInfo;
	}

	@Override
	public Integer userRoleRelUpdate(String userId, List<SysRole> roles) 
	{
		Integer rs = 0;
		try
		{
			SysUserRoleExample example = new SysUserRoleExample();
			example.createCriteria().andUserIdEqualTo(userId);
			rs += userRoleMapper.deleteByExample(example);
			for(SysRole role:roles)
			{
				SysUserRole userRole = new SysUserRole();
				userRole.setRelId(IdUtil.createIdByTime());
				userRole.setRoleId(role.getRoleId());
				userRole.setUserId(userId);
				
				rs += userRoleMapper.insert(userRole);
			}
		}catch(Exception e){
			return 0;
		}
		
		return rs;
	}

	@Override
	public Integer addUserRoleRel(String roleId, List<String> userIds) 
	{
		
		Integer rs = 0;
		try
		{
			SysUserRoleExample example = new SysUserRoleExample();
			example.createCriteria().andRoleIdEqualTo(roleId);
			List<SysUserRole> oldRel = userRoleMapper.selectByExample(example);
			List<String> userIdList = new ArrayList<String>();
			for(SysUserRole rel:oldRel){
				userIdList.add(rel.getUserId());
			}
			
			for(String userId:userIds)
			{
				//如果已存在则不再保存
				if(userIdList.contains(userId)){continue;}
				
				SysUserRole userRole = new SysUserRole();
				userRole.setRelId(IdUtil.createIdByTime());
				userRole.setRoleId(roleId);
				userRole.setUserId(userId);
				rs += userRoleMapper.insert(userRole);
			}
			//处理用户表
			SysUserExample ue = new SysUserExample();
			SysUserExample.Criteria uc = ue.createCriteria();
			uc.andUserIdIn(userIds);
			List<SysUser>users = userMapper.selectByExample(ue);
			for(SysUser u:users) {
				String role = u.getUserRole()+"";
				if(role.contains(roleId)) 
				{
					continue;
				}
				if(role.length() ==0) 
				{
					role += roleId;
				}else {
					role += (","+roleId);
				}
				u.setUserRole(role);
				userMapper.updateByPrimaryKey(u);
			}
		}catch(Exception e){
			return 0;
		}
		return rs;
	}

	@Override
	public Integer delUserRoleRel(String roleId, List<String> userIds) 
	{
		try
		{
			SysUserRoleExample example = new SysUserRoleExample();
			Criteria c = example.createCriteria();
			c.andRoleIdEqualTo(roleId);
			c.andUserIdIn(userIds);
			//更新用户角色字段
			SysUserExample ue = new SysUserExample();
			SysUserExample.Criteria uc = ue.createCriteria();
			uc.andUserIdIn(userIds);
			List<SysUser>users = userMapper.selectByExample(ue);
			for(SysUser u:users) {
				String role = u.getUserRole()+"";
				if(!role.contains(roleId)) 
				{
					continue;
				}
				String [] rs = role.split(",");
				StringBuffer sb = new StringBuffer();
				for(String r:rs) {
					if(!r.equals(roleId)) 
					{
						if(sb.length()>0) {
							sb.append(",");
						}
						sb.append(r);
					}
				}
				u.setUserRole(sb.toString());
				userMapper.updateByPrimaryKey(u);
			}
			return userRoleMapper.deleteByExample(example);
			
		}catch(Exception e){
			return 0;
		}
	}

	@Override
	public List<SysFunction> findFunctionsByRole(String roleId) 
	{
		SysRoleFunctionExample example = new SysRoleFunctionExample();
		example.createCriteria().andRoleIdEqualTo(roleId);
		List<SysRoleFunction> rolefuncrels = roleFunctionMapper.selectByExample(example);
		List<String> funcIds = new ArrayList<String>();
		for(SysRoleFunction rel:rolefuncrels){
			funcIds.add(rel.getFunctionId());
		}
		if(funcIds.size()==0){
			return new ArrayList<SysFunction>();
		}
		SysFunctionExample functionExample = new SysFunctionExample();
		functionExample.createCriteria().andIdIn(funcIds);
		return functionMapper.selectByExample(functionExample);
	}

	@Override
	public List<TreeNode> findFunctionTreeByRole(String roleId) 
	{
		List<SysFunction> funs = this.findFunctionsByRole(roleId);
		 
		List<TreeNode> nodes = new ArrayList<TreeNode>();
		if(funs == null || funs.size()==0){
			return nodes;
		}
		TreeNode rootNode = null;
		for(SysFunction func:funs)
		{
			TreeNode node = new TreeNode();
			node.setId(func.getId());
			node.setParentId(func.getParentId());
			node.setText(func.getName());
			nodes.add(node);
			
			System.out.println("funcID:"+func.getId()+"  name:"+func.getName());
			if(StringUtils.isBlank(func.getParentId())){
				rootNode = node;
			}
		}
		//构建树形结构(从根节点开始的树形结构,根节点的菜单parentId为空)
		List<TreeNode> orderNodes = new ArrayList<TreeNode>();
		try {
			if(nodes.size()>0){
				orderNodes = TreeNodeUtil.getfatherNode(nodes, rootNode.getId());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return orderNodes;
	}

	@Override
	public List<SysRole> findAllRoles() 
	{
		SysRoleExample example = new SysRoleExample();
		SysRoleExample.Criteria c = example.createCriteria();
		c.andRoleDelflagEqualTo(DelFlagEnum.STATUS_NORMAL.getCode());
		example.setOrderByClause("role_order asc");
		
		return roleMapper.selectByExample(example);
	}

	@Override
	public LayuiTableData selectRoleList(LayuiTableParam param) {
		//每页显示条数
		int pageSize = param.getLimit();
		//从第多少条开始
		int pageStart = (param.getPage()-1)*pageSize;
		//当前是第几页
		int pageNum = pageStart/pageSize + 1;
		// 1、设置分页信息，包括当前页数和每页显示的总计数
		PageHelper.startPage(pageNum, pageSize);
		
		SysRoleExample example = new SysRoleExample();
		SysRoleExample.Criteria suc = example.createCriteria();
		suc.andRoleDelflagEqualTo(DelFlagEnum.STATUS_NORMAL.getCode());
		if(!StringUtils.isBlank((String)param.getParam().get("roleName"))) 
		{
			suc.andRoleNameLike("%"+param.getParam().get("roleName")+"%");
		}
		List<SysRole> list = roleMapper.selectByExample(example);
		// 3、获取分页查询后的数据
		PageInfo<SysRole> pageInfo= new PageInfo<SysRole>(list);
		LayuiTableData data = new LayuiTableData();
		data.setData(pageInfo.getList());
		Long total = pageInfo.getTotal();
		data.setCount(total.intValue());
		return data;
	}

	@Override
	public String getRoleCode(SysRole role) 
	{
		return HanyuPinyinHelper.toPinyin(role.getRoleName());
	}
	/**
	 * 检查是否有同名角色
	 * @param role
	 * @return
	 */
	private boolean checkRoleDoubleName(SysRole role)
	{
		SysRoleExample example = new SysRoleExample();
		SysRoleExample.Criteria c = example.createCriteria();
		c.andRoleNameEqualTo(role.getRoleName());
		c.andRoleDelflagEqualTo(DelFlagEnum.STATUS_NORMAL.getCode());
		
		List<SysRole> rs = roleMapper.selectByExample(example);
		if(rs == null || rs.size() == 0) 
		{
			return false;
		}
		for(SysRole r:rs) 
		{
			if(!r.getRoleId().equals(role.getRoleId())) 
			{
				return true;
			}
		}
		return false;
	}
	
	public static void main(String [] args) 
	{
		String a = "e";
		String roleId = "a,b,c,d";
		String [] rs = roleId.split(",");
		StringBuffer sb = new StringBuffer();
		for(String r:rs) {
			if(!r.equals(a)) 
			{
				if(sb.length()>0) {
					sb.append(",");
				}
				sb.append(r);
			}
			
		}
		System.out.println(sb.toString());
	}
}

