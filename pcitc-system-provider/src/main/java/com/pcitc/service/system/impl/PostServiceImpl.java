package com.pcitc.service.system.impl;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.pcitc.base.common.LayuiTableData;
import com.pcitc.base.common.LayuiTableParam;
import com.pcitc.base.common.enums.DelFlagEnum;
import com.pcitc.base.system.SysFunction;
import com.pcitc.base.system.SysFunctionExample;
import com.pcitc.base.system.SysPost;
import com.pcitc.base.system.SysPostExample;
import com.pcitc.base.system.SysPostFunction;
import com.pcitc.base.system.SysPostFunctionExample;
import com.pcitc.base.system.SysUnit;
import com.pcitc.base.system.SysUser;
import com.pcitc.base.system.SysUserExample;
import com.pcitc.base.system.SysUserPost;
import com.pcitc.base.system.SysUserPostExample;
import com.pcitc.base.util.DateUtil;
import com.pcitc.base.util.HanyuPinyinHelper;
import com.pcitc.base.util.IdUtil;
import com.pcitc.mapper.system.SysFunctionMapper;
import com.pcitc.mapper.system.SysPostFunctionMapper;
import com.pcitc.mapper.system.SysPostMapper;
import com.pcitc.mapper.system.SysUnitMapper;
import com.pcitc.mapper.system.SysUserMapper;
import com.pcitc.mapper.system.SysUserPostMapper;
import com.pcitc.service.system.PostService;
import com.pcitc.service.system.UnitService;
import com.pcitc.utils.StringUtils;

@Service("postService")
@Transactional(propagation = Propagation.REQUIRED, readOnly = false, rollbackFor = Exception.class)
public class PostServiceImpl implements PostService 
{

	@Autowired
	private SysPostMapper postMapper;
	
	@Autowired
	private SysFunctionMapper functionMapper;
	
	@Autowired
	private SysPostFunctionMapper postFunctionMapper;
	
	@Autowired
	private SysUnitMapper unitMapper;
	
	@Autowired
	private SysUserPostMapper sysUserPostMapper;
	
	@Autowired
	private SysUserMapper sysUserMapper;
	
	@Autowired
	private UnitService unitService;
	
	
	//private SysUserPostMapper userPostMapper;
	
	@Override
	public List<SysPost> findByUnit(String unintId) 
	{
		SysPostExample example = new SysPostExample();
		SysPostExample.Criteria c = example.createCriteria();
		
		c.andPostDelflagEqualTo(DelFlagEnum.STATUS_NORMAL.getCode());
		c.andPostUnitEqualTo(unintId);
		return postMapper.selectByExample(example);
	}

	@Override
	public SysPost findById(String postId) 
	{
		return postMapper.selectByPrimaryKey(postId);
	}

	@Override
	public Integer saveSysPost(SysPost post)
	{
		SysUnit unit = unitMapper.selectByPrimaryKey(post.getPostUnit());
		post.setPostCode(unit.getUnitCode()+"_"+HanyuPinyinHelper.toPinyin(post.getPostName()));
		post.setPostLevel(unit.getUnitLevel()+1);
		return postMapper.insertSelective(post);
	}
	@Override
	public Integer updatePost(SysPost post) 
	{
		try
		{
			return postMapper.updateByPrimaryKey(post);
		}catch(Exception e){
			return 0;
		}
	}
	@Override
	public Integer delPost(Serializable id) 
	{
		try
		{
			SysPost post = postMapper.selectByPrimaryKey(id.toString());
			if(post != null)
			{
				post.setPostDelflag(DelFlagEnum.STATUS_DEL.getCode());
				return postMapper.updateByPrimaryKey(post);
			}
		}catch(Exception e){
			return 0;
		}
		return 0;
	}

	@Override
	public Integer delPostReal(Serializable id) 
	{
		try
		{
			SysPost post = postMapper.selectByPrimaryKey(id.toString());
			if(post != null)
			{
				SysUserPostExample example = new SysUserPostExample();
				SysUserPostExample.Criteria c = example.createCriteria();
				c.andPostIdEqualTo(post.getPostId());
				
				List<SysUserPost> rels = sysUserPostMapper.selectByExample(example);
				if(rels != null && rels.size() >0) {
					for(SysUserPost rel:rels) {
						sysUserPostMapper.deleteByPrimaryKey(rel.getRelId());
					}
				}
				return postMapper.deleteByPrimaryKey(post.getPostId());
			}
		}catch(Exception e){
			return 0;
		}
		return 0;
	}

	@Override
	public LayuiTableData findByUnit(LayuiTableParam param) 
	{
		
		SysPostExample example = new SysPostExample();
		SysPostExample.Criteria c = example.createCriteria();
		c.andPostDelflagEqualTo(DelFlagEnum.STATUS_NORMAL.getCode());
		c.andPostUnitEqualTo(param.getParam().get("unitId").toString());
		
		return selectUnitByExample(param,example);
		
	}
	private LayuiTableData selectUnitByExample(LayuiTableParam param,SysPostExample example) 
	{
		//每页显示条数
		int pageSize = param.getLimit();
		//从第多少条开始
		int pageStart = (param.getPage()-1)*pageSize;
		//当前是第几页
		int pageNum = pageStart/pageSize + 1;
		// 1、设置分页信息，包括当前页数和每页显示的总计数
		PageHelper.startPage(pageNum, pageSize);
		
		List<SysPost> list = postMapper.selectByExample(example);
		// 3、获取分页查询后的数据
		PageInfo<SysPost> pageInfo= new PageInfo<SysPost>(list);
		LayuiTableData data = new LayuiTableData();
		data.setData(pageInfo.getList());
		Long total = pageInfo.getTotal();
		data.setCount(total.intValue());
		return data;
	}

	@Override
	public Integer delPostFunctionRel(String postId, String functionId) 
	{
		SysPostFunctionExample example = new SysPostFunctionExample();
		SysPostFunctionExample.Criteria c = example.createCriteria();
		c.andPostIdEqualTo(postId);
		c.andFunctionIdEqualTo(functionId);
		return postFunctionMapper.deleteByExample(example);
	}

	@Override
	public Integer addPostFunctionRel(String postId, List<SysPostFunction> functions) 
	{
		SysPostFunctionExample example = new SysPostFunctionExample();
		SysPostFunctionExample.Criteria c = example.createCriteria();
		c.andPostIdEqualTo(postId);
		//删除关系
		postFunctionMapper.deleteByExample(example);
		
		Integer rs = 0;
		for(SysPostFunction spf:functions)
		{
			spf.setCreateDate(DateUtil.format(new Date(), DateUtil.FMT_SS));
			spf.setRelId(IdUtil.createUUID());
			spf.setPostId(postId);
			rs += postFunctionMapper.insert(spf);
		}
		return rs;
	}

	@Override
	public List<SysFunction> getFunctionListByPost(String postId) 
	{
		SysPostFunctionExample example = new SysPostFunctionExample();
		SysPostFunctionExample.Criteria c = example.createCriteria();
		c.andPostIdEqualTo(postId);
		List<SysPostFunction> pfs = postFunctionMapper.selectByExample(example);
		List<String> fids = new ArrayList<String>();
		for(SysPostFunction pf:pfs){
			fids.add(pf.getFunctionId());
		}
		if(fids.size()==0){
			return new ArrayList<SysFunction>();
		}
		
		SysFunctionExample fexample = new SysFunctionExample();
		SysFunctionExample.Criteria cf = fexample.createCriteria();
		cf.andIdIn(fids);
		return functionMapper.selectByExample(fexample);
	}

	@Override
	public String getPostCode(SysPost post) 
	{
		SysUnit unit = unitService.seletUnitById(post.getPostUnit());
		if(unit != null)
		{
			String unitCode = unitService.getUnitCode(unit);
			return unitCode+"_"+HanyuPinyinHelper.toPinyin(post.getPostName());
		}
		return null;
	}

	@Override
	public List<SysPost> findAllSysPost() 
	{
		SysPostExample example = new SysPostExample();
		SysPostExample.Criteria c = example.createCriteria();
		
		c.andPostDelflagEqualTo(DelFlagEnum.STATUS_NORMAL.getCode());
		return postMapper.selectByExample(example);
	}

	@Override
	public Map<String,Set<String>> getFunctionButtonRel(String postId) 
	{
		SysPostFunctionExample example = new SysPostFunctionExample();
		SysPostFunctionExample.Criteria c = example.createCriteria();
		c.andPostIdEqualTo(postId);
		List<SysPostFunction> pfs = postFunctionMapper.selectByExample(example);
		Map<String,Set<String>> map = new HashMap<String,Set<String>>();
		for(SysPostFunction pf:pfs) {
			if(!map.containsKey(pf.getFunctionId())) {
				map.put(pf.getFunctionId(), new HashSet<String>());
			}
			if(!StringUtils.isBlank(pf.getFunctionButtons())) 
			{
				String [] buttons = pf.getFunctionButtons().split(",");
				for(String button:buttons) 
				{
					if(!StringUtils.isBlank(button)) {
						map.get(pf.getFunctionId()).add(button);
					}
				}
			}
		}
		return map;
	}

	@Override
	public SysPost findByCode(String postCode) 
	{
		SysPostExample example = new SysPostExample();
		SysPostExample.Criteria c = example.createCriteria();
		
		c.andPostDelflagEqualTo(DelFlagEnum.STATUS_NORMAL.getCode());
		c.andPostCodeEqualTo(postCode);
		
		List<SysPost> posts = postMapper.selectByExample(example);
		if(posts != null && posts.size() >0) 
		{
			return posts.get(0);
		}
		return null;
	}

	@Override
	public List<SysUser> findUserByPost(String postCode) 
	{
		SysPost post = findByCode(postCode);
		if(post == null) {
			return new ArrayList<SysUser>();
		}
		SysUserPostExample example = new SysUserPostExample();
		SysUserPostExample.Criteria c = example.createCriteria();
		c.andPostIdEqualTo(post.getPostId());
		
		List<SysUserPost> posts = sysUserPostMapper.selectByExample(example);
		if(posts == null || posts.size() ==0) {
			return new ArrayList<SysUser>();
		}
		List<String> userIds = new ArrayList<String>();
		for(SysUserPost up:posts) {
			userIds.add(up.getUserId());
		}
		
		SysUserExample ue = new SysUserExample();
		SysUserExample.Criteria uc = ue.createCriteria();
		uc.andUserDelflagEqualTo(DelFlagEnum.STATUS_NORMAL.getCode());
		uc.andUserIdIn(userIds);
		
		return sysUserMapper.selectByExample(ue);
	}
}
