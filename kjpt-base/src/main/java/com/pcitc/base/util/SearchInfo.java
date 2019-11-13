package com.pcitc.base.util;

public class SearchInfo {
	
	private String iSortCol ;//排序字段名
	private String sSortDir_0 ;//asc 或 desc
	
	private String sSearch;//搜索条件
	
	
	private String limit;
	
	private String page;
	
	private String functionId;//工作流所关联的菜单id
	
	private String userIds;//工作流第一步审批选择的审批人id，如"id1,id2,id3"
	
	public String getFunctionId() {
		return functionId;
	}
	public void setFunctionId(String functionId) {
		this.functionId = functionId;
	}
	
	public String getUserIds() {
		return userIds;
	}
	public void setUserIds(String userIds) {
		this.userIds = userIds;
	}
	public String getsSearch() {
		return sSearch;
	}
	public void setsSearch(String sSearch) {
		this.sSearch = sSearch;
	}
	public String getiSortCol() {
		
		return iSortCol;
	}
	public void setiSortCol(String iSortCol) {
		
		this.iSortCol = stringChange(iSortCol);
	}
	public String getsSortDir_0() {
		return sSortDir_0;
	}
	public void setsSortDir_0(String sSortDir_0) {
		this.sSortDir_0 = sSortDir_0;
	}
	 
	
	

	public String getLimit() {
		return limit;
	}

	public void setLimit(String limit) {
		this.limit = limit;
	}

	public String getPage() {
		return page;
	}

	public void setPage(String page) {
		this.page = page;
	}
	
	

	
	//驼峰转下划线+小写
    @SuppressWarnings({ "unused", "static-access" })
	private  String stringChange(String s) {
    	StringBuilder sb = null;
    	if(s == null || s=="" ||s.trim()==""){
    		return s;
    	}else{
    		for (int i = 0; i < s.length(); i++) {
                if (Character.isUpperCase(s.charAt(i))) {
                	
                  s = s.replace(s.charAt(i), s.valueOf(s.charAt(i)).toLowerCase().charAt(0)) ;

                  sb = new StringBuilder(s);

                  sb.insert(i, "_");
                }
            }
           
            return (sb != null)? sb.toString() :s;
    	}
        
        
    }
}
