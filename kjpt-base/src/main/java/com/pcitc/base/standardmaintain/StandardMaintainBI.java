package com.pcitc.base.standardmaintain;

/***
 * @Author xiaoh
 * @Description 质量标准-领导驾驶舱
 * @Date 2020/6/8 17:11
 * @param
 * @return
 **/
public class StandardMaintainBI extends StandardMaintain {

    /**
     * 计划总数
     */
    private int allCount;

    /**
     * 在研数
     */
    private int researchCount;

    /**
     * 累计发布数
     */
    private int publishCount;

    public int getAllCount() {
        return allCount;
    }

    public void setAllCount(int allCount) {
        this.allCount = allCount;
    }

    public int getResearchCount() {
        return researchCount;
    }

    public void setResearchCount(int researchCount) {
        this.researchCount = researchCount;
    }

    public int getPublishCount() {
        return publishCount;
    }

    public void setPublishCount(int publishCount) {
        this.publishCount = publishCount;
    }
}
