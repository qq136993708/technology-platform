package com.pcitc.web.activiti.system;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.node.ObjectNode;
import com.pcitc.web.common.BaseController;

/**
 * @author zhf 2018-04-16
 */
@RestController
public class ModelEditorJsonRestResource extends BaseController {

	private static final String ACTIVITI_MODEL_DATA = "http://pcitc-zuul/system-proxy/modeler-provider/model/json-data/";

	/**
	 * 获取模型实际的json数据, 编辑用
	 * @param modelId
	 * @return
	 */
	@RequestMapping(value = "/service/model/{modelId}/json", method = RequestMethod.GET, produces = "application/json")
	public ObjectNode getEditorJson(@PathVariable String modelId) {

		System.out.println("=====getEditorJson");
		
		ResponseEntity<ObjectNode> responseEntity = this.restTemplate.exchange(ACTIVITI_MODEL_DATA + modelId, HttpMethod.GET, new HttpEntity<Object>(httpHeaders), ObjectNode.class);
		ObjectNode modelNode = responseEntity.getBody();

		return modelNode;
	}
}
