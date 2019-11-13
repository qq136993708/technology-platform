package com.pcitc.web.system;

import com.alibaba.fastjson.JSONObject;
import com.pcitc.base.common.LayuiTableParam;
import com.pcitc.base.system.EmailTemplate;
import com.pcitc.service.system.EmailTemplateService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * <p>服务接口</p>
 * <p>Table: email_template - 邮件模板</p>
 *
 * @since 2019-06-05 03:42:06
 */
@Api(value = "EmailTemplateClient-API", description = "邮件模板服务接口")
@RestController
public class EmailTemplateClient {
    private final static Logger logger = LoggerFactory.getLogger(EmailTemplateClient.class);

    @Autowired
    EmailTemplateService emailTemplateService;

    //参数查询
    @ApiOperation(value = "带参邮件模板查询列表", notes = "根据ID查询查询邮件模板信息,返回一个邮件模板的JSONObject对象")
    @RequestMapping(value = "/emailtemplate-provider/emailtemplate/emailtemplate_list_param", method = RequestMethod.POST)
    public JSONObject selectEmailTemplateListParam(@RequestParam(value = "id", required = false) String id) {
        JSONObject retJson = new JSONObject();
        try {
            EmailTemplate emailTemplate = new EmailTemplate();
            emailTemplate.setId(id);
            List<EmailTemplate> list = emailTemplateService.findEmailTemplateList(emailTemplate);
            retJson.put("list", list);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return retJson;
    }

    //对象查询,js需要JSON.stringify({id:"1"},转换之后,才能自动赋值
    @ApiOperation(value = "邮件模板查询列表", notes = "自定义对象(条件)查询邮件模板信息,返回存储在JSONObject对象中的邮件模板列表")
    @RequestMapping(value = "/emailtemplate-provider/emailtemplate/emailtemplate_list", method = RequestMethod.POST)
    public JSONObject selectEmailTemplateList(@RequestBody EmailTemplate emailTemplate) {
        JSONObject retJson = new JSONObject();
        try {
            List<EmailTemplate> list = emailTemplateService.findEmailTemplateList(emailTemplate);
            retJson.put("list", list);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return retJson;
    }

    @ApiOperation(value = "查询邮件模板树形详情信息", notes = "按ID查询邮件模板详情信息(带父ID),操作成功返回SysFileKind对象")
    @RequestMapping(value = "/emailtemplate-provider/emailtemplate/get-emailtemplate/{id}", method = RequestMethod.POST)
    public EmailTemplate getEmailTemplateInfo(@PathVariable(value = "id", required = true) String id) {
        try {
            return emailTemplateService.getEmailTemplateInfo(id);
        } catch (Exception e) {
            logger.error("[初始化信息失败：]", e);
        }
        return null;
    }

    /**
     * 树形展示
     *
     * @return
     * @throws Exception
     */
    @ApiOperation(value = "查询(树)邮件模板信息", notes = "查询(树)邮件模板信息,操作成功返回List<TreeNode>对象")
    @RequestMapping(value = "/emailtemplate-provider/emailtemplate/tree-data")
    @ResponseBody
    public List selectObjectByTree() throws Exception {
        return emailTemplateService.selectObjectByTree();
    }

    /**
     * 删除邮件模板-false
     *
     * @param emailTemplatecId
     * @return
     */
    @ApiOperation(value = "伪删除邮件模板信息", notes = "按ID伪删除邮件模板信息,操作成功返回201")
    @RequestMapping(value = "/emailtemplate-provider/emailtemplate/del-emailtemplate/{emailTemplateId}")
    public Object deleteEmailTemplate(@PathVariable("emailTemplateId") String emailTemplatecId) {
        return emailTemplateService.deleteEmailTemplate(emailTemplatecId);
    }

    /**
     * 删除邮件模板-true
     *
     * @param emailTemplatecId
     * @return
     */
    @ApiOperation(value = "删除邮件模板信息", notes = "按ID删除邮件模板信息,操作成功返回201")
    @RequestMapping(value = "/emailtemplate-provider/emailtemplate/del-emailtemplate-real/{emailTemplateId}", method = RequestMethod.POST)
    public Object deleteEmailTemplateReal(@PathVariable("emailTemplateId") String emailTemplatecId) {
        return emailTemplateService.deleteEmailTemplateReal(emailTemplatecId);
    }

    /**
     * 分页查询
     *
     * @param param
     * @return
     */
    @ApiOperation(value = "查询邮件模板信息-分页查询", notes = "查询邮件模板信息-分页查询,Object")
    @RequestMapping(value = "/emailtemplate-provider/emailtemplate/emailtemplate-page")
    public Object selectEmailTemplateByPage(@RequestBody LayuiTableParam param) {
        return emailTemplateService.findEmailTemplateByPage(param);
    }

    /**
     * 保存
     *
     * @param emailTemplate
     * @return
     */
    @ApiOperation(value = "新增邮件模板信息", notes = "新增邮件模板信息,操作成功返回500")
    @RequestMapping(value = "/emailtemplate-provider/emailtemplate/save_emailtemplate", method = RequestMethod.POST)
    public int updateOrInsertEmailTemplate(@RequestBody EmailTemplate emailTemplate) {
        try {
            return emailTemplateService.updateOrInsertEmailTemplate(emailTemplate);
        } catch (Exception e) {
            logger.error("[保存信息失败：]", e);
        }
        return 500;
    }
}
