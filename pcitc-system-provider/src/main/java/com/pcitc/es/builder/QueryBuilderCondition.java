package com.pcitc.es.builder;

import org.elasticsearch.index.query.BoolQueryBuilder;
import org.elasticsearch.search.sort.SortOrder;

import java.util.List;
import java.util.Map;

/**
 * @author:Administrator
 * @date:2018/6/23
 */
public class QueryBuilderCondition {

    // paixu
    private Map<String, SortOrder> sortMap;

    private BoolQueryBuilder boolQueryBuilder;

    private int start = 0;

    private int row;

    private boolean isShowHighLight = false;

    private float minScore = 1f;

    public float getMinScore()
    {
        return minScore;
    }

    private List<String> highLightFileds;

    public boolean isShowHighLight()
    {
        return isShowHighLight;
    }

    public List<String> getHighLightFileds()
    {
        return highLightFileds;
    }

    public Map<String, SortOrder> getSortMap()
    {
        return sortMap;
    }

    public BoolQueryBuilder getBoolQueryBuilder()
    {
        return boolQueryBuilder;
    }

    public int getStart()
    {
        return start;
    }

    public int getRow()
    {
        return row;
    }

    public static class builder
    {
        QueryBuilderCondition queryBuilderCondition = new QueryBuilderCondition();

        public builder setSortMap(Map<String, SortOrder> sortMap)
        {
            queryBuilderCondition.sortMap = sortMap;
            return this;
        }

        public builder setBoolQueryBuilder(BoolQueryBuilder boolQueryBuilder)
        {
            queryBuilderCondition.boolQueryBuilder = boolQueryBuilder;
            return this;
        }

        public builder setStart(int start)
        {
            queryBuilderCondition.start = start;
            return this;
        }

        public builder setRow(int row)
        {
            queryBuilderCondition.row = row;
            return this;
        }

        public builder setMinScore(float score)
        {
            queryBuilderCondition.minScore = score;
            return this;
        }

        public builder setIsShowHighLight(boolean isShowHighLight, List<String> highLightFileds)
        {
            queryBuilderCondition.isShowHighLight = isShowHighLight;
            queryBuilderCondition.highLightFileds = highLightFileds;
            return this;
        }

        public QueryBuilderCondition builder()
        {
            return queryBuilderCondition;
        }

    }
}
