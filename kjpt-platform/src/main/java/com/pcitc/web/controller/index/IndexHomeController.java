package com.pcitc.web.controller.index;

import com.github.pagehelper.PageInfo;
import com.pcitc.web.common.BaseController;
import io.swagger.annotations.Api;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

/**
 * @author zhf
 * @date 2018年4月20日 上午10:27:55 任务控制器
 */
@Api(value = "首页查询",tags = {"首页查询"})
@RestController
public class IndexHomeController extends BaseController {

	// 首页总数汇总
	private static final String HOME_NUMMARY = "http://kjpt-zuul/stp-proxy/indexHome/homeNummary";

	/**
	 * @param request
	 * @return 首页总数汇总
	 */
	@RequestMapping(value = "/indexHome-model/homeNummary", method = RequestMethod.GET)
	@ResponseBody
	public PageInfo recallTask(HttpServletRequest request) {
		Map<String, Object> condition = new HashMap<>(6);
		ResponseEntity<PageInfo> responseEntity = this.restTemplate.exchange(HOME_NUMMARY, HttpMethod.POST, new HttpEntity<Map>(condition, this.httpHeaders), PageInfo.class);
		return responseEntity.getBody();
	}

}
