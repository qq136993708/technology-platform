package com.pcitc.base.system;

import com.pcitc.base.util.DataTableInfoVo;
import com.pcitc.base.util.SearchInfo;

public class SysModuleVo extends SearchInfo {

	private String id;

	private String moduleName;

	private String moduleCode;

	private String moduleWidth;

	private String moduleHeight;

	private String moduleColor;

	private String moduleImage;

	private String moduleSort;

	private Integer isVariable;

	private DataTableInfoVo dataTableInfoVo;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getModuleName() {
		return moduleName;
	}

	public void setModuleName(String moduleName) {
		this.moduleName = moduleName;
	}

	public String getModuleCode() {
		return moduleCode;
	}

	public void setModuleCode(String moduleCode) {
		this.moduleCode = moduleCode;
	}

	public String getModuleWidth() {
		return moduleWidth;
	}

	public void setModuleWidth(String moduleWidth) {
		this.moduleWidth = moduleWidth;
	}

	public String getModuleHeight() {
		return moduleHeight;
	}

	public void setModuleHeight(String moduleHeight) {
		this.moduleHeight = moduleHeight;
	}

	public String getModuleColor() {
		return moduleColor;
	}

	public void setModuleColor(String moduleColor) {
		this.moduleColor = moduleColor;
	}

	public String getModuleImage() {
		return moduleImage;
	}

	public void setModuleImage(String moduleImage) {
		this.moduleImage = moduleImage;
	}

	public String getModuleSort() {
		return moduleSort;
	}

	public void setModuleSort(String moduleSort) {
		this.moduleSort = moduleSort;
	}

	public Integer getIsVariable() {
		return isVariable;
	}

	public void setIsVariable(Integer isVariable) {
		this.isVariable = isVariable;
	}

	public DataTableInfoVo getDataTableInfoVo() {
		return dataTableInfoVo;
	}

	public void setDataTableInfoVo(DataTableInfoVo dataTableInfoVo) {
		this.dataTableInfoVo = dataTableInfoVo;
	}

}