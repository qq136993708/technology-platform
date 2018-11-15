package com.pcitc.web.controller.system;

import java.util.List;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.druid.support.json.JSONUtils;
import com.alibaba.fastjson.JSONObject;
import com.pcitc.base.common.TreeNode;
import com.pcitc.base.common.enums.DataOperationStatusEnum;
import com.pcitc.base.system.SysFileConfig;
import com.pcitc.web.common.BaseController;

/**
 * <p>
 * 控制类
 * </p>
 * <p>
 * Table: sys_file_config - InnoDB free: 5120 kB
 * </p>
 *
 * @since 2018-05-12 09:49:59
 */
@RestController
public class SysFileConfigController extends BaseController {

	// @Autowired
	// private RestTemplate restTemplate;
	//
	// @Autowired
	// private HttpHeaders httpHeaders;

	private static final String GET = "http://pcitc-zuul/system-proxy/sysfileconfig-provider/sysfileconfig/get-sysfileconfig/";
	private static final String TREE_DATA = "http://pcitc-zuul/system-proxy/sysfileconfig-provider/sysfileconfig/tree-data";
	private static final String ADD = "http://pcitc-zuul/system-proxy/sysfileconfig-provider/sysfileconfig/add-sysfileconfig";
	private static final String UPDATE = "http://pcitc-zuul/system-proxy/sysfileconfig-provider/sysfileconfig/update-sysfileconfig";
	private static final String DEL = "http://pcitc-zuul/system-proxy/sysfileconfig-provider/sysfileconfig/del-sysfileconfig/";
	private static final String DEL_REAL = "http://pcitc-zuul/system-proxy/sysfileconfig-provider/sysfileconfig/del-sysfileconfig-real/";

	private static final String getFileConfig = "http://pcitc-zuul/system-proxy/sysfileconfig-provider/sysfileconfig/getFileConfig/";

	@RequestMapping(value = "/sysfileconfig/getFileConfig", method = RequestMethod.POST)
	@ResponseBody
	public String getFileConfig(@RequestParam(value = "filedflag") String filedflag) throws Exception {
		System.out.println("filedflag = " + filedflag);

		MultiValueMap<String, Object> form = new LinkedMultiValueMap<String, Object>();
		form.add("filedflag", filedflag);
		HttpEntity<MultiValueMap<String, Object>> entity = new HttpEntity<>(form, httpHeaders);

		// this.httpHeaders.setContentType(MediaType.APPLICATION_FORM_URLENCODED);
		SysFileConfig sysFileConfig = this.restTemplate.exchange(getFileConfig + filedflag, HttpMethod.POST, entity, SysFileConfig.class).getBody();
		System.out.println("---------------------------");
		System.out.println(sysFileConfig);
		return JSONObject.toJSONString(sysFileConfig);
	}

	/**
	 * 查询菜单信息
	 *
	 * @param id
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/sysfileconfig/get/{id}")
	@ResponseBody
	public String getSysFileConfigInfo(@PathVariable String id) throws Exception {
		SysFileConfig sysFileConfig = this.restTemplate.exchange(GET + id, HttpMethod.POST, new HttpEntity<Object>(this.httpHeaders), SysFileConfig.class).getBody();
		return JSONObject.toJSONString(sysFileConfig);
	}

	@RequestMapping(value = "/sysfileconfig/tree-data")
	public Object getSysFileConfigTreeData() throws Exception {
		TreeNode node = this.restTemplate.exchange(TREE_DATA, HttpMethod.POST, new HttpEntity<Object>(this.httpHeaders), TreeNode.class).getBody();
		return node;
	}

	@RequestMapping(value = "/sysfileconfig/tree-datas")
	@ResponseBody
	public String getSysFileConfigTreeDatas() throws Exception {
		List list = this.restTemplate.exchange(TREE_DATA, HttpMethod.POST, new HttpEntity<Object>(this.httpHeaders), List.class).getBody();
		return JSONUtils.toJSONString(list);
	}

	@RequestMapping(value = "/sysfileconfig/add")
	public Object addSysFileConfig(SysFileConfig sysFileConfig) throws Exception {
		HttpEntity<Object> entity = new HttpEntity<Object>(sysFileConfig, this.httpHeaders);
		System.out.println(entity);
		SysFileConfig rs = this.restTemplate.exchange(ADD, HttpMethod.POST, entity, SysFileConfig.class).getBody();
		return JSONObject.toJSONString(rs);
	}

	@RequestMapping(value = "/sysfileconfig/update")
	public Object updateSysFileConfig(SysFileConfig sysFileConfig) throws Exception {
		DataOperationStatusEnum rs = this.restTemplate.exchange(UPDATE, HttpMethod.POST, new HttpEntity<Object>(sysFileConfig, this.httpHeaders), DataOperationStatusEnum.class).getBody();
		return rs;
	}

	@RequestMapping(value = "/sysfileconfig/del")
	public Object delSysFileConfig(String sysFileConfigId) throws Exception {
		DataOperationStatusEnum rs = this.restTemplate.exchange(DEL + sysFileConfigId, HttpMethod.POST, new HttpEntity<Object>(this.httpHeaders), DataOperationStatusEnum.class).getBody();
		return rs;
	}

	@RequestMapping(value = "/sysfileconfig/del-real")
	public Object delSysFileConfigReal(String id) throws Exception {
		DataOperationStatusEnum rs = this.restTemplate.exchange(DEL_REAL + id, HttpMethod.POST, new HttpEntity<Object>(this.httpHeaders), DataOperationStatusEnum.class).getBody();
		return rs;
	}
}