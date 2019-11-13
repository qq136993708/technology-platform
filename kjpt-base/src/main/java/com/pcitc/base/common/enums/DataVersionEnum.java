package com.pcitc.base.common.enums;

public enum DataVersionEnum 
{
	DATA_VERSION_1_0("1_0","数据版本1.0");
	
	private DataVersionEnum(String version, String desc) {
		this.version = version;
		this.desc = desc;
	}
	/**
	 * 获得当前数据版本
	 * @return
	 */
	public static DataVersionEnum getCurrentDataVersion()
	{
		return DATA_VERSION_1_0;
	}

	private String version;
	private String desc;

	public String getVersion() {
		return version;
	}

	public void setVersion(String version) {
		this.version = version;
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}


	
}
