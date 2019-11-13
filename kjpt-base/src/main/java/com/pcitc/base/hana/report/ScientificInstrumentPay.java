package com.pcitc.base.hana.report;

import java.io.Serializable;

public class ScientificInstrumentPay implements Serializable{
	
	private static final long serialVersionUID = 1L;
	private  String g0CALY;//年月
	private  String g0GSDM;//公司代码
	private  String g0GSJC;//公司简称
	private  String g0FLAG;//
	private  String g0ZCMS;//资产分类描述
	private  String k0BNZCJE;//本年累计折旧金额
	private  String k0SNZCJE;//上年同期累计折旧金额
	private  String k0TBZCJE;//同比折旧金额
	private  String k0TBZCBL;//同比折旧比例
	private  String k0TQBL;//
	
	
	
	public String getK0TQBL() {
		return k0TQBL;
	}
	public void setK0TQBL(String k0tqbl) {
		k0TQBL = k0tqbl;
	}
	public String getG0CALY() {
		return g0CALY;
	}
	public void setG0CALY(String g0caly) {
		g0CALY = g0caly;
	}
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
	public String getG0FLAG() {
		return g0FLAG;
	}
	public void setG0FLAG(String g0flag) {
		g0FLAG = g0flag;
	}
	public String getG0ZCMS() {
		return g0ZCMS;
	}
	public void setG0ZCMS(String g0zcms) {
		g0ZCMS = g0zcms;
	}
	public String getK0BNZCJE() {
		return k0BNZCJE;
	}
	public void setK0BNZCJE(String k0bnzcje) {
		k0BNZCJE = k0bnzcje;
	}
	public String getK0SNZCJE() {
		return k0SNZCJE;
	}
	public void setK0SNZCJE(String k0snzcje) {
		k0SNZCJE = k0snzcje;
	}
	public String getK0TBZCJE() {
		return k0TBZCJE;
	}
	public void setK0TBZCJE(String k0tbzcje) {
		k0TBZCJE = k0tbzcje;
	}
	public String getK0TBZCBL() {
		return k0TBZCBL;
	}
	public void setK0TBZCBL(String k0tbzcbl) {
		k0TBZCBL = k0tbzcbl;
	}
	
	
	

}
