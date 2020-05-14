package com.pcitc.base.qims;

import com.pcitc.base.common.RecordModel;

import java.io.Serializable;
import java.util.Date;

public class QualityStatistics extends RecordModel implements Serializable {

    private String id;
    private String key;
    private String content;
    private Date date;
    private String dateStr;
    
    private Date createTime;
    
    

    public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getDateStr() {
        return dateStr;
    }

    public void setDateStr(String dateStr) {
        this.dateStr = dateStr;
    }
}
