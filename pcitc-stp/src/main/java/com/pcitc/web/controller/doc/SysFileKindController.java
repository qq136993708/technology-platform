package com.pcitc.web.controller.doc;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

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

import com.alibaba.druid.support.json.JSONUtils;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.pcitc.base.common.LayuiTableData;
import com.pcitc.base.common.LayuiTableParam;
import com.pcitc.base.common.enums.DataOperationStatusEnum;
import com.pcitc.base.doc.SysFileKind;
import com.pcitc.base.system.SysFile;
import com.pcitc.base.util.DateUtil;
import com.pcitc.web.common.BaseController;
import com.pcitc.web.common.DataTableLayui;
import com.pcitc.web.common.OperationFilter;

/**
 * <p>
 * 控制类
 * </p>
 * <p>
 * Table: sys_file_kind -
 * </p>
 *
 * @since 2018-06-19 09:24:12
 */

@Controller
@RequestMapping("sysfilekind")
public class SysFileKindController extends BaseController {

	private static final String	GET_INFO	= "http://pcitc-zuul/system-proxy/sysfilekind-provider/sysfilekind/get-sysfilekind/";
	private static final String	TREE_DATA	= "http://pcitc-zuul/system-proxy/sysfilekind-provider/sysfilekind/tree-data";
	private static final String	ADD			= "http://pcitc-zuul/system-proxy/sysfilekind-provider/sysfilekind/add-sysfilekind";
	private static final String	UPDATE		= "http://pcitc-zuul/system-proxy/sysfilekind-provider/sysfilekind/update-sysfilekind";
	private static final String	DEL			= "http://pcitc-zuul/system-proxy/sysfilekind-provider/sysfilekind/del-sysfilekind/";
	private static final String	DEL_REAL	= "http://pcitc-zuul/system-proxy/sysfilekind-provider/sysfilekind/del-sysfilekind-real/";

	/**
	 * 标准增删改查
	 */
	private static final String	LIST		= "http://pcitc-zuul/system-proxy/sysfilekind-provider/sysfilekind/sysfilekind_list";
	private static final String	LISTPARAM	= "http://pcitc-zuul/system-proxy/sysfilekind-provider/sysfilekind/sysfilekind_list_param";

	private static final String	LISTPAGE	= "http://pcitc-zuul/system-proxy/sysfilekind-provider/sysfilekind/sysfilekind-page";

	private static final String	SAVE		= "http://pcitc-zuul/system-proxy/sysfilekind-provider/sysfilekind/save_sysfilekind";

	private static final String	DELETE		= "http://pcitc-zuul/system-proxy/sysfilekind-provider/sysfilekind/delete_sysfilekind/";

	private static final String	GET			= "http://pcitc-zuul/system-proxy/sysfilekind-provider/sysfilekind/get_sysfilekind/";

	private static final String	SAVEFile	= "http://pcitc-zuul/system-proxy/sysfilekind-provider/sysfilekind/save_file";

	/**
	 * -查询列表
	 *
	 * @param sysFileKind
	 * @return
	 */
	@RequestMapping(value = "/list", method = RequestMethod.POST)
	@ResponseBody
	@OperationFilter(modelName = "", actionName = "查询列表getList")
	public Object getList(@RequestBody SysFileKind sysFileKind) {
		ResponseEntity<JSONObject> responseEntity = this.restTemplate.exchange(LIST, HttpMethod.POST, new HttpEntity<SysFileKind>(sysFileKind, this.httpHeaders), JSONObject.class);
		JSONObject retJson = responseEntity.getBody();
		List<SysFileKind> list = (List<SysFileKind>) retJson.get("list");
		return list;
	}

	@RequestMapping(value = "/listParam", method = RequestMethod.POST)
	@ResponseBody
	@OperationFilter(modelName = "", actionName = "查询列表getListParam")
	public Object getListParam(@RequestParam String id) {
		httpHeaders.setContentType(MediaType.APPLICATION_FORM_URLENCODED);
		MultiValueMap<String, String> requestBody = new LinkedMultiValueMap<String, String>();
		requestBody.add("id", request.getParameter("id")+"");
		HttpEntity<MultiValueMap<String, String>> entity = new HttpEntity<MultiValueMap<String, String>>(requestBody, this.httpHeaders);
		ResponseEntity<JSONObject> responseEntity = this.restTemplate.exchange(LISTPARAM, HttpMethod.POST, entity, JSONObject.class);
		JSONObject retJson = responseEntity.getBody();
		List<SysFileKind> list = (List<SysFileKind>) retJson.get("list");
		return list;
	}

	/**
	 * -分页查询
	 *
	 * @param param
	 * @return
	 */
	@RequestMapping(value = "/getTableData", method = RequestMethod.POST)
	@ResponseBody
	@OperationFilter(modelName = "", actionName = "分页查询getTableData")
	public Object getTableData(@ModelAttribute("param") LayuiTableParam param) {

		HttpEntity<LayuiTableParam> entity = new HttpEntity<LayuiTableParam>(param, this.httpHeaders);
		ResponseEntity<LayuiTableData> responseEntity = this.restTemplate.exchange(LISTPAGE, HttpMethod.POST, entity, LayuiTableData.class);
		LayuiTableData data = responseEntity.getBody();
		return JSON.toJSON(data).toString();
	}

	@RequestMapping(value = "/getTableDataLayui", method = RequestMethod.POST)
	@ResponseBody
	@OperationFilter(modelName = "", actionName = "getTableDataLayui")
	public Object getTableDataLayui(HttpServletRequest request) {
		List<Object> aoData = null;
		httpHeaders.setContentType(MediaType.APPLICATION_FORM_URLENCODED);
		// //传递参数
		// MultiValueMap<String, String> requestBody = new
		// LinkedMultiValueMap<String, String>();
		// requestBody.add("jsonStr", JSONArray.fromObject(aoData).toString());
		// HttpEntity<MultiValueMap<String, String>> entity = new
		// HttpEntity<MultiValueMap<String, String>>(requestBody,
		// this.httpHeaders);
		//
		// ResponseEntity<net.sf.json.JSONObject> responseEntity =
		// this.restTemplate.exchange(LISTPAGE, HttpMethod.POST, entity,
		// net.sf.json.JSONObject.class);
		// net.sf.json.JSONObject retJson = responseEntity.getBody();
		// Long totalCount = retJson.get("totalCount") != null ?
		// Long.parseLong(retJson.get("totalCount").toString()) : 0l;
		// List<SysFileKind> list =
		// JSONArray.toList(retJson.getJSONArray("list"), new SysFileKind(), new
		// JsonConfig());
		List<SysFile> list = new ArrayList<>();
		SysFile sysFile = new SysFile();
		sysFile.setId("1");
		sysFile.setFileName("文档");

		SysFile sysFile1 = new SysFile();
		sysFile1.setId("2");
		sysFile1.setFileName("图片");

		list.add(sysFile);
		list.add(sysFile1);
		System.out.println("-------------------");
		System.out.println("list = "+list);
		DataTableLayui data = new DataTableLayui();
		data.setData(list);
		data.setMsg("");
		data.setCode("0");
		// 要显示的总条数
		// 真实的总条数
		System.out.println("data = "+JSON.toJSONString(data));
		return JSON.toJSONString(data);
	}

	/**
	 * 保存-
	 *
	 * @param record
	 * @return
	 */
	@RequestMapping(value = "/savesysFileKind")
	@ResponseBody
	@OperationFilter(modelName = "", actionName = "保存saveRecord")
	public int saveRecord(SysFileKind record) {
		if (record.getId()==null||"".equals(record.getId())) {
			record.setCreateDate(DateUtil.format(new Date(), DateUtil.FMT_SS));
			record.setCreatePersonId(sysUserInfo.getUserId());
			record.setCreatePersonName(sysUserInfo.getUserName());
		} else {
			record.setUpdateDate(DateUtil.format(new Date(), DateUtil.FMT_SS));
			record.setUpdatePersonId(sysUserInfo.getUserId());
			record.setUpdatePersonName(sysUserInfo.getUserName());
		}
		record.setStatus("1");
		ResponseEntity<Integer> responseEntity = this.restTemplate.exchange(SAVE, HttpMethod.POST, new HttpEntity<SysFileKind>(record, this.httpHeaders), Integer.class);
		Integer result = responseEntity.getBody();
		return result;
	}

	/**
	 * 删除-
	 *
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "/deletesysFileKindById")
	@ResponseBody
	@OperationFilter(modelName = "", actionName = "删除deleteObject")
	public int deleteObject(HttpServletRequest request) {
		String id = request.getParameter("id");
		ResponseEntity<Integer> responseEntity = restTemplate.exchange(DELETE+id, HttpMethod.POST, new HttpEntity<String>(this.httpHeaders), Integer.class);
		int result = responseEntity.getBody();
		return result;
	}

	/**
	 * 调整编辑页面-
	 *
	 * @param id
	 * @param model
	 * @return
	 */
	@RequestMapping(method = RequestMethod.GET, value = "/edit")
	@OperationFilter(modelName = "", actionName = "跳转编辑页面pageEdit")
	public String pageEdit(String id, Model model, String opt, String parentId) {
		request.setAttribute("userInfo", sysUserInfo);
		request.setAttribute("createDate", DateUtil.format(new Date(), DateUtil.FMT_SS));
		model.addAttribute("id", id);
		model.addAttribute("opt", opt);
		model.addAttribute("parentId", parentId);
		return "pplus/doc/sysFileKind_edit";
	}

	/**
	 * 跳转至列表页面
	 *
	 * @return
	 */
	@RequestMapping(value = { "/toListPage" }, method = { RequestMethod.GET })
	@OperationFilter(modelName = "", actionName = "跳转列表页toListPage")
	public String toListPage() {
		return "pplus/doc/sysFileKind_list";
	}

	/**
	 * 跳转至树形列表
	 *
	 * @return
	 */
	@RequestMapping(value = { "/toListPageTree" }, method = { RequestMethod.GET })
	@OperationFilter(modelName = "", actionName = "跳转列表页toListPage")
	public String toListPageTree() {
		return "pplus/doc/sysFileKind_tree_list";
	}

	/**
	 * 根据ID查询对象信息
	 *
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "/getsysFileKindInfo")
	@OperationFilter(modelName = "", actionName = "根据ID查询对象信息getsysFileKindInfo")
	@ResponseBody
	public Object getsysFileKindInfo(HttpServletRequest request) {
		String id = request.getParameter("id");
		ResponseEntity<SysFileKind> responseEntity = this.restTemplate.exchange(GET_INFO+id, HttpMethod.POST, new HttpEntity<String>(this.httpHeaders), SysFileKind.class);
		SysFileKind news = responseEntity.getBody();
		return news;
	}

	/**
	 * 查询信息
	 *
	 * @param id
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/sysfilekind/get/{id}")
	@ResponseBody
	public String getSysFileKindInfo(@PathVariable String id) throws Exception {
		SysFileKind sysFileKind = this.restTemplate.exchange(GET+id, HttpMethod.POST, new HttpEntity<Object>(this.httpHeaders), SysFileKind.class).getBody();
		return JSONObject.toJSONString(sysFileKind);
	}

	@RequestMapping(value = "/sysfilekind/tree-data")
	@ResponseBody
	public String getSysFileKindTreeData() throws Exception {
		SysFileKind sysFileKind = new SysFileKind();
		ResponseEntity<List> responseEntity = this.restTemplate.exchange(TREE_DATA, HttpMethod.POST, new HttpEntity<SysFileKind>(sysFileKind, this.httpHeaders), List.class);
		List treeNodes = responseEntity.getBody();
		return JSONUtils.toJSONString(treeNodes);
	}

	@RequestMapping(value = "/sysfilekind/tree-data-children")
	@ResponseBody
	public String getSysFileKindTreeDataChildren() throws Exception {
		SysFileKind sysFileKind = new SysFileKind();
		ResponseEntity<List> responseEntity = this.restTemplate.exchange(TREE_DATA, HttpMethod.POST, new HttpEntity<SysFileKind>(sysFileKind, this.httpHeaders), List.class);
		List treeNodes = responseEntity.getBody();
		String strTreeJson = JSONUtils.toJSONString(treeNodes);
		System.out.println("strTreeJson = "+strTreeJson);
		System.out.println("strTreeJson = "+strTreeJson.replace("nodes", "children"));
		strTreeJson = strTreeJson.replace("nodes", "children");
		strTreeJson = strTreeJson.replace("text", "name");
		return strTreeJson;
	}

	@RequestMapping(value = "/sysfilekind/tree-datas")
	@ResponseBody
	public String getSysFileKindTreeDatas(HttpServletRequest request) throws Exception {
		List list = this.restTemplate.exchange(TREE_DATA, HttpMethod.POST, new HttpEntity<Object>(this.httpHeaders), List.class).getBody();
		return JSONUtils.toJSONString(list);
	}

	@RequestMapping(value = "/sysfilekind/add")
	public Object addSysFileKind(SysFileKind sysFileKind) throws Exception {
		HttpEntity<Object> entity = new HttpEntity<Object>(sysFileKind, this.httpHeaders);
		System.out.println(entity);
		SysFileKind rs = this.restTemplate.exchange(ADD, HttpMethod.POST, entity, SysFileKind.class).getBody();
		return JSONObject.toJSONString(rs);
	}

	@RequestMapping(value = "/sysfilekind/update")
	public Object updateSysFileKind(SysFileKind sysFileKind) throws Exception {
		DataOperationStatusEnum rs = this.restTemplate.exchange(UPDATE, HttpMethod.POST, new HttpEntity<Object>(sysFileKind, this.httpHeaders), DataOperationStatusEnum.class).getBody();
		return rs;
	}

	@RequestMapping(value = "/sysfilekind/del")
	@ResponseBody
	public Object delSysFileKind() throws Exception {
		SysFileKind sysFileKind = new SysFileKind();
		String id = request.getParameter("sysFileKindId");
		sysFileKind.setParentId(id);
		sysFileKind.setStatus("1");
		ResponseEntity<JSONObject> responseEntity = this.restTemplate.exchange(LIST, HttpMethod.POST, new HttpEntity<SysFileKind>(sysFileKind, this.httpHeaders), JSONObject.class);
		JSONObject json = responseEntity.getBody();
		DataOperationStatusEnum rs;
		if (!"[]".equals(json.getString("list"))) {
			rs = DataOperationStatusEnum.DEL_DATA_ERROR;
		} else {
			rs = this.restTemplate.exchange(DEL+id, HttpMethod.POST, new HttpEntity<Object>(this.httpHeaders), DataOperationStatusEnum.class).getBody();
		}
		return rs;
	}

	@RequestMapping(value = "/sysfilekind/del-real")
	public Object delSysFileKindReal(String id) throws Exception {
		DataOperationStatusEnum rs = this.restTemplate.exchange(DEL_REAL+id, HttpMethod.POST, new HttpEntity<Object>(this.httpHeaders), DataOperationStatusEnum.class).getBody();
		return rs;
	}

	/**
	 * 跳转至列表页面:公共
	 *
	 * @return
	 */
	@RequestMapping(value = { "/toListPagePublic" }, method = { RequestMethod.GET })
	// @OperationFilter(modelName = "", actionName = "跳转列表页toListPagePublic")
	public String toListPagePublic() {
		return "pplus/doc/sysFileKind_tree_public";
	}

	/**
	 * 跳转至列表页面:私有
	 *
	 * @return
	 */
	@RequestMapping(value = { "/toListPagePrivate" }, method = { RequestMethod.GET })
	// @OperationFilter(modelName = "", actionName = "跳转列表页toListPagePrivate")
	public String toListPagePrivate() {
		return "pplus/doc/sysFileKind_tree_private";
	}

	/**
	 * 跳转至列表页面:共享
	 *
	 * @return
	 */
	@RequestMapping(value = { "/toListPageShare" }, method = { RequestMethod.GET })
	@OperationFilter(modelName = "", actionName = "跳转列表页toListPageShare")
	public String toListPageShare() {
		return "pplus/doc/sysFileKind_tree_share";
	}

	/**
	 * 跳转至列表页面:录入
	 *
	 * @return
	 */
	@RequestMapping(value = { "/toListPagePrivateEdit" }, method = { RequestMethod.GET })
	@OperationFilter(modelName = "", actionName = "跳转录入页toListPagePrivateEdit")
	public String toListPagePrivateEdit() {
		request.setAttribute("bak2", UUID.randomUUID().toString().replace("-", ""));
		return "pplus/doc/sysFile_edit";
	}

	/**
	 * 跳转ES查询页面
	 *
	 * @return
	 */
	@RequestMapping(value = { "/toListPageEsEdit" }, method = { RequestMethod.GET })
	@OperationFilter(modelName = "", actionName = "跳转录入页toListPageEsEdit")
	public String toListPageEsEdit() {
		response.addHeader("P3P", "CP=CAO PSA OUR");
		return "pplus/doc/sysFileKind_tree_es";
	}

	/**
	 * 编辑页面-附件上传
	 *
	 * @param id
	 * @param model
	 * @return
	 */
	@RequestMapping(method = RequestMethod.GET, value = "/editUpload")
	@OperationFilter(modelName = "", actionName = "跳转编辑页面sysFile_edit")
	public String pageEditUpload(String id, Model model, String opt, String parentId) {
		model.addAttribute("id", id);
		model.addAttribute("opt", opt);
		model.addAttribute("parentId", parentId);
		Object dataId = request.getParameter("dataId");
		model.addAttribute("bak2", dataId==null ? UUID.randomUUID().toString().replace("-", "") : dataId);
		return "pplus/doc/sysFile_edit";
	}

	@RequestMapping(value = { "/toListPageAll" }, method = { RequestMethod.GET })
	@OperationFilter(modelName = "", actionName = "跳转列表页toListPageAll")
	public String toListPageShareAll() {
		return "pplus/doc/sysFileKind_tree_all";
	}

	@RequestMapping(value = { "/toListPageAllTest" }, method = { RequestMethod.GET })
	@OperationFilter(modelName = "", actionName = "toListPageAllTest")
	public String toListPageAllTest() {
		return "layui/tree_tableDemo";
	}

	/**
	 * 保存-
	 *
	 * @param record
	 * @return
	 */
	@RequestMapping(value = "/savesysFileKindUpload")
	@ResponseBody
	@OperationFilter(modelName = "", actionName = "保存saveRecordUpload")
	public int saveRecordUpload(SysFileKind record) {
		record.setUpdateDate(DateUtil.format(new Date(), DateUtil.FMT_SS));
		record.setUpdatePersonId(sysUserInfo.getUserId());
		record.setUpdatePersonName(sysUserInfo.getUserName());
		record.setCreateDate(DateUtil.format(new Date(), DateUtil.FMT_SS));
		record.setCreatePersonId(sysUserInfo.getUserId());
		record.setCreatePersonName(sysUserInfo.getUserName());
		ResponseEntity<Integer> responseEntity = this.restTemplate.exchange(SAVEFile, HttpMethod.POST, new HttpEntity<SysFileKind>(record, this.httpHeaders), Integer.class);
		Integer result = responseEntity.getBody();
		return result;
	}

}