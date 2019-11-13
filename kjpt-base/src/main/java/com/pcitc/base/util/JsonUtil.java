package com.pcitc.base.util;

import java.util.HashMap;
import java.util.Map;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

/**
 * 
 * @author fb
 *
 */
public class JsonUtil {
	public static String parseMapToJson(Map<String, Object> paraMap) {
		JSONArray paras = new JSONArray();

		for (String key : paraMap.keySet()) {
			JSONObject para = new JSONObject();
			para.put("name", key);
			para.put("value", paraMap.get(key));
			paras.add(para);
		}
		String rtnStr = paras.toString();
		rtnStr = rtnStr.replaceAll("\'", "%27");
		return rtnStr;
	}

	@SuppressWarnings("unchecked")
	public static Map<String, Object> parseJsonToMap(String jsonStr) {
		JSONArray json = JSONArray.parseArray(jsonStr);
		Map<String, Object> map = new HashMap<String, Object>();
		for (java.util.Iterator<Object> iter = json.iterator(); iter.hasNext();) {
			JSONObject obj = (JSONObject) iter.next();
			String key = obj.getString("name");
			Object val = obj.get("value");
			map.put(key, val);
		}
		return map;
	}
}
