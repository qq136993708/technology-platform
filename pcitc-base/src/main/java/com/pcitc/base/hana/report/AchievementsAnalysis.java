package com.pcitc.base.hana.report;
/**
 *   领导二级页面，各个研究院的成果情况
 * @author fb
 *
 */
public class AchievementsAnalysis 
{
	private Integer sl;//总数量
	private Integer gyhsl;//工业化数量
	private Integer gysysl;//工业实验数量
	private Integer qtsl;//其他
	
	private String define1;//研究院简称
	
	public Integer getSl() {
		return sl;
	}
	public void setSl(Integer sl) {
		this.sl = sl;
	}
	public Integer getGyhsl() {
		return gyhsl;
	}
	public void setGyhsl(Integer gyhsl) {
		this.gyhsl = gyhsl;
	}
	public Integer getGysysl() {
		return gysysl;
	}
	public void setGysysl(Integer gysysl) {
		this.gysysl = gysysl;
	}
	public String getDefine1() {
		return define1;
	}
	public void setDefine1(String define1) {
		this.define1 = define1;
	}
	public Integer getQtsl() {
		return qtsl;
	}
	public void setQtsl(Integer qtsl) {
		this.qtsl = qtsl;
	}
}
