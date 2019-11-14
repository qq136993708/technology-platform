package com.pcitc.web.controller.system;

import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.pcitc.base.system.SysUser;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.alibaba.druid.support.json.JSONUtils;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.pcitc.base.common.LayuiTableData;
import com.pcitc.base.common.LayuiTableParam;
import com.pcitc.base.common.Result;
import com.pcitc.base.common.TreeNode;
import com.pcitc.base.system.SysDictionary;
import com.pcitc.base.system.SysNews;
import com.pcitc.base.util.CommonUtil;
import com.pcitc.base.util.DateUtil;
import com.pcitc.base.util.StrUtil;
import com.pcitc.web.common.BaseController;
import com.pcitc.web.common.OperationFilter;

/**
 * <p>
 * 控制类
 * </p>
 * <p>
 * Table: sys_news - 系统新闻表
 * </p>
 *
 * @since 2019-04-04 10:25:32
 */

@Controller
public class SysNewsController extends BaseController {
	/**
	 * 根据ID获取对象信息
	 */
	private static final String GET_INFO = "http://kjpt-zuul/stp-proxy/sysnews-provider/sysnews/get-sysnews/";
	/**
	 * 树形
	 */
	private static final String TREE_DATA = "http://kjpt-zuul/stp-proxy/sysnews-provider/sysnews/tree-data";
	/**
	 * 逻辑删除
	 */
	private static final String DEL = "http://kjpt-zuul/stp-proxy/sysnews-provider/sysnews/del-sysnews/";
	/**
	 * 物理删除
	 */
	private static final String DEL_REAL = "http://kjpt-zuul/stp-proxy/sysnews-provider/sysnews/del-sysnews-real/";

	/**
	 * 查询列表
	 */
	private static final String LIST = "http://kjpt-zuul/stp-proxy/sysnews-provider/sysnews/sysnews_list";
	/**
	 * 参数查询
	 */
	private static final String LISTPARAM = "http://kjpt-zuul/stp-proxy/sysnews-provider/sysnews/sysnews_list_param";
	/**
	 * 分页查询
	 */
	private static final String LISTPAGE = "http://kjpt-zuul/stp-proxy/sysnews-provider/sysnews/sysnews-page";
	/**
	 * 保存
	 */
	private static final String SAVE = "http://kjpt-zuul/stp-proxy/sysnews-provider/sysnews/save_sysnews";

	private static final String getNewsIndexType = "http://kjpt-zuul/stp-proxy/sysnews-provider/sysnews/getNewsIndexType";
	
	private static final String  DICTIONARY=   "http://kjpt-zuul/system-proxy/dictionary-provider/getDictionaryByCode/";
	
	

	@RequestMapping(value = "/sysNews/getNewsIndexType", method = RequestMethod.POST)
	@ResponseBody
	public Object getNewsIndexType() {
		SysNews sysNews = new SysNews();
		sysNews.setBak3(request.getParameter("bak3"));
		sysNews.setStype(request.getParameter("stype"));
		ResponseEntity<JSONObject> responseEntity = this.restTemplate.exchange(getNewsIndexType, HttpMethod.POST, new HttpEntity<SysNews>(sysNews, this.httpHeaders), JSONObject.class);
		JSONObject retJson = responseEntity.getBody();
		List<?> list = (List<?>) retJson.get("list");
		// String formIds = "";
		// for (int i = 0; i < list.size(); i++) {
		// if ("ROOT_XTGL_SPLX_PT".equals(list.get(i).getStype())){
		// //视频查询图片
		// formIds = formIds+(i==0?"":",")+list.get(i).getDataId();
		// }
		// }
		return list;
	}
	
	

	
	
	

	/**
	 * 系统新闻表-查询列表
	 *
	 * @param sysNews
	 * @return
	 */
	@RequestMapping(value = "/sysNews/list", method = RequestMethod.POST)
	@ResponseBody
	public Object getList(@RequestBody SysNews sysNews) {
		httpHeaders.setContentType(MediaType.APPLICATION_JSON);
		ResponseEntity<JSONObject> responseEntity = this.restTemplate.exchange(LIST, HttpMethod.POST, new HttpEntity<SysNews>(sysNews, this.httpHeaders), JSONObject.class);
		JSONObject retJson = responseEntity.getBody();
		List<?> list = (List<?>) retJson.get("list");
		return list;
	}

	@RequestMapping(value = "/sysNews/listParam", method = RequestMethod.POST)
	@ResponseBody
	public Object getListParam(@RequestParam String id) {
		httpHeaders.setContentType(MediaType.APPLICATION_FORM_URLENCODED);
		MultiValueMap<String, String> requestBody = new LinkedMultiValueMap<String, String>();
		requestBody.add("id", request.getParameter("id") + "");
		HttpEntity<MultiValueMap<String, String>> entity = new HttpEntity<MultiValueMap<String, String>>(requestBody, this.httpHeaders);
		ResponseEntity<JSONObject> responseEntity = this.restTemplate.exchange(LISTPARAM, HttpMethod.POST, entity, JSONObject.class);
		JSONObject retJson = responseEntity.getBody();
		List<?> list = (List<?>) retJson.get("list");
		return list;
	}

	/**
	 * 系统新闻表-分页查询
	 *
	 * @param param
	 * @return
	 */
	@RequestMapping(value = "/sysNews/getTableData", method = RequestMethod.POST)
	@ResponseBody
	public Object getTableData(@ModelAttribute("param") LayuiTableParam param) {
		HttpEntity<LayuiTableParam> entity = new HttpEntity<LayuiTableParam>(param, this.httpHeaders);
		ResponseEntity<LayuiTableData> responseEntity = this.restTemplate.exchange(LISTPAGE, HttpMethod.POST, entity, LayuiTableData.class);
		LayuiTableData data = responseEntity.getBody();
		return JSON.toJSON(data).toString();
	}

	/**
	 * 保存-系统新闻表
	 *
	 * @param record
	 * @return
	 */
	@RequestMapping(value = "/sysNews/saveSysNews")
	@ResponseBody
	@OperationFilter(modelName = "系统新闻表", actionName = "保存saveRecord")
	public int saveRecord(SysNews record) {
		SysUser sysUserInfo = getUserProfile();
		httpHeaders.setContentType(MediaType.APPLICATION_JSON);
		if (record.getDataId() == null || "".equals(record.getDataId())) {
			record.setCreateDate(DateUtil.format(new Date(), DateUtil.FMT_SS));
			record.setCreateUser(sysUserInfo.getUserId());
			record.setCreateUserDisp(sysUserInfo.getUserName());
		} else {
			record.setUpdateDate(DateUtil.format(new Date(), DateUtil.FMT_SS));
			record.setUpdatePersonId(sysUserInfo.getUserId());
			record.setUpdatePersonName(sysUserInfo.getUserName());
		}
		record.setStatus("0");
		ResponseEntity<Integer> responseEntity = this.restTemplate.exchange(SAVE, HttpMethod.POST, new HttpEntity<SysNews>(record, this.httpHeaders), Integer.class);
		Integer result = responseEntity.getBody();
		return result;
	}

	/**
	 * 编辑页面-系统新闻表
	 *
	 * @param id
	 * @param model
	 * @return
	 */
	@RequestMapping(method = RequestMethod.GET, value = "/sysNews/edit")
	@OperationFilter(modelName = "系统新闻表", actionName = "跳转编辑页面pageEdit")
	public String pageEdit(String id, Model model, String opt)throws Exception {
		model.addAttribute("id", id);
		model.addAttribute("opt", opt);
		
		
		if( id!=null && !id.equals(""))
		{
			ResponseEntity<SysNews> responseEntity = this.restTemplate.exchange(GET_INFO + id, HttpMethod.POST, new HttpEntity<String>(this.httpHeaders), SysNews.class);
			SysNews sysNews = responseEntity.getBody();
			model.addAttribute("sysNews", sysNews);
			model.addAttribute("bak6", sysNews.getBak6());
		}else
		{
			model.addAttribute("bak6", UUID.randomUUID().toString());
		}
		
		List<SysDictionary>  lbList= CommonUtil.getDictionaryByParentCode("ROOT_XTGL_XWLX", restTemplate, httpHeaders);
		request.setAttribute("lbList", lbList);
		
		
		return "stp/system/sysNews_edit";
	}

	@RequestMapping(method = RequestMethod.GET, value = "/sysNews/editvideo")
	@OperationFilter(modelName = "系统新闻表", actionName = "跳转编辑页面pageEdit")
	public String pageEditVideo(String id, Model model, String opt) {
		model.addAttribute("id", id);
		model.addAttribute("opt", opt);
		model.addAttribute("bak3", StrUtil.isBlank(id) ? UUID.randomUUID().toString() : id);
		model.addAttribute("bak4", StrUtil.isBlank(id) ? UUID.randomUUID().toString() : id);
		return "stp/system/sysNews_edit_video";
	}

	/**
	 * 详情页面-系统新闻表
	 *
	 * @param model
	 * @return
	 */
	@RequestMapping(method = RequestMethod.GET, value = "/sysNews/view/{dataId}")
	@OperationFilter(modelName = "系统新闻表", actionName = "跳转详情页面pageView")
	public String pageView(@PathVariable("dataId") String dataId, Model model) {
		model.addAttribute("id", dataId);
		model.addAttribute("opt", "");
		model.addAttribute("dataId", (dataId == null || "".equals(dataId)) ? UUID.randomUUID().toString().replace("-", "") : dataId);
		return "stp/system/sysNews_view";
	}

	@RequestMapping(method = RequestMethod.GET, value = "/sysNews/viewvideo/{dataId}")
	@OperationFilter(modelName = "系统新闻表", actionName = "跳转详情页面pageView")
	public String pageViewVideo(@PathVariable("dataId") String dataId, Model model) {
		model.addAttribute("id", dataId);
		model.addAttribute("opt", "");
		model.addAttribute("dataId", (dataId == null || "".equals(dataId)) ? UUID.randomUUID().toString().replace("-", "") : dataId);
		return "stp/system/sysNews_view_video";
	}

	/**
	 * 跳转至系统新闻表列表页面
	 *
	 * @return
	 */
	@RequestMapping(value = "/sysNews/toListPage", method = { RequestMethod.GET })
	@OperationFilter(modelName = "系统新闻表", actionName = "跳转列表页toListPage")
	public String toListPage() {
		return "stp/system/sysNews_list";
	}

	/**
	 * 跳转至系统新闻表列表页面
	 *
	 * @return
	 */
	@RequestMapping(value = "/sysNews/toListPageVideo", method = { RequestMethod.GET })
	@OperationFilter(modelName = "系统新闻表", actionName = "跳转列表页toListPage")
	public String toListPageVideo() {
		return "stp/system/sysNews_list_video";
	}

	/**
	 * 根据ID查询对象信息
	 *
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "/sysNews/getSysNewsInfo")
	@OperationFilter(modelName = "系统新闻表", actionName = "根据ID查询对象信息getsysNewsInfo")
	@ResponseBody
	public Object getsysNewsInfo(HttpServletRequest request) {
		String id = request.getParameter("id");
		ResponseEntity<SysNews> responseEntity = this.restTemplate.exchange(GET_INFO + id, HttpMethod.POST, new HttpEntity<String>(this.httpHeaders), SysNews.class);
		SysNews news = responseEntity.getBody();
		return news;
	}

	@RequestMapping(value = "/sysNews/getNewsIndexTypeDetail")
	public String getNewsIndexTypeDetail(HttpServletRequest request) {
		String id = request.getParameter("dataId");
		ResponseEntity<SysNews> responseEntity = this.restTemplate.exchange(GET_INFO + id, HttpMethod.POST, new HttpEntity<String>(this.httpHeaders), SysNews.class);
		SysNews news = responseEntity.getBody();
		request.setAttribute("list", news);
		SysDictionary dic = this.restTemplate.exchange(DICTIONARY+news.getStype(), HttpMethod.POST, new HttpEntity<Object>(this.httpHeaders), SysDictionary.class).getBody();
		request.setAttribute("dic", dic);
		return "layui/leader_speech_details";
	}
	
	@RequestMapping(value = "/sysNews/newsDetail")
	public String toNewsDetail(HttpServletRequest request) {
		String id = request.getParameter("dataId");
		ResponseEntity<SysNews> responseEntity = this.restTemplate.exchange(GET_INFO + id, HttpMethod.POST, new HttpEntity<String>(this.httpHeaders), SysNews.class);
		SysNews news = responseEntity.getBody();
		request.setAttribute("news", news);
		SysDictionary dic = this.restTemplate.exchange(DICTIONARY+news.getStype(), HttpMethod.POST, new HttpEntity<Object>(this.httpHeaders), SysDictionary.class).getBody();
		request.setAttribute("dic", dic);
		return "layui/leader_details";
	}

	@RequestMapping(value = "/sysNews/tree-data")
	@ResponseBody
	@OperationFilter(modelName = "系统新闻表", actionName = "树形查询getSysNewsTreeData()")
	public Object getSysNewsTreeData() throws Exception {
		TreeNode node = this.restTemplate.exchange(TREE_DATA, HttpMethod.POST, new HttpEntity<Object>(this.httpHeaders), TreeNode.class).getBody();
		return node;
	}

	@RequestMapping(value = "/sysNews/tree-datas")
	@OperationFilter(modelName = "系统新闻表", actionName = "树形查询getSysNewsTreeData()")
	@ResponseBody
	public String getSysNewsTreeDatas(HttpServletRequest request) throws Exception {
		this.httpHeaders.setContentType(MediaType.APPLICATION_JSON);
		List<?> list = this.restTemplate.exchange(TREE_DATA, HttpMethod.POST, new HttpEntity<Object>(this.httpHeaders), List.class).getBody();
		return JSONUtils.toJSONString(list);
	}

	@OperationFilter(modelName = "删除系统新闻表", actionName = "根据ID删除系统新闻表")
	@RequestMapping(value = "/sysNews/del", method = RequestMethod.POST)
	@ResponseBody
	public Object delSysNews() throws Exception {
		Integer rs = this.restTemplate.exchange(DEL + request.getParameter("id"), HttpMethod.POST, new HttpEntity<Object>(this.httpHeaders), Integer.class).getBody();
		if (rs > 0) {
			return new Result(true, "操作成功！");
		} else {
			return new Result(false, "保存失败请重试！");
		}
	}

	@OperationFilter(modelName = "物理删除系统新闻表", actionName = "根据ID物理删除系统新闻表")
	@RequestMapping(value = "/sysNews/del-real", method = RequestMethod.POST)
	@ResponseBody
	public Object delSysNewsReal() throws Exception {
		Integer rs = this.restTemplate.exchange(DEL_REAL + request.getParameter("id"), HttpMethod.POST, new HttpEntity<Object>(this.httpHeaders), Integer.class).getBody();
		if (rs > 0) {
			return new Result(true, "操作成功！");
		} else {
			return new Result(false, "保存失败请重试！");
		}
	}

	@OperationFilter(modelName = "物理删除系统新闻表", actionName = "根据ID物理删除系统新闻表")
	@RequestMapping(value = "/sysNews/del-realvideo", method = RequestMethod.POST)
	@ResponseBody
	public Object delSysNewsRealVideo() throws Exception {
		Integer rs = this.restTemplate.exchange(DEL_REAL + request.getParameter("id"), HttpMethod.POST, new HttpEntity<Object>(this.httpHeaders), Integer.class).getBody();
		if (rs > 0) {
			return new Result(true, "操作成功！");
		} else {
			return new Result(false, "保存失败请重试！");
		}
	}

	@RequestMapping(value = "/sysNews/toLeaderSpeechList", method = { RequestMethod.GET })
	public String toLeaderSpeechList() {
		String stype = request.getParameter("stype");
		request.setAttribute("stype", stype);
		SysDictionary dic = this.restTemplate.exchange(DICTIONARY+stype, HttpMethod.POST, new HttpEntity<Object>(this.httpHeaders), SysDictionary.class).getBody();
		request.setAttribute("dic", dic);
		return "layui/leader_speech_list";
	}

	@RequestMapping(value = "/sysNews/upload", method = RequestMethod.POST)
	public void upload(@RequestParam(value = "/file", required = false) MultipartFile files, HttpServletRequest request, HttpServletResponse response) {
		PrintWriter out = null;

		String imageUrl = "/upload/a.jpg";

		String msg = "";

		String fileName = "a.jpg";
		// String fileName = "a.jpg";

		JSONObject result = new JSONObject();

		try {
			// response.setContentType("text/html; charset=UTF-8");
			// response.setHeader("Cache-Control", "no-cache");
			out = response.getWriter();
			//
			// String imagesViewUrlPrefix =
			// CommonResource.get("imagesViewUrlPrefix");
			//
			// String fileType =
			// FileUtil.getFileSuffixFromContentType(file.getContentType());
			//
			// fileName = UUIDFactory.getUUID() + "." + fileType;
			//
			// BaseResult uploadResult = FileUtil.uploadFile(fileName,
			// file.getInputStream());
			//
			// if (uploadResult.getCode() == ResultType.CODE_NORMAL) {
			//
			// String imagePath = (String) uploadResult.getData();
			//
			// imageUrl = imagesViewUrlPrefix + imagePath;
			//
			// } else {
			//
			// msg = "文件上传失败";
			//
			// }

		} catch (Exception e) {

			e.printStackTrace();

			logger.error("富文本编辑器上传图片时发生异常", e);

			msg = "服务器异常";

		} finally {

			if (!StrUtil.isBlank(msg)) {
				// 上传失败
				result.put("uploaded", 0);
				JSONObject errorObj = new JSONObject();
				errorObj.put("message", msg);
				result.put("error", errorObj);
			} else {
				// 上传成功
				result.put("uploaded", 1);
				result.put("fileName", fileName);
				result.put("url", imageUrl);
			}
			// out.println(JSON.toJSONString(result));
			out.println(result.toJSONString());
		}

	}
}