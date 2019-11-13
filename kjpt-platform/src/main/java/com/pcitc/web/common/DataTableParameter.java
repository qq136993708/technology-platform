package com.pcitc.web.common;

import java.io.Serializable;
import java.util.List;

import com.google.common.collect.Lists;

public class DataTableParameter implements Serializable {

    private static final long serialVersionUID = 1L;

    /**response*/
    //数据状态的字段名称，默认：code
    private String status;

    //成功的状态码，默认：0
    private String statusCode;
    //状态信息的字段名称，默认：msg
    private String msg;

    //数据总数的字段名称
    private Long iTotalRecords;

    private Long iTotalDisplayRecords;
    //数据列表的字段名称，默认：data
    private List<?> aaData = Lists.newArrayList();
    /**request*/
    //页码的参数名称
    private String page;
    //每页数据量的参数名
    private String limit;


    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(String statusCode) {
        this.statusCode = statusCode;
    }

    public String getPage() {
        return page;
    }

    public void setPage(String page) {
        this.page = page;
    }

    public String getLimit() {
        return limit;
    }

    public void setLimit(String limit) {
        this.limit = limit;
    }

    /**
     * @return the iTotalRecords
     */
    public Long getiTotalRecords() {
        return iTotalRecords;
    }

    /**
     * @param iTotalRecords the iTotalRecords to set
     */
    public void setiTotalRecords(Long iTotalRecords) {
        this.iTotalRecords = iTotalRecords;
    }

    /**
     * @return the iTotalDisplayRecords
     */
    public Long getiTotalDisplayRecords() {
        return iTotalDisplayRecords;
    }

    /**
     * @param iTotalDisplayRecords the iTotalDisplayRecords to set
     */
    public void setiTotalDisplayRecords(Long iTotalDisplayRecords) {
        this.iTotalDisplayRecords = iTotalDisplayRecords;
    }

    /**
     * @return the aaData
     */
    public List<?> getAaData() {
        return aaData;
    }

    /**
     * @param aaData the aaData to set
     */
    public void setAaData(List<?> aaData) {
        this.aaData = aaData;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }


}
