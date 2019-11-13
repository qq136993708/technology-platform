package com.pcitc.es.common;

import org.elasticsearch.search.SearchHits;

import java.util.List;

/**
 * @author:Administrator
 * @date:2018/6/23
 */
public class Result<T>
{

    private SearchHits searchHits;

    private List<T> list;

    public SearchHits getSearchHits()
    {
        return searchHits;
    }

    public void setSearchHits(SearchHits searchHits)
    {
        this.searchHits = searchHits;
    }

    public List getList()
    {
        return list;
    }

    public void setList(List list)
    {
        this.list = list;
    }
}
