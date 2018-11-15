package com.pcitc.web.controller.system;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.StringUtils;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;
import com.pcitc.base.common.InforVo;
import com.pcitc.base.common.LayuiTableData;
import com.pcitc.base.common.LayuiTableParam;
import com.pcitc.base.system.SysNews;
import com.pcitc.base.util.DateUtil;
import com.pcitc.web.common.BaseController;
import com.pcitc.web.common.OperationFilter;

@Controller
@RequestMapping("news")
public class SysNewsController extends BaseController {

	private static final String NEWS_LIST = "http://pcitc-zuul/system-proxy/news-provider/news_list";

	private static final String SAVE_NEWS = "http://pcitc-zuul/system-proxy/news-provider/save_news";

	private static final String DELETE_NEWS = "http://pcitc-zuul/system-proxy/news-provider/delete_news/";

	private static final String GET_NEWS = "http://pcitc-zuul/system-proxy/news-provider/get_news/";

	@RequestMapping(value = "/selectNewsList")
	@ResponseBody
	public Object selectNewsList(@ModelAttribute("param") LayuiTableParam param, HttpServletRequest request) throws Exception {

		HttpEntity<LayuiTableParam> entity = new HttpEntity<LayuiTableParam>(param, this.httpHeaders);
		ResponseEntity<LayuiTableData> responseEntity = this.restTemplate.exchange(NEWS_LIST, HttpMethod.POST, entity, LayuiTableData.class);
		LayuiTableData result = responseEntity.getBody();

		return JSON.toJSONString(result);

	}

	@OperationFilter(modelName = "新闻管理", actionName = "新增或修改新闻")
	@RequestMapping(value = "/saveNews")
	@ResponseBody
	public int saveNews(@RequestBody SysNews news) {
		ResponseEntity<Integer> responseEntity = this.restTemplate.exchange(SAVE_NEWS, HttpMethod.POST, new HttpEntity<SysNews>(news, this.httpHeaders), Integer.class);
		Integer result = responseEntity.getBody();
		return result;
	}

	@OperationFilter(modelName = "新闻管理", actionName = "删除新闻")
	@RequestMapping(value = "/deleteNewsById")
	@ResponseBody
	public int deleteDictionary(HttpServletRequest request) {
		String id = request.getParameter("id");
		ResponseEntity<Integer> responseEntity = restTemplate.exchange(DELETE_NEWS + id, HttpMethod.POST, new HttpEntity<String>(this.httpHeaders), Integer.class);
		int result = responseEntity.getBody();
		return result;
	}

	@RequestMapping(method = RequestMethod.GET, value = "/edit")
	private String pageEdit(String id, Model model) {
		if (StringUtils.isEmpty(id))
			id = "";
		model.addAttribute("id", id);
		return "base/system/news_info";
	}

	/**
	 * 跳转至新闻页面
	 * 
	 * @return
	 */
	@RequestMapping(value = { "/toNewsList" }, method = RequestMethod.GET)
	public String toUserPorperty() {
		return "base/system/news_list";
	}

	@RequestMapping(value = "/getNewsInfo")
	@ResponseBody
	public Object getNewsInfo(HttpServletRequest request) {
		String id = request.getParameter("id");
		ResponseEntity<SysNews> responseEntity = this.restTemplate.exchange(GET_NEWS + id, HttpMethod.POST, new HttpEntity<String>(this.httpHeaders), SysNews.class);
		SysNews news = responseEntity.getBody();
		return news;
	}

	/**
	 * 跳转至新闻查看页面
	 * 
	 * @return
	 */
	@RequestMapping(value = { "/toNewsShow" }, method = RequestMethod.GET)
	public String toNewsShow(String id, Model model) {
		ResponseEntity<SysNews> responseEntity = this.restTemplate.exchange(GET_NEWS + id, HttpMethod.POST, new HttpEntity<String>(this.httpHeaders), SysNews.class);
		SysNews entity = responseEntity.getBody();
		InforVo inforVo = new InforVo();
		inforVo.setContent(entity.getContent());
		inforVo.setDate(DateUtil.format(entity.getUpdatetime(), DateUtil.FMT_DD));
		inforVo.setTitle(entity.getTitle());
		model.addAttribute("info", inforVo);

		Object stype = request.getParameter("stype");
		if (stype == null || "".equals(stype)) {
			return "base/system/info-dialog";
		} else {
			return "base/system/info-detail";
		}

		// return "base/system/news_show";
	}

}
