package com.pcitc.service.system.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.pcitc.base.common.LayuiTableData;
import com.pcitc.base.common.LayuiTableParam;
import com.pcitc.base.common.TreeNode;
import com.pcitc.base.system.SysButton;
import com.pcitc.base.system.SysButtonExample;
import com.pcitc.base.system.SysFunction;
import com.pcitc.base.system.SysFunctionExample;
import com.pcitc.base.system.SysRoleFunction;
import com.pcitc.base.system.SysRoleFunctionExample;
import com.pcitc.base.system.SysUserRole;
import com.pcitc.base.system.SysUserRoleExample;
import com.pcitc.base.system.vo.SysFunctionVo;
import com.pcitc.base.util.AutoNumberUtils;
import com.pcitc.base.util.StrUtil;
import com.pcitc.base.util.TreeNodeUtil;
import com.pcitc.mapper.system.SysButtonMapper;
import com.pcitc.mapper.system.SysFunctionMapper;
import com.pcitc.mapper.system.SysRoleFunctionMapper;
import com.pcitc.mapper.system.SysUserRoleMapper;
import com.pcitc.service.system.SysFunctionService;

@Service
public class SysFunctionServiceImpl implements SysFunctionService{
	
	@Autowired
	private SysFunctionMapper functionMapper;
	
	@Autowired
	private SysUserRoleMapper userRoleMapper;
	
	@Autowired
	private SysRoleFunctionMapper roleFunctionMapper;
	
	@Autowired
	private SysFunctionMapper functionDao;
	
	@Autowired
	private SysButtonMapper buttonDao;

	

	@Override
	public LayuiTableData selectFunctionList(LayuiTableParam param) throws Exception {
		//每页显示条数
		int pageSize = param.getLimit();
		//当前是第几页
		int pageNum = param.getPage();
		// 1、设置分页信息，包括当前页数和每页显示的总计数
		PageHelper.startPage(pageNum, pageSize);
		
		
		// 2、执行查询
	    SysFunction function = new SysFunction();
	    System.out.println("4====/task/pending-list" + param.getOrderKey());
		System.out.println("5====/task/pending-list" + param.getOrderType());
		if (param.getOrderKey() != null && !StrUtil.isBlankOrNull(param.getOrderKey().toString())) {
			PageHelper.orderBy(param.getOrderKey().toString() +" "+ param.getOrderType().toString());
		} else {
			PageHelper.orderBy("weight asc");
		}
        function.setName((String)param.getParam().get("name"));
        function.setParentId((String) param.getParam().get("parentId"));
	    
		List<SysFunction> list = functionDao.selectFunctionList(function);
		// 3、获取分页查询后的数据
		PageInfo<SysFunction> pageInfo= new PageInfo<SysFunction>(list);
		// 4、封装需要返回的分页实体
		LayuiTableData data = new LayuiTableData();
		data.setData(pageInfo.getList());
		Long total = pageInfo.getTotal();
		data.setCount(total.intValue());
		return data;
	
	}
    
	@Transactional
	@Override
	public int updateOrInsertFunction(SysFunctionVo function) throws Exception {
		int result = 500;
		List<SysFunction> beFound = null;
		String codeString = null;
		String parentCode = null;
		int sameCount =0;
		if(function != null){
			String oldParentId = function.getParentId();//老的 父id
			String newParentId = function.getParentName();//新的
			if(function.getId()!=null && function.getId()!=""){
				//若同一级有相同菜单返回201；
				sameCount = functionDao.selectSameName(function.getParentId(),function.getName(),function.getId());
				if(sameCount > 0){
					return 201;//(有相同名字菜单)
				}
				//如果改变父节点，既要改变parentId,又要改变parentCode
				if(StrUtil.isNotBlank(newParentId)){
					if(!newParentId.equals(function.getParentId())){
						function.setParentId(newParentId);
						parentCode  =functionDao.getCodeById(newParentId);
						function.setParentCode(parentCode);
						createCode(parentCode,beFound,codeString,function);
					}
					 changeParentCodeAndCreateCode(function,beFound,codeString);
				}
				functionDao.updateByPrimaryKeySelective(function);
				//如果变化了父节点，查询之前父节点之下是否还有子节点
				if(StrUtil.isNotBlank(newParentId) && !newParentId.equals(oldParentId) ){
					//如果变化了父节点，查询之前父节点之下是否还有子节点
					int countSon = functionDao.getCountByParentId(oldParentId);
					if(countSon < 1){
						functionDao.updateNodeIsParent(oldParentId, 0);
						functionDao.updateNodeIsLeaf(oldParentId, 1);
					}
					//如果变化了父节点，现在父节点之下就有子节点
					functionDao.updateNodeIsParent(newParentId, 1);
					functionDao.updateNodeIsLeaf(newParentId, 0);
				}
			}else{
				String id = UUID.randomUUID().toString().replace("-", "");
				function.setId(id);
				function.setLevelCode(Integer.valueOf(function.getLevelCode()!= null ?function.getLevelCode():0)+1);
				//function.setIsLeaf(1);//新增菜单必定是子节点
				
				sameCount = functionDao.selectSameName(function.getParentId(),function.getName(),null);
				if(sameCount > 0){
					return 201;//(有相同名字菜单)
				}
				//生成code编号
	    		if(StrUtil.isEmpty(function.getCode())){
	    			createCode(function.getParentCode(),beFound,codeString,function);
	    		}
				buttonDao.updateByFunctionId(id);
				functionDao.insertSelective(function);
				//新增时修改其父节点isparent是1,isleaf 是0 
				functionDao.updateNodeIsParent(function.getParentId(), 1);
				functionDao.updateNodeIsLeaf(function.getParentId(), 0);
			}
		}
		result = 200;
		return result;
	}

	@Transactional
	@Override
	public int deleteFunction(String id) throws Exception {
		int result = 500;
		int count = functionDao.getCountByParentId(id);
		if(id!=null && id!=""){
			if(count >0 ){
				return 101;
			}
			//删除之前查一下要删除的节点的父节点，再看父节点下是否有子节点
			String parentId = functionDao.getParentIdById(id);
			functionDao.deleteByPrimaryKey(id);
			//删除后 如果这个节点的父节点下没有子节点了，则修改isparent 为0
			int countSon = functionDao.getCountByParentId(parentId);
			if(countSon < 1){
				functionDao.updateNodeIsParent(parentId, 0);
				functionDao.updateNodeIsLeaf(parentId, 1);
			}
			
		}
		result = 200;
		return result;
	}

	@Override
	public SysFunction getFunctionById(String id) {
		
		return functionDao.getFunctionById(id);
	}

	@Override
	public List<TreeNode> selectTreeNodeByLevel(SysFunction function) throws Exception {
		
		return functionDao.selectTreeNodeByLevel(function);
	}
	
	@Override
	public List<SysFunction> findFunctionsByUserId(String userId) 
	{
		//查询角色
		SysUserRoleExample userRoleExample = new SysUserRoleExample();
		userRoleExample.createCriteria().andUserIdEqualTo(userId);
		List<SysUserRole> userRoles = userRoleMapper.selectByExample(userRoleExample);
		List<String> roleIds = new ArrayList<String>();
		for(SysUserRole urole:userRoles){
			roleIds.add(urole.getRoleId());
		}
		if(roleIds.size()==0){
			return new ArrayList<SysFunction>();
		}
		//查询菜单Ids	
		SysRoleFunctionExample roleFunctionExample = new SysRoleFunctionExample();
		roleFunctionExample.createCriteria().andRoleIdIn(roleIds);
		List<SysRoleFunction> rolefuncrels = roleFunctionMapper.selectByExample(roleFunctionExample);
		List<String> funcIds = new ArrayList<String>();
		for(SysRoleFunction rel:rolefuncrels){
			funcIds.add(rel.getFunctionId());
		}
		if(funcIds.size()==0){
			return new ArrayList<SysFunction>();
		}
		//查询菜单
		SysFunctionExample functionExample = new SysFunctionExample();
		functionExample.createCriteria().andIdIn(funcIds);
		return functionMapper.selectByExample(functionExample);
	}

	@Override
	public SysFunction getRootFunction() 
	{
		SysFunctionExample example = new SysFunctionExample();
		example.createCriteria().andParentIdIsNull();
		
		List<SysFunction> funcs = functionMapper.selectByExample(example);
		if(funcs != null && funcs.size()>0){
			return funcs.get(0);
		}
		return null;
	}

	@Override
	public Integer updateRoleFunctionRel(String roleId,List<SysRoleFunction> rels) {
		//查询菜单Ids	
		Integer rs = 0;
		try{
			SysRoleFunctionExample roleFunctionExample = new SysRoleFunctionExample();
			roleFunctionExample.createCriteria().andRoleIdEqualTo(roleId);
			rs += roleFunctionMapper.deleteByExample(roleFunctionExample);
			
			for(SysRoleFunction rel:rels)
			{
				rs += roleFunctionMapper.insert(rel);
			}
			
		}catch(Exception e){
			return rs;
		}
		return rs;
	}

	@Override
	public List<TreeNode> selectList(String id) throws Exception {
		
		return functionDao.selectFunctionByLevelCode(id);
	}
	
	
	private void createCode(String parentCode,List<SysFunction> beFound,String codeString,SysFunction function){
		if(!StrUtil.isEmpty(parentCode)){
			beFound = functionDao.findByParentCodeOrderByCodeDesc(parentCode);
			if(beFound != null && beFound.size()>0){
				if(beFound.get(0).getCode() != null && beFound.get(0).getParentCode() !=null){
    				if(beFound.get(0).getCode().indexOf(beFound.get(0).getParentCode()) != -1){
    					codeString = beFound.get(0).getCode().replaceFirst(beFound.get(0).getParentCode(), "");//父节点下最后一个子节点编码（最大的）
    				}else{
    					codeString = "00";
    				}
				}
			}else{
				codeString = "00";
			}
		}
		int num = -1;
		if(!StrUtil.isEmpty(codeString)){
			num = Integer.valueOf(codeString);
		}else{
			codeString = "00";
			num = Integer.valueOf(codeString);
		}

		if (num < 10) {
			num = Integer.valueOf(codeString.substring(codeString.lastIndexOf("0"), codeString.length()));
		} else if (num > 9 && num < 100) {
			num = Integer.valueOf(codeString.substring(0, codeString.length()));
		} 
		
		String code = AutoNumberUtils.getTwoNumber(num);
		
		function.setCode(parentCode + code);
	}

	/**
	 * 查询子节点
	 * @param parentId
	 * @return
	 */
	public List<TreeNode> findSons(String parentId){
		List<TreeNode> list = null;
		try {
			list = functionDao.findSons(parentId);
			list = TreeNodeUtil.getChildrenNode(parentId,list);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	/**
	 * 获取树种所有节点ID集合
	 * @param treeNodes
	 * @param strings
	 */
	public void getIds(List<TreeNode> treeNodes,List<String> strings){
		for (int i = 0; i < treeNodes.size(); i++) {
			strings.add(treeNodes.get(i).getId());
			if(treeNodes.get(i).getNodes().size()>0){
				getIds(treeNodes.get(i).getNodes(),strings);
			}
		}
	}

	@Override
	public LayuiTableData selectButtonList(LayuiTableParam param) throws Exception {
		//每页显示条数
		int pageSize = param.getLimit();
		//从第多少条开始
		int pageStart = (param.getPage()-1)*pageSize;
		//当前是第几页
		int pageNum = pageStart/pageSize + 1;
		// 1、设置分页信息，包括当前页数和每页显示的总计数
		PageHelper.startPage(pageNum, pageSize);
		// 2、执行查询
	    SysButton button = new SysButton();
	    /*button.setiSortCol(tableInfo.getiSortCol());
	    button.setsSortDir_0(tableInfo.getsSortDir_0());*/
	    button.setFunctionId((String) param.getParam().get("functionId"));
	    

		List<SysButton> list = buttonDao.selectButtonList(button);
		// 3、获取分页查询后的数据
		PageInfo<SysButton> pageInfo= new PageInfo<SysButton>(list);
		// 4、封装需要返回的分页实体
		LayuiTableData data = new LayuiTableData();
		data.setData(pageInfo.getList());
		Long total = pageInfo.getTotal();
		data.setCount(total.intValue());
		return data;
	}

	@Override
	public int updateOrInsertButton(SysButton button) throws Exception {
		int result = 500;
		int sameCount = 0;
		
		if(!StrUtil.isBlank(button.getId())){
			sameCount = buttonDao.selectCountSameName(button.getFunctionId(), button.getName(),button.getId());
			if(sameCount > 0 ){
				return 201;//返回201表示重复
			}
			SysButtonExample example = new SysButtonExample();
			buttonDao.updateByExampleSelective(button, example);
		}else{
			button.setId(UUID.randomUUID().toString().replace("-", ""));
			sameCount = buttonDao.selectCountSameName(button.getFunctionId(), button.getName(),button.getId());
			if(sameCount > 0 ){
				return 201;//返回201表示重复
			}
			//生成button编码
/*			if(StrUtil.isBlank(button.getCode())){
		    	String code = HanyuPinyinHelper.toPinyin(HanyuPinyinHelper.toPinyin(button.getName()));
		    	button.setCode(code);
			}*/
			buttonDao.insertSelective(button);
		}
		result= 200;
		return result;
	}

	@Override
	public SysButton getButtonById(String id) throws Exception {
		
		return buttonDao.getButtonInfoById(id);
	}

	@Override
	public int deleteButton(String id) throws Exception {
		
		return buttonDao.deleteById(id);
	}
	
	/**
	 * 只要有子节点，修改子节点的parentCode,并且生成子节点Code
	 * @param function
	 * @param beFound
	 * @param codeString
	 */
	public void changeParentCodeAndCreateCode(SysFunction function,List<SysFunction> beFound,String codeString){
		List<SysFunction> nodes = functionDao.findChildren(function.getId());
		if(nodes != null&& nodes.size()>0 ){
			 for (SysFunction node : nodes) {
				node.setParentCode(function.getCode());
			    createCode(function.getCode(), beFound, codeString, node);
			    functionDao.updateByPrimaryKeySelective(node);
			    //递归只要有子节点，修改子节点的parentCode,并且生成子节点Code
			    changeParentCodeAndCreateCode(node,beFound,codeString);
			 }
		}else{
			return;
		}
	}

	@Override
	public String createCode(SysFunction function) throws Exception {
		List<SysFunction> beFound = null;
		String codeString =null;
		if(!StrUtil.isEmpty(function.getParentCode())){
			beFound = functionDao.findByParentCodeOrderByCodeDesc(function.getParentCode());
			if(beFound != null && beFound.size()>0){
				if(beFound.get(0).getCode() != null && beFound.get(0).getParentCode() !=null){
    				if(beFound.get(0).getCode().indexOf(beFound.get(0).getParentCode()) != -1){
    					codeString = beFound.get(0).getCode().replaceFirst(beFound.get(0).getParentCode(), "");//父节点下最后一个子节点编码（最大的）
    				}else{
    					codeString = "00";
    				}
				}
			}else{
				codeString = "00";
			}
		}
		int num = -1;
		if(!StrUtil.isEmpty(codeString)){
			num = Integer.valueOf(codeString);
		}else{
			codeString = "00";
			num = Integer.valueOf(codeString);
		}

		if (num < 10) {
			num = Integer.valueOf(codeString.substring(codeString.lastIndexOf("0"), codeString.length()));
		} else if (num > 9 && num < 100) {
			num = Integer.valueOf(codeString.substring(0, codeString.length()));
		} 
		
		String code = function.getParentCode()+AutoNumberUtils.getTwoNumber(num);
		return code;
	}

	@Override
	public String createWeight(SysFunction function) throws Exception {
		List<SysFunction> beFound = null;
		Integer weight =0;
		if(!StrUtil.isEmpty(function.getParentCode())){
			beFound = functionDao.findWeightOrderByDesc(function.getParentCode());
			if(beFound != null && beFound.size()>0){
				if(beFound.get(0).getWeight() != null ){
    				weight = beFound.get(0).getWeight()+1;
				}
			}else{
				weight = weight+1;
			}
		}
		
		return weight.toString();
	}

    @Override
    public List<SysFunction> selectByExample(SysFunctionExample example) {
        return functionDao.selectByExample(example);
    }
}
