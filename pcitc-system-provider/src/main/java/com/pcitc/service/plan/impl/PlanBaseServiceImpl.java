package com.pcitc.service.plan.impl;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.pcitc.base.common.LayuiTableData;
import com.pcitc.base.common.LayuiTableParam;
import com.pcitc.base.common.TreeNode;
import com.pcitc.base.common.enums.DataOperationStatusEnum;
import com.pcitc.base.common.enums.DelFlagEnum;
import com.pcitc.base.plan.PlanBase;
import com.pcitc.base.plan.PlanBaseExample;
import com.pcitc.base.system.StandardBase;
import com.pcitc.base.system.SysFile;
import com.pcitc.base.util.ExcelReadUtil;
import com.pcitc.base.util.IdUtil;
import com.pcitc.base.util.Point;
import com.pcitc.base.util.TreeNodeUtil;
import com.pcitc.mapper.plan.PlanBaseMapper;
import com.pcitc.service.plan.PlanBaseService;
import com.pcitc.service.system.StandardBaseService;
import com.pcitc.service.system.SysFileService;
import org.apache.ibatis.annotations.Param;
import org.olap4j.Axis;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.io.File;
import java.io.Serializable;
import java.util.*;

/**
 * <p>接口实现类</p>
 * <p>Table: plan_base - 工程签证申请</p>
 *
 * @since 2018-11-12 10:14:54
 */
@Service("planBaseService")
@Transactional(propagation = Propagation.REQUIRED, readOnly = false, rollbackFor = Exception.class)
public class PlanBaseServiceImpl implements PlanBaseService {

    @Autowired
    private PlanBaseMapper planBaseMapper;

    public List<PlanBase> findPlanBaseList(PlanBase planBase) {
        List<PlanBase> record = planBaseMapper.findPlanBaseList(planBase);
        return record;
    }

    @Override
    public int updateOrInsertPlanBase(PlanBase planBase) throws Exception {
        int result = 500;
        if (planBase.getId() != null && planBase.getId() != null) {
            planBaseMapper.updateByPrimaryKeySelective(planBase);
        } else {
            planBase.setId(IdUtil.createIdByTime());
            planBaseMapper.insertSelective(planBase);
        }
        result = 200;
        return result;
    }

    @Override
    public int deletePlanBaseById(String id) throws Exception {
        int result = 500;
        if (id != null) {
            planBaseMapper.deleteByPrimaryKey(id);
        }
        result = 200;
        return result;
    }

    @Override
    public PlanBase getPlanBaseInfo(String id) throws Exception {

        return planBaseMapper.selectByPrimaryKey(id);
    }

    @Override
    public long countByExample(PlanBaseExample example) {
        return planBaseMapper.countByExample(example);
    }

    @Override
    public int deleteByExample(PlanBaseExample example) {
        return planBaseMapper.deleteByExample(example);
    }

    @Override
    public int deleteByPrimaryKey(String recordId) {
        return planBaseMapper.deleteByPrimaryKey(recordId);
    }

    @Override
    public Integer deletePlanBaseReal(String recordId) {
        return planBaseMapper.deleteByPrimaryKey(recordId);
    }

    @Override
    public int insert(PlanBase record) {
        record.setId(IdUtil.createIdByTime());
        return planBaseMapper.insert(record);
    }

    @Override
    public int insertSelective(PlanBase record) {
        return planBaseMapper.insertSelective(record);
    }

    public PlanBase insertObject(PlanBase record) {
        this.insert(record);
        return record;
    }

    @Override
    public List<PlanBase> selectByExample(PlanBaseExample example) {
        return planBaseMapper.selectByExample(example);
    }

    @Override
    public PlanBase selectByPrimaryKey(String recordId) {
        return planBaseMapper.selectByPrimaryKey(recordId);
    }

    @Override
    public int updateByExampleSelective(@Param("record") PlanBase record, @Param("example") PlanBaseExample example) {
        return planBaseMapper.updateByExampleSelective(record, example);
    }

    @Override
    public int updateByExample(@Param("record") PlanBase record, @Param("example") PlanBaseExample example) {
        return planBaseMapper.updateByExample(record, example);
    }

    @Override
    public int updateByPrimaryKeySelective(PlanBase record) {
        return planBaseMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(PlanBase record) {
        if (record.getStatus() == null) {
            record.setStatus("");
        }
        return planBaseMapper.updateByPrimaryKey(record);
    }

    @Override
    public Integer deletePlanBase(Serializable planBaseId) {
        try {
            PlanBase record = planBaseMapper.selectByPrimaryKey(planBaseId.toString());
            if (record != null) {
                record.setStatus(DelFlagEnum.STATUS_DEL.getCode() + "");
                planBaseMapper.updateByPrimaryKey(record);
            }
            return Integer.parseInt(String.valueOf(DataOperationStatusEnum.DEL_OK));
        } catch (Exception e) {
            return Integer.parseInt(String.valueOf(DataOperationStatusEnum.DEL_DATA_ERROR));
        }
    }

    @Override
    public LayuiTableData findPlanBaseByPage(LayuiTableParam param) {
        PlanBaseExample example = new PlanBaseExample();
        PlanBaseExample.Criteria c = example.createCriteria();
//        c.andStatusEqualTo("1");
//        if(param.getParam().get("fileKind") !=null && !com.pcitc.common.StringUtils.isBlank(param.getParam().get("fileKind")+""))
//        {
        //   c.andIdLike("'%"+param.getParam().get("fileKind")+"%'");
//            PlanBaseExample.Criteria criteria2 = example.or();
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
    private LayuiTableData findByExample(LayuiTableParam param, PlanBaseExample example) {
        int pageSize = param.getLimit();
        int pageStart = (param.getPage() - 1) * pageSize;
        int pageNum = pageStart / pageSize + 1;
        PageHelper.startPage(pageNum, pageSize);
        List<PlanBase> list = planBaseMapper.selectByExample(example);
        // 3、获取分页查询后的数据
        PageInfo<PlanBase> pageInfo = new PageInfo<PlanBase>(list);
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
        List<TreeNode> nodes = new ArrayList<TreeNode>();
        PlanBaseExample example = new PlanBaseExample();
        example.getOredCriteria().add(example.createCriteria().andStatusNotEqualTo(DataOperationStatusEnum.DEL_OK.getStatusCode().toString()));
        List<PlanBase> records = planBaseMapper.selectByExample(example);
        for (PlanBase record : records) {
            TreeNode node = new TreeNode();
            node.setId(record.getId());
            //            node.setLevelCode(record.getUnitLevel().toString());
            node.setParentId(record.getParentId());
            nodes.add(node);
        }
        //构建树形结构(从根节点开始的树形结构)

        PlanBaseExample planBaseExample = new PlanBaseExample();
        String strParentId = planBaseMapper.selectByExample(planBaseExample).get(0).getId();
        List<TreeNode> orderNodes = TreeNodeUtil.getChildrenNode(strParentId, nodes);

        return orderNodes;
    }

    public List<PlanBase> selectSonPlanBasesByCreateUserId(JSONObject jsonObject) {
        Map<String, Object> map = new HashMap<>();
        map.put("createUserId", jsonObject.get("createUserId"));
        return planBaseMapper.selectSonPlanBasesByCreateUserId(map);
    }

    @Autowired
    private StandardBaseService standardBaseService;

    public static void main(String [] args) {

        File file = new File("D:\\files\\uploadPath\\file\\a5d3946e876744cc81f59891f417737d\\20190508113215292_file_16a957fb33c_6630fd93.xls");
//		File file = new File("D:\\group_total_data.xlsx");
        ExcelReadUtil util = new ExcelReadUtil();
        List<Map<Point,Object>> rss = null;
        try {
            rss = util.readExcelAllCellVal(file);
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println(rss);
      /*  ExcelReadUtil ImportExce = new ExcelReadUtil();

        List<Map<Point, Object>> maps = ImportExce.readExcelAllCellVal(new File("D:\\files\\uploadPath\\file\\a5d3946e876744cc81f59891f417737d\\20190508113215292_file_16a957fb33c_6630fd93.xls"));
        System.out.println(maps);*/
    }

    @Autowired
    private SysFileService sysFileService;
    public void importFileStandard(JSONObject jsonObject) {
        try {

            JSONArray jsArr = JSONObject.parseArray((String) jsonObject.get("fileList"));
            List<SysFile> sysFiles = JSONObject.parseArray(jsArr.toJSONString(), SysFile.class);
//            List<SysFile> sysFiles = (List<SysFile>) jsonObject.get("fileList");
            ExcelReadUtil ImportExce = new ExcelReadUtil();
            for (int a = 0; a < sysFiles.size(); a++) {
                System.out.println(sysFiles.get(a).getFilePath());
                List<Map<Point, Object>> maps = ImportExce.readExcelAllCellVal(new File("D:\\files\\uploadPath\\file\\a5d3946e876744cc81f59891f417737d\\20190508113215292_file_16a957fb33c_6630fd93.xls"));
//                List<Map<Point, Object>> maps = ImportExce.readExcelAllCellVal(new File(sysFiles.get(a).getFilePath()));

                if (maps==null){
                    continue;
                }
                for (int i = 0; i < maps.size(); i++) {
                    Map<Point, Object> pointObjectMap = maps.get(i);//sheet页
                    List<List<Object>> valByRow = new ExcelReadUtil().getValByRow(pointObjectMap);
                    for (int j = 0; j < valByRow.size(); j++) {
                        StandardBase standardBase = new StandardBase();
                        standardBase.setStandardName(valByRow.get(j).get(0).toString());
                        standardBase.setStandardDesc(valByRow.get(j).get(1).toString());
                        standardBase.setRemark(valByRow.get(j).get(2).toString());
                        standardBaseService.insert(standardBase);
                    }
                }
                //删除
//                sysFileService.deleteByPrimaryKey(sysFiles.get(a).getId());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}