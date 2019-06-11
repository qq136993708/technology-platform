package com.pcitc.service.system.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.pcitc.base.common.LayuiTableData;
import com.pcitc.base.common.LayuiTableParam;
import com.pcitc.base.common.TreeNode;
import com.pcitc.base.common.enums.DataOperationStatusEnum;
import com.pcitc.base.common.enums.DelFlagEnum;
import com.pcitc.base.system.EmailTemplate;
import com.pcitc.base.system.EmailTemplateExample;
import com.pcitc.base.util.IdUtil;
import com.pcitc.base.util.TreeNodeUtil;
import com.pcitc.mapper.system.EmailTemplateMapper;
import com.pcitc.service.system.EmailTemplateService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * <p>接口实现类</p>
 * <p>Table: email_template - 邮件模板</p>
 *
 * @since 2019-06-05 03:42:06
 */
@Service("emailTemplateService")
@Transactional(propagation = Propagation.REQUIRED, readOnly = false, rollbackFor = Exception.class)
public class EmailTemplateServiceImpl implements EmailTemplateService {

    @Autowired
    private EmailTemplateMapper emailTemplateMapper;

    public List<EmailTemplate> findEmailTemplateList(EmailTemplate emailTemplate) {
        List<EmailTemplate> record = emailTemplateMapper.findEmailTemplateList(emailTemplate);
        return record;
    }

    @Override
    public int updateOrInsertEmailTemplate(EmailTemplate emailTemplate) throws Exception {
        int result = 500;
        if (emailTemplate.getDataId() != null && emailTemplate.getDataId() != null) {
            emailTemplateMapper.updateByPrimaryKeySelective(emailTemplate);
        } else {
            emailTemplate.setDataId(IdUtil.createIdByTime());
            emailTemplateMapper.insertSelective(emailTemplate);
        }
        result = 200;
        return result;
    }

    @Override
    public int deleteEmailTemplateById(String id) throws Exception {
        int result = 500;
        if (id != null) {
            emailTemplateMapper.deleteByPrimaryKey(id);
        }
        result = 200;
        return result;
    }

    @Override
    public EmailTemplate getEmailTemplateInfo(String id) throws Exception {

        return emailTemplateMapper.selectByPrimaryKey(id);
    }

    @Override
    public long countByExample(EmailTemplateExample example) {
        return emailTemplateMapper.countByExample(example);
    }

    @Override
    public int deleteByExample(EmailTemplateExample example) {
        return emailTemplateMapper.deleteByExample(example);
    }

    @Override
    public int deleteByPrimaryKey(String recordId) {
        return emailTemplateMapper.deleteByPrimaryKey(recordId);
    }

    @Override
    public Integer deleteEmailTemplateReal(String recordId) {
        return emailTemplateMapper.deleteByPrimaryKey(recordId);
    }

    @Override
    public int insert(EmailTemplate record) {
        record.setDataId(IdUtil.createIdByTime());
        return emailTemplateMapper.insert(record);
    }

    @Override
    public int insertSelective(EmailTemplate record) {
        return emailTemplateMapper.insertSelective(record);
    }

    public EmailTemplate insertObject(EmailTemplate record) {
        this.insert(record);
        return record;
    }

    @Override
    public List<EmailTemplate> selectByExample(EmailTemplateExample example) {
        return emailTemplateMapper.selectByExample(example);
    }

    @Override
    public EmailTemplate selectByPrimaryKey(String recordId) {
        return emailTemplateMapper.selectByPrimaryKey(recordId);
    }

    @Override
    public int updateByExampleSelective(@Param("record") EmailTemplate record, @Param("example") EmailTemplateExample example) {
        return emailTemplateMapper.updateByExampleSelective(record, example);
    }

    @Override
    public int updateByExample(@Param("record") EmailTemplate record, @Param("example") EmailTemplateExample example) {
        return emailTemplateMapper.updateByExample(record, example);
    }

    @Override
    public int updateByPrimaryKeySelective(EmailTemplate record) {
        return emailTemplateMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(EmailTemplate record) {
        if (record.getStatus() == null) {
            record.setStatus("");
        }
        return emailTemplateMapper.updateByPrimaryKey(record);
    }

    @Override
    public Integer deleteEmailTemplate(Serializable emailTemplateId) {
        try {
            EmailTemplate record = emailTemplateMapper.selectByPrimaryKey(emailTemplateId.toString());
            if (record != null) {
                record.setStatus(DelFlagEnum.STATUS_DEL.getCode() + "");
                emailTemplateMapper.updateByPrimaryKey(record);
            }
            return Integer.parseInt(String.valueOf(DataOperationStatusEnum.DEL_OK));
        } catch (Exception e) {
            return Integer.parseInt(String.valueOf(DataOperationStatusEnum.DEL_DATA_ERROR));
        }
    }

    @Override
    public LayuiTableData findEmailTemplateByPage(LayuiTableParam param) {
        EmailTemplateExample example = new EmailTemplateExample();
        EmailTemplateExample.Criteria c = example.createCriteria();
//        c.andStatusEqualTo("1");
//        if(param.getParam().get("fileKind") !=null && !com.pcitc.common.StringUtils.isBlank(param.getParam().get("fileKind")+""))
//        {
        //   c.andIdLike("'%"+param.getParam().get("fileKind")+"%'");
//            EmailTemplateExample.Criteria criteria2 = example.or();
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
    private LayuiTableData findByExample(LayuiTableParam param, EmailTemplateExample example) {
        int pageSize = param.getLimit();
        int pageStart = (param.getPage() - 1) * pageSize;
        int pageNum = pageStart / pageSize + 1;
        PageHelper.startPage(pageNum, pageSize);
        List<EmailTemplate> list = emailTemplateMapper.selectByExample(example);
        // 3、获取分页查询后的数据
        PageInfo<EmailTemplate> pageInfo = new PageInfo<EmailTemplate>(list);
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
        EmailTemplateExample example = new EmailTemplateExample();
        //example.getOredCriteria().add(example.createCriteria().andStatusNotEqualTo(DataOperationStatusEnum.DEL_OK.getStatusCode().toString()));
        List<EmailTemplate> records = emailTemplateMapper.selectByExample(example);
        for (EmailTemplate record : records) {
            TreeNode node = new TreeNode();
            node.setId(record.getId());
            //            node.setLevelCode(record.getUnitLevel().toString());
            node.setParentId(record.getParentId());
            nodes.add(node);
        }
        //构建树形结构(从根节点开始的树形结构)

        EmailTemplateExample emailTemplateExample = new EmailTemplateExample();
        String strParentId = emailTemplateMapper.selectByExample(emailTemplateExample).get(0).getId();
        List<TreeNode> orderNodes = TreeNodeUtil.getChildrenNode(strParentId, nodes);

        return orderNodes;
    }
}