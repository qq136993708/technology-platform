package com.pcitc.web.controller.system;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.pcitc.base.common.LayuiTableData;
import com.pcitc.base.common.LayuiTableParam;
import com.pcitc.base.system.SysQrtzLog;
import com.pcitc.base.system.SysJob;
import com.pcitc.web.common.BaseController;

@Controller
@RequestMapping("sysJob")
public class SysJobController extends BaseController {
	
	private static final String JOB_LIST = "http://kjpt-zuul/system-proxy/job-provider/findSysJob";
	private static final String EXCEP_JOB_LIST = "http://kjpt-zuul/system-proxy/job-provider/findSysExcepJob";
	private static final String JOB_SAVE = "http://kjpt-zuul/system-proxy/job-provider/saveSysJob";
	private static final String JOB_DELETE = "http://kjpt-zuul/system-proxy/job-provider/deleteSysJob/";
	private static final String JOB_QUERY = "http://kjpt-zuul/system-proxy/job-provider/getSysJob/";
	private static final String JOB_PAUSE = "http://kjpt-zuul/system-proxy/job-provider/pauseJob/";
	private static final String JOB_RESUME = "http://kjpt-zuul/system-proxy/job-provider/resumeJob/";
	private static final String JOB_EXECUTE = "http://kjpt-zuul/system-proxy/job-provider/executeJob/";
	private static final String sys_job_excep_list = "http://kjpt-zuul/system-proxy/job-provider/sys_job_excep_list/";
	
	
	private static final String getExcep = "http://kjpt-zuul/system-proxy/job-provider/getExcep/";
	

	/**
	 * 跳转到模块列表页
	 */
	@RequestMapping(value = "/sysJob_list")
	public String toList() {
		return "/base/system/jobList";
	}

	/**
	 * 跳转到定时任务异常列表页
	 */
	@RequestMapping(value = "/sysJobExcep_list")
	public String toExcepList() {
		return "/base/system/jobExcepList";
	}
	
	
	@RequestMapping(value = "/sys_job_excep_list")
	@ResponseBody
	public String sys_job_excep_list(@ModelAttribute("param") LayuiTableParam param, HttpServletRequest request, HttpServletResponse response) {
		LayuiTableData layuiTableData = new LayuiTableData();
		HttpEntity<LayuiTableParam> entity = new HttpEntity<LayuiTableParam>(param, httpHeaders);
		ResponseEntity<LayuiTableData> responseEntity = restTemplate.exchange(sys_job_excep_list, HttpMethod.POST, entity, LayuiTableData.class);
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
	
	
	
	
	@RequestMapping(value = "/getExcep/{id}", method = RequestMethod.GET)
	public String viewget(@PathVariable("id") String id, HttpServletRequest request, HttpServletResponse response) throws Exception {
		ResponseEntity<SysQrtzLog> responseEntity = this.restTemplate.exchange(getExcep + id, HttpMethod.GET, new HttpEntity<Object>(this.httpHeaders), SysQrtzLog.class);
		int statusCode = responseEntity.getStatusCodeValue();
		logger.info("============远程返回  statusCode " + statusCode);
		SysQrtzLog sysCronExceptionLog = responseEntity.getBody();
		request.setAttribute("sysCronExceptionLog", sysCronExceptionLog);
		return "/base/system/jobExcepDetail";
	}

	/**
	 * 加载作业列表数据
	 */
	@RequestMapping(value = "/getJobs")
	@ResponseBody
	public Object getJobs(@ModelAttribute("param")LayuiTableParam param) {
		HttpEntity<LayuiTableParam> entity = new HttpEntity<LayuiTableParam>(param, this.httpHeaders);
		ResponseEntity<LayuiTableData> responseEntity = this.restTemplate.exchange(JOB_LIST, HttpMethod.POST, entity, LayuiTableData.class);
		LayuiTableData retJson = responseEntity.getBody();

		return JSON.toJSON(retJson).toString();
	}

	/**
	 * 加载作业异常列表数据
	 */
	@RequestMapping(value = "/getExcepJobs")
	@ResponseBody
	public Object getExcepJobs(@ModelAttribute("param")LayuiTableParam param) {
		HttpEntity<LayuiTableParam> entity = new HttpEntity<LayuiTableParam>(param, this.httpHeaders);
		ResponseEntity<LayuiTableData> responseEntity = this.restTemplate.exchange(EXCEP_JOB_LIST, HttpMethod.POST, entity, LayuiTableData.class);
		LayuiTableData retJson = responseEntity.getBody();

		return JSON.toJSON(retJson).toString();
	}

	/**
	 * 删除作业
	 */
	@RequestMapping(value = "/deleteJob")
	@ResponseBody
	public Object deleteJob(HttpServletRequest request) throws IOException {
		String dataId = request.getParameter("dataId");
		ResponseEntity<Integer> responseEntity = this.restTemplate.exchange(JOB_DELETE+dataId, HttpMethod.POST, new HttpEntity<String>(this.httpHeaders), Integer.class);
		return responseEntity.getBody();

	}

	/**
	 * 修改作业
	 */
	@RequestMapping(value = "/edit")
	private String edit(String id, Model model) {
		if(StringUtils.isEmpty(id)) id = "";
		model.addAttribute("id", id);
		return "base/system/job_info";
	}

	/**
	 * 根据id查询作业
	 */
	@RequestMapping(value = "/getJobInfo")
	@ResponseBody
	public Object getJobInfo(HttpServletRequest request){
		String id = request.getParameter("id");
		ResponseEntity<SysJob> responseEntity = this.restTemplate.exchange(JOB_QUERY+id, HttpMethod.POST, new HttpEntity<String>(this.httpHeaders), SysJob.class);
		SysJob job = responseEntity.getBody();
		return job;
	}

	/**
	 * 保存作业
	 */
	@RequestMapping(value = "/save")
	@ResponseBody
	public int saveJob(@RequestBody SysJob job){
		job.setDelFlag(0);
		ResponseEntity<Integer> responseEntity = this.restTemplate.exchange(JOB_SAVE, HttpMethod.POST, new HttpEntity<SysJob>(job,this.httpHeaders), Integer.class);
		Integer result = responseEntity.getBody();
		return result;
	}
	
    /**
     * 终止作业
     * @param request
     * @return
     */
    @RequestMapping(value = "/pauseJob")
	@ResponseBody
    public Integer pauseJob(HttpServletRequest request){
        String dataId = request.getParameter("dataId");
        ResponseEntity<Integer> responseEntity = this.restTemplate.exchange(JOB_PAUSE+dataId, HttpMethod.POST, new HttpEntity<String>(this.httpHeaders), Integer.class);
        return responseEntity.getBody();
    }

    /**
     * 继续作业
     * @param request
     * @return
     */
    @RequestMapping(value = "/resumeJob")
	@ResponseBody
    public Integer resumeJob(HttpServletRequest request){
        String dataId = request.getParameter("dataId");
        ResponseEntity<Integer> responseEntity = this.restTemplate.exchange(JOB_RESUME+dataId, HttpMethod.POST, new HttpEntity<String>(this.httpHeaders), Integer.class);
        return responseEntity.getBody();
    }

    /**
     * 执行作业
     * @param request
     * @return
     */
    @RequestMapping(value = "/executeJob")
	@ResponseBody
    public Integer executeJob(HttpServletRequest request){
		String dataId = request.getParameter("dataId");
		ResponseEntity<Integer> responseEntity = this.restTemplate.exchange(JOB_EXECUTE+dataId, HttpMethod.POST, new HttpEntity<String>(this.httpHeaders), Integer.class);
		return responseEntity.getBody();
    }

}
