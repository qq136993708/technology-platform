package com.pcitc.base.common;

import java.util.ArrayList;
import java.util.List;

public class ChartForceResultData {

    public final static String name = "FORCENAME";

    public final static String value = "forcevalue";

    private List<ChartForceDataNode> nodes = new ArrayList<ChartForceDataNode>();

    private List<ChartForceDataLink> links = new ArrayList<ChartForceDataLink>();

    private List<ChartForceCategories> categories = new ArrayList<ChartForceCategories>();

    private List<String> legendDataList = new ArrayList<String>();


    private String title;


    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public List<String> getLegendDataList() {
        return legendDataList;
    }

    public void setLegendDataList(List<String> legendDataList) {
        this.legendDataList = legendDataList;
    }


    public List<ChartForceDataNode> getNodes() {
        return nodes;
    }

    public void setNodes(List<ChartForceDataNode> nodes) {
        this.nodes = nodes;
    }

    public List<ChartForceDataLink> getLinks() {
        return links;
    }

    public void setLinks(List<ChartForceDataLink> links) {
        this.links = links;
    }

    public List<ChartForceCategories> getCategories() {
        return categories;
    }

    public void setCategories(List<ChartForceCategories> categories) {
        this.categories = categories;
    }
}
