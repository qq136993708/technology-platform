package com.pcitc.web.controller.other;

import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.pcitc.base.common.LayuiTableData;
import com.pcitc.base.common.LayuiTableParam;
import com.pcitc.base.common.Result;
import com.pcitc.base.common.enums.RequestProcessStatusEnum;
import com.pcitc.base.stp.out.OutProjectInfo;
import com.pcitc.base.system.SysDictionary;
import com.pcitc.base.system.SysUnit;
import com.pcitc.base.util.CommonUtil;
import com.pcitc.base.util.DateUtil;
import com.pcitc.base.util.IdUtil;
import com.pcitc.web.common.BaseController;
import com.pcitc.web.utils.EquipmentUtils;
@Controller
public class TenDragonsContorller extends BaseController {
	
	private static final String PAGE_URL =   "http://pcitc-zuul/system-proxy/out-project-provider/ten_dragons/page";
	private static final String ADD_URL =    "http://pcitc-zuul/system-proxy/out-project-provider/ten_dragons/add";
	private static final String UPDATE_URL = "http://pcitc-zuul/system-proxy/out-project-provider/ten_dragons/update";
	private static final String DEL_URL =    "http://pcitc-zuul/system-proxy/out-project-provider/ten_dragons/delete/";
	private static final String GET_URL =    "http://pcitc-zuul/system-proxy/out-project-provider/ten_dragons/get/";
	
	private static final String ADD_WithBLOB_URL =    "http://pcitc-zuul/system-proxy/out-project-provider/ten_dragons/addWithBLOB";
	private static final String UPDATE_WithBLOB_URL = "http://pcitc-zuul/system-proxy/out-project-provider/ten_dragons/updateWithBLOB";
	private static final String GET_WithBLOB_URL =    "http://pcitc-zuul/system-proxy/out-project-provider/ten_dragons/getWithBLOB/";
	
	
	  //十条龙维护
	  @RequestMapping(method = RequestMethod.GET, value = "/ten_dragons/list")
	  public String ten_dragons(HttpServletRequest request) throws Exception
	  {
		    
		  
		    //项目状态
			List<SysDictionary> statusList=	EquipmentUtils.getSysDictionaryListByParentCode("ROOT_STLGL_XMZT", restTemplate, httpHeaders);
			request.setAttribute("statusList", statusList);
			
			
			//单位类型
			List<SysDictionary> define6List=	EquipmentUtils.getSysDictionaryListByParentCode("ROOT_STLGL_DWLX", restTemplate, httpHeaders);
			request.setAttribute("define6List", define6List);
			
			
			//科技部
			List<SysDictionary> zycmcList=	EquipmentUtils.getSysDictionaryListByParentCode("ROOT_ZGSHJT_ZBJG_KJB", restTemplate, httpHeaders);
			request.setAttribute("zycmcList", zycmcList);
			
			
			
			
			
	        return "stp/other/ten_dragons/list";
	  }
	  
	  

		@RequestMapping(value = "/ten_dragons/list_date")
		@ResponseBody
		public String ajaxlist(@ModelAttribute("param") LayuiTableParam param, HttpServletRequest request, HttpServletResponse response) {
			LayuiTableData layuiTableData = new LayuiTableData();
			HttpEntity<LayuiTableParam> entity = new HttpEntity<LayuiTableParam>(param, httpHeaders);
			ResponseEntity<LayuiTableData> responseEntity = restTemplate.exchange(PAGE_URL, HttpMethod.POST, entity, LayuiTableData.class);
			int statusCode = responseEntity.getStatusCodeValue();
			if (statusCode == 200) {
				layuiTableData = responseEntity.getBody();
			}
			JSONObject result = JSONObject.parseObject(JSONObject.toJSONString(layuiTableData));
			// 安全设置：归档文件下载
			response.setHeader("Pragma", "no-cache");
			response.setHeader("Cache-Control", "no-cache");
			return result.toString();
		}

		

		/**
		 * 增加
		 * @param request
		 * @param response
		 * @return
		 * @throws Exception
		 */
		@RequestMapping(value = "/ten_dragons/add")
		public String add(HttpServletRequest request, HttpServletResponse response) throws Exception {
			String dataId = CommonUtil.getParameter(request, "dataId", "");
			request.setAttribute("dataId", dataId);
			String attachmentId = IdUtil.createFileIdByTime();
			request.setAttribute("attachmentId", attachmentId);
			if(!dataId.equals(""))
			{
				ResponseEntity<OutProjectInfo> responseEntity = this.restTemplate.exchange(GET_WithBLOB_URL + dataId, HttpMethod.GET, new HttpEntity<Object>(this.httpHeaders), OutProjectInfo.class);
				int statusCode = responseEntity.getStatusCodeValue();
				if (statusCode == 200)
				{
					OutProjectInfo outProjectInfo = responseEntity.getBody();
					request.setAttribute("outProjectInfo", outProjectInfo);
				}
				
			}

			return "stp/other/ten_dragons/add";
		}

		/**
		 * 保存-更新操作
		 * @param request
		 * @param response
		 * @return
		 * @throws Exception
		 */
		@RequestMapping(method = RequestMethod.POST, value = "/ten_dragons/save")
		public String saveOrUpdate(HttpServletRequest request, HttpServletResponse response) throws Exception {

			Result resultsDate = new Result();
			String meetingPlace = CommonUtil.getParameter(request, "meetingPlace", "");
			String meetingContent = CommonUtil.getParameter(request, "meetingContent", "");
			String remark = CommonUtil.getParameter(request, "remark", "");
			String meetingEmcee = CommonUtil.getParameter(request, "meetingEmcee", "");
			String status = CommonUtil.getParameter(request, "status", "");
			String zysx = CommonUtil.getParameter(request, "zysx", "");
			String zyly = CommonUtil.getParameter(request, "zyly", "");
			String zylbbm = CommonUtil.getParameter(request, "zylbbm", "");
			String zylb = CommonUtil.getParameter(request, "zylb", "");
			String zycbm = CommonUtil.getParameter(request, "zycbm", "");
			String dataId = CommonUtil.getParameter(request, "dataId", "");
			String erpProjectCode = CommonUtil.getParameter(request, "erpProjectCode", "");
			String erpProjectName = CommonUtil.getParameter(request, "erpProjectName", "");
			String projectType = CommonUtil.getParameter(request, "projectType", "");
			String typeFlag = CommonUtil.getParameter(request, "typeFlag", "");
			String fwdx = CommonUtil.getParameter(request, "fwdx", "");
			String fwdxbm = CommonUtil.getParameter(request, "fwdxbm", "");
			String fzdwunit = CommonUtil.getParameter(request, "fzdwunit", "");
			String fzdwunitcw = CommonUtil.getParameter(request, "fzdwunitcw", "");
			String fzrdh = CommonUtil.getParameter(request, "fzrdh", "");
			String fzrxm = CommonUtil.getParameter(request, "fzrxm", "");
			String fzryx = CommonUtil.getParameter(request, "fzryx", "");
			String gsbmbm = CommonUtil.getParameter(request, "gsbmbm", "");
			String gsbmmc = CommonUtil.getParameter(request, "gsbmmc", "");
			String hth = CommonUtil.getParameter(request, "hth", "");
			String parentProjectId = CommonUtil.getParameter(request, "parentProjectId", "");
			String projectId = CommonUtil.getParameter(request, "projectId", "");
			String jf = CommonUtil.getParameter(request, "jf", "");
			String jssj = CommonUtil.getParameter(request, "jssj", "");
			String jssxxm = CommonUtil.getParameter(request, "jssxxm", "");
			String jtfzdwbm = CommonUtil.getParameter(request, "jtfzdwbm", "");
			String jtfzdw = CommonUtil.getParameter(request, "jtfzdw", "");
			String kssj = CommonUtil.getParameter(request, "kssj", "");
			String leaderFlag = CommonUtil.getParameter(request, "leaderFlag", "");
			String lxrdh = CommonUtil.getParameter(request, "lxrdh", "");
			String lxrxm = CommonUtil.getParameter(request, "lxrxm", "");
			String lxryx = CommonUtil.getParameter(request, "lxryx", "");
			String projectAbc = CommonUtil.getParameter(request, "projectAbc", "");
			String projectProperty = CommonUtil.getParameter(request, "projectProperty", "");
			String projectScope = CommonUtil.getParameter(request, "projectScope", "");
			String projectSource = CommonUtil.getParameter(request, "projectSource", "");
			String projectLevel = CommonUtil.getParameter(request, "projectLevel", "");
			String attachmentId = CommonUtil.getParameter(request, "attachmentId", "");

			OutProjectInfo outProjectInfo = null;
			if (dataId.equals("")) {
				outProjectInfo = new OutProjectInfo();
				outProjectInfo.setCreateDate(new Date());
				String id = UUID.randomUUID().toString().replaceAll("-", "");
				outProjectInfo.setDataId(id);
				outProjectInfo.setCreatePerson(sysUserInfo.getUserDisp());
		
			} else {
				ResponseEntity<OutProjectInfo> se = this.restTemplate.exchange(GET_WithBLOB_URL + dataId, HttpMethod.GET, new HttpEntity<Object>(this.httpHeaders), OutProjectInfo.class);
				outProjectInfo = se.getBody();
			}
			
			outProjectInfo.setErpProjectCode(erpProjectCode);
			outProjectInfo.setErpProjectName(erpProjectName);
			outProjectInfo.setProjectType(projectType);
			outProjectInfo.setTypeFlag(typeFlag);
			outProjectInfo.setFwdx(fwdx);
			outProjectInfo.setFwdxbm(fwdxbm);
			outProjectInfo.setFzdwunit(fzdwunit);
			outProjectInfo.setFzdwunitcw(fzdwunitcw);
			outProjectInfo.setFzrdh(fzrdh);
			outProjectInfo.setFzrxm(fzrxm);
			outProjectInfo.setFzryx(fzryx);
			outProjectInfo.setGsbmbm(gsbmbm);
			outProjectInfo.setGsbmmc(gsbmmc);
			outProjectInfo.setHth(hth);
			outProjectInfo.setParentProjectId(parentProjectId);
			outProjectInfo.setProjectId(projectId);
			outProjectInfo.setJf(jf);
			outProjectInfo.setJssj(jssj);
			outProjectInfo.setJssxxm(jssxxm);
			outProjectInfo.setJtfzdw(jtfzdw);
			outProjectInfo.setJtfzdwbm(jtfzdwbm);
			outProjectInfo.setKssj(kssj);
			outProjectInfo.setLeaderFlag(leaderFlag);
			outProjectInfo.setLxrdh(lxrdh);
			outProjectInfo.setLxrxm(lxrxm);
			outProjectInfo.setLxryx(lxryx);
			outProjectInfo.setProjectLevel(projectLevel);
			outProjectInfo.setProjectAbc(projectAbc);
			outProjectInfo.setProjectLevel(projectLevel);
			outProjectInfo.setProjectProperty(projectProperty);
			outProjectInfo.setProjectScope(projectScope);
			outProjectInfo.setProjectSource(projectSource);
			outProjectInfo.setProjectType(projectType);
			outProjectInfo.setErpProjectCode(erpProjectCode);
			outProjectInfo.setErpProjectName(erpProjectName);
			outProjectInfo.setZycbm(zycbm);
			outProjectInfo.setZylb(zylb);
			outProjectInfo.setZylbbm(zylbbm);
			outProjectInfo.setZyly(zyly);
			outProjectInfo.setZysx(zysx);
			int statusCode =0;
			// 判断是新增还是修改
			if (dataId.equals(""))
			{
				 ResponseEntity<String> responseEntity = this.restTemplate.exchange(ADD_URL, HttpMethod.POST, new HttpEntity<OutProjectInfo>(outProjectInfo, this.httpHeaders), String.class);
				 statusCode = responseEntity.getStatusCodeValue();
				
			} else 
			{
				ResponseEntity<Integer> responseEntity = this.restTemplate.exchange(UPDATE_URL, HttpMethod.POST, new HttpEntity<OutProjectInfo>(outProjectInfo, this.httpHeaders), Integer.class);
				statusCode = responseEntity.getStatusCodeValue();
			}
			
			// 返回结果代码
			if (statusCode == 200)
			{
				resultsDate = new Result(true, RequestProcessStatusEnum.OK.getStatusDesc());
			} else {
				resultsDate = new Result(false, RequestProcessStatusEnum.SERVER_BUSY.getStatusDesc());
			}

			response.setContentType("text/html;charset=UTF-8");
			PrintWriter out = response.getWriter();
			JSONObject ob = JSONObject.parseObject(JSONObject.toJSONString(resultsDate));
			out.println(ob.toString());
			out.flush();
			out.close();
			return null;
		}
		

		/**
		 * 修改
		 * 
		 * @param request
		 * @param response
		 * @return
		 * @throws Exception
		 */
		@RequestMapping(value = "/ten_dragons/update")
		public String update(HttpServletRequest request, HttpServletResponse response) throws Exception {

			String dataId = CommonUtil.getParameter(request, "dataId", "");
			request.setAttribute("dataId", dataId);
			ResponseEntity<OutProjectInfo> responseEntity = this.restTemplate.exchange(GET_URL + dataId, HttpMethod.GET, new HttpEntity<Object>(this.httpHeaders), OutProjectInfo.class);
			int statusCode = responseEntity.getStatusCodeValue();
			logger.info("============远程返回  statusCode " + statusCode);
			OutProjectInfo outProjectInfo = responseEntity.getBody();
			request.setAttribute("outProjectInfo", outProjectInfo);
			request.setAttribute("attachmentId", outProjectInfo.getAttachmentId());

			return "stp/other/ten_dragons/add";
		}

		/**
		 * 删除
		 * 
		 * @param request
		 * @param response
		 * @return
		 * @throws Exception
		 */
		@RequestMapping(value = "/ten_dragons/delete/{id}")
		public String delete(@PathVariable("id") String id, HttpServletRequest request, HttpServletResponse response) throws Exception {
			Result resultsDate = new Result();
			ResponseEntity<Integer> responseEntity = this.restTemplate.exchange(DEL_URL + id, HttpMethod.POST, new HttpEntity<Object>(this.httpHeaders), Integer.class);
			int statusCode = responseEntity.getStatusCodeValue();
			int status = responseEntity.getBody();
			logger.info("============远程返回  statusCode " + statusCode + "  status=" + status);
			if (responseEntity.getBody() > 0) {
				resultsDate = new Result(true);
			} else {
				resultsDate = new Result(false, "删除失败，请联系系统管理员！");
			}
			response.setContentType("text/html;charset=UTF-8");
			PrintWriter out = response.getWriter();
			JSONObject ob = JSONObject.parseObject(JSONObject.toJSONString(resultsDate));
			out.println(ob.toString());
			out.flush();
			out.close();
			return null;
		}
		

		/**
		 * 详情
		 * 
		 * @param request
		 * @param response
		 * @return
		 * @throws Exception
		 */
		@RequestMapping(value = "/ten_dragons/get/{id}", method = RequestMethod.GET)
		public String get(@PathVariable("id") String id, HttpServletRequest request, HttpServletResponse response) throws Exception {
			ResponseEntity<OutProjectInfo> responseEntity = this.restTemplate.exchange(GET_WithBLOB_URL + id, HttpMethod.GET, new HttpEntity<Object>(this.httpHeaders), OutProjectInfo.class);
			int statusCode = responseEntity.getStatusCodeValue();
			logger.info("============远程返回  statusCode " + statusCode);
			OutProjectInfo outProjectInfo = responseEntity.getBody();
			request.setAttribute("outProjectInfo", outProjectInfo);
			return "stp/other/ten_dragons/view";
		}


}
