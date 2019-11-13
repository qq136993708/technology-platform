package com.pcitc.base.system;

import com.pcitc.base.common.DataEntity;

import com.fasterxml.jackson.annotation.JsonInclude;

import java.io.Serializable;

/**
 * <p>实体类</p>
 * <p>Table: sys_address - 省市县地址表</p>
 *
 * @since 2019-02-14 11:01:09
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class SysAddress extends DataEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * data_id -
     */

    private Integer dataId;

    /**
     * cityName -
     */

    private String cityname;

    /**
     * parentId -
     */

    private Integer parentid;

    /**
     * shortName -
     */
    private String shortname;

    /**
     * depth -
     */
    private Integer depth;

    /**
     * cityCode -
     */
    private String citycode;

    /**
     * zipCode -
     */
    private String zipcode;

    /**
     * mergerName -
     */
    private String mergername;

    /**
     * longitude -
     */
    private String longitude;

    /**
     * latitude -
     */
    private String latitude;

    /**
     * pinyin -
     */
    private String pinyin;

    /**
     * isUse -
     */
    private Integer isuse;

    public Integer getDataId() {
        return this.dataId;
    }

    public void setDataId(Integer dataId) {
        this.dataId = dataId;
    }

    public String getCityname() {
        return this.cityname;
    }

    public void setCityname(String cityname) {
        this.cityname = cityname;
    }

    public Integer getParentid() {
        return this.parentid;
    }

    public void setParentid(Integer parentid) {
        this.parentid = parentid;
    }

    public String getShortname() {
        return this.shortname;
    }

    public void setShortname(String shortname) {
        this.shortname = shortname;
    }

    public Integer getDepth() {
        return this.depth;
    }

    public void setDepth(Integer depth) {
        this.depth = depth;
    }

    public String getCitycode() {
        return this.citycode;
    }

    public void setCitycode(String citycode) {
        this.citycode = citycode;
    }

    public String getZipcode() {
        return this.zipcode;
    }

    public void setZipcode(String zipcode) {
        this.zipcode = zipcode;
    }

    public String getMergername() {
        return this.mergername;
    }

    public void setMergername(String mergername) {
        this.mergername = mergername;
    }

    public String getLongitude() {
        return this.longitude;
    }

    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }

    public String getLatitude() {
        return this.latitude;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }

    public String getPinyin() {
        return this.pinyin;
    }

    public void setPinyin(String pinyin) {
        this.pinyin = pinyin;
    }

    public Integer getIsuse() {
        return this.isuse;
    }

    public void setIsuse(Integer isuse) {
        this.isuse = isuse;
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

        SysAddress other = (SysAddress) that;

        return
                (this.getDataId() == null ? other.getDataId() == null : this.getDataId().equals(other.getDataId())) &&

                        (this.getCityname() == null ? other.getCityname() == null : this.getCityname().equals(other.getCityname())) &&

                        (this.getParentid() == null ? other.getParentid() == null : this.getParentid().equals(other.getParentid())) &&

                        (this.getShortname() == null ? other.getShortname() == null : this.getShortname().equals(other.getShortname())) &&

                        (this.getDepth() == null ? other.getDepth() == null : this.getDepth().equals(other.getDepth())) &&

                        (this.getCitycode() == null ? other.getCitycode() == null : this.getCitycode().equals(other.getCitycode())) &&

                        (this.getZipcode() == null ? other.getZipcode() == null : this.getZipcode().equals(other.getZipcode())) &&

                        (this.getMergername() == null ? other.getMergername() == null : this.getMergername().equals(other.getMergername())) &&

                        (this.getLongitude() == null ? other.getLongitude() == null : this.getLongitude().equals(other.getLongitude())) &&

                        (this.getLatitude() == null ? other.getLatitude() == null : this.getLatitude().equals(other.getLatitude())) &&

                        (this.getPinyin() == null ? other.getPinyin() == null : this.getPinyin().equals(other.getPinyin())) &&

                        (this.getIsuse() == null ? other.getIsuse() == null : this.getIsuse().equals(other.getIsuse()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getDataId() == null) ? 0 : getDataId().hashCode());
        result = prime * result + ((getCityname() == null) ? 0 : getCityname().hashCode());
        result = prime * result + ((getParentid() == null) ? 0 : getParentid().hashCode());
        result = prime * result + ((getShortname() == null) ? 0 : getShortname().hashCode());
        result = prime * result + ((getDepth() == null) ? 0 : getDepth().hashCode());
        result = prime * result + ((getCitycode() == null) ? 0 : getCitycode().hashCode());
        result = prime * result + ((getZipcode() == null) ? 0 : getZipcode().hashCode());
        result = prime * result + ((getMergername() == null) ? 0 : getMergername().hashCode());
        result = prime * result + ((getLongitude() == null) ? 0 : getLongitude().hashCode());
        result = prime * result + ((getLatitude() == null) ? 0 : getLatitude().hashCode());
        result = prime * result + ((getPinyin() == null) ? 0 : getPinyin().hashCode());
        result = prime * result + ((getIsuse() == null) ? 0 : getIsuse().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", dataId=").append(dataId);
        sb.append(", cityname=").append(cityname);
        sb.append(", parentid=").append(parentid);
        sb.append(", shortname=").append(shortname);
        sb.append(", depth=").append(depth);
        sb.append(", citycode=").append(citycode);
        sb.append(", zipcode=").append(zipcode);
        sb.append(", mergername=").append(mergername);
        sb.append(", longitude=").append(longitude);
        sb.append(", latitude=").append(latitude);
        sb.append(", pinyin=").append(pinyin);
        sb.append(", isuse=").append(isuse);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}