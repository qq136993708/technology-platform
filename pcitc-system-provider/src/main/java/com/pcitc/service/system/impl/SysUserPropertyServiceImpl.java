package com.pcitc.service.system.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.pcitc.base.common.LayuiTableData;
import com.pcitc.base.common.LayuiTableParam;
import com.pcitc.base.common.TreeNode;
import com.pcitc.base.system.SysUserProperty;
import com.pcitc.base.system.vo.SysUserPropertyVo;
import com.pcitc.mapper.system.SysUserPropertyMapper;
import com.pcitc.service.system.SysUserPropertyService;

@Service
@CacheConfig(cacheNames = "userPropertyCache")
@Transactional(propagation = Propagation.REQUIRED, readOnly = false, rollbackFor = Exception.class)
public class SysUserPropertyServiceImpl implements SysUserPropertyService {

	@Autowired
	private StringRedisTemplate stringRedisTemplate;

	@Autowired
	private RedisTemplate redisTemplate;

	@Autowired
	private SysUserPropertyMapper userPropertyDao;

	@Override
	public List<TreeNode> selectUnitUserUnderOfRoot() throws Exception {
		List<TreeNode> orgs = userPropertyDao.selectUintTreeByRootId();
		orgs.forEach(obj -> obj.setIsParent(true));
		return orgs;
	}

	@Override
	public List<TreeNode> selectUserUnderOfUnitTree(String parentId, HttpServletRequest request) throws Exception {
		String path = request.getContextPath();
		// 集团下子节点的部门
		List<TreeNode> listOrg = userPropertyDao.selectChildUnitByUnitId(parentId);
		listOrg.forEach(obj -> obj.setIsParent(true));

		// 集团下子节点用户
		List<TreeNode> listUser = userPropertyDao.selectUserByUintId(parentId);
		listUser.forEach(obj -> obj.setIcon(path + "/image/humen.png"));
		listOrg.addAll(listUser);
		// 集团下子节点岗位
		List<TreeNode> listPost = userPropertyDao.selectPostByUintId(parentId);
		listPost.forEach(obj -> obj.setIsParent(true));
		listPost.forEach(obj -> obj.setIcon(path + "/image/team.png"));
		listOrg.addAll(listPost);

		// 部门下岗位下人员
		List<TreeNode> listPostUser = userPropertyDao.selectUserByPostId(parentId);
		listPostUser.forEach(obj -> obj.setIcon(path + "/image/humen.png"));
		listOrg.addAll(listPostUser);
		return listOrg;
	}

	@CacheEvict(value = "userPropertyCache", allEntries = true, beforeInvocation = true)
	@Override
	public Integer bantchInsertRelation(List<SysUserProperty> list, String dataType, List<String> userIds, List<String> currentPageList, String dataIds) throws Exception {

		int result = 500;
		String dataId = null;
		String dataTp = null;
		// 删除当前页的数据 保存勾选的数据
		// userPropertyDao.deleteByDataType(dataType,userIds);
		// currentPageList.forEach( property ->
		// userPropertyDao.deleteCurrentPage(property) );

		/*
		 * if(list!=null && list.size()>0){
		 * userPropertyDao.bantchInsertRelation(list); }
		 */
		if (list != null && list.size() > 0) {
			for (int i = 0; i < list.size(); i++) {
				// 根据userId和dataType查询一下，如果有配置过 ，则获取其配置的信息，修改
				if (dataType.equals("unit_id")) {
					SysUserProperty datatree = userPropertyDao.getDataIdByUserIdAndDataType(list.get(i).getUserId(), list.get(i).getDataType());
					if (datatree != null) {
						dataTp = datatree.getDataType();
						userPropertyDao.updateDataIdByUserIdAndDataType(dataIds, dataTp, list.get(i).getUserId());
					} else {
						userPropertyDao.insertSelective(list.get(i));
					}
				} else {
					SysUserProperty data = userPropertyDao.getDataIdByUserIdAndDataType(list.get(i).getUserId(), list.get(i).getDataType());
					if (data != null) {
						dataId = data.getDataId();
						dataTp = data.getDataType();
						/*
						 * if(StrUtil.isNotBlank(dataTp)&&!dataTp.contains(dataType
						 * )){ dataTp = dataTp + ","+dataType; }
						 */
						if (dataId != null) {
							// 如果数据库中有，则遍历当前页面的data_id,逐个替换，生成新的字符串dataId，最后拼接上要保存的dataId
							// ，依次插入
							if (currentPageList != null && currentPageList.size() > 0) {
								for (int j = 0; j < currentPageList.size(); j++) {
									if (dataId.contains("," + currentPageList.get(j) + ",")) {
										dataId = dataId.replaceAll("," + currentPageList.get(j) + ",", ",");
										dataId = dataId.replaceAll(",,", ",");
									}
								}
							}
							// 要保存的串
							dataId = dataId + list.get(i).getDataId();
							dataId = dataId.replaceAll(",,", ",");
							userPropertyDao.updateDataIdByUserIdAndDataType(dataId, dataTp, list.get(i).getUserId());
						}
					} else {
						if (list.get(i) != null && list.get(i).getDataId() != null) {
							list.get(i).setDataId(list.get(i).getDataId().replaceAll(",,", ","));
						}
						userPropertyDao.insertSelective(list.get(i));
					}
				}
			}

		}

		// 删除redis中的缓存,模糊匹配删除
		String keys = "userProperty_";
		redisTemplate.delete(redisTemplate.keys(keys + "*"));

		result = 200;
		return result;
	}

	@Override
	public LayuiTableData selectUserPropertyList(LayuiTableParam param) throws Exception {
		// 每页显示条数
		int pageSize = param.getLimit();
		// 从第多少条开始
		int pageStart = (param.getPage() - 1) * pageSize;
		// 当前是第几页
		int pageNum = pageStart / pageSize + 1;
		// 1、设置分页信息，包括当前页数和每页显示的总计数
		PageHelper.startPage(pageNum, pageSize);

		// String parentCode = (String) param.getParam().get("parentCode");

		// 1、设置分页信息，包括当前页数和每页显示的总计数
		PageHelper.startPage(pageNum, pageSize);
		// 2、执行查询
		SysUserPropertyVo property = new SysUserPropertyVo();

		// property.setUserId(tableInfo.getParentId());
		property.setUserId((String) param.getParam().get("userId"));
		// property.setDataType(tableInfo.getParam0());
		property.setDataType((String) param.getParam().get("dataType"));
		// property.setProjectName(tableInfo.getName());
		property.setProjectName((String) param.getParam().get("projectName"));

		List<SysUserPropertyVo> list = null;
		if (((String) param.getParam().get("dataType")).equals("project_id")) {
			list = userPropertyDao.selectUserPropertyList(property);
		} else if (((String) param.getParam().get("dataType")).equals("UNITCODE")) {
			list = userPropertyDao.selectUserPropertyUnitList(property);
		} else if (((String) param.getParam().get("dataType")).equals("G0DSM")) {
			list = userPropertyDao.selectUserPropertyDicList(property);
		}

		// 3、获取分页查询后的数据
		PageInfo<SysUserPropertyVo> pageInfo = new PageInfo<SysUserPropertyVo>(list);
		LayuiTableData data = new LayuiTableData();
		data.setData(pageInfo.getList());
		Long total = pageInfo.getTotal();
		data.setCount(total.intValue());
		return data;
	}

	/**
	 * @param dataTypes
	 * @return 查询某个人在某些数据控制属性上的具体控制数据内容,放redis缓存中
	 */
	// @Cacheable(key = "'userProperty_'+#userId", value = "userPropertyCache")
	public List<SysUserProperty> selectUserPropertyByUserAndType(String userId, String functionCode) {
		System.out.println("1=======selectUserPropertyByUserAndType");
		Map<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("userId", userId);
		paramMap.put("functionCode", functionCode);
		List<SysUserProperty> list = userPropertyDao.selectUserPropertyByUserAndType(paramMap);

		return list;
	}

	@Override
	public List<TreeNode> selectUnitTree(String userId) throws Exception {
		SysUserPropertyVo property = new SysUserPropertyVo();
		// 临时数据
		property.setDataType("unit_id");
		property.setUserId(userId);
		List<TreeNode> listOrg = userPropertyDao.selectUserPropertyUnitTree(property);
		return listOrg;
	}

	@Override
	public List<TreeNode> selectChildByChild(String parentId) throws Exception {
		List<TreeNode> users = null;
		List<TreeNode> listPost = null;
		List<TreeNode> listPostUser = null;

		users = userPropertyDao.selectUserByUnitCode(parentId);
		listPost = userPropertyDao.selectPostByUnitCode(parentId);
		listPostUser = userPropertyDao.selectPostUserByUnitCode(parentId);
		users.addAll(listPost);
		users.addAll(listPostUser);

		return users;
	}

	/**
	 * @param dataTypes
	 * @return 查询某人在某个dataType下管理的数据
	 */
	public List<SysUserProperty> selectUserPropertyByUserIdAndDataType(String userId, String dataType) {
		System.out.println("1=======selectUserPropertyByUserIdAndDataType");

		Map<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("userId", userId);
		paramMap.put("dataType", dataType);
		List<SysUserProperty> list = userPropertyDao.selectUserPropertyByUserAndType(paramMap);
		return list;
	}

}
