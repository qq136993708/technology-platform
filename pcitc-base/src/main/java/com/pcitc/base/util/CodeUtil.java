package com.pcitc.base.util;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import com.alibaba.fastjson.JSONObject;

public class CodeUtil {
	//生成编码
	private static final String TABLE_ENCODE_CREATE = "http://pcitc-zuul/system-proxy/SystemCodeTool/generate/create/";
	public static String getCode(String str,RestTemplate restTemplate,HttpHeaders httpHeaders) {
	    ResponseEntity<String> responseEntityCode = restTemplate.exchange(TABLE_ENCODE_CREATE+str, HttpMethod.POST, new HttpEntity<String>(httpHeaders), String.class);
	    String bodyCode = responseEntityCode.getBody();
		JSONObject codeJson = JSONObject.parseObject(bodyCode);
		String code = "";
		if(codeJson != null){
			code = codeJson.get("code")+"";
			return code;
		}else {
			return "";
		}
    }
}
