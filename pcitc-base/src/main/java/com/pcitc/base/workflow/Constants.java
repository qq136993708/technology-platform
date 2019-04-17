package com.pcitc.base.workflow;

/**
 * @author zhf
 * 通用审批相关变量
 */
public class Constants {
    //通用审批单变量名称
    public static final String APPROVE_RESULT = "approved";//审批结果
    public static final String APPROVE_SUGGESTION = "suggestion";//审批意见

    //任务状态（流程节点）
    public static final String STATE_DONE = "0";//已执行
    public static final String STATE_DOING = "1";//正在执行（下一步执行节点）
    public static final String STATE_TODO = "2";//尚未执行节点

    //流程实例状态
    public static final String STATE_INSTANCE_DOING = "0";//办理中
    public static final String STATE_INSTANCE_DONE = "1";//办结

    //候选人审批人类型
    public static final String IDENTITY_ASSIGNEE = "assignee";
    public static final String IDENTITY_GROUP = "group";
    public static final String IDENTITY_USER = "user";

    //流程是否可撤回
    public static final String WITHDRAW_YES = "1";
    public static final String WITHDRAW_NO = "0";

    public static final String APPROVED_PASSED="1";//通过
    public static final String APPROVED_REJECT="0";//拒绝
    public static final String[] APPROVED_PASSED_TEXT={"同意","通过","批准","提交"};
    public static final String[] APPROVED_REJECT_TEXT={"拒绝","不同意","不批准","终止"};

    //固定流程变量
    //业务表单url变量
    public static final String VAR_FORM_URL="local_form_url";
    //用户名
    public static final String VAR_APPLYUSER_NAME="applyUserName";
    //启动用户Id
    public static final String VAR_APPLYUSER_ID="applyUserId";
    //业务Id
    public static final String VAR_BUSINESS_KEY="businessKey";


    //业务流程状态
    public static final int FLOW_STATE_SAVE=0; //临时保存
    public static final int FLOW_STATE_DOING=1;//审批中
    public static final int FLOW_STATE_DONE=2;//审批通过
    public static final int FLOW_STATE_CLOSE=3;//强制结束
    
    //任务关闭变量
    public static final String TASK_CLOUSE="0"; //0关闭状态
    public static final String OK_CLOUSE="1"; //1已关闭状态
    
    
    public static final String START_WORKFLOW_URL = "http://pcitc-zuul/system-proxy/workflow-provider/workflow/start";
    
    public static final String AUDIT_FLAG_URL = "http://pcitc-zuul/system-proxy/task-provider/task/process/audit/flag";




}
