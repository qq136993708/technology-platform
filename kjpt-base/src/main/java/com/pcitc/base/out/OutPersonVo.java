package com.pcitc.base.out;

import java.io.Serializable;

public class OutPersonVo implements Serializable{
	
	 private String zjyxlmc;
	 private String zjyxwmc;
	 
	 
	 private String pernr;//人员编号，专家的主键
	 private String zdwbm;//单位编码 
	 private String zdwqc;//单位全称 
	 private String nachn;//姓名
	 private String gesch;//性别
	 private String gbdat;//出生日期
	 private String icnum;//身份证号码
	 
	 
	 
	 
	public String getPernr() {
		return pernr;
	}
	public void setPernr(String pernr) {
		this.pernr = pernr;
	}
	public String getZdwbm() {
		return zdwbm;
	}
	public void setZdwbm(String zdwbm) {
		this.zdwbm = zdwbm;
	}
	public String getZdwqc() {
		return zdwqc;
	}
	public void setZdwqc(String zdwqc) {
		this.zdwqc = zdwqc;
	}
	public String getNachn() {
		return nachn;
	}
	public void setNachn(String nachn) {
		this.nachn = nachn;
	}
	public String getGesch() {
		return gesch;
	}
	public void setGesch(String gesch) {
		this.gesch = gesch;
	}
	public String getGbdat() {
		return gbdat;
	}
	public void setGbdat(String gbdat) {
		this.gbdat = gbdat;
	}
	public String getIcnum() {
		return icnum;
	}
	public void setIcnum(String icnum) {
		this.icnum = icnum;
	}
	public String getZjyxlmc() {
		return zjyxlmc;
	}
	public void setZjyxlmc(String zjyxlmc) {
		this.zjyxlmc = zjyxlmc;
	}
	public String getZjyxwmc() {
		return zjyxwmc;
	}
	public void setZjyxwmc(String zjyxwmc) {
		this.zjyxwmc = zjyxwmc;
	}
	 
	 

}
