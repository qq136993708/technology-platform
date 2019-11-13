package com.pcitc.base.system;

import java.io.Serializable;

import com.pcitc.base.util.SearchInfo;

public class SysButton extends SearchInfo implements Serializable {
    private String id;

    // 按钮名称
    private String name;

    // 按钮英文名
    private String englishName;

    // 按钮编码
    private String code;

    // 作用域
    private String area;

    // 按钮描述
    private String remark;

    // 状态 0 禁用 1启用
    private Integer status;

    // 菜单id
    private String functionId;

    private static final long serialVersionUID = 1L;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getEnglishName() {
        return englishName;
    }

    public void setEnglishName(String englishName) {
        this.englishName = englishName == null ? null : englishName.trim();
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code == null ? null : code.trim();
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area == null ? null : area.trim();
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getFunctionId() {
        return functionId;
    }

    public void setFunctionId(String functionId) {
        this.functionId = functionId == null ? null : functionId.trim();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", name=").append(name);
        sb.append(", englishName=").append(englishName);
        sb.append(", code=").append(code);
        sb.append(", area=").append(area);
        sb.append(", remark=").append(remark);
        sb.append(", status=").append(status);
        sb.append(", functionId=").append(functionId);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}