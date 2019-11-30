package com.pcitc.base.common;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class FormSelectNode implements Serializable {
	
	private String id;

    private String parentId;

    private String levelCode;
    
    private String code;
    private String pId;
    
    private String name;
    private String value;
    private String nodePath;
    
    private List<FormSelectNode> children = new ArrayList<FormSelectNode>();
    
    
	public String getNodePath() {
		return nodePath;
	}

	public void setNodePath(String nodePath) {
		this.nodePath = nodePath;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public String getpId() {
		return pId;
	}

	public void setpId(String pId) {
		this.pId = pId;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getParentId() {
		return parentId;
	}

	public void setParentId(String parentId) {
		this.parentId = parentId;
	}

	

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public List<FormSelectNode> getChildren() {
		return children;
	}

	public void setChildren(List<FormSelectNode> children) {
		this.children = children;
	}

	public String getLevelCode() {
		return levelCode;
	}

	public void setLevelCode(String levelCode) {
		this.levelCode = levelCode;
	}

	
    

}
