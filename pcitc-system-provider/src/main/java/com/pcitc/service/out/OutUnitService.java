package com.pcitc.service.out;

import java.util.List;

import com.pcitc.base.stp.out.OutUnit;

public interface OutUnitService {

	public int insertOutUnitBatch(List<OutUnit> list, String deleteFlag);
	
	/**
	 * @param list
	 * 批量修改数据
	 */
	public int updateUnitDataBatch(List<OutUnit> list);
	/**
	 * 
	 * @return
	 */
	public List<OutUnit> selectByDefine1(String define1);
	/**
	 * 
	 * @return
	 */
	public List<OutUnit> selectByDefine2(String define2);
	/**
	 * 
	 * @return
	 */
	public List<OutUnit> selectByDefine3(String define3);
	
}
