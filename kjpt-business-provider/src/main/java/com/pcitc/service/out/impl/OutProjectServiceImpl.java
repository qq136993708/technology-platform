package com.pcitc.service.out.impl;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeSet;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSONObject;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.pcitc.base.common.LayuiTableData;
import com.pcitc.base.common.LayuiTableParam;
import com.pcitc.base.out.OutPerson;
import com.pcitc.base.out.OutProject;
import com.pcitc.mapper.out.OutPersonMapper;
import com.pcitc.mapper.out.OutProjectMapper;
import com.pcitc.service.out.IOutProjectService;
@Service("outProjectService")
public class OutProjectServiceImpl implements IOutProjectService {
	
	
	
	@Autowired
	private OutProjectMapper outProjectMapper;
	
	
	
	/**
              * 根据ID获取外系统项目信息详情
	*/
	public OutProject selectOutProject(String id) throws Exception
	{
		return outProjectMapper.selectByPrimaryKey(id);
	}
	
	 /**
	     *修改外系统项目信息
	*/
	public Integer updateOutProject(OutProject record)throws Exception
	{
		return outProjectMapper.updateByPrimaryKey(record);
	}
	
	
	 /**
	     *根据ID删除外系统项目信息
	 */
	public int deleteOutProject(String id)throws Exception
	{
		return outProjectMapper.deleteByPrimaryKey(id);
	}
	
	
	/**
	     * 增加外系统项目信息
	 */
	public Integer insertOutProject(OutProject record)throws Exception
	{
		return outProjectMapper.insert(record);
	}
	
	
	/**
	  * 获取外系统项目（分页）
	*/
	public LayuiTableData getOutProjectPage(LayuiTableParam param)throws Exception
	{
		
	        //每页显示条数
			int pageSize = param.getLimit();
			//从第多少条开始
			int pageStart = (param.getPage()-1)*pageSize;
			//当前是第几页
			int pageNum = pageStart/pageSize + 1;
			// 1、设置分页信息，包括当前页数和每页显示的总计数
			PageHelper.startPage(pageNum, pageSize);
			String rewarkLevel=getTableParam(param,"rewarkLevel","");
			String sourceType=getTableParam(param,"sourceType","");
			String delStatus=getTableParam(param,"delStatus","");
			String outSystemId=getTableParam(param,"outSystemId","");
			String expertId=getTableParam(param,"expertId","");
			String techTypeIndex=getTableParam(param,"techTypeIndex","");
			
			
			Map map=new HashMap();
			map.put("rewarkLevel", rewarkLevel);
			map.put("sourceType", sourceType);
			map.put("delStatus", delStatus);
			map.put("outSystemId", outSystemId);
			map.put("expertId", expertId);
			map.put("techTypeIndex", techTypeIndex);
			
			
			List<OutProject> list = outProjectMapper.getList(map);
			PageInfo<OutProject> pageInfo = new PageInfo<OutProject>(list);
			System.out.println(">>>>>>>>>外系统项目查询分页结果 "+pageInfo.getList().size());
			
			LayuiTableData data = new LayuiTableData();
			data.setData(pageInfo.getList());
			Long total = pageInfo.getTotal();
			data.setCount(total.intValue());
		    return data;
	}
	
	
	public List getOutProjectList(Map map)throws Exception
	{
		List<OutProject> list = outProjectMapper.getList(map);
		
		return list;
	}
	
	

    public JSONObject getHotByTypeIndex(JSONObject obj)throws Exception {
        //查询
        Map map_para=new HashMap();
        map_para.put("techTypeIndex", obj.get("typeIndex").toString());
        List<OutProject> list = outProjectMapper.getList(map_para);
        
        //map<typeIndex,typeName>
        Map<String, String> map = list.stream().collect(Collectors.toMap(OutProject::getTechTypeIndex, OutProject::getProjectName, (entity1, entity2) -> entity1));
        //根据年去重
        List<OutProject> unique = list.stream().collect(
                Collectors.collectingAndThen(
                        Collectors.toCollection(() -> new TreeSet<>(Comparator.comparing(OutProject::getSetupYear))), ArrayList::new)
        );
        //获取年map<年,年>
        Map<String, String> yearMap = unique.stream().collect(Collectors.toMap(OutProject::getSetupYear, OutProject::getSetupYear, (entity1, entity2) -> entity1));
        //排序年
        Map<String, String> sortMap = new LinkedHashMap<>();
        yearMap.entrySet().stream().sorted(Map.Entry.<String, String>comparingByValue()).
                forEachOrdered(e -> sortMap.put(e.getKey(), e.getValue()));
        //去重排序后的年放入list<String>
        List<String> y = new ArrayList<>();
        for (Map.Entry<String, String> e : sortMap.entrySet()) {
            y.add(e.getKey());
        }

        //map<typeIndex,List<对象>>
        Map<String, List<OutProject>> infoGroupMap = list.stream().collect(Collectors.groupingBy(OutProject::getTechTypeIndex));

        //map<typeIndex,Map<年,数量>>
        Map<String, Map<String, Long>> mapCount = new LinkedHashMap<>();
        for (Map.Entry<String, List<OutProject>> entry : infoGroupMap.entrySet()) {
            mapCount.put(entry.getKey(), entry.getValue().stream().collect(Collectors.groupingBy(OutProject::getSetupYear, Collectors.counting())));
        }
        //定义
        List<String> x = new ArrayList<>();
        List<String> x_temp = new ArrayList<>();
        int i = 0, j = 0, k = 0;
        //遍历map,存x,存y
        for (Map.Entry<String, String> entry : map.entrySet()) {
            x.add(entry.getValue());
            x_temp.add(entry.getKey());
        }

        //计算数组长度
        for (Map.Entry<String, Map<String, Long>> entry : mapCount.entrySet()) {
            for (Map.Entry<String, Long> e : entry.getValue().entrySet()) {
                k++;
            }
        }
        int[][] data = new int[k][3];
        int l = 0;
//        //组装
        for (Map.Entry<String, Map<String, Long>> entry : mapCount.entrySet()) {
            Map<String, Long> ymap = entry.getValue();//年,数量
            int xi = x_temp.indexOf(entry.getKey());
            for (Map.Entry<String, Long> e : ymap.entrySet()) {
                int yi = y.indexOf(e.getKey());//获取当前数据所在的y坐标
                int[] ints = new int[3];
                ints[0] = xi;
                ints[1] = yi;
                ints[2] = e.getValue().intValue();
                data[l]=ints;
//                System.out.println(map.get(entry.getKey())+"---"+e.getKey()+"---"+xi+"---"+yi+"---"+ints[2]  );
                //l++
                l++;
            }
        }
        //返回
        obj.put("x", x);
        obj.put("y", y);
        obj.put("data", data);
        return obj;
    }
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
	
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
	
	private String getTableParam(LayuiTableParam param,String paramName,String defaultstr)
	{
		String resault="";
		Object object=param.getParam().get(paramName);
		if(object!=null)
		{
			resault=(String)object;
		}
		return resault;
	}

}
