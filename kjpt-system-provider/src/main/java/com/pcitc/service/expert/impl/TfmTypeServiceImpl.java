package com.pcitc.service.expert.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.pcitc.base.common.LayuiTableData;
import com.pcitc.base.common.LayuiTableParam;
import com.pcitc.base.common.enums.DataOperationStatusEnum;
import com.pcitc.base.common.enums.DelFlagEnum;
import com.pcitc.base.common.TreeNode;
import com.pcitc.base.expert.*;
import com.pcitc.base.expert.TfmTypeExample;
import com.pcitc.base.util.IdUtil;
import com.pcitc.base.util.MyBeanUtils;
import com.pcitc.base.util.TreeNodeUtil;
import com.pcitc.mapper.expert.TfmTypeMapper;
import com.pcitc.service.expert.TfmTypeService;
import com.pcitc.service.search.FullSearchService;
import com.pcitc.service.system.IndexOutAppraisalService;
import com.pcitc.service.system.IndexOutPatentService;
import com.pcitc.service.system.IndexOutProjectInfoService;
import org.apache.commons.lang3.StringUtils;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <p>接口实现类</p>
 * <p>Table: tfm_type - </p>
 *
 * @since 2019-01-16 02:47:25
 */
@Service("tfmTypeService")
@Transactional(propagation = Propagation.REQUIRED, readOnly = false, rollbackFor = Exception.class)
public class TfmTypeServiceImpl implements TfmTypeService {

    @Autowired
    private TfmTypeMapper tfmTypeMapper;

    public List<TfmType> findTfmTypeList(TfmType tfmType) {
        List<TfmType> record = tfmTypeMapper.findTfmTypeList(tfmType);
        return record;
    }

    @Override
    public int updateOrInsertTfmType(TfmType tfmType) throws Exception {
        int result = 500;
        if (tfmType.getTfmTypeId() != null && tfmType.getTfmTypeId() != null) {
            tfmTypeMapper.updateByPrimaryKeySelective(tfmType);
        } else {
            tfmType.setTfmTypeId(IdUtil.createIdByTime());
            tfmTypeMapper.insertSelective(tfmType);
        }
        result = 200;
        return result;
    }

    @Override
    public int deleteTfmTypeById(String id) throws Exception {
        int result = 500;
        if (id != null) {
            tfmTypeMapper.deleteByPrimaryKey(id);
        }
        result = 200;
        return result;
    }

    @Override
    public TfmType getTfmTypeInfo(String id) throws Exception {

        return tfmTypeMapper.selectByPrimaryKey(id);
    }

    @Override
    public long countByExample(TfmTypeExample example) {
        return tfmTypeMapper.countByExample(example);
    }

    @Override
    public int deleteByExample(TfmTypeExample example) {
        return tfmTypeMapper.deleteByExample(example);
    }

    @Override
    public int deleteByPrimaryKey(String recordId) {
        return tfmTypeMapper.deleteByPrimaryKey(recordId);
    }

    @Override
    public Integer deleteTfmTypeReal(String recordId) {
        return tfmTypeMapper.deleteByPrimaryKey(recordId);
    }

    @Override
    public int insert(TfmType record) {
        record.setTfmTypeId(IdUtil.createIdByTime());
        return tfmTypeMapper.insert(record);
    }

    @Override
    public int insertSelective(TfmType record) {
        return tfmTypeMapper.insertSelective(record);
    }

    public TfmType insertObject(TfmType record) {
        this.insert(record);
        return record;
    }

    @Override
    public List<TfmType> selectByExample(TfmTypeExample example) {
        return tfmTypeMapper.selectByExample(example);
    }

    @Override
    public TfmType selectByPrimaryKey(String recordId) {
        return tfmTypeMapper.selectByPrimaryKey(recordId);
    }

    @Override
    public int updateByExampleSelective(@Param("record") TfmType record, @Param("example") TfmTypeExample example) {
        return tfmTypeMapper.updateByExampleSelective(record, example);
    }

    @Override
    public int updateByExample(@Param("record") TfmType record, @Param("example") TfmTypeExample example) {
        return tfmTypeMapper.updateByExample(record, example);
    }

    @Override
    public int updateByPrimaryKeySelective(TfmType record) {
        return tfmTypeMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(TfmType record) {
        if (record.getStatus() == null) {
            record.setStatus("");
        }
        return tfmTypeMapper.updateByPrimaryKey(record);
    }

    @Override
    public Integer deleteTfmType(Serializable tfmTypeId) {
        try {
            TfmType record = tfmTypeMapper.selectByPrimaryKey(tfmTypeId.toString());
            if (record != null) {
                record.setStatus(DelFlagEnum.STATUS_DEL.getCode() + "");
                tfmTypeMapper.updateByPrimaryKey(record);
            }
            return Integer.parseInt(String.valueOf(DataOperationStatusEnum.DEL_OK));
        } catch (Exception e) {
            return Integer.parseInt(String.valueOf(DataOperationStatusEnum.DEL_DATA_ERROR));
        }
    }

    @Autowired
    IndexOutAppraisalService indexOutAppraisalService;
    @Autowired
    IndexOutPatentService indexOutPatentService;
    @Autowired
    IndexOutProjectInfoService indexOutProjectInfoService;
    @Autowired
    FullSearchService fullSearchService;

    @Override
    public LayuiTableData findTfmTypeByPage(LayuiTableParam param) {
        TfmTypeExample example = new TfmTypeExample();
        TfmTypeExample.Criteria c = example.createCriteria();
        Object typeName = param.getParam().get("typeName");
        Object keyword = param.getParam().get("keyword");
        if (typeName != null && !"".equals(typeName)) {
            c.andTypeNameLike("%" + typeName + "%");
        }
        if (keyword != null && !"".equals(keyword)) {
            c.andTypeNameLike("%" + keyword + "%");
        }
        example.setOrderByClause("create_date desc");

        Object iscount = param.getParam().get("iscount");

        LayuiTableData data = this.findByExample(param, example);

        List<TfmType> tfmTypes = new ArrayList<>();

        Object keywords = param.getParam().get("keyword");
        if (keywords != null && !"".equals(keywords)) {
            List<Map<String, Object>> maps = (List<Map<String, Object>>) data.getData();
            for (int i = 0, j = maps.size(); i < j; i++) {
                TfmType tfmType = new TfmType();
                MyBeanUtils.transMap2Bean(maps.get(i), tfmType);
                tfmTypes.add(tfmType);
            }
        }else {
            tfmTypes = (List<TfmType>) data.getData();
        }

        if (iscount != null && "1".equals(iscount)) {
            for (int i = 0, j = tfmTypes.size(); i < j; i++) {
                Map map = new HashMap();
                map.put("typeIndex", tfmTypes.get(i).getTypeIndex());
                param.setParam(map);
                //获取项目数
                //获取成果数
                //获取专利数
                //获取人员数
                String strCount = indexOutProjectInfoService.findIndexOutProjectInfoByPage(param).getCount() + "|" + indexOutAppraisalService.findIndexOutAppraisalByPage(param).getCount() + "|" + indexOutPatentService.findIndexOutPatentByPage(param).getCount() + "|";
                map.put("type", "ry");
                param.setParam(map);
                LayuiTableData ry_data = indexOutProjectInfoService.findIndexOutProjectInfoByPageTreeIndex(param);
                tfmTypes.get(i).setRemarks(strCount + ry_data.getCount());
            }
            data.setData(tfmTypes);
        }
        return data;
    }

    /**
     * 根据条件分页搜索
     *
     * @param param
     * @param example
     * @return
     */
    private LayuiTableData findByExample(LayuiTableParam param, TfmTypeExample example) {
        int pageSize = param.getLimit();
        int pageStart = (param.getPage() - 1) * pageSize;
        int pageNum = pageStart / pageSize + 1;
        PageHelper.startPage(pageNum, pageSize);
        List<TfmType> list = tfmTypeMapper.selectByExample(example);
        // 3、获取分页查询后的数据
        PageInfo<TfmType> pageInfo = new PageInfo<TfmType>(list);
        LayuiTableData data = new LayuiTableData();
        Object keywords = param.getParam().get("keyword");
        if (keywords != null && !"".equals(keywords)) {
            data.setData(fullSearchService.setKeyWordCss(pageInfo, keywords.toString()));
        } else {
            data.setData(pageInfo.getList());
        }
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
        TfmTypeExample example = new TfmTypeExample();
        //example.getOredCriteria().add(example.createCriteria().andStatusNotEqualTo(DataOperationStatusEnum.DEL_OK.getStatusCode().toString()));
        List<TfmType> records = tfmTypeMapper.selectByExample(example);
        for (TfmType record : records) {
            TreeNode node = new TreeNode();
            node.setId(record.getId());
            //            node.setLevelCode(record.getUnitLevel().toString());
            node.setParentId(record.getParentId());
            nodes.add(node);
        }
        //构建树形结构(从根节点开始的树形结构)

        TfmTypeExample tfmTypeExample = new TfmTypeExample();
        String strParentId = tfmTypeMapper.selectByExample(tfmTypeExample).get(0).getId();
        List<TreeNode> orderNodes = TreeNodeUtil.getChildrenNode(strParentId, nodes);

        return orderNodes;
    }
}