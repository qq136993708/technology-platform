package com.pcitc.service.report.impl;


import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.pcitc.base.common.LayuiTableData;
import com.pcitc.base.common.LayuiTableParam;
import com.pcitc.base.common.TreeNode;
import com.pcitc.base.common.enums.DataOperationStatusEnum;
import com.pcitc.base.common.enums.DelFlagEnum;
import com.pcitc.base.report.ReportColumn;
import com.pcitc.base.report.ReportColumnExample;
import com.pcitc.base.util.DateUtil;
import com.pcitc.base.util.IdUtil;
import com.pcitc.base.util.MyBeanUtils;
import com.pcitc.mapper.report.ReportColumnMapper;
import com.pcitc.service.report.ReportColumnService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.Map;


/**
 * <p>接口实现类</p>
 * <p>Table: report_column - 报表字段配置信息</p>
 *
 * @since 2018-08-03 10:29:19
 */
@Service("reportColumnService")
@Transactional(propagation = Propagation.REQUIRED, readOnly = false, rollbackFor = Exception.class)
public class ReportColumnServiceImpl implements ReportColumnService {

    @Autowired
    private ReportColumnMapper reportColumnMapper;

    public List<ReportColumn> findReportColumnList(ReportColumn reportColumn) {
        List<ReportColumn> record = reportColumnMapper.findReportColumnList(reportColumn);
        return record;
    }

    @Override
    public int updateOrInsertReportColumn(ReportColumn reportColumn) throws Exception {
        int result = 500;
        if (reportColumn.getId() != null && reportColumn.getId() != null) {
            reportColumnMapper.updateByPrimaryKey(reportColumn);
//            reportColumnMapper.updateByPrimaryKeySelective(reportColumn);
        } else {
            reportColumn.setId(IdUtil.createIdByTime());
            reportColumnMapper.insertSelective(reportColumn);
        }
        result = 200;
        return result;
    }

    @Override
    public int deleteReportColumnById(String id) throws Exception {
        int result = 500;
        if (id != null) {
            reportColumnMapper.deleteByPrimaryKey(id);
        }
        result = 200;
        return result;
    }

    @Override
    public ReportColumn getReportColumnInfo(String id) throws Exception {

        return reportColumnMapper.selectByPrimaryKey(id);
    }

    @Override
    public long countByExample(ReportColumnExample example) {
        return reportColumnMapper.countByExample(example);
    }

    @Override
    public int deleteByExample(ReportColumnExample example) {
        return reportColumnMapper.deleteByExample(example);
    }

    @Override
    public int deleteByPrimaryKey(String recordId) {
        return reportColumnMapper.deleteByPrimaryKey(recordId);
    }

    @Override
    public Integer deleteReportColumnReal(String recordId) {
        return reportColumnMapper.deleteByPrimaryKey(recordId);
    }

    @Override
    public int insert(ReportColumn record) {
        record.setId(IdUtil.createIdByTime());
        return reportColumnMapper.insert(record);
    }

    @Override
    public int insertSelective(ReportColumn record) {
        return reportColumnMapper.insertSelective(record);
    }

    public ReportColumn insertObject(ReportColumn record) {
        this.insert(record);
        return record;
    }

    @Override
    public List<ReportColumn> selectByExample(ReportColumnExample example) {
        return reportColumnMapper.selectByExample(example);
    }

    public int deleteReportColumnRealBatch(String reportColumncId){
        ReportColumnExample ex = new ReportColumnExample();
        ex.createCriteria().andReportConfigIdEqualTo(reportColumncId);
        return this.deleteByExample(ex);
    }

    @Override
    public ReportColumn selectByPrimaryKey(String recordId) {
        return reportColumnMapper.selectByPrimaryKey(recordId);
    }

    @Override
    public int updateByExampleSelective(@Param("record") ReportColumn record, @Param("example") ReportColumnExample example) {
        return reportColumnMapper.updateByExampleSelective(record, example);
    }

    @Override
    public int updateByExample(@Param("record") ReportColumn record, @Param("example") ReportColumnExample example) {
        return reportColumnMapper.updateByExample(record, example);
    }

    @Override
    public int updateByPrimaryKeySelective(ReportColumn record) {
        return reportColumnMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(ReportColumn record) {
        if (record.getStatus() == null) {
            record.setStatus("");
        }
        return reportColumnMapper.updateByPrimaryKey(record);
    }

    @Override
    public Integer deleteReportColumn(Serializable reportColumnId) {
        try {
            ReportColumn record = reportColumnMapper.selectByPrimaryKey(reportColumnId.toString());
            if (record != null) {
                record.setStatus(DelFlagEnum.STATUS_DEL.getCode() + "");
                reportColumnMapper.updateByPrimaryKey(record);
            }
            return Integer.parseInt(String.valueOf(DataOperationStatusEnum.DEL_OK.getStatusCode()));
        } catch (Exception e) {
            return Integer.parseInt(String.valueOf(DataOperationStatusEnum.DEL_DATA_ERROR.getStatusCode()));
        }
    }

    @Override
    public LayuiTableData findReportColumnByPage(LayuiTableParam param) {
        ReportColumnExample example = new ReportColumnExample();
        ReportColumnExample.Criteria c = example.createCriteria();
        if (param.getParam().get("reportConfigId") != null && !com.pcitc.common.StringUtils.isBlank(param.getParam().get("reportConfigId") + "")) {
            c.andReportConfigIdLike("%" + param.getParam().get("reportConfigId") + "%");
        }
        if (param.getParam().get("field") != null && !com.pcitc.common.StringUtils.isBlank(param.getParam().get("field") + "")) {
            c.andFieldLike("%" + param.getParam().get("field") + "%");
        }

        if (param.getParam().get("stype") != null && !com.pcitc.common.StringUtils.isBlank(param.getParam().get("stype") + "")) {
            c.andStypeEqualTo(param.getParam().get("stype").toString());
        }
        if (param.getParam().get("sfShow") != null && !com.pcitc.common.StringUtils.isBlank(param.getParam().get("sfShow") + "")) {
            c.andSfShowEqualTo(param.getParam().get("sfShow").toString());
        }
        if (param.getParam().get("sfShowlist") != null && !com.pcitc.common.StringUtils.isBlank(param.getParam().get("sfShowlist") + "")) {
            c.andSfShowlistEqualTo(param.getParam().get("sfShowlist").toString());
        }
        if ("1".equals(param.getParam().get("bak2"))) {
            c.andBak2NotEqualTo("");
        }
        if (param.getParam().get("sfX") != null && !com.pcitc.common.StringUtils.isBlank(param.getParam().get("sfX") + "")) {
            c.andSfXEqualTo(param.getParam().get("sfX").toString());
        }
//        c.andStatusEqualTo("1");
//        if(param.getParam().get("fileKind") !=null && !com.pcitc.common.StringUtils.isBlank(param.getParam().get("fileKind")+""))
//        {
        //   c.andIdLike("'%"+param.getParam().get("fileKind")+"%'");
//            ReportColumnExample.Criteria criteria2 = example.or();
//            criteria2.andParentIdEqualTo(param.getParam().get("fileKind").toString());
//            example.or(criteria2);
        //       }
        example.setOrderByClause("create_date desc");
        return this.findByExample(param, example);

    }

    /**
     * 根据条件分页搜索
     *
     * @param param
     * @param example
     * @return
     */
    private LayuiTableData findByExample(LayuiTableParam param, ReportColumnExample example) {
        int pageSize = param.getLimit();
        int pageStart = (param.getPage() - 1) * pageSize;
        int pageNum = pageStart / pageSize + 1;
        PageHelper.startPage(pageNum, pageSize);
        List<ReportColumn> list = reportColumnMapper.selectByExample(example);
        // 3、获取分页查询后的数据
        PageInfo<ReportColumn> pageInfo = new PageInfo<ReportColumn>(list);
        LayuiTableData data = new LayuiTableData();
        data.setData(pageInfo.getList());
        Long total = pageInfo.getTotal();
        data.setCount(total.intValue());
        return data;
    }

    /**
     * 树形菜单
     *
     * @return
     */
    @Override
    public List<TreeNode> selectObjectByTree() {
        List<TreeNode> list = null;
        try {
            list = reportColumnMapper.selectTrees();
            TreeNode treeNode = new TreeNode();
            treeNode.setOpen("true");
            treeNode.setId("1");
            treeNode.setText("根节点");
            treeNode.setName("根节点");
            treeNode.setIsParent(true);
            list.add(treeNode);
            for (int i = 0; i < list.size(); i++) {
                TreeNode tree = list.get(i);
                if (tree.getLevelCode() < 10) {
                    tree.setOpen("true");
                } else {
                    tree.setOpen("false");
                }
            }
//            list = TreeNodeUtil.getChildrenNode("1", sysFileKindMapper.selectTrees());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    public JSONObject getReportPageConfig(String id) {
        JSONObject retJson = new JSONObject();
        try {
            ReportColumn reportColumn = new ReportColumn();
            reportColumn.setReportConfigId(id);
            reportColumn.setSfDel("0");
            reportColumn.setSfUse("0");//添加启用/禁用状态
            reportColumn.setiSortCol("ssort");
            reportColumn.setsSortDir_0(" asc");
            List<ReportColumn> list = this.findReportColumnList(reportColumn);
            JSONArray wd_obj_array = new JSONArray();
            JSONArray zb_obj_array = new JSONArray();
            JSONArray wd_show_obj_array = new JSONArray();
            JSONArray wd_hide_obj_array = new JSONArray();
            JSONArray zb_show_obj_array = new JSONArray();
            JSONArray zb_hide_obj_array = new JSONArray();
            JSONArray default_wd_zb_obj_array = new JSONArray();
            JSONArray default_wd_zb_obj_array_temp = new JSONArray();
            JSONArray default_x_obj_array = new JSONArray();
            JSONArray default_column_obj_array = new JSONArray();
            for (int i = 0; i < list.size(); i++) {
                ReportColumn column = list.get(i);

                String strField = column.getField().toUpperCase();
                String strAlign = column.getAlign();
                JSONObject jsonObject = new JSONObject();
                jsonObject.put("field",strField);
                jsonObject.put("title",column.getTitle());
                jsonObject.put("align",strAlign);
                if ("0".equals(column.getStype())) {
                    //维度，字符串json数组var G0BK = {field: 'G0BK', title: '板块'};
                    JSONObject wd_obj = new JSONObject();
                    wd_obj.put(strField.toUpperCase(), jsonObject);
                    wd_obj_array.add(wd_obj);
                    if ("1".equals(column.getSfShow())) {
                        //维度，显示的json数组
                        JSONObject wd_show_obj = new JSONObject();
                        wd_show_obj.put(strField.toUpperCase(), jsonObject);

//                        wd_show_obj.put(strField.toUpperCase(), "{field:" + strField + ",title:" + column.getTitle() + ",align:" + strAlign + "}");
                        wd_show_obj_array.add(wd_show_obj);
                    } else {
                        //维度，隐藏的json数组
                        JSONObject wd_hide_obj = new JSONObject();
                        wd_hide_obj.put(strField.toUpperCase(), jsonObject);
//                        wd_hide_obj.put(strField.toUpperCase(), "{field:" + strField + ",title:" + column.getTitle() + ",align:" + strAlign + "}");
                        wd_hide_obj_array.add(wd_hide_obj);
                    }
                } else {
                    //指标，字符串json数组
                    JSONObject zb_obj = new JSONObject();
//                    zb_obj.put(strField.toUpperCase(), "{field:" + strField + ",title:" + column.getTitle() + ",align:" + strAlign + "}");
                    zb_obj.put(strField.toUpperCase(), jsonObject);
                    zb_obj_array.add(zb_obj);
                    if ("1".equals(column.getSfShow())) {
                        //指标，显示的json数组
                        JSONObject zb_show_obj = new JSONObject();
                        zb_show_obj.put(strField.toUpperCase(), jsonObject);
//                        zb_show_obj.put(strField.toUpperCase(), "{field:" + strField + ",title:" + column.getTitle() + ",align:" + strAlign + "}");
                        zb_show_obj_array.add(zb_show_obj);
                    } else {
                        //指标，隐藏的json数组
                        JSONObject zb_hide_obj = new JSONObject();
//                        zb_hide_obj.put(strField.toUpperCase(), "{field:" + strField + ",title:" + column.getTitle() + ",align:" + strAlign + "}");
                        zb_hide_obj.put(strField.toUpperCase(), jsonObject);
                        zb_hide_obj_array.add(zb_hide_obj);
                    }
                }
                if ("1".equals(column.getSfShowlist())) {
                    //默认列表维度，指标
                    if ("0".equals(column.getStype())) {
                        JSONObject default_wd_obj = new JSONObject();
                        default_wd_obj.put(strField, "0");
                        default_wd_zb_obj_array.add(default_wd_obj);
                    } else {
                        JSONObject default_zb_obj = new JSONObject();
                        default_zb_obj.put(strField, "1");
                        default_wd_zb_obj_array_temp.add(default_zb_obj);
                    }
                }
                if ("1".equals(column.getSfX())) {
                    //默认图表X轴
                    JSONObject default_x_obj = new JSONObject();
                    default_x_obj.put(strField, strField);
                    default_x_obj_array.add(default_x_obj);
                }
                if (column.getBak1() != null && !"".equals(column.getBak1())) {
                    //字段默认值：设置
                    JSONObject default_column_obj = new JSONObject();
                    default_column_obj.put("var " + strField, "=" + column.getBak1() + ";");
                    default_column_obj_array.add(default_column_obj);
                }
            }
            retJson.put("wd_obj_array", wd_obj_array);
            retJson.put("zb_obj_array", zb_obj_array);
            retJson.put("wd_show_obj_array", wd_show_obj_array);
            retJson.put("wd_hide_obj_array", wd_hide_obj_array);
            retJson.put("zb_show_obj_array", zb_show_obj_array);
            retJson.put("zb_hide_obj_array", zb_hide_obj_array);
            retJson.put("default_wd_zb_obj_array", this.joinJSONArray(default_wd_zb_obj_array, default_wd_zb_obj_array_temp));
            retJson.put("default_x_obj_array", default_x_obj_array);
            retJson.put("default_column_obj_array", default_column_obj_array);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return retJson;
    }

    /**
     * JSONARRAY数组合并
     *
     * @param mData
     * @param array
     * @return
     */
    public JSONArray joinJSONArray(JSONArray mData, JSONArray array) {
        StringBuffer buffer = new StringBuffer();
        JSONArray jsonArray = new JSONArray();
        try {
            int len = mData.size();
            for (int i = 0; i < len; i++) {
                jsonArray.add(mData.get(i));
            }
            len = array.size();
            for (int i = 0; i < len; i++) {
                jsonArray.add(array.get(i));
            }
        } catch (Exception e) {

        }
        return jsonArray;
    }

    public JSONObject saveReportColumnList(String paramsJson,String paramscolumnconfig) {
        JSONObject jsonObject = new JSONObject();
        try {
            System.out.println("paramsJson = " + paramsJson);
            System.out.println("paramscolumnconfig = " + paramscolumnconfig);
            List mapParam = JSONArray.parseArray(paramsJson);
            Map<String,String> mapConfig = JSONObject.parseObject(paramscolumnconfig, Map.class);
            String strConfigId = mapConfig.get("id").toString();
            String strConfigCreateUser = mapConfig.get("createUser").toString();
            for (int i = 0; i < mapParam.size(); i++) {
                Map<String, Object> map = (Map<String, Object>) mapParam.get(i);
                ReportColumn reportColumn = new ReportColumn();
                reportColumn.setReportConfigId(strConfigId);
                reportColumn.setSfDel("0");
                reportColumn.setTitle(map.get("DIMENSION_CAPTION").toString());
                reportColumn.setField(map.get("DIMENSION_NAME").toString());
                Object strDesc = map.get("DIMENSION_NAME");
                if((strDesc==null?"":strDesc.toString()).indexOf("K0")>-1){
                    reportColumn.setAlign("right");
                    reportColumn.setStype("1");
                }else {
                    reportColumn.setAlign("left");
                    reportColumn.setStype("0");
                }
                reportColumn.setSfShowlist("0");
                reportColumn.setSfX("0");
                reportColumn.setSfY("");
                reportColumn.setSfUse("0");
                reportColumn.setSfAjax("");
                reportColumn.setSsort((i+1)+"");
                reportColumn.setSfShow("0");
                reportColumn.setCreateUser(strConfigCreateUser);
                reportColumn.setCreateDate(DateUtil.format(new Date(), DateUtil.FMT_SS));
                reportColumn.setStatus("0");
                this.insert(reportColumn);
            }
            jsonObject.put("msg", "");
        } catch (Exception e) {
            jsonObject.put("msg", "error");
            e.printStackTrace();
        }
        return new JSONObject();
    }
}