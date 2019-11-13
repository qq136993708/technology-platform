package com.pcitc.es;

import org.elasticsearch.search.SearchHits;

import java.util.List;

/**
 * @author:Administrator
 * @date:2018/6/23
 */
public interface Hits {
    <T> void getHITS(SearchHits hits, List<T> list);
}
