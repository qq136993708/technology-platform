package com.pcitc.mapper.other;
import java.util.List;
import java.util.Map;

import com.pcitc.base.hana.report.H1AMKYSY100101;
import com.pcitc.base.hana.report.H1AMKYSY100104;
import com.pcitc.base.hana.report.H1AMKYSY100109;
import com.pcitc.base.hana.report.H1AMKYSY100117;
import com.pcitc.base.hana.report.TopicDevelop;
public interface HomeLevel2Mapper 
{
	
	 
	 
	 
	 //科研装备二级页面
	 public List<H1AMKYSY100104>  getJFZCLevel2(Map map);
	 //经费支出
	 public List<H1AMKYSY100104>  getJFZCLevel2Pie(Map map);
	 // 经费下达
	 public List<H1AMKYSY100104>  getJFXDPie(Map map);
	 
	 
	 
	 public List<H1AMKYSY100104>  getJFZCLevel2Circle(Map map);
	 public List<H1AMKYSY100104>  getJFZCLevel2TableList(Map map);
	 public Integer getJFZCLevel2TableCount(Map map);
     //三级表格     
     public List<H1AMKYSY100104> getJFZCLevel_03_table_list(Map map);
	 public Integer getJFZCLevel_03_Table_count(Map map);
	 
	 
	 
     
     
     
}
