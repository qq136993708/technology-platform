package com.pcitc.service.system.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.alibaba.fastjson.JSONObject;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.pcitc.base.common.LayuiTableData;
import com.pcitc.base.common.LayuiTableParam;
import com.pcitc.base.common.enums.DelFlagEnum;
import com.pcitc.base.system.SysCollect;
import com.pcitc.base.system.SysCollectExample;
import com.pcitc.base.system.SysCollectExample.Criteria;
import com.pcitc.base.system.SysFunction;
import com.pcitc.base.system.SysUser;
import com.pcitc.base.system.SysUserExample;
import com.pcitc.base.system.SysUserPost;
import com.pcitc.base.system.SysUserPostExample;
import com.pcitc.base.system.SysUserProperty;
import com.pcitc.base.system.SysUserRole;
import com.pcitc.base.system.SysUserRoleExample;
import com.pcitc.base.system.SysUserUnit;
import com.pcitc.base.system.SysUserUnitExample;
import com.pcitc.base.util.DataTableInfo;
import com.pcitc.base.util.IdUtil;
import com.pcitc.base.util.MyBeanUtils;
import com.pcitc.mapper.system.SysCollectMapper;
import com.pcitc.mapper.system.SysFunctionMapper;
import com.pcitc.mapper.system.SysUserMapper;
import com.pcitc.mapper.system.SysUserPostMapper;
import com.pcitc.mapper.system.SysUserPropertyMapper;
import com.pcitc.mapper.system.SysUserRoleMapper;
import com.pcitc.mapper.system.SysUserUnitMapper;
import com.pcitc.service.system.UserService;

//@CachePut 是先执行方法，然后把返回值保存或更新到缓存中
//@Cacheable 是先查询缓存，如果缓存有值，则不执行方法了；否则执行方法，然后把返回值保存到缓存
//@CacheEvict 清除缓存元素
@Service("userService")
@CacheConfig(cacheNames = "userCache")
@Transactional(propagation = Propagation.REQUIRED, readOnly = false, rollbackFor = Exception.class)
public class UserServiceImpl implements UserService {

	@Autowired
	private SysUserMapper userMapper;

	@Autowired
	private SysFunctionMapper functionMapper;

	@Autowired
	private SysUserRoleMapper userRoleMapper;

	@Autowired
	private SysUserUnitMapper userUnitMapper;

	@Autowired
	private SysUserPostMapper userPostMapper;

	@Autowired
	private SysUserPropertyMapper sysUserPropertyMapper;
	
	@Autowired
	private SysCollectMapper sysCollectMapper;

	@Override
	public SysUser selectUserByUserId(String userId) {
		System.out.println("userid::::" + userId);
		return userMapper.selectByPrimaryKey(userId);
	}

	@Override
	public Integer updateUser(SysUser user) {
		SysUser oluser = userMapper.selectByPrimaryKey(user.getUserId());
		if (oluser != null) {
			// 处理角色(如果有变化 先删除后保存)
			if (user.getUserRole() != null && !user.getUserRole().equals(oluser.getUserRole())) {
				updateUserRole(user);
			}
			// 处理组织机构（如果有变化 先删除后保存）
			if (user.getUserUnit() != null && !user.getUserUnit().equals(oluser.getUserUnit())) {
				this.updateUserUnit(user);
			}
			// 处理岗位（如果有变化 先删除后保存）
			if (user.getUserPost() != null && !user.getUserPost().equals(oluser.getUserPost())) {
				this.updateUserPost(user);
			}

			MyBeanUtils.copyPropertiesIgnoreNull(user, oluser);
		}
		return userMapper.updateByPrimaryKey(oluser);
	}

	@Override
	public int deleteUser(String userId) {
		SysUser user = userMapper.selectByPrimaryKey(userId);
		if (user != null) {
			user.setUserDelflag(DelFlagEnum.STATUS_DEL.getCode());
			return userMapper.updateByPrimaryKey(user);
		}
		return 0;
	}

	@Override
	public Integer insertUser(SysUser user) {
		SysUser newuser = (SysUser) MyBeanUtils.createBean(SysUser.class);
		MyBeanUtils.copyPropertiesIgnoreNull(user, newuser);
		// 处理岗位、角色、权限(如果有变化 先删除后保存)
		this.updateRoleUnitPost(newuser);
		return userMapper.insert(newuser);
	}

	@Override
	public List<SysUser> getAllUsers() {
		return userMapper.selectByExample(new SysUserExample());
	}

	@Override
	public LayuiTableData selectUserByPage(LayuiTableParam param) {
		SysUserExample example = new SysUserExample();
		SysUserExample.Criteria c = example.createCriteria();
		if (param.getParam().get("userName") != null && !StringUtils.isBlank(param.getParam().get("userName") + "")) {
			c.andUserNameLike("%" + param.getParam().get("userName") + "%");
		}
		example.setOrderByClause("user_create_time desc");

		return this.findByExample(param, example);// int pageLength = 10;
		// int startPage = 0;
		// Map<String,Object> paramMap = param.getParam();
		//
		// String userName = (String)paramMap.get("userName");
		// String roleId = (String)paramMap.get("roleId");
		// //查询当前角色内用户
		// String roleIn = (String)paramMap.get("roleIn");
		// //查询当前角色外用户
		// String roleNot = (String)paramMap.get("roleNot");
		//
		// SysUserExample example = new SysUserExample();
		// SysUserExample.Criteria suc = example.createCriteria();
		// //如果是根据角色查询用户
		// if(roleId != null){//如果参数中存在角色
		// SysUserRoleExample userRoleExample = new SysUserRoleExample();
		// SysUserRoleExample.Criteria surc = userRoleExample.createCriteria();
		// surc.andRoleIdEqualTo(roleId);
		//
		// List<SysUserRole> userRoles =
		// userRoleMapper.selectByExample(userRoleExample);
		// List<String> userIds = new ArrayList<String>();
		// for(SysUserRole ur:userRoles){
		// userIds.add(ur.getUserId());
		// }
		// if(userIds.size()==0){
		// userIds.add("-1");
		// }
		// if(roleIn !=null && userIds.size()>0){
		// suc.andUserIdIn(userIds);
		// }
		// if(roleNot != null && userIds.size()>0){
		// suc.andUserIdNotIn(userIds);
		// }
		// }
		//
		// startPage = startPage/pageLength+1;
		// // 1、设置分页信息，包括当前页数和每页显示的总计数
		// PageHelper.startPage(startPage, pageLength);
		// // 2、执行查询
		// suc.andUserDelflagEqualTo(DelFlagEnum.STATUS_NORMAL.getCode());
		// if(!StringUtils.isBlank(userName)){
		// suc.andUserNameLike("%"+userName+"%");
		// }
		// //是否属于当前角色
		// List<SysUser> list = userMapper.selectByExample(example);
		// // 3、获取分页查询后的数据
		// PageInfo<SysUser> pageInfo = new PageInfo<SysUser>(list);
		// // 4、封装需要返回的分页实体
		// JSONObject retJson = new JSONObject();
		// retJson.put("totalCount", pageInfo.getTotal());
		// retJson.put("list", list);
		// return retJson;
	}

	/**
	 * @author zhf
	 * @date 2018年5月17日 上午9:30:34 包含用户本身的熟悉、所拥有的角色、菜单等
	 */
	// @Cacheable(key = "'userDetails_'+#userId", value = "userCache")
	public SysUser selectUserDetailsByUserId(String userId) throws Exception {
		SysUser user = userMapper.selectByPrimaryKey(userId);
		System.out.println(user+"======selectUserDetailsByUserId------------"+userId);
		
		// 此人有哪些菜单权限，每个菜单对应的数据控制项
		List<SysFunction> funList = functionMapper.selectFuntionByUserId(userId);
		
		System.out.println("======funList------------"+funList);
		user.setFunList(funList);
		
		// 此人收藏的菜单
		SysCollectExample sysCollectExample = new SysCollectExample();
		Criteria cri = sysCollectExample.createCriteria();
		cri.andUserIdEqualTo(userId);
		cri.andStatusEqualTo("1");
		List<SysCollect> scList = sysCollectMapper.selectByExample(sysCollectExample);
		user.setScList(scList);
		return user;
	}

	@Override
	public int deleteUserReal(String userId) {
		Integer rs = 0;
		try {
			SysUserRoleExample example = new SysUserRoleExample();
			example.createCriteria().andUserIdEqualTo(userId);

			rs += userRoleMapper.deleteByExample(example);
			rs += userMapper.deleteByPrimaryKey(userId);
		} catch (Exception e) {
			return rs;
		}
		return rs;
	}

	@Override
	public List<Boolean> userValidate(SysUser user) {
		// 验证用户名是否重复
		boolean checkUserName = true;
		// boolean checkMobile = true;
		boolean checkMail = true;
		SysUserExample example = new SysUserExample();
		example.createCriteria().andUserNameEqualTo(user.getUserName());
		List<SysUser> users = userMapper.selectByExample(example);
		if (users.size() != 0 && !users.get(0).getUserId().equals(user.getUserId())) {
			checkUserName = false;
		}
		// 验证手机号不能重复
		/*
		 * example = new SysUserExample();
		 * example.createCriteria().andUserMobileEqualTo(user.getUserMobile());
		 * users = userMapper.selectByExample(example); if(users.size() != 0 &&
		 * !users.get(0).getUserId().equals(user.getUserId())){ checkMobile =
		 * false; }
		 */
		// 验证邮箱名
		example = new SysUserExample();
		example.createCriteria().andUserMailEqualTo(user.getUserMail());
		users = userMapper.selectByExample(example);
		if (users.size() != 0 && !users.get(0).getUserId().equals(user.getUserId())) {
			checkMail = false;
		}
		List<Boolean> rs = new ArrayList<Boolean>();
		rs.add(checkUserName);
		// rs.add(checkMobile);
		rs.add(checkMail);
		return rs;
	}

	/**
	 * @param roleCodes
	 * @return 根据角色编码（多个），获取所属人员
	 */
	public Object findUserByRoleCodes(Map<String, Object> paramMap) {
		int limit = 15;
		int page = 0;

		if (paramMap.get("limit") != null) {
			limit = Integer.parseInt(paramMap.get("limit").toString());
		}
		if (paramMap.get("page") != null) {
			page = Integer.parseInt(paramMap.get("page").toString());
		}
		if (paramMap.get("userName") != null && paramMap.get("userName").equals("")) {
			paramMap.put("userName", null);
		}

		// 1、设置分页信息，包括当前页数和每页显示的总计数
		PageHelper.startPage(page, limit);

		// 2、执行查询
		List<SysUser> list = userMapper.findUserByRoleCodes(paramMap);

		// 3、获取分页查询后的数据
		PageInfo<SysUser> pageInfo = new PageInfo<SysUser>(list);

		// 4、封装需要返回的分页实体
		LayuiTableData retData = new LayuiTableData();
		retData.setData(list);
		retData.setCount((int) pageInfo.getTotal());
		return retData;
	}

	@Override
	public JSONObject findUserByUnit(DataTableInfo tableInfo) {
		int iDisplayLength = 10;
		int iDisplayStart = 0;

		if (tableInfo.getiDisplayLength() != null) {
			iDisplayLength = Integer.parseInt(tableInfo.getiDisplayLength().toString());
		}
		if (tableInfo.getiDisplayStart() != null) {
			iDisplayStart = Integer.parseInt(tableInfo.getiDisplayStart().toString());
		}
		SysUserExample example = new SysUserExample();
		example.createCriteria().andUserUnitLike(tableInfo.getParams().get("unitPath") + "%");

		iDisplayStart = iDisplayStart / iDisplayLength + 1;
		// 1、设置分页信息，包括当前页数和每页显示的总计数
		PageHelper.startPage(iDisplayStart, iDisplayLength);
		// 2、执行查询
		List<SysUser> list = userMapper.selectByExample(example);
		// 3、获取分页查询后的数据
		PageInfo<SysUser> pageInfo = new PageInfo<SysUser>(list);
		// 4、封装需要返回的分页实体
		JSONObject retJson = new JSONObject();
		retJson.put("totalCount", pageInfo.getTotal());
		retJson.put("list", list);
		return retJson;
	}

	private void updateRoleUnitPost(SysUser user) {
		updateUserRole(user);
		updateUserPost(user);
		updateUserUnit(user);
	}

	/**
	 * 更新角色
	 * 
	 * @param user
	 */
	private void updateUserRole(SysUser user) {
		SysUserRoleExample example = new SysUserRoleExample();
		SysUserRoleExample.Criteria ec = example.createCriteria();
		ec.andUserIdEqualTo(user.getUserId());
		userRoleMapper.deleteByExample(example);
		if (StringUtils.isBlank(user.getUserRole())) {
			return;
		}
		String[] roles = user.getUserRole().split(",");// 逗号分割
		for (String roleId : roles) {
			SysUserRole sur = new SysUserRole();
			sur.setRelId(IdUtil.createIdByTime());
			sur.setRoleId(roleId);
			sur.setUserId(user.getUserId());
			userRoleMapper.insert(sur);
		}
	}

	private void updateUserPost(SysUser user) {
		SysUserPostExample example = new SysUserPostExample();
		SysUserPostExample.Criteria ec = example.createCriteria();
		ec.andUserIdEqualTo(user.getUserId());
		userPostMapper.deleteByExample(example);
		if (StringUtils.isBlank(user.getUserPost())) {
			return;
		}
		String[] posts = user.getUserPost().split(",");// 逗号分割
		for (String postId : posts) {
			SysUserPost sur = new SysUserPost();
			sur.setRelId(IdUtil.createIdByTime());
			sur.setPostId(postId);
			sur.setUserId(user.getUserId());
			userPostMapper.insert(sur);
		}
	}

	private void updateUserUnit(SysUser user) {
		SysUserUnitExample example = new SysUserUnitExample();
		SysUserUnitExample.Criteria ec = example.createCriteria();
		ec.andUserIdEqualTo(user.getUserId());
		userUnitMapper.deleteByExample(example);
		if (StringUtils.isBlank(user.getUserUnit())) {
			return;
		}
		String[] units = user.getUserUnit().split(",");// 逗号分割
		for (String unitId : units) {
			SysUserUnit sur = new SysUserUnit();
			sur.setRelId(IdUtil.createIdByTime());
			sur.setUnitId(unitId);
			sur.setUserId(user.getUserId());
			userUnitMapper.insert(sur);
		}
	}

	@Override
	public LayuiTableData selectUserList(LayuiTableParam param) {
		SysUserExample example = new SysUserExample();

		SysUserExample.Criteria suc = example.createCriteria();
		SysUserExample.Criteria suc2 = example.createCriteria();
		suc.andUserDelflagEqualTo(DelFlagEnum.STATUS_NORMAL.getCode());
		suc2.andUserDelflagEqualTo(DelFlagEnum.STATUS_NORMAL.getCode());
		if (!StringUtils.isBlank((String) param.getParam().get("userName"))) {
			// 登录名称
			suc.andUserNameLike("%" + param.getParam().get("userName") + "%");
			// 显示名称
			suc2.andUserDispLike("%" + param.getParam().get("userName") + "%");
		}
		if (!StringUtils.isBlank((String) param.getParam().get("userKind"))) {
			suc.andUserKindEqualTo(param.getParam().get("userKind").toString());
			suc2.andUserKindEqualTo(param.getParam().get("userKind").toString());
		}
		if (!StringUtils.isBlank((String) param.getParam().get("userUnit"))) {
			suc.andUserUnitLike("%" + param.getParam().get("userUnit").toString() + "%");
			suc2.andUserUnitLike("%" + param.getParam().get("userUnit").toString() + "%");
		}
		example.or(suc);
		example.or(suc2);
		return this.findByExample(param, example);
	}

	@Override
	public Integer delUsers(List<String> userIds) {
		if (userIds == null || userIds.size() == 0) {
			return 0;
		}
		Integer rs = 0;
		for (String userId : userIds) {
			SysUser user = userMapper.selectByPrimaryKey(userId);
			if (user != null) {
				user.setUserDelflag(DelFlagEnum.STATUS_DEL.getCode());
				rs += userMapper.updateByPrimaryKey(user);
			}
		}
		return rs;
	}

	@Override
	public LayuiTableData selectUserListByRole(LayuiTableParam param) {
		String roleId = (String) param.getParam().get("roleId");
		String userName = (String) param.getParam().get("userName");

		SysUserRoleExample roleExample = new SysUserRoleExample();
		SysUserRoleExample.Criteria c = roleExample.createCriteria();
		c.andRoleIdEqualTo(roleId);
		List<SysUserRole> roles = userRoleMapper.selectByExample(roleExample);
		List<String> userIds = new ArrayList<String>();
		for (SysUserRole r : roles) {
			userIds.add(r.getUserId());
		}
		// 避免空值查询异常
		if (userIds.size() == 0) {
			userIds.add("-1");
		}

		SysUserExample userExample = new SysUserExample();
		SysUserExample.Criteria uc = userExample.createCriteria();
		if (userName != null) {
			uc.andUserDispLike("%" + userName + "%");
		}
		uc.andUserIdIn(userIds);
		uc.andUserDelflagEqualTo(DelFlagEnum.STATUS_NORMAL.getCode());
		return this.findByExample(param, userExample);
	}

	@Override
	public LayuiTableData selectNotInRoleUserList(LayuiTableParam param) {
		SysUserExample example = new SysUserExample();
		SysUserExample.Criteria suc = example.createCriteria();
		String roleId = param.getParam().get("roleId").toString();
		String userName = (String) param.getParam().get("userName");

		// 查询该角色下已绑定的用户
		SysUserRoleExample userRoleExample = new SysUserRoleExample();
		SysUserRoleExample.Criteria surc = userRoleExample.createCriteria();
		surc.andRoleIdEqualTo(roleId);

		List<SysUserRole> userRoles = userRoleMapper.selectByExample(userRoleExample);
		List<String> userIds = new ArrayList<String>();
		// 避免userId为空
		userIds.add("-1");
		for (SysUserRole ur : userRoles) {
			userIds.add(ur.getUserId());
		}

		suc.andUserDelflagEqualTo(DelFlagEnum.STATUS_NORMAL.getCode());
		suc.andUserIdNotIn(userIds);
		if (userName != null) {
			suc.andUserDispLike("%" + userName + "%");
		}
		return findByExample(param, example);
	}

	private LayuiTableData findByExample(LayuiTableParam param, SysUserExample example) {
		// 每页显示条数
		int pageSize = param.getLimit();
		// 从第多少条开始
		int pageStart = (param.getPage() - 1) * pageSize;
		// 当前是第几页
		int pageNum = pageStart / pageSize + 1;
		// 1、设置分页信息，包括当前页数和每页显示的总计数
		PageHelper.startPage(pageNum, pageSize);

		List<SysUser> list = userMapper.selectByExample(example);
		// 3、获取分页查询后的数据
		PageInfo<SysUser> pageInfo = new PageInfo<SysUser>(list);
		LayuiTableData data = new LayuiTableData();
		data.setData(pageInfo.getList());
		Long total = pageInfo.getTotal();
		data.setCount(total.intValue());
		return data;
	}

	@Override
	public SysUser selectUserByUserName(String username) {
		SysUserExample example = new SysUserExample();
		SysUserExample.Criteria suc = example.createCriteria();
		suc.andUserDelflagEqualTo(DelFlagEnum.STATUS_NORMAL.getCode());
		suc.andUserNameEqualTo(username);

		List<SysUser> us = userMapper.selectByExample(example);
		if (us != null && us.size() > 0) {
			return us.get(0);
		}
		return null;
	}

	@Override
	public Integer insertUserUnit(SysUserUnit user) {
		return userUnitMapper.insert(user);
	}

	/**
	 * @param paramMap
	 * @return 查询用户信息，包含所属部门，多部门以“，”分开显示
	 */
	public JSONObject selectUserDetail(Map<String, Object> paramMap) {
		if (paramMap.get("userName") != null && paramMap.get("userName").equals("")) {
			paramMap.put("userName", null);
		}
		if (paramMap.get("userPassword") != null && paramMap.get("userPassword").equals("")) {
			paramMap.put("userPassword", null);
		}

		List<SysUser> list = userMapper.selectUserDetail(paramMap);
		
		/*
		List<String> instituteNameList = new ArrayList<String>();
		List<String> instituteCodeList = new ArrayList<String>();
		// 本人管理的研究院
		for (int i = 0; i < list.size(); i++) {
			SysUser su = list.get(i);
			SysUserProperty sup = sysUserPropertyMapper.getDataIdByUserIdAndDataType(su.getUserId(), "G0DSM");
			if (sup != null) {
				if (sup.getDataId() != null && sup.getDataId().contains("1120")) {
					instituteNameList.add("勘探院");
					instituteCodeList.add("1120,1123,1124,1127");
				}
				if (sup.getDataId() != null && sup.getDataId().contains("1130")) {
					instituteNameList.add("物探院");
					instituteCodeList.add("1130");
				}
				if (sup.getDataId() != null && sup.getDataId().contains("4360")) {
					instituteNameList.add("工程院");
					instituteCodeList.add("4360");
				}
				if (sup.getDataId() != null && sup.getDataId().contains("1020")) {
					instituteNameList.add("石科院");
					instituteCodeList.add("1020");
				}
				if (sup.getDataId() != null && sup.getDataId().contains("1060")) {
					instituteNameList.add("大连院");
					instituteCodeList.add("1060,1061");
				}
				if (sup.getDataId() != null && sup.getDataId().contains("1040")) {
					instituteNameList.add("北化院");
					instituteCodeList.add("1040,1041");
				}
				if (sup.getDataId() != null && sup.getDataId().contains("1080")) {
					instituteNameList.add("上海院");
					instituteCodeList.add("1080");
				}
				if (sup.getDataId() != null && sup.getDataId().contains("1100")) {
					instituteNameList.add("安工院");
					instituteCodeList.add("1100,1101");
				}
			}
			su.setInstituteCodes(instituteCodeList);
			su.setInstituteNames(instituteNameList);
		}*/
		
		JSONObject retJson = new JSONObject();
		retJson.put("list", list);
		return retJson;
	}
	
	
	
	
	
	@Override
	public LayuiTableData querySysUserListByPage(LayuiTableParam param) {
		//每页显示条数
		int pageSize = param.getLimit();
		//从第多少条开始
		int pageStart = (param.getPage()-1)*pageSize;
		//当前是第几页
		int pageNum = pageStart/pageSize + 1;
		// 1、设置分页信息，包括当前页数和每页显示的总计数
		PageHelper.startPage(pageNum, pageSize);
		SysUser vo = new SysUser();
		String unitId = (String) param.getParam().get("unitId");
		if(unitId != null && !"".equals(unitId)) {
			vo.setUserUnit(unitId);
		}
		String userDisp = (String) param.getParam().get("userDisp");
		if(userDisp != null && !"".equals(userDisp)) {
			vo.setUserDisp(userDisp);
		}
		List<SysUser> list = userMapper.querySysUserListByPage(vo);
		int total = userMapper.countByQuerySysUserList(vo).intValue();
		PageInfo<SysUser> pageInfo= new PageInfo<SysUser>(list);
		LayuiTableData data = new LayuiTableData();
		data.setData(pageInfo.getList());
		data.setCount(total);
		return data;
	}
	
	
	
	
	public LayuiTableData getSysUserListByUserUnitPage(LayuiTableParam param) {
		//每页显示条数
		int pageSize = param.getLimit();
		//从第多少条开始
		int pageStart = (param.getPage()-1)*pageSize;
		//当前是第几页
		int pageNum = pageStart/pageSize + 1;
		// 1、设置分页信息，包括当前页数和每页显示的总计数
		PageHelper.startPage(pageNum, pageSize);
		SysUser vo = new SysUser();
		String unitId = (String) param.getParam().get("unitId");
		if(unitId != null && !"".equals(unitId)) {
			vo.setUserUnit(unitId);
		}
		String userDisp = (String) param.getParam().get("userDisp");
		if(userDisp != null && !"".equals(userDisp)) {
			vo.setUserDisp(userDisp);
		}
		List<SysUser> list = userMapper.getSysUserListByUserUnit(vo);
		int total = userMapper.getSysUserCountByUserUnit(vo).intValue();
		PageInfo<SysUser> pageInfo= new PageInfo<SysUser>(list);
		LayuiTableData data = new LayuiTableData();
		data.setData(pageInfo.getList());
		data.setCount(total);
		return data;
	}
	
	/**
	 * mybatis自带查询用户信息
	 */
	public List<SysUser> selectByExample(SysUserExample example) {
		return userMapper.selectByExample(example);
	}


}
