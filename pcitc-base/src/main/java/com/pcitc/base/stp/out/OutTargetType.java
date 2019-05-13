package com.pcitc.base.stp.out;
/**
 * 中标分类
 * @author uuy
 *
 */
public class OutTargetType {
	private String id;
	private String name;
	private Integer no;
	private Integer delFlag;
	private String prefix;
	
	
	public OutTargetType() {
		super();
	}
	public OutTargetType(String id, String name, Integer no, Integer delFlag, String prefix) {
		super();
		this.id = id;
		this.name = name;
		this.no = no;
		this.delFlag = delFlag;
		this.prefix = prefix;
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
	public String getPrefix() {
		return prefix;
	}
	public void setPrefix(String prefix) {
		this.prefix = prefix;
	}
	
	
}
