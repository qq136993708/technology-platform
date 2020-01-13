package com.pcitc.base.common;

import java.io.Serializable;

public class TreeNodeApi implements Serializable{
	    private static final long serialVersionUID = 1L;
	    private String id;
	    private int levelCode;
	    private String code;
	    private String pId;
	    private String name;
	    private String parentCode;
	    private String secretLevel;
	    
	    
		public String getId() {
			return id;
		}
		public void setId(String id) {
			this.id = id;
		}
		
		public int getLevelCode() {
			return levelCode;
		}
		public void setLevelCode(int levelCode) {
			this.levelCode = levelCode;
		}
		public String getCode() {
			return code;
		}
		public void setCode(String code) {
			this.code = code;
		}
		public String getpId() {
			return pId;
		}
		public void setpId(String pId) {
			this.pId = pId;
		}
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		public String getParentCode() {
			return parentCode;
		}
		public void setParentCode(String parentCode) {
			this.parentCode = parentCode;
		}
		public String getSecretLevel() {
			return secretLevel;
		}
		public void setSecretLevel(String secretLevel) {
			this.secretLevel = secretLevel;
		}
	    
	    
	    
}
