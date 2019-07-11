package com.pcitc.web.controller.system;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.StringUtils;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;
import com.pcitc.base.common.LayuiTableData;
import com.pcitc.base.common.LayuiTableParam;
import com.pcitc.base.system.SysJob;
import com.pcitc.web.common.BaseController;

@Controller
@RequestMapping("sysJob")
public class SysJobController extends BaseController {
	
	private static final String JOB_LIST = "http://pcitc-zuul/system-proxy/job-provider/findSysJob";
	private static final String JOB_SAVE = "http://pcitc-zuul/system-proxy/job-provider/saveSysJob";
	private static final String JOB_DELETE = "http://pcitc-zuul/system-proxy/job-provider/deleteSysJob/";
	private static final String JOB_QUERY = "http://pcitc-zuul/system-proxy/job-provider/getSysJob/";
	private static final String JOB_PAUSE = "http://pcitc-zuul/system-proxy/job-provider/pauseJob/";
	private static final String JOB_RESUME = "http://pcitc-zuul/system-proxy/job-provider/resumeJob/";
	private static final String JOB_EXECUTE = "http://pcitc-zuul/system-proxy/job-provider/executeJob/";

	/**
	 * 跳转到模块列表页
	 */
	@RequestMapping(value = "/sysJob_list")
	public String toList() {
		return "/base/system/jobList";
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
