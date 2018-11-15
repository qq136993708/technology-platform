package com.pcitc.base.hana.report;

import java.io.Serializable;

//项目主数据-科研公司代码,  报表编码: H1AM_KY_ZH_1000_01
public class CompanyCode implements Serializable{
	
	private static final long serialVersionUID = 1L;

    private String g0GSDM;//公司代码
    private String g0GSJC;//公司名称
    private String g0DMJC;//公司表述
	public String getG0GSDM() {
		return g0GSDM;
	}
	public void setG0GSDM(String g0gsdm) {
		g0GSDM = g0gsdm;
	}
	public String getG0GSJC() {
		return g0GSJC;
	}
	public void setG0GSJC(String g0gsjc) {
		g0GSJC = g0gsjc;
	}
	public String getG0DMJC() {
		return g0DMJC;
	}
	public void setG0DMJC(String g0dmjc) {
		g0DMJC = g0dmjc;
	}
    
    
    
    

}
