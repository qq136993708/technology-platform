package com.pcitc.base.common;

import java.io.Serializable;
import java.util.Date;

/**
 * 可追踪实体
 *
 */
public class RecordModel implements Serializable {
	private static final long serialVersionUID = 1L;

	//创建人
	private String creator;
	//修改人
	private String updator;
	//创建时间
	private Date createDate;
	//修改时间
	private Date updateDate;
	//删除标识
	private String deleted;

	public String getUpdator() {
		return updator;
	}
	public void setUpdator(String updator) {
		this.updator = updator;
	}
	public Date getCreateDate() {
		return createDate;
	}
	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}
	public Date getUpdateDate() {
		return updateDate;
	}
	public void setUpdateDate(Date updateDate) {
		this.updateDate = updateDate;
	}
	public String getDeleted() {
		return deleted;
	}

	public void setDeleted(String deleted) {
		this.deleted = deleted;
	}

	public String getCreator() {
		return creator;
	}

	public void setCreator(String creator) {
		this.creator = creator;
	}







	@Override
	public String toString() {
		return "RecordModel [creator=" + creator + ", updator=" + updator + ", createDate=" + createDate
				+ ", updateDate=" + updateDate + ", deleted=" + deleted + "]";
	}


}
