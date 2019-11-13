package com.pcitc.base.hana.report;

import java.io.Serializable;

public class ScientificBaseBuildFee02 implements Serializable{
	private static final long serialVersionUID = 1L;
	private  String g0GSJC;  //公司简称
	private  String k0BNZCJE;//本年累计折旧金额
	private  String k0SNZCJE;//上年同期累计折旧金额
	private  String k0TBZCJE;//同比折旧金额
	private  String k0TBZCBL;//同比折旧比例
	
	
	public String getG0GSJC() {
		return g0GSJC;
	}
	public void setG0GSJC(String g0gsjc) {
		g0GSJC = g0gsjc;
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
