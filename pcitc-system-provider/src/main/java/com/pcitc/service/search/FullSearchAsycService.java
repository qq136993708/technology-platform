package com.pcitc.service.search;

import com.pcitc.base.common.LayuiTableData;
import com.pcitc.base.common.LayuiTableParam;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.concurrent.Future;

public interface FullSearchAsycService {
    public Future<LayuiTableData> getTableDataScientific(LayuiTableParam param);
    public Future<LayuiTableData> getTableDataAchivement(LayuiTableParam param);
    public Future<LayuiTableData> getTableDataReport(LayuiTableParam param);
    public Future<LayuiTableData> getOutRewardListPage(LayuiTableParam param);
    public Future<LayuiTableData> getEquipmentListPage(LayuiTableParam param_common) throws Exception;
    Future<LayuiTableData> findTfmTypeByPage(LayuiTableParam param);
    public Future<LayuiTableData>  selectZjkBaseInfoByPage(@RequestBody LayuiTableParam param);
    public Future<LayuiTableData> selectZjkZhuanliByPage(@RequestBody LayuiTableParam param);
}
