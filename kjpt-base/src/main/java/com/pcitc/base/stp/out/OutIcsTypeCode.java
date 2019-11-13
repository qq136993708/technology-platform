package com.pcitc.base.stp.out;

public class OutIcsTypeCode 
{
	private String id;
	private String name;
	private Integer no;
	private Integer delFlag;
	
	
	public OutIcsTypeCode() {
		super();
	}
	public OutIcsTypeCode(String id, String name) {
		super();
		this.id = id;
		this.name = name;
	}
	public OutIcsTypeCode(String id, String name, Integer no, Integer delFlag) {
		super();
		this.id = id;
		this.name = name;
		this.no = no;
		this.delFlag = delFlag;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Integer getNo() {
		return no;
	}
	public void setNo(Integer no) {
		this.no = no;
	}
	public Integer getDelFlag() {
		return delFlag;
	}
	public void setDelFlag(Integer delFlag) {
		this.delFlag = delFlag;
	}
	
	

}
