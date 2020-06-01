package com.pcitc.base.system;

import java.io.Serializable;
import java.util.Date;

/**
 * sys_user_tmp
 * @author 
 */
public class SysUserTmp implements Serializable {
    /**
     * 用户ID
     */
    private String userId;

    /**
     * 登录名(账号)
     */
    private String userName;

    /**
     * 保密级别
     */
    private String secretLevel;

    /**
     * 用户显示名称
     */
    private String userDisp;

    /**
     * 统一身份ID
     */
    private String unifyIdentityId;

    /**
     * 用户单位ID
     */
    private String userUnit;

    /**
     * 用户单位名
     */
    private String userUnitName;

    /**
     * 用户岗位（(逗号分开)）
     */
    private String userPost;

    /**
     * 岗位名称
     */
    private String postName;

    /**
     * 用户角色名
     */
    private String userRoleText;

    /**
     * 用户角色ID(逗号分开)
     */
    private String userRole;

    /**
     * 排序
     */
    private Integer userOrder;

    /**
     * 用户邮箱
     */
    private String userMail;

    /**
     * 手机号
     */
    private String userMobile;

    /**
     * 座机号码
     */
    private String userPhone;

    /**
     * 用户签章
     */
    private String userSign;

    /**
     * 用户种类
     */
    private String userKind;

    /**
     * 系统标识
     */
    private String userFlag;

    /**
     * 用户密码
     */
    private String userPassword;

    /**
     * 创建时间
     */
    private String userCreateTime;

    /**
     * 用户级别
     */
    private Integer userLevel;

    /**
     * 删除标记
     */
    private Integer userDelflag;

    /**
     * 用户关系
     */
    private String userRelation;

    /**
     * 扩展信息
     */
    private String userExtend;

    /**
     * 用户注释
     */
    private String userComment;

    /**
     * 是否域用户（1是，0否）
     */
    private Integer isDomain;

    /**
     * 登录失败次数
     */
    private Integer loginErrorNumber;

    /**
     * 登录验证码
     */
    private String loginCheckCode;

    /**
     * 登录IP
     */
    private String userLoginIp;

    /**
     * 登录时间
     */
    private Date userLoginDate;

    /**
     * 头像
     */
    private String userHeadPic;

    private String userUnitPath;

    private static final long serialVersionUID = 1L;

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getSecretLevel() {
        return secretLevel;
    }

    public void setSecretLevel(String secretLevel) {
        this.secretLevel = secretLevel;
    }

    public String getUserDisp() {
        return userDisp;
    }

    public void setUserDisp(String userDisp) {
        this.userDisp = userDisp;
    }

    public String getUnifyIdentityId() {
        return unifyIdentityId;
    }

    public void setUnifyIdentityId(String unifyIdentityId) {
        this.unifyIdentityId = unifyIdentityId;
    }

    public String getUserUnit() {
        return userUnit;
    }

    public void setUserUnit(String userUnit) {
        this.userUnit = userUnit;
    }

    public String getUserUnitName() {
        return userUnitName;
    }

    public void setUserUnitName(String userUnitName) {
        this.userUnitName = userUnitName;
    }

    public String getUserPost() {
        return userPost;
    }

    public void setUserPost(String userPost) {
        this.userPost = userPost;
    }

    public String getPostName() {
        return postName;
    }

    public void setPostName(String postName) {
        this.postName = postName;
    }

    public String getUserRoleText() {
        return userRoleText;
    }

    public void setUserRoleText(String userRoleText) {
        this.userRoleText = userRoleText;
    }

    public String getUserRole() {
        return userRole;
    }

    public void setUserRole(String userRole) {
        this.userRole = userRole;
    }

    public Integer getUserOrder() {
        return userOrder;
    }

    public void setUserOrder(Integer userOrder) {
        this.userOrder = userOrder;
    }

    public String getUserMail() {
        return userMail;
    }

    public void setUserMail(String userMail) {
        this.userMail = userMail;
    }

    public String getUserMobile() {
        return userMobile;
    }

    public void setUserMobile(String userMobile) {
        this.userMobile = userMobile;
    }

    public String getUserPhone() {
        return userPhone;
    }

    public void setUserPhone(String userPhone) {
        this.userPhone = userPhone;
    }

    public String getUserSign() {
        return userSign;
    }

    public void setUserSign(String userSign) {
        this.userSign = userSign;
    }

    public String getUserKind() {
        return userKind;
    }

    public void setUserKind(String userKind) {
        this.userKind = userKind;
    }

    public String getUserFlag() {
        return userFlag;
    }

    public void setUserFlag(String userFlag) {
        this.userFlag = userFlag;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }

    public String getUserCreateTime() {
        return userCreateTime;
    }

    public void setUserCreateTime(String userCreateTime) {
        this.userCreateTime = userCreateTime;
    }

    public Integer getUserLevel() {
        return userLevel;
    }

    public void setUserLevel(Integer userLevel) {
        this.userLevel = userLevel;
    }

    public Integer getUserDelflag() {
        return userDelflag;
    }

    public void setUserDelflag(Integer userDelflag) {
        this.userDelflag = userDelflag;
    }

    public String getUserRelation() {
        return userRelation;
    }

    public void setUserRelation(String userRelation) {
        this.userRelation = userRelation;
    }

    public String getUserExtend() {
        return userExtend;
    }

    public void setUserExtend(String userExtend) {
        this.userExtend = userExtend;
    }

    public String getUserComment() {
        return userComment;
    }

    public void setUserComment(String userComment) {
        this.userComment = userComment;
    }

    public Integer getIsDomain() {
        return isDomain;
    }

    public void setIsDomain(Integer isDomain) {
        this.isDomain = isDomain;
    }

    public Integer getLoginErrorNumber() {
        return loginErrorNumber;
    }

    public void setLoginErrorNumber(Integer loginErrorNumber) {
        this.loginErrorNumber = loginErrorNumber;
    }

    public String getLoginCheckCode() {
        return loginCheckCode;
    }

    public void setLoginCheckCode(String loginCheckCode) {
        this.loginCheckCode = loginCheckCode;
    }

    public String getUserLoginIp() {
        return userLoginIp;
    }

    public void setUserLoginIp(String userLoginIp) {
        this.userLoginIp = userLoginIp;
    }

    public Date getUserLoginDate() {
        return userLoginDate;
    }

    public void setUserLoginDate(Date userLoginDate) {
        this.userLoginDate = userLoginDate;
    }

    public String getUserHeadPic() {
        return userHeadPic;
    }

    public void setUserHeadPic(String userHeadPic) {
        this.userHeadPic = userHeadPic;
    }

    public String getUserUnitPath() {
        return userUnitPath;
    }

    public void setUserUnitPath(String userUnitPath) {
        this.userUnitPath = userUnitPath;
    }
}