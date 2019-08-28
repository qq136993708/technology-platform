package com.pcitc.service.expert.impl;

import com.pcitc.base.common.LayuiTableData;
import com.pcitc.base.expert.ZjkChoice;
import com.pcitc.base.system.EmailTemplate;
import com.pcitc.base.system.SysFile;
import com.pcitc.service.expert.CommonAsycService;
import com.pcitc.service.msg.MailSentService;
import com.pcitc.service.system.EmailTemplateService;
import com.pcitc.util.mail.MailSenderInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.AsyncResult;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

@Async
@Service("commonAsycServiceImpl")
public class CommonAsycServiceImpl implements CommonAsycService {

    @Autowired
    EmailTemplateService emailTemplateService;

    @Autowired
    MailSentService mailSentService;

    @Async
    public Future<String> sendEmailAsyc(String templeteId, List<ZjkChoice> zjkChoice, List<SysFile> files) {
        String result = "1";
        try {
            EmailTemplate emailTemplate = emailTemplateService.selectByPrimaryKey(templeteId);
            for (int i = 0, j = zjkChoice.size(); i < j; i++) {
                ZjkChoice obj = zjkChoice.get(i);
                MailSenderInfo m = new MailSenderInfo();
//                m.setToAddress(new String[]{"635447170@qq.com"});
                m.setToAddress(new String[]{obj.getBak3()});
                String content = emailTemplate.getContent();
                content = content.replace("${name}", obj.getBak2());
                content = content.replace("${date}", obj.getBak4());
                content = content.replace("${project}", obj.getXmName());
                content = content.replace("${mobile}", obj.getBak5());
                m.setContent(content);
                m.setSubject("评审邀请");
                int leng = files.size();
                String[] names = new String[leng];
                String[] urls = new String[leng];
                for (int k = 0; k < leng; k++) {
                    names[k] = files.get(k).getFileName();
                    urls[k] = files.get(k).getFilePath();
                }
                m.setAttachFileUrls(urls);
                m.setAttachFileNames(names);
                mailSentService.sendMailFileInputStream(m);
            }
        } catch (Exception e) {
            result = "0";
            e.printStackTrace();
        } finally {
            return new AsyncResult<String>(result);
        }
    }
}
