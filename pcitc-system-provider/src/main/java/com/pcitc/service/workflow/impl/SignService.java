package com.pcitc.service.workflow.impl;

import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

import org.activiti.engine.impl.pvm.delegate.ActivityExecution;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.pcitc.base.system.SysRole;
import com.pcitc.base.system.SysRoleExample;
import com.pcitc.base.system.SysUserRole;
import com.pcitc.base.system.SysUserRoleExample;
import com.pcitc.mapper.system.SysRoleMapper;
import com.pcitc.mapper.system.SysUserRoleMapper;

@Service("signService")
@CacheConfig(cacheNames = "signCache")
@Transactional(propagation = Propagation.REQUIRED, readOnly = false, rollbackFor = Exception.class)
public class SignService {
	
	@Autowired
	private SysRoleMapper roleMapper;
	
	@Autowired
	private SysUserRoleMapper userRoleMapper;

	@Cacheable(key = "'sign_'+#role", value = "signCache")
	public Set<String> getUsers(ActivityExecution execution, String role) {
		System.out.println("0=============CountersignService=getUsers");
		System.out.println("1=============CountersignService=getUsers==========="+role);
		Set<String> userIds = new LinkedHashSet<String>();
		String nodeId=execution.getActivity().getId();
		if (execution.getVariable("signUser_"+nodeId) == null) {
			System.out.println("2=============CountersignService=getUsers==="+nodeId);
			
		}
		SysRoleExample rexample = new SysRoleExample();
		// 角色编码
		rexample.createCriteria().andRoleFlagEqualTo(role);
		List<SysRole> roleList = roleMapper.selectByExample(rexample);
		if (roleList != null && roleList.size() > 0) {
			SysUserRoleExample example = new SysUserRoleExample();
			example.createCriteria().andRoleIdEqualTo(roleList.get(0).getRoleId());
			List<SysUserRole> userRoles = userRoleMapper.selectByExample(example);
			for (SysUserRole ur : userRoles) {
				userIds.add(ur.getUserId());
			}
		}
		
		execution.setVariable("signUser_"+nodeId, userIds);		
		System.out.println("3=============CountersignService=getUsers");
		
		return userIds;
	}
    
}
