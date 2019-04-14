package com.pcitc.web.controller.doc;

import java.util.Date;
import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.druid.support.json.JSONUtils;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.pcitc.base.common.TreeNode;
import com.pcitc.base.common.enums.DataOperationStatusEnum;
import com.pcitc.base.doc.SysFileCollect;
import com.pcitc.base.util.DateUtil;
import com.pcitc.web.common.BaseController;
import com.pcitc.web.common.DataTableParameter;
import com.pcitc.web.common.OperationFilter;

/**
 * <p>
 * 控制类
 * </p>
 * <p>
 * Table: sys_file_collect - 文件收藏
 * </p>
 *
 * @since 2018-06-22 09:00:03
 */

@Controller
public class SysFileCollectController extends BaseController {

	private static final String GET_INFO = "http://pplus-zuul/system-proxy/sysfilecollect-provider/sysfilecollect/get-sysfilecollect/";
	private static final String TREE_DATA = "http://pplus-zuul/system-proxy/sysfilecollect-provider/sysfilecollect/tree-data";
	private static final String ADD = "http://pplus-zuul/system-proxy/sysfilecollect-provider/sysfilecollect/add-sysfilecollect";
	private static final String UPDATE = "http://pplus-zuul/system-proxy/sysfilecollect-provider/sysfilecollect/update-sysfilecollect";
	private static final String DEL = "http://pplus-zuul/system-proxy/sysfilecollect-provider/sysfilecollect/del-sysfilecollect/";
	private static final String DEL_REAL = "http://pplus-zuul/system-proxy/sysfilecollect-provider/sysfilecollect/del-sysfilecollect-real/";

	/**
	 * 标准增删改查
	 */
	private static final String LIST = "http://pplus-zuul/system-proxy/sysfilecollect-provider/sysfilecollect/sysfilecollect_list";
	private static final String LISTPARAM = "http://pplus-zuul/system-proxy/sysfilecollect-provider/sysfilecollect/sysfilecollect_list_param";

	private static final String LISTPAGE = "http://pplus-zuul/system-proxy/sysfilecollect-provider/sysfilecollect/sysfilecollect-page";

	private static final String SAVE = "http://pplus-zuul/system-proxy/sysfilecollect-provider/sysfilecollect/save_sysfilecollect";

	private static final String DELETE_COLLECT = "http://pplus-zuul/system-proxy/sysfilecollect-provider/sysfilecollect/delete_sysfilecollect";

	private static final String GET = "http://pplus-zuul/system-proxy/sysfilecollect-provider/sysfilecollect/get_sysfilecollect/";
	
	
	/**
	 * 初始化弹出文件收藏功能，显示个人的文件夹
	 *
	 * @return
	 */
	@RequestMapping(value = { "/sysfilecollect/ini-file-collect" }, method = { RequestMethod.GET })
	public String iniSysFileCollect(HttpServletRequest request) {
		request.setAttribute("fileIds", request.getParameter("fileIds"));
		return "pplus/doc/sysFile_collect";
	}
	
	/**
	 * 保存-文件收藏
	 * record.fileIds、fileKind有多个，后台处理
	 */
	@RequestMapping(value = "/sysfilecollect/savesysFileCollect")
	@ResponseBody
	@OperationFilter(modelName = "文档管理", actionName = "文档收藏")
	public int saveRecord(SysFileCollect record) {
		record.setCreateDate(DateUtil.format(new Date(), DateUtil.FMT_SS));
		record.setCreatePersonId(sysUserInfo.getUserId());
		record.setCreatePersonName(sysUserInfo.getUserName());
		record.setStatus("1");
		ResponseEntity<Integer> responseEntity = this.restTemplate.exchange(SAVE, HttpMethod.POST, new HttpEntity<SysFileCollect>(record, this.httpHeaders), Integer.class);
		Integer result = responseEntity.getBody();
		return result;
	}

	/**
	 * 文件收藏-查询列表
	 *
	 * @param sysFileCollect
	 * @return
	 */
	@RequestMapping(value = "/sysfilecollect/list", method = RequestMethod.POST)
	@ResponseBody
	@OperationFilter(modelName = "文件收藏", actionName = "查询列表getList")
	public Object getList(@RequestBody SysFileCollect sysFileCollect) {
		ResponseEntity<JSONObject> responseEntity = this.restTemplate.exchange(LIST, HttpMethod.POST, new HttpEntity<SysFileCollect>(sysFileCollect, this.httpHeaders), JSONObject.class);
		JSONObject retJson = responseEntity.getBody();
		List<SysFileCollect> list = (List<SysFileCollect>) retJson.get("list");
		return list;
	}

	@RequestMapping(value = "/sysfilecollect/listParam", method = RequestMethod.POST)
	@ResponseBody
	@OperationFilter(modelName = "文件收藏", actionName = "查询列表getListParam")
	public Object getListParam(@RequestParam String id) {
		httpHeaders.setContentType(MediaType.APPLICATION_FORM_URLENCODED);
		MultiValueMap<String, String> requestBody = new LinkedMultiValueMap<String, String>();
		requestBody.add("id", request.getParameter("id") + "");
		HttpEntity<MultiValueMap<String, String>> entity = new HttpEntity<MultiValueMap<String, String>>(requestBody, this.httpHeaders);
		ResponseEntity<JSONObject> responseEntity = this.restTemplate.exchange(LISTPARAM, HttpMethod.POST, entity, JSONObject.class);
		JSONObject retJson = responseEntity.getBody();
		List<SysFileCollect> list = (List<SysFileCollect>) retJson.get("list");
		return list;
	}

	/**
	 * 文件收藏-分页查询
	 *
	 * @param aoData
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "/sysfilecollect/getTableData", method = RequestMethod.POST)
	@ResponseBody
	@OperationFilter(modelName = "文件收藏", actionName = "分页查询getTableData")
	public Object getTableData(@RequestBody List<Object> aoData, HttpServletRequest request) {
		httpHeaders.setContentType(MediaType.APPLICATION_FORM_URLENCODED);
		// 传递参数
		MultiValueMap<String, String> requestBody = new LinkedMultiValueMap<String, String>();
		requestBody.add("jsonStr", JSONArray.parseArray(JSON.toJSONString(aoData)).toString());
		HttpEntity<MultiValueMap<String, String>> entity = new HttpEntity<MultiValueMap<String, String>>(requestBody, this.httpHeaders);

		ResponseEntity<JSONObject> responseEntity = this.restTemplate.exchange(LISTPAGE, HttpMethod.POST, entity, JSONObject.class);
		JSONObject retJson = responseEntity.getBody();
		Long totalCount = retJson.get("totalCount") != null ? Long.parseLong(retJson.get("totalCount").toString()) : 0l;
		List<SysFileCollect> list = JSONObject.parseArray(retJson.getJSONArray("list").toJSONString(), SysFileCollect.class);
		DataTableParameter data = new DataTableParameter();
		data.setAaData(list);
		// 要显示的总条数
		data.setiTotalDisplayRecords(totalCount);
		// 真实的总条数
		data.setiTotalRecords(totalCount);
		return data;
	}


	/**
	 * 删除-文件收藏
	 * 删除本人关于此文件的收藏
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "/sysfilecollect/file-kind/file/delete")
	@ResponseBody
	@OperationFilter(modelName = "文件收藏", actionName = "删除本人此文件收藏")
	public int deleteObject(HttpServletRequest request) {
		HashMap<String, Object> map = new HashMap<String, Object>();
		if (request.getParameter("fileIds")!= null) {
			map.put("fileIds", request.getParameter("fileIds"));
		}
		if (request.getParameter("fileKind")!= null) {
			map.put("fileKind", request.getParameter("fileKind"));
		}
		map.put("userId", sysUserInfo.getUserId());
		HttpEntity<HashMap<String, Object>> entity = new HttpEntity<HashMap<String, Object>>(map, this.httpHeaders);

		ResponseEntity<Integer> responseEntity = this.restTemplate.exchange(DELETE_COLLECT, HttpMethod.POST, entity, Integer.class);
		int result = responseEntity.getBody();
		return result;
	}

	/**
	 * 调整编辑页面-文件收藏
	 *
	 * @param id
	 * @param model
	 * @return
	 */
	@RequestMapping(method = RequestMethod.GET, value = "/sysfilecollect/edit")
	@OperationFilter(modelName = "文件收藏", actionName = "跳转编辑页面pageEdit")
	public String pageEdit(String id, Model model, String opt) {
		model.addAttribute("id", id);
		model.addAttribute("opt", opt);
		return "pplus/doc/sysFileCollect_edit";
	}

	/**
	 * 跳转至文件收藏列表页面
	 *
	 * @return
	 */
	@RequestMapping(value = { "/sysfilecollect/toListPage" }, method = { RequestMethod.GET })
	@OperationFilter(modelName = "文件收藏", actionName = "跳转列表页toListPage")
	public String toListPage() {
		return "pplus/doc/sysFileCollect_list";
	}

	/**
	 * 根据ID查询对象信息
	 *
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "/sysfilecollect/getsysFileCollectInfo")
	@OperationFilter(modelName = "文件收藏", actionName = "根据ID查询对象信息getsysFileCollectInfo")
	@ResponseBody
	public Object getsysFileCollectInfo(HttpServletRequest request) {
		String id = request.getParameter("id");
		ResponseEntity<SysFileCollect> responseEntity = this.restTemplate.exchange(GET_INFO + id, HttpMethod.POST, new HttpEntity<String>(this.httpHeaders), SysFileCollect.class);
		SysFileCollect news = responseEntity.getBody();
		return news;
	}

	/**
	 * 查询文件收藏信息
	 *
	 * @param id
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/sysfilecollect/sysfilecollect/get/{id}")
	@ResponseBody
	public String getSysFileCollectInfo(@PathVariable String id) throws Exception {
		SysFileCollect sysFileCollect = this.restTemplate.exchange(GET + id, HttpMethod.POST, new HttpEntity<Object>(this.httpHeaders), SysFileCollect.class).getBody();
		// System.out.println(JSONObject.fromObject(sysFileCollect).toString());
		return JSONObject.toJSONString(sysFileCollect);
	}

	@RequestMapping(value = "/sysfilecollect/sysfilecollect/tree-data")
	public Object getSysFileCollectTreeData() throws Exception {
		TreeNode node = this.restTemplate.exchange(TREE_DATA, HttpMethod.POST, new HttpEntity<Object>(this.httpHeaders), TreeNode.class).getBody();
		return node;
	}

	@RequestMapping(value = "/sysfilecollect/sysfilecollect/tree-datas")
	@ResponseBody
	public String getSysFileCollectTreeDatas(HttpServletRequest request) throws Exception {

		List list = this.restTemplate.exchange(TREE_DATA, HttpMethod.POST, new HttpEntity<Object>(this.httpHeaders), List.class).getBody();
		return JSONUtils.toJSONString(list);
	}

	@RequestMapping(value = "/sysfilecollect/sysfilecollect/add")
	public Object addSysFileCollect(SysFileCollect sysFileCollect) throws Exception {
		HttpEntity<Object> entity = new HttpEntity<Object>(sysFileCollect, this.httpHeaders);
		System.out.println(entity);
		SysFileCollect rs = this.restTemplate.exchange(ADD, HttpMethod.POST, entity, SysFileCollect.class).getBody();
		return JSONObject.toJSONString(rs);
	}

	@RequestMapping(value = "/sysfilecollect/sysfilecollect/update")
	public Object updateSysFileCollect(SysFileCollect sysFileCollect) throws Exception {
		DataOperationStatusEnum rs = this.restTemplate.exchange(UPDATE, HttpMethod.POST, new HttpEntity<Object>(sysFileCollect, this.httpHeaders), DataOperationStatusEnum.class).getBody();
		return rs;
	}

	@RequestMapping(value = "/sysfilecollect/sysfilecollect/del")
	public Object delSysFileCollect(String sysFileCollectId) throws Exception {
		DataOperationStatusEnum rs = this.restTemplate.exchange(DEL + sysFileCollectId, HttpMethod.POST, new HttpEntity<Object>(this.httpHeaders), DataOperationStatusEnum.class).getBody();
		return rs;
	}

	@RequestMapping(value = "/sysfilecollect/sysfilecollect/del-real")
	public Object delSysFileCollectReal(String id) throws Exception {
		DataOperationStatusEnum rs = this.restTemplate.exchange(DEL_REAL + id, HttpMethod.POST, new HttpEntity<Object>(this.httpHeaders), DataOperationStatusEnum.class).getBody();
		return rs;
	}
}