package com.pcitc.web.controller.doc;

import java.util.Date;
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
import com.pcitc.base.doc.SysFileShare;
import com.pcitc.base.util.DateUtil;
import com.pcitc.web.common.BaseController;
import com.pcitc.web.common.DataTableParameter;
import com.pcitc.web.common.OperationFilter;

/**
 * <p>
 * 控制类
 * </p>
 * <p>
 * Table: sys_file_share - 文件分享信息
 * </p>
 *
 * @since 2018-06-19 04:01:58
 */

@Controller
@RequestMapping("sysfileshare")
public class SysFileShareController extends BaseController {

	private static final String GET_INFO = "http://pcitc-zuul/system-proxy/sysfileshare-provider/sysfileshare/get-sysfileshare/";
	private static final String TREE_DATA = "http://pcitc-zuul/system-proxy/sysfileshare-provider/sysfileshare/tree-data";
	private static final String ADD = "http://pcitc-zuul/system-proxy/sysfileshare-provider/sysfileshare/add-sysfileshare";
	private static final String UPDATE = "http://pcitc-zuul/system-proxy/sysfileshare-provider/sysfileshare/update-sysfileshare";
	private static final String DEL = "http://pcitc-zuul/system-proxy/sysfileshare-provider/sysfileshare/del-sysfileshare/";
	private static final String DEL_REAL = "http://pcitc-zuul/system-proxy/sysfileshare-provider/sysfileshare/del-sysfileshare-real/";

	/**
	 * 标准增删改查
	 */
	private static final String LIST = "http://pcitc-zuul/system-proxy/sysfileshare-provider/sysfileshare/sysfileshare_list";
	private static final String LISTPARAM = "http://pcitc-zuul/system-proxy/sysfileshare-provider/sysfileshare/sysfileshare_list_param";

	private static final String LISTPAGE = "http://pcitc-zuul/system-proxy/sysfileshare-provider/sysfileshare/sysfileshare-page";

	private static final String SAVE = "http://pcitc-zuul/system-proxy/sysfileshare-provider/sysfileshare/save_sysfileshare";

	private static final String SAVE_FILE = "http://pcitc-zuul/system-proxy/sysfileshare-provider/sysfileshare/save_sysfileshare_file";

	private static final String DELETE = "http://pcitc-zuul/system-proxy/sysfileshare-provider/sysfileshare/delete_sysfileshare/";

	private static final String GET = "http://pcitc-zuul/system-proxy/sysfileshare-provider/sysfileshare/get_sysfileshare/";

	/**
	 * 文件分享信息-查询列表
	 *
	 * @param fileId
	 * @return
	 */
	@RequestMapping(value = "/list", method = RequestMethod.POST)
	@ResponseBody
	@OperationFilter(modelName = "文件分享信息", actionName = "查询列表getList")
	public Object getList(@RequestParam String fileId) {

		SysFileShare sysFileShare = new SysFileShare();
		sysFileShare.setFileId(fileId);
		ResponseEntity<JSONObject> responseEntity = this.restTemplate.exchange(LIST, HttpMethod.POST, new HttpEntity<SysFileShare>(sysFileShare, this.httpHeaders), JSONObject.class);
		JSONObject retJson = responseEntity.getBody();
		List<SysFileShare> list = (List<SysFileShare>) retJson.get("list");
		return list;
	}

	@RequestMapping(value = "/listParam", method = RequestMethod.POST)
	@ResponseBody
	@OperationFilter(modelName = "文件分享信息", actionName = "查询列表getListParam")
	public Object getListParam(@RequestParam String id) {
		httpHeaders.setContentType(MediaType.APPLICATION_FORM_URLENCODED);
		MultiValueMap<String, String> requestBody = new LinkedMultiValueMap<String, String>();
		requestBody.add("id", request.getParameter("id") + "");
		HttpEntity<MultiValueMap<String, String>> entity = new HttpEntity<MultiValueMap<String, String>>(requestBody, this.httpHeaders);
		ResponseEntity<JSONObject> responseEntity = this.restTemplate.exchange(LISTPARAM, HttpMethod.POST, entity, JSONObject.class);
		JSONObject retJson = responseEntity.getBody();
		List<SysFileShare> list = (List<SysFileShare>) retJson.get("list");
		return list;
	}

	/**
	 * 文件分享信息-分页查询
	 *
	 * @param aoData
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "/getTableData", method = RequestMethod.POST)
	@ResponseBody
	@OperationFilter(modelName = "文件分享信息", actionName = "分页查询getTableData")
	public Object getTableData(@RequestBody List<Object> aoData, HttpServletRequest request) {
		httpHeaders.setContentType(MediaType.APPLICATION_FORM_URLENCODED);
		// 传递参数
		MultiValueMap<String, String> requestBody = new LinkedMultiValueMap<String, String>();
		requestBody.add("jsonStr", JSONArray.parseArray(JSON.toJSONString(aoData)).toString());
		HttpEntity<MultiValueMap<String, String>> entity = new HttpEntity<MultiValueMap<String, String>>(requestBody, this.httpHeaders);

		ResponseEntity<JSONObject> responseEntity = this.restTemplate.exchange(LISTPAGE, HttpMethod.POST, entity, JSONObject.class);
		JSONObject retJson = responseEntity.getBody();
		Long totalCount = retJson.get("totalCount") != null ? Long.parseLong(retJson.get("totalCount").toString()) : 0l;
		List<SysFileShare> list = JSONObject.parseArray(retJson.getJSONArray("list").toJSONString(), SysFileShare.class);
		DataTableParameter data = new DataTableParameter();
		data.setAaData(list);
		// 要显示的总条数
		data.setiTotalDisplayRecords(totalCount);
		// 真实的总条数
		data.setiTotalRecords(totalCount);
		return data;
	}

	/**
	 * 保存-文件分享信息
	 *
	 * @param record
	 * @return
	 */
	@RequestMapping(value = "/savesysFileShare")
	@ResponseBody
	@OperationFilter(modelName = "文件分享信息", actionName = "保存saveRecord")
	public int saveRecord(SysFileShare record) {
		record.setUserId(sysUserInfo.getUserId());
		if (record.getId() == null || "".equals(record.getId())) {
			record.setCreateDate(DateUtil.format(new Date(), DateUtil.FMT_SS));
			record.setCreatePersonId(sysUserInfo.getUserId());
			record.setCreatePersonName(sysUserInfo.getUserName());
		} else {
			record.setUpdateDate(DateUtil.format(new Date(), DateUtil.FMT_SS));
			record.setUpdatePersonId(sysUserInfo.getUserId());
			record.setUpdatePersonName(sysUserInfo.getUserName());
		}
		record.setStatus("1");
		ResponseEntity<Integer> responseEntity = this.restTemplate.exchange(SAVE, HttpMethod.POST, new HttpEntity<SysFileShare>(record, this.httpHeaders), Integer.class);
		Integer result = responseEntity.getBody();
		return result;
	}

	/**
	 * 保存-文件分享信息
	 *
	 * @param record
	 * @return
	 */
	@RequestMapping(value = "/savesysFileShareFile")
	@ResponseBody
	@OperationFilter(modelName = "文件分享信息", actionName = "保存savesysFileShareFile")
	public int saveRecordFile(SysFileShare record) {
		record.setUserId(sysUserInfo.getUserId());
		if (record.getId() == null || "".equals(record.getId())) {
			record.setCreateDate(DateUtil.format(new Date(), DateUtil.FMT_SS));
			record.setCreatePersonId(sysUserInfo.getUserId());
			record.setCreatePersonName(sysUserInfo.getUserName());
		} else {
			record.setUpdateDate(DateUtil.format(new Date(), DateUtil.FMT_SS));
			record.setUpdatePersonId(sysUserInfo.getUserId());
			record.setUpdatePersonName(sysUserInfo.getUserName());
		}
		record.setStatus("1");
		ResponseEntity<Integer> responseEntity = this.restTemplate.exchange(SAVE_FILE, HttpMethod.POST, new HttpEntity<SysFileShare>(record, this.httpHeaders), Integer.class);
		Integer result = responseEntity.getBody();
		return result;
	}

	/**
	 * 删除-文件分享信息
	 *
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "/deletesysFileShareById")
	@ResponseBody
	@OperationFilter(modelName = "文件分享信息", actionName = "删除deleteObject")
	public int deleteObject(HttpServletRequest request) {
		String id = request.getParameter("id");
		ResponseEntity<Integer> responseEntity = restTemplate.exchange(DELETE + id, HttpMethod.POST, new HttpEntity<String>(this.httpHeaders), Integer.class);
		int result = responseEntity.getBody();
		return result;
	}

	/**
	 * 调整编辑页面-文件分享信息
	 *
	 * @param id
	 * @param model
	 * @return
	 */
	@RequestMapping(method = RequestMethod.GET, value = "/edit")
	@OperationFilter(modelName = "文件分享信息", actionName = "跳转编辑页面pageEdit")
	public String pageEdit(String id, Model model, String opt, String fieldId) {
		model.addAttribute("id", id);
		model.addAttribute("opt", opt);
		model.addAttribute("fieldId", fieldId);
		return "pplus/doc/sysFileShare_edit";
	}

	/**
	 * 跳转至文件分享信息列表页面
	 *
	 * @return
	 */
	@RequestMapping(value = { "/toListPage" }, method = { RequestMethod.GET })
	@OperationFilter(modelName = "文件分享信息", actionName = "跳转列表页toListPage")
	public String toListPage() {
		return "pplus/doc/sysFileShare_list";
	}

	/**
	 * 根据ID查询对象信息
	 *
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "/getsysFileShareInfo")
	@OperationFilter(modelName = "文件分享信息", actionName = "根据ID查询对象信息getsysFileShareInfo")
	@ResponseBody
	public Object getsysFileShareInfo(HttpServletRequest request) {
		String id = request.getParameter("id");
		ResponseEntity<SysFileShare> responseEntity = this.restTemplate.exchange(GET_INFO + id, HttpMethod.POST, new HttpEntity<String>(this.httpHeaders), SysFileShare.class);
		SysFileShare news = responseEntity.getBody();
		return news;
	}

	/**
	 * 查询文件分享信息信息
	 *
	 * @param id
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/sysfileshare/get/{id}")
	@ResponseBody
	public String getSysFileShareInfo(@PathVariable String id) throws Exception {
		SysFileShare sysFileShare = this.restTemplate.exchange(GET + id, HttpMethod.POST, new HttpEntity<Object>(this.httpHeaders), SysFileShare.class).getBody();
		return JSONObject.toJSONString(sysFileShare);
	}

	@RequestMapping(value = "/sysfileshare/tree-data")
	public Object getSysFileShareTreeData() throws Exception {
		TreeNode node = this.restTemplate.exchange(TREE_DATA, HttpMethod.POST, new HttpEntity<Object>(this.httpHeaders), TreeNode.class).getBody();
		return node;
	}

	@RequestMapping(value = "/sysfileshare/tree-datas")
	@ResponseBody
	public String getSysFileShareTreeDatas(HttpServletRequest request) throws Exception {

		List list = this.restTemplate.exchange(TREE_DATA, HttpMethod.POST, new HttpEntity<Object>(this.httpHeaders), List.class).getBody();
		return JSONUtils.toJSONString(list);
	}

	@RequestMapping(value = "/sysfileshare/add")
	public Object addSysFileShare(SysFileShare sysFileShare) throws Exception {
		HttpEntity<Object> entity = new HttpEntity<Object>(sysFileShare, this.httpHeaders);
		System.out.println(entity);
		SysFileShare rs = this.restTemplate.exchange(ADD, HttpMethod.POST, entity, SysFileShare.class).getBody();
		return JSONObject.toJSONString(rs);
	}

	@RequestMapping(value = "/sysfileshare/update")
	public Object updateSysFileShare(SysFileShare sysFileShare) throws Exception {
		DataOperationStatusEnum rs = this.restTemplate.exchange(UPDATE, HttpMethod.POST, new HttpEntity<Object>(sysFileShare, this.httpHeaders), DataOperationStatusEnum.class).getBody();
		return rs;
	}

	@RequestMapping(value = "/sysfileshare/del")
	public Object delSysFileShare(String sysFileShareId) throws Exception {
		DataOperationStatusEnum rs = this.restTemplate.exchange(DEL + sysFileShareId, HttpMethod.POST, new HttpEntity<Object>(this.httpHeaders), DataOperationStatusEnum.class).getBody();
		return rs;
	}

	@RequestMapping(value = "/sysfileshare/del-real")
	public Object delSysFileShareReal(String id) throws Exception {
		DataOperationStatusEnum rs = this.restTemplate.exchange(DEL_REAL + id, HttpMethod.POST, new HttpEntity<Object>(this.httpHeaders), DataOperationStatusEnum.class).getBody();
		return rs;
	}

	/**
	 * 跳转列表页-用户选择
	 * 
	 * @return
	 */
	@RequestMapping(method = RequestMethod.GET, value = "/dialog_user_list")
	@OperationFilter(modelName = "文件分享信息", actionName = "跳转用户选择列表页面dialog_user_list")
	public String pageDialogUserList(String id, Model model, String opt, String fieldId) {
		model.addAttribute("id", id);
		model.addAttribute("opt", opt);
		model.addAttribute("fieldId", fieldId);
		return "pplus/doc/dialog_user_list";
	}

	// @RequestMapping(method = RequestMethod.GET, value =
	// "/page_layui_tree_list")
	// @OperationFilter(modelName = "测试layui", actionName =
	// "跳转用户选择列表页面dialog_user_list")
	// public String pageDialogUserList() {
	// return "pplus/doc/dialog_user_list";
	// }
}