package com.pcitc.web.controller.system;

import java.io.PrintWriter;
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
import com.alibaba.fastjson.JSONObject;
import com.pcitc.base.common.LayuiTableData;
import com.pcitc.base.common.LayuiTableParam;
import com.pcitc.base.common.Result;
import com.pcitc.base.common.enums.RequestProcessStatusEnum;
import com.pcitc.base.system.Department;
import com.pcitc.base.system.SysDictionary;
import com.pcitc.base.util.CommonUtil;
import com.pcitc.base.util.IdUtil;
import com.pcitc.web.common.BaseController;
import com.pcitc.web.utils.EquipmentUtils;

@Controller
public class DepartmentController extends BaseController {


	private static final String PAGE_URL   = "http://pcitc-zuul/system-proxy/department-provider/department/page";
	private static final String ADD_URL    = "http://pcitc-zuul/system-proxy/department-provider/department/add";
	private static final String UPDATE_URL = "http://pcitc-zuul/system-proxy/department-provider/department/update";
	private static final String DEL_URL    = "http://pcitc-zuul/system-proxy/department-provider/department/delete/";
	private static final String GET_URL    = "http://pcitc-zuul/system-proxy/department-provider/department/get/";
	
	private static final String LIST_URL   = "http://pcitc-zuul/system-proxy/department-provider/department/list";
	

	@RequestMapping(value = "/department/to-list")
	public String list(HttpServletRequest request, HttpServletResponse response) throws Exception{
		
		List<SysDictionary> list=	EquipmentUtils.getSysDictionaryListByParentCode("ROOT_ZGSHJT_GFGS_ZSYJY", restTemplate, httpHeaders);
		request.setAttribute("list", list);
		
		String unitPathIds = sysUserInfo.getUnitPath();
	//	String type=EquipmentUtils.getYSPersonName(unitPathIds, restTemplate, httpHeaders);
		//request.setAttribute("type", type);
		return "/stp/department/list";
	}

	@RequestMapping(value = "/department/list")
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
	 * 
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/department/add")
	public String add(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String id = CommonUtil.getParameter(request, "id", "");
		request.setAttribute("id", id);

		List<SysDictionary> list=	EquipmentUtils.getSysDictionaryListByParentCode("ROOT_ZGSHJT_GFGS_ZSYJY", restTemplate, httpHeaders);
		request.setAttribute("list", list);
		return "/stp/department/add";
	}

	/**
	 * 保存-更新操作
	 * 
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(method = RequestMethod.POST, value = "/department/save")
	public String saveOrUpdate(HttpServletRequest request, HttpServletResponse response) throws Exception {

		Result resultsDate = new Result();
		String type = CommonUtil.getParameter(request, "type", "");
		String major = CommonUtil.getParameter(request, "major", "");
		String personnel = CommonUtil.getParameter(request, "personnel", "");
		String organization = CommonUtil.getParameter(request, "organization", "");
		String id = CommonUtil.getParameter(request, "id", "");
		String notes = CommonUtil.getParameter(request, "notes", "");
		String honor = CommonUtil.getParameter(request, "honor", "");
		String developHistory = CommonUtil.getParameter(request, "developHistory", "");

		String breif = CommonUtil.getParameter(request, "breif", "");


		Department department = null;
		if (id.equals("")) {
			department = new Department();
			department.setCreateTime(new Date()); 
			department.setCreateUserId(sysUserInfo.getUserId());
			String idv = UUID.randomUUID().toString().replaceAll("-", "");
			department.setId(idv);
		} else {
			ResponseEntity<Department> se = this.restTemplate.exchange(GET_URL + id, HttpMethod.GET, new HttpEntity<Object>(this.httpHeaders), Department.class);
			department = se.getBody();
		}

		department.setBreif(breif); 
		department.setDevelopHistory(developHistory);
		department.setHonor(honor);
		department.setMajor(major);
		department.setNotes(notes);
		department.setOrganization(organization);
		department.setPersonnel(personnel);
		department.setType(type);
		
		// 判断是新增还是修改
		if (id.equals(""))
		{
			ResponseEntity<String> responseEntity = this.restTemplate.exchange(ADD_URL, HttpMethod.POST, new HttpEntity<Department>(department, this.httpHeaders), String.class);
			int statusCode = responseEntity.getStatusCodeValue();
			// 返回结果代码
			if (statusCode == 200) {
				resultsDate = new Result(true, RequestProcessStatusEnum.OK.getStatusDesc());
			} else {
				resultsDate = new Result(false, RequestProcessStatusEnum.SERVER_BUSY.getStatusDesc());
			}

		} else {
			ResponseEntity<Integer> responseEntity = this.restTemplate.exchange(UPDATE_URL, HttpMethod.POST, new HttpEntity<Department>(department, this.httpHeaders), Integer.class);
			int statusCode = responseEntity.getStatusCodeValue();

			// 返回结果代码
			if (statusCode == 200) {
				resultsDate = new Result(true, RequestProcessStatusEnum.OK.getStatusDesc());
			} else {
				resultsDate = new Result(false, RequestProcessStatusEnum.SERVER_BUSY.getStatusDesc());
			}
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
	@RequestMapping(value = "/department/update")
	public String update(HttpServletRequest request, HttpServletResponse response) throws Exception {

		String id = CommonUtil.getParameter(request, "id", "");
		request.setAttribute("id", id);
		ResponseEntity<Department> responseEntity = this.restTemplate.exchange(GET_URL + id, HttpMethod.GET, new HttpEntity<Object>(this.httpHeaders), Department.class);
		int statusCode = responseEntity.getStatusCodeValue();
		logger.info("============远程返回  statusCode " + statusCode);
		Department department = responseEntity.getBody();
		request.setAttribute("department", department);
		List<SysDictionary> list=	EquipmentUtils.getSysDictionaryListByParentCode("ROOT_ZGSHJT_GFGS_ZSYJY", restTemplate, httpHeaders);
		request.setAttribute("list", list);
		return "/stp/department/add";
	}

	/**
	 * 删除
	 * 
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/department/delete/{id}")
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
	@RequestMapping(value = "/department/get/{id}", method = RequestMethod.GET)
	public String get(@PathVariable("id") String id, HttpServletRequest request, HttpServletResponse response) throws Exception {
		ResponseEntity<Department> responseEntity = this.restTemplate.exchange(GET_URL + id, HttpMethod.GET, new HttpEntity<Object>(this.httpHeaders), Department.class);
		int statusCode = responseEntity.getStatusCodeValue();
		logger.info("============远程返回  statusCode " + statusCode);
		Department department = responseEntity.getBody();
		request.setAttribute("department", department);
		return "/stp/department/view";
	}

}
