package com.pcitc.base.util;

import java.util.ArrayList;
import java.util.List;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;

/**
 * DateTable获取参数将参数实体化的工具
 * @author masir
 *
 */
public class DateTableUtil {
	
	 private static String sEcho = null;
	 private static Integer iColumns = null;
	 private static Integer iDisplayStart = null;
	 private static Integer iDisplayLength = null;
	 private static List<String> mDataProp = null; //存放列名(比如菜单名称/菜单父编码)
	 private static String sSearch = null;
	 private static Integer iSortCol_0 = null;
	 private static String iSortCol = null;
	 private static String sSortDir_0 = null;
	 //以下是扩展属性
	 private static String parentId = null;
	 
	 private static String parentCode = "";
	 
	 private static String name = null;
	 
	private static String param0;
	
	private static String param1;
	
	private static String param2;
	
	private static String param3;
	
	private static String param4;
	
	private static String param5;
	
	private static String param6;
	
	private static String param7;

	private static String param8;
	 
	 
	 public static DataTableInfo getDataTableParam(List<Object> aoData){
		 
		 JSONArray ja = JSONArray.parseArray(JSON.toJSONString(aoData));
		 mDataProp = new ArrayList<String>();
		 for (int i = 0; i < ja.size(); i++) {
			 if (ja.getJSONObject(i).getString("name").equals("sEcho")){
				 sEcho = ja.getJSONObject(i).getString("value");
			 }else if (ja.getJSONObject(i).getString("name").equals("iColumns")){
				 iColumns = Integer.valueOf(ja.getJSONObject(i).getString("value"));
			 }else if (ja.getJSONObject(i).getString("name").equals("iDisplayStart")){
				 iDisplayStart = Integer.valueOf(ja.getJSONObject(i).getString("value"));
			 }else if (ja.getJSONObject(i).getString("name").equals("iDisplayLength")){
				 iDisplayLength = Integer.valueOf(ja.getJSONObject(i).getString("value"));
			 }else if (ja.getJSONObject(i).getString("name").equals("sSearch")){
				 sSearch = ja.getJSONObject(i).getString("value");
			 }else if (ja.getJSONObject(i).getString("name").equals("iSortCol_0")){
				 iSortCol_0 = Integer.valueOf(ja.getJSONObject(i).getString("value"));
			 }else if (ja.getJSONObject(i).getString("name").equals("sSortDir_0")){
				 sSortDir_0 = ja.getJSONObject(i).getString("value");
			 }else if (iColumns != null) {
				 for (int j = 0; j < iColumns; j++){
					  if (ja.getJSONObject(i).getString("name").equals("mDataProp_" + j)){
						  mDataProp.add(ja.getJSONObject(i).getString("value"));
					  }
				 }
			 }
		 }
			 iSortCol = mDataProp.get(iSortCol_0);
			 DataTableInfo info =  new DataTableInfo(sEcho, iColumns, iDisplayStart, iDisplayLength, sSearch, iSortCol_0, iSortCol, sSortDir_0,mDataProp);
			 return info;
	 }
	 
	 
	 
	 public static DataTableInfoVo getAllParam(List<Object> aoData){
			 DataTableInfoVo infoVo = new DataTableInfoVo();
			 JSONArray ja = JSONArray.parseArray(JSON.toJSONString(aoData));
			 mDataProp = new ArrayList<String>();
			 for (int i = 0; i < ja.size(); i++) {
				 if (ja.getJSONObject(i).getString("name").equals("sEcho")){
					 sEcho = ja.getJSONObject(i).getString("value");
					 infoVo.setsEcho(sEcho);
				 }else if (ja.getJSONObject(i).getString("name").equals("iColumns")){
					 iColumns = Integer.valueOf(ja.getJSONObject(i).getString("value"));
					 infoVo.setiColumns(iColumns);
				 }else if (ja.getJSONObject(i).getString("name").equals("iDisplayStart")){
					 iDisplayStart = Integer.valueOf(ja.getJSONObject(i).getString("value"));
					 infoVo.setiDisplayStart(iDisplayStart);
				 }else if (ja.getJSONObject(i).getString("name").equals("iDisplayLength")){
					 iDisplayLength = Integer.valueOf(ja.getJSONObject(i).getString("value"));
					 infoVo.setiDisplayLength(iDisplayLength);
				 }else if (ja.getJSONObject(i).getString("name").equals("sSearch")){
					 sSearch = ja.getJSONObject(i).getString("value");
					 infoVo.setsSearch(sSearch);
				 }else if (ja.getJSONObject(i).getString("name").equals("iSortCol_0")){
					 iSortCol_0 = Integer.valueOf(ja.getJSONObject(i).getString("value"));
					 infoVo.setiSortCol_0(iSortCol_0);
				 }else if (ja.getJSONObject(i).getString("name").equals("sSortDir_0")){
					 sSortDir_0 = ja.getJSONObject(i).getString("value");
					 infoVo.setsSortDir_0(sSortDir_0);
					 //查询条件扩展 根据需求 需要什么参数就往后面加什么参数
				 }else if(ja.getJSONObject(i).getString("name").equals("parentId")){
					 parentId = ja.getJSONObject(i).getString("value");
					 infoVo.setParentId(parentId);
				 }else if(ja.getJSONObject(i).getString("name").equals("parentCode")){
					 parentCode = ja.getJSONObject(i).getString("value");
					 infoVo.setParentCode(parentCode);
				 }else if(ja.getJSONObject(i).getString("name").equals("name")){
					 name = ja.getJSONObject(i).getString("value");
					 infoVo.setName(name);
				 }else if(ja.getJSONObject(i).getString("name").equals("param0")){
					 param0 = ja.getJSONObject(i).getString("value");
					 infoVo.setParam0(param0);
				 }else if(ja.getJSONObject(i).getString("name").equals("param1")){
					 param1 = ja.getJSONObject(i).getString("value");
					 infoVo.setParam1(param1);
				 }else if(ja.getJSONObject(i).getString("name").equals("param2")){
					 param2 = ja.getJSONObject(i).getString("value");
					 infoVo.setParam2(param2);
				 }else if(ja.getJSONObject(i).getString("name").equals("param3")){
					 param3 = ja.getJSONObject(i).getString("value");
					 infoVo.setParam3(param3);
				 }else if(ja.getJSONObject(i).getString("name").equals("param4")){
					 param4 = ja.getJSONObject(i).getString("value");
					 infoVo.setParam4(param4);
				 }else if(ja.getJSONObject(i).getString("name").equals("param5")){
					 param5 = ja.getJSONObject(i).getString("value");
					 infoVo.setParam5(param5);
				 }else if(ja.getJSONObject(i).getString("name").equals("param6")){
					 param6 = ja.getJSONObject(i).getString("value");
					 infoVo.setParam6(param6);
				 }else if(ja.getJSONObject(i).getString("name").equals("param7")){
					 param7 = ja.getJSONObject(i).getString("value");
					 infoVo.setParam7(param7);
				 }else if(ja.getJSONObject(i).getString("name").equals("param8")){
					 param8 = ja.getJSONObject(i).getString("value");
					 infoVo.setParam8(param8);
				 }else if (iColumns != null) {
					 for (int j = 0; j < iColumns; j++){
						  if (ja.getJSONObject(i).getString("name").equals("mDataProp_" + j)){
							  mDataProp.add(ja.getJSONObject(i).getString("value"));
						  }
					 }
					 infoVo.setmDataProp(mDataProp);
					
				 }
			 }
				 iSortCol = mDataProp.get(iSortCol_0);
				 infoVo.setiSortCol(iSortCol);
				 return infoVo;
		 }
		 
	 
	 
	 

}
