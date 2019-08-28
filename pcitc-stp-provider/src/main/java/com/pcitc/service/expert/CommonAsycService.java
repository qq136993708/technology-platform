package com.pcitc.service.expert;

import com.pcitc.base.common.LayuiTableData;
import com.pcitc.base.common.LayuiTableParam;
import com.pcitc.base.expert.ZjkChoice;
import com.pcitc.base.system.SysFile;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.concurrent.Future;

public interface CommonAsycService {
    /**
     * 发送邮件
     * @param templetId 模板ID
     * @param choiceList 专家列表
     * @param sysFiles 附件列表
     * @return
     */
    public Future<String> sendEmailAsyc(String templetId, List<ZjkChoice> choiceList, List<SysFile> sysFiles);
}
