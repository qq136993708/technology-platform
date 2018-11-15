package com.pcitc.base.common;

import com.pcitc.base.common.DataEntity;

/**
 * @author:Administrator
 * @date:2018/6/12
 */
public class InforVo extends DataEntity {

    private String title;
    private String date;
    private String content;
    private String from;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }


}
