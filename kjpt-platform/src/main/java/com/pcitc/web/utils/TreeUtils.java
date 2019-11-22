package com.pcitc.web.utils;

import java.util.ArrayList;
import java.util.List;

import com.pcitc.base.common.FormSelectNode;
import com.pcitc.base.stp.techFamily.TechFamily;
import com.pcitc.base.system.SysUnit;

public class TreeUtils {
	
	
	//机构LIST转为FormSelectNode形式的列表
	public static List<FormSelectNode> sysUnitToSelectNodeList(List<SysUnit> alllist)
	{
		
		List<FormSelectNode> reslutList=new ArrayList();
		for(int i=0;i<alllist.size();i++)
		{
			SysUnit node=alllist.get(i);
			FormSelectNode formSelectNode=new FormSelectNode();
			formSelectNode.setpId(node.getUnitRelation());
			formSelectNode.setId(node.getUnitId());
			formSelectNode.setLevelCode(String.valueOf(node.getUnitLevel()));
			formSelectNode.setValue(node.getUnitId());
			formSelectNode.setName(node.getUnitName());
			formSelectNode.setParentId(node.getUnitRelation());
			reslutList.add(formSelectNode);
			
		}
		return reslutList;
	}

	
	//技术族LIST转为FormSelectNode形式的列表
	public static List<FormSelectNode> treeNodeToSelectNodeList(List<TechFamily> alllist)
	{
		
		List<FormSelectNode> reslutList=new ArrayList();
		for(int i=0;i<alllist.size();i++)
		{
			TechFamily node=alllist.get(i);
			FormSelectNode formSelectNode=new FormSelectNode();
			formSelectNode.setpId(node.getParentId());
			formSelectNode.setCode(node.getTypeCode());
			formSelectNode.setId(node.getTfmTypeId());
			formSelectNode.setLevelCode(node.getLevelCode());
			formSelectNode.setValue(node.getTypeCode());
			formSelectNode.setName(node.getTypeName());
			formSelectNode.setParentId(node.getParentId());
			reslutList.add(formSelectNode);
			
		}
		return reslutList;
	}
	
	

	   /**
	    * 递归算法解析成树形结构
	   */
	  public static  FormSelectNode recursiveTree(String cid, List<FormSelectNode> allList)
		{
			FormSelectNode node = getSysDictionary(cid,  allList);
			// 查询cid下的所有子节点(SELECT * FROM tb_tree t WHERE t.pid=?)
			List<FormSelectNode> childTreeNodes = getChlids(cid,  allList);
			// 遍历子节点
			for (FormSelectNode child : childTreeNodes)
			{
				FormSelectNode n = recursiveTree(child.getId(), allList); // 递归
				node.getChildren().add(n) ;
			}
			return node;
		}
	  
	    //根据ID取详情
		public static FormSelectNode getSysDictionary(String id, List<FormSelectNode> allList)
		{
			FormSelectNode sd=null;
			for(int i=0;i<allList.size();i++)
			{
				FormSelectNode sysDictionary=allList.get(i);
				if(sysDictionary.getId().equals(id))
				{
					sd=sysDictionary;
				}
			}
			return sd;
		}
		
		
		 //根据ID取下一级子节点LIST
		public static  List<FormSelectNode>  getChlids(String id, List<FormSelectNode> allList)
		{
			List<FormSelectNode>  list=new ArrayList<FormSelectNode>();
			for(int i=0;i<allList.size();i++)
			{
				FormSelectNode sysDictionary=allList.get(i);
				String parentId=sysDictionary.getParentId();
				if(parentId!=null)
				{
					if(parentId.equals(id))
					{
						list.add(sysDictionary);
					}
				}
				
			}
			return list;
		}
		
	
		
		
		//获取根节点
		public static  List<FormSelectNode> getRootNode(List<FormSelectNode> menuList) 
		  {         
		         List<FormSelectNode> rootMenuLists =new  ArrayList<FormSelectNode>();
		         for(FormSelectNode menuNode : menuList) {
		             if(menuNode.getParentId().equals("0")) 
		             {
		                 rootMenuLists.add(menuNode);
		             }
		         }
		         return rootMenuLists;
		     }
	

}
