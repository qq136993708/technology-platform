package com.pcitc.web.activiti.system;

import java.io.UnsupportedEncodingException;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.pcitc.web.common.BaseController;

@Controller
public class ActivitiModelerController extends BaseController {
	
	private static final String ACTIVITI_MODELER_NEW = "http://pcitc-zuul/system-proxy/modeler-provider/model/create";
	
    /**
     * 新建模型
     * @return
     * @throws UnsupportedEncodingException
     */
    @RequestMapping("/activiti/create")
	public ModelAndView newModel() throws UnsupportedEncodingException {
    	System.out.println("=====newModel");
        ResponseEntity<String> responseEntity = this.restTemplate.exchange(ACTIVITI_MODELER_NEW, HttpMethod.POST, new HttpEntity<Object>(httpHeaders), String.class);
		String modelId = responseEntity.getBody();
        return new ModelAndView("redirect:/modeler.html?modelId=" + modelId);
    }
}
