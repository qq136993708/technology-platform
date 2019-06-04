package com.pcitc.service.expert.impl;

import com.alibaba.fastjson.JSONArray;
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
import com.pcitc.base.util.DateUtil;
import com.pcitc.base.util.IdUtil;
import com.pcitc.base.util.StrUtil;
import com.pcitc.base.util.TreeNodeUtil;
import com.pcitc.mapper.expert.ZjkChoiceMapper;
import com.pcitc.service.expert.ZjkBaseInfoService;
import com.pcitc.service.expert.ZjkChoiceService;
import com.pcitc.service.expert.ZjkMsgConfigService;
import com.pcitc.service.expert.ZjkMsgService;
import com.pcitc.service.feign.SystemRemoteClient;
import com.pcitc.service.msg.MailSentService;
import com.pcitc.util.mail.MailSenderInfo;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.io.Serializable;
import java.util.*;
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
        if(record.getId()==null){
            record.setId(IdUtil.createIdByTime());
        }
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
        if (!StrUtil.isObjectEmpty(adduserId)) {
            c.andAddUserIdEqualTo(adduserId.toString());
        }

        Object projectId = param.getParam().get("projectId");
        if (!StrUtil.isObjectEmpty(projectId)) {
            c.andXmIdEqualTo(projectId.toString());
        }

        Object xmName = param.getParam().get("xmName");
        if (!StrUtil.isObjectEmpty(xmName)) {
            c.andXmNameLike("%"+xmName.toString()+"%");
        }
        Object bak1 = param.getParam().get("bak1");
        if (!StrUtil.isObjectEmpty(bak1)) {
            c.andBak1EqualTo(bak1.toString());
        }

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
        if (!StrUtil.isObjectEmpty(adduserId)) {
            c.andAddUserIdEqualTo(adduserId.toString());
        }

        Object projectId = param.getParam().get("projectId");
        if (!StrUtil.isObjectEmpty(projectId)) {
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

    @Autowired
    private MailSentService mailSentService;

    @Override
    public LayuiTableData getUserChoiceTableData(LayuiTableParam param) {
        LayuiTableData data = new LayuiTableData();
        Map<String, Object> map = param.getParam();
        String strProjectId = map.get("projectId").toString();//项目ID
        String strProjectConfigId = map.get("projectConfigId").toString();//项目阶段ID
        String strType = map.get("type").toString();//随机，固定，单位
        String unitId = map.get("unitId").toString();//机构id

        //获取项目配置内容
        ZjkExtractConfig zjkExtractConfigInfo = systemRemoteClient.getZjkExtractConfigInfo(strProjectConfigId);
        //根据配置，过滤专家列表
        String sql = "";
        ZjkExpertExample example = new ZjkExpertExample();
        ZjkExpertExample.Criteria c = example.createCriteria();
        c.andStatusEqualTo("0");
        c.andSysFlagEqualTo("0");
        c.andDelFlagEqualTo("0");
        c.andAuditStatusEqualTo("2");
        //专家职称
        String expertProfessional = zjkExtractConfigInfo.getExpertProfessional();
        if (!StrUtil.isEmpty(expertProfessional)) {
            c.andExpertProfessinalIn(Arrays.asList(expertProfessional.split(",")));
        }
        //抽取次数
        String expertCount = zjkExtractConfigInfo.getExpertCount();
        if (!"0".equals(expertCount)){
            ZjkMsgExample zjkMsgExample = new ZjkMsgExample();
            ZjkMsgExample.Criteria criteria = zjkMsgExample.createCriteria();
            criteria.andIsCompleteEqualTo("ROOT_UNIVERSAL_WEHTHER_YES");
            criteria.andStatusEqualTo(DateUtil.dateToStr(new Date(),DateUtil.FMT_YYYY));
            List<ZjkMsg> zjkMsgs = zjkMsgService.selectByExample(zjkMsgExample);
            Map<String, Long> collect = zjkMsgs.stream().collect(Collectors.groupingBy(ZjkMsg::getZjkId, Collectors.counting()));
            List<String> expertStrings = new ArrayList<>();
            for (Map.Entry<String,Long> entry:collect.entrySet()){
                if (entry.getValue()>Long.valueOf(expertCount)){
                    expertStrings.add(entry.getKey());
                }
            }
            if (expertStrings.size()>0){
                c.andDataIdNotIn(expertStrings);
            }
        }
        //区域范围
        String expertArea = zjkExtractConfigInfo.getExpertArea();
        if (!StrUtil.isEmpty(expertArea)) {
//            c.andProvinceIn(Arrays.asList(expertArea.split(",")));
        }
        //规避本院
        String companyAvoid = zjkExtractConfigInfo.getCompanyAvoid();
        if ("ROOT_UNIVERSAL_WEHTHER_YES".equals(companyAvoid)){
            c.andCompanyNotEqualTo(unitId);
        }
        //抽取人数不够的时候,给出提示,人数要凑够
        //判断类型
        if ("suiji".equals(strType)) {
            String strCount = map.get("count").toString();//数量

            Object expertProfessinal = param.getParam().get("expertProfessinal");
            if (!StrUtil.isObjectEmpty(expertProfessinal)) {
                c.andExpertProfessinalEqualTo(expertProfessinal.toString());
            }
            List<ZjkExpert> experts = zjkBaseInfoService.selectByExample(example);
            int count = Integer.parseInt(strCount);

            //专家数量>取值，正常操作
            if (experts.size() > count) {
                int[] s = StrUtil.randomCommon(0, experts.size(), count);
                List<ZjkExpert> expertsData = new ArrayList<>();
                for (int i = 0; i < count; i++) {
                    expertsData.add(experts.get(s[i]));
                }
                data.setData(expertsData);
            }
            //专家数量<取值,取专家数据
            else {
                data.setData(experts);
            }

        } else if ("guding".equals(strType)) {

            Object expertName = param.getParam().get("expertName");
            if (!StrUtil.isObjectEmpty(expertName)) {
                c.andExpertNameLike("%" + expertName + "%");
            }

            Object expertProfessinal = param.getParam().get("expertProfessinal");
            if (!StrUtil.isObjectEmpty(expertProfessinal)) {
                c.andExpertProfessinalEqualTo(expertProfessinal.toString());
            }

            Object expertProfessionalField = param.getParam().get("expertProfessionalField");
            if (!StrUtil.isObjectEmpty(expertProfessionalField)) {
                c.andExpertProfessionalFieldEqualTo(expertProfessionalField.toString());
            }

            Object email = param.getParam().get("email");
            if (!StrUtil.isObjectEmpty(email)) {
                c.andEmailLike("%" + email + "%");
            }

            Object company = param.getParam().get("company");
            if (!StrUtil.isObjectEmpty(company)) {
                c.andCompanyEqualTo(company.toString());
            }

            data = zjkBaseInfoService.findByExample(param, example);
        } else {
            Object expertId = map.get("expertId");
            if (StrUtil.isObjectEmpty(expertId)) {
                c.andDataIdIn(Arrays.asList(expertId.toString().split(",")));
            }
            data = zjkBaseInfoService.findByExample(param, example);
        }
        //返回
        return data;
    }

    public int updateOrInsertZjkChoiceUpdateBat(JSONObject jsonObject) {
        //取值
        List<ZjkChoice> zjkChoice = JSONObject.parseArray((jsonObject.getString("list")), ZjkChoice.class);
        String projectSteps = zjkChoice.get(0).getBak1();
        String projectId = zjkChoice.get(0).getXmId();
        String projectName = zjkChoice.get(0).getXmName();
        String bak6 = zjkChoice.get(0).getBak6();
        //删除
        ZjkChoiceExample example = new ZjkChoiceExample();
        ZjkChoiceExample.Criteria c = example.createCriteria();
        c.andStatusEqualTo("2");
        c.andXmIdEqualTo(projectId);
        c.andBak1EqualTo(projectSteps);
        this.deleteByExample(example);
        //新增
        int j = zjkChoice.size();
        for (int i = 0; i < j; i++) {
//            ZjkChoiceExample ex = new ZjkChoiceExample();
//            ZjkChoiceExample.Criteria criteria = ex.createCriteria();
//            this.deleteByExample(ex);
            this.insert(zjkChoice.get(i));
        }
        //查询项目阶段提醒方式
        ZjkMsgConfigExample configExample = new ZjkMsgConfigExample();
        configExample.createCriteria().andProjectStepsEqualTo(projectSteps);
        List<ZjkMsgConfig> zjkMsgConfigs = configService.selectByExample(configExample);
        String type = zjkMsgConfigs.get(0).getMsgType();//消息类型
        //TO DO 插入专家通知
        for (int i = 0; i < j; i++) {
            //删除:项目ID,项目阶段ID,人员id
            ZjkMsgExample ex = new ZjkMsgExample();
            ZjkMsgExample.Criteria criteria = ex.createCriteria();
            criteria.andProjectIdEqualTo(projectId);
            criteria.andXmIdEqualTo(projectId);
            criteria.andXmStepsEqualTo(projectSteps);
            criteria.andZjkIdEqualTo(zjkChoice.get(i).getZjId());
            zjkMsgService.deleteByExample(ex);

            ZjkMsg msg = new ZjkMsg();
            msg.setProjectId(projectId);
            msg.setProjectName(projectName);
            msg.setXmId(projectId);
            msg.setXmName(projectName);
            msg.setXmSteps(projectSteps);
            msg.setIsComplete("ROOT_UNIVERSAL_WEHTHER_NO");
            msg.setSysFlag("ROOT_UNIVERSAL_WEHTHER_NO");
            msg.setCompleteType(type);
            msg.setZjkId(zjkChoice.get(i).getZjId());
            msg.setZjkName(zjkChoice.get(i).getBak2());
            msg.setStatus(DateUtil.dateToStr(new Date(),DateUtil.FMT_YYYY));
            msg.setCreateDate(DateUtil.dateToStr(new Date(),DateUtil.FMT_DD));
            zjkMsgService.insert(msg);
        }
        //获取附件 bak6

        //发送消息
        try {
//            List<String> emails = zjkChoice.stream().map(ZjkChoice::getBak3).collect(Collectors.toList());
            for (int i = 0; i < j; i++) {
                ZjkChoice obj = zjkChoice.get(i);
                MailSenderInfo m = new MailSenderInfo();
//                m.setToAddress(new String[]{"635447170@qq.com"});
                m.setToAddress(new String[]{obj.getBak3()});
                m.setContent("尊敬的" + obj.getBak2() + "你好：<br>项目'" + obj.getXmName() + "'特邀您进行进行评审，评审日期:" + obj.getBak4() + "请及时回复是否能准时参加！！！联系方式：" + obj.getBak5() + "<br>&nbsp;&nbsp;&nbsp;&nbsp;谢谢");
                m.setSubject("项目评审邀请");
               mailSentService.sendMail(m);
            }
        } catch (Exception e) {
        }
        //返回
        return 200;
    }

    @Autowired
    private ZjkMsgService zjkMsgService;
    @Autowired
    private ZjkMsgConfigService configService;
}