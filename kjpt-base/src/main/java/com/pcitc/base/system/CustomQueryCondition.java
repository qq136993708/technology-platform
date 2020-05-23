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
    private String columnCode;

    /**
     * 说明
     */
    private String notes;
    
    
    private String attributeName;
    
    

    public String getAttributeName() {
		return attributeName;
	}

	public void setAttributeName(String attributeName) {
		this.attributeName = attributeName;
	}

	private static final long serialVersionUID = 1L;

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

    public String getColumnCode() {
        return columnCode;
    }

    public void setColumnCode(String columnCode) {
        this.columnCode = columnCode;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }
}