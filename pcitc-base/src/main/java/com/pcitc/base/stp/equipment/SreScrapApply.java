package com.pcitc.base.stp.equipment;

import java.util.Date;

public class SreScrapApply {
    private String id;

    private String name;

    private String auditStatus;

    private String createUserId;

    private String createUser;

    private Date createDate;

    private String applicationNumber;
    
    private String updateUserId;
    
    private String documentdoc;

	private String updateUser;

    private Date updateTime;

    private String remarks;

    private String status;
    
    private String G0NDURJ;//使用年限
    
    private String G0SCHRW;//资产残值
    
    private String G0LJGZYZJE;//账面净额
    
    private String G0LJDJZJJE;//预付定金
    
    private String G0NCGZYZJE;//年初购置价值
    
    private String G0LJZJJE;//累计折旧
    
    	

    public String getG0NDURJ() {
		return G0NDURJ;
	}



	public void setG0NDURJ(String g0ndurj) {
		G0NDURJ = g0ndurj;
	}



	public String getG0SCHRW() {
		return G0SCHRW;
	}



	public void setG0SCHRW(String g0schrw) {
		G0SCHRW = g0schrw;
	}



	public String getG0LJGZYZJE() {
		return G0LJGZYZJE;
	}



	public void setG0LJGZYZJE(String g0ljgzyzje) {
		G0LJGZYZJE = g0ljgzyzje;
	}



	public String getG0LJDJZJJE() {
		return G0LJDJZJJE;
	}



	public void setG0LJDJZJJE(String g0ljdjzjje) {
		G0LJDJZJJE = g0ljdjzjje;
	}



	public String getG0NCGZYZJE() {
		return G0NCGZYZJE;
	}



	public void setG0NCGZYZJE(String g0ncgzyzje) {
		G0NCGZYZJE = g0ncgzyzje;
	}



	public String getG0LJZJJE() {
		return G0LJZJJE;
	}



	public void setG0LJZJJE(String g0ljzjje) {
		G0LJZJJE = g0ljzjje;
	}



	public String getId() {
        return id;
    }

 

	public void setId(String id) {
        this.id = id;
    }

    public String getDocumentdoc() {
		return documentdoc;
	}



	public void setDocumentdoc(String documentdoc) {
		this.documentdoc = documentdoc;
	}



	public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAuditStatus() {
        return auditStatus;
    }

    public void setAuditStatus(String auditStatus) {
        this.auditStatus = auditStatus;
    }

    public String getCreateUserId() {
        return createUserId;
    }

    public void setCreateUserId(String createUserId) {
        this.createUserId = createUserId;
    }

    public String getCreateUser() {
        return createUser;
    }

    public void setCreateUser(String createUser) {
        this.createUser = createUser;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public String getApplicationNumber() {
        return applicationNumber;
    }

    public void setApplicationNumber(String applicationNumber) {
        this.applicationNumber = applicationNumber;
    }

    public String getUpdateUser() {
        return updateUser;
    }

    public void setUpdateUser(String updateUser) {
        this.updateUser = updateUser;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
    public String getUpdateUserId() {
 		return updateUserId;
 	}

 	public void setUpdateUserId(String updateUserId) {
 		this.updateUserId = updateUserId;
 	}



}