package com.pcitc.web.common;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author zhanghaifeng
 * @Date: 2018/5/15
 * 数据过滤和日志记录功能
 */
@Retention(RetentionPolicy.RUNTIME)//注解会在class中存在，运行时可通过反射获取
@Target(ElementType.METHOD)//目标是方法
@Documented
public @interface OperationFilter {
    
	/**
     * 模块名字
     */
    String modelName() default "";

    /**
     * 操作类型
     */
    String actionName() default "";
    
    /**
     * 归属菜单code
     */
    String dataFlag() default "";

}