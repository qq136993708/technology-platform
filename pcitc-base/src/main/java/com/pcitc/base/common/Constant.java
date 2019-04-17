package com.pcitc.base.common;

import java.util.List;

public class Constant {
    public static String HOME_URL = "http://localhost:8080/";
    public static String USER_JSESSIONID_RANGE = "localhost";

    public static String ECHARTS_TYPE_LINE = "line";
    public static String ECHARTS_TYPE_BAR = "bar";
    public static String ECHARTS_TYPE_PIE = "pie";


    public static String AUDIT_STATUS_DRAFT = "0";//0未审批(草稿), 1审批中(已提交)  2审批通过   3审批不通过
    public static String AUDIT_STATUS_SUBMIT = "1";
    public static String AUDIT_STATUS_PASS = "2";
    public static String AUDIT_STATUS_REJECT = "3";

    //采购管理
    public static String  PURCHASE_STATUS_DRAFT = "0";// 10 未提交 20 已提交
    public static String PURCHASE_STATUS_SUBMIT = "1";

    //采购阶段
    public static String  PURCHASE_REQUEST = "1";   // 阶段   1 采购申请  2 合同系统对接  3  到货验收 4合同验收
    public static String  PURCHASE_CONTRACT_DOCKING = "2";
    public static String  PURCHASE_ARRIVE_GOODS = "3";
    public static String  PURCHASE_CONTRACT_CHECK= "4";
    /**
     * 默认文件上传类型
     */
    public static String default_file_type = "png|jpg|jpep|gif|txt|doc|docx|xls|xlsx|ppt|pptx|pdf|wps|rar|zip|gz|rm|rmvb|mp3|wma|mid|html";

    //生成编码
    public static final String TABLE_ENCODE_CREATE = "http://pcitc-zuul/system-proxy/SystemCodeTool/generate/create";

    public static final String UPDATE_FILE_FLAG = "http://pcitc-zuul/system-proxy/sysfile-provider/sysfile/update-file-flag/";

    public static final String DELETE_FILE_FORM = "http://pcitc-zuul/system-proxy/sysfile-provider/sysfile/delete-form-file/";

}
