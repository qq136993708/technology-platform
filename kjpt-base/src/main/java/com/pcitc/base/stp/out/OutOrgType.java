package com.pcitc.base.stp.out;
/**
 * 
 * @author uuy
 *
 */
public class OutOrgType {

	private String id;
	private String name;
	private String pId;
	private Integer level;
	private Integer delFlag;
	private Integer no;
	
	public OutOrgType() {
		super();
	}
	
	public OutOrgType(String id, String name, String pId,Integer no) {
		super();
		this.id = id;
		this.name = name;
		this.pId = pId;
		this.no= no;
	}

	public OutOrgType(String id, String name, String pId, Integer level, Integer delFlag) {
		super();
		this.id = id;
		this.name = name;
		this.pId = pId;
		this.level = level;
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

	public String getpId() {
		return pId;
	}
	public void setpId(String pId) {
		this.pId = pId;
	}
	public Integer getLevel() {
		return level;
	}
	public void setLevel(Integer level) {
		this.level = level;
	}
	public Integer getDelFlag() {
		return delFlag;
	}
	public void setDelFlag(Integer delFlag) {
		this.delFlag = delFlag;
	}

	public Integer getNo() {
		return no;
	}

	public void setNo(Integer no) {
		this.no = no;
	}
	
	
}
