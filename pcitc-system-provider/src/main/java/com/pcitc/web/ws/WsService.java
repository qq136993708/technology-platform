package com.pcitc.web.ws;

public interface WsService {

	public String GetList(String sqlstr);
	
	public String GetItem(String id);
	
	public String GetListByYear (String sqlstr);
}
