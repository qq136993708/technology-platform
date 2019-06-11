package com.pcitc.base.hana.report;

import java.io.Serializable;

public class Award implements Serializable{
	
	
	private static final long serialVersionUID = 1L;
	private  String gnxjcount;//国内先进
	private  String gnlxcount;//国内领先
	private  String gjxjcount;//国际先进
	private  String gjlxcount;//国际领先
	private  String hyxjcount;//行业先进
	private  String hylxcount;//行业领先
	private  String acount;//A.石油勘探
	private  String bcount;//
	private  String ccount;//
	private  String dcount;//
	private  String ecount;//
	private  String fcount;//
	private  String gcount;//
	private  String hcount;//
	private  String icount;//
	private  String jcount;//
	private  String kcount;//
	private  String ms;//
	private  String mscount;//
	private  String cglx;
	
	private  String cglxcount;
	private  String gnxjName;//国内先进
	private  String gnlxName;//国内领先
	private  String gjxjName;//国际先进
	private  String gjlxName;//国际领先
	private  String hyxjName;//行业先进
	private  String hylxName;//行业领先
	
	private  String unitType;
	private  String jdjg;
	private  Integer zsl;
	private  Integer oneYearSl;
	private  Integer twoYearSl;
	private  Integer treeYearSl;
	private  Integer fourYearSl;
	private  Integer fiveYearSl;
	private  Integer sylzSl;
	private  Integer yqkfSl;
	private  Integer hghqSl;
	private  Integer sbaqSl;
	private  Integer yqktSl;
	private  Integer xxzhSl;
	private  Integer ydjSl;
	private  Integer edjSl;
	private  Integer sdjSl;
	
	private  String sbjz;
	
	
	private  Integer zls;
	
	
	private  Integer kjjbjSl;
	private  Integer jsfmjSl;
	private  Integer yjkxSl;
	
	
	
	private  String define2;
	
	
	
	
	public Integer getKjjbjSl() {
		return kjjbjSl;
	}
	public void setKjjbjSl(Integer kjjbjSl) {
		this.kjjbjSl = kjjbjSl;
	}
	public Integer getJsfmjSl() {
		return jsfmjSl;
	}
	public void setJsfmjSl(Integer jsfmjSl) {
		this.jsfmjSl = jsfmjSl;
	}
	public Integer getYjkxSl() {
		return yjkxSl;
	}
	public void setYjkxSl(Integer yjkxSl) {
		this.yjkxSl = yjkxSl;
	}
	public String getDefine2() {
		return define2;
	}
	public void setDefine2(String define2) {
		this.define2 = define2;
	}
	public Integer getZls() {
		return zls;
	}
	public void setZls(Integer zls) {
		this.zls = zls;
	}
	public String getSbjz() {
		return sbjz;
	}
	public void setSbjz(String sbjz) {
		this.sbjz = sbjz;
	}
	public Integer getZsl() {
		return zsl;
	}
	public void setZsl(Integer zsl) {
		this.zsl = zsl;
	}
	public Integer getOneYearSl() {
		return oneYearSl;
	}
	public void setOneYearSl(Integer oneYearSl) {
		this.oneYearSl = oneYearSl;
	}
	public Integer getTwoYearSl() {
		return twoYearSl;
	}
	public void setTwoYearSl(Integer twoYearSl) {
		this.twoYearSl = twoYearSl;
	}
	public Integer getTreeYearSl() {
		return treeYearSl;
	}
	public void setTreeYearSl(Integer treeYearSl) {
		this.treeYearSl = treeYearSl;
	}
	public Integer getFourYearSl() {
		return fourYearSl;
	}
	public void setFourYearSl(Integer fourYearSl) {
		this.fourYearSl = fourYearSl;
	}
	public Integer getFiveYearSl() {
		return fiveYearSl;
	}
	public void setFiveYearSl(Integer fiveYearSl) {
		this.fiveYearSl = fiveYearSl;
	}
	public Integer getSylzSl() {
		return sylzSl;
	}
	public void setSylzSl(Integer sylzSl) {
		this.sylzSl = sylzSl;
	}
	public Integer getYqkfSl() {
		return yqkfSl;
	}
	public void setYqkfSl(Integer yqkfSl) {
		this.yqkfSl = yqkfSl;
	}
	public Integer getHghqSl() {
		return hghqSl;
	}
	public void setHghqSl(Integer hghqSl) {
		this.hghqSl = hghqSl;
	}
	public Integer getSbaqSl() {
		return sbaqSl;
	}
	public void setSbaqSl(Integer sbaqSl) {
		this.sbaqSl = sbaqSl;
	}
	public Integer getYqktSl() {
		return yqktSl;
	}
	public void setYqktSl(Integer yqktSl) {
		this.yqktSl = yqktSl;
	}
	public Integer getXxzhSl() {
		return xxzhSl;
	}
	public void setXxzhSl(Integer xxzhSl) {
		this.xxzhSl = xxzhSl;
	}
	public Integer getYdjSl() {
		return ydjSl;
	}
	public void setYdjSl(Integer ydjSl) {
		this.ydjSl = ydjSl;
	}
	public Integer getEdjSl() {
		return edjSl;
	}
	public void setEdjSl(Integer edjSl) {
		this.edjSl = edjSl;
	}
	public Integer getSdjSl() {
		return sdjSl;
	}
	public void setSdjSl(Integer sdjSl) {
		this.sdjSl = sdjSl;
	}
	public String getJdjg() {
		return jdjg;
	}
	public void setJdjg(String jdjg) {
		this.jdjg = jdjg;
	}
	public String getUnitType() {
		return unitType;
	}
	public void setUnitType(String unitType) {
		this.unitType = unitType;
	}
	public String getGnxjName() {
		return gnxjName;
	}
	public void setGnxjName(String gnxjName) {
		this.gnxjName = gnxjName;
	}
	public String getGnlxName() {
		return gnlxName;
	}
	public void setGnlxName(String gnlxName) {
		this.gnlxName = gnlxName;
	}
	public String getGjxjName() {
		return gjxjName;
	}
	public void setGjxjName(String gjxjName) {
		this.gjxjName = gjxjName;
	}
	public String getGjlxName() {
		return gjlxName;
	}
	public void setGjlxName(String gjlxName) {
		this.gjlxName = gjlxName;
	}
	public String getHyxjName() {
		return hyxjName;
	}
	public void setHyxjName(String hyxjName) {
		this.hyxjName = hyxjName;
	}
	public String getHylxName() {
		return hylxName;
	}
	public void setHylxName(String hylxName) {
		this.hylxName = hylxName;
	}
	public String getCglxcount() {
		return cglxcount;
	}
	public void setCglxcount(String cglxcount) {
		this.cglxcount = cglxcount;
	}
	public String getCglx() {
		return cglx;
	}
	public void setCglx(String cglx) {
		this.cglx = cglx;
	}
	public String getMs() {
		return ms;
	}
	public void setMs(String ms) {
		this.ms = ms;
	}
	public String getMscount() {
		return mscount;
	}
	public void setMscount(String mscount) {
		this.mscount = mscount;
	}
	public String getGnxjcount() {
		return gnxjcount;
	}
	public void setGnxjcount(String gnxjcount) {
		this.gnxjcount = gnxjcount;
	}
	public String getGnlxcount() {
		return gnlxcount;
	}
	public void setGnlxcount(String gnlxcount) {
		this.gnlxcount = gnlxcount;
	}
	public String getGjxjcount() {
		return gjxjcount;
	}
	public void setGjxjcount(String gjxjcount) {
		this.gjxjcount = gjxjcount;
	}
	public String getGjlxcount() {
		return gjlxcount;
	}
	public void setGjlxcount(String gjlxcount) {
		this.gjlxcount = gjlxcount;
	}
	public String getHyxjcount() {
		return hyxjcount;
	}
	public void setHyxjcount(String hyxjcount) {
		this.hyxjcount = hyxjcount;
	}
	public String getHylxcount() {
		return hylxcount;
	}
	public void setHylxcount(String hylxcount) {
		this.hylxcount = hylxcount;
	}
	public String getAcount() {
		return acount;
	}
	public void setAcount(String acount) {
		this.acount = acount;
	}
	public String getBcount() {
		return bcount;
	}
	public void setBcount(String bcount) {
		this.bcount = bcount;
	}
	public String getCcount() {
		return ccount;
	}
	public void setCcount(String ccount) {
		this.ccount = ccount;
	}
	public String getDcount() {
		return dcount;
	}
	public void setDcount(String dcount) {
		this.dcount = dcount;
	}
	public String getEcount() {
		return ecount;
	}
	public void setEcount(String ecount) {
		this.ecount = ecount;
	}
	public String getFcount() {
		return fcount;
	}
	public void setFcount(String fcount) {
		this.fcount = fcount;
	}
	public String getGcount() {
		return gcount;
	}
	public void setGcount(String gcount) {
		this.gcount = gcount;
	}
	public String getHcount() {
		return hcount;
	}
	public void setHcount(String hcount) {
		this.hcount = hcount;
	}
	public String getIcount() {
		return icount;
	}
	public void setIcount(String icount) {
		this.icount = icount;
	}
	public String getJcount() {
		return jcount;
	}
	public void setJcount(String jcount) {
		this.jcount = jcount;
	}
	public String getKcount() {
		return kcount;
	}
	public void setKcount(String kcount) {
		this.kcount = kcount;
	}
	
	
	
	

}
