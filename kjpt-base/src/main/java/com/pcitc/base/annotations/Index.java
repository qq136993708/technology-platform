package com.pcitc.base.annotations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author:Administrator
 * @date:2018/6/23
 */
@Target(ElementType.ANNOTATION_TYPE)
@Retention(RetentionPolicy.RUNTIME)
public @interface Index {
    String name();

    short shards() default 5;// number_of_shards

    short replicas() default 1;// number_of_replicas

    String setting() default "";
}
