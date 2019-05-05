package com.pcitc.web.system;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.pcitc.base.common.LayuiTableParam;
import com.pcitc.base.system.SysFunction;
import com.pcitc.base.system.SysPost;
import com.pcitc.base.system.SysPostFunction;
import com.pcitc.base.util.DateUtil;
import com.pcitc.base.util.IdUtil;
import com.pcitc.base.util.MyBeanUtils;
import com.pcitc.service.system.PostService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;


@Api(value="岗位接口",tags= {"岗位相关操作服务接口"})
@RestController
public class PostProviderClient 
{
	
	//private final static Logger logger = LoggerFactory.getLogger(PostProviderClient.class);
	
	@Autowired
	private PostService postService;
	
	@ApiOperation(value="检索岗位信息",notes="根据岗位ID检索岗位信息。")
	@RequestMapping(value = "/post-provider/post/get-post/{postId}", method = RequestMethod.POST)
	public SysPost getSysPost(@PathVariable(value = "postId", required = true) String postId) 
	{
		return postService.findById(postId);
	}
	
	@ApiOperation(value="检索岗位信息",notes="根据岗位Code检索岗位信息。")
	@RequestMapping(value = "/post-provider/post/get-post-bycode/{postCode}", method = RequestMethod.POST)
	public SysPost getSysPostByCode(@PathVariable(value = "postCode", required = true) String postCode) 
	{
		return postService.findByCode(postCode);
	}
	
	@ApiOperation(value="检索岗位列表(带分页)",notes="检索机构下岗位列表，根据条件分页检索。")
	@RequestMapping(value = "/post-provider/post/get-post-by-unit", method = RequestMethod.POST)
	public Object getSysPostByUnit(@RequestBody LayuiTableParam param) 
	{
		return postService.findByUnit(param);
	}
	@ApiOperation(value="添加岗位",notes="保存数据到持久化结构中,操作返回持久化数据的数量，1为成功，0不成功。")
	@RequestMapping(value = "/post-provider/post/add-post", method = RequestMethod.POST)
	public Integer saveSysPost(@RequestBody SysPost post) 
	{
		return postService.saveSysPost(post);
	}
	
	@ApiOperation(value="更新岗位",notes="持久化结构数据更新,操作返回持久化数据的数量，1为成功，0不成功。")
	@RequestMapping(value = "/post-provider/post/upd-post", method = RequestMethod.POST)
	public Integer updateSysPost(@RequestBody SysPost post) 
	{
		SysPost oldPost = postService.findById(post.getPostId());
		Integer rs = 0;
		if(oldPost != null)
		{
			MyBeanUtils.copyPropertiesIgnoreNull(post, oldPost);
			rs = postService.updatePost(oldPost);
		}
		return rs;
	}
	
	@ApiOperation(value="删除岗位(逻辑删除)",notes="删除指定ID岗位信息，逻辑删除，物理数据依然存在于持久化数据结构中。")
	@RequestMapping(value = "/post-provider/post/del-post/{postId}", method = RequestMethod.POST)
	public Integer deleteSysPost(@PathVariable(value = "postId", required = true) String postId) 
	{
		return postService.delPost(postId);
	}
	
	@ApiOperation(value="删除岗位(物理删除)",notes="删除指定ID岗位信息，物理删除，物理数据将从持久化数据结构中删除，同时删除用户岗位关系数据！")
	@RequestMapping(value = "/post-provider/post/del-post-real/{postId}", method = RequestMethod.POST)
	public Integer deleteSysPostRel(@PathVariable(value = "postId", required = true) String postId) 
	{
		return postService.delPostReal(postId);
	}
	
	@ApiOperation(value="检索岗位权限(菜单)",notes="获取目标岗位对应的权限列表！")
	@RequestMapping(value = "/post-provider/post/get-function-list/{postId}", method = RequestMethod.POST)
	public List<SysFunction> getFunctionsByPost(@PathVariable(value = "postId", required = true) String postId)
	{
		return postService.getFunctionListByPost(postId);
	}
	
	@ApiOperation(value="添加岗位权限(包含按钮)",notes="添加指定岗位的权限，数据结构为Map<postId,Map<functionId,Array[Buttons]>>！")
	@RequestMapping(value = "/post-provider/post/add-post-function", method = RequestMethod.POST)
	public Integer addPostFunctionRel(@RequestBody Map<String,String> relmap)
	{
		Integer rs = 0;
		for(java.util.Iterator<String> iter = relmap.keySet().iterator();iter.hasNext();)
		{
			String postId = iter.next();
			Map<?,?> map = JSON.parseObject(relmap.get(postId), Map.class);
			
			List<SysPostFunction> fs = new ArrayList<SysPostFunction>();
			for(java.util.Iterator<?> fiter = map.keySet().iterator();fiter.hasNext();) 
			{
				String functionId = fiter.next().toString();
				JSONArray buttons = JSON.parseArray(map.get(functionId).toString());
				StringBuffer sb = new StringBuffer();
				for(java.util.Iterator<Object> objiter = buttons.iterator();objiter.hasNext();)
				{
					sb.append(","+ objiter.next());
				}
				SysPostFunction function = new SysPostFunction();
				function.setRelId(IdUtil.createIdByTime());
				function.setPostId(postId);
				function.setFunctionId(functionId);
				function.setFunctionButtons(sb.toString());
				function.setCreateDate(DateUtil.format(new Date(), DateUtil.FMT_SS));
				
				fs.add(function);
			}
			rs += postService.addPostFunctionRel(postId, fs);
		}
		return rs;
	}
	@ApiOperation(value="检索岗位列表(不分页)",notes="获得机构下岗位列表！")
	@RequestMapping(value = "/post-provider/post/get-post-list", method = RequestMethod.POST)
	public Object getSysPostListByUnit(@RequestBody String unitId) 
	{
		//获取机构下岗位，不分页
		return postService.findByUnit(unitId);
	}
	
	@ApiOperation(value="检索岗位列表(不分页)",notes="获得机构下岗位列表！")
	@RequestMapping(value = "/post-provider/post/get-post-json", method = RequestMethod.POST)
	public JSONArray getSysPostListByUnitjson(@RequestBody String unitId) 
	{
		//获取机构下岗位，不分页
		List<SysPost> list= postService.findByUnit(unitId);
		JSONArray json = JSONArray.parseArray(JSON.toJSONString(list));
		return json;
	}
	
	
	
	@ApiOperation(value="生成岗位编码",notes="根据岗位信息生成岗位编码，岗位编码中包含机构编码！")
	@RequestMapping(value = "/post-provider/post/post-code", method = RequestMethod.POST)
	public Object getSysPostCode(@RequestBody SysPost post) 
	{
		return postService.getPostCode(post);
	}
	@ApiOperation(value="检索岗位列表(不分页)",notes="检索所有的岗位信息！")
	@RequestMapping(value = "/post-provider/post/list-data", method = RequestMethod.POST)
	public Object getSysPostList() 
	{
		return postService.findAllSysPost();
	}
	@ApiOperation(value="检索岗位权限(包含按钮)",notes="根据岗位ID检索岗位权限，包含按钮权限！")
	@RequestMapping(value = "/post-provider/post/post-function-buttons/{postId}", method = RequestMethod.POST)
	public Object getFunctionButtonsByPost(@PathVariable(value = "postId", required = true) String postId) 
	{
		return postService.getFunctionButtonRel(postId);
	}
}
