package com.pcitc.base.expert;

import java.io.Serializable;
import java.util.Date;

/**
 * zjk_book_sync
 * @author 
 */
public class ZjkBookSync implements Serializable {
    private String id;

    private String expertNum;

    private String outSysId;

    private Date createTime;

    /**
     * 论文、著作名称
     */
    private String bookName;

    /**
     * 著作方式
     */
    private String bookType;

    /**
     * 发表时间
     */
    private Date bookDate;

    /**
     * 备注
     */
    private String notes;

    /**
     * 出版国家
     */
    private String bookCountry;

    /**
     * 刊物或出版社名称
     */
    private String publicOrg;

    private static final long serialVersionUID = 1L;
    
    private String bookDateStr;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getExpertNum() {
		return expertNum;
	}

	public void setExpertNum(String expertNum) {
		this.expertNum = expertNum;
	}

	public String getOutSysId() {
		return outSysId;
	}

	public void setOutSysId(String outSysId) {
		this.outSysId = outSysId;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public String getBookName() {
		return bookName;
	}

	public void setBookName(String bookName) {
		this.bookName = bookName;
	}

	public String getBookType() {
		return bookType;
	}

	public void setBookType(String bookType) {
		this.bookType = bookType;
	}

	public Date getBookDate() {
		return bookDate;
	}

	public void setBookDate(Date bookDate) {
		this.bookDate = bookDate;
	}

	public String getNotes() {
		return notes;
	}

	public void setNotes(String notes) {
		this.notes = notes;
	}

	public String getBookCountry() {
		return bookCountry;
	}

	public void setBookCountry(String bookCountry) {
		this.bookCountry = bookCountry;
	}

	public String getPublicOrg() {
		return publicOrg;
	}

	public void setPublicOrg(String publicOrg) {
		this.publicOrg = publicOrg;
	}

	public String getBookDateStr() {
		return bookDateStr;
	}

	public void setBookDateStr(String bookDateStr) {
		this.bookDateStr = bookDateStr;
	}
    
    
    
    
    
    
 
}