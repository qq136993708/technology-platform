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
import com.ctc.wstx.util.DataUtil;
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
import com.pcitc.web.utils.HanaUtil;
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
	  
	  

		@RequestMapping(value = "/ten_dragons/list_data")
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
		public String add(HttpServletRequest request, HttpServletResponse response) throws Exception 
		{
			
			String dataId = CommonUtil.getParameter(request, "dataId", "");
			request.setAttribute("dataId", dataId);
			String define18 = IdUtil.createFileIdByTime();
			String nd=HanaUtil.getCurrentYear();
			if(!dataId.equals(""))
			{
				ResponseEntity<OutProjectInfo> responseEntity = this.restTemplate.exchange(GET_WithBLOB_URL + dataId, HttpMethod.GET, new HttpEntity<Object>(this.httpHeaders), OutProjectInfo.class);
				int statusCode = responseEntity.getStatusCodeValue();
				if (statusCode == 200)
				{
					OutProjectInfo outProjectInfo = responseEntity.getBody();
					request.setAttribute("outProjectInfo", outProjectInfo);
					define18=outProjectInfo.getDefine18();
					nd=outProjectInfo.getNd();
				}
			}
			
			
			request.setAttribute("define18", define18);
		    //项目状态
			List<SysDictionary> statusList=	EquipmentUtils.getSysDictionaryListByParentCode("ROOT_STLGL_XMZT", restTemplate, httpHeaders);
			request.setAttribute("statusList", statusList);
			
			//单位类型
			List<SysDictionary> define6List=	EquipmentUtils.getSysDictionaryListByParentCode("ROOT_STLGL_DWLX", restTemplate, httpHeaders);
			request.setAttribute("define6List", define6List);
			
			//科技部
			List<SysDictionary> zycmcList=	EquipmentUtils.getSysDictionaryListByParentCode("ROOT_ZGSHJT_ZBJG_KJB", restTemplate, httpHeaders);
			request.setAttribute("zycmcList", zycmcList);
			
			
			request.setAttribute("nd", nd);
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
		public String saveOrUpdate(HttpServletRequest request, HttpServletResponse response) throws Exception 
		{

			Result resultsDate = new Result();
			String parentProjectId = CommonUtil.getParameter(request, "parentProjectId", "");
			String zycbm   = CommonUtil.getParameter(request, "zycbm", "");
			String nd      = CommonUtil.getParameter(request, "nd", "");
			String status  = CommonUtil.getParameter(request, "status", "入龙");
			String dataId  = CommonUtil.getParameter(request, "dataId", "");
			String hth     = CommonUtil.getParameter(request, "hth", "");
			String ysnd    = CommonUtil.getParameter(request, "ysnd", "");
			String zycmc   = CommonUtil.getParameter(request, "zycmc", "");
			String xmmc    = CommonUtil.getParameter(request, "xmmc", "");
			String define6 = CommonUtil.getParameter(request, "define6", "");
			String fzdwbm  = CommonUtil.getParameter(request, "fzdwbm", "");
			String fzdw    = CommonUtil.getParameter(request, "fzdw", "");
			String define18 = CommonUtil.getParameter(request, "define18", "");
			String define19     = CommonUtil.getParameter(request, "define19", "");
			String fzdwStr     = CommonUtil.getParameter(request, "fzdwStr", "");
			OutProjectInfo outProjectInfo = null;
			if (dataId.equals("")) 
			{
				outProjectInfo = new OutProjectInfo();
				outProjectInfo.setCreateDate(new Date());
				String id = UUID.randomUUID().toString().replaceAll("-", "");
				outProjectInfo.setDataId(id);
				outProjectInfo.setCreatePerson(sysUserInfo.getUserDisp());
				outProjectInfo.setDefine3("十条龙项目");
				outProjectInfo.setProjectProperty("十条龙项目");
				outProjectInfo.setStatus(status);
				outProjectInfo.setProjectId(DateUtil.dateToStr(new Date(), DateUtil.FMT_SSS_03));
				outProjectInfo.setXmid(DateUtil.dateToStr(new Date(), DateUtil.FMT_SSS_03));
			} else 
			{
				ResponseEntity<OutProjectInfo> se = this.restTemplate.exchange(GET_WithBLOB_URL + dataId, HttpMethod.GET, new HttpEntity<Object>(this.httpHeaders), OutProjectInfo.class);
				outProjectInfo = se.getBody();
			}
			
			if(!parentProjectId.equals(""))
			{
				outProjectInfo.setParentProjectId(parentProjectId);
				outProjectInfo.setProjectType("2");
			}else
			{
				outProjectInfo.setProjectType("0");
			}
			
			outProjectInfo.setFzdwStr(fzdwStr);
			outProjectInfo.setDefine19(define19);
			outProjectInfo.setFzdw(fzdw);
			outProjectInfo.setFzdwbm(fzdwbm);
			outProjectInfo.setDefine6(define6);
			outProjectInfo.setXmmc(xmmc);
			outProjectInfo.setZycmc(zycmc);
			outProjectInfo.setZycbm(zycbm);
			outProjectInfo.setHth(hth);
			outProjectInfo.setYsnd(ysnd);
			outProjectInfo.setNd(nd);
			outProjectInfo.setDefine18(define18);
			
			int statusCode =0;
			// 判断是新增还是修改
			if(dataId.equals(""))
			{
				 ResponseEntity<String> responseEntity = this.restTemplate.exchange(ADD_URL, HttpMethod.POST, new HttpEntity<OutProjectInfo>(outProjectInfo, this.httpHeaders), String.class);
				 statusCode = responseEntity.getStatusCodeValue();
				
			} else 
			{
				ResponseEntity<Integer> responseEntity = this.restTemplate.exchange(UPDATE_URL, HttpMethod.POST, new HttpEntity<OutProjectInfo>(outProjectInfo, this.httpHeaders), Integer.class);
				statusCode = responseEntity.getStatusCodeValue();
			}
			
			// 返回结果代码
			if(statusCode == 200)
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
