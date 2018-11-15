package com.pcitc.web.utils;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.RestTemplate;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.pcitc.base.system.SysDictionary;
import com.pcitc.web.common.BaseController;

@Controller
@RequestMapping("/pageCommon")
public class PageCommon extends BaseController {
	
	//字典
	private static final String DICTIONARY_LIST = "http://pcitc-zuul/system-proxy/dictionary-provider/dictionary/";
	
	/***
	 * 
	 * 字典获取
	 * 
	 * ***/
	@RequestMapping(value="/dic/{parentCode}",method = RequestMethod.POST)
    @ResponseBody
    public List<SysDictionary> getByCode(@PathVariable("parentCode") String parentCode,HttpServletRequest request)
	{
		@SuppressWarnings("unchecked")
		List<SysDictionary> dictionarys = this.restTemplate.exchange(DICTIONARY_LIST+parentCode, HttpMethod.POST, new HttpEntity<Object>(this.httpHeaders), List.class).getBody();
       return dictionarys;
    }
	
	/**
	 * 字典回写
	 * @param restTemplate
	 * @param httpHeaders
	 * @param dataObject 列表信息
	 * @param parentCode 字典编码
	 * @param writebackField 回写字段
	 * @return
	 */
    public JSONObject getDictionaryWriteback (RestTemplate restTemplate, HttpHeaders httpHeaders, JSONObject dataObject, String parentCode, String writebackField)
	{
    	JSONArray dataArray = dataObject.getJSONArray("data");
    	@SuppressWarnings("unchecked")
    	List<SysDictionary> dictionaryList = restTemplate.exchange(DICTIONARY_LIST+parentCode, HttpMethod.POST, new HttpEntity<String>(httpHeaders), List.class).getBody();
		for(int i=0; i<dataArray.size(); i++) {
			JSONObject jsonObject = dataArray.getJSONObject(i);
			String wirtebackValue = jsonObject.getString(writebackField);
			for(int j=0; j<dictionaryList.size(); j++) {
				JSONObject dicObject = (JSONObject) JSON.toJSON(dictionaryList.get(j));
				String code = dicObject.getString("code");            //编码
				String numValue = dicObject.getString("numValue");    //数值
				if(wirtebackValue != null && (wirtebackValue.equals(code) || wirtebackValue.equals(numValue))) {
					jsonObject.put(writebackField+"Disp", dicObject.getString("name"));
					break;
				}
			}
		}
       return dataObject;
    }
}
