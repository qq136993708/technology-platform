package com.pcitc.base.common;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.pcitc.base.stp.techFamily.TechFamily;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * @author masir
 * Bootstrap treeview 树实体
 */
public class TreeNode implements Serializable {

    private static final long serialVersionUID = 1L;


    private String text;

    private List<String> tags;

    private String id;

    private String parentId;

    private int levelCode;

    private List<TreeNode> nodes;

    private String icon;
    
    private int isLeaf;//叶子节点
    
    private boolean isParent;
    
    private String code;
    
    private String pId;
    
    private String name;
    
    private String open;
    
    private String nodeType;
    
    private String treeUrl;
    
    private String nodePath;
    
    private String parentFlag;
    
    private String children;
    
    private String _parentId;
    
    private String state;
    
    private String expand;
    
    //一级计划（wbs内码、计划开始、计划完成、计划工期、估算权重、百分比权重）
    private String innerCode;
    
    private String planStart;
    
    private String planEnd;
    
    private String planDuration;
    
    private String estimatedWeight;
    
    private String percentageWeight;
    
    private String wbsInnercode;
    
    private String bak1;
    
    private String bak2;
    
    private String bak3;
    
    
    private List<TreeNode> childNodes = new ArrayList<TreeNode>();
    
    
	public List<TreeNode> getChildNodes() {
		return childNodes;
	}

	public void setChildNodes(List<TreeNode> childNodes) {
		this.childNodes = childNodes;
	}

	public String getBak1() {
		return bak1;
	}

	public void setBak1(String bak1) {
		this.bak1 = bak1;
	}

	public String getBak2() {
		return bak2;
	}

	public void setBak2(String bak2) {
		this.bak2 = bak2;
	}

	public String getBak3() {
		return bak3;
	}

	public void setBak3(String bak3) {
		this.bak3 = bak3;
	}

	public String getExpand() {
		return expand;
	}

	public void setExpand(String expand) {
		this.expand = expand;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String get_parentId() {
		return _parentId;
	}

	public void set_parentId(String _parentId) {
		this._parentId = _parentId;
	}

	public String getChildren() {
		return children;
	}

	public void setChildren(String children) {
		this.children = children;
	}

	public String getParentFlag() {
		return parentFlag;
	}

	public void setParentFlag(String parentFlag) {
		this.parentFlag = parentFlag;
	}

	public String getNodePath() {
		return nodePath;
	}

	public void setNodePath(String nodePath) {
		this.nodePath = nodePath;
	}

	public void setParent(boolean isParent) {
		this.isParent = isParent;
	}

	public String getTreeUrl() {
		return treeUrl;
	}

	public void setTreeUrl(String treeUrl) {
		this.treeUrl = treeUrl;
	}

	public String getNodeType() {
		return nodeType;
	}

	public void setNodeType(String nodeType) {
		this.nodeType = nodeType;
	}

	public String getOpen() {
		return open;
	}

	public void setOpen(String open) {
		this.open = open;
	}

	public String getpId() {
		return pId;
	}

	public void setpId(String pId) {
		this.pId = pId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getIsLeaf() {
		return isLeaf;
	}

	public void setIsLeaf(int isLeaf) {
		this.isLeaf = isLeaf;
	}

	public String getParentId() {

        return this.parentId;
    }

    public String getIcon() {

        return icon;
    }

    public void setIcon(String icon) {

        this.icon = icon;
    }

    public int getLevelCode() {

        return levelCode;
    }

    public void setLevelCode(int levelCode) {

        this.levelCode = levelCode;
    }

    public void setParentId(String parentId) {

        this.parentId = parentId;
    }

    public String getText() {

        return text;
    }

    public void setText(String text) {

        this.text = text;
    }

    public List<String> getTags() {

        return tags;
    }

    public void setTags(List<String> tags) {

        this.tags = tags;
    }

    public String getId() {

        return id;
    }

    public void setId(String id) {

        this.id = id;
    }

    public List<TreeNode> getNodes() {

        return nodes;
    }

    public void setNodes(List<TreeNode> nodes) {

        this.nodes = nodes;
    }

	public boolean getIsParent() {
		return isParent;
	}

	public void setIsParent(boolean isParent) {
		this.isParent = isParent;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}
	
	public String getInnerCode() {
		return innerCode;
	}

	public void setInnerCode(String innerCode) {
		this.innerCode = innerCode;
	}

	public String getPlanStart() {
		return planStart;
	}

	public void setPlanStart(String planStart) {
		this.planStart = planStart;
	}

	public String getPlanEnd() {
		return planEnd;
	}

	public void setPlanEnd(String planEnd) {
		this.planEnd = planEnd;
	}

	public String getPlanDuration() {
		return planDuration;
	}

	public void setPlanDuration(String planDuration) {
		this.planDuration = planDuration;
	}

	public String getEstimatedWeight() {
		return estimatedWeight;
	}

	public void setEstimatedWeight(String estimatedWeight) {
		this.estimatedWeight = estimatedWeight;
	}

	public String getPercentageWeight() {
		return percentageWeight;
	}

	public void setPercentageWeight(String percentageWeight) {
		this.percentageWeight = percentageWeight;
	}

	public String getWbsInnercode() {
		return wbsInnercode;
	}

	public void setWbsInnercode(String wbsInnercode) {
		this.wbsInnercode = wbsInnercode;
	}

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TreeNode treeNode = (TreeNode) o;
        return levelCode == treeNode.levelCode &&
                isLeaf == treeNode.isLeaf &&
                isParent == treeNode.isParent &&
                Objects.equals(text, treeNode.text) &&
                Objects.equals(tags, treeNode.tags) &&
                Objects.equals(id, treeNode.id) &&
                Objects.equals(parentId, treeNode.parentId) &&
                Objects.equals(nodes, treeNode.nodes) &&
                Objects.equals(icon, treeNode.icon) &&
                Objects.equals(code, treeNode.code) &&
                Objects.equals(pId, treeNode.pId) &&
                Objects.equals(name, treeNode.name) &&
                Objects.equals(open, treeNode.open) &&
                Objects.equals(nodeType, treeNode.nodeType) &&
                Objects.equals(treeUrl, treeNode.treeUrl) &&
                Objects.equals(nodePath, treeNode.nodePath) &&
                Objects.equals(parentFlag, treeNode.parentFlag) &&
                Objects.equals(children, treeNode.children) &&
                Objects.equals(_parentId, treeNode._parentId) &&
                Objects.equals(state, treeNode.state) &&
                Objects.equals(expand, treeNode.expand) &&
                Objects.equals(innerCode, treeNode.innerCode) &&
                Objects.equals(planStart, treeNode.planStart) &&
                Objects.equals(planEnd, treeNode.planEnd) &&
                Objects.equals(planDuration, treeNode.planDuration) &&
                Objects.equals(estimatedWeight, treeNode.estimatedWeight) &&
                Objects.equals(percentageWeight, treeNode.percentageWeight) &&
                Objects.equals(wbsInnercode, treeNode.wbsInnercode) &&
                Objects.equals(bak1, treeNode.bak1) &&
                Objects.equals(bak2, treeNode.bak2) &&
                Objects.equals(bak3, treeNode.bak3);
    }

    @Override
    public int hashCode() {

        return Objects.hash(text, tags, id, parentId, levelCode, nodes, icon, isLeaf, isParent, code, pId, name, open, nodeType, treeUrl, nodePath, parentFlag, children, _parentId, state, expand, innerCode, planStart, planEnd, planDuration, estimatedWeight, percentageWeight, wbsInnercode, bak1, bak2, bak3);
    }
}
