package com.pcitc.base.common;

import java.util.ArrayList;
import java.util.List;

public class ChartGraphResultData {

    public final static String name = "GRAPHNAME";

    public final static String value = "graphvalue";

    private List<ChartGraphDataNode> nodes = new ArrayList<ChartGraphDataNode>();

    private List<ChartGraphDataLink> links = new ArrayList<ChartGraphDataLink>();

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


    public List<ChartGraphDataNode> getNodes() {
        return nodes;
    }

    public void setNodes(List<ChartGraphDataNode> nodes) {
        this.nodes = nodes;
    }

    public List<ChartGraphDataLink> getLinks() {
        return links;
    }

    public void setLinks(List<ChartGraphDataLink> links) {
        this.links = links;
    }

    public List<ChartForceCategories> getCategories() {
        return categories;
    }

    public void setCategories(List<ChartForceCategories> categories) {
        this.categories = categories;
    }
}
