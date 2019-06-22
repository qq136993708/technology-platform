package com.pcitc.web.controller.system;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.pcitc.base.common.InforVo;
import com.pcitc.base.system.SysNotice;
import com.pcitc.base.system.SysNoticeVo;
import com.pcitc.base.system.SysUser;
import com.pcitc.base.util.DataTableInfoVo;
import com.pcitc.base.util.DateTableUtil;
import com.pcitc.base.util.DateUtil;
import com.pcitc.web.common.BaseController;
import com.pcitc.web.common.DataTableParameter;
import org.apache.commons.lang.StringUtils;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("sysNotice")
public class SysNoticeController extends BaseController {

	private static final String NOTICE_LIST = "http://pcitc-zuul/system-proxy/sysNotice-provider/sysNotice_list";

	private static final String SAVE_NOTICE = "http://pcitc-zuul/system-proxy/sysNotice-provider/saveSysNotice";

	private static final String DELETE_NOTICE = "http://pcitc-zuul/system-proxy/sysNotice-provider/deleteSysNotice/";

	private static final String GET_NOTICE = "http://pcitc-zuul/system-proxy/sysNotice-provider/getSysNotice/";

	private static final String VIEW_NOTICE = "http://pcitc-zuul/system-proxy/sysNotice-provider/getSysNoticeView/";

	private static final String COUNT_NOTICE = "http://pcitc-zuul/system-proxy/sysNotice-provider/getSysNoticeCount";

	/**
	 * 跳转到公告列表页
	 */
	@RequestMapping(value = "/sysNotice_list")
	public String toList(String userNoticeStatus, Model model,HttpServletRequest request, HttpServletResponse response) {
		if (StringUtils.isEmpty(userNoticeStatus))
			userNoticeStatus = "";
		model.addAttribute("userNoticeStatus", userNoticeStatus);
		request.setAttribute("userId", sysUserInfo.getUserId());
		return "/base/system/sysNotice_list";
	}

	/**
	 * 跳转到查看公告列表页
	 */
	@RequestMapping(value = "/index_notice")
	public String toIndexNotice(Model model) {
		return "/base/system/index_notice";
	}

	/**
	 * 跳转到公告详情页
	 */
	@RequestMapping(value = "/sysNotice_info")
	public String toInfo(String id, Model model) {
		if (StringUtils.isEmpty(id))
			id = "";
		model.addAttribute("id", id);
		model.addAttribute("currentUser", sysUserInfo);
		return "/base/system/sysNotice_info";
	}

	/**
	 * 获取列表数据
	 */
	@RequestMapping(value = "/getTableData", method = RequestMethod.POST)
	@ResponseBody
	public Object getTableData(@RequestBody List<Object> aoData, HttpServletRequest request) throws IOException {
		String exchangeUrl = NOTICE_LIST;
		DataTableInfoVo dataTableInfoVo = DateTableUtil.getAllParam(aoData);
		SysNoticeVo vo = new SysNoticeVo();
		SysUser currentUser = sysUserInfo;
		// 管理员默认看到所有公告
		vo.setUserId(currentUser.getUserId());
		// if(!"123456".equals(currentUser.getUserName())) {
		// vo.setUserId(currentUser.getUserId());
		// }
		vo.setDataTableInfoVo(dataTableInfoVo);
		JSONArray ja = JSONArray.parseArray(JSON.toJSONString(aoData));
		for (int i = 0; i < ja.size(); i++) {
			if (ja.getJSONObject(i).getString("name").equals("noticeTitle")) {
				vo.setNoticeTitle(ja.getJSONObject(i).getString("value"));
			}
			if (ja.getJSONObject(i).getString("name").equals("userNoticeStatus")) {
				vo.setUserNoticeStatus(Integer.parseInt(ja.getJSONObject(i).getString("value")));
			}
		}
		HttpEntity<SysNoticeVo> entity = new HttpEntity<SysNoticeVo>(vo, this.httpHeaders);
		ResponseEntity<String> responseEntity = this.restTemplate.exchange(exchangeUrl, HttpMethod.POST, entity, String.class);
		String result = responseEntity.getBody();
		JSONObject retJson = JSONObject.parseObject(result);
		DataTableParameter data = new DataTableParameter();
		if (retJson != null) {
			Long totalCount = retJson.get("totalCount") != null ? Long.parseLong(retJson.get("totalCount").toString()) : 0l;
			List<SysNotice> sysNoticeList = JSON.parseArray(retJson.getJSONArray("list").toJSONString(), SysNotice.class);
			data.setAaData(sysNoticeList);
			// 要显示的总条数
			data.setiTotalDisplayRecords(totalCount);
			// 真实的总条数
			data.setiTotalRecords(totalCount);
		}
		return data;
	}

	/**
	 * 获取列表数据
	 */
	@RequestMapping(value = "/getSysNoticeList", method = RequestMethod.POST)
	@ResponseBody
	public Object getSysNoticeList(HttpServletRequest request, HttpServletResponse response) throws IOException {
		SysNoticeVo vo = new SysNoticeVo();
		String page = request.getParameter("page"); // 起始索引
		String limit = request.getParameter("limit"); // 每页显示的行数
		String noticeTitle = request.getParameter("noticeTitle");
		String isRead = request.getParameter("isRead");
		vo.setPage(page);
		vo.setLimit(limit);
		SysUser currentUser = sysUserInfo;
		// 管理员默认看到所有公告
		if (StringUtils.isNotEmpty(isRead)) {
			vo.setUserId(currentUser.getUserId());
			// vo.setUserNoticeStatus(0);
		}
		if (StringUtils.isNotEmpty(noticeTitle)) {
			vo.setNoticeTitle(noticeTitle);
		}
		HttpEntity<SysNoticeVo> entity = new HttpEntity<SysNoticeVo>(vo, this.httpHeaders);
		ResponseEntity<String> responseEntity = this.restTemplate.exchange(NOTICE_LIST, HttpMethod.POST, entity, String.class);
		String result = responseEntity.getBody();
		JSONObject retJson = JSONObject.parseObject(result);
		if (retJson != null) {
			Long totalCount = retJson.get("totalCount") != null ? Long.parseLong(retJson.get("totalCount").toString()) : 0l;
			List<SysNotice> resultList = JSON.parseArray(retJson.getJSONArray("list").toJSONString(), SysNotice.class);
			JSONObject jsonObj = new JSONObject();
			jsonObj.put("code", "0");
			jsonObj.put("msg", "提示");
			jsonObj.put("count", totalCount);
			jsonObj.put("data", resultList);
			return jsonObj.toString();
		}
		return null;
	}

	/**
	 * 保存公告
	 * 
	 * @param sysNotice
	 * @return
	 */
	@RequestMapping(value = "/saveSysNotice")
	@ResponseBody
	public int saveSysNotice(@RequestBody SysNotice sysNotice) {
		sysNotice.setNoticeCreatetime(DateUtil.dateToStr(new Date(), DateUtil.FMT_SS));
		HttpEntity<SysNotice> entity = new HttpEntity<SysNotice>(sysNotice, this.httpHeaders);
		ResponseEntity<Integer> responseEntity = this.restTemplate.exchange(SAVE_NOTICE, HttpMethod.POST, entity, Integer.class);
		int result = responseEntity.getBody();
		return result;
	}

	/**
	 * 删除公告
	 * 
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "/deleteSysNotice")
	@ResponseBody
	public int deleteSysNotice(HttpServletRequest request) {
		String id = request.getParameter("id");
		ResponseEntity<Integer> responseEntity = this.restTemplate.exchange(DELETE_NOTICE + id, HttpMethod.POST, new HttpEntity<String>(this.httpHeaders), Integer.class);
		int result = responseEntity.getBody();
		return result;
	}

	/**
	 * 获取公告详情
	 * 
	 * @return
	 */
	@RequestMapping(value = "/getSysNotice")
	@ResponseBody
	public Object getSysNotice(HttpServletRequest request) {
		String id = request.getParameter("id");
		ResponseEntity<SysNotice> responseEntity = this.restTemplate.exchange(GET_NOTICE + id, HttpMethod.POST, new HttpEntity<String>(this.httpHeaders), SysNotice.class);
		SysNotice sysNotice = responseEntity.getBody();
		return sysNotice;
	}

	/**
	 * 首页显示的公告
	 * 
	 * @return
	 */
	@RequestMapping(value = "/noticeListShow", method = RequestMethod.POST)
	@ResponseBody
	public Object noticeListShow(HttpServletRequest request, HttpServletResponse response) throws IOException {
		SysNoticeVo vo = new SysNoticeVo();
		String page = "1";
		String limit = "5";
		vo.setPage(page);
		vo.setLimit(limit);
		vo.setUserId(sysUserInfo.getUserId());
		HttpEntity<SysNoticeVo> entity = new HttpEntity<SysNoticeVo>(vo, this.httpHeaders);
		ResponseEntity<String> responseEntity = this.restTemplate.exchange(NOTICE_LIST, HttpMethod.POST, entity, String.class);
		String result = responseEntity.getBody();
		JSONObject retJson = JSONObject.parseObject(result);
		if (retJson != null) {
			Long totalCount = retJson.get("totalCount") != null ? Long.parseLong(retJson.get("totalCount").toString()) : 0l;
			List<SysNotice> resultList = JSON.parseArray(retJson.getJSONArray("list").toJSONString(), SysNotice.class);
			JSONObject jsonObj = new JSONObject();
			jsonObj.put("code", "0");
			jsonObj.put("msg", "提示");
			jsonObj.put("count", totalCount);
			jsonObj.put("data", resultList);
			return jsonObj.toString();
		}
		return null;
	}

	/**
	 * 跳转至公告查看页面
	 * 
	 * @return
	 */
	@RequestMapping(value = { "/toNoticeShow" }, method = RequestMethod.GET)
	public String toNoticeShow(String id, Model model) {
		SysNoticeVo vo = new SysNoticeVo();
		vo.setNoticeId(id);
		HttpEntity<SysNoticeVo> entity = new HttpEntity<SysNoticeVo>(vo, this.httpHeaders);
		ResponseEntity<SysNotice> responseEntity = this.restTemplate.exchange(VIEW_NOTICE, HttpMethod.POST, entity, SysNotice.class);
		SysNotice sysNotice = responseEntity.getBody();
		InforVo inforVo = new InforVo();
		inforVo.setContent(sysNotice.getNoticeContent());
		inforVo.setDate(sysNotice.getNoticePublishtime());
		inforVo.setTitle(sysNotice.getNoticeTitle());
		model.addAttribute("info", inforVo);
		Object stype = request.getParameter("stype");
		if (stype == null || "".equals(stype)) {
			return "base/system/info-dialog";
		} else {
			return "base/system/info-detail";
		}
	}

	/**
	 * 查看公告
	 * 
	 * @return
	 */
	@RequestMapping(value = "/readNotice")
	public String readNotice(String id, Model model) {
		SysNoticeVo vo = new SysNoticeVo();
		vo.setNoticeId(id);
		SysUser currentUser = sysUserInfo;
		vo.setUserId(currentUser.getUserId());
		HttpEntity<SysNoticeVo> entity = new HttpEntity<SysNoticeVo>(vo, this.httpHeaders);
		ResponseEntity<SysNotice> responseEntity = this.restTemplate.exchange(VIEW_NOTICE, HttpMethod.POST, entity, SysNotice.class);
		SysNotice sysNotice = responseEntity.getBody();
		InforVo inforVo = new InforVo();
		inforVo.setContent(sysNotice.getNoticeContent());
		inforVo.setDate(sysNotice.getNoticePublishtime());
		inforVo.setTitle(sysNotice.getNoticeTitle());
		model.addAttribute("info", inforVo);
		return "base/system/info-dialog";
	}

	/**
	 * 获取公告数量
	 * 
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "/getUserNoticeCount")
	@ResponseBody
	public Long getUserNoticeCount(HttpServletRequest request) {
		SysNoticeVo vo = new SysNoticeVo();
		SysUser currentUser = sysUserInfo;
		vo.setUserId(currentUser.getUserId());
		vo.setUserNoticeStatus(0);
		HttpEntity<SysNoticeVo> noticeEntity = new HttpEntity<SysNoticeVo>(vo, this.httpHeaders);
		ResponseEntity<String> responseNoticeEntity = this.restTemplate.exchange(COUNT_NOTICE, HttpMethod.POST, noticeEntity, String.class);
		String retNoticeJson = responseNoticeEntity.getBody();
		Long totalCount = 0l;
		if (retNoticeJson != null) {
			totalCount = Long.parseLong(retNoticeJson);
		}
		return totalCount;
	}

}
