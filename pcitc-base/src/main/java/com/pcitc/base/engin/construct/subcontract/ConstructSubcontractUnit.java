package com.pcitc.base.engin.construct.subcontract;

public class ConstructSubcontractUnit {
	/**
	 * 业务id
	 */
	private String dataId;

	/**
	 * 分包明细编号
	 */
	private String subdetailId;

	/**
	 * 分包单位编码
	 */
	private String unitCode;

	/**
	 * 分包单位名称
	 */
	private String unitName;

	/**
	 * 拟分包单位资质
	 */
	private String unitQualify;

	public String getDataId() {
		return dataId;
	}

	public void setDataId(String dataId) {
		this.dataId = dataId == null ? null : dataId.trim();
	}

	public String getSubdetailId() {
		return subdetailId;
	}

	public void setSubdetailId(String subdetailId) {
		this.subdetailId = subdetailId == null ? null : subdetailId.trim();
	}

	public String getUnitCode() {
		return unitCode;
	}

	public void setUnitCode(String unitCode) {
		this.unitCode = unitCode == null ? null : unitCode.trim();
	}

	public String getUnitName() {
		return unitName;
	}

	public void setUnitName(String unitName) {
		this.unitName = unitName == null ? null : unitName.trim();
	}

	public String getUnitQualify() {
		return unitQualify;
	}

	public void setUnitQualify(String unitQualify) {
		this.unitQualify = unitQualify == null ? null : unitQualify.trim();
	}
}