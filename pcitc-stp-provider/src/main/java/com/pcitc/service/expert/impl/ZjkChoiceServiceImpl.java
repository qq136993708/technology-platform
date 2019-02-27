package com.pcitc.service.expert.impl;

import com.alibaba.fastjson.JSONObject;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.pcitc.base.common.LayuiTableData;
import com.pcitc.base.common.LayuiTableParam;
import com.pcitc.base.common.enums.DataOperationStatusEnum;
import com.pcitc.base.common.enums.DelFlagEnum;
import com.pcitc.base.common.TreeNode;
import com.pcitc.base.expert.*;
import com.pcitc.base.expert.ZjkChoiceExample;
import com.pcitc.base.util.IdUtil;
import com.pcitc.base.util.StrUtil;
import com.pcitc.base.util.TreeNodeUtil;
import com.pcitc.mapper.expert.ZjkChoiceMapper;
import com.pcitc.service.expert.ZjkBaseInfoService;
import com.pcitc.service.expert.ZjkChoiceService;
import com.pcitc.service.feign.SystemRemoteClient;
import org.apache.commons.lang3.StringUtils;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * <p>接口实现类</p>
 * <p>Table: zjk_choice - 专家-人员选择</p>
 *
 * @since 2018-12-08 04:10:47
 */
@Service("zjkChoiceService")
@Transactional(propagation = Propagation.REQUIRED, readOnly = false, rollbackFor = Exception.class)
public class ZjkChoiceServiceImpl implements ZjkChoiceService {

    @Autowired
    private ZjkChoiceMapper zjkChoiceMapper;

    @Autowired
    private ZjkBaseInfoService zjkBaseInfoService;

    public List<ZjkChoice> findZjkChoiceList(ZjkChoice zjkChoice) {
        List<ZjkChoice> record = zjkChoiceMapper.findZjkChoiceList(zjkChoice);
        return record;
    }

    public List<ZjkExpert> findZjkBaseInofList(List<String> ids) {
        ZjkExpertExample example = new ZjkExpertExample();
        example.createCriteria().andDataIdIn(ids);
        List<ZjkExpert> list = zjkBaseInfoService.selectByExample(example);
        return list;
    }

    @Override
    public int updateOrInsertZjkChoice(ZjkChoice zjkChoice) throws Exception {
        int result = 500;
        if (zjkChoice.getId() != null && zjkChoice.getId() != null) {
            zjkChoiceMapper.updateByPrimaryKeySelective(zjkChoice);
        } else {
            zjkChoice.setId(IdUtil.createIdByTime());
            zjkChoiceMapper.insertSelective(zjkChoice);
        }
        result = 200;
        return result;
    }

    @Override
    public int updateOrInsertZjkChoiceUpdate(ZjkChoice zjkChoice) throws Exception {
        int result = 500;
        ZjkChoice choice = new ZjkChoice();
        choice.setZjId(zjkChoice.getZjId());
        choice.setAddUserId(zjkChoice.getAddUserId());
        List<ZjkChoice> zjkChoiceList = this.findZjkChoiceList(choice);
        if (zjkChoiceList != null && zjkChoiceList.size() > 0) {
            for (int i = 0; i < zjkChoiceList.size(); i++) {
                this.deleteByPrimaryKey(zjkChoiceList.get(i).getId());
            }
        }
        if (zjkChoice.getId() != null && zjkChoice.getId() != null) {
            zjkChoiceMapper.updateByPrimaryKeySelective(zjkChoice);
        } else {
            zjkChoice.setId(IdUtil.createIdByTime());
            zjkChoiceMapper.insertSelective(zjkChoice);
        }
        result = 200;
        return result;
    }

    @Override
    public int deleteZjkChoiceById(String id) throws Exception {
        int result = 500;
        if (id != null) {
            zjkChoiceMapper.deleteByPrimaryKey(id);
        }
        result = 200;
        return result;
    }

    @Override
    public ZjkChoice getZjkChoiceInfo(String id) throws Exception {

        return zjkChoiceMapper.selectByPrimaryKey(id);
    }

    @Override
    public long countByExample(ZjkChoiceExample example) {
        return zjkChoiceMapper.countByExample(example);
    }

    @Override
    public int deleteByExample(ZjkChoiceExample example) {
        return zjkChoiceMapper.deleteByExample(example);
    }

    @Override
    public int deleteByPrimaryKey(String recordId) {
        return zjkChoiceMapper.deleteByPrimaryKey(recordId);
    }

    @Override
    public Integer deleteZjkChoiceReal(String recordId) {
        return zjkChoiceMapper.deleteByPrimaryKey(recordId);
    }

    @Override
    public int insert(ZjkChoice record) {
        record.setId(IdUtil.createIdByTime());
        return zjkChoiceMapper.insert(record);
    }

    @Override
    public int insertSelective(ZjkChoice record) {
        return zjkChoiceMapper.insertSelective(record);
    }

    public ZjkChoice insertObject(ZjkChoice record) {
        this.insert(record);
        return record;
    }

    @Override
    public List<ZjkChoice> selectByExample(ZjkChoiceExample example) {
        return zjkChoiceMapper.selectByExample(example);
    }

    @Override
    public ZjkChoice selectByPrimaryKey(String recordId) {
        return zjkChoiceMapper.selectByPrimaryKey(recordId);
    }

    @Override
    public int updateByExampleSelective(@Param("record") ZjkChoice record, @Param("example") ZjkChoiceExample example) {
        return zjkChoiceMapper.updateByExampleSelective(record, example);
    }

    @Override
    public int updateByExample(@Param("record") ZjkChoice record, @Param("example") ZjkChoiceExample example) {
        return zjkChoiceMapper.updateByExample(record, example);
    }

    @Override
    public int updateByPrimaryKeySelective(ZjkChoice record) {
        return zjkChoiceMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(ZjkChoice record) {
        if (record.getStatus() == null) {
            record.setStatus("");
        }
        return zjkChoiceMapper.updateByPrimaryKey(record);
    }

    @Override
    public Integer deleteZjkChoice(Serializable zjkChoiceId) {
        try {
            ZjkChoice record = zjkChoiceMapper.selectByPrimaryKey(zjkChoiceId.toString());
            if (record != null) {
                record.setStatus(DelFlagEnum.STATUS_DEL.getCode() + "");
                zjkChoiceMapper.updateByPrimaryKey(record);
            }
            return Integer.parseInt(String.valueOf(DataOperationStatusEnum.DEL_OK));
        } catch (Exception e) {
            return Integer.parseInt(String.valueOf(DataOperationStatusEnum.DEL_DATA_ERROR));
        }
    }

    @Override
    public LayuiTableData findZjkChoiceByPageChoice(LayuiTableParam param) {
        ZjkChoiceExample example = new ZjkChoiceExample();
        ZjkChoiceExample.Criteria c = example.createCriteria();
//        c.andStatusEqualTo("1");

        c.andStatusEqualTo(param.getParam().get("status").toString());

        Object adduserId = param.getParam().get("addUserId");
        if(!StrUtil.isObjectEmpty(adduserId)){
            c.andAddUserIdEqualTo(adduserId.toString());
        }

        Object projectId = param.getParam().get("projectId");
        if(!StrUtil.isObjectEmpty(projectId)){
            c.andXmIdEqualTo(projectId.toString());
        }

        Object xmName = param.getParam().get("xmName");
        if(!StrUtil.isObjectEmpty(projectId)){
            c.andXmNameEqualTo(xmName.toString());
        }
//        Object xmName = param.getParam().get("xmName");
//        if(!StrUtil.isObjectEmpty(projectId)){
//            c.andXmNameEqualTo(xmName.toString());
//        }

        example.setOrderByClause("create_date desc");
        return this.findByExample(param, example);

    }

    @Override
    public LayuiTableData findZjkChoiceByPage(LayuiTableParam param) {
        ZjkChoiceExample example = new ZjkChoiceExample();
        ZjkChoiceExample.Criteria c = example.createCriteria();
//        c.andStatusEqualTo("1");

        c.andStatusEqualTo(param.getParam().get("status").toString());

        Object adduserId = param.getParam().get("addUserId");
        if(!StrUtil.isObjectEmpty(adduserId)){
            c.andAddUserIdEqualTo(adduserId.toString());
        }

        Object projectId = param.getParam().get("projectId");
        if(!StrUtil.isObjectEmpty(projectId)){
            c.andXmIdEqualTo(projectId.toString());
        }
        example.setOrderByClause("create_date desc");

        List<ZjkChoice> zjkChoices = this.selectByExample(example);
        if (zjkChoices == null || zjkChoices.size() == 0) {
            return new LayuiTableData();
        } else {

            ZjkExpertExample ex = new ZjkExpertExample();
            List<String> strings = zjkChoices.stream().map(ZjkChoice::getZjId).collect(Collectors.toList());
            ex.createCriteria().andDataIdIn(strings);
            List<ZjkExpert> list = zjkBaseInfoService.selectByExample(ex);

            LayuiTableData data = new LayuiTableData();
            data.setData(list);

            return data;
        }

//        return zjkBaseInfoService.findByExample(param, ex);

    }

    /**
     * 根据条件分页搜索
     *
     * @param param
     * @param example
     * @return
     */
    private LayuiTableData findByExample(LayuiTableParam param, ZjkChoiceExample example) {
        int pageSize = param.getLimit();
        int pageStart = (param.getPage() - 1) * pageSize;
        int pageNum = pageStart / pageSize + 1;
        PageHelper.startPage(pageNum, pageSize);
        List<ZjkChoice> list = zjkChoiceMapper.selectByExample(example);
        // 3、获取分页查询后的数据
        PageInfo<ZjkChoice> pageInfo = new PageInfo<ZjkChoice>(list);
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
        ZjkChoiceExample example = new ZjkChoiceExample();
        example.getOredCriteria().add(example.createCriteria().andStatusNotEqualTo(DataOperationStatusEnum.DEL_OK.getStatusCode().toString()));
        List<ZjkChoice> records = zjkChoiceMapper.selectByExample(example);
        for (ZjkChoice record : records) {
            TreeNode node = new TreeNode();
            node.setId(record.getId());
            //            node.setLevelCode(record.getUnitLevel().toString());
            node.setParentId(record.getParentId());
            nodes.add(node);
        }
        //构建树形结构(从根节点开始的树形结构)

        ZjkChoiceExample zjkChoiceExample = new ZjkChoiceExample();
        String strParentId = zjkChoiceMapper.selectByExample(zjkChoiceExample).get(0).getId();
        List<TreeNode> orderNodes = TreeNodeUtil.getChildrenNode(strParentId, nodes);

        return orderNodes;
    }


    @Autowired
    private SystemRemoteClient systemRemoteClient;


    @Override
    public LayuiTableData getUserChoiceTableData(LayuiTableParam param) {
        LayuiTableData data = new LayuiTableData();
        Map<String, Object> map = param.getParam();
        String strProjectId = map.get("projectId").toString();//项目ID
        String strProjectConfigId = map.get("projectConfigId").toString();//项目阶段ID
        String strType = map.get("type").toString();//随机，固定，单位

        //获取项目配置内容
        ZjkExtractConfig zjkExtractConfigInfo = systemRemoteClient.getZjkExtractConfigInfo(strProjectConfigId);
        //根据配置，过滤专家列表
        String sql = "";
        ZjkExpertExample example = new ZjkExpertExample();
        ZjkExpertExample.Criteria c = example.createCriteria();
        c.andStatusEqualTo("0");
        c.andSysFlagEqualTo("0");
        c.andDelFlagEqualTo("0");
        String expertProfessional = zjkExtractConfigInfo.getExpertProfessional();
        if(!StrUtil.isEmpty(expertProfessional)){
//            c.andExpertProfessionalFieldIn(Arrays.asList(expertProfessional.split(",")));
        }
        String expertArea = zjkExtractConfigInfo.getExpertArea();
        if(!StrUtil.isEmpty(expertArea)){
//            c.andProvinceIn(Arrays.asList(expertArea.split(",")));
        }
//        随机选取：根据选择的项目阶段、专家人数，通过系统随机选取与该阶段对应的专家。
//        固定选取：按照阶段、技术领域、级别、职称等维度，直接在系统中选取专家。
//        单位选取：只选择某研究院，不指定具体专家，由研究院自行决定。
//        根据抽取条件以及系统设定的抽取规则进行自动专家抽取，其中抽取规则包括在职/退休专家抽取频率、专家在一年内允许被抽取到的次数、间隔频率、抽取权重、单位回避等。

        //判断类型
        if ("suiji".equals(strType)){
            String strCount = map.get("count").toString();//数量
            List<ZjkExpert> experts = zjkBaseInfoService.selectByExample(example);
            int[] s = StrUtil.randomCommon(0, experts.size(), Integer.parseInt(strCount));
            List<ZjkExpert> expertsData = new ArrayList<>();
            for (int i = 0; i < s.length; i++) {
                expertsData.add(experts.get(s[i]));
            }
            data.setData(expertsData);
        }else if ("guding".equals(strType)){
            data = zjkBaseInfoService.findByExample(param,example);
        }else {
            Object expertId = map.get("expertId");
            if(StrUtil.isObjectEmpty(expertId)){
                c.andDataIdIn(Arrays.asList(expertId.toString().split(",")));
            }
            data = zjkBaseInfoService.findByExample(param,example);
        }
        //返回
        return data;
    }
}