package com.pcitc.base.common.enums;

/**
 * @author:Administrator
 * @date:2018/6/23
 */
public enum ESOperateType {
    QUERY("_search"),//查询
    COUNT("_count"),//统计
    DELETE("_delete");//删除
    private String value;
    private ESOperateType(String value){
        this.value = value;
    }
    public String getValue(){
        return value;
    }
    public static void main(String[] args) {
        for(ESOperateType type : ESOperateType.values()){
            System.out.println(type + ":" + type.value);
        }
    }
}
