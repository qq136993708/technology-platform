package com.pcitc.service.doc;

import com.pcitc.es.builder.BooleanCondtionBuilder;
import com.pcitc.es.builder.QueryBuilderCondition;
import com.pcitc.es.common.Result;
import org.elasticsearch.client.transport.TransportClient;
import org.elasticsearch.search.aggregations.bucket.terms.Terms;

import java.util.Collection;
import java.util.List;

/**
 * @author:Administrator
 * @date:2018/6/23
 * 和ElasticSearch进行交互的底层接口，包括对索引、映射、类型、以及具体记录数据的添加、更新、删除、查询、搜索等操作 目前有两个实现类：
 * (1).AccessorClientImpl:
 * 通过es自带的TransportClient客户端提供的API进行操作 (2).AccessorWebImpl: 通过es的原生的restfult web API进行操作
 */
public interface AccessorService {

    /* 添加单个对象 */
    <T> boolean add(T model);

    /* 批量添加对象 */
    <T> boolean add(List<T> models);

    /* 根据ID获得记录 */
    <T> T get(Class<T> t, String id);

    /* 根据ID删除记录 */
    boolean delete(String id, Class clazz);

    /* 查询 */
    <T> Result searchFun(Class<T> clazz, BooleanCondtionBuilder params);

    /* 查询 */
    <T> Result searchFun(Class<T> clazz, QueryBuilderCondition params);

    /* 根据查询条件统计记录数 */
    public long count(Class clazz, BooleanCondtionBuilder params);

    /* 根据查询条件删除数据 */
    boolean delete(Class clazz, String params);

    TransportClient getClient();

    <T> Collection<Terms.Bucket> groupByAggs(Class<T> clazz, String filed, BooleanCondtionBuilder query);
}
