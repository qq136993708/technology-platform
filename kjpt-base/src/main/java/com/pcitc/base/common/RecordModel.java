package com.pcitc.base.common;

import java.io.Serializable;
import java.util.Date;

/**
 * 可追踪实体
 *
 */
public class RecordModel extends BaseModel implements Serializable {
	private static final long serialVersionUID = 1L;

	//创建人
	private String createor;
	//修改人
	private String updator;
	//创建时间
	private Date createDate;
	//修改时间
	private Date updateDate;
	//删除标识
	private boolean deleted;
	
	public String getCreateor() {
		return createor;
	}
	public void setCreateor(String createor) {
		this.createor = createor;
	}
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
	public boolean isDeleted() {
		return deleted;
	}
	public void setDeleted(boolean deleted) {
		this.deleted = deleted;
	}
	
	
	@Override
	public String toString() {
		return "RecordModel [createor=" + createor + ", updator=" + updator + ", createDate=" + createDate
				+ ", updateDate=" + updateDate + ", deleted=" + deleted + "]";
	}
	
	
}
