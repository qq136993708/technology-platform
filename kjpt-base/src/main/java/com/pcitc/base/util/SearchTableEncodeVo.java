package com.pcitc.base.util;

import java.io.Serializable;

/**
 * DataTable参数传递 的扩展
 * 
 * @author masir
 *
 */
@SuppressWarnings("serial")
public class SearchTableEncodeVo extends DataTableInfo implements Serializable {

    /**
     * 编码名称
     */
    private String tableEncodeName;

    /**
     * 项目ID
     */
    private String tableEncodeProjectId;

    /**
     * 项目名称
     */
    private String tableEncodeProjectName;

    /**
     * 项目编码
     */
    private String tableEncodeProjectCode;

    /**
     * 是否有序
     */
    private String tableEncodeOrderly;

    /**
     * 是否需显示
     */
    private String tableEncodeShow;

    /**
     * 是否有效
     */
    private String tableEncodeValid;

    /**
     * 编码值类型
     */
    private String tableEncodeValueType;


    /**
     * 编码级别
     */
    private String tableEncodeLevel;
    
    /**
     * 编码属性
     */
    private String tableEncodeAnnotation;

	public String getTableEncodeName() {
		return tableEncodeName;
	}


	public void setTableEncodeName(String tableEncodeName) {
		this.tableEncodeName = tableEncodeName;
	}


	public String getTableEncodeProjectId() {
		return tableEncodeProjectId;
	}


	public void setTableEncodeProjectId(String tableEncodeProjectId) {
		this.tableEncodeProjectId = tableEncodeProjectId;
	}


	public String getTableEncodeProjectName() {
		return tableEncodeProjectName;
	}


	public void setTableEncodeProjectName(String tableEncodeProjectName) {
		this.tableEncodeProjectName = tableEncodeProjectName;
	}


	public String getTableEncodeProjectCode() {
		return tableEncodeProjectCode;
	}


	public void setTableEncodeProjectCode(String tableEncodeProjectCode) {
		this.tableEncodeProjectCode = tableEncodeProjectCode;
	}


	public String getTableEncodeOrderly() {
		return tableEncodeOrderly;
	}


	public void setTableEncodeOrderly(String tableEncodeOrderly) {
		this.tableEncodeOrderly = tableEncodeOrderly;
	}


	public String getTableEncodeShow() {
		return tableEncodeShow;
	}


	public void setTableEncodeShow(String tableEncodeShow) {
		this.tableEncodeShow = tableEncodeShow;
	}


	public String getTableEncodeValid() {
		return tableEncodeValid;
	}


	public void setTableEncodeValid(String tableEncodeValid) {
		this.tableEncodeValid = tableEncodeValid;
	}


	public String getTableEncodeValueType() {
		return tableEncodeValueType;
	}


	public void setTableEncodeValueType(String tableEncodeValueType) {
		this.tableEncodeValueType = tableEncodeValueType;
	}


	public String getTableEncodeLevel() {
		return tableEncodeLevel;
	}


	public void setTableEncodeLevel(String tableEncodeLevel) {
		this.tableEncodeLevel = tableEncodeLevel;
	}


	public String getTableEncodeAnnotation() {
		return tableEncodeAnnotation;
	}


	public void setTableEncodeAnnotation(String tableEncodeAnnotation) {
		this.tableEncodeAnnotation = tableEncodeAnnotation;
	}
	
}
