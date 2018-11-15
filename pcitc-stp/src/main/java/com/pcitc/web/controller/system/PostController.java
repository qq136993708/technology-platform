package com.pcitc.web.controller.system;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang3.StringUtils;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.pcitc.base.common.LayuiTableData;
import com.pcitc.base.common.LayuiTableParam;
import com.pcitc.base.common.Result;
import com.pcitc.base.common.enums.DataOperationStatusEnum;
import com.pcitc.base.common.enums.DelFlagEnum;
import com.pcitc.base.system.SysFunction;
import com.pcitc.base.system.SysPost;
import com.pcitc.base.util.IdUtil;
import com.pcitc.base.util.MyBeanUtils;
import com.pcitc.web.common.BaseController;

@RestController
public class PostController extends BaseController {

	private static final String POST_GET_POST = "http://pcitc-zuul/system-proxy/post-provider/post/get-post/";
	private static final String POST_GET_POST_BY_UNIT = "http://pcitc-zuul/system-proxy/post-provider/post/get-post-by-unit";
	private static final String POST_ADD_POST = "http://pcitc-zuul/system-proxy/post-provider/post/add-post";
	private static final String POST_UPDATE_POST = "http://pcitc-zuul/system-proxy/post-provider/post/upd-post";
	private static final String POST_DEL_POST = "http://pcitc-zuul/system-proxy/post-provider/post/del-post/";
	private static final String POST_DEL_POST_REAL = "http://pcitc-zuul/system-proxy/post-provider/post/del-post-real/";

	private static final String POST_ADD_POST_FUNCTION = "http://pcitc-zuul/system-proxy/post-provider/post/add-post-function";
	private static final String POST_GET_POST_FUNCTION_LIST = "http://pcitc-zuul/system-proxy/post-provider/post/get-function-list/";
	private static final String GET_POST_LIST_BYUNIT = "http://pcitc-zuul/system-proxy/post-provider/post/get-post-list";
	private static final String GET_POST_CODE = "http://pcitc-zuul/system-proxy/post-provider/post/post-code";
	private static final String GET_POST_LIST = "http://pcitc-zuul/system-proxy/post-provider/post/list-data";
	private static final String GET_POST_FUNCTION_BUTTONS = "http://pcitc-zuul/system-proxy/post-provider/post/post-function-buttons/";

	@RequestMapping(value = "/post/edit-post", method = RequestMethod.GET)
	public ModelAndView toPostEditPage(HttpServletRequest request, @RequestParam(name = "unitId", required = false) String unitId, @RequestParam(name = "postId", required = false) String postId) {
		System.out.println("----------unitId=====" + unitId + "---------postId===" + postId);
		request.setAttribute("unitId", unitId);
		request.setAttribute("postId", postId);
		return new ModelAndView("/base/post/edit_post");
	}

	@RequestMapping(value = "/post/post_function", method = RequestMethod.GET)
	public ModelAndView toPostFunctionPage(HttpServletRequest request, @RequestParam(name = "unitId", required = false) String unitId, @RequestParam(name = "postId", required = false) String postId) {
		System.out.println("----------unitId=====" + unitId + "---------postId===" + postId);
		request.setAttribute("unitId", unitId);
		request.setAttribute("postId", postId);
		return new ModelAndView("/base/post/post_function");
	}

	@RequestMapping(value = "/post/get/{postId}")
	public Object getSysPostInfo(@PathVariable("postId") String postId) throws Exception {
		SysPost post = this.restTemplate.exchange(POST_GET_POST + postId, HttpMethod.POST, new HttpEntity<Object>(this.httpHeaders), SysPost.class).getBody();
		System.out.println(JSONObject.toJSON(post).toString());
		return post;
	}

	@RequestMapping(value = "/post/get-post-by-unit")
	public Object getPostByUnit(@ModelAttribute("param") LayuiTableParam param) throws Exception {
		System.out.print("unitId:" + param.getParam().get("unitId"));

		HttpEntity<LayuiTableParam> entity = new HttpEntity<LayuiTableParam>(param, this.httpHeaders);
		ResponseEntity<LayuiTableData> responseEntity = this.restTemplate.exchange(POST_GET_POST_BY_UNIT, HttpMethod.POST, entity, LayuiTableData.class);
		LayuiTableData data = responseEntity.getBody();
		return JSON.toJSON(data).toString();
	}

	@RequestMapping(value = "/post/add-post")
	public Object addSysPost(@ModelAttribute("post") SysPost post) throws Exception {
		System.out.println("start add post.....................");
		DataOperationStatusEnum rs = this.restTemplate.exchange(POST_ADD_POST, HttpMethod.POST, new HttpEntity<Object>(post, this.httpHeaders), DataOperationStatusEnum.class).getBody();
		System.out.println(JSONArray.toJSON(rs).toString());
		return rs;
	}

	@RequestMapping(value = "/post/upd-or-add")
	public Object updateSysPost(@ModelAttribute("post") SysPost post) throws Exception {
		System.out.println("start upd or add post.....................");
		Integer rs = null;
		if (StringUtils.isBlank(post.getPostId()) || "0".equals(post.getPostId())) {
			post.setPostId(IdUtil.createIdByTime());
			post.setPostDelflag(DelFlagEnum.STATUS_NORMAL.getCode());
			MyBeanUtils.setDefaultModel(post);
			rs = this.restTemplate.exchange(POST_ADD_POST, HttpMethod.POST, new HttpEntity<SysPost>(post, this.httpHeaders), Integer.class).getBody();
		} else {
			rs = this.restTemplate.exchange(POST_UPDATE_POST, HttpMethod.POST, new HttpEntity<SysPost>(post, this.httpHeaders), Integer.class).getBody();
		}
		// System.out.println(JSONArray.toJSON(rs).toString());
		return new Result(rs > 0 ? true : false);
	}

	@RequestMapping(value = "/post/del-post")
	public Object delSysPost(String postId) throws Exception {
		System.out.println("start del post.....................");
		Integer rs = this.restTemplate.exchange(POST_DEL_POST + postId, HttpMethod.POST, new HttpEntity<Object>(this.httpHeaders), Integer.class).getBody();
		System.out.println(JSONArray.toJSON(rs).toString());
		return new Result(rs > 0 ? true : false);
	}

	@RequestMapping(value = "/post/del-post-real")
	public Object delSysPostReal(String postId) throws Exception {
		System.out.println("start del post.....................");
		Integer rs = this.restTemplate.exchange(POST_DEL_POST_REAL + postId, HttpMethod.POST, new HttpEntity<Object>(this.httpHeaders), Integer.class).getBody();
		System.out.println(JSONArray.toJSON(rs).toString());
		return new Result(rs > 0 ? true : false);
	}

	@SuppressWarnings("unchecked")
	@RequestMapping(value = "/post/get-function-list/{postId}")
	public Object getPostFunctionList(@PathVariable(value = "postId", required = true) String postId) throws Exception {
		List<SysFunction> rs = this.restTemplate.exchange(POST_GET_POST_FUNCTION_LIST + postId, HttpMethod.POST, new HttpEntity<Object>(this.httpHeaders), List.class).getBody();
		System.out.println(JSONObject.toJSON(rs).toString());
		return rs;
	}

	@RequestMapping(value = "/post/save-post-functions")
	public Object savePostFunctionRel(@RequestParam(value = "functionIds", required = false) String functionIds, @RequestParam(value = "postId", required = false) String postId) throws Exception {
		Map<String, String> map = new HashMap<String, String>();
		map.put(postId, functionIds);
		System.out.println(JSON.toJSON(map).toString());
		ResponseEntity<Integer> rs = this.restTemplate.exchange(POST_ADD_POST_FUNCTION, HttpMethod.POST, new HttpEntity<Map<String, String>>(map, this.httpHeaders), Integer.class);
		if (rs.getBody() == 0) {
			return new Result(false);
		} else {
			return new Result(true);
		}
	}

	@RequestMapping(value = "/post/get-post-list")
	public Object getPostListByUnit(@RequestParam(value = "unitId", required = true) String unitId) throws Exception {
		System.out.println("unit id :" + unitId);
		List<?> rs = this.restTemplate.exchange(GET_POST_LIST_BYUNIT, HttpMethod.POST, new HttpEntity<String>(unitId, this.httpHeaders), List.class).getBody();
		System.out.println(JSONObject.toJSON(rs).toString());
		return rs;
	}

	@RequestMapping(value = "/post/post-code")
	public Object getUnitCodeByUnitName(@ModelAttribute("post") SysPost post) {
		ResponseEntity<String> responseEntity = restTemplate.exchange(GET_POST_CODE, HttpMethod.POST, new HttpEntity<SysPost>(post, this.httpHeaders), String.class);
		String rs = responseEntity.getBody();
		System.out.println("code ..... " + rs);
		return new Result(true, rs);
	}

	/**
	 * 查询岗位列表
	 * 
	 * @param unitId
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/post/list-data")
	public Object getListPost() throws Exception {
		List<?> rs = this.restTemplate.exchange(GET_POST_LIST, HttpMethod.POST, new HttpEntity<String>(this.httpHeaders), List.class).getBody();
		System.out.println(JSONObject.toJSON(rs).toString());
		return rs;
	}

	@RequestMapping(value = "/post/post-function-buttons")
	public Object getPostFunctionButtons(@RequestParam(value = "postId", required = true) String postId) throws Exception {
		System.out.println("postId:" + postId);
		ResponseEntity<Object> rs = this.restTemplate.exchange(GET_POST_FUNCTION_BUTTONS + postId, HttpMethod.POST, new HttpEntity<String>(this.httpHeaders), Object.class);
		System.out.println(JSONObject.toJSON(rs.getBody()).toString());
		return rs.getBody();
	}
}
