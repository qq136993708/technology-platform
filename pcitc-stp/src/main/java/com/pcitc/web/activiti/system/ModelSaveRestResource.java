package com.pcitc.web.activiti.system;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.pcitc.base.workflow.WorkflowVo;
import com.pcitc.web.common.BaseController;

/**
 * @author zhf 2018-04-16
 */
@RestController
public class ModelSaveRestResource extends BaseController {
	
	private static final String ACTIVITI_MODEL_SAVE = "http://pcitc-zuul/system-proxy/modeler-provider/model/save";

	@RequestMapping(value = "/service/model/{modelId}/save", method = RequestMethod.POST)
	@ResponseStatus(value = HttpStatus.OK)
	public void saveModel(@PathVariable String modelId, @RequestParam("name") String name, @RequestParam("json_xml") String json_xml, @RequestParam("svg_xml") String svg_xml, @RequestParam("description") String description) {// 对接收参数进行了修改
		WorkflowVo workflowVo = new WorkflowVo();
		workflowVo.setModelId(modelId);
		workflowVo.setModelName(name);
		workflowVo.setModelDescription(description);
		workflowVo.setJsonXml(json_xml);
		workflowVo.setSvgXml(svg_xml);
		ResponseEntity<String> status = this.restTemplate.exchange(ACTIVITI_MODEL_SAVE, HttpMethod.POST, new HttpEntity<WorkflowVo>(workflowVo, this.httpHeaders), String.class);
		System.out.println("saveModel====="+status);
	}

}
