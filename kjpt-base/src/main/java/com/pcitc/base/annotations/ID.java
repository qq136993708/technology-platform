package com.pcitc.base.annotations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author:Administrator
 * @date:2018/6/23 * 虚键，用于标志主键，不会对ID字段创建mapping（也即在真实的es存储中没有该ID标志的那个字段，只是用于查询时的显示， 比如查询一条记录，会将es自带的_id字段的值设置到该ID标志的字段）
 */
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface ID {
}
