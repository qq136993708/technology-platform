package com.pcitc.service.util;

import com.pcitc.base.common.LayuiTableParam;

public class HanaProvideUtil {
	
	
	
	public static String getTableParam(LayuiTableParam param,String paramName,String defaultstr)
		{
			String resault="";
			Object object=param.getParam().get(paramName);
			if(object!=null)
			{
				resault=(String)object;
			}
			return resault;
		}
	 

}
