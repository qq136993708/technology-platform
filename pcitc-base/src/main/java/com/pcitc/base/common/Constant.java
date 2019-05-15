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

    //采购管理状态
    public static String PURCHASE_STATUS_DRAFT = "10";//10未审批  11审批中(已提交)  20审批通过 13审批不通过    30 合同系统对接通过   40到货验收通过
    public static String PURCHASE_STATUS_SUBMIT = "11";//50 合同签收通过  60 安装调试通过  70 合同关闭通过
    public static String PURCHASE_STATUS_PASS = "20";
    public static String PURCHASE_STATUS_REJECT = "13";
    public static String PURCHASE_STATUS_COMPACT = "30";
    public static String PURCHASE_STATUS_ARRIVE_GOODS = "40";
    public static String PURCHASE_STATUS_CONTRACT_ACCEPTANCE = "50";
    public static String PURCHASE_STATUS_INSTALLATION = "60";
    public static String PURCHASE_STATUS_CONTRACT_CLOSE = "70";

    //采购阶段
    public static String  PURCHASE_REQUEST = "1";   // 阶段   1 采购申请  2 合同系统对接  3  到货验收 4合同验收  5 安装调试  6合同关闭
    public static String  PURCHASE_CONTRACT_DOCKING = "2";
    public static String  PURCHASE_ARRIVE_GOODS = "3";
    public static String  PURCHASE_CONTRACT_CHECK= "4";
    public static String  PURCHASE_INSTALL_DEBUG = "5";
    public static String  PURCHASE_CONTRACT_CLOSE =  "6";

    //装备采购阶段
    public static String  EQUIPMENT_PURCHASE_DRAFT  = "0";  //0 未采购 1 申请中(采购单上报) 2 申请通过 3 合同验收通过 4 到货验收通过  5  待采购
    public static String  EQUIPMENT_PURCHASE_SUBMIT = "1";  //6 合同验收通过 7 安装调试通过 8 合同关闭通过
    public static String  EQUIPMENT_PURCHASE_PASS   = "2";
    public static String  EQUIPMENT_PURCHASE_COMPACT   = "3";
    public static String  EQUIPMENT_PURCHASE_ARRIVE_GOODS   = "4";
    public static String  EQUIPMENT_PURCHASE_CONTRACT_ACCEPTANCE = "6";
    public static String  EQUIPMENT_PURCHASE_INSTALLATION = "7";
    public static String  EQUIPMENT_PURCHASE_CONTRACT_CLOSE = "8";
    public static String  EQUIPMENT_PURCHASE_PRE_PURCHASE = "5";

    //采购管理-合同关闭
    public static String  PURCHASE_CONTRACT_STAY_CLOSE = "0"; //0 待关闭 1 已关闭
    public static String  PURCHASE_CONTRACT_CLOSED = "1";
    //装备转资变量
    public static final String EQUME_ZERO="0"; //开启状态
    public static final String EQUME_ONE="1"; //关闭状态

    //转资申请状态变量
    public static final String OK_ZERO="10"; //保存状态
    public static final String OK_NEO="20"; //上报状态
    public static final String OK_THRRE="30"; //通过状态
    
    //转资申请状态变量
    public static final String OK_THREE="30"; //通过状态
    public static final String OK_SREE="40"; //退回状态
    
    //报废管理状态变量
    public static final String SRE_SCARP_APPLY_STATUS="10"; //上报状态
    public static final String OKSRE_SCARP_APPLY_STATUS="20"; //通过状态
    public static final String NOSRE_SCARP_APPLY_STATUS="30"; //不通过状态
    /**
     * 默认文件上传类型
     */
    public static String default_file_type = "png|jpg|jpep|gif|txt|doc|docx|xls|xlsx|ppt|pptx|pdf|wps|rar|zip|gz|rm|rmvb|mp3|wma|mid|html";

    //生成编码
    public static final String TABLE_ENCODE_CREATE = "http://pcitc-zuul/system-proxy/SystemCodeTool/generate/create";

    public static final String UPDATE_FILE_FLAG = "http://pcitc-zuul/system-proxy/sysfile-provider/sysfile/update-file-flag/";

    public static final String DELETE_FILE_FORM = "http://pcitc-zuul/system-proxy/sysfile-provider/sysfile/delete-form-file/";

}
