package com.pcitc.base.system;

import java.io.Serializable;

/**
 * t_custom_query_condition
 * @author 
 */
public class CustomQueryCondition implements Serializable {
    private String id;

    /**
     * 表名
     */
    private String taleName;

    /**
     * 列名
     */
    private String columnName;

    /**
     * 列类型
     */
    private String columnType;

    /**
     * 如果下拉，字典表CODE
     */
    private String optionCode;

    /**
     * 说明
     */
    private String notes;
    
    
    private String attributeName;
    private String optionType;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getTaleName() {
		return taleName;
	}
	public void setTaleName(String taleName) {
		this.taleName = taleName;
	}
	public String getColumnName() {
		return columnName;
	}
	public void setColumnName(String columnName) {
		this.columnName = columnName;
	}
	public String getColumnType() {
		return columnType;
	}
	public void setColumnType(String columnType) {
		this.columnType = columnType;
	}
	public String getOptionCode() {
		return optionCode;
	}
	public void setOptionCode(String optionCode) {
		this.optionCode = optionCode;
	}
	public String getNotes() {
		return notes;
	}
	public void setNotes(String notes) {
		this.notes = notes;
	}
	public String getAttributeName() {
		return attributeName;
	}
	public void setAttributeName(String attributeName) {
		this.attributeName = attributeName;
	}
	public String getOptionType() {
		return optionType;
	}
	public void setOptionType(String optionType) {
		this.optionType = optionType;
	}
    
    

}