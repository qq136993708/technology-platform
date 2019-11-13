package com.pcitc.web.common;

import com.google.common.collect.Lists;

import java.io.Serializable;
import java.util.List;

public class DataTableLayui implements Serializable {

    private String code;
    private String msg;
    private List<?> data = Lists.newArrayList();

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public List<?> getData() {
        return data;
    }

    public void setData(List<?> data) {
        this.data = data;
    }

}
