package com.pcitc.web.techFamily;

import com.pcitc.base.util.DateUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

import java.util.*;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.pcitc.base.common.LayuiTableParam;
import com.pcitc.base.common.TreeNode;
import com.pcitc.base.stp.techFamily.TechFamily;
import com.pcitc.service.techFamily.TechFamilyService;

@Api(value = "技术族接口", tags = { "查询技术族信息、分类信息、检索信息等" })
@RestController
public class TechFamilyProviderClient {
	private final static Logger logger = LoggerFactory.getLogger(TechFamilyProviderClient.class);

	@Autowired
	private TechFamilyService techFamilyService;

	/**
	 * @param techType
	 * @return 查询树形结构
	 */
	@RequestMapping(value = "/tech-family-provider/type-tree", method = RequestMethod.POST)
	public List<TreeNode> getTechTypeTree(@RequestBody TechFamily techType) {
		List<TreeNode> list = null;
		try {
			list = techFamilyService.selectTreeNodeByLevel(techType);
			for (int i = 0; i < list.size(); i++) {
				TreeNode tree = list.get(i);
				// 前几层默认打开
				if (tree.getLevelCode() < 2) {
					tree.setOpen("true");
				} else {
					tree.setOpen("false");
				}

				// 判断节点是否有孩子（异步加载用）
				if (tree.getParentFlag().equals("0")) {
					tree.setIsParent(false);
				} else {
					tree.setIsParent(true);
				}
			}
		} catch (Exception e) {
			logger.error("[分类树获取失败：]", e);
		}
		return list;
	}

	/**
	 * @param techType
	 * @return 查询树形结构
	 */
	@RequestMapping(value = "/tech-family-provider/type-tree1", method = RequestMethod.POST)
	public JSONArray getTechTypeTree1(@RequestBody TechFamily techType) {
		List<TreeNode> list = null;
		JSONArray temJson = new JSONArray();
		JSONObject rootJson = new JSONObject();
		rootJson.put("id", "10");
		rootJson.put("pId", "-");
		rootJson.put("name", "技术族");
		temJson.add(rootJson);
		try {
			list = techFamilyService.selectTreeNodeByLevel(techType);

			for (int i = 0; i < list.size(); i++) {
				JSONObject treeJson = new JSONObject();
				treeJson.put("id", list.get(i).getId());
				treeJson.put("pId", list.get(i).getpId());
				treeJson.put("name", list.get(i).getName());
				temJson.add(treeJson);
			}

		} catch (Exception e) {
			logger.error("[分类树获取失败：]", e);
		}
		return temJson;
	}

	/**
	 * @param techType
	 * @return 查询树形结构
	 */
	@RequestMapping(value = "/tech-family-provider/type-tree/cond", method = RequestMethod.POST)
	public JSONArray getTechTypeTreeCode(@RequestBody TechFamily techType) {
		JSONArray temJson = new JSONArray();
		TechFamily temT = new TechFamily();
		temT.setTypeName(techType.getTypeName());
		List<TreeNode> list = techFamilyService.selectTreeNodeByLevel(temT);
		
		List<TreeNode> retList = new ArrayList<TreeNode>();
		if (list != null && list.size() >= 1 && list.size() <= 5) {
			JSONObject rootJson = new JSONObject();
			rootJson.put("id", "10");
			rootJson.put("pId", "-");
			rootJson.put("name", "中国石化技术族");
			temJson.add(rootJson);
			for (int k = 0; k < list.size(); k++) {
				System.out.println(list.size() + "====================技术族");
				TreeNode temNode = list.get(k);
				techType.setLevelCode("2");
				List<String> typeCodeCond = new ArrayList<String>();
				String nodePath = temNode.getNodePath();
				String[] nodes = nodePath.split("@");
				System.out.println(nodePath + "====================技术族");
				for (int i = 1; i < nodes.length; i++) {
					typeCodeCond.add(nodes[i]);
				}
				System.out.println(nodes.length + "====================技术族"+nodes[nodes.length - 1]);
				techType.setParentCode(nodes[nodes.length - 1]);
				techType.setTypeCodeCond(typeCodeCond);
				List<TreeNode> temList = techFamilyService.selectTreeNodeByLevelCond(techType);
				
				retList.addAll(temList);
			}
			
			System.out.println(retList.size() + "====================1技术族");
			
			List<TreeNode> zList = new ArrayList<TreeNode>();
			for (int i = 0; i < retList.size(); i++) {
				TreeNode iNode = retList.get(i);
				boolean temB = true;
				for (int j = 0; j < zList.size(); j++) {
					TreeNode jNode = zList.get(j);
					if (iNode.getCode().equals(jNode.getCode())) {
						temB = false;
						break;
					}
				}
				if (temB) {
					zList.add(iNode);
				}
			}
			
			System.out.println(zList.size() + "====================2技术族");
			for (int i = 0; i < zList.size(); i++) {
				JSONObject treeJson = new JSONObject();
				treeJson.put("id", zList.get(i).getId());
				treeJson.put("pId", zList.get(i).getpId());
				treeJson.put("name", zList.get(i).getName());
				if (zList.get(i).getLevelCode() > 2) {
					treeJson.put("symbolSize", "[90, 70]");
					treeJson.put("symbol", "'image://http://localhost:8080/image/house.png'");
				}
				temJson.add(treeJson);
			}
		} else if (list.size() > 5) {
			JSONObject rootJson = new JSONObject();
			rootJson.put("id", "10");
			rootJson.put("pId", "-");
			rootJson.put("name", "技术族");
			temJson.add(rootJson);
		} 

		return temJson;
	}

	@ApiOperation(value = "查询技术族分类", notes = "表格显示，分页处理")
	@RequestMapping(value = "/tech-family-provider/type-list", method = RequestMethod.POST)
	public Object getTechTypeList(@RequestBody LayuiTableParam param) throws Exception {

		Object tem = techFamilyService.getTechTypeList(param);
		return tem;
	}

	@ApiOperation(value = "保存技术族分类", notes = "保存技术族分类")
	@RequestMapping(value = "/tech-family-provider/type-insert", method = RequestMethod.POST)
	public Integer insertTechFamilyType(@RequestBody TechFamily techType) {
		System.out.println("insertTechFamilyType==================" + techType);
		// 先获取父节点信息
		TechFamily temTF = new TechFamily();
		temTF.setTfmTypeId(techType.getParentId());
		List<TechFamily> parentList = techFamilyService.selectTechFamilyTypeList(temTF);

		if (parentList != null && parentList.size() == 1) {
			TechFamily parentVo = parentList.get(0);
			techType.setParentCode(parentVo.getTypeCode());
			techType.setTypeIndex(parentVo.getTypeIndex() + techType.getTypeCode() + "@");
			techType.setLevelCode(String.valueOf(Integer.valueOf(parentVo.getLevelCode()) + 1));
			techType.setTfmTypeId(UUID.randomUUID().toString().replaceAll("-", ""));

			techFamilyService.saveTechFamilyType(techType);

			// 修改原节点isParent 属性
			if (parentVo.getIsParent().equals("0")) {
				parentVo.setIsParent("1");
				techFamilyService.updateTechFamilyType(parentVo);
			}
			return 1;
		} else {
			return 0;
		}

	}

	@ApiOperation(value = "删除技术族分类", notes = "删除技术族分类")
	@RequestMapping(value = "/tech-family-provider/type-delete", method = RequestMethod.DELETE)
	public Integer deleteTechFamilyType(@RequestBody TechFamily techType) {
		System.out.println("deleteTechFamilyType==================" + techType);

		String[] typeIds = techType.getTfmTypeId().split(",");
		String[] typeIndex = techType.getTypeIndex().split(",");
		for (int i = 0; i < typeIds.length; i++) {
			// 删除当前节点及其孩子
			TechFamily temTF = new TechFamily();
			temTF.setStatus("0");
			temTF.setTypeIndex(typeIndex[i]);
			techFamilyService.deleteTechFamilyType(temTF);

			// 判断其父亲节点是否还有孩子
			TechFamily parentTF = new TechFamily();
			parentTF.setParentId(techType.getParentId());
			parentTF.setStatus("1");
			List<TechFamily> parentList = techFamilyService.selectTechFamilyTypeList(parentTF);
			if (parentList == null || parentList.size() <= 0) {// 已经没有其他孩子,
																// 修改父亲节点的isparent
				// 先获取父节点信息
				TechFamily tf = new TechFamily();
				tf.setTfmTypeId(techType.getParentId());
				List<TechFamily> tfList = techFamilyService.selectTechFamilyTypeList(tf);

				if (tfList != null && tfList.size() > 0) {
					TechFamily oldParentTF = tfList.get(0);
					oldParentTF.setIsParent("0");
					techFamilyService.updateTechFamilyType(oldParentTF);
				}
			}
		}
		return 1;
	}

	@ApiOperation(value = "获取当前节点孩子的最大编码", notes = "新增数据时，编码+1")
	@RequestMapping(value = "/tech-family-provider/max-type-code", method = RequestMethod.POST)
	public JSONObject getMaxTechTypeCode(@RequestBody HashMap<String, String> map) {
		String maxTypeCode = techFamilyService.getMaxTechTypeCode(map);
		String retCode = "101";
		JSONObject retJson = new JSONObject();
		if (maxTypeCode != null) {
			// 取后四位+1
			String temcode = maxTypeCode.substring(maxTypeCode.length() - 4, maxTypeCode.length());
			retCode = maxTypeCode.substring(0, maxTypeCode.length() - 4) + String.valueOf(Integer.parseInt(temcode) + 1);
		}
		retJson.put("maxTypeCode", retCode);
		return retJson;
	}

    @ApiOperation(value = "保存技术族分类", notes = "保存技术族分类")
    @RequestMapping(value = "/tech-family-provider/type-insert-list", method = RequestMethod.POST)
    public Integer insertTechFamilyTypeList(@RequestBody JSONObject jsonObject) {
        System.out.println("insertTechFamilyType==================" + jsonObject);
        int rt = 0;
        List<List<Object>> valByRow = (List<List<Object>>) jsonObject.get("list");
        List<TechFamily> techFamilies = new ArrayList<>();
        for (int j = 1; j < valByRow.size(); j++) {

            String pid = (String) valByRow.get(j).get(0);//父ID
            String id = (String) valByRow.get(j).get(1);//ID
            String name = (String) valByRow.get(j).get(2);//name

            //获取最大编码
            HashMap<String, String> map = new HashMap<String, String>();
            map.put("parentId", pid);
            String maxTypeCode = techFamilyService.getMaxTechTypeCode(map);
            String retCode = "101";
            if (maxTypeCode != null) {
                String temcode = maxTypeCode.substring(maxTypeCode.length() - 4, maxTypeCode.length());
                retCode = maxTypeCode.substring(0, maxTypeCode.length() - 4) + String.valueOf(Integer.parseInt(temcode) + 1);
            }


            // 先获取父节点信息
            TechFamily techType = new TechFamily();

            techType.setTfmTypeId(pid);
            List<TechFamily> parentList = techFamilyService.selectTechFamilyTypeList(techType);



            if (parentList != null && parentList.size() == 1) {
                TechFamily parentVo = parentList.get(0);
                techType.setStatus("1");
                techType.setCreateDate(DateUtil.format(new Date(), DateUtil.FMT_SS));
                techType.setIsParent("0");
                techType.setTypeCode(retCode);

                techType.setTypeName(name);
                techType.setParentCode(parentVo.getTypeCode());
                techType.setTypeIndex(parentVo.getTypeIndex() + techType.getTypeCode() + "@");
                techType.setLevelCode(String.valueOf(Integer.valueOf(parentVo.getLevelCode()) + 1));
                techType.setParentId(pid);
                techType.setTfmTypeId(id);
//                techType.setTfmTypeId(UUID.randomUUID().toString().replaceAll("-", ""));
                techFamilyService.saveTechFamilyType(techType);
                // 修改原节点isParent 属性
                if (parentVo.getIsParent().equals("0")) {
                    parentVo.setIsParent("1");
                    techFamilyService.updateTechFamilyType(parentVo);
                }
                techFamilies.add(techType);
                rt =  1;
            } else {
                rt = 0;
                break;
            }
        }
        if (rt==0){
            for (int i = 0; i < techFamilies.size(); i++) {
                techFamilyService.deleteTechFamilyType(techFamilies.get(i));
            }
        }
        return rt;
    }
}
