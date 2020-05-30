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
					String columnType=vo.getColumnType();
					if(conditionSymbol.contains("=") || conditionSymbol.contains(">") || conditionSymbol.contains("<"))
					{
						if(columnType.equals("string"))
						{
							sb.append(" AND "+vo.getColumnName()+" <![CDATA[ "+conditionSymbol+" ]]> '"+vo.getValue()+"'");
						}else if(columnType.equals("date"))
						{
							sb.append(" AND DATE_FORMAT("+vo.getColumnName()+",'%Y-%m-%d') <![CDATA[ "+conditionSymbol+" ]]> '"+vo.getValue()+"'");
						}else if(columnType.equals("int"))
						{
							sb.append(" AND "+vo.getColumnName()+" <![CDATA[ "+conditionSymbol+" ]]> "+vo.getValue()+"");
						}
					}else if(conditionSymbol.contains("like"))
					{
						if(columnType.equals("string"))
						{
							sb.append(" AND "+vo.getColumnName()+" "+conditionSymbol+" '%"+vo.getValue()+"%'");
						}
					}
					
				}
			}
		}
		System.out.println("----自定义查询条件："+sb.toString());
		return sb.toString();
	}

}
