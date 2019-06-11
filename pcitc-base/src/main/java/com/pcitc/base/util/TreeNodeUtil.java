package com.pcitc.base.util;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.StringUtils;

import com.alibaba.fastjson.JSONArray;
import com.pcitc.base.common.TreeNode;


/**
 * @author masw
 * 递归获取树
 */
public class TreeNodeUtil {

	/**
	 * 父节点
	 * @param treeDataList
	 * @param parentId
	 * @return
	 * @throws Exception
	 */
    public final static List<TreeNode> getfatherNode(List<TreeNode> treeDataList, String parentId) throws Exception {
    	List<TreeNode> newTreeDataList = new ArrayList<TreeNode>();
            for (TreeNode jsonTreeData : treeDataList) {
                if(jsonTreeData.getId().equals(parentId)) {
                    //获取父节点下的子节点
                    jsonTreeData.setNodes(getChildrenNode(jsonTreeData.getId(),treeDataList));
                    newTreeDataList.add(jsonTreeData);
                }
            }
        return newTreeDataList;
    }


   /**
    * 递归获取所有子节点
    * @param parentId
    * @param treeDataList
    * @return
    * @throws Exception
    */
   public final static List<TreeNode> getChildrenNode(String parentId , List<TreeNode> treeDataList) {
        List<TreeNode> newTreeDataList = new ArrayList<TreeNode>();
        	for (TreeNode jsonTreeData : treeDataList) {
                if(jsonTreeData.getParentId() == null || "".equals(jsonTreeData.getParentId())) {
                    continue;
                }
                //这是一个子节点
                if(jsonTreeData.getParentId().equals(parentId)){
                    //递归获取子节点下的子节点
                    jsonTreeData.setNodes(getChildrenNode(jsonTreeData.getId() , treeDataList));
                    newTreeDataList.add(jsonTreeData);
                }
            }
        return newTreeDataList;
    }
   	/**
   	 * 将子节点nodes名称转换children
   	 * @param nodes
   	 * @return
   	 */
    public final static String changeNodesToChildrenJson(List<TreeNode> nodes)
    {
    	String json = JSONArray.toJSONString(nodes);

    	return StringUtils.replacePattern(json, "nodes", "children");
    }
      
}
