package com.pcitc.base.system;

import java.io.Serializable;

import com.pcitc.base.util.SearchInfo;

public class SysNews extends SearchInfo implements Serializable {
    private Integer id;

    // 标题
    private String title;

    // 1上架 0 未上架
    private Byte status;

    // 创建时间
    private String createtime;

    // 修改时间
    private String updatetime;

    // 作者(发布者）
    private String author;

    // 内容
    private String content;
    
    private String noticePublisherName;

    private String noticePublisherUnit;

    private String noticePublishtime;
    
    private String noticeContent;
    
    private String noticeTitle;
    
    private String noticeCreater;
    
    private String createtimestr;
    
    public String getCreatetimestr() {
		return createtimestr;
	}

	public void setCreatetimestr(String createtimestr) {
		this.createtimestr = createtimestr;
	}

	private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title == null ? null : title.trim();
    }

    public Byte getStatus() {
        return status;
    }

    public void setStatus(Byte status) {
        this.status = status;
    }

    public String getCreatetime() {
        return createtime;
    }

    public void setCreatetime(String createtime) {
        this.createtime = createtime;
    }

    public String getUpdatetime() {
        return updatetime;
    }

    public void setUpdatetime(String updatetime) {
        this.updatetime = updatetime;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author == null ? null : author.trim();
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content == null ? null : content.trim();
    }
    
    

    public String getNoticePublisherName() {
		return noticePublisherName;
	}

	public void setNoticePublisherName(String noticePublisherName) {
		this.noticePublisherName = noticePublisherName;
	}

	public String getNoticePublisherUnit() {
		return noticePublisherUnit;
	}

	public void setNoticePublisherUnit(String noticePublisherUnit) {
		this.noticePublisherUnit = noticePublisherUnit;
	}

	public String getNoticePublishtime() {
		return noticePublishtime;
	}

	public void setNoticePublishtime(String noticePublishtime) {
		this.noticePublishtime = noticePublishtime;
	}

	public String getNoticeContent() {
		return noticeContent;
	}

	public void setNoticeContent(String noticeContent) {
		this.noticeContent = noticeContent;
	}

	public String getNoticeTitle() {
		return noticeTitle;
	}

	public void setNoticeTitle(String noticeTitle) {
		this.noticeTitle = noticeTitle;
	}

	
	public String getNoticeCreater() {
		return noticeCreater;
	}

	public void setNoticeCreater(String noticeCreater) {
		this.noticeCreater = noticeCreater;
	}

	@Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", title=").append(title);
        sb.append(", status=").append(status);
        sb.append(", createtime=").append(createtime);
        sb.append(", updatetime=").append(updatetime);
        sb.append(", author=").append(author);
        sb.append(", content=").append(content);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}