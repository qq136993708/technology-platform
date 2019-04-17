package com.pcitc.base.stp.budget.vo;

import java.util.HashMap;

/**
 * 
 * @author uuy
 *
 */
public class SplitItemVo extends HashMap<String, Object>
{
	/**
	 * 
	 */
	private static final long serialVersionUID = -848381741074059742L;
	
	public SplitItemVo(String code,Object total, Object jz, Object xq) {
		super();
		put(code+"_total", total==null?0:total);
		put(code+"_jz", jz==null?0:jz);
		put(code+"_xq", xq==null?0:xq);
	}
	public SplitItemVo(String key,Object val) {
		super();
		put(key,val);
	}
}
