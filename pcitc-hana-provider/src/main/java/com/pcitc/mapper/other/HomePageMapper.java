package com.pcitc.mapper.other;
import java.util.List;
import java.util.Map;

import com.pcitc.base.hana.report.H1AMKYSY100101;
import com.pcitc.base.hana.report.H1AMKYSY100104;
import com.pcitc.base.hana.report.H1AMKYSY100109;
import com.pcitc.base.hana.report.H1AMKYSY100117;
import com.pcitc.base.hana.report.TopicDevelop;
public interface HomePageMapper 
{
	
	 // 科研项目
     public List<H1AMKYSY100101> getKyxm (Map map);
     //科研装备
     public List<H1AMKYSY100104> getkyzb (Map map);
     //年度预算 经费支出
     public List<H1AMKYSY100104> getndys_xfzc(Map map);
     
     public List<H1AMKYSY100109> getH1AMKYSY100109Report(Map map);
     
     public List<H1AMKYSY100109> getH1AMKYSY100109Count(Map map);
     
     public List<H1AMKYSY100109> getH1AMKYSY100109Count02(Map map);
     
     public  List<H1AMKYSY100117> getDzzk(Map map);
     
     public  List<H1AMKYSY100117> getDzzk_bar(Map map);
     
     
     
     
     //二级页面
     public List<H1AMKYSY100109> getNdkyxmzl(Map map);
     
     public List<H1AMKYSY100109> getNdkyxmzl02(Map map);
     
     public List<H1AMKYSY100109> getNdkyxmzBar(Map map);
     
     public List<H1AMKYSY100109> getNdkyxmzCircle(Map map);
     
     public List<H1AMKYSY100109> getlist(Map map);
     
	 public Integer getCount(Map map);
	 
	 public List<H1AMKYSY100109> getListLevel2(Map map);
	 
	 public Integer getCountLevel2(Map map);
	 
	 
	 
	 //科研装备二级页面
	 public List<H1AMKYSY100109>  getLevel2KYZB01(Map map);
	 public List<H1AMKYSY100109>  getLevel2KYZB02Bar(Map map);
	 public List<H1AMKYSY100109>  getLevel2KYZB03Circle(Map map);
	 public List<H1AMKYSY100109>  getLevel2KYZB04List(Map map);
	 public Integer getLevel2KYZB04Count(Map map);
     
     
     public List<H1AMKYSY100104> get_KYZB_table_list(Map map);
	 public Integer get_KYZB_table_count(Map map);
	 
	 
	   public  List<H1AMKYSY100117> getZhuanziTableList(Map map);
	   public Integer getZhuanziTableCount(Map map);
     
     
}
