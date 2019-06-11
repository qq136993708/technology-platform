package com.pcitc.service.system;

import com.alibaba.fastjson.JSONObject;
import com.pcitc.base.system.SysRestfulapi;

public interface SysRestfulapiService {

	JSONObject findWarehousing(String jsonStr);

	Integer insertSysRestfulapi(SysRestfulapi srf);

	Integer updateSysRestfulapi(SysRestfulapi srf);

	SysRestfulapi getSysRestfulapiById(String restfulapiId);

	Integer deleteRestfulapiById(String restfulapiId);

}
