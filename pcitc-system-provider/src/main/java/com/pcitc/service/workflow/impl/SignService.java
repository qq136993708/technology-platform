package com.pcitc.service.workflow.impl;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

import org.activiti.engine.impl.pvm.delegate.ActivityExecution;
import org.activiti.engine.task.IdentityLink;
import org.activiti.engine.task.IdentityLinkType;
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
import com.pcitc.base.util.StrUtil;
import com.pcitc.mapper.system.SysRoleMapper;
import com.pcitc.mapper.system.SysUserMapper;
import com.pcitc.mapper.system.SysUserRoleMapper;

// 流程图中涉及到会签的时候，获取
@Service("signService")
//@CacheConfig(cacheNames = "signCache")
@Transactional(propagation = Propagation.REQUIRED, readOnly = false, rollbackFor = Exception.class)
public class SignService {

	@Autowired
	private SysRoleMapper roleMapper;

	@Autowired
	private SysUserRoleMapper userRoleMapper;

	@Autowired
	private SysUserMapper sysUserMapper;

	// group_id 对应act视图里面的act_id_membership中的group_id
	//@Cacheable(key = "'sign_'+#role", value = "signCache")
	public Set<String> getUsers(ActivityExecution execution, String group_id) {
		System.out.println("0=============CountersignService=getUsers");
		System.out.println("1=============CountersignService=getUsers===========" + group_id);
		Set<String> userIds = new LinkedHashSet<String>();
		String nodeId = execution.getActivity().getId();
		if (execution.getVariable("signUser_" + nodeId) == null) {
			System.out.println("2=============CountersignService=getUsers===" + nodeId);
		}

		// 分解group
		String[] groups = group_id.split("-");
		for (int i = 0; i < groups.length; i++) {
			userIds.addAll(sysUserMapper.findUserByGroupIdFromACT(groups[i]));
		}

		execution.setVariable("signUser_" + nodeId, userIds);
		System.out.println("3=============CountersignService=getUsers"+userIds);
		System.out.println("4=============CountersignService=getUsers"+userIds.size());
		
		return userIds;
	}

}
