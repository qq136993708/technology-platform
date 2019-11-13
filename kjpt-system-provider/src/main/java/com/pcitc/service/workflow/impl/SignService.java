package com.pcitc.service.workflow.impl;

import java.util.Arrays;
import java.util.List;

import org.activiti.engine.impl.pvm.delegate.ActivityExecution;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

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
	public List<String> getUsers(ActivityExecution execution, String group_id) {
		System.out.println("0=============CountersignService=getUsers");
		System.out.println("1=============CountersignService=getUsers===========" + group_id);
		//Set<String> userIds = new LinkedHashSet<String>();
		String nodeId = execution.getActivity().getId();
		if (execution.getVariable("signUser_" + nodeId) == null) {
			System.out.println("2=============CountersignService=getUsers===" + nodeId);
		}

		// 分解group
		String[] groups = group_id.split("-");
		//userIds.addAll(sysUserMapper.findUserByGroupIdFromACT(Arrays.asList(groups)));

		List<String> userList = sysUserMapper.findUserByGroupIdFromACT(Arrays.asList(groups));
		execution.setVariable("signUser_" + nodeId, userList);
		System.out.println("3=============CountersignService=getUsers"+userList);
		System.out.println("4=============CountersignService=getUsers"+userList.size());
		
		return userList;
	}

}
