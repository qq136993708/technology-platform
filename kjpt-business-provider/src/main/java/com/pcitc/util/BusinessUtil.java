package com.pcitc.util;

import java.util.List;

import com.alibaba.fastjson.JSONObject;
import com.pcitc.base.system.CustomQueryConditionVo;

public class BusinessUtil {
	
	
	//customQueryConditionStr
	public static String getSqlQueryCondition(String customQueryConditionStr)
	{
		StringBuffer sb=new StringBuffer();
		if(customQueryConditionStr!=null) 
		{
			List<CustomQueryConditionVo> voList = JSONObject.parseArray(customQueryConditionStr, CustomQueryConditionVo.class);
			if(voList!=null)
			{
				for(int i=0;i<voList.size();i++)
				{
					CustomQueryConditionVo vo=voList.get(i);
					String conditionSymbol=vo.getCondition();
					if(conditionSymbol.equals("="))
					{
						sb.append(" AND "+vo.getColumnName()+" = "+vo.getValue());
					}else if(conditionSymbol.equals("like"))
					{
						sb.append(" AND "+vo.getColumnName()+" like '%"+vo.getValue()+"%'");
					}else
					{
						sb.append(" AND "+vo.getColumnName()+"<![CDATA[ "+conditionSymbol+" ]]>"+vo.getValue());
					}
					
				}
			}
		}
		return sb.toString();
	}

}
