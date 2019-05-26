package com.pcitc.service.system.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.pcitc.base.common.LayuiTableData;
import com.pcitc.base.common.LayuiTableParam;
import com.pcitc.base.common.enums.DataOperationStatusEnum;
import com.pcitc.base.common.enums.DelFlagEnum;
import com.pcitc.base.common.TreeNode;
import com.pcitc.base.stp.out.*;
import com.pcitc.base.stp.techFamily.TechFamily;
import com.pcitc.base.system.*;
import com.pcitc.base.system.IndexOutProjectInfoExample;
import com.pcitc.base.util.IdUtil;
import com.pcitc.base.util.MyBeanUtils;
import com.pcitc.base.util.StrUtil;
import com.pcitc.base.util.TreeNodeUtil;
import com.pcitc.mapper.out.OutAppraisalMapper;
import com.pcitc.mapper.out.OutPatentMapper;
import com.pcitc.mapper.out.OutProjectInfoMapper;
import com.pcitc.mapper.system.IndexOutProjectInfoMapper;
import com.pcitc.service.out.OutAppraisalService;
import com.pcitc.service.system.IndexOutAppraisalService;
import com.pcitc.service.system.IndexOutPatentService;
import com.pcitc.service.system.IndexOutProjectInfoService;
import com.pcitc.web.feign.TechFamilyProviderClient;
import org.apache.commons.lang3.StringUtils;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import java.util.Date;
import java.util.stream.Collectors;

/**
 * <p>接口实现类</p>
 * <p>Table: index_out_project_info - 首页-科研项目</p>
 *
 * @since 2019-05-22 03:38:18
 */
@Service("indexOutProjectInfoService")
@Transactional(propagation = Propagation.REQUIRED, readOnly = false, rollbackFor = Exception.class)
public class IndexOutProjectInfoServiceImpl implements IndexOutProjectInfoService {

    @Autowired
    private IndexOutProjectInfoMapper indexOutProjectInfoMapper;

    public List<IndexOutProjectInfo> findIndexOutProjectInfoList(IndexOutProjectInfo indexOutProjectInfo) {
        List<IndexOutProjectInfo> record = indexOutProjectInfoMapper.findIndexOutProjectInfoList(indexOutProjectInfo);
        return record;
    }

    @Override
    public int updateOrInsertIndexOutProjectInfo(IndexOutProjectInfo indexOutProjectInfo) throws Exception {
        int result = 500;
        if (indexOutProjectInfo.getDataId() != null && indexOutProjectInfo.getDataId() != null) {
            indexOutProjectInfoMapper.updateByPrimaryKeySelective(indexOutProjectInfo);
        } else {
            indexOutProjectInfo.setDataId(IdUtil.createIdByTime());
            indexOutProjectInfoMapper.insertSelective(indexOutProjectInfo);
        }
        result = 200;
        return result;
    }

    @Override
    public int deleteIndexOutProjectInfoById(String id) throws Exception {
        int result = 500;
        if (id != null) {
            indexOutProjectInfoMapper.deleteByPrimaryKey(id);
        }
        result = 200;
        return result;
    }

    @Override
    public IndexOutProjectInfo getIndexOutProjectInfoInfo(String id) throws Exception {

        return indexOutProjectInfoMapper.selectByPrimaryKey(id);
    }

    @Override
    public long countByExample(IndexOutProjectInfoExample example) {
        return indexOutProjectInfoMapper.countByExample(example);
    }

    @Override
    public int deleteByExample(IndexOutProjectInfoExample example) {
        return indexOutProjectInfoMapper.deleteByExample(example);
    }

    @Override
    public int deleteByPrimaryKey(String recordId) {
        return indexOutProjectInfoMapper.deleteByPrimaryKey(recordId);
    }

    @Override
    public Integer deleteIndexOutProjectInfoReal(String recordId) {
        return indexOutProjectInfoMapper.deleteByPrimaryKey(recordId);
    }

    @Override
    public int insert(IndexOutProjectInfo record) {
        record.setDataId(IdUtil.createIdByTime());
        return indexOutProjectInfoMapper.insert(record);
    }

    @Override
    public int insertSelective(IndexOutProjectInfo record) {
        return indexOutProjectInfoMapper.insertSelective(record);
    }

    public IndexOutProjectInfo insertObject(IndexOutProjectInfo record) {
        this.insert(record);
        return record;
    }

    @Override
    public List<IndexOutProjectInfo> selectByExample(IndexOutProjectInfoExample example) {
        return indexOutProjectInfoMapper.selectByExample(example);
    }

    @Override
    public IndexOutProjectInfo selectByPrimaryKey(String recordId) {
        return indexOutProjectInfoMapper.selectByPrimaryKey(recordId);
    }

    @Override
    public int updateByExampleSelective(@Param("record") IndexOutProjectInfo record, @Param("example") IndexOutProjectInfoExample example) {
        return indexOutProjectInfoMapper.updateByExampleSelective(record, example);
    }

    @Override
    public int updateByExample(@Param("record") IndexOutProjectInfo record, @Param("example") IndexOutProjectInfoExample example) {
        return indexOutProjectInfoMapper.updateByExample(record, example);
    }

    @Override
    public int updateByPrimaryKeySelective(IndexOutProjectInfo record) {
        return indexOutProjectInfoMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(IndexOutProjectInfo record) {
        if (record.getStatus() == null) {
            record.setStatus("");
        }
        return indexOutProjectInfoMapper.updateByPrimaryKey(record);
    }

    @Override
    public Integer deleteIndexOutProjectInfo(Serializable indexOutProjectInfoId) {
        try {
            IndexOutProjectInfo record = indexOutProjectInfoMapper.selectByPrimaryKey(indexOutProjectInfoId.toString());
            if (record != null) {
                record.setStatus(DelFlagEnum.STATUS_DEL.getCode() + "");
                indexOutProjectInfoMapper.updateByPrimaryKey(record);
            }
            return Integer.parseInt(String.valueOf(DataOperationStatusEnum.DEL_OK));
        } catch (Exception e) {
            return Integer.parseInt(String.valueOf(DataOperationStatusEnum.DEL_DATA_ERROR));
        }
    }

    @Override
    public LayuiTableData findIndexOutProjectInfoByPage(LayuiTableParam param) {
        IndexOutProjectInfoExample example = new IndexOutProjectInfoExample();
        IndexOutProjectInfoExample.Criteria c = example.createCriteria();
        Object typeIndex = param.getParam().get("typeIndex");
        if (typeIndex != null) {
            c.andTypeIndexLike(typeIndex + "%");
        }
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
    private LayuiTableData findByExample(LayuiTableParam param, IndexOutProjectInfoExample example) {
        int pageSize = param.getLimit();
        int pageStart = (param.getPage() - 1) * pageSize;
        int pageNum = pageStart / pageSize + 1;

        Object type = param.getParam().get("type");
        if ("ry".equals(type)) {
            pageSize = 1000000000;
        }

        if ("fy".equals(type)) {
            pageSize = 1000000000;
        }
        PageHelper.startPage(pageNum, pageSize);
        List<IndexOutProjectInfo> list = indexOutProjectInfoMapper.selectByExample(example);
//        if("ry".equals(type)){
//            List<String> ryList = list.stream().map(ry ->(ry.getFzrxm())).collect(Collectors.toList());
//        }
//
//        if ("fy".equals(type)){
//            pageSize = 1000000000;
//        }

        // 3、获取分页查询后的数据
        PageInfo<IndexOutProjectInfo> pageInfo = new PageInfo<IndexOutProjectInfo>(list);
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
        IndexOutProjectInfoExample example = new IndexOutProjectInfoExample();
        //example.getOredCriteria().add(example.createCriteria().andStatusNotEqualTo(DataOperationStatusEnum.DEL_OK.getStatusCode().toString()));
        List<IndexOutProjectInfo> records = indexOutProjectInfoMapper.selectByExample(example);
        for (IndexOutProjectInfo record : records) {
            TreeNode node = new TreeNode();
            node.setId(record.getId());
            //            node.setLevelCode(record.getUnitLevel().toString());
            node.setParentId(record.getParentId());
            nodes.add(node);
        }
        //构建树形结构(从根节点开始的树形结构)

        IndexOutProjectInfoExample indexOutProjectInfoExample = new IndexOutProjectInfoExample();
        String strParentId = indexOutProjectInfoMapper.selectByExample(indexOutProjectInfoExample).get(0).getId();
        List<TreeNode> orderNodes = TreeNodeUtil.getChildrenNode(strParentId, nodes);

        return orderNodes;
    }

    @Autowired
    private TechFamilyProviderClient techFamilyProviderClient;
    @Autowired
    private OutProjectInfoMapper outProjectInfoMapper;

    @Override
    public void selectTfcToIndexProjectInfo() {
        this.deleteByExample(new IndexOutProjectInfoExample());
        TechFamily techFamily = new TechFamily();
        List<TechFamily> techFamilies = techFamilyProviderClient.selectTechFamilyTypeList(techFamily);
        for (int i = 0, j = techFamilies.size(); i < j; i++) {
            TechFamily tf = techFamilies.get(i);
            //查询项目表
            OutProjectInfoExample example = new OutProjectInfoExample();
            OutProjectInfoExample.Criteria criteria = example.createCriteria();
            criteria.andXmmcLike("%" + tf.getTypeName() + "%");
            List<OutProjectInfo> records = outProjectInfoMapper.selectByExample(example);
            //插入index项目表
            if (records == null || records.size() == 0) {
                continue;
            }
            for (int k = 0; k < records.size(); k++) {
                IndexOutProjectInfo indexOutProjectInfo = new IndexOutProjectInfo();
                MyBeanUtils.copyProperties(records.get(k), indexOutProjectInfo);
                indexOutProjectInfo.setTypeCode(tf.getTypeCode());
                indexOutProjectInfo.setTypeName(tf.getTypeName());
                indexOutProjectInfo.setTfmTypeId(tf.getTfmTypeId());
                indexOutProjectInfo.setParentId(tf.getParentId());
                indexOutProjectInfo.setParentCode(tf.getParentCode());
                indexOutProjectInfo.setIsParent(tf.getIsParent());
                indexOutProjectInfo.setTypeIndex(tf.getTypeIndex());
                IndexOutProjectInfoExample e = new IndexOutProjectInfoExample();
                e.createCriteria().andXmidEqualTo(indexOutProjectInfo.getXmid());
                this.deleteByExample(e);
                this.insert(indexOutProjectInfo);
            }
        }
    }

    @Autowired
    private OutAppraisalMapper outAppraisalMapper;

    @Autowired
    private IndexOutAppraisalService indexOutAppraisalService;

    @Override
    public void selectAppraisalToIndexProjectInfo() {
        this.deleteByExample(new IndexOutProjectInfoExample());
        TechFamily techFamily = new TechFamily();
        List<TechFamily> techFamilies = techFamilyProviderClient.selectTechFamilyTypeList(techFamily);
        for (int i = 0, j = techFamilies.size(); i < j; i++) {
            TechFamily tf = techFamilies.get(i);
            //查询项目表
            OutAppraisalExample example = new OutAppraisalExample();
            OutAppraisalExample.Criteria criteria = example.createCriteria();
            criteria.andCgmcLike("%" + tf.getTypeName() + "%");
            List<OutAppraisal> records = outAppraisalMapper.selectByExample(example);
            //插入index项目表
            if (records == null || records.size() == 0) {
                continue;
            }
            for (int k = 0; k < records.size(); k++) {
                IndexOutAppraisal indexOutProjectInfo = new IndexOutAppraisal();
                MyBeanUtils.copyProperties(records.get(k), indexOutProjectInfo);
                indexOutProjectInfo.setTypeCode(tf.getTypeCode());
                indexOutProjectInfo.setTypeName(tf.getTypeName());
                indexOutProjectInfo.setTfmTypeId(tf.getTfmTypeId());
                indexOutProjectInfo.setParentId(tf.getParentId());
                indexOutProjectInfo.setParentCode(tf.getParentCode());
                indexOutProjectInfo.setIsParent(tf.getIsParent());
                indexOutProjectInfo.setTypeIndex(tf.getTypeIndex());
                IndexOutAppraisalExample e = new IndexOutAppraisalExample();
                e.createCriteria().andCgidEqualTo(indexOutProjectInfo.getCgid());
                indexOutAppraisalService.deleteByExample(e);
                indexOutAppraisalService.insert(indexOutProjectInfo);
            }
        }
    }

    @Autowired
    private OutPatentMapper outPatentMapper;

    @Autowired
    private IndexOutPatentService indexOutPatentService;

    @Override
    public void selectPatentToIndexProjectInfo() {
        this.deleteByExample(new IndexOutProjectInfoExample());
        TechFamily techFamily = new TechFamily();
        List<TechFamily> techFamilies = techFamilyProviderClient.selectTechFamilyTypeList(techFamily);
        for (int i = 0, j = techFamilies.size(); i < j; i++) {
            TechFamily tf = techFamilies.get(i);
            //查询项目表
            OutPatentExample example = new OutPatentExample();
            OutPatentExample.Criteria criteria = example.createCriteria();
            criteria.andFmmcLike("%" + tf.getTypeName() + "%");
            List<OutPatent> records = outPatentMapper.selectByExample(example);
            //插入index项目表
            if (records == null || records.size() == 0) {
                continue;
            }
            for (int k = 0; k < records.size(); k++) {
                IndexOutPatent indexOutProjectInfo = new IndexOutPatent();
                MyBeanUtils.copyProperties(records.get(k), indexOutProjectInfo);
                indexOutProjectInfo.setTypeCode(tf.getTypeCode());
                indexOutProjectInfo.setTypeName(tf.getTypeName());
                indexOutProjectInfo.setTfmTypeId(tf.getTfmTypeId());
                indexOutProjectInfo.setParentId(tf.getParentId());
                indexOutProjectInfo.setParentCode(tf.getParentCode());
                indexOutProjectInfo.setIsParent(tf.getIsParent());
                indexOutProjectInfo.setTypeIndex(tf.getTypeIndex());

//                IndexOutPatentExample e = new IndexOutPatentExample();
//                e.createCriteria().andSqhEqualTo(indexOutProjectInfo.getSqh());
//                indexOutPatentService.deleteByExample(e);
                indexOutPatentService.insert(indexOutProjectInfo);
            }
        }
    }
}