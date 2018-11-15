package com.pcitc.web.activiti.system;

import java.io.InputStream;

import org.apache.commons.io.IOUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author zhf 
 * 2018-04-16
 */
@RestController
public class StencilsetRestResource {
  
  @RequestMapping(value="/service/editor/stencilset", method = RequestMethod.GET, produces = "application/json;charset=utf-8")
  public @ResponseBody String getStencilset() {
    InputStream stencilsetStream = this.getClass().getClassLoader().getResourceAsStream("stencilset.json");
    System.out.println("stencilsetStream=====加载activiti配置");
    try {
      return IOUtils.toString(stencilsetStream, "utf-8");
    } catch (Exception e) {
    }
	return null;
  }
}
