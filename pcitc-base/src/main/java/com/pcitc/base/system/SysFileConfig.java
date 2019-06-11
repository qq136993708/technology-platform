package com.pcitc.base.system;

import com.pcitc.base.common.DataEntity;


import com.fasterxml.jackson.annotation.JsonInclude;

import java.io.Serializable;

/**
 * <p>实体类</p>
 * <p>Table: sys_file_config - 附件配置表</p>
 *
 * @since 2018-10-22 09:44:01
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class SysFileConfig extends DataEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * id -
     */
    private String id;

    /**
     * menu_id - 菜单ID
     */
    private String menuId;

    /**
     * position - 位置
     */
    private String position;

    /**
     * file_size - 文件大小
     */
    private String fileSize;

    /**
     * file_count - 数量
     */
    private String fileCount;

    /**
     * file_height - 显示高度
     */
    private String fileHeight;

    /**
     * file_width - 显示宽度
     */
    private String fileWidth;

    /**
     * file_key - key
     */
    private String fileKey;

    /**
     * create_time - 创建时间
     */
    private String createTime;

    /**
     * create_user - 创建人
     */
    private String createUser;

    /**
     * state - 状态
     */
    private String state;

    /**
     * file_type - 文件类型
     */
    private String fileType;

    /**
     * file_theme - 主题
     */
    private String fileTheme;

    /**
     * bz - 备注
     */
    private String bz;

    /**
     * img_type - 图片剪裁类型
     */
    private String imgType;

    /**
     * img_desc - 图片裁剪详情
     */
    private String imgDesc;

    /**
     * img_quality - 图片精度
     */
    private String imgQuality;

    /**
     * bak1 -
     */
    private String bak1;

    /**
     * bak2 -
     */
    private String bak2;

    /**
     * bak3 -
     */
    private String bak3;


    public String getId() {
        return this.id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getMenuId() {
        return this.menuId;
    }

    public void setMenuId(String menuId) {
        this.menuId = menuId;
    }

    public String getPosition() {
        return this.position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getFileSize() {
        return this.fileSize;
    }

    public void setFileSize(String fileSize) {
        this.fileSize = fileSize;
    }

    public String getFileCount() {
        return this.fileCount;
    }

    public void setFileCount(String fileCount) {
        this.fileCount = fileCount;
    }

    public String getFileHeight() {
        return this.fileHeight;
    }

    public void setFileHeight(String fileHeight) {
        this.fileHeight = fileHeight;
    }

    public String getFileWidth() {
        return this.fileWidth;
    }

    public void setFileWidth(String fileWidth) {
        this.fileWidth = fileWidth;
    }

    public String getFileKey() {
        return this.fileKey;
    }

    public void setFileKey(String fileKey) {
        this.fileKey = fileKey;
    }

    public String getCreateTime() {
        return this.createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    public String getCreateUser() {
        return this.createUser;
    }

    public void setCreateUser(String createUser) {
        this.createUser = createUser;
    }

    public String getState() {
        return this.state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getFileType() {
        return this.fileType;
    }

    public void setFileType(String fileType) {
        this.fileType = fileType;
    }

    public String getFileTheme() {
        return this.fileTheme;
    }

    public void setFileTheme(String fileTheme) {
        this.fileTheme = fileTheme;
    }

    public String getBz() {
        return this.bz;
    }

    public void setBz(String bz) {
        this.bz = bz;
    }

    public String getImgType() {
        return this.imgType;
    }

    public void setImgType(String imgType) {
        this.imgType = imgType;
    }

    public String getImgDesc() {
        return this.imgDesc;
    }

    public void setImgDesc(String imgDesc) {
        this.imgDesc = imgDesc;
    }

    public String getImgQuality() {
        return this.imgQuality;
    }

    public void setImgQuality(String imgQuality) {
        this.imgQuality = imgQuality;
    }

    public String getBak1() {
        return this.bak1;
    }

    public void setBak1(String bak1) {
        this.bak1 = bak1;
    }

    public String getBak2() {
        return this.bak2;
    }

    public void setBak2(String bak2) {
        this.bak2 = bak2;
    }

    public String getBak3() {
        return this.bak3;
    }

    public void setBak3(String bak3) {
        this.bak3 = bak3;
    }

    @Override
    public boolean equals(Object that) {
        if (this == that) {
            return true;
        }
        if (that == null) {
            return false;
        }
        if (getClass() != that.getClass()) {
            return false;
        }

        SysFileConfig other = (SysFileConfig) that;


        return
                (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId())) &&

                        (this.getMenuId() == null ? other.getMenuId() == null : this.getMenuId().equals(other.getMenuId())) &&

                        (this.getPosition() == null ? other.getPosition() == null : this.getPosition().equals(other.getPosition())) &&

                        (this.getFileSize() == null ? other.getFileSize() == null : this.getFileSize().equals(other.getFileSize())) &&

                        (this.getFileCount() == null ? other.getFileCount() == null : this.getFileCount().equals(other.getFileCount())) &&

                        (this.getFileHeight() == null ? other.getFileHeight() == null : this.getFileHeight().equals(other.getFileHeight())) &&

                        (this.getFileWidth() == null ? other.getFileWidth() == null : this.getFileWidth().equals(other.getFileWidth())) &&

                        (this.getFileKey() == null ? other.getFileKey() == null : this.getFileKey().equals(other.getFileKey())) &&

                        (this.getCreateTime() == null ? other.getCreateTime() == null : this.getCreateTime().equals(other.getCreateTime())) &&

                        (this.getCreateUser() == null ? other.getCreateUser() == null : this.getCreateUser().equals(other.getCreateUser())) &&

                        (this.getState() == null ? other.getState() == null : this.getState().equals(other.getState())) &&

                        (this.getFileType() == null ? other.getFileType() == null : this.getFileType().equals(other.getFileType())) &&

                        (this.getFileTheme() == null ? other.getFileTheme() == null : this.getFileTheme().equals(other.getFileTheme())) &&

                        (this.getBz() == null ? other.getBz() == null : this.getBz().equals(other.getBz())) &&

                        (this.getImgType() == null ? other.getImgType() == null : this.getImgType().equals(other.getImgType())) &&

                        (this.getImgDesc() == null ? other.getImgDesc() == null : this.getImgDesc().equals(other.getImgDesc())) &&

                        (this.getImgQuality() == null ? other.getImgQuality() == null : this.getImgQuality().equals(other.getImgQuality())) &&

                        (this.getBak1() == null ? other.getBak1() == null : this.getBak1().equals(other.getBak1())) &&

                        (this.getBak2() == null ? other.getBak2() == null : this.getBak2().equals(other.getBak2())) &&

                        (this.getBak3() == null ? other.getBak3() == null : this.getBak3().equals(other.getBak3()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getMenuId() == null) ? 0 : getMenuId().hashCode());
        result = prime * result + ((getPosition() == null) ? 0 : getPosition().hashCode());
        result = prime * result + ((getFileSize() == null) ? 0 : getFileSize().hashCode());
        result = prime * result + ((getFileCount() == null) ? 0 : getFileCount().hashCode());
        result = prime * result + ((getFileHeight() == null) ? 0 : getFileHeight().hashCode());
        result = prime * result + ((getFileWidth() == null) ? 0 : getFileWidth().hashCode());
        result = prime * result + ((getFileKey() == null) ? 0 : getFileKey().hashCode());
        result = prime * result + ((getCreateTime() == null) ? 0 : getCreateTime().hashCode());
        result = prime * result + ((getCreateUser() == null) ? 0 : getCreateUser().hashCode());
        result = prime * result + ((getState() == null) ? 0 : getState().hashCode());
        result = prime * result + ((getFileType() == null) ? 0 : getFileType().hashCode());
        result = prime * result + ((getFileTheme() == null) ? 0 : getFileTheme().hashCode());
        result = prime * result + ((getBz() == null) ? 0 : getBz().hashCode());
        result = prime * result + ((getImgType() == null) ? 0 : getImgType().hashCode());
        result = prime * result + ((getImgDesc() == null) ? 0 : getImgDesc().hashCode());
        result = prime * result + ((getImgQuality() == null) ? 0 : getImgQuality().hashCode());
        result = prime * result + ((getBak1() == null) ? 0 : getBak1().hashCode());
        result = prime * result + ((getBak2() == null) ? 0 : getBak2().hashCode());
        result = prime * result + ((getBak3() == null) ? 0 : getBak3().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", menuId=").append(menuId);
        sb.append(", position=").append(position);
        sb.append(", fileSize=").append(fileSize);
        sb.append(", fileCount=").append(fileCount);
        sb.append(", fileHeight=").append(fileHeight);
        sb.append(", fileWidth=").append(fileWidth);
        sb.append(", fileKey=").append(fileKey);
        sb.append(", createTime=").append(createTime);
        sb.append(", createUser=").append(createUser);
        sb.append(", state=").append(state);
        sb.append(", fileType=").append(fileType);
        sb.append(", fileTheme=").append(fileTheme);
        sb.append(", bz=").append(bz);
        sb.append(", imgType=").append(imgType);
        sb.append(", imgDesc=").append(imgDesc);
        sb.append(", imgQuality=").append(imgQuality);
        sb.append(", bak1=").append(bak1);
        sb.append(", bak2=").append(bak2);
        sb.append(", bak3=").append(bak3);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}